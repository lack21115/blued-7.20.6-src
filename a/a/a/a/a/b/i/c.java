package a.a.a.a.a.b.i;

import android.opengl.GLES20;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f1271a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1272c;
    public int d;
    public int e;

    public c(int i) {
        switch (i) {
            case 6407:
            case 6408:
            case 6409:
                this.f1272c = i;
                this.b = a.a.a.a.a.a.h.f.a(3553);
                this.d = 0;
                this.e = 0;
                int[] iArr = new int[1];
                GLES20.glGenFramebuffers(1, iArr, 0);
                int i2 = iArr[0];
                this.f1271a = i2;
                GLES20.glBindFramebuffer(36160, i2);
                a.a.a.a.a.a.h.f.a("Generate framebuffer");
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.b, 0);
                a.a.a.a.a.a.h.f.a("Attach texture to framebuffer");
                GLES20.glBindFramebuffer(36160, 0);
                return;
            default:
                throw new IllegalArgumentException("Invalid pixel format: " + i);
        }
    }

    public int a() {
        return this.f1271a;
    }

    public void a(int i, int i2) {
        if (i == 0 || i2 == 0) {
            throw new IllegalArgumentException("Invalid size: " + i + "x" + i2);
        } else if (i == this.d && i2 == this.e) {
        } else {
            this.d = i;
            this.e = i2;
            GLES20.glBindFramebuffer(36160, this.f1271a);
            a.a.a.a.a.a.h.f.a("glBindFramebuffer");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.b);
            int i3 = this.f1272c;
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
        GLES20.glDeleteFramebuffers(1, new int[]{this.f1271a}, 0);
        this.d = 0;
        this.e = 0;
    }
}
