package com.blued.android.framework.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/TransStatusBarWorkaround.class */
public class TransStatusBarWorkaround {

    /* renamed from: a  reason: collision with root package name */
    private View f10118a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup.LayoutParams f10119c;

    /* renamed from: com.blued.android.framework.utils.TransStatusBarWorkaround$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/TransStatusBarWorkaround$1.class */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TransStatusBarWorkaround f10120a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f10120a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int b = b();
        if (b != this.b) {
            this.f10119c.height = b;
            this.f10118a.requestLayout();
            this.b = b;
        }
    }

    private int b() {
        Rect rect = new Rect();
        this.f10118a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }
}
