package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/n.class */
public class n {
    private static n e;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private File f38970c = null;

    /* renamed from: a  reason: collision with root package name */
    public boolean f38969a = false;
    private boolean d = false;
    private File f = null;

    private n(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
        b();
    }

    public static n a() {
        n nVar;
        synchronized (n.class) {
            try {
                nVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    public static n a(Context context) {
        n nVar;
        synchronized (n.class) {
            try {
                if (e == null) {
                    e = new n(context);
                }
                nVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    private File d() {
        try {
            if (this.f38970c == null) {
                File file = new File(QbSdk.getTbsFolderDir(this.b), "core_private");
                this.f38970c = file;
                if (file == null || !file.isDirectory()) {
                    return null;
                }
            }
            File file2 = new File(this.f38970c, "debug.conf");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a(boolean z) {
        this.d = z;
        c();
    }

    public void b() {
        synchronized (this) {
            BufferedInputStream bufferedInputStream = null;
            try {
                if (this.f == null) {
                    this.f = d();
                }
            } catch (Throwable th) {
                th = th;
            }
            if (this.f == null) {
                return;
            }
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(this.f));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                String property = properties.getProperty("setting_forceUseSystemWebview", "");
                if (!"".equals(property)) {
                    this.f38969a = Boolean.parseBoolean(property);
                }
            } catch (Throwable th2) {
                bufferedInputStream = bufferedInputStream2;
                th = th2;
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                }
            }
            try {
                bufferedInputStream2.close();
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
            }
        }
    }

    public void c() {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Properties properties;
        try {
            try {
                File d = d();
                if (d == null) {
                    try {
                        throw new NullPointerException();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            throw new NullPointerException();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(d));
                try {
                    properties = new Properties();
                    properties.load(bufferedInputStream);
                    properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.f38969a));
                    properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.d));
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(d));
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = null;
                }
                try {
                    properties.store(bufferedOutputStream, (String) null);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    bufferedOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        bufferedOutputStream.close();
                    } catch (Throwable th3) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                bufferedOutputStream = null;
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }
}
