package com.sobot.chat.api.apiUtils;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/apiUtils/SobotApp.class */
public class SobotApp {
    private static Context mApplicationContext;

    public static Context getApplicationContext() {
        return mApplicationContext;
    }

    public static void setApplicationContext(Context context) {
        mApplicationContext = context;
    }
}
