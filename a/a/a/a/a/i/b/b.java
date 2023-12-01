package a.a.a.a.a.i.b;

import a.a.a.a.a.a.h.f;
import a.a.a.a.a.e.e;
import a.a.a.a.a.i.b.a;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.util.Pair;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/i/b/b.class */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f1339a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f1340c;
    public int d;
    public int e;
    public int f;
    public a.EnumC0011a g;
    public float h;

    public b(int i) {
        a.EnumC0011a enumC0011a = a.EnumC0011a.TEXTURE_2D;
        this.g = enumC0011a;
        int a2 = a(enumC0011a);
        this.f1339a = a2;
        if (a2 == 0) {
            throw new RuntimeException("Unable to create program");
        }
        c();
        this.h = i / 255.0f;
    }

    public static ByteBuffer a(Bitmap bitmap) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bitmap.getWidth() * bitmap.getHeight() * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            bitmap.copyPixelsToBuffer(allocateDirect);
            allocateDirect.position(0);
        }
        return allocateDirect;
    }

    public static FloatBuffer a() {
        return f.a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static FloatBuffer a(WatermarkSetting watermarkSetting, int i, int i2) {
        float[] fArr;
        Pair<Float, Float> calculateWHRatio = watermarkSetting.calculateWHRatio(i, i2);
        float floatValue = calculateWHRatio.first.floatValue() * 2.0f;
        float floatValue2 = calculateWHRatio.second.floatValue() * 2.0f;
        FloatBuffer floatBuffer = null;
        if (watermarkSetting.isCustomPositionSet()) {
            float customPositionX = (watermarkSetting.getCustomPositionX() * 2.0f) - 1.0f;
            float customPositionY = ((watermarkSetting.getCustomPositionY() * 2.0f) - 1.0f) * (-1.0f);
            float f = customPositionX;
            if (customPositionX + floatValue > 1.0f) {
                f = 1.0f - floatValue;
            }
            float f2 = customPositionY;
            if (customPositionY - floatValue2 < -1.0f) {
                f2 = -(1.0f - floatValue2);
            }
            float f3 = f2 - floatValue2;
            float f4 = floatValue + f;
            fArr = new float[]{f, f3, f4, f3, f, f2, f4, f2};
        } else {
            WatermarkSetting.WATERMARK_LOCATION watermarkLocation = watermarkSetting.getWatermarkLocation();
            if (watermarkLocation == WatermarkSetting.WATERMARK_LOCATION.NORTH_WEST) {
                float f5 = 1.0f - floatValue2;
                float f6 = floatValue - 1.0f;
                fArr = new float[]{-1.0f, f5, f6, f5, -1.0f, 1.0f, f6, 1.0f};
            } else if (watermarkLocation == WatermarkSetting.WATERMARK_LOCATION.NORTH_EAST) {
                float f7 = 1.0f - floatValue;
                float f8 = 1.0f - floatValue2;
                fArr = new float[]{f7, f8, 1.0f, f8, f7, 1.0f, 1.0f, 1.0f};
            } else if (watermarkLocation == WatermarkSetting.WATERMARK_LOCATION.SOUTH_WEST) {
                float f9 = floatValue - 1.0f;
                float f10 = floatValue2 - 1.0f;
                fArr = new float[]{-1.0f, -1.0f, f9, -1.0f, -1.0f, f10, f9, f10};
            } else if (watermarkLocation == WatermarkSetting.WATERMARK_LOCATION.SOUTH_EAST) {
                float f11 = 1.0f - floatValue;
                float f12 = floatValue2 - 1.0f;
                fArr = new float[]{f11, -1.0f, 1.0f, -1.0f, f11, f12, 1.0f, f12};
            } else {
                e.f1313c.e("WatermarkFilter", "ERROR: pass in wrong location.");
                fArr = null;
            }
        }
        if (fArr != null) {
            floatBuffer = f.a(fArr);
        }
        return floatBuffer;
    }

    public int a(a.EnumC0011a enumC0011a) {
        return f.a("uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = aTextureCoord.xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\nuniform float uOpacity;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord) * uOpacity;\n}\n");
    }

    public void a(int i) {
        GLES20.glActiveTexture(33984);
        f.b("active texture.");
        GLES20.glBindTexture(b(), i);
        f.b("bind texture.");
        GLES20.glUniform1i(this.f, 0);
    }

    public void a(int i, int i2) {
        GLES20.glBlendEquationSeparate(32774, 32774);
        GLES20.glBlendFuncSeparate(1, 771, 1, 1);
        GLES20.glEnable(3042);
        GLES20.glDrawArrays(5, i, i2);
        f.b("Draw watermark");
        GLES20.glDisable(3042);
    }

    public void a(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, FloatBuffer floatBuffer2, int i5, int i6) {
        f.b("draw start");
        d();
        a(i5);
        a(fArr, floatBuffer, i3, i4, floatBuffer2, i6);
        a(i, i2);
        e();
        f();
        g();
        f.b("draw start");
    }

    public void a(float[] fArr, FloatBuffer floatBuffer, int i, int i2, FloatBuffer floatBuffer2, int i3) {
        GLES20.glUniform1f(this.e, this.h);
        GLES20.glUniformMatrix4fv(this.f1340c, 1, false, fArr, 0);
        GLES20.glEnableVertexAttribArray(this.b);
        GLES20.glVertexAttribPointer(this.b, i, 5126, false, i2, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.d);
        GLES20.glVertexAttribPointer(this.d, 2, 5126, false, i3, (Buffer) floatBuffer2);
    }

    public int b() {
        return 3553;
    }

    public void c() {
        this.f = GLES20.glGetUniformLocation(this.f1339a, "uTexture");
        this.e = GLES20.glGetUniformLocation(this.f1339a, "uOpacity");
        this.b = GLES20.glGetAttribLocation(this.f1339a, "aPosition");
        this.f1340c = GLES20.glGetUniformLocation(this.f1339a, "uMVPMatrix");
        this.d = GLES20.glGetAttribLocation(this.f1339a, "aTextureCoord");
    }

    public void d() {
        GLES20.glUseProgram(this.f1339a);
        f.b("glUseProgram");
    }

    public void e() {
        GLES20.glDisableVertexAttribArray(this.b);
        GLES20.glDisableVertexAttribArray(this.d);
    }

    public void f() {
        GLES20.glBindTexture(b(), 0);
    }

    public void g() {
        GLES20.glUseProgram(0);
    }

    public void h() {
        GLES20.glDeleteProgram(this.f1339a);
        this.f1339a = -1;
    }
}
