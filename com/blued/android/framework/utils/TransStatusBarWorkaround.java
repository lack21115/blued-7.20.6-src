package com.blued.android.framework.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/TransStatusBarWorkaround.class */
public class TransStatusBarWorkaround {
    private View a;
    private int b;
    private ViewGroup.LayoutParams c;

    /* renamed from: com.blued.android.framework.utils.TransStatusBarWorkaround$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/TransStatusBarWorkaround$1.class */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ TransStatusBarWorkaround a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int b = b();
        if (b != this.b) {
            this.c.height = b;
            this.a.requestLayout();
            this.b = b;
        }
    }

    private int b() {
        Rect rect = new Rect();
        this.a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }
}
