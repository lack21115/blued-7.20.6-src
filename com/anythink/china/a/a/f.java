package com.anythink.china.a.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.anythink.core.common.b.g;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/f.class */
public final class f {
    private Context a;

    public f(Context context) {
        this.a = context;
    }

    public final String a() {
        Bundle call;
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(parse);
                Bundle call2 = acquireContentProviderClient.call("getOAID", null, null);
                call = call2;
                if (acquireContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireContentProviderClient.close();
                        call = call2;
                    } else {
                        acquireContentProviderClient.release();
                        call = call2;
                    }
                }
            } else {
                call = this.a.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            int i = -1;
            if (call != null) {
                i = call.getInt(g.c.b, -1);
            }
            return i == 0 ? call.getString("id") : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
