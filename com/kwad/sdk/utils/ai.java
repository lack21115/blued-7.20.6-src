package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ai.class */
public final class ai {
    public static boolean DL() {
        return DM();
    }

    public static boolean DM() {
        return ServiceProvider.CA().getApplicationContext().getResources().getConfiguration().orientation == 1;
    }

    public static void b(Context context, boolean z) {
        try {
            Activity dj = com.kwad.sdk.j.k.dj(context);
            if (dj == null) {
                return;
            }
            if (z) {
                if (Build.VERSION.SDK_INT < 19) {
                    dj.getWindow().getDecorView().setSystemUiVisibility(8);
                } else {
                    dj.getWindow().getDecorView().setSystemUiVisibility(1792);
                }
            } else if (Build.VERSION.SDK_INT < 19) {
                dj.getWindow().getDecorView().setSystemUiVisibility(0);
            } else {
                dj.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean cb(Context context) {
        Activity dj = com.kwad.sdk.j.k.dj(context);
        boolean z = false;
        if (dj != null) {
            Window window = dj.getWindow();
            z = false;
            if ((window.getAttributes().flags & 1024) == 1024) {
                z = true;
            }
            window.setFlags(1024, 1024);
        }
        return z;
    }

    public static void cc(Context context) {
        Activity dj = com.kwad.sdk.j.k.dj(context);
        if (dj != null) {
            dj.getWindow().clearFlags(1024);
        }
    }

    public static void cd(Context context) {
        Activity dj = com.kwad.sdk.j.k.dj(context);
        if (dj != null) {
            dj.setRequestedOrientation(0);
        }
    }

    public static void ce(Context context) {
        Activity dj = com.kwad.sdk.j.k.dj(context);
        if (dj != null) {
            dj.setRequestedOrientation(1);
        }
    }
}
