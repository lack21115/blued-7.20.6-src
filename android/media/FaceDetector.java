package android.media;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/media/FaceDetector.class */
public class FaceDetector {
    private static boolean sInitialized;
    private byte[] mBWBuffer;
    private long mDCR;
    private long mFD;
    private int mHeight;
    private int mMaxFaces;
    private long mSDK;
    private int mWidth;

    /* loaded from: source-9557208-dex2jar.jar:android/media/FaceDetector$Face.class */
    public class Face {
        public static final float CONFIDENCE_THRESHOLD = 0.4f;
        public static final int EULER_X = 0;
        public static final int EULER_Y = 1;
        public static final int EULER_Z = 2;
        private float mConfidence;
        private float mEyesDist;
        private float mMidPointX;
        private float mMidPointY;
        private float mPoseEulerX;
        private float mPoseEulerY;
        private float mPoseEulerZ;

        private Face() {
        }

        public float confidence() {
            return this.mConfidence;
        }

        public float eyesDistance() {
            return this.mEyesDist;
        }

        public void getMidPoint(PointF pointF) {
            pointF.set(this.mMidPointX, this.mMidPointY);
        }

        public float pose(int i) {
            if (i == 0) {
                return this.mPoseEulerX;
            }
            if (i == 1) {
                return this.mPoseEulerY;
            }
            if (i == 2) {
                return this.mPoseEulerZ;
            }
            throw new IllegalArgumentException();
        }
    }

    static {
        sInitialized = false;
        try {
            System.loadLibrary("FFTEm");
            nativeClassInit();
            sInitialized = true;
        } catch (UnsatisfiedLinkError e) {
            Log.d("FFTEm", "face detection library not found!");
        }
    }

    public FaceDetector(int i, int i2, int i3) {
        if (sInitialized) {
            fft_initialize(i, i2, i3);
            this.mWidth = i;
            this.mHeight = i2;
            this.mMaxFaces = i3;
            this.mBWBuffer = new byte[i * i2];
        }
    }

    private native void fft_destroy();

    private native int fft_detect(Bitmap bitmap);

    private native void fft_get_face(Face face, int i);

    private native int fft_initialize(int i, int i2, int i3);

    private static native void nativeClassInit();

    protected void finalize() throws Throwable {
        fft_destroy();
    }

    public int findFaces(Bitmap bitmap, Face[] faceArr) {
        int i;
        if (!sInitialized) {
            i = 0;
        } else if (bitmap.getWidth() != this.mWidth || bitmap.getHeight() != this.mHeight) {
            throw new IllegalArgumentException("bitmap size doesn't match initialization");
        } else {
            if (faceArr.length >= this.mMaxFaces) {
                int fft_detect = fft_detect(bitmap);
                int i2 = fft_detect;
                if (fft_detect >= this.mMaxFaces) {
                    i2 = this.mMaxFaces;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    i = i2;
                    if (i4 >= i2) {
                        break;
                    }
                    if (faceArr[i4] == null) {
                        faceArr[i4] = new Face();
                    }
                    fft_get_face(faceArr[i4], i4);
                    i3 = i4 + 1;
                }
            } else {
                throw new IllegalArgumentException("faces[] smaller than maxFaces");
            }
        }
        return i;
    }
}
