package com.blued.android.kbswitch;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.blued.android.kbswitch.listener.KeyboardHeightChangedListener;
import com.blued.android.kbswitch.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/kbswitch/KeyboardPop.class */
public final class KeyboardPop extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f10424a;
    private final View b;

    /* renamed from: c  reason: collision with root package name */
    private final View f10425c;
    private int d;
    private int e;
    private int f;
    private KeyboardHeightChangedListener g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardPop(Activity activity, View parentView) {
        super(activity);
        Intrinsics.e(activity, "activity");
        Intrinsics.e(parentView, "parentView");
        this.f10424a = activity;
        this.b = parentView;
        View view = new View(this.f10424a);
        this.f10425c = view;
        setContentView(view);
        setSoftInputMode(21);
        setInputMethodMode(1);
        setWidth(0);
        setHeight(-1);
        this.f10425c.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private final void a(int i, int i2) {
        KeyboardHeightChangedListener keyboardHeightChangedListener = this.g;
        if (keyboardHeightChangedListener == null) {
            return;
        }
        keyboardHeightChangedListener.a(i, i2);
    }

    private final int c() {
        Rect rect = new Rect();
        this.b.getWindowVisibleDisplayFrame(rect);
        return rect.height();
    }

    public final void a() {
        try {
            if (isShowing() || this.b.getWindowToken() == null) {
                return;
            }
            setBackgroundDrawable(new ColorDrawable(0));
            showAtLocation(this.b, 0, 0, 0);
        } catch (Throwable th) {
        }
    }

    public final void a(KeyboardHeightChangedListener keyboardHeightChangedListener) {
        this.g = keyboardHeightChangedListener;
    }

    public final boolean b() {
        return this.e > 120;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        this.f10425c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.g = null;
        super.dismiss();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean z;
        int height = this.f10425c.getHeight();
        if (height <= 0) {
            return;
        }
        if (c() - height <= UtilsKt.a(this.f10424a, 100.0f)) {
            this.f = height;
            z = false;
        } else {
            z = true;
        }
        if (z && this.f <= 0) {
            this.f = c();
        }
        int i = z ? this.f - height : 0;
        int i2 = this.e;
        if (i2 == i) {
            return;
        }
        this.d = i2;
        this.e = i;
        int i3 = this.f10424a.getResources().getConfiguration().orientation;
        if (i < 120) {
            this.e = 0;
            a(0, i3);
        } else if (i3 == 1) {
            a(RangesKt.c(i, 0), i3);
        } else {
            a(RangesKt.c(i, 0), i3);
        }
    }
}
