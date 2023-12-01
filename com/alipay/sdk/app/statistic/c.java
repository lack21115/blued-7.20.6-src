package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.util.n;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/statistic/c.class */
public class c {
    public static final String A = "ClientBindException";
    public static final String B = "SaveTradeTokenError";
    public static final String C = "ClientBindServiceFailed";
    public static final String D = "TryStartServiceEx";
    public static final String E = "BindWaitTimeoutEx";
    public static final String F = "CheckClientExistEx";
    public static final String G = "CheckClientSignEx";
    public static final String H = "GetInstalledAppEx";
    public static final String I = "ParserTidClientKeyEx";
    public static final String J = "PgApiInvoke";
    public static final String K = "PgBindStarting";
    public static final String L = "PgBinded";
    public static final String M = "PgBindEnd";
    public static final String N = "PgBindPay";
    public static final String O = "PgReturn";
    public static final String P = "PgWltVer";
    public static final String Q = "PgOpenStarting";
    public static final String R = "ErrIntentEx";
    public static final String S = "ErrActNull";
    public static final String T = "ErrActNull";
    public static final String U = "GetInstalledAppEx";
    public static final String V = "StartLaunchAppTransEx";
    public static final String W = "CheckLaunchAppExistEx";
    public static final String X = "LogCurrentAppLaunchSwitch";
    public static final String Y = "LogCurrentQueryTime";
    public static final String Z = "LogCalledPackage";

    /* renamed from: a  reason: collision with root package name */
    public static final String f4608a = "net";
    public static final String aa = "LogBindCalledH5";
    public static final String ab = "LogCalledH5";
    public static final String ac = "LogHkLoginByIntent";
    public static final String ad = "SchemePayWrongHashEx";
    public static final String ae = "LogAppLaunchSwitchEnabled";
    public static final String af = "H5CbUrlEmpty";
    public static final String ag = "H5CbEx";
    public static final String ah = "BuildSchemePayUriError";
    public static final String ai = "StartActivityEx";
    public static final String aj = "JSONEx";
    public static final String ak = "ParseBundleSerializableError";
    public static final String al = "ParseSchemeQueryError";
    public static final String am = "tid_context_null";
    public static final String an = "partner";
    public static final String ao = "out_trade_no";
    public static final String ap = "trade_no";
    public static final String aq = "biz_content";

    /* renamed from: ar  reason: collision with root package name */
    public static final String f4609ar = "app_id";
    public static final String b = "biz";

    /* renamed from: c  reason: collision with root package name */
    public static final String f4610c = "cp";
    public static final String d = "auth";
    public static final String e = "third";
    public static final String f = "tid";
    public static final String g = "FormatResultEx";
    public static final String h = "GetApdidEx";
    public static final String i = "GetApdidNull";
    public static final String j = "GetApdidTimeout";
    public static final String k = "GetUtdidEx";
    public static final String l = "GetPackageInfoEx";
    public static final String m = "NotIncludeSignatures";
    public static final String n = "GetInstalledPackagesEx";
    public static final String o = "GetPublicKeyFromSignEx";
    public static final String p = "H5PayNetworkError";
    public static final String q = "H5AuthNetworkError";
    public static final String r = "SSLError";
    public static final String s = "SSLProceed";
    public static final String t = "SSLDenied";
    public static final String u = "H5PayDataAnalysisError";
    public static final String v = "H5AuthDataAnalysisError";
    public static final String w = "PublicKeyUnmatch";
    public static final String x = "ClientBindFailed";
    public static final String y = "TriDesEncryptError";
    public static final String z = "TriDesDecryptError";
    private String aB;
    private String as;
    private String at;
    private String au;
    private String av;
    private String aw;
    private String ax;
    private String ay;
    private String az = "";
    private String aA = "";

    public c(Context context, boolean z2) {
        Context applicationContext = context != null ? context.getApplicationContext() : context;
        this.as = c();
        this.au = a(applicationContext);
        this.av = a(z2 ? 0L : a.c.a(applicationContext));
        this.aw = d();
        this.ax = b(applicationContext);
        this.ay = "-";
        this.aB = "-";
    }

    private static String a(long j2) {
        String b2 = b("15.7.4");
        String b3 = b("h.a.3.7.4");
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", b2, b3, Constants.WAVE_SEPARATOR + j2);
    }

    private static String a(Context context) {
        String str;
        String str2;
        String str3 = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                str = applicationContext.getPackageName();
                try {
                    PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(str, 64);
                    str3 = packageInfo.versionName + "|" + a(packageInfo);
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                str = "-";
            }
            str2 = str3;
        } else {
            str2 = "-";
            str = str3;
        }
        return String.format("%s,%s,-,-,-", b(str), b(str2));
    }

    private static String a(PackageInfo packageInfo) {
        String str;
        String a2;
        if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length == 0) {
            return "0";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.signatures.length);
            Signature[] signatureArr = packageInfo.signatures;
            int length = signatureArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return sb.toString();
                }
                try {
                    a2 = n.a((com.alipay.sdk.sys.a) null, signatureArr[i3].toByteArray());
                } catch (Throwable th) {
                }
                if (TextUtils.isEmpty(a2)) {
                    str = "?";
                    sb.append("-");
                    sb.append(str);
                    i2 = i3 + 1;
                } else {
                    str = n.f(a2).substring(0, 8);
                    sb.append("-");
                    sb.append(str);
                    i2 = i3 + 1;
                }
            }
        } catch (Throwable th2) {
            return "?";
        }
    }

    private static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName());
            stringBuffer.append(":");
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                int i2 = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append(" 》 ");
                    i2++;
                    if (i2 > 5) {
                        break;
                    }
                }
            }
        } catch (Throwable th2) {
        }
        return stringBuffer.toString();
    }

    private boolean a() {
        return TextUtils.isEmpty(this.aA);
    }

    private static String b() {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
    }

    private static String b(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", b(com.alipay.sdk.util.a.d(context)), "android", b(Build.VERSION.RELEASE), b(Build.MODEL), "-", b(com.alipay.sdk.util.a.a(context).a()), b(com.alipay.sdk.util.a.b(context).b()), "gw", b(com.alipay.sdk.util.a.a(context).b()));
    }

    private static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("^", Constants.WAVE_SEPARATOR).replace("#", "＃");
    }

    private static String c() {
        return String.format("123456789,%s", new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
    }

    private static String c(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "-";
        }
        return str2;
    }

    private void c(String str, String str2, String str3) {
        synchronized (this) {
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, String.format("err %s %s %s", str, str2, str3));
            String str4 = TextUtils.isEmpty(this.aA) ? "" : "^";
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(String.format("%s,%s,%s,%s", str, str2, TextUtils.isEmpty(str3) ? "-" : b(str3), b(b())));
            this.aA += sb.toString();
        }
    }

    private static String d() {
        return String.format("%s,%s,-,-,-", b(com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b()).a()), b(com.alipay.sdk.sys.b.a().e()));
    }

    private static String d(String str) {
        String str2;
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String[] split = str3.split("&");
        String str4 = null;
        String str5 = null;
        if (split != null) {
            int length = split.length;
            str2 = null;
            str4 = null;
            int i2 = 0;
            while (i2 < length) {
                String[] split2 = split[i2].split("=");
                String str6 = str5;
                String str7 = str2;
                String str8 = str4;
                if (split2 != null) {
                    str6 = str5;
                    str7 = str2;
                    str8 = str4;
                    if (split2.length == 2) {
                        if (split2[0].equalsIgnoreCase(an)) {
                            str6 = split2[1].replace("\"", "");
                            str7 = str2;
                            str8 = str4;
                        } else if (split2[0].equalsIgnoreCase(ao)) {
                            str7 = split2[1].replace("\"", "");
                            str6 = str5;
                            str8 = str4;
                        } else if (split2[0].equalsIgnoreCase(ap)) {
                            str8 = split2[1].replace("\"", "");
                            str6 = str5;
                            str7 = str2;
                        } else if (split2[0].equalsIgnoreCase(aq)) {
                            try {
                                JSONObject jSONObject = new JSONObject(n.b(com.alipay.sdk.sys.a.a(), split2[1]));
                                str6 = str5;
                                str7 = str2;
                                str8 = str4;
                                if (TextUtils.isEmpty(str2)) {
                                    str7 = jSONObject.getString(ao);
                                    str6 = str5;
                                    str8 = str4;
                                }
                            } catch (Throwable th) {
                                str6 = str5;
                                str7 = str2;
                                str8 = str4;
                            }
                        } else {
                            str6 = str5;
                            str7 = str2;
                            str8 = str4;
                            if (split2[0].equalsIgnoreCase("app_id")) {
                                str6 = str5;
                                str7 = str2;
                                str8 = str4;
                                if (TextUtils.isEmpty(str5)) {
                                    str6 = split2[1];
                                    str8 = str4;
                                    str7 = str2;
                                }
                            }
                        }
                    }
                }
                i2++;
                str5 = str6;
                str2 = str7;
                str4 = str8;
            }
        } else {
            str5 = null;
            str2 = null;
        }
        return String.format("%s,%s,-,%s,-,-,-", b(str4), b(str2), b(str5));
    }

    private void d(String str, String str2, String str3) {
        synchronized (this) {
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, String.format("event %s %s %s", str, str2, str3));
            String str4 = TextUtils.isEmpty(this.az) ? "" : "^";
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", TextUtils.isEmpty(str) ? "-" : b(str), b(str2), b(str3), b(b())));
            this.az += sb.toString();
        }
    }

    public String a(String str) {
        String d2 = d(str);
        this.at = d2;
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.as, d2, this.au, this.av, this.aw, this.ax, this.ay, c(this.az), c(this.aA), this.aB);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        d("", str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, String str3) {
        c(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, Throwable th) {
        c(str, str2, a(th));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, Throwable th, String str3) {
        String a2 = a(th);
        c(str, str2, str3 + ": " + a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, String str2, String str3) {
        d("", str, str2 + "|" + str3);
    }
}
