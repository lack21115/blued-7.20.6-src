package com.sobot.chat.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/CustomToast.class */
public class CustomToast {
    public static Toast makeText(Context context, int i, int i2) {
        Toast toast = new Toast(context.getApplicationContext());
        View inflate = View.inflate(context, ResourceUtils.getIdByName(context, "layout", "sobot_custom_toast_layout_2"), null);
        ((TextView) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_content"))).setText(i);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i2);
        return toast;
    }

    public static Toast makeText(Context context, CharSequence charSequence, int i) {
        Toast toast = new Toast(context.getApplicationContext());
        View inflate = View.inflate(context, ResourceUtils.getIdByName(context, "layout", "sobot_custom_toast_layout_2"), null);
        ((TextView) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_content"))).setText(charSequence);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i);
        return toast;
    }

    public static Toast makeText(Context context, CharSequence charSequence, int i, int i2) {
        Toast toast = new Toast(context.getApplicationContext());
        View inflate = View.inflate(context, ResourceUtils.getIdByName(context, "layout", "sobot_custom_toast_layout"), null);
        ((TextView) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_content"))).setText(charSequence);
        ((ImageView) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_iv_content"))).setImageResource(i2);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i);
        return toast;
    }
}
