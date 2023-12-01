package com.kwad.sdk.j;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/j/j.class */
public final class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context df(Context context) {
        Context applicationContext = unwrapContextIfNeed(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                return applicationContext;
            }
            Context applicationContext2 = applicationContext.getApplicationContext();
            if (applicationContext2 instanceof Application) {
                return applicationContext2;
            }
            applicationContext = applicationContext2;
            if (dg(applicationContext2)) {
                applicationContext = dh(applicationContext2);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean dg(Context context) {
        return context instanceof ResContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context dh(Context context) {
        return ((ResContext) context).getDelegatedContext();
    }

    public static void onDestroy(Context context) {
        Wrapper.onDestroy(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context unwrapContextIfNeed(Context context) {
        Context context2 = context;
        if (dg(context)) {
            context2 = dh(context);
        }
        if (dg(context2)) {
            RuntimeException runtimeException = null;
            int i = 0;
            while (i < 10) {
                RuntimeException runtimeException2 = runtimeException;
                if (runtimeException == null) {
                    runtimeException2 = new RuntimeException("expect normalContext --context:" + context2.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish());
                    ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(runtimeException2);
                }
                context2 = dh(context2);
                if (!dg(context2)) {
                    return context2;
                }
                i++;
                runtimeException = runtimeException2;
            }
            return context2;
        }
        return context2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context wrapContextIfNeed(Context context) {
        return Wrapper.wrapContextIfNeed(context);
    }
}
