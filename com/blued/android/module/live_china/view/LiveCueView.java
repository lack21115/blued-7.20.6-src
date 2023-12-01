package com.blued.android.module.live_china.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveCueView.class */
public class LiveCueView {

    /* renamed from: a  reason: collision with root package name */
    public View f14444a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public View f14445c;
    public Context d;
    public LayoutInflater e;
    private TextView f;
    private MyPopupWindow g;
    private String h;
    private boolean i;
    private int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveCueView$MyPopupWindow.class */
    public class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            if (!(LiveCueView.this.d instanceof Activity) || Build.VERSION.SDK_INT < 17 || ((Activity) LiveCueView.this.d).isFinishing() || ((Activity) LiveCueView.this.d).isDestroyed()) {
                return;
            }
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                LiveCueView.this.d();
            } catch (Exception e) {
                a();
            }
        }
    }

    public LiveCueView(Context context, String str) {
        this.h = "";
        this.i = true;
        this.j = 5000;
        this.h = str;
        this.d = context;
        f();
    }

    public LiveCueView(Context context, String str, int i, int i2, int i3, int i4, int i5, boolean z, int i6, int i7) {
        this.h = "";
        this.i = true;
        this.j = 5000;
        this.h = str;
        this.d = context;
        this.i = z;
        this.j = i7;
        f();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = DensityUtils.a(this.d, i2);
        layoutParams.topMargin = DensityUtils.a(this.d, i3);
        layoutParams.rightMargin = DensityUtils.a(this.d, i4);
        layoutParams.bottomMargin = DensityUtils.a(this.d, i5);
        layoutParams.gravity = i;
        this.f14445c.setLayoutParams(layoutParams);
        if (i6 != 0) {
            this.f14445c.setBackgroundResource(i6);
        }
    }

    public static void a(Context context, String str) {
        new LiveCueView(context, str).b();
    }

    public static void a(Context context, String str, int i, int i2, int i3, int i4, int i5, boolean z, int i6, int i7) {
        new LiveCueView(context, str, i, i2, i3, i4, i5, z, i6, i7).b();
    }

    private void f() {
        this.e = LayoutInflater.from(this.d);
        a();
        View findViewById = this.f14444a.findViewById(R.id.tv_bg);
        this.b = findViewById;
        findViewById.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveCueView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveCueView.this.d();
            }
        });
        View findViewById2 = this.f14444a.findViewById(R.id.ll_content);
        this.f14445c = findViewById2;
        findViewById2.setVisibility(8);
        this.f14445c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveCueView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(this.f14444a, -1, -1, true);
        this.g = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
        this.g.setTouchable(true);
        this.g.setOutsideTouchable(true);
        this.g.setFocusable(true);
        this.g.update();
        TextView textView = (TextView) this.f14444a.findViewById(R.id.cue_text);
        this.f = textView;
        textView.setText(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int a2;
        int a3;
        int a4 = DensityUtils.a(this.d, 3.6f);
        float f = a4;
        float f2 = -a4;
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f14445c, "translationY", 0.0f, f, f2, f, f2, DensityUtils.a(this.d, 3.6f), -a2, DensityUtils.a(this.d, 3.6f), -a3, 0.0f).setDuration(5000L);
        duration.setInterpolator(new LinearInterpolator());
        duration.start();
    }

    public void a() {
        if (LiveFloatManager.a().C()) {
            this.f14444a = this.e.inflate(R.layout.pop_cue_view_center, (ViewGroup) null);
        } else {
            this.f14444a = this.e.inflate(R.layout.pop_cue_view, (ViewGroup) null);
        }
    }

    public void b() {
        this.b.clearAnimation();
        this.f14445c.clearAnimation();
        if (this.g.isShowing()) {
            this.g.a();
        }
        this.g.showAtLocation(this.f14444a, 49, 0, 0);
        this.f14445c.setVisibility(0);
        c();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveCueView.3
            @Override // java.lang.Runnable
            public void run() {
                LiveCueView.this.d();
            }
        }, this.j);
    }

    public void c() {
        this.f14445c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_in));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveCueView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (LiveCueView.this.i) {
                    LiveCueView.this.g();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void d() {
        if (this.f14445c.getVisibility() == 8) {
            return;
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveCueView.5
            @Override // java.lang.Runnable
            public void run() {
                LiveCueView.this.g.a();
            }
        }, 320L);
        e();
        this.f14445c.setVisibility(8);
    }

    public void e() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f14445c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
    }
}
