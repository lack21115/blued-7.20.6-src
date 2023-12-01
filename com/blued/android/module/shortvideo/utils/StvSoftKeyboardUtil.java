package com.blued.android.module.shortvideo.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvSoftKeyboardUtil.class */
public class StvSoftKeyboardUtil {

    /* renamed from: com.blued.android.module.shortvideo.utils.StvSoftKeyboardUtil$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvSoftKeyboardUtil$1.class */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        int f15857a;
        final /* synthetic */ View b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OnSoftKeyboardChangeListener f15858c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.b.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom;
            int height = this.b.getHeight();
            int i2 = height - i;
            if (this.f15857a != i2) {
                this.f15858c.a(i2, true ^ (((double) i) / ((double) height) > 0.8d));
            }
            this.f15857a = height;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvSoftKeyboardUtil$OnSoftKeyboardChangeListener.class */
    public interface OnSoftKeyboardChangeListener {
        void a(int i, boolean z);
    }
}
