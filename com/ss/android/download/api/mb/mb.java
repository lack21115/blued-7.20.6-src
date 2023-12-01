package com.ss.android.download.api.mb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.bytedance.applog.tracker.Tracker;
import com.ss.android.download.api.config.je;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/mb/mb.class */
public class mb implements je {
    private static Dialog mb(final DownloadAlertDialogInfo downloadAlertDialogInfo) {
        if (downloadAlertDialogInfo == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(downloadAlertDialogInfo.mb).setTitle(downloadAlertDialogInfo.ox).setMessage(downloadAlertDialogInfo.b).setPositiveButton(downloadAlertDialogInfo.hj, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.mb.mb.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (DownloadAlertDialogInfo.this.ww != null) {
                    DownloadAlertDialogInfo.this.ww.mb(dialogInterface);
                }
            }
        }).setNegativeButton(downloadAlertDialogInfo.h, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.mb.mb.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (DownloadAlertDialogInfo.this.ww != null) {
                    DownloadAlertDialogInfo.this.ww.ox(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(downloadAlertDialogInfo.u);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.mb.mb.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (DownloadAlertDialogInfo.this.ww != null) {
                    DownloadAlertDialogInfo.this.ww.b(dialogInterface);
                }
            }
        });
        if (downloadAlertDialogInfo.ko != null) {
            show.setIcon(downloadAlertDialogInfo.ko);
        }
        return show;
    }

    @Override // com.ss.android.download.api.config.je
    public void mb(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.download.api.config.je
    public Dialog ox(DownloadAlertDialogInfo downloadAlertDialogInfo) {
        return mb(downloadAlertDialogInfo);
    }
}
