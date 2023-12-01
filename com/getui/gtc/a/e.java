package com.getui.gtc.a;

import android.os.Build;
import android.text.TextUtils;
import com.cdo.oaps.ad.af;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.e.c;
import com.huawei.openalliance.ad.constant.t;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/e.class */
public final class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f21887a;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private long f21888c = 86400000;
    private String[] d = {t.W, "com.bbk.launcher2", "net.oneplus.launcher", "com.android.deskclock", af.e, "com.oppo.market"};
    private String[] e = {"com.tencent.mm", "com.tencent.mobileqq", "com.eg.android.AlipayGphone", "com.jingdong.app.mall", "com.ss.android.article.news", "com.taobao.taobao", "com.tmall.wireless", "com.sankuai.meituan", "com.xunmeng.pinduoduo", "com.ss.android.ugc.aweme"};

    private String a() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = this.d;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = strArr[i2];
                String str2 = com.getui.gtc.i.d.a.a(str).applicationInfo.sourceDir;
                sb.append(str + "#" + str2 + ",");
                i = i2 + 1;
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.a(th);
            return "";
        }
    }

    private String b() {
        File file;
        long millis;
        long millis2;
        if (Build.VERSION.SDK_INT < 26) {
            com.getui.gtc.i.c.a.a("type304 get hot info failed, api<26");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            File externalCacheDir = GtcProvider.context().getExternalCacheDir();
            file = null;
            if (externalCacheDir != null) {
                File parentFile = externalCacheDir.getParentFile();
                file = null;
                if (parentFile != null) {
                    file = parentFile.getParentFile();
                }
            }
        } catch (Throwable th) {
            th = th;
        }
        if (file == null) {
            return "";
        }
        try {
            String[] strArr = this.e;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = strArr[i2];
                try {
                    BasicFileAttributes readAttributes = Files.readAttributes(new File(file, str).toPath(), BasicFileAttributes.class, new LinkOption[0]);
                    millis = readAttributes.creationTime().toMillis();
                    millis2 = readAttributes.lastAccessTime().toMillis();
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    sb.append(str + "#" + com.getui.gtc.i.d.a.a(str).firstInstallTime + "#" + millis + "#" + millis2);
                    sb.append(",");
                } catch (Throwable th3) {
                    th = th3;
                    com.getui.gtc.i.c.a.a(th);
                    i = i2 + 1;
                }
                i = i2 + 1;
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Throwable th4) {
            th = th4;
            com.getui.gtc.i.c.a.a(th);
            return sb.toString();
        }
        return sb.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        try {
            Map<String, String> a2 = com.getui.gtc.f.b.a(null);
            if (a2 != null && a2.size() > 0) {
                try {
                    String str = a2.get("sdk.gtc.type304.enable");
                    if (str != null) {
                        this.b = Boolean.parseBoolean(str);
                    }
                } catch (Exception e) {
                    com.getui.gtc.i.c.a.a(e);
                }
                try {
                    String str2 = a2.get("sdk.gtc.type304.interval");
                    if (str2 != null) {
                        this.f21888c = Long.parseLong(str2) * 1000;
                    }
                } catch (Exception e2) {
                    com.getui.gtc.i.c.a.a(e2);
                }
                try {
                    String str3 = a2.get("sdk.gtc.type304.sys_al");
                    if (!TextUtils.isEmpty(str3) && !"none".equalsIgnoreCase(str3)) {
                        String[] split = str3.split(",");
                        if (split.length > 0) {
                            this.d = split;
                            com.getui.gtc.i.c.a.a("type304 dyc sysApp:" + Arrays.toString(split));
                        }
                    }
                } catch (Exception e3) {
                    com.getui.gtc.i.c.a.a(e3);
                }
                try {
                    String str4 = a2.get("sdk.gtc.type304.hot_al");
                    if (!TextUtils.isEmpty(str4) && !"none".equalsIgnoreCase(str4)) {
                        String[] split2 = str4.split(",");
                        if (split2.length > 0) {
                            this.e = split2;
                            com.getui.gtc.i.c.a.a("type304 dyc hotApp:" + Arrays.toString(split2));
                        }
                    }
                } catch (Exception e4) {
                    com.getui.gtc.i.c.a.a(e4);
                }
            }
            if (!this.b) {
                com.getui.gtc.i.c.a.b("type 304 is not enabled");
            } else if (CommonUtil.isAppDebugEnable()) {
                com.getui.gtc.i.c.a.b("type 304 is debug, disallow");
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                cVar = c.a.f21997a;
                if (currentTimeMillis - cVar.f21995a.k < this.f21888c) {
                    return;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                String str5 = a.a(simpleDateFormat.format(new Date())) + "|" + a.a(com.getui.gtc.c.b.d) + "|" + a.a(com.getui.gtc.c.b.f21920a) + "|android|" + GtcProvider.context().getPackageName() + "|GTC-3.2.1.0|" + a() + "|" + b();
                this.f21887a = str5;
                try {
                    com.getui.gtc.h.a.a(str5, 304);
                    cVar2 = c.a.f21997a;
                    com.getui.gtc.e.d dVar = cVar2.f21995a;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (dVar.a(16, currentTimeMillis2)) {
                        dVar.k = currentTimeMillis2;
                    }
                } catch (Exception e5) {
                    com.getui.gtc.i.c.a.c("type 304 report error: " + e5.toString());
                }
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.a("type 304", th);
        }
    }
}
