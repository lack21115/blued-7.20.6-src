package com.ksad.download;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.core.download.DownloadParams;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/ksad/download/e.class */
public final class e {
    public static PendingIntent a(File file, int i, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.addFlags(3);
        Context context = c.M().getContext();
        Uri a2 = a(context, file);
        intent.setDataAndType(a2, AdBaseConstants.MIME_APK);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, a2, 3);
        }
        Intent intent2 = intent;
        if (z) {
            c.M();
            intent2 = intent;
            if (c.P()) {
                intent2 = a(intent);
            }
        }
        return PendingIntent.getActivity(context, i, intent2, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
    }

    private static Intent a(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra(com.huawei.openalliance.ad.download.app.d.d, intent);
        intent2.addFlags(268435456);
        return intent2;
    }

    private static Uri a(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
        }
        return Uri.fromFile(file);
    }

    public static PendingIntent e(String str, int i) {
        Context context = c.M().getContext();
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i, launchIntentForPackage, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
    }

    public static PendingIntent l(DownloadTask downloadTask) {
        File file = new File(downloadTask.getTargetFilePath());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.addFlags(3);
        Context context = c.M().getContext();
        Uri a2 = a(context, file);
        intent.setDataAndType(a2, AdBaseConstants.MIME_APK);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, a2, 3);
        }
        c.M();
        Intent intent2 = intent;
        if (c.P()) {
            intent2 = intent;
            if (downloadTask.getTag() instanceof DownloadParams) {
                intent2 = intent;
                if (((DownloadParams) downloadTask.getTag()).requestInstallPermission) {
                    intent2 = a(intent);
                }
            }
        }
        return PendingIntent.getActivity(context, downloadTask.getId(), intent2, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
    }
}
