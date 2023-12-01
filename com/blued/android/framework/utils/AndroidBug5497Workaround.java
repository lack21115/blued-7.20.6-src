package com.blued.android.framework.utils;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/AndroidBug5497Workaround.class */
public class AndroidBug5497Workaround {

    /* renamed from: a  reason: collision with root package name */
    private View f10066a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private FrameLayout.LayoutParams f10067c;
    private int d;
    private boolean e;
    private int f;

    /* renamed from: com.blued.android.framework.utils.AndroidBug5497Workaround$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/AndroidBug5497Workaround$1.class */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AndroidBug5497Workaround f10068a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f10068a.e) {
                AndroidBug5497Workaround androidBug5497Workaround = this.f10068a;
                androidBug5497Workaround.d = androidBug5497Workaround.f10066a.getHeight();
                this.f10068a.e = false;
            }
            this.f10068a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int b = b();
        if (b != this.b) {
            int height = this.f10066a.getRootView().getHeight();
            int i = height - b;
            if (i <= height / 4) {
                this.f10067c.height = this.d;
            } else if (Build.VERSION.SDK_INT >= 19) {
                this.f10067c.height = (height - i) + this.f;
            } else {
                this.f10067c.height = height - i;
            }
            this.f10066a.requestLayout();
            this.b = b;
        }
    }

    private int b() {
        Rect rect = new Rect();
        this.f10066a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }
}
