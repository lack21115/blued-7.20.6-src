package com.sobot.chat.listener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import com.sobot.chat.widget.dialog.SobotPermissionDialog;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/listener/PermissionListenerImpl.class */
public class PermissionListenerImpl implements PermissionListener {
    @Override // com.sobot.chat.listener.PermissionListener
    public void onPermissionErrorListener(Activity activity, String str) {
        if (activity == null) {
            return;
        }
        new SobotPermissionDialog(activity, str, new SobotPermissionDialog.ClickViewListener() { // from class: com.sobot.chat.listener.PermissionListenerImpl.1
            @Override // com.sobot.chat.widget.dialog.SobotPermissionDialog.ClickViewListener
            public void clickLeftView(Context context, SobotPermissionDialog sobotPermissionDialog) {
                sobotPermissionDialog.dismiss();
            }

            @Override // com.sobot.chat.widget.dialog.SobotPermissionDialog.ClickViewListener
            public void clickRightView(Context context, SobotPermissionDialog sobotPermissionDialog) {
                context.startActivity(new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + context.getPackageName())));
                sobotPermissionDialog.dismiss();
            }
        }).show();
    }

    @Override // com.sobot.chat.listener.PermissionListener
    public void onPermissionSuccessListener() {
    }
}
