package com.qiniu.pili.droid.streaming.av.encoder;

import a.a.a.a.a.a.f.a;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import com.qiniu.pili.droid.streaming.processing.image.ImageProcessor;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/av/encoder/PLH264Encoder.class */
public class PLH264Encoder {
    public static final boolean i = SharedLibraryNameHelper.getInstance().c();

    /* renamed from: a  reason: collision with root package name */
    public ArrayDeque<PLAVFrame> f14151a = new ArrayDeque<>();
    public final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public volatile int f14152c = 0;
    public boolean d = false;
    public a e = new a(2);
    public a.a.a.a.a.a.g.a f;
    public ByteBuffer g;
    public ImageProcessor h;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/av/encoder/PLH264Encoder$Parameters.class */
    public static class Parameters {
        public boolean adaptiveBitrateEnable;
        public int bitrate;
        public int cpuWorkload;
        public int cropX;
        public int cropY;
        public int destHeight;
        public int destWidth;
        public int fps;
        public int h264Profile;
        public int imageHeight;
        public int imageWidth;
        public boolean isLoggingEnabled = e.a();
        public int maxKeyFrameInterval;
        public int mode;
        public boolean needEncodingFlip;
        public int rotation;
        public int srcFormat;
        public int srcHeight;
        public int srcSize;
        public int srcWidth;
        public WatermarkSetting wmSetting;

        public Parameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z, int i13, int i14, StreamingProfile.EncoderRCModes encoderRCModes, StreamingProfile.a aVar, StreamingProfile.H264Profile h264Profile, WatermarkSetting watermarkSetting, boolean z2) {
            this.srcSize = i3;
            this.srcWidth = i;
            this.srcHeight = i2;
            this.cropX = i4;
            this.cropY = i5;
            this.imageWidth = i6;
            this.imageHeight = i7;
            this.destWidth = i8;
            this.destHeight = i9;
            this.fps = i10;
            this.bitrate = i11;
            this.needEncodingFlip = z;
            this.rotation = i13;
            this.maxKeyFrameInterval = i12;
            this.srcFormat = i14;
            if (encoderRCModes == StreamingProfile.EncoderRCModes.QUALITY_PRIORITY) {
                this.mode = 0;
            } else if (encoderRCModes == StreamingProfile.EncoderRCModes.BITRATE_PRIORITY) {
                this.mode = 1;
            } else {
                this.mode = 0;
            }
            this.adaptiveBitrateEnable = z2;
            e eVar = e.i;
            eVar.c("PLH264Encoder", "cpuWorkload " + aVar);
            if (aVar == StreamingProfile.a.HIGH) {
                this.cpuWorkload = 0;
            } else if (aVar == StreamingProfile.a.MEDIUM) {
                this.cpuWorkload = 1;
            } else if (aVar == StreamingProfile.a.LOW) {
                this.cpuWorkload = 2;
            } else {
                this.cpuWorkload = 1;
            }
            e eVar2 = e.i;
            eVar2.c("PLH264Encoder", "h264Profile " + h264Profile);
            if (h264Profile == StreamingProfile.H264Profile.BASELINE) {
                this.h264Profile = 0;
            } else if (h264Profile == StreamingProfile.H264Profile.MAIN) {
                this.h264Profile = 1;
            } else if (h264Profile == StreamingProfile.H264Profile.HIGH) {
                this.h264Profile = 2;
            } else {
                this.h264Profile = 0;
            }
            this.wmSetting = watermarkSetting;
        }
    }

    private void doSPSAndPPSCallback(PLAVFrame pLAVFrame) {
        e eVar = e.i;
        eVar.c("PLH264Encoder", "doSPSAndPPSCallback size:" + pLAVFrame.mSize + ",encodedBuffer:" + pLAVFrame.mBuffer);
        PLBufferInfo pLBufferInfo = new PLBufferInfo();
        int i2 = pLBufferInfo.flags | 2;
        pLBufferInfo.flags = i2;
        int i3 = pLAVFrame.mSize;
        long j = pLAVFrame.mPresentationTimeUs / 1000;
        pLBufferInfo.set(0, i3, j, j, i2);
        pLBufferInfo.isNeedAddHeader = false;
        pLAVFrame.mBuffer.position(0);
        pLAVFrame.mBuffer.limit(pLAVFrame.mSize);
        a.a.a.a.a.a.g.a aVar = this.f;
        if (aVar != null) {
            aVar.a(pLAVFrame, pLBufferInfo);
        }
        e.i.c("PLH264Encoder", "doSPSAndPPSCallback -");
    }

    private void encodeCallback(PLAVFrame pLAVFrame, int i2) {
        if (pLAVFrame == null) {
            e.i.d("PLH264Encoder", "encodedFrame:" + pLAVFrame);
            return;
        }
        e.i.a("PLH264Encoder", "encodeCallback + size:" + pLAVFrame.mSize + ",frameType:" + i2 + ",ts:" + pLAVFrame.mPresentationTimeUs);
        long currentTimeMillis = System.currentTimeMillis();
        PLBufferInfo pLBufferInfo = new PLBufferInfo();
        if (i2 == 1 || i2 == 2) {
            pLBufferInfo.flags |= 1;
        } else {
            pLBufferInfo.flags |= 8;
        }
        pLBufferInfo.set(0, pLAVFrame.mSize, pLAVFrame.mPresentationTimeUs / 1000, pLAVFrame.mDtsUs / 1000, pLBufferInfo.flags);
        pLBufferInfo.isNeedAddHeader = false;
        pLAVFrame.mBuffer.position(0);
        pLAVFrame.mBuffer.limit(pLAVFrame.mSize);
        e.i.a("PLH264Encoder", "encodeCallback buffer:" + pLAVFrame.mBuffer);
        a.a.a.a.a.a.g.a aVar = this.f;
        if (aVar != null) {
            aVar.a(pLAVFrame, pLBufferInfo);
        }
        e.i.a("PLH264Encoder", "encodeCallback - cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    private PLAVFrame getOutputFrame(int i2) {
        e eVar = e.i;
        eVar.a("PLH264Encoder", "getOutputFrame + reqSize:" + i2);
        PLAVFrame a2 = this.e.a(i2);
        a2.mBuffer.clear();
        e eVar2 = e.i;
        eVar2.a("PLH264Encoder", "getOutputFrame - ,mBuffer:" + a2.mBuffer);
        return a2;
    }

    public static native void getPixelFromPBO(int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public int a() {
        this.e.a();
        this.d = false;
        this.h.a();
        release();
        synchronized (this.b) {
            this.f14151a.clear();
        }
        return 0;
    }

    public int a(int i2) {
        return reconfig(i2);
    }

    public void a(a.a.a.a.a.a.g.a aVar) {
        this.f = aVar;
    }

    public void a(WatermarkSetting watermarkSetting) {
        ImageProcessor imageProcessor = this.h;
        if (imageProcessor != null) {
            imageProcessor.updateWatermarkSetting(watermarkSetting);
        }
    }

    public void a(PLAVFrame pLAVFrame) {
        synchronized (this.b) {
            this.f14151a.add(pLAVFrame);
        }
    }

    public void a(PLAVFrame pLAVFrame, f.a aVar, boolean z) {
        if (!this.d) {
            e.i.d("PLH264Encoder", "encodeFrame not ready");
            return;
        }
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null || byteBuffer.capacity() < pLAVFrame.mSize) {
            this.g = ByteBuffer.allocateDirect(pLAVFrame.mSize);
        }
        this.g.clear();
        this.h.a(aVar.n);
        int encode = encode(this.g, this.h.convertYUV(pLAVFrame.mBuffer, pLAVFrame.mSize, this.g, aVar.m), pLAVFrame.mPresentationTimeUs, z, aVar.m);
        if (encode < 0) {
            e eVar = e.i;
            eVar.a("PLH264Encoder", "encodeFrame ret=" + encode);
        }
        a(pLAVFrame);
    }

    public void a(Parameters parameters) {
        int i2 = parameters.srcSize;
        e eVar = e.i;
        eVar.c("PLH264Encoder", "isLoggingEnabled:" + parameters.isLoggingEnabled);
        ImageProcessor imageProcessor = new ImageProcessor();
        this.h = imageProcessor;
        imageProcessor.initYUVProcessor(parameters.wmSetting, false, parameters.srcWidth, parameters.srcHeight, parameters.cropX, parameters.cropY, parameters.imageWidth, parameters.imageHeight, parameters.destWidth, parameters.destHeight, parameters.rotation, parameters.srcFormat, PLFourCC.FOURCC_I420, parameters.needEncodingFlip);
        initialize(parameters);
        int i3 = parameters.destWidth * parameters.destHeight * 2;
        e eVar2 = e.i;
        eVar2.c("PLH264Encoder", "dest size = " + i3 + ", w = " + parameters.destWidth + ", h = " + parameters.destHeight);
        this.g = ByteBuffer.allocateDirect(i3);
        this.d = true;
        this.f14152c = 0;
    }

    public PLAVFrame b(int i2) {
        PLAVFrame pLAVFrame;
        synchronized (this.b) {
            if (i2 <= 0) {
                e.i.e("PLH264Encoder", "Init improperly:" + i2);
                return null;
            }
            if (!this.f14151a.isEmpty()) {
                PLAVFrame remove = this.f14151a.remove();
                if (remove != null && remove.mBuffer != null && remove.mBuffer.capacity() >= i2) {
                    return remove;
                }
                e.i.d("PLH264Encoder", "The frame is:" + remove);
            }
            if (this.f14152c < 2) {
                try {
                    pLAVFrame = new PLAVFrame(ByteBuffer.allocateDirect(i2), 0, 0L);
                    try {
                        this.f14152c++;
                        e.i.c("PLH264Encoder", "Allocate extra buffer mInputExtraNum:" + this.f14152c + ",frame.buffer:" + pLAVFrame.mBuffer);
                    } catch (OutOfMemoryError e) {
                        e.i.e("PLH264Encoder", "Fatal Error. OOM !!!");
                        return pLAVFrame;
                    }
                } catch (OutOfMemoryError e2) {
                    pLAVFrame = null;
                }
                return pLAVFrame;
            }
            return null;
        }
    }

    public void b() {
    }

    public void b(PLAVFrame pLAVFrame) {
        pLAVFrame.mBuffer.clear();
        this.e.a(pLAVFrame);
    }

    public void c(PLAVFrame pLAVFrame) {
        b(pLAVFrame);
    }

    public native int encode(ByteBuffer byteBuffer, int i2, long j, boolean z, boolean z2);

    public final native void initialize(Parameters parameters);

    public final native int reconfig(int i2);

    public native void release();
}
