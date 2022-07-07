package com.tencent.qq;

import static com.tencent.qq.MainActivity6.gameType;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.lingala.zip4j.headers.HeaderWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    ProgressBar splashProgress;
    private String xs;
    public static int g = 1;
    public static int k = 1;
    public static int l = 1;
    public static int c = 1;
    public static int v = 1;
    public static int t = 1;
    public static int cg = 1;
    public static int yx = 0;
    public static int b =1;
    public static int compg = 0;
    public static int compk = 0;
    public static int compl = 0;
    public static int compc = 0;
    public static int compcg = 0;
    public static int compt = 0;
    public static int compv = 0;
    public static int compb = 0;
    public static int xz = 0;

    int SPLASH_TIME = 5000;
    public static MediaPlayer mpo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow();
        getApplicationContext().getExternalFilesDir("");
        requestWindowFeature(1);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }
        if (Build.VERSION.SDK_INT >= 29 && (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == PackageManager.PERMISSION_DENIED || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == PackageManager.PERMISSION_DENIED)) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
        }
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 0);
        }

        copyAssets();
        get("https://jarvisinternationaltech.com/cpp/vver","vver");
        get("https://jarvisinternationaltech.com/cpp/tver","tver");
        get("https://jarvisinternationaltech.com/cpp/cgver","cgver");
        get("https://jarvisinternationaltech.com/cpp/gver","gver");
        get("https://jarvisinternationaltech.com/cpp/kver","kver");
        get("https://jarvisinternationaltech.com/cpp/cver","cver");
        get("https://jarvisinternationaltech.com/cpp/lver","lver");
        get("https://jarvisinternationaltech.com/cpp/bver","bver");

        File filexs = new File(getFilesDir()+"/db_constraintx");
        if (filexs.exists()) {
            yx = 1;
        }
        File filexj = new File(getFilesDir()+"/db_constraint");
        if (!filexj.exists()) {
         gen();
        }

        MainActivity2.getlogs runnable =new getlogs();
        new Thread(runnable).start();



//Code to start timer and take action after the timer ends
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do any action here. Now we are moving to next page
                Intent mySuperIntent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(mySuperIntent);
                //This 'finish()' is for exiting the app when back button pressed from Home page which is ActivityHome
                finish();

            }
        }, SPLASH_TIME);
    }

    //Method to run progress bar for 5 seconds
    private void playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 100)
                .setDuration(5000)
                .start();
    }
    private void copyAssets() {
        AssetManager assetManager = getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            Log.e("tag", "Failed to get asset file list.", e);
        }
        if (files != null) for (String filename : files) {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(getFilesDir()+"/"+filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch(IOException e) {
                Log.e("tag", "Failed to copy asset file: " + filename, e);
            }
            finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        // NOOP
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        // NOOP
                    }
                }
            }
        }
    }
    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
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
    public void gen() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        write("db_constraint",generatedString);

    }
    public void get(String url,String filename){
        RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        write(filename,response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

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
    public void she(String cmd){
        try {
            Runtime.getRuntime().exec("su -c "+cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    class getlogs implements Runnable{

        getlogs(){
        }
        @Override
        public void run() {
            she("pm path com.pubg.imobile &> "+getFilesDir()+"/logs.txt");
            she("pm path com.tencent.ig &> "+getFilesDir()+"/logsg.txt");
            she("pm path com.pubg.krmobile &> "+getFilesDir()+"/logsk.txt");
            she("pm path com.vng.pubgmobile &> "+getFilesDir()+"/logsv.txt");
            she("pm path com.tencent.iglite &> "+getFilesDir()+"/logsl.txt");
            she("pm path com.rekoo.pubgm &> "+getFilesDir()+"/logst.txt");

            write(".xmc1","1");
            write(".xmc2","2");
            write(".xmc3","3");
            write(".xmc4","4");
            write(".xmc5","5");
            write(".xmc6","6");
            write(".xmc7","7");
            write(".xmc8","8");
            String path = getFilesDir() + "/";

            File fileb = new File(path+"verb");
            if (!fileb.exists()) {
                write("verb","N/A");
                write("bx","1");
                b = 0;
            }else{if (read("bver").equals(read("verb"))){
                compb =2;
            }else{compb =1;}}

            File filev = new File(path+"verv");
            if (!filev.exists()) {
                write("verv","N/A");
                write("vx","1");
                v = 0;
            }else{if (read("vver").equals(read("verv"))){
                compv =2;
            }else{compv =1;}}
            File filet = new File(path+"vert");
            if (!filet.exists()) {
                write("vert","N/A");
                write("tx","1");
                t = 0;
            }else{if (read("tver").equals(read("vert"))){
                compt =2;
            }else{compt =1;}}

            File filecg = new File(path+"vercg");
            if (!filecg.exists()) {
                write("vercg","N/A");
                write("cgx","1");
                v = 0;
            }else{if (read("cgver").equals(read("vercg"))){
                compcg =2;
            }else{compcg =1;}}

            File filex = new File(path+"verg");
            if (!filex.exists()) {
                write("verg","N/A");
                write("gx","1");
                g = 0;
            }else{if (read("gver").equals(read("verg"))){
                compg =2;
            }else{compg =1;}}

            File filek = new File(path+"verk");
            if (!filek.exists()) {
                write("verk","N/A");
                write("kx","1");
                k =0;
            }else{if (read("kver").equals(read("verk"))){
                compk =2;
            }else{ compk =1;}}

            File filec = new File(path+"verc");
            if (!filec.exists()) {
                write("verc","N/A");
                write("cx","1");
                c = 0;
            }else{if (read("cver").equals(read("verc"))){
                compc = 2;
            }else{compc =1;}}

            File filel = new File(path+"verl");
            if (!filel.exists()) {
                write("verl","N/A");
                write("lx","1");
                l =0;

            }else{if (read("lver").equals(read("verl"))){
                compl = 2;
            }else{compl =1;}}

        }

    }


}