package com.sobot.chat.notchlib;

import android.app.Activity;
import android.graphics.Rect;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/INotchScreen.class */
public interface INotchScreen {

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/INotchScreen$HasNotchCallback.class */
    public interface HasNotchCallback {
        void onResult(boolean z);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/INotchScreen$NotchScreenCallback.class */
    public interface NotchScreenCallback {
        void onResult(NotchScreenInfo notchScreenInfo);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/INotchScreen$NotchScreenInfo.class */
    public static class NotchScreenInfo {
        public boolean hasNotch;
        public List<Rect> notchRects;
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/INotchScreen$NotchSizeCallback.class */
    public interface NotchSizeCallback {
        void onResult(List<Rect> list);
    }

    void getNotchRect(Activity activity, NotchSizeCallback notchSizeCallback);

    boolean hasNotch(Activity activity);

    void setDisplayInNotch(Activity activity);
}
