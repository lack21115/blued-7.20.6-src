package com.blued.android.framework.utils;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/AndroidBug5497Workaround.class */
public class AndroidBug5497Workaround {
    private View a;
    private int b;
    private FrameLayout.LayoutParams c;
    private int d;
    private boolean e;
    private int f;

    /* renamed from: com.blued.android.framework.utils.AndroidBug5497Workaround$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/AndroidBug5497Workaround$1.class */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ AndroidBug5497Workaround a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.a.e) {
                AndroidBug5497Workaround androidBug5497Workaround = this.a;
                androidBug5497Workaround.d = androidBug5497Workaround.a.getHeight();
                this.a.e = false;
            }
            this.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int b = b();
        if (b != this.b) {
            int height = this.a.getRootView().getHeight();
            int i = height - b;
            if (i <= height / 4) {
                this.c.height = this.d;
            } else if (Build.VERSION.SDK_INT >= 19) {
                this.c.height = (height - i) + this.f;
            } else {
                this.c.height = height - i;
            }
            this.a.requestLayout();
            this.b = b;
        }
    }

    private int b() {
        Rect rect = new Rect();
        this.a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }
}
