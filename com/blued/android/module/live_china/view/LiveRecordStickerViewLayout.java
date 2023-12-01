package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.customview.widget.ViewDragHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRecordLevelStickerModel;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRecordStickerViewLayout.class */
public class LiveRecordStickerViewLayout extends FrameLayout {
    private ViewDragHelper a;
    private ImageView b;
    private View c;
    private View d;
    private Context e;
    private int f;
    private int g;
    private View h;
    private View i;
    private ViewDragHelper.Callback j;
    private RecordingOnliveFragment k;
    private LiveRecordLevelStickerModel l;

    public LiveRecordStickerViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new ViewDragHelper.Callback() { // from class: com.blued.android.module.live_china.view.LiveRecordStickerViewLayout.1
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                int paddingLeft = LiveRecordStickerViewLayout.this.getPaddingLeft();
                return Math.min(Math.max(i, paddingLeft), (LiveRecordStickerViewLayout.this.getWidth() - view.getWidth()) - paddingLeft);
            }

            public int clampViewPositionVertical(View view, int i, int i2) {
                int paddingTop = LiveRecordStickerViewLayout.this.getPaddingTop();
                return Math.min(Math.max(i, paddingTop), (LiveRecordStickerViewLayout.this.getHeight() - view.getHeight()) - paddingTop);
            }

            public int getViewHorizontalDragRange(View view) {
                return LiveRecordStickerViewLayout.this.getMeasuredWidth() - view.getMeasuredWidth();
            }

            public int getViewVerticalDragRange(View view) {
                return LiveRecordStickerViewLayout.this.getMeasuredHeight() - view.getMeasuredHeight();
            }

            public void onViewCaptured(View view, int i) {
                super.onViewCaptured(view, i);
                LiveRecordStickerViewLayout.this.f = view.getLeft();
                LiveRecordStickerViewLayout.this.g = view.getTop();
            }

            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (i == 0) {
                    LiveRecordStickerViewLayout.this.c.setVisibility(4);
                    LiveRecordStickerViewLayout.this.h.setVisibility(4);
                    LiveRecordStickerViewLayout.this.i.setVisibility(4);
                    LiveRecordStickerViewLayout.this.k.cL.setBackgroundColor(LiveRecordStickerViewLayout.this.e.getResources().getColor(R.color.transparent));
                } else if (i == 1) {
                    LiveRecordStickerViewLayout.this.c.setVisibility(0);
                    LiveRecordStickerViewLayout.this.h.setVisibility(0);
                    LiveRecordStickerViewLayout.this.i.setVisibility(0);
                    LiveRecordStickerViewLayout.this.k.cL.setBackgroundColor(LiveRecordStickerViewLayout.this.e.getResources().getColor(R.color.color_4c000000));
                }
                Log.v("pk", "onViewDragStateChanged state:" + i);
            }

            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
            }

            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                int left = view.getLeft();
                int top = view.getTop();
                int right = view.getRight();
                int bottom = view.getBottom();
                Log.v("drb", "onViewReleased stickerLeft:" + left + " -- stickerTop:" + top);
                LiveRecordStickerViewLayout liveRecordStickerViewLayout = LiveRecordStickerViewLayout.this;
                if (liveRecordStickerViewLayout.a(liveRecordStickerViewLayout.c, left, bottom)) {
                    LiveRecordStickerViewLayout.this.c.setVisibility(4);
                    LiveRecordStickerViewLayout.this.b.setVisibility(8);
                    LiveRecordStickerViewLayout.this.b.startAnimation(AnimationUtils.loadAnimation(LiveRecordStickerViewLayout.this.e, R.anim.push_center_out));
                    LiveRecordStickerViewLayout.this.b();
                    LiveRecordStickerViewLayout.this.k.a(LiveRecordStickerViewLayout.this.l);
                    return;
                }
                LiveRecordStickerViewLayout liveRecordStickerViewLayout2 = LiveRecordStickerViewLayout.this;
                if (liveRecordStickerViewLayout2.a(liveRecordStickerViewLayout2.h, left, top)) {
                    LiveRecordStickerViewLayout.this.a.settleCapturedViewAt(LiveRecordStickerViewLayout.this.f, LiveRecordStickerViewLayout.this.g);
                    LiveRecordStickerViewLayout.this.invalidate();
                    return;
                }
                LiveRecordStickerViewLayout liveRecordStickerViewLayout3 = LiveRecordStickerViewLayout.this;
                if (liveRecordStickerViewLayout3.a(liveRecordStickerViewLayout3.i, right, top)) {
                    LiveRecordStickerViewLayout.this.a.settleCapturedViewAt(LiveRecordStickerViewLayout.this.f, LiveRecordStickerViewLayout.this.g);
                    LiveRecordStickerViewLayout.this.invalidate();
                    return;
                }
                LiveRecordStickerViewLayout liveRecordStickerViewLayout4 = LiveRecordStickerViewLayout.this;
                liveRecordStickerViewLayout4.a(left, top, liveRecordStickerViewLayout4.l);
            }

            public boolean tryCaptureView(View view, int i) {
                return view == LiveRecordStickerViewLayout.this.b;
            }
        };
        this.e = context;
        a();
    }

    private void a() {
        this.a = ViewDragHelper.create(this, 1.0f, this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && i >= i3 && i <= view.getMeasuredWidth() + i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.k.ac.v();
    }

    public void a(int i, int i2, LiveRecordLevelStickerModel liveRecordLevelStickerModel) {
        if (liveRecordLevelStickerModel == null) {
            return;
        }
        Log.v("drb", "viewX:" + i);
        float f = ((float) i) / ((float) AppInfo.l);
        float f2 = ((float) i2) / ((float) AppInfo.m);
        LiveRoomPreferences.z(i + BridgeUtil.UNDERLINE_STR + i2);
        RecordingOnliveFragment recordingOnliveFragment = this.k;
        if (recordingOnliveFragment == null || recordingOnliveFragment.ac == null) {
            return;
        }
        this.k.ac.a(f, f2, liveRecordLevelStickerModel.image);
    }

    public void a(RecordingOnliveFragment recordingOnliveFragment) {
        this.k = recordingOnliveFragment;
    }

    public void a(final LiveRecordLevelStickerModel liveRecordLevelStickerModel) {
        this.l = liveRecordLevelStickerModel;
        if (liveRecordLevelStickerModel == null) {
            b();
            this.b.setVisibility(8);
            this.b.startAnimation(AnimationUtils.loadAnimation(this.e, R.anim.push_center_out));
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DensityUtils.a(this.e, 90.0f), DensityUtils.a(this.e, 45.0f));
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        if (this.b.getVisibility() == 8) {
            this.b.setVisibility(0);
            ImageLoader.a((IRequestHost) null, liveRecordLevelStickerModel.image).a(this.b);
        } else {
            this.b.setVisibility(8);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.e, R.anim.push_center_out);
            this.b.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveRecordStickerViewLayout.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LiveRecordStickerViewLayout.this.b.setVisibility(0);
                    ImageLoader.a((IRequestHost) null, liveRecordLevelStickerModel.image).a(LiveRecordStickerViewLayout.this.b);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveRecordStickerViewLayout.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                LiveRecordStickerViewLayout.this.b.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                Log.v("drb", "changeSticker left:" + i + " -- top:" + i2);
                LiveRecordStickerViewLayout.this.a(i, i2, liveRecordLevelStickerModel);
            }
        }, 500L);
    }

    public void b(int i, int i2, LiveRecordLevelStickerModel liveRecordLevelStickerModel) {
        this.l = liveRecordLevelStickerModel;
        Log.v("drb", "changeLocation x:" + i + " -- y:" + i2);
        this.b.setVisibility(0);
        ImageLoader.a((IRequestHost) null, liveRecordLevelStickerModel.image).a(this.b);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.gravity = 51;
        this.b.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.a.continueSettling(true)) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.b = (ImageView) findViewById(R.id.live_record_sticker_image);
        this.c = findViewById(R.id.live_record_sticker_remove_layout);
        this.d = findViewById(R.id.live_record_sticker_remove_btn);
        this.h = findViewById(R.id.live_record_domain1);
        this.i = findViewById(R.id.live_record_domain2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a.shouldInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        this.a.processTouchEvent(motionEvent);
        return a(this.b, rawX, rawY);
    }
}
