package com.blued.android.module.media.selector.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.blued.android.core.AppInfo;
import com.blued.android.module.media.selector.R;
import com.bytedance.applog.tracker.Tracker;
import java.util.TimerTask;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/widget/PopMenu.class */
public class PopMenu {
    private static boolean f = false;
    private ViewGroup a;
    private View b;
    private View c;
    private Context d;
    private MyPopupWindow e;

    /* renamed from: com.blued.android.module.media.selector.widget.PopMenu$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/widget/PopMenu$3.class */
    class AnonymousClass3 extends Handler {
        final /* synthetic */ PopMenu a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a();
            boolean unused = PopMenu.f = false;
            super.handleMessage(message);
        }
    }

    /* renamed from: com.blued.android.module.media.selector.widget.PopMenu$4  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/widget/PopMenu$4.class */
    class AnonymousClass4 extends TimerTask {
        final /* synthetic */ Handler a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            this.a.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/widget/PopMenu$MyPopupWindow.class */
    public class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                PopMenu.this.a();
            } catch (Exception e) {
                a();
            }
        }
    }

    public PopMenu(Context context, View view) {
        this.d = context;
        this.a = new FrameLayout(context);
        View view2 = new View(context);
        this.b = view2;
        view2.setBackgroundColor(View.MEASURED_STATE_MASK);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.media.selector.widget.PopMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                PopMenu.this.a();
            }
        });
        this.c = view;
        view.setBackgroundColor(this.d.getResources().getColor(R.color.window_bg_color));
        this.c.setVisibility(8);
        this.a.addView(this.b, -1, -1);
        this.a.addView(this.c, -1, -2);
        MyPopupWindow myPopupWindow = new MyPopupWindow(this.a, -1, -1, true);
        this.e = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.d.getResources().getDrawable(com.android.internal.R.color.transparent));
        this.e.setTouchable(true);
        this.e.setOutsideTouchable(true);
        this.e.setFocusable(true);
        this.e.setAnimationStyle(R.style.PopupAnimation);
        this.e.update();
    }

    public void a() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.c.setVisibility(8);
        this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_top_out2));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.media.selector.widget.PopMenu.5
            @Override // java.lang.Runnable
            public void run() {
                PopMenu.this.e.a();
            }
        }, 320L);
    }

    public void a(View view) {
        this.b.clearAnimation();
        this.c.clearAnimation();
        if (this.e.isShowing()) {
            this.e.a();
        }
        if (Build.VERSION.SDK_INT < 24) {
            this.e.showAsDropDown(view);
        } else {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int height = iArr[1] + view.getHeight();
            if (Build.VERSION.SDK_INT >= 25) {
                this.e.setHeight(((WindowManager) this.d.getSystemService("window")).getDefaultDisplay().getHeight() - height);
            }
            this.e.showAtLocation(view, 0, 0, height);
        }
        this.c.setVisibility(8);
        this.b.setVisibility(8);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.media.selector.widget.PopMenu.2
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setFillAfter(true);
                PopMenu.this.b.startAnimation(alphaAnimation);
                PopMenu.this.b.setVisibility(0);
                PopMenu.this.c.startAnimation(AnimationUtils.loadAnimation(PopMenu.this.d, R.anim.push_top_in2));
                PopMenu.this.c.setVisibility(0);
            }
        }, 50L);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.e.setOnDismissListener(onDismissListener);
    }
}
