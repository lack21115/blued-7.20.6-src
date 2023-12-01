package com.ss.android.download.api.mb;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.config.lz;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/mb/ox.class */
public class ox implements lz {
    private gm mb;

    @Override // com.ss.android.download.api.config.lz
    public void mb(Activity activity, int i, String[] strArr, int[] iArr) {
        gm gmVar;
        if (iArr.length <= 0 || (gmVar = this.mb) == null) {
            return;
        }
        if (iArr[0] == -1) {
            gmVar.mb(strArr[0]);
        } else if (iArr[0] == 0) {
            gmVar.mb();
        }
    }

    @Override // com.ss.android.download.api.config.lz
    public void mb(Activity activity, String[] strArr, gm gmVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.mb = gmVar;
            activity.requestPermissions(strArr, 1);
        } else if (gmVar != null) {
            gmVar.mb();
        }
    }

    @Override // com.ss.android.download.api.config.lz
    public boolean mb(Context context, String str) {
        boolean z = false;
        if (context != null) {
            z = false;
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                z = true;
            }
        }
        return z;
    }
}
