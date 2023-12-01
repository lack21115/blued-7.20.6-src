package com.blued.android.module.yy_china.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPopupWindow.class */
public class YYPopupWindow extends PopupWindow {
    private PopupwindowFactory.Builder a;
    private View b;

    public YYPopupWindow(Context context, PopupwindowFactory.Builder builder) {
        super(context);
        this.a = builder;
        a();
    }

    private void a() {
        setContentView(this.a.c());
        setWidth(this.a.a());
        setHeight(this.a.b());
        setBackgroundDrawable(new ColorDrawable(0));
        if (this.a.f()) {
            setOutsideTouchable(true);
            setFocusable(true);
            return;
        }
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(false);
        getContentView().setFocusable(true);
        getContentView().setFocusableInTouchMode(true);
        getContentView().setOnKeyListener(new View.OnKeyListener() { // from class: com.blued.android.module.yy_china.view.YYPopupWindow.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    YYPopupWindow.this.dismiss();
                    return true;
                }
                return false;
            }
        });
        setTouchInterceptor(new View.OnTouchListener() { // from class: com.blued.android.module.yy_china.view.YYPopupWindow.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() != 0 || (x >= 0 && x < YYPopupWindow.this.a.c().getMeasuredWidth() && y >= 0 && y < YYPopupWindow.this.a.c().getMeasuredHeight())) {
                    return motionEvent.getAction() == 4;
                }
                LogUtils.d("YYPopupWindow", "pop width: " + YYPopupWindow.this.a.c().getMeasuredWidth() + "; height: " + YYPopupWindow.this.a.c().getMeasuredHeight());
                return true;
            }
        });
    }

    private void a(float f) {
        Logger.e("YYPopupWindow", "backgroundAlpha ... bgAlpha = " + f);
        if (this.b == null) {
            Window window = ((Activity) this.a.d()).getWindow();
            View view = new View(this.a.d());
            this.b = view;
            window.addContentView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (f < 1.0f) {
            this.b.setBackgroundColor(this.a.d().getResources().getColor(this.a.e()));
            return;
        }
        View view2 = this.b;
        if (view2 == null || view2.getParent() == null || !(this.b.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.b.getParent()).removeView(this.b);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        Logger.e("YYPopupWindow", "dismiss ... ");
        a(1.0f);
        if (this.a.g() != null) {
            this.a.g().b();
        }
        PopupwindowFactory.Builder builder = this.a;
        if (builder != null) {
            builder.a((Context) null);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        super.showAsDropDown(view, i, i2, i3);
        if (this.a.g() != null) {
            this.a.g().a();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        Logger.e("YYPopupWindow", "showAtLocation ... ");
        a(0.3f);
        if (this.a.g() != null) {
            this.a.g().a();
        }
    }
}
