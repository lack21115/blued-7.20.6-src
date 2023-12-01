package android.media.tv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.media.tv.TvInputManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewRootImpl;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvView.class */
public class TvView extends ViewGroup {
    private static final int CAPTION_DEFAULT = 0;
    private static final int CAPTION_DISABLED = 2;
    private static final int CAPTION_ENABLED = 1;
    private static final boolean DEBUG = false;
    private static final String TAG = "TvView";
    private static final int ZORDER_MEDIA = 0;
    private static final int ZORDER_MEDIA_OVERLAY = 1;
    private static final int ZORDER_ON_TOP = 2;
    private String mAppPrivateCommandAction;
    private Bundle mAppPrivateCommandData;
    private final AttributeSet mAttrs;
    private TvInputCallback mCallback;
    private int mCaptionEnabled;
    private final int mDefStyleAttr;
    private final TvInputManager.Session.FinishedInputEventCallback mFinishedInputEventCallback;
    private final Handler mHandler;
    private boolean mHasStreamVolume;
    private OnUnhandledInputEventListener mOnUnhandledInputEventListener;
    private boolean mOverlayViewCreated;
    private Rect mOverlayViewFrame;
    private TvInputManager.Session mSession;
    private MySessionCallback mSessionCallback;
    private float mStreamVolume;
    private Surface mSurface;
    private boolean mSurfaceChanged;
    private int mSurfaceFormat;
    private int mSurfaceHeight;
    private final SurfaceHolder.Callback mSurfaceHolderCallback;
    private SurfaceView mSurfaceView;
    private int mSurfaceViewBottom;
    private int mSurfaceViewLeft;
    private int mSurfaceViewRight;
    private int mSurfaceViewTop;
    private int mSurfaceWidth;
    private final TvInputManager mTvInputManager;
    private boolean mUseRequestedSurfaceLayout;
    private int mWindowZOrder;
    private static final WeakReference<TvView> NULL_TV_VIEW = new WeakReference<>(null);
    private static final Object sMainTvViewLock = new Object();
    private static WeakReference<TvView> sMainTvView = NULL_TV_VIEW;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvView$MySessionCallback.class */
    public class MySessionCallback extends TvInputManager.SessionCallback {
        Uri mChannelUri;
        final String mInputId;
        Bundle mTuneParams;

        MySessionCallback(String str, Uri uri, Bundle bundle) {
            this.mInputId = str;
            this.mChannelUri = uri;
            this.mTuneParams = bundle;
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onChannelRetuned(TvInputManager.Session session, Uri uri) {
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onChannelRetuned - session not created");
            } else if (TvView.this.mCallback != null) {
                TvView.this.mCallback.onChannelRetuned(this.mInputId, uri);
            }
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onContentAllowed(TvInputManager.Session session) {
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onContentAllowed - session not created");
            } else if (TvView.this.mCallback != null) {
                TvView.this.mCallback.onContentAllowed(this.mInputId);
            }
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onContentBlocked(TvInputManager.Session session, TvContentRating tvContentRating) {
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onContentBlocked - session not created");
            } else if (TvView.this.mCallback != null) {
                TvView.this.mCallback.onContentBlocked(this.mInputId, tvContentRating);
            }
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onLayoutSurface(TvInputManager.Session session, int i, int i2, int i3, int i4) {
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onLayoutSurface - session not created");
                return;
            }
            TvView.this.mSurfaceViewLeft = i;
            TvView.this.mSurfaceViewTop = i2;
            TvView.this.mSurfaceViewRight = i3;
            TvView.this.mSurfaceViewBottom = i4;
            TvView.this.mUseRequestedSurfaceLayout = true;
            TvView.this.requestLayout();
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onSessionCreated(TvInputManager.Session session) {
            boolean z = true;
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onSessionCreated - session already created");
                if (session != null) {
                    session.release();
                    return;
                }
                return;
            }
            TvView.this.mSession = session;
            if (session == null) {
                TvView.this.mSessionCallback = null;
                if (TvView.this.mCallback != null) {
                    TvView.this.mCallback.onConnectionFailed(this.mInputId);
                    return;
                }
                return;
            }
            synchronized (TvView.sMainTvViewLock) {
                if (TvView.this.hasWindowFocus() && TvView.this == TvView.sMainTvView.get()) {
                    TvView.this.mSession.setMain();
                }
            }
            if (TvView.this.mSurface != null) {
                TvView.this.setSessionSurface(TvView.this.mSurface);
                if (TvView.this.mSurfaceChanged) {
                    TvView.this.dispatchSurfaceChanged(TvView.this.mSurfaceFormat, TvView.this.mSurfaceWidth, TvView.this.mSurfaceHeight);
                }
            }
            TvView.this.createSessionOverlayView();
            if (TvView.this.mCaptionEnabled != 0) {
                TvInputManager.Session session2 = TvView.this.mSession;
                if (TvView.this.mCaptionEnabled != 1) {
                    z = false;
                }
                session2.setCaptionEnabled(z);
            }
            TvView.this.mSession.tune(this.mChannelUri, this.mTuneParams);
            if (TvView.this.mHasStreamVolume) {
                TvView.this.mSession.setStreamVolume(TvView.this.mStreamVolume);
            }
            if (TvView.this.mAppPrivateCommandAction != null) {
                TvView.this.mSession.sendAppPrivateCommand(TvView.this.mAppPrivateCommandAction, TvView.this.mAppPrivateCommandData);
                TvView.this.mAppPrivateCommandAction = null;
                TvView.this.mAppPrivateCommandData = null;
            }
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onSessionEvent(TvInputManager.Session session, String str, Bundle bundle) {
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onSessionEvent - session not created");
            } else if (TvView.this.mCallback != null) {
                TvView.this.mCallback.onEvent(this.mInputId, str, bundle);
            }
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onSessionReleased(TvInputManager.Session session) {
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onSessionReleased - session not created");
                return;
            }
            TvView.this.mOverlayViewCreated = false;
            TvView.this.mOverlayViewFrame = null;
            TvView.this.mSessionCallback = null;
            TvView.this.mSession = null;
            if (TvView.this.mCallback != null) {
                TvView.this.mCallback.onDisconnected(this.mInputId);
            }
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onTrackSelected(TvInputManager.Session session, int i, String str) {
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onTrackSelected - session not created");
            } else if (TvView.this.mCallback != null) {
                TvView.this.mCallback.onTrackSelected(this.mInputId, i, str);
            }
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onTracksChanged(TvInputManager.Session session, List<TvTrackInfo> list) {
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onTracksChanged - session not created");
            } else if (TvView.this.mCallback != null) {
                TvView.this.mCallback.onTracksChanged(this.mInputId, list);
            }
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onVideoAvailable(TvInputManager.Session session) {
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onVideoAvailable - session not created");
            } else if (TvView.this.mCallback != null) {
                TvView.this.mCallback.onVideoAvailable(this.mInputId);
            }
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onVideoSizeChanged(TvInputManager.Session session, int i, int i2) {
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onVideoSizeChanged - session not created");
            } else if (TvView.this.mCallback != null) {
                TvView.this.mCallback.onVideoSizeChanged(this.mInputId, i, i2);
            }
        }

        @Override // android.media.tv.TvInputManager.SessionCallback
        public void onVideoUnavailable(TvInputManager.Session session, int i) {
            if (this != TvView.this.mSessionCallback) {
                Log.w(TvView.TAG, "onVideoUnavailable - session not created");
            } else if (TvView.this.mCallback != null) {
                TvView.this.mCallback.onVideoUnavailable(this.mInputId, i);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvView$OnUnhandledInputEventListener.class */
    public interface OnUnhandledInputEventListener {
        boolean onUnhandledInputEvent(InputEvent inputEvent);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvView$TvInputCallback.class */
    public static abstract class TvInputCallback {
        public void onChannelRetuned(String str, Uri uri) {
        }

        public void onConnectionFailed(String str) {
        }

        public void onContentAllowed(String str) {
        }

        public void onContentBlocked(String str, TvContentRating tvContentRating) {
        }

        public void onDisconnected(String str) {
        }

        public void onEvent(String str, String str2, Bundle bundle) {
        }

        public void onTrackSelected(String str, int i, String str2) {
        }

        public void onTracksChanged(String str, List<TvTrackInfo> list) {
        }

        public void onVideoAvailable(String str) {
        }

        public void onVideoSizeChanged(String str, int i, int i2) {
        }

        public void onVideoUnavailable(String str, int i) {
        }
    }

    public TvView(Context context) {
        this(context, null, 0);
    }

    public TvView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TvView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.mSurfaceHolderCallback = new SurfaceHolder.Callback() { // from class: android.media.tv.TvView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                TvView.this.mSurfaceFormat = i2;
                TvView.this.mSurfaceWidth = i3;
                TvView.this.mSurfaceHeight = i4;
                TvView.this.mSurfaceChanged = true;
                TvView.this.dispatchSurfaceChanged(TvView.this.mSurfaceFormat, TvView.this.mSurfaceWidth, TvView.this.mSurfaceHeight);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                TvView.this.mSurface = surfaceHolder.getSurface();
                TvView.this.setSessionSurface(TvView.this.mSurface);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                TvView.this.mSurface = null;
                TvView.this.mSurfaceChanged = false;
                TvView.this.setSessionSurface(null);
            }
        };
        this.mFinishedInputEventCallback = new TvInputManager.Session.FinishedInputEventCallback() { // from class: android.media.tv.TvView.2
            @Override // android.media.tv.TvInputManager.Session.FinishedInputEventCallback
            public void onFinishedInputEvent(Object obj, boolean z) {
                ViewRootImpl viewRootImpl;
                if (z) {
                    return;
                }
                InputEvent inputEvent = (InputEvent) obj;
                if (TvView.this.dispatchUnhandledInputEvent(inputEvent) || (viewRootImpl = TvView.this.getViewRootImpl()) == null) {
                    return;
                }
                viewRootImpl.dispatchUnhandledInputEvent(inputEvent);
            }
        };
        this.mAttrs = attributeSet;
        this.mDefStyleAttr = i;
        resetSurfaceView();
        this.mTvInputManager = (TvInputManager) getContext().getSystemService(Context.TV_INPUT_SERVICE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSessionOverlayView() {
        if (this.mSession == null || !isAttachedToWindow() || this.mOverlayViewCreated || this.mWindowZOrder != 0) {
            return;
        }
        this.mOverlayViewFrame = getViewFrameOnScreen();
        this.mSession.createOverlayView(this, this.mOverlayViewFrame);
        this.mOverlayViewCreated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSurfaceChanged(int i, int i2, int i3) {
        if (this.mSession == null) {
            return;
        }
        this.mSession.dispatchSurfaceChanged(i, i2, i3);
    }

    private Rect getViewFrameOnScreen() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + getWidth(), iArr[1] + getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void relayoutSessionOverlayView() {
        if (this.mSession != null && isAttachedToWindow() && this.mOverlayViewCreated && this.mWindowZOrder == 0) {
            Rect viewFrameOnScreen = getViewFrameOnScreen();
            if (viewFrameOnScreen.equals(this.mOverlayViewFrame)) {
                return;
            }
            this.mSession.relayoutOverlayView(viewFrameOnScreen);
            this.mOverlayViewFrame = viewFrameOnScreen;
        }
    }

    private void release() {
        this.mAppPrivateCommandAction = null;
        this.mAppPrivateCommandData = null;
        setSessionSurface(null);
        removeSessionOverlayView();
        this.mUseRequestedSurfaceLayout = false;
        this.mSession.release();
        this.mSession = null;
        this.mSessionCallback = null;
    }

    private void removeSessionOverlayView() {
        if (this.mSession == null || !this.mOverlayViewCreated) {
            return;
        }
        this.mSession.removeOverlayView();
        this.mOverlayViewCreated = false;
        this.mOverlayViewFrame = null;
    }

    private void resetInternal() {
        if (this.mSession != null) {
            release();
            resetSurfaceView();
        }
    }

    private void resetSurfaceView() {
        if (this.mSurfaceView != null) {
            this.mSurfaceView.getHolder().removeCallback(this.mSurfaceHolderCallback);
            removeView(this.mSurfaceView);
        }
        this.mSurface = null;
        this.mSurfaceView = new SurfaceView(getContext(), this.mAttrs, this.mDefStyleAttr) { // from class: android.media.tv.TvView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.view.SurfaceView
            public void updateWindow(boolean z, boolean z2) {
                super.updateWindow(z, z2);
                TvView.this.relayoutSessionOverlayView();
            }
        };
        this.mSurfaceView.getHolder().addCallback(this.mSurfaceHolderCallback);
        if (this.mWindowZOrder == 1) {
            this.mSurfaceView.setZOrderMediaOverlay(true);
        } else if (this.mWindowZOrder == 2) {
            this.mSurfaceView.setZOrderOnTop(true);
        }
        addView(this.mSurfaceView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionSurface(Surface surface) {
        if (this.mSession == null) {
            return;
        }
        this.mSession.setSurface(surface);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWindowZOrder != 2) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (super.dispatchGenericMotionEvent(motionEvent)) {
            return true;
        }
        if (this.mSession == null) {
            return false;
        }
        MotionEvent copy = motionEvent.copy();
        return this.mSession.dispatchInputEvent(copy, copy, this.mFinishedInputEventCallback, this.mHandler) != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        if (this.mSession == null) {
            return false;
        }
        KeyEvent copy = keyEvent.copy();
        return this.mSession.dispatchInputEvent(copy, copy, this.mFinishedInputEventCallback, this.mHandler) != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        if (this.mSession == null) {
            return false;
        }
        MotionEvent copy = motionEvent.copy();
        return this.mSession.dispatchInputEvent(copy, copy, this.mFinishedInputEventCallback, this.mHandler) != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        if (super.dispatchTrackballEvent(motionEvent)) {
            return true;
        }
        if (this.mSession == null) {
            return false;
        }
        MotionEvent copy = motionEvent.copy();
        return this.mSession.dispatchInputEvent(copy, copy, this.mFinishedInputEventCallback, this.mHandler) != 0;
    }

    public boolean dispatchUnhandledInputEvent(InputEvent inputEvent) {
        if (this.mOnUnhandledInputEventListener == null || !this.mOnUnhandledInputEventListener.onUnhandledInputEvent(inputEvent)) {
            return onUnhandledInputEvent(inputEvent);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowFocusChanged(boolean z) {
        super.dispatchWindowFocusChanged(z);
        synchronized (sMainTvViewLock) {
            if (z) {
                if (this == sMainTvView.get() && this.mSession != null) {
                    this.mSession.setMain();
                }
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mWindowZOrder != 2) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        super.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (this.mWindowZOrder != 2 && region != null) {
            int width = getWidth();
            int height = getHeight();
            if (width > 0 && height > 0) {
                int[] iArr = new int[2];
                getLocationInWindow(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                region.op(i, i2, i + width, i2 + height, Region.Op.UNION);
            }
        }
        return super.gatherTransparentRegion(region);
    }

    public String getSelectedTrack(int i) {
        if (this.mSession == null) {
            return null;
        }
        return this.mSession.getSelectedTrack(i);
    }

    public List<TvTrackInfo> getTracks(int i) {
        if (this.mSession == null) {
            return null;
        }
        return this.mSession.getTracks(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        createSessionOverlayView();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeSessionOverlayView();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mUseRequestedSurfaceLayout) {
            this.mSurfaceView.layout(this.mSurfaceViewLeft, this.mSurfaceViewTop, this.mSurfaceViewRight, this.mSurfaceViewBottom);
        } else {
            this.mSurfaceView.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mSurfaceView.measure(i, i2);
        int measuredWidth = this.mSurfaceView.getMeasuredWidth();
        int measuredHeight = this.mSurfaceView.getMeasuredHeight();
        int measuredState = this.mSurfaceView.getMeasuredState();
        setMeasuredDimension(resolveSizeAndState(measuredWidth, i, measuredState), resolveSizeAndState(measuredHeight, i2, measuredState << 16));
    }

    public boolean onUnhandledInputEvent(InputEvent inputEvent) {
        return false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.mSurfaceView.setVisibility(i);
        if (i == 0) {
            createSessionOverlayView();
        } else {
            removeSessionOverlayView();
        }
    }

    public void requestUnblockContent(TvContentRating tvContentRating) {
        if (this.mSession != null) {
            this.mSession.requestUnblockContent(tvContentRating);
        }
    }

    public void reset() {
        synchronized (sMainTvViewLock) {
            if (this == sMainTvView.get()) {
                sMainTvView = NULL_TV_VIEW;
            }
        }
        resetInternal();
    }

    public void selectTrack(int i, String str) {
        if (this.mSession != null) {
            this.mSession.selectTrack(i, str);
        }
    }

    public void sendAppPrivateCommand(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("action cannot be null or an empty string");
        }
        if (this.mSession != null) {
            this.mSession.sendAppPrivateCommand(str, bundle);
            return;
        }
        Log.w(TAG, "sendAppPrivateCommand - session not created (action " + str + " cached)");
        if (this.mAppPrivateCommandAction != null) {
            Log.w(TAG, "previous cached action " + str + " removed");
        }
        this.mAppPrivateCommandAction = str;
        this.mAppPrivateCommandData = bundle;
    }

    public void setCallback(TvInputCallback tvInputCallback) {
        this.mCallback = tvInputCallback;
    }

    public void setCaptionEnabled(boolean z) {
        this.mCaptionEnabled = z ? 1 : 2;
        if (this.mSession != null) {
            this.mSession.setCaptionEnabled(z);
        }
    }

    public void setMain() {
        synchronized (sMainTvViewLock) {
            sMainTvView = new WeakReference<>(this);
            if (hasWindowFocus() && this.mSession != null) {
                this.mSession.setMain();
            }
        }
    }

    public void setOnUnhandledInputEventListener(OnUnhandledInputEventListener onUnhandledInputEventListener) {
        this.mOnUnhandledInputEventListener = onUnhandledInputEventListener;
    }

    public void setStreamVolume(float f) {
        this.mHasStreamVolume = true;
        this.mStreamVolume = f;
        if (this.mSession == null) {
            return;
        }
        this.mSession.setStreamVolume(f);
    }

    public void setZOrderMediaOverlay(boolean z) {
        if (z) {
            this.mWindowZOrder = 1;
            removeSessionOverlayView();
        } else {
            this.mWindowZOrder = 0;
            createSessionOverlayView();
        }
        if (this.mSurfaceView != null) {
            this.mSurfaceView.setZOrderOnTop(false);
            this.mSurfaceView.setZOrderMediaOverlay(z);
        }
    }

    public void setZOrderOnTop(boolean z) {
        if (z) {
            this.mWindowZOrder = 2;
            removeSessionOverlayView();
        } else {
            this.mWindowZOrder = 0;
            createSessionOverlayView();
        }
        if (this.mSurfaceView != null) {
            this.mSurfaceView.setZOrderMediaOverlay(false);
            this.mSurfaceView.setZOrderOnTop(z);
        }
    }

    public void tune(String str, Uri uri) {
        tune(str, uri, null);
    }

    public void tune(String str, Uri uri, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("inputId cannot be null or an empty string");
        }
        synchronized (sMainTvViewLock) {
            if (sMainTvView.get() == null) {
                sMainTvView = new WeakReference<>(this);
            }
        }
        if (this.mSessionCallback == null || !this.mSessionCallback.mInputId.equals(str)) {
            resetInternal();
            this.mSessionCallback = new MySessionCallback(str, uri, bundle);
            if (this.mTvInputManager != null) {
                this.mTvInputManager.createSession(str, this.mSessionCallback, this.mHandler);
            }
        } else if (this.mSession != null) {
            this.mSession.tune(uri, bundle);
        } else {
            this.mSessionCallback.mChannelUri = uri;
            this.mSessionCallback.mTuneParams = bundle;
        }
    }
}
