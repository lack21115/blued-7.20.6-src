package c.t.m.g;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/z0.class */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f4022a;

    public z0(Context context) {
        this.f4022a = context;
    }

    public String a() {
        Bundle call;
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = this.f4022a.getContentResolver().acquireContentProviderClient(parse);
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
                call = this.f4022a.getContentResolver().call(parse, "getOAID", null, null);
            }
            if (call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
            call.getString("message");
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
