package com.blued.android.core.utils.toast.config;

import android.content.Context;
import android.view.View;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/config/IToastStyle.class */
public interface IToastStyle<V extends View> {

    /* renamed from: com.blued.android.core.utils.toast.config.IToastStyle$-CC  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/config/IToastStyle$-CC.class */
    public final /* synthetic */ class CC {
        public static int $default$a(IToastStyle iToastStyle) {
            return 17;
        }

        public static float $default$b(IToastStyle iToastStyle) {
            return 0.0f;
        }

        public static int $default$b(IToastStyle iToastStyle, Context context) {
            return 0;
        }

        public static float $default$c(IToastStyle iToastStyle) {
            return 0.0f;
        }

        public static int $default$c(IToastStyle iToastStyle, Context context) {
            return 0;
        }
    }

    int a();

    V a(Context context);

    float b();

    int b(Context context);

    float c();

    int c(Context context);
}
