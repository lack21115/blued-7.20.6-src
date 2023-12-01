package com.tencent.liteav.videobase.videobase;

import com.tencent.liteav.videobase.videobase.h;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/f.class */
public final class f implements IVideoReporter {
    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public final void notifyError(h.a aVar, String str, Object... objArr) {
        if (str == null || str.isEmpty()) {
            return;
        }
        String.format(str, objArr);
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public final void notifyEvent(h.b bVar, String str, Object... objArr) {
        if (str == null || str.isEmpty()) {
            return;
        }
        String.format(str, objArr);
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public final void notifyWarning(h.c cVar, String str, Object... objArr) {
        if (str == null || str.isEmpty()) {
            return;
        }
        String.format(str, objArr);
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public final void updateStatus(i iVar, int i, Object obj) {
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public final void updateStatus(i iVar, Object obj) {
    }
}
