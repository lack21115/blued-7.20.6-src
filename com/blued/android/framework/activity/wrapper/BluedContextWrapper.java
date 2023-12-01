package com.blued.android.framework.activity.wrapper;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.util.Log;
import com.blued.android.framework.utils.LocaleUtils;
import java.util.Locale;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/wrapper/BluedContextWrapper.class */
public class BluedContextWrapper extends ContextWrapper {
    public static ContextWrapper a(Context context) {
        Context context2;
        Locale c2 = LocaleUtils.c();
        if (c2 != null) {
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                configuration.setLocales(new LocaleList(c2));
                context2 = context.createConfigurationContext(configuration);
            } else {
                context2 = context;
                if (Build.VERSION.SDK_INT >= 19) {
                    configuration.setLocale(c2);
                    context2 = context.createConfigurationContext(configuration);
                }
            }
            Log.i("BluedContextWrapper", "locale :" + c2.getLanguage() + ":" + c2.getCountry());
            context = context2;
        } else {
            Log.i("BluedContextWrapper", "locale null");
        }
        return new ContextWrapper(context);
    }
}
