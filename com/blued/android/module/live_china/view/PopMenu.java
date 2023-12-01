package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import com.blued.android.core.AppInfo;
import com.blued.android.module.res_china.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopMenu.class */
public class PopMenu {
    public View a;
    public View b;
    public Context c;
    public MyPopupWindow d;
    public ViewGroup e;
    public onShowListener f;

    /* renamed from: com.blued.android.module.live_china.view.PopMenu$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopMenu$1.class */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ PopMenu a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.a.a();
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.PopMenu$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopMenu$2.class */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ PopMenu a;

        @Override // java.lang.Runnable
        public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setFillAfter(true);
            this.a.a.startAnimation(alphaAnimation);
            this.a.a.setVisibility(0);
            this.a.e.startAnimation(AnimationUtils.loadAnimation(this.a.c, R.anim.push_top_in2));
            this.a.e.setVisibility(0);
            if (this.a.f != null) {
                this.a.f.a();
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopMenu$MyPopupWindow.class */
    class MyPopupWindow extends PopupWindow {
        final /* synthetic */ PopMenu a;

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

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopMenu$onShowListener.class */
    public interface onShowListener {
        void a();
    }

    public void a() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        this.a.startAnimation(alphaAnimation);
        this.e.setVisibility(8);
        this.e.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_top_out2));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopMenu.3
            @Override // java.lang.Runnable
            public void run() {
                PopMenu.this.d.a();
            }
        }, 320L);
    }
}
