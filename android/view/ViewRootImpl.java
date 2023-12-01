package android.view;

import android.animation.LayoutTransition;
import android.app.ActivityManagerNative;
import android.content.ClipDescription;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.Slog;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Choreographer;
import android.view.HardwareRenderer;
import android.view.IWindow;
import android.view.InputDevice;
import android.view.InputQueue;
import android.view.KeyCharacterMap;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.IAccessibilityInteractionConnection;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import com.alipay.sdk.util.i;
import com.android.internal.R;
import com.android.internal.os.SomeArgs;
import com.android.internal.policy.PolicyManager;
import com.android.internal.view.BaseSurfaceHolder;
import com.android.internal.view.RootViewSurfaceTaker;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl.class */
public final class ViewRootImpl implements ViewParent, View.AttachInfo.Callbacks, HardwareRenderer.HardwareDrawCallbacks {
    private static final boolean DBG = false;
    private static final boolean DEBUG_CONFIGURATION = false;
    private static final boolean DEBUG_DIALOG = false;
    private static final boolean DEBUG_DRAW = false;
    private static final boolean DEBUG_FPS = false;
    private static final boolean DEBUG_IMF = false;
    private static final boolean DEBUG_INPUT_RESIZE = false;
    private static final boolean DEBUG_INPUT_STAGES = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final boolean DEBUG_ORIENTATION = false;
    private static final boolean DEBUG_TRACKBALL = false;
    private static final boolean LOCAL_LOGV = false;
    private static final int MAX_QUEUED_INPUT_EVENT_POOL_SIZE = 10;
    static final int MAX_TRACKBALL_DELAY = 250;
    private static final int MSG_CHECK_FOCUS = 13;
    private static final int MSG_CLEAR_ACCESSIBILITY_FOCUS_HOST = 21;
    private static final int MSG_CLOSE_SYSTEM_DIALOGS = 14;
    private static final int MSG_DIE = 3;
    private static final int MSG_DISPATCH_APP_VISIBILITY = 8;
    private static final int MSG_DISPATCH_DONE_ANIMATING = 22;
    private static final int MSG_DISPATCH_DRAG_EVENT = 15;
    private static final int MSG_DISPATCH_DRAG_LOCATION_EVENT = 16;
    private static final int MSG_DISPATCH_GET_NEW_SURFACE = 9;
    private static final int MSG_DISPATCH_INPUT_EVENT = 7;
    private static final int MSG_DISPATCH_KEY_FROM_IME = 11;
    private static final int MSG_DISPATCH_SYSTEM_UI_VISIBILITY = 17;
    private static final int MSG_DISPATCH_WINDOW_SHOWN = 26;
    private static final int MSG_FINISH_INPUT_CONNECTION = 12;
    private static final int MSG_INVALIDATE = 1;
    private static final int MSG_INVALIDATE_RECT = 2;
    private static final int MSG_INVALIDATE_WORLD = 23;
    private static final int MSG_PROCESS_INPUT_EVENTS = 19;
    private static final int MSG_RESIZED = 4;
    private static final int MSG_RESIZED_REPORT = 5;
    private static final int MSG_SYNTHESIZE_INPUT_EVENT = 25;
    private static final int MSG_UPDATE_CONFIGURATION = 18;
    private static final int MSG_WINDOW_FOCUS_CHANGED = 6;
    private static final int MSG_WINDOW_MOVED = 24;
    public static final String PROPERTY_EMULATOR_CIRCULAR = "ro.emulator.circular";
    private static final String PROPERTY_MEDIA_DISABLED = "config.disable_media";
    private static final String PROPERTY_PROFILE_RENDERING = "viewroot.profile_rendering";
    private static final String TAG = "ViewRootImpl";
    View mAccessibilityFocusedHost;
    AccessibilityNodeInfo mAccessibilityFocusedVirtualView;
    AccessibilityInteractionConnectionManager mAccessibilityInteractionConnectionManager;
    AccessibilityInteractionController mAccessibilityInteractionController;
    final AccessibilityManager mAccessibilityManager;
    boolean mAdded;
    boolean mAddedTouchMode;
    boolean mApplyInsetsRequested;
    final View.AttachInfo mAttachInfo;
    AudioManager mAudioManager;
    final String mBasePackageName;
    boolean mBlockResizeBuffer;
    Choreographer mChoreographer;
    int mClientWindowLayoutFlags;
    final ConsumeBatchedInputImmediatelyRunnable mConsumeBatchedInputImmediatelyRunnable;
    boolean mConsumeBatchedInputImmediatelyScheduled;
    boolean mConsumeBatchedInputScheduled;
    final ConsumeBatchedInputRunnable mConsumedBatchedInputRunnable;
    final Context mContext;
    int mCurScrollY;
    View mCurrentDragView;
    private final int mDensity;
    Rect mDirty;
    final Display mDisplay;
    final DisplayAdjustments mDisplayAdjustments;
    private final DisplayManager.DisplayListener mDisplayListener;
    final DisplayManager mDisplayManager;
    ClipDescription mDragDescription;
    boolean mDrawDuringWindowsAnimating;
    boolean mDrawingAllowed;
    FallbackEventHandler mFallbackEventHandler;
    boolean mFirst;
    InputStage mFirstInputStage;
    InputStage mFirstPostImeInputStage;
    private int mFpsNumFrames;
    boolean mFullRedrawNeeded;
    final ViewRootHandler mHandler;
    int mHardwareXOffset;
    int mHardwareYOffset;
    boolean mHasHadWindowFocus;
    int mHeight;
    HighContrastTextManager mHighContrastTextManager;
    InputChannel mInputChannel;
    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier;
    WindowInputEventReceiver mInputEventReceiver;
    InputQueue mInputQueue;
    InputQueue.Callback mInputQueueCallback;
    final InvalidateOnAnimationRunnable mInvalidateOnAnimationRunnable;
    boolean mIsAnimating;
    private boolean mIsCircularEmulator;
    boolean mIsCreating;
    boolean mIsDrawing;
    private boolean mIsEmulator;
    boolean mIsInTraversal;
    boolean mLastOverscanRequested;
    WeakReference<View> mLastScrolledFocus;
    int mLastSystemUiVisibility;
    boolean mLastWasImTarget;
    boolean mLayoutRequested;
    volatile Object mLocalDragState;
    final WindowLeaked mLocation;
    private boolean mMediaDisabled;
    boolean mNewSurfaceNeeded;
    private final int mNoncompatDensity;
    int mPendingInputEventCount;
    QueuedInputEvent mPendingInputEventHead;
    QueuedInputEvent mPendingInputEventTail;
    private ArrayList<LayoutTransition> mPendingTransitions;
    final Region mPreviousTransparentRegion;
    boolean mProcessInputEventsScheduled;
    private boolean mProfile;
    private boolean mProfileRendering;
    private QueuedInputEvent mQueuedInputEventPool;
    private int mQueuedInputEventPoolSize;
    private boolean mRemoved;
    private Choreographer.FrameCallback mRenderProfiler;
    private boolean mRenderProfilingEnabled;
    boolean mReportNextDraw;
    int mResizeAlpha;
    HardwareLayer mResizeBuffer;
    int mResizeBufferDuration;
    long mResizeBufferStartTime;
    final Paint mResizePaint;
    boolean mScrollMayChange;
    int mScrollY;
    Scroller mScroller;
    SendWindowContentChangedAccessibilityEvent mSendWindowContentChangedAccessibilityEvent;
    int mSeq;
    int mSoftInputMode;
    BaseSurfaceHolder mSurfaceHolder;
    SurfaceHolder.Callback2 mSurfaceHolderCallback;
    InputStage mSyntheticInputStage;
    final int mTargetSdkVersion;
    HashSet<View> mTempHashSet;
    final Rect mTempRect;
    final Thread mThread;
    CompatibilityInfo.Translator mTranslator;
    final Region mTransparentRegion;
    int mTraversalBarrier;
    final TraversalRunnable mTraversalRunnable;
    boolean mTraversalScheduled;
    boolean mUnbufferedInputDispatch;
    View mView;
    final ViewConfiguration mViewConfiguration;
    private int mViewLayoutDirectionInitial;
    int mViewVisibility;
    final Rect mVisRect;
    int mWidth;
    boolean mWillDrawSoon;
    final Rect mWinFrame;
    final W mWindow;
    private final boolean mWindowIsRound;
    final IWindowSession mWindowSession;
    boolean mWindowsAnimating;
    static final ThreadLocal<RunQueue> sRunQueues = new ThreadLocal<>();
    static final ArrayList<Runnable> sFirstDrawHandlers = new ArrayList<>();
    static boolean sFirstDrawComplete = false;
    static final ArrayList<ComponentCallbacks> sConfigCallbacks = new ArrayList<>();
    static final Interpolator mResizeInterpolator = new AccelerateDecelerateInterpolator();
    final int[] mTmpLocation = new int[2];
    final TypedValue mTmpValue = new TypedValue();
    final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
    boolean mAppVisible = true;
    int mOrigWindowType = -1;
    boolean mStopped = false;
    boolean mLastInCompatMode = false;
    String mPendingInputEventQueueLengthCounterName = "pq";
    boolean mWindowAttributesChanged = false;
    int mWindowAttributesChangesFlag = 0;
    final Surface mSurface = new Surface();
    final Rect mPendingOverscanInsets = new Rect();
    final Rect mPendingVisibleInsets = new Rect();
    final Rect mPendingStableInsets = new Rect();
    final Rect mPendingContentInsets = new Rect();
    final ViewTreeObserver.InternalInsetsInfo mLastGivenInsets = new ViewTreeObserver.InternalInsetsInfo();
    final Rect mDispatchContentInsets = new Rect();
    final Rect mDispatchStableInsets = new Rect();
    final Configuration mLastConfiguration = new Configuration();
    final Configuration mPendingConfiguration = new Configuration();
    final PointF mDragPoint = new PointF();
    final PointF mLastTouchPoint = new PointF();
    private long mFpsStartTime = -1;
    private long mFpsPrevTime = -1;
    private boolean mInLayout = false;
    ArrayList<View> mLayoutRequesters = new ArrayList<>();
    boolean mHandlingLayoutInLayoutRequest = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$AccessibilityInteractionConnection.class */
    public static final class AccessibilityInteractionConnection extends IAccessibilityInteractionConnection.Stub {
        private final WeakReference<ViewRootImpl> mViewRootImpl;

        AccessibilityInteractionConnection(ViewRootImpl viewRootImpl) {
            this.mViewRootImpl = new WeakReference<>(viewRootImpl);
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void findAccessibilityNodeInfoByAccessibilityId(long j, Region region, int i, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i2, int i3, long j2, MagnificationSpec magnificationSpec) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().findAccessibilityNodeInfoByAccessibilityIdClientThread(j, region, i, iAccessibilityInteractionConnectionCallback, i2, i3, j2, magnificationSpec);
                return;
            }
            try {
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfosResult(null, i);
            } catch (RemoteException e) {
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void findAccessibilityNodeInfosByText(long j, String str, Region region, int i, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i2, int i3, long j2, MagnificationSpec magnificationSpec) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().findAccessibilityNodeInfosByTextClientThread(j, str, region, i, iAccessibilityInteractionConnectionCallback, i2, i3, j2, magnificationSpec);
                return;
            }
            try {
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfosResult(null, i);
            } catch (RemoteException e) {
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void findAccessibilityNodeInfosByViewId(long j, String str, Region region, int i, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i2, int i3, long j2, MagnificationSpec magnificationSpec) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().findAccessibilityNodeInfosByViewIdClientThread(j, str, region, i, iAccessibilityInteractionConnectionCallback, i2, i3, j2, magnificationSpec);
                return;
            }
            try {
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfoResult(null, i);
            } catch (RemoteException e) {
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void findFocus(long j, int i, Region region, int i2, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i3, int i4, long j2, MagnificationSpec magnificationSpec) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().findFocusClientThread(j, i, region, i2, iAccessibilityInteractionConnectionCallback, i3, i4, j2, magnificationSpec);
                return;
            }
            try {
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfoResult(null, i2);
            } catch (RemoteException e) {
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void focusSearch(long j, int i, Region region, int i2, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i3, int i4, long j2, MagnificationSpec magnificationSpec) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().focusSearchClientThread(j, i, region, i2, iAccessibilityInteractionConnectionCallback, i3, i4, j2, magnificationSpec);
                return;
            }
            try {
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfoResult(null, i2);
            } catch (RemoteException e) {
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void performAccessibilityAction(long j, int i, Bundle bundle, int i2, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i3, int i4, long j2) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().performAccessibilityActionClientThread(j, i, bundle, i2, iAccessibilityInteractionConnectionCallback, i3, i4, j2);
                return;
            }
            try {
                iAccessibilityInteractionConnectionCallback.setPerformAccessibilityActionResult(false, i2);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$AccessibilityInteractionConnectionManager.class */
    public final class AccessibilityInteractionConnectionManager implements AccessibilityManager.AccessibilityStateChangeListener {
        AccessibilityInteractionConnectionManager() {
        }

        public void ensureConnection() {
            if (ViewRootImpl.this.mAttachInfo.mAccessibilityWindowId != Integer.MAX_VALUE) {
                return;
            }
            ViewRootImpl.this.mAttachInfo.mAccessibilityWindowId = ViewRootImpl.this.mAccessibilityManager.addAccessibilityInteractionConnection(ViewRootImpl.this.mWindow, new AccessibilityInteractionConnection(ViewRootImpl.this));
        }

        public void ensureNoConnection() {
            if (ViewRootImpl.this.mAttachInfo.mAccessibilityWindowId != Integer.MAX_VALUE) {
                ViewRootImpl.this.mAttachInfo.mAccessibilityWindowId = Integer.MAX_VALUE;
                ViewRootImpl.this.mAccessibilityManager.removeAccessibilityInteractionConnection(ViewRootImpl.this.mWindow);
            }
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z) {
            if (!z) {
                ensureNoConnection();
                ViewRootImpl.this.mHandler.obtainMessage(21).sendToTarget();
                return;
            }
            ensureConnection();
            if (ViewRootImpl.this.mAttachInfo.mHasWindowFocus) {
                ViewRootImpl.this.mView.sendAccessibilityEvent(32);
                View findFocus = ViewRootImpl.this.mView.findFocus();
                if (findFocus == null || findFocus == ViewRootImpl.this.mView) {
                    return;
                }
                findFocus.sendAccessibilityEvent(8);
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$AsyncInputStage.class */
    abstract class AsyncInputStage extends InputStage {
        protected static final int DEFER = 3;
        private QueuedInputEvent mQueueHead;
        private int mQueueLength;
        private QueuedInputEvent mQueueTail;
        private final String mTraceCounter;

        public AsyncInputStage(InputStage inputStage, String str) {
            super(inputStage);
            this.mTraceCounter = str;
        }

        private void dequeue(QueuedInputEvent queuedInputEvent, QueuedInputEvent queuedInputEvent2) {
            if (queuedInputEvent2 == null) {
                this.mQueueHead = queuedInputEvent.mNext;
            } else {
                queuedInputEvent2.mNext = queuedInputEvent.mNext;
            }
            if (this.mQueueTail == queuedInputEvent) {
                this.mQueueTail = queuedInputEvent2;
            }
            queuedInputEvent.mNext = null;
            this.mQueueLength--;
            Trace.traceCounter(4L, this.mTraceCounter, this.mQueueLength);
        }

        private void enqueue(QueuedInputEvent queuedInputEvent) {
            if (this.mQueueTail == null) {
                this.mQueueHead = queuedInputEvent;
                this.mQueueTail = queuedInputEvent;
            } else {
                this.mQueueTail.mNext = queuedInputEvent;
                this.mQueueTail = queuedInputEvent;
            }
            this.mQueueLength++;
            Trace.traceCounter(4L, this.mTraceCounter, this.mQueueLength);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected void apply(QueuedInputEvent queuedInputEvent, int i) {
            if (i == 3) {
                defer(queuedInputEvent);
            } else {
                super.apply(queuedInputEvent, i);
            }
        }

        protected void defer(QueuedInputEvent queuedInputEvent) {
            queuedInputEvent.mFlags |= 2;
            enqueue(queuedInputEvent);
        }

        @Override // android.view.ViewRootImpl.InputStage
        void dump(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print(getClass().getName());
            printWriter.print(": mQueueLength=");
            printWriter.println(this.mQueueLength);
            super.dump(str, printWriter);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected void forward(QueuedInputEvent queuedInputEvent) {
            boolean z;
            queuedInputEvent.mFlags &= -3;
            QueuedInputEvent queuedInputEvent2 = this.mQueueHead;
            if (queuedInputEvent2 == null) {
                super.forward(queuedInputEvent);
                return;
            }
            int deviceId = queuedInputEvent.mEvent.getDeviceId();
            QueuedInputEvent queuedInputEvent3 = null;
            boolean z2 = false;
            while (true) {
                z = z2;
                if (queuedInputEvent2 == null || queuedInputEvent2 == queuedInputEvent) {
                    break;
                }
                boolean z3 = z;
                if (!z) {
                    z3 = z;
                    if (deviceId == queuedInputEvent2.mEvent.getDeviceId()) {
                        z3 = true;
                    }
                }
                queuedInputEvent3 = queuedInputEvent2;
                queuedInputEvent2 = queuedInputEvent2.mNext;
                z2 = z3;
            }
            if (z) {
                if (queuedInputEvent2 == null) {
                    enqueue(queuedInputEvent);
                    return;
                }
                return;
            }
            QueuedInputEvent queuedInputEvent4 = queuedInputEvent2;
            if (queuedInputEvent2 != null) {
                queuedInputEvent4 = queuedInputEvent2.mNext;
                dequeue(queuedInputEvent, queuedInputEvent3);
            }
            super.forward(queuedInputEvent);
            QueuedInputEvent queuedInputEvent5 = queuedInputEvent4;
            while (true) {
                QueuedInputEvent queuedInputEvent6 = queuedInputEvent5;
                if (queuedInputEvent6 == null) {
                    return;
                }
                if (deviceId != queuedInputEvent6.mEvent.getDeviceId()) {
                    queuedInputEvent3 = queuedInputEvent6;
                    queuedInputEvent5 = queuedInputEvent6.mNext;
                } else if ((queuedInputEvent6.mFlags & 2) != 0) {
                    return;
                } else {
                    QueuedInputEvent queuedInputEvent7 = queuedInputEvent6.mNext;
                    dequeue(queuedInputEvent6, queuedInputEvent3);
                    super.forward(queuedInputEvent6);
                    queuedInputEvent5 = queuedInputEvent7;
                }
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$CalledFromWrongThreadException.class */
    public static final class CalledFromWrongThreadException extends AndroidRuntimeException {
        public CalledFromWrongThreadException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$ConsumeBatchedInputImmediatelyRunnable.class */
    public final class ConsumeBatchedInputImmediatelyRunnable implements Runnable {
        ConsumeBatchedInputImmediatelyRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewRootImpl.this.doConsumeBatchedInput(-1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$ConsumeBatchedInputRunnable.class */
    public final class ConsumeBatchedInputRunnable implements Runnable {
        ConsumeBatchedInputRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewRootImpl.this.doConsumeBatchedInput(ViewRootImpl.this.mChoreographer.getFrameTimeNanos());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$EarlyPostImeInputStage.class */
    public final class EarlyPostImeInputStage extends InputStage {
        public EarlyPostImeInputStage(InputStage inputStage) {
            super(inputStage);
        }

        private int processKeyEvent(QueuedInputEvent queuedInputEvent) {
            KeyEvent keyEvent = (KeyEvent) queuedInputEvent.mEvent;
            if (ViewRootImpl.this.checkForLeavingTouchModeAndConsume(keyEvent)) {
                return 1;
            }
            ViewRootImpl.this.mFallbackEventHandler.preDispatchKeyEvent(keyEvent);
            return 0;
        }

        private int processPointerEvent(QueuedInputEvent queuedInputEvent) {
            MotionEvent motionEvent = (MotionEvent) queuedInputEvent.mEvent;
            if (ViewRootImpl.this.mTranslator != null) {
                ViewRootImpl.this.mTranslator.translateEventInScreenToAppWindow(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 0 || action == 8) {
                ViewRootImpl.this.ensureTouchMode(true);
            }
            if (ViewRootImpl.this.mCurScrollY != 0) {
                motionEvent.offsetLocation(0.0f, ViewRootImpl.this.mCurScrollY);
            }
            if (motionEvent.isTouchEvent()) {
                ViewRootImpl.this.mLastTouchPoint.x = motionEvent.getRawX();
                ViewRootImpl.this.mLastTouchPoint.y = motionEvent.getRawY();
                return 0;
            }
            return 0;
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent queuedInputEvent) {
            if (queuedInputEvent.mEvent instanceof KeyEvent) {
                return processKeyEvent(queuedInputEvent);
            }
            if ((queuedInputEvent.mEvent.getSource() & 2) != 0) {
                return processPointerEvent(queuedInputEvent);
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$HighContrastTextManager.class */
    public final class HighContrastTextManager implements AccessibilityManager.HighTextContrastChangeListener {
        HighContrastTextManager() {
            ViewRootImpl.this.mAttachInfo.mHighContrastText = ViewRootImpl.this.mAccessibilityManager.isHighTextContrastEnabled();
        }

        @Override // android.view.accessibility.AccessibilityManager.HighTextContrastChangeListener
        public void onHighTextContrastStateChanged(boolean z) {
            ViewRootImpl.this.mAttachInfo.mHighContrastText = z;
            ViewRootImpl.this.destroyHardwareResources();
            ViewRootImpl.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$ImeInputStage.class */
    public final class ImeInputStage extends AsyncInputStage implements InputMethodManager.FinishedInputEventCallback {
        public ImeInputStage(InputStage inputStage, String str) {
            super(inputStage, str);
        }

        @Override // android.view.inputmethod.InputMethodManager.FinishedInputEventCallback
        public void onFinishedInputEvent(Object obj, boolean z) {
            QueuedInputEvent queuedInputEvent = (QueuedInputEvent) obj;
            if (z) {
                finish(queuedInputEvent, true);
            } else {
                forward(queuedInputEvent);
            }
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent queuedInputEvent) {
            InputMethodManager peekInstance;
            if (!ViewRootImpl.this.mLastWasImTarget || ViewRootImpl.this.isInLocalFocusMode() || (peekInstance = InputMethodManager.peekInstance()) == null) {
                return 0;
            }
            int dispatchInputEvent = peekInstance.dispatchInputEvent(queuedInputEvent.mEvent, queuedInputEvent, this, ViewRootImpl.this.mHandler);
            if (dispatchInputEvent == 1) {
                return 1;
            }
            return dispatchInputEvent == 0 ? 0 : 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$InputStage.class */
    public abstract class InputStage {
        protected static final int FINISH_HANDLED = 1;
        protected static final int FINISH_NOT_HANDLED = 2;
        protected static final int FORWARD = 0;
        private final InputStage mNext;

        public InputStage(InputStage inputStage) {
            this.mNext = inputStage;
        }

        protected void apply(QueuedInputEvent queuedInputEvent, int i) {
            if (i == 0) {
                forward(queuedInputEvent);
            } else if (i == 1) {
                finish(queuedInputEvent, true);
            } else if (i != 2) {
                throw new IllegalArgumentException("Invalid result: " + i);
            } else {
                finish(queuedInputEvent, false);
            }
        }

        public final void deliver(QueuedInputEvent queuedInputEvent) {
            if ((queuedInputEvent.mFlags & 4) != 0) {
                forward(queuedInputEvent);
            } else if (shouldDropInputEvent(queuedInputEvent)) {
                finish(queuedInputEvent, false);
            } else {
                apply(queuedInputEvent, onProcess(queuedInputEvent));
            }
        }

        void dump(String str, PrintWriter printWriter) {
            if (this.mNext != null) {
                this.mNext.dump(str, printWriter);
            }
        }

        protected void finish(QueuedInputEvent queuedInputEvent, boolean z) {
            queuedInputEvent.mFlags |= 4;
            if (z) {
                queuedInputEvent.mFlags |= 8;
            }
            forward(queuedInputEvent);
        }

        protected void forward(QueuedInputEvent queuedInputEvent) {
            onDeliverToNext(queuedInputEvent);
        }

        protected void onDeliverToNext(QueuedInputEvent queuedInputEvent) {
            if (this.mNext != null) {
                this.mNext.deliver(queuedInputEvent);
            } else {
                ViewRootImpl.this.finishInputEvent(queuedInputEvent);
            }
        }

        protected int onProcess(QueuedInputEvent queuedInputEvent) {
            return 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
            if (r4.this$0.mStopped != false) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected boolean shouldDropInputEvent(android.view.ViewRootImpl.QueuedInputEvent r5) {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                r0 = r4
                android.view.ViewRootImpl r0 = android.view.ViewRootImpl.this
                android.view.View r0 = r0.mView
                if (r0 == 0) goto L16
                r0 = r4
                android.view.ViewRootImpl r0 = android.view.ViewRootImpl.this
                boolean r0 = r0.mAdded
                if (r0 != 0) goto L36
            L16:
                java.lang.String r0 = "ViewRootImpl"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r2 = r1
                r2.<init>()
                java.lang.String r2 = "Dropping event due to root view being removed: "
                java.lang.StringBuilder r1 = r1.append(r2)
                r2 = r5
                android.view.InputEvent r2 = r2.mEvent
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                int r0 = android.util.Slog.w(r0, r1)
                r0 = 1
                r6 = r0
            L34:
                r0 = r6
                return r0
            L36:
                r0 = r4
                android.view.ViewRootImpl r0 = android.view.ViewRootImpl.this
                android.view.View$AttachInfo r0 = r0.mAttachInfo
                boolean r0 = r0.mHasWindowFocus
                if (r0 == 0) goto L4f
                r0 = r7
                r6 = r0
                r0 = r4
                android.view.ViewRootImpl r0 = android.view.ViewRootImpl.this
                boolean r0 = r0.mStopped
                if (r0 == 0) goto L34
            L4f:
                r0 = r7
                r6 = r0
                r0 = r5
                android.view.InputEvent r0 = r0.mEvent
                r1 = 2
                boolean r0 = r0.isFromSource(r1)
                if (r0 != 0) goto L34
                r0 = r5
                android.view.InputEvent r0 = r0.mEvent
                boolean r0 = android.view.ViewRootImpl.isTerminalInputEvent(r0)
                if (r0 == 0) goto L8b
                r0 = r5
                android.view.InputEvent r0 = r0.mEvent
                r0.cancel()
                java.lang.String r0 = "ViewRootImpl"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r2 = r1
                r2.<init>()
                java.lang.String r2 = "Cancelling event due to no window focus: "
                java.lang.StringBuilder r1 = r1.append(r2)
                r2 = r5
                android.view.InputEvent r2 = r2.mEvent
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                int r0 = android.util.Slog.w(r0, r1)
                r0 = 0
                return r0
            L8b:
                java.lang.String r0 = "ViewRootImpl"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r2 = r1
                r2.<init>()
                java.lang.String r2 = "Dropping event due to no window focus: "
                java.lang.StringBuilder r1 = r1.append(r2)
                r2 = r5
                android.view.InputEvent r2 = r2.mEvent
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                int r0 = android.util.Slog.w(r0, r1)
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.InputStage.shouldDropInputEvent(android.view.ViewRootImpl$QueuedInputEvent):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$InvalidateOnAnimationRunnable.class */
    public final class InvalidateOnAnimationRunnable implements Runnable {
        private boolean mPosted;
        private View.AttachInfo.InvalidateInfo[] mTempViewRects;
        private View[] mTempViews;
        private final ArrayList<View> mViews = new ArrayList<>();
        private final ArrayList<View.AttachInfo.InvalidateInfo> mViewRects = new ArrayList<>();

        InvalidateOnAnimationRunnable() {
        }

        private void postIfNeededLocked() {
            if (this.mPosted) {
                return;
            }
            ViewRootImpl.this.mChoreographer.postCallback(1, this, null);
            this.mPosted = true;
        }

        public void addView(View view) {
            synchronized (this) {
                this.mViews.add(view);
                postIfNeededLocked();
            }
        }

        public void addViewRect(View.AttachInfo.InvalidateInfo invalidateInfo) {
            synchronized (this) {
                this.mViewRects.add(invalidateInfo);
                postIfNeededLocked();
            }
        }

        public void removeView(View view) {
            synchronized (this) {
                this.mViews.remove(view);
                int size = this.mViewRects.size();
                while (true) {
                    int i = size;
                    int i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    View.AttachInfo.InvalidateInfo invalidateInfo = this.mViewRects.get(i2);
                    if (invalidateInfo.target == view) {
                        this.mViewRects.remove(i2);
                        invalidateInfo.recycle();
                    }
                    size = i2;
                }
                if (this.mPosted && this.mViews.isEmpty() && this.mViewRects.isEmpty()) {
                    ViewRootImpl.this.mChoreographer.removeCallbacks(1, this, null);
                    this.mPosted = false;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int size;
            int size2;
            synchronized (this) {
                this.mPosted = false;
                size = this.mViews.size();
                if (size != 0) {
                    this.mTempViews = (View[]) this.mViews.toArray(this.mTempViews != null ? this.mTempViews : new View[size]);
                    this.mViews.clear();
                }
                size2 = this.mViewRects.size();
                if (size2 != 0) {
                    this.mTempViewRects = (View.AttachInfo.InvalidateInfo[]) this.mViewRects.toArray(this.mTempViewRects != null ? this.mTempViewRects : new View.AttachInfo.InvalidateInfo[size2]);
                    this.mViewRects.clear();
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                this.mTempViews[i2].invalidate();
                this.mTempViews[i2] = null;
                i = i2 + 1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    return;
                }
                View.AttachInfo.InvalidateInfo invalidateInfo = this.mTempViewRects[i4];
                invalidateInfo.target.invalidate(invalidateInfo.left, invalidateInfo.top, invalidateInfo.right, invalidateInfo.bottom);
                invalidateInfo.recycle();
                i3 = i4 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$NativePostImeInputStage.class */
    public final class NativePostImeInputStage extends AsyncInputStage implements InputQueue.FinishedInputEventCallback {
        public NativePostImeInputStage(InputStage inputStage, String str) {
            super(inputStage, str);
        }

        public void onFinishedInputEvent(Object obj, boolean z) {
            QueuedInputEvent queuedInputEvent = (QueuedInputEvent) obj;
            if (z) {
                finish(queuedInputEvent, true);
            } else {
                forward(queuedInputEvent);
            }
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent queuedInputEvent) {
            int i = 0;
            if (ViewRootImpl.this.mInputQueue != null) {
                ViewRootImpl.this.mInputQueue.sendInputEvent(queuedInputEvent.mEvent, queuedInputEvent, false, this);
                i = 3;
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$NativePreImeInputStage.class */
    public final class NativePreImeInputStage extends AsyncInputStage implements InputQueue.FinishedInputEventCallback {
        public NativePreImeInputStage(InputStage inputStage, String str) {
            super(inputStage, str);
        }

        public void onFinishedInputEvent(Object obj, boolean z) {
            QueuedInputEvent queuedInputEvent = (QueuedInputEvent) obj;
            if (z) {
                finish(queuedInputEvent, true);
            } else {
                forward(queuedInputEvent);
            }
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent queuedInputEvent) {
            if (ViewRootImpl.this.mInputQueue == null || !(queuedInputEvent.mEvent instanceof KeyEvent)) {
                return 0;
            }
            ViewRootImpl.this.mInputQueue.sendInputEvent(queuedInputEvent.mEvent, queuedInputEvent, true, this);
            return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$QueuedInputEvent.class */
    public static final class QueuedInputEvent {
        public static final int FLAG_DEFERRED = 2;
        public static final int FLAG_DELIVER_POST_IME = 1;
        public static final int FLAG_FINISHED = 4;
        public static final int FLAG_FINISHED_HANDLED = 8;
        public static final int FLAG_RESYNTHESIZED = 16;
        public static final int FLAG_UNHANDLED = 32;
        public InputEvent mEvent;
        public int mFlags;
        public QueuedInputEvent mNext;
        public InputEventReceiver mReceiver;

        private QueuedInputEvent() {
        }

        private boolean flagToString(String str, int i, boolean z, StringBuilder sb) {
            boolean z2 = z;
            if ((this.mFlags & i) != 0) {
                if (z) {
                    sb.append("|");
                }
                sb.append(str);
                z2 = true;
            }
            return z2;
        }

        public boolean shouldSendToSynthesizer() {
            return (this.mFlags & 32) != 0;
        }

        public boolean shouldSkipIme() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            return (this.mEvent instanceof MotionEvent) && this.mEvent.isFromSource(2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("QueuedInputEvent{flags=");
            if (!flagToString("UNHANDLED", 32, flagToString("RESYNTHESIZED", 16, flagToString("FINISHED_HANDLED", 8, flagToString("FINISHED", 4, flagToString("DEFERRED", 2, flagToString("DELIVER_POST_IME", 1, false, sb), sb), sb), sb), sb), sb)) {
                sb.append("0");
            }
            sb.append(", hasNextQueuedEvent=" + (this.mEvent != null ? "true" : "false"));
            sb.append(", hasInputEventReceiver=" + (this.mReceiver != null ? "true" : "false"));
            sb.append(", mEvent=" + this.mEvent + i.d);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$RunQueue.class */
    public static final class RunQueue {
        private final ArrayList<HandlerAction> mActions = new ArrayList<>();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$RunQueue$HandlerAction.class */
        public static class HandlerAction {
            Runnable action;
            long delay;

            private HandlerAction() {
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                HandlerAction handlerAction = (HandlerAction) obj;
                return this.action != null ? this.action.equals(handlerAction.action) : handlerAction.action == null;
            }

            public int hashCode() {
                return ((this.action != null ? this.action.hashCode() : 0) * 31) + ((int) (this.delay ^ (this.delay >>> 32)));
            }
        }

        RunQueue() {
        }

        void executeActions(Handler handler) {
            synchronized (this.mActions) {
                ArrayList<HandlerAction> arrayList = this.mActions;
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < size) {
                        HandlerAction handlerAction = arrayList.get(i2);
                        handler.postDelayed(handlerAction.action, handlerAction.delay);
                        i = i2 + 1;
                    } else {
                        arrayList.clear();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void post(Runnable runnable) {
            postDelayed(runnable, 0L);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void postDelayed(Runnable runnable, long j) {
            HandlerAction handlerAction = new HandlerAction();
            handlerAction.action = runnable;
            handlerAction.delay = j;
            synchronized (this.mActions) {
                this.mActions.add(handlerAction);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void removeCallbacks(Runnable runnable) {
            HandlerAction handlerAction = new HandlerAction();
            handlerAction.action = runnable;
            synchronized (this.mActions) {
                do {
                } while (this.mActions.remove(handlerAction));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$SendWindowContentChangedAccessibilityEvent.class */
    public class SendWindowContentChangedAccessibilityEvent implements Runnable {
        private int mChangeTypes;
        public long mLastEventTimeMillis;
        public View mSource;

        private SendWindowContentChangedAccessibilityEvent() {
            this.mChangeTypes = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AccessibilityManager.getInstance(ViewRootImpl.this.mContext).isEnabled()) {
                this.mLastEventTimeMillis = SystemClock.uptimeMillis();
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                obtain.setContentChangeTypes(this.mChangeTypes);
                this.mSource.sendAccessibilityEventUnchecked(obtain);
            } else {
                this.mLastEventTimeMillis = 0L;
            }
            this.mSource.resetSubtreeAccessibilityStateChanged();
            this.mSource = null;
            this.mChangeTypes = 0;
        }

        public void runOrPost(View view, int i) {
            if (this.mSource != null) {
                View commonPredecessor = ViewRootImpl.this.getCommonPredecessor(this.mSource, view);
                if (commonPredecessor != null) {
                    view = commonPredecessor;
                }
                this.mSource = view;
                this.mChangeTypes |= i;
                return;
            }
            this.mSource = view;
            this.mChangeTypes = i;
            long uptimeMillis = SystemClock.uptimeMillis() - this.mLastEventTimeMillis;
            long sendRecurringAccessibilityEventsInterval = ViewConfiguration.getSendRecurringAccessibilityEventsInterval();
            if (uptimeMillis < sendRecurringAccessibilityEventsInterval) {
                this.mSource.postDelayed(this, sendRecurringAccessibilityEventsInterval - uptimeMillis);
                return;
            }
            this.mSource.removeCallbacks(this);
            run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$SyntheticInputStage.class */
    public final class SyntheticInputStage extends InputStage {
        private final SyntheticJoystickHandler mJoystick;
        private final SyntheticKeyboardHandler mKeyboard;
        private final SyntheticTouchNavigationHandler mTouchNavigation;
        private final SyntheticTrackballHandler mTrackball;

        public SyntheticInputStage() {
            super(null);
            this.mTrackball = new SyntheticTrackballHandler();
            this.mJoystick = new SyntheticJoystickHandler();
            this.mTouchNavigation = new SyntheticTouchNavigationHandler();
            this.mKeyboard = new SyntheticKeyboardHandler();
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected void onDeliverToNext(QueuedInputEvent queuedInputEvent) {
            if ((queuedInputEvent.mFlags & 16) == 0 && (queuedInputEvent.mEvent instanceof MotionEvent)) {
                MotionEvent motionEvent = (MotionEvent) queuedInputEvent.mEvent;
                int source = motionEvent.getSource();
                if ((source & 4) != 0) {
                    this.mTrackball.cancel(motionEvent);
                } else if ((source & 16) != 0) {
                    this.mJoystick.cancel(motionEvent);
                } else if ((source & 2097152) == 2097152) {
                    this.mTouchNavigation.cancel(motionEvent);
                }
            }
            super.onDeliverToNext(queuedInputEvent);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent queuedInputEvent) {
            queuedInputEvent.mFlags |= 16;
            if (!(queuedInputEvent.mEvent instanceof MotionEvent)) {
                if ((queuedInputEvent.mFlags & 32) != 0) {
                    this.mKeyboard.process((KeyEvent) queuedInputEvent.mEvent);
                    return 1;
                }
                return 0;
            }
            MotionEvent motionEvent = (MotionEvent) queuedInputEvent.mEvent;
            int source = motionEvent.getSource();
            if ((source & 4) != 0) {
                this.mTrackball.process(motionEvent);
                return 1;
            } else if ((source & 16) != 0) {
                this.mJoystick.process(motionEvent);
                return 1;
            } else if ((source & 2097152) == 2097152) {
                this.mTouchNavigation.process(motionEvent);
                return 1;
            } else {
                return 0;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$SyntheticJoystickHandler.class */
    final class SyntheticJoystickHandler extends Handler {
        private static final int MSG_ENQUEUE_X_AXIS_KEY_REPEAT = 1;
        private static final int MSG_ENQUEUE_Y_AXIS_KEY_REPEAT = 2;
        private static final String TAG = "SyntheticJoystickHandler";
        private int mLastXDirection;
        private int mLastXKeyCode;
        private int mLastYDirection;
        private int mLastYKeyCode;

        public SyntheticJoystickHandler() {
            super(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancel(MotionEvent motionEvent) {
            removeMessages(1);
            removeMessages(2);
            update(motionEvent, false);
        }

        private int joystickAxisValueToDirection(float f) {
            if (f >= 0.5f) {
                return 1;
            }
            return f <= -0.5f ? -1 : 0;
        }

        private void update(MotionEvent motionEvent, boolean z) {
            long eventTime = motionEvent.getEventTime();
            int metaState = motionEvent.getMetaState();
            int deviceId = motionEvent.getDeviceId();
            int source = motionEvent.getSource();
            int joystickAxisValueToDirection = joystickAxisValueToDirection(motionEvent.getAxisValue(15));
            int i = joystickAxisValueToDirection;
            if (joystickAxisValueToDirection == 0) {
                i = joystickAxisValueToDirection(motionEvent.getX());
            }
            int joystickAxisValueToDirection2 = joystickAxisValueToDirection(motionEvent.getAxisValue(16));
            int i2 = joystickAxisValueToDirection2;
            if (joystickAxisValueToDirection2 == 0) {
                i2 = joystickAxisValueToDirection(motionEvent.getY());
            }
            if (i != this.mLastXDirection) {
                if (this.mLastXKeyCode != 0) {
                    removeMessages(1);
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(eventTime, eventTime, 1, this.mLastXKeyCode, 0, metaState, deviceId, 0, 1024, source));
                    this.mLastXKeyCode = 0;
                }
                this.mLastXDirection = i;
                if (i != 0 && z) {
                    this.mLastXKeyCode = i > 0 ? 22 : 21;
                    KeyEvent keyEvent = new KeyEvent(eventTime, eventTime, 0, this.mLastXKeyCode, 0, metaState, deviceId, 0, 1024, source);
                    ViewRootImpl.this.enqueueInputEvent(keyEvent);
                    Message obtainMessage = obtainMessage(1, keyEvent);
                    obtainMessage.setAsynchronous(true);
                    sendMessageDelayed(obtainMessage, ViewConfiguration.getKeyRepeatTimeout());
                }
            }
            if (i2 != this.mLastYDirection) {
                if (this.mLastYKeyCode != 0) {
                    removeMessages(2);
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(eventTime, eventTime, 1, this.mLastYKeyCode, 0, metaState, deviceId, 0, 1024, source));
                    this.mLastYKeyCode = 0;
                }
                this.mLastYDirection = i2;
                if (i2 == 0 || !z) {
                    return;
                }
                this.mLastYKeyCode = i2 > 0 ? 20 : 19;
                KeyEvent keyEvent2 = new KeyEvent(eventTime, eventTime, 0, this.mLastYKeyCode, 0, metaState, deviceId, 0, 1024, source);
                ViewRootImpl.this.enqueueInputEvent(keyEvent2);
                Message obtainMessage2 = obtainMessage(2, keyEvent2);
                obtainMessage2.setAsynchronous(true);
                sendMessageDelayed(obtainMessage2, ViewConfiguration.getKeyRepeatTimeout());
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                case 2:
                    KeyEvent keyEvent = (KeyEvent) message.obj;
                    KeyEvent changeTimeRepeat = KeyEvent.changeTimeRepeat(keyEvent, SystemClock.uptimeMillis(), keyEvent.getRepeatCount() + 1);
                    if (ViewRootImpl.this.mAttachInfo.mHasWindowFocus) {
                        ViewRootImpl.this.enqueueInputEvent(changeTimeRepeat);
                        Message obtainMessage = obtainMessage(message.what, changeTimeRepeat);
                        obtainMessage.setAsynchronous(true);
                        sendMessageDelayed(obtainMessage, ViewConfiguration.getKeyRepeatDelay());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void process(MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 2:
                    update(motionEvent, true);
                    return;
                case 3:
                    cancel(motionEvent);
                    return;
                default:
                    Log.w(TAG, "Unexpected action: " + motionEvent.getActionMasked());
                    return;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$SyntheticKeyboardHandler.class */
    final class SyntheticKeyboardHandler {
        SyntheticKeyboardHandler() {
        }

        public void process(KeyEvent keyEvent) {
            KeyCharacterMap.FallbackAction fallbackAction;
            if ((keyEvent.getFlags() & 1024) == 0 && (fallbackAction = keyEvent.getKeyCharacterMap().getFallbackAction(keyEvent.getKeyCode(), keyEvent.getMetaState())) != null) {
                KeyEvent obtain = KeyEvent.obtain(keyEvent.getDownTime(), keyEvent.getEventTime(), keyEvent.getAction(), fallbackAction.keyCode, keyEvent.getRepeatCount(), fallbackAction.metaState, keyEvent.getDeviceId(), keyEvent.getScanCode(), keyEvent.getFlags() | 1024, keyEvent.getSource(), null);
                fallbackAction.recycle();
                ViewRootImpl.this.enqueueInputEvent(obtain);
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$SyntheticTouchNavigationHandler.class */
    final class SyntheticTouchNavigationHandler extends Handler {
        private static final float DEFAULT_HEIGHT_MILLIMETERS = 48.0f;
        private static final float DEFAULT_WIDTH_MILLIMETERS = 48.0f;
        private static final float FLING_TICK_DECAY = 0.8f;
        private static final boolean LOCAL_DEBUG = false;
        private static final String LOCAL_TAG = "SyntheticTouchNavigationHandler";
        private static final float MAX_FLING_VELOCITY_TICKS_PER_SECOND = 20.0f;
        private static final float MIN_FLING_VELOCITY_TICKS_PER_SECOND = 6.0f;
        private static final int TICK_DISTANCE_MILLIMETERS = 12;
        private float mAccumulatedX;
        private float mAccumulatedY;
        private int mActivePointerId;
        private float mConfigMaxFlingVelocity;
        private float mConfigMinFlingVelocity;
        private float mConfigTickDistance;
        private boolean mConsumedMovement;
        private int mCurrentDeviceId;
        private boolean mCurrentDeviceSupported;
        private int mCurrentSource;
        private final Runnable mFlingRunnable;
        private float mFlingVelocity;
        private boolean mFlinging;
        private float mLastX;
        private float mLastY;
        private int mPendingKeyCode;
        private long mPendingKeyDownTime;
        private int mPendingKeyMetaState;
        private int mPendingKeyRepeatCount;
        private float mStartX;
        private float mStartY;
        private VelocityTracker mVelocityTracker;

        public SyntheticTouchNavigationHandler() {
            super(true);
            this.mCurrentDeviceId = -1;
            this.mActivePointerId = -1;
            this.mPendingKeyCode = 0;
            this.mFlingRunnable = new Runnable() { // from class: android.view.ViewRootImpl.SyntheticTouchNavigationHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    SyntheticTouchNavigationHandler.this.sendKeyDownOrRepeat(uptimeMillis, SyntheticTouchNavigationHandler.this.mPendingKeyCode, SyntheticTouchNavigationHandler.this.mPendingKeyMetaState);
                    SyntheticTouchNavigationHandler.access$1332(SyntheticTouchNavigationHandler.this, SyntheticTouchNavigationHandler.FLING_TICK_DECAY);
                    if (SyntheticTouchNavigationHandler.this.postFling(uptimeMillis)) {
                        return;
                    }
                    SyntheticTouchNavigationHandler.this.mFlinging = false;
                    SyntheticTouchNavigationHandler.this.finishKeys(uptimeMillis);
                }
            };
        }

        static /* synthetic */ float access$1332(SyntheticTouchNavigationHandler syntheticTouchNavigationHandler, float f) {
            float f2 = syntheticTouchNavigationHandler.mFlingVelocity * f;
            syntheticTouchNavigationHandler.mFlingVelocity = f2;
            return f2;
        }

        private void cancelFling() {
            if (this.mFlinging) {
                removeCallbacks(this.mFlingRunnable);
                this.mFlinging = false;
            }
        }

        private float consumeAccumulatedMovement(long j, int i, float f, int i2, int i3) {
            float f2;
            while (true) {
                f2 = f;
                if (f > (-this.mConfigTickDistance)) {
                    break;
                }
                sendKeyDownOrRepeat(j, i2, i);
                f += this.mConfigTickDistance;
            }
            while (f2 >= this.mConfigTickDistance) {
                sendKeyDownOrRepeat(j, i3, i);
                f2 -= this.mConfigTickDistance;
            }
            return f2;
        }

        private void consumeAccumulatedMovement(long j, int i) {
            float abs = Math.abs(this.mAccumulatedX);
            float abs2 = Math.abs(this.mAccumulatedY);
            if (abs >= abs2) {
                if (abs >= this.mConfigTickDistance) {
                    this.mAccumulatedX = consumeAccumulatedMovement(j, i, this.mAccumulatedX, 21, 22);
                    this.mAccumulatedY = 0.0f;
                    this.mConsumedMovement = true;
                }
            } else if (abs2 >= this.mConfigTickDistance) {
                this.mAccumulatedY = consumeAccumulatedMovement(j, i, this.mAccumulatedY, 19, 20);
                this.mAccumulatedX = 0.0f;
                this.mConsumedMovement = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void finishKeys(long j) {
            cancelFling();
            sendKeyUp(j);
        }

        private void finishTracking(long j) {
            if (this.mActivePointerId >= 0) {
                this.mActivePointerId = -1;
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean postFling(long j) {
            if (this.mFlingVelocity >= this.mConfigMinFlingVelocity) {
                postAtTime(this.mFlingRunnable, j + ((this.mConfigTickDistance / this.mFlingVelocity) * 1000.0f));
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendKeyDownOrRepeat(long j, int i, int i2) {
            if (this.mPendingKeyCode != i) {
                sendKeyUp(j);
                this.mPendingKeyDownTime = j;
                this.mPendingKeyCode = i;
                this.mPendingKeyRepeatCount = 0;
            } else {
                this.mPendingKeyRepeatCount++;
            }
            this.mPendingKeyMetaState = i2;
            ViewRootImpl.this.enqueueInputEvent(new KeyEvent(this.mPendingKeyDownTime, j, 0, this.mPendingKeyCode, this.mPendingKeyRepeatCount, this.mPendingKeyMetaState, this.mCurrentDeviceId, 1024, this.mCurrentSource));
        }

        private void sendKeyUp(long j) {
            if (this.mPendingKeyCode != 0) {
                ViewRootImpl.this.enqueueInputEvent(new KeyEvent(this.mPendingKeyDownTime, j, 1, this.mPendingKeyCode, 0, this.mPendingKeyMetaState, this.mCurrentDeviceId, 0, 1024, this.mCurrentSource));
                this.mPendingKeyCode = 0;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private boolean startFling(long j, float f, float f2) {
            boolean z;
            switch (this.mPendingKeyCode) {
                case 19:
                    z = false;
                    if ((-f2) >= this.mConfigMinFlingVelocity) {
                        z = false;
                        if (Math.abs(f) < this.mConfigMinFlingVelocity) {
                            this.mFlingVelocity = -f2;
                            this.mFlinging = postFling(j);
                            z = this.mFlinging;
                            break;
                        }
                    }
                    break;
                case 20:
                    z = false;
                    if (f2 >= this.mConfigMinFlingVelocity) {
                        z = false;
                        if (Math.abs(f) < this.mConfigMinFlingVelocity) {
                            this.mFlingVelocity = f2;
                            this.mFlinging = postFling(j);
                            z = this.mFlinging;
                            break;
                        }
                    }
                    break;
                case 21:
                    z = false;
                    if ((-f) >= this.mConfigMinFlingVelocity) {
                        z = false;
                        if (Math.abs(f2) < this.mConfigMinFlingVelocity) {
                            this.mFlingVelocity = -f;
                            this.mFlinging = postFling(j);
                            z = this.mFlinging;
                            break;
                        }
                    }
                    break;
                case 22:
                    z = false;
                    if (f >= this.mConfigMinFlingVelocity) {
                        z = false;
                        if (Math.abs(f2) < this.mConfigMinFlingVelocity) {
                            this.mFlingVelocity = f;
                            this.mFlinging = postFling(j);
                            z = this.mFlinging;
                            break;
                        }
                    }
                    break;
                default:
                    this.mFlinging = postFling(j);
                    z = this.mFlinging;
                    break;
            }
            return z;
        }

        public void cancel(MotionEvent motionEvent) {
            if (this.mCurrentDeviceId == motionEvent.getDeviceId() && this.mCurrentSource == motionEvent.getSource()) {
                long eventTime = motionEvent.getEventTime();
                finishKeys(eventTime);
                finishTracking(eventTime);
            }
        }

        public void process(MotionEvent motionEvent) {
            long eventTime = motionEvent.getEventTime();
            int deviceId = motionEvent.getDeviceId();
            int source = motionEvent.getSource();
            if (this.mCurrentDeviceId != deviceId || this.mCurrentSource != source) {
                finishKeys(eventTime);
                finishTracking(eventTime);
                this.mCurrentDeviceId = deviceId;
                this.mCurrentSource = source;
                this.mCurrentDeviceSupported = false;
                InputDevice device = motionEvent.getDevice();
                if (device != null) {
                    InputDevice.MotionRange motionRange = device.getMotionRange(0);
                    InputDevice.MotionRange motionRange2 = device.getMotionRange(1);
                    if (motionRange != null && motionRange2 != null) {
                        this.mCurrentDeviceSupported = true;
                        float resolution = motionRange.getResolution();
                        float f = resolution;
                        if (resolution <= 0.0f) {
                            f = motionRange.getRange() / 48.0f;
                        }
                        float resolution2 = motionRange2.getResolution();
                        float f2 = resolution2;
                        if (resolution2 <= 0.0f) {
                            f2 = motionRange2.getRange() / 48.0f;
                        }
                        this.mConfigTickDistance = 12.0f * (f + f2) * 0.5f;
                        this.mConfigMinFlingVelocity = MIN_FLING_VELOCITY_TICKS_PER_SECOND * this.mConfigTickDistance;
                        this.mConfigMaxFlingVelocity = MAX_FLING_VELOCITY_TICKS_PER_SECOND * this.mConfigTickDistance;
                    }
                }
            }
            if (this.mCurrentDeviceSupported) {
                int actionMasked = motionEvent.getActionMasked();
                switch (actionMasked) {
                    case 0:
                        boolean z = this.mFlinging;
                        finishKeys(eventTime);
                        finishTracking(eventTime);
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        this.mVelocityTracker = VelocityTracker.obtain();
                        this.mVelocityTracker.addMovement(motionEvent);
                        this.mStartX = motionEvent.getX();
                        this.mStartY = motionEvent.getY();
                        this.mLastX = this.mStartX;
                        this.mLastY = this.mStartY;
                        this.mAccumulatedX = 0.0f;
                        this.mAccumulatedY = 0.0f;
                        this.mConsumedMovement = z;
                        return;
                    case 1:
                    case 2:
                        if (this.mActivePointerId >= 0) {
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                finishKeys(eventTime);
                                finishTracking(eventTime);
                                return;
                            }
                            this.mVelocityTracker.addMovement(motionEvent);
                            float x = motionEvent.getX(findPointerIndex);
                            float y = motionEvent.getY(findPointerIndex);
                            this.mAccumulatedX += x - this.mLastX;
                            this.mAccumulatedY += y - this.mLastY;
                            this.mLastX = x;
                            this.mLastY = y;
                            consumeAccumulatedMovement(eventTime, motionEvent.getMetaState());
                            if (actionMasked == 1) {
                                if (this.mConsumedMovement && this.mPendingKeyCode != 0) {
                                    this.mVelocityTracker.computeCurrentVelocity(1000, this.mConfigMaxFlingVelocity);
                                    if (!startFling(eventTime, this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mVelocityTracker.getYVelocity(this.mActivePointerId))) {
                                        finishKeys(eventTime);
                                    }
                                }
                                finishTracking(eventTime);
                                return;
                            }
                            return;
                        }
                        return;
                    case 3:
                        finishKeys(eventTime);
                        finishTracking(eventTime);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$SyntheticTrackballHandler.class */
    final class SyntheticTrackballHandler {
        private long mLastTime;
        private final TrackballAxis mX = new TrackballAxis();
        private final TrackballAxis mY = new TrackballAxis();

        SyntheticTrackballHandler() {
        }

        public void cancel(MotionEvent motionEvent) {
            this.mLastTime = -2147483648L;
            if (ViewRootImpl.this.mView == null || !ViewRootImpl.this.mAdded) {
                return;
            }
            ViewRootImpl.this.ensureTouchMode(false);
        }

        public void process(MotionEvent motionEvent) {
            float f;
            int i;
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.mLastTime + 250 < uptimeMillis) {
                this.mX.reset(0);
                this.mY.reset(0);
                this.mLastTime = uptimeMillis;
            }
            int action = motionEvent.getAction();
            int metaState = motionEvent.getMetaState();
            switch (action) {
                case 0:
                    this.mX.reset(2);
                    this.mY.reset(2);
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(uptimeMillis, uptimeMillis, 0, 23, 0, metaState, -1, 0, 1024, 257));
                    break;
                case 1:
                    this.mX.reset(2);
                    this.mY.reset(2);
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(uptimeMillis, uptimeMillis, 1, 23, 0, metaState, -1, 0, 1024, 257));
                    break;
            }
            float collect = this.mX.collect(motionEvent.getX(), motionEvent.getEventTime(), "X");
            float collect2 = this.mY.collect(motionEvent.getY(), motionEvent.getEventTime(), "Y");
            int i2 = 0;
            if (collect > collect2) {
                int generate = this.mX.generate();
                f = 1.0f;
                i = 0;
                i2 = generate;
                if (generate != 0) {
                    i = generate > 0 ? 22 : 21;
                    f = this.mX.acceleration;
                    this.mY.reset(2);
                    i2 = generate;
                }
            } else {
                f = 1.0f;
                i = 0;
                if (collect2 > 0.0f) {
                    int generate2 = this.mY.generate();
                    f = 1.0f;
                    i = 0;
                    i2 = generate2;
                    if (generate2 != 0) {
                        i = generate2 > 0 ? 20 : 19;
                        f = this.mY.acceleration;
                        this.mX.reset(2);
                        i2 = generate2;
                    }
                }
            }
            if (i != 0) {
                int i3 = i2;
                if (i2 < 0) {
                    i3 = -i2;
                }
                int i4 = (int) (i3 * f);
                long j = uptimeMillis;
                int i5 = i3;
                if (i4 > i3) {
                    i5 = i3 - 1;
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(uptimeMillis, uptimeMillis, 2, i, i4 - i5, metaState, -1, 0, 1024, 257));
                    j = uptimeMillis;
                }
                while (i5 > 0) {
                    i5--;
                    j = SystemClock.uptimeMillis();
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(j, j, 0, i, 0, metaState, -1, 0, 1024, 257));
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(j, j, 1, i, 0, metaState, -1, 0, 1024, 257));
                }
                this.mLastTime = j;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$SystemUiVisibilityInfo.class */
    public static final class SystemUiVisibilityInfo {
        int globalVisibility;
        int localChanges;
        int localValue;
        int seq;

        SystemUiVisibilityInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$TakenSurfaceHolder.class */
    public class TakenSurfaceHolder extends BaseSurfaceHolder {
        TakenSurfaceHolder() {
        }

        @Override // android.view.SurfaceHolder
        public boolean isCreating() {
            return ViewRootImpl.this.mIsCreating;
        }

        @Override // com.android.internal.view.BaseSurfaceHolder
        public boolean onAllowLockCanvas() {
            return ViewRootImpl.this.mDrawingAllowed;
        }

        @Override // com.android.internal.view.BaseSurfaceHolder
        public void onRelayoutContainer() {
        }

        @Override // com.android.internal.view.BaseSurfaceHolder
        public void onUpdateSurface() {
            throw new IllegalStateException("Shouldn't be here");
        }

        @Override // com.android.internal.view.BaseSurfaceHolder, android.view.SurfaceHolder
        public void setFixedSize(int i, int i2) {
            throw new UnsupportedOperationException("Currently only support sizing from layout");
        }

        @Override // com.android.internal.view.BaseSurfaceHolder, android.view.SurfaceHolder
        public void setFormat(int i) {
            ((RootViewSurfaceTaker) ViewRootImpl.this.mView).setSurfaceFormat(i);
        }

        @Override // android.view.SurfaceHolder
        public void setKeepScreenOn(boolean z) {
            ((RootViewSurfaceTaker) ViewRootImpl.this.mView).setSurfaceKeepScreenOn(z);
        }

        @Override // com.android.internal.view.BaseSurfaceHolder, android.view.SurfaceHolder
        public void setType(int i) {
            ((RootViewSurfaceTaker) ViewRootImpl.this.mView).setSurfaceType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$TrackballAxis.class */
    public static final class TrackballAxis {
        static final float ACCEL_MOVE_SCALING_FACTOR = 0.025f;
        static final long FAST_MOVE_TIME = 150;
        static final float FIRST_MOVEMENT_THRESHOLD = 0.5f;
        static final float MAX_ACCELERATION = 20.0f;
        static final float SECOND_CUMULATIVE_MOVEMENT_THRESHOLD = 2.0f;
        static final float SUBSEQUENT_INCREMENTAL_MOVEMENT_THRESHOLD = 1.0f;
        int dir;
        int nonAccelMovement;
        float position;
        int step;
        float acceleration = 1.0f;
        long lastMoveTime = 0;

        TrackballAxis() {
        }

        float collect(float f, long j, String str) {
            long j2;
            if (f > 0.0f) {
                j2 = 150.0f * f;
                if (this.dir < 0) {
                    this.position = 0.0f;
                    this.step = 0;
                    this.acceleration = 1.0f;
                    this.lastMoveTime = 0L;
                }
                this.dir = 1;
            } else if (f < 0.0f) {
                j2 = (-f) * 150.0f;
                if (this.dir > 0) {
                    this.position = 0.0f;
                    this.step = 0;
                    this.acceleration = 1.0f;
                    this.lastMoveTime = 0L;
                }
                this.dir = -1;
            } else {
                j2 = 0;
            }
            if (j2 > 0) {
                long j3 = j - this.lastMoveTime;
                this.lastMoveTime = j;
                float f2 = this.acceleration;
                if (j3 < j2) {
                    float f3 = ((float) (j2 - j3)) * ACCEL_MOVE_SCALING_FACTOR;
                    float f4 = f2;
                    if (f3 > 1.0f) {
                        f4 = f2 * f3;
                    }
                    if (f4 >= MAX_ACCELERATION) {
                        f4 = 20.0f;
                    }
                    this.acceleration = f4;
                } else {
                    float f5 = ((float) (j3 - j2)) * ACCEL_MOVE_SCALING_FACTOR;
                    float f6 = f2;
                    if (f5 > 1.0f) {
                        f6 = f2 / f5;
                    }
                    if (f6 <= 1.0f) {
                        f6 = 1.0f;
                    }
                    this.acceleration = f6;
                }
            }
            this.position += f;
            return Math.abs(this.position);
        }

        int generate() {
            int i = 0;
            this.nonAccelMovement = 0;
            while (true) {
                int i2 = this.position >= 0.0f ? 1 : -1;
                switch (this.step) {
                    case 0:
                        if (Math.abs(this.position) < FIRST_MOVEMENT_THRESHOLD) {
                            break;
                        } else {
                            i += i2;
                            this.nonAccelMovement += i2;
                            this.step = 1;
                            break;
                        }
                    case 1:
                        if (Math.abs(this.position) < SECOND_CUMULATIVE_MOVEMENT_THRESHOLD) {
                            break;
                        } else {
                            i += i2;
                            this.nonAccelMovement += i2;
                            this.position -= i2 * SECOND_CUMULATIVE_MOVEMENT_THRESHOLD;
                            this.step = 2;
                            break;
                        }
                    default:
                        if (Math.abs(this.position) >= 1.0f) {
                            i += i2;
                            this.position -= i2 * 1.0f;
                            float f = this.acceleration * 1.1f;
                            if (f >= MAX_ACCELERATION) {
                                f = this.acceleration;
                            }
                            this.acceleration = f;
                            break;
                        } else {
                            break;
                        }
                }
            }
            return i;
        }

        void reset(int i) {
            this.position = 0.0f;
            this.acceleration = 1.0f;
            this.lastMoveTime = 0L;
            this.step = i;
            this.dir = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$TraversalRunnable.class */
    public final class TraversalRunnable implements Runnable {
        TraversalRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewRootImpl.this.doTraversal();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$ViewPostImeInputStage.class */
    public final class ViewPostImeInputStage extends InputStage {
        public ViewPostImeInputStage(InputStage inputStage) {
            super(inputStage);
        }

        private int processGenericMotionEvent(QueuedInputEvent queuedInputEvent) {
            return ViewRootImpl.this.mView.dispatchGenericMotionEvent((MotionEvent) queuedInputEvent.mEvent) ? 1 : 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
            if (shouldDropInputEvent(r5) == false) goto L25;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int processKeyEvent(android.view.ViewRootImpl.QueuedInputEvent r5) {
            /*
                Method dump skipped, instructions count: 472
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.ViewPostImeInputStage.processKeyEvent(android.view.ViewRootImpl$QueuedInputEvent):int");
        }

        private int processPointerEvent(QueuedInputEvent queuedInputEvent) {
            MotionEvent motionEvent = (MotionEvent) queuedInputEvent.mEvent;
            ViewRootImpl.this.mAttachInfo.mUnbufferedDispatchRequested = false;
            boolean dispatchPointerEvent = ViewRootImpl.this.mView.dispatchPointerEvent(motionEvent);
            if (ViewRootImpl.this.mAttachInfo.mUnbufferedDispatchRequested && !ViewRootImpl.this.mUnbufferedInputDispatch) {
                ViewRootImpl.this.mUnbufferedInputDispatch = true;
                if (ViewRootImpl.this.mConsumeBatchedInputScheduled) {
                    ViewRootImpl.this.scheduleConsumeBatchedInputImmediately();
                }
            }
            return dispatchPointerEvent ? 1 : 0;
        }

        private int processTrackballEvent(QueuedInputEvent queuedInputEvent) {
            return ViewRootImpl.this.mView.dispatchTrackballEvent((MotionEvent) queuedInputEvent.mEvent) ? 1 : 0;
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected void onDeliverToNext(QueuedInputEvent queuedInputEvent) {
            if (ViewRootImpl.this.mUnbufferedInputDispatch && (queuedInputEvent.mEvent instanceof MotionEvent) && ((MotionEvent) queuedInputEvent.mEvent).isTouchEvent() && ViewRootImpl.isTerminalInputEvent(queuedInputEvent.mEvent)) {
                ViewRootImpl.this.mUnbufferedInputDispatch = false;
                ViewRootImpl.this.scheduleConsumeBatchedInput();
            }
            super.onDeliverToNext(queuedInputEvent);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent queuedInputEvent) {
            if (queuedInputEvent.mEvent instanceof KeyEvent) {
                return processKeyEvent(queuedInputEvent);
            }
            ViewRootImpl.this.handleDispatchDoneAnimating();
            int source = queuedInputEvent.mEvent.getSource();
            return (source & 2) != 0 ? processPointerEvent(queuedInputEvent) : (source & 4) != 0 ? processTrackballEvent(queuedInputEvent) : processGenericMotionEvent(queuedInputEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$ViewPreImeInputStage.class */
    public final class ViewPreImeInputStage extends InputStage {
        public ViewPreImeInputStage(InputStage inputStage) {
            super(inputStage);
        }

        private int processKeyEvent(QueuedInputEvent queuedInputEvent) {
            return ViewRootImpl.this.mView.dispatchKeyEventPreIme((KeyEvent) queuedInputEvent.mEvent) ? 1 : 0;
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent queuedInputEvent) {
            if (queuedInputEvent.mEvent instanceof KeyEvent) {
                return processKeyEvent(queuedInputEvent);
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$ViewRootHandler.class */
    public final class ViewRootHandler extends Handler {
        ViewRootHandler() {
        }

        @Override // android.os.Handler
        public String getMessageName(Message message) {
            switch (message.what) {
                case 1:
                    return "MSG_INVALIDATE";
                case 2:
                    return "MSG_INVALIDATE_RECT";
                case 3:
                    return "MSG_DIE";
                case 4:
                    return "MSG_RESIZED";
                case 5:
                    return "MSG_RESIZED_REPORT";
                case 6:
                    return "MSG_WINDOW_FOCUS_CHANGED";
                case 7:
                    return "MSG_DISPATCH_INPUT_EVENT";
                case 8:
                    return "MSG_DISPATCH_APP_VISIBILITY";
                case 9:
                    return "MSG_DISPATCH_GET_NEW_SURFACE";
                case 10:
                case 20:
                case 23:
                default:
                    return super.getMessageName(message);
                case 11:
                    return "MSG_DISPATCH_KEY_FROM_IME";
                case 12:
                    return "MSG_FINISH_INPUT_CONNECTION";
                case 13:
                    return "MSG_CHECK_FOCUS";
                case 14:
                    return "MSG_CLOSE_SYSTEM_DIALOGS";
                case 15:
                    return "MSG_DISPATCH_DRAG_EVENT";
                case 16:
                    return "MSG_DISPATCH_DRAG_LOCATION_EVENT";
                case 17:
                    return "MSG_DISPATCH_SYSTEM_UI_VISIBILITY";
                case 18:
                    return "MSG_UPDATE_CONFIGURATION";
                case 19:
                    return "MSG_PROCESS_INPUT_EVENTS";
                case 21:
                    return "MSG_CLEAR_ACCESSIBILITY_FOCUS_HOST";
                case 22:
                    return "MSG_DISPATCH_DONE_ANIMATING";
                case 24:
                    return "MSG_WINDOW_MOVED";
                case 25:
                    return "MSG_SYNTHESIZE_INPUT_EVENT";
                case 26:
                    return "MSG_DISPATCH_WINDOW_SHOWN";
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((View) message.obj).invalidate();
                    return;
                case 2:
                    View.AttachInfo.InvalidateInfo invalidateInfo = (View.AttachInfo.InvalidateInfo) message.obj;
                    invalidateInfo.target.invalidate(invalidateInfo.left, invalidateInfo.top, invalidateInfo.right, invalidateInfo.bottom);
                    invalidateInfo.recycle();
                    return;
                case 3:
                    ViewRootImpl.this.doDie();
                    return;
                case 4:
                    SomeArgs someArgs = (SomeArgs) message.obj;
                    if (ViewRootImpl.this.mWinFrame.equals(someArgs.arg1) && ViewRootImpl.this.mPendingOverscanInsets.equals(someArgs.arg5) && ViewRootImpl.this.mPendingContentInsets.equals(someArgs.arg2) && ViewRootImpl.this.mPendingStableInsets.equals(someArgs.arg6) && ViewRootImpl.this.mPendingVisibleInsets.equals(someArgs.arg3) && someArgs.arg4 == null) {
                        return;
                    }
                    break;
                case 5:
                    break;
                case 6:
                    if (ViewRootImpl.this.mAdded) {
                        boolean z = message.arg1 != 0;
                        ViewRootImpl.this.mAttachInfo.mHasWindowFocus = z;
                        ViewRootImpl.this.profileRendering(z);
                        if (z) {
                            ViewRootImpl.this.ensureTouchModeLocally(message.arg2 != 0);
                            if (ViewRootImpl.this.mAttachInfo.mHardwareRenderer != null && ViewRootImpl.this.mSurface.isValid()) {
                                ViewRootImpl.this.mFullRedrawNeeded = true;
                                try {
                                    WindowManager.LayoutParams layoutParams = ViewRootImpl.this.mWindowAttributes;
                                    ViewRootImpl.this.mAttachInfo.mHardwareRenderer.initializeIfNeeded(ViewRootImpl.this.mWidth, ViewRootImpl.this.mHeight, ViewRootImpl.this.mSurface, layoutParams != null ? layoutParams.surfaceInsets : null);
                                } catch (Surface.OutOfResourcesException e) {
                                    Log.e(ViewRootImpl.TAG, "OutOfResourcesException locking surface", e);
                                    try {
                                        if (!ViewRootImpl.this.mWindowSession.outOfMemory(ViewRootImpl.this.mWindow)) {
                                            Slog.w(ViewRootImpl.TAG, "No processes killed for memory; killing self");
                                            Process.killProcess(Process.myPid());
                                        }
                                    } catch (RemoteException e2) {
                                    }
                                    sendMessageDelayed(obtainMessage(message.what, message.arg1, message.arg2), 500L);
                                    return;
                                }
                            }
                        }
                        ViewRootImpl.this.mLastWasImTarget = WindowManager.LayoutParams.mayUseInputMethod(ViewRootImpl.this.mWindowAttributes.flags);
                        InputMethodManager peekInstance = InputMethodManager.peekInstance();
                        if (ViewRootImpl.this.mView != null) {
                            if (z && peekInstance != null && ViewRootImpl.this.mLastWasImTarget && !ViewRootImpl.this.isInLocalFocusMode()) {
                                peekInstance.startGettingWindowFocus(ViewRootImpl.this.mView);
                            }
                            ViewRootImpl.this.mAttachInfo.mKeyDispatchState.reset();
                            ViewRootImpl.this.mView.dispatchWindowFocusChanged(z);
                            ViewRootImpl.this.mAttachInfo.mTreeObserver.dispatchOnWindowFocusChange(z);
                        }
                        if (z) {
                            if (peekInstance != null && ViewRootImpl.this.mLastWasImTarget && !ViewRootImpl.this.isInLocalFocusMode()) {
                                peekInstance.onWindowFocus(ViewRootImpl.this.mView, ViewRootImpl.this.mView.findFocus(), ViewRootImpl.this.mWindowAttributes.softInputMode, !ViewRootImpl.this.mHasHadWindowFocus, ViewRootImpl.this.mWindowAttributes.flags);
                            }
                            ViewRootImpl.this.mWindowAttributes.softInputMode &= -257;
                            ((WindowManager.LayoutParams) ViewRootImpl.this.mView.getLayoutParams()).softInputMode &= -257;
                            ViewRootImpl.this.mHasHadWindowFocus = true;
                        }
                        if (ViewRootImpl.this.mView != null && ViewRootImpl.this.mAccessibilityManager.isEnabled() && z) {
                            ViewRootImpl.this.mView.sendAccessibilityEvent(32);
                            return;
                        }
                        return;
                    }
                    return;
                case 7:
                    SomeArgs someArgs2 = (SomeArgs) message.obj;
                    ViewRootImpl.this.enqueueInputEvent((InputEvent) someArgs2.arg1, (InputEventReceiver) someArgs2.arg2, 0, true);
                    someArgs2.recycle();
                    return;
                case 8:
                    ViewRootImpl.this.handleAppVisibility(message.arg1 != 0);
                    return;
                case 9:
                    ViewRootImpl.this.handleGetNewSurface();
                    return;
                case 10:
                case 20:
                default:
                    return;
                case 11:
                    KeyEvent keyEvent = (KeyEvent) message.obj;
                    KeyEvent keyEvent2 = keyEvent;
                    if ((keyEvent.getFlags() & 8) != 0) {
                        keyEvent2 = KeyEvent.changeFlags(keyEvent, keyEvent.getFlags() & (-9));
                    }
                    ViewRootImpl.this.enqueueInputEvent(keyEvent2, null, 1, true);
                    return;
                case 12:
                    InputMethodManager peekInstance2 = InputMethodManager.peekInstance();
                    if (peekInstance2 != null) {
                        peekInstance2.reportFinishInputConnection((InputConnection) message.obj);
                        return;
                    }
                    return;
                case 13:
                    InputMethodManager peekInstance3 = InputMethodManager.peekInstance();
                    if (peekInstance3 != null) {
                        peekInstance3.checkFocus();
                        return;
                    }
                    return;
                case 14:
                    if (ViewRootImpl.this.mView != null) {
                        ViewRootImpl.this.mView.onCloseSystemDialogs((String) message.obj);
                        return;
                    }
                    return;
                case 15:
                case 16:
                    DragEvent dragEvent = (DragEvent) message.obj;
                    dragEvent.mLocalState = ViewRootImpl.this.mLocalDragState;
                    ViewRootImpl.this.handleDragEvent(dragEvent);
                    return;
                case 17:
                    ViewRootImpl.this.handleDispatchSystemUiVisibilityChanged((SystemUiVisibilityInfo) message.obj);
                    return;
                case 18:
                    Configuration configuration = (Configuration) message.obj;
                    Configuration configuration2 = configuration;
                    if (configuration.isOtherSeqNewer(ViewRootImpl.this.mLastConfiguration)) {
                        configuration2 = ViewRootImpl.this.mLastConfiguration;
                    }
                    ViewRootImpl.this.updateConfiguration(configuration2, false);
                    return;
                case 19:
                    ViewRootImpl.this.mProcessInputEventsScheduled = false;
                    ViewRootImpl.this.doProcessInputEvents();
                    return;
                case 21:
                    ViewRootImpl.this.setAccessibilityFocus(null, null);
                    return;
                case 22:
                    ViewRootImpl.this.handleDispatchDoneAnimating();
                    return;
                case 23:
                    if (ViewRootImpl.this.mView != null) {
                        ViewRootImpl.this.invalidateWorld(ViewRootImpl.this.mView);
                        return;
                    }
                    return;
                case 24:
                    if (ViewRootImpl.this.mAdded) {
                        int width = ViewRootImpl.this.mWinFrame.width();
                        int height = ViewRootImpl.this.mWinFrame.height();
                        int i = message.arg1;
                        int i2 = message.arg2;
                        ViewRootImpl.this.mWinFrame.left = i;
                        ViewRootImpl.this.mWinFrame.right = i + width;
                        ViewRootImpl.this.mWinFrame.top = i2;
                        ViewRootImpl.this.mWinFrame.bottom = i2 + height;
                        if (ViewRootImpl.this.mView != null) {
                            ViewRootImpl.forceLayout(ViewRootImpl.this.mView);
                        }
                        ViewRootImpl.this.requestLayout();
                        return;
                    }
                    return;
                case 25:
                    ViewRootImpl.this.enqueueInputEvent((InputEvent) message.obj, null, 32, true);
                    return;
                case 26:
                    ViewRootImpl.this.handleDispatchWindowShown();
                    return;
            }
            if (ViewRootImpl.this.mAdded) {
                SomeArgs someArgs3 = (SomeArgs) message.obj;
                Configuration configuration3 = (Configuration) someArgs3.arg4;
                if (configuration3 != null) {
                    ViewRootImpl.this.updateConfiguration(configuration3, false);
                }
                ViewRootImpl.this.mWinFrame.set((Rect) someArgs3.arg1);
                ViewRootImpl.this.mPendingOverscanInsets.set((Rect) someArgs3.arg5);
                ViewRootImpl.this.mPendingContentInsets.set((Rect) someArgs3.arg2);
                ViewRootImpl.this.mPendingStableInsets.set((Rect) someArgs3.arg6);
                ViewRootImpl.this.mPendingVisibleInsets.set((Rect) someArgs3.arg3);
                someArgs3.recycle();
                if (message.what == 5) {
                    ViewRootImpl.this.mReportNextDraw = true;
                }
                if (ViewRootImpl.this.mView != null) {
                    ViewRootImpl.forceLayout(ViewRootImpl.this.mView);
                }
                ViewRootImpl.this.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$W.class */
    public static class W extends IWindow.Stub {
        private final WeakReference<ViewRootImpl> mViewAncestor;
        private final IWindowSession mWindowSession;

        W(ViewRootImpl viewRootImpl) {
            this.mViewAncestor = new WeakReference<>(viewRootImpl);
            this.mWindowSession = viewRootImpl.mWindowSession;
        }

        private static int checkCallingPermission(String str) {
            try {
                return ActivityManagerNative.getDefault().checkPermission(str, Binder.getCallingPid(), Binder.getCallingUid());
            } catch (RemoteException e) {
                return -1;
            }
        }

        public void closeSystemDialogs(String str) {
            ViewRootImpl viewRootImpl = this.mViewAncestor.get();
            if (viewRootImpl != null) {
                viewRootImpl.dispatchCloseSystemDialogs(str);
            }
        }

        public void dispatchAppVisibility(boolean z) {
            ViewRootImpl viewRootImpl = this.mViewAncestor.get();
            if (viewRootImpl != null) {
                viewRootImpl.dispatchAppVisibility(z);
            }
        }

        public void dispatchDragEvent(DragEvent dragEvent) {
            ViewRootImpl viewRootImpl = this.mViewAncestor.get();
            if (viewRootImpl != null) {
                viewRootImpl.dispatchDragEvent(dragEvent);
            }
        }

        public void dispatchGetNewSurface() {
            ViewRootImpl viewRootImpl = this.mViewAncestor.get();
            if (viewRootImpl != null) {
                viewRootImpl.dispatchGetNewSurface();
            }
        }

        public void dispatchSystemUiVisibilityChanged(int i, int i2, int i3, int i4) {
            ViewRootImpl viewRootImpl = this.mViewAncestor.get();
            if (viewRootImpl != null) {
                viewRootImpl.dispatchSystemUiVisibilityChanged(i, i2, i3, i4);
            }
        }

        public void dispatchWallpaperCommand(String str, int i, int i2, int i3, Bundle bundle, boolean z) {
            if (z) {
                try {
                    this.mWindowSession.wallpaperCommandComplete(asBinder(), (Bundle) null);
                } catch (RemoteException e) {
                }
            }
        }

        public void dispatchWallpaperOffsets(float f, float f2, float f3, float f4, boolean z) {
            if (z) {
                try {
                    this.mWindowSession.wallpaperOffsetsComplete(asBinder());
                } catch (RemoteException e) {
                }
            }
        }

        public void dispatchWindowShown() {
            ViewRootImpl viewRootImpl = this.mViewAncestor.get();
            if (viewRootImpl != null) {
                viewRootImpl.dispatchWindowShown();
            }
        }

        public void doneAnimating() {
            ViewRootImpl viewRootImpl = this.mViewAncestor.get();
            if (viewRootImpl != null) {
                viewRootImpl.dispatchDoneAnimating();
            }
        }

        public void executeCommand(String str, String str2, ParcelFileDescriptor parcelFileDescriptor) {
            View view;
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
            ViewRootImpl viewRootImpl = this.mViewAncestor.get();
            if (viewRootImpl == null || (view = viewRootImpl.mView) == null) {
                return;
            }
            if (checkCallingPermission("android.permission.DUMP") != 0) {
                throw new SecurityException("Insufficient permissions to invoke executeCommand() from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
            }
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = null;
            try {
                try {
                    ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream3 = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
                    try {
                        ViewDebug.dispatchCommand(view, str, str2, autoCloseOutputStream3);
                        if (autoCloseOutputStream3 != null) {
                            try {
                                autoCloseOutputStream3.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        autoCloseOutputStream = autoCloseOutputStream3;
                        autoCloseOutputStream2 = autoCloseOutputStream;
                        e.printStackTrace();
                        if (autoCloseOutputStream != null) {
                            try {
                                autoCloseOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        autoCloseOutputStream2 = autoCloseOutputStream3;
                        if (autoCloseOutputStream2 != null) {
                            try {
                                autoCloseOutputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e5) {
                e = e5;
                autoCloseOutputStream = null;
            }
        }

        public void moved(int i, int i2) {
            ViewRootImpl viewRootImpl = this.mViewAncestor.get();
            if (viewRootImpl != null) {
                viewRootImpl.dispatchMoved(i, i2);
            }
        }

        public void resized(Rect rect, Rect rect2, Rect rect3, Rect rect4, Rect rect5, boolean z, Configuration configuration) {
            ViewRootImpl viewRootImpl = this.mViewAncestor.get();
            if (viewRootImpl != null) {
                viewRootImpl.dispatchResized(rect, rect2, rect3, rect4, rect5, z, configuration);
            }
        }

        public void windowFocusChanged(boolean z, boolean z2) {
            ViewRootImpl viewRootImpl = this.mViewAncestor.get();
            if (viewRootImpl != null) {
                viewRootImpl.windowFocusChanged(z, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewRootImpl$WindowInputEventReceiver.class */
    public final class WindowInputEventReceiver extends InputEventReceiver {
        public WindowInputEventReceiver(InputChannel inputChannel, Looper looper) {
            super(inputChannel, looper);
        }

        public void dispose() {
            ViewRootImpl.this.unscheduleConsumeBatchedInput();
            super.dispose();
        }

        public void onBatchedInputEventPending() {
            if (ViewRootImpl.this.mUnbufferedInputDispatch) {
                super.onBatchedInputEventPending();
            } else {
                ViewRootImpl.this.scheduleConsumeBatchedInput();
            }
        }

        public void onInputEvent(InputEvent inputEvent) {
            ViewRootImpl.this.enqueueInputEvent(inputEvent, this, 0, true);
        }
    }

    public ViewRootImpl(Context context, Display display) {
        this.mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ? new InputEventConsistencyVerifier(this, 0) : null;
        this.mProfile = false;
        this.mDisplayListener = new DisplayManager.DisplayListener() { // from class: android.view.ViewRootImpl.1
            private int toViewScreenState(int i) {
                int i2 = 1;
                if (i == 1) {
                    i2 = 0;
                }
                return i2;
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i) {
                int i2;
                int state;
                if (ViewRootImpl.this.mView == null || ViewRootImpl.this.mDisplay.getDisplayId() != i || (i2 = ViewRootImpl.this.mAttachInfo.mDisplayState) == (state = ViewRootImpl.this.mDisplay.getState())) {
                    return;
                }
                ViewRootImpl.this.mAttachInfo.mDisplayState = state;
                if (i2 != 0) {
                    int viewScreenState = toViewScreenState(i2);
                    int viewScreenState2 = toViewScreenState(state);
                    if (viewScreenState != viewScreenState2) {
                        ViewRootImpl.this.mView.dispatchScreenStateChanged(viewScreenState2);
                    }
                    if (i2 == 1) {
                        ViewRootImpl.this.mFullRedrawNeeded = true;
                        ViewRootImpl.this.scheduleTraversals();
                    }
                }
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i) {
            }
        };
        this.mResizePaint = new Paint();
        this.mHandler = new ViewRootHandler();
        this.mTraversalRunnable = new TraversalRunnable();
        this.mConsumedBatchedInputRunnable = new ConsumeBatchedInputRunnable();
        this.mConsumeBatchedInputImmediatelyRunnable = new ConsumeBatchedInputImmediatelyRunnable();
        this.mInvalidateOnAnimationRunnable = new InvalidateOnAnimationRunnable();
        this.mContext = context;
        this.mWindowSession = WindowManagerGlobal.getWindowSession();
        this.mDisplay = display;
        this.mBasePackageName = context.getBasePackageName();
        this.mDisplayAdjustments = display.getDisplayAdjustments();
        this.mThread = Thread.currentThread();
        this.mLocation = new WindowLeaked(null);
        this.mLocation.fillInStackTrace();
        this.mWidth = -1;
        this.mHeight = -1;
        this.mDirty = new Rect();
        this.mTempRect = new Rect();
        this.mVisRect = new Rect();
        this.mWinFrame = new Rect();
        this.mWindow = new W(this);
        this.mTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        this.mViewVisibility = 8;
        this.mTransparentRegion = new Region();
        this.mPreviousTransparentRegion = new Region();
        this.mFirst = true;
        this.mAdded = false;
        this.mAttachInfo = new View.AttachInfo(this.mWindowSession, this.mWindow, display, this, this.mHandler, this);
        this.mAccessibilityManager = AccessibilityManager.getInstance(context);
        this.mAccessibilityInteractionConnectionManager = new AccessibilityInteractionConnectionManager();
        this.mAccessibilityManager.addAccessibilityStateChangeListener(this.mAccessibilityInteractionConnectionManager);
        this.mHighContrastTextManager = new HighContrastTextManager();
        this.mAccessibilityManager.addHighTextContrastStateChangeListener(this.mHighContrastTextManager);
        this.mViewConfiguration = ViewConfiguration.get(context);
        this.mDensity = context.getResources().getDisplayMetrics().densityDpi;
        this.mNoncompatDensity = context.getResources().getDisplayMetrics().noncompatDensityDpi;
        this.mFallbackEventHandler = PolicyManager.makeNewFallbackEventHandler(context);
        this.mChoreographer = Choreographer.getInstance();
        this.mDisplayManager = (DisplayManager) context.getSystemService("display");
        loadSystemProperties();
        this.mWindowIsRound = context.getResources().getBoolean(R.bool.config_windowIsRound);
    }

    public static void addConfigCallback(ComponentCallbacks componentCallbacks) {
        synchronized (sConfigCallbacks) {
            sConfigCallbacks.add(componentCallbacks);
        }
    }

    public static void addFirstDrawHandler(Runnable runnable) {
        synchronized (sFirstDrawHandlers) {
            if (!sFirstDrawComplete) {
                sFirstDrawHandlers.add(runnable);
            }
        }
    }

    private void applyKeepScreenOnFlag(WindowManager.LayoutParams layoutParams) {
        if (this.mAttachInfo.mKeepScreenOn) {
            layoutParams.flags |= 128;
        } else {
            layoutParams.flags = (layoutParams.flags & (-129)) | (this.mClientWindowLayoutFlags & 128);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkForLeavingTouchModeAndConsume(KeyEvent keyEvent) {
        if (this.mAttachInfo.mInTouchMode) {
            int action = keyEvent.getAction();
            if ((action == 0 || action == 2) && (keyEvent.getFlags() & 4) == 0) {
                if (isNavigationKey(keyEvent)) {
                    return ensureTouchMode(false);
                }
                if (isTypingKey(keyEvent)) {
                    ensureTouchMode(false);
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x009a, code lost:
        if (r5.mAttachInfo.mHasSystemUiListeners != r0.hasSystemUiListeners) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean collectViewAttributes() {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.collectViewAttributes():boolean");
    }

    private void deliverInputEvent(QueuedInputEvent queuedInputEvent) {
        Trace.asyncTraceBegin(8L, "deliverInputEvent", queuedInputEvent.mEvent.getSequenceNumber());
        if (this.mInputEventConsistencyVerifier != null) {
            this.mInputEventConsistencyVerifier.onInputEvent(queuedInputEvent.mEvent, 0);
        }
        InputStage inputStage = queuedInputEvent.shouldSendToSynthesizer() ? this.mSyntheticInputStage : queuedInputEvent.shouldSkipIme() ? this.mFirstPostImeInputStage : this.mFirstInputStage;
        if (inputStage != null) {
            inputStage.deliver(queuedInputEvent);
        } else {
            finishInputEvent(queuedInputEvent);
        }
    }

    private void destroyHardwareRenderer() {
        HardwareRenderer hardwareRenderer = this.mAttachInfo.mHardwareRenderer;
        if (hardwareRenderer != null) {
            if (this.mView != null) {
                hardwareRenderer.destroyHardwareResources(this.mView);
            }
            hardwareRenderer.destroy();
            hardwareRenderer.setRequested(false);
            this.mAttachInfo.mHardwareRenderer = null;
            this.mAttachInfo.mHardwareAccelerated = false;
        }
    }

    private void draw(boolean z) {
        Surface surface = this.mSurface;
        if (surface.isValid()) {
            if (!sFirstDrawComplete) {
                synchronized (sFirstDrawHandlers) {
                    sFirstDrawComplete = true;
                    int size = sFirstDrawHandlers.size();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        this.mHandler.post(sFirstDrawHandlers.get(i2));
                        i = i2 + 1;
                    }
                }
            }
            scrollToRectOrFocus(null, false);
            if (this.mAttachInfo.mViewScrollChanged) {
                this.mAttachInfo.mViewScrollChanged = false;
                this.mAttachInfo.mTreeObserver.dispatchOnScrollChanged();
            }
            boolean z2 = this.mScroller != null && this.mScroller.computeScrollOffset();
            int currY = z2 ? this.mScroller.getCurrY() : this.mScrollY;
            if (this.mCurScrollY != currY) {
                this.mCurScrollY = currY;
                z = true;
                if (this.mView instanceof RootViewSurfaceTaker) {
                    ((RootViewSurfaceTaker) this.mView).onRootViewScrollYChanged(this.mCurScrollY);
                    z = true;
                }
            }
            float f = this.mAttachInfo.mApplicationScale;
            boolean z3 = this.mAttachInfo.mScalingRequired;
            boolean z4 = z2;
            int i3 = 0;
            if (this.mResizeBuffer != null) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.mResizeBufferStartTime;
                if (uptimeMillis < this.mResizeBufferDuration) {
                    z4 = true;
                    i3 = 255 - ((int) (255.0f * mResizeInterpolator.getInterpolation(((float) uptimeMillis) / this.mResizeBufferDuration)));
                } else {
                    disposeResizeBuffer();
                    z4 = z2;
                    i3 = 0;
                }
            }
            Rect rect = this.mDirty;
            if (this.mSurfaceHolder != null) {
                rect.setEmpty();
                if (z4) {
                    if (this.mScroller != null) {
                        this.mScroller.abortAnimation();
                    }
                    disposeResizeBuffer();
                    return;
                }
                return;
            }
            if (z) {
                this.mAttachInfo.mIgnoreDirtyState = true;
                rect.set(0, 0, (int) ((this.mWidth * f) + 0.5f), (int) ((this.mHeight * f) + 0.5f));
            }
            this.mAttachInfo.mTreeObserver.dispatchOnDraw();
            int i4 = 0;
            WindowManager.LayoutParams layoutParams = this.mWindowAttributes;
            Rect rect2 = layoutParams != null ? layoutParams.surfaceInsets : null;
            int i5 = currY;
            if (rect2 != null) {
                i4 = 0 - rect2.left;
                i5 = currY - rect2.top;
                rect.offset(rect2.left, rect2.right);
            }
            Drawable drawable = this.mAttachInfo.mAccessibilityFocusDrawable;
            boolean z5 = false;
            if (drawable != null) {
                Rect rect3 = this.mAttachInfo.mTmpInvalRect;
                if (!getAccessibilityFocusedRect(rect3)) {
                    rect3.setEmpty();
                }
                z5 = false;
                if (!rect3.equals(drawable.getBounds())) {
                    z5 = true;
                }
            }
            if (!rect.isEmpty() || this.mIsAnimating || z5) {
                if (this.mAttachInfo.mHardwareRenderer != null && this.mAttachInfo.mHardwareRenderer.isEnabled()) {
                    this.mIsAnimating = false;
                    if (this.mHardwareYOffset != i5 || this.mHardwareXOffset != i4) {
                        this.mHardwareYOffset = i5;
                        this.mHardwareXOffset = i4;
                        z5 = true;
                    }
                    this.mResizeAlpha = i3;
                    if (this.mSurface.isValid() && rect != null) {
                        this.mSurface.setDirtyRect(rect);
                    }
                    if (z5) {
                        this.mAttachInfo.mHardwareRenderer.invalidateRoot();
                    }
                    rect.setEmpty();
                    this.mBlockResizeBuffer = false;
                    this.mAttachInfo.mHardwareRenderer.draw(this.mView, this.mAttachInfo, this);
                } else if (this.mAttachInfo.mHardwareRenderer != null && !this.mAttachInfo.mHardwareRenderer.isEnabled() && this.mAttachInfo.mHardwareRenderer.isRequested()) {
                    try {
                        this.mAttachInfo.mHardwareRenderer.initializeIfNeeded(this.mWidth, this.mHeight, this.mSurface, rect2);
                        this.mFullRedrawNeeded = true;
                        scheduleTraversals();
                        return;
                    } catch (Surface.OutOfResourcesException e) {
                        handleOutOfResourcesException(e);
                        return;
                    }
                } else if (!drawSoftware(surface, this.mAttachInfo, i4, i5, z3, rect)) {
                    return;
                }
            }
            if (z4) {
                this.mFullRedrawNeeded = true;
                scheduleTraversals();
            }
        }
    }

    private void drawAccessibilityFocusedDrawableIfNeeded(Canvas canvas) {
        Rect rect = this.mAttachInfo.mTmpInvalRect;
        if (!getAccessibilityFocusedRect(rect)) {
            if (this.mAttachInfo.mAccessibilityFocusDrawable != null) {
                this.mAttachInfo.mAccessibilityFocusDrawable.setBounds(0, 0, 0, 0);
                return;
            }
            return;
        }
        Drawable accessibilityFocusedDrawable = getAccessibilityFocusedDrawable();
        if (accessibilityFocusedDrawable != null) {
            accessibilityFocusedDrawable.setBounds(rect);
            accessibilityFocusedDrawable.draw(canvas);
        }
    }

    private boolean drawSoftware(Surface surface, View.AttachInfo attachInfo, int i, int i2, boolean z, Rect rect) {
        try {
            int i3 = rect.left;
            int i4 = rect.top;
            int i5 = rect.right;
            int i6 = rect.bottom;
            Canvas lockCanvas = this.mSurface.lockCanvas(rect);
            if (i3 != rect.left || i4 != rect.top || i5 != rect.right || i6 != rect.bottom) {
                attachInfo.mIgnoreDirtyState = true;
            }
            lockCanvas.setDensity(this.mDensity);
            try {
                if (!lockCanvas.isOpaque() || i2 != 0 || i != 0) {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                rect.setEmpty();
                this.mIsAnimating = false;
                attachInfo.mDrawingTime = SystemClock.uptimeMillis();
                this.mView.mPrivateFlags |= 32;
                lockCanvas.translate(-i, -i2);
                if (this.mTranslator != null) {
                    this.mTranslator.translateCanvas(lockCanvas);
                }
                lockCanvas.setScreenDensity(z ? this.mNoncompatDensity : 0);
                attachInfo.mSetIgnoreDirtyState = false;
                this.mView.draw(lockCanvas);
                drawAccessibilityFocusedDrawableIfNeeded(lockCanvas);
                if (!attachInfo.mSetIgnoreDirtyState) {
                    attachInfo.mIgnoreDirtyState = false;
                }
                try {
                    surface.unlockCanvasAndPost(lockCanvas);
                    return true;
                } catch (IllegalArgumentException e) {
                    Log.e(TAG, "Could not unlock surface", e);
                    this.mLayoutRequested = true;
                    return false;
                }
            } catch (Throwable th) {
                try {
                    surface.unlockCanvasAndPost(lockCanvas);
                    throw th;
                } catch (IllegalArgumentException e2) {
                    Log.e(TAG, "Could not unlock surface", e2);
                    this.mLayoutRequested = true;
                    return false;
                }
            }
        } catch (Surface.OutOfResourcesException e3) {
            handleOutOfResourcesException(e3);
            return false;
        } catch (IllegalArgumentException e4) {
            Log.e(TAG, "Could not lock surface", e4);
            this.mLayoutRequested = true;
            return false;
        }
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(view.toString());
        if (!(view instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) view).getChildCount()) <= 0) {
            return;
        }
        String str2 = str + "  ";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            dumpViewHierarchy(str2, printWriter, viewGroup.getChildAt(i2));
            i = i2 + 1;
        }
    }

    private void enableHardwareAcceleration(WindowManager.LayoutParams layoutParams) {
        this.mAttachInfo.mHardwareAccelerated = false;
        this.mAttachInfo.mHardwareAccelerationRequested = false;
        if (this.mTranslator != null) {
            return;
        }
        if (((layoutParams.flags & 16777216) != 0) && HardwareRenderer.isAvailable()) {
            boolean z = (layoutParams.privateFlags & 1) != 0;
            boolean z2 = (layoutParams.privateFlags & 2) != 0;
            if (z) {
                this.mAttachInfo.mHardwareAccelerationRequested = true;
            } else if (!HardwareRenderer.sRendererDisabled || (HardwareRenderer.sSystemRendererDisabled && z2)) {
                if (this.mAttachInfo.mHardwareRenderer != null) {
                    this.mAttachInfo.mHardwareRenderer.destroy();
                }
                Rect rect = layoutParams.surfaceInsets;
                this.mAttachInfo.mHardwareRenderer = HardwareRenderer.create(this.mContext, layoutParams.format != -1 || (rect.left != 0 || rect.right != 0 || rect.top != 0 || rect.bottom != 0));
                if (this.mAttachInfo.mHardwareRenderer != null) {
                    this.mAttachInfo.mHardwareRenderer.setName(layoutParams.getTitle().toString());
                    View.AttachInfo attachInfo = this.mAttachInfo;
                    this.mAttachInfo.mHardwareAccelerationRequested = true;
                    attachInfo.mHardwareAccelerated = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ensureTouchModeLocally(boolean z) {
        if (this.mAttachInfo.mInTouchMode == z) {
            return false;
        }
        this.mAttachInfo.mInTouchMode = z;
        this.mAttachInfo.mTreeObserver.dispatchOnTouchModeChanged(z);
        return z ? enterTouchMode() : leaveTouchMode();
    }

    private boolean enterTouchMode() {
        View findFocus;
        if (this.mView == null || !this.mView.hasFocus() || (findFocus = this.mView.findFocus()) == null || findFocus.isFocusableInTouchMode()) {
            return false;
        }
        ViewGroup findAncestorToTakeFocusInTouchMode = findAncestorToTakeFocusInTouchMode(findFocus);
        if (findAncestorToTakeFocusInTouchMode != null) {
            return findAncestorToTakeFocusInTouchMode.requestFocus();
        }
        findFocus.clearFocusInternal(null, true, false);
        return true;
    }

    private static ViewGroup findAncestorToTakeFocusInTouchMode(View view) {
        ViewParent parent = view.getParent();
        while (true) {
            ViewParent viewParent = parent;
            if (!(viewParent instanceof ViewGroup)) {
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) viewParent;
            if (viewGroup.getDescendantFocusability() == 262144 && viewGroup.isFocusableInTouchMode()) {
                return viewGroup;
            }
            if (viewGroup.isRootNamespace()) {
                return null;
            }
            parent = viewGroup.getParent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishInputEvent(QueuedInputEvent queuedInputEvent) {
        Trace.asyncTraceEnd(8L, "deliverInputEvent", queuedInputEvent.mEvent.getSequenceNumber());
        if (queuedInputEvent.mReceiver != null) {
            queuedInputEvent.mReceiver.finishInputEvent(queuedInputEvent.mEvent, (queuedInputEvent.mFlags & 8) != 0);
        } else {
            queuedInputEvent.mEvent.recycleIfNeededAfterDispatch();
        }
        recycleQueuedInputEvent(queuedInputEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void forceLayout(View view) {
        view.forceLayout();
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
            forceLayout(viewGroup.getChildAt(i2));
            i = i2 + 1;
        }
    }

    private Drawable getAccessibilityFocusedDrawable() {
        if (this.mAttachInfo.mAccessibilityFocusDrawable == null) {
            TypedValue typedValue = new TypedValue();
            if (this.mView.mContext.getTheme().resolveAttribute(R.attr.accessibilityFocusedDrawable, typedValue, true)) {
                this.mAttachInfo.mAccessibilityFocusDrawable = this.mView.mContext.getDrawable(typedValue.resourceId);
            }
        }
        return this.mAttachInfo.mAccessibilityFocusDrawable;
    }

    private boolean getAccessibilityFocusedRect(Rect rect) {
        View view;
        boolean z = true;
        AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(this.mView.mContext);
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (view = this.mAccessibilityFocusedHost) == null || view.mAttachInfo == null) {
            return false;
        }
        if (view.getAccessibilityNodeProvider() == null) {
            view.getBoundsOnScreen(rect, true);
        } else if (this.mAccessibilityFocusedVirtualView == null) {
            return false;
        } else {
            this.mAccessibilityFocusedVirtualView.getBoundsInScreen(rect);
        }
        View.AttachInfo attachInfo = this.mAttachInfo;
        rect.offset(-attachInfo.mWindowLeft, -attachInfo.mWindowTop);
        rect.intersect(0, 0, attachInfo.mViewRootImpl.mWidth, attachInfo.mViewRootImpl.mHeight);
        if (rect.isEmpty()) {
            z = false;
        }
        return z;
    }

    private AudioManager getAudioManager() {
        if (this.mView == null) {
            throw new IllegalStateException("getAudioManager called when there is no mView");
        }
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mView.getContext().getSystemService("audio");
        }
        return this.mAudioManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getCommonPredecessor(View view, View view2) {
        if (this.mTempHashSet == null) {
            this.mTempHashSet = new HashSet<>();
        }
        HashSet<View> hashSet = this.mTempHashSet;
        hashSet.clear();
        while (view != null) {
            hashSet.add(view);
            ViewParent viewParent = view.mParent;
            view = viewParent instanceof View ? (View) viewParent : null;
        }
        View view3 = view2;
        while (true) {
            View view4 = view3;
            if (view4 == null) {
                hashSet.clear();
                return null;
            } else if (hashSet.contains(view4)) {
                hashSet.clear();
                return view4;
            } else {
                ViewParent viewParent2 = view4.mParent;
                view3 = viewParent2 instanceof View ? (View) viewParent2 : null;
            }
        }
    }

    private static void getGfxInfo(View view, int[] iArr) {
        RenderNode renderNode = view.mRenderNode;
        iArr[0] = iArr[0] + 1;
        if (renderNode != null) {
            iArr[1] = iArr[1] + renderNode.getDebugSize();
        }
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
            getGfxInfo(viewGroup.getChildAt(i2), iArr);
            i = i2 + 1;
        }
    }

    private int getImpliedSystemUiVisibility(WindowManager.LayoutParams layoutParams) {
        int i = 0;
        if ((layoutParams.flags & 67108864) != 0) {
            i = 0 | GL10.GL_INVALID_ENUM;
        }
        int i2 = i;
        if ((layoutParams.flags & 134217728) != 0) {
            i2 = i | GL10.GL_SRC_COLOR;
        }
        return i2;
    }

    private static int getRootMeasureSpec(int i, int i2) {
        switch (i2) {
            case -2:
                return View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
            case -1:
                return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
            default:
                return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RunQueue getRunQueue() {
        RunQueue runQueue = sRunQueues.get();
        if (runQueue != null) {
            return runQueue;
        }
        RunQueue runQueue2 = new RunQueue();
        sRunQueues.set(runQueue2);
        return runQueue2;
    }

    private ArrayList<View> getValidLayoutRequesters(ArrayList<View> arrayList, boolean z) {
        boolean z2;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = null;
        int i = 0;
        while (i < size) {
            View view = arrayList.get(i);
            ArrayList<View> arrayList3 = arrayList2;
            if (view != null) {
                arrayList3 = arrayList2;
                if (view.mAttachInfo != null) {
                    arrayList3 = arrayList2;
                    if (view.mParent != null) {
                        if (!z) {
                            arrayList3 = arrayList2;
                            if ((view.mPrivateFlags & 4096) != 4096) {
                            }
                        }
                        View view2 = view;
                        while (true) {
                            View view3 = view2;
                            z2 = false;
                            if (view3 == null) {
                                break;
                            } else if ((view3.mViewFlags & 12) == 8) {
                                z2 = true;
                                break;
                            } else {
                                view2 = view3.mParent instanceof View ? (View) view3.mParent : null;
                            }
                        }
                        arrayList3 = arrayList2;
                        if (!z2) {
                            arrayList3 = arrayList2;
                            if (arrayList2 == null) {
                                arrayList3 = new ArrayList<>();
                            }
                            arrayList3.add(view);
                        }
                    }
                }
            }
            i++;
            arrayList2 = arrayList3;
        }
        if (!z) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                View view4 = arrayList.get(i3);
                while (true) {
                    View view5 = view4;
                    if (view5 != null && (view5.mPrivateFlags & 4096) != 0) {
                        view5.mPrivateFlags &= -4097;
                        view4 = view5.mParent instanceof View ? (View) view5.mParent : null;
                    }
                }
                i2 = i3 + 1;
            }
        }
        arrayList.clear();
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDragEvent(DragEvent dragEvent) {
        if (this.mView != null && this.mAdded) {
            int i = dragEvent.mAction;
            if (i == 6) {
                this.mView.dispatchDragEvent(dragEvent);
            } else {
                if (i == 1) {
                    this.mCurrentDragView = null;
                    this.mDragDescription = dragEvent.mClipDescription;
                } else {
                    dragEvent.mClipDescription = this.mDragDescription;
                }
                if (i == 2 || i == 3) {
                    this.mDragPoint.set(dragEvent.mX, dragEvent.mY);
                    if (this.mTranslator != null) {
                        this.mTranslator.translatePointInScreenToAppWindow(this.mDragPoint);
                    }
                    if (this.mCurScrollY != 0) {
                        this.mDragPoint.offset(0.0f, this.mCurScrollY);
                    }
                    dragEvent.mX = this.mDragPoint.x;
                    dragEvent.mY = this.mDragPoint.y;
                }
                View view = this.mCurrentDragView;
                boolean dispatchDragEvent = this.mView.dispatchDragEvent(dragEvent);
                if (view != this.mCurrentDragView) {
                    if (view != null) {
                        try {
                            this.mWindowSession.dragRecipientExited(this.mWindow);
                        } catch (RemoteException e) {
                            Slog.e(TAG, "Unable to note drag target change");
                        }
                    }
                    if (this.mCurrentDragView != null) {
                        this.mWindowSession.dragRecipientEntered(this.mWindow);
                    }
                }
                if (i == 3) {
                    this.mDragDescription = null;
                    try {
                        Log.i(TAG, "Reporting drop result: " + dispatchDragEvent);
                        this.mWindowSession.reportDropResult(this.mWindow, dispatchDragEvent);
                    } catch (RemoteException e2) {
                        Log.e(TAG, "Unable to report drop result");
                    }
                }
                if (i == 4) {
                    setLocalDragState(null);
                }
            }
        }
        dragEvent.recycle();
    }

    private void handleOutOfResourcesException(Surface.OutOfResourcesException outOfResourcesException) {
        Log.e(TAG, "OutOfResourcesException initializing HW surface", outOfResourcesException);
        try {
            if (!this.mWindowSession.outOfMemory(this.mWindow) && Process.myUid() != 1000) {
                Slog.w(TAG, "No processes killed for memory; killing self");
                Process.killProcess(Process.myPid());
            }
        } catch (RemoteException e) {
        }
        this.mLayoutRequested = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInLocalFocusMode() {
        return (this.mWindowAttributes.flags & 268435456) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isInTouchMode() {
        IWindowSession peekWindowSession = WindowManagerGlobal.peekWindowSession();
        if (peekWindowSession != null) {
            try {
                return peekWindowSession.getInTouchMode();
            } catch (RemoteException e) {
                return false;
            }
        }
        return false;
    }

    private static boolean isNavigationKey(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 61:
            case 62:
            case 66:
            case 92:
            case 93:
            case 122:
            case 123:
                return true;
            default:
                return false;
        }
    }

    static boolean isTerminalInputEvent(InputEvent inputEvent) {
        boolean z = false;
        if (inputEvent instanceof KeyEvent) {
            return ((KeyEvent) inputEvent).getAction() == 1;
        }
        int action = ((MotionEvent) inputEvent).getAction();
        if (action == 1 || action == 3 || action == 10) {
            z = true;
        }
        return z;
    }

    private static boolean isTypingKey(KeyEvent keyEvent) {
        return keyEvent.getUnicodeChar() > 0;
    }

    public static boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && isViewDescendantOf((View) parent, view2);
    }

    private boolean leaveTouchMode() {
        if (this.mView != null) {
            if (this.mView.hasFocus()) {
                View findFocus = this.mView.findFocus();
                if (!(findFocus instanceof ViewGroup) || ((ViewGroup) findFocus).getDescendantFocusability() != 262144) {
                    return false;
                }
            }
            View focusSearch = focusSearch(null, 130);
            if (focusSearch != null) {
                return focusSearch.requestFocus(130);
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b5, code lost:
        if (r5.mHeight != r6.getMeasuredHeight()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean measureHierarchy(android.view.View r6, android.view.WindowManager.LayoutParams r7, android.content.res.Resources r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.measureHierarchy(android.view.View, android.view.WindowManager$LayoutParams, android.content.res.Resources, int, int):boolean");
    }

    private QueuedInputEvent obtainQueuedInputEvent(InputEvent inputEvent, InputEventReceiver inputEventReceiver, int i) {
        QueuedInputEvent queuedInputEvent = this.mQueuedInputEventPool;
        if (queuedInputEvent != null) {
            this.mQueuedInputEventPoolSize--;
            this.mQueuedInputEventPool = queuedInputEvent.mNext;
            queuedInputEvent.mNext = null;
        } else {
            queuedInputEvent = new QueuedInputEvent();
        }
        queuedInputEvent.mEvent = inputEvent;
        queuedInputEvent.mReceiver = inputEventReceiver;
        queuedInputEvent.mFlags = i;
        return queuedInputEvent;
    }

    private void performDraw() {
        if (this.mAttachInfo.mDisplayState != 1 || this.mReportNextDraw) {
            boolean z = this.mFullRedrawNeeded;
            this.mFullRedrawNeeded = false;
            this.mIsDrawing = true;
            Trace.traceBegin(8L, "draw");
            try {
                draw(z);
                this.mIsDrawing = false;
                Trace.traceEnd(8L);
                if (this.mAttachInfo.mPendingAnimatingRenderNodes != null) {
                    int size = this.mAttachInfo.mPendingAnimatingRenderNodes.size();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        this.mAttachInfo.mPendingAnimatingRenderNodes.get(i2).endAllAnimators();
                        i = i2 + 1;
                    }
                    this.mAttachInfo.mPendingAnimatingRenderNodes.clear();
                }
                if (this.mReportNextDraw) {
                    this.mReportNextDraw = false;
                    if (this.mAttachInfo.mHardwareRenderer != null) {
                        this.mAttachInfo.mHardwareRenderer.fence();
                    }
                    if (this.mSurfaceHolder != null && this.mSurface.isValid()) {
                        this.mSurfaceHolderCallback.surfaceRedrawNeeded(this.mSurfaceHolder);
                        SurfaceHolder.Callback[] callbacks = this.mSurfaceHolder.getCallbacks();
                        if (callbacks != null) {
                            int length = callbacks.length;
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 < length) {
                                    SurfaceHolder.Callback callback = callbacks[i4];
                                    if (callback instanceof SurfaceHolder.Callback2) {
                                        ((SurfaceHolder.Callback2) callback).surfaceRedrawNeeded(this.mSurfaceHolder);
                                    }
                                    i3 = i4 + 1;
                                }
                            }
                        }
                    }
                    try {
                        this.mWindowSession.finishDrawing(this.mWindow);
                    } catch (RemoteException e) {
                    }
                }
            } catch (Throwable th) {
                this.mIsDrawing = false;
                Trace.traceEnd(8L);
                throw th;
            }
        }
    }

    private void performLayout(WindowManager.LayoutParams layoutParams, int i, int i2) {
        ArrayList<View> validLayoutRequesters;
        this.mLayoutRequested = false;
        this.mScrollMayChange = true;
        this.mInLayout = true;
        View view = this.mView;
        Trace.traceBegin(8L, "layout");
        try {
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            this.mInLayout = false;
            if (this.mLayoutRequesters.size() > 0 && (validLayoutRequesters = getValidLayoutRequesters(this.mLayoutRequesters, false)) != null) {
                this.mHandlingLayoutInLayoutRequest = true;
                int size = validLayoutRequesters.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size) {
                        break;
                    }
                    View view2 = validLayoutRequesters.get(i4);
                    Log.w("View", "requestLayout() improperly called by " + view2 + " during layout: running second layout pass");
                    view2.requestLayout();
                    i3 = i4 + 1;
                }
                measureHierarchy(view, layoutParams, this.mView.getContext().getResources(), i, i2);
                this.mInLayout = true;
                view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                this.mHandlingLayoutInLayoutRequest = false;
                final ArrayList<View> validLayoutRequesters2 = getValidLayoutRequesters(this.mLayoutRequesters, true);
                if (validLayoutRequesters2 != null) {
                    getRunQueue().post(new Runnable() { // from class: android.view.ViewRootImpl.2
                        @Override // java.lang.Runnable
                        public void run() {
                            int size2 = validLayoutRequesters2.size();
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= size2) {
                                    return;
                                }
                                View view3 = (View) validLayoutRequesters2.get(i6);
                                Log.w("View", "requestLayout() improperly called by " + view3 + " during second layout pass: posting in next frame");
                                view3.requestLayout();
                                i5 = i6 + 1;
                            }
                        }
                    });
                }
            }
            Trace.traceEnd(8L);
            this.mInLayout = false;
        } catch (Throwable th) {
            Trace.traceEnd(8L);
            throw th;
        }
    }

    private void performMeasure(int i, int i2) {
        Trace.traceBegin(8L, "measure");
        try {
            this.mView.measure(i, i2);
            Trace.traceEnd(8L);
        } catch (Throwable th) {
            Trace.traceEnd(8L);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:305:0x0860, code lost:
        if (r8.mLastOverscanRequested != r8.mAttachInfo.mOverscanRequested) goto L590;
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x0d5e, code lost:
        if (r20 != false) goto L513;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0231, code lost:
        if (r8.mAttachInfo.mViewVisibilityChanged != false) goto L607;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02de, code lost:
        if (r0 != r8.mHeight) goto L630;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0374, code lost:
        if (r0.height == (-2)) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0984  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x09a9  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x0cab  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0cfd  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0d24  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void performTraversals() {
        /*
            Method dump skipped, instructions count: 4652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.performTraversals():void");
    }

    private void postSendWindowContentChangedCallback(View view, int i) {
        if (this.mSendWindowContentChangedAccessibilityEvent == null) {
            this.mSendWindowContentChangedAccessibilityEvent = new SendWindowContentChangedAccessibilityEvent();
        }
        this.mSendWindowContentChangedAccessibilityEvent.runOrPost(view, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void profileRendering(boolean z) {
        if (this.mProfileRendering) {
            this.mRenderProfilingEnabled = z;
            if (this.mRenderProfiler != null) {
                this.mChoreographer.removeFrameCallback(this.mRenderProfiler);
            }
            if (!this.mRenderProfilingEnabled) {
                this.mRenderProfiler = null;
                return;
            }
            if (this.mRenderProfiler == null) {
                this.mRenderProfiler = new Choreographer.FrameCallback() { // from class: android.view.ViewRootImpl.3
                    @Override // android.view.Choreographer.FrameCallback
                    public void doFrame(long j) {
                        ViewRootImpl.this.mDirty.set(0, 0, ViewRootImpl.this.mWidth, ViewRootImpl.this.mHeight);
                        ViewRootImpl.this.scheduleTraversals();
                        if (ViewRootImpl.this.mRenderProfilingEnabled) {
                            ViewRootImpl.this.mChoreographer.postFrameCallback(ViewRootImpl.this.mRenderProfiler);
                        }
                    }
                };
            }
            this.mChoreographer.postFrameCallback(this.mRenderProfiler);
        }
    }

    private void recycleQueuedInputEvent(QueuedInputEvent queuedInputEvent) {
        queuedInputEvent.mEvent = null;
        queuedInputEvent.mReceiver = null;
        if (this.mQueuedInputEventPoolSize < 10) {
            this.mQueuedInputEventPoolSize++;
            queuedInputEvent.mNext = this.mQueuedInputEventPool;
            this.mQueuedInputEventPool = queuedInputEvent;
        }
    }

    private int relayoutWindow(WindowManager.LayoutParams layoutParams, int i, boolean z) throws RemoteException {
        float f = this.mAttachInfo.mApplicationScale;
        boolean z2 = false;
        if (layoutParams != null) {
            z2 = false;
            if (this.mTranslator != null) {
                z2 = true;
                layoutParams.backup();
                this.mTranslator.translateWindowLayout(layoutParams);
            }
        }
        if (layoutParams != null) {
        }
        this.mPendingConfiguration.seq = 0;
        if (layoutParams != null && this.mOrigWindowType != layoutParams.type && this.mTargetSdkVersion < 14) {
            Slog.w(TAG, "Window type can not be changed after the window is added; ignoring change of " + this.mView);
            layoutParams.type = this.mOrigWindowType;
        }
        int relayout = this.mWindowSession.relayout(this.mWindow, this.mSeq, layoutParams, (int) ((this.mView.getMeasuredWidth() * f) + 0.5f), (int) ((this.mView.getMeasuredHeight() * f) + 0.5f), i, z ? 1 : 0, this.mWinFrame, this.mPendingOverscanInsets, this.mPendingContentInsets, this.mPendingVisibleInsets, this.mPendingStableInsets, this.mPendingConfiguration, this.mSurface);
        if (z2) {
            layoutParams.restore();
        }
        if (this.mTranslator != null) {
            this.mTranslator.translateRectInScreenToAppWinFrame(this.mWinFrame);
            this.mTranslator.translateRectInScreenToAppWindow(this.mPendingOverscanInsets);
            this.mTranslator.translateRectInScreenToAppWindow(this.mPendingContentInsets);
            this.mTranslator.translateRectInScreenToAppWindow(this.mPendingVisibleInsets);
            this.mTranslator.translateRectInScreenToAppWindow(this.mPendingStableInsets);
        }
        return relayout;
    }

    private void removeSendWindowContentChangedCallback() {
        if (this.mSendWindowContentChangedAccessibilityEvent != null) {
            this.mHandler.removeCallbacks(this.mSendWindowContentChangedAccessibilityEvent);
        }
    }

    private void scheduleProcessInputEvents() {
        if (this.mProcessInputEventsScheduled) {
            return;
        }
        this.mProcessInputEventsScheduled = true;
        Message obtainMessage = this.mHandler.obtainMessage(19);
        obtainMessage.setAsynchronous(true);
        this.mHandler.sendMessage(obtainMessage);
    }

    private void trackFPS() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mFpsStartTime < 0) {
            this.mFpsPrevTime = currentTimeMillis;
            this.mFpsStartTime = currentTimeMillis;
            this.mFpsNumFrames = 0;
            return;
        }
        this.mFpsNumFrames++;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        long j = this.mFpsPrevTime;
        long j2 = currentTimeMillis - this.mFpsStartTime;
        Log.v(TAG, "0x" + hexString + "\tFrame time:\t" + (currentTimeMillis - j));
        this.mFpsPrevTime = currentTimeMillis;
        if (j2 > 1000) {
            Log.v(TAG, "0x" + hexString + "\tFPS:\t" + ((this.mFpsNumFrames * 1000.0f) / ((float) j2)));
            this.mFpsStartTime = currentTimeMillis;
            this.mFpsNumFrames = 0;
        }
    }

    @Override // android.view.ViewParent
    public void bringChildToFront(View view) {
    }

    @Override // android.view.ViewParent
    public boolean canResolveLayoutDirection() {
        return true;
    }

    @Override // android.view.ViewParent
    public boolean canResolveTextAlignment() {
        return true;
    }

    @Override // android.view.ViewParent
    public boolean canResolveTextDirection() {
        return true;
    }

    public void cancelInvalidate(View view) {
        this.mHandler.removeMessages(1, view);
        this.mHandler.removeMessages(2, view);
        this.mInvalidateOnAnimationRunnable.removeView(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeCanvasOpacity(boolean z) {
        Log.d(TAG, "changeCanvasOpacity: opaque=" + z);
        if (this.mAttachInfo.mHardwareRenderer != null) {
            this.mAttachInfo.mHardwareRenderer.setOpaque(z);
        }
    }

    void checkThread() {
        if (this.mThread != Thread.currentThread()) {
            throw new CalledFromWrongThreadException("Only the original thread that created a view hierarchy can touch its views.");
        }
    }

    @Override // android.view.ViewParent
    public void childDrawableStateChanged(View view) {
    }

    @Override // android.view.ViewParent
    public void childHasTransientStateChanged(View view, boolean z) {
    }

    @Override // android.view.ViewParent
    public void clearChildFocus(View view) {
        checkThread();
        scheduleTraversals();
    }

    @Override // android.view.ViewParent
    public void createContextMenu(ContextMenu contextMenu) {
    }

    public void debug() {
        this.mView.debug();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroyHardwareResources() {
        if (this.mAttachInfo.mHardwareRenderer != null) {
            this.mAttachInfo.mHardwareRenderer.destroyHardwareResources(this.mView);
            this.mAttachInfo.mHardwareRenderer.destroy();
        }
    }

    public void detachFunctor(long j) {
        this.mBlockResizeBuffer = true;
        if (this.mAttachInfo.mHardwareRenderer != null) {
            this.mAttachInfo.mHardwareRenderer.stopDrawing();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean die(boolean z) {
        if (z && !this.mIsInTraversal) {
            doDie();
            return false;
        }
        if (this.mIsDrawing) {
            Log.e(TAG, "Attempting to destroy the window while drawing!\n  window=" + this + ", title=" + ((Object) this.mWindowAttributes.getTitle()));
        } else {
            destroyHardwareRenderer();
        }
        this.mHandler.sendEmptyMessage(3);
        return true;
    }

    public void dispatchAppVisibility(boolean z) {
        Message obtainMessage = this.mHandler.obtainMessage(8);
        obtainMessage.arg1 = z ? 1 : 0;
        this.mHandler.sendMessage(obtainMessage);
    }

    void dispatchApplyInsets(View view) {
        this.mDispatchContentInsets.set(this.mAttachInfo.mContentInsets);
        this.mDispatchStableInsets.set(this.mAttachInfo.mStableInsets);
        view.dispatchApplyWindowInsets(new WindowInsets(this.mDispatchContentInsets, null, this.mDispatchStableInsets, (this.mIsEmulator && this.mIsCircularEmulator) || this.mWindowIsRound));
    }

    public void dispatchCheckFocus() {
        if (this.mHandler.hasMessages(13)) {
            return;
        }
        this.mHandler.sendEmptyMessage(13);
    }

    public void dispatchCloseSystemDialogs(String str) {
        Message obtain = Message.obtain();
        obtain.what = 14;
        obtain.obj = str;
        this.mHandler.sendMessage(obtain);
    }

    void dispatchDetachedFromWindow() {
        if (this.mView != null && this.mView.mAttachInfo != null) {
            this.mAttachInfo.mTreeObserver.dispatchOnWindowAttachedChange(false);
            this.mView.dispatchDetachedFromWindow();
        }
        this.mAccessibilityInteractionConnectionManager.ensureNoConnection();
        this.mAccessibilityManager.removeAccessibilityStateChangeListener(this.mAccessibilityInteractionConnectionManager);
        this.mAccessibilityManager.removeHighTextContrastStateChangeListener(this.mHighContrastTextManager);
        removeSendWindowContentChangedCallback();
        destroyHardwareRenderer();
        setAccessibilityFocus(null, null);
        this.mView.assignParent(null);
        this.mView = null;
        this.mAttachInfo.mRootView = null;
        this.mSurface.release();
        if (this.mInputQueueCallback != null && this.mInputQueue != null) {
            this.mInputQueueCallback.onInputQueueDestroyed(this.mInputQueue);
            this.mInputQueue.dispose();
            this.mInputQueueCallback = null;
            this.mInputQueue = null;
        }
        if (this.mInputEventReceiver != null) {
            this.mInputEventReceiver.dispose();
            this.mInputEventReceiver = null;
        }
        try {
            this.mWindowSession.remove(this.mWindow);
        } catch (RemoteException e) {
        }
        if (this.mInputChannel != null) {
            this.mInputChannel.dispose();
            this.mInputChannel = null;
        }
        this.mDisplayManager.unregisterDisplayListener(this.mDisplayListener);
        unscheduleTraversals();
    }

    public void dispatchDoneAnimating() {
        this.mHandler.sendEmptyMessage(22);
    }

    public void dispatchDragEvent(DragEvent dragEvent) {
        int i;
        if (dragEvent.getAction() == 2) {
            i = 16;
            this.mHandler.removeMessages(16);
        } else {
            i = 15;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(i, dragEvent));
    }

    public void dispatchFinishInputConnection(InputConnection inputConnection) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(12, inputConnection));
    }

    public void dispatchGetNewSurface() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(9));
    }

    public void dispatchInputEvent(InputEvent inputEvent) {
        dispatchInputEvent(inputEvent, null);
    }

    public void dispatchInputEvent(InputEvent inputEvent, InputEventReceiver inputEventReceiver) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.arg1 = inputEvent;
        obtain.arg2 = inputEventReceiver;
        Message obtainMessage = this.mHandler.obtainMessage(7, obtain);
        obtainMessage.setAsynchronous(true);
        this.mHandler.sendMessage(obtainMessage);
    }

    public void dispatchInvalidateDelayed(View view, long j) {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, view), j);
    }

    public void dispatchInvalidateOnAnimation(View view) {
        this.mInvalidateOnAnimationRunnable.addView(view);
    }

    public void dispatchInvalidateRectDelayed(View.AttachInfo.InvalidateInfo invalidateInfo, long j) {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2, invalidateInfo), j);
    }

    public void dispatchInvalidateRectOnAnimation(View.AttachInfo.InvalidateInfo invalidateInfo) {
        this.mInvalidateOnAnimationRunnable.addViewRect(invalidateInfo);
    }

    public void dispatchKeyFromIme(KeyEvent keyEvent) {
        Message obtainMessage = this.mHandler.obtainMessage(11, keyEvent);
        obtainMessage.setAsynchronous(true);
        this.mHandler.sendMessage(obtainMessage);
    }

    public void dispatchMoved(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.mTranslator != null) {
            PointF pointF = new PointF(i, i2);
            this.mTranslator.translatePointInScreenToAppWindow(pointF);
            i3 = (int) (pointF.x + 0.5d);
            i4 = (int) (pointF.y + 0.5d);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(24, i3, i4));
    }

    public void dispatchResized(Rect rect, Rect rect2, Rect rect3, Rect rect4, Rect rect5, boolean z, Configuration configuration) {
        Message obtainMessage = this.mHandler.obtainMessage(z ? 5 : 4);
        if (this.mTranslator != null) {
            this.mTranslator.translateRectInScreenToAppWindow(rect);
            this.mTranslator.translateRectInScreenToAppWindow(rect2);
            this.mTranslator.translateRectInScreenToAppWindow(rect3);
            this.mTranslator.translateRectInScreenToAppWindow(rect4);
        }
        SomeArgs obtain = SomeArgs.obtain();
        boolean z2 = Binder.getCallingPid() == Process.myPid();
        Rect rect6 = rect;
        if (z2) {
            rect6 = new Rect(rect);
        }
        obtain.arg1 = rect6;
        Rect rect7 = rect3;
        if (z2) {
            rect7 = new Rect(rect3);
        }
        obtain.arg2 = rect7;
        Rect rect8 = rect4;
        if (z2) {
            rect8 = new Rect(rect4);
        }
        obtain.arg3 = rect8;
        Configuration configuration2 = configuration;
        if (z2) {
            configuration2 = configuration;
            if (configuration != null) {
                configuration2 = new Configuration(configuration);
            }
        }
        obtain.arg4 = configuration2;
        Rect rect9 = rect2;
        if (z2) {
            rect9 = new Rect(rect2);
        }
        obtain.arg5 = rect9;
        Rect rect10 = rect5;
        if (z2) {
            rect10 = new Rect(rect5);
        }
        obtain.arg6 = rect10;
        obtainMessage.obj = obtain;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void dispatchSystemUiVisibilityChanged(int i, int i2, int i3, int i4) {
        SystemUiVisibilityInfo systemUiVisibilityInfo = new SystemUiVisibilityInfo();
        systemUiVisibilityInfo.seq = i;
        systemUiVisibilityInfo.globalVisibility = i2;
        systemUiVisibilityInfo.localValue = i3;
        systemUiVisibilityInfo.localChanges = i4;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(17, systemUiVisibilityInfo));
    }

    public void dispatchUnhandledInputEvent(InputEvent inputEvent) {
        MotionEvent motionEvent = inputEvent;
        if (inputEvent instanceof MotionEvent) {
            motionEvent = MotionEvent.obtain((MotionEvent) inputEvent);
        }
        synthesizeInputEvent(motionEvent);
    }

    public void dispatchWindowShown() {
        this.mHandler.sendEmptyMessage(26);
    }

    void disposeResizeBuffer() {
        if (this.mResizeBuffer != null) {
            this.mResizeBuffer.destroy();
            this.mResizeBuffer = null;
        }
    }

    void doConsumeBatchedInput(long j) {
        if (this.mConsumeBatchedInputScheduled) {
            this.mConsumeBatchedInputScheduled = false;
            if (this.mInputEventReceiver != null && this.mInputEventReceiver.consumeBatchedInputEvents(j) && j != -1) {
                scheduleConsumeBatchedInput();
            }
            doProcessInputEvents();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDie() {
        boolean z = true;
        checkThread();
        synchronized (this) {
            if (this.mRemoved) {
                return;
            }
            this.mRemoved = true;
            if (this.mAdded) {
                dispatchDetachedFromWindow();
            }
            if (this.mAdded && !this.mFirst) {
                destroyHardwareRenderer();
                if (this.mView != null) {
                    int visibility = this.mView.getVisibility();
                    if (this.mViewVisibility == visibility) {
                        z = false;
                    }
                    if (this.mWindowAttributesChanged || z) {
                        try {
                            if ((relayoutWindow(this.mWindowAttributes, visibility, false) & 2) != 0) {
                                this.mWindowSession.finishDrawing(this.mWindow);
                            }
                        } catch (RemoteException e) {
                        }
                    }
                    this.mSurface.release();
                }
            }
            this.mAdded = false;
            WindowManagerGlobal.getInstance().doRemoveView(this);
        }
    }

    void doProcessInputEvents() {
        while (this.mPendingInputEventHead != null) {
            QueuedInputEvent queuedInputEvent = this.mPendingInputEventHead;
            this.mPendingInputEventHead = queuedInputEvent.mNext;
            if (this.mPendingInputEventHead == null) {
                this.mPendingInputEventTail = null;
            }
            queuedInputEvent.mNext = null;
            this.mPendingInputEventCount--;
            Trace.traceCounter(4L, this.mPendingInputEventQueueLengthCounterName, this.mPendingInputEventCount);
            deliverInputEvent(queuedInputEvent);
        }
        if (this.mProcessInputEventsScheduled) {
            this.mProcessInputEventsScheduled = false;
            this.mHandler.removeMessages(19);
        }
    }

    void doTraversal() {
        if (this.mTraversalScheduled) {
            this.mTraversalScheduled = false;
            this.mHandler.getLooper().removeSyncBarrier(this.mTraversalBarrier);
            if (this.mProfile) {
                Debug.startMethodTracing("ViewAncestor");
            }
            Trace.traceBegin(8L, "performTraversals");
            try {
                performTraversals();
                Trace.traceEnd(8L);
                if (this.mProfile) {
                    Debug.stopMethodTracing();
                    this.mProfile = false;
                }
            } catch (Throwable th) {
                Trace.traceEnd(8L);
                throw th;
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "  ";
        printWriter.print(str);
        printWriter.println("ViewRoot:");
        printWriter.print(str2);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoved=");
        printWriter.println(this.mRemoved);
        printWriter.print(str2);
        printWriter.print("mConsumeBatchedInputScheduled=");
        printWriter.println(this.mConsumeBatchedInputScheduled);
        printWriter.print(str2);
        printWriter.print("mConsumeBatchedInputImmediatelyScheduled=");
        printWriter.println(this.mConsumeBatchedInputImmediatelyScheduled);
        printWriter.print(str2);
        printWriter.print("mPendingInputEventCount=");
        printWriter.println(this.mPendingInputEventCount);
        printWriter.print(str2);
        printWriter.print("mProcessInputEventsScheduled=");
        printWriter.println(this.mProcessInputEventsScheduled);
        printWriter.print(str2);
        printWriter.print("mTraversalScheduled=");
        printWriter.print(this.mTraversalScheduled);
        if (this.mTraversalScheduled) {
            printWriter.print(" (barrier=");
            printWriter.print(this.mTraversalBarrier);
            printWriter.println(")");
        } else {
            printWriter.println();
        }
        this.mFirstInputStage.dump(str2, printWriter);
        this.mChoreographer.dump(str, printWriter);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        dumpViewHierarchy(str2, printWriter, this.mView);
    }

    public void dumpGfxInfo(int[] iArr) {
        iArr[1] = 0;
        iArr[0] = 0;
        if (this.mView != null) {
            getGfxInfo(this.mView, iArr);
        }
    }

    void enqueueInputEvent(InputEvent inputEvent) {
        enqueueInputEvent(inputEvent, null, 0, false);
    }

    void enqueueInputEvent(InputEvent inputEvent, InputEventReceiver inputEventReceiver, int i, boolean z) {
        QueuedInputEvent obtainQueuedInputEvent = obtainQueuedInputEvent(inputEvent, inputEventReceiver, i);
        QueuedInputEvent queuedInputEvent = this.mPendingInputEventTail;
        if (queuedInputEvent == null) {
            this.mPendingInputEventHead = obtainQueuedInputEvent;
            this.mPendingInputEventTail = obtainQueuedInputEvent;
        } else {
            queuedInputEvent.mNext = obtainQueuedInputEvent;
            this.mPendingInputEventTail = obtainQueuedInputEvent;
        }
        this.mPendingInputEventCount++;
        Trace.traceCounter(4L, this.mPendingInputEventQueueLengthCounterName, this.mPendingInputEventCount);
        if (z) {
            doProcessInputEvents();
        } else {
            scheduleProcessInputEvents();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ensureTouchMode(boolean z) {
        if (this.mAttachInfo.mInTouchMode == z) {
            return false;
        }
        try {
            if (!isInLocalFocusMode()) {
                this.mWindowSession.setInTouchMode(z);
            }
            return ensureTouchModeLocally(z);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.view.ViewParent
    public View focusSearch(View view, int i) {
        checkThread();
        if (this.mView instanceof ViewGroup) {
            return FocusFinder.getInstance().findNextFocus((ViewGroup) this.mView, view, i);
        }
        return null;
    }

    @Override // android.view.ViewParent
    public void focusableViewAvailable(View view) {
        checkThread();
        if (this.mView != null) {
            if (!this.mView.hasFocus()) {
                view.requestFocus();
                return;
            }
            View findFocus = this.mView.findFocus();
            if ((findFocus instanceof ViewGroup) && ((ViewGroup) findFocus).getDescendantFocusability() == 262144 && isViewDescendantOf(view, findFocus)) {
                view.requestFocus();
            }
        }
    }

    public View getAccessibilityFocusedHost() {
        return this.mAccessibilityFocusedHost;
    }

    public AccessibilityNodeInfo getAccessibilityFocusedVirtualView() {
        return this.mAccessibilityFocusedVirtualView;
    }

    public AccessibilityInteractionController getAccessibilityInteractionController() {
        if (this.mView == null) {
            throw new IllegalStateException("getAccessibilityInteractionController called when there is no mView");
        }
        if (this.mAccessibilityInteractionController == null) {
            this.mAccessibilityInteractionController = new AccessibilityInteractionController(this);
        }
        return this.mAccessibilityInteractionController;
    }

    @Override // android.view.ViewParent
    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        if (view != this.mView) {
            throw new RuntimeException("child is not mine, honest!");
        }
        return rect.intersect(0, 0, this.mWidth, this.mHeight);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHostVisibility() {
        if (this.mAppVisible) {
            return this.mView.getVisibility();
        }
        return 8;
    }

    public void getLastTouchPoint(Point point) {
        point.x = (int) this.mLastTouchPoint.x;
        point.y = (int) this.mLastTouchPoint.y;
    }

    @Override // android.view.ViewParent
    public int getLayoutDirection() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final WindowLeaked getLocation() {
        return this.mLocation;
    }

    @Override // android.view.ViewParent
    public ViewParent getParent() {
        return null;
    }

    @Override // android.view.ViewParent
    public ViewParent getParentForAccessibility() {
        return null;
    }

    @Override // android.view.ViewParent
    public int getTextAlignment() {
        return 1;
    }

    @Override // android.view.ViewParent
    public int getTextDirection() {
        return 1;
    }

    public View getView() {
        return this.mView;
    }

    void handleAppVisibility(boolean z) {
        if (this.mAppVisible != z) {
            this.mAppVisible = z;
            scheduleTraversals();
            if (this.mAppVisible) {
                return;
            }
            WindowManagerGlobal.trimForeground();
        }
    }

    public void handleDispatchDoneAnimating() {
        if (this.mWindowsAnimating) {
            this.mWindowsAnimating = false;
            if (!this.mDirty.isEmpty() || this.mIsAnimating || this.mFullRedrawNeeded) {
                scheduleTraversals();
            }
        }
    }

    public void handleDispatchSystemUiVisibilityChanged(SystemUiVisibilityInfo systemUiVisibilityInfo) {
        if (this.mSeq != systemUiVisibilityInfo.seq) {
            this.mSeq = systemUiVisibilityInfo.seq;
            this.mAttachInfo.mForceReportNewAttributes = true;
            scheduleTraversals();
        }
        if (this.mView == null) {
            return;
        }
        if (systemUiVisibilityInfo.localChanges != 0) {
            this.mView.updateLocalSystemUiVisibility(systemUiVisibilityInfo.localValue, systemUiVisibilityInfo.localChanges);
        }
        int i = systemUiVisibilityInfo.globalVisibility & 7;
        if (i != this.mAttachInfo.mGlobalSystemUiVisibility) {
            this.mAttachInfo.mGlobalSystemUiVisibility = i;
            this.mView.dispatchSystemUiVisibilityChanged(i);
        }
    }

    public void handleDispatchWindowShown() {
        this.mAttachInfo.mTreeObserver.dispatchOnWindowShown();
    }

    void handleGetNewSurface() {
        this.mNewSurfaceNeeded = true;
        this.mFullRedrawNeeded = true;
        scheduleTraversals();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidate() {
        this.mDirty.set(0, 0, this.mWidth, this.mHeight);
        if (this.mWillDrawSoon) {
            return;
        }
        scheduleTraversals();
    }

    @Override // android.view.ViewParent
    public void invalidateChild(View view, Rect rect) {
        invalidateChildInParent(null, rect);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        if (r7.mTranslator != null) goto L33;
     */
    @Override // android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.ViewParent invalidateChildInParent(int[] r8, android.graphics.Rect r9) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.invalidateChildInParent(int[], android.graphics.Rect):android.view.ViewParent");
    }

    void invalidateWorld(View view) {
        view.invalidate();
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            invalidateWorld(viewGroup.getChildAt(i2));
            i = i2 + 1;
        }
    }

    public void invokeFunctor(long j, boolean z) {
        ThreadedRenderer.invokeFunctor(j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInLayout() {
        return this.mInLayout;
    }

    @Override // android.view.ViewParent
    public boolean isLayoutDirectionResolved() {
        return true;
    }

    @Override // android.view.ViewParent
    public boolean isLayoutRequested() {
        return this.mLayoutRequested;
    }

    @Override // android.view.ViewParent
    public boolean isTextAlignmentResolved() {
        return true;
    }

    @Override // android.view.ViewParent
    public boolean isTextDirectionResolved() {
        return true;
    }

    public void loadSystemProperties() {
        this.mHandler.post(new Runnable() { // from class: android.view.ViewRootImpl.4
            @Override // java.lang.Runnable
            public void run() {
                ViewRootImpl.this.mProfileRendering = SystemProperties.getBoolean(ViewRootImpl.PROPERTY_PROFILE_RENDERING, false);
                ViewRootImpl.this.profileRendering(ViewRootImpl.this.mAttachInfo.mHasWindowFocus);
                ViewRootImpl.this.mMediaDisabled = SystemProperties.getBoolean(ViewRootImpl.PROPERTY_MEDIA_DISABLED, false);
                if (ViewRootImpl.this.mAttachInfo.mHardwareRenderer != null && ViewRootImpl.this.mAttachInfo.mHardwareRenderer.loadSystemProperties()) {
                    ViewRootImpl.this.invalidate();
                }
                boolean z = SystemProperties.getBoolean(View.DEBUG_LAYOUT_PROPERTY, false);
                if (z != ViewRootImpl.this.mAttachInfo.mDebugLayout) {
                    ViewRootImpl.this.mAttachInfo.mDebugLayout = z;
                    if (!ViewRootImpl.this.mHandler.hasMessages(23)) {
                        ViewRootImpl.this.mHandler.sendEmptyMessageDelayed(23, 200L);
                    }
                }
                ViewRootImpl.this.mIsEmulator = Build.HARDWARE.contains("goldfish");
                ViewRootImpl.this.mIsCircularEmulator = SystemProperties.getBoolean(ViewRootImpl.PROPERTY_EMULATOR_CIRCULAR, false);
            }
        });
    }

    void notifyRendererOfFramePending() {
        if (this.mAttachInfo.mHardwareRenderer != null) {
            this.mAttachInfo.mHardwareRenderer.notifyFramePending();
        }
    }

    @Override // android.view.ViewParent
    public void notifySubtreeAccessibilityStateChanged(View view, View view2, int i) {
        postSendWindowContentChangedCallback(view2, i);
    }

    public void onHardwarePostDraw(HardwareCanvas hardwareCanvas) {
        if (this.mResizeBuffer != null) {
            this.mResizePaint.setAlpha(this.mResizeAlpha);
            hardwareCanvas.drawHardwareLayer(this.mResizeBuffer, this.mHardwareXOffset, this.mHardwareYOffset, this.mResizePaint);
        }
        drawAccessibilityFocusedDrawableIfNeeded(hardwareCanvas);
    }

    public void onHardwarePreDraw(HardwareCanvas hardwareCanvas) {
        hardwareCanvas.translate(-this.mHardwareXOffset, -this.mHardwareYOffset);
    }

    @Override // android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewParent
    public boolean onNestedPrePerformAccessibilityAction(View view, int i, Bundle bundle) {
        return false;
    }

    @Override // android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
    }

    @Override // android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return false;
    }

    @Override // android.view.ViewParent
    public void onStopNestedScroll(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void outputDisplayList(View view) {
        RenderNode displayList = view.getDisplayList();
        if (displayList != null) {
            displayList.output();
        }
    }

    @Override // android.view.View.AttachInfo.Callbacks
    public boolean performHapticFeedback(int i, boolean z) {
        try {
            return this.mWindowSession.performHapticFeedback(this.mWindow, i, z);
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.View.AttachInfo.Callbacks
    public void playSoundEffect(int i) {
        checkThread();
        if (this.mMediaDisabled) {
            return;
        }
        try {
            AudioManager audioManager = getAudioManager();
            switch (i) {
                case 0:
                    audioManager.playSoundEffect(0);
                    return;
                case 1:
                    audioManager.playSoundEffect(3);
                    return;
                case 2:
                    audioManager.playSoundEffect(1);
                    return;
                case 3:
                    audioManager.playSoundEffect(4);
                    return;
                case 4:
                    audioManager.playSoundEffect(2);
                    return;
                default:
                    throw new IllegalArgumentException("unknown effect id " + i + " not defined in " + SoundEffectConstants.class.getCanonicalName());
            }
        } catch (IllegalStateException e) {
            Log.e(TAG, "FATAL EXCEPTION when attempting to play sound effect: " + e);
            e.printStackTrace();
        }
    }

    public void profile() {
        this.mProfile = true;
    }

    @Override // android.view.ViewParent
    public void recomputeViewAttributes(View view) {
        checkThread();
        if (this.mView == view) {
            this.mAttachInfo.mRecomputeGlobalAttributes = true;
            if (this.mWillDrawSoon) {
                return;
            }
            scheduleTraversals();
        }
    }

    public void registerAnimatingRenderNode(RenderNode renderNode) {
        if (this.mAttachInfo.mHardwareRenderer != null) {
            this.mAttachInfo.mHardwareRenderer.registerAnimatingRenderNode(renderNode);
            return;
        }
        if (this.mAttachInfo.mPendingAnimatingRenderNodes == null) {
            this.mAttachInfo.mPendingAnimatingRenderNodes = new ArrayList();
        }
        this.mAttachInfo.mPendingAnimatingRenderNodes.add(renderNode);
    }

    @Override // android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        checkThread();
        scheduleTraversals();
    }

    @Override // android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        boolean scrollToRectOrFocus = scrollToRectOrFocus(rect, z);
        if (rect != null) {
            this.mTempRect.set(rect);
            this.mTempRect.offset(0, -this.mCurScrollY);
            this.mTempRect.offset(this.mAttachInfo.mWindowLeft, this.mAttachInfo.mWindowTop);
            try {
                this.mWindowSession.onRectangleOnScreenRequested(this.mWindow, this.mTempRect);
            } catch (RemoteException e) {
                return scrollToRectOrFocus;
            }
        }
        return scrollToRectOrFocus;
    }

    @Override // android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // android.view.ViewParent
    public void requestFitSystemWindows() {
        checkThread();
        this.mApplyInsetsRequested = true;
        scheduleTraversals();
    }

    @Override // android.view.ViewParent
    public void requestLayout() {
        if (this.mHandlingLayoutInLayoutRequest) {
            return;
        }
        checkThread();
        this.mLayoutRequested = true;
        scheduleTraversals();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean requestLayoutDuringLayout(View view) {
        if (view.mParent == null || view.mAttachInfo == null) {
            return true;
        }
        if (!this.mLayoutRequesters.contains(view)) {
            this.mLayoutRequesters.add(view);
        }
        return !this.mHandlingLayoutInLayoutRequest;
    }

    @Override // android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        AccessibilityNodeProvider accessibilityNodeProvider2;
        if (this.mView == null) {
            return false;
        }
        switch (accessibilityEvent.getEventType()) {
            case 2048:
                if (this.mAccessibilityFocusedHost != null && this.mAccessibilityFocusedVirtualView != null && AccessibilityNodeInfo.getAccessibilityViewId(accessibilityEvent.getSourceNodeId()) == this.mAccessibilityFocusedHost.getAccessibilityViewId()) {
                    int contentChangeTypes = accessibilityEvent.getContentChangeTypes();
                    if (((contentChangeTypes & 1) != 0 || contentChangeTypes == 0) && (accessibilityNodeProvider = this.mAccessibilityFocusedHost.getAccessibilityNodeProvider()) != null) {
                        int virtualDescendantId = AccessibilityNodeInfo.getVirtualDescendantId(this.mAccessibilityFocusedVirtualView.getSourceNodeId());
                        if (virtualDescendantId != Integer.MAX_VALUE) {
                            this.mAccessibilityFocusedVirtualView = accessibilityNodeProvider.createAccessibilityNodeInfo(virtualDescendantId);
                            break;
                        } else {
                            this.mAccessibilityFocusedVirtualView = accessibilityNodeProvider.createAccessibilityNodeInfo(-1);
                            break;
                        }
                    }
                }
                break;
            case 32768:
                long sourceNodeId = accessibilityEvent.getSourceNodeId();
                View findViewByAccessibilityId = this.mView.findViewByAccessibilityId(AccessibilityNodeInfo.getAccessibilityViewId(sourceNodeId));
                if (findViewByAccessibilityId != null && (accessibilityNodeProvider2 = findViewByAccessibilityId.getAccessibilityNodeProvider()) != null) {
                    int virtualDescendantId2 = AccessibilityNodeInfo.getVirtualDescendantId(sourceNodeId);
                    setAccessibilityFocus(findViewByAccessibilityId, virtualDescendantId2 == Integer.MAX_VALUE ? accessibilityNodeProvider2.createAccessibilityNodeInfo(-1) : accessibilityNodeProvider2.createAccessibilityNodeInfo(virtualDescendantId2));
                    break;
                }
                break;
            case 65536:
                View findViewByAccessibilityId2 = this.mView.findViewByAccessibilityId(AccessibilityNodeInfo.getAccessibilityViewId(accessibilityEvent.getSourceNodeId()));
                if (findViewByAccessibilityId2 != null && findViewByAccessibilityId2.getAccessibilityNodeProvider() != null) {
                    setAccessibilityFocus(null, null);
                    break;
                }
                break;
        }
        this.mAccessibilityManager.sendAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void requestTransitionStart(LayoutTransition layoutTransition) {
        if (this.mPendingTransitions == null || !this.mPendingTransitions.contains(layoutTransition)) {
            if (this.mPendingTransitions == null) {
                this.mPendingTransitions = new ArrayList<>();
            }
            this.mPendingTransitions.add(layoutTransition);
        }
    }

    @Override // android.view.ViewParent
    public void requestTransparentRegion(View view) {
        checkThread();
        if (this.mView == view) {
            this.mView.mPrivateFlags |= 512;
            this.mWindowAttributesChanged = true;
            this.mWindowAttributesChangesFlag = 0;
            requestLayout();
        }
    }

    public void requestUpdateConfiguration(Configuration configuration) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(18, configuration));
    }

    void scheduleConsumeBatchedInput() {
        if (this.mConsumeBatchedInputScheduled) {
            return;
        }
        this.mConsumeBatchedInputScheduled = true;
        this.mChoreographer.postCallback(0, this.mConsumedBatchedInputRunnable, null);
    }

    void scheduleConsumeBatchedInputImmediately() {
        if (this.mConsumeBatchedInputImmediatelyScheduled) {
            return;
        }
        unscheduleConsumeBatchedInput();
        this.mConsumeBatchedInputImmediatelyScheduled = true;
        this.mHandler.post(this.mConsumeBatchedInputImmediatelyRunnable);
    }

    void scheduleTraversals() {
        if (this.mTraversalScheduled) {
            return;
        }
        this.mTraversalScheduled = true;
        this.mTraversalBarrier = this.mHandler.getLooper().postSyncBarrier();
        this.mChoreographer.postCallback(2, this.mTraversalRunnable, null);
        if (!this.mUnbufferedInputDispatch) {
            scheduleConsumeBatchedInput();
        }
        notifyRendererOfFramePending();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x004c, code lost:
        if (r0.bottom > r0.bottom) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean scrollToRectOrFocus(android.graphics.Rect r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.scrollToRectOrFocus(android.graphics.Rect, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAccessibilityFocus(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (this.mAccessibilityFocusedVirtualView != null) {
            AccessibilityNodeInfo accessibilityNodeInfo2 = this.mAccessibilityFocusedVirtualView;
            View view2 = this.mAccessibilityFocusedHost;
            this.mAccessibilityFocusedHost = null;
            this.mAccessibilityFocusedVirtualView = null;
            view2.clearAccessibilityFocusNoCallbacks();
            AccessibilityNodeProvider accessibilityNodeProvider = view2.getAccessibilityNodeProvider();
            if (accessibilityNodeProvider != null) {
                accessibilityNodeInfo2.getBoundsInParent(this.mTempRect);
                view2.invalidate(this.mTempRect);
                accessibilityNodeProvider.performAction(AccessibilityNodeInfo.getVirtualDescendantId(accessibilityNodeInfo2.getSourceNodeId()), 128, null);
            }
            accessibilityNodeInfo2.recycle();
        }
        if (this.mAccessibilityFocusedHost != null) {
            this.mAccessibilityFocusedHost.clearAccessibilityFocusNoCallbacks();
        }
        this.mAccessibilityFocusedHost = view;
        this.mAccessibilityFocusedVirtualView = accessibilityNodeInfo;
        if (this.mAttachInfo.mHardwareRenderer != null) {
            this.mAttachInfo.mHardwareRenderer.invalidateRoot();
        }
    }

    public void setDragFocus(View view) {
        if (this.mCurrentDragView != view) {
            this.mCurrentDragView = view;
        }
    }

    public void setDrawDuringWindowsAnimating(boolean z) {
        this.mDrawDuringWindowsAnimating = z;
        if (z) {
            handleDispatchDoneAnimating();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLayoutParams(WindowManager.LayoutParams layoutParams, boolean z) {
        synchronized (this) {
            int i = this.mWindowAttributes.surfaceInsets.left;
            int i2 = this.mWindowAttributes.surfaceInsets.top;
            int i3 = this.mWindowAttributes.surfaceInsets.right;
            int i4 = this.mWindowAttributes.surfaceInsets.bottom;
            int i5 = this.mWindowAttributes.softInputMode;
            this.mClientWindowLayoutFlags = layoutParams.flags;
            int i6 = this.mWindowAttributes.privateFlags;
            layoutParams.systemUiVisibility = this.mWindowAttributes.systemUiVisibility;
            layoutParams.subtreeSystemUiVisibility = this.mWindowAttributes.subtreeSystemUiVisibility;
            this.mWindowAttributesChangesFlag = this.mWindowAttributes.copyFrom(layoutParams);
            if ((this.mWindowAttributesChangesFlag & 524288) != 0) {
                this.mAttachInfo.mRecomputeGlobalAttributes = true;
            }
            if (this.mWindowAttributes.packageName == null) {
                this.mWindowAttributes.packageName = this.mBasePackageName;
            }
            this.mWindowAttributes.privateFlags |= i6 & 128;
            this.mWindowAttributes.surfaceInsets.set(i, i2, i3, i4);
            applyKeepScreenOnFlag(this.mWindowAttributes);
            if (z) {
                this.mSoftInputMode = layoutParams.softInputMode;
                requestLayout();
            }
            if ((layoutParams.softInputMode & 240) == 0) {
                this.mWindowAttributes.softInputMode = (this.mWindowAttributes.softInputMode & (-241)) | (i5 & 240);
            }
            this.mWindowAttributesChanged = true;
            scheduleTraversals();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLocalDragState(Object obj) {
        this.mLocalDragState = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStopped(boolean z) {
        if (this.mStopped != z) {
            this.mStopped = z;
            if (z) {
                return;
            }
            scheduleTraversals();
        }
    }

    public void setView(View view, WindowManager.LayoutParams layoutParams, View view2) {
        synchronized (this) {
            if (this.mView == null) {
                this.mView = view;
                this.mAttachInfo.mDisplayState = this.mDisplay.getState();
                this.mDisplayManager.registerDisplayListener(this.mDisplayListener, this.mHandler);
                this.mViewLayoutDirectionInitial = this.mView.getRawLayoutDirection();
                this.mFallbackEventHandler.setView(view);
                this.mWindowAttributes.copyFrom(layoutParams);
                if (this.mWindowAttributes.packageName == null) {
                    this.mWindowAttributes.packageName = this.mBasePackageName;
                }
                WindowManager.LayoutParams layoutParams2 = this.mWindowAttributes;
                this.mClientWindowLayoutFlags = layoutParams2.flags;
                setAccessibilityFocus(null, null);
                if (view instanceof RootViewSurfaceTaker) {
                    this.mSurfaceHolderCallback = ((RootViewSurfaceTaker) view).willYouTakeTheSurface();
                    if (this.mSurfaceHolderCallback != null) {
                        this.mSurfaceHolder = new TakenSurfaceHolder();
                        this.mSurfaceHolder.setFormat(0);
                    }
                }
                int ceil = (int) Math.ceil(view.getZ() * 2.0f);
                layoutParams2.surfaceInsets.set(ceil, ceil, ceil, ceil);
                CompatibilityInfo compatibilityInfo = this.mDisplayAdjustments.getCompatibilityInfo();
                this.mTranslator = compatibilityInfo.getTranslator();
                this.mDisplayAdjustments.setActivityToken(layoutParams2.token);
                if (this.mSurfaceHolder == null) {
                    enableHardwareAcceleration(layoutParams2);
                }
                boolean z = false;
                if (this.mTranslator != null) {
                    this.mSurface.setCompatibilityTranslator(this.mTranslator);
                    z = true;
                    layoutParams2.backup();
                    this.mTranslator.translateWindowLayout(layoutParams2);
                }
                if (!compatibilityInfo.supportsScreen()) {
                    layoutParams2.privateFlags |= 128;
                    this.mLastInCompatMode = true;
                }
                this.mSoftInputMode = layoutParams2.softInputMode;
                this.mWindowAttributesChanged = true;
                this.mWindowAttributesChangesFlag = -1;
                this.mAttachInfo.mRootView = view;
                this.mAttachInfo.mScalingRequired = this.mTranslator != null;
                this.mAttachInfo.mApplicationScale = this.mTranslator == null ? 1.0f : this.mTranslator.applicationScale;
                if (view2 != null) {
                    this.mAttachInfo.mPanelParentWindowToken = view2.getApplicationWindowToken();
                }
                this.mAdded = true;
                requestLayout();
                if ((this.mWindowAttributes.inputFeatures & 2) == 0) {
                    this.mInputChannel = new InputChannel();
                }
                try {
                    this.mOrigWindowType = this.mWindowAttributes.type;
                    this.mAttachInfo.mRecomputeGlobalAttributes = true;
                    collectViewAttributes();
                    int addToDisplay = this.mWindowSession.addToDisplay(this.mWindow, this.mSeq, this.mWindowAttributes, getHostVisibility(), this.mDisplay.getDisplayId(), this.mAttachInfo.mContentInsets, this.mAttachInfo.mStableInsets, this.mInputChannel);
                    if (z) {
                        layoutParams2.restore();
                    }
                    if (this.mTranslator != null) {
                        this.mTranslator.translateRectInScreenToAppWindow(this.mAttachInfo.mContentInsets);
                    }
                    this.mPendingOverscanInsets.set(0, 0, 0, 0);
                    this.mPendingContentInsets.set(this.mAttachInfo.mContentInsets);
                    this.mPendingStableInsets.set(this.mAttachInfo.mStableInsets);
                    this.mPendingVisibleInsets.set(0, 0, 0, 0);
                    if (addToDisplay < 0) {
                        this.mAttachInfo.mRootView = null;
                        this.mAdded = false;
                        this.mFallbackEventHandler.setView((View) null);
                        unscheduleTraversals();
                        setAccessibilityFocus(null, null);
                        switch (addToDisplay) {
                            case -10:
                                throw new WindowManager.InvalidDisplayException("Unable to add window " + this.mWindow + " -- the specified window type is not valid");
                            case -9:
                                throw new WindowManager.InvalidDisplayException("Unable to add window " + this.mWindow + " -- the specified display can not be found");
                            case -8:
                                throw new WindowManager.BadTokenException("Unable to add window " + this.mWindow + " -- permission denied for this window type");
                            case -7:
                                throw new WindowManager.BadTokenException("Unable to add window " + this.mWindow + " -- another window of this type already exists");
                            case -6:
                                return;
                            case -5:
                                throw new WindowManager.BadTokenException("Unable to add window -- window " + this.mWindow + " has already been added");
                            case -4:
                                throw new WindowManager.BadTokenException("Unable to add window -- app for token " + layoutParams2.token + " is exiting");
                            case -3:
                                throw new WindowManager.BadTokenException("Unable to add window -- token " + layoutParams2.token + " is not for an application");
                            case -2:
                            case -1:
                                throw new WindowManager.BadTokenException("Unable to add window -- token " + layoutParams2.token + " is not valid; is your activity running?");
                            default:
                                throw new RuntimeException("Unable to add window -- unknown error code " + addToDisplay);
                        }
                    }
                    if (view instanceof RootViewSurfaceTaker) {
                        this.mInputQueueCallback = ((RootViewSurfaceTaker) view).willYouTakeTheInputQueue();
                    }
                    if (this.mInputChannel != null) {
                        if (this.mInputQueueCallback != null) {
                            this.mInputQueue = new InputQueue();
                            this.mInputQueueCallback.onInputQueueCreated(this.mInputQueue);
                        }
                        this.mInputEventReceiver = new WindowInputEventReceiver(this.mInputChannel, Looper.myLooper());
                    }
                    view.assignParent(this);
                    this.mAddedTouchMode = (addToDisplay & 1) != 0;
                    this.mAppVisible = (addToDisplay & 2) != 0;
                    if (this.mAccessibilityManager.isEnabled()) {
                        this.mAccessibilityInteractionConnectionManager.ensureConnection();
                    }
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                    CharSequence title = layoutParams2.getTitle();
                    this.mSyntheticInputStage = new SyntheticInputStage();
                    EarlyPostImeInputStage earlyPostImeInputStage = new EarlyPostImeInputStage(new NativePostImeInputStage(new ViewPostImeInputStage(this.mSyntheticInputStage), "aq:native-post-ime:" + ((Object) title)));
                    this.mFirstInputStage = new NativePreImeInputStage(new ViewPreImeInputStage(new ImeInputStage(earlyPostImeInputStage, "aq:ime:" + ((Object) title))), "aq:native-pre-ime:" + ((Object) title));
                    this.mFirstPostImeInputStage = earlyPostImeInputStage;
                    this.mPendingInputEventQueueLengthCounterName = "aq:pending:" + ((Object) title);
                } catch (RemoteException e) {
                    this.mAdded = false;
                    this.mView = null;
                    this.mAttachInfo.mRootView = null;
                    this.mInputChannel = null;
                    this.mFallbackEventHandler.setView((View) null);
                    unscheduleTraversals();
                    setAccessibilityFocus(null, null);
                    throw new RuntimeException("Adding window failed", e);
                }
            }
        }
    }

    @Override // android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        return false;
    }

    @Override // android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public void synthesizeInputEvent(InputEvent inputEvent) {
        Message obtainMessage = this.mHandler.obtainMessage(25, inputEvent);
        obtainMessage.setAsynchronous(true);
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void transformMatrixToGlobal(Matrix matrix) {
        matrix.preTranslate(this.mAttachInfo.mWindowLeft, this.mAttachInfo.mWindowTop);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void transformMatrixToLocal(Matrix matrix) {
        matrix.postTranslate(-this.mAttachInfo.mWindowLeft, -this.mAttachInfo.mWindowTop);
    }

    void unscheduleConsumeBatchedInput() {
        if (this.mConsumeBatchedInputScheduled) {
            this.mConsumeBatchedInputScheduled = false;
            this.mChoreographer.removeCallbacks(0, this.mConsumedBatchedInputRunnable, null);
        }
    }

    void unscheduleTraversals() {
        if (this.mTraversalScheduled) {
            this.mTraversalScheduled = false;
            this.mHandler.getLooper().removeSyncBarrier(this.mTraversalBarrier);
            this.mChoreographer.removeCallbacks(2, this.mTraversalRunnable, null);
        }
    }

    void updateConfiguration(Configuration configuration, boolean z) {
        CompatibilityInfo compatibilityInfo = this.mDisplayAdjustments.getCompatibilityInfo();
        Configuration configuration2 = configuration;
        if (!compatibilityInfo.equals(CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO)) {
            configuration2 = new Configuration(configuration);
            compatibilityInfo.applyToConfiguration(this.mNoncompatDensity, configuration2);
        }
        synchronized (sConfigCallbacks) {
            int size = sConfigCallbacks.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                sConfigCallbacks.get(i).onConfigurationChanged(configuration2);
                size = i;
            }
        }
        if (this.mView != null) {
            Configuration configuration3 = this.mView.getResources().getConfiguration();
            if (z || this.mLastConfiguration.diff(configuration3) != 0) {
                int layoutDirection = this.mLastConfiguration.getLayoutDirection();
                int layoutDirection2 = configuration3.getLayoutDirection();
                this.mLastConfiguration.setTo(configuration3);
                if (layoutDirection != layoutDirection2 && this.mViewLayoutDirectionInitial == 2) {
                    this.mView.setLayoutDirection(layoutDirection2);
                }
                this.mView.dispatchConfigurationChanged(configuration3);
            }
        }
    }

    public void windowFocusChanged(boolean z, boolean z2) {
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.arg1 = z ? 1 : 0;
        obtain.arg2 = z2 ? 1 : 0;
        this.mHandler.sendMessage(obtain);
    }
}
