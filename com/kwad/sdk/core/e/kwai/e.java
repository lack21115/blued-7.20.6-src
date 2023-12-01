package com.kwad.sdk.core.e.kwai;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/kwai/e.class */
public final class e {
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Bundle call;
        String str = "";
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = this.mContext.getContentResolver().call(parse, "getOAID", null, null);
            }
            String str2 = "";
            if (call != null) {
                str2 = call.getInt("code", -1) == 0 ? call.getString("id") : "";
                String str3 = str2;
                String string = call.getString("message");
                String str4 = str2;
                StringBuilder sb = new StringBuilder("getOAID oaid:");
                String str5 = str2;
                sb.append(str2);
                String str6 = str2;
                sb.append("faledMsg:");
                str = str2;
                sb.append(string);
            }
            return str2;
        } catch (Exception e) {
            return str;
        }
    }
}
