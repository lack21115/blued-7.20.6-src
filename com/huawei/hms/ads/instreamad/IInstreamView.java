package com.huawei.hms.ads.instreamad;

import android.view.View;
import com.huawei.hms.ads.MediaMuteListener;
import com.huawei.hms.ads.instreamad.InstreamView;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/instreamad/IInstreamView.class */
public interface IInstreamView {
    void destroy();

    View getCallToActionView();

    boolean isPlaying();

    void mute();

    void onClose();

    void pause();

    void play();

    void registerOverlays(List<View> list);

    void removeInstreamMediaChangeListener();

    void removeInstreamMediaStateListener();

    void removeMediaMuteListener();

    void setCallToActionView(View view);

    void setInstreamAds(List<InstreamAd> list);

    void setInstreamMediaChangeListener(InstreamMediaChangeListener instreamMediaChangeListener);

    void setInstreamMediaStateListener(InstreamMediaStateListener instreamMediaStateListener);

    void setMediaMuteListener(MediaMuteListener mediaMuteListener);

    void setOnInstreamAdClickListener(InstreamView.OnInstreamAdClickListener onInstreamAdClickListener);

    void stop();

    void unmute();
}
