package cn.shuzilm.core;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/Main.class */
public class Main {
    public static final int DU_ASYNCHRONOUS = 1;
    public static final int DU_SYNCHRONOUS = 0;
    public static final Lock mLock = new ReentrantLock();

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f4166a = Executors.newSingleThreadExecutor();
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Context f4167c = null;
    private static DUConnection d = new DUConnection();
    private static int e = 0;

    public static void exitService() {
        try {
            f4167c.unbindService(d);
        } catch (Exception e2) {
        }
    }

    public static void getDeviceLabel(int i, Listener listener) {
        DUHelper.f2c071(i, listener);
    }

    public static Map getNewQueryID(Context context, String str, String str2, int i, Listener listener) {
        try {
            return DUHelper.getQueryID(context, str, str2, i, listener, 3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void getOpenAnmsID(Context context, Listener listener) {
        DUHelper.ZVTFJRA(context, listener);
    }

    public static String getQueryID(Context context, String str, String str2) {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            if (Looper.myLooper() != null) {
                return DUHelper.getQueryID(context, str, str2);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getQueryID(String str, String str2, DUListener dUListener) {
        if (!b) {
            Log.e("[shuzilm]", "[NEED SERVICE ALIVE]");
            return "";
        }
        try {
            f4166a.execute(new x(str, str2, dUListener));
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Map getQueryID(Context context, String str, String str2, int i, Listener listener) {
        try {
            return DUHelper.getQueryID(context, str, str2, i, listener, 2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getSpecificID(Context context, String str) {
        return DUHelper.Q3VzdG(context, str);
    }

    public static void go(Context context, String str, String str2) {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            if (Looper.myLooper() != null) {
                DUHelper.go(context, str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void init(Context context, String str) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (Looper.myLooper() != null) {
            DUHelper.init(context, str);
        }
    }

    public static void initService(Context context, String str) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (Looper.myLooper() != null) {
            try {
                b = true;
                f4167c = context;
                mLock.lock();
                DUHelper.startService(context, d, str, 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Map onEvent(Context context, String str, String str2, int i, Listener listener) {
        try {
            return DUHelper.onEvent(context, str, str2, i, listener);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void onEvent(String str, String str2, String str3, DUListener dUListener) {
        if (!b) {
            Log.e("[shuzilm]", "[NEED SERVICE ALIVE]");
            return;
        }
        try {
            f4166a.execute(new w(str, str2, str3, dUListener));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void report(Context context, String str, String str2) {
        try {
            DUHelper.report(context, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int setConfig(String str, String str2) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (b) {
            f4166a.execute(new v(str, str2));
            return e;
        }
        return DUHelper.setConfig(str, str2);
    }

    public static int setData(String str, String str2) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (b) {
            f4166a.execute(new u(str, str2));
            return e;
        }
        return DUHelper.setData(str, str2);
    }
}
