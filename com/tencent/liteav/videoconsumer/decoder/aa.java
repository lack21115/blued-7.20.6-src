package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.videoconsumer.decoder.d;
import com.tencent.ugc.UGCTransitionRules;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/aa.class */
public final /* synthetic */ class aa implements d.InterfaceC0938d {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f36745a = new aa();

    private aa() {
    }

    public static d.InterfaceC0938d a() {
        return f36745a;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.d.InterfaceC0938d
    public final SpsInfo a(boolean z, ByteBuffer byteBuffer) {
        SpsInfo nativeDecodeSps = SpsInfo.nativeDecodeSps(z, byteBuffer);
        SpsInfo spsInfo = nativeDecodeSps;
        if (nativeDecodeSps == null) {
            spsInfo = new SpsInfo();
        }
        if (spsInfo.width <= 0 || spsInfo.height <= 0) {
            spsInfo.width = UGCTransitionRules.DEFAULT_IMAGE_WIDTH;
            spsInfo.height = 1280;
        }
        return spsInfo;
    }
}
