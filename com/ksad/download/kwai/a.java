package com.ksad.download.kwai;

import android.content.Context;
import android.content.Intent;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
import com.kwad.sdk.core.d.b;

/* loaded from: source-7994992-dex2jar.jar:com/ksad/download/kwai/a.class */
public final class a {
    public static void a(Context context, String str, DownloadTask.DownloadRequest downloadRequest) {
        try {
            Intent intent = new Intent(context, DownloadService.class);
            intent.putExtra("download_service_type_tag", 1);
            intent.putExtra("download_service_id_tag", str);
            intent.putExtra("download_service_args_tag", downloadRequest);
            context.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(Context context, String str) {
        b.d("DownloadClient", "pauseDownload");
        try {
            Intent intent = new Intent(context, DownloadService.class);
            intent.putExtra("download_service_type_tag", 2);
            intent.putExtra("download_service_id_tag", str);
            context.startService(intent);
        } catch (Exception e) {
        }
    }
}
