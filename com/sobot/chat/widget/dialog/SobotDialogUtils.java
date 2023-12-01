package com.sobot.chat.widget.dialog;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.widget.TextView;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotDialogUtils.class */
public class SobotDialogUtils {
    public static SobotLoadingDialog progressDialog;

    public static void resetDialogStyle(AlertDialog alertDialog) {
        TextView textView = (TextView) alertDialog.findViewById(R.id.message);
        if (textView != null) {
            textView.setTextSize(14.0f);
            textView.setGravity(17);
            textView.setTextColor(-16777216);
        }
        alertDialog.getButton(-2).setTextSize(14.0f);
        alertDialog.getButton(-2).setTextColor(-16777216);
        alertDialog.getButton(-1).setTextSize(14.0f);
        alertDialog.getButton(-1).setTextColor(-16777216);
    }

    public static void startProgressDialog(Context context) {
        if (context == null) {
            return;
        }
        SobotLoadingDialog sobotLoadingDialog = progressDialog;
        if (sobotLoadingDialog == null) {
            progressDialog = new SobotLoadingDialog(context, ResourceUtils.getResString(context, "sobot_loading"));
        } else {
            sobotLoadingDialog.setmMessage(ResourceUtils.getResString(context, "sobot_loading"));
        }
        try {
            progressDialog.show();
        } catch (Exception e) {
        }
    }

    public static void startProgressDialog(Context context, String str) {
        if (context == null) {
            return;
        }
        SobotLoadingDialog sobotLoadingDialog = progressDialog;
        if (sobotLoadingDialog == null) {
            progressDialog = new SobotLoadingDialog(context, str);
        } else {
            sobotLoadingDialog.setmMessage(str);
        }
        try {
            progressDialog.show();
        } catch (Exception e) {
        }
    }

    public static void stopProgressDialog(Context context) {
        SobotLoadingDialog sobotLoadingDialog = progressDialog;
        if (sobotLoadingDialog != null && context != null && sobotLoadingDialog.isShowing()) {
            try {
                if (!((Activity) context).isFinishing()) {
                    progressDialog.dismiss();
                }
            } catch (Exception e) {
            }
        }
        progressDialog = null;
    }
}
