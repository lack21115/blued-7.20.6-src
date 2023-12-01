package com.opos.mobad.provider;

import android.content.Context;
import android.net.Uri;
import com.opos.process.bridge.provider.ProcessBridgeProvider;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/MobAdGlobalProvider.class */
public class MobAdGlobalProvider extends ProcessBridgeProvider {
    private static final String AUTHORITY_SUFFIX = "MobAdGlobalProvider";

    public static final String getAuthority(Context context) {
        return context.getPackageName() + "." + AUTHORITY_SUFFIX;
    }

    public static Uri getUri(Context context) {
        return Uri.parse("content://" + getAuthority(context));
    }

    @Override // com.opos.process.bridge.provider.ProcessBridgeProvider, android.content.ContentProvider
    public boolean onCreate() {
        return super.onCreate();
    }
}
