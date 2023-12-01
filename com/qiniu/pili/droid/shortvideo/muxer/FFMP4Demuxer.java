package com.qiniu.pili.droid.shortvideo.muxer;

import com.qiniu.pili.droid.shortvideo.f.e;
import java.math.BigDecimal;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/muxer/FFMP4Demuxer.class */
public class FFMP4Demuxer {

    /* renamed from: a  reason: collision with root package name */
    private static String f14043a = "FFMP4Demuxer";
    private long b;

    private native int nativeCloseFile(long j);

    private native long nativeGetAudioCodecParams(long j);

    private native int nativeGetAudioESDS(long j, ByteBuffer byteBuffer, int i);

    private native int nativeGetAudioStreamIndex(long j);

    private native int nativeGetAudioTimebaseDen(long j);

    private native int nativeGetAudioTimebaseNum(long j);

    private native long nativeGetPacketDTS(long j);

    private native byte[] nativeGetPacketData(long j);

    private native int nativeGetPacketDataSize(long j);

    private native long nativeGetPacketDuration(long j);

    private native long nativeGetPacketPTS(long j);

    private native int nativeGetPacketStreamIndex(long j);

    private native float nativeGetPacketTimestamp(long j, int i, long j2);

    private native long nativeGetVideoCodecParams(long j);

    private native int nativeGetVideoFrameRate(long j);

    private native int nativeGetVideoRotate(long j);

    private native int nativeGetVideoSPSPPS(long j, ByteBuffer byteBuffer, int i);

    private native int nativeGetVideoStreamIndex(long j);

    private native int nativeGetVideoTimebaseDen(long j);

    private native int nativeGetVideoTimebaseNum(long j);

    private native int nativeIsPacketKeyFrame(long j);

    private native long nativeOpenFile(String str);

    private native long nativeReadNextPacket(long j);

    private native int nativeSeek(long j, int i, long j2, int i2);

    public int a() {
        return nativeGetVideoStreamIndex(this.b);
    }

    public int a(int i, long j, int i2) {
        return nativeSeek(this.b, i, j, i2);
    }

    public int a(long j) {
        return nativeGetPacketStreamIndex(j);
    }

    public int a(ByteBuffer byteBuffer, int i) {
        return nativeGetVideoSPSPPS(this.b, byteBuffer, i);
    }

    public long a(int i, long j) {
        BigDecimal bigDecimal = new BigDecimal(nativeGetPacketTimestamp(this.b, i, j));
        bigDecimal.setScale(6, 5);
        return bigDecimal.floatValue() * 1000000.0f;
    }

    public boolean a(String str) {
        long nativeOpenFile = nativeOpenFile(str);
        this.b = nativeOpenFile;
        if (nativeOpenFile == -1) {
            e.n.e(f14043a, "demuxer create failed!");
            return false;
        }
        return true;
    }

    public int b() {
        return nativeGetAudioStreamIndex(this.b);
    }

    public int b(ByteBuffer byteBuffer, int i) {
        return nativeGetAudioESDS(this.b, byteBuffer, i);
    }

    public byte[] b(long j) {
        return nativeGetPacketData(j);
    }

    public int c() {
        return nativeGetVideoFrameRate(this.b);
    }

    public int c(long j) {
        return nativeGetPacketDataSize(j);
    }

    public int d() {
        return nativeGetVideoRotate(this.b);
    }

    public int d(long j) {
        return nativeIsPacketKeyFrame(j);
    }

    public int e() {
        return nativeGetAudioTimebaseNum(this.b);
    }

    public long e(long j) {
        return nativeGetPacketPTS(j);
    }

    public int f() {
        return nativeGetAudioTimebaseDen(this.b);
    }

    public long f(long j) {
        return nativeGetPacketDTS(j);
    }

    public int g() {
        return nativeGetVideoTimebaseNum(this.b);
    }

    public long g(long j) {
        return nativeGetPacketDuration(j);
    }

    public int h() {
        return nativeGetVideoTimebaseDen(this.b);
    }

    public long i() {
        return nativeReadNextPacket(this.b);
    }

    public long j() {
        return nativeGetVideoCodecParams(this.b);
    }

    public long k() {
        return nativeGetAudioCodecParams(this.b);
    }

    public int l() {
        return nativeCloseFile(this.b);
    }
}
