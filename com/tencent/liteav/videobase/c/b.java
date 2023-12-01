package com.tencent.liteav.videobase.c;

import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/c/b.class */
public final class b extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a  reason: collision with root package name */
    private int f22918a = -1;
    private int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f22919c = -1;

    public final void a(Buffer buffer, int i, int i2) {
        if (this.f22918a != i || this.b != i2) {
            this.f22918a = i;
            this.b = i2;
            OpenGlUtils.deleteTexture(this.f22919c);
            this.f22919c = -1;
        }
        this.f22919c = OpenGlUtils.loadTexture(6408, buffer, i, i2, this.f22919c);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onDraw(int i, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.onDraw(this.f22919c, dVar, floatBuffer, floatBuffer2);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onUninit() {
        super.onUninit();
        OpenGlUtils.deleteTexture(this.f22919c);
        this.f22919c = -1;
    }
}
