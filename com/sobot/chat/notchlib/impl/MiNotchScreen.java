package com.sobot.chat.notchlib.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.Window;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.utils.ScreenUtil;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/impl/MiNotchScreen.class */
public class MiNotchScreen implements INotchScreen {
    public static int getNotchHeight(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getNotchWidth(Context context) {
        int identifier = context.getResources().getIdentifier("notch_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static boolean isNotch() {
        boolean z = false;
        try {
            if (((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, "ro.miui.notch", 0)).intValue() == 1) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public void getNotchRect(Activity activity, INotchScreen.NotchSizeCallback notchSizeCallback) {
        Rect calculateNotchRect = ScreenUtil.calculateNotchRect(activity, getNotchWidth(activity), getNotchHeight(activity));
        ArrayList arrayList = new ArrayList();
        arrayList.add(calculateNotchRect);
        notchSizeCallback.onResult(arrayList);
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public boolean hasNotch(Activity activity) {
        return isNotch();
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public void setDisplayInNotch(Activity activity) {
        try {
            Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(activity.getWindow(), 1792);
        } catch (Exception e) {
        }
    }
}
