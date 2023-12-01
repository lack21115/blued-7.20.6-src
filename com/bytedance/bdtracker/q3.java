package com.bytedance.bdtracker;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bdtracker.s3;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/q3.class */
public final class q3 implements s3 {
    @Override // com.bytedance.bdtracker.s3
    public s3.a a(Context context) {
        Bundle call;
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient == null) {
                    return null;
                }
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = context.getContentResolver().call(parse, "getOAID", null, null);
            }
            if (call == null) {
                return null;
            }
            if (call.getInt("code", -1) == 0) {
                s3.a aVar = new s3.a();
                aVar.f21305a = call.getString("id");
                return aVar;
            }
            String string = call.getString("message");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            z2.b(string, (Throwable) null);
            return null;
        } catch (Exception e) {
            z2.a(e);
            return null;
        }
    }

    @Override // com.bytedance.bdtracker.s3
    public boolean b(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }
}
