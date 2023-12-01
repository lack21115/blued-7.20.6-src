package com.kwad.components.ad.splashscreen.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.kwad.sdk.utils.v;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/n.class */
public final class n extends e {
    private com.kwad.sdk.core.download.kwai.a Db;

    /* JADX INFO: Access modifiers changed from: private */
    public static String S(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return context.getResources().getString(packageInfo.applicationInfo.labelRes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Db = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.n.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                String str;
                super.onDownloadStarted();
                Context context = n.this.getContext();
                if (context != null) {
                    String S = n.S(context);
                    if (S != null) {
                        str = S + ":已开始下载";
                    } else {
                        str = "已开始下载";
                    }
                    v.H(context, str);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
            }
        };
        this.Cg.mApkDownloadHelper.b(this.Db);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        if (this.Db != null) {
            this.Cg.mApkDownloadHelper.c(this.Db);
        }
    }
}
