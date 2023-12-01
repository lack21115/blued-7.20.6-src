package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.h;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/ui/TXCloudVideoView.class */
public class TXCloudVideoView extends FrameLayout implements ScaleGestureDetector.OnScaleGestureListener {
    private static final int FOCUS_AREA_SIZE_IN_DP = 70;
    private WeakReference<b> mCallback;
    private final DashBoard mDashBoard;
    private final Rect mDashMargin;
    private final a mDelayedTapRunnable;
    private boolean mEnableShowLog;
    private boolean mEnableTouchToFocus;
    private boolean mEnableZoom;
    private FocusIndicatorView mFocusIndicatorView;
    protected Object mGLContext;
    private final Runnable mHideIndicatorViewRunnable;
    private float mLastScaleFactor;
    private float mScaleFactor;
    private final ScaleGestureDetector mScaleGestureDetector;
    private final WeakReference<SurfaceView> mSurfaceView;
    private final String mTAG;
    private com.tencent.rtmp.ui.a mTapListener;
    private String mUserId;
    private TextureView mVideoView;
    private com.tencent.rtmp.ui.b mZoomListener;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/ui/TXCloudVideoView$a.class */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Point f38687a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f38688c;

        private a() {
            this.f38687a = new Point();
            this.b = 0;
            this.f38688c = 0;
        }

        /* synthetic */ a(TXCloudVideoView tXCloudVideoView, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (TXCloudVideoView.this.mTapListener != null) {
                TXCloudVideoView.this.mTapListener.a(this.f38687a.x, this.f38687a.y, this.b, this.f38688c);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/ui/TXCloudVideoView$b.class */
    public interface b {
        void onShowLog(boolean z);
    }

    public TXCloudVideoView(Context context) {
        this(context, null);
    }

    public TXCloudVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, null);
    }

    public TXCloudVideoView(Context context, AttributeSet attributeSet, SurfaceView surfaceView) {
        super(context, attributeSet);
        this.mTAG = "TXCloudVideoView_" + hashCode();
        this.mDashMargin = new Rect();
        this.mEnableTouchToFocus = false;
        this.mDelayedTapRunnable = new a(this, (byte) 0);
        this.mEnableZoom = false;
        this.mUserId = "";
        this.mHideIndicatorViewRunnable = c.a(this);
        this.mDashBoard = new DashBoard(context);
        this.mSurfaceView = surfaceView != null ? new WeakReference<>(surfaceView) : null;
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this);
    }

    public TXCloudVideoView(SurfaceView surfaceView) {
        this(surfaceView.getContext(), null, surfaceView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideIndicatorView() {
        FocusIndicatorView focusIndicatorView = this.mFocusIndicatorView;
        if (focusIndicatorView != null) {
            focusIndicatorView.setVisibility(8);
        }
    }

    private boolean isShowLogEnabled() {
        return this.mEnableShowLog;
    }

    private static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void repositionDashBoard() {
        removeView(this.mDashBoard);
        addView(this.mDashBoard);
    }

    private void setShowLogCallback(WeakReference<b> weakReference) {
        this.mCallback = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFocusViewInternal(int i, int i2, int i3, int i4) {
        if (i3 != getWidth() || i4 != getHeight()) {
            LiteavLog.i(this.mTAG, "ignore show indicator view when view size changed");
            return;
        }
        LiteavLog.v(this.mTAG, "show indicator view at (%d,%d)", Integer.valueOf(i), Integer.valueOf(i2));
        removeCallbacks(this.mHideIndicatorViewRunnable);
        int i5 = (int) ((getResources().getDisplayMetrics().density * 70.0f) + 0.5f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i5);
        int i6 = i5 / 2;
        layoutParams.leftMargin = h.a(i - i6, 0, getWidth() - i5);
        layoutParams.topMargin = h.a(i2 - i6, 0, getHeight() - i5);
        View view = this.mFocusIndicatorView;
        if (view == null) {
            FocusIndicatorView focusIndicatorView = new FocusIndicatorView(getContext());
            this.mFocusIndicatorView = focusIndicatorView;
            addView(focusIndicatorView, layoutParams);
        } else if (indexOfChild(view) != getChildCount() - 1) {
            removeView(this.mFocusIndicatorView);
            addView(this.mFocusIndicatorView, layoutParams);
        } else {
            this.mFocusIndicatorView.setLayoutParams(layoutParams);
        }
        this.mFocusIndicatorView.setVisibility(0);
        FocusIndicatorView focusIndicatorView2 = this.mFocusIndicatorView;
        focusIndicatorView2.startAnimation(focusIndicatorView2.f38683a);
        postDelayed(this.mHideIndicatorViewRunnable, TimeUnit.SECONDS.toMillis(1L));
    }

    public void addVideoView(TextureView textureView) {
        TextureView textureView2 = this.mVideoView;
        if (textureView2 != null) {
            removeView(textureView2);
        }
        this.mVideoView = textureView;
        addView(textureView);
        repositionDashBoard();
    }

    public void clearLastFrame(boolean z) {
        if (z) {
            setVisibility(8);
        }
    }

    public void clearLog() {
        DashBoard dashBoard = this.mDashBoard;
        if (dashBoard != null) {
            dashBoard.f38681a.setLength(0);
            if (dashBoard.b != null) {
                dashBoard.b.setText("");
            }
            if (dashBoard.f38682c != null) {
                dashBoard.f38682c.setText("");
            }
        }
    }

    public void disableLog(boolean z) {
    }

    public TextureView getHWVideoView() {
        return this.mVideoView;
    }

    public Object getOpenGLContext() {
        return this.mGLContext;
    }

    public SurfaceView getSurfaceView() {
        WeakReference<SurfaceView> weakReference = this.mSurfaceView;
        if (weakReference == null) {
            return null;
        }
        SurfaceView surfaceView = weakReference.get();
        if (surfaceView == null) {
            LiteavLog.w(this.mTAG, "surfaceView is null.");
        }
        return surfaceView;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public TextureView getVideoView() {
        return this.mVideoView;
    }

    public void onDestroy() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mDashBoard.a(this.mDashMargin.left, this.mDashMargin.top, this.mDashMargin.right, this.mDashMargin.bottom);
        this.mDashBoard.setStatusTextSize((float) (px2dip(getContext(), getWidth()) / 30.0d));
        this.mDashBoard.setEventTextSize((float) (px2dip(getContext(), getWidth()) / 25.0d));
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (this.mEnableZoom) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            float f = this.mLastScaleFactor;
            this.mLastScaleFactor = scaleGestureDetector.getScaleFactor();
            float a2 = h.a(this.mScaleFactor + (scaleFactor - f), 0.0f, 1.0f);
            this.mScaleFactor = a2;
            com.tencent.rtmp.ui.b bVar = this.mZoomListener;
            if (bVar != null) {
                bVar.a(a2);
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.mLastScaleFactor = scaleGestureDetector.getScaleFactor();
        return this.mEnableZoom;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1 && motionEvent.getAction() == 0) {
            if (this.mEnableTouchToFocus) {
                a aVar = this.mDelayedTapRunnable;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int width = getWidth();
                int height = getHeight();
                aVar.f38687a.x = x;
                aVar.f38687a.y = y;
                aVar.b = width;
                aVar.f38688c = height;
                removeCallbacks(this.mDelayedTapRunnable);
                postDelayed(this.mDelayedTapRunnable, 100L);
            }
        } else if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2 && this.mEnableZoom) {
            removeCallbacks(this.mDelayedTapRunnable);
            hideIndicatorView();
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
        }
        if (this.mEnableZoom) {
            if (motionEvent.getAction() == 0) {
                performClick();
                return true;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeVideoView() {
        TextureView textureView = this.mVideoView;
        if (textureView != null) {
            removeView(textureView);
            this.mVideoView = null;
        }
    }

    public void setDashBoardMarginInPx(int i, int i2, int i3, int i4) {
        this.mDashMargin.left = i;
        this.mDashMargin.right = i2;
        this.mDashMargin.top = i3;
        this.mDashMargin.bottom = i4;
        this.mDashBoard.a(i, i3, i2, i4);
    }

    public void setDashBoardMarginInRatio(final float f, final float f2, final float f3, final float f4) {
        postDelayed(new Runnable() { // from class: com.tencent.rtmp.ui.TXCloudVideoView.1
            @Override // java.lang.Runnable
            public final void run() {
                TXCloudVideoView tXCloudVideoView = TXCloudVideoView.this;
                tXCloudVideoView.setDashBoardMarginInPx((int) (tXCloudVideoView.getWidth() * f), (int) (TXCloudVideoView.this.getWidth() * f2), (int) (TXCloudVideoView.this.getHeight() * f3), (int) (TXCloudVideoView.this.getHeight() * f4));
            }
        }, 100L);
    }

    public void setLogMargin(float f, float f2, float f3, float f4) {
        setDashBoardMarginInPx((int) f, (int) f2, (int) f3, (int) f4);
    }

    public void setOpenGLContext(Object obj) {
        this.mGLContext = obj;
    }

    public void setTouchToFocusEnabled(boolean z, com.tencent.rtmp.ui.a aVar) {
        this.mEnableTouchToFocus = z;
        this.mTapListener = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setZoomEnabled(boolean z, com.tencent.rtmp.ui.b bVar) {
        LiteavLog.i(this.mTAG, "setZoomEnabled: ".concat(String.valueOf(z)));
        this.mEnableZoom = z;
        this.mZoomListener = bVar;
    }

    public void showFocusView(int i, int i2, int i3, int i4) {
        post(d.a(this, i, i2, i3, i4));
    }

    public void showLog(boolean z) {
        this.mEnableShowLog = z;
        WeakReference<b> weakReference = this.mCallback;
        b bVar = weakReference == null ? null : weakReference.get();
        if (bVar != null) {
            bVar.onShowLog(z);
        }
    }
}
