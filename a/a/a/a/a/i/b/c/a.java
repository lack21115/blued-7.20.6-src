package a.a.a.a.a.i.b.c;

import android.content.Context;
import com.qiniu.pili.droid.streaming.processing.image.mm.JNIControl;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/i/b/c/a.class */
public final class a {
    public int b;

    /* renamed from: a  reason: collision with root package name */
    public int f1389a = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1390c = false;

    public int a(int i, int i2, int i3) {
        JNIControl.setSurfaceTextureID(i);
        JNIControl.handlePreview(0L, i3, i2, i3, i2);
        int outputTexture = JNIControl.getOutputTexture();
        this.b = outputTexture;
        return outputTexture;
    }

    public void a() {
        if (this.f1390c) {
            JNIControl.reInit();
        }
        this.f1390c = false;
        this.f1389a = -1;
    }

    public void a(float f) {
        JNIControl.setBeautify(f);
    }

    public void a(Context context, int i, int i2) {
        this.f1390c = true;
        if (this.f1389a == -1) {
            if (i == 3) {
                JNIControl.setGLES(3);
            } else {
                JNIControl.setGLES(2);
            }
            JNIControl.onSurfaceCreated(context, i2);
        }
    }

    public void a(boolean z) {
        JNIControl.setFrontCamera(z);
    }

    public boolean a(ByteBuffer byteBuffer, int i) {
        return JNIControl.updateNV21Frame(byteBuffer, i);
    }

    public void b(float f) {
        JNIControl.setWhiten(f);
    }

    public void b(Context context, int i, int i2) {
        JNIControl.onSurfaceChanged(i, i2);
        this.b = JNIControl.getOutputTexture();
        JNIControl.setCurrentDirection(1);
    }

    public void b(boolean z) {
        JNIControl.setIsPortraitDisplay(z);
    }

    public void c(float f) {
        JNIControl.setRedden(f);
    }

    public void c(boolean z) {
        JNIControl.setDrawRotate180(z);
    }
}
