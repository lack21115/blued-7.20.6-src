package android.filterpacks.ui;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.FilterSurfaceView;
import android.filterfw.core.Frame;
import android.filterfw.core.GLEnvironment;
import android.filterfw.core.GLFrame;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.GenerateFinalPort;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.util.Log;
import android.view.SurfaceHolder;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/ui/SurfaceRenderFilter.class */
public class SurfaceRenderFilter extends Filter implements SurfaceHolder.Callback {
    private static final String TAG = "SurfaceRenderFilter";
    private final int RENDERMODE_FILL_CROP;
    private final int RENDERMODE_FIT;
    private final int RENDERMODE_STRETCH;
    private float mAspectRatio;
    private boolean mIsBound;
    private boolean mLogVerbose;
    private ShaderProgram mProgram;
    private int mRenderMode;
    @GenerateFieldPort(hasDefault = true, name = "renderMode")
    private String mRenderModeString;
    private GLFrame mScreen;
    private int mScreenHeight;
    private int mScreenWidth;
    @GenerateFinalPort(name = "surfaceView")
    private FilterSurfaceView mSurfaceView;

    public SurfaceRenderFilter(String str) {
        super(str);
        this.RENDERMODE_STRETCH = 0;
        this.RENDERMODE_FIT = 1;
        this.RENDERMODE_FILL_CROP = 2;
        this.mIsBound = false;
        this.mRenderMode = 1;
        this.mAspectRatio = 1.0f;
        this.mLogVerbose = Log.isLoggable(TAG, 2);
    }

    private void updateTargetRect() {
        if (this.mScreenWidth <= 0 || this.mScreenHeight <= 0 || this.mProgram == null) {
            return;
        }
        float f = (this.mScreenWidth / this.mScreenHeight) / this.mAspectRatio;
        switch (this.mRenderMode) {
            case 0:
                this.mProgram.setTargetRect(0.0f, 0.0f, 1.0f, 1.0f);
                return;
            case 1:
                if (f > 1.0f) {
                    this.mProgram.setTargetRect(0.5f - (0.5f / f), 0.0f, 1.0f / f, 1.0f);
                    return;
                } else {
                    this.mProgram.setTargetRect(0.0f, 0.5f - (0.5f * f), 1.0f, f);
                    return;
                }
            case 2:
                if (f > 1.0f) {
                    this.mProgram.setTargetRect(0.0f, 0.5f - (0.5f * f), 1.0f, f);
                    return;
                } else {
                    this.mProgram.setTargetRect(0.5f - (0.5f / f), 0.0f, 1.0f / f, 1.0f);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.filterfw.core.Filter
    public void close(FilterContext filterContext) {
        this.mSurfaceView.unbind();
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        updateTargetRect();
    }

    @Override // android.filterfw.core.Filter
    public void open(FilterContext filterContext) {
        this.mSurfaceView.unbind();
        this.mSurfaceView.bindToListener(this, filterContext.getGLEnvironment());
    }

    @Override // android.filterfw.core.Filter
    public void prepare(FilterContext filterContext) {
        this.mProgram = ShaderProgram.createIdentity(filterContext);
        this.mProgram.setSourceRect(0.0f, 1.0f, 1.0f, -1.0f);
        this.mProgram.setClearsOutput(true);
        this.mProgram.setClearColor(0.0f, 0.0f, 0.0f);
        updateRenderMode();
        this.mScreen = (GLFrame) filterContext.getFrameManager().newBoundFrame(ImageFormat.create(this.mSurfaceView.getWidth(), this.mSurfaceView.getHeight(), 3, 3), 101, 0L);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame frame;
        if (!this.mIsBound) {
            Log.w(TAG, this + ": Ignoring frame as there is no surface to render to!");
            return;
        }
        if (this.mLogVerbose) {
            Log.v(TAG, "Starting frame processing");
        }
        GLEnvironment gLEnv = this.mSurfaceView.getGLEnv();
        if (gLEnv != filterContext.getGLEnvironment()) {
            throw new RuntimeException("Surface created under different GLEnvironment!");
        }
        Frame pullInput = pullInput(TypedValues.AttributesType.S_FRAME);
        boolean z = false;
        float width = pullInput.getFormat().getWidth() / pullInput.getFormat().getHeight();
        if (width != this.mAspectRatio) {
            if (this.mLogVerbose) {
                Log.v(TAG, "New aspect ratio: " + width + ", previously: " + this.mAspectRatio);
            }
            this.mAspectRatio = width;
            updateTargetRect();
        }
        if (this.mLogVerbose) {
            Log.v(TAG, "Got input format: " + pullInput.getFormat());
        }
        if (pullInput.getFormat().getTarget() != 3) {
            frame = filterContext.getFrameManager().duplicateFrameToTarget(pullInput, 3);
            z = true;
        } else {
            frame = pullInput;
        }
        gLEnv.activateSurfaceWithId(this.mSurfaceView.getSurfaceId());
        this.mProgram.process(frame, this.mScreen);
        gLEnv.swapBuffers();
        if (z) {
            frame.release();
        }
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        if (this.mSurfaceView == null) {
            throw new RuntimeException("NULL SurfaceView passed to SurfaceRenderFilter");
        }
        addMaskedInputPort(TypedValues.AttributesType.S_FRAME, ImageFormat.create(3));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        synchronized (this) {
            if (this.mScreen != null) {
                this.mScreenWidth = i2;
                this.mScreenHeight = i3;
                this.mScreen.setViewport(0, 0, this.mScreenWidth, this.mScreenHeight);
                updateTargetRect();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        synchronized (this) {
            this.mIsBound = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this) {
            this.mIsBound = false;
        }
    }

    @Override // android.filterfw.core.Filter
    public void tearDown(FilterContext filterContext) {
        if (this.mScreen != null) {
            this.mScreen.release();
        }
    }

    public void updateRenderMode() {
        if (this.mRenderModeString != null) {
            if (this.mRenderModeString.equals("stretch")) {
                this.mRenderMode = 0;
            } else if (this.mRenderModeString.equals("fit")) {
                this.mRenderMode = 1;
            } else if (!this.mRenderModeString.equals("fill_crop")) {
                throw new RuntimeException("Unknown render mode '" + this.mRenderModeString + "'!");
            } else {
                this.mRenderMode = 2;
            }
        }
        updateTargetRect();
    }
}
