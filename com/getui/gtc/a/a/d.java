package com.getui.gtc.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.base.util.ScheduleQueue;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/a/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static int f8267a = -1;
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static String f8268c = "";

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/a/d$a.class */
    static final class a implements InvocationHandler {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            g gVar;
            if (!"onResult".equalsIgnoreCase(method.getName()) || objArr == null) {
                return null;
            }
            try {
                if (objArr.length > 0) {
                    String str = (String) objArr[0];
                    JSONObject jSONObject = new JSONObject(str);
                    com.getui.gtc.i.c.a.d("ct prelg result: ".concat(String.valueOf(str)));
                    jSONObject.optInt("result", -1);
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        gVar = d.b(optJSONObject.optString("number"));
                    } else {
                        com.getui.gtc.i.c.a.d("ct prelg error.");
                        gVar = new g(-9);
                    }
                    final g gVar2 = gVar;
                    ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.a.a.d.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.getui.gtc.a.f.a(3, gVar2);
                        }
                    });
                    return null;
                }
                return null;
            } catch (Throwable th) {
                com.getui.gtc.i.c.a.b(th);
                return null;
            }
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/a/d$b.class */
    static final class b implements InvocationHandler {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            g gVar;
            if (!"onResult".equalsIgnoreCase(method.getName()) || objArr == null) {
                return null;
            }
            try {
                if (objArr.length > 0) {
                    int i = 0;
                    String str = (String) objArr[0];
                    JSONObject jSONObject = new JSONObject(str);
                    com.getui.gtc.i.c.a.d("cu prelg result: ".concat(String.valueOf(str)));
                    int optInt = jSONObject.optInt(ProcessBridgeProvider.KEY_RESULT_CODE, -1);
                    JSONObject optJSONObject = jSONObject.optJSONObject(ProcessBridgeProvider.KEY_RESULT_DATA);
                    if (optInt != 0 || optJSONObject == null) {
                        gVar = new g(-9, d.f8268c, "");
                    } else {
                        String optString = optJSONObject.optString("mobile", "");
                        if (TextUtils.isEmpty(optString)) {
                            i = -9;
                        }
                        gVar = new g(i, d.f8268c, optString);
                    }
                    final g gVar2 = gVar;
                    ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.a.a.d.b.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.getui.gtc.a.f.a(2, gVar2);
                        }
                    });
                    return null;
                }
                return null;
            } catch (Throwable th) {
                com.getui.gtc.i.c.a.b(th);
                return null;
            }
        }
    }

    public static int a(Context context) {
        try {
            String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            com.getui.gtc.i.c.a.d("PM operator ".concat(String.valueOf(simOperator)));
            boolean z = true;
            int hashCode = simOperator.hashCode();
            if (hashCode != 49679479) {
                if (hashCode != 49679502) {
                    switch (hashCode) {
                        case 49679470:
                            if (simOperator.equals("46000")) {
                                z = false;
                                break;
                            }
                            break;
                        case 49679471:
                            if (simOperator.equals("46001")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679472:
                            if (simOperator.equals("46002")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679473:
                            if (simOperator.equals("46003")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679474:
                            if (simOperator.equals("46004")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679475:
                            if (simOperator.equals("46005")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679476:
                            if (simOperator.equals("46006")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679477:
                            if (simOperator.equals("46007")) {
                                z = true;
                                break;
                            }
                            break;
                    }
                } else if (simOperator.equals("46011")) {
                    z = true;
                }
            } else if (simOperator.equals("46009")) {
                z = true;
            }
            switch (z) {
                case false:
                case true:
                case true:
                case true:
                    return 1;
                case true:
                case true:
                case true:
                    return 2;
                case true:
                case true:
                case true:
                    return 3;
                default:
                    return 4;
            }
        } catch (Exception e) {
            com.getui.gtc.i.c.a.b(e);
            return 4;
        }
    }

    public static boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) GtcProvider.context().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || "none".equalsIgnoreCase(str)) {
            return false;
        }
        String[] split = str.split(",");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            String str2 = split[i2];
            try {
                Class.forName(str2 + ".UniAccountHelper");
                b = str2;
                return true;
            } catch (Throwable th) {
                com.getui.gtc.i.c.a.b(th);
                i = i2 + 1;
            }
        }
    }

    public static int b() {
        try {
            String str = new String(com.getui.gtc.a.a.b.a("Y24uY29tLmNoaW5hdGVsZWNvbS5hY2NvdW50LnNkay4="));
            Class.forName(str + "CtAuth");
            f8267a = 1;
            return 1;
        } catch (Throwable th) {
            try {
                String str2 = new String(com.getui.gtc.a.a.b.a("Y24uY29tLmNoaW5hdGVsZWNvbS5hY2NvdW50LmFwaS4="));
                Class.forName(str2 + "CtAuth");
                f8267a = 2;
                return 2;
            } catch (Throwable th2) {
                f8267a = -1;
                return -1;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.getui.gtc.a.a.g b(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.a.a.d.b(java.lang.String):com.getui.gtc.a.a.g");
    }

    public static boolean b(Context context) {
        try {
            if (i()) {
                return false;
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
                return false;
            }
            String country = Locale.getDefault().getCountry();
            if (TextUtils.isEmpty(country) || !country.equals("CN") || CommonUtil.isAppDebugEnable()) {
                return false;
            }
            return !c(context);
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
            return false;
        }
    }

    public static boolean c() {
        try {
            String str = new String(com.getui.gtc.a.a.b.a("Y24uY29tLmNoaW5hdGVsZWNvbS5hY2NvdW50LmFwaS4="));
            int b2 = b();
            if (b2 == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("a");
                return !TextUtils.isEmpty((String) Class.forName(sb.toString()).getField("a").get(null));
            } else if (b2 != 2) {
                return false;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("CtAuth");
                return !TextUtils.isEmpty((String) Class.forName(sb2.toString()).getField("mAppId").get(null));
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
            return false;
        }
    }

    private static boolean c(Context context) {
        try {
            if (!CommonUtil.isAppForeground()) {
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
                return registerReceiver == null || registerReceiver.getExtras() == null || registerReceiver.getExtras().getInt(BatteryManager.EXTRA_PLUGGED) == 2;
            }
            boolean z = Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
            Intent registerReceiver2 = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            if (registerReceiver2 == null || registerReceiver2.getExtras() == null) {
                return true;
            }
            return z && registerReceiver2.getExtras().getInt(BatteryManager.EXTRA_PLUGGED) == 2;
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
            return true;
        }
    }

    public static boolean d() {
        try {
            if (b == null) {
                return false;
            }
            Class<?> cls = Class.forName(b + ".UniAccountHelper");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mContext");
            declaredField.setAccessible(true);
            return ((Context) declaredField.get(invoke)) != null;
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
            return false;
        }
    }

    public static g e() {
        String str;
        int i;
        String str2;
        try {
            Class<?> cls = Class.forName(b + ".UniAccountHelper");
            i = 0;
            f8268c = (String) cls.getMethod("getSdkVersion", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            str = (String) Class.forName(b + ".f.h").getMethod("c", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            th = th;
            str = "";
        }
        try {
            str2 = str;
            if (TextUtils.isEmpty(str)) {
                i = -4;
                str2 = str;
            }
        } catch (Throwable th2) {
            th = th2;
            i = -5;
            com.getui.gtc.i.c.a.b(th);
            str2 = str;
            return new g(i, f8268c, str2);
        }
        return new g(i, f8268c, str2);
    }

    public static void f() {
        try {
            String str = b + ".UniAccountHelper";
            String str2 = b + ".ResultListener";
            com.getui.gtc.i.c.a.d("strUniAccountHelper: " + str + ", strResultListener: " + str2);
            Class<?> cls = Class.forName(str);
            Method method = cls.getMethod("getInstance", new Class[0]);
            Class<?> cls2 = Class.forName(str2);
            cls.getMethod("preGetToken", Integer.TYPE, cls2).invoke(method.invoke(null, new Object[0]), 5000, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new b((byte) 0)));
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
            com.getui.gtc.a.f.a(2, new g(-9));
        }
    }

    public static void g() {
        try {
            String str = new String(com.getui.gtc.a.a.b.a("Y24uY29tLmNoaW5hdGVsZWNvbS5hY2NvdW50LnNkay4="));
            String str2 = new String(com.getui.gtc.a.a.b.a("Y24uY29tLmNoaW5hdGVsZWNvbS5hY2NvdW50LmFwaS4="));
            String str3 = str2 + "CtSetting";
            com.getui.gtc.i.c.a.d("prefixOfficial: " + str + ", prefixCustom: " + str2);
            if (f8267a != 1) {
                str = str2;
            }
            Class<?> cls = Class.forName(str + "CtAuth");
            Class<?> cls2 = Class.forName(str3);
            Class<?> cls3 = Class.forName(str + "ResultListener");
            cls.getMethod("requestPreLogin", cls2, cls3).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), null, Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new a((byte) 0)));
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
            com.getui.gtc.a.f.a(3, new g(-9));
        }
    }

    private static boolean i() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                Iterator it = Collections.list(networkInterfaces).iterator();
                while (it.hasNext()) {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0 && ("tun0".equals(networkInterface.getName()) || "ppp0".equals(networkInterface.getName()))) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
            return false;
        }
    }
}
