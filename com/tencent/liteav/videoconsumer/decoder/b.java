package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.videoconsumer.consumer.ServerVideoConsumerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final VideoDecoderDef.DecodeAbility f23085a;
    private final com.tencent.liteav.base.util.j b;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f23086a = new b((byte) 0);
    }

    private b() {
        this.f23085a = new VideoDecoderDef.DecodeAbility();
        com.tencent.liteav.base.util.j jVar = new com.tencent.liteav.base.util.j();
        this.b = jVar;
        jVar.a(c.a(this));
        synchronized (this) {
            this.f23085a.f23051c = a();
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static boolean a() {
        return b() || ExternalDecodeFactoryManager.a();
    }

    public static boolean b() {
        Integer num;
        return ServerVideoConsumerConfig.isHWHevcDecodeAllowed() && (num = new PersistStorage(PersistStorage.GLOBAL_DOMAIN).getInt("Liteav.Video.android.local.decoder.enable.hw.hevc")) != null && num.intValue() > 0;
    }
}
