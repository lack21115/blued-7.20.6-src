package com.blued.android.module.external_sense_library.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/TimeUtil.class */
public class TimeUtil {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss:SSS");
    private static final SimpleDateFormat b = new SimpleDateFormat("HH:mm:ss.SSS");

    public static String a() {
        return a.format(new Date());
    }
}
