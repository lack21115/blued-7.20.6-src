package com.opos.cmn.an.h.e;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/h/e/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static TelephonyManager f10876a;

    public static TelephonyManager a(Context context) {
        if (f10876a == null && context != null) {
            f10876a = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        }
        return f10876a;
    }

    private static String a(String str) {
        return !TextUtils.isEmpty(str) ? (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46004") || str.startsWith("46007") || str.startsWith("46008")) ? "mobile" : (str.startsWith("46001") || str.startsWith("46006") || str.startsWith("46009")) ? "unicom" : (str.startsWith("46003") || str.startsWith("46011")) ? "telecom" : "none" : "none";
    }

    public static String b(Context context) {
        TelephonyManager a2;
        String networkOperatorName;
        if (context != null) {
            try {
                a2 = a(context);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("TelMgrTool", "", e);
            }
            if (a2 != null) {
                networkOperatorName = a2.getNetworkOperatorName();
                com.opos.cmn.an.f.a.b("TelMgrTool", "getNetOperator=" + networkOperatorName);
                return networkOperatorName;
            }
        }
        networkOperatorName = "none";
        com.opos.cmn.an.f.a.b("TelMgrTool", "getNetOperator=" + networkOperatorName);
        return networkOperatorName;
    }

    public static String c(Context context) {
        TelephonyManager a2;
        String simOperatorName;
        if (context != null) {
            try {
                a2 = a(context);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("TelMgrTool", "", e);
            }
            if (a2 != null) {
                simOperatorName = a2.getSimOperatorName();
                com.opos.cmn.an.f.a.b("TelMgrTool", "getSimOperator=" + simOperatorName);
                return simOperatorName;
            }
        }
        simOperatorName = "none";
        com.opos.cmn.an.f.a.b("TelMgrTool", "getSimOperator=" + simOperatorName);
        return simOperatorName;
    }

    public static String d(Context context) {
        TelephonyManager a2;
        String simOperator;
        if (context != null) {
            try {
                a2 = a(context);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("TelMgrTool", "", e);
            }
            if (a2 != null) {
                simOperator = a2.getSimOperator();
                com.opos.cmn.an.f.a.b("TelMgrTool", "getSimOperatorNumeric=" + simOperator);
                return simOperator;
            }
        }
        simOperator = "none";
        com.opos.cmn.an.f.a.b("TelMgrTool", "getSimOperatorNumeric=" + simOperator);
        return simOperator;
    }

    public static String e(Context context) {
        String a2;
        if (context != null) {
            try {
                a2 = a(d(context));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("TelMgrTool", "", e);
            }
            com.opos.cmn.an.f.a.b("TelMgrTool", "getOperatorByNumeric=" + a2);
            return a2;
        }
        a2 = "none";
        com.opos.cmn.an.f.a.b("TelMgrTool", "getOperatorByNumeric=" + a2);
        return a2;
    }
}
