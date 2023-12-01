package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l1111l111111Il/l111l1111l1Il.class */
public final class l111l1111l1Il extends l111l1111lI1l {
    private final Context l1111l111111Il;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l111l1111l1Il(Context context) {
        this.l1111l111111Il = context;
    }

    @Override // com.ishumei.l111l11111Il.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            Bundle bundle = null;
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = this.l1111l111111Il.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient != null) {
                    bundle = acquireContentProviderClient.call("getOAID", null, null);
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                }
            } else {
                bundle = this.l1111l111111Il.getContentResolver().call(parse, "getOAID", null, null);
            }
            int i = -1;
            if (bundle != null) {
                i = bundle.getInt("code", -1);
            }
            return i == 0 ? bundle.getString("id") : "";
        } catch (Exception e) {
            return "";
        }
    }
}
