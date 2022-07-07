package com.tencent.qq;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import static com.tencent.qq.MainActivity.vercd;
import static com.tencent.qq.MainActivity6.gameType;
import static com.tencent.qq.MainActivity6.verx;
import static java.lang.System.exit;

public class FloatLogo extends Service implements View.OnClickListener {
    TextView float_ninja;

    private WindowManager mWindowManager;
    private View mFloatingView;
    private WindowManager mWindowManageraim;
    private View mFloatingViewaim;
    public static int closex =0;
    @SuppressLint("StaticFieldLeak")
    private static FloatLogo Instance;
    private String daemonPath;
    public int pval =4;
    public int pvalc =6;
    public int abv =1;
    public  static String packc;
    public  static String packct;
    public  static String packcl;
    public  static String packcv;
    public  static String packck;
    public  static String packcg;

    public static String packaget;


    public FloatLogo() {
    }
    static {
        System.loadLibrary("jarvis");
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    View logoView;
    View espView;
    View aimon,aimoff;
    public static String cvbn;
    public static String kklj;
    @SuppressLint("CutPasteId")
    @Override
    public void onCreate() {
        super.onCreate();
        Instance=this;
        createOver();
        SettingValue(11,false);
        logoView = mFloatingView.findViewById(R.id.collapsedView);
        espView = mFloatingView.findViewById(R.id.rv1);
        aimon = mFloatingViewaim.findViewById(R.id.relativeLayoutParentaimon);
        aimoff = mFloatingViewaim.findViewById(R.id.relativeLayoutParentaimoff);
        Init();

    }


    @SuppressLint("InflateParams")
    void createOver(){

        mFloatingView = LayoutInflater.from(this).inflate(R.layout.floatlogo, null);
        mFloatingViewaim = LayoutInflater.from(this).inflate(R.layout.aim, null);
        int LAYOUT_FLAG;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;

        } else {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
        }
        //setting the layout parameters
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                LAYOUT_FLAG,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.RGBA_8888);

        //setting the layout parameters
        final WindowManager.LayoutParams paramsaim = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                LAYOUT_FLAG,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.RGBA_8888);

        //getting windows services and adding the floating view to it
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);
        mWindowManageraim = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManageraim.addView(mFloatingViewaim, paramsaim);

        final GestureDetector gestureDetector = new GestureDetector(this, new SingleTapConfirm());
        final GestureDetector gestureDetectoraim = new GestureDetector(this, new SingleTapConfirm());

        //window function
        Switch wallc = mFloatingView.findViewById(R.id.switch2c);
        Switch smallc = mFloatingView.findViewById(R.id.switch3c);
        Switch abc = mFloatingView.findViewById(R.id.switch4c);
        Switch nrc = mFloatingView.findViewById(R.id.switch5c);
        Switch wvc = mFloatingView.findViewById(R.id.switch2cc);
        Switch qc = mFloatingView.findViewById(R.id.switch6c);
        Switch mbc = mFloatingView.findViewById(R.id.switch7c);
        Switch sitc = mFloatingView.findViewById(R.id.switch8c);
        Switch standc = mFloatingView.findViewById(R.id.switch9c);
        Switch pronec = mFloatingView.findViewById(R.id.switch10c);
        Switch protect = mFloatingView.findViewById(R.id.switch11c);
        Switch pdc = mFloatingView.findViewById(R.id.switch12c);
        TextView tView = mFloatingView.findViewById(R.id.tv13);
        TextView tViewc = mFloatingView.findViewById(R.id.tv13c);

        Switch pd = mFloatingView.findViewById(R.id.switch33);
        Switch bt = mFloatingView.findViewById(R.id.switchbt);
        Switch fc = mFloatingView.findViewById(R.id.switch7cc);
        Switch wsc = mFloatingView.findViewById(R.id.switch7ccc);
        TextView safec = mFloatingView.findViewById(R.id.safecod);
        TextView brutalc = mFloatingView.findViewById(R.id.brutalcod);
        TextView extrac = mFloatingView.findViewById(R.id.Extrascod);
        TextView espon = mFloatingView.findViewById(R.id.textView9);
        LinearLayout brutalviewc = mFloatingView.findViewById(R.id.brutalc);
        LinearLayout extraviewc = mFloatingView.findViewById(R.id.extrac);
        LinearLayout safeviewc = mFloatingView.findViewById(R.id.safec);
        Switch espswi = mFloatingView.findViewById(R.id.switch32);
        LinearLayout safeview = mFloatingView.findViewById(R.id.safe);
        LinearLayout brutalview = mFloatingView.findViewById(R.id.brutal);
        LinearLayout extraview = mFloatingView.findViewById(R.id.extra);
        LinearLayout injector = mFloatingView.findViewById(R.id.injector);
        LinearLayout espmeu =mFloatingView.findViewById(R.id.espmenu);
        TextView safe = mFloatingView.findViewById(R.id.textView3);
        TextView brutal = mFloatingView.findViewById(R.id.textView4);
        TextView extra = mFloatingView.findViewById(R.id.textView5);
        TextView player = mFloatingView.findViewById(R.id.player);
        TextView weapon = mFloatingView.findViewById(R.id.weapon);
        TextView vehicle = mFloatingView.findViewById(R.id.vehicle);
        LinearLayout playerview =mFloatingView.findViewById(R.id.playermenu);
        LinearLayout weaponview =mFloatingView.findViewById(R.id.weaponmenu);
        LinearLayout vehicleview =mFloatingView.findViewById(R.id.vehiclemenu);
        TextView minimise = mFloatingView.findViewById(R.id.textViewmin);
        TextView close = mFloatingView.findViewById(R.id.textViewclose);
        Switch obf = mFloatingView.findViewById(R.id.switch31);

        String hc = MainActivity.packet.replaceAll("\n","");
        String gj = hc.replaceAll("package:","");
        String packcd = gj.replaceAll("base.apk","lib/arm64/");
        packc = packcd.replaceAll("\\r|\\n","");

        hc = MainActivity.packett.replaceAll("\n","");
        gj = hc.replaceAll("package:","");
        packcd = gj.replaceAll("base.apk","lib/arm64/");
        packct = packcd.replaceAll("\\r|\\n","");

        hc = MainActivity.packetv.replaceAll("\n","");
        gj = hc.replaceAll("package:","");
        packcd = gj.replaceAll("base.apk","lib/arm64/");
        packcv = packcd.replaceAll("\\r|\\n","");

        hc = MainActivity.packeg.replaceAll("\n","");
        gj = hc.replaceAll("package:","");
        packcd = gj.replaceAll("base.apk","lib/arm64/");
        packcg = packcd.replaceAll("\\r|\\n","");

        hc = MainActivity.packetl.replaceAll("\n","");
        gj = hc.replaceAll("package:","");
        packcd = gj.replaceAll("base.apk","lib/arm64/");
        packcl = packcd.replaceAll("\\r|\\n","");

        hc = MainActivity.packetk.replaceAll("\n","");
        gj = hc.replaceAll("package:","");
        packcd = gj.replaceAll("base.apk","lib/arm64/");
        packck = packcd.replaceAll("\\r|\\n","");




/*
        sh("rm -rf "+packc+"libBugly.so");
        sh("rm -rf "+packc+"libzip.so");
        sh("rm -rf "+packc+"libgamemaster.so");
        sh("rm -rf "+packc+"libgcloudarch.so");
        sh("rm -rf "+packc+"libhelpshiftlistener.so");
        sh("rm -rf "+packc+"libigshare.so");
        sh("rm -rf "+packc+"liblbs.so");
        sh("rm -rf "+packc+"libnpps-jni.so");
        sh("rm -rf "+packc+"libst-engine.so");
        sh("rm -rf "+packc+"libapp.so");
        sh("rm -rf "+packc+"libc++_shared.so");
        sh("rm -rf "+packc+"libflutter.so");
        sh("rm -rf "+packc+"libImsdk.so");
        sh("rm -rf "+packc+"libmarsxlog.so");
        sh("rm -rf "+packc+"libmmkv.so");
        sh("rm -rf "+packc+"libsentry.so");
        sh("rm -rf "+packc+"libsentry-android.so");
        sh("rm -rf "+packc+"libkk-image.so");
        sh("rm -rf "+packc+"libsoundtouch.so");*/


        safe.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.antion));
        safec.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.antion));
        minimise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                espView.setVisibility(View.GONE);
                logoView.setVisibility(View.VISIBLE);

            }
        });
        wvc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(2);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(3);
                    new Thread(runnable).start();
                }
            }
        });
        fc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(12);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(13);
                    new Thread(runnable).start();
                }
            }
        });

        bt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(28);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(29);
                    new Thread(runnable).start();
                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (closex==1) {
                    espmeu.setVisibility(View.GONE);
                    injector.setVisibility(View.VISIBLE);
                    closex=0;
                }else{ stopService(new Intent(FloatLogo.this, Overlay.class));  stopService(new Intent(FloatLogo.this, FloatLogo.class)); MainActivity.islist = 1;}

            }
        });
        wsc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(16);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(17);
                    new Thread(runnable).start();
                }
            }
        });

        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.antion));
                weapon.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                vehicle.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                playerview.setVisibility(View.VISIBLE);
                weaponview.setVisibility(View.GONE);
                vehicleview.setVisibility(View.GONE);

            }
        });

        weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                weapon.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.antion));
                vehicle.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                playerview.setVisibility(View.GONE);
                weaponview.setVisibility(View.VISIBLE);
                vehicleview.setVisibility(View.GONE);

            }
        });

        vehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                weapon.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                vehicle.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.antion));
                playerview.setVisibility(View.GONE);
                weaponview.setVisibility(View.GONE);
                vehicleview.setVisibility(View.VISIBLE);

            }
        });
        safec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                safec.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.antion));
                brutalc.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                extrac.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                safeviewc.setVisibility(View.VISIBLE);
                brutalviewc.setVisibility(View.GONE);
                extraviewc.setVisibility(View.GONE);

            }
        });
        safe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                safe.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.antion));
                brutal.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                extra.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                safeview.setVisibility(View.VISIBLE);
                brutalview.setVisibility(View.GONE);
                extraview.setVisibility(View.GONE);

            }
        });
        brutalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                safec.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                brutalc.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.antion));
                extrac.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                safeviewc.setVisibility(View.GONE);
                brutalviewc.setVisibility(View.VISIBLE);
                extraviewc.setVisibility(View.GONE);

            }
        });
        brutal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                safe.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                brutal.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.antion));
                extra.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                safeview.setVisibility(View.GONE);
                brutalview.setVisibility(View.VISIBLE);
                extraview.setVisibility(View.GONE);

            }
        });
        if (verx==1) {
            cvbn = MainActivity.hjg;
            kklj = "libctr.so";
            abv =2;
            packaget="com.tencent.ig";
            MainActivity6.gameType=1;
        }
        if (verx ==0 &vercd ==1){
            cvbn = MainActivity.hjg;
            kklj = "libctr.so";
            packaget="com.tencent.ig";
            MainActivity6.gameType=1;
            abv = 2;}
        if (verx == 2) {
            cvbn = MainActivity.hjk;
            kklj = "libnative.so";
            MainActivity6.gameType=2;
        }
        if (verx==0 & vercd ==2){
            cvbn = MainActivity.hjk;
            kklj = "libnative.so";
            MainActivity6.gameType=2;
        }
        if (verx == 3) {
            cvbn = MainActivity.hjl;
            MainActivity6.gameType=3;
            kklj = "lib_n_ctr.so";
        }
        if (verx ==0 & vercd ==3){
            cvbn = MainActivity.hjl;
            kklj = "lib_n_ctr.so";
            MainActivity6.gameType=3;
        }

        if (verx == 4) {
            cvbn = MainActivity.hjc;
            kklj = "libcurl.so";
        }
        if (verx ==0 & vercd ==4){
            cvbn = MainActivity.hjc;
            kklj = "libcurl.so";}

        if (verx == 8) {
            cvbn = MainActivity.hjc;
            kklj = "libbgmi.so";
            abv = 1;
            packaget="com.pubg.imobile";
            MainActivity6.gameType=5;
        }
        if (verx ==0 & vercd ==8){
            cvbn = MainActivity.hjc;
            kklj = "libbgmi.so";
            abv = 1;
            packaget="com.pubg.imobile";
            MainActivity6.gameType=5;
        }

        sh("chmod 777 "+MainActivity.internal+"/"+ FloatLogo.kklj);
        sh("chmod 777 "+getFilesDir()+"/sock");

        FloatLogo.clearc runnable =new clearc();
        new Thread(runnable).start();

        extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                safe.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                brutal.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                extra.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.antion));
                safeview.setVisibility(View.GONE);
                brutalview.setVisibility(View.GONE);
                extraview.setVisibility(View.VISIBLE);

            }
        });

        extrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                safec.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                brutalc.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.cross));
                extrac.setBackground(ContextCompat.getDrawable(FloatLogo.this, R.drawable.antion));
                safeviewc.setVisibility(View.GONE);
                brutalviewc.setVisibility(View.GONE);
                extraviewc.setVisibility(View.VISIBLE);

            }
        });
        espon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closex=1;
                injector.setVisibility(View.GONE);
                espmeu.setVisibility(View.VISIBLE);
            }
        });
        espswi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    espon.setVisibility(View.VISIBLE);
                    startService(new Intent(FloatLogo.this, Overlay.class));
                } else {
                    espon.setVisibility(View.GONE);
                    stopService(new Intent(FloatLogo.this, Overlay.class));
                }
            }
        });


        ToggleButton toggleaban = (ToggleButton) mFloatingView.findViewById(R.id.aban);
        ToggleButton toggleabanc = (ToggleButton) mFloatingView.findViewById(R.id.abanc);
        SeekBar sb = mFloatingView.findViewById(R.id.seek);
        SeekBar sbc = mFloatingView.findViewById(R.id.seekc);
        LinearLayout codm = mFloatingView.findViewById(R.id.codmenu);
        Switch wv = mFloatingView.findViewById(R.id.switch2);
        Switch ab = mFloatingView.findViewById(R.id.switch3);
        Switch sc = mFloatingView.findViewById(R.id.switch4);
        Switch ih = mFloatingView.findViewById(R.id.switch4i);
        Switch nf = mFloatingView.findViewById(R.id.switch5);
        Switch lr = mFloatingView.findViewById(R.id.switch6);
        Switch ahs = mFloatingView.findViewById(R.id.switch7);
        Switch as = mFloatingView.findViewById(R.id.switch8);
        Switch ab100 = mFloatingView.findViewById(R.id.switch9);
        Switch flash = mFloatingView.findViewById(R.id.switch21);
        Switch flashx = mFloatingView.findViewById(R.id.switch2cv);
        Switch flashy = mFloatingView.findViewById(R.id.switch2cvn);
        Switch ah = mFloatingView.findViewById(R.id.switch20);
        Switch sit = mFloatingView.findViewById(R.id.switch22);
        Switch stand = mFloatingView.findViewById(R.id.switch23);

        Switch fp = mFloatingView.findViewById(R.id.switch25);
        Switch cf = mFloatingView.findViewById(R.id.switch26);
        Switch third = mFloatingView.findViewById(R.id.switch30);
        Switch desert = mFloatingView.findViewById(R.id.desert);
        Switch ptrace = mFloatingView.findViewById(R.id.ptrace);



        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
                tView.setText("   Set delay : "+pval);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
                tView.setText("   Set delay : "+pval);
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tView.setText("   Set delay : "+pval);
            }
        });

        sbc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pvalc = progress;
                tViewc.setText("   Set delay : "+pvalc);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
                tViewc.setText("   Set delay : "+pvalc);
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tViewc.setText("   Set delay : "+pvalc);
            }
        });

        obf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sh("su -c iptables -A INPUT -p tcp -j DROP");
                } else {
                    sh("su -c iptables -F");
                    sh("su -c iptables -X");
                }
            }
        });

        protect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(100);
                    new Thread(runnable).start();
                } else {

                }
            }
        });
        pdc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(1);
                    new Thread(runnable).start();
                    //////////////////////////
                } else {
                    sh("chmod 777 /data/user/0/com.tencent.mobileqqig/files");
                }
            }
        });
        pd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                   /* if (isRootAvailable()!=true){sh("./"+getFilesDir()+"/sock "+abv); FloatLogo.this.startActivity(FloatLogo.this.getPackageManager().getLaunchIntentForPackage("com.pubg.imobile")); sh("chmod 000 /data/user/0/com.tencent.mobileqqig/files");}else{
                        ExampleRunnableops runnable =new ExampleRunnableops();
                        new Thread(runnable).start();|*/
                    sh("./"+getFilesDir()+"/sock 1 " + pval);

                } else {


                }
            }
        });
        ptrace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(210);
                    new Thread(runnable).start();
                } else {


                }
            }
        });
        wallc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(4);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(5);
                    new Thread(runnable).start();
                }
            }
        });
        smallc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(20);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(21);
                    new Thread(runnable).start();
                }
            }
        });
        abc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(8);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(9);
                    new Thread(runnable).start();
                }
            }
        });
        nrc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(10);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(11);
                    new Thread(runnable).start();
                }
            }
        });
        qc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(10);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(11);
                    new Thread(runnable).start();
                }
            }
        });
        mbc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(18);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(19);
                    new Thread(runnable).start();
                }
            }
        });
        sitc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(20);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(21);
                    new Thread(runnable).start();
                }
            }
        });
        standc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(22);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(23);
                    new Thread(runnable).start();
                }
            }
        });
        pronec.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(24);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(25);
                    new Thread(runnable).start();
                }
            }
        });


        fp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(44);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(45);
                    new Thread(runnable).start();
                }
            }
        });

        ab100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(51);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(52);
                    new Thread(runnable).start();
                }
            }
        });
        ahs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(53);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(54);
                    new Thread(runnable).start();
                }
            }
        });
        third.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(46);
                    new Thread(runnable).start();
                } else {

                }
            }
        });
        as.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(49);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(50);
                    new Thread(runnable).start();
                }
            }
        });
        cf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(36);
                    new Thread(runnable).start();
                } else {

                }
            }
        });
        stand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(38);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(39);
                    new Thread(runnable).start();
                }
            }
        });
        sit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(20);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(21);
                    new Thread(runnable).start();
                }
            }
        });

        flash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(32);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(33);
                    new Thread(runnable).start();
                }
            }
        });


        flashx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(32);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(33);
                    new Thread(runnable).start();
                }
            }
        });
        flashy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(34);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(35);
                    new Thread(runnable).start();
                }
            }
        });

        desert.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(56);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(57);
                    new Thread(runnable).start();
                }
            }
        });
        toggleaban.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(48);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(55);
                    new Thread(runnable).start();
                }

            }
        });
        toggleabanc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(48);
                    new Thread(runnable).start();

                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(1);
                    new Thread(runnable).start();

                }
            }
        });
        wv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ExampleRunnableop runnable =new ExampleRunnableop(2);
                    new Thread(runnable).start();
                    // shellx(2);
                    // The toggle is enabled
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(3);
                    new Thread(runnable).start();

                    // The toggle is disabled
                }
            }
        });

        nf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(4);
                    new Thread(runnable).start();
                    // The toggle is enabled
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(5);
                    new Thread(runnable).start();
                    // The toggle is disabled
                }
            }
        });
        ab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(6);
                    new Thread(runnable).start();
                    // The toggle is enabled
                } else {

                    ExampleRunnableop runnable =new ExampleRunnableop(7);
                    new Thread(runnable).start();
                    // The toggle is disabled
                }
            }
        });
        lr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(8);
                    new Thread(runnable).start();
                    // The toggle is enabled
                } else {

                    ExampleRunnableop runnable =new ExampleRunnableop(9);
                    new Thread(runnable).start();
                    // The toggle is disabled
                }
            }
        });
        final Switch crosshair = mFloatingView.findViewById(R.id.switch4);
        crosshair.setChecked(getConfig((String) crosshair.getText()));
        SettingValue(16,getConfig((String) crosshair.getText()));
        crosshair.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(crosshair.getText()), crosshair.isChecked());
                SettingValue(13,crosshair.isChecked());
            }
        });

      /*  sc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    try {
                        Runtime.getRuntime().exec("su -c "+MainActivity.internal+"/"+ FloatLogo.kklj+" 10");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                   // ExampleRunnableop runnable =new ExampleRunnableop(10);
                   // new Thread(runnable).start();
                    // The toggle is enabled
                } else {

                    ExampleRunnableop runnable =new ExampleRunnableop(11);
                    new Thread(runnable).start();
                    // The toggle is disabled
                }
            }
        });
*/
        ih.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(40);
                    new Thread(runnable).start();
                    // The toggle is enabled
                } else {

                    ExampleRunnableop runnable =new ExampleRunnableop(40);
                    new Thread(runnable).start();
                    // The toggle is disabled
                }
            }
        });

        ah.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    ExampleRunnableop runnable =new ExampleRunnableop(12);
                    new Thread(runnable).start();
                } else {
                    ExampleRunnableop runnable =new ExampleRunnableop(13);
                    new Thread(runnable).start();

                }
            }
        });








        //floating window setting
        mFloatingView.findViewById(R.id.relativeLayoutParent).setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    espView.setVisibility(View.VISIBLE);
                    logoView.setVisibility(View.GONE);
                    if (verx==4){codm.setVisibility(View.VISIBLE);}else{ if (vercd ==4 & verx ==0){codm.setVisibility(View.VISIBLE);}else {
                        injector.setVisibility(View.VISIBLE);
                    }}
                    return true;
                } else {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            initialX = params.x;
                            initialY = params.y;
                            initialTouchX = event.getRawX();
                            initialTouchY = event.getRawY();
                            return true;


                        case MotionEvent.ACTION_MOVE:
                            //this code is helping the widget to move around the screen with fingers
                            params.x = initialX + (int) (event.getRawX() - initialTouchX);
                            params.y = initialY + (int) (event.getRawY() - initialTouchY);

                            mWindowManager.updateViewLayout(mFloatingView, params);
                            return true;
                    }
                    return false;
                }
            }
        });

        mFloatingViewaim.findViewById(R.id.relativeLayoutParentaimoff).setOnTouchListener(new View.OnTouchListener() {
            private int initialXaim;
            private int initialYaim;
            private float initialTouchXaim;
            private float initialTouchYaim;

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetectoraim.onTouchEvent(event)) {
                    aimon.setVisibility(View.VISIBLE);
                    aimoff.setVisibility(View.GONE);
                    SettingValue(11,true);
                    return true;
                } else {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            initialXaim = paramsaim.x;
                            initialYaim = paramsaim.y;
                            initialTouchXaim = event.getRawX();
                            initialTouchYaim = event.getRawY();
                            return true;


                        case MotionEvent.ACTION_MOVE:
                            //this code is helping the widget to move around the screen with fingers
                            paramsaim.x = initialXaim + (int) (event.getRawX() - initialTouchXaim);
                            paramsaim.y = initialYaim + (int) (event.getRawY() - initialTouchYaim);
                            mWindowManageraim.updateViewLayout(mFloatingViewaim, paramsaim);
                            return true;
                    }
                    return false;
                }
            }
        });

        mFloatingViewaim.findViewById(R.id.relativeLayoutParentaimon).setOnTouchListener(new View.OnTouchListener() {
            private int initialXaim;
            private int initialYaim;
            private float initialTouchXaim;
            private float initialTouchYaim;

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetectoraim.onTouchEvent(event)) {
                    aimoff.setVisibility(View.VISIBLE);
                    aimon.setVisibility(View.GONE);
                    SettingValue(11,false);
                    return true;
                } else {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            initialXaim = paramsaim.x;
                            initialYaim = paramsaim.y;
                            initialTouchXaim = event.getRawX();
                            initialTouchYaim = event.getRawY();
                            return true;


                        case MotionEvent.ACTION_MOVE:
                            //this code is helping the widget to move around the screen with fingers
                            paramsaim.x = initialXaim + (int) (event.getRawX() - initialTouchXaim);
                            paramsaim.y = initialYaim + (int) (event.getRawY() - initialTouchYaim);

                            mWindowManageraim.updateViewLayout(mFloatingViewaim, paramsaim);
                            return true;
                    }
                    return false;
                }
            }
        });



    }





    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFloatingView != null) mWindowManager.removeView(mFloatingView);
        if (mFloatingViewaim != null) mWindowManageraim.removeView(mFloatingViewaim);
    }

    @Override
    public void onClick(View v) {
       /* switch (v.getId()) {
            case R.id.floatLogo:
                //switching views
                espView.setVisibility(View.VISIBLE);
                logoView.setVisibility(View.GONE);
                break;

            case R.id.closeBtn:
                espView.setVisibility(View.GONE);
                logoView.setVisibility(View.VISIBLE);
                break;
        }*/
    }





    private String getType(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getString("type","1");
    }
    private void  setValue(String key,boolean b) {
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putBoolean(key,b);
        ed.apply();

    }

    boolean getConfig(String key){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return  sp.getBoolean(key,false);
        // return !key.equals("");
    }
    void setFps(int fps){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("fps",fps);
        ed.apply();
    }
    void setPosition(int position){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("position",position);
        ed.apply();
    }

    void setSize(int size){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("size",size);
        ed.apply();
    }

    void setStrokeBox(int StrokeBox){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("StrokeBox",StrokeBox);
        ed.apply();
    }

    void setStrokeSkeleton(int StrokeSkeleton){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("StrokeSkeleton",StrokeSkeleton);
        ed.apply();
    }

    void setStrokeLine(int StrokeLine){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("StrokeLine",StrokeLine);
        ed.apply();
    }

    void setColorBox(int ColorBox){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorBox",ColorBox);
        ed.apply();
    }

    void setColorSkel(int ColorSkel){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorSkel",ColorSkel);
        ed.apply();
    }

    void setColorHead(int ColorHead){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorHead",ColorHead);
        ed.apply();
    }

    void setColorLine(int ColorLine){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorLine",ColorLine);
        ed.apply();
    }

    void setColorAlert(int ColorAlert){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorAlert",ColorAlert);
        ed.apply();
    }

    void setColorAlertText(int ColorAlertText){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorAlertText",ColorAlertText);
        ed.apply();
    }

    void setItemSIze(int ItemSize){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ItemSize",ItemSize);
        ed.apply();
    }

    void setItemPosition(int ItemPosition){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ItemPosition",ItemPosition);
        ed.apply();
    }

    void setEnemyName(int EnemyName){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyName",EnemyName);
        ed.apply();
    }

    void setEnemyNameText(int EnemyNameText){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyNameText",EnemyNameText);
        ed.apply();
    }

    void setEnemyDistance(int EnemyDistance){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyDistance",EnemyDistance);
        ed.apply();
    }

    void setEnemyDistanceText(int EnemyDistanceText){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyDistanceText",EnemyDistanceText);
        ed.apply();
    }

    void setEnemyWeapon(int EnemyWeapon){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyWeapon",EnemyWeapon);
        ed.apply();
    }

    void setEnemyWeaponText(int EnemyWeaponText){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyWeaponText",EnemyWeaponText);
        ed.apply();
    }

    void setColorCrosHair(int ColorCrosHair){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorCrosHair",ColorCrosHair);
        ed.apply();
    }

    void setStrokeCrosHair(int StrokeCrosHair){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("StrokeCrosHair",StrokeCrosHair);
        ed.apply();
    }

    void setStrokeCrosHair2(int StrokeCrosHair2){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("StrokeCrosHair2",StrokeCrosHair2);
        ed.apply();
    }

    void setIDBgt(int IDBgt){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("IDBgt",IDBgt);
        ed.apply();
    }

    int getColorCrosHair(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorCrosHair",100);
    }

    int getStrokeCrosHair(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("StrokeCrosHair",200);
    }

    int getStrokeCrosHair2(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("StrokeCrosHair2",0);
    }

    int getIDBgt(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("IDBgt",100);
    }

    int getEnemyName(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyName",100);
    }

    int getEnemyDistance(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyDistance",100);
    }

    int getEnemyWeapon(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyWeapon",100);
    }

    int getEnemyNameText(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyNameText",100);
    }

    int getEnemyDistanceText(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyDistanceText",100);
    }

    int getEnemyWeaponText(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyWeaponText",100);
    }

    int getItemSize(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ItemSize",0);
    }

    int getItemPosition(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ItemPosition",0);
    }

    int getColorBox(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorBox",100);
    }

    int getColorSkeleton(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorLine",100);
    }

    int getColorHead(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorHead",100);
    }

    int getColorLine(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorLine",100);
    }

    int getColorAlert(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorAlert",100);
    }

    int getColorAlertText(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorAlertText",100);
    }

    int getFps(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("fps",100);
    }

    int getPosition(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("position",0);
    }

    int getSize(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("size",0);
    }

    int getStrokeBox(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("StrokeBox",0);
    }

    int getStrokeSkeleton(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("StrokeLine",0);
    }

    int getStrokeLine(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("StrokeLine",0);
    }

    public static void HideFloat() {

        if (Instance != null)
        {
            Instance.Hide();
        }
    }
    public void Hide(){
        stopSelf();
        exit(-1);
        /*Instance = null;
        try {
            mWindowManager.removeView(mFloatingView);
        }catch (Exception e){
            System.out.println("-->"+e);
        }
        try {
        stopSelf();
        }catch (Exception e){
            System.out.println("-->"+e);
        }
            try {
        this.onDestroy();
            }catch (Exception e) {
                System.out.println("-->" + e);
            }*/
    }

    void Init(){







        //all elements
        final CheckBox Buggy = mFloatingView.findViewById(R.id.Buggy);
        Buggy.setChecked(getConfig((String) Buggy.getText()));
        Buggy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Buggy.getText()), Buggy.isChecked());
            }
        });
        final CheckBox UAZ = mFloatingView.findViewById(R.id.UAZ);
        UAZ.setChecked(getConfig((String) UAZ.getText()));
        UAZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(UAZ.getText()), UAZ.isChecked());
            }
        });
        final CheckBox Trike = mFloatingView.findViewById(R.id.Trike);
        Trike.setChecked(getConfig((String) Trike.getText()));
        Trike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Trike.getText()), Trike.isChecked());
            }
        });
        final CheckBox Bike = mFloatingView.findViewById(R.id.Bike);
        Bike.setChecked(getConfig((String) Bike.getText()));
        Bike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bike.getText()), Bike.isChecked());
            }
        });
        final CheckBox Dacia = mFloatingView.findViewById(R.id.Dacia);
        Dacia.setChecked(getConfig((String) Dacia.getText()));
        Dacia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Dacia.getText()), Dacia.isChecked());
            }
        });
        final CheckBox Jet = mFloatingView.findViewById(R.id.Jet);
        Jet.setChecked(getConfig((String) Jet.getText()));
        Jet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Jet.getText()), Jet.isChecked());
            }
        });
        final CheckBox Boat = mFloatingView.findViewById(R.id.Boat);
        Boat.setChecked(getConfig((String) Boat.getText()));
        Boat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Boat.getText()), Boat.isChecked());
            }
        });
        final CheckBox Scooter = mFloatingView.findViewById(R.id.Scooter);
        Scooter.setChecked(getConfig((String) Scooter.getText()));
        Scooter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Scooter.getText()), Scooter.isChecked());
            }
        });
        final CheckBox Bus = mFloatingView.findViewById(R.id.Bus);
        Bus.setChecked(getConfig((String) Bus.getText()));
        Bus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bus.getText()), Bus.isChecked());
            }
        });
        final CheckBox Mirado = mFloatingView.findViewById(R.id.Mirado);
        Mirado.setChecked(getConfig((String) Mirado.getText()));
        Mirado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mirado.getText()), Mirado.isChecked());
            }
        });
        final CheckBox Rony = mFloatingView.findViewById(R.id.Rony);
        Rony.setChecked(getConfig((String) Rony.getText()));
        Rony.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Rony.getText()), Rony.isChecked());
            }
        });
        final CheckBox Snowbike = mFloatingView.findViewById(R.id.Snowbike);
        Snowbike.setChecked(getConfig((String) Snowbike.getText()));
        Snowbike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Snowbike.getText()), Snowbike.isChecked());
            }
        });
        final CheckBox Snowmobile = mFloatingView.findViewById(R.id.Snowmobile);
        Snowmobile.setChecked(getConfig((String) Snowmobile.getText()));
        Snowmobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Snowmobile.getText()), Snowmobile.isChecked());
            }
        });
        final CheckBox Tempo = mFloatingView.findViewById(R.id.Tempo);
        Tempo.setChecked(getConfig((String) Tempo.getText()));
        Tempo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Tempo.getText()), Tempo.isChecked());
            }
        });
        final CheckBox Truck = mFloatingView.findViewById(R.id.Truck);
        Truck.setChecked(getConfig((String) Truck.getText()));
        Truck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Truck.getText()), Truck.isChecked());
            }
        });
        final CheckBox MonsterTruck = mFloatingView.findViewById(R.id.MonsterTruck);
        MonsterTruck.setChecked(getConfig((String) MonsterTruck.getText()));
        MonsterTruck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(MonsterTruck.getText()), MonsterTruck.isChecked());
            }
        });
        final CheckBox BRDM = mFloatingView.findViewById(R.id.BRDM);
        BRDM.setChecked(getConfig((String) BRDM.getText()));
        BRDM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(BRDM.getText()), BRDM.isChecked());
            }
        });
        final CheckBox LadaNiva = mFloatingView.findViewById(R.id.LadaNiva);
        LadaNiva.setChecked(getConfig((String) LadaNiva.getText()));
        LadaNiva.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LadaNiva.getText()), LadaNiva.isChecked());
            }
        });
        final CheckBox CheekPad = mFloatingView.findViewById(R.id.CheekPad);
        CheekPad.setChecked(getConfig((String) CheekPad.getText()));
        CheekPad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(CheekPad.getText()), CheekPad.isChecked());
            }
        });
        final CheckBox AirDrop = mFloatingView.findViewById(R.id.AirDrop);
        AirDrop.setChecked(getConfig((String) AirDrop.getText()));
        AirDrop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AirDrop.getText()), AirDrop.isChecked());
            }
        });
        final CheckBox Crate = mFloatingView.findViewById(R.id.Crate);
        Crate.setChecked(getConfig((String) Crate.getText()));
        Crate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Crate.getText()), Crate.isChecked());
            }
        });
        final CheckBox DropPlane = mFloatingView.findViewById(R.id.DropPlane);
        DropPlane.setChecked(getConfig((String) DropPlane.getText()));
        DropPlane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DropPlane.getText()), DropPlane.isChecked());
            }
        });
        final CheckBox isEnemyWeapon = mFloatingView.findViewById(R.id.isEnemyWeapon);
        isEnemyWeapon.setChecked(getConfig((String) isEnemyWeapon.getText()));
        SettingValue(10,getConfig((String) isEnemyWeapon.getText()));
        isEnemyWeapon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isEnemyWeapon.getText()), isEnemyWeapon.isChecked());
                SettingValue(10,isEnemyWeapon.isChecked());
            }
        });
        final CheckBox isGrenadeWarning = mFloatingView.findViewById(R.id.isGrenadeWarning);
        isGrenadeWarning.setChecked(getConfig((String) isGrenadeWarning.getText()));
        SettingValue(9,getConfig((String) isGrenadeWarning.getText()));
        isGrenadeWarning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isGrenadeWarning.getText()), isGrenadeWarning.isChecked());
                SettingValue(9,isGrenadeWarning.isChecked());
            }
        });

        final CheckBox isSkelton = mFloatingView.findViewById(R.id.isSkelton);
        isSkelton.setChecked(getConfig((String) isSkelton.getText()));
        SettingValue(8,getConfig((String) isSkelton.getText()));
        isSkelton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isSkelton.getText()), isSkelton.isChecked());
                SettingValue(8,isSkelton.isChecked());
            }
        });


        final CheckBox isHead = mFloatingView.findViewById(R.id.isHead);
        isHead.setChecked(getConfig((String) isHead.getText()));
        SettingValue(6,getConfig((String) isHead.getText()));
        isHead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isHead.getText()), isHead.isChecked());
                SettingValue(6,isHead.isChecked());
            }
        });
        final CheckBox isBox = mFloatingView.findViewById(R.id.isBox);
        isBox.setChecked(getConfig((String) isBox.getText()));
        SettingValue(1,getConfig((String) isBox.getText()));
        isBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isBox.getText()), isBox.isChecked());
                SettingValue(1,isBox.isChecked());
            }
        });

        final CheckBox isLine = mFloatingView.findViewById(R.id.isLine);
        isLine.setChecked(getConfig((String) isLine.getText()));
        SettingValue(2,getConfig((String) isLine.getText()));
        isLine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isLine.getText()), isLine.isChecked());
                SettingValue(2,isLine.isChecked());
            }
        });
        final CheckBox isBack = mFloatingView.findViewById(R.id.isBack);
        isBack.setChecked(getConfig((String) isBack.getText()));
        SettingValue(7,getConfig((String) isBack.getText()));
        isBack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isBack.getText()), isBack.isChecked());
                SettingValue(7,isBack.isChecked());
            }
        });

        final CheckBox isHealth = mFloatingView.findViewById(R.id.isHealth);
        isHealth.setChecked(getConfig((String) isHealth.getText()));
        SettingValue(4,getConfig((String) isHealth.getText()));
        isHealth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isHealth.getText()), isHealth.isChecked());
                SettingValue(4,isHealth.isChecked());
            }
        });

        final CheckBox isName = mFloatingView.findViewById(R.id.isName);
        isName.setChecked(getConfig((String) isName.getText()));
        SettingValue(5,getConfig((String) isName.getText()));
        isName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isName.getText()), isName.isChecked());
                SettingValue(5,isName.isChecked());
            }
        });
        final CheckBox isDist = mFloatingView.findViewById(R.id.isDist);
        isDist.setChecked(getConfig((String) isDist.getText()));
        SettingValue(3,getConfig((String) isDist.getText()));
        isDist.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isDist.getText()), isDist.isChecked());
                SettingValue(3,isDist.isChecked());
            }
        });
        final Switch bullettrack = mFloatingView.findViewById(R.id.bullettrack);
        bullettrack.setChecked(getConfig((String) bullettrack.getText()));
        SettingValue(13,getConfig((String) bullettrack.getText()));
        bullettrack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(bullettrack.getText()), bullettrack.isChecked());
                SettingValue(13,bullettrack.isChecked());
            }
        });
        final Switch recoil = mFloatingView.findViewById(R.id.recoil);
        recoil.setChecked(getConfig((String) recoil.getText()));
        SettingValue(22,getConfig((String) recoil.getText()));
        recoil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(recoil.getText()), recoil.isChecked());
                SettingValue(22,recoil.isChecked());
            }
        });
        final Switch instanthit = mFloatingView.findViewById(R.id.instanthit);
        instanthit.setChecked(getConfig((String) instanthit.getText()));
        SettingValue(15,getConfig((String) instanthit.getText()));
        instanthit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(instanthit.getText()), instanthit.isChecked());
                SettingValue(15,instanthit.isChecked());
            }
        });
        final Switch crosshair = mFloatingView.findViewById(R.id.crosshair);
        crosshair.setChecked(getConfig((String) crosshair.getText()));
        SettingValue(16,getConfig((String) crosshair.getText()));
        crosshair.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(crosshair.getText()), crosshair.isChecked());
                SettingValue(16,crosshair.isChecked());
            }
        });


        final Switch aimknocked = mFloatingView.findViewById(R.id.aimknocked);
        aimknocked.setChecked(getConfig((String) aimknocked.getText()));
        SettingValue(17,getConfig((String) aimknocked.getText()));
        aimknocked.setOnCheckedChangeListener((buttonView, isChecked) -> {
            setValue(String.valueOf(aimknocked.getText()), aimknocked.isChecked());
            SettingValue(17,aimknocked.isChecked());
        });

        final Switch hitX = mFloatingView.findViewById(R.id.hitx);
        hitX.setChecked(getConfig((String) hitX.getText()));
        SettingValue(18,getConfig((String) hitX.getText()));
        hitX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(hitX.getText()), hitX.isChecked());
                SettingValue(18,hitX.isChecked());
            }
        });

        final Switch antiShake = mFloatingView.findViewById(R.id.antishake);
        antiShake.setChecked(getConfig((String) antiShake.getText()));
        SettingValue(19,getConfig((String) antiShake.getText()));
        antiShake.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(antiShake.getText()), antiShake.isChecked());
                SettingValue(19,antiShake.isChecked());
            }
        });

        final Switch noRecoil = mFloatingView.findViewById(R.id.norecoil);
        noRecoil.setChecked(getConfig((String) noRecoil.getText()));
        SettingValue(20,getConfig((String) noRecoil.getText()));
        noRecoil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(noRecoil.getText()), noRecoil.isChecked());
                SettingValue(20,noRecoil.isChecked());
            }
        });
        final Switch fastShootInterval = mFloatingView.findViewById(R.id.fastshootinterval);
        fastShootInterval.setChecked(getConfig((String) fastShootInterval.getText()));
        SettingValue(21,getConfig((String) fastShootInterval.getText()));
        fastShootInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(fastShootInterval.getText()), fastShootInterval.isChecked());
                SettingValue(21,fastShootInterval.isChecked());
            }
        });





        final CheckBox canted = mFloatingView.findViewById(R.id.canted);
        canted.setChecked(getConfig((String) canted.getText()));
        canted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(canted.getText()),canted.isChecked());
            }
        });

        final CheckBox reddot = mFloatingView.findViewById(R.id.reddot);
        reddot.setChecked(getConfig((String) reddot.getText()));
        reddot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(reddot.getText()),reddot.isChecked());
            }
        });

        final CheckBox hollow = mFloatingView.findViewById(R.id.hollow);
        hollow.setChecked(getConfig((String) hollow.getText()));
        hollow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(hollow.getText()),hollow.isChecked());
            }
        });

        final CheckBox twox = mFloatingView.findViewById(R.id.twox);
        twox.setChecked(getConfig((String) twox.getText()));
        twox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(twox.getText()),twox.isChecked());
            }
        });

        final CheckBox threex = mFloatingView.findViewById(R.id.threex);
        threex.setChecked(getConfig((String) threex.getText()));
        threex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(threex.getText()),threex.isChecked());
            }
        });

        final CheckBox fourx = mFloatingView.findViewById(R.id.fourx);
        fourx.setChecked(getConfig((String) fourx.getText()));
        fourx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(fourx.getText()),fourx.isChecked());
            }
        });

        final CheckBox sixx = mFloatingView.findViewById(R.id.sixx);
        sixx.setChecked(getConfig((String) sixx.getText()));
        sixx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(sixx.getText()),sixx.isChecked());
            }
        });

        final CheckBox eightx = mFloatingView.findViewById(R.id.eightx);
        eightx.setChecked(getConfig((String) eightx.getText()));
        eightx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(eightx.getText()),eightx.isChecked());
            }
        });

        final CheckBox AWM = mFloatingView.findViewById(R.id.AWM);
        AWM.setChecked(getConfig((String) AWM.getText()));
        AWM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AWM.getText()),AWM.isChecked());
            }
        });

        final CheckBox QBU = mFloatingView.findViewById(R.id.QBU);
        QBU.setChecked(getConfig((String) QBU.getText()));
        QBU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QBU.getText()),QBU.isChecked());
            }
        });

        final CheckBox SLR = mFloatingView.findViewById(R.id.SLR);
        SLR.setChecked(getConfig((String) SLR.getText()));
        SLR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SLR.getText()),SLR.isChecked());
            }
        });

        final CheckBox SKS = mFloatingView.findViewById(R.id.SKS);
        SKS.setChecked(getConfig((String) SKS.getText()));
        SKS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SKS.getText()),SKS.isChecked());
            }
        });

        final CheckBox Mini14 = mFloatingView.findViewById(R.id.Mini14);
        Mini14.setChecked(getConfig((String) Mini14.getText()));
        Mini14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mini14.getText()),Mini14.isChecked());
            }
        });

        final CheckBox M24 = mFloatingView.findViewById(R.id.M24);
        M24.setChecked(getConfig((String) M24.getText()));
        M24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M24.getText()),M24.isChecked());
            }
        });

        final CheckBox Kar98k = mFloatingView.findViewById(R.id.Kar98k);
        Kar98k.setChecked(getConfig((String) Kar98k.getText()));
        Kar98k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Kar98k.getText()),Kar98k.isChecked());
            }
        });

        final CheckBox VSS = mFloatingView.findViewById(R.id.VSS);
        VSS.setChecked(getConfig((String) VSS.getText()));
        VSS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(VSS.getText()),VSS.isChecked());
            }
        });

        final CheckBox Win94 = mFloatingView.findViewById(R.id.Win94);
        Win94.setChecked(getConfig((String) Win94.getText()));
        Win94.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Win94.getText()),Win94.isChecked());
            }
        });

        final CheckBox AUG = mFloatingView.findViewById(R.id.AUG);
        AUG.setChecked(getConfig((String) AUG.getText()));
        AUG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AUG.getText()),AUG.isChecked());
            }
        });

        final CheckBox M762 = mFloatingView.findViewById(R.id.M762);
        M762.setChecked(getConfig((String) M762.getText()));
        M762.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M762.getText()),M762.isChecked());
            }
        });

        final CheckBox SCARL = mFloatingView.findViewById(R.id.SCARL);
        SCARL.setChecked(getConfig((String) SCARL.getText()));
        SCARL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SCARL.getText()),SCARL.isChecked());
            }
        });

        final CheckBox M416 = mFloatingView.findViewById(R.id.M416);
        M416.setChecked(getConfig((String) M416.getText()));
        M416.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M416.getText()),M416.isChecked());
            }
        });

        final CheckBox M16A4 = mFloatingView.findViewById(R.id.M16A4);
        M16A4.setChecked(getConfig((String) M16A4.getText()));
        M16A4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M16A4.getText()),M16A4.isChecked());
            }
        });

        final CheckBox Mk47Mutant = mFloatingView.findViewById(R.id.Mk47Mutant);
        Mk47Mutant.setChecked(getConfig((String) Mk47Mutant.getText()));
        Mk47Mutant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mk47Mutant.getText()),Mk47Mutant.isChecked());
            }
        });

        final CheckBox G36C = mFloatingView.findViewById(R.id.G36C);
        G36C.setChecked(getConfig((String) G36C.getText()));
        G36C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(G36C.getText()),G36C.isChecked());
            }
        });

        final CheckBox QBZ = mFloatingView.findViewById(R.id.QBZ);
        QBZ.setChecked(getConfig((String) QBZ.getText()));
        QBZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QBZ.getText()),QBZ.isChecked());
            }
        });

        final CheckBox AKM = mFloatingView.findViewById(R.id.AKM);
        AKM.setChecked(getConfig((String) AKM.getText()));
        AKM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AKM.getText()),AKM.isChecked());
            }
        });

        final CheckBox Groza = mFloatingView.findViewById(R.id.Groza);
        Groza.setChecked(getConfig((String) Groza.getText()));
        Groza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Groza.getText()),Groza.isChecked());
            }
        });



        final CheckBox TommyGun = mFloatingView.findViewById(R.id.TommyGun);
        TommyGun.setChecked(getConfig((String) TommyGun.getText()));
        TommyGun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(TommyGun.getText()),TommyGun.isChecked());
            }
        });

        final CheckBox MP5K = mFloatingView.findViewById(R.id.MP5K);
        MP5K.setChecked(getConfig((String) MP5K.getText()));
        MP5K.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(MP5K.getText()),MP5K.isChecked());
            }
        });

        final CheckBox Vector = mFloatingView.findViewById(R.id.Vector);
        Vector.setChecked(getConfig((String) Vector.getText()));
        Vector.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vector.getText()),Vector.isChecked());
            }
        });

        final CheckBox Uzi = mFloatingView.findViewById(R.id.Uzi);
        Uzi.setChecked(getConfig((String) Uzi.getText()));
        Uzi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Uzi.getText()),Uzi.isChecked());
            }
        });


        final CheckBox Mk14 = mFloatingView.findViewById(R.id.Mk14);
        Mk14.setChecked(getConfig((String) Mk14.getText()));
        Mk14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mk14.getText()),Mk14.isChecked());
            }
        });

        final CheckBox sst = mFloatingView.findViewById(R.id.sst);
        sst.setChecked(getConfig((String) sst.getText()));
        sst.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(sst.getText()),sst.isChecked());
            }
        });

        final CheckBox ffACP = mFloatingView.findViewById(R.id.ffACP);
        ffACP.setChecked(getConfig((String) ffACP.getText()));
        ffACP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ffACP.getText()),ffACP.isChecked());
            }
        });

        final CheckBox ffs = mFloatingView.findViewById(R.id.ffs);
        ffs.setChecked(getConfig((String) ffs.getText()));
        ffs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ffs.getText()),ffs.isChecked());
            }
        });

        final CheckBox nmm = mFloatingView.findViewById(R.id.nmm);
        nmm.setChecked(getConfig((String) nmm.getText()));
        nmm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(nmm.getText()),nmm.isChecked());
            }
        });

        final CheckBox tzzMagnum = mFloatingView.findViewById(R.id.tzzMagnum);
        tzzMagnum.setChecked(getConfig((String) tzzMagnum.getText()));
        tzzMagnum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(tzzMagnum.getText()),tzzMagnum.isChecked());
            }
        });

        final CheckBox otGuage = mFloatingView.findViewById(R.id.otGuage);
        otGuage.setChecked(getConfig((String) otGuage.getText()));
        otGuage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(otGuage.getText()),otGuage.isChecked());
            }
        });

        final CheckBox Choke = mFloatingView.findViewById(R.id.Choke);
        Choke.setChecked(getConfig((String) Choke.getText()));
        Choke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Choke.getText()),Choke.isChecked());
            }
        });

        final CheckBox SniperCompensator = mFloatingView.findViewById(R.id.SniperCompensator);
        SniperCompensator.setChecked(getConfig((String) SniperCompensator.getText()));
        SniperCompensator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SniperCompensator.getText()),SniperCompensator.isChecked());
            }
        });

        final CheckBox DP28 = mFloatingView.findViewById(R.id.DP28);
        DP28.setChecked(getConfig((String) DP28.getText()));
        DP28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DP28.getText()),DP28.isChecked());
            }
        });

        final CheckBox M249 = mFloatingView.findViewById(R.id.M249);
        M249.setChecked(getConfig((String) M249.getText()));
        M249.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M249.getText()),M249.isChecked());
            }
        });

        final CheckBox Grenade = mFloatingView.findViewById(R.id.Grenade);
        Grenade.setChecked(getConfig((String) Grenade.getText()));
        Grenade.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Grenade.getText()),Grenade.isChecked());
            }
        });

        final CheckBox Smoke = mFloatingView.findViewById(R.id.Smoke);
        Smoke.setChecked(getConfig((String) Smoke.getText()));
        Smoke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Smoke.getText()),Smoke.isChecked());
            }
        });

        final CheckBox Molotov = mFloatingView.findViewById(R.id.Molotov);
        Molotov.setChecked(getConfig((String) Molotov.getText()));
        Molotov.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Molotov.getText()),Molotov.isChecked());
            }
        });

        final CheckBox Painkiller = mFloatingView.findViewById(R.id.Painkiller);
        Painkiller.setChecked(getConfig((String) Painkiller.getText()));
        Painkiller.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Painkiller.getText()),Painkiller.isChecked());
            }
        });

        final CheckBox Adrenaline = mFloatingView.findViewById(R.id.Adrenaline);
        Adrenaline.setChecked(getConfig((String) Adrenaline.getText()));
        Adrenaline.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Adrenaline.getText()),Adrenaline.isChecked());
            }
        });

        final CheckBox EnergyDrink = mFloatingView.findViewById(R.id.EnergyDrink);
        EnergyDrink.setChecked(getConfig((String) EnergyDrink.getText()));
        EnergyDrink.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(EnergyDrink.getText()),EnergyDrink.isChecked());
            }
        });

        final CheckBox FirstAidKit = mFloatingView.findViewById(R.id.FirstAidKit);
        FirstAidKit.setChecked(getConfig((String) FirstAidKit.getText()));
        FirstAidKit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FirstAidKit.getText()),FirstAidKit.isChecked());
            }
        });

        final CheckBox Bandage = mFloatingView.findViewById(R.id.Bandage);
        Bandage.setChecked(getConfig((String) Bandage.getText()));
        Bandage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bandage.getText()),Bandage.isChecked());
            }
        });

        final CheckBox Medkit = mFloatingView.findViewById(R.id.Medkit);
        Medkit.setChecked(getConfig((String) Medkit.getText()));
        Medkit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Medkit.getText()),Medkit.isChecked());
            }
        });

        final CheckBox FlareGun = mFloatingView.findViewById(R.id.FlareGun);
        FlareGun.setChecked(getConfig((String) FlareGun.getText()));
        FlareGun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlareGun.getText()),FlareGun.isChecked());
            }
        });

        final CheckBox GullieSuit = mFloatingView.findViewById(R.id.GullieSuit);
        GullieSuit.setChecked(getConfig((String) GullieSuit.getText()));
        GullieSuit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(GullieSuit.getText()),GullieSuit.isChecked());
            }
        });

        final CheckBox UMP = mFloatingView.findViewById(R.id.UMP);
        UMP.setChecked(getConfig((String) UMP.getText()));
        UMP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(UMP.getText()),UMP.isChecked());
            }
        });

        final CheckBox Bizon = mFloatingView.findViewById(R.id.Bizon);
        Bizon.setChecked(getConfig((String) Bizon.getText()));
        Bizon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bizon.getText()),Bizon.isChecked());
            }
        });

        final CheckBox CompensatorSMG = mFloatingView.findViewById(R.id.CompensatorSMG);
        CompensatorSMG.setChecked(getConfig((String) CompensatorSMG.getText()));
        CompensatorSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(CompensatorSMG.getText()),CompensatorSMG.isChecked());
            }
        });

        final CheckBox FlashHiderSMG = mFloatingView.findViewById(R.id.FlashHiderSMG);
        FlashHiderSMG.setChecked(getConfig((String) FlashHiderSMG.getText()));
        FlashHiderSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderSMG.getText()),FlashHiderSMG.isChecked());
            }
        });

        final CheckBox FlashHiderAr = mFloatingView.findViewById(R.id.FlashHiderAr);
        FlashHiderAr.setChecked(getConfig((String) FlashHiderAr.getText()));
        FlashHiderAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderAr.getText()),FlashHiderAr.isChecked());
            }
        });

        final CheckBox ArCompensator = mFloatingView.findViewById(R.id.ArCompensator);
        ArCompensator.setChecked(getConfig((String) ArCompensator.getText()));
        ArCompensator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ArCompensator.getText()),ArCompensator.isChecked());
            }
        });

        final CheckBox TacticalStock = mFloatingView.findViewById(R.id.TacticalStock);
        TacticalStock.setChecked(getConfig((String) TacticalStock.getText()));
        TacticalStock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(TacticalStock.getText()),TacticalStock.isChecked());
            }
        });

        final CheckBox Duckbill = mFloatingView.findViewById(R.id.Duckbill);
        Duckbill.setChecked(getConfig((String) Duckbill.getText()));
        Duckbill.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Duckbill.getText()),Duckbill.isChecked());
            }
        });

        final CheckBox FlashHiderSniper = mFloatingView.findViewById(R.id.FlashHiderSniper);
        FlashHiderSniper.setChecked(getConfig((String) FlashHiderSniper.getText()));
        FlashHiderSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderSniper.getText()),FlashHiderSniper.isChecked());
            }
        });

        final CheckBox SuppressorSMG = mFloatingView.findViewById(R.id.SuppressorSMG);
        SuppressorSMG.setChecked(getConfig((String) SuppressorSMG.getText()));
        SuppressorSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorSMG.getText()),SuppressorSMG.isChecked());
            }
        });

        final CheckBox HalfGrip = mFloatingView.findViewById(R.id.HalfGrip);
        HalfGrip.setChecked(getConfig((String) HalfGrip.getText()));
        HalfGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(HalfGrip.getText()),HalfGrip.isChecked());
            }
        });

        final CheckBox StockMicroUZI = mFloatingView.findViewById(R.id.StockMicroUZI);
        StockMicroUZI.setChecked(getConfig((String) StockMicroUZI.getText()));
        StockMicroUZI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(StockMicroUZI.getText()),StockMicroUZI.isChecked());
            }
        });

        final CheckBox SuppressorSniper = mFloatingView.findViewById(R.id.SuppressorSniper);
        SuppressorSniper.setChecked(getConfig((String) SuppressorSniper.getText()));
        SuppressorSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorSniper.getText()),SuppressorSniper.isChecked());
            }
        });

        final CheckBox SuppressorAr = mFloatingView.findViewById(R.id.SuppressorAr);
        SuppressorAr.setChecked(getConfig((String) SuppressorAr.getText()));
        SuppressorAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorAr.getText()),SuppressorAr.isChecked());
            }
        });

        final CheckBox ExQdSniper = mFloatingView.findViewById(R.id.ExQdSniper);
        ExQdSniper.setChecked(getConfig((String) ExQdSniper.getText()));
        ExQdSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdSniper.getText()),ExQdSniper.isChecked());
            }
        });

        final CheckBox QdSMG = mFloatingView.findViewById(R.id.QdSMG);
        QdSMG.setChecked(getConfig((String) QdSMG.getText()));
        QdSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdSMG.getText()),QdSMG.isChecked());
            }
        });

        final CheckBox ExSMG = mFloatingView.findViewById(R.id.ExSMG);
        ExSMG.setChecked(getConfig((String) ExSMG.getText()));
        ExSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExSMG.getText()),ExSMG.isChecked());
            }
        });

        final CheckBox QdSniper = mFloatingView.findViewById(R.id.QdSniper);
        QdSniper.setChecked(getConfig((String) QdSniper.getText()));
        QdSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdSniper.getText()),QdSniper.isChecked());
            }
        });

        final CheckBox ExSniper = mFloatingView.findViewById(R.id.ExSniper);
        ExSniper.setChecked(getConfig((String) ExSniper.getText()));
        ExSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExSniper.getText()),ExSniper.isChecked());
            }
        });

        final CheckBox ExAr = mFloatingView.findViewById(R.id.ExAr);
        ExAr.setChecked(getConfig((String) ExAr.getText()));
        ExAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExAr.getText()),ExAr.isChecked());
            }
        });

        final CheckBox ExQdAr = mFloatingView.findViewById(R.id.ExQdAr);
        ExQdAr.setChecked(getConfig((String) ExQdAr.getText()));
        ExQdAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdAr.getText()),ExQdAr.isChecked());
            }
        });

        final CheckBox QdAr = mFloatingView.findViewById(R.id.QdAr);
        QdAr.setChecked(getConfig((String) QdAr.getText()));
        QdAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdAr.getText()),QdAr.isChecked());
            }
        });

        final CheckBox ExQdSMG = mFloatingView.findViewById(R.id.ExQdSMG);
        ExQdSMG.setChecked(getConfig((String) ExQdSMG.getText()));
        ExQdSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdSMG.getText()),ExQdSMG.isChecked());
            }
        });

        final CheckBox QuiverCrossBow = mFloatingView.findViewById(R.id.QuiverCrossBow);
        QuiverCrossBow.setChecked(getConfig((String) QuiverCrossBow.getText()));
        QuiverCrossBow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QuiverCrossBow.getText()),QuiverCrossBow.isChecked());
            }
        });

        final CheckBox BulletLoop = mFloatingView.findViewById(R.id.BulletLoop);
        BulletLoop.setChecked(getConfig((String) BulletLoop.getText()));
        BulletLoop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(BulletLoop.getText()),BulletLoop.isChecked());
            }
        });

        final CheckBox ThumbGrip = mFloatingView.findViewById(R.id.ThumbGrip);
        ThumbGrip.setChecked(getConfig((String) ThumbGrip.getText()));
        ThumbGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ThumbGrip.getText()),ThumbGrip.isChecked());
            }
        });

        final CheckBox LaserSight = mFloatingView.findViewById(R.id.LaserSight);
        LaserSight.setChecked(getConfig((String) LaserSight.getText()));
        LaserSight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LaserSight.getText()),LaserSight.isChecked());
            }
        });

        final CheckBox AngledGrip = mFloatingView.findViewById(R.id.AngledGrip);
        AngledGrip.setChecked(getConfig((String) AngledGrip.getText()));
        AngledGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AngledGrip.getText()),AngledGrip.isChecked());
            }
        });

        final CheckBox LightGrip = mFloatingView.findViewById(R.id.LightGrip);
        LightGrip.setChecked(getConfig((String) LightGrip.getText()));
        LightGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LightGrip.getText()),LightGrip.isChecked());
            }
        });

        final CheckBox VerticalGrip = mFloatingView.findViewById(R.id.VerticalGrip);
        VerticalGrip.setChecked(getConfig((String) VerticalGrip.getText()));
        VerticalGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(VerticalGrip.getText()),VerticalGrip.isChecked());
            }
        });

        final CheckBox GasCan = mFloatingView.findViewById(R.id.GasCan);
        GasCan.setChecked(getConfig((String) GasCan.getText()));
        GasCan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(GasCan.getText()),GasCan.isChecked());
            }
        });





        final CheckBox Baglvl1 = mFloatingView.findViewById(R.id.Baglvl1);
        Baglvl1.setChecked(getConfig((String) Baglvl1.getText()));
        Baglvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl1.getText()),Baglvl1.isChecked());
            }
        });

        final CheckBox Baglvl2 = mFloatingView.findViewById(R.id.Baglvl2);
        Baglvl2.setChecked(getConfig((String) Baglvl2.getText()));
        Baglvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl2.getText()),Baglvl2.isChecked());
            }
        });

        final CheckBox Baglvl3 = mFloatingView.findViewById(R.id.Baglvl3);
        Baglvl3.setChecked(getConfig((String) Baglvl3.getText()));
        Baglvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl3.getText()),Baglvl3.isChecked());
            }
        });

        final CheckBox Helmetlvl1 = mFloatingView.findViewById(R.id.Helmetlvl1);
        Helmetlvl1.setChecked(getConfig((String) Helmetlvl1.getText()));
        Helmetlvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl1.getText()),Helmetlvl1.isChecked());
            }
        });

        final CheckBox Helmetlvl2 = mFloatingView.findViewById(R.id.Helmetlvl2);
        Helmetlvl2.setChecked(getConfig((String) Helmetlvl2.getText()));
        Helmetlvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl2.getText()),Helmetlvl2.isChecked());
            }
        });

        final CheckBox Helmetlvl3 = mFloatingView.findViewById(R.id.Helmetlvl3);
        Helmetlvl3.setChecked(getConfig((String) Helmetlvl3.getText()));
        Helmetlvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl3.getText()),Helmetlvl3.isChecked());
            }
        });

        final CheckBox Vestlvl1 = mFloatingView.findViewById(R.id.Vestlvl1);
        Vestlvl1.setChecked(getConfig((String) Vestlvl1.getText()));
        Vestlvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl1.getText()),Vestlvl1.isChecked());
            }
        });

        final CheckBox Vestlvl2 = mFloatingView.findViewById(R.id.Vestlvl2);
        Vestlvl2.setChecked(getConfig((String) Vestlvl2.getText()));
        Vestlvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl2.getText()),Vestlvl2.isChecked());
            }
        });

        final CheckBox Vestlvl3 = mFloatingView.findViewById(R.id.Vestlvl3);
        Vestlvl3.setChecked(getConfig((String) Vestlvl3.getText()));
        Vestlvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl3.getText()),Vestlvl3.isChecked());
            }
        });

// FOV aimbot
        final SeekBar range = mFloatingView.findViewById(R.id.range);
        range.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Range(range.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final RadioGroup aimby=mFloatingView.findViewById(R.id.aimby);
        aimby.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int chkdId=aimby.getCheckedRadioButtonId();
                RadioButton btn=mFloatingView.findViewById(chkdId);
                AimBy(Integer.parseInt(btn.getTag().toString()));
            }
        });

        final RadioGroup aimwhen=mFloatingView.findViewById(R.id.aimwhen);
        aimwhen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int chkdId=aimwhen.getCheckedRadioButtonId();
                RadioButton btn=mFloatingView.findViewById(chkdId);
                AimWhen(Integer.parseInt(btn.getTag().toString()));
            }
        });
        final RadioGroup aimbotmode=mFloatingView.findViewById(R.id.aimbotmode);
        aimbotmode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int chkdId=aimbotmode.getCheckedRadioButtonId();
                RadioButton btn=mFloatingView.findViewById(chkdId);
                Target(Integer.parseInt(btn.getTag().toString()));
            }
        });

//        final Switch aimbot = mFloatingView.findViewById(R.id.aimbot);
//        aimbot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b) {
//                    aimoff.setVisibility(View.VISIBLE);
//                }
//                else {
//                    aimoff.setVisibility(View.GONE);
//                    aimon.setVisibility(View.GONE);
//                }
//            }
//        });





        //Text Position













    }
    public static boolean isRootAvailable(){
        for(String pathDir : System.getenv("PATH").split(":")){
            if(new File(pathDir, "su").exists()) {
                return true;
            }
        }
        return false;
    }
    private void sh(String cmd) {
        for(String pathDir : System.getenv("PATH").split(":")) {
            if (new File(pathDir, "su").exists()) {
                try {
                    Runtime.getRuntime().exec("su -c "+cmd);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{ try {
                Runtime.getRuntime().exec(cmd);
            } catch (IOException e) {
                e.printStackTrace();
            }}
        }
    }
    class ExampleRunnableop implements Runnable{
        int i;
        ExampleRunnableop(int i){
            this.i =i;
        }
        @Override
        public void run() {
            for(String pathDir : System.getenv("PATH").split(":")) {
                if (isRootAvailable()) {
                    try {
                        Runtime.getRuntime().exec("su -c "+MainActivity.internal+"/"+ FloatLogo.kklj+" "+i);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else{ try {
                    Runtime.getRuntime().exec(MainActivity.internal+"/"+ FloatLogo.kklj+" "+i);
                } catch (IOException e) {
                    e.printStackTrace();
                }}
            }
        }

    }

    class clearc implements Runnable{

        clearc(){

        }

        public void lib(String name){
            sh("./"+getFilesDir()+"/sock 1 " + pval +" "+MainActivity6.gameType);
        }
        @Override
        public void run() {
            lib(packck);
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
    public void shellx(String i){

        for(String pathDir : System.getenv("PATH").split(":")) {
            if (new File(pathDir, "su").exists()) {
                try {
                    String line;

                    OutputStream stdin = MainActivity.xsr.getOutputStream();
                    InputStream stderr = MainActivity.xsr.getErrorStream();
                    InputStream stdout = MainActivity.xsr.getInputStream();
                    sh("su -c chmod 777 "+MainActivity.internal+"/"+i);
                    stdin.write((MainActivity.internal+"/"+i).getBytes());
                    stdin.write("exit\n".getBytes());
                    stdin.flush();
                    stdin.close();
                    BufferedReader br =
                            new BufferedReader(new InputStreamReader(stdout));
                    while ((line = br.readLine()) != null) {
                        Log.d("[Output]", line);
                    }
                    br.close();
                    br =
                            new BufferedReader(new InputStreamReader(stderr));
                    while ((line = br.readLine()) != null) {
                        Log.e("[Error]", line);
                    }
                    br.close();
                    MainActivity.xsr.waitFor();
                    MainActivity.xsr.destroy();

                } catch (Exception ex) {
                }
            } else {
                sh("chmod 777 "+MainActivity.internal+"/"+i);
                sh(MainActivity.internal+"/"+i);

            }
        }
    }
    private void finishAffinity() {
    }


    public native void SettingValue(int setting_code,boolean value);
    public native void Range(int range);
    public native void Target(int target);
    public native void AimBy(int aimby);
    public native void AimWhen(int aimwhen);

}
class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return true;
    }



}

