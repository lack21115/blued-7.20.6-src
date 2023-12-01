package com.baidu.aip.face;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.idl.facesdk.FaceInfo;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/FaceCropper.class */
public class FaceCropper {
    public static void adjustRect(int[] iArr, int i, Rect rect) {
        rect.left = Math.max(rect.left, 0);
        rect.right = Math.min(rect.right, i);
        rect.bottom = Math.min(rect.bottom, iArr.length / i);
        rect.sort();
    }

    public static int[] crop(int[] iArr, int i, Rect rect) {
        adjustRect(iArr, i, rect);
        int[] iArr2 = new int[rect.width() * rect.height()];
        int i2 = rect.top;
        while (true) {
            int i3 = i2;
            if (i3 >= rect.bottom) {
                return iArr2;
            }
            try {
                System.arraycopy(iArr, (i * i3) + rect.left, iArr2, rect.width() * (i3 - rect.top), rect.width());
                i2 = i3 + 1;
            } catch (Exception e) {
                e.printStackTrace();
                return iArr;
            }
        }
    }

    public static Bitmap getFace(int[] iArr, FaceInfo faceInfo, int i) {
        int[] iArr2 = new int[8];
        faceInfo.getRectPoints(iArr2);
        int i2 = iArr2[2];
        int i3 = iArr2[3];
        int i4 = iArr2[6];
        int i5 = iArr2[7];
        int i6 = ((i4 - i2) * 3) / 2;
        int i7 = (i5 - i3) * 2;
        int i8 = faceInfo.mCenter_x;
        int i9 = i6 / 2;
        int i10 = faceInfo.mCenter_y;
        int i11 = i7 / 2;
        int i12 = (i7 * 4) / 5;
        int max = Math.max(i8 - i9, 0);
        int max2 = Math.max(i10 - i11, 0);
        Rect rect = new Rect(max, max2, i6 + max, i12 + max2);
        adjustRect(iArr, i, rect);
        return Bitmap.createBitmap(iArr, (rect.top * i) + rect.left, i, rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
    }
}
