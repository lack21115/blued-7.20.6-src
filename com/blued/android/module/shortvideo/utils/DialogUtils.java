package com.blued.android.module.shortvideo.utils;

import android.app.Dialog;
import android.content.Context;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.shortvideo.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/DialogUtils.class */
public class DialogUtils {
    public static final Dialog a(Context context) {
        return a(context, true);
    }

    public static final Dialog a(Context context, boolean z) {
        Dialog dialog = new Dialog(context, R.style.TranslucentBackground);
        dialog.setContentView(R.layout.common_loading_layout);
        StatusBarHelper.a(dialog.getWindow());
        dialog.setCancelable(z);
        return dialog;
    }

    public static void a(Dialog dialog) {
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    return;
                }
                dialog.show();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void b(Dialog dialog) {
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
