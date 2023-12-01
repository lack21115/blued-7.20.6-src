package com.tencent.cloud.huiyansdkface.facelight.common;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.view.WindowManager;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.io.ByteArrayOutputStream;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/common/RotateSetting.class */
public class RotateSetting {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21896a = RotateSetting.class.getSimpleName();
    private static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f21897c = -1;

    public static byte[] Nv21MirrorCenter(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 >= i2) {
                break;
            }
            int i6 = i5 + i;
            int i7 = i6;
            while (true) {
                int i8 = i7 - 1;
                if (i5 < i8) {
                    byte b2 = bArr[i5];
                    bArr[i5] = bArr[i8];
                    bArr[i8] = b2;
                    i5++;
                    i7 = i8;
                }
            }
            i3++;
            i4 = i6;
        }
        int i9 = 0;
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= i2 / 2) {
                return bArr;
            }
            int i12 = (i * i2) + i9;
            int i13 = i12 + i;
            int i14 = 2;
            while (true) {
                int i15 = i13 - i14;
                if (i12 < i15) {
                    byte b3 = bArr[i12];
                    bArr[i12] = bArr[i15];
                    bArr[i15] = b3;
                    int i16 = i12 + 1;
                    int i17 = i15 - 1;
                    byte b4 = bArr[i16];
                    bArr[i16] = bArr[i17];
                    bArr[i17] = b4;
                    i12 = i16 + 1;
                    i13 = i17;
                    i14 = 1;
                }
            }
            i9 += i;
            i10 = i11 + 1;
        }
    }

    private static int a(int i) {
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 8;
        }
        if (i == 6) {
            return 7;
        }
        if (i == 7) {
            return 6;
        }
        if (i == 8) {
            return 5;
        }
        String str = f21896a;
        WLogger.w(str, "[YtCameraSetting.transBackFacingCameraRatateTag] unsurported rotateTag: " + i);
        return 0;
    }

    private static int a(int i, int i2) {
        int i3;
        if (i == 90) {
            i3 = 7;
        } else if (i == 180) {
            i3 = 3;
        } else if (i == 270) {
            i3 = 5;
        } else {
            WLogger.i(f21896a, "camera rotate not 90degree or 180degree, input: " + i);
            i3 = 1;
        }
        return i2 == 1 ? i3 : a(i3);
    }

    private static int a(Context context, int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        int rotation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();
        int i2 = 0;
        if (rotation != 0) {
            i2 = rotation != 1 ? rotation != 2 ? rotation != 3 ? 0 : 270 : 180 : 90;
        }
        int i3 = (cameraInfo.facing == 1 ? 360 - ((cameraInfo.orientation + i2) % 360) : (cameraInfo.orientation - i2) + 360) % 360;
        WLogger.i(f21896a, "debug camera orientation is " + cameraInfo.orientation + " ui degrees is " + i2);
        f21897c = i3;
        return i3;
    }

    public static void calRotateTag(Context context, int i, int i2) {
        b = a(a(context, i), i2);
    }

    public static int getRotate() {
        return b;
    }

    public static int getVideoRotate() {
        return f21897c;
    }

    public static byte[] rawCamDataToJpg(int i, byte[] bArr, int i2, int i3, boolean z) {
        int i4;
        int i5;
        byte[] rotateRawCamData = rotateRawCamData(i, bArr, i2, i3);
        if (z && (i == 1 || i == 2 || i == 3 || i == 4)) {
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
        }
        if (i != 5 && i != 6 && i != 7 && i != 8) {
            i3 = i4;
            i2 = i5;
        }
        YuvImage yuvImage = new YuvImage(rotateRawCamData, 17, i3, i2, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.reset();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return byteArray;
        }
    }

    public static byte[] rotateNV21Degree90(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 * 3) / 2;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = i2;
            while (true) {
                int i8 = i7 - 1;
                if (i8 >= 0) {
                    bArr2[i5] = bArr[(i8 * i) + i6];
                    i5++;
                    i7 = i8;
                }
            }
        }
        int i9 = i4 - 1;
        int i10 = i;
        int i11 = 1;
        while (true) {
            int i12 = i10 - i11;
            if (i12 <= 0) {
                return bArr2;
            }
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 < i2 / 2) {
                    int i15 = (i14 * i) + i3;
                    bArr2[i9] = bArr[i15 + i12];
                    int i16 = i9 - 1;
                    bArr2[i16] = bArr[i15 + (i12 - 1)];
                    i9 = i16 - 1;
                    i13 = i14 + 1;
                }
            }
            i10 = i12;
            i11 = 2;
        }
    }

    public static byte[] rotateRawCamData(int i, byte[] bArr, int i2, int i3) {
        switch (i) {
            case 2:
                return Nv21MirrorCenter(bArr, i2, i3);
            case 3:
                return rotateYUV420Degree180(bArr, i2, i3);
            case 4:
                return rotateYUV420Degree180(Nv21MirrorCenter(bArr, i2, i3), i2, i3);
            case 5:
                return rotateYUV420Degree270(Nv21MirrorCenter(bArr, i2, i3), i2, i3);
            case 6:
                return rotateNV21Degree90(bArr, i2, i3);
            case 7:
                return rotateNV21Degree90(Nv21MirrorCenter(bArr, i2, i3), i2, i3);
            case 8:
                return rotateYUV420Degree270(bArr, i2, i3);
            default:
                return bArr;
        }
    }

    public static byte[] rotateYUV420Degree180(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 * 3) / 2;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            bArr2[i5] = bArr[i6];
            i5++;
        }
        int i7 = i4;
        int i8 = 1;
        while (true) {
            int i9 = i7 - i8;
            if (i9 < i3) {
                return bArr2;
            }
            int i10 = i5 + 1;
            bArr2[i5] = bArr[i9 - 1];
            i5 = i10 + 1;
            bArr2[i10] = bArr[i9];
            i7 = i9;
            i8 = 2;
        }
    }

    public static byte[] rotateYUV420Degree270(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = i * i2;
        byte[] bArr2 = new byte[(i5 * 3) / 2];
        int i6 = i - 1;
        int i7 = i6;
        int i8 = 0;
        while (true) {
            i4 = i8;
            if (i7 < 0) {
                break;
            }
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 < i2) {
                    bArr2[i8] = bArr[(i10 * i) + i7];
                    i8++;
                    i9 = i10 + 1;
                }
            }
            i7--;
        }
        for (i3 = i6; i3 > 0; i3 -= 2) {
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 < i2 / 2) {
                    int i13 = (i12 * i) + i5;
                    bArr2[i4] = bArr[(i3 - 1) + i13];
                    int i14 = i4 + 1;
                    bArr2[i14] = bArr[i13 + i3];
                    i4 = i14 + 1;
                    i11 = i12 + 1;
                }
            }
        }
        return bArr2;
    }

    public static void setRotateInfo(int i) {
        int i2;
        switch (i) {
            case 1:
            case 2:
                WLogger.d(f21896a, "ROTATE 0");
                i2 = 0;
                break;
            case 3:
            case 4:
                WLogger.d(f21896a, "ROTATE 180");
                i2 = 180;
                break;
            case 5:
            case 6:
                WLogger.d(f21896a, "ROTATE 270");
                i2 = 270;
                break;
            case 7:
            case 8:
                WLogger.d(f21896a, "ROTATE 90");
                i2 = 90;
                break;
            default:
                return;
        }
        Param.setRolateInfo(String.valueOf(i2));
    }
}
