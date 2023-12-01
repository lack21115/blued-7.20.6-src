package pl.droidsonroids.gif.transforms;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/transforms/CornerRadiusTransform.class */
public class CornerRadiusTransform implements Transform {

    /* renamed from: a  reason: collision with root package name */
    private float f44171a;
    private Shader b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f44172c;

    @Override // pl.droidsonroids.gif.transforms.Transform
    public void a(Canvas canvas, Paint paint, Bitmap bitmap) {
        if (this.f44171a == 0.0f) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f44172c, paint);
            return;
        }
        if (this.b == null) {
            this.b = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setTranslate(this.f44172c.left, this.f44172c.top);
            matrix.preScale(this.f44172c.width() / bitmap.getWidth(), this.f44172c.height() / bitmap.getHeight());
            this.b.setLocalMatrix(matrix);
        }
        paint.setShader(this.b);
        RectF rectF = this.f44172c;
        float f = this.f44171a;
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    @Override // pl.droidsonroids.gif.transforms.Transform
    public void a(Rect rect) {
        this.f44172c.set(rect);
        this.b = null;
    }
}
