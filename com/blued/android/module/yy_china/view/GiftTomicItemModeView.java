package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.yy_china.model.GiftToMicItemMode;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/GiftTomicItemModeView.class */
public final class GiftTomicItemModeView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f17939a;
    private final CopyOnWriteArrayList<GiftToMicItemMode> b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17940c;

    public GiftTomicItemModeView(Context context) {
        this(context, null);
    }

    public GiftTomicItemModeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftTomicItemModeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17939a = new Paint();
        this.b = new CopyOnWriteArrayList<>();
        this.f17940c = true;
    }

    public final void a() {
        this.f17940c = false;
        this.b.clear();
    }

    public final void a(int i, int i2, int i3, int i4, Bitmap bitmap, boolean z) {
        if (((this.b.size() >= 50 || !this.f17940c) && !z) || this.b.size() >= 70) {
            return;
        }
        this.b.add(new GiftToMicItemMode(i, i2, i3, i4, bitmap));
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.e(canvas, "canvas");
        super.draw(canvas);
        Iterator<GiftToMicItemMode> it = this.b.iterator();
        Intrinsics.c(it, "das.iterator()");
        int i = 0;
        while (it.hasNext()) {
            GiftToMicItemMode next = it.next();
            if (next.a(canvas, this.f17939a, getMeasuredWidth(), getMeasuredHeight())) {
                this.b.remove(next);
            }
            int i2 = i + 1;
            i = i2;
            if (i2 == 30) {
                break;
            }
        }
        if (this.b.size() > 0) {
            invalidate();
        }
    }
}
