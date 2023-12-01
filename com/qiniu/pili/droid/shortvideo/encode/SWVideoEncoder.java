package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.BatteryManager;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.f.g;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/SWVideoEncoder.class */
public class SWVideoEncoder extends f {
    private PLVideoEncodeSetting f;
    private long mVideoEncoderId = 0;

    public SWVideoEncoder(PLVideoEncodeSetting pLVideoEncodeSetting) {
        this.f = pLVideoEncodeSetting;
    }

    private MediaFormat a(PLVideoEncodeSetting pLVideoEncodeSetting, byte[] bArr, byte[] bArr2) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", pLVideoEncodeSetting.getVideoEncodingWidth(), pLVideoEncodeSetting.getVideoEncodingHeight());
        int round = Math.round((pLVideoEncodeSetting.getIFrameInterval() * 1.0f) / pLVideoEncodeSetting.getVideoEncodingFps());
        createVideoFormat.setInteger(MediaFormat.KEY_BIT_RATE, (int) (pLVideoEncodeSetting.getEncodingBitrate() * this.f27649a));
        createVideoFormat.setInteger(MediaFormat.KEY_FRAME_RATE, (int) (pLVideoEncodeSetting.getVideoEncodingFps() * this.f27649a));
        createVideoFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, round);
        createVideoFormat.setInteger(MediaFormat.KEY_PROFILE, g.a(pLVideoEncodeSetting.getProfileMode()));
        createVideoFormat.setInteger(BatteryManager.EXTRA_LEVEL, 1);
        createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
        createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(bArr2));
        return createVideoFormat;
    }

    private boolean n() {
        return nativeSetParam(1, this.f.getVideoEncodingWidth()) & true & nativeSetParam(2, this.f.getVideoEncodingHeight()) & nativeSetParam(3, (int) (this.f.getEncodingBitrate() * this.f27649a)) & nativeSetParam(5, (int) (this.f.getVideoEncodingFps() * this.f27649a)) & nativeSetParam(4, (int) (this.f.getIFrameInterval() * this.f27649a)) & nativeSetParam(7, this.f.getProfileMode().ordinal());
    }

    private native boolean nativeClose();

    private native boolean nativeEncode(ByteBuffer byteBuffer, byte[] bArr, int i, long j);

    private native boolean nativeInit();

    private native boolean nativeOpen();

    private native boolean nativeRelease();

    private native boolean nativeSetParam(int i, int i2);

    private void onSpsPpsEncoded(byte[] bArr, byte[] bArr2) {
        MediaFormat a2 = a(this.f, bArr, bArr2);
        if (this.d != null) {
            this.d.a(a2);
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
        eVar.c("SWVideoEncoder", "create format: " + a2);
    }

    private void onVideoFrameEncoded(int i, boolean z, long j) {
        com.qiniu.pili.droid.shortvideo.f.e.h.b("SWVideoEncoder", "on frame encoded: " + z + ", " + i + " bytes, ts = " + j);
        if (this.d == null) {
            return;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.offset = 0;
        bufferInfo.size = i;
        bufferInfo.presentationTimeUs = j;
        if (z) {
            bufferInfo.flags |= 1;
        }
        this.d.a(this.e, bufferInfo);
        e();
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.f
    boolean a(ByteBuffer byteBuffer, byte[] bArr, int i, long j) {
        return nativeEncode(byteBuffer, bArr, i, j / 1000);
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.f
    boolean g() {
        return nativeInit() && n();
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.f
    boolean h() {
        return nativeRelease();
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.f
    boolean i() {
        return nativeOpen();
    }

    @Override // com.qiniu.pili.droid.shortvideo.f.k
    public String j() {
        return "SWVideoEncoder";
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.f
    boolean k() {
        return nativeClose();
    }
}
