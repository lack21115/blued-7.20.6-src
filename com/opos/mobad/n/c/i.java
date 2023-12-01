package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/i.class */
public abstract class i extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    protected Paint f26613a;
    protected Matrix b;

    public i(Context context) {
        this(context, null);
    }

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Matrix();
        Paint paint = new Paint();
        this.f26613a = paint;
        paint.setAntiAlias(true);
    }

    private Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
            int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, width, height);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("RoundImageView", "drawableToBitamp", (Throwable) e);
            return null;
        }
    }

    protected abstract void a(Canvas canvas, int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if (getDrawable() == null) {
                return;
            }
            Bitmap a2 = a(getDrawable());
            BitmapShader bitmapShader = new BitmapShader(a2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            float f = 1.0f;
            if (a2.getWidth() != getWidth() || a2.getHeight() != getHeight()) {
                f = Math.max((getWidth() * 1.0f) / a2.getWidth(), (getHeight() * 1.0f) / a2.getHeight());
            }
            this.b.setScale(f, f);
            bitmapShader.setLocalMatrix(this.b);
            this.f26613a.setShader(bitmapShader);
            a(canvas, getWidth(), getHeight());
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("RoundImageView", "onDraw", th);
        }
    }
}
