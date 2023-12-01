package com.soft.blued.ui.live.utils;

import com.anythink.expressad.d.a.b;
import java.text.DecimalFormat;
import java.util.Locale;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/utils/FormatUtils.class */
public class FormatUtils {
    public static String a(float f) {
        return new DecimalFormat("#0.0").format(f);
    }

    public static String a(long j) {
        return j <= 0 ? "00:00" : j < 60 ? String.format(Locale.getDefault(), "00:%02d", Long.valueOf(j % 60)) : j < b.P ? String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf(j / 60), Long.valueOf(j % 60)) : String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf(j / b.P), Long.valueOf((j % b.P) / 60), Long.valueOf(j % 60));
    }
}
