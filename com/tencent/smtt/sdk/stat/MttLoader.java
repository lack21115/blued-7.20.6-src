package com.tencent.smtt.sdk.stat;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.FileProvider;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/stat/MttLoader.class */
public class MttLoader {
    public static final String CHANNEL_ID = "ChannelID";
    public static final String ENTRY_ID = "entryId";
    @Deprecated
    public static final String KEY_ACTIVITY_NAME = "KEY_ACT";
    @Deprecated
    public static final String KEY_APP_NAME = "KEY_APPNAME";
    public static final String KEY_EUSESTAT = "KEY_EUSESTAT";
    @Deprecated
    public static final String KEY_PACKAGE = "KEY_PKG";
    public static final String KEY_PID = "KEY_PID";
    public static final String MTT_ACTION = "com.tencent.QQBrowser.action.VIEW";
    public static final String MTT_ACTION_SP = "com.tencent.QQBrowser.action.VIEWSP";
    public static final String PID_ARTICLE_NEWS = "21272";
    public static final String PID_MOBILE_QQ = "50079";
    public static final String PID_QQPIM = "50190";
    public static final String PID_QZONE = "10494";
    public static final String PID_WECHAT = "10318";
    public static final String POS_ID = "PosID";
    public static final String QQBROWSER_DIRECT_DOWNLOAD_URL = "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079";
    public static final String QQBROWSER_DOWNLOAD_URL = "https://mdc.html5.qq.com/mh?channel_id=50079&u=";
    public static final String QQBROWSER_PARAMS_FROME = ",from=";
    public static final String QQBROWSER_PARAMS_PACKAGENAME = ",packagename=";
    public static final String QQBROWSER_PARAMS_PD = ",product=";
    public static final String QQBROWSER_PARAMS_VERSION = ",version=";
    public static final String QQBROWSER_SCHEME = "mttbrowser://url=";
    public static final int RESULT_INVALID_CONTEXT = 3;
    public static final int RESULT_INVALID_URL = 2;
    public static final int RESULT_NOT_INSTALL_QQBROWSER = 4;
    public static final int RESULT_OK = 0;
    public static final int RESULT_QQBROWSER_LOW = 5;
    public static final int RESULT_UNKNOWN = 1;
    public static final String STAT_KEY = "StatKey";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo.class */
    public static class BrowserInfo {
        public int browserType = -1;
        public int ver = -1;
        public String quahead = "";
        public String vn = "0";
        public String packageName = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/stat/MttLoader$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f38880a;
        public String b;

        private a() {
            this.f38880a = "";
            this.b = "";
        }
    }

    private static int a(Context context) {
        String str = context.getApplicationInfo().processName;
        if (str.equals("com.tencent.mobileqq")) {
            return 13;
        }
        if (str.equals("com.qzone")) {
            return 14;
        }
        if (str.equals("com.tencent.WBlog")) {
            return 15;
        }
        return str.equals("com.tencent.mm") ? 24 : 26;
    }

    private static Uri a(Context context, String str) {
        return FileProvider.a(context, str);
    }

    private static a a(Context context, Uri uri) {
        Intent intent = new Intent(MTT_ACTION);
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        a aVar = new a();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                aVar.f38880a = resolveInfo.activityInfo.name;
                aVar.b = resolveInfo.activityInfo.packageName;
                return aVar;
            } else if (str.contains("com.tencent.qbx")) {
                aVar.f38880a = resolveInfo.activityInfo.name;
                aVar.b = resolveInfo.activityInfo.packageName;
            }
        }
        return aVar;
    }

    private static String a(Certificate certificate) throws CertificateEncodingException {
        byte[] encoded = certificate.getEncoded();
        int length = encoded.length;
        char[] cArr = new char[length * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new String(cArr);
            }
            byte b = encoded[i2];
            int i3 = (b >> 4) & 15;
            int i4 = i2 * 2;
            cArr[i4] = (char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
            int i5 = b & 15;
            cArr[i4 + 1] = (char) (i5 >= 10 ? (i5 + 97) - 10 : i5 + 48);
            i = i2 + 1;
        }
    }

    private static boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String trim = str.trim();
        int indexOf = trim.toLowerCase().indexOf("://");
        int indexOf2 = trim.toLowerCase().indexOf(46);
        if (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) {
            return trim.toLowerCase().contains("://");
        }
        return false;
    }

    public static BrowserInfo getBrowserInfo(Context context) {
        PackageInfo packageInfo;
        PackageInfo packageInfo2;
        boolean z = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        BrowserInfo browserInfo = new BrowserInfo();
        if (z) {
            return browserInfo;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo3 = null;
            try {
                PackageInfo packageInfo4 = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                browserInfo.browserType = 2;
                browserInfo.packageName = TbsConfig.APP_QB;
                browserInfo.quahead = "ADRQB_";
                packageInfo = packageInfo4;
                if (packageInfo4 != null) {
                    packageInfo = packageInfo4;
                    if (packageInfo4.versionCode > 420000) {
                        browserInfo.ver = packageInfo4.versionCode;
                        StringBuilder sb = new StringBuilder();
                        sb.append(browserInfo.quahead);
                        sb.append(packageInfo4.versionName.replaceAll("\\.", ""));
                        browserInfo.quahead = sb.toString();
                        packageInfo3 = packageInfo4;
                        browserInfo.vn = packageInfo4.versionName.replaceAll("\\.", "");
                        return browserInfo;
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                packageInfo = packageInfo3;
            }
            try {
                PackageInfo packageInfo5 = packageManager.getPackageInfo("com.tencent.qbx", 0);
                browserInfo.browserType = 0;
                browserInfo.packageName = "com.tencent.qbx";
                packageInfo = packageInfo5;
                browserInfo.quahead = "ADRQBX_";
                packageInfo2 = packageInfo5;
            } catch (PackageManager.NameNotFoundException e2) {
                try {
                    PackageInfo packageInfo6 = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    browserInfo.browserType = 1;
                    browserInfo.packageName = "com.tencent.qbx5";
                    packageInfo = packageInfo6;
                    browserInfo.quahead = "ADRQBX5_";
                    packageInfo2 = packageInfo6;
                } catch (PackageManager.NameNotFoundException e3) {
                    PackageInfo packageInfo7 = packageInfo;
                    try {
                        PackageInfo packageInfo8 = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                        browserInfo.packageName = TbsConfig.APP_QB;
                        browserInfo.browserType = 2;
                        packageInfo7 = packageInfo8;
                        browserInfo.quahead = "ADRQB_";
                        packageInfo2 = packageInfo8;
                    } catch (PackageManager.NameNotFoundException e4) {
                        try {
                            PackageInfo packageInfo9 = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            browserInfo.packageName = "com.tencent.mtt.x86";
                            browserInfo.browserType = 2;
                            packageInfo7 = packageInfo9;
                            browserInfo.quahead = "ADRQB_";
                            packageInfo2 = packageInfo9;
                        } catch (Exception e5) {
                            try {
                                a a2 = a(context, Uri.parse(QQBROWSER_DOWNLOAD_URL));
                                packageInfo2 = packageInfo7;
                                if (a2 != null) {
                                    packageInfo2 = packageInfo7;
                                    if (!TextUtils.isEmpty(a2.b)) {
                                        packageInfo2 = packageManager.getPackageInfo(a2.b, 0);
                                        try {
                                            browserInfo.packageName = a2.b;
                                            browserInfo.browserType = 2;
                                            browserInfo.quahead = "ADRQB_";
                                        } catch (Exception e6) {
                                        }
                                    }
                                }
                            } catch (Exception e7) {
                                packageInfo2 = packageInfo7;
                            }
                        }
                    }
                }
            }
            if (packageInfo2 != null) {
                browserInfo.ver = packageInfo2.versionCode;
                browserInfo.quahead += packageInfo2.versionName.replaceAll("\\.", "");
                browserInfo.vn = packageInfo2.versionName.replaceAll("\\.", "");
            }
            return browserInfo;
        } catch (Exception e8) {
            return browserInfo;
        }
    }

    public static String getDownloadUrlWithQb(String str) {
        try {
            return QQBROWSER_DOWNLOAD_URL + URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return QQBROWSER_DOWNLOAD_URL;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r0.ver < 33) goto L5;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getValidQBUrl(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = r4
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "qb://"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L42
            r0 = 0
            r6 = r0
            r0 = r3
            com.tencent.smtt.sdk.stat.MttLoader$BrowserInfo r0 = getBrowserInfo(r0)
            r3 = r0
            r0 = r3
            int r0 = r0.browserType
            r1 = -1
            if (r0 != r1) goto L21
        L1c:
            r0 = 1
            r5 = r0
            goto L39
        L21:
            r0 = r6
            r5 = r0
            r0 = r3
            int r0 = r0.browserType
            r1 = 2
            if (r0 != r1) goto L39
            r0 = r6
            r5 = r0
            r0 = r3
            int r0 = r0.ver
            r1 = 33
            if (r0 >= r1) goto L39
            goto L1c
        L39:
            r0 = r5
            if (r0 == 0) goto L42
            r0 = r4
            java.lang.String r0 = getDownloadUrlWithQb(r0)
            return r0
        L42:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.stat.MttLoader.getValidQBUrl(android.content.Context, java.lang.String):java.lang.String");
    }

    public static boolean isBrowserInstalled(Context context) {
        return getBrowserInfo(context).browserType != -1;
    }

    public static boolean isBrowserInstalledEx(Context context) {
        BrowserInfo browserInfo = getBrowserInfo(context);
        boolean z = false;
        try {
            if (Long.valueOf(browserInfo.vn).longValue() >= 6001500) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (browserInfo.ver >= 601500) {
            return true;
        }
        return z;
    }

    public static boolean isGreatBrowserVer(Context context, long j, long j2) {
        BrowserInfo browserInfo;
        boolean z = false;
        try {
            if (Long.valueOf(getBrowserInfo(context).vn).longValue() >= j) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (browserInfo.ver >= j2) {
            return true;
        }
        return z;
    }

    public static boolean isSupportQBScheme(Context context) {
        BrowserInfo browserInfo = getBrowserInfo(context);
        if (browserInfo.browserType == -1) {
            return false;
        }
        return browserInfo.browserType != 2 || browserInfo.ver >= 42;
    }

    public static boolean isSupportingTbsTips(Context context) {
        BrowserInfo browserInfo = getBrowserInfo(context);
        return browserInfo.browserType == 2 && browserInfo.ver >= 580000;
    }

    public static int loadUrl(Context context, String str, HashMap<String, String> hashMap, WebView webView) {
        a a2;
        Intent intent;
        String str2;
        Set<String> keySet;
        String str3;
        if (context == null) {
            return 3;
        }
        String str4 = str;
        if (!a(str)) {
            str4 = "http://" + str;
        }
        try {
            Uri parse = Uri.parse(str4);
            if (parse == null) {
                return 2;
            }
            BrowserInfo browserInfo = getBrowserInfo(context);
            if (browserInfo.browserType == -1) {
                return 4;
            }
            if (browserInfo.browserType != 2 || browserInfo.ver >= 33) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                if (browserInfo.browserType == 2) {
                    if (browserInfo.ver >= 33 && browserInfo.ver <= 39) {
                        str3 = "com.tencent.mtt.MainActivity";
                    } else if (browserInfo.ver < 40 || browserInfo.ver > 45) {
                        intent = intent2;
                        if (browserInfo.ver >= 46) {
                            Intent intent3 = new Intent(MTT_ACTION);
                            a a3 = a(context, parse);
                            intent = intent3;
                            if (a3 != null) {
                                intent = intent3;
                                if (!TextUtils.isEmpty(a3.f38880a)) {
                                    intent = intent3;
                                    a2 = a3;
                                    intent.setClassName(a2.b, a2.f38880a);
                                }
                            }
                        }
                    } else {
                        str3 = "com.tencent.mtt.SplashActivity";
                    }
                    intent2.setClassName(TbsConfig.APP_QB, str3);
                    intent = intent2;
                } else if (browserInfo.browserType == 1) {
                    if (browserInfo.ver == 1) {
                        str2 = "com.tencent.qbx5.MainActivity";
                    } else {
                        intent = intent2;
                        str2 = browserInfo.ver == 2 ? "com.tencent.qbx5.SplashActivity" : "com.tencent.qbx5.SplashActivity";
                    }
                    intent2.setClassName("com.tencent.qbx5", str2);
                    intent = intent2;
                } else if (browserInfo.browserType != 0) {
                    Intent intent4 = new Intent(MTT_ACTION);
                    a2 = a(context, parse);
                    intent = intent4;
                    if (a2 != null) {
                        intent = intent4;
                        if (!TextUtils.isEmpty(a2.f38880a)) {
                            intent = intent4;
                            intent.setClassName(a2.b, a2.f38880a);
                        }
                    }
                } else if (browserInfo.ver < 4 || browserInfo.ver > 6) {
                    intent = intent2;
                    if (browserInfo.ver > 6) {
                        Intent intent5 = new Intent(MTT_ACTION);
                        a2 = a(context, parse);
                        intent = intent5;
                        if (a2 != null) {
                            intent = intent5;
                            if (!TextUtils.isEmpty(a2.f38880a)) {
                                intent = intent5;
                                intent.setClassName(a2.b, a2.f38880a);
                            }
                        }
                    }
                } else {
                    intent2.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                    intent = intent2;
                }
                intent.setData(parse);
                if (hashMap != null && (keySet = hashMap.keySet()) != null) {
                    for (String str5 : keySet) {
                        String str6 = hashMap.get(str5);
                        if (!TextUtils.isEmpty(str6)) {
                            intent.putExtra(str5, str6);
                        }
                    }
                }
                try {
                    intent.putExtra("loginType", a(context));
                    intent.addFlags(268435456);
                    if (webView != null) {
                        intent.putExtra("AnchorPoint", new Point(webView.getScrollX(), webView.getScrollY()));
                        intent.putExtra("ContentSize", new Point(webView.getContentWidth(), webView.getContentHeight()));
                    }
                    context.startActivity(intent);
                    return 0;
                } catch (ActivityNotFoundException e) {
                    return 4;
                }
            }
            return 5;
        } catch (Exception e2) {
            return 2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|2|3|(3:7|8|(8:10|11|12|(1:14)|15|(1:17)(1:21)|18|19))|26|11|12|(0)|15|(0)(0)|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d2, code lost:
        r10 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int loadUrl(android.content.Context r5, java.lang.String r6, java.util.HashMap<java.lang.String, java.lang.String> r7, java.lang.String r8, com.tencent.smtt.sdk.WebView r9) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r13 = r0
            r0 = 0
            r11 = r0
            r0 = r5
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> Lcb
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L3b
            r0 = r12
            java.lang.String r1 = "com.tencent.mtt"
            r2 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch: java.lang.Throwable -> Lcb
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L3b
            r0 = r12
            int r0 = r0.versionCode     // Catch: java.lang.Throwable -> Lcb
            r10 = r0
            r0 = r10
            r1 = 601000(0x92ba8, float:8.4218E-40)
            if (r0 <= r1) goto L3b
            r0 = 1
            r10 = r0
            goto L3e
        L3b:
            r0 = 0
            r10 = r0
        L3e:
            r0 = r6
            java.lang.String r1 = "UTF-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r1)     // Catch: java.lang.Exception -> Ld0
            r12 = r0
            r0 = r10
            if (r0 == 0) goto L4f
            r0 = r12
            r6 = r0
        L4f:
            goto L52
        L52:
            r0 = r10
            if (r0 == 0) goto L5f
            java.lang.String r0 = ",encoded=1"
            r12 = r0
            goto L64
        L5f:
            java.lang.String r0 = ""
            r12 = r0
        L64:
            r0 = r13
            java.lang.String r1 = "mttbrowser://url="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            java.lang.String r1 = ",product="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            java.lang.String r1 = "TBS"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            java.lang.String r1 = ",packagename="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            r1 = r5
            java.lang.String r1 = r1.getPackageName()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            java.lang.String r1 = ",from="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            java.lang.String r1 = ",version="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            java.lang.String r1 = "4.3.0.67"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            r1 = r12
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r13
            java.lang.String r1 = r1.toString()
            r2 = r7
            r3 = r9
            int r0 = loadUrl(r0, r1, r2, r3)
            return r0
        Lcb:
            r12 = move-exception
            goto L3b
        Ld0:
            r12 = move-exception
            r0 = r11
            r10 = r0
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.stat.MttLoader.loadUrl(android.content.Context, java.lang.String, java.util.HashMap, java.lang.String, com.tencent.smtt.sdk.WebView):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00da A[Catch: Exception -> 0x0127, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0127, blocks: (B:2:0x0000, B:4:0x0011, B:6:0x001d, B:8:0x0028, B:10:0x0030, B:12:0x0050, B:13:0x005d, B:15:0x0082, B:16:0x0090, B:17:0x009c, B:19:0x00aa, B:21:0x00b6, B:23:0x00be, B:25:0x00c7, B:29:0x00da, B:31:0x0114, B:33:0x0120), top: B:44:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean openDocWithQb(android.content.Context r4, java.lang.String r5, int r6, java.lang.String r7, java.lang.String r8, java.util.HashMap<java.lang.String, java.lang.String> r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.stat.MttLoader.openDocWithQb(android.content.Context, java.lang.String, int, java.lang.String, java.lang.String, java.util.HashMap, android.os.Bundle):boolean");
    }

    public static boolean openDocWithQb(Context context, String str, int i, String str2, HashMap<String, String> hashMap) {
        return openDocWithQb(context, str, i, str2, hashMap, null);
    }

    public static boolean openDocWithQb(Context context, String str, int i, String str2, HashMap<String, String> hashMap, Bundle bundle) {
        return openDocWithQb(context, str, i, str2, "", hashMap, null);
    }

    public static boolean openVideoWithQb(Context context, String str, HashMap<String, String> hashMap) {
        boolean z;
        Set<String> keySet;
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setDataAndType(parse, "video/*");
        if (hashMap != null && (keySet = hashMap.keySet()) != null) {
            for (String str2 : keySet) {
                String str3 = hashMap.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    intent.putExtra(str2, str3);
                }
            }
        }
        try {
            intent.putExtra("loginType", a(context));
            intent.setComponent(new ComponentName(TbsConfig.APP_QB, "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
            context.startActivity(intent);
            z = true;
        } catch (Throwable th) {
            z = false;
        }
        if (z) {
            return true;
        }
        try {
            intent.setComponent(null);
            context.startActivity(intent);
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean verifySignature(File file) {
        JarFile jarFile;
        JarFile jarFile2;
        InputStream inputStream;
        JarEntry jarEntry;
        InputStream inputStream2 = null;
        try {
            jarFile2 = new JarFile(file);
            inputStream = null;
            try {
                jarEntry = jarFile2.getJarEntry(ShareConstants.RES_MANIFEST);
            } catch (Throwable th) {
                inputStream2 = inputStream;
                jarFile = jarFile2;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e) {
                    }
                }
                if (jarFile == null) {
                    return false;
                }
                try {
                    jarFile.close();
                    return false;
                } catch (IOException e2) {
                    return false;
                }
            }
        } catch (Throwable th2) {
            jarFile = null;
        }
        if (jarEntry == null) {
            try {
                jarFile2.close();
                return false;
            } catch (IOException e3) {
                return false;
            }
        }
        byte[] bArr = new byte[8192];
        InputStream inputStream3 = jarFile2.getInputStream(jarEntry);
        while (inputStream3.read(bArr, 0, 8192) != -1) {
        }
        inputStream3.close();
        Certificate[] certificates = jarEntry.getCertificates();
        if (certificates.length < 1) {
            if (inputStream3 != null) {
                try {
                    inputStream3.close();
                } catch (IOException e4) {
                }
            }
            try {
                jarFile2.close();
                return false;
            } catch (IOException e5) {
                return false;
            }
        }
        String a2 = a(certificates[0]);
        if (a2 != null) {
            inputStream = inputStream3;
            if (a2.equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e6) {
                    }
                }
                try {
                    jarFile2.close();
                    return true;
                } catch (IOException e7) {
                    return true;
                }
            }
        }
        jarFile = jarFile2;
        if (inputStream3 != null) {
            try {
                inputStream3.close();
                jarFile = jarFile2;
            } catch (IOException e8) {
                jarFile = jarFile2;
            }
        }
        jarFile.close();
        return false;
    }
}
