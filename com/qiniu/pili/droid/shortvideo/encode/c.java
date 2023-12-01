package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaFormat;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.encode.d;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/c.class */
public class c extends d {
    private PLAudioEncodeSetting g;

    public c(PLAudioEncodeSetting pLAudioEncodeSetting) {
        this.g = pLAudioEncodeSetting;
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.d
    protected MediaFormat g() {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.g.getSamplerate(), this.g.getChannels());
        createAudioFormat.setInteger(MediaFormat.KEY_AAC_PROFILE, 2);
        createAudioFormat.setInteger(MediaFormat.KEY_SAMPLE_RATE, this.g.getSamplerate());
        createAudioFormat.setInteger(MediaFormat.KEY_CHANNEL_COUNT, this.g.getChannels());
        createAudioFormat.setInteger(MediaFormat.KEY_BIT_RATE, this.g.getBitrate());
        createAudioFormat.setInteger(MediaFormat.KEY_MAX_INPUT_SIZE, 16384);
        return createAudioFormat;
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.d
    protected String h() {
        return "audio/mp4a-latm";
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.d
    protected d.a i() {
        return d.a.AUDIO_ENCODER;
    }

    @Override // com.qiniu.pili.droid.shortvideo.f.k
    public String j() {
        return "HWAudioEncoder";
    }
}
