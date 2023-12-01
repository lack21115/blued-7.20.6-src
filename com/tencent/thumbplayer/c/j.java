package com.tencent.thumbplayer.c;

import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/j.class */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private ITPDownloadProxy f39266a;

    public j(ITPDownloadProxy iTPDownloadProxy) {
        this.f39266a = iTPDownloadProxy;
    }

    @Override // com.tencent.thumbplayer.c.b
    public ITPDownloadProxy a() {
        return this.f39266a;
    }

    @Override // com.tencent.thumbplayer.c.b
    public void a(int i) {
        this.f39266a.pushEvent(i);
    }
}
