package com.blued.android.chat.utils;

import com.blued.android.chat.ChatManager;
import java.util.Locale;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/utils/BlueAppChatLocal.class */
public class BlueAppChatLocal {
    public static String getCountry() {
        return ChatManager.context.getResources().getConfiguration().locale.getCountry();
    }

    public static Locale getDefault() {
        return ChatManager.context.getResources().getConfiguration().locale;
    }

    public static String getLanguage() {
        return ChatManager.context.getResources().getConfiguration().locale.getLanguage();
    }

    public static boolean isZh() {
        return "zh".equals(getLanguage());
    }
}
