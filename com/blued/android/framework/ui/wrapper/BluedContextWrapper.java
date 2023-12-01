package com.blued.android.framework.ui.wrapper;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.util.Log;
import com.blued.android.framework.utils.LocaleUtils;
import java.util.Locale;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/wrapper/BluedContextWrapper.class */
public class BluedContextWrapper extends ContextWrapper {
    public static ContextWrapper a(Context context) {
        Context context2;
        Locale c = LocaleUtils.c();
        if (c != null) {
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                configuration.setLocales(new LocaleList(c));
                context2 = context.createConfigurationContext(configuration);
            } else {
                context2 = context;
                if (Build.VERSION.SDK_INT >= 19) {
                    configuration.setLocale(c);
                    context2 = context.createConfigurationContext(configuration);
                }
            }
            Log.i("BluedContextWrapper", "locale :" + c.getLanguage() + ":" + c.getCountry());
            context = context2;
        } else {
            Log.i("BluedContextWrapper", "locale null");
        }
        return new ContextWrapper(context);
    }
}
