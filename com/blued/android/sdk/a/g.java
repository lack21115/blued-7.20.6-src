package com.blued.android.sdk.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/a/g.class */
public class g {
    public static void a(final Context context) {
        new AlertDialog.Builder(context).setMessage("您的手机没有安装Blued客户端，是否前往官网进行下载?").setPositiveButton("前往", new DialogInterface.OnClickListener() { // from class: com.blued.android.sdk.a.g.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                g.b(Context.this);
            }
        }).setNegativeButton("取消", (DialogInterface.OnClickListener) null).show();
    }

    public static boolean a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static void b(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.blued.cn"));
        context.startActivity(intent);
    }
}
