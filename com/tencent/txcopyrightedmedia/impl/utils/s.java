package com.tencent.txcopyrightedmedia.impl.utils;

import com.tencent.txcopyrightedmedia.ITXSongScoreCallback;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/s.class */
public final class s implements ITXSongScoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private final ITXSongScoreCallback f26453a;
    private final ai b = (ai) m.a().b(m.d);

    public s(ITXSongScoreCallback iTXSongScoreCallback) {
        this.f26453a = iTXSongScoreCallback;
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScoreCallback
    public final void onMIDIGroveAndHint(final boolean z, final float f, final float f2, final int i) {
        ai aiVar;
        if (this.f26453a == null || (aiVar = this.b) == null) {
            return;
        }
        aiVar.a(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.s.2
            @Override // java.lang.Runnable
            public final void run() {
                s.this.f26453a.onMIDIGroveAndHint(z, f, f2, i);
            }
        });
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScoreCallback
    public final void onMIDISCoreUpdate(final int i, final int i2, final int i3) {
        ai aiVar;
        if (this.f26453a == null || (aiVar = this.b) == null) {
            return;
        }
        aiVar.a(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.s.1
            @Override // java.lang.Runnable
            public final void run() {
                s.this.f26453a.onMIDISCoreUpdate(i, i2, i3);
            }
        });
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScoreCallback
    public final void onMIDIScoreError(final int i, final String str) {
        ai aiVar;
        if (this.f26453a == null || (aiVar = this.b) == null) {
            return;
        }
        aiVar.a(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.s.5
            @Override // java.lang.Runnable
            public final void run() {
                s.this.f26453a.onMIDIScoreError(i, str);
            }
        });
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScoreCallback
    public final void onMIDIScoreFinish(final int[] iArr, final int i) {
        ai aiVar;
        if (this.f26453a == null || (aiVar = this.b) == null) {
            return;
        }
        aiVar.a(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.s.3
            @Override // java.lang.Runnable
            public final void run() {
                s.this.f26453a.onMIDIScoreFinish(iArr, i);
            }
        });
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScoreCallback
    public final void onMIDIScorePrepared() {
        ai aiVar;
        if (this.f26453a == null || (aiVar = this.b) == null) {
            return;
        }
        aiVar.a(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.s.4
            @Override // java.lang.Runnable
            public final void run() {
                s.this.f26453a.onMIDIScorePrepared();
            }
        });
    }
}
