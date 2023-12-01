package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;
import java.util.Objects;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/SpsInfo.class */
public class SpsInfo {
    public int width = 0;
    public int height = 0;
    public Integer videoFormat = null;
    public Integer videoFullRangeFlag = null;
    public Integer colourPrimaries = null;
    public Integer transferCharacteristics = null;
    public Integer matrixCoefficients = null;

    public static native SpsInfo nativeDecodeSps(boolean z, ByteBuffer byteBuffer);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SpsInfo) {
            SpsInfo spsInfo = (SpsInfo) obj;
            return spsInfo.width == this.width && spsInfo.height == this.height && Objects.equals(this.videoFormat, spsInfo.videoFormat) && Objects.equals(this.videoFullRangeFlag, spsInfo.videoFullRangeFlag) && Objects.equals(this.colourPrimaries, spsInfo.colourPrimaries) && Objects.equals(this.transferCharacteristics, spsInfo.transferCharacteristics) && Objects.equals(this.matrixCoefficients, spsInfo.matrixCoefficients);
        }
        return false;
    }

    public void set(SpsInfo spsInfo) {
        SpsInfo spsInfo2 = spsInfo;
        if (spsInfo == null) {
            spsInfo2 = new SpsInfo();
        }
        this.width = spsInfo2.width;
        this.height = spsInfo2.height;
        this.videoFormat = spsInfo2.videoFormat;
        this.videoFullRangeFlag = spsInfo2.videoFullRangeFlag;
        this.colourPrimaries = spsInfo2.colourPrimaries;
        this.transferCharacteristics = spsInfo2.transferCharacteristics;
        this.matrixCoefficients = spsInfo2.matrixCoefficients;
    }

    public void setColourPrimaries(int i) {
        this.colourPrimaries = Integer.valueOf(i);
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setMatrixCoefficients(int i) {
        this.matrixCoefficients = Integer.valueOf(i);
    }

    public void setTransferCharacteristics(int i) {
        this.transferCharacteristics = Integer.valueOf(i);
    }

    public void setVideoFormat(int i) {
        this.videoFormat = Integer.valueOf(i);
    }

    public void setVideoFullRangeFlag(int i) {
        this.videoFullRangeFlag = Integer.valueOf(i);
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public String toString() {
        return "SpsInfo(" + ("width=" + this.width + ",height=" + this.height + ",videoFormat=" + this.videoFormat + ",videoFullRangeFlag=" + this.videoFullRangeFlag + ",colourPrimaries=" + this.colourPrimaries + ",transferCharacteristics=" + this.transferCharacteristics + ",matrixCoefficients=" + this.matrixCoefficients) + ")";
    }
}
