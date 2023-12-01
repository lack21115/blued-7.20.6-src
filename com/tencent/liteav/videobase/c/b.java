package com.tencent.liteav.videobase.c;

import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/c/b.class */
public final class b extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a  reason: collision with root package name */
    private int f36609a = -1;
    private int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f36610c = -1;

    public final void a(Buffer buffer, int i, int i2) {
        if (this.f36609a != i || this.b != i2) {
            this.f36609a = i;
            this.b = i2;
            OpenGlUtils.deleteTexture(this.f36610c);
            this.f36610c = -1;
        }
        this.f36610c = OpenGlUtils.loadTexture(6408, buffer, i, i2, this.f36610c);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onDraw(int i, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.onDraw(this.f36610c, dVar, floatBuffer, floatBuffer2);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onUninit() {
        super.onUninit();
        OpenGlUtils.deleteTexture(this.f36610c);
        this.f36610c = -1;
    }
}
