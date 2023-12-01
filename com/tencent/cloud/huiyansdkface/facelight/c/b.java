package com.tencent.cloud.huiyansdkface.facelight.c;

import android.util.Base64;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.DataPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f35543a = b.class.getSimpleName();

    private static float a(float f, float f2, float f3, float f4) {
        return (f * f4) - (f3 * f2);
    }

    public static float a(float[] fArr) {
        float f = fArr[32] - fArr[40];
        float f2 = fArr[33] - fArr[41];
        float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        float abs = (Math.abs(a(f, f2, fArr[44] - fArr[40], fArr[45] - fArr[41])) + Math.abs(a(f, f2, fArr[36] - fArr[40], fArr[37] - fArr[41]))) / (sqrt * sqrt);
        float f3 = fArr[56] - fArr[48];
        float f4 = fArr[57] - fArr[49];
        float sqrt2 = (float) Math.sqrt((f3 * f3) + (f4 * f4));
        float abs2 = (Math.abs(a(f3, f4, fArr[60] - fArr[56], fArr[61] - fArr[57])) + Math.abs(a(f3, f4, fArr[52] - fArr[56], fArr[53] - fArr[57]))) / (sqrt2 * sqrt2);
        float f5 = abs;
        if (abs > abs2) {
            f5 = abs2;
        }
        return f5;
    }

    public static Timeval a(long j) {
        return new Timeval(j / 1000, (int) ((j * 1000) % 1000000));
    }

    private static ColorImgData a(RawImgData rawImgData) {
        ColorImgData colorImgData = new ColorImgData();
        colorImgData.setImage(new String(Base64.encode(rawImgData.frameBuffer, 2)));
        colorImgData.checksum = rawImgData.checksum;
        colorImgData.setCapture_time(rawImgData.captureTime);
        colorImgData.setX(rawImgData.x);
        colorImgData.setY(rawImgData.y);
        return colorImgData;
    }

    public static ReflectColorData a(DataPack dataPack) {
        ReflectColorData reflectColorData = new ReflectColorData();
        ArrayList<ColorImgData> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dataPack.videoData.length) {
                break;
            }
            arrayList.add(a(dataPack.videoData[i2]));
            i = i2 + 1;
        }
        reflectColorData.setImages_data(arrayList);
        reflectColorData.setBegin_time(dataPack.beginTime);
        reflectColorData.setChangepoint_time(dataPack.changePointTime);
        reflectColorData.changepoint_time_list = new ArrayList<>();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= dataPack.changePointTimeList.length) {
                break;
            }
            reflectColorData.changepoint_time_list.add(Long.valueOf(dataPack.changePointTimeList[i4]));
            i3 = i4 + 1;
        }
        reflectColorData.setOffset_sys(dataPack.offsetSys);
        reflectColorData.setFrame_num(dataPack.frameNum);
        reflectColorData.setLandmark_num(dataPack.landMarkNum);
        reflectColorData.setWidth(dataPack.width);
        reflectColorData.setHeight(dataPack.height);
        reflectColorData.version = "3.6.7";
        try {
            reflectColorData.setLog(new String(dataPack.log, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }
        reflectColorData.setConfig_begin(dataPack.config_begin);
        return reflectColorData;
    }

    public static boolean a(YTFaceTracker.TrackedFace trackedFace, float f, float f2) {
        int i;
        int i2;
        int i3;
        String str;
        StringBuilder sb;
        String str2;
        int i4 = (int) (f * 17.0f);
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = i6;
            if (i5 >= 8) {
                break;
            }
            int i7 = i;
            if (trackedFace.faceVisible[i5] < f2) {
                i7 = i + 1;
            }
            i5++;
            i6 = i7;
        }
        int i8 = 16;
        while (i8 < 24) {
            int i9 = i;
            if (trackedFace.faceVisible[i8] < f2) {
                i9 = i + 1;
            }
            i8++;
            i = i9;
        }
        int i10 = i;
        if (trackedFace.faceVisible[88] < f2) {
            i10 = i + 1;
        }
        if (i10 > i4) {
            str = f35543a;
            sb = new StringBuilder();
            str2 = "左眼部被挡住，count=";
        } else {
            int i11 = 0;
            int i12 = 8;
            while (true) {
                i2 = i11;
                i3 = 24;
                if (i12 >= 16) {
                    break;
                }
                int i13 = i11;
                if (trackedFace.faceVisible[i12] < f2) {
                    i13 = i11 + 1;
                }
                i12++;
                i11 = i13;
            }
            while (i3 < 32) {
                int i14 = i2;
                if (trackedFace.faceVisible[i3] < f2) {
                    i14 = i2 + 1;
                }
                i3++;
                i2 = i14;
            }
            i10 = i2;
            if (trackedFace.faceVisible[89] < f2) {
                i10 = i2 + 1;
            }
            if (i10 <= i4) {
                return false;
            }
            str = f35543a;
            sb = new StringBuilder();
            str2 = "右眼部被挡住，count=";
        }
        sb.append(str2);
        sb.append(i10);
        WLogger.w(str, sb.toString());
        return true;
    }

    public static YTFaceTracker.TrackedFace[] a(YTFaceTracker.TrackedFace[] trackedFaceArr) {
        if (trackedFaceArr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= trackedFaceArr.length) {
                    break;
                }
                trackedFaceArr[i2].faceShape = b(trackedFaceArr[i2].faceShape);
                trackedFaceArr[i2].faceVisible = c(trackedFaceArr[i2].faceVisible);
                i = i2 + 1;
            }
        }
        return trackedFaceArr;
    }

    public static boolean b(YTFaceTracker.TrackedFace trackedFace, float f, float f2) {
        int i;
        int i2 = (int) (f * 13.0f);
        int i3 = 32;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i3 >= 45) {
                break;
            }
            int i5 = i;
            if (trackedFace.faceVisible[i3] < f2) {
                i5 = i + 1;
            }
            i3++;
            i4 = i5;
        }
        if (i > i2) {
            WLogger.w(f35543a, "鼻子被挡住，count=" + i);
            return true;
        }
        return false;
    }

    private static float[] b(float[] fArr) {
        int i;
        int i2;
        int i3;
        float[] fArr2 = new float[180];
        int[] iArr = {0, 4, 18, 19, 7, 8, 10, 11, 12, 14, 15, 21, 20};
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < 32) {
            fArr2[i5] = fArr[i6];
            i4++;
            i6++;
            i5++;
        }
        int i7 = 0;
        while (i7 < 32) {
            fArr2[i5] = fArr[i6];
            i7++;
            i6++;
            i5++;
        }
        float[] fArr3 = new float[44];
        int i8 = 0;
        while (i8 < 44) {
            fArr3[i8] = fArr[i6];
            i8++;
            i6++;
        }
        fArr3[16] = (fArr3[16] + fArr3[18]) / 2.0f;
        fArr3[19] = (fArr3[19] + fArr3[19]) / 2.0f;
        fArr3[28] = (fArr3[28] + fArr3[26]) / 2.0f;
        fArr3[29] = (fArr3[29] + fArr3[27]) / 2.0f;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= 13) {
                break;
            }
            int i11 = i5 + 1;
            fArr2[i5] = fArr3[iArr[i10] * 2];
            i5 = i11 + 1;
            fArr2[i11] = fArr3[(iArr[i10] * 2) + 1];
            i9 = i10 + 1;
        }
        int i12 = 0;
        while (i12 < 44) {
            fArr2[i5] = fArr[i6];
            i12++;
            i6++;
            i5++;
        }
        int i13 = 0;
        while (i13 < 82) {
            if ((i13 / 2) % 2 != 1) {
                fArr2[i5] = fArr[i6];
                i5++;
            }
            i13++;
            i6++;
        }
        int i14 = 0;
        while (true) {
            i = 0;
            i2 = i5;
            i3 = i6;
            if (i14 >= 14) {
                break;
            }
            i14++;
            i6++;
        }
        while (i < 4) {
            fArr2[i2] = fArr[i3];
            i++;
            i3++;
            i2++;
        }
        return fArr2;
    }

    public static boolean c(YTFaceTracker.TrackedFace trackedFace, float f, float f2) {
        int i;
        int i2 = (int) (f * 22.0f);
        int i3 = 45;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i3 >= 67) {
                break;
            }
            int i5 = i;
            if (trackedFace.faceVisible[i3] < f2) {
                i5 = i + 1;
            }
            i3++;
            i4 = i5;
        }
        if (i > i2) {
            WLogger.w(f35543a, "嘴巴被挡住，count=" + i);
            return true;
        }
        return false;
    }

    private static float[] c(float[] fArr) {
        int i;
        int i2;
        int i3;
        float[] fArr2 = new float[90];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < 16) {
            fArr2[i5] = fArr[i6];
            i4++;
            i6++;
            i5++;
        }
        int i7 = 0;
        while (i7 < 16) {
            fArr2[i5] = fArr[i6];
            i7++;
            i6++;
            i5++;
        }
        float[] fArr3 = new float[22];
        int i8 = 0;
        while (i8 < 22) {
            fArr3[i8] = fArr[i6];
            i8++;
            i6++;
        }
        fArr3[8] = (fArr3[8] + fArr3[9]) / 2.0f;
        fArr3[14] = (fArr3[14] + fArr3[13]) / 2.0f;
        int i9 = 0;
        while (i9 < 13) {
            fArr2[i5] = fArr3[new int[]{0, 4, 18, 19, 7, 8, 10, 11, 12, 14, 15, 21, 20}[i9]];
            i9++;
            i5++;
        }
        int i10 = 0;
        while (i10 < 22) {
            fArr2[i5] = fArr[i6];
            i10++;
            i6++;
            i5++;
        }
        int i11 = 0;
        while (i11 < 41) {
            if (i11 % 2 != 1) {
                fArr2[i5] = fArr[i6];
                i5++;
            }
            i11++;
            i6++;
        }
        int i12 = 0;
        while (true) {
            i = 0;
            i2 = i5;
            i3 = i6;
            if (i12 >= 7) {
                break;
            }
            i12++;
            i6++;
        }
        while (i < 2) {
            fArr2[i2] = fArr[i3];
            i++;
            i3++;
            i2++;
        }
        return fArr2;
    }
}
