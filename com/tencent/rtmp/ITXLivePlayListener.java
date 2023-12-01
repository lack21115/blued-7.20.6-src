package com.tencent.rtmp;

import android.os.Bundle;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/ITXLivePlayListener.class */
public interface ITXLivePlayListener {
    void onNetStatus(Bundle bundle);

    void onPlayEvent(int i, Bundle bundle);
}
