package com.tencent.qmsp.oaid2;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/c0.class */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f38461a = Uri.parse("content://cn.nubia.identity/identity");

    public static String a(Context context, String str) {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f38461a);
                Bundle call2 = acquireUnstableContentProviderClient.call("getAAID", str, null);
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
                call = context.getContentResolver().call(f38461a, "getAAID", str, null);
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                StringBuilder sb = new StringBuilder();
                sb.append("NubiaLog succeed:");
                sb.append(string);
                c.c(sb.toString());
                return string;
            }
            String string2 = call.getString("message");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NubiaLog failed:");
            sb2.append(string2);
            c.c(sb2.toString());
            return string2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context) {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f38461a);
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
                call = context.getContentResolver().call(f38461a, "isSupport", null, null);
            }
            if (call.getInt("code", -1) == 0) {
                c.c("NubiaLog succeed");
                return call.getBoolean("issupport", true);
            }
            String string = call.getString("message");
            c.c("NubiaLog failed:" + string);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String b(Context context) {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f38461a);
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
                call = context.getContentResolver().call(f38461a, "getOAID", null, null);
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                StringBuilder sb = new StringBuilder();
                sb.append("NubiaLog succeed:");
                sb.append(string);
                c.c(sb.toString());
                return string;
            }
            String string2 = call.getString("message");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NubiaLog failed:");
            sb2.append(string2);
            c.c(sb2.toString());
            return string2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
