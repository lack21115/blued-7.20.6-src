package com.blued.android.core.image.transform;

import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/transform/CropWithStartEndTransformation.class */
public class CropWithStartEndTransformation extends BitmapTransformation {
    private boolean b;

    public CropWithStartEndTransformation(boolean z) {
        this.b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0114  */
    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r9, android.graphics.Bitmap r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.image.transform.CropWithStartEndTransformation.a(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool, android.graphics.Bitmap, int, int):android.graphics.Bitmap");
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        messageDigest.update(("com.blued.android.core.transform.CropWithStartEndTransformation.1" + this.b).getBytes(f20706a));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof CropWithStartEndTransformation) && ((CropWithStartEndTransformation) obj).b == this.b;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1058285468 + (this.b ? 1000 : 0);
    }

    public String toString() {
        return "CropWithStartEndTransformation(fitStart=" + this.b + ")";
    }
}
