package com.opos.cmn.i;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/b.class */
public class b {
    public static final boolean a(Context context, Uri uri) {
        boolean z = false;
        boolean z2 = false;
        try {
            ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
            if (acquireContentProviderClient != null) {
                z2 = true;
            }
            z = z2;
            if (acquireContentProviderClient != null) {
                acquireContentProviderClient.release();
                return z2;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("", "check provider", e);
        }
        return z;
    }
}
