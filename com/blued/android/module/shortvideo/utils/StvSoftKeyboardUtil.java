package com.blued.android.module.shortvideo.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvSoftKeyboardUtil.class */
public class StvSoftKeyboardUtil {

    /* renamed from: com.blued.android.module.shortvideo.utils.StvSoftKeyboardUtil$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvSoftKeyboardUtil$1.class */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        int a;
        final /* synthetic */ View b;
        final /* synthetic */ OnSoftKeyboardChangeListener c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.b.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom;
            int height = this.b.getHeight();
            int i2 = height - i;
            if (this.a != i2) {
                this.c.a(i2, true ^ (((double) i) / ((double) height) > 0.8d));
            }
            this.a = height;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvSoftKeyboardUtil$OnSoftKeyboardChangeListener.class */
    public interface OnSoftKeyboardChangeListener {
        void a(int i, boolean z);
    }
}
