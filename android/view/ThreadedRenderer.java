package android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.Trace;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.HardwareRenderer;
import android.view.IAssetAtlas;
import android.view.Surface;
import android.view.View;
import com.android.internal.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: source-9557208-dex2jar.jar:android/view/ThreadedRenderer.class */
public class ThreadedRenderer extends HardwareRenderer {
    private static final String LOGTAG = "ThreadedRenderer";
    private static final int SYNC_INVALIDATE_REQUIRED = 1;
    private static final int SYNC_LOST_SURFACE_REWARD_IF_FOUND = 2;
    private static final int SYNC_OK = 0;
    private static final String[] VISUALIZERS = {HardwareRenderer.PROFILE_PROPERTY_VISUALIZE_BARS};
    private final int mAmbientShadowAlpha;
    private Choreographer mChoreographer;
    private boolean mHasInsets;
    private int mHeight;
    private boolean mInitialized = false;
    private int mInsetLeft;
    private int mInsetTop;
    private final float mLightRadius;
    private final float mLightY;
    private final float mLightZ;
    private long mNativeProxy;
    private boolean mProfilingEnabled;
    private RenderNode mRootNode;
    private boolean mRootNodeNeedsUpdate;
    private final int mSpotShadowAlpha;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mWidth;

    /* loaded from: source-9557208-dex2jar.jar:android/view/ThreadedRenderer$AtlasInitializer.class */
    private static class AtlasInitializer {
        static AtlasInitializer sInstance = new AtlasInitializer();
        private boolean mInitialized = false;

        private AtlasInitializer() {
        }

        private static void validateMap(Context context, long[] jArr) {
            Log.d("Atlas", "Validating map...");
            HashSet hashSet = new HashSet();
            LongSparseArray<Drawable.ConstantState> preloadedDrawables = context.getResources().getPreloadedDrawables();
            int size = preloadedDrawables.size();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                preloadedDrawables.valueAt(i2).addAtlasableBitmaps(arrayList);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < arrayList.size()) {
                        hashSet.add(Long.valueOf(((Bitmap) arrayList.get(i4)).mNativeBitmap));
                        i3 = i4 + 1;
                    }
                }
                arrayList.clear();
                i = i2 + 1;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= jArr.length) {
                    return;
                }
                if (!hashSet.contains(Long.valueOf(jArr[i6]))) {
                    Log.w("Atlas", String.format("Pointer 0x%X, not in getPreloadedDrawables?", Long.valueOf(jArr[i6])));
                    jArr[i6] = 0;
                }
                i5 = i6 + 4;
            }
        }

        void init(Context context, long j) {
            IBinder service;
            GraphicBuffer buffer;
            synchronized (this) {
                if (!this.mInitialized && (service = ServiceManager.getService("assetatlas")) != null) {
                    IAssetAtlas asInterface = IAssetAtlas.Stub.asInterface(service);
                    try {
                        if (asInterface.isCompatible(Process.myPpid()) && (buffer = asInterface.getBuffer()) != null) {
                            long[] map = asInterface.getMap();
                            if (map != null) {
                                validateMap(context, map);
                                ThreadedRenderer.nSetAtlas(j, buffer, map);
                                this.mInitialized = true;
                            }
                            if (asInterface.getClass() != service.getClass()) {
                                buffer.destroy();
                            }
                        }
                    } catch (RemoteException e) {
                        Log.w("HardwareRenderer", "Could not acquire atlas", e);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadedRenderer(Context context, boolean z) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.Lighting, 0, 0);
        this.mLightY = obtainStyledAttributes.getDimension(2, 0.0f);
        this.mLightZ = obtainStyledAttributes.getDimension(3, 0.0f);
        this.mLightRadius = obtainStyledAttributes.getDimension(4, 0.0f);
        this.mAmbientShadowAlpha = (int) ((obtainStyledAttributes.getFloat(0, 0.0f) * 255.0f) + 0.5f);
        this.mSpotShadowAlpha = (int) ((obtainStyledAttributes.getFloat(1, 0.0f) * 255.0f) + 0.5f);
        obtainStyledAttributes.recycle();
        long nCreateRootRenderNode = nCreateRootRenderNode();
        this.mRootNode = RenderNode.adopt(nCreateRootRenderNode);
        this.mRootNode.setClipToBounds(false);
        this.mNativeProxy = nCreateProxy(z, nCreateRootRenderNode);
        AtlasInitializer.sInstance.init(context, this.mNativeProxy);
        this.mChoreographer = Choreographer.getInstance();
        nSetFrameInterval(this.mNativeProxy, this.mChoreographer.getFrameIntervalNanos());
        loadSystemProperties();
    }

    private static boolean checkIfProfilingRequested() {
        String str = SystemProperties.get(HardwareRenderer.PROFILE_PROPERTY);
        return search(VISUALIZERS, str) >= 0 || Boolean.parseBoolean(str);
    }

    private static void destroyResources(View view) {
        view.destroyHardwareResources();
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            destroyResources(viewGroup.getChildAt(i2));
            i = i2 + 1;
        }
    }

    static void invokeFunctor(long j, boolean z) {
        nInvokeFunctor(j, z);
    }

    private static native void nBuildLayer(long j, long j2);

    private static native void nCancelLayerUpdate(long j, long j2);

    private static native boolean nCopyLayerInto(long j, long j2, long j3);

    private static native long nCreateProxy(boolean z, long j);

    private static native long nCreateRootRenderNode();

    private static native long nCreateTextureLayer(long j);

    private static native void nDeleteProxy(long j);

    private static native void nDestroy(long j);

    private static native void nDestroyHardwareResources(long j);

    private static native void nDetachSurfaceTexture(long j, long j2);

    private static native void nDumpProfileInfo(long j, FileDescriptor fileDescriptor);

    private static native void nFence(long j);

    private static native boolean nInitialize(long j, Surface surface);

    private static native void nInvokeFunctor(long j, boolean z);

    private static native boolean nLoadSystemProperties(long j);

    private static native void nNotifyFramePending(long j);

    private static native boolean nPauseSurface(long j, Surface surface);

    private static native void nPushLayerUpdate(long j, long j2);

    private static native void nRegisterAnimatingRenderNode(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nSetAtlas(long j, GraphicBuffer graphicBuffer, long[] jArr);

    private static native void nSetFrameInterval(long j, long j2);

    private static native void nSetOpaque(long j, boolean z);

    private static native void nSetup(long j, int i, int i2, float f, float f2, float f3, float f4, int i3, int i4);

    private static native void nStopDrawing(long j);

    private static native int nSyncAndDrawFrame(long j, long j2, long j3, float f);

    private static native void nTrimMemory(int i);

    private static native void nUpdateSurface(long j, Surface surface);

    private static int search(String[] strArr, String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return -1;
            }
            if (strArr[i2].equals(str)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setupShadersDiskCache(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void trimMemory(int i) {
        nTrimMemory(i);
    }

    private void updateEnabledState(Surface surface) {
        if (surface == null || !surface.isValid()) {
            setEnabled(false);
        } else {
            setEnabled(this.mInitialized);
        }
    }

    private void updateRootDisplayList(View view, HardwareRenderer.HardwareDrawCallbacks hardwareDrawCallbacks) {
        Trace.traceBegin(8L, "Record View#draw()");
        updateViewTreeDisplayList(view);
        if (this.mRootNodeNeedsUpdate || !this.mRootNode.isValid()) {
            HardwareCanvas start = this.mRootNode.start(this.mSurfaceWidth, this.mSurfaceHeight);
            try {
                int save = start.save();
                start.translate(this.mInsetLeft, this.mInsetTop);
                hardwareDrawCallbacks.onHardwarePreDraw(start);
                start.insertReorderBarrier();
                start.drawRenderNode(view.getDisplayList());
                start.insertInorderBarrier();
                hardwareDrawCallbacks.onHardwarePostDraw(start);
                start.restoreToCount(save);
                this.mRootNodeNeedsUpdate = false;
            } finally {
                this.mRootNode.end(start);
            }
        }
        Trace.traceEnd(8L);
    }

    private void updateViewTreeDisplayList(View view) {
        view.mPrivateFlags |= 32;
        view.mRecreateDisplayList = (view.mPrivateFlags & Integer.MIN_VALUE) == Integer.MIN_VALUE;
        view.mPrivateFlags &= Integer.MAX_VALUE;
        view.getDisplayList();
        view.mRecreateDisplayList = false;
    }

    @Override // android.view.HardwareRenderer
    void buildLayer(RenderNode renderNode) {
        nBuildLayer(this.mNativeProxy, renderNode.getNativeDisplayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.HardwareRenderer
    public boolean copyLayerInto(HardwareLayer hardwareLayer, Bitmap bitmap) {
        return nCopyLayerInto(this.mNativeProxy, hardwareLayer.getDeferredLayerUpdater(), bitmap.mNativeBitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.HardwareRenderer
    public HardwareLayer createTextureLayer() {
        return HardwareLayer.adoptTextureLayer(this, nCreateTextureLayer(this.mNativeProxy));
    }

    @Override // android.view.HardwareRenderer
    void destroy() {
        this.mInitialized = false;
        updateEnabledState(null);
        nDestroy(this.mNativeProxy);
    }

    @Override // android.view.HardwareRenderer
    void destroyHardwareResources(View view) {
        destroyResources(view);
        nDestroyHardwareResources(this.mNativeProxy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.HardwareRenderer
    public void detachSurfaceTexture(long j) {
        nDetachSurfaceTexture(this.mNativeProxy, j);
    }

    @Override // android.view.HardwareRenderer
    void draw(View view, View.AttachInfo attachInfo, HardwareRenderer.HardwareDrawCallbacks hardwareDrawCallbacks) {
        attachInfo.mIgnoreDirtyState = true;
        long frameTimeNanos = this.mChoreographer.getFrameTimeNanos();
        attachInfo.mDrawingTime = frameTimeNanos / 1000000;
        long j = 0;
        if (this.mProfilingEnabled) {
            j = System.nanoTime();
        }
        updateRootDisplayList(view, hardwareDrawCallbacks);
        long j2 = j;
        if (this.mProfilingEnabled) {
            j2 = System.nanoTime() - j;
        }
        attachInfo.mIgnoreDirtyState = false;
        if (attachInfo.mPendingAnimatingRenderNodes != null) {
            int size = attachInfo.mPendingAnimatingRenderNodes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                registerAnimatingRenderNode((RenderNode) attachInfo.mPendingAnimatingRenderNodes.get(i2));
                i = i2 + 1;
            }
            attachInfo.mPendingAnimatingRenderNodes.clear();
            attachInfo.mPendingAnimatingRenderNodes = null;
        }
        int nSyncAndDrawFrame = nSyncAndDrawFrame(this.mNativeProxy, frameTimeNanos, j2, view.getResources().getDisplayMetrics().density);
        if ((nSyncAndDrawFrame & 2) != 0) {
            setEnabled(false);
            attachInfo.mViewRootImpl.mSurface.release();
            attachInfo.mViewRootImpl.invalidate();
        }
        if ((nSyncAndDrawFrame & 1) != 0) {
            attachInfo.mViewRootImpl.invalidate();
        }
    }

    @Override // android.view.HardwareRenderer
    void dumpGfxInfo(PrintWriter printWriter, FileDescriptor fileDescriptor) {
        printWriter.flush();
        nDumpProfileInfo(this.mNativeProxy, fileDescriptor);
    }

    @Override // android.view.HardwareRenderer
    void fence() {
        nFence(this.mNativeProxy);
    }

    protected void finalize() throws Throwable {
        try {
            nDeleteProxy(this.mNativeProxy);
            this.mNativeProxy = 0L;
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.HardwareRenderer
    int getHeight() {
        return this.mHeight;
    }

    @Override // android.view.HardwareRenderer
    int getWidth() {
        return this.mWidth;
    }

    @Override // android.view.HardwareRenderer
    boolean initialize(Surface surface) throws Surface.OutOfResourcesException {
        this.mInitialized = true;
        updateEnabledState(surface);
        boolean nInitialize = nInitialize(this.mNativeProxy, surface);
        surface.allocateBuffers();
        return nInitialize;
    }

    @Override // android.view.HardwareRenderer
    void invalidate(Surface surface) {
        updateSurface(surface);
    }

    @Override // android.view.HardwareRenderer
    void invalidateRoot() {
        this.mRootNodeNeedsUpdate = true;
    }

    @Override // android.view.HardwareRenderer
    boolean loadSystemProperties() {
        boolean nLoadSystemProperties = nLoadSystemProperties(this.mNativeProxy);
        boolean checkIfProfilingRequested = checkIfProfilingRequested();
        if (checkIfProfilingRequested != this.mProfilingEnabled) {
            this.mProfilingEnabled = checkIfProfilingRequested;
            nLoadSystemProperties = true;
        }
        if (nLoadSystemProperties) {
            invalidateRoot();
        }
        return nLoadSystemProperties;
    }

    @Override // android.view.HardwareRenderer
    public void notifyFramePending() {
        nNotifyFramePending(this.mNativeProxy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.HardwareRenderer
    public void onLayerDestroyed(HardwareLayer hardwareLayer) {
        nCancelLayerUpdate(this.mNativeProxy, hardwareLayer.getDeferredLayerUpdater());
    }

    @Override // android.view.HardwareRenderer
    boolean pauseSurface(Surface surface) {
        return nPauseSurface(this.mNativeProxy, surface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.HardwareRenderer
    public void pushLayerUpdate(HardwareLayer hardwareLayer) {
        nPushLayerUpdate(this.mNativeProxy, hardwareLayer.getDeferredLayerUpdater());
    }

    @Override // android.view.HardwareRenderer
    void registerAnimatingRenderNode(RenderNode renderNode) {
        nRegisterAnimatingRenderNode(this.mRootNode.mNativeRenderNode, renderNode.mNativeRenderNode);
    }

    @Override // android.view.HardwareRenderer
    void setName(String str) {
    }

    @Override // android.view.HardwareRenderer
    void setOpaque(boolean z) {
        nSetOpaque(this.mNativeProxy, z && !this.mHasInsets);
    }

    @Override // android.view.HardwareRenderer
    void setup(int i, int i2, Rect rect) {
        float f = i / 2.0f;
        this.mWidth = i;
        this.mHeight = i2;
        if (rect == null || (rect.left == 0 && rect.right == 0 && rect.top == 0 && rect.bottom == 0)) {
            this.mHasInsets = false;
            this.mInsetLeft = 0;
            this.mInsetTop = 0;
            this.mSurfaceWidth = i;
            this.mSurfaceHeight = i2;
        } else {
            this.mHasInsets = true;
            this.mInsetLeft = rect.left;
            this.mInsetTop = rect.top;
            this.mSurfaceWidth = this.mInsetLeft + i + rect.right;
            this.mSurfaceHeight = this.mInsetTop + i2 + rect.bottom;
            setOpaque(false);
        }
        this.mRootNode.setLeftTopRightBottom(-this.mInsetLeft, -this.mInsetTop, this.mSurfaceWidth, this.mSurfaceHeight);
        nSetup(this.mNativeProxy, this.mSurfaceWidth, this.mSurfaceHeight, f, this.mLightY, this.mLightZ, this.mLightRadius, this.mAmbientShadowAlpha, this.mSpotShadowAlpha);
    }

    @Override // android.view.HardwareRenderer
    void stopDrawing() {
        nStopDrawing(this.mNativeProxy);
    }

    @Override // android.view.HardwareRenderer
    void updateSurface(Surface surface) throws Surface.OutOfResourcesException {
        updateEnabledState(surface);
        nUpdateSurface(this.mNativeProxy, surface);
    }
}
