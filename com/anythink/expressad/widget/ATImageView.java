package com.anythink.expressad.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.anythink.expressad.foundation.g.d.b;
import com.anythink.expressad.foundation.g.d.c;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/widget/ATImageView.class */
public class ATImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5940a = "at-widget-imageview";
    private Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private String f5941c;

    /* renamed from: com.anythink.expressad.widget.ATImageView$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/widget/ATImageView$1.class */
    final class AnonymousClass1 implements c {
        AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            ATImageView.this.setImageBitmap(bitmap);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    public ATImageView(Context context) {
        super(context);
        this.b = null;
    }

    public ATImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
    }

    public ATImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = null;
    }

    private void a() {
        if (getContext() != null) {
            b.a(getContext()).a(this.f5941c, new AnonymousClass1());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if (this.b == null || !this.b.isRecycled()) {
                super.onDraw(canvas);
            } else if (getContext() != null) {
                b.a(getContext()).a(this.f5941c, new AnonymousClass1());
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.b = bitmap;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.setImageBitmap(bitmap);
            return;
        }
        this.b = null;
        super.setImageBitmap(null);
    }

    public void setImageUrl(String str) {
        this.f5941c = str;
    }
}
