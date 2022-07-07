package com.tencent.qq;

import android.annotation.SuppressLint;
import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.graphics.*;
import android.media.MediaPlayer;
import android.net.*;
import android.os.*;
import android.provider.Settings;
import android.text.Editable;
import android.text.Layout;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.CompoundButton.*;
import java.io.*;

import com.android.volley.AuthFailureError;
import com.android.volley.BuildConfig;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.qq.FloatLogo;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.lang.Process;
import java.nio.file.Paths;
import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.util.Log;
import android.widget.Button;
import android.os.HandlerThread;
import android.content.Intent;
import android.graphics.Point;
import android.view.WindowManager;

import android.view.Display;

import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import org.json.JSONException;
import org.json.JSONObject;


import static com.tencent.qq.MainActivity6.verx;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener
{

    public static String gameName="com.tencent.ig";
    public static int bit=1;

    static {
        System.loadLibrary("jarvis");
    }


    private boolean isDisplay = false;
    private boolean isMenuDis = false;
    //WindowManager.LayoutParams params;
    Context ctx;
    View menu;

    int mx,my;

    public static String socket;
    public String MemHack;
    Process process;

    public String daemonPath;
    public String daemonPath64;



    static boolean isRoot = true;
    static boolean isNoroot = false;
    static boolean rootMod = true;

    static boolean is32 = true;
    static boolean is64 = false;
    static boolean bitMod = true;

    String indMEM;

    public boolean onESP = false;
    public boolean isDaemon = false;



    public Button mbutton1,mbutton2,mbutton5,mbutton4,mbutton6,mbutton3;
    TextView telegram,stat,partners,aboutninja,logouch;
    TextView copyright,version;
    Button webview;

    public static RequestQueue requestQueue;
    public static ProgressBar spinner;
    public static TextInputLayout textInputLayout;
    public static String yu;
    public static String cx;
    public static String internal;
    private String xs;
    public static String xt;
    public static String xtx;
    public static ProgressDialog mProgressDialog;
    public static String time;
    public static String cvb;
    public static String hjg;
    public static String hjk;
    public static String hjl;
    public static String hjc;
    public static String hjb;
    public static int vercd = 0;
    private static int gh;
    private static int gs = 0;
    private static int ks = 0;
    private static int ls = 0;
    private static int vs = 0;
    private static int ts = 0;
    private static int bs = 0;
    private static int cgs = 0;
    private static int cs = 0;
public static EditText denyf;
    public static String response;
    public static TextInputLayout textInputLayout3;
    public static Button b0;
    public static Button b1;
    public static Button b2;
    public static Button b3;
    public static Button b4;
    public static Button b5;
    public static Button b6;
    public static Button b7;
    public static int gxi;
    public static String lub;
    public static String lug;
    public static String luk;
    public static String lul;
    public static String luc;
    public static String luv;
    public static String lut;
    public static String lucg;
    public static String gv;
    public static String kv;
    public static String lv;
    public static String cv;
    public static String tv;
    public static String vv;
    public static String cgv;
    public static String bv;
    public static TextView insb;
    public static TextView insgl;
    public static TextView inskr;
    public static TextView insl;
    public static TextView insc;
    public static TextView insv;
    public static TextView inst;
    public static TextView inscg;
    public  static String packet;
    public  static String packeg;
    public  static String packett;
    public  static String packetk;
    public  static String packetv;
    public  static String packetl;
    public static Layout lx;
    public static int islist = 1;
    public static String editable;
    public static MediaPlayer mediaPlayer;
    public static MediaPlayer mediaPlayer2;
    public static MediaPlayer mediaPlayer3;
    public static ConstraintLayout loi;
    public String conf;
    public static Window window;
    public static String id;
    public static int mode = 0;
    public static Process xsr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow();
        requestWindowFeature(1);
        getSupportActionBar().hide();
        setContentView(R.layout.main);
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }
        CheckFloatViewPermission();
        initialization();

        ctx = this;


        if(!isConfigExist())
        {
            Init();
        }

        EditText denyf = findViewById(R.id.ti);
        File filelhgh = new File(getFilesDir()+"/.hgh");
        if (filelhgh.exists()) {
           denyf.setText(read(".hgh").replaceAll("\n",""));
        }


        if (isRootAvailable()!=true){isRoot = false; isNoroot = true;}

        FrameLayout aler = findViewById(R.id.textViewframe);
if(MainActivity2.yx == 1){ aler.setVisibility(View.GONE);}
TextView agree = findViewById(R.id.textView27);
agree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              write("db_constraintx","57");
                aler.setVisibility(View.GONE);
                // MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/jarvis_international")));
            }
        });

        TextView deny = findViewById(R.id.textView26);
        deny.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.finish();
                // MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/jarvis_international")));
            }
        });

///////////////////////////////////importing///////////////////////////////////////
        packet = read("logs.txt");
        packeg = read("logsg.txt");
        packett = read("logst.txt");
        packetl = read("logsl.txt");
        packetk = read("logsk.txt");
        packetv = read("logsv.txt");

        sh("chmod 777 "+getFilesDir()+"/1");
        sh("chmod 777 "+getFilesDir()+"/2");
        TextView learn = findViewById(R.id.textView3x);
        Button button = (Button) findViewById(R.id.button09);
        TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(R.id.textInputLayout3);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        spinner = progressBar;
        TextView pay = findViewById(R.id.textView13);
        progressBar.setVisibility(View.GONE);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.tt);
        MediaPlayer po = MediaPlayer.create(this, R.raw.po);
        TextView tv1 = (TextView) findViewById(R.id.textView4x);
        TextView tv2 = (TextView) findViewById(R.id.textView5x);
        conf = read("db_constraint");
        List<String> networkList = new ArrayList<>();
// declare the dialog as a member field of your activity
      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (!getPackageManager().canRequestPackageInstalls()) {
                startActivityForResult(new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES).setData(Uri.parse(String.format("package:%s", getPackageName()))), 1234);
            } else {
            }
        }*/
        loi = findViewById(R.id.loi);
        ConstraintLayout qu = findViewById(R.id.constraintLayout13);
        qu.setVisibility(View.VISIBLE);
        loi.setVisibility(View.GONE);
        File filelx = new File(getFilesDir()+"/.xmc");
        if (filelx.exists()) {
            if (read(".xmc").equals(read(".xmc1"))){ vercd = 1;}
            if (read(".xmc").equals(read(".xmc2"))){ vercd = 2;}
            if (read(".xmc").equals(read(".xmc3"))){ vercd = 3;}
            if (read(".xmc").equals(read(".xmc4"))){ vercd = 4;}
            if (read(".xmc").equals(read(".xmc5"))){ vercd = 5;}
            if (read(".xmc").equals(read(".xmc6"))){ vercd = 6;}
            if (read(".xmc").equals(read(".xmc7"))){ vercd = 7;}
            if (read(".xmc").equals(read(".xmc8"))){ vercd = 8;}
        }


        if (Build.VERSION.SDK_INT >= 29 && (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == PackageManager.PERMISSION_DENIED || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == PackageManager.PERMISSION_DENIED)) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
        }
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 0);
        }
        if (Build.VERSION.SDK_INT >= 29 && (checkSelfPermission("android.permission.REQUEST_INSTALL_PACKAGES") == PackageManager.PERMISSION_DENIED || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == PackageManager.PERMISSION_DENIED)) {
            requestPermissions(new String[]{"android.permission.REQUEST_INSTALL_PACKAGES"}, 1000);
        }

        CheckBox rm = findViewById(R.id.checkBoxrem);
        rm.setVisibility(View.GONE);



        ///////////////////////////////////////////// lets do it ////////////////////


// execute this when the downloader must be fired
        final String PREF_NAME = "MyPref";

// getting saved preferences
        SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);

        if (settings.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            Log.d("Comments", "First time");

            // first time task


            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time", false).commit();
        }

        String URL = "https://jarvisinternationaltech.com/cpp/ver.php";

        String data = "{" +
                "\"fc\":" + "\"" + "bitchx" + "\"," +
                "\"name\":" + "\"" + yu + "\"" +
                "}";

        String savedata = data;

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objres = new JSONObject(response);
                    xt = response;
                    if (xt.equals("1")) {

                    }
                    else{
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                        alertDialogBuilder.setTitle("Update found..!!!");
                        alertDialogBuilder.setIcon(R.drawable.applogo);
                        alertDialogBuilder.setMessage("Please update in order to continue ...");
                        alertDialogBuilder.setCancelable(false);
                        alertDialogBuilder.setPositiveButton("update now !", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent viewIntent =
                                        new Intent("android.intent.action.VIEW",
                                                Uri.parse("https://jarvisinternationaltech.com"));
                                startActivity(viewIntent);
                                finish();
                            }
                        });

                        alertDialogBuilder.show();
                    }
                } catch (JSONException e) {
                    xt = response;
                    if (xt.equals("2")) {

                    }
                    else{
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                        alertDialogBuilder.setTitle("Update found..!!!");
                        alertDialogBuilder.setIcon(R.drawable.applogo);
                        alertDialogBuilder.setMessage("Please update in order to continue ...");
                        alertDialogBuilder.setCancelable(false);
                        alertDialogBuilder.setPositiveButton("update now !", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent viewIntent =
                                        new Intent("android.intent.action.VIEW",
                                                Uri.parse("https://jarvisinternationaltech.com"));
                                startActivity(viewIntent);
                            }
                        });

                        alertDialogBuilder.show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                //Log.v("VOLLEY", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return savedata == null ? null : savedata.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    //Log.v("Unsupported Encoding while trying to get the bytes", data);
                    return null;
                }
            }

        };
        stringRequest.setShouldCache(false);
        requestQueue.add(stringRequest);
        ///////////////////////////////////////////////////////////////////////////////}


     /*   final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.layoutds);
        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(),"Dismissed..!!",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();


// instantiate it within the onCreate method
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("A message");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(true);

// execute this when the downloader must be fired
        final DownloadTask downloadTask = new DownloadTask(MainActivity.this);
        downloadTask.execute("https://jarvisinternationaltech.com/cpp/jarvis.apk");

        mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                downloadTask.cancel(true); //cancel the task
            }
        });
*/
        String pathx = getFilesDir() + "";
        String cx = pathx.replaceAll("/com.jarvis.xs/files", "");
        hjg = cx + "/com.tencent.ig/databases";
        hjk = cx + "/com.pubg.krmobile/databases";
        hjl = cx + "/com.tencent.iglite";
        hjc = cx + "/com.activision.callofduty.shooter";
        boolean xst = obfs();

        if(xst == true){
            MainActivity.this.finish();
        }

        if(xst == false){
            ///////////////////////////////////////////// lets do it ///////////////////
        }




        //////////////////////////////////////

        /////////////////////////////////////

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://t.me/jarvis_international"));
                startActivity(viewIntent);
                // MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/jarvis_international")));
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://jarvisinternationaltech.com"));
                startActivity(viewIntent);
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        ImageView logout = findViewById(R.id.imageView22);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loi.setVisibility(View.GONE);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                }
                Vibrator vix = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 400 milliseconds
                vix.vibrate(200);
                qu.setVisibility(View.VISIBLE);
                sh("rm -rf "+getFilesDir()+"/cache_vr");
                sh("su -c rm -rf "+getFilesDir()+"/cache_vr");
            }
        });
        TextView tvf = findViewById(R.id.textViewfree);
        tvf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode =1;
                TextView title = findViewById(R.id.textView);
                title.setVisibility(View.VISIBLE);
                title.setText("TRIAL MODE ON");
                qu.setVisibility(View.GONE);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.mg));
                }
                Vibrator vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 400 milliseconds
                vi.vibrate(200);
                try {
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    String URL = "https://jarvisinternationaltech.com/cpp/key.php";
                    JSONObject jsonBody = new JSONObject();
                    jsonBody.put("fc", "bitchx");
                    jsonBody.put("key", id);
                    jsonBody.put("device", conf);
                    final String requestBody = jsonBody.toString();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            xtx = response;
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

                loi.setVisibility(View.VISIBLE);

            }
        });
        internal =getFilesDir()+"";

        String pathxy = getFilesDir()+"";
        String cxt = pathxy.replaceAll("/files", "/cache");


        textInputLayout3 = textInputLayout2;
        mediaPlayer = po;
        mediaPlayer2 = mp;
        String ps = getFilesDir()+"/.hgh";
        String op = getFilesDir()+"";

        try {
            File myObj = new File("/sdcard/.path");
            if (myObj.createNewFile()) {

            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("/sdcard/.path");
            myWriter.write(ps);
            myWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        try {
            File myObj = new File("/sdcard/.op");
            if (myObj.createNewFile()) {

            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("/sdcard/.op");
            myWriter.write(op);
            myWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        write(".op",op);
        write(".hghx",ps);

        sh("su -c mv "+getFilesDir()+"/.hghx /sdcard/.path");
        sh("su -c mv "+getFilesDir()+"/.hghx /sdcard/.op");

        String auto =read("");

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                MainActivity.this.write(".hgh", textInputLayout3.getEditText().getText().toString());
                if (textInputLayout3.getEditText().getText().toString().equals(BuildConfig.FLAVOR)) {
                    mediaPlayer.start();
                    textInputLayout3.setError("Field cannot be empty");
                    return;
                }
                boolean xst = obfs();

                if(xst == true){
                    MainActivity.this.finish();
                }
                else
                    mediaPlayer2.start();
                MainActivity.spinner.setVisibility(View.VISIBLE);
                try {
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    String URL = "https://jarvisinternationaltech.com/nikx.php";
                    JSONObject jsonBody = new JSONObject();
                    jsonBody.put("fc", "login");
                    jsonBody.put("key", textInputLayout3.getEditText().getText().toString());
                    jsonBody.put("device", conf);
                    final String requestBody = jsonBody.toString();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("nmsr")){
                                try {
                                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                                    String URL = "https://jarvisinternationaltech.com/cpp/keyx.php";
                                    JSONObject jsonBody = new JSONObject();
                                    jsonBody.put("fc", "bitchx");
                                    jsonBody.put("key", textInputLayout3.getEditText().getText().toString());
                                    jsonBody.put("device", conf);
                                    final String requestBody = jsonBody.toString();

                                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            xtx = response;
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

                                MainActivity.spinner.setVisibility(View.GONE);
                                //  MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), MainActivity5.class));
                                //  MainActivity.this.finish();
                                ConstraintLayout m = findViewById(R.id.constraintLayout13);
                                m.setVisibility(View.GONE);
                                TextView title = findViewById(R.id.textView);
                                title.setVisibility(View.GONE);
                                loi.setVisibility(View.VISIBLE);

                                final Dialog dialog = new Dialog(MainActivity.this);
                                gxi = 5;
// instantiate it within the onCreate method
                                mProgressDialog = new ProgressDialog(MainActivity.this,R.style.CustomAlertDialogStyle);
                                mProgressDialog.setMessage("Downloading resources ..");
                                mProgressDialog.setIndeterminate(true);
                                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                                mProgressDialog.setCancelable(true);


// execute this when the downloader must be fired
                                final DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                                if (mode ==1){ downloadTask.execute("https://jarvisinternationaltech.com/cpp/soii");}else {
                                    downloadTask.execute("https://jarvisinternationaltech.com/cpp/sockstar32");
                                }

                                if (Build.VERSION.SDK_INT >= 21) {
                                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                                    window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.mg));
                                }
                                cvb = textInputLayout3.getEditText().getText().toString();
                            }
                            if (response.equals("1007")){
                                MainActivity.spinner.setVisibility(View.GONE);
                                mediaPlayer.start();
                                textInputLayout3.setError("Error code 1007");
                            }
                            if (response.equals("0")){
                                MainActivity.spinner.setVisibility(View.GONE);
                                mediaPlayer.start();
                                textInputLayout3.setError("Invalid key");
                            }
                            if (response.equals("0101")){
                                MainActivity.spinner.setVisibility(View.GONE);
                                mediaPlayer.start();
                                textInputLayout3.setError("Key Expired !");
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("VOLLEY", error.toString());
                            toast(error.toString());

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
        });

        //////////////////////////////////second activity///////////////////////////////////////////////////
        Button bx = findViewById(R.id.button2);
        b0 = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.buttonn);
        b2 = (Button) findViewById(R.id.button13);
        b3 = (Button) findViewById(R.id.button17);
        b4 = (Button) findViewById(R.id.button17d);
        b5 = (Button) findViewById(R.id.button17dc);
        b6 = (Button) findViewById(R.id.button17dcd);
        b7 = (Button) findViewById(R.id.button17md);

        insb = (TextView) findViewById(R.id.textView16md);
        TextView lb = (TextView) findViewById(R.id.textView15md);
        insgl = (TextView) findViewById(R.id.textView6);
        TextView lgl = (TextView) findViewById(R.id.textView5);
        inskr = (TextView) findViewById(R.id.textViewz);
        TextView lkr = (TextView) findViewById(R.id.textViewy);
        insl = (TextView) findViewById(R.id.textView12);
        TextView ll = (TextView) findViewById(R.id.textView11);
        insc = (TextView) findViewById(R.id.textView16);
        TextView lc = (TextView) findViewById(R.id.textView15);
        insv = (TextView) findViewById(R.id.textView15d);
        TextView lvv = (TextView) findViewById(R.id.textView16d);
        inst = (TextView) findViewById(R.id.textView16dc);
        TextView lt = (TextView) findViewById(R.id.textView15dc);
        inscg = (TextView) findViewById(R.id.textView16dcd);
        TextView lcg = (TextView) findViewById(R.id.textView15dcd);

        TextView mainb = findViewById(R.id.textView15mc);
        TextView mainbi = findViewById(R.id.textViewmainb);
        TextView main = findViewById(R.id.textView4);
        TextView maingl = findViewById(R.id.textViewmaingl);
        TextView maink = findViewById(R.id.textViewx);
        TextView mainkr = findViewById(R.id.textViewmainkr);
        TextView mainli = findViewById(R.id.textViewmainl);
        TextView mainl = findViewById(R.id.textView10);
        TextView mainv = findViewById(R.id.textView15c);
        TextView mainvi = findViewById(R.id.textViewmainv);
        TextView maint = findViewById(R.id.textView15cd);
        TextView mainti = findViewById(R.id.textViewmaint);
        TextView mainc = findViewById(R.id.textView14);
        TextView mainci = findViewById(R.id.textViewmainc);
        TextView maincg = findViewById(R.id.textView15cdd);
        TextView maincgi = findViewById(R.id.textViewmaincg);

        ConstraintLayout bgmi = findViewById(R.id.constraintLayout90);
        ConstraintLayout cg = findViewById(R.id.constraintLayout61D);
        ConstraintLayout cod = findViewById(R.id.constraintLayout4);
        ConstraintLayout taiwan = findViewById(R.id.constraintLayout61);
        ConstraintLayout vietnam = findViewById(R.id.constraintLayout5);
        ConstraintLayout lite = findViewById(R.id.constraintLayout3);
        ConstraintLayout korean = findViewById(R.id.constraintLayout2);
        ConstraintLayout global = findViewById(R.id.constraintLayout);
        ConstraintLayout tele = findViewById(R.id.constraintLayout10);
        ConstraintLayout web = findViewById(R.id.constraintLayout8);
        ConstraintLayout yt = findViewById(R.id.constraintLayout11);
        ConstraintLayout discord = findViewById(R.id.constraintLayout7);
        ConstraintLayout git = findViewById(R.id.constraintLayout6);
        ConstraintLayout insta = findViewById(R.id.constraintLayoutl);


        // logic
        bv  = read("bver");
        gv = read("gver");
        kv = read("kver");
        lv = read("lver");
        cv = read("cv");
        vv = read("vver");
        tv = read("tver");
        cgv = read("cgver");
// Add the request to the RequestQueue.
        lb.setText("Latest version: "+read("bver"));
        lgl.setText("Latest version: "+read("gver"));
        lkr.setText("Latest version: "+read("kver"));
        ll.setText("Latest version: "+read("lver"));
        lc.setText("Latest version: "+read("cver"));
        lvv.setText("Latest version: "+read("vver"));
        lt.setText("Latest version : "+read("tver"));
        lcg.setText("Latest version :"+read("cgver"));

        insb.setText("Installed version: "+read("verb"));
        insgl.setText("Installed version: "+read("verg"));
        inskr.setText("Installed version: "+read("verk"));
        insl.setText("Installed version: "+read("verl"));
        insc.setText("Installed version: "+read("verc"));
        insv.setText("Installed version: "+read("verv"));
        inst.setText("Installed version: "+read("vert"));
        inscg.setText("Installed version: "+read("vercg"));

        if (MainActivity2.b == 0){ b7.setText("DOWNLOAD");}
        if (MainActivity2.g == 0){ b0.setText("DOWNLOAD");}
        if (MainActivity2.k == 0){ b1.setText("DOWNLOAD");}
        if (MainActivity2.l == 0){ b2.setText("DOWNLOAD");}
        if (MainActivity2.c == 0){ b3.setText("DOWNLOAD");}
        if (MainActivity2.v == 0){ b4.setText("DOWNLOAD");}
        if (MainActivity2.t == 0){ b5.setText("DOWNLOAD");}
        if (MainActivity2.cg == 0){ b6.setText("DOWNLOAD");}
        if (MainActivity2.compg ==1){b0.setText("UPDATE");}
        if (MainActivity2.compk ==1){b1.setText("UPDATE");}
        if (MainActivity2.compl ==1){b2.setText("UPDATE");}
        if (MainActivity2.compc ==1){b3.setText("UPDATE");}
        if (MainActivity2.compv ==1){b4.setText("UPDATE");}
        if (MainActivity2.compt ==1){b5.setText("UPDATE");}
        if (MainActivity2.compcg ==1){b6.setText("UPDATE");}
        if (MainActivity2.compb ==1){b7.setText("UPDATE");}
        if (MainActivity2.compg ==2){b0.setText("UPDATED");}
        if (MainActivity2.compk ==2){b1.setText("UPDATED");}
        if (MainActivity2.compl ==2){b2.setText("UPDATED");}
        if (MainActivity2.compc ==2){b3.setText("UPDATED");}
        if (MainActivity2.compv ==2){b4.setText("UPDATED");}
        if (MainActivity2.compt ==2){b5.setText("UPDATED");}
        if (MainActivity2.compcg ==2){b6.setText("UPDATED");}
        if (MainActivity2.compb ==2){b7.setText("UPDATED");}
        lub = getFilesDir()+"/verb";
        lug = getFilesDir()+"/verg";
        luk = getFilesDir()+"/verk";
        lul = getFilesDir()+"/verl";
        luc = getFilesDir()+"/verc";
        lucg = getFilesDir()+"/vercg";
        lut = getFilesDir()+"/vert";
        luv = getFilesDir()+"/verv";

        bgmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bs ==0){
                    mainb.setVisibility(View.VISIBLE);
                    insb.setVisibility(View.VISIBLE);
                    lb.setVisibility(View.VISIBLE);
                    mainbi.setVisibility(View.GONE);
                    bs =1;}else{
                    mainb.setVisibility(View.GONE);
                    insb.setVisibility(View.GONE);
                    lb.setVisibility(View.GONE);
                    mainbi.setVisibility(View.VISIBLE);
                    bs = 0;
                }
            }
        });

        cg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cgs ==0){
                    maincg.setVisibility(View.VISIBLE);
                    inscg.setVisibility(View.VISIBLE);
                    lcg.setVisibility(View.VISIBLE);
                    maincgi.setVisibility(View.GONE);
                    cgs =1;}else{
                    maincg.setVisibility(View.GONE);
                    inscg.setVisibility(View.GONE);
                    lcg.setVisibility(View.GONE);
                    maincgi.setVisibility(View.VISIBLE);
                    cgs = 0;
                }
            }
        });

        cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cs ==0){
                    mainc.setVisibility(View.VISIBLE);
                    insc.setVisibility(View.VISIBLE);
                    lc.setVisibility(View.VISIBLE);
                    mainci.setVisibility(View.GONE);
                    cs =1;}else{
                    mainc.setVisibility(View.GONE);
                    insc.setVisibility(View.GONE);
                    lc.setVisibility(View.GONE);
                    mainci.setVisibility(View.VISIBLE);
                    cs = 0;
                }
            }
        });
        taiwan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ts ==0){
                    maint.setVisibility(View.VISIBLE);
                    inst.setVisibility(View.VISIBLE);
                    lt.setVisibility(View.VISIBLE);
                    mainti.setVisibility(View.GONE);
                    ts =1;}else{
                    maint.setVisibility(View.GONE);
                    inst.setVisibility(View.GONE);
                    lt.setVisibility(View.GONE);
                    mainti.setVisibility(View.VISIBLE);
                    ts = 0;
                }
            }
        });
        vietnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vs ==0){
                    mainv.setVisibility(View.VISIBLE);
                    insv.setVisibility(View.VISIBLE);
                    lvv.setVisibility(View.VISIBLE);
                    mainvi.setVisibility(View.GONE);
                    vs =1;}else{
                    mainv.setVisibility(View.GONE);
                    insv.setVisibility(View.GONE);
                    lvv.setVisibility(View.GONE);
                    mainvi.setVisibility(View.VISIBLE);
                    vs = 0;
                }
            }
        });
        lite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ls ==0){
                    mainl.setVisibility(View.VISIBLE);
                    insl.setVisibility(View.VISIBLE);
                    ll.setVisibility(View.VISIBLE);
                    mainli.setVisibility(View.GONE);
                    ls =1;}else{
                    mainl.setVisibility(View.GONE);
                    insl.setVisibility(View.GONE);
                    ll.setVisibility(View.GONE);
                    mainli.setVisibility(View.VISIBLE);
                    ls = 0;
                }
            }
        });
        korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ks ==0){
                    maink.setVisibility(View.VISIBLE);
                    inskr.setVisibility(View.VISIBLE);
                    lkr.setVisibility(View.VISIBLE);
                    mainkr.setVisibility(View.GONE);
                    ks =1;}else{
                    maink.setVisibility(View.GONE);
                    inskr.setVisibility(View.GONE);
                    lkr.setVisibility(View.GONE);
                    mainkr.setVisibility(View.VISIBLE);
                    ks = 0;
                }
            }
        });
        global.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gs ==0){
                    main.setVisibility(View.VISIBLE);
                    insgl.setVisibility(View.VISIBLE);
                    lgl.setVisibility(View.VISIBLE);
                    maingl.setVisibility(View.GONE);
                    gs =1;}else{
                    main.setVisibility(View.GONE);
                    insgl.setVisibility(View.GONE);
                    lgl.setVisibility(View.GONE);
                    maingl.setVisibility(View.VISIBLE);
                    gs = 0;
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gxi = 7;
// instantiate it within the onCreate method
                mProgressDialog = new ProgressDialog(MainActivity.this,R.style.CustomAlertDialogStyle);
                mProgressDialog.setMessage("Downloading resources ..");
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setCancelable(true);

// execute this when the downloader must be fired
                final DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                downloadTask.execute("https://jarvisinternationaltech.com/cpp/unknownt");

                mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        downloadTask.cancel(true);
                    }
                });
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gxi = 8;
// instantiate it within the onCreate method
                mProgressDialog = new ProgressDialog(MainActivity.this,R.style.CustomAlertDialogStyle);
                mProgressDialog.setMessage("Downloading resources ..");
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setCancelable(true);

// execute this when the downloader must be fired
                final DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                downloadTask.execute("https://jarvisinternationaltech.com/cpp/unknowncg");

                mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        downloadTask.cancel(true);
                    }
                });
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gxi = 9;
// instantiate it within the onCreate method
                mProgressDialog = new ProgressDialog(MainActivity.this,R.style.CustomAlertDialogStyle);
                mProgressDialog.setMessage("Downloading resources ..");
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setCancelable(true);

// execute this when the downloader must be fired
                final DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                downloadTask.execute("https://jarvisinternationaltech.com/cpp/unknownb");

                mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        downloadTask.cancel(true);
                    }
                });
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                gxi = 1;
// instantiate it within the onCreate method
                mProgressDialog = new ProgressDialog(MainActivity.this,R.style.CustomAlertDialogStyle);
                mProgressDialog.setMessage("Downloading resources ..");
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setCancelable(true);

// execute this when the downloader must be fired
                final DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                if (mode ==1){ downloadTask.execute("https://jarvisinternationaltech.com/cpp/unknownstar");}else{
                    downloadTask.execute("https://jarvisinternationaltech.com/cpp/unknownxstar");

                /*    while(true){
                        File filel = new File(getFilesDir()+"/libctr.soxx");
                        if (!filel.exists()) {

                        }else{
                            mProgressDialog = new ProgressDialog(MainActivity.this);
                            mProgressDialog.setMessage("Downloading resources ..");
                            mProgressDialog.setIndeterminate(true);
                            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                            mProgressDialog.setCancelable(true);
                            downloadTask.execute("https://jarvisinternationaltech.com/cpp/sockstar");
                            break;}
                    }
*/
                }
                mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        downloadTask.cancel(true);
                    }
                });
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gxi = 2;
// instantiate it within the onCreate method
                mProgressDialog = new ProgressDialog(MainActivity.this,R.style.CustomAlertDialogStyle);
                mProgressDialog.setMessage("Downloading resources ..");
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setCancelable(true);

// execute this when the downloader must be fired
                final DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                if (mode ==1){ downloadTask.execute("https://jarvisinternationaltech.com/cpp/unknown");}else{
                    downloadTask.execute("https://jarvisinternationaltech.com/cpp/unknownkstar");}

                mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        downloadTask.cancel(true);
                    }
                });
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gxi = 3;
// instantiate it within the onCreate method
                mProgressDialog = new ProgressDialog(MainActivity.this,R.style.CustomAlertDialogStyle);
                mProgressDialog.setMessage("Downloading resources ..");
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setCancelable(true);

// execute this when the downloader must be fired
                final DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                downloadTask.execute("https://jarvisinternationaltech.com/cpp/unknownl");

                mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        downloadTask.cancel(true);
                    }
                });
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gxi = 6;
// instantiate it within the onCreate method
                mProgressDialog = new ProgressDialog(MainActivity.this,R.style.CustomAlertDialogStyle);
                mProgressDialog.setMessage("Downloading resources ..");
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setCancelable(true);

// execute this when the downloader must be fired
                final DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                downloadTask.execute("https://jarvisinternationaltech.com/cpp/unknownv");

                mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        downloadTask.cancel(true);
                    }
                });
            }
        });
        tele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://t.me/jarvis_international"));
                startActivity(viewIntent);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://jarvisinternationaltech.com"));
                startActivity(viewIntent);
            }
        });
        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.youtube.com/channel/UCainZ0fQJMk5G4C2Scntfwg"));
                startActivity(viewIntent);
            }
        });

        discord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://discord.gg/eQrCfyAW"));
                startActivity(viewIntent);
            }
        });

        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://github.com/NikhilMrityunjay-01"));
                startActivity(viewIntent);
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://instagram.com/pubg_jarvis?igshid=41g1y9m48hew"));
                startActivity(viewIntent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gxi = 4;
// instantiate it within the onCreate method
                mProgressDialog = new ProgressDialog(MainActivity.this,R.style.CustomAlertDialogStyle);
                mProgressDialog.setMessage("Downloading resources ..");
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setCancelable(true);

// execute this when the downloader must be fired
                final DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                downloadTask.execute("https://jarvisinternationaltech.com/cpp/unknownc");

                mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        downloadTask.cancel(true);
                    }
                });
            }
        });

        pathx = getFilesDir() + "";
        String cxm = pathx.replaceAll("/com.jarvis.xs/files", "");
        bx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (verx == 0 & vercd == 0){toast("Please set your game version from settings .");}

                else{
                    if (islist==0){toast(" Please close the floating menu first !");}else{

                        if(isNoroot) {
                            socket  = daemonPath;
                        }
                        if(isRoot) {
                            socket = "su -c " + daemonPath;
                        }

                        startPatcher();
                        isDisplay = true;
                        isDaemon = true;
                        //startService(new Intent(MainActivity.this, Overlay.class));

                        // startService(new Intent(MainActivity.this, MainActivityo.class));  starting float
                        islist = 0;
                        if (verx ==1 ){
                            sh("su -c rm -rf " + cxm +"/"+ "com.tencent.ig" + "/files");
                            sh("su -c touch " + cxm +"/"+ "com.tencent.ig" + "/files");
                            sh("rm -rf " + cxm +"/"+ "com.tencent.ig" + "/files");
                            sh("touch " + cxm +"/"+ "com.tencent.ig" + "/files");

                            if (verx ==2){
                                sh("su -c rm -rf " + cxm +"/"+ "com.pubg.krmobile" + "/files");
                                sh("su -c touch " + cxm +"/"+ "com.pubg.krmobile" + "/files");
                                sh("rm -rf " + cxm +"/"+ "com.pubg.krmobile" + "/files");
                                sh("touch " + cxm +"/"+ "com.pubg.krmobile" + "/files");

                            }else{
                                if (verx ==3){
                                    sh("su -c rm -rf " + cxm +"/"+ "com.tencent.iglite" + "/files");
                                    sh("su -c touch " + cxm +"/"+ "com.tencent.iglite" + "/files");
                                    sh("rm -rf " + cxm +"/"+ "com.tencent.iglite" + "/files");
                                    sh("touch " + cxm +"/"+ "com.tencent.iglite" + "/files");

                                    if (vercd ==1 ){
                                        sh("su -c rm -rf " + cxm +"/"+ "com.tencent.ig" + "/files");
                                        sh("su -c touch " + cxm +"/"+ "com.tencent.ig" + "/files");
                                        sh("rm -rf " + cxm +"/"+ "com.tencent.ig" + "/files");
                                        sh("touch " + cxm +"/"+ "com.tencent.ig" + "/files");

                                    }else{
                                        if (vercd ==2){
                                            sh("su -c rm -rf " + cxm +"/"+ "com.pubg.krmobile" + "/files");
                                            sh("su -c touch " + cxm +"/"+ "com.pubg.krmobile" + "/files");
                                            sh("rm -rf " + cxm +"/"+ "com.pubg.krmobile" + "/files");
                                            sh("touch " + cxm +"/"+ "com.pubg.krmobile" + "/files");

                                        }else{
                                            if (vercd ==3){
                                                sh("su -c rm -rf " + cxm +"/"+ "com.tencent.iglite" + "/files");
                                                sh("su -c touch " + cxm +"/"+ "com.tencent.iglite" + "/files");
                                                sh("rm -rf " + cxm +"/"+ "com.tencent.iglite" + "/files");
                                                sh("touch " + cxm +"/"+ "com.tencent.iglite" + "/files");

                                            }

                                        }
                                    }

                                }
                            }

                        }}}
            }
        });
        ////////////////////////////////////////////importing//////////////////////////////////////////////////////////////////////








   /*     final String[] vers = {"Global", "Korea", "Vietnam", "Taiwan"};
        final Spinner spin = findViewById(R.id.spinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, vers);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spin.getSelectedItem().toString().equals("Taiwan")){
                    gameName = "com.rekoo.pubgm";
                    gameType=4;
                }
                else if (spin.getSelectedItem().toString().equals("Korea")){
                    gameName = "com.pubg.krmobile";
                    gameType=2;
                }
                else if (spin.getSelectedItem().toString().equals("Vietnam")){
                    gameName = "com.vng.pubgmobile";
                    gameType=3;
                }
                else{
                    gameName = "com.tencent.ig";
                    gameType=1;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/





    /*    for(String pathDir : System.getenv("PATH").split(":")) {
            if (new File(pathDir, "su").exists()) {
                isRoot = true;
                ExecuteElf("su -c");
                isNoroot = false;
                rootMod = true;
            }else{
                isNoroot = true;
                isRoot = false;
                rootMod = true;
            }}


*/


        ExecuteElf("su -c");

        loadAssets();
        loadAssets64();

        socket = daemonPath;

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


    private boolean MvAssets(String outPath, String fileName)
    {
        File file = new File(outPath);
        if (!file.exists())
        {
            if (!file.mkdirs())
            {
                Log.e("--Method--", "copyAssetsSingleFile: cannot create directory.");
                return false;
            }
        }
        try
        {
            InputStream inputStream = getAssets().open(fileName);
            File outFile = new File(file, fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int byteRead;
            while (-1 != (byteRead = inputStream.read(buffer)))
            {
                fileOutputStream.write(buffer, 0, byteRead);
            }
            inputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }



    private void initialization(){
        MvAssets(getFilesDir() + "/","gl.sh");
        MvAssets(getFilesDir() + "/","Clear.sh");
        MvAssets(getFilesDir() + "/","kr.sh");
        Handler Handler = new Handler();
        Handler.postDelayed(new Runnable() {
            @Override
            public void run() {}}, 6000);
    }



    public void CheckFloatViewPermission()
    {
        if (!Settings.canDrawOverlays(this))
        {
            Toast.makeText(this,"Enable Floating Permission ",Toast.LENGTH_LONG).show();
            startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), 0);
        }
    }

    private boolean isServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        if (manager != null) {
            for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
                if (FloatLogo.class.getName().equals(service.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }




    void startPatcher() {
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, 123);
        } else {
            startFloater();
        }
    }

    private void startFloater() {
        if (!isServiceRunning()) {
            startService(new Intent(this, FloatLogo.class));
        } else {
            Toast.makeText(this, "Service Already Running!", Toast.LENGTH_SHORT).show();
        }
    }

    private void ExecuteElf(String shell)
    {
        String s=shell;

        try
        {
            Runtime.getRuntime().exec(s,null,null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void RunCPP(String path)
    {
        try
        {
            ExecuteElf("chmod 777 "+getFilesDir()+path);
            ExecuteElf(getFilesDir()+path);
            ExecuteElf("su -c chmod 777 "+getFilesDir()+path);
            ExecuteElf("su -c "+getFilesDir()+path);
        }
        catch(Exception e){
        }
    }


    public void Shell(String str) {

        DataOutputStream dataOutputStream = null;
        try {
            process = Runtime.getRuntime().exec(str);
        } catch (IOException e) {
            e.printStackTrace();
            process = null;
        }
        if (process != null) {
            dataOutputStream = new DataOutputStream(process.getOutputStream());
        }
        try {
            dataOutputStream.flush();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            process.waitFor();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

    public void startDaemon(){
        new Thread()
        {
            public void run()
            {
                Shell(socket);

            }
        }.start();
    }

    public void loadAssets()
    {
        String pathf = getFilesDir().toString()+"/sock32";
        try
        {
            OutputStream myOutput = new FileOutputStream(pathf);
            byte[] buffer = new byte[1024];
            int length;
            InputStream myInput = getAssets().open("sock32");
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myInput.close();
            myOutput.flush();
            myOutput.close();

        }

        catch (IOException e)
        {
        }

        daemonPath = getFilesDir().toString()+"/sock32";


        try{
            Runtime.getRuntime().exec("chmod 777 "+daemonPath);
        }
        catch (IOException e)
        {
        }

    }

    public void loadAssets64()
    {

        String pathf = getFilesDir().toString()+"/sock64";
        try
        {
            OutputStream myOutput = new FileOutputStream(pathf);
            byte[] buffer = new byte[1024];
            int length;
            InputStream myInput = getAssets().open("sock64");
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myInput.close();
            myOutput.flush();
            myOutput.close();

        }

        catch (IOException e)
        {
        }


        daemonPath64 = getFilesDir().toString()+"/sock64";


        try{
            Runtime.getRuntime().exec("chmod 777 "+daemonPath64);
        }
        catch (IOException e)
        {
        }

    }

    void Init(){
        SharedPreferences sp=getApplicationContext().getSharedPreferences("espValue", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("fps",30);
        ed.putBoolean("Box",true);
        ed.putBoolean("Line",true);
        ed.putBoolean("Distance",false);
        ed.putBoolean("Health",false);
        ed.putBoolean("Name",false);
        ed.putBoolean("Back Mark",false);
        ed.putBoolean("Skelton",false);
        ed.putBoolean("Grenade Warning",false);
        ed.putBoolean("Enemy Weapon",false);
        ed.putBoolean("Cross",true);
        ed.apply();
    }
    boolean isConfigExist(){
        SharedPreferences sp=getApplicationContext().getSharedPreferences("espValue", Context.MODE_PRIVATE);
        return sp.contains("fps");
    }
    private void toast(String txt) {
        Context context = getApplicationContext();
        CharSequence text = txt;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    private void write(String name, String content) {
        String text = content;
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(name, MODE_PRIVATE);
            fos.write(text.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public  String read(String name){
        FileInputStream fis = null;
        try {
            fis = openFileInput(name);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            xs = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return xs;
    }
    public void sh(String cmd){
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("MissingPermission")
    private boolean obfs() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getNetworkInfo(ConnectivityManager.TYPE_VPN).isConnectedOrConnecting();
    }
    public void toastc(String cmd){
        LayoutInflater li = getLayoutInflater();
        //Getting the View object as defined in the customtoast.xml file
        View layout = li.inflate(R.layout.toast,(ViewGroup) findViewById(R.id.custom_toast_layout));
        //Creating the Toast object
        TextView text = (TextView) layout.findViewById(R.id.custom_toast_message);
        text.setText(cmd);
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 460);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();
    }
    void installAPK(){

        String PATH = Environment.getExternalStorageDirectory() + "/" + "m.apk";
        write("path",PATH);
        File file = new File(PATH);
        if(file.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uriFromFile(getApplicationContext(), new File(PATH)), "application/vnd.android.package-archive");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            try {
                getApplicationContext().startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                Log.e("TAG", "Error in opening the file!");
            }
        }else{
            Toast.makeText(getApplicationContext(),"installing",Toast.LENGTH_LONG).show();
        }
    }
    Uri uriFromFile(Context context, File file) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", file);
        } else {
            return Uri.fromFile(file);
        }
    }

    public void gen() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        write("",generatedString);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu,menu);
        return true;

    }
    public void showPopup(View v){
        PopupMenu popup =new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_menu);
        popup.show();
    }

    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.item1:
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), MainActivity6.class));
                return true;
            case  R.id.item2:
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), Profile.class));
                return true;

            default:
                return false;
        }
    }

    public void copy(File src, File dst) throws IOException {
        FileInputStream inStream = new FileInputStream(src);
        FileOutputStream outStream = new FileOutputStream(dst);
        FileChannel inChannel = inStream.getChannel();
        FileChannel outChannel = outStream.getChannel();
        inChannel.transferTo(0, inChannel.size(), outChannel);
        inStream.close();
        outStream.close();
    }
    public void auto(){
        String pathxy = getFilesDir()+"";
        String cxt = pathxy.replaceAll("/files", "/cache");


        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 400 milliseconds
        v.vibrate(400);
        boolean xst = obfs();
        conf = read("db_constraint");

        String vc = read(".hgh");
        String nk = vc.replaceAll(" ","");
        String id = nk.replaceAll("\n","");

        if(xst == true){
            MainActivity.this.finish();
        }
        else

            MainActivity.spinner.setVisibility(View.VISIBLE);
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            String URL = "https://jarvisinternationaltech.com/nikx.php";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("fc", "login");
            jsonBody.put("key", id);
            jsonBody.put("device", conf);
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("nmsr")){
                        try {
                            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                            String URL = "https://jarvisinternationaltech.com/cpp/keyx.php";
                            JSONObject jsonBody = new JSONObject();
                            jsonBody.put("fc", "bitchx");
                            jsonBody.put("key", id);
                            jsonBody.put("device", conf);
                            final String requestBody = jsonBody.toString();

                            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    xtx = response;
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

                        MainActivity.spinner.setVisibility(View.GONE);
                        //  MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), MainActivity5.class));
                        //  MainActivity.this.finish();
                        ConstraintLayout m = findViewById(R.id.constraintLayout13);
                        m.setVisibility(View.GONE);
                        TextView title = findViewById(R.id.textView);
                        title.setVisibility(View.GONE);
                        loi.setVisibility(View.VISIBLE);

                        CheckBox rm = findViewById(R.id.checkBoxrem);

                        if (rm.isChecked()){
                            write("cache_vr","1");
                        }

                        if (Build.VERSION.SDK_INT >= 21) {
                            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.mg));
                        }

                    }
                    if (response.equals("1007")){
                        MainActivity.spinner.setVisibility(View.GONE);
                        mediaPlayer.start();
                        write("invalid1","1");
                        textInputLayout3.setError("Error code 1007");
                        sh("rm -rf "+getFilesDir()+"/cache_vr");
                        sh("su -c rm -rf "+getFilesDir()+"/cache_vr");
                    }
                    if (response.equals("0")){
                        spinner.setVisibility(View.GONE);
                        mediaPlayer.start();
                        write("invalid","1");
                        write("id",id);
                        textInputLayout3.setError("Invalid key");
                        sh("rm -rf "+getFilesDir()+"/cache_vr");
                        sh("su -c rm -rf "+getFilesDir()+"/cache_vr");
                    }
                    if (response.equals("0101")){
                        MainActivity.spinner.setVisibility(View.GONE);
                        mediaPlayer.start();
                        write("invalid3","1");
                        textInputLayout3.setError("Key Expired !");
                        sh("rm -rf "+getFilesDir()+"/cache_vr");
                        sh("su -c rm -rf "+getFilesDir()+"/cache_vr");
                    }
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

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static boolean isRootAvailable(){
        for(String pathDir : System.getenv("PATH").split(":")){
            if(new File(pathDir, "su").exists()) {
                return true;
            }
        }
        return false;
    }

}








