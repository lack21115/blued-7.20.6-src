package com.kwad.sdk.core.imageloader.utils;

import android.opengl.GLES10;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/utils/ImageSizeUtils.class */
public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    /* renamed from: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/utils/ImageSizeUtils$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ViewScaleType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType = iArr;
            try {
                iArr[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[ViewScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        maxBitmapSize = new ImageSize(max, max);
    }

    private ImageSizeUtils() {
    }

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int max;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        int i = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[viewScaleType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                max = 1;
            } else if (z) {
                int i2 = width / 2;
                int i3 = height / 2;
                int i4 = 1;
                while (true) {
                    int i5 = i4;
                    max = i5;
                    if (i2 / i5 <= width2) {
                        break;
                    }
                    max = i5;
                    if (i3 / i5 <= height2) {
                        break;
                    }
                    i4 = i5 * 2;
                }
            } else {
                max = Math.min(width / width2, height / height2);
            }
        } else if (z) {
            int i6 = width / 2;
            int i7 = height / 2;
            int i8 = 1;
            while (true) {
                int i9 = i8;
                if (i6 / i9 <= width2) {
                    max = i9;
                    if (i7 / i9 <= height2) {
                        break;
                    }
                }
                i8 = i9 * 2;
            }
        } else {
            max = Math.max(width / width2, height / height2);
        }
        if (max <= 0) {
            max = 1;
        }
        return considerMaxTextureSize(width, height, max, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0093, code lost:
        if (r12 != r0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static float computeImageScale(com.kwad.sdk.core.imageloader.core.assist.ImageSize r3, com.kwad.sdk.core.imageloader.core.assist.ImageSize r4, com.kwad.sdk.core.imageloader.core.assist.ViewScaleType r5, boolean r6) {
        /*
            r0 = r3
            int r0 = r0.getWidth()
            r13 = r0
            r0 = r3
            int r0 = r0.getHeight()
            r14 = r0
            r0 = r4
            int r0 = r0.getWidth()
            r11 = r0
            r0 = r4
            int r0 = r0.getHeight()
            r12 = r0
            r0 = r13
            float r0 = (float) r0
            r9 = r0
            r0 = r9
            r1 = r11
            float r1 = (float) r1
            float r0 = r0 / r1
            r7 = r0
            r0 = r14
            float r0 = (float) r0
            r8 = r0
            r0 = r8
            r1 = r12
            float r1 = (float) r1
            float r0 = r0 / r1
            r10 = r0
            r0 = r5
            com.kwad.sdk.core.imageloader.core.assist.ViewScaleType r1 = com.kwad.sdk.core.imageloader.core.assist.ViewScaleType.FIT_INSIDE
            if (r0 != r1) goto L41
            r0 = r7
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L50
        L41:
            r0 = r5
            com.kwad.sdk.core.imageloader.core.assist.ViewScaleType r1 = com.kwad.sdk.core.imageloader.core.assist.ViewScaleType.CROP
            if (r0 != r1) goto L5b
            r0 = r7
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L5b
        L50:
            r0 = r8
            r1 = r7
            float r0 = r0 / r1
            int r0 = (int) r0
            r12 = r0
            goto L63
        L5b:
            r0 = r9
            r1 = r10
            float r0 = r0 / r1
            int r0 = (int) r0
            r11 = r0
        L63:
            r0 = 1065353216(0x3f800000, float:1.0)
            r8 = r0
            r0 = r6
            if (r0 != 0) goto L78
            r0 = r11
            r1 = r13
            if (r0 >= r1) goto L78
            r0 = r12
            r1 = r14
            if (r0 < r1) goto L96
        L78:
            r0 = r8
            r7 = r0
            r0 = r6
            if (r0 == 0) goto L9e
            r0 = r8
            r7 = r0
            r0 = r11
            r1 = r13
            if (r0 == r1) goto L9e
            r0 = r8
            r7 = r0
            r0 = r12
            r1 = r14
            if (r0 == r1) goto L9e
        L96:
            r0 = r11
            float r0 = (float) r0
            r1 = r9
            float r0 = r0 / r1
            r7 = r0
        L9e:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils.computeImageScale(com.kwad.sdk.core.imageloader.core.assist.ImageSize, com.kwad.sdk.core.imageloader.core.assist.ImageSize, com.kwad.sdk.core.imageloader.core.assist.ViewScaleType, boolean):float");
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        return Math.max((int) Math.ceil(width / maxBitmapSize.getWidth()), (int) Math.ceil(height / maxBitmapSize.getHeight()));
    }

    private static int considerMaxTextureSize(int i, int i2, int i3, boolean z) {
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i / i3 <= width && i2 / i3 <= height) {
                return i3;
            }
            i3 = z ? i3 * 2 : i3 + 1;
        }
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
        int width = imageAware.getWidth();
        int i = width;
        if (width <= 0) {
            i = imageSize.getWidth();
        }
        int height = imageAware.getHeight();
        int i2 = height;
        if (height <= 0) {
            i2 = imageSize.getHeight();
        }
        return new ImageSize(i, i2);
    }
}
