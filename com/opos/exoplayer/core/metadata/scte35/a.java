package com.opos.exoplayer.core.metadata.scte35;

import com.opos.exoplayer.core.i.l;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.s;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.d;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/scte35/a.class */
public final class a implements com.opos.exoplayer.core.metadata.a {

    /* renamed from: a  reason: collision with root package name */
    private final m f11864a = new m();
    private final l b = new l();

    /* renamed from: c  reason: collision with root package name */
    private s f11865c;

    @Override // com.opos.exoplayer.core.metadata.a
    public Metadata a(d dVar) {
        if (this.f11865c == null || dVar.d != this.f11865c.c()) {
            s sVar = new s(dVar.f11386c);
            this.f11865c = sVar;
            sVar.c(dVar.f11386c - dVar.d);
        }
        ByteBuffer byteBuffer = dVar.b;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f11864a.a(array, limit);
        this.b.a(array, limit);
        this.b.b(39);
        long c2 = (this.b.c(1) << 32) | this.b.c(32);
        this.b.b(20);
        int c3 = this.b.c(12);
        int c4 = this.b.c(8);
        this.f11864a.d(14);
        SpliceCommand a2 = c4 != 0 ? c4 != 255 ? c4 != 4 ? c4 != 5 ? c4 != 6 ? null : TimeSignalCommand.a(this.f11864a, c2, this.f11865c) : SpliceInsertCommand.a(this.f11864a, c2, this.f11865c) : SpliceScheduleCommand.a(this.f11864a) : PrivateCommand.a(this.f11864a, c3, c2) : new SpliceNullCommand();
        return a2 == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(a2);
    }
}
