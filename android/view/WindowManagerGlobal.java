package android.view;

import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.ArraySet;
import android.util.Log;
import android.view.IWindowManager;
import android.view.IWindowSessionCallback;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.android.internal.util.FastPrintWriter;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerGlobal.class */
public final class WindowManagerGlobal {
    public static final int ADD_APP_EXITING = -4;
    public static final int ADD_BAD_APP_TOKEN = -1;
    public static final int ADD_BAD_SUBWINDOW_TOKEN = -2;
    public static final int ADD_DUPLICATE_ADD = -5;
    public static final int ADD_FLAG_APP_VISIBLE = 2;
    public static final int ADD_FLAG_IN_TOUCH_MODE = 1;
    public static final int ADD_INVALID_DISPLAY = -9;
    public static final int ADD_INVALID_TYPE = -10;
    public static final int ADD_MULTIPLE_SINGLETON = -7;
    public static final int ADD_NOT_APP_TOKEN = -3;
    public static final int ADD_OKAY = 0;
    public static final int ADD_PERMISSION_DENIED = -8;
    public static final int ADD_STARTING_NOT_NEEDED = -6;
    public static final int RELAYOUT_DEFER_SURFACE_DESTROY = 2;
    public static final int RELAYOUT_INSETS_PENDING = 1;
    public static final int RELAYOUT_RES_ANIMATING = 8;
    public static final int RELAYOUT_RES_FIRST_TIME = 2;
    public static final int RELAYOUT_RES_IN_TOUCH_MODE = 1;
    public static final int RELAYOUT_RES_SURFACE_CHANGED = 4;
    private static final String TAG = "WindowManager";
    private static WindowManagerGlobal sDefaultWindowManager;
    private static IWindowManager sWindowManagerService;
    private static IWindowSession sWindowSession;
    private Runnable mSystemPropertyUpdater;
    private final Object mLock = new Object();
    private final ArrayList<View> mViews = new ArrayList<>();
    private final ArrayList<ViewRootImpl> mRoots = new ArrayList<>();
    private final ArrayList<WindowManager.LayoutParams> mParams = new ArrayList<>();
    private final ArraySet<View> mDyingViews = new ArraySet<>();

    private WindowManagerGlobal() {
    }

    private void doTrimForeground() {
        boolean z = false;
        synchronized (this.mLock) {
            int size = this.mRoots.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                ViewRootImpl viewRootImpl = this.mRoots.get(i);
                if (viewRootImpl.mView == null || viewRootImpl.getHostVisibility() != 0 || viewRootImpl.mAttachInfo.mHardwareRenderer == null) {
                    viewRootImpl.destroyHardwareResources();
                } else {
                    z = true;
                }
                size = i;
            }
        }
        if (z) {
            return;
        }
        HardwareRenderer.trimMemory(80);
    }

    private int findViewLocked(View view, boolean z) {
        int indexOf = this.mViews.indexOf(view);
        if (!z || indexOf >= 0) {
            return indexOf;
        }
        throw new IllegalArgumentException("View=" + view + " not attached to window manager");
    }

    public static WindowManagerGlobal getInstance() {
        WindowManagerGlobal windowManagerGlobal;
        synchronized (WindowManagerGlobal.class) {
            try {
                if (sDefaultWindowManager == null) {
                    sDefaultWindowManager = new WindowManagerGlobal();
                }
                windowManagerGlobal = sDefaultWindowManager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return windowManagerGlobal;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002f -> B:9:0x0025). Please submit an issue!!! */
    public static IWindowManager getWindowManagerService() {
        IWindowManager iWindowManager;
        synchronized (WindowManagerGlobal.class) {
            try {
                if (sWindowManagerService == null) {
                    sWindowManagerService = IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
                    try {
                        sWindowManagerService = getWindowManagerService();
                        ValueAnimator.setDurationScale(sWindowManagerService.getCurrentAnimatorScale());
                    } catch (RemoteException e) {
                        Log.e(TAG, "Failed to get WindowManagerService, cannot set animator scale", e);
                    }
                }
                iWindowManager = sWindowManagerService;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iWindowManager;
    }

    private static String getWindowName(ViewRootImpl viewRootImpl) {
        return ((Object) viewRootImpl.mWindowAttributes.getTitle()) + BridgeUtil.SPLIT_MARK + viewRootImpl.getClass().getName() + '@' + Integer.toHexString(viewRootImpl.hashCode());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0033 -> B:7:0x0029). Please submit an issue!!! */
    public static IWindowSession getWindowSession() {
        IWindowSession iWindowSession;
        synchronized (WindowManagerGlobal.class) {
            try {
                if (sWindowSession == null) {
                    try {
                        InputMethodManager inputMethodManager = InputMethodManager.getInstance();
                        sWindowSession = getWindowManagerService().openSession(new IWindowSessionCallback.Stub() { // from class: android.view.WindowManagerGlobal.1
                            @Override // android.view.IWindowSessionCallback
                            public void onAnimatorScaleChanged(float f) {
                                ValueAnimator.setDurationScale(f);
                            }
                        }, inputMethodManager.getClient(), inputMethodManager.getInputContext());
                    } catch (RemoteException e) {
                        Log.e(TAG, "Failed to open window session", e);
                    }
                }
                iWindowSession = sWindowSession;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iWindowSession;
    }

    public static void initialize() {
        getWindowManagerService();
    }

    public static IWindowSession peekWindowSession() {
        IWindowSession iWindowSession;
        synchronized (WindowManagerGlobal.class) {
            try {
                iWindowSession = sWindowSession;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iWindowSession;
    }

    private void removeViewLocked(int i, boolean z) {
        InputMethodManager inputMethodManager;
        ViewRootImpl viewRootImpl = this.mRoots.get(i);
        View view = viewRootImpl.getView();
        if (view != null && (inputMethodManager = InputMethodManager.getInstance()) != null) {
            inputMethodManager.windowDismissed(this.mViews.get(i).getWindowToken());
        }
        boolean die = viewRootImpl.die(z);
        if (view != null) {
            view.assignParent(null);
            if (die) {
                this.mDyingViews.add(view);
            }
        }
    }

    public static boolean shouldDestroyEglContext(int i) {
        if (i >= 80) {
            return true;
        }
        return i >= 60 && !ActivityManager.isHighEndGfx();
    }

    public static void trimForeground() {
        if (HardwareRenderer.sTrimForeground && HardwareRenderer.isAvailable()) {
            getInstance().doTrimForeground();
        }
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams, Display display, Window window) {
        View view2;
        ViewRootImpl viewRootImpl;
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        if (display == null) {
            throw new IllegalArgumentException("display must not be null");
        }
        if (!(layoutParams instanceof WindowManager.LayoutParams)) {
            throw new IllegalArgumentException("Params must be WindowManager.LayoutParams");
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
        if (window != null) {
            window.adjustLayoutParamsForSubWindow(layoutParams2);
        } else {
            Context context = view.getContext();
            if (context != null && context.getApplicationInfo().targetSdkVersion >= 21) {
                layoutParams2.flags |= 16777216;
            }
        }
        View view3 = null;
        synchronized (this.mLock) {
            if (this.mSystemPropertyUpdater == null) {
                this.mSystemPropertyUpdater = new Runnable() { // from class: android.view.WindowManagerGlobal.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (WindowManagerGlobal.this.mLock) {
                            int size = WindowManagerGlobal.this.mRoots.size();
                            while (true) {
                                int i = size - 1;
                                if (i >= 0) {
                                    ((ViewRootImpl) WindowManagerGlobal.this.mRoots.get(i)).loadSystemProperties();
                                    size = i;
                                }
                            }
                        }
                    }
                };
                SystemProperties.addChangeCallback(this.mSystemPropertyUpdater);
            }
            int findViewLocked = findViewLocked(view, false);
            if (findViewLocked >= 0) {
                if (!this.mDyingViews.contains(view)) {
                    throw new IllegalStateException("View " + view + " has already been added to the window manager.");
                }
                this.mRoots.get(findViewLocked).doDie();
            }
            view2 = null;
            if (layoutParams2.type >= 1000) {
                view2 = null;
                if (layoutParams2.type <= 1999) {
                    int size = this.mViews.size();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        view2 = view3;
                        if (i2 >= size) {
                            break;
                        }
                        if (this.mRoots.get(i2).mWindow.asBinder() == layoutParams2.token) {
                            view3 = this.mViews.get(i2);
                        }
                        i = i2 + 1;
                    }
                }
            }
            viewRootImpl = new ViewRootImpl(view.getContext(), display);
            view.setLayoutParams(layoutParams2);
            this.mViews.add(view);
            this.mRoots.add(viewRootImpl);
            this.mParams.add(layoutParams2);
        }
        try {
            viewRootImpl.setView(view, layoutParams2, view2);
        } catch (RuntimeException e) {
            synchronized (this.mLock) {
                int findViewLocked2 = findViewLocked(view, false);
                if (findViewLocked2 >= 0) {
                    removeViewLocked(findViewLocked2, true);
                }
                throw e;
            }
        }
    }

    public void changeCanvasOpacity(IBinder iBinder, boolean z) {
        if (iBinder == null) {
            return;
        }
        synchronized (this.mLock) {
            int size = this.mParams.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                if (this.mParams.get(i).token == iBinder) {
                    this.mRoots.get(i).changeCanvasOpacity(z);
                    return;
                }
                size = i;
            }
        }
    }

    public void closeAll(IBinder iBinder, String str, String str2) {
        synchronized (this.mLock) {
            int size = this.mViews.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    if (iBinder == null || this.mParams.get(i2).token == iBinder) {
                        ViewRootImpl viewRootImpl = this.mRoots.get(i2);
                        if (str != null) {
                            WindowLeaked windowLeaked = new WindowLeaked(str2 + " " + str + " has leaked window " + viewRootImpl.getView() + " that was originally added here");
                            windowLeaked.setStackTrace(viewRootImpl.getLocation().getStackTrace());
                            Log.e(TAG, "", windowLeaked);
                        }
                        removeViewLocked(i2, false);
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doRemoveView(ViewRootImpl viewRootImpl) {
        synchronized (this.mLock) {
            int indexOf = this.mRoots.indexOf(viewRootImpl);
            if (indexOf >= 0) {
                this.mRoots.remove(indexOf);
                this.mParams.remove(indexOf);
                this.mDyingViews.remove(this.mViews.remove(indexOf));
            }
        }
        if (HardwareRenderer.sTrimForeground && HardwareRenderer.isAvailable()) {
            doTrimForeground();
        }
    }

    public void dumpGfxInfo(FileDescriptor fileDescriptor) {
        FastPrintWriter fastPrintWriter = new FastPrintWriter(new FileOutputStream(fileDescriptor));
        try {
            synchronized (this.mLock) {
                int size = this.mViews.size();
                fastPrintWriter.println("Profile data in ms:");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    ViewRootImpl viewRootImpl = this.mRoots.get(i2);
                    fastPrintWriter.printf("\n\t%s (visibility=%d)", getWindowName(viewRootImpl), Integer.valueOf(viewRootImpl.getHostVisibility()));
                    HardwareRenderer hardwareRenderer = viewRootImpl.getView().mAttachInfo.mHardwareRenderer;
                    if (hardwareRenderer != null) {
                        hardwareRenderer.dumpGfxInfo(fastPrintWriter, fileDescriptor);
                    }
                    i = i2 + 1;
                }
                fastPrintWriter.println("\nView hierarchy:\n");
                int i3 = 0;
                int i4 = 0;
                int[] iArr = new int[2];
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 < size) {
                        ViewRootImpl viewRootImpl2 = this.mRoots.get(i6);
                        viewRootImpl2.dumpGfxInfo(iArr);
                        fastPrintWriter.printf("  %s\n  %d views, %.2f kB of display lists", getWindowName(viewRootImpl2), Integer.valueOf(iArr[0]), Float.valueOf(iArr[1] / 1024.0f));
                        fastPrintWriter.printf("\n\n", new Object[0]);
                        i3 += iArr[0];
                        i4 += iArr[1];
                        i5 = i6 + 1;
                    } else {
                        fastPrintWriter.printf("\nTotal ViewRootImpl: %d\n", Integer.valueOf(size));
                        fastPrintWriter.printf("Total Views:        %d\n", Integer.valueOf(i3));
                        fastPrintWriter.printf("Total DisplayList:  %.2f kB\n\n", Float.valueOf(i4 / 1024.0f));
                    }
                }
            }
        } finally {
            fastPrintWriter.flush();
        }
    }

    public View getRootView(String str) {
        synchronized (this.mLock) {
            int size = this.mRoots.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return null;
                }
                ViewRootImpl viewRootImpl = this.mRoots.get(i);
                if (str.equals(getWindowName(viewRootImpl))) {
                    return viewRootImpl.getView();
                }
                size = i;
            }
        }
    }

    public String[] getViewRootNames() {
        String[] strArr;
        synchronized (this.mLock) {
            int size = this.mRoots.size();
            strArr = new String[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    strArr[i2] = getWindowName(this.mRoots.get(i2));
                    i = i2 + 1;
                }
            }
        }
        return strArr;
    }

    public void removeView(View view, boolean z) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        synchronized (this.mLock) {
            int findViewLocked = findViewLocked(view, true);
            View view2 = this.mRoots.get(findViewLocked).getView();
            removeViewLocked(findViewLocked, z);
            if (view2 != view) {
                throw new IllegalStateException("Calling with view " + view + " but the ViewAncestor is attached to " + view2);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003b -> B:14:0x003c). Please submit an issue!!! */
    public void reportNewConfiguration(Configuration configuration) {
        int size;
        Configuration configuration2;
        int i;
        synchronized (this.mLock) {
            try {
                size = this.mViews.size();
                configuration2 = new Configuration(configuration);
                i = 0;
            } catch (Throwable th) {
                th = th;
            }
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                try {
                    this.mRoots.get(i2).requestUpdateConfiguration(configuration2);
                    i = i2 + 1;
                } catch (Throwable th2) {
                    th = th2;
                }
                th = th2;
                throw th;
            }
        }
    }

    public void setStoppedState(IBinder iBinder, boolean z) {
        synchronized (this.mLock) {
            int size = this.mViews.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    if (iBinder == null || this.mParams.get(i2).token == iBinder) {
                        this.mRoots.get(i2).setStopped(z);
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public void trimMemory(int i) {
        if (HardwareRenderer.isAvailable()) {
            int i2 = i;
            if (shouldDestroyEglContext(i)) {
                synchronized (this.mLock) {
                    int size = this.mRoots.size();
                    while (true) {
                        int i3 = size - 1;
                        if (i3 < 0) {
                            break;
                        }
                        this.mRoots.get(i3).destroyHardwareResources();
                        size = i3;
                    }
                }
                i2 = 80;
            }
            HardwareRenderer.trimMemory(i2);
            if (HardwareRenderer.sTrimForeground) {
                doTrimForeground();
            }
        }
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        if (!(layoutParams instanceof WindowManager.LayoutParams)) {
            throw new IllegalArgumentException("Params must be WindowManager.LayoutParams");
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
        view.setLayoutParams(layoutParams2);
        synchronized (this.mLock) {
            int findViewLocked = findViewLocked(view, true);
            ViewRootImpl viewRootImpl = this.mRoots.get(findViewLocked);
            this.mParams.remove(findViewLocked);
            this.mParams.add(findViewLocked, layoutParams2);
            viewRootImpl.setLayoutParams(layoutParams2, false);
        }
    }
}
