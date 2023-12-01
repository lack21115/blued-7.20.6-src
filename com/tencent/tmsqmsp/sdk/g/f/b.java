package com.tencent.tmsqmsp.sdk.g.f;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.tmsqmsp.sdk.base.c;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/f/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f39790a = Uri.parse("content://cn.nubia.identity/identity");

    public static String a(Context context, String str) {
        Bundle bundle;
        String string;
        StringBuilder sb;
        String str2;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f39790a);
                bundle = acquireUnstableContentProviderClient.call("getAAID", str, null);
                if (i >= 24) {
                    acquireUnstableContentProviderClient.close();
                } else {
                    acquireUnstableContentProviderClient.release();
                }
            } else {
                bundle = context.getContentResolver().call(f39790a, "getAAID", str, null);
            }
            try {
                if (bundle.getInt("code", -1) == 0) {
                    string = bundle.getString("id");
                    sb = new StringBuilder();
                    str2 = "NubiaLog succeed:";
                } else {
                    string = bundle.getString("message");
                    sb = new StringBuilder();
                    str2 = "NubiaLog failed:";
                }
                sb.append(str2);
                sb.append(string);
                bundle = string;
                c.c(sb.toString());
                return string;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return bundle;
            }
        } catch (Exception e2) {
            e = e2;
            bundle = null;
        }
    }

    public static boolean a(Context context) {
        Bundle call;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f39790a);
                call = acquireUnstableContentProviderClient.call("isSupport", null, null);
                if (i >= 24) {
                    acquireUnstableContentProviderClient.close();
                } else {
                    acquireUnstableContentProviderClient.release();
                }
            } else {
                call = context.getContentResolver().call(f39790a, "isSupport", null, null);
            }
            if (call.getInt("code", -1) == 0) {
                c.c("NubiaLog succeed");
                return call.getBoolean("issupport", true);
            }
            String string = call.getString("message");
            StringBuilder sb = new StringBuilder();
            sb.append("NubiaLog failed:");
            sb.append(string);
            c.c(sb.toString());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String b(Context context) {
        String str;
        Exception e;
        Bundle call;
        String string;
        StringBuilder sb;
        String str2;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f39790a);
                call = acquireUnstableContentProviderClient.call("getOAID", null, null);
                if (i >= 24) {
                    acquireUnstableContentProviderClient.close();
                } else {
                    acquireUnstableContentProviderClient.release();
                }
            } else {
                call = context.getContentResolver().call(f39790a, "getOAID", null, null);
            }
            try {
                if (call.getInt("code", -1) == 0) {
                    string = call.getString("id");
                    sb = new StringBuilder();
                    str2 = "NubiaLog succeed:";
                } else {
                    string = call.getString("message");
                    sb = new StringBuilder();
                    str2 = "NubiaLog failed:";
                }
                sb.append(str2);
                sb.append(string);
                call = string;
                c.c(sb.toString());
                return string;
            } catch (Exception e2) {
                e = e2;
                str = call;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e3) {
            str = null;
            e = e3;
        }
    }
}
