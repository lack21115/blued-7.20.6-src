package com.tencent.thumbplayer.g.b;

import android.media.MediaCodec;
import com.tencent.thumbplayer.g.f.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b/g.class */
public final class g extends f {
    public g(MediaCodec mediaCodec, e eVar) {
        super(mediaCodec, eVar);
    }

    @Override // com.tencent.thumbplayer.g.b.f
    public final a.b a(e eVar) {
        return (!com.tencent.thumbplayer.g.f.a.a(this, eVar) || eVar.b > this.g.f39320a || eVar.f39327c > this.g.b || com.tencent.thumbplayer.g.h.c.a(this, eVar) > this.g.f39321c) ? a.b.KEEP_CODEC_RESULT_NO : eVar.a(this.e) ? a.b.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION : a.b.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION;
    }

    @Override // com.tencent.thumbplayer.g.b.f
    public final boolean j() {
        return super.j() && this.f != null && this.e.d == 0;
    }

    @Override // com.tencent.thumbplayer.g.b.f
    public final String toString() {
        return "VideoCodecWrapper[" + hashCode() + ']';
    }
}
