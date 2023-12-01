package com.sobot.chat.utils;

import com.anythink.expressad.video.module.a.a.m;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/FastClickUtils.class */
public class FastClickUtils {
    private static final int MIN_CLICK_DELAY_TIME = 3000;
    private static long lastClickTime;

    public static boolean isCanClick() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - lastClickTime >= m.ag;
        lastClickTime = currentTimeMillis;
        return z;
    }
}
