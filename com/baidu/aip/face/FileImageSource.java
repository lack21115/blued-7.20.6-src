package com.baidu.aip.face;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import java.io.IOException;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/FileImageSource.class */
public class FileImageSource extends ImageSource {
    private String filePath;

    private static int getExifOrientation(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e) {
            exifInterface = null;
        }
        if (exifInterface == null || (attributeInt = exifInterface.getAttributeInt("Orientation", -1)) == -1) {
            return 0;
        }
        if (attributeInt != 3) {
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        }
        return 180;
    }

    private Bitmap getImageThumbnail(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i3 = options.outHeight;
        int i4 = options.outWidth / i;
        int i5 = i3 / i2;
        if (i4 >= i5) {
            i4 = i5;
        }
        if (i4 <= 0) {
            i4 = 1;
        }
        options.inSampleSize = i4;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(str, options);
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
        if (r0 == 270) goto L15;
     */
    @Override // com.baidu.aip.face.ImageSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void start() {
        /*
            r9 = this;
            r0 = r9
            super.start()
            r0 = r9
            r1 = r9
            java.lang.String r1 = r1.filePath
            r2 = 960(0x3c0, float:1.345E-42)
            r3 = 960(0x3c0, float:1.345E-42)
            android.graphics.Bitmap r0 = r0.getImageThumbnail(r1, r2, r3)
            r12 = r0
            r0 = r9
            java.lang.String r0 = r0.filePath
            int r0 = getExifOrientation(r0)
            r10 = r0
            r0 = r10
            r1 = 90
            if (r0 == r1) goto L31
            r0 = r10
            r1 = 180(0xb4, float:2.52E-43)
            if (r0 == r1) goto L31
            r0 = r12
            r11 = r0
            r0 = r10
            r1 = 270(0x10e, float:3.78E-43)
            if (r0 != r1) goto L51
        L31:
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = r11
            r1 = r10
            float r1 = (float) r1
            boolean r0 = r0.postRotate(r1)
            r0 = r12
            r1 = 0
            r2 = 0
            r3 = r12
            int r3 = r3.getWidth()
            r4 = r12
            int r4 = r4.getHeight()
            r5 = r11
            r6 = 1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)
            r11 = r0
        L51:
            r0 = r11
            int r0 = r0.getWidth()
            r1 = r11
            int r1 = r1.getHeight()
            int r0 = r0 * r1
            int[] r0 = new int[r0]
            r13 = r0
            r0 = r11
            r1 = r13
            r2 = 0
            r3 = r11
            int r3 = r3.getWidth()
            r4 = 0
            r5 = 0
            r6 = r11
            int r6 = r6.getWidth()
            r7 = r11
            int r7 = r7.getHeight()
            r0.getPixels(r1, r2, r3, r4, r5, r6, r7)
            com.baidu.aip.FaceDetector r0 = com.baidu.aip.FaceDetector.getInstance()
            r0.clearTrackedFaces()
            com.baidu.aip.ImageFrame r0 = new com.baidu.aip.ImageFrame
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            r1 = r13
            r0.setArgb(r1)
            r0 = r12
            r1 = r11
            int r1 = r1.getWidth()
            r0.setWidth(r1)
            r0 = r12
            r1 = r11
            int r1 = r1.getHeight()
            r0.setHeight(r1)
            r0 = r9
            java.util.ArrayList r0 = r0.getListeners()
            java.util.Iterator r0 = r0.iterator()
            r11 = r0
        L9f:
            r0 = r11
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lba
            r0 = r11
            java.lang.Object r0 = r0.next()
            com.baidu.aip.face.OnFrameAvailableListener r0 = (com.baidu.aip.face.OnFrameAvailableListener) r0
            r1 = r12
            r0.onFrameAvailable(r1)
            goto L9f
        Lba:
            com.baidu.aip.FaceDetector r0 = com.baidu.aip.FaceDetector.getInstance()
            r0.clearTrackedFaces()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.aip.face.FileImageSource.start():void");
    }
}
