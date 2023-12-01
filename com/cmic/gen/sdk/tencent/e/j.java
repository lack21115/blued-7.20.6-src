package com.cmic.gen.sdk.tencent.e;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/j.class */
public class j {
    private static j b;

    /* renamed from: a  reason: collision with root package name */
    private final Context f21667a;

    private j(Context context) {
        this.f21667a = context;
    }

    public static j a() {
        return b;
    }

    public static void a(Context context) {
        b = new j(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String b(String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode == 49679479) {
            if (str.equals("46009")) {
                z = true;
            }
            z = true;
        } else if (hashCode != 49679502) {
            switch (hashCode) {
                case 49679470:
                    if (str.equals("46000")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 49679471:
                    if (str.equals("46001")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49679472:
                    if (str.equals("46002")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49679473:
                    if (str.equals("46003")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49679474:
                    if (str.equals("46004")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49679475:
                    if (str.equals("46005")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49679476:
                    if (str.equals("46006")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49679477:
                    if (str.equals("46007")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
        } else {
            if (str.equals("46011")) {
                z = true;
            }
            z = true;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
                c.a("SIMUtils", "中国移动");
                return "1";
            case true:
            case true:
            case true:
                c.a("SIMUtils", "中国联通");
                return "2";
            case true:
            case true:
            case true:
                c.a("SIMUtils", "中国电信");
                return "3";
            default:
                return "0";
        }
    }

    public String a(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = c();
        }
        return b(str2);
    }

    public String b() {
        try {
            int a2 = com.cmic.gen.sdk.tencent.b.a.a().b().a();
            return a2 >= 0 ? Integer.toString(a2) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String c() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f21667a.getSystemService("phone");
        if (telephonyManager != null) {
            String simOperator = telephonyManager.getSimOperator();
            c.b("SIMUtils", "SysOperator= " + simOperator);
            return simOperator;
        }
        return "";
    }
}
