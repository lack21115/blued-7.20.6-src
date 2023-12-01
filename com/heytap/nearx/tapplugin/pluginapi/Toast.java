package com.heytap.nearx.tapplugin.pluginapi;

import android.app.Activity;
import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/tapplugin/pluginapi/Toast.class */
public class Toast {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;

    public static android.widget.Toast makeText(Context context, int i, int i2) {
        return makeText(context, context.getResources().getText(i), i2);
    }

    public static android.widget.Toast makeText(Context context, CharSequence charSequence, int i) {
        Activity proxyActivity = (PluginApi.sPluginMode && (context instanceof Activity)) ? PluginApi.getProxyActivity((Activity) context) : null;
        if (proxyActivity != null) {
            context = proxyActivity;
        }
        return android.widget.Toast.makeText(context, charSequence, i);
    }
}
