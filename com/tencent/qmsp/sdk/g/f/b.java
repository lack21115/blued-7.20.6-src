package com.tencent.qmsp.sdk.g.f;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.qmsp.sdk.base.c;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/f/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f24949a = Uri.parse("content://cn.nubia.identity/identity");

    public static String a(Context context, String str) {
        Bundle bundle;
        String string;
        StringBuilder sb;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f24949a);
                Bundle call = acquireUnstableContentProviderClient.call("getAAID", str, null);
                bundle = call;
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                        bundle = call;
                    } else {
                        acquireUnstableContentProviderClient.release();
                        bundle = call;
                    }
                }
            } else {
                bundle = context.getContentResolver().call(f24949a, "getAAID", str, null);
            }
        } catch (Exception e) {
            e = e;
            bundle = null;
        }
        try {
            if (bundle.getInt("code", -1) == 0) {
                string = bundle.getString("id");
                sb = new StringBuilder();
                sb.append("NubiaLog succeed:");
            } else {
                string = bundle.getString("message");
                sb = new StringBuilder();
                sb.append("NubiaLog failed:");
            }
            String str2 = string;
            sb.append(string);
            bundle = string;
            c.c(sb.toString());
            return string;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return bundle;
        }
    }

    public static boolean a(Context context) {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f24949a);
                Bundle call2 = acquireUnstableContentProviderClient.call("isSupport", null, null);
                call = call2;
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                        call = call2;
                    } else {
                        acquireUnstableContentProviderClient.release();
                        call = call2;
                    }
                }
            } else {
                call = context.getContentResolver().call(f24949a, "isSupport", null, null);
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
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f24949a);
                Bundle call2 = acquireUnstableContentProviderClient.call("getOAID", null, null);
                call = call2;
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                        call = call2;
                    } else {
                        acquireUnstableContentProviderClient.release();
                        call = call2;
                    }
                }
            } else {
                call = context.getContentResolver().call(f24949a, "getOAID", null, null);
            }
            try {
                if (call.getInt("code", -1) == 0) {
                    string = call.getString("id");
                    sb = new StringBuilder();
                    sb.append("NubiaLog succeed:");
                } else {
                    string = call.getString("message");
                    sb = new StringBuilder();
                    sb.append("NubiaLog failed:");
                }
                String str2 = string;
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
