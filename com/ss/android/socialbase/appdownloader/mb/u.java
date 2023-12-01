package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/mb/u.class */
public class u extends mb {
    public u(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
