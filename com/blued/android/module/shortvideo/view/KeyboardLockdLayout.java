package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/KeyboardLockdLayout.class */
public class KeyboardLockdLayout extends FrameLayout {
    int a;
    int b;
    private Context c;

    public KeyboardLockdLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = context;
        a();
    }

    private void a() {
    }

    private boolean b() {
        Rect rect = new Rect();
        View rootView = getRootView();
        getWindowVisibleDisplayFrame(rect);
        return ((float) (rootView.getBottom() - rect.bottom)) > rootView.getResources().getDisplayMetrics().density * 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (b()) {
            super.onMeasure(this.a, this.b);
        } else {
            super.onMeasure(i, i2);
        }
        this.a = i;
        this.b = i2;
    }
}
