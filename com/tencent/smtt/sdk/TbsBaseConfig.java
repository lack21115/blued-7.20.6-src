package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsBaseConfig.class */
public abstract class TbsBaseConfig {
    public static final String TAG = "TbsBaseConfig";

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f25065a;
    private Context b;

    private static File a(Context context, String str) {
        o.a();
        File s = o.s(context);
        if (s == null) {
            return null;
        }
        File file = new File(s, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clear() {
        this.f25065a.clear();
        commit();
    }

    public void commit() {
        synchronized (this) {
            writeTbsDownloadInfo();
        }
    }

    public abstract String getConfigFileName();

    public void init(Context context) {
        this.f25065a = new HashMap();
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        if (applicationContext == null) {
            this.b = context;
        }
        refreshSyncMap(context);
    }

    public void refreshSyncMap(Context context) {
        BufferedInputStream bufferedInputStream;
        File a2;
        synchronized (this) {
            try {
                a2 = a(this.b, getConfigFileName());
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
            if (a2 == null) {
                return;
            }
            this.f25065a.clear();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(a2));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                for (String str : properties.stringPropertyNames()) {
                    this.f25065a.put(str, properties.getProperty(str));
                }
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                }
            }
            try {
                bufferedInputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        }
    }

    public void writeTbsDownloadInfo() {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        File a2;
        Properties properties;
        synchronized (this) {
            TbsLog.i(TAG, "writeTbsDownloadInfo #1");
            try {
                a2 = a(this.b, getConfigFileName());
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
            if (a2 == null) {
                return;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(a2));
            try {
                properties = new Properties();
                properties.load(bufferedInputStream);
                properties.clear();
                for (String str : this.f25065a.keySet()) {
                    String str2 = this.f25065a.get(str);
                    properties.setProperty(str, "" + ((Object) str2));
                    TbsLog.i(TAG, "writeTbsDownloadInfo key is " + str + " value is " + ((Object) str2));
                }
                this.f25065a.clear();
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a2));
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
            try {
                properties.store(bufferedOutputStream, (String) null);
                try {
                    bufferedInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    bufferedOutputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
