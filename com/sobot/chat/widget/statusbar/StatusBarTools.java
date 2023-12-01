package com.sobot.chat.widget.statusbar;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/statusbar/StatusBarTools.class */
public class StatusBarTools {
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
