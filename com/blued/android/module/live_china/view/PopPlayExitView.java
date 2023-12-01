package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPlayExitView.class */
public class PopPlayExitView {
    public View a;
    public View b;
    public Context c;
    private MyPopupWindow d;

    /* renamed from: com.blued.android.module.live_china.view.PopPlayExitView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPlayExitView$1.class */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ PopPlayExitView a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.a.a();
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.PopPlayExitView$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPlayExitView$2.class */
    class AnonymousClass2 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.PopPlayExitView$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPlayExitView$3.class */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ PopPlayExitView a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.a.a();
            LiveSetDataObserver.a().l();
            LiveRefreshUIObserver.a().s();
            EventTrackLive.a(LiveProtos.Event.LIVE_EXIT_GUIDE_FOLLOWED_EXIT_BTN_CLICK);
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.PopPlayExitView$4  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPlayExitView$4.class */
    class AnonymousClass4 implements View.OnClickListener {
        final /* synthetic */ PopPlayExitView a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.a.a();
            LiveRefreshUIObserver.a().s();
            EventTrackLive.a(LiveProtos.Event.LIVE_EXIT_GUIDE_EXIT_BTN_CLICK);
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.PopPlayExitView$6  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPlayExitView$6.class */
    class AnonymousClass6 implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPlayExitView$MyPopupWindow.class */
    class MyPopupWindow extends PopupWindow {
        final /* synthetic */ PopPlayExitView a;

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                this.a.a();
            } catch (Exception e) {
                a();
            }
        }
    }

    private void b() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.a.startAnimation(alphaAnimation);
        this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_out));
    }

    public void a() {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopPlayExitView.5
            @Override // java.lang.Runnable
            public void run() {
                PopPlayExitView.this.d.a();
            }
        }, 320L);
        b();
        this.b.setVisibility(8);
    }
}
