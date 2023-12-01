package com.blued.android.framework.utils;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/SharedPreferencesUtils.class */
public class SharedPreferencesUtils {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f10114a;
    private static SharedPreferences b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/SharedPreferencesUtils$ActivityThreadHCallBack.class */
    public static class ActivityThreadHCallBack implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 115) {
                SpBlockHelper.a("SERVICE_ARGS");
                return false;
            } else if (i == 116) {
                SpBlockHelper.a("STOP_SERVICE");
                return false;
            } else if (i == 137) {
                SpBlockHelper.a("SLEEPING");
                return false;
            } else {
                switch (i) {
                    case 101:
                        SpBlockHelper.a("PAUSE_ACTIVITY");
                        return false;
                    case 102:
                        SpBlockHelper.a("PAUSE_ACTIVITY_FINISHING");
                        return false;
                    case 103:
                        SpBlockHelper.a("STOP_ACTIVITY_SHOW");
                        return false;
                    case 104:
                        SpBlockHelper.a("STOP_ACTIVITY_HIDE");
                        return false;
                    default:
                        return false;
                }
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/SharedPreferencesUtils$SpBlockHelper.class */
    public static class SpBlockHelper {

        /* renamed from: a  reason: collision with root package name */
        static boolean f10115a = false;
        static String b = "android.app.QueuedWork";

        /* renamed from: c  reason: collision with root package name */
        static String f10116c = "sPendingWorkFinishers";
        static ConcurrentLinkedQueue<Runnable> d;

        static void a() {
            try {
                Field declaredField = Class.forName(b).getDeclaredField(f10116c);
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    d = (ConcurrentLinkedQueue) declaredField.get(null);
                }
                Log.i("tryHackActivityThreadH", "getPendingWorkFinishers");
            } catch (Exception e) {
                Log.e("tryHackActivityThreadH", "getPendingWorkFinishers", e);
            }
        }

        public static void a(String str) {
            if (!f10115a) {
                a();
                f10115a = true;
            }
            Log.d("tryHackActivityThreadH", "beforeSPBlock " + str);
            ConcurrentLinkedQueue<Runnable> concurrentLinkedQueue = d;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.clear();
                Log.i("tryHackActivityThreadH", "beforeSPBlock clear ----");
            }
        }
    }

    public static SharedPreferences a() {
        if (b == null) {
            b = PreferenceManager.getDefaultSharedPreferences(AppUtils.a());
        }
        return b;
    }

    public static SharedPreferences b() {
        if (f10114a == null) {
            f10114a = AppUtils.a().getSharedPreferences("blued_common", 0);
        }
        return f10114a;
    }

    public static void c() {
        if (Build.VERSION.SDK_INT < 26) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mH");
                declaredField.setAccessible(true);
                Handler handler = (Handler) declaredField.get(invoke);
                Field declaredField2 = Handler.class.getDeclaredField("mCallback");
                declaredField2.setAccessible(true);
                declaredField2.set(handler, new ActivityThreadHCallBack());
                Log.i("tryHackActivityThreadH", "hook success");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
