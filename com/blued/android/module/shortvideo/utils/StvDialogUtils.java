package com.blued.android.module.shortvideo.utils;

import android.app.Dialog;
import android.content.Context;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.shortvideo.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvDialogUtils.class */
public class StvDialogUtils {
    public static final Dialog a(Context context) {
        Dialog dialog = new Dialog(context, R.style.SeventyTransBackgroud);
        dialog.setContentView(R.layout.stv_loading_layout);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    public static final Dialog b(Context context) {
        Dialog dialog = new Dialog(context, R.style.SeventyTransBackgroud);
        dialog.setContentView(R.layout.stv_loading_layout);
        StatusBarHelper.a(dialog.getWindow());
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}
