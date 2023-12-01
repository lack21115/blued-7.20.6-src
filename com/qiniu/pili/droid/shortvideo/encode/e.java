package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.BatteryManager;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.encode.d;
import com.qiniu.pili.droid.shortvideo.f.g;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/e.class */
public class e extends d implements a.InterfaceC0575a {
    private PLVideoEncodeSetting g;
    private a.InterfaceC0575a h;

    public e(PLVideoEncodeSetting pLVideoEncodeSetting) {
        this.g = pLVideoEncodeSetting;
        super.a(this);
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
    public void a(MediaFormat mediaFormat) {
        a.InterfaceC0575a interfaceC0575a = this.h;
        if (interfaceC0575a != null) {
            interfaceC0575a.a(mediaFormat);
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
    public void a(Surface surface) {
        a.InterfaceC0575a interfaceC0575a = this.h;
        if (interfaceC0575a != null) {
            interfaceC0575a.a(surface);
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a
    public void a(a.InterfaceC0575a interfaceC0575a) {
        this.h = interfaceC0575a;
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
    public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        a.InterfaceC0575a interfaceC0575a = this.h;
        if (interfaceC0575a != null) {
            interfaceC0575a.a(byteBuffer, bufferInfo);
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
    public void a(boolean z) {
        a.InterfaceC0575a interfaceC0575a = this.h;
        if (interfaceC0575a != null) {
            interfaceC0575a.a(z);
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.d, com.qiniu.pili.droid.shortvideo.encode.a
    public boolean a(long j) {
        synchronized (this) {
            if (m()) {
                com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "stop is marked, not accepting anymore frames.");
                return false;
            } else if (this.e == null) {
                com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "encoder is null.");
                return false;
            } else {
                long b = b(j);
                if (b < 0) {
                    return false;
                }
                d();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
                String j2 = j();
                eVar.b(j2, "input frame: " + this.b + " timestampNs:" + b);
                return true;
            }
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
    public void b(boolean z) {
        a.InterfaceC0575a interfaceC0575a = this.h;
        if (interfaceC0575a != null) {
            interfaceC0575a.b(z);
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.d
    protected MediaFormat g() {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.g.getVideoEncodingWidth(), this.g.getVideoEncodingHeight());
        int round = Math.round((this.g.getIFrameInterval() * 1.0f) / this.g.getVideoEncodingFps());
        createVideoFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface);
        createVideoFormat.setInteger(MediaFormat.KEY_BIT_RATE, (int) (this.g.getEncodingBitrate() * (this.g.IsConstFrameRateEnabled() ? 1.0d : this.f13961a)));
        createVideoFormat.setInteger(MediaFormat.KEY_FRAME_RATE, (int) (this.g.getVideoEncodingFps() * (this.g.IsConstFrameRateEnabled() ? 1.0d : this.f13961a)));
        createVideoFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, round);
        createVideoFormat.setInteger(MediaFormat.KEY_PROFILE, g.a(this.g.getProfileMode()));
        int i = 1;
        createVideoFormat.setInteger(BatteryManager.EXTRA_LEVEL, 1);
        if (this.g.getBitrateMode() == PLVideoEncodeSetting.BitrateMode.BITRATE_PRIORITY) {
            i = 2;
        } else if (this.g.getBitrateMode() == PLVideoEncodeSetting.BitrateMode.CONSTANT_QUALITY_PRIORITY) {
            i = 0;
        }
        createVideoFormat.setInteger(MediaFormat.KEY_BITRATE_MODE, i);
        return createVideoFormat;
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.d
    protected String h() {
        return "video/avc";
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.d
    protected d.a i() {
        return d.a.VIDEO_ENCODER;
    }

    @Override // com.qiniu.pili.droid.shortvideo.f.k
    public String j() {
        return "HWVideoEncoder";
    }
}
