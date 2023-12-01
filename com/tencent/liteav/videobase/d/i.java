package com.tencent.liteav.videobase.d;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/d/i.class */
public abstract class i extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a  reason: collision with root package name */
    private int f22932a;
    private final int[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f22933c;
    private int d;

    public i(String str, String str2) {
        super(str, str2);
        int[] iArr = new int[2];
        this.b = iArr;
        this.f22933c = 0;
        this.d = 0;
        Arrays.fill(iArr, -1);
    }

    private void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            int[] iArr = this.b;
            if (i2 >= iArr.length) {
                return;
            }
            OpenGlUtils.deleteTexture(iArr[i2]);
            this.b[i2] = -1;
            i = i2 + 1;
        }
    }

    protected abstract int a();

    public final void a(ByteBuffer byteBuffer, int i, int i2) {
        if (this.f22933c != i || this.d != i2) {
            b();
            this.f22933c = i;
            this.d = i2;
        }
        OpenGlUtils.loadYuv420DataToTextures(byteBuffer, a(), i, i2, this.b);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void beforeDrawArrays(int i) {
        super.beforeDrawArrays(i);
        GLES20.glActiveTexture(33985);
        OpenGlUtils.bindTexture(getTarget(), this.b[1]);
        GLES20.glUniform1i(this.f22932a, 1);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onDraw(int i, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.onDraw(this.b[0], dVar, floatBuffer, floatBuffer2);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f22932a = GLES20.glGetUniformLocation(getProgramId(), "uvTexture");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onUninit() {
        b();
        super.onUninit();
    }
}
