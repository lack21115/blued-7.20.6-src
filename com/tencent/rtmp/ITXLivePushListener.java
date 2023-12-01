package com.tencent.rtmp;

import android.os.Bundle;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/ITXLivePushListener.class */
public interface ITXLivePushListener {
    void onNetStatus(Bundle bundle);

    void onPushEvent(int i, Bundle bundle);
}
