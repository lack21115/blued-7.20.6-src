package com.blued.android.module.common.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CenterAlignUrlImageSpan.class */
public final class CenterAlignUrlImageSpan extends ReplacementSpan {
    private WeakReference<TextView> a;
    private final IRequestHost b;
    private final int c;
    private final int d;
    private final String e;
    private Drawable f;

    public CenterAlignUrlImageSpan(WeakReference<TextView> weakReference, IRequestHost iRequestHost, int i, int i2, String url) {
        Intrinsics.e(url, "url");
        this.a = weakReference;
        this.b = iRequestHost;
        this.c = i;
        this.d = i2;
        this.e = url;
        ImageLoader.a(iRequestHost, url).a((Target) new SimpleTarget<Drawable>() { // from class: com.blued.android.module.common.view.CenterAlignUrlImageSpan.1
            /* renamed from: a */
            public void onResourceReady(Drawable res, Transition<? super Drawable> transition) {
                TextView textView;
                Intrinsics.e(res, "res");
                CenterAlignUrlImageSpan.this.a(res);
                WeakReference<TextView> a = CenterAlignUrlImageSpan.this.a();
                if (a != null && (textView = a.get()) != null) {
                    textView.invalidate();
                }
                CenterAlignUrlImageSpan.this.a((WeakReference<TextView>) null);
            }

            public void onLoadCleared(Drawable drawable) {
            }
        });
    }

    public final WeakReference<TextView> a() {
        return this.a;
    }

    public final void a(Drawable drawable) {
        this.f = drawable;
    }

    public final void a(WeakReference<TextView> weakReference) {
        this.a = weakReference;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.e(canvas, "canvas");
        Intrinsics.e(paint, "paint");
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i6 = fontMetricsInt.descent;
        int i7 = fontMetricsInt.ascent;
        int i8 = fontMetricsInt.descent;
        int i9 = (i6 - i7) / 2;
        Drawable drawable = this.f;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, b(), c());
        canvas.save();
        canvas.translate(f, ((i4 + i8) - i9) - ((drawable.getBounds().bottom - drawable.getBounds().top) / 2));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.e(paint, "paint");
        return this.c;
    }
}
