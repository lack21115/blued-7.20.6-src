package android.view;

import android.content.Context;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.android.internal.view.BaseIWindow;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-9557208-dex2jar.jar:android/view/SurfaceView.class */
public class SurfaceView extends View {
    private static final boolean DEBUG = false;
    static final int GET_NEW_SURFACE_MSG = 2;
    static final int KEEP_SCREEN_ON_MSG = 1;
    private static final String TAG = "SurfaceView";
    static final int UPDATE_WINDOW_MSG = 3;
    final ArrayList<SurfaceHolder.Callback> mCallbacks;
    final Configuration mConfiguration;
    final Rect mContentInsets;
    private final ViewTreeObserver.OnPreDrawListener mDrawListener;
    boolean mDrawingStopped;
    int mFormat;
    private boolean mGlobalListenersAdded;
    final Handler mHandler;
    boolean mHaveFrame;
    int mHeight;
    boolean mIsCreating;
    long mLastLockTime;
    int mLastSurfaceHeight;
    int mLastSurfaceWidth;
    final WindowManager.LayoutParams mLayout;
    int mLeft;
    final int[] mLocation;
    final Surface mNewSurface;
    final Rect mOverscanInsets;
    boolean mReportDrawNeeded;
    int mRequestedFormat;
    int mRequestedHeight;
    boolean mRequestedVisible;
    int mRequestedWidth;
    final ViewTreeObserver.OnScrollChangedListener mScrollChangedListener;
    IWindowSession mSession;
    final Rect mStableInsets;
    final Surface mSurface;
    boolean mSurfaceCreated;
    final Rect mSurfaceFrame;
    private final SurfaceHolder mSurfaceHolder;
    final ReentrantLock mSurfaceLock;
    int mTop;
    private CompatibilityInfo.Translator mTranslator;
    boolean mUpdateWindowNeeded;
    boolean mViewVisibility;
    boolean mVisible;
    final Rect mVisibleInsets;
    int mWidth;
    final Rect mWinFrame;
    MyWindow mWindow;
    int mWindowType;
    boolean mWindowVisibility;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/SurfaceView$MyWindow.class */
    public static class MyWindow extends BaseIWindow {
        private final WeakReference<SurfaceView> mSurfaceView;
        int mCurWidth = -1;
        int mCurHeight = -1;

        public MyWindow(SurfaceView surfaceView) {
            this.mSurfaceView = new WeakReference<>(surfaceView);
        }

        public void dispatchAppVisibility(boolean z) {
        }

        public void dispatchGetNewSurface() {
            SurfaceView surfaceView = this.mSurfaceView.get();
            if (surfaceView != null) {
                surfaceView.mHandler.sendMessage(surfaceView.mHandler.obtainMessage(2));
            }
        }

        public void executeCommand(String str, String str2, ParcelFileDescriptor parcelFileDescriptor) {
        }

        public void resized(Rect rect, Rect rect2, Rect rect3, Rect rect4, Rect rect5, boolean z, Configuration configuration) {
            SurfaceView surfaceView = this.mSurfaceView.get();
            if (surfaceView != null) {
                surfaceView.mSurfaceLock.lock();
                try {
                    if (z) {
                        surfaceView.mUpdateWindowNeeded = true;
                        surfaceView.mReportDrawNeeded = true;
                        surfaceView.mHandler.sendEmptyMessage(3);
                    } else if (surfaceView.mWinFrame.width() != rect.width() || surfaceView.mWinFrame.height() != rect.height()) {
                        surfaceView.mUpdateWindowNeeded = true;
                        surfaceView.mHandler.sendEmptyMessage(3);
                    }
                } finally {
                    surfaceView.mSurfaceLock.unlock();
                }
            }
        }

        public void windowFocusChanged(boolean z, boolean z2) {
            Log.w(SurfaceView.TAG, "Unexpected focus in surface: focus=" + z + ", touchEnabled=" + z2);
        }
    }

    public SurfaceView(Context context) {
        super(context);
        this.mCallbacks = new ArrayList<>();
        this.mLocation = new int[2];
        this.mSurfaceLock = new ReentrantLock();
        this.mSurface = new Surface();
        this.mNewSurface = new Surface();
        this.mDrawingStopped = true;
        this.mLayout = new WindowManager.LayoutParams();
        this.mVisibleInsets = new Rect();
        this.mWinFrame = new Rect();
        this.mOverscanInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mStableInsets = new Rect();
        this.mConfiguration = new Configuration();
        this.mWindowType = 1001;
        this.mIsCreating = false;
        this.mHandler = new Handler() { // from class: android.view.SurfaceView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z = false;
                switch (message.what) {
                    case 1:
                        SurfaceView surfaceView = SurfaceView.this;
                        if (message.arg1 != 0) {
                            z = true;
                        }
                        surfaceView.setKeepScreenOn(z);
                        return;
                    case 2:
                        SurfaceView.this.handleGetNewSurface();
                        return;
                    case 3:
                        SurfaceView.this.updateWindow(false, false);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: android.view.SurfaceView.2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                SurfaceView.this.updateWindow(false, false);
            }
        };
        this.mRequestedVisible = false;
        this.mWindowVisibility = false;
        this.mViewVisibility = false;
        this.mRequestedWidth = -1;
        this.mRequestedHeight = -1;
        this.mRequestedFormat = 4;
        this.mHaveFrame = false;
        this.mSurfaceCreated = false;
        this.mLastLockTime = 0L;
        this.mVisible = false;
        this.mLeft = -1;
        this.mTop = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mFormat = -1;
        this.mSurfaceFrame = new Rect();
        this.mLastSurfaceWidth = -1;
        this.mLastSurfaceHeight = -1;
        this.mDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: android.view.SurfaceView.3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                SurfaceView.this.mHaveFrame = SurfaceView.this.getWidth() > 0 && SurfaceView.this.getHeight() > 0;
                SurfaceView.this.updateWindow(false, false);
                return true;
            }
        };
        this.mSurfaceHolder = new SurfaceHolder() { // from class: android.view.SurfaceView.4
            private static final String LOG_TAG = "SurfaceHolder";

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0096 -> B:16:0x007e). Please submit an issue!!! */
            private final Canvas internalLockCanvas(Rect rect) {
                SurfaceView.this.mSurfaceLock.lock();
                Canvas canvas = null;
                if (!SurfaceView.this.mDrawingStopped) {
                    canvas = null;
                    if (SurfaceView.this.mWindow != null) {
                        try {
                            canvas = SurfaceView.this.mSurface.lockCanvas(rect);
                        } catch (Exception e) {
                            Log.e(LOG_TAG, "Exception locking surface", e);
                            canvas = null;
                        }
                    }
                }
                if (canvas != null) {
                    SurfaceView.this.mLastLockTime = SystemClock.uptimeMillis();
                    return canvas;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                long j = SurfaceView.this.mLastLockTime + 100;
                long j2 = uptimeMillis;
                if (j > uptimeMillis) {
                    try {
                        Thread.sleep(j - uptimeMillis);
                    } catch (InterruptedException e2) {
                    }
                    j2 = SystemClock.uptimeMillis();
                }
                SurfaceView.this.mLastLockTime = j2;
                SurfaceView.this.mSurfaceLock.unlock();
                return null;
            }

            @Override // android.view.SurfaceHolder
            public void addCallback(SurfaceHolder.Callback callback) {
                synchronized (SurfaceView.this.mCallbacks) {
                    if (!SurfaceView.this.mCallbacks.contains(callback)) {
                        SurfaceView.this.mCallbacks.add(callback);
                    }
                }
            }

            @Override // android.view.SurfaceHolder
            public Surface getSurface() {
                return SurfaceView.this.mSurface;
            }

            @Override // android.view.SurfaceHolder
            public Rect getSurfaceFrame() {
                return SurfaceView.this.mSurfaceFrame;
            }

            @Override // android.view.SurfaceHolder
            public boolean isCreating() {
                return SurfaceView.this.mIsCreating;
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas() {
                return internalLockCanvas(null);
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas(Rect rect) {
                return internalLockCanvas(rect);
            }

            @Override // android.view.SurfaceHolder
            public void removeCallback(SurfaceHolder.Callback callback) {
                synchronized (SurfaceView.this.mCallbacks) {
                    SurfaceView.this.mCallbacks.remove(callback);
                }
            }

            @Override // android.view.SurfaceHolder
            public void setFixedSize(int i, int i2) {
                if (SurfaceView.this.mRequestedWidth == i && SurfaceView.this.mRequestedHeight == i2) {
                    return;
                }
                SurfaceView.this.mRequestedWidth = i;
                SurfaceView.this.mRequestedHeight = i2;
                SurfaceView.this.requestLayout();
            }

            @Override // android.view.SurfaceHolder
            public void setFormat(int i) {
                int i2 = i;
                if (i == -1) {
                    i2 = 4;
                }
                SurfaceView.this.mRequestedFormat = i2;
                if (SurfaceView.this.mWindow != null) {
                    SurfaceView.this.updateWindow(false, false);
                }
            }

            @Override // android.view.SurfaceHolder
            public void setKeepScreenOn(boolean z) {
                int i = 1;
                Message obtainMessage = SurfaceView.this.mHandler.obtainMessage(1);
                if (!z) {
                    i = 0;
                }
                obtainMessage.arg1 = i;
                SurfaceView.this.mHandler.sendMessage(obtainMessage);
            }

            @Override // android.view.SurfaceHolder
            public void setSizeFromLayout() {
                if (SurfaceView.this.mRequestedWidth == -1 && SurfaceView.this.mRequestedHeight == -1) {
                    return;
                }
                SurfaceView surfaceView = SurfaceView.this;
                SurfaceView.this.mRequestedHeight = -1;
                surfaceView.mRequestedWidth = -1;
                SurfaceView.this.requestLayout();
            }

            @Override // android.view.SurfaceHolder
            @Deprecated
            public void setType(int i) {
            }

            @Override // android.view.SurfaceHolder
            public void unlockCanvasAndPost(Canvas canvas) {
                SurfaceView.this.mSurface.unlockCanvasAndPost(canvas);
                SurfaceView.this.mSurfaceLock.unlock();
            }
        };
        init();
    }

    public SurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCallbacks = new ArrayList<>();
        this.mLocation = new int[2];
        this.mSurfaceLock = new ReentrantLock();
        this.mSurface = new Surface();
        this.mNewSurface = new Surface();
        this.mDrawingStopped = true;
        this.mLayout = new WindowManager.LayoutParams();
        this.mVisibleInsets = new Rect();
        this.mWinFrame = new Rect();
        this.mOverscanInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mStableInsets = new Rect();
        this.mConfiguration = new Configuration();
        this.mWindowType = 1001;
        this.mIsCreating = false;
        this.mHandler = new Handler() { // from class: android.view.SurfaceView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z = false;
                switch (message.what) {
                    case 1:
                        SurfaceView surfaceView = SurfaceView.this;
                        if (message.arg1 != 0) {
                            z = true;
                        }
                        surfaceView.setKeepScreenOn(z);
                        return;
                    case 2:
                        SurfaceView.this.handleGetNewSurface();
                        return;
                    case 3:
                        SurfaceView.this.updateWindow(false, false);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: android.view.SurfaceView.2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                SurfaceView.this.updateWindow(false, false);
            }
        };
        this.mRequestedVisible = false;
        this.mWindowVisibility = false;
        this.mViewVisibility = false;
        this.mRequestedWidth = -1;
        this.mRequestedHeight = -1;
        this.mRequestedFormat = 4;
        this.mHaveFrame = false;
        this.mSurfaceCreated = false;
        this.mLastLockTime = 0L;
        this.mVisible = false;
        this.mLeft = -1;
        this.mTop = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mFormat = -1;
        this.mSurfaceFrame = new Rect();
        this.mLastSurfaceWidth = -1;
        this.mLastSurfaceHeight = -1;
        this.mDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: android.view.SurfaceView.3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                SurfaceView.this.mHaveFrame = SurfaceView.this.getWidth() > 0 && SurfaceView.this.getHeight() > 0;
                SurfaceView.this.updateWindow(false, false);
                return true;
            }
        };
        this.mSurfaceHolder = new SurfaceHolder() { // from class: android.view.SurfaceView.4
            private static final String LOG_TAG = "SurfaceHolder";

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0096 -> B:16:0x007e). Please submit an issue!!! */
            private final Canvas internalLockCanvas(Rect rect) {
                SurfaceView.this.mSurfaceLock.lock();
                Canvas canvas = null;
                if (!SurfaceView.this.mDrawingStopped) {
                    canvas = null;
                    if (SurfaceView.this.mWindow != null) {
                        try {
                            canvas = SurfaceView.this.mSurface.lockCanvas(rect);
                        } catch (Exception e) {
                            Log.e(LOG_TAG, "Exception locking surface", e);
                            canvas = null;
                        }
                    }
                }
                if (canvas != null) {
                    SurfaceView.this.mLastLockTime = SystemClock.uptimeMillis();
                    return canvas;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                long j = SurfaceView.this.mLastLockTime + 100;
                long j2 = uptimeMillis;
                if (j > uptimeMillis) {
                    try {
                        Thread.sleep(j - uptimeMillis);
                    } catch (InterruptedException e2) {
                    }
                    j2 = SystemClock.uptimeMillis();
                }
                SurfaceView.this.mLastLockTime = j2;
                SurfaceView.this.mSurfaceLock.unlock();
                return null;
            }

            @Override // android.view.SurfaceHolder
            public void addCallback(SurfaceHolder.Callback callback) {
                synchronized (SurfaceView.this.mCallbacks) {
                    if (!SurfaceView.this.mCallbacks.contains(callback)) {
                        SurfaceView.this.mCallbacks.add(callback);
                    }
                }
            }

            @Override // android.view.SurfaceHolder
            public Surface getSurface() {
                return SurfaceView.this.mSurface;
            }

            @Override // android.view.SurfaceHolder
            public Rect getSurfaceFrame() {
                return SurfaceView.this.mSurfaceFrame;
            }

            @Override // android.view.SurfaceHolder
            public boolean isCreating() {
                return SurfaceView.this.mIsCreating;
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas() {
                return internalLockCanvas(null);
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas(Rect rect) {
                return internalLockCanvas(rect);
            }

            @Override // android.view.SurfaceHolder
            public void removeCallback(SurfaceHolder.Callback callback) {
                synchronized (SurfaceView.this.mCallbacks) {
                    SurfaceView.this.mCallbacks.remove(callback);
                }
            }

            @Override // android.view.SurfaceHolder
            public void setFixedSize(int i, int i2) {
                if (SurfaceView.this.mRequestedWidth == i && SurfaceView.this.mRequestedHeight == i2) {
                    return;
                }
                SurfaceView.this.mRequestedWidth = i;
                SurfaceView.this.mRequestedHeight = i2;
                SurfaceView.this.requestLayout();
            }

            @Override // android.view.SurfaceHolder
            public void setFormat(int i) {
                int i2 = i;
                if (i == -1) {
                    i2 = 4;
                }
                SurfaceView.this.mRequestedFormat = i2;
                if (SurfaceView.this.mWindow != null) {
                    SurfaceView.this.updateWindow(false, false);
                }
            }

            @Override // android.view.SurfaceHolder
            public void setKeepScreenOn(boolean z) {
                int i = 1;
                Message obtainMessage = SurfaceView.this.mHandler.obtainMessage(1);
                if (!z) {
                    i = 0;
                }
                obtainMessage.arg1 = i;
                SurfaceView.this.mHandler.sendMessage(obtainMessage);
            }

            @Override // android.view.SurfaceHolder
            public void setSizeFromLayout() {
                if (SurfaceView.this.mRequestedWidth == -1 && SurfaceView.this.mRequestedHeight == -1) {
                    return;
                }
                SurfaceView surfaceView = SurfaceView.this;
                SurfaceView.this.mRequestedHeight = -1;
                surfaceView.mRequestedWidth = -1;
                SurfaceView.this.requestLayout();
            }

            @Override // android.view.SurfaceHolder
            @Deprecated
            public void setType(int i) {
            }

            @Override // android.view.SurfaceHolder
            public void unlockCanvasAndPost(Canvas canvas) {
                SurfaceView.this.mSurface.unlockCanvasAndPost(canvas);
                SurfaceView.this.mSurfaceLock.unlock();
            }
        };
        init();
    }

    public SurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCallbacks = new ArrayList<>();
        this.mLocation = new int[2];
        this.mSurfaceLock = new ReentrantLock();
        this.mSurface = new Surface();
        this.mNewSurface = new Surface();
        this.mDrawingStopped = true;
        this.mLayout = new WindowManager.LayoutParams();
        this.mVisibleInsets = new Rect();
        this.mWinFrame = new Rect();
        this.mOverscanInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mStableInsets = new Rect();
        this.mConfiguration = new Configuration();
        this.mWindowType = 1001;
        this.mIsCreating = false;
        this.mHandler = new Handler() { // from class: android.view.SurfaceView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z = false;
                switch (message.what) {
                    case 1:
                        SurfaceView surfaceView = SurfaceView.this;
                        if (message.arg1 != 0) {
                            z = true;
                        }
                        surfaceView.setKeepScreenOn(z);
                        return;
                    case 2:
                        SurfaceView.this.handleGetNewSurface();
                        return;
                    case 3:
                        SurfaceView.this.updateWindow(false, false);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: android.view.SurfaceView.2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                SurfaceView.this.updateWindow(false, false);
            }
        };
        this.mRequestedVisible = false;
        this.mWindowVisibility = false;
        this.mViewVisibility = false;
        this.mRequestedWidth = -1;
        this.mRequestedHeight = -1;
        this.mRequestedFormat = 4;
        this.mHaveFrame = false;
        this.mSurfaceCreated = false;
        this.mLastLockTime = 0L;
        this.mVisible = false;
        this.mLeft = -1;
        this.mTop = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mFormat = -1;
        this.mSurfaceFrame = new Rect();
        this.mLastSurfaceWidth = -1;
        this.mLastSurfaceHeight = -1;
        this.mDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: android.view.SurfaceView.3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                SurfaceView.this.mHaveFrame = SurfaceView.this.getWidth() > 0 && SurfaceView.this.getHeight() > 0;
                SurfaceView.this.updateWindow(false, false);
                return true;
            }
        };
        this.mSurfaceHolder = new SurfaceHolder() { // from class: android.view.SurfaceView.4
            private static final String LOG_TAG = "SurfaceHolder";

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0096 -> B:16:0x007e). Please submit an issue!!! */
            private final Canvas internalLockCanvas(Rect rect) {
                SurfaceView.this.mSurfaceLock.lock();
                Canvas canvas = null;
                if (!SurfaceView.this.mDrawingStopped) {
                    canvas = null;
                    if (SurfaceView.this.mWindow != null) {
                        try {
                            canvas = SurfaceView.this.mSurface.lockCanvas(rect);
                        } catch (Exception e) {
                            Log.e(LOG_TAG, "Exception locking surface", e);
                            canvas = null;
                        }
                    }
                }
                if (canvas != null) {
                    SurfaceView.this.mLastLockTime = SystemClock.uptimeMillis();
                    return canvas;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                long j = SurfaceView.this.mLastLockTime + 100;
                long j2 = uptimeMillis;
                if (j > uptimeMillis) {
                    try {
                        Thread.sleep(j - uptimeMillis);
                    } catch (InterruptedException e2) {
                    }
                    j2 = SystemClock.uptimeMillis();
                }
                SurfaceView.this.mLastLockTime = j2;
                SurfaceView.this.mSurfaceLock.unlock();
                return null;
            }

            @Override // android.view.SurfaceHolder
            public void addCallback(SurfaceHolder.Callback callback) {
                synchronized (SurfaceView.this.mCallbacks) {
                    if (!SurfaceView.this.mCallbacks.contains(callback)) {
                        SurfaceView.this.mCallbacks.add(callback);
                    }
                }
            }

            @Override // android.view.SurfaceHolder
            public Surface getSurface() {
                return SurfaceView.this.mSurface;
            }

            @Override // android.view.SurfaceHolder
            public Rect getSurfaceFrame() {
                return SurfaceView.this.mSurfaceFrame;
            }

            @Override // android.view.SurfaceHolder
            public boolean isCreating() {
                return SurfaceView.this.mIsCreating;
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas() {
                return internalLockCanvas(null);
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas(Rect rect) {
                return internalLockCanvas(rect);
            }

            @Override // android.view.SurfaceHolder
            public void removeCallback(SurfaceHolder.Callback callback) {
                synchronized (SurfaceView.this.mCallbacks) {
                    SurfaceView.this.mCallbacks.remove(callback);
                }
            }

            @Override // android.view.SurfaceHolder
            public void setFixedSize(int i2, int i22) {
                if (SurfaceView.this.mRequestedWidth == i2 && SurfaceView.this.mRequestedHeight == i22) {
                    return;
                }
                SurfaceView.this.mRequestedWidth = i2;
                SurfaceView.this.mRequestedHeight = i22;
                SurfaceView.this.requestLayout();
            }

            @Override // android.view.SurfaceHolder
            public void setFormat(int i2) {
                int i22 = i2;
                if (i2 == -1) {
                    i22 = 4;
                }
                SurfaceView.this.mRequestedFormat = i22;
                if (SurfaceView.this.mWindow != null) {
                    SurfaceView.this.updateWindow(false, false);
                }
            }

            @Override // android.view.SurfaceHolder
            public void setKeepScreenOn(boolean z) {
                int i2 = 1;
                Message obtainMessage = SurfaceView.this.mHandler.obtainMessage(1);
                if (!z) {
                    i2 = 0;
                }
                obtainMessage.arg1 = i2;
                SurfaceView.this.mHandler.sendMessage(obtainMessage);
            }

            @Override // android.view.SurfaceHolder
            public void setSizeFromLayout() {
                if (SurfaceView.this.mRequestedWidth == -1 && SurfaceView.this.mRequestedHeight == -1) {
                    return;
                }
                SurfaceView surfaceView = SurfaceView.this;
                SurfaceView.this.mRequestedHeight = -1;
                surfaceView.mRequestedWidth = -1;
                SurfaceView.this.requestLayout();
            }

            @Override // android.view.SurfaceHolder
            @Deprecated
            public void setType(int i2) {
            }

            @Override // android.view.SurfaceHolder
            public void unlockCanvasAndPost(Canvas canvas) {
                SurfaceView.this.mSurface.unlockCanvasAndPost(canvas);
                SurfaceView.this.mSurfaceLock.unlock();
            }
        };
        init();
    }

    public SurfaceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mCallbacks = new ArrayList<>();
        this.mLocation = new int[2];
        this.mSurfaceLock = new ReentrantLock();
        this.mSurface = new Surface();
        this.mNewSurface = new Surface();
        this.mDrawingStopped = true;
        this.mLayout = new WindowManager.LayoutParams();
        this.mVisibleInsets = new Rect();
        this.mWinFrame = new Rect();
        this.mOverscanInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mStableInsets = new Rect();
        this.mConfiguration = new Configuration();
        this.mWindowType = 1001;
        this.mIsCreating = false;
        this.mHandler = new Handler() { // from class: android.view.SurfaceView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z = false;
                switch (message.what) {
                    case 1:
                        SurfaceView surfaceView = SurfaceView.this;
                        if (message.arg1 != 0) {
                            z = true;
                        }
                        surfaceView.setKeepScreenOn(z);
                        return;
                    case 2:
                        SurfaceView.this.handleGetNewSurface();
                        return;
                    case 3:
                        SurfaceView.this.updateWindow(false, false);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: android.view.SurfaceView.2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                SurfaceView.this.updateWindow(false, false);
            }
        };
        this.mRequestedVisible = false;
        this.mWindowVisibility = false;
        this.mViewVisibility = false;
        this.mRequestedWidth = -1;
        this.mRequestedHeight = -1;
        this.mRequestedFormat = 4;
        this.mHaveFrame = false;
        this.mSurfaceCreated = false;
        this.mLastLockTime = 0L;
        this.mVisible = false;
        this.mLeft = -1;
        this.mTop = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mFormat = -1;
        this.mSurfaceFrame = new Rect();
        this.mLastSurfaceWidth = -1;
        this.mLastSurfaceHeight = -1;
        this.mDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: android.view.SurfaceView.3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                SurfaceView.this.mHaveFrame = SurfaceView.this.getWidth() > 0 && SurfaceView.this.getHeight() > 0;
                SurfaceView.this.updateWindow(false, false);
                return true;
            }
        };
        this.mSurfaceHolder = new SurfaceHolder() { // from class: android.view.SurfaceView.4
            private static final String LOG_TAG = "SurfaceHolder";

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0096 -> B:16:0x007e). Please submit an issue!!! */
            private final Canvas internalLockCanvas(Rect rect) {
                SurfaceView.this.mSurfaceLock.lock();
                Canvas canvas = null;
                if (!SurfaceView.this.mDrawingStopped) {
                    canvas = null;
                    if (SurfaceView.this.mWindow != null) {
                        try {
                            canvas = SurfaceView.this.mSurface.lockCanvas(rect);
                        } catch (Exception e) {
                            Log.e(LOG_TAG, "Exception locking surface", e);
                            canvas = null;
                        }
                    }
                }
                if (canvas != null) {
                    SurfaceView.this.mLastLockTime = SystemClock.uptimeMillis();
                    return canvas;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                long j = SurfaceView.this.mLastLockTime + 100;
                long j2 = uptimeMillis;
                if (j > uptimeMillis) {
                    try {
                        Thread.sleep(j - uptimeMillis);
                    } catch (InterruptedException e2) {
                    }
                    j2 = SystemClock.uptimeMillis();
                }
                SurfaceView.this.mLastLockTime = j2;
                SurfaceView.this.mSurfaceLock.unlock();
                return null;
            }

            @Override // android.view.SurfaceHolder
            public void addCallback(SurfaceHolder.Callback callback) {
                synchronized (SurfaceView.this.mCallbacks) {
                    if (!SurfaceView.this.mCallbacks.contains(callback)) {
                        SurfaceView.this.mCallbacks.add(callback);
                    }
                }
            }

            @Override // android.view.SurfaceHolder
            public Surface getSurface() {
                return SurfaceView.this.mSurface;
            }

            @Override // android.view.SurfaceHolder
            public Rect getSurfaceFrame() {
                return SurfaceView.this.mSurfaceFrame;
            }

            @Override // android.view.SurfaceHolder
            public boolean isCreating() {
                return SurfaceView.this.mIsCreating;
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas() {
                return internalLockCanvas(null);
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas(Rect rect) {
                return internalLockCanvas(rect);
            }

            @Override // android.view.SurfaceHolder
            public void removeCallback(SurfaceHolder.Callback callback) {
                synchronized (SurfaceView.this.mCallbacks) {
                    SurfaceView.this.mCallbacks.remove(callback);
                }
            }

            @Override // android.view.SurfaceHolder
            public void setFixedSize(int i22, int i222) {
                if (SurfaceView.this.mRequestedWidth == i22 && SurfaceView.this.mRequestedHeight == i222) {
                    return;
                }
                SurfaceView.this.mRequestedWidth = i22;
                SurfaceView.this.mRequestedHeight = i222;
                SurfaceView.this.requestLayout();
            }

            @Override // android.view.SurfaceHolder
            public void setFormat(int i22) {
                int i222 = i22;
                if (i22 == -1) {
                    i222 = 4;
                }
                SurfaceView.this.mRequestedFormat = i222;
                if (SurfaceView.this.mWindow != null) {
                    SurfaceView.this.updateWindow(false, false);
                }
            }

            @Override // android.view.SurfaceHolder
            public void setKeepScreenOn(boolean z) {
                int i22 = 1;
                Message obtainMessage = SurfaceView.this.mHandler.obtainMessage(1);
                if (!z) {
                    i22 = 0;
                }
                obtainMessage.arg1 = i22;
                SurfaceView.this.mHandler.sendMessage(obtainMessage);
            }

            @Override // android.view.SurfaceHolder
            public void setSizeFromLayout() {
                if (SurfaceView.this.mRequestedWidth == -1 && SurfaceView.this.mRequestedHeight == -1) {
                    return;
                }
                SurfaceView surfaceView = SurfaceView.this;
                SurfaceView.this.mRequestedHeight = -1;
                surfaceView.mRequestedWidth = -1;
                SurfaceView.this.requestLayout();
            }

            @Override // android.view.SurfaceHolder
            @Deprecated
            public void setType(int i22) {
            }

            @Override // android.view.SurfaceHolder
            public void unlockCanvasAndPost(Canvas canvas) {
                SurfaceView.this.mSurface.unlockCanvasAndPost(canvas);
                SurfaceView.this.mSurfaceLock.unlock();
            }
        };
        init();
    }

    private SurfaceHolder.Callback[] getSurfaceCallbacks() {
        SurfaceHolder.Callback[] callbackArr;
        synchronized (this.mCallbacks) {
            callbackArr = new SurfaceHolder.Callback[this.mCallbacks.size()];
            this.mCallbacks.toArray(callbackArr);
        }
        return callbackArr;
    }

    private void init() {
        setWillNotDraw(true);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWindowType != 1000 && (this.mPrivateFlags & 128) == 128) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mWindowType != 1000 && (this.mPrivateFlags & 128) == 0) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    public boolean gatherTransparentRegion(Region region) {
        boolean z;
        if (this.mWindowType == 1000) {
            z = super.gatherTransparentRegion(region);
        } else {
            if ((this.mPrivateFlags & 128) == 0) {
                z = super.gatherTransparentRegion(region);
            } else {
                z = true;
                if (region != null) {
                    int width = getWidth();
                    int height = getHeight();
                    z = true;
                    if (width > 0) {
                        z = true;
                        if (height > 0) {
                            getLocationInWindow(this.mLocation);
                            int i = this.mLocation[0];
                            int i2 = this.mLocation[1];
                            region.op(i, i2, i + width, i2 + height, Region.Op.UNION);
                            z = true;
                        }
                    }
                }
            }
            if (PixelFormat.formatHasAlpha(this.mRequestedFormat)) {
                return false;
            }
        }
        return z;
    }

    public SurfaceHolder getHolder() {
        return this.mSurfaceHolder;
    }

    void handleGetNewSurface() {
        updateWindow(false, false);
    }

    public boolean isFixedSize() {
        return (this.mRequestedWidth == -1 && this.mRequestedHeight == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mParent.requestTransparentRegion(this);
        this.mSession = getWindowSession();
        this.mLayout.token = getWindowToken();
        this.mLayout.setTitle(TAG);
        this.mViewVisibility = getVisibility() == 0;
        if (this.mGlobalListenersAdded) {
            return;
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnScrollChangedListener(this.mScrollChangedListener);
        viewTreeObserver.addOnPreDrawListener(this.mDrawListener);
        this.mGlobalListenersAdded = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        if (this.mGlobalListenersAdded) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            viewTreeObserver.removeOnScrollChangedListener(this.mScrollChangedListener);
            viewTreeObserver.removeOnPreDrawListener(this.mDrawListener);
            this.mGlobalListenersAdded = false;
        }
        this.mRequestedVisible = false;
        updateWindow(false, false);
        this.mHaveFrame = false;
        if (this.mWindow != null) {
            try {
                this.mSession.remove(this.mWindow);
            } catch (RemoteException e) {
            }
            this.mWindow = null;
        }
        this.mSession = null;
        this.mLayout.token = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mRequestedWidth >= 0 ? resolveSizeAndState(this.mRequestedWidth, i, 0) : getDefaultSize(0, i), this.mRequestedHeight >= 0 ? resolveSizeAndState(this.mRequestedHeight, i2, 0) : getDefaultSize(0, i2));
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.mWindowVisibility = i == 0;
        this.mRequestedVisible = this.mWindowVisibility && this.mViewVisibility;
        updateWindow(false, false);
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        updateWindow(false, false);
        return frame;
    }

    public void setSecure(boolean z) {
        if (z) {
            this.mLayout.flags |= 8192;
            return;
        }
        this.mLayout.flags &= -8193;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.mViewVisibility = i == 0;
        boolean z = this.mWindowVisibility && this.mViewVisibility;
        if (z != this.mRequestedVisible) {
            requestLayout();
        }
        this.mRequestedVisible = z;
        updateWindow(false, false);
    }

    public void setWindowType(int i) {
        this.mWindowType = i;
    }

    public void setZOrderMediaOverlay(boolean z) {
        this.mWindowType = z ? 1004 : 1001;
    }

    public void setZOrderOnTop(boolean z) {
        if (z) {
            this.mWindowType = 1000;
            this.mLayout.flags |= 131072;
            return;
        }
        this.mWindowType = 1001;
        this.mLayout.flags &= -131073;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0349, code lost:
        if (r25 != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x043c, code lost:
        if (r25 != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x057a, code lost:
        if (r26 == false) goto L153;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x048b A[Catch: all -> 0x0531, TRY_ENTER, TryCatch #2 {RemoteException -> 0x03fd, blocks: (B:51:0x00df, B:53:0x0146, B:55:0x0152, B:57:0x0180, B:59:0x0195, B:61:0x01ae, B:65:0x01fa, B:67:0x0218, B:91:0x030e, B:178:0x050c, B:180:0x0516, B:182:0x0524, B:96:0x032e, B:104:0x034c, B:106:0x0355, B:108:0x035f, B:112:0x0378, B:129:0x040c, B:131:0x041c, B:135:0x042a, B:141:0x043f, B:144:0x0452, B:146:0x045a, B:150:0x046b, B:154:0x048b, B:156:0x0493, B:160:0x04a4, B:166:0x04d1, B:168:0x04d9, B:173:0x04ed, B:175:0x04f5, B:69:0x021f, B:72:0x0235, B:75:0x0269, B:78:0x02a2, B:80:0x02a8, B:82:0x02be, B:84:0x02db, B:86:0x02f5, B:89:0x0301, B:121:0x03ba), top: B:204:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04a4 A[Catch: all -> 0x0531, TRY_ENTER, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x03fd, blocks: (B:51:0x00df, B:53:0x0146, B:55:0x0152, B:57:0x0180, B:59:0x0195, B:61:0x01ae, B:65:0x01fa, B:67:0x0218, B:91:0x030e, B:178:0x050c, B:180:0x0516, B:182:0x0524, B:96:0x032e, B:104:0x034c, B:106:0x0355, B:108:0x035f, B:112:0x0378, B:129:0x040c, B:131:0x041c, B:135:0x042a, B:141:0x043f, B:144:0x0452, B:146:0x045a, B:150:0x046b, B:154:0x048b, B:156:0x0493, B:160:0x04a4, B:166:0x04d1, B:168:0x04d9, B:173:0x04ed, B:175:0x04f5, B:69:0x021f, B:72:0x0235, B:75:0x0269, B:78:0x02a2, B:80:0x02a8, B:82:0x02be, B:84:0x02db, B:86:0x02f5, B:89:0x0301, B:121:0x03ba), top: B:204:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0516 A[Catch: RemoteException -> 0x03fd, TRY_ENTER, TryCatch #2 {RemoteException -> 0x03fd, blocks: (B:51:0x00df, B:53:0x0146, B:55:0x0152, B:57:0x0180, B:59:0x0195, B:61:0x01ae, B:65:0x01fa, B:67:0x0218, B:91:0x030e, B:178:0x050c, B:180:0x0516, B:182:0x0524, B:96:0x032e, B:104:0x034c, B:106:0x0355, B:108:0x035f, B:112:0x0378, B:129:0x040c, B:131:0x041c, B:135:0x042a, B:141:0x043f, B:144:0x0452, B:146:0x045a, B:150:0x046b, B:154:0x048b, B:156:0x0493, B:160:0x04a4, B:166:0x04d1, B:168:0x04d9, B:173:0x04ed, B:175:0x04f5, B:69:0x021f, B:72:0x0235, B:75:0x0269, B:78:0x02a2, B:80:0x02a8, B:82:0x02be, B:84:0x02db, B:86:0x02f5, B:89:0x0301, B:121:0x03ba), top: B:204:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04c3 A[EDGE_INSN: B:208:0x04c3->B:162:0x04c3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0335  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateWindow(boolean r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 1408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.SurfaceView.updateWindow(boolean, boolean):void");
    }
}
