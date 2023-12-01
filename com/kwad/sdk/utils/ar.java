package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ar.class */
public final class ar {
    public static int ao(Context context, String str) {
        Resources ck = ck(context);
        Resources resources = ck;
        if (ck == null) {
            resources = context.getResources();
        }
        return resources.getIdentifier(str, com.anythink.expressad.foundation.h.i.f7952c, context.getPackageName());
    }

    public static Resources ck(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.CA().getResources();
    }
}
