package com.tencent.txcopyrightedmedia.impl.utils;

import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/q.class */
public final class q implements ITXCMMusicTrack.OnErrorListener {

    /* renamed from: a  reason: collision with root package name */
    private final ITXCMMusicTrack.OnErrorListener f40139a;

    public q(ITXCMMusicTrack.OnErrorListener onErrorListener) {
        this.f40139a = onErrorListener;
    }

    @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack.OnErrorListener
    public final void onError(final int i, final String str) {
        ai aiVar;
        if (this.f40139a == null || (aiVar = (ai) m.a().b(m.d)) == null) {
            return;
        }
        aiVar.a(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.q.1
            @Override // java.lang.Runnable
            public final void run() {
                q.this.f40139a.onError(i, str);
            }
        });
    }
}
