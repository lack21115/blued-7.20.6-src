package com.tencent.thumbplayer.g.b;

import android.media.MediaCodec;
import com.tencent.thumbplayer.g.f.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b/a.class */
public final class a extends f {
    public a(MediaCodec mediaCodec, e eVar) {
        super(mediaCodec, eVar);
    }

    @Override // com.tencent.thumbplayer.g.b.f
    public final a.b a(e eVar) {
        return com.tencent.thumbplayer.g.f.a.a(this, eVar) ? a.b.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION : a.b.KEEP_CODEC_RESULT_NO;
    }

    @Override // com.tencent.thumbplayer.g.b.f
    public final String toString() {
        return "AudioCodecWrapper[" + hashCode() + ']';
    }
}
