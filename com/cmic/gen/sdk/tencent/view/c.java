package com.cmic.gen.sdk.tencent.view;

import android.content.Context;
import android.content.res.Resources;
import com.anythink.expressad.foundation.h.i;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/c.class */
public class c {
    public static int a(Context context, String str) {
        int a2 = a(context, str, "id");
        if (a2 != 0) {
            return a2;
        }
        throw new Resources.NotFoundException(str);
    }

    public static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static int b(Context context, String str) {
        int a2 = a(context, str, i.f5112c);
        if (a2 != 0) {
            return a2;
        }
        throw new Resources.NotFoundException(str);
    }

    public static int c(Context context, String str) {
        int a2 = a(context, str, i.f);
        if (a2 != 0) {
            return a2;
        }
        throw new Resources.NotFoundException(str);
    }
}
