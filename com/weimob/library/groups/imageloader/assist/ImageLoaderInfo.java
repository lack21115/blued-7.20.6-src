package com.weimob.library.groups.imageloader.assist;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/assist/ImageLoaderInfo.class */
public class ImageLoaderInfo {
    public Bitmap bitmap;
    private CloseableReference<?> closeableImageRef;
    public int exifOrientation;
    public String fileExtension;
    public int height;
    public String imageFormat;
    public InputStream inputStream;
    public int rotationAngle;
    public int width;

    public void close() {
        CloseableReference.closeSafely(this.closeableImageRef);
    }

    public void setCloseableImageRef(CloseableReference<?> closeableReference) {
        this.closeableImageRef = closeableReference;
    }
}
