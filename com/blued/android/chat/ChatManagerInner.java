package com.blued.android.chat;

import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.heart.Heart;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/ChatManagerInner.class */
public class ChatManagerInner {
    public static Connector getConnector() {
        return ChatManager.getInstance().connector;
    }

    public static Heart getHeart() {
        return ChatManager.getInstance().heart;
    }

    public static boolean isStopped() {
        return ChatManager.getInstance().stopped;
    }
}
