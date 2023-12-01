package com.sobot.chat.utils;

import android.content.Context;
import android.content.Intent;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/StServiceUtils.class */
public class StServiceUtils {
    public static void safeStartService(Context context, Intent intent) {
        try {
            context.startService(intent);
        } catch (Throwable th) {
        }
    }
}
