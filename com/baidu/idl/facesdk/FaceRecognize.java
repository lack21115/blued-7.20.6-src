package com.baidu.idl.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.baidu.idl.facesdk.FaceSDK;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/idl/facesdk/FaceRecognize.class */
public class FaceRecognize {
    private static final String TAG = "FaceRecognize";
    private Context context;
    private boolean isInitModel = false;
    private Map<FaceSDK.RecognizeType, Boolean> abilities = new HashMap();

    public FaceRecognize(Context context) {
        this.context = context;
    }

    private native int extractFeature(int[] iArr, int i, int i2, int i3, byte[] bArr, int[] iArr2, int i4, int i5);

    private native float getConsineDistance(byte[] bArr, byte[] bArr2);

    private native float getFaceSimilarity(byte[] bArr, byte[] bArr2, int i, int i2);

    private native int recognizeModelInit(AssetManager assetManager, String str, int i);

    private native int scoreMapInit(AssetManager assetManager, String str, int i);

    public int extractFeature(int[] iArr, int i, int i2, FaceSDK.ImgType imgType, int i3, byte[] bArr, FaceSDK.RecognizeType recognizeType) {
        int i4;
        FaceInfo[] run_detect;
        if (!this.abilities.containsKey(recognizeType)) {
            Log.e(TAG, "not success init " + recognizeType);
            return -1;
        } else if (FaceSDK.checkParameter(iArr, i, i2) && bArr != null && bArr.length == 2048) {
            if (!this.isInitModel) {
                Context context = this.context;
                if (context == null) {
                    return -1;
                }
                FaceSDK.initModel(context);
                this.isInitModel = true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (i3 == 0) {
                i3 = 100;
            }
            FaceInfo[] faceInfoArr = null;
            try {
                Log.e(TAG, "detect start");
            } catch (Exception e) {
                Log.i(TAG, "FaceSDK: You need to apply for the authorization to use the facesdk");
                e.printStackTrace();
            }
            if (recognizeType != FaceSDK.RecognizeType.RECOGNIZE_LIVE && recognizeType != FaceSDK.RecognizeType.RECOGNIZE_ID_PHOTO) {
                run_detect = FaceSDK.run_detect(iArr, i, i2, imgType, FaceSDK.DetectMethodType.NIR, i3);
                FaceInfo[] faceInfoArr2 = run_detect;
                StringBuilder sb = new StringBuilder();
                FaceInfo[] faceInfoArr3 = run_detect;
                sb.append("detect end ");
                FaceInfo[] faceInfoArr4 = run_detect;
                sb.append(System.currentTimeMillis() - currentTimeMillis2);
                faceInfoArr = run_detect;
                Log.e(TAG, sb.toString());
                faceInfoArr = run_detect;
                if (faceInfoArr == null && faceInfoArr.length > 0) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i5 >= faceInfoArr.length) {
                            break;
                        }
                        int i9 = i8;
                        if (faceInfoArr[i5].mWidth > i8) {
                            i9 = faceInfoArr[i5].mWidth;
                            i6 = i5;
                        }
                        i5++;
                        i7 = i9;
                    }
                    int i10 = faceInfoArr[i6].mCenter_x;
                    int i11 = faceInfoArr[i6].mCenter_y;
                    int i12 = faceInfoArr[i6].mWidth;
                    int i13 = faceInfoArr[i6].mAngle;
                    int[] iArr2 = new int[144];
                    try {
                        Log.e(TAG, "align start");
                        FaceSDK.run_align(iArr, i, i2, imgType, FaceSDK.AlignMethodType.CDNN, new int[]{i10, i11, i12, i13}, iArr2, new int[]{0}, new float[]{0.0f});
                        Log.e(TAG, "align end " + (System.currentTimeMillis() - currentTimeMillis3));
                    } catch (Exception e2) {
                        Log.i(TAG, "You need to apply for the authorization to use the facesdk");
                        e2.printStackTrace();
                    }
                    long currentTimeMillis4 = System.currentTimeMillis();
                    try {
                        Log.e(TAG, "feature start");
                        i4 = extractFeature(iArr, i, i2, imgType.ordinal(), bArr, iArr2, 1, recognizeType.ordinal());
                    } catch (Exception e3) {
                        e = e3;
                        i4 = -1;
                    }
                    try {
                        Log.e(TAG, "feature end " + (System.currentTimeMillis() - currentTimeMillis4));
                    } catch (Exception e4) {
                        e = e4;
                        Log.i(TAG, "You need to apply for the authorization to use the facesdk");
                        e.printStackTrace();
                        Log.e(TAG, "all time " + (System.currentTimeMillis() - currentTimeMillis));
                        return i4;
                    }
                    Log.e(TAG, "all time " + (System.currentTimeMillis() - currentTimeMillis));
                    return i4;
                }
            }
            run_detect = FaceSDK.run_detect(iArr, i, i2, imgType, FaceSDK.DetectMethodType.CNN, i3);
            FaceInfo[] faceInfoArr22 = run_detect;
            StringBuilder sb2 = new StringBuilder();
            FaceInfo[] faceInfoArr32 = run_detect;
            sb2.append("detect end ");
            FaceInfo[] faceInfoArr42 = run_detect;
            sb2.append(System.currentTimeMillis() - currentTimeMillis2);
            faceInfoArr = run_detect;
            Log.e(TAG, sb2.toString());
            faceInfoArr = run_detect;
            return faceInfoArr == null ? -1 : -1;
        } else {
            return -1;
        }
    }

    public int extractFeature(int[] iArr, int i, int i2, FaceSDK.ImgType imgType, byte[] bArr, int[] iArr2, FaceSDK.RecognizeType recognizeType) {
        if (!this.abilities.containsKey(recognizeType)) {
            Log.e(TAG, "not success init " + recognizeType);
            return -1;
        } else if (FaceSDK.checkParameter(iArr, i, i2) && iArr2 != null && bArr != null && bArr.length == 2048) {
            return extractFeature(iArr, i, i2, imgType.ordinal(), bArr, iArr2, 1, recognizeType.ordinal());
        } else {
            return -1;
        }
    }

    public float getFaceFeatureDistance(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return -1.0f;
        }
        float consineDistance = getConsineDistance(bArr, bArr2);
        if (Float.isNaN(consineDistance)) {
            return -1.0f;
        }
        return consineDistance;
    }

    public float getFaceSimilarity(byte[] bArr, byte[] bArr2, FaceSDK.RecognizeType recognizeType) {
        if (recognizeType == FaceSDK.RecognizeType.RECOGNIZE_ID_PHOTO || recognizeType == FaceSDK.RecognizeType.RECOGNIZE_NIR) {
            if (BDFaceUtils.hasModel(this.context, FaceConfig.recognize_finance_compare_model_path)) {
                scoreMapInit(this.context.getAssets(), FaceConfig.recognize_finance_compare_model_path, recognizeType.ordinal());
                return getFaceSimilarity(bArr, bArr2, 0, recognizeType.ordinal());
            }
            return 0.0f;
        } else if (recognizeType == FaceSDK.RecognizeType.RECOGNIZE_LIVE && BDFaceUtils.hasModel(this.context, FaceConfig.recognize_compare_model_path)) {
            scoreMapInit(this.context.getAssets(), FaceConfig.recognize_compare_model_path, recognizeType.ordinal());
            return getFaceSimilarity(bArr, bArr2, 0, recognizeType.ordinal());
        } else {
            return 0.0f;
        }
    }

    public void initModel(FaceSDK.RecognizeType recognizeType) {
        if (this.context != null) {
            if (recognizeType == FaceSDK.RecognizeType.RECOGNIZE_ID_PHOTO && BDFaceUtils.hasModel(this.context, FaceConfig.recognize_finance_model_path)) {
                recognizeModelInit(this.context.getAssets(), FaceConfig.recognize_finance_model_path, FaceSDK.RecognizeType.RECOGNIZE_ID_PHOTO.ordinal());
                this.abilities.put(FaceSDK.RecognizeType.RECOGNIZE_ID_PHOTO, true);
            }
            if (recognizeType == FaceSDK.RecognizeType.RECOGNIZE_LIVE && BDFaceUtils.hasModel(this.context, FaceConfig.recognize_model_path)) {
                recognizeModelInit(this.context.getAssets(), FaceConfig.recognize_model_path, FaceSDK.RecognizeType.RECOGNIZE_LIVE.ordinal());
                this.abilities.put(FaceSDK.RecognizeType.RECOGNIZE_LIVE, true);
            }
            if (recognizeType == FaceSDK.RecognizeType.RECOGNIZE_NIR && BDFaceUtils.hasModel(this.context, FaceConfig.recognize_nir_model_path)) {
                recognizeModelInit(this.context.getAssets(), FaceConfig.recognize_nir_model_path, FaceSDK.RecognizeType.RECOGNIZE_NIR.ordinal());
                this.abilities.put(FaceSDK.RecognizeType.RECOGNIZE_NIR, true);
            }
        }
    }
}
