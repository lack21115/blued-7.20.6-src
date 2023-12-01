package com.getui.gtc.base.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.ProcessSwitchContract;
import com.getui.gtc.base.publish.Broker;
import com.getui.gtc.base.publish.Subscriber;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/util/CommonUtil.class */
public class CommonUtil {
    private static Boolean isAppDebug;

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/util/CommonUtil$CommonUtilSubscriber.class */
    static class CommonUtilSubscriber implements Subscriber {
        private static String getInstanceMethodName;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/util/CommonUtil$CommonUtilSubscriber$InstanceHolder.class */
        public static class InstanceHolder {
            private static final CommonUtilSubscriber instance = new CommonUtilSubscriber();

            private InstanceHolder() {
            }
        }

        private CommonUtilSubscriber() {
        }

        private Bundle createBundle() {
            Bundle bundle = new Bundle();
            bundle.putString(ProcessSwitchContract.CLASS_NAME, getClass().getName());
            bundle.putString(ProcessSwitchContract.GET_INSTANCE, getInstanceMethodName);
            return bundle;
        }

        public static CommonUtilSubscriber getInstance() {
            getInstanceMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            return InstanceHolder.instance;
        }

        public boolean isAppForeground() {
            try {
                if (CommonUtil.isGtcProcess()) {
                    return GtcProvider.isForeground();
                }
                Bundle createBundle = createBundle();
                createBundle.putString(ProcessSwitchContract.METHOD_NAME, "base-1-1-1");
                return Broker.getInstance().subscribe(createBundle).getBoolean(ProcessSwitchContract.METHOD_RETURN);
            } catch (Throwable th) {
                return false;
            }
        }

        @Override // com.getui.gtc.base.publish.Subscriber
        public void receive(Bundle bundle, Bundle bundle2) {
            ArrayList<Throwable> arrayList = new ArrayList();
            try {
                Throwable th = (Throwable) bundle2.getSerializable(ProcessSwitchContract.METHOD_EXCEPTION);
                if (th != null) {
                    arrayList.add(th);
                }
                String string = bundle.getString(ProcessSwitchContract.METHOD_NAME);
                if (TextUtils.isEmpty(string)) {
                    throw new RuntimeException("methodName missed");
                }
                boolean z = true;
                if (string.hashCode() == -1969640451 && string.equals("base-1-1-1")) {
                    z = false;
                }
                if (!z) {
                    bundle2.putBoolean(ProcessSwitchContract.METHOD_RETURN, isAppForeground());
                }
            } catch (Throwable th2) {
                try {
                    arrayList.add(th2);
                    for (Throwable th3 : arrayList) {
                        th3.printStackTrace();
                    }
                } finally {
                    for (Throwable th4 : arrayList) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    public static void checkRuntimePermission(Context context, String str, boolean z) throws Throwable {
        if (hasPermission(context, str, z)) {
            return;
        }
        throw new IllegalStateException("permission " + str + " not granted");
    }

    public static Context ensureAppContext(Context context) {
        Context context2 = context;
        if (context != null) {
            context2 = context.getApplicationContext();
        }
        Context context3 = context2;
        if (context2 == null) {
            context3 = GtcProvider.context();
        }
        Context context4 = context3;
        if (context3 == null) {
            context4 = findAppContext();
        }
        return context4;
    }

    public static Context findAppContext() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
            declaredMethod.setAccessible(true);
            return (Context) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getProcessName() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            String processNameByPid = getProcessNameByPid(Process.myPid());
            return !TextUtils.isEmpty(processNameByPid) ? processNameByPid : "unknown.process";
        }
    }

    private static String getProcessNameByPid(int i) {
        BufferedReader bufferedReader;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                String readLine = bufferedReader2.readLine();
                String str = readLine;
                if (!TextUtils.isEmpty(readLine)) {
                    str = readLine.trim();
                }
                try {
                    bufferedReader2.close();
                    return bufferedReader;
                } catch (IOException e) {
                    e.printStackTrace();
                    return bufferedReader;
                }
            } catch (Throwable th) {
                bufferedReader = bufferedReader2;
                th = th;
                try {
                    th.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return null;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static Activity getTopActivity() {
        Object next;
        Class<?> cls;
        Field declaredField;
        try {
            Class<?> cls2 = Class.forName("android.app.ActivityThread");
            Object invoke = cls2.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField2 = cls2.getDeclaredField("mActivities");
            declaredField2.setAccessible(true);
            Map map = Build.VERSION.SDK_INT < 19 ? (HashMap) declaredField2.get(invoke) : (ArrayMap) declaredField2.get(invoke);
            if (map.size() <= 0) {
                return null;
            }
            Iterator it = map.values().iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
                cls = next.getClass();
                declaredField = cls.getDeclaredField("paused");
                declaredField.setAccessible(true);
            } while (declaredField.getBoolean(next));
            Field declaredField3 = cls.getDeclaredField("activity");
            declaredField3.setAccessible(true);
            return (Activity) declaredField3.get(next);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean hasPermission(Context context, String str, boolean z) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            return z;
        }
    }

    public static boolean isAppDebugEnable() {
        if (GtcProvider.context() == null) {
            return false;
        }
        if (isAppDebug == null) {
            try {
                isAppDebug = Boolean.valueOf((GtcProvider.context().getApplicationInfo().flags & 2) != 0);
            } catch (Throwable th) {
                return false;
            }
        }
        return isAppDebug.booleanValue();
    }

    public static boolean isAppForeground() {
        try {
            return CommonUtilSubscriber.getInstance().isAppForeground();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isGtcProcess() {
        return Process.myPid() == GtcProvider.gtcPid();
    }

    public static boolean isMainProcess() {
        return isMainProcess(GtcProvider.context());
    }

    public static boolean isMainProcess(Context context) {
        Context context2 = context;
        if (context == null) {
            try {
                context2 = findAppContext();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (context2 != null) {
            String str = context2.getApplicationInfo().processName;
            String processName = getProcessName();
            if (str != null) {
                return str.equals(processName);
            }
            return false;
        }
        return false;
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
