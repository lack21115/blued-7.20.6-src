package com.opos.cmn.biz.monitor;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24662a = e.class.getSimpleName();

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f24663a;
        public final boolean b;

        public a(String str, boolean z) {
            this.f24663a = str;
            this.b = z;
        }
    }

    public static a a(Context context, String str, MonitorEvent monitorEvent) {
        String[] strArr;
        String str2 = str;
        for (String str3 : c.f24661a) {
            String b = b(context, str3, monitorEvent);
            if (b != null) {
                str2 = a(str2, str3, b(b));
            }
        }
        return new a(str2, a(str));
    }

    public static String a(Context context) {
        String h = com.opos.cmn.an.h.c.a.h(context);
        return ("none".equals(h) || TextUtils.isEmpty(h)) ? "UNKNOWN" : h.toUpperCase();
    }

    public static String a(String str, String str2, String str3) {
        return a(str, str2, str3, -1, false);
    }

    private static String a(String str, String str2, String str3, int i, boolean z) {
        String str4;
        int i2;
        String str5 = str;
        if (!TextUtils.isEmpty(str)) {
            str5 = str;
            if (!TextUtils.isEmpty(str2)) {
                str5 = str;
                if (str3 != null) {
                    if (i == 0) {
                        return str;
                    }
                    if (z) {
                        str4 = str.toLowerCase();
                        str2 = str2.toLowerCase();
                    } else {
                        str4 = str;
                    }
                    int indexOf = str4.indexOf(str2, 0);
                    str5 = str;
                    if (indexOf != -1) {
                        int length = str2.length();
                        int length2 = str3.length() - length;
                        int i3 = length2;
                        if (length2 < 0) {
                            i3 = 0;
                        }
                        int i4 = 64;
                        if (i < 0) {
                            i4 = 16;
                        } else if (i <= 64) {
                            i4 = i;
                        }
                        StringBuilder sb = new StringBuilder((i4 * i3) + str.length());
                        int i5 = i;
                        int i6 = indexOf;
                        int i7 = 0;
                        while (true) {
                            i2 = i7;
                            if (i6 == -1) {
                                break;
                            }
                            sb.append(str.substring(i7, i6));
                            sb.append(str3);
                            i7 = i6 + length;
                            i5--;
                            if (i5 == 0) {
                                i2 = i7;
                                break;
                            }
                            i6 = str4.indexOf(str2, i7);
                        }
                        sb.append(str.substring(i2));
                        str5 = sb.toString();
                    }
                }
            }
        }
        return str5;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.indexOf("mix_in") >= 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r3) {
        /*
            r0 = r3
            java.lang.String r0 = com.opos.cmn.an.h.e.a.b(r0)
            r4 = r0
            java.lang.String r0 = "none"
            r1 = r4
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L17
            r0 = r4
            r3 = r0
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1a
        L17:
            java.lang.String r0 = "UNKNOWN"
            r3 = r0
        L1a:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.monitor.e.b(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String b(Context context, String str, MonitorEvent monitorEvent) {
        boolean z;
        String str2;
        String str3;
        int b;
        switch (str.hashCode()) {
            case 37701:
                if (str.equals("$c$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 37856:
                if (str.equals("$h$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 38011:
                if (str.equals("$m$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 38228:
                if (str.equals("$t$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 38321:
                if (str.equals("$w$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1169294:
                if (str.equals("$as$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1169387:
                if (str.equals("$av$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1169790:
                if (str.equals("$bd$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1170658:
                if (str.equals("$ca$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1170906:
                if (str.equals("$ci$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1171123:
                if (str.equals("$cp$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1171185:
                if (str.equals("$cr$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1171247:
                if (str.equals("$ct$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1172332:
                if (str.equals("$dx$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1172363:
                if (str.equals("$dy$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1177912:
                if (str.equals("$jr$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1181818:
                if (str.equals("$nt$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1182748:
                if (str.equals("$os$")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1182841:
                if (str.equals("$ov$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1185228:
                if (str.equals("$rf$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1185259:
                if (str.equals("$rg$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1187956:
                if (str.equals("$ua$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1188669:
                if (str.equals("$ux$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1188700:
                if (str.equals("$uy$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 36560847:
                if (str.equals("$lan$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 36689404:
                if (str.equals("$pkg$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 546794483:
                if (str.equals("$progress$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1125369693:
                if (str.equals("$ckid$")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1978886681:
                if (str.equals("__CONTENT__")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        String str4 = "";
        switch (z) {
            case false:
                str4 = "android";
                return str4;
            case true:
                return com.opos.cmn.an.b.c.c();
            case true:
                return com.opos.cmn.an.b.c.a();
            case true:
                return com.opos.cmn.an.b.b.a();
            case true:
                return com.opos.cmn.an.b.b.b();
            case true:
                return com.opos.cmn.biz.a.d.a(context);
            case true:
                try {
                    b = com.opos.cmn.an.h.f.a.b(context);
                    return String.valueOf(b);
                } catch (Exception e) {
                    e = e;
                    str2 = f24662a;
                    str3 = "get width fail";
                    com.opos.cmn.an.f.a.b(str2, str3, e);
                    return String.valueOf(0);
                }
            case true:
                try {
                    b = com.opos.cmn.an.h.f.a.c(context);
                    return String.valueOf(b);
                } catch (Exception e2) {
                    e = e2;
                    str2 = f24662a;
                    str3 = "get height fail";
                    com.opos.cmn.an.f.a.b(str2, str3, e);
                    return String.valueOf(0);
                }
            case true:
                return context.getPackageName();
            case true:
                return com.opos.cmn.an.h.d.a.c(context, context.getPackageName());
            case true:
                return c(context);
            case true:
            case true:
                return str4;
            case true:
                return a(context);
            case true:
                return b(context);
            case true:
                b = monitorEvent.a();
                return String.valueOf(b);
            case true:
                b = monitorEvent.b();
                return String.valueOf(b);
            case true:
                b = monitorEvent.c();
                return String.valueOf(b);
            case true:
                b = monitorEvent.d();
                return String.valueOf(b);
            case true:
                b = monitorEvent.e();
                return String.valueOf(b);
            case true:
                return monitorEvent.f();
            case true:
                return monitorEvent.g();
            case true:
                b = monitorEvent.h();
                return String.valueOf(b);
            case true:
                return String.valueOf(System.currentTimeMillis());
            case true:
                return com.opos.cmn.biz.a.b.a(context);
            case true:
                return monitorEvent.i();
            case true:
                return monitorEvent.j();
            case true:
                return monitorEvent.k();
            case true:
                return UUID.randomUUID().toString() + System.currentTimeMillis();
            default:
                return null;
        }
    }

    private static String b(String str) {
        if (str == null) {
            return "";
        }
        String str2 = str;
        if (str.length() > 0) {
            try {
                str2 = URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return "";
            }
        }
        return str2;
    }

    private static String c(Context context) {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(f24662a, "getUA", e);
            return "";
        }
    }
}
