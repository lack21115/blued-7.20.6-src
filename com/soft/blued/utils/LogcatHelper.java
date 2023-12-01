package com.soft.blued.utils;

import android.util.Log;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/LogcatHelper.class */
public class LogcatHelper {

    /* renamed from: a  reason: collision with root package name */
    private static LogcatHelper f34745a;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/LogcatHelper$LogDumper.class */
    class LogDumper extends Thread {

        /* renamed from: a  reason: collision with root package name */
        String f34746a;
        private Process b;

        /* renamed from: c  reason: collision with root package name */
        private BufferedReader f34747c;
        private boolean d;
        private String e;
        private FileOutputStream f;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            String readLine;
            try {
                try {
                    this.b = Runtime.getRuntime().exec(this.f34746a);
                    Log.v("pk", "logcatProc:" + this.b.toString());
                    this.f34747c = new BufferedReader(new InputStreamReader(this.b.getInputStream()), 1024);
                    while (this.d && (readLine = this.f34747c.readLine()) != null && this.d) {
                        if (readLine.length() != 0 && this.f != null && readLine.contains(this.e)) {
                            FileOutputStream fileOutputStream2 = this.f;
                            fileOutputStream2.write((LogcatHelper.a() + "  " + readLine + "\n").getBytes());
                        }
                    }
                    Process process = this.b;
                    if (process != null) {
                        process.destroy();
                        this.b = null;
                    }
                    BufferedReader bufferedReader = this.f34747c;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            this.f34747c = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    fileOutputStream = this.f;
                } catch (Throwable th) {
                    Process process2 = this.b;
                    if (process2 != null) {
                        process2.destroy();
                        this.b = null;
                    }
                    BufferedReader bufferedReader2 = this.f34747c;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            this.f34747c = null;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    FileOutputStream fileOutputStream3 = this.f;
                    if (fileOutputStream3 != null) {
                        try {
                            fileOutputStream3.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        this.f = null;
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                Process process3 = this.b;
                if (process3 != null) {
                    process3.destroy();
                    this.b = null;
                }
                BufferedReader bufferedReader3 = this.f34747c;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        this.f34747c = null;
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                FileOutputStream fileOutputStream4 = this.f;
                if (fileOutputStream4 == null) {
                    return;
                }
                try {
                    fileOutputStream4.close();
                } catch (IOException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.f = null;
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.f = null;
                }
                this.f = null;
            }
        }
    }

    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date(System.currentTimeMillis()));
    }
}
