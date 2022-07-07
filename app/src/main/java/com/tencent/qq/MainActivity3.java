package com.tencent.qq;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    public ProgressBar pb;
    String amountEt;
    EditText noteEt;
    EditText nameEt;
    EditText upiIdEt;
    public int lim;
    Button send;
    public int time;
    final int UPI_PAYMENT = 0;
    public int pval = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow();
        requestWindowFeature(1);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }
        initializeViews();
        Bundle bundle = getIntent().getExtras();
        //price recieved from previous activity is fetched here
        pb = findViewById(R.id.progressBar2);
        pb.setVisibility(View.GONE);
        TextView tView = findViewById(R.id.textView21);
        SeekBar sb = findViewById(R.id.seekBar);

        TextView textView = findViewById(R.id.textView18);

        Typeface typeface = ResourcesCompat.getFont(
                this,
                R.font.lion);
        textView.setTypeface(typeface);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
                tView.setText("Select number of keys below : "+pval);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
                tView.setText("Select number of keys below : "+pval);
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tView.setText("Select number of keys below : "+pval);
            }
        });

        final RadioGroup radio = (RadioGroup) findViewById(R.id.radioGroup2);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radio.findViewById(checkedId);
                int index = radio.indexOfChild(radioButton);

                // Add logic here

                switch (index) {
                    case 0: // first button
                        time = 160;
                        lim = 1;
                        break;
                    case 1: // secondbutton
                        time = 1000;
                        lim = 7;
                        break;
                    case 2: // secondbutton
                        time = 2500;
                        lim = 30;
                        break;
                }
            }
        });



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int q = (pval * time);
                if(pval >= 3){q = (70/100)*q;}
                pb.setVisibility(View.VISIBLE);
                String amount = q+"";
                String note = "["+pval+"] "+lim+" - Day(s) Key(s).";
                String name = "JARVIS INTERNATIONAL";
                String upiId = "7807335450@okbizaxis";
                //upiIdEt.setFocusable(false);
                payUsingUpi(amount, upiId, name, note);
            }
        });
    }


    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    void initializeViews() {
        send = findViewById(R.id.button3);

    }

    void payUsingUpi(String amount, String upiId, String name, String note) {

        Uri uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa", upiId)
                .appendQueryParameter("pn", name)
                .appendQueryParameter("tr", "BCR2DN6TV6SPN4A4")
                .appendQueryParameter("tn", note)
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                .build();


        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);

        // will always show a dialog to user to choose an app
        Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");

        // check if intent resolves
        if (null != chooser.resolveActivity(getPackageManager())) {
            startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            Toast.makeText(this, "No UPI app found, please install one to continue", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case UPI_PAYMENT:
                if ((RESULT_OK == resultCode) || (resultCode == 11)) {
                    if (data != null) {
                        String trxt = data.getStringExtra("response");
                        //Log.d("UPI", "onActivityResult: " + trxt);
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add(trxt);
                        upiPaymentDataOperation(dataList);
                    } else {
                        //Log.d("UPI", "onActivityResult: " + "Return data is null");
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add("nothing");
                        upiPaymentDataOperation(dataList);
                    }
                } else {
                    //Log.d("UPI", "onActivityResult: " + "Return data is null"); //when user simply back without payment
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("nothing");
                    upiPaymentDataOperation(dataList);
                }
                break;
        }
    }

    private void upiPaymentDataOperation(ArrayList<String> data) {
        if (isConnectionAvailable(MainActivity3.this)) {
            String str = data.get(0);
            //Log.d("UPIPAY", "upiPaymentDataOperation: "+str);
            String paymentCancel = "";
            if(str == null) str = "discard";
            String status = "";
            String approvalRefNo = "";
            String response[] = str.split("&");
            for (int i = 0; i < response.length; i++) {
                String equalStr[] = response[i].split("=");
                if(equalStr.length >= 2) {
                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                        status = equalStr[1].toLowerCase();
                    }
                    else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        approvalRefNo = equalStr[1];
                    }
                }
                else {
                    paymentCancel = "Payment cancelled !";
                    pb.setVisibility(View.GONE);
                }
            }

            if (status.equals("success")) {
                //Code to handle successful transaction here.
                Toast.makeText(MainActivity3.this, "Transaction successful.", Toast.LENGTH_SHORT).show();
                // Log.d("UPI", "responseStr: "+approvalRefNo);
                Toast.makeText(this, "YOUR ORDER HAS BEEN PLACED\n PLEASE WAIT TILL YOUR KEY IS GENERATED", Toast.LENGTH_LONG).show();
                try {
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity3.this);
                    String URL = "https://jarvisinternationaltech.com/shiv.php";
                    JSONObject jsonBody = new JSONObject();
                    jsonBody.put("fc", "tool");
                    jsonBody.put("key", "");
                    jsonBody.put("device", "");
                    final String requestBody = jsonBody.toString();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            String xtx = response;
                            toast("xtx");
                            try {
                                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity3.this);
                                String URL = "https://jarvisinternationaltech.com/shiv.php";
                                JSONObject jsonBody = new JSONObject();
                                jsonBody.put("fc", "r");
                                jsonBody.put("name", "JARVIS_"+xtx);
                                jsonBody.put("content", lim);
                                final String requestBody = jsonBody.toString();

                                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                        ClipData clip = ClipData.newPlainText("","JARVIS_"+xtx);
                                        clipboard.setPrimaryClip(clip);
                                        pb.setVisibility(View.GONE);
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {

                                                if (!isFinishing()){
                                                    new AlertDialog.Builder(MainActivity3.this)
                                                            .setTitle("Transaction successful !")
                                                            .setMessage("Your Key to use jarvis is :\n\n"+"JARVIS_"+xtx+"\n\nand has been copied to clipboard successfully !")
                                                            .setCancelable(false)
                                                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    // Whatever...
                                                                }
                                                            }).show();
                                                }
                                            }
                                        });
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Log.e("VOLLEY", error.toString());
                                    }
                                }) {
                                    @Override
                                    public String getBodyContentType() {
                                        return "application/json; charset=utf-8";
                                    }

                                    @Override
                                    public byte[] getBody() throws AuthFailureError {
                                        try {
                                            return requestBody == null ? null : requestBody.getBytes("utf-8");
                                        } catch (UnsupportedEncodingException uee) {
                                            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                                            return null;
                                        }
                                    }

                                    @Override
                                    protected Response<String> parseNetworkResponse(NetworkResponse response) {
                                        String responseString = "";
                                        if (response != null) {
                                            responseString = String.valueOf(response.statusCode);
                                            // can get more details such as response.headers
                                        }
                                        return super.parseNetworkResponse(response);
                                    }
                                };
                                stringRequest.setShouldCache(false);
                                requestQueue.add(stringRequest);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("VOLLEY", error.toString());
                            toast("error"+response);
                        }
                    }) {
                        @Override
                        public String getBodyContentType() {
                            return "application/json; charset=utf-8";
                        }

                        @Override
                        public byte[] getBody() throws AuthFailureError {
                            try {
                                return requestBody == null ? null : requestBody.getBytes("utf-8");
                            } catch (UnsupportedEncodingException uee) {
                                VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                                return null;
                            }
                        }

                        @Override
                        protected Response<String> parseNetworkResponse(NetworkResponse response) {
                            String responseString = "";
                            if (response != null) {
                                responseString = String.valueOf(response.statusCode);
                                // can get more details such as response.headers
                            }
                            return super.parseNetworkResponse(response);
                        }
                    };
                    stringRequest.setShouldCache(false);
                    requestQueue.add(stringRequest);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if("Payment cancelled by user.".equals(paymentCancel)) {
                Toast.makeText(MainActivity3.this, "Payment cancelled", Toast.LENGTH_SHORT).show();
                pb.setVisibility(View.GONE);
            }
            else {
                Toast.makeText(MainActivity3.this, "Transaction failed! Please try again", Toast.LENGTH_SHORT).show();
                pb.setVisibility(View.GONE);
            }
        } else {
            Toast.makeText(MainActivity3.this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
            pb.setVisibility(View.GONE);
        }
    }
    private void toast(String txt) {
        Context context = getApplicationContext();
        CharSequence text = txt;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

}