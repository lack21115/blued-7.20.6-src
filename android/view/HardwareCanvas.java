package android.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CanvasProperty;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: source-9557208-dex2jar.jar:android/view/HardwareCanvas.class */
public abstract class HardwareCanvas extends Canvas {
    public static void setProperty(String str, String str2) {
        GLES20Canvas.setProperty(str, str2);
    }

    public abstract int callDrawGLFunction2(long j);

    public abstract void drawCircle(CanvasProperty<Float> canvasProperty, CanvasProperty<Float> canvasProperty2, CanvasProperty<Float> canvasProperty3, CanvasProperty<Paint> canvasProperty4);

    abstract void drawHardwareLayer(HardwareLayer hardwareLayer, float f, float f2, Paint paint);

    public abstract int drawRenderNode(RenderNode renderNode, Rect rect, int i);

    public void drawRenderNode(RenderNode renderNode) {
        drawRenderNode(renderNode, null, 1);
    }

    public abstract void drawRoundRect(CanvasProperty<Float> canvasProperty, CanvasProperty<Float> canvasProperty2, CanvasProperty<Float> canvasProperty3, CanvasProperty<Float> canvasProperty4, CanvasProperty<Float> canvasProperty5, CanvasProperty<Float> canvasProperty6, CanvasProperty<Paint> canvasProperty7);

    @Override // android.graphics.Canvas
    public boolean isHardwareAccelerated() {
        return true;
    }

    public abstract void onPostDraw();

    public abstract int onPreDraw(Rect rect);

    @Override // android.graphics.Canvas
    public void setBitmap(Bitmap bitmap) {
        throw new UnsupportedOperationException();
    }
}
