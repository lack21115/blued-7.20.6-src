package com.sobot.chat.widget.timePicker.utils;

import android.content.Context;
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/utils/SobotPickerViewAnimateUtil.class */
public class SobotPickerViewAnimateUtil {
    private static final int INVALID = -1;

    public static int getAnimationResource(Context context, int i, boolean z) {
        if (i != 80) {
            return -1;
        }
        return ResourceUtils.getIdByName(context, i.f, z ? "sobot_pickerview_slide_in_bottom" : "sobot_pickerview_slide_out_bottom");
    }
}
