package com.blued.android.module.external_sense_library.utils;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/AppLogger.class */
public class AppLogger {

    /* renamed from: a  reason: collision with root package name */
    private static String f11308a;
    private static AppLogger b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f11309c;
    private File d;
    private Writer e;
    private int f = 0;
    private final int g = 20;

    private AppLogger() {
        f11308a = Environment.getExternalStorageDirectory().getPath();
        if (this.f11309c == null) {
            this.f11309c = new Handler(ThreadHandlerManager.a().b().getLooper()) { // from class: com.blued.android.module.external_sense_library.utils.AppLogger.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    String format = String.format("%s %s  %s", TimeUtil.a(), "sense_log", message.obj);
                    AppLogger.this.b(format);
                    AppLogger.this.a(format);
                }
            };
        }
        c();
    }

    public static AppLogger a() {
        if (b == null) {
            synchronized (AppLogger.class) {
                try {
                    if (b == null) {
                        b = new AppLogger();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private String a(int i) {
        return "external_sense_" + i + ".txt";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        int length = str.length();
        if (length <= 4000) {
            com.blued.android.framework.utils.LogUtils.a("sense_log", str);
            return;
        }
        int i = length / 2000;
        int i2 = length % 2000 == 0 ? 0 : 1;
        int i3 = 0;
        int i4 = 1;
        while (i3 < length) {
            int i5 = i3 + 2000;
            if (i5 >= length) {
                i5 = length;
            }
            Log.v("sense_log", String.format("[%d/%d] %s", Integer.valueOf(i4), Integer.valueOf(i + i2), str.substring(i3, i5)));
            i4++;
            i3 = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.f++;
        Writer writer = this.e;
        if (writer != null) {
            try {
                writer.write(str);
                this.e.write(IOUtils.LINE_SEPARATOR_WINDOWS);
                if (this.f >= 20) {
                    this.e.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.f < 20 || this.d.length() < 10485760) {
            return;
        }
        this.f = 0;
        d();
    }

    private void c() {
        d();
    }

    private void d() {
        this.f11309c.post(new Runnable() { // from class: com.blued.android.module.external_sense_library.utils.AppLogger.2
            @Override // java.lang.Runnable
            public void run() {
                AppLogger.this.e();
                AppLogger.this.d = new File(AppLogger.f11308a, "external_sense.txt");
                try {
                    if (!AppLogger.this.d.exists()) {
                        AppLogger.this.d.createNewFile();
                    }
                    AppLogger.this.e = new BufferedWriter(new FileWriter(AppLogger.this.d, true));
                } catch (IOException e) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        File file = new File(f11308a, "external_sense.txt");
        if (!file.exists() || file.length() < 10485760) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 6) {
                return;
            }
            File file2 = new File(f11308a, a(i2));
            if (!file2.exists()) {
                f();
                file.renameTo(file2);
                return;
            }
            if (i2 == 6) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 <= 6) {
                        File file3 = new File(f11308a, a(i4));
                        if (file3.exists()) {
                            file3.delete();
                            if (i4 == 0) {
                                f();
                                file.renameTo(file3);
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private void f() {
        Writer writer = this.e;
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = str;
        this.f11309c.sendMessage(obtain);
    }
}
