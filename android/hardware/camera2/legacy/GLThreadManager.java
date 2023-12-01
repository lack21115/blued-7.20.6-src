package android.hardware.camera2.legacy;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.legacy.RequestThreadManager;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import com.android.internal.util.Preconditions;
import java.util.Collection;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/GLThreadManager.class */
public class GLThreadManager {
    private static final boolean DEBUG = Log.isLoggable(LegacyCameraDevice.DEBUG_PROP, 3);
    private static final int MSG_ALLOW_FRAMES = 5;
    private static final int MSG_CLEANUP = 3;
    private static final int MSG_DROP_FRAMES = 4;
    private static final int MSG_NEW_CONFIGURATION = 1;
    private static final int MSG_NEW_FRAME = 2;
    private final String TAG;
    private CaptureCollector mCaptureCollector;
    private final CameraDeviceState mDeviceState;
    private final RequestHandlerThread mGLHandlerThread;
    private final SurfaceTextureRenderer mTextureRenderer;
    private final RequestThreadManager.FpsCounter mPrevCounter = new RequestThreadManager.FpsCounter("GL Preview Producer");
    private final Handler.Callback mGLHandlerCb = new Handler.Callback() { // from class: android.hardware.camera2.legacy.GLThreadManager.1
        private boolean mCleanup = false;
        private boolean mConfigured = false;
        private boolean mDroppingFrames = false;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (this.mCleanup) {
                return true;
            }
            try {
                switch (message.what) {
                    case -1:
                        return true;
                    case 0:
                    default:
                        Log.e(GLThreadManager.this.TAG, "Unhandled message " + message.what + " on GLThread.");
                        return true;
                    case 1:
                        ConfigureHolder configureHolder = (ConfigureHolder) message.obj;
                        GLThreadManager.this.mTextureRenderer.cleanupEGLContext();
                        GLThreadManager.this.mTextureRenderer.configureSurfaces(configureHolder.surfaces);
                        GLThreadManager.this.mCaptureCollector = (CaptureCollector) Preconditions.checkNotNull(configureHolder.collector);
                        configureHolder.condition.open();
                        this.mConfigured = true;
                        return true;
                    case 2:
                        if (this.mDroppingFrames) {
                            Log.w(GLThreadManager.this.TAG, "Ignoring frame.");
                            return true;
                        }
                        if (GLThreadManager.DEBUG) {
                            GLThreadManager.this.mPrevCounter.countAndLog();
                        }
                        if (!this.mConfigured) {
                            Log.e(GLThreadManager.this.TAG, "Dropping frame, EGL context not configured!");
                        }
                        GLThreadManager.this.mTextureRenderer.drawIntoSurfaces(GLThreadManager.this.mCaptureCollector);
                        return true;
                    case 3:
                        GLThreadManager.this.mTextureRenderer.cleanupEGLContext();
                        this.mCleanup = true;
                        this.mConfigured = false;
                        return true;
                    case 4:
                        this.mDroppingFrames = true;
                        return true;
                    case 5:
                        this.mDroppingFrames = false;
                        return true;
                }
            } catch (Exception e) {
                Log.e(GLThreadManager.this.TAG, "Received exception on GL render thread: ", e);
                GLThreadManager.this.mDeviceState.setError(1);
                return true;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/GLThreadManager$ConfigureHolder.class */
    public static class ConfigureHolder {
        public final CaptureCollector collector;
        public final ConditionVariable condition;
        public final Collection<Pair<Surface, Size>> surfaces;

        public ConfigureHolder(ConditionVariable conditionVariable, Collection<Pair<Surface, Size>> collection, CaptureCollector captureCollector) {
            this.condition = conditionVariable;
            this.surfaces = collection;
            this.collector = captureCollector;
        }
    }

    public GLThreadManager(int i, int i2, CameraDeviceState cameraDeviceState) {
        this.mTextureRenderer = new SurfaceTextureRenderer(i2);
        this.TAG = String.format("CameraDeviceGLThread-%d", Integer.valueOf(i));
        this.mGLHandlerThread = new RequestHandlerThread(this.TAG, this.mGLHandlerCb);
        this.mDeviceState = cameraDeviceState;
    }

    public void allowNewFrames() {
        this.mGLHandlerThread.getHandler().sendEmptyMessage(5);
    }

    public SurfaceTexture getCurrentSurfaceTexture() {
        return this.mTextureRenderer.getSurfaceTexture();
    }

    public void ignoreNewFrames() {
        this.mGLHandlerThread.getHandler().sendEmptyMessage(4);
    }

    public void queueNewFrame() {
        Handler handler = this.mGLHandlerThread.getHandler();
        if (handler.hasMessages(2)) {
            Log.e(this.TAG, "GLThread dropping frame.  Not consuming frames quickly enough!");
        } else {
            handler.sendMessage(handler.obtainMessage(2));
        }
    }

    public void quit() {
        Handler handler = this.mGLHandlerThread.getHandler();
        handler.sendMessageAtFrontOfQueue(handler.obtainMessage(3));
        this.mGLHandlerThread.quitSafely();
        try {
            this.mGLHandlerThread.join();
        } catch (InterruptedException e) {
            Log.e(this.TAG, String.format("Thread %s (%d) interrupted while quitting.", this.mGLHandlerThread.getName(), Long.valueOf(this.mGLHandlerThread.getId())));
        }
    }

    public void setConfigurationAndWait(Collection<Pair<Surface, Size>> collection, CaptureCollector captureCollector) {
        Preconditions.checkNotNull(captureCollector, "collector must not be null");
        Handler handler = this.mGLHandlerThread.getHandler();
        ConditionVariable conditionVariable = new ConditionVariable(false);
        handler.sendMessage(handler.obtainMessage(1, 0, 0, new ConfigureHolder(conditionVariable, collection, captureCollector)));
        conditionVariable.block();
    }

    public void start() {
        this.mGLHandlerThread.start();
    }

    public void waitUntilIdle() {
        this.mGLHandlerThread.waitUntilIdle();
    }

    public void waitUntilStarted() {
        this.mGLHandlerThread.waitUntilStarted();
    }
}
