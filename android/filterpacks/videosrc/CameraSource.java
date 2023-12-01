package android.filterpacks.videosrc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.GLFrame;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.GenerateFinalPort;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.Matrix;
import android.util.Log;
import java.io.IOException;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/videosrc/CameraSource.class */
public class CameraSource extends Filter {
    private static final int NEWFRAME_TIMEOUT = 100;
    private static final int NEWFRAME_TIMEOUT_REPEAT = 10;
    private static final String TAG = "CameraSource";
    private static final String mFrameShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES tex_sampler_0;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_FragColor = texture2D(tex_sampler_0, v_texcoord);\n}\n";
    private static final float[] mSourceCoords = {0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    private Camera mCamera;
    private GLFrame mCameraFrame;
    @GenerateFieldPort(hasDefault = true, name = "id")
    private int mCameraId;
    private Camera.Parameters mCameraParameters;
    private float[] mCameraTransform;
    @GenerateFieldPort(hasDefault = true, name = "framerate")
    private int mFps;
    private ShaderProgram mFrameExtractor;
    @GenerateFieldPort(hasDefault = true, name = "height")
    private int mHeight;
    private final boolean mLogVerbose;
    private float[] mMappedCoords;
    private boolean mNewFrameAvailable;
    private MutableFrameFormat mOutputFormat;
    private SurfaceTexture mSurfaceTexture;
    @GenerateFinalPort(hasDefault = true, name = "waitForNewFrame")
    private boolean mWaitForNewFrame;
    @GenerateFieldPort(hasDefault = true, name = "width")
    private int mWidth;
    private SurfaceTexture.OnFrameAvailableListener onCameraFrameAvailableListener;

    public CameraSource(String str) {
        super(str);
        this.mCameraId = 0;
        this.mWidth = 320;
        this.mHeight = 240;
        this.mFps = 30;
        this.mWaitForNewFrame = true;
        this.onCameraFrameAvailableListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: android.filterpacks.videosrc.CameraSource.1
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (CameraSource.this.mLogVerbose) {
                    Log.v(CameraSource.TAG, "New frame from camera");
                }
                synchronized (CameraSource.this) {
                    CameraSource.this.mNewFrameAvailable = true;
                    CameraSource.this.notify();
                }
            }
        };
        this.mCameraTransform = new float[16];
        this.mMappedCoords = new float[16];
        this.mLogVerbose = Log.isLoggable(TAG, 2);
    }

    private void createFormats() {
        this.mOutputFormat = ImageFormat.create(this.mWidth, this.mHeight, 3, 3);
    }

    private int[] findClosestFpsRange(int i, Camera.Parameters parameters) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        int[] iArr = supportedPreviewFpsRange.get(0);
        for (int[] iArr2 : supportedPreviewFpsRange) {
            if (iArr2[0] < i * 1000 && iArr2[1] > i * 1000 && iArr2[0] > iArr[0] && iArr2[1] < iArr[1]) {
                iArr = iArr2;
            }
        }
        if (this.mLogVerbose) {
            Log.v(TAG, "Requested fps: " + i + ".Closest frame rate range: [" + (iArr[0] / 1000.0d) + "," + (iArr[1] / 1000.0d) + "]");
        }
        return iArr;
    }

    private int[] findClosestSize(int i, int i2, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        int i3 = -1;
        int i4 = -1;
        int i5 = supportedPreviewSizes.get(0).width;
        int i6 = supportedPreviewSizes.get(0).height;
        for (Camera.Size size : supportedPreviewSizes) {
            int i7 = i4;
            int i8 = i3;
            if (size.width <= i) {
                i7 = i4;
                i8 = i3;
                if (size.height <= i2) {
                    i7 = i4;
                    i8 = i3;
                    if (size.width >= i3) {
                        i7 = i4;
                        i8 = i3;
                        if (size.height >= i4) {
                            i8 = size.width;
                            i7 = size.height;
                        }
                    }
                }
            }
            i4 = i7;
            i3 = i8;
            if (size.width < i5) {
                i4 = i7;
                i3 = i8;
                if (size.height < i6) {
                    i5 = size.width;
                    i6 = size.height;
                    i4 = i7;
                    i3 = i8;
                }
            }
        }
        int i9 = i4;
        int i10 = i3;
        if (i3 == -1) {
            i10 = i5;
            i9 = i6;
        }
        if (this.mLogVerbose) {
            Log.v(TAG, "Requested resolution: (" + i + ", " + i2 + "). Closest match: (" + i10 + ", " + i9 + ").");
        }
        return new int[]{i10, i9};
    }

    @Override // android.filterfw.core.Filter
    public void close(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Closing");
        }
        this.mCamera.release();
        this.mCamera = null;
        this.mSurfaceTexture.release();
        this.mSurfaceTexture = null;
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (str.equals("framerate")) {
            getCameraParameters();
            int[] findClosestFpsRange = findClosestFpsRange(this.mFps, this.mCameraParameters);
            this.mCameraParameters.setPreviewFpsRange(findClosestFpsRange[0], findClosestFpsRange[1]);
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    public Camera.Parameters getCameraParameters() {
        Camera.Parameters parameters;
        synchronized (this) {
            boolean z = false;
            if (this.mCameraParameters == null) {
                if (this.mCamera == null) {
                    this.mCamera = Camera.open(this.mCameraId);
                    z = true;
                }
                this.mCameraParameters = this.mCamera.getParameters();
                if (z) {
                    this.mCamera.release();
                    this.mCamera = null;
                }
            }
            int[] findClosestSize = findClosestSize(this.mWidth, this.mHeight, this.mCameraParameters);
            this.mWidth = findClosestSize[0];
            this.mHeight = findClosestSize[1];
            this.mCameraParameters.setPreviewSize(this.mWidth, this.mHeight);
            int[] findClosestFpsRange = findClosestFpsRange(this.mFps, this.mCameraParameters);
            this.mCameraParameters.setPreviewFpsRange(findClosestFpsRange[0], findClosestFpsRange[1]);
            parameters = this.mCameraParameters;
        }
        return parameters;
    }

    @Override // android.filterfw.core.Filter
    public void open(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Opening");
        }
        this.mCamera = Camera.open(this.mCameraId);
        getCameraParameters();
        this.mCamera.setParameters(this.mCameraParameters);
        createFormats();
        this.mCameraFrame = (GLFrame) filterContext.getFrameManager().newBoundFrame(this.mOutputFormat, 104, 0L);
        this.mSurfaceTexture = new SurfaceTexture(this.mCameraFrame.getTextureId());
        try {
            this.mCamera.setPreviewTexture(this.mSurfaceTexture);
            this.mSurfaceTexture.setOnFrameAvailableListener(this.onCameraFrameAvailableListener);
            this.mNewFrameAvailable = false;
            this.mCamera.startPreview();
        } catch (IOException e) {
            throw new RuntimeException("Could not bind camera surface texture: " + e.getMessage() + "!");
        }
    }

    @Override // android.filterfw.core.Filter
    public void prepare(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Preparing");
        }
        this.mFrameExtractor = new ShaderProgram(filterContext, mFrameShader);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Processing new frame");
        }
        if (this.mWaitForNewFrame) {
            while (!this.mNewFrameAvailable) {
                if (10 == 0) {
                    throw new RuntimeException("Timeout waiting for new frame");
                }
                try {
                    wait(100L);
                } catch (InterruptedException e) {
                    if (this.mLogVerbose) {
                        Log.v(TAG, "Interrupted while waiting for new frame");
                    }
                }
            }
            this.mNewFrameAvailable = false;
            if (this.mLogVerbose) {
                Log.v(TAG, "Got new frame");
            }
        }
        this.mSurfaceTexture.updateTexImage();
        if (this.mLogVerbose) {
            Log.v(TAG, "Using frame extractor in thread: " + Thread.currentThread());
        }
        this.mSurfaceTexture.getTransformMatrix(this.mCameraTransform);
        Matrix.multiplyMM(this.mMappedCoords, 0, this.mCameraTransform, 0, mSourceCoords, 0);
        this.mFrameExtractor.setSourceRegion(this.mMappedCoords[0], this.mMappedCoords[1], this.mMappedCoords[4], this.mMappedCoords[5], this.mMappedCoords[8], this.mMappedCoords[9], this.mMappedCoords[12], this.mMappedCoords[13]);
        Frame newFrame = filterContext.getFrameManager().newFrame(this.mOutputFormat);
        this.mFrameExtractor.process(this.mCameraFrame, newFrame);
        long timestamp = this.mSurfaceTexture.getTimestamp();
        if (this.mLogVerbose) {
            Log.v(TAG, "Timestamp: " + (timestamp / 1.0E9d) + " s");
        }
        newFrame.setTimestamp(timestamp);
        pushOutput("video", newFrame);
        newFrame.release();
        if (this.mLogVerbose) {
            Log.v(TAG, "Done processing new frame");
        }
    }

    public void setCameraParameters(Camera.Parameters parameters) {
        synchronized (this) {
            parameters.setPreviewSize(this.mWidth, this.mHeight);
            this.mCameraParameters = parameters;
            if (isOpen()) {
                this.mCamera.setParameters(this.mCameraParameters);
            }
        }
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addOutputPort("video", ImageFormat.create(3, 3));
    }

    @Override // android.filterfw.core.Filter
    public void tearDown(FilterContext filterContext) {
        if (this.mCameraFrame != null) {
            this.mCameraFrame.release();
        }
    }
}
