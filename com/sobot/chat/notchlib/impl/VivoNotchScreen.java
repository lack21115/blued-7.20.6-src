package com.sobot.chat.notchlib.impl;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.utils.ScreenUtil;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/impl/VivoNotchScreen.class */
public class VivoNotchScreen implements INotchScreen {
    private static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int getNotchHeight(Context context) {
        return (int) (getDensity(context) * 27.0f);
    }

    public static int getNotchWidth(Context context) {
        return (int) (getDensity(context) * 100.0f);
    }

    public static boolean isNotch() {
        try {
            Class<?> cls = Class.forName("android.util.FtFeature");
            return ((Boolean) cls.getMethod("isFtFeatureSupport", Integer.TYPE).invoke(cls.newInstance(), 32)).booleanValue();
        } catch (Exception e) {
            Log.e("tag", "get error() ", e);
            return false;
        }
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public void getNotchRect(Activity activity, INotchScreen.NotchSizeCallback notchSizeCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ScreenUtil.calculateNotchRect(activity, getNotchWidth(activity), getNotchHeight(activity)));
        notchSizeCallback.onResult(arrayList);
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public boolean hasNotch(Activity activity) {
        return isNotch();
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    @Deprecated
    public void setDisplayInNotch(Activity activity) {
    }
}
