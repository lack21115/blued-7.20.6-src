package com.sobot.chat.widget.kpswitch.util;

import android.content.Context;
import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/util/StatusBarHeightUtil.class */
public class StatusBarHeightUtil {
    private static boolean INIT = false;
    private static final String STATUS_BAR_DEF_PACKAGE = "android";
    private static final String STATUS_BAR_DEF_TYPE = "dimen";
    private static int STATUS_BAR_HEIGHT = 50;
    private static final String STATUS_BAR_NAME = "status_bar_height";

    public static int getStatusBarHeight(Context context) {
        int i;
        int identifier;
        synchronized (StatusBarHeightUtil.class) {
            try {
                if (!INIT && (identifier = context.getResources().getIdentifier(STATUS_BAR_NAME, STATUS_BAR_DEF_TYPE, "android")) > 0) {
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                    STATUS_BAR_HEIGHT = dimensionPixelSize;
                    INIT = true;
                    Log.d("StatusBarHeightUtil", String.format("Get status bar height %d", Integer.valueOf(dimensionPixelSize)));
                }
                i = STATUS_BAR_HEIGHT;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }
}
