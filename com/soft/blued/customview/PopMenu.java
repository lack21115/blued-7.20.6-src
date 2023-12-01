package com.soft.blued.customview;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PopMenu.class */
public class PopMenu {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f14778a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public View f14779c;
    public Context d;
    public MyPopupWindow e;
    public ViewGroup f;
    public onShowListener g;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PopMenu$MyPopupWindow.class */
    class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                PopMenu.this.d();
            } catch (Exception e) {
                a();
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PopMenu$onShowListener.class */
    public interface onShowListener {
        void a();
    }

    public PopMenu(Context context, View view) {
        this.d = context;
        this.f14778a = new RelativeLayout(context);
        this.f = new RelativeLayout(context);
        View view2 = new View(context);
        this.b = view2;
        view2.setBackgroundColor(Color.parseColor("#B3000000"));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.PopMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                PopMenu.this.d();
            }
        });
        this.f14779c = view;
        if (c() > 0) {
            this.f14779c.setBackgroundColor(c());
        }
        this.f14778a.addView(this.b, -1, -1);
        this.f.addView(this.f14779c, b());
        this.f14778a.addView(this.f, b());
        MyPopupWindow myPopupWindow = new MyPopupWindow(this.f14778a, -1, -1, true);
        this.e = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.d.getResources().getDrawable(R.color.transparent));
        this.e.setTouchable(true);
        this.e.setFocusable(true);
        this.e.setOutsideTouchable(true);
        this.e.update();
    }

    private boolean a(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        Rect rect = new Rect();
        try {
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            if (rect.height() != AppInfo.m - StatusBarHelper.a(context)) {
                z = true;
            }
            return z;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(View view) {
        this.b.clearAnimation();
        this.f.clearAnimation();
        if (this.e.isShowing()) {
            this.e.a();
        }
        if (Build.VERSION.SDK_INT < 24) {
            this.e.showAsDropDown(view);
        } else {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int height = iArr[1] + view.getHeight();
            this.e.getHeight();
            int height2 = ((WindowManager) this.d.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight() - height;
            int i = height2;
            if (a(this.d)) {
                i = height2 + StatusBarHelper.a(this.d);
            }
            this.e.setHeight(i);
            this.e.showAtLocation(((Activity) this.d).getWindow().getDecorView(), 0, 0, height);
        }
        this.f.setVisibility(8);
        this.b.setVisibility(8);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.customview.PopMenu.2
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setFillAfter(true);
                PopMenu.this.b.startAnimation(alphaAnimation);
                PopMenu.this.b.setVisibility(0);
                PopMenu.this.f.startAnimation(AnimationUtils.loadAnimation(PopMenu.this.d, com.blued.android.module_share_china.R.anim.push_top_in2));
                PopMenu.this.f.setVisibility(0);
                if (PopMenu.this.g != null) {
                    PopMenu.this.g.a();
                }
            }
        }, 10L);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.e.setOnDismissListener(onDismissListener);
    }

    public void a(onShowListener onshowlistener) {
        this.g = onshowlistener;
    }

    public boolean a() {
        return this.e.isShowing();
    }

    public RelativeLayout.LayoutParams b() {
        return new RelativeLayout.LayoutParams(-1, -2);
    }

    public int c() {
        return this.d.getResources().getColor(com.blued.android.module_share_china.R.color.window_bg_color);
    }

    public void d() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f.setVisibility(8);
        this.f.startAnimation(AnimationUtils.loadAnimation(this.d, com.blued.android.module_share_china.R.anim.push_top_out2));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.customview.PopMenu.3
            @Override // java.lang.Runnable
            public void run() {
                PopMenu.this.e.a();
            }
        }, 320L);
    }
}
