package com.opos.exoplayer.core.metadata.emsg;

import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.d;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/emsg/a.class */
public final class a implements com.opos.exoplayer.core.metadata.a {
    @Override // com.opos.exoplayer.core.metadata.a
    public Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.b;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        m mVar = new m(array, limit);
        String y = mVar.y();
        String y2 = mVar.y();
        long m = mVar.m();
        return new Metadata(new EventMessage(y, y2, u.d(mVar.m(), 1000L, m), mVar.m(), Arrays.copyOfRange(array, mVar.d(), limit), u.d(mVar.m(), 1000000L, m)));
    }
}
