package com.sobot.chat.notchlib.impl;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.utils.ScreenUtil;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/impl/OppoNotchScreen.class */
public class OppoNotchScreen implements INotchScreen {
    private static String getScreenValue() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls.newInstance(), "ro.oppo.screen.heteromorphism");
        } catch (Throwable th) {
            return "";
        }
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public void getNotchRect(Activity activity, INotchScreen.NotchSizeCallback notchSizeCallback) {
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        try {
            String screenValue = getScreenValue();
            if (TextUtils.isEmpty(screenValue)) {
                return;
            }
            String[] split = screenValue.split(":");
            String[] split2 = split[0].split(",");
            String[] split3 = split[1].split(",");
            if (ScreenUtil.isPortrait(activity)) {
                intValue = Integer.valueOf(split2[0]).intValue();
                intValue2 = Integer.valueOf(split2[1]).intValue();
                intValue3 = Integer.valueOf(split3[0]).intValue();
                intValue4 = Integer.valueOf(split3[1]).intValue();
            } else {
                intValue = Integer.valueOf(split2[1]).intValue();
                intValue2 = Integer.valueOf(split2[0]).intValue();
                intValue3 = Integer.valueOf(split3[1]).intValue();
                intValue4 = Integer.valueOf(split3[0]).intValue();
            }
            Rect rect = new Rect(intValue, intValue2, intValue3, intValue4);
            ArrayList arrayList = new ArrayList();
            arrayList.add(rect);
            notchSizeCallback.onResult(arrayList);
        } catch (Throwable th) {
            notchSizeCallback.onResult(null);
        }
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public boolean hasNotch(Activity activity) {
        try {
            return activity.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    @Deprecated
    public void setDisplayInNotch(Activity activity) {
    }
}
