package cn.com.chinatelecom.account.api.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import com.igexin.assist.sdk.AssistPushConsts;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/e/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f4097a;
    public static String b;

    /* renamed from: c  reason: collision with root package name */
    public static String f4098c;
    public static String d = "0";
    private static final String[] e = {"46000", "46002", "46004", "46007", "46008"};
    private static final String[] f = {"46003", "46005", "46011"};
    private static final String[] g = {"46001", "46006", "46009"};

    private static int a(int i) {
        int i2 = -101;
        if (i != -101) {
            i2 = -1;
            if (i != -1) {
                switch (i) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 2;
                    case 13:
                    case 18:
                    case 19:
                        return 3;
                    case 20:
                        return 4;
                    default:
                        return i;
                }
            }
        }
        return i2;
    }

    public static NetworkInfo a(Context context) {
        if (context == null) {
            return null;
        }
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
    }

    public static String a() {
        return f4097a;
    }

    public static String a(Context context, boolean z) {
        String h = h(context);
        if (h != null) {
            String[] strArr = f;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    String[] strArr2 = e;
                    int length2 = strArr2.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length2) {
                            String[] strArr3 = g;
                            int length3 = strArr3.length;
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= length3) {
                                    break;
                                } else if (h.equals(strArr3[i6])) {
                                    return z ? "3" : "CU";
                                } else {
                                    i5 = i6 + 1;
                                }
                            }
                        } else if (h.equals(strArr2[i4])) {
                            return z ? "2" : "CM";
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                } else if (h.equals(strArr[i2])) {
                    return z ? "1" : AssistPushConsts.MSG_KEY_CONTENT;
                } else {
                    i = i2 + 1;
                }
            }
        }
        return z ? "0" : "UN";
    }

    public static String b() {
        return b != null ? "https://open.e.189.cn/openapi/special/getTimeStamp.do".replace(cn.com.chinatelecom.account.api.a.d.a(b.g), b) : "https://open.e.189.cn/openapi/special/getTimeStamp.do";
    }

    public static boolean b(Context context) {
        NetworkInfo a2 = a(context);
        return a2 != null && a2.isAvailable();
    }

    public static String c() {
        String str = f4098c;
        return str != null ? "https://api-e189.21cn.com/gw/client/accountMsg.do".replace("e189.21cn.com", str) : "https://api-e189.21cn.com/gw/client/accountMsg.do";
    }

    public static boolean c(Context context) {
        NetworkInfo a2 = a(context);
        return a2 != null && a2.getType() == 0;
    }

    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            CtAuth.warn("NetUtil", "isMobileEnable error ", th);
            return true;
        }
    }

    public static String e(Context context) {
        String str;
        int j = j(context);
        if (j != -101) {
            str = com.igexin.push.core.b.l;
            if (j != -1) {
                str = com.igexin.push.core.b.l;
                if (j != 0) {
                    return j != 1 ? j != 2 ? j != 3 ? j != 4 ? Integer.toString(j) : "5G" : "4G" : "3G" : "2G";
                }
            }
        } else {
            str = "WIFI";
        }
        return str;
    }

    public static String f(Context context) {
        String e2 = e(context);
        return (e2 != null && e2.equals("WIFI") && d(context)) ? "BOTH" : e2;
    }

    public static String g(Context context) {
        String f2 = f(context);
        return (TextUtils.isEmpty(f2) || f2.equals(com.igexin.push.core.b.l)) ? "15" : f2.equals("2G") ? "10" : f2.equals("3G") ? "11" : f2.equals("4G") ? "12" : f2.equals("5G") ? "16" : f2.equals("WIFI") ? "13" : f2.equals("BOTH") ? "14" : "15";
    }

    public static String h(Context context) {
        try {
            String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            return !TextUtils.isEmpty(simOperator) ? simOperator : "00000";
        } catch (Throwable th) {
            th.printStackTrace();
            return "00000";
        }
    }

    public static String i(Context context) {
        return a(context, true);
    }

    private static int j(Context context) {
        int i = 0;
        int i2 = 0;
        try {
            NetworkInfo a2 = a(context);
            if (a2 != null && a2.isAvailable() && a2.isConnected()) {
                int type = a2.getType();
                if (type == 1) {
                    i = -101;
                } else {
                    i = 0;
                    if (type == 0) {
                        try {
                            i2 = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            i2 = 0;
                        }
                        i = i2;
                        if (i2 == 0) {
                            i = i2;
                            i = a2.getSubtype();
                        }
                    }
                }
            } else {
                i = -1;
            }
        } catch (NullPointerException e3) {
            e3.printStackTrace();
            i = i2;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return a(i);
    }
}
