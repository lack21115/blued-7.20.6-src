package com.tencent.txcopyrightedmedia.impl.utils;

import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/r.class */
public final class r implements ITXCMMusicTrack.OnPreparedListener {

    /* renamed from: a  reason: collision with root package name */
    private final ITXCMMusicTrack.OnPreparedListener f40142a;

    public r(ITXCMMusicTrack.OnPreparedListener onPreparedListener) {
        this.f40142a = onPreparedListener;
    }

    @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack.OnPreparedListener
    public final void onPrepared() {
        ai aiVar;
        if (this.f40142a == null || (aiVar = (ai) m.a().b(m.d)) == null) {
            return;
        }
        aiVar.a(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.r.1
            @Override // java.lang.Runnable
            public final void run() {
                r.this.f40142a.onPrepared();
            }
        });
    }
}
