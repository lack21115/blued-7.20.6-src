package android.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.Surface;
import android.view.View;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/view/HardwareRenderer.class */
public abstract class HardwareRenderer {
    private static final String CACHE_PATH_SHADERS = "com.android.opengl.shaders_cache";
    public static final String DEBUG_DIRTY_REGIONS_PROPERTY = "debug.hwui.show_dirty_regions";
    public static final String DEBUG_OVERDRAW_PROPERTY = "debug.hwui.overdraw";
    public static final String DEBUG_SHOW_LAYERS_UPDATES_PROPERTY = "debug.hwui.show_layers_updates";
    public static final String DEBUG_SHOW_NON_RECTANGULAR_CLIP_PROPERTY = "debug.hwui.show_non_rect_clip";
    static final String LOG_TAG = "HardwareRenderer";
    public static final String OVERDRAW_PROPERTY_SHOW = "show";
    static final String PRINT_CONFIG_PROPERTY = "debug.hwui.print_config";
    static final String PROFILE_MAXFRAMES_PROPERTY = "debug.hwui.profile.maxframes";
    public static final String PROFILE_PROPERTY = "debug.hwui.profile";
    public static final String PROFILE_PROPERTY_VISUALIZE_BARS = "visual_bars";
    static final String RENDER_DIRTY_REGIONS_PROPERTY = "debug.hwui.render_dirty_regions";
    public static boolean sRendererDisabled = false;
    public static boolean sSystemRendererDisabled = false;
    public static boolean sTrimForeground = false;
    private boolean mEnabled;
    private boolean mRequested = true;

    /* loaded from: source-9557208-dex2jar.jar:android/view/HardwareRenderer$HardwareDrawCallbacks.class */
    interface HardwareDrawCallbacks {
        void onHardwarePostDraw(HardwareCanvas hardwareCanvas);

        void onHardwarePreDraw(HardwareCanvas hardwareCanvas);
    }

    static HardwareRenderer create(Context context, boolean z) {
        ThreadedRenderer threadedRenderer = null;
        if (GLES20Canvas.isAvailable()) {
            threadedRenderer = new ThreadedRenderer(context, z);
        }
        return threadedRenderer;
    }

    public static void disable(boolean z) {
        sRendererDisabled = true;
        if (z) {
            sSystemRendererDisabled = true;
        }
    }

    public static void enableForegroundTrimming() {
        sTrimForeground = true;
    }

    public static boolean isAvailable() {
        return GLES20Canvas.isAvailable();
    }

    public static void setupDiskCache(File file) {
        ThreadedRenderer.setupShadersDiskCache(new File(file, CACHE_PATH_SHADERS).getAbsolutePath());
    }

    static void trimMemory(int i) {
        ThreadedRenderer.trimMemory(i);
    }

    abstract void buildLayer(RenderNode renderNode);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean copyLayerInto(HardwareLayer hardwareLayer, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract HardwareLayer createTextureLayer();

    abstract void destroy();

    abstract void destroyHardwareResources(View view);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void detachSurfaceTexture(long j);

    abstract void draw(View view, View.AttachInfo attachInfo, HardwareDrawCallbacks hardwareDrawCallbacks);

    abstract void dumpGfxInfo(PrintWriter printWriter, FileDescriptor fileDescriptor);

    abstract void fence();

    abstract int getHeight();

    abstract int getWidth();

    abstract boolean initialize(Surface surface) throws Surface.OutOfResourcesException;

    boolean initializeIfNeeded(int i, int i2, Surface surface, Rect rect) throws Surface.OutOfResourcesException {
        if (isRequested() && !isEnabled() && initialize(surface)) {
            setup(i, i2, rect);
            return true;
        }
        return false;
    }

    abstract void invalidate(Surface surface);

    abstract void invalidateRoot();

    boolean isEnabled() {
        return this.mEnabled;
    }

    boolean isRequested() {
        return this.mRequested;
    }

    abstract boolean loadSystemProperties();

    abstract void notifyFramePending();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onLayerDestroyed(HardwareLayer hardwareLayer);

    abstract boolean pauseSurface(Surface surface);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void pushLayerUpdate(HardwareLayer hardwareLayer);

    abstract void registerAnimatingRenderNode(RenderNode renderNode);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    abstract void setName(String str);

    abstract void setOpaque(boolean z);

    void setRequested(boolean z) {
        this.mRequested = z;
    }

    abstract void setup(int i, int i2, Rect rect);

    abstract void stopDrawing();

    abstract void updateSurface(Surface surface) throws Surface.OutOfResourcesException;
}
