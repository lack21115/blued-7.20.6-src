package com.qiniu.pili.droid.shortvideo.gl.texread;

import android.opengl.GLES20;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/texread/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f14037a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14038c;
    private int d;
    private int e;

    public b(int i) {
        switch (i) {
            case 6407:
            case 6408:
            case 6409:
                this.f14038c = i;
                this.b = GlUtil.a(3553);
                this.d = 0;
                this.e = 0;
                int[] iArr = new int[1];
                GLES20.glGenFramebuffers(1, iArr, 0);
                int i2 = iArr[0];
                this.f14037a = i2;
                GLES20.glBindFramebuffer(36160, i2);
                GlUtil.a("Generate framebuffer");
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.b, 0);
                GlUtil.a("Attach texture to framebuffer");
                GLES20.glBindFramebuffer(36160, 0);
                return;
            default:
                throw new IllegalArgumentException("Invalid pixel format: " + i);
        }
    }

    public int a() {
        return this.f14037a;
    }

    public void a(int i, int i2) {
        if (i == 0 || i2 == 0) {
            throw new IllegalArgumentException("Invalid size: " + i + "x" + i2);
        } else if (i == this.d && i2 == this.e) {
        } else {
            this.d = i;
            this.e = i2;
            GLES20.glBindFramebuffer(36160, this.f14037a);
            GlUtil.a("glBindFramebuffer");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.b);
            int i3 = this.f14038c;
            GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, null);
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            if (glCheckFramebufferStatus == 36053) {
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glBindTexture(3553, 0);
                return;
            }
            throw new IllegalStateException("Framebuffer not complete, status: " + glCheckFramebufferStatus);
        }
    }

    public void b() {
        GLES20.glDeleteTextures(1, new int[]{this.b}, 0);
        GLES20.glDeleteFramebuffers(1, new int[]{this.f14037a}, 0);
        this.d = 0;
        this.e = 0;
    }
}
