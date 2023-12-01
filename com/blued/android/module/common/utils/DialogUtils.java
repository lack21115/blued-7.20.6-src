package com.blued.android.module.common.utils;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/DialogUtils.class */
public class DialogUtils {
    public static final Dialog a(Context context) {
        return a(context, true);
    }

    public static final Dialog a(Context context, String str, boolean z) {
        Dialog b = b(context, z);
        ((TextView) b.findViewById(R.id.pb_text)).setText(str);
        return b;
    }

    public static final Dialog a(Context context, boolean z) {
        Dialog dialog = new Dialog(context, R.style.TranslucentBackground);
        dialog.setContentView(R.layout.common_loading_layout);
        StatusBarHelper.a(dialog.getWindow());
        dialog.setCancelable(z);
        dialog.getWindow().getDecorView().setSystemUiVisibility(2);
        dialog.getWindow().setFlags(8, 8);
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

    public static final Dialog b(Context context) {
        Dialog dialog = new Dialog(context, R.style.SubTransBackground);
        dialog.setContentView(R.layout.common_loading_layout);
        StatusBarHelper.a(dialog.getWindow());
        dialog.setCancelable(true);
        return dialog;
    }

    private static final Dialog b(Context context, boolean z) {
        Dialog dialog = new Dialog(context, R.style.TranslucentBackground);
        dialog.setContentView(R.layout.common_loading_layout_with_text);
        StatusBarHelper.a(dialog.getWindow());
        dialog.setCancelable(z);
        return dialog;
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
