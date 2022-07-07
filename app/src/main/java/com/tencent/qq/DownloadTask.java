package com.tencent.qq;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.PowerManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import static com.tencent.qq.MainActivity.mProgressDialog;
import static com.tencent.qq.MainActivity.gv;
import static com.tencent.qq.MainActivity.kv;

public class DownloadTask extends AsyncTask<String, Integer, String> {

    private Context context;
    private PowerManager.WakeLock mWakeLock;

    public DownloadTask(Context context) {
        this.context = context;
    }
    public static int resp;
    @Override
    protected String doInBackground(String... sUrl) {
        InputStream input = null;
        OutputStream output = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(sUrl[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            // expect HTTP 200 OK, so we don't mistakenly save error report
            // instead of the file
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return "Server returned HTTP " + connection.getResponseCode()
                        + " " + connection.getResponseMessage();
            }

            // this will be useful to display download percentage
            // might be -1: server did not report the length
            int fileLength = connection.getContentLength();

            // download the file
            input = connection.getInputStream();

            if (MainActivity.gxi == 1) {
                output = new FileOutputStream(MainActivity.internal+"/libctr.so");
            }
            if (MainActivity.gxi == 2) {
                output = new FileOutputStream(MainActivity.internal+"/libnative.so");
            }
            if (MainActivity.gxi == 3) {
                output = new FileOutputStream(MainActivity.internal+"/lib_n_ctr.so");
            }
            if (MainActivity.gxi == 4) {
                output = new FileOutputStream(MainActivity.internal+"/libcurl.so");

            }
            if (MainActivity.gxi == 5) {
                output = new FileOutputStream(MainActivity.internal+"/sock");

            }
            if (MainActivity.gxi == 6) {
                output = new FileOutputStream(MainActivity.internal+"/libvien.so");

            }
            if (MainActivity.gxi == 7) {
                output = new FileOutputStream(MainActivity.internal+"/libtien.so");

            }
            if (MainActivity.gxi == 8) {
                output = new FileOutputStream(MainActivity.internal+"/libcgien.so");

            }
            if (MainActivity.gxi == 9) {
                output = new FileOutputStream(MainActivity.internal+"/libbgmi.so");

            }


            byte data[] = new byte[4096];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                // allow canceling with back button
                if (isCancelled()) {
                    input.close();
                    return null;
                }
                total += count;
                // publishing the progress....
                if (fileLength > 0) // only if total length is known
                    publishProgress((int) (total * 100 / fileLength));
                output.write(data, 0, count);
            }
        } catch (Exception e) {
            return e.toString();
        } finally {
            try {
                if (output != null)
                    output.close();
                if (input != null)
                    input.close();
            } catch (IOException ignored) {
            }

            if (connection != null)
                connection.disconnect();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // take CPU lock to prevent CPU from going off if the user
        // presses the power button during download
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                getClass().getName());
        mWakeLock.acquire();
        mProgressDialog.show();
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        // if we get here, length is known, now set indeterminate to false
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setMax(100);
        mProgressDialog.setProgress(progress[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        mWakeLock.release();
        mProgressDialog.dismiss();
        if (result != null)
            resp =0;
        else
            if (MainActivity.gxi==1){MainActivity.b0.setText("UPDATED");
                try{
                    FileWriter fw=new FileWriter(MainActivity.lug);
                    fw.write(gv);
                    fw.close();
                }catch(Exception e){System.out.println(e);}

                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(MainActivity.internal+"/libctr.so");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(MainActivity.internal+"/libctr.soxx");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String lks = MainActivity.xtx;
                String lkz = lks.replaceAll("126", "");
                String lok = "Mx" + lkz + "x";

                SecretKeySpec sks = new SecretKeySpec(lok.getBytes(), "AES");
                Cipher cipher = null;
                try {
                    cipher = Cipher.getInstance("AES");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                }
                try {
                    cipher.init(Cipher.DECRYPT_MODE, sks);
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                }
                CipherInputStream cis = new CipherInputStream(fis, cipher);
                int b = 0;
                byte[] d = new byte[8];
                while (true) {
                    try {
                        if (!((b = cis.read(d)) != -1)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fos.write(d, 0, b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    cis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MainActivity.insgl.setText("Installed version: "+gv);
            }
            if (MainActivity.gxi==5){
                sh("su -c chmod 777 /data/data/com.tencent.qq/files/sock");
                sh("su -c ./data/data/com.tencent.qq/files/sock 2 " + "23" +" "+MainActivity6.gameType);
            }
            if (MainActivity.gxi==2){MainActivity.b1.setText("UPDATED");
                try{
                    FileWriter fw=new FileWriter(MainActivity.luk);
                    fw.write(MainActivity.kv);
                    fw.close();
                }catch(Exception e){System.out.println(e);}
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(MainActivity.internal+"/libnative.so");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(MainActivity.internal+"/libnative.soxx");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String lks = MainActivity.xtx;
                String lkz = lks.replaceAll("126", "");
                String lok = "Mx" + lkz + "x";

                SecretKeySpec sks = new SecretKeySpec(lok.getBytes(), "AES");
                Cipher cipher = null;
                try {
                    cipher = Cipher.getInstance("AES");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                }
                try {
                    cipher.init(Cipher.DECRYPT_MODE, sks);
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                }
                CipherInputStream cis = new CipherInputStream(fis, cipher);
                int b = 0;
                byte[] d = new byte[8];
                while (true) {
                    try {
                        if (!((b = cis.read(d)) != -1)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fos.write(d, 0, b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    cis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MainActivity.inskr.setText("Installed version: "+MainActivity.kv);
            }
            if (MainActivity.gxi==3){MainActivity.b2.setText("UPDATED");
                try{
                    FileWriter fw=new FileWriter(MainActivity.lul);
                    fw.write(MainActivity.lv);
                    fw.close();
                }catch(Exception e){System.out.println(e);}
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(MainActivity.internal+"/lib_n_ctr.so");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(MainActivity.internal+"/lib_n_ctr.soxx");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String lks = MainActivity.xtx;
                String lkz = lks.replaceAll("126", "");
                String lok = "Mx" + lkz + "x";

                SecretKeySpec sks = new SecretKeySpec(lok.getBytes(), "AES");
                Cipher cipher = null;
                try {
                    cipher = Cipher.getInstance("AES");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                }
                try {
                    cipher.init(Cipher.DECRYPT_MODE, sks);
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                }
                CipherInputStream cis = new CipherInputStream(fis, cipher);
                int b = 0;
                byte[] d = new byte[8];
                while (true) {
                    try {
                        if (!((b = cis.read(d)) != -1)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fos.write(d, 0, b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    cis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MainActivity.insl.setText("Installed version: "+MainActivity.lv);
            }
            if (MainActivity.gxi==4){MainActivity.b3.setText("UPDATED");
                try{
                    FileWriter fw=new FileWriter(MainActivity.luc);
                    fw.write(MainActivity.cv);
                    fw.close();
                }catch(Exception e){System.out.println(e);}
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(MainActivity.internal+"/libcurl.so");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(MainActivity.internal+"/libcurl.soxx");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String lks = MainActivity.xtx;
                String lkz = lks.replaceAll("126", "");
                String lok = "Mx" + lkz + "x";

                SecretKeySpec sks = new SecretKeySpec(lok.getBytes(), "AES");
                Cipher cipher = null;
                try {
                    cipher = Cipher.getInstance("AES");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                }
                try {
                    cipher.init(Cipher.DECRYPT_MODE, sks);
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                }
                CipherInputStream cis = new CipherInputStream(fis, cipher);
                int b = 0;
                byte[] d = new byte[8];
                while (true) {
                    try {
                        if (!((b = cis.read(d)) != -1)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fos.write(d, 0, b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    cis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MainActivity.insc.setText("Installed version: "+MainActivity.cv);
            }
    /*    if (MainActivity.gxi==5){
            try{
                FileWriter fw=new FileWriter(MainActivity.luc);
                fw.write(MainActivity.cv);
                fw.close();
            }catch(Exception e){System.out.println(e);}
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(MainActivity.internal+"/sockstar");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(MainActivity.internal+"/sock");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String lks = MainActivity.xtx;
            String lkz = lks.replaceAll("126", "");
            String lok = "Mx" + lkz + "x";

            SecretKeySpec sks = new SecretKeySpec(lok.getBytes(), "AES");
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("AES");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            }
            try {
                cipher.init(Cipher.DECRYPT_MODE, sks);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
            CipherInputStream cis = new CipherInputStream(fis, cipher);
            int b = 0;
            byte[] d = new byte[8];
            while (true) {
                try {
                    if (!((b = cis.read(d)) != -1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.write(d, 0, b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                cis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
*/
        if (MainActivity.gxi==6){MainActivity.b4.setText("UPDATED");
            try{
                FileWriter fw=new FileWriter(MainActivity.luv);
                fw.write(MainActivity.vv);
                fw.close();
            }catch(Exception e){System.out.println(e);}
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(MainActivity.internal+"/libvien.so");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(MainActivity.internal+"/libvien.soxx");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String lks = MainActivity.xtx;
            String lkz = lks.replaceAll("126", "");
            String lok = "Mx" + lkz + "x";

            SecretKeySpec sks = new SecretKeySpec(lok.getBytes(), "AES");
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("AES");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            }
            try {
                cipher.init(Cipher.DECRYPT_MODE, sks);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
            CipherInputStream cis = new CipherInputStream(fis, cipher);
            int b = 0;
            byte[] d = new byte[8];
            while (true) {
                try {
                    if (!((b = cis.read(d)) != -1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.write(d, 0, b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                cis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            MainActivity.insv.setText("Installed version: "+MainActivity.vv);
        }

        if (MainActivity.gxi==7){MainActivity.b5.setText("UPDATED");
            try{
                FileWriter fw=new FileWriter(MainActivity.lut);
                fw.write(MainActivity.tv);
                fw.close();
            }catch(Exception e){System.out.println(e);}
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(MainActivity.internal+"/libtien.so");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(MainActivity.internal+"/libtien.soxx");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String lks = MainActivity.xtx;
            String lkz = lks.replaceAll("126", "");
            String lok = "Mx" + lkz + "x";

            SecretKeySpec sks = new SecretKeySpec(lok.getBytes(), "AES");
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("AES");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            }
            try {
                cipher.init(Cipher.DECRYPT_MODE, sks);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
            CipherInputStream cis = new CipherInputStream(fis, cipher);
            int b = 0;
            byte[] d = new byte[8];
            while (true) {
                try {
                    if (!((b = cis.read(d)) != -1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.write(d, 0, b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                cis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            MainActivity.inst.setText("Installed version: "+MainActivity.tv);
        }
        if (MainActivity.gxi==8){MainActivity.b6.setText("UPDATED");
            try{
                FileWriter fw=new FileWriter(MainActivity.lucg);
                fw.write(MainActivity.cgv);
                fw.close();
            }catch(Exception e){System.out.println(e);}
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(MainActivity.internal+"/libcgien.so");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(MainActivity.internal+"/libcgien.soxx");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String lks = MainActivity.xtx;
            String lkz = lks.replaceAll("126", "");
            String lok = "Mx" + lkz + "x";

            SecretKeySpec sks = new SecretKeySpec(lok.getBytes(), "AES");
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("AES");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            }
            try {
                cipher.init(Cipher.DECRYPT_MODE, sks);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
            CipherInputStream cis = new CipherInputStream(fis, cipher);
            int b = 0;
            byte[] d = new byte[8];
            while (true) {
                try {
                    if (!((b = cis.read(d)) != -1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.write(d, 0, b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                cis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            MainActivity.inscg.setText("Installed version: "+MainActivity.cgv);
        }
        if (MainActivity.gxi==9){MainActivity.b7.setText("UPDATED");
            try{
                FileWriter fw=new FileWriter(MainActivity.lub);
                fw.write(MainActivity.bv);
                fw.close();
            }catch(Exception e){System.out.println(e);}
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(MainActivity.internal+"/libbgmi.so");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(MainActivity.internal+"/libbgmi.soxx");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String lks = MainActivity.xtx;
            String lkz = lks.replaceAll("126", "");
            String lok = "Mx" + lkz + "x";

            SecretKeySpec sks = new SecretKeySpec(lok.getBytes(), "AES");
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("AES");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            }
            try {
                cipher.init(Cipher.DECRYPT_MODE, sks);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
            CipherInputStream cis = new CipherInputStream(fis, cipher);
            int b = 0;
            byte[] d = new byte[8];
            while (true) {
                try {
                    if (!((b = cis.read(d)) != -1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.write(d, 0, b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                cis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            MainActivity.insb.setText("Installed version: "+MainActivity.bv);
        }
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

}