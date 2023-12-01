package com.sobot.chat.api;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/a.class */
public class a {
    public static ZhiChiApi a(Context context) {
        if (context != null) {
            return new ZhiChiApiImpl(context.getApplicationContext());
        }
        throw new IllegalArgumentException("The context can not be null");
    }
}
