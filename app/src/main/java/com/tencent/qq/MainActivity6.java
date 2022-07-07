package com.tencent.qq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.tencent.qq.MainActivity.*;

public class MainActivity6 extends AppCompatActivity {
    public static int verx = 0;
    public static RadioButton global;
    public static RadioButton korean;
    public static RadioButton lite;
    public static RadioButton call;
    public static RadioButton bgmi;
    public static int gameType=1;
private String xs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow();
        requestWindowFeature(1);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main7);
        this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.mg)));

        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.mg));

        }

         global = findViewById(R.id.radioButton);
         korean = findViewById(R.id.radioButton2);
         lite = findViewById(R.id.radioButton5);
         call = findViewById(R.id.radioButton6);
         bgmi = findViewById(R.id.radioButton11);

if (verx ==1 ){global.setChecked(true);}else {
    if (verx == 2) {
        korean.setChecked(true);
    } else {
        if (verx == 3) {
            lite.setChecked(true);
        } else {
            if (verx == 4) {
                call.setChecked(true);
            } else {
                if (verx == 8) {
                    bgmi.setChecked(true);
                } else {
                    if (vercd == 1) {
                        global.setChecked(true);
                    } else {
                        if (vercd == 2) {
                            korean.setChecked(true);
                        } else {
                            if (vercd == 3) {
                                lite.setChecked(true);
                            } else {
                                if (vercd == 4) {
                                    call.setChecked(true);
                                } else {
                                    if (vercd == 8) {
                                        bgmi.setChecked(true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


        bgmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verx = 8;
                write(".xmc","8");
                gameName = "com.pubg.imobile";
                gameType = 5;

            }
        });

        global.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               verx = 1;
               write(".xmc","1");
                gameType=1;

            }
        });

        korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameType=2;
                verx = 2;
            }
        });
        lite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write(".xmc","3");
                verx = 3;
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write(".xmc","4");
                verx = 4;
            }
        });
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
}