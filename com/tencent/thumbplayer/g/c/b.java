package com.tencent.thumbplayer.g.c;

import android.graphics.SurfaceTexture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/c/b.class */
public final class b extends SurfaceTexture {

    /* renamed from: a  reason: collision with root package name */
    private a f39337a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/c/b$a.class */
    public interface a {
        void a();
    }

    public b(int i) {
        super(i);
    }

    public final void a(a aVar) {
        this.f39337a = aVar;
    }

    @Override // android.graphics.SurfaceTexture
    public final void release() {
        super.release();
        a aVar = this.f39337a;
        if (aVar != null) {
            aVar.a();
        }
    }
}
