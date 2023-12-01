package com.soft.blued.ui.setting.View;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/View/ModifyUserInfoPopView.class */
public class ModifyUserInfoPopView {

    /* renamed from: a  reason: collision with root package name */
    public View f33259a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public View f33260c;
    public Context d;
    public LayoutInflater e;
    private TextView f;
    private TextView g;
    private MyPopupWindow h;
    private String i;
    private String j;
    private View.OnClickListener k;
    private int l;
    private int m;
    private int n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/View/ModifyUserInfoPopView$MyPopupWindow.class */
    public class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            if (!(ModifyUserInfoPopView.this.d instanceof Activity) || Build.VERSION.SDK_INT < 17 || ((Activity) ModifyUserInfoPopView.this.d).isFinishing() || ((Activity) ModifyUserInfoPopView.this.d).isDestroyed()) {
                return;
            }
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                ModifyUserInfoPopView.this.d();
            } catch (Exception e) {
                a();
            }
        }
    }

    public ModifyUserInfoPopView(Context context, String str, String str2, int i, int i2, int i3, View.OnClickListener onClickListener) {
        this.i = "";
        this.j = "";
        this.i = str;
        this.j = str2;
        this.d = context;
        this.k = onClickListener;
        this.l = i;
        this.m = i2;
        this.n = i3;
        Log.v("drb", "top:" + i3 + "--right:" + i2);
        f();
    }

    private void f() {
        this.e = LayoutInflater.from(this.d);
        a();
        View findViewById = this.f33259a.findViewById(2131370973);
        this.b = findViewById;
        findViewById.setBackgroundColor(this.d.getResources().getColor(2131102388));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.View.ModifyUserInfoPopView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        View findViewById2 = this.f33259a.findViewById(2131367715);
        this.f33260c = findViewById2;
        findViewById2.setVisibility(8);
        this.f33260c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.View.ModifyUserInfoPopView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(this.f33259a, -1, -1, true);
        this.h = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
        this.h.setTouchable(true);
        this.h.setOutsideTouchable(true);
        this.h.setFocusable(true);
        this.h.update();
        this.f = (TextView) this.f33259a.findViewById(2131372708);
        this.g = (TextView) this.f33259a.findViewById(2131371023);
        this.f.setText(this.i);
        this.g.setText(this.j);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.m;
        layoutParams.topMargin = this.n;
        layoutParams.gravity = this.l;
        this.f33260c.setLayoutParams(layoutParams);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.View.ModifyUserInfoPopView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ModifyUserInfoPopView.this.k != null) {
                    ModifyUserInfoPopView.this.k.onClick(view);
                }
            }
        });
    }

    private void g() {
        this.f33260c.startAnimation(AnimationUtils.loadAnimation(this.d, 2130772112));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.setting.View.ModifyUserInfoPopView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void a() {
        this.f33259a = this.e.inflate(R.layout.modify_user_info_pop_view, (ViewGroup) null);
    }

    public boolean b() {
        return this.f33260c.getVisibility() == 0;
    }

    public void c() {
        this.b.clearAnimation();
        this.f33260c.clearAnimation();
        if (this.h.isShowing()) {
            this.h.a();
        }
        this.h.showAtLocation(this.f33259a, 49, 0, 0);
        this.f33260c.setVisibility(0);
        g();
    }

    public void d() {
        if (this.f33260c.getVisibility() == 8) {
            return;
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.setting.View.ModifyUserInfoPopView.5
            @Override // java.lang.Runnable
            public void run() {
                ModifyUserInfoPopView.this.h.a();
            }
        }, 320L);
        e();
        this.f33260c.setVisibility(8);
    }

    public void e() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f33260c.startAnimation(AnimationUtils.loadAnimation(this.d, 2130772113));
    }
}
