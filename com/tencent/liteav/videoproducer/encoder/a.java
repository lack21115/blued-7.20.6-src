package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final VideoEncoderDef.EncodeAbility f23276a;
    private final com.tencent.liteav.base.util.j b;

    /* renamed from: com.tencent.liteav.videoproducer.encoder.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/a$a.class */
    public static final class C0771a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f23277a = new a((byte) 0);
    }

    private a() {
        this.f23276a = new VideoEncoderDef.EncodeAbility();
        com.tencent.liteav.base.util.j jVar = new com.tencent.liteav.base.util.j();
        this.b = jVar;
        jVar.a(b.a(this));
        synchronized (this) {
            this.f23276a.f23265c = a();
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static boolean a() {
        Integer num;
        return ServerVideoProducerConfig.isHWHevcEncodeAllowed() && (num = new PersistStorage(PersistStorage.GLOBAL_DOMAIN).getInt("Liteav.Video.android.local.encoder.enable.hw.hevc")) != null && num.intValue() > 0;
    }
}
