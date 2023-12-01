package com.qiniu.pili.droid.streaming.av.encoder;

import a.a.a.a.a.a.f.a;
import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/av/encoder/PLAACEncoder.class */
public class PLAACEncoder {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f27837c = SharedLibraryNameHelper.getInstance().a();

    /* renamed from: a  reason: collision with root package name */
    public a f27838a = new a(2);
    public a.a.a.a.a.a.g.a b;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/av/encoder/PLAACEncoder$Parameters.class */
    public static class Parameters {
        public int bitrate;
        public int bitsPerSample;
        public int channels;
        public boolean isLoggingEnabled = e.a();
        public int sampleRate;

        public Parameters(int i, int i2, int i3, int i4) {
            this.channels = i2;
            this.sampleRate = i3;
            this.bitsPerSample = i4;
            this.bitrate = i;
        }
    }

    public PLAACEncoder(Parameters parameters) {
        e eVar = e.i;
        eVar.c("PLAACEncoder", "isLoggingEnabled:" + parameters.isLoggingEnabled);
        initialize(parameters);
    }

    private void audioSpecificConfigCallback(PLAVFrame pLAVFrame) {
        e eVar = e.i;
        eVar.c("PLAACEncoder", "audioSpecificConfigCallback size:" + pLAVFrame.mSize + ",encodedBuffer:" + pLAVFrame.mBuffer);
        pLAVFrame.mBuffer.position(0);
        pLAVFrame.mBuffer.limit(pLAVFrame.mSize);
        PLBufferInfo pLBufferInfo = new PLBufferInfo();
        int i = pLBufferInfo.flags | 2;
        pLBufferInfo.flags = i;
        int i2 = pLAVFrame.mSize;
        long j = pLAVFrame.mPresentationTimeUs;
        pLBufferInfo.set(0, i2, j, j, i);
        pLBufferInfo.isNeedAddHeader = false;
        a.a.a.a.a.a.g.a aVar = this.b;
        if (aVar != null) {
            aVar.a(pLAVFrame, pLBufferInfo);
        }
    }

    private void encodeCallback(PLAVFrame pLAVFrame, int i) {
        e eVar = e.i;
        eVar.a("PLAACEncoder", "encodeCallback + size:" + pLAVFrame.mSize + ",frameType:" + i + ",ts:" + pLAVFrame.mPresentationTimeUs);
        long currentTimeMillis = System.currentTimeMillis();
        PLBufferInfo pLBufferInfo = new PLBufferInfo();
        int i2 = pLAVFrame.mSize;
        long j = pLAVFrame.mPresentationTimeUs;
        pLBufferInfo.set(0, i2, j, j, pLBufferInfo.flags);
        pLBufferInfo.isNeedAddHeader = false;
        pLAVFrame.mBuffer.position(0);
        pLAVFrame.mBuffer.limit(pLAVFrame.mSize);
        e eVar2 = e.i;
        eVar2.a("PLAACEncoder", "encodeCallback buffer:" + pLAVFrame.mBuffer + ",mCallback:" + this.b + ",frame:" + pLAVFrame);
        a.a.a.a.a.a.g.a aVar = this.b;
        if (aVar != null) {
            aVar.a(pLAVFrame, pLBufferInfo);
        }
        e eVar3 = e.i;
        eVar3.a("PLAACEncoder", "encodeCallback - cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    private PLAVFrame getOutputFrame(int i) {
        PLAVFrame a2 = this.f27838a.a(i);
        e eVar = e.i;
        eVar.a("PLAACEncoder", "getOutputFrame reqSize:" + i + ",mBuffer:" + a2.mBuffer);
        a2.mBuffer.clear();
        return a2;
    }

    public void a(a.a.a.a.a.a.g.a aVar) {
        this.b = aVar;
    }

    public void a(PLAVFrame pLAVFrame) {
        pLAVFrame.mBuffer.limit(0);
        pLAVFrame.mBuffer.clear();
        this.f27838a.a(pLAVFrame);
    }

    public void b(PLAVFrame pLAVFrame) {
        a(pLAVFrame);
    }

    public native int encode(ByteBuffer byteBuffer, int i, long j);

    public native void initialize(Parameters parameters);

    public native void release();
}
