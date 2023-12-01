package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.OpenGlUtils;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private int f22939a = -1;

    public final void a() {
        if (this.f22939a == -1) {
            this.f22939a = OpenGlUtils.generateFrameBufferId();
        }
    }

    public final void a(int i) {
        int i2 = this.f22939a;
        if (i2 == -1) {
            LiteavLog.d("GLFrameBuffer", "FrameBuffer is invalid");
        } else {
            OpenGlUtils.attachTextureToFrameBuffer(i, i2);
        }
    }

    public final void b() {
        OpenGlUtils.bindFramebuffer(36160, this.f22939a);
    }

    public final void c() {
        int i = this.f22939a;
        if (i == -1) {
            LiteavLog.d("GLFrameBuffer", "FrameBuffer is invalid");
        } else {
            OpenGlUtils.detachTextureFromFrameBuffer(i);
        }
    }

    public final void d() {
        int i = this.f22939a;
        if (i != -1) {
            OpenGlUtils.deleteFrameBuffer(i);
            this.f22939a = -1;
        }
    }
}
