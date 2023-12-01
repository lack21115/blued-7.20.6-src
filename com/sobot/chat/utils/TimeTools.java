package com.sobot.chat.utils;

import com.ss.android.download.api.constant.BaseConstants;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/TimeTools.class */
public class TimeTools {
    public static TimeTools instance;

    static {
        if (0 == 0) {
            instance = new TimeTools();
        }
    }

    public String calculatTime(int i) {
        int i2 = i / BaseConstants.Time.HOUR;
        int i3 = i - (((i2 * 60) * 60) * 1000);
        int i4 = i3 / 60000;
        int i5 = (i3 - ((i4 * 60) * 1000)) / 1000;
        int i6 = i4;
        int i7 = i5;
        if (i5 >= 60) {
            i7 = i5 % 60;
            i6 = i4 + (i7 / 60);
        }
        int i8 = i2;
        int i9 = i6;
        if (i6 >= 60) {
            i9 = i6 % 60;
            i8 = i2 + (i9 / 60);
        }
        if (i8 < 10) {
        }
        if (i9 < 10) {
        }
        if (i7 < 10) {
            return "00:0" + String.valueOf(i7);
        }
        return "00:" + String.valueOf(i7);
    }
}
