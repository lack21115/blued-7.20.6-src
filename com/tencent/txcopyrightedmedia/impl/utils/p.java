package com.tencent.txcopyrightedmedia.impl.utils;

import com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/p.class */
public final class p implements ITXMusicPreloadCallback {

    /* renamed from: a  reason: collision with root package name */
    private final ITXMusicPreloadCallback f26441a;
    private final ai b = (ai) m.a().b(m.d);

    public p(ITXMusicPreloadCallback iTXMusicPreloadCallback) {
        this.f26441a = iTXMusicPreloadCallback;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && ((p) obj).f26441a == this.f26441a;
    }

    @Override // com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback
    public final void onPreloadComplete(final String str, final String str2, final int i, final String str3) {
        ai aiVar;
        if (this.f26441a == null || (aiVar = this.b) == null) {
            return;
        }
        aiVar.a(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.p.3
            @Override // java.lang.Runnable
            public final void run() {
                p.this.f26441a.onPreloadComplete(str, str2, i, str3);
            }
        });
    }

    @Override // com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback
    public final void onPreloadProgress(final String str, final String str2, final float f) {
        ai aiVar;
        if (this.f26441a == null || (aiVar = this.b) == null) {
            return;
        }
        aiVar.a(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.p.2
            @Override // java.lang.Runnable
            public final void run() {
                p.this.f26441a.onPreloadProgress(str, str2, f);
            }
        });
    }

    @Override // com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback
    public final void onPreloadStart(final String str, final String str2) {
        ai aiVar;
        if (this.f26441a == null || (aiVar = this.b) == null) {
            return;
        }
        aiVar.a(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.p.1
            @Override // java.lang.Runnable
            public final void run() {
                p.this.f26441a.onPreloadStart(str, str2);
            }
        });
    }
}
