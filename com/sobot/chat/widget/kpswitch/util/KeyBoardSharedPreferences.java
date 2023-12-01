package com.sobot.chat.widget.kpswitch.util;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/util/KeyBoardSharedPreferences.class */
public class KeyBoardSharedPreferences {
    private static final String FILE_NAME = "keyboard.common";
    private static final String KEY_KEYBOARD_HEIGHT = "sp.key.keyboard.height";
    private static volatile SharedPreferences SP;

    KeyBoardSharedPreferences() {
    }

    public static int get(Context context, int i) {
        return with(context).getInt(KEY_KEYBOARD_HEIGHT, i);
    }

    public static boolean save(Context context, int i) {
        return with(context).edit().putInt(KEY_KEYBOARD_HEIGHT, i).commit();
    }

    private static SharedPreferences with(Context context) {
        if (SP == null) {
            synchronized (KeyBoardSharedPreferences.class) {
                try {
                    if (SP == null) {
                        SP = context.getSharedPreferences(FILE_NAME, 0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return SP;
    }
}
