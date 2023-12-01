package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.o;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLShortVideoMixer.class */
public class PLShortVideoMixer {
    private o mShortVideoMixerCore;

    public PLShortVideoMixer(Context context, String str, long j) {
        this.mShortVideoMixerCore = new o(context, str, j);
    }

    public void cancel() {
        this.mShortVideoMixerCore.a();
    }

    public void mix(List<PLVideoMixItem> list, PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoMixerCore.a(list, pLVideoSaveListener);
        QosManager.a().a(QosManager.KeyPoint.mix_video);
        QosManager.a().a(this.mShortVideoMixerCore.a(list.size()));
    }

    public void setVideoEncodeSetting(PLVideoEncodeSetting pLVideoEncodeSetting) {
        this.mShortVideoMixerCore.a(pLVideoEncodeSetting);
    }
}
