package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/mb/je.class */
public class je extends mb {
    public je(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        String optString = this.ox.optString("s");
        String mb = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("ag"), optString);
        String mb2 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("ah"), optString);
        String mb3 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString(com.anythink.expressad.d.a.b.cZ), optString);
        String mb4 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("aj"), optString);
        Intent intent = new Intent();
        intent.putExtra(mb, this.b);
        intent.putExtra(mb2, "*/*");
        intent.putExtra(mb3, true);
        intent.setAction(mb4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
