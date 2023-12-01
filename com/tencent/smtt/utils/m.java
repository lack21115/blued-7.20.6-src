package com.tencent.smtt.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/m.class */
public class m {

    /* renamed from: c  reason: collision with root package name */
    private static m f25276c;

    /* renamed from: a  reason: collision with root package name */
    private Context f25277a;
    private File b = null;
    private String d = "https://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    private String e = "https://log.tbs.qq.com/ajax?c=pu&tk=";
    private String f = "https://log.tbs.qq.com/ajax?c=dl&k=";
    private String g = "https://cfg.imtt.qq.com/tbs?v=2&mk=";
    private String h = "https://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    private String i = "https://mqqad.html5.qq.com/adjs";
    private String j = "https://log.tbs.qq.com/ajax?c=ucfu&k=";
    private String k = "https://tbsrecovery.imtt.qq.com/getconfig";

    private m(Context context) {
        this.f25277a = null;
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.f25277a = context.getApplicationContext();
        h();
    }

    public static m a() {
        m mVar;
        synchronized (m.class) {
            try {
                mVar = f25276c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    public static m a(Context context) {
        m mVar;
        synchronized (m.class) {
            try {
                if (f25276c == null) {
                    f25276c = new m(context);
                }
                mVar = f25276c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    private void h() {
        BufferedInputStream bufferedInputStream;
        StringWriter stringWriter;
        File i;
        synchronized (this) {
            try {
                i = i();
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
            if (i == null) {
                TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
                return;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(i));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                String property = properties.getProperty("pv_post_url", "");
                if (!"".equals(property)) {
                    this.d = property;
                }
                String property2 = properties.getProperty("tbs_download_stat_post_url", "");
                if (!"".equals(property2)) {
                    this.f = property2;
                }
                String property3 = properties.getProperty("tbs_downloader_post_url", "");
                if (!"".equals(property3)) {
                    this.g = property3;
                }
                String property4 = properties.getProperty("tbs_log_post_url", "");
                if (!"".equals(property4)) {
                    this.h = property4;
                }
                String property5 = properties.getProperty("tips_url", "");
                if (!"".equals(property5)) {
                    this.i = property5;
                }
                String property6 = properties.getProperty("tbs_cmd_post_url", "");
                if (!"".equals(property6)) {
                    this.j = property6;
                }
                String property7 = properties.getProperty("tbs_emergency_post_url", "");
                if (!"".equals(property7)) {
                    this.k = property7;
                }
                String property8 = properties.getProperty("pv_post_url_tk", "");
                if (!"".equals(property8)) {
                    this.e = property8;
                }
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace(new PrintWriter(new StringWriter()));
                TbsLog.e("TbsCommonConfig", "exceptions occurred1:" + stringWriter.toString());
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                    }
                }
            }
            try {
                bufferedInputStream.close();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
            }
        }
    }

    private File i() {
        File file;
        StringWriter stringWriter;
        File file2;
        try {
            if (this.b == null) {
                String str = this.f25277a.getApplicationContext().getApplicationInfo().packageName;
                if (TextUtils.isEmpty(str)) {
                    file2 = new File(FileUtil.a(this.f25277a, 8));
                } else {
                    boolean z = true;
                    boolean z2 = this.f25277a.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", str) == 0;
                    if (this.f25277a.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", str) != 0) {
                        z = false;
                    }
                    if (z2 || z) {
                        TbsLog.i("TbsCommonConfig", "no permission,use sdcard default folder");
                        file2 = new File(FileUtil.a(this.f25277a, 5));
                    } else {
                        file2 = new File(FileUtil.a(this.f25277a, 8));
                    }
                }
                this.b = file2;
                if (this.b == null || !this.b.isDirectory()) {
                    return null;
                }
            }
            file = new File(this.b, "tbsnet.conf");
            if (!file.exists()) {
                TbsLog.e("TbsCommonConfig", "Get file(" + file.getCanonicalPath() + ") failed!");
                return null;
            }
            try {
                TbsLog.w("TbsCommonConfig", "pathc:" + file.getCanonicalPath());
                return file;
            } catch (Throwable th) {
                th = th;
                th.printStackTrace(new PrintWriter(new StringWriter()));
                TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
                return file;
            }
        } catch (Throwable th2) {
            th = th2;
            file = null;
        }
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.e;
    }

    public String g() {
        return this.k;
    }
}
