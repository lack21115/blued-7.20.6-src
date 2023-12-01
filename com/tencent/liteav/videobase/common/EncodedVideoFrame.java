package com.tencent.liteav.videobase.common;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/common/EncodedVideoFrame.class */
public class EncodedVideoFrame {
    private static final String TAG = "EncodedVideoFrame";
    public ByteBuffer data;
    public long dts;
    public int height;
    public a nalType;
    public b profileType;
    public long pts;
    public int rotation;
    public MediaFormat videoFormat;
    public int width;
    public long nativePtr = 0;
    public CodecType codecType = CodecType.H264;
    public long gopIndex = 0;
    public long gopFrameIndex = 0;
    public long frameIndex = 0;
    public long refFrameIndex = 0;
    public Integer svcInfo = null;
    public boolean isEosFrame = false;
    public MediaCodec.BufferInfo info = null;

    public static EncodedVideoFrame createEncodedVideoFrame(ByteBuffer byteBuffer, int i, int i2, int i3, long j, long j2, long j3, long j4, long j5, long j6, int i4, long j7, int i5, int i6, boolean z, int i7) {
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        encodedVideoFrame.data = byteBuffer;
        encodedVideoFrame.nativePtr = j7;
        encodedVideoFrame.nalType = a.a(i);
        encodedVideoFrame.profileType = b.a(i2);
        encodedVideoFrame.codecType = CodecType.a(i4);
        encodedVideoFrame.rotation = i3;
        encodedVideoFrame.dts = j;
        encodedVideoFrame.pts = j2;
        encodedVideoFrame.gopIndex = j3;
        encodedVideoFrame.gopFrameIndex = j4;
        encodedVideoFrame.frameIndex = j5;
        encodedVideoFrame.refFrameIndex = j6;
        encodedVideoFrame.info = null;
        encodedVideoFrame.width = i5;
        encodedVideoFrame.height = i6;
        if (z) {
            encodedVideoFrame.svcInfo = Integer.valueOf(i7);
            return encodedVideoFrame;
        }
        encodedVideoFrame.svcInfo = null;
        return encodedVideoFrame;
    }

    private a getNalTypeFromH264NALHeader(ByteBuffer byteBuffer, int i) {
        int i2 = byteBuffer.get(i) & 31;
        return i2 != 5 ? i2 != 6 ? i2 != 7 ? i2 != 8 ? a.UNKNOWN : a.PPS : a.SPS : a.SEI : a.IDR;
    }

    private a getNalTypeFromH265NALHeader(ByteBuffer byteBuffer, int i) {
        int i2 = (byteBuffer.get(i) & 126) >> 1;
        if (i2 != 39) {
            switch (i2) {
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    return a.IDR;
                default:
                    switch (i2) {
                        case 32:
                            return a.VPS;
                        case 33:
                            return a.SPS;
                        case 34:
                            return a.PPS;
                        default:
                            return a.UNKNOWN;
                    }
            }
        }
        return a.SEI;
    }

    public static int getNextNALHeaderPos(int i, ByteBuffer byteBuffer) {
        while (true) {
            int i2 = i + 3;
            if (i2 >= byteBuffer.remaining()) {
                return -1;
            }
            if (byteBuffer.get(i) == 0 && byteBuffer.get(i + 1) == 0 && byteBuffer.get(i + 2) == 0 && byteBuffer.get(i2) == 1) {
                return i + 4;
            }
            if (byteBuffer.get(i) == 0 && byteBuffer.get(i + 1) == 0 && byteBuffer.get(i + 2) == 1) {
                return i2;
            }
            i++;
        }
    }

    private native void nativeRelease(long j);

    public static long resetEncodedVideoFrame(EncodedVideoFrame encodedVideoFrame) {
        long j = encodedVideoFrame.nativePtr;
        if (j == 0 || encodedVideoFrame.data == null) {
            return 0L;
        }
        encodedVideoFrame.data = null;
        encodedVideoFrame.nativePtr = 0L;
        return j;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.nativePtr != 0) {
            LiteavLog.w(TAG, "nativePtr != 0, must call release before finalize ");
            release();
        }
    }

    public boolean isH265() {
        return this.codecType == CodecType.H265;
    }

    public boolean isIDRFrame() {
        a aVar = this.nalType;
        if (aVar != null) {
            return aVar == a.IDR;
        }
        return false;
    }

    public boolean isRPSEnable() {
        return this.profileType == b.BASELINE_RPS || this.profileType == b.MAIN_RPS || this.profileType == b.HIGH_RPS;
    }

    public boolean isSVCEnable() {
        return this.svcInfo != null;
    }

    public void release() {
        long j = this.nativePtr;
        if (j != 0) {
            nativeRelease(j);
            this.nativePtr = 0L;
        }
    }

    public String toString() {
        return "nalType = " + this.nalType + ", profiletype=" + this.profileType + ", rotation=" + this.rotation + ", codecType=" + this.codecType + ", dts=" + this.dts + ", pts=" + this.pts + ", gopIndex=" + this.gopIndex + ", gopFrameIndex=" + this.gopFrameIndex + ", frameIndex=" + this.frameIndex;
    }

    public void updateNALTypeAccordingNALHeader() {
        if (this.data == null) {
            return;
        }
        a aVar = this.nalType;
        if (aVar != null && aVar != a.UNKNOWN) {
            return;
        }
        int i = 0;
        while (true) {
            int nextNALHeaderPos = getNextNALHeaderPos(i, this.data);
            if (nextNALHeaderPos == -1 || nextNALHeaderPos >= this.data.remaining()) {
                return;
            }
            a aVar2 = a.UNKNOWN;
            a nalTypeFromH265NALHeader = isH265() ? getNalTypeFromH265NALHeader(this.data, nextNALHeaderPos) : getNalTypeFromH264NALHeader(this.data, nextNALHeaderPos);
            a aVar3 = this.nalType;
            if (aVar3 == null || aVar3 == a.UNKNOWN || nalTypeFromH265NALHeader == a.IDR) {
                this.nalType = nalTypeFromH265NALHeader;
            }
            i = nextNALHeaderPos;
            if (this.nalType != a.SPS) {
                i = nextNALHeaderPos;
                if (this.nalType != a.PPS) {
                    i = nextNALHeaderPos;
                    if (this.nalType != a.VPS) {
                        i = nextNALHeaderPos;
                        if (this.nalType != a.SEI) {
                            return;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
