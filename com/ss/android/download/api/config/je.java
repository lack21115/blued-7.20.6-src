package com.ss.android.download.api.config;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/config/je.class */
public interface je {
    void mb(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2);

    Dialog ox(DownloadAlertDialogInfo downloadAlertDialogInfo);
}
