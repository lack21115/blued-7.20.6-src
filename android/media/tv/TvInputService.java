package android.media.tv;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.media.tv.ITvInputService;
import android.media.tv.TvInputManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.android.internal.os.SomeArgs;
import com.blued.das.live.LiveProtos;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputService.class */
public abstract class TvInputService extends Service {
    private static final boolean DEBUG = false;
    public static final String SERVICE_INTERFACE = "android.media.tv.TvInputService";
    public static final String SERVICE_META_DATA = "android.media.tv.input";
    private static final String TAG = "TvInputService";
    private TvInputManager mTvInputManager;
    private final Handler mServiceHandler = new ServiceHandler();
    private final RemoteCallbackList<ITvInputServiceCallback> mCallbacks = new RemoteCallbackList<>();

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputService$HardwareSession.class */
    public static abstract class HardwareSession extends Session {
        private TvInputManager.Session mHardwareSession;
        private final TvInputManager.SessionCallback mHardwareSessionCallback;
        private ITvInputSession mProxySession;
        private ITvInputSessionCallback mProxySessionCallback;
        private Handler mServiceHandler;

        public HardwareSession(Context context) {
            super(context);
            this.mHardwareSessionCallback = new TvInputManager.SessionCallback() { // from class: android.media.tv.TvInputService.HardwareSession.1
                @Override // android.media.tv.TvInputManager.SessionCallback
                public void onSessionCreated(TvInputManager.Session session) {
                    HardwareSession.this.mHardwareSession = session;
                    SomeArgs obtain = SomeArgs.obtain();
                    if (session != null) {
                        obtain.arg1 = HardwareSession.this;
                        obtain.arg2 = HardwareSession.this.mProxySession;
                        obtain.arg3 = HardwareSession.this.mProxySessionCallback;
                        obtain.arg4 = session.getToken();
                    } else {
                        obtain.arg1 = null;
                        obtain.arg2 = null;
                        obtain.arg3 = HardwareSession.this.mProxySessionCallback;
                        obtain.arg4 = null;
                        HardwareSession.this.onRelease();
                    }
                    HardwareSession.this.mServiceHandler.obtainMessage(2, obtain).sendToTarget();
                    session.tune(TvContract.buildChannelUriForPassthroughInput(HardwareSession.this.getHardwareInputId()));
                }

                @Override // android.media.tv.TvInputManager.SessionCallback
                public void onVideoAvailable(TvInputManager.Session session) {
                    if (HardwareSession.this.mHardwareSession == session) {
                        HardwareSession.this.onHardwareVideoAvailable();
                    }
                }

                @Override // android.media.tv.TvInputManager.SessionCallback
                public void onVideoUnavailable(TvInputManager.Session session, int i) {
                    if (HardwareSession.this.mHardwareSession == session) {
                        HardwareSession.this.onHardwareVideoUnavailable(i);
                    }
                }
            };
        }

        public abstract String getHardwareInputId();

        public void onHardwareVideoAvailable() {
        }

        public void onHardwareVideoUnavailable(int i) {
        }

        @Override // android.media.tv.TvInputService.Session
        public final boolean onSetSurface(Surface surface) {
            Log.e(TvInputService.TAG, "onSetSurface() should not be called in HardwareProxySession.");
            return false;
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputService$ServiceHandler.class */
    private final class ServiceHandler extends Handler {
        private static final int DO_ADD_HARDWARE_TV_INPUT = 3;
        private static final int DO_ADD_HDMI_TV_INPUT = 5;
        private static final int DO_CREATE_SESSION = 1;
        private static final int DO_NOTIFY_SESSION_CREATED = 2;
        private static final int DO_REMOVE_HARDWARE_TV_INPUT = 4;
        private static final int DO_REMOVE_HDMI_TV_INPUT = 6;

        private ServiceHandler() {
        }

        private void broadcastAddHardwareTvInput(int i, TvInputInfo tvInputInfo) {
            int beginBroadcast = TvInputService.this.mCallbacks.beginBroadcast();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= beginBroadcast) {
                    TvInputService.this.mCallbacks.finishBroadcast();
                    return;
                }
                try {
                    ((ITvInputServiceCallback) TvInputService.this.mCallbacks.getBroadcastItem(i3)).addHardwareTvInput(i, tvInputInfo);
                } catch (RemoteException e) {
                    Log.e(TvInputService.TAG, "Error while broadcasting.", e);
                }
                i2 = i3 + 1;
            }
        }

        private void broadcastAddHdmiTvInput(int i, TvInputInfo tvInputInfo) {
            int beginBroadcast = TvInputService.this.mCallbacks.beginBroadcast();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= beginBroadcast) {
                    TvInputService.this.mCallbacks.finishBroadcast();
                    return;
                }
                try {
                    ((ITvInputServiceCallback) TvInputService.this.mCallbacks.getBroadcastItem(i3)).addHdmiTvInput(i, tvInputInfo);
                } catch (RemoteException e) {
                    Log.e(TvInputService.TAG, "Error while broadcasting.", e);
                }
                i2 = i3 + 1;
            }
        }

        private void broadcastRemoveTvInput(String str) {
            int beginBroadcast = TvInputService.this.mCallbacks.beginBroadcast();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= beginBroadcast) {
                    TvInputService.this.mCallbacks.finishBroadcast();
                    return;
                }
                try {
                    ((ITvInputServiceCallback) TvInputService.this.mCallbacks.getBroadcastItem(i2)).removeTvInput(str);
                } catch (RemoteException e) {
                    Log.e(TvInputService.TAG, "Error while broadcasting.", e);
                }
                i = i2 + 1;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    SomeArgs someArgs = (SomeArgs) message.obj;
                    InputChannel inputChannel = (InputChannel) someArgs.arg1;
                    ITvInputSessionCallback iTvInputSessionCallback = (ITvInputSessionCallback) someArgs.arg2;
                    String str = (String) someArgs.arg3;
                    someArgs.recycle();
                    Session onCreateSession = TvInputService.this.onCreateSession(str);
                    if (onCreateSession == null) {
                        try {
                            iTvInputSessionCallback.onSessionCreated(null, null);
                            return;
                        } catch (RemoteException e) {
                            Log.e(TvInputService.TAG, "error in onSessionCreated");
                            return;
                        }
                    }
                    ITvInputSessionWrapper iTvInputSessionWrapper = new ITvInputSessionWrapper(TvInputService.this, onCreateSession, inputChannel);
                    if (!(onCreateSession instanceof HardwareSession)) {
                        SomeArgs obtain = SomeArgs.obtain();
                        obtain.arg1 = onCreateSession;
                        obtain.arg2 = iTvInputSessionWrapper;
                        obtain.arg3 = iTvInputSessionCallback;
                        obtain.arg4 = null;
                        TvInputService.this.mServiceHandler.obtainMessage(2, obtain).sendToTarget();
                        return;
                    }
                    HardwareSession hardwareSession = (HardwareSession) onCreateSession;
                    String hardwareInputId = hardwareSession.getHardwareInputId();
                    if (!TextUtils.isEmpty(hardwareInputId) && TvInputService.this.isPassthroughInput(hardwareInputId)) {
                        hardwareSession.mProxySession = iTvInputSessionWrapper;
                        hardwareSession.mProxySessionCallback = iTvInputSessionCallback;
                        hardwareSession.mServiceHandler = TvInputService.this.mServiceHandler;
                        ((TvInputManager) TvInputService.this.getSystemService(Context.TV_INPUT_SERVICE)).createSession(hardwareInputId, hardwareSession.mHardwareSessionCallback, TvInputService.this.mServiceHandler);
                        return;
                    }
                    if (TextUtils.isEmpty(hardwareInputId)) {
                        Log.w(TvInputService.TAG, "Hardware input id is not setup yet.");
                    } else {
                        Log.w(TvInputService.TAG, "Invalid hardware input id : " + hardwareInputId);
                    }
                    onCreateSession.onRelease();
                    try {
                        iTvInputSessionCallback.onSessionCreated(null, null);
                        return;
                    } catch (RemoteException e2) {
                        Log.e(TvInputService.TAG, "error in onSessionCreated");
                        return;
                    }
                case 2:
                    SomeArgs someArgs2 = (SomeArgs) message.obj;
                    Session session = (Session) someArgs2.arg1;
                    ITvInputSession iTvInputSession = (ITvInputSession) someArgs2.arg2;
                    ITvInputSessionCallback iTvInputSessionCallback2 = (ITvInputSessionCallback) someArgs2.arg3;
                    try {
                        iTvInputSessionCallback2.onSessionCreated(iTvInputSession, (IBinder) someArgs2.arg4);
                    } catch (RemoteException e3) {
                        Log.e(TvInputService.TAG, "error in onSessionCreated");
                    }
                    if (session != null) {
                        session.initialize(iTvInputSessionCallback2);
                    }
                    someArgs2.recycle();
                    return;
                case 3:
                    TvInputHardwareInfo tvInputHardwareInfo = (TvInputHardwareInfo) message.obj;
                    TvInputInfo onHardwareAdded = TvInputService.this.onHardwareAdded(tvInputHardwareInfo);
                    if (onHardwareAdded != null) {
                        broadcastAddHardwareTvInput(tvInputHardwareInfo.getDeviceId(), onHardwareAdded);
                        return;
                    }
                    return;
                case 4:
                    String onHardwareRemoved = TvInputService.this.onHardwareRemoved((TvInputHardwareInfo) message.obj);
                    if (onHardwareRemoved != null) {
                        broadcastRemoveTvInput(onHardwareRemoved);
                        return;
                    }
                    return;
                case 5:
                    HdmiDeviceInfo hdmiDeviceInfo = (HdmiDeviceInfo) message.obj;
                    TvInputInfo onHdmiDeviceAdded = TvInputService.this.onHdmiDeviceAdded(hdmiDeviceInfo);
                    if (onHdmiDeviceAdded != null) {
                        broadcastAddHdmiTvInput(hdmiDeviceInfo.getId(), onHdmiDeviceAdded);
                        return;
                    }
                    return;
                case 6:
                    String onHdmiDeviceRemoved = TvInputService.this.onHdmiDeviceRemoved((HdmiDeviceInfo) message.obj);
                    if (onHdmiDeviceRemoved != null) {
                        broadcastRemoveTvInput(onHdmiDeviceRemoved);
                        return;
                    }
                    return;
                default:
                    Log.w(TvInputService.TAG, "Unhandled message code: " + message.what);
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputService$Session.class */
    public static abstract class Session implements KeyEvent.Callback {
        private static final int DETACH_OVERLAY_VIEW_TIMEOUT = 5000;
        private Context mContext;
        final Handler mHandler;
        private Rect mOverlayFrame;
        private View mOverlayView;
        private OverlayViewCleanUpTask mOverlayViewCleanUpTask;
        private FrameLayout mOverlayViewContainer;
        private boolean mOverlayViewEnabled;
        private ITvInputSessionCallback mSessionCallback;
        private Surface mSurface;
        private final WindowManager mWindowManager;
        private WindowManager.LayoutParams mWindowParams;
        private IBinder mWindowToken;
        private final KeyEvent.DispatcherState mDispatcherState = new KeyEvent.DispatcherState();
        private Object mLock = new Object();
        private List<Runnable> mPendingActions = new ArrayList();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputService$Session$OverlayViewCleanUpTask.class */
        public final class OverlayViewCleanUpTask extends AsyncTask<View, Void, Void> {
            private OverlayViewCleanUpTask() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(View... viewArr) {
                View view = viewArr[0];
                try {
                    Thread.sleep(5000L);
                    if (!isCancelled() && view.isAttachedToWindow()) {
                        Log.e(TvInputService.TAG, "Time out on releasing overlay view. Killing " + view.getContext().getPackageName());
                        Process.killProcess(Process.myPid());
                        return null;
                    }
                    return null;
                } catch (InterruptedException e) {
                    return null;
                }
            }
        }

        public Session(Context context) {
            this.mContext = context;
            this.mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            this.mHandler = new Handler(context.getMainLooper());
        }

        private final void executeOrPostRunnable(Runnable runnable) {
            synchronized (this.mLock) {
                if (this.mSessionCallback == null) {
                    this.mPendingActions.add(runnable);
                } else if (this.mHandler.getLooper().isCurrentThread()) {
                    runnable.run();
                } else {
                    this.mHandler.post(runnable);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initialize(ITvInputSessionCallback iTvInputSessionCallback) {
            synchronized (this.mLock) {
                this.mSessionCallback = iTvInputSessionCallback;
                for (Runnable runnable : this.mPendingActions) {
                    runnable.run();
                }
                this.mPendingActions.clear();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void appPrivateCommand(String str, Bundle bundle) {
            onAppPrivateCommand(str, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void createOverlayView(IBinder iBinder, Rect rect) {
            if (this.mOverlayViewContainer != null) {
                removeOverlayView(false);
            }
            this.mWindowToken = iBinder;
            this.mOverlayFrame = rect;
            onOverlayViewSizeChanged(rect.right - rect.left, rect.bottom - rect.top);
            if (this.mOverlayViewEnabled) {
                this.mOverlayView = onCreateOverlayView();
                if (this.mOverlayView != null) {
                    if (this.mOverlayViewCleanUpTask != null) {
                        this.mOverlayViewCleanUpTask.cancel(true);
                        this.mOverlayViewCleanUpTask = null;
                    }
                    this.mOverlayViewContainer = new FrameLayout(this.mContext);
                    this.mOverlayViewContainer.addView(this.mOverlayView);
                    this.mWindowParams = new WindowManager.LayoutParams(rect.right - rect.left, rect.bottom - rect.top, rect.left, rect.top, 1004, LiveProtos.Event.LIVE_PK_SCORE_BTN_SHOW_VALUE, -2);
                    this.mWindowParams.privateFlags |= 64;
                    this.mWindowParams.gravity = BadgeDrawable.TOP_START;
                    this.mWindowParams.token = iBinder;
                    this.mWindowManager.addView(this.mOverlayViewContainer, this.mWindowParams);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int dispatchInputEvent(InputEvent inputEvent, InputEventReceiver inputEventReceiver) {
            boolean z;
            if (inputEvent instanceof KeyEvent) {
                KeyEvent keyEvent = (KeyEvent) inputEvent;
                z = TvInputService.isNavigationKey(keyEvent.getKeyCode());
                if (keyEvent.dispatch(this, this.mDispatcherState, this)) {
                    return 1;
                }
            } else {
                z = false;
                if (inputEvent instanceof MotionEvent) {
                    MotionEvent motionEvent = (MotionEvent) inputEvent;
                    int source = motionEvent.getSource();
                    if (motionEvent.isTouchEvent()) {
                        if (onTouchEvent(motionEvent)) {
                            return 1;
                        }
                        z = false;
                    } else if ((source & 4) != 0) {
                        z = false;
                        if (onTrackballEvent(motionEvent)) {
                            return 1;
                        }
                    } else {
                        z = false;
                        if (onGenericMotionEvent(motionEvent)) {
                            return 1;
                        }
                    }
                }
            }
            if (this.mOverlayViewContainer == null || !this.mOverlayViewContainer.isAttachedToWindow()) {
                return 0;
            }
            if (!this.mOverlayViewContainer.hasWindowFocus()) {
                this.mOverlayViewContainer.getViewRootImpl().windowFocusChanged(true, true);
            }
            if (z && this.mOverlayViewContainer.hasFocusable()) {
                this.mOverlayViewContainer.getViewRootImpl().dispatchInputEvent(inputEvent);
                return 1;
            }
            this.mOverlayViewContainer.getViewRootImpl().dispatchInputEvent(inputEvent, inputEventReceiver);
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dispatchSurfaceChanged(int i, int i2, int i3) {
            onSurfaceChanged(i, i2, i3);
        }

        public void layoutSurface(final int i, final int i2, final int i3, final int i4) {
            if (i > i3 || i2 > i4) {
                throw new IllegalArgumentException("Invalid parameter");
            }
            executeOrPostRunnable(new Runnable() { // from class: android.media.tv.TvInputService.Session.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Session.this.mSessionCallback != null) {
                            Session.this.mSessionCallback.onLayoutSurface(i, i2, i3, i4);
                        }
                    } catch (RemoteException e) {
                        Log.w(TvInputService.TAG, "error in layoutSurface");
                    }
                }
            });
        }

        public void notifyChannelRetuned(final Uri uri) {
            executeOrPostRunnable(new Runnable() { // from class: android.media.tv.TvInputService.Session.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Session.this.mSessionCallback != null) {
                            Session.this.mSessionCallback.onChannelRetuned(uri);
                        }
                    } catch (RemoteException e) {
                        Log.w(TvInputService.TAG, "error in notifyChannelRetuned");
                    }
                }
            });
        }

        public void notifyContentAllowed() {
            executeOrPostRunnable(new Runnable() { // from class: android.media.tv.TvInputService.Session.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Session.this.mSessionCallback != null) {
                            Session.this.mSessionCallback.onContentAllowed();
                        }
                    } catch (RemoteException e) {
                        Log.w(TvInputService.TAG, "error in notifyContentAllowed");
                    }
                }
            });
        }

        public void notifyContentBlocked(final TvContentRating tvContentRating) {
            executeOrPostRunnable(new Runnable() { // from class: android.media.tv.TvInputService.Session.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Session.this.mSessionCallback != null) {
                            Session.this.mSessionCallback.onContentBlocked(tvContentRating.flattenToString());
                        }
                    } catch (RemoteException e) {
                        Log.w(TvInputService.TAG, "error in notifyContentBlocked");
                    }
                }
            });
        }

        public void notifySessionEvent(final String str, final Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("eventType should not be null.");
            }
            executeOrPostRunnable(new Runnable() { // from class: android.media.tv.TvInputService.Session.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Session.this.mSessionCallback != null) {
                            Session.this.mSessionCallback.onSessionEvent(str, bundle);
                        }
                    } catch (RemoteException e) {
                        Log.w(TvInputService.TAG, "error in sending event (event=" + str + ")");
                    }
                }
            });
        }

        public void notifyTrackSelected(final int i, final String str) {
            executeOrPostRunnable(new Runnable() { // from class: android.media.tv.TvInputService.Session.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Session.this.mSessionCallback != null) {
                            Session.this.mSessionCallback.onTrackSelected(i, str);
                        }
                    } catch (RemoteException e) {
                        Log.w(TvInputService.TAG, "error in notifyTrackSelected");
                    }
                }
            });
        }

        public void notifyTracksChanged(final List<TvTrackInfo> list) {
            HashSet hashSet = new HashSet();
            for (TvTrackInfo tvTrackInfo : list) {
                String id = tvTrackInfo.getId();
                if (hashSet.contains(id)) {
                    throw new IllegalArgumentException("redundant track ID: " + id);
                }
                hashSet.add(id);
            }
            hashSet.clear();
            executeOrPostRunnable(new Runnable() { // from class: android.media.tv.TvInputService.Session.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Session.this.mSessionCallback != null) {
                            Session.this.mSessionCallback.onTracksChanged(list);
                        }
                    } catch (RemoteException e) {
                        Log.w(TvInputService.TAG, "error in notifyTracksChanged");
                    }
                }
            });
        }

        public void notifyVideoAvailable() {
            executeOrPostRunnable(new Runnable() { // from class: android.media.tv.TvInputService.Session.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Session.this.mSessionCallback != null) {
                            Session.this.mSessionCallback.onVideoAvailable();
                        }
                    } catch (RemoteException e) {
                        Log.w(TvInputService.TAG, "error in notifyVideoAvailable");
                    }
                }
            });
        }

        public void notifyVideoUnavailable(final int i) {
            if (i < 0 || i > 3) {
                throw new IllegalArgumentException("Unknown reason: " + i);
            }
            executeOrPostRunnable(new Runnable() { // from class: android.media.tv.TvInputService.Session.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Session.this.mSessionCallback != null) {
                            Session.this.mSessionCallback.onVideoUnavailable(i);
                        }
                    } catch (RemoteException e) {
                        Log.w(TvInputService.TAG, "error in notifyVideoUnavailable");
                    }
                }
            });
        }

        public void onAppPrivateCommand(String str, Bundle bundle) {
        }

        public View onCreateOverlayView() {
            return null;
        }

        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            return false;
        }

        @Override // android.view.KeyEvent.Callback
        public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
            return false;
        }

        @Override // android.view.KeyEvent.Callback
        public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
            return false;
        }

        @Override // android.view.KeyEvent.Callback
        public boolean onKeyUp(int i, KeyEvent keyEvent) {
            return false;
        }

        public void onOverlayViewSizeChanged(int i, int i2) {
        }

        public abstract void onRelease();

        public boolean onSelectTrack(int i, String str) {
            return false;
        }

        public abstract void onSetCaptionEnabled(boolean z);

        public void onSetMain(boolean z) {
        }

        public abstract void onSetStreamVolume(float f);

        public abstract boolean onSetSurface(Surface surface);

        public void onSurfaceChanged(int i, int i2, int i3) {
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onTrackballEvent(MotionEvent motionEvent) {
            return false;
        }

        public abstract boolean onTune(Uri uri);

        public boolean onTune(Uri uri, Bundle bundle) {
            return onTune(uri);
        }

        public void onUnblockContent(TvContentRating tvContentRating) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void relayoutOverlayView(Rect rect) {
            if (this.mOverlayFrame == null || this.mOverlayFrame.width() != rect.width() || this.mOverlayFrame.height() != rect.height()) {
                onOverlayViewSizeChanged(rect.right - rect.left, rect.bottom - rect.top);
            }
            this.mOverlayFrame = rect;
            if (!this.mOverlayViewEnabled || this.mOverlayViewContainer == null) {
                return;
            }
            this.mWindowParams.x = rect.left;
            this.mWindowParams.y = rect.top;
            this.mWindowParams.width = rect.right - rect.left;
            this.mWindowParams.height = rect.bottom - rect.top;
            this.mWindowManager.updateViewLayout(this.mOverlayViewContainer, this.mWindowParams);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void release() {
            onRelease();
            if (this.mSurface != null) {
                this.mSurface.release();
                this.mSurface = null;
            }
            synchronized (this.mLock) {
                this.mSessionCallback = null;
                this.mPendingActions.clear();
            }
            removeOverlayView(true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void removeOverlayView(boolean z) {
            if (z) {
                this.mWindowToken = null;
                this.mOverlayFrame = null;
            }
            if (this.mOverlayViewContainer != null) {
                this.mOverlayViewContainer.removeView(this.mOverlayView);
                this.mOverlayView = null;
                this.mWindowManager.removeView(this.mOverlayViewContainer);
                this.mOverlayViewContainer = null;
                this.mWindowParams = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void scheduleOverlayViewCleanup() {
            FrameLayout frameLayout = this.mOverlayViewContainer;
            if (frameLayout != null) {
                this.mOverlayViewCleanUpTask = new OverlayViewCleanUpTask();
                this.mOverlayViewCleanUpTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, frameLayout);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void selectTrack(int i, String str) {
            onSelectTrack(i, str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setCaptionEnabled(boolean z) {
            onSetCaptionEnabled(z);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setMain(boolean z) {
            onSetMain(z);
        }

        public void setOverlayViewEnabled(final boolean z) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputService.Session.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z == Session.this.mOverlayViewEnabled) {
                        return;
                    }
                    Session.this.mOverlayViewEnabled = z;
                    if (!z) {
                        Session.this.removeOverlayView(false);
                    } else if (Session.this.mWindowToken != null) {
                        Session.this.createOverlayView(Session.this.mWindowToken, Session.this.mOverlayFrame);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setStreamVolume(float f) {
            onSetStreamVolume(f);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setSurface(Surface surface) {
            onSetSurface(surface);
            if (this.mSurface != null) {
                this.mSurface.release();
            }
            this.mSurface = surface;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void tune(Uri uri, Bundle bundle) {
            onTune(uri, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void unblockContent(String str) {
            onUnblockContent(TvContentRating.unflattenFromString(str));
        }
    }

    public static boolean isNavigationKey(int i) {
        switch (i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPassthroughInput(String str) {
        if (this.mTvInputManager == null) {
            this.mTvInputManager = (TvInputManager) getSystemService(Context.TV_INPUT_SERVICE);
        }
        TvInputInfo tvInputInfo = this.mTvInputManager.getTvInputInfo(str);
        return tvInputInfo != null && tvInputInfo.isPassthroughInput();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new ITvInputService.Stub() { // from class: android.media.tv.TvInputService.1
            @Override // android.media.tv.ITvInputService
            public void createSession(InputChannel inputChannel, ITvInputSessionCallback iTvInputSessionCallback, String str) {
                if (inputChannel == null) {
                    Log.w(TvInputService.TAG, "Creating session without input channel");
                }
                if (iTvInputSessionCallback == null) {
                    return;
                }
                SomeArgs obtain = SomeArgs.obtain();
                obtain.arg1 = inputChannel;
                obtain.arg2 = iTvInputSessionCallback;
                obtain.arg3 = str;
                TvInputService.this.mServiceHandler.obtainMessage(1, obtain).sendToTarget();
            }

            @Override // android.media.tv.ITvInputService
            public void notifyHardwareAdded(TvInputHardwareInfo tvInputHardwareInfo) {
                TvInputService.this.mServiceHandler.obtainMessage(3, tvInputHardwareInfo).sendToTarget();
            }

            @Override // android.media.tv.ITvInputService
            public void notifyHardwareRemoved(TvInputHardwareInfo tvInputHardwareInfo) {
                TvInputService.this.mServiceHandler.obtainMessage(4, tvInputHardwareInfo).sendToTarget();
            }

            @Override // android.media.tv.ITvInputService
            public void notifyHdmiDeviceAdded(HdmiDeviceInfo hdmiDeviceInfo) {
                TvInputService.this.mServiceHandler.obtainMessage(5, hdmiDeviceInfo).sendToTarget();
            }

            @Override // android.media.tv.ITvInputService
            public void notifyHdmiDeviceRemoved(HdmiDeviceInfo hdmiDeviceInfo) {
                TvInputService.this.mServiceHandler.obtainMessage(6, hdmiDeviceInfo).sendToTarget();
            }

            @Override // android.media.tv.ITvInputService
            public void registerCallback(ITvInputServiceCallback iTvInputServiceCallback) {
                if (iTvInputServiceCallback != null) {
                    TvInputService.this.mCallbacks.register(iTvInputServiceCallback);
                }
            }

            @Override // android.media.tv.ITvInputService
            public void unregisterCallback(ITvInputServiceCallback iTvInputServiceCallback) {
                if (iTvInputServiceCallback != null) {
                    TvInputService.this.mCallbacks.unregister(iTvInputServiceCallback);
                }
            }
        };
    }

    public abstract Session onCreateSession(String str);

    public TvInputInfo onHardwareAdded(TvInputHardwareInfo tvInputHardwareInfo) {
        return null;
    }

    public String onHardwareRemoved(TvInputHardwareInfo tvInputHardwareInfo) {
        return null;
    }

    public TvInputInfo onHdmiDeviceAdded(HdmiDeviceInfo hdmiDeviceInfo) {
        return null;
    }

    public String onHdmiDeviceRemoved(HdmiDeviceInfo hdmiDeviceInfo) {
        return null;
    }
}
