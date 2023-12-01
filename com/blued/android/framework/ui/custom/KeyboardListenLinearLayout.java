package com.blued.android.framework.ui.custom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.KeyboardUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/custom/KeyboardListenLinearLayout.class */
public class KeyboardListenLinearLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    private SwitchPanelRelativeLayout f9877a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9878c;
    private int d;
    private IOnKeyboardStateChangedListener e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/custom/KeyboardListenLinearLayout$IOnKeyboardStateChangedListener.class */
    public interface IOnKeyboardStateChangedListener {
        void a(int i);
    }

    public KeyboardListenLinearLayout(Context context) {
        this(context, null);
    }

    public KeyboardListenLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeyboardListenLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.f9878c = false;
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private void a() {
        Rect rect = new Rect();
        ((Activity) getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = this.d;
        int i2 = i;
        if (i == 0) {
            i2 = AppInfo.m;
        }
        int abs = Math.abs((rect.bottom - rect.top) - i2);
        boolean z = Math.abs(abs) > i2 / 5;
        if (abs == 0 || !z) {
            return;
        }
        KeyboardUtils.a(abs);
    }

    private boolean a(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        boolean z = false;
        if (rect.bottom == AppInfo.l) {
            return false;
        }
        if (view.getBottom() - rect.bottom > view.getResources().getDisplayMetrics().density * 100.0f) {
            z = true;
        }
        return z;
    }

    private SwitchPanelRelativeLayout b(View view) {
        SwitchPanelRelativeLayout switchPanelRelativeLayout = this.f9877a;
        if (switchPanelRelativeLayout != null) {
            return switchPanelRelativeLayout;
        }
        if (view instanceof SwitchPanelRelativeLayout) {
            SwitchPanelRelativeLayout switchPanelRelativeLayout2 = (SwitchPanelRelativeLayout) view;
            this.f9877a = switchPanelRelativeLayout2;
            return switchPanelRelativeLayout2;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    return null;
                }
                SwitchPanelRelativeLayout b = b(viewGroup.getChildAt(i2));
                if (b != null) {
                    this.f9877a = b;
                    return b;
                }
                i = i2 + 1;
            }
        }
    }

    private void b() {
        Rect rect = new Rect();
        ((Activity) getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.d = rect.bottom - rect.top;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.e != null) {
            if (this.f9877a == null) {
                b(this);
            }
            if (!this.b) {
                this.b = true;
                IOnKeyboardStateChangedListener iOnKeyboardStateChangedListener = this.e;
                if (iOnKeyboardStateChangedListener != null) {
                    iOnKeyboardStateChangedListener.a(-1);
                }
            } else if (a(getRootView())) {
                if (!this.f9878c) {
                    SwitchPanelRelativeLayout switchPanelRelativeLayout = this.f9877a;
                    if (switchPanelRelativeLayout != null) {
                        switchPanelRelativeLayout.c();
                        this.f9877a.a(true);
                    }
                    this.f9878c = true;
                    this.e.a(-3);
                    a();
                }
            } else if (this.f9878c) {
                SwitchPanelRelativeLayout switchPanelRelativeLayout2 = this.f9877a;
                if (switchPanelRelativeLayout2 != null && switchPanelRelativeLayout2.a()) {
                    this.f9877a.a(false);
                    this.f9877a.b();
                }
                this.f9878c = false;
                this.e.a(-2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setOnKeyboardStateChangedListener(IOnKeyboardStateChangedListener iOnKeyboardStateChangedListener) {
        this.e = iOnKeyboardStateChangedListener;
    }
}
