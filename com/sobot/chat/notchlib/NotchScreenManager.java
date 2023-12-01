package com.sobot.chat.notchlib;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.impl.AndroidPNotchScreen;
import com.sobot.chat.notchlib.impl.HuaweiNotchScreen;
import com.sobot.chat.notchlib.impl.MiNotchScreen;
import com.sobot.chat.notchlib.impl.OppoNotchScreen;
import com.sobot.chat.notchlib.impl.VivoNotchScreen;
import com.sobot.chat.notchlib.utils.RomUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/NotchScreenManager.class */
public class NotchScreenManager {
    private static final NotchScreenManager instance = new NotchScreenManager();
    private boolean res = false;
    private final INotchScreen notchScreen = getNotchScreen();

    private NotchScreenManager() {
    }

    public static NotchScreenManager getInstance() {
        return instance;
    }

    private INotchScreen getNotchScreen() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new AndroidPNotchScreen();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (RomUtils.isHuawei()) {
                return new HuaweiNotchScreen();
            }
            if (RomUtils.isOppo()) {
                return new OppoNotchScreen();
            }
            if (RomUtils.isVivo()) {
                return new VivoNotchScreen();
            }
            if (RomUtils.isXiaomi()) {
                return new MiNotchScreen();
            }
            return null;
        }
        return null;
    }

    public void getNotchInfo(Activity activity, final INotchScreen.NotchScreenCallback notchScreenCallback) {
        final INotchScreen.NotchScreenInfo notchScreenInfo = new INotchScreen.NotchScreenInfo();
        INotchScreen iNotchScreen = this.notchScreen;
        if (iNotchScreen == null || !iNotchScreen.hasNotch(activity)) {
            notchScreenCallback.onResult(notchScreenInfo);
        } else {
            this.notchScreen.getNotchRect(activity, new INotchScreen.NotchSizeCallback() { // from class: com.sobot.chat.notchlib.NotchScreenManager.1
                @Override // com.sobot.chat.notchlib.INotchScreen.NotchSizeCallback
                public void onResult(List<Rect> list) {
                    if (list != null && list.size() > 0) {
                        notchScreenInfo.hasNotch = true;
                        notchScreenInfo.notchRects = list;
                    }
                    notchScreenCallback.onResult(notchScreenInfo);
                }
            });
        }
    }

    public boolean hasNotch(Activity activity) {
        INotchScreen iNotchScreen = this.notchScreen;
        if (iNotchScreen != null && iNotchScreen.hasNotch(activity)) {
            this.notchScreen.getNotchRect(activity, new INotchScreen.NotchSizeCallback() { // from class: com.sobot.chat.notchlib.NotchScreenManager.2
                @Override // com.sobot.chat.notchlib.INotchScreen.NotchSizeCallback
                public void onResult(List<Rect> list) {
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    NotchScreenManager.this.res = true;
                }
            });
        }
        return this.res;
    }

    public void setDisplayInNotch(Activity activity) {
        INotchScreen iNotchScreen = this.notchScreen;
        if (iNotchScreen != null) {
            iNotchScreen.setDisplayInNotch(activity);
        }
    }
}
