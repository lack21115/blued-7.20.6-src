package com.tencent.rtmp;

import android.os.Bundle;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/ITXVodPlayListener.class */
public interface ITXVodPlayListener {
    void onNetStatus(TXVodPlayer tXVodPlayer, Bundle bundle);

    void onPlayEvent(TXVodPlayer tXVodPlayer, int i, Bundle bundle);
}
