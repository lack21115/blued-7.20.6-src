package com.blued.android.module.live.base.view.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/decoder/ImageRegionDecoder.class */
public interface ImageRegionDecoder {
    Bitmap a(Rect rect, int i);

    Point a(Context context, Uri uri) throws Exception;

    boolean a();

    void b();
}
