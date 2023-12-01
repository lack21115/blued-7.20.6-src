package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.util.Log;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/mb/mb.class */
public abstract class mb implements h {
    protected final String b;
    protected final Context mb;
    protected final DownloadSetting ox;

    public mb(Context context, DownloadSetting downloadSetting, String str) {
        this.mb = context;
        this.ox = downloadSetting;
        this.b = str;
    }

    public boolean mb() {
        if (this.mb == null) {
            return false;
        }
        try {
            return ox().resolveActivity(this.mb.getPackageManager()) != null;
        } catch (Throwable th) {
            if (Logger.debug()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
                return false;
            }
            return false;
        }
    }
}
