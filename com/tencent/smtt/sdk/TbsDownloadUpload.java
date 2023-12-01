package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
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

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsDownloadUpload.class */
public class TbsDownloadUpload {
    private static TbsDownloadUpload b;

    /* renamed from: a  reason: collision with root package name */
    Map<String, Object> f38762a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Context f38763c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    public SharedPreferences mPreferences;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsDownloadUpload$TbsUploadKey.class */
    public interface TbsUploadKey {
        public static final String KEY_LOCAL_CORE_VERSION = "tbs_local_core_version";
        public static final String KEY_NEEDDOWNLOAD_CODE = "tbs_needdownload_code";
        public static final String KEY_NEEDDOWNLOAD_RETURN = "tbs_needdownload_return";
        public static final String KEY_NEEDDOWNLOAD_SENT = "tbs_needdownload_sent";
        public static final String KEY_STARTDOWNLOAD_CODE = "tbs_startdownload_code";
        public static final String KEY_STARTDOWNLOAD_SENT = "tbs_startdownload_sent";
    }

    public TbsDownloadUpload(Context context) {
        this.mPreferences = context.getSharedPreferences("tbs_download_upload", 4);
        Context applicationContext = context.getApplicationContext();
        this.f38763c = applicationContext;
        if (applicationContext == null) {
            this.f38763c = context;
        }
    }

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

    public static void clear() {
        synchronized (TbsDownloadUpload.class) {
            try {
                b = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static TbsDownloadUpload getInstance() {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            try {
                tbsDownloadUpload = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tbsDownloadUpload;
    }

    public static TbsDownloadUpload getInstance(Context context) {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            try {
                if (b == null) {
                    b = new TbsDownloadUpload(context);
                }
                tbsDownloadUpload = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tbsDownloadUpload;
    }

    public void clearUploadCode() {
        this.f38762a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 0);
        this.f38762a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 0);
        this.f38762a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, 0);
        this.f38762a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, 0);
        this.f38762a.put(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, 0);
        this.f38762a.put(TbsUploadKey.KEY_LOCAL_CORE_VERSION, 0);
        writeTbsDownloadInfo();
    }

    public void commit() {
        synchronized (this) {
            writeTbsDownloadInfo();
        }
    }

    public int getLocalCoreVersion() {
        int i;
        synchronized (this) {
            i = this.i;
        }
        return i;
    }

    public int getNeedDownloadCode() {
        synchronized (this) {
            if (this.g == 1) {
                return 148;
            }
            return this.d;
        }
    }

    public int getNeedDownloadReturn() {
        int i;
        synchronized (this) {
            i = this.f;
        }
        return i;
    }

    public int getStartDownloadCode() {
        synchronized (this) {
            if (this.h == 1) {
                return 168;
            }
            return this.e;
        }
    }

    public void readTbsDownloadInfo(Context context) {
        BufferedInputStream bufferedInputStream;
        File a2;
        synchronized (this) {
            try {
                a2 = a(this.f38763c, "download_upload");
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
            if (a2 == null) {
                return;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(a2));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                String property = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, "");
                if (!"".equals(property)) {
                    this.d = Math.max(Integer.parseInt(property), 0);
                }
                String property2 = properties.getProperty(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, "");
                if (!"".equals(property2)) {
                    this.e = Math.max(Integer.parseInt(property2), 0);
                }
                String property3 = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, "");
                if (!"".equals(property3)) {
                    this.f = Math.max(Integer.parseInt(property3), 0);
                }
                String property4 = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, "");
                if (!"".equals(property4)) {
                    this.g = Math.max(Integer.parseInt(property4), 0);
                }
                String property5 = properties.getProperty(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, "");
                if (!"".equals(property5)) {
                    this.h = Math.max(Integer.parseInt(property5), 0);
                }
                String property6 = properties.getProperty(TbsUploadKey.KEY_LOCAL_CORE_VERSION, "");
                if (!"".equals(property6)) {
                    this.i = Math.max(Integer.parseInt(property6), 0);
                }
                try {
                    bufferedInputStream.close();
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (Throwable th2) {
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
        }
    }

    public void writeTbsDownloadInfo() {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        File a2;
        Properties properties;
        synchronized (this) {
            TbsLog.i("TbsDownloadUpload", "writeTbsDownloadInfo #1");
            try {
                a2 = a(this.f38763c, "download_upload");
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
                for (String str : this.f38762a.keySet()) {
                    Object obj = this.f38762a.get(str);
                    properties.setProperty(str, "" + obj);
                    TbsLog.i("TbsDownloadUpload", "writeTbsDownloadInfo key is " + str + " value is " + obj);
                }
                this.f38762a.clear();
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
