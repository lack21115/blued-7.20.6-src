package com.sobot.chat.notchlib.impl;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.utils.ScreenUtil;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/impl/HuaweiNotchScreen.class */
public class HuaweiNotchScreen implements INotchScreen {
    public static final int FLAG_NOTCH_SUPPORT = 65536;

    public static void setNotDisplayInNotch(Activity activity) {
        try {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("clearHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
            window.getWindowManager().updateViewLayout(window.getDecorView(), window.getDecorView().getLayoutParams());
        } catch (Throwable th) {
        }
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public void getNotchRect(Activity activity, INotchScreen.NotchSizeCallback notchSizeCallback) {
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            int[] iArr = (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ScreenUtil.calculateNotchRect(activity, iArr[0], iArr[1]));
            notchSizeCallback.onResult(arrayList);
        } catch (Throwable th) {
            notchSizeCallback.onResult(null);
        }
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public boolean hasNotch(Activity activity) {
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public void setDisplayInNotch(Activity activity) {
        try {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
            window.getWindowManager().updateViewLayout(window.getDecorView(), window.getDecorView().getLayoutParams());
        } catch (Throwable th) {
        }
    }
}
