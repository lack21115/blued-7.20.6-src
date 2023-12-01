package com.soft.blued.utils;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.net.wifi.WifiInfo;
import android.util.Log;
import com.blued.android.core.AppInfo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/HookActivityManager.class */
public class HookActivityManager {

    /* renamed from: a  reason: collision with root package name */
    private static WifiInfo f21050a;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/HookActivityManager$IActivityManagerProxy.class */
    static class IActivityManagerProxy implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private Object f21051a;

        public IActivityManagerProxy(Object obj) {
            this.f21051a = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!"reportSizeConfigurations".equals(method.getName())) {
                try {
                    return method.invoke(this.f21051a, objArr);
                } catch (Exception e) {
                    return false;
                }
            }
            try {
                Log.w("HookActivityManager", "reportSizeConfigurations invoke execute ");
                return method.invoke(this.f21051a, objArr);
            } catch (Exception e2) {
                Log.w("HookActivityManager", "reportSizeConfigurations exception: " + e2.getMessage());
                return false;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/HookActivityManager$WifiInvocationHandler.class */
    public static class WifiInvocationHandler implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final String f21052a;
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private Object f21053c;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            WifiInfo wifiInfo;
            Exception e;
            Log.d(this.f21052a, "method invoke " + method.getName());
            if (!this.b.equals(method.getName())) {
                return method.invoke(this.f21053c, objArr);
            }
            if (BluedPreferences.aC() != 1 && !BluedPreferences.aD()) {
                return null;
            }
            if (AppInfo.m()) {
                new Exception("this is a log").printStackTrace();
            }
            if (HookActivityManager.f21050a != null) {
                Log.d(this.f21052a, "cacheWifiInfo:" + HookActivityManager.f21050a);
                return HookActivityManager.f21050a;
            }
            try {
                wifiInfo = (WifiInfo) WifiInfo.class.newInstance();
                try {
                    Field declaredField = WifiInfo.class.getDeclaredField("mMacAddress");
                    declaredField.setAccessible(true);
                    declaredField.set(wifiInfo, "");
                    WifiInfo unused = HookActivityManager.f21050a = wifiInfo;
                    Log.d(this.f21052a, "wifiInfo:" + wifiInfo);
                    return wifiInfo;
                } catch (Exception e2) {
                    e = e2;
                    Log.e(this.f21052a, "WifiInfo error:" + e.getMessage());
                    return wifiInfo;
                }
            } catch (Exception e3) {
                wifiInfo = null;
                e = e3;
            }
        }
    }

    public static void a() {
        try {
            Field declaredField = ActivityManager.class.getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = obj.getClass().getSuperclass().getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Class<?> cls = Class.forName(IActivityManager.descriptor);
            declaredField2.set(obj, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new IActivityManagerProxy(obj2)));
        } catch (Exception e) {
            Log.d("HookActivityManager", "" + e);
        }
    }
}
