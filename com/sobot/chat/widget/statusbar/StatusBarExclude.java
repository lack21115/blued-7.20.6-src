package com.sobot.chat.widget.statusbar;

import android.os.Build;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/statusbar/StatusBarExclude.class */
public class StatusBarExclude {
    static boolean exclude = false;

    public static void excludeIncompatibleFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
        } catch (NoSuchMethodException e) {
            exclude |= Build.BRAND.contains("Meizu");
        }
    }
}
