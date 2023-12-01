package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/ImageLoaderPerfUtil.class */
public class ImageLoaderPerfUtil {
    private static final String TAG = ImageLoaderPerfUtil.class.getSimpleName();

    public static ImageLoaderInfo getInfo() {
        ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
        imageLoaderInfo.totalCount = y.DE();
        imageLoaderInfo.successCount = y.DF();
        imageLoaderInfo.failedCount = y.DG();
        imageLoaderInfo.duration = y.DD();
        return imageLoaderInfo;
    }

    public static void report() {
        g.execute(new aw() { // from class: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
                if (info.totalCount == 0) {
                    b.w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
                    return;
                }
                String str = ImageLoaderPerfUtil.TAG;
                b.d(str, "ImageLoaderInfo:" + info.toJson().toString());
                KSLoggerReporter.y(info.toJson());
            }
        });
    }
}
