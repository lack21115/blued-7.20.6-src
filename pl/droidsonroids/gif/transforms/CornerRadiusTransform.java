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
    private float a;
    private Shader b;
    private final RectF c;

    @Override // pl.droidsonroids.gif.transforms.Transform
    public void a(Canvas canvas, Paint paint, Bitmap bitmap) {
        if (this.a == 0.0f) {
            canvas.drawBitmap(bitmap, (Rect) null, this.c, paint);
            return;
        }
        if (this.b == null) {
            this.b = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setTranslate(this.c.left, this.c.top);
            matrix.preScale(this.c.width() / bitmap.getWidth(), this.c.height() / bitmap.getHeight());
            this.b.setLocalMatrix(matrix);
        }
        paint.setShader(this.b);
        RectF rectF = this.c;
        float f = this.a;
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    @Override // pl.droidsonroids.gif.transforms.Transform
    public void a(Rect rect) {
        this.c.set(rect);
        this.b = null;
    }
}
