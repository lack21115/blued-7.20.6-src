package android.filterpacks.videosrc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.GLEnvironment;
import android.filterfw.core.GLFrame;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.GenerateFinalPort;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.filterfw.geometry.Point;
import android.filterfw.geometry.Quad;
import android.graphics.SurfaceTexture;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/videosrc/SurfaceTextureTarget.class */
public class SurfaceTextureTarget extends Filter {
    private static final String TAG = "SurfaceTextureTarget";
    private final int RENDERMODE_CUSTOMIZE;
    private final int RENDERMODE_FILL_CROP;
    private final int RENDERMODE_FIT;
    private final int RENDERMODE_STRETCH;
    private float mAspectRatio;
    private boolean mLogVerbose;
    private ShaderProgram mProgram;
    private int mRenderMode;
    @GenerateFieldPort(hasDefault = true, name = "renderMode")
    private String mRenderModeString;
    private GLFrame mScreen;
    @GenerateFinalPort(name = "height")
    private int mScreenHeight;
    @GenerateFinalPort(name = "width")
    private int mScreenWidth;
    @GenerateFieldPort(hasDefault = true, name = "sourceQuad")
    private Quad mSourceQuad;
    private int mSurfaceId;
    @GenerateFinalPort(name = "surfaceTexture")
    private SurfaceTexture mSurfaceTexture;
    @GenerateFieldPort(hasDefault = true, name = "targetQuad")
    private Quad mTargetQuad;

    public SurfaceTextureTarget(String str) {
        super(str);
        this.RENDERMODE_STRETCH = 0;
        this.RENDERMODE_FIT = 1;
        this.RENDERMODE_FILL_CROP = 2;
        this.RENDERMODE_CUSTOMIZE = 3;
        this.mSourceQuad = new Quad(new Point(0.0f, 1.0f), new Point(1.0f, 1.0f), new Point(0.0f, 0.0f), new Point(1.0f, 0.0f));
        this.mTargetQuad = new Quad(new Point(0.0f, 0.0f), new Point(1.0f, 0.0f), new Point(0.0f, 1.0f), new Point(1.0f, 1.0f));
        this.mRenderMode = 1;
        this.mAspectRatio = 1.0f;
        this.mLogVerbose = Log.isLoggable(TAG, 2);
    }

    private void updateTargetRect() {
        if (this.mLogVerbose) {
            Log.v(TAG, "updateTargetRect. Thread: " + Thread.currentThread());
        }
        if (this.mScreenWidth <= 0 || this.mScreenHeight <= 0 || this.mProgram == null) {
            return;
        }
        float f = this.mScreenWidth / this.mScreenHeight;
        float f2 = f / this.mAspectRatio;
        if (this.mLogVerbose) {
            Log.v(TAG, "UTR. screen w = " + this.mScreenWidth + " x screen h = " + this.mScreenHeight + " Screen AR: " + f + ", frame AR: " + this.mAspectRatio + ", relative AR: " + f2);
        }
        if (f2 == 1.0f && this.mRenderMode != 3) {
            this.mProgram.setTargetRect(0.0f, 0.0f, 1.0f, 1.0f);
            this.mProgram.setClearsOutput(false);
            return;
        }
        switch (this.mRenderMode) {
            case 0:
                this.mTargetQuad.p0.set(0.0f, 0.0f);
                this.mTargetQuad.p1.set(1.0f, 0.0f);
                this.mTargetQuad.p2.set(0.0f, 1.0f);
                this.mTargetQuad.p3.set(1.0f, 1.0f);
                this.mProgram.setClearsOutput(false);
                break;
            case 1:
                if (f2 > 1.0f) {
                    this.mTargetQuad.p0.set(0.5f - (0.5f / f2), 0.0f);
                    this.mTargetQuad.p1.set((0.5f / f2) + 0.5f, 0.0f);
                    this.mTargetQuad.p2.set(0.5f - (0.5f / f2), 1.0f);
                    this.mTargetQuad.p3.set((0.5f / f2) + 0.5f, 1.0f);
                } else {
                    this.mTargetQuad.p0.set(0.0f, 0.5f - (0.5f * f2));
                    this.mTargetQuad.p1.set(1.0f, 0.5f - (0.5f * f2));
                    this.mTargetQuad.p2.set(0.0f, (0.5f * f2) + 0.5f);
                    this.mTargetQuad.p3.set(1.0f, (0.5f * f2) + 0.5f);
                }
                this.mProgram.setClearsOutput(true);
                break;
            case 2:
                if (f2 > 1.0f) {
                    this.mTargetQuad.p0.set(0.0f, 0.5f - (0.5f * f2));
                    this.mTargetQuad.p1.set(1.0f, 0.5f - (0.5f * f2));
                    this.mTargetQuad.p2.set(0.0f, (0.5f * f2) + 0.5f);
                    this.mTargetQuad.p3.set(1.0f, (0.5f * f2) + 0.5f);
                } else {
                    this.mTargetQuad.p0.set(0.5f - (0.5f / f2), 0.0f);
                    this.mTargetQuad.p1.set((0.5f / f2) + 0.5f, 0.0f);
                    this.mTargetQuad.p2.set(0.5f - (0.5f / f2), 1.0f);
                    this.mTargetQuad.p3.set((0.5f / f2) + 0.5f, 1.0f);
                }
                this.mProgram.setClearsOutput(true);
                break;
            case 3:
                this.mProgram.setSourceRegion(this.mSourceQuad);
                break;
        }
        if (this.mLogVerbose) {
            Log.v(TAG, "UTR. quad: " + this.mTargetQuad);
        }
        this.mProgram.setTargetRegion(this.mTargetQuad);
    }

    @Override // android.filterfw.core.Filter
    public void close(FilterContext filterContext) {
        synchronized (this) {
            if (this.mSurfaceId > 0) {
                filterContext.getGLEnvironment().unregisterSurfaceId(this.mSurfaceId);
                this.mSurfaceId = -1;
            }
        }
    }

    public void disconnect(FilterContext filterContext) {
        synchronized (this) {
            if (this.mLogVerbose) {
                Log.v(TAG, "disconnect");
            }
            if (this.mSurfaceTexture == null) {
                Log.d(TAG, "SurfaceTexture is already null. Nothing to disconnect.");
            } else {
                this.mSurfaceTexture = null;
                if (this.mSurfaceId > 0) {
                    filterContext.getGLEnvironment().unregisterSurfaceId(this.mSurfaceId);
                    this.mSurfaceId = -1;
                }
            }
        }
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "FPVU. Thread: " + Thread.currentThread());
        }
        updateRenderMode();
    }

    @Override // android.filterfw.core.Filter
    public void open(FilterContext filterContext) {
        synchronized (this) {
            if (this.mSurfaceTexture == null) {
                Log.e(TAG, "SurfaceTexture is null!!");
                throw new RuntimeException("Could not register SurfaceTexture: " + this.mSurfaceTexture);
            }
            this.mSurfaceId = filterContext.getGLEnvironment().registerSurfaceTexture(this.mSurfaceTexture, this.mScreenWidth, this.mScreenHeight);
            if (this.mSurfaceId <= 0) {
                throw new RuntimeException("Could not register SurfaceTexture: " + this.mSurfaceTexture);
            }
        }
    }

    @Override // android.filterfw.core.Filter
    public void prepare(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Prepare. Thread: " + Thread.currentThread());
        }
        this.mProgram = ShaderProgram.createIdentity(filterContext);
        this.mProgram.setSourceRect(0.0f, 1.0f, 1.0f, -1.0f);
        this.mProgram.setClearColor(0.0f, 0.0f, 0.0f);
        updateRenderMode();
        MutableFrameFormat mutableFrameFormat = new MutableFrameFormat(2, 3);
        mutableFrameFormat.setBytesPerSample(4);
        mutableFrameFormat.setDimensions(this.mScreenWidth, this.mScreenHeight);
        this.mScreen = (GLFrame) filterContext.getFrameManager().newBoundFrame(mutableFrameFormat, 101, 0L);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame frame;
        synchronized (this) {
            if (this.mSurfaceId > 0) {
                GLEnvironment gLEnvironment = filterContext.getGLEnvironment();
                Frame pullInput = pullInput(TypedValues.AttributesType.S_FRAME);
                boolean z = false;
                float width = pullInput.getFormat().getWidth() / pullInput.getFormat().getHeight();
                if (width != this.mAspectRatio) {
                    if (this.mLogVerbose) {
                        Log.v(TAG, "Process. New aspect ratio: " + width + ", previously: " + this.mAspectRatio + ". Thread: " + Thread.currentThread());
                    }
                    this.mAspectRatio = width;
                    updateTargetRect();
                }
                if (pullInput.getFormat().getTarget() != 3) {
                    frame = filterContext.getFrameManager().duplicateFrameToTarget(pullInput, 3);
                    z = true;
                } else {
                    frame = pullInput;
                }
                gLEnvironment.activateSurfaceWithId(this.mSurfaceId);
                this.mProgram.process(frame, this.mScreen);
                gLEnvironment.setSurfaceTimestamp(pullInput.getTimestamp());
                gLEnvironment.swapBuffers();
                if (z) {
                    frame.release();
                }
            }
        }
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        synchronized (this) {
            if (this.mSurfaceTexture == null) {
                throw new RuntimeException("Null SurfaceTexture passed to SurfaceTextureTarget");
            }
            addMaskedInputPort(TypedValues.AttributesType.S_FRAME, ImageFormat.create(3));
        }
    }

    @Override // android.filterfw.core.Filter
    public void tearDown(FilterContext filterContext) {
        if (this.mScreen != null) {
            this.mScreen.release();
        }
    }

    public void updateRenderMode() {
        if (this.mLogVerbose) {
            Log.v(TAG, "updateRenderMode. Thread: " + Thread.currentThread());
        }
        if (this.mRenderModeString != null) {
            if (this.mRenderModeString.equals("stretch")) {
                this.mRenderMode = 0;
            } else if (this.mRenderModeString.equals("fit")) {
                this.mRenderMode = 1;
            } else if (this.mRenderModeString.equals("fill_crop")) {
                this.mRenderMode = 2;
            } else if (!this.mRenderModeString.equals("customize")) {
                throw new RuntimeException("Unknown render mode '" + this.mRenderModeString + "'!");
            } else {
                this.mRenderMode = 3;
            }
        }
        updateTargetRect();
    }
}
