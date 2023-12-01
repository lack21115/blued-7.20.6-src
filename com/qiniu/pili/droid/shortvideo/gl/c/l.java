package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/l.class */
public class l extends k {
    public byte[] h() {
        GLES20.glBindFramebuffer(36160, this.f14033a);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.b, 0);
        ByteBuffer allocate = ByteBuffer.allocate(this.i * 4 * this.j);
        GLES20.glReadPixels(0, 0, this.i, this.j, 6408, 5121, allocate);
        GLES20.glBindFramebuffer(36160, 0);
        return allocate.array();
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    protected float[] j() {
        return com.qiniu.pili.droid.shortvideo.f.d.d;
    }
}
