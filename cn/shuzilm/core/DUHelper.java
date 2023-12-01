package cn.shuzilm.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.android.internal.telephony.PhoneConstants;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/DUHelper.class */
public class DUHelper extends PhoneStateListener {
    public static final int MAIN_DU_ASYNCHRONOUS = 1;
    public static final int MAIN_DU_SYNCHRONOUS = 0;
    private static final String a = "du.lock";
    private static final String b = "du";
    private static AIClient c;
    public static Context mContext;
    public static int mMeic;
    public static int mPopu;
    public static int mPort;
    public static int mSplt;
    private static s s;
    private int v = 2;
    private boolean w = false;
    private long x = 0;
    private static final DUHelper d = new DUHelper();
    private static final Lock e = new ReentrantLock();
    private static final Lock f = new ReentrantLock();
    private static final ReentrantReadWriteLock g = new ReentrantReadWriteLock();
    private static boolean h = false;
    private static String i = null;
    private static String j = null;
    private static final JSONObject k = new JSONObject();
    private static final JSONObject l = new JSONObject();
    private static JSONObject m = null;
    private static final ThreadLocal n = new ThreadLocal();
    private static String o = null;
    private static JSONObject p = new JSONObject();
    private static final ExecutorService q = Executors.newSingleThreadExecutor();
    private static final ExecutorService r = Executors.newSingleThreadExecutor();
    private static Timer t = null;
    private static TimerTask u = new g();

    private DUHelper() {
    }

    public static String Q3VzdG(Context context, String str) {
        if (str == null) {
            return null;
        }
        String packageName = context.getPackageName();
        return context.getSharedPreferences(packageName + "_dna", 0).getString(str, null);
    }

    public static void ZVTFJRA(Context context, Listener listener) {
        try {
            r.execute(new f(b(context), listener));
        } catch (Exception e2) {
            listener.handler("NA_E");
            e2.printStackTrace();
        }
    }

    public static void ZVTFJRAAsyn(Context context, DUListener dUListener) {
        try {
            r.execute(new e(b(context), dUListener));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String a(Context context, String str, String str2, int i2) {
        try {
            if (!d.d(context)) {
                Log.e("[shuzilm]", "network is unavailable.");
                return null;
            }
            setConfig("apiKey", i);
            a(context, l, str);
            a(k, str2);
            String query = query(context, l.toString(), k.toString(), i2);
            if (query != null && !query.isEmpty()) {
                dl.d(mContext, query);
            }
            return query;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (UnsatisfiedLinkError e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private void a(Context context, int i2) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.x > 7000) {
                q.execute(new q(this, i2));
                this.x = currentTimeMillis;
            }
        } catch (Exception e2) {
        }
    }

    private void a(Context context, SensorManager sensorManager, Sensor sensor) {
        sensorManager.registerListener(new c(this, context, sensorManager), sensor, 1);
    }

    private void a(Context context, String str, String str2, DUListener dUListener) {
        try {
            q.execute(new a(this, context, str, str2, dUListener));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, String str, String str2, Listener listener, int i2) {
        try {
            q.execute(new b(this, context, str, str2, i2, listener));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, String str, String str2, String str3, DUListener dUListener) {
        q.execute(new o(this, context, str, str2, str3, dUListener));
    }

    private void a(Context context, String str, String str2, String str3, Listener listener) {
        q.execute(new p(this, context, str, str2, str3, listener));
    }

    public void a(Context context, JSONObject jSONObject, String str) {
        String str2;
        try {
            if (jSONObject.isNull("store")) {
                String str3 = str;
                if (str == null) {
                    String f2 = f(context);
                    str3 = f2;
                    if (f2 == null) {
                        str3 = (String) c(context, "store");
                    }
                }
                if (str3 != null) {
                    jSONObject.put("store", str3);
                }
            }
            if (!jSONObject.isNull("apiKey") || (str2 = (String) c(context, "apiKey")) == null) {
                return;
            }
            jSONObject.put("apiKey", str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, String str2) {
        try {
            JSONObject jSONObject = (JSONObject) n.get();
            if (jSONObject != null) {
                jSONObject.put(str, str2);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, str2);
            n.set(jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject, String str) {
        a(jSONObject, "custom", str);
    }

    private void a(JSONObject jSONObject, String str, String str2) {
        jSONObject.put(str, str2);
    }

    public static native void aXZlZWNl(Context context, Intent intent);

    private static Context b(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                return applicationContext;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return context;
    }

    public String b(Context context, int i2) {
        String str;
        try {
            str = c6M2YmYQ(context, i2);
        } catch (Exception e2) {
            str = null;
        }
        if (i2 != 1) {
            a(context, i2);
        }
        return str;
    }

    private String b(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    open.close();
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (IOException e2) {
            return null;
        }
    }

    public String b(Context context, String str, String str2, String str3) {
        String onEvent;
        try {
            if (!d.d(context)) {
                Log.e("[shuzilm]", "network is unavailable.");
                return null;
            }
            a("pEventCode", str);
            if (str2 != null) {
                a("mEventCode", str2);
            }
            String jSONObject = n.get() != null ? ((JSONObject) n.get()).toString() : null;
            String jSONObject2 = k.toString();
            synchronized (this) {
                onEvent = onEvent(context, jSONObject, jSONObject2, str3);
            }
            return onEvent;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (UnsatisfiedLinkError e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static void bm(Context context, String str) {
        try {
            q.execute(new h(b(context), str));
        } catch (Exception e2) {
        }
    }

    private static int c(Context context) {
        String packageName = context.getPackageName();
        try {
            int i2 = (int) context.getPackageManager().getPackageInfo(packageName, 0).firstInstallTime;
            int hashCode = (packageName + Build.MODEL).hashCode();
            int i3 = hashCode;
            if (hashCode < 0) {
                i3 = -hashCode;
            }
            mPort = (i3 % 5000) + 12000 + (i2 % 10000);
            return 0;
        } catch (Exception e2) {
            mPort = 17835;
            e2.printStackTrace();
            return -1;
        }
    }

    private Object c(Context context, String str) {
        try {
            JSONObject jSONObject = m;
            JSONObject jSONObject2 = jSONObject;
            if (jSONObject == null) {
                jSONObject2 = e(context);
                m = jSONObject2;
            }
            return jSONObject2.opt(str);
        } catch (Exception e2) {
            return null;
        }
    }

    private static native String c6M2YmYQ(Context context, int i2);

    private String d(Context context, String str) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private boolean d(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (Build.VERSION.SDK_INT > 23) {
                return connectivityManager.getActiveNetwork() != null;
            }
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static native void dGZvcmRQ(Context context, String str, String str2);

    private JSONObject e(Context context) {
        String b2 = b(context, "cn.shuzilm.config.json");
        if (b2 != null) {
            return new JSONObject(b2);
        }
        return null;
    }

    private String f(Context context) {
        try {
            Object c2 = d.c(context, "store");
            if (c2 instanceof String) {
                return null;
            }
            return d.d(context, new JSONObject(c2.toString()).getJSONObject("metadata").getString("name"));
        } catch (Exception e2) {
            return null;
        }
    }

    public static void f2c071(int i2, Listener listener) {
        try {
            Context b2 = b(mContext);
            if (d.w && b2 != null && i != null) {
                if (i2 != 1) {
                    listener.handler(d.b(b2, i2));
                    return;
                }
                getQueryID(mContext, "NA", "", 1, new r(b2, i2, listener), i2 + 100);
                return;
            }
            Log.e("[shuzilm]", "sdk init error.");
        } catch (Exception e2) {
        }
    }

    public String g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_dna", 0);
        String str = null;
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("device_id", null);
        }
        return str;
    }

    private static void g() {
        if (h) {
            return;
        }
        try {
            new Thread(new l()).start();
            h = true;
        } catch (Throwable th) {
        }
    }

    public static String getQueryID(Context context, String str, String str2) {
        try {
            return (String) getQueryID(context, str, str2, 0, null, 2).get("device_id");
        } catch (NullPointerException e2) {
            return "";
        }
    }

    public static Map getQueryID(Context context, String str, String str2, int i2, Listener listener, int i3) {
        try {
            HashMap hashMap = new HashMap();
            Context b2 = b(context);
            d.v = i3;
            if (i2 == 1) {
                d.a(b2, str, str2, listener, i3);
                return null;
            } else if (!e.tryLock()) {
                String g2 = d.g(b2);
                if (g2 == null) {
                    d.a(b2, str, str2, listener, i3);
                }
                hashMap.put("device_id", g2);
                hashMap.put("valid", "0");
                return hashMap;
            } else {
                String a2 = d.a(b2, str, str2, i3);
                boolean z = "0";
                if (a2 != null) {
                    o = a2;
                    z = "1";
                }
                String str3 = a2;
                if (a2 == null) {
                    str3 = o != null ? o : d.g(b2);
                }
                hashMap.put("device_id", str3);
                hashMap.put("valid", z);
                e.unlock();
                return hashMap;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Map getQueryIDDUCallback(Context context, String str, String str2, int i2, DUListener dUListener) {
        try {
            HashMap hashMap = new HashMap();
            Context b2 = b(context);
            if (i2 == 1) {
                d.a(b2, str, str2, dUListener);
                return null;
            } else if (!e.tryLock()) {
                String g2 = d.g(b2);
                if (g2 == null) {
                    d.a(b2, str, str2, dUListener);
                }
                hashMap.put("device_id", g2);
                hashMap.put("valid", "0");
                return hashMap;
            } else {
                String a2 = d.a(b2, str, str2, d.v);
                boolean z = "0";
                if (a2 != null) {
                    o = a2;
                    z = "1";
                }
                String str3 = a2;
                if (a2 == null) {
                    str3 = o != null ? o : d.g(b2);
                }
                hashMap.put("device_id", str3);
                hashMap.put("valid", z);
                e.unlock();
                return hashMap;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0047 -> B:31:0x0038). Please submit an issue!!! */
    public static void go(Context context, String str, String str2) {
        try {
            Context b2 = b(context);
            if (!d.d(b2)) {
                Log.e("[shuzilm]", "network is unavailable.");
            } else if (e.tryLock()) {
                try {
                    q.execute(new m(b2, str, str2));
                } catch (Exception e2) {
                }
                e.unlock();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void h(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(9);
        if (defaultSensor != null) {
            a(context, sensorManager, defaultSensor);
        }
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(3);
        if (defaultSensor2 != null) {
            a(context, sensorManager, defaultSensor2);
        }
        Sensor defaultSensor3 = sensorManager.getDefaultSensor(11);
        if (defaultSensor3 != null) {
            a(context, sensorManager, defaultSensor3);
        }
        Sensor defaultSensor4 = sensorManager.getDefaultSensor(6);
        if (defaultSensor4 != null) {
            a(context, sensorManager, defaultSensor4);
        }
        Sensor defaultSensor5 = sensorManager.getDefaultSensor(1);
        if (defaultSensor5 != null) {
            a(context, sensorManager, defaultSensor5);
        }
        Sensor defaultSensor6 = sensorManager.getDefaultSensor(4);
        if (defaultSensor6 != null) {
            a(context, sensorManager, defaultSensor6);
        }
        Sensor defaultSensor7 = sensorManager.getDefaultSensor(5);
        if (defaultSensor7 != null) {
            a(context, sensorManager, defaultSensor7);
        }
        Sensor defaultSensor8 = sensorManager.getDefaultSensor(2);
        if (defaultSensor8 != null) {
            a(context, sensorManager, defaultSensor8);
        }
    }

    public static void i(Context context) {
        if (d.d(context)) {
            try {
                if (!y.a(context) || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
                NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
                i iVar = new i(context);
                oxlbmV0d(context, iVar, 2);
                connectivityManager.requestNetwork(build, iVar);
            } catch (Throwable th) {
            }
        }
    }

    public static void init(Context context, String str) {
        try {
            mContext = b(context);
            FileOutputStream openFileOutput = context.openFileOutput(a, 0);
            FileLock tryLock = openFileOutput.getChannel().tryLock();
            if (!tryLock.isValid()) {
                openFileOutput.close();
                return;
            }
            g();
            c(mContext);
            i = str;
            q.execute(new k(context));
            tryLock.release();
            openFileOutput.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (UnsatisfiedLinkError e3) {
            e3.printStackTrace();
        }
    }

    public static void loadLibrary() {
        q.execute(new j());
    }

    private static native String onEvent(Context context, String str, String str2, String str3);

    public static Map onEvent(Context context, String str, String str2, int i2, Listener listener) {
        if (str == null) {
            return null;
        }
        try {
            Context b2 = b(context);
            if (i2 == 1) {
                d.a(b2, str, (String) null, str2, listener);
                return null;
            }
            HashMap hashMap = new HashMap();
            if (!e.tryLock()) {
                d.a(b2, str, (String) null, str2, listener);
                return null;
            }
            hashMap.put("SessionID", d.b(b2, str, null, str2));
            hashMap.put("QueryID", o);
            e.unlock();
            return hashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Map onEventDUCallback(Context context, String str, String str2, String str3, int i2, DUListener dUListener) {
        try {
            HashMap hashMap = new HashMap();
            if (str == null) {
                return null;
            }
            Context b2 = b(context);
            if (i2 == 1) {
                d.a(b2, str, str2, str3, dUListener);
                return null;
            } else if (!e.tryLock()) {
                d.a(b2, str, str2, str3, dUListener);
                return null;
            } else {
                hashMap.put("SessionID", d.b(b2, str, str2, str3));
                hashMap.put("QueryID", o);
                e.unlock();
                return hashMap;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static native String onIEvent(Context context, String str, String str2, String str3);

    public static void onIEvent(Context context, String str) {
        try {
            q.execute(new d(str, b(context)));
        } catch (Exception e2) {
        }
    }

    private static native void onSSChanged(Context context, SignalStrength signalStrength);

    public static native void onSensorChanged(Context context, SensorEvent sensorEvent);

    public static native void oxlbmV0d(Context context, Object obj, int i2);

    private static native String query(Context context, String str, String str2, int i2);

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0047 -> B:31:0x0038). Please submit an issue!!! */
    public static void report(Context context, String str, String str2) {
        try {
            Context b2 = b(context);
            if (!d.d(b2)) {
                Log.e("[shuzilm]", "network is unavailable.");
            } else if (e.tryLock()) {
                try {
                    q.execute(new n(b2, str, str2));
                } catch (Exception e2) {
                }
                e.unlock();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static native String reportRun(Context context, String str, String str2);

    public static native String run(Context context, String str, String str2);

    public static int setConfig(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        d.a(l, str, str2);
        return 0;
    }

    public static int setData(String str, String str2) {
        d.a(k, str, str2);
        return 0;
    }

    public static int sl(Context context, IntentFilter intentFilter) {
        try {
            if (s == null) {
                s = new s(null);
            }
            if (t == null) {
                context.registerReceiver(s, intentFilter);
                Timer timer = new Timer();
                t = timer;
                timer.schedule(u, 10000L);
                return 0;
            }
            return 0;
        } catch (Exception e2) {
            return 0;
        }
    }

    public static String startService(Context context, ServiceConnection serviceConnection, String str, int i2) {
        try {
            Context b2 = b(context);
            String packageName = b2.getPackageName();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(packageName, DUService.class.getName()));
            intent.putExtra("apikey", str);
            b2.bindService(intent, serviceConnection, 1);
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int ul(int i2) {
        try {
            mContext.unregisterReceiver(s);
        } catch (Exception e2) {
        }
        if (i2 == 0) {
            try {
                Intent intent = new Intent();
                intent.setAction("MTZiMjcx");
                aXZlZWNl(mContext, intent);
                if (t != null) {
                    t.cancel();
                    t = null;
                    return -1;
                }
                return -1;
            } catch (Exception e3) {
                return -1;
            }
        }
        return -1;
    }

    public static int unResListener() {
        try {
            ((TelephonyManager) mContext.getSystemService(PhoneConstants.PHONE_KEY)).listen(d, 0);
            return 0;
        } catch (Exception e2) {
            return -1;
        }
    }

    public static native String zZVTFJRA(Context context, String str);

    @Override // android.telephony.PhoneStateListener
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        try {
            onSSChanged(mContext, signalStrength);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }
}
