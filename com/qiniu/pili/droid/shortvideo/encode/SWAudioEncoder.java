package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/SWAudioEncoder.class */
public class SWAudioEncoder extends f {
    private PLAudioEncodeSetting f;
    private long mAudioEncoderId = 0;

    public SWAudioEncoder(PLAudioEncodeSetting pLAudioEncodeSetting) {
        this.f = pLAudioEncodeSetting;
    }

    private MediaFormat a(PLAudioEncodeSetting pLAudioEncodeSetting, byte[] bArr) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", pLAudioEncodeSetting.getSamplerate(), pLAudioEncodeSetting.getChannels());
        createAudioFormat.setInteger(MediaFormat.KEY_BIT_RATE, pLAudioEncodeSetting.getBitrate());
        createAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
        return createAudioFormat;
    }

    private boolean n() {
        return nativeSetParam(1, this.f.getSamplerate()) & true & nativeSetParam(2, this.f.getChannels()) & nativeSetParam(3, this.f.getBitrate());
    }

    private native boolean nativeClose();

    private native boolean nativeEncode(ByteBuffer byteBuffer, byte[] bArr, int i, long j);

    private native boolean nativeInit();

    private native boolean nativeOpen();

    private native boolean nativeRelease();

    private native boolean nativeSetParam(int i, int i2);

    private void onAudioFrameEncoded(int i, long j) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
        eVar.b("SWAudioEncoder", "on frame encoded: size = " + i + " bytes, ts = " + j);
        if (this.d == null) {
            return;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.offset = 0;
        bufferInfo.size = i;
        bufferInfo.presentationTimeUs = j;
        this.d.a(this.e, bufferInfo);
        e();
    }

    private void onESDSEncoded(byte[] bArr) {
        MediaFormat a2 = a(this.f, bArr);
        if (this.d != null) {
            this.d.a(a2);
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
        eVar.c("SWAudioEncoder", "create format: " + a2);
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.f
    boolean a(ByteBuffer byteBuffer, byte[] bArr, int i, long j) {
        return nativeEncode(byteBuffer, bArr, i, j);
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a
    public long b() {
        return 0L;
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
        return "SWAudioEncoder";
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.f
    boolean k() {
        return nativeClose();
    }
}
