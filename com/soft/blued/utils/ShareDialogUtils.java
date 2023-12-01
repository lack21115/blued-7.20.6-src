package com.soft.blued.utils;

import android.app.Dialog;
import android.content.Context;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module_share_china.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/ShareDialogUtils.class */
public class ShareDialogUtils {
    public static final Dialog a(Context context) {
        return a(context, true);
    }

    public static final Dialog a(Context context, boolean z) {
        Dialog dialog = new Dialog(context, R.style.TranslucentBackground);
        dialog.setContentView(R.layout.share_common_loading_layout);
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
