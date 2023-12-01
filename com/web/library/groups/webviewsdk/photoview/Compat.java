package com.web.library.groups.webviewsdk.photoview;

import android.os.Build;
import android.view.View;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/photoview/Compat.class */
public class Compat {
    private static final int SIXTY_FPS_INTERVAL = 16;

    public static int getPointerIndex(int i) {
        return Build.VERSION.SDK_INT >= 11 ? getPointerIndexHoneyComb(i) : getPointerIndexEclair(i);
    }

    private static int getPointerIndexEclair(int i) {
        return (i & 65280) >> 8;
    }

    private static int getPointerIndexHoneyComb(int i) {
        return (i & 65280) >> 8;
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimationJellyBean(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    private static void postOnAnimationJellyBean(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
