package com.opos.cmn.an.h.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/h/c/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static ConnectivityManager f10874a;
    private static TelephonyManager b;

    public static TelephonyManager a(Context context) {
        if (b == null && context != null) {
            b = (TelephonyManager) context.getSystemService("phone");
        }
        return b;
    }

    private static String a(int i) {
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "CDMA - EvDo rev. 0";
            case 6:
                return "CDMA - EvDo rev. A";
            case 7:
                return "CDMA - 1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDEN";
            case 12:
                return "CDMA - EvDo rev. B";
            case 13:
                return "LTE";
            case 14:
                return "CDMA - eHRPD";
            case 15:
                return "HSPA+";
            case 16:
                return "GSM";
            case 17:
                return "TD_SCDMA";
            case 18:
                return "IWLAN";
            case 19:
                return "LTE_CA";
            case 20:
                return "NR";
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static ConnectivityManager b(Context context) {
        if (f10874a == null && context != null) {
            f10874a = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        }
        return f10874a;
    }

    public static boolean c(Context context) {
        boolean z;
        ConnectivityManager b2;
        NetworkInfo activeNetworkInfo;
        try {
            b2 = b(context);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
        }
        if (b2 != null && (activeNetworkInfo = b2.getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.getType() == 0) {
                z = true;
                com.opos.cmn.an.f.a.b("ConnMgrTool", "isMobileActive=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("ConnMgrTool", "isMobileActive=" + z);
        return z;
    }

    public static boolean d(Context context) {
        boolean z;
        ConnectivityManager b2;
        NetworkInfo activeNetworkInfo;
        try {
            b2 = b(context);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
        }
        if (b2 != null && (activeNetworkInfo = b2.getActiveNetworkInfo()) != null) {
            if (NetworkInfo.State.CONNECTED == activeNetworkInfo.getState()) {
                z = true;
                com.opos.cmn.an.f.a.b("ConnMgrTool", "isNetAvailable=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("ConnMgrTool", "isNetAvailable=" + z);
        return z;
    }

    public static boolean e(Context context) {
        boolean z = false;
        if (context != null) {
            try {
                ConnectivityManager b2 = b(context);
                z = false;
                if (b2 != null) {
                    NetworkInfo activeNetworkInfo = b2.getActiveNetworkInfo();
                    z = false;
                    if (activeNetworkInfo != null) {
                        z = false;
                        if (activeNetworkInfo.getType() == 1) {
                            z = true;
                        }
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
                z = false;
            }
        }
        com.opos.cmn.an.f.a.b("ConnMgrTool", "isWifiActive=" + z);
        return z;
    }

    public static String f(Context context) {
        String str = "";
        if (context != null) {
            try {
                ConnectivityManager b2 = b(context);
                str = "";
                if (b2 != null) {
                    NetworkInfo activeNetworkInfo = b2.getActiveNetworkInfo();
                    str = "";
                    if (activeNetworkInfo != null) {
                        StringBuilder sb = new StringBuilder();
                        str = "";
                        if (activeNetworkInfo.getTypeName() != null) {
                            if ("WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
                                sb.append(activeNetworkInfo.getTypeName());
                            } else if (Build.VERSION.SDK_INT <= 29) {
                                str = "";
                                if (activeNetworkInfo.getSubtypeName() != null) {
                                    sb.append(activeNetworkInfo.getSubtypeName());
                                }
                            } else if (com.opos.cmn.an.h.d.a.a(context, "android.permission.READ_PHONE_STATE")) {
                                TelephonyManager a2 = a(context);
                                str = "";
                                if (a2 != null) {
                                    str = a(a2.getDataNetworkType());
                                }
                            } else {
                                str = "";
                                if (c(context)) {
                                    str = "mobile";
                                }
                            }
                            str = sb.toString();
                        }
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("ConnMgrTool", "getNetTypeName=" + str);
        return str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0064 -> B:27:0x006c). Please submit an issue!!! */
    public static int g(Context context) {
        ConnectivityManager b2;
        NetworkInfo activeNetworkInfo;
        int i;
        if (context != null) {
            try {
                b2 = b(context);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
            }
            if (b2 != null && (activeNetworkInfo = b2.getActiveNetworkInfo()) != null) {
                if (1 == activeNetworkInfo.getType()) {
                    i = -1;
                } else if (activeNetworkInfo.getType() == 0) {
                    if (Build.VERSION.SDK_INT <= 29) {
                        i = activeNetworkInfo.getSubtype();
                    } else if (com.opos.cmn.an.h.d.a.a(context, "android.permission.READ_PHONE_STATE")) {
                        TelephonyManager a2 = a(context);
                        if (a2 != null) {
                            i = a2.getDataNetworkType();
                        }
                    } else if (c(context)) {
                        i = -2;
                    }
                }
                com.opos.cmn.an.f.a.b("ConnMgrTool", "getNetType=" + i);
                return i;
            }
        }
        i = 0;
        com.opos.cmn.an.f.a.b("ConnMgrTool", "getNetType=" + i);
        return i;
    }

    public static String h(Context context) {
        String str;
        if (context != null) {
            try {
                int g = g(context);
                if (g == -2) {
                    str = "mobile";
                } else if (g == -1) {
                    str = "wifi";
                } else if (g != 20) {
                    switch (g) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = "2g";
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            str = "3g";
                            break;
                        case 13:
                            str = "4g";
                            break;
                    }
                } else {
                    str = NetworkUtil.NETWORK_CLASS_5G;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
            }
            com.opos.cmn.an.f.a.b("ConnMgrTool", "getNetEnv=" + str);
            return str;
        }
        str = "none";
        com.opos.cmn.an.f.a.b("ConnMgrTool", "getNetEnv=" + str);
        return str;
    }
}
