package android.hardware.camera2.legacy;

import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.legacy.LegacyExceptionUtils;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Environment;
import android.os.SystemProperties;
import android.text.format.Time;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/SurfaceTextureRenderer.class */
public class SurfaceTextureRenderer {
    private static final int EGL_COLOR_BITLENGTH = 8;
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private static final int FLIP_TYPE_BOTH = 3;
    private static final int FLIP_TYPE_HORIZONTAL = 1;
    private static final int FLIP_TYPE_NONE = 0;
    private static final int FLIP_TYPE_VERTICAL = 2;
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final int GLES_VERSION = 2;
    private static final int GL_MATRIX_SIZE = 16;
    private static final String LEGACY_PERF_PROPERTY = "persist.camera.legacy_perf";
    private static final int PBUFFER_PIXEL_BYTES = 4;
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
    private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
    private static final int VERTEX_POS_SIZE = 3;
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private static final int VERTEX_UV_SIZE = 2;
    private FloatBuffer mBothFlipTriangleVertices;
    private EGLConfig mConfigs;
    private final int mFacing;
    private FloatBuffer mHorizontalFlipTriangleVertices;
    private ByteBuffer mPBufferPixels;
    private int mProgram;
    private volatile SurfaceTexture mSurfaceTexture;
    private FloatBuffer mVerticalFlipTriangleVertices;
    private int maPositionHandle;
    private int maTextureHandle;
    private int muMVPMatrixHandle;
    private int muSTMatrixHandle;
    private static final String TAG = SurfaceTextureRenderer.class.getSimpleName();
    private static final boolean DEBUG = Log.isLoggable(LegacyCameraDevice.DEBUG_PROP, 3);
    private static final float[] sHorizontalFlipTriangleVertices = {-1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] sVerticalFlipTriangleVertices = {-1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] sBothFlipTriangleVertices = {-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};
    private static final float[] sRegularTriangleVertices = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
    private List<EGLSurfaceHolder> mSurfaces = new ArrayList();
    private List<EGLSurfaceHolder> mConversionSurfaces = new ArrayList();
    private float[] mMVPMatrix = new float[16];
    private float[] mSTMatrix = new float[16];
    private int mTextureID = 0;
    private PerfMeasurement mPerfMeasurer = null;
    private FloatBuffer mRegularTriangleVertices = ByteBuffer.allocateDirect(sRegularTriangleVertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/SurfaceTextureRenderer$EGLSurfaceHolder.class */
    public class EGLSurfaceHolder {
        EGLSurface eglSurface;
        int height;
        Surface surface;
        int width;

        private EGLSurfaceHolder() {
        }
    }

    public SurfaceTextureRenderer(int i) {
        this.mFacing = i;
        this.mRegularTriangleVertices.put(sRegularTriangleVertices).position(0);
        this.mHorizontalFlipTriangleVertices = ByteBuffer.allocateDirect(sHorizontalFlipTriangleVertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mHorizontalFlipTriangleVertices.put(sHorizontalFlipTriangleVertices).position(0);
        this.mVerticalFlipTriangleVertices = ByteBuffer.allocateDirect(sVerticalFlipTriangleVertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mVerticalFlipTriangleVertices.put(sVerticalFlipTriangleVertices).position(0);
        this.mBothFlipTriangleVertices = ByteBuffer.allocateDirect(sBothFlipTriangleVertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mBothFlipTriangleVertices.put(sBothFlipTriangleVertices).position(0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
    }

    private void addGlTimestamp(long j) {
        if (this.mPerfMeasurer == null) {
            return;
        }
        this.mPerfMeasurer.addTimestamp(j);
    }

    private void beginGlTiming() {
        if (this.mPerfMeasurer == null) {
            return;
        }
        this.mPerfMeasurer.startTimer();
    }

    private void checkEglError(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    private void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            throw new IllegalStateException(str + ": GLES20 error: 0x" + Integer.toHexString(glGetError));
        }
    }

    private void clearState() {
        this.mSurfaces.clear();
        this.mConversionSurfaces.clear();
        this.mPBufferPixels = null;
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
        }
        this.mSurfaceTexture = null;
    }

    private void configureEGLContext() {
        this.mEGLDisplay = EGL14.eglGetDisplay(0);
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new IllegalStateException("No EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.mEGLDisplay, iArr, 0, iArr, 1)) {
            throw new IllegalStateException("Cannot initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, 4, EGL_RECORDABLE_ANDROID, 1, EGL14.EGL_SURFACE_TYPE, 5, EGL14.EGL_NONE}, 0, eGLConfigArr, 0, eGLConfigArr.length, iArr2, 0);
        checkEglError("eglCreateContext RGB888+recordable ES2");
        if (iArr2[0] == 0) {
            Log.w(TAG, "eglChooseConfig returned no configs, retrying without EGL_RECORDABLE_ANDROID");
            EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_SURFACE_TYPE, 5, EGL14.EGL_NONE}, 0, eGLConfigArr, 0, eGLConfigArr.length, iArr2, 0);
            checkEglError("eglCreateContext RGB888 ES2");
        }
        this.mConfigs = eGLConfigArr[0];
        this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, EGL14.EGL_NONE}, 0);
        checkEglError("eglCreateContext");
        if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
            throw new IllegalStateException("No EGLContext could be made");
        }
    }

    private void configureEGLOutputSurfaces(Collection<EGLSurfaceHolder> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalStateException("No Surfaces were provided to draw to");
        }
        for (EGLSurfaceHolder eGLSurfaceHolder : collection) {
            eGLSurfaceHolder.eglSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mConfigs, eGLSurfaceHolder.surface, new int[]{EGL14.EGL_NONE}, 0);
            checkEglError("eglCreateWindowSurface");
        }
    }

    private void configureEGLPbufferSurfaces(Collection<EGLSurfaceHolder> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalStateException("No Surfaces were provided to draw to");
        }
        int i = 0;
        for (EGLSurfaceHolder eGLSurfaceHolder : collection) {
            int i2 = eGLSurfaceHolder.width * eGLSurfaceHolder.height;
            int i3 = i;
            if (i2 > i) {
                i3 = i2;
            }
            eGLSurfaceHolder.eglSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mConfigs, new int[]{EGL14.EGL_WIDTH, eGLSurfaceHolder.width, EGL14.EGL_HEIGHT, eGLSurfaceHolder.height, EGL14.EGL_NONE}, 0);
            checkEglError("eglCreatePbufferSurface");
            i = i3;
        }
        this.mPBufferPixels = ByteBuffer.allocateDirect(i * 4).order(ByteOrder.nativeOrder());
    }

    private int createProgram(String str, String str2) {
        int i;
        int loadShader = loadShader(GLES20.GL_VERTEX_SHADER, str);
        if (loadShader == 0) {
            i = 0;
        } else {
            int loadShader2 = loadShader(GLES20.GL_FRAGMENT_SHADER, str2);
            if (loadShader2 == 0) {
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            checkGlError("glCreateProgram");
            if (glCreateProgram == 0) {
                Log.e(TAG, "Could not create program");
            }
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, GLES20.GL_LINK_STATUS, iArr, 0);
            i = glCreateProgram;
            if (iArr[0] != 1) {
                Log.e(TAG, "Could not link program: ");
                Log.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                throw new IllegalStateException("Could not link program");
            }
        }
        return i;
    }

    private void drawFrame(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        FloatBuffer floatBuffer;
        checkGlError("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.mSTMatrix);
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        try {
            Size textureSize = LegacyCameraDevice.getTextureSize(surfaceTexture);
            float width = textureSize.getWidth();
            float height = textureSize.getHeight();
            if (width <= 0.0f || height <= 0.0f) {
                throw new IllegalStateException("Illegal intermediate texture with dimension of 0");
            }
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF(0.0f, 0.0f, i, i2);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.CENTER);
            matrix.mapRect(rectF2);
            float width2 = rectF.width() / rectF2.width();
            float height2 = rectF.height() / rectF2.height();
            android.opengl.Matrix.scaleM(this.mMVPMatrix, 0, width2, height2, 1.0f);
            if (DEBUG) {
                Log.d(TAG, "Scaling factors (S_x = " + width2 + ",S_y = " + height2 + ") used for " + i + "x" + i2 + " surface, intermediate buffer size is " + width + "x" + height);
            }
            GLES20.glViewport(0, 0, i, i2);
            if (DEBUG) {
                GLES20.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(LogType.UNEXP_RESTART);
            }
            GLES20.glUseProgram(this.mProgram);
            checkGlError("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
            switch (i3) {
                case 1:
                    floatBuffer = this.mHorizontalFlipTriangleVertices;
                    break;
                case 2:
                    floatBuffer = this.mVerticalFlipTriangleVertices;
                    break;
                case 3:
                    floatBuffer = this.mBothFlipTriangleVertices;
                    break;
                default:
                    floatBuffer = this.mRegularTriangleVertices;
                    break;
            }
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, (Buffer) floatBuffer);
            checkGlError("glVertexAttribPointer maPosition");
            GLES20.glEnableVertexAttribArray(this.maPositionHandle);
            checkGlError("glEnableVertexAttribArray maPositionHandle");
            floatBuffer.position(3);
            GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 20, (Buffer) floatBuffer);
            checkGlError("glVertexAttribPointer maTextureHandle");
            GLES20.glEnableVertexAttribArray(this.maTextureHandle);
            checkGlError("glEnableVertexAttribArray maTextureHandle");
            GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
            GLES20.glDrawArrays(5, 0, 4);
            checkGlError("glDrawArrays");
        } catch (LegacyExceptionUtils.BufferQueueAbandonedException e) {
            throw new IllegalStateException("Surface abandoned, skipping drawFrame...", e);
        }
    }

    private void dumpGlTiming() {
        if (this.mPerfMeasurer == null) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "CameraLegacy");
        if (!file.exists() && !file.mkdirs()) {
            Log.e(TAG, "Failed to create directory for data dump");
            return;
        }
        StringBuilder sb = new StringBuilder(file.getPath());
        sb.append(File.separator);
        sb.append("durations_");
        Time time = new Time();
        time.setToNow();
        sb.append(time.format2445());
        sb.append("_S");
        for (EGLSurfaceHolder eGLSurfaceHolder : this.mSurfaces) {
            sb.append(String.format("_%d_%d", Integer.valueOf(eGLSurfaceHolder.width), Integer.valueOf(eGLSurfaceHolder.height)));
        }
        sb.append("_C");
        for (EGLSurfaceHolder eGLSurfaceHolder2 : this.mConversionSurfaces) {
            sb.append(String.format("_%d_%d", Integer.valueOf(eGLSurfaceHolder2.width), Integer.valueOf(eGLSurfaceHolder2.height)));
        }
        sb.append(".txt");
        this.mPerfMeasurer.dumpPerformanceData(sb.toString());
    }

    private void endGlTiming() {
        if (this.mPerfMeasurer == null) {
            return;
        }
        this.mPerfMeasurer.stopTimer();
    }

    private int getTextureId() {
        return this.mTextureID;
    }

    private void initializeGLState() {
        this.mProgram = createProgram(VERTEX_SHADER, FRAGMENT_SHADER);
        if (this.mProgram == 0) {
            throw new IllegalStateException("failed creating program");
        }
        this.maPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
        checkGlError("glGetAttribLocation aPosition");
        if (this.maPositionHandle == -1) {
            throw new IllegalStateException("Could not get attrib location for aPosition");
        }
        this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        checkGlError("glGetAttribLocation aTextureCoord");
        if (this.maTextureHandle == -1) {
            throw new IllegalStateException("Could not get attrib location for aTextureCoord");
        }
        this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
        checkGlError("glGetUniformLocation uMVPMatrix");
        if (this.muMVPMatrixHandle == -1) {
            throw new IllegalStateException("Could not get attrib location for uMVPMatrix");
        }
        this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
        checkGlError("glGetUniformLocation uSTMatrix");
        if (this.muSTMatrixHandle == -1) {
            throw new IllegalStateException("Could not get attrib location for uSTMatrix");
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mTextureID = iArr[0];
        GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
        checkGlError("glBindTexture mTextureID");
        GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
        GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        GLES20.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
        GLES20.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
        checkGlError("glTexParameter");
    }

    private int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        checkGlError("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, GLES20.GL_COMPILE_STATUS, iArr, 0);
        if (iArr[0] == 0) {
            Log.e(TAG, "Could not compile shader " + i + ":");
            Log.e(TAG, " " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            throw new IllegalStateException("Could not compile shader " + i);
        }
        return glCreateShader;
    }

    private void makeCurrent(EGLSurface eGLSurface) {
        EGL14.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface, this.mEGLContext);
        checkEglError("makeCurrent");
    }

    private void releaseEGLContext() {
        if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            dumpGlTiming();
            if (this.mSurfaces != null) {
                for (EGLSurfaceHolder eGLSurfaceHolder : this.mSurfaces) {
                    if (eGLSurfaceHolder.eglSurface != null) {
                        EGL14.eglDestroySurface(this.mEGLDisplay, eGLSurfaceHolder.eglSurface);
                    }
                }
            }
            if (this.mConversionSurfaces != null) {
                for (EGLSurfaceHolder eGLSurfaceHolder2 : this.mConversionSurfaces) {
                    if (eGLSurfaceHolder2.eglSurface != null) {
                        EGL14.eglDestroySurface(this.mEGLDisplay, eGLSurfaceHolder2.eglSurface);
                    }
                }
            }
            EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mConfigs = null;
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        clearState();
    }

    private void setupGlTiming() {
        if (PerfMeasurement.isGlTimingSupported()) {
            Log.d(TAG, "Enabling GL performance measurement");
            this.mPerfMeasurer = new PerfMeasurement();
            return;
        }
        Log.d(TAG, "GL performance measurement not supported on this device");
        this.mPerfMeasurer = null;
    }

    private boolean swapBuffers(EGLSurface eGLSurface) {
        boolean eglSwapBuffers = EGL14.eglSwapBuffers(this.mEGLDisplay, eGLSurface);
        checkEglError("swapBuffers");
        return eglSwapBuffers;
    }

    public void cleanupEGLContext() {
        releaseEGLContext();
    }

    public void configureSurfaces(Collection<Pair<Surface, Size>> collection) {
        releaseEGLContext();
        if (collection == null || collection.size() == 0) {
            Log.w(TAG, "No output surfaces configured for GL drawing.");
            return;
        }
        for (Pair<Surface, Size> pair : collection) {
            Surface surface = pair.first;
            Size size = pair.second;
            try {
                EGLSurfaceHolder eGLSurfaceHolder = new EGLSurfaceHolder();
                eGLSurfaceHolder.surface = surface;
                eGLSurfaceHolder.width = size.getWidth();
                eGLSurfaceHolder.height = size.getHeight();
                if (LegacyCameraDevice.needsConversion(surface)) {
                    LegacyCameraDevice.setSurfaceFormat(surface, ImageFormat.YV12);
                    this.mConversionSurfaces.add(eGLSurfaceHolder);
                } else {
                    this.mSurfaces.add(eGLSurfaceHolder);
                }
            } catch (LegacyExceptionUtils.BufferQueueAbandonedException e) {
                Log.w(TAG, "Surface abandoned, skipping configuration... ", e);
            }
        }
        configureEGLContext();
        if (this.mSurfaces.size() > 0) {
            configureEGLOutputSurfaces(this.mSurfaces);
        }
        if (this.mConversionSurfaces.size() > 0) {
            configureEGLPbufferSurfaces(this.mConversionSurfaces);
        }
        makeCurrent(this.mSurfaces.size() > 0 ? this.mSurfaces.get(0).eglSurface : this.mConversionSurfaces.get(0).eglSurface);
        initializeGLState();
        this.mSurfaceTexture = new SurfaceTexture(getTextureId());
        if (SystemProperties.getBoolean(LEGACY_PERF_PROPERTY, false)) {
            setupGlTiming();
        }
    }

    public void drawIntoSurfaces(CaptureCollector captureCollector) {
        if ((this.mSurfaces == null || this.mSurfaces.size() == 0) && (this.mConversionSurfaces == null || this.mConversionSurfaces.size() == 0)) {
            return;
        }
        boolean hasPendingPreviewCaptures = captureCollector.hasPendingPreviewCaptures();
        checkGlError("before updateTexImage");
        if (hasPendingPreviewCaptures) {
            beginGlTiming();
        }
        this.mSurfaceTexture.updateTexImage();
        long timestamp = this.mSurfaceTexture.getTimestamp();
        Pair<RequestHolder, Long> previewCaptured = captureCollector.previewCaptured(timestamp);
        if (previewCaptured == null) {
            if (DEBUG) {
                Log.d(TAG, "Dropping preview frame.");
            }
            if (hasPendingPreviewCaptures) {
                endGlTiming();
                return;
            }
            return;
        }
        Collection<Surface> holderTargets = previewCaptured.first.getHolderTargets();
        if (hasPendingPreviewCaptures) {
            addGlTimestamp(timestamp);
        }
        List<Long> surfaceIds = LegacyCameraDevice.getSurfaceIds(holderTargets);
        for (EGLSurfaceHolder eGLSurfaceHolder : this.mSurfaces) {
            if (LegacyCameraDevice.containsSurfaceId(eGLSurfaceHolder.surface, surfaceIds)) {
                try {
                    LegacyCameraDevice.setSurfaceDimens(eGLSurfaceHolder.surface, eGLSurfaceHolder.width, eGLSurfaceHolder.height);
                    makeCurrent(eGLSurfaceHolder.eglSurface);
                    LegacyCameraDevice.setNextTimestamp(eGLSurfaceHolder.surface, previewCaptured.second.longValue());
                    drawFrame(this.mSurfaceTexture, eGLSurfaceHolder.width, eGLSurfaceHolder.height, this.mFacing == 0 ? 1 : 0);
                    swapBuffers(eGLSurfaceHolder.eglSurface);
                } catch (LegacyExceptionUtils.BufferQueueAbandonedException e) {
                    Log.w(TAG, "Surface abandoned, dropping frame. ", e);
                }
            }
        }
        for (EGLSurfaceHolder eGLSurfaceHolder2 : this.mConversionSurfaces) {
            if (LegacyCameraDevice.containsSurfaceId(eGLSurfaceHolder2.surface, surfaceIds)) {
                makeCurrent(eGLSurfaceHolder2.eglSurface);
                drawFrame(this.mSurfaceTexture, eGLSurfaceHolder2.width, eGLSurfaceHolder2.height, this.mFacing == 0 ? 3 : 2);
                this.mPBufferPixels.clear();
                GLES20.glReadPixels(0, 0, eGLSurfaceHolder2.width, eGLSurfaceHolder2.height, 6408, 5121, this.mPBufferPixels);
                checkGlError("glReadPixels");
                try {
                    int detectSurfaceType = LegacyCameraDevice.detectSurfaceType(eGLSurfaceHolder2.surface);
                    LegacyCameraDevice.setSurfaceDimens(eGLSurfaceHolder2.surface, eGLSurfaceHolder2.width, eGLSurfaceHolder2.height);
                    LegacyCameraDevice.setNextTimestamp(eGLSurfaceHolder2.surface, previewCaptured.second.longValue());
                    LegacyCameraDevice.produceFrame(eGLSurfaceHolder2.surface, this.mPBufferPixels.array(), eGLSurfaceHolder2.width, eGLSurfaceHolder2.height, detectSurfaceType);
                } catch (LegacyExceptionUtils.BufferQueueAbandonedException e2) {
                    Log.w(TAG, "Surface abandoned, dropping frame. ", e2);
                }
            }
        }
        captureCollector.previewProduced();
        if (hasPendingPreviewCaptures) {
            endGlTiming();
        }
    }

    public void flush() {
        Log.e(TAG, "Flush not yet implemented.");
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }
}
