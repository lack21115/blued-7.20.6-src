package com.meizu.cloud.pushsdk.d.f;

import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/f/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10515a = e.class.getSimpleName();

    public static long a(String str) {
        long j;
        long j2;
        long j3 = 0;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                j2 = 1;
            } else if (charAt <= 2047) {
                j2 = 2;
            } else {
                if (charAt >= 55296 && charAt <= 57343) {
                    j = j3 + 4;
                    i++;
                } else if (charAt < 65535) {
                    j2 = 3;
                } else {
                    j = j3 + 4;
                }
                i++;
                j3 = j;
            }
            j = j3 + j2;
            i++;
            j3 = j;
        }
        return j3;
    }

    private static Object a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            return obj;
        }
        if (obj == null) {
            return JSONObject.NULL;
        }
        Object obj2 = obj;
        if (!(obj instanceof JSONObject)) {
            if (obj instanceof JSONArray) {
                return obj;
            }
            if (obj instanceof Collection) {
                JSONArray jSONArray = new JSONArray();
                for (Object obj3 : (Collection) obj) {
                    jSONArray.put(a(obj3));
                }
                return jSONArray;
            } else if (obj.getClass().isArray()) {
                JSONArray jSONArray2 = new JSONArray();
                int length = Array.getLength(obj);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return jSONArray2;
                    }
                    jSONArray2.put(a(Array.get(obj, i2)));
                    i = i2 + 1;
                }
            } else if (obj instanceof Map) {
                return a((Map) obj);
            } else {
                obj2 = obj;
                if (!(obj instanceof Boolean)) {
                    obj2 = obj;
                    if (!(obj instanceof Byte)) {
                        obj2 = obj;
                        if (!(obj instanceof Character)) {
                            obj2 = obj;
                            if (!(obj instanceof Double)) {
                                obj2 = obj;
                                if (!(obj instanceof Float)) {
                                    obj2 = obj;
                                    if (!(obj instanceof Integer)) {
                                        obj2 = obj;
                                        if (!(obj instanceof Long)) {
                                            obj2 = obj;
                                            if (!(obj instanceof Short)) {
                                                if (obj instanceof String) {
                                                    return obj;
                                                }
                                                if (obj.getClass().getPackage().getName().startsWith("java.")) {
                                                    return obj.toString();
                                                }
                                                obj2 = null;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return obj2;
    }

    public static String a() {
        return Long.toString(System.currentTimeMillis());
    }

    public static JSONObject a(Map map) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new JSONObject(map);
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object a2 = a(entry.getValue());
            try {
                jSONObject.put(str, a2);
            } catch (JSONException e) {
                c.a(f10515a, "Could not put key '%s' and value '%s' into new JSONObject: %s", str, a2, e);
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static boolean a(long j, long j2, long j3) {
        return j > j2 - j3;
    }

    public static boolean a(Context context) {
        try {
            c.c(f10515a, "Checking tracker internet connectivity.", new Object[0]);
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            c.b(f10515a, "Tracker connection online: %s", Boolean.valueOf(z));
            return z;
        } catch (Exception e) {
            c.a(f10515a, "Security exception checking connection: %s", e.toString());
            return true;
        }
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    public static String b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
            return null;
        } catch (Exception e) {
            c.a(f10515a, "getCarrier: %s", e.toString());
            return null;
        }
    }

    public static String c(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getSimOperator();
            }
            return null;
        } catch (Exception e) {
            String str = f10515a;
            c.a(str, "getOperator error " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static Point d(Context context) {
        Point point = new Point();
        Display display = null;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager == null) {
                return null;
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Display.class.getMethod("getSize", Point.class);
            display = defaultDisplay;
            defaultDisplay.getSize(point);
            return point;
        } catch (Exception e) {
            c.a(f10515a, "Display.getSize isn't available on older devices.", new Object[0]);
            if (display == null) {
                c.a(f10515a, "error get display", new Object[0]);
                return point;
            }
            point.x = display.getWidth();
            point.y = display.getHeight();
            return point;
        }
    }
}
