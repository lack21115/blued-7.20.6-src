package com.cdo.oaps.ad;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/q.class */
public class q {
    public static boolean a(Context context) {
        Intent launchIntentForPackage;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (launchIntentForPackage = packageManager.getLaunchIntentForPackage(a.b(a.f7907a))) == null) {
                return false;
            }
            launchIntentForPackage.setFlags(270532608);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, long j, boolean z, boolean z2, int i) {
        try {
            Uri parse = Uri.parse(a.c() + "market://ProductDetail?pid=" + j);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            intent.setPackage(a.b(a.f7907a));
            intent.putExtra("out_intent_from", i);
            intent.addFlags(335544320);
            intent.putExtra("extra.key.productdetail_start_with_download", z);
            intent.putExtra("go_back_to_launcher_app", z2);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return false;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2, int i) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(a.c() + "market://detail_search?keyword=" + str + "&packagename=" + str2));
            intent.addFlags(335544320);
            intent.setPackage(a.b(a.f7907a));
            intent.putExtra("out_intent_from", i);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, boolean z, boolean z2, int i) {
        try {
            Uri parse = Uri.parse(a.c() + "market://details?packagename=" + str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            intent.setPackage(a.b(a.f7907a));
            intent.putExtra("out_intent_from", i);
            intent.addFlags(335544320);
            intent.putExtra("extra.key.productdetail_start_with_download", z);
            intent.putExtra("go_back_to_launcher_app", z2);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return false;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
