package com.tencent.turingface.sdk.mfa;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/usfPi.class */
public final class usfPi implements Xjpd8 {
    @Override // com.tencent.turingface.sdk.mfa.Xjpd8
    public final void a(Context context) {
    }

    @Override // com.tencent.turingface.sdk.mfa.Xjpd8
    public final OTVRM b(Context context) {
        Bundle call;
        Bundle call2;
        Uri parse = Uri.parse(kC0XR.a(kC0XR.x0));
        String a2 = kC0XR.a(kC0XR.f26271a);
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
            try {
                call2 = acquireContentProviderClient.call(a2, null, null);
                call = call2;
            } catch (Throwable th) {
                call = null;
                if (acquireContentProviderClient != null) {
                    call = null;
                    if (Build.VERSION.SDK_INT >= 24) {
                        call = null;
                    }
                }
            }
            if (i >= 24) {
                call = call2;
                acquireContentProviderClient.close();
            }
            acquireContentProviderClient.release();
        } else {
            call = context.getContentResolver().call(parse, a2, null, null);
        }
        return call == null ? OTVRM.a(-1) : call.getInt(kC0XR.a(kC0XR.y0), -1) != 0 ? OTVRM.a(-2) : new OTVRM(call.getString(kC0XR.a(kC0XR.z0)), 0);
    }
}
