package com.anythink.expressad.atsignalcommon.mraid;

import com.anythink.expressad.foundation.d.c;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/mraid/IMraidSignalCommunication.class */
public interface IMraidSignalCommunication {
    void close();

    void expand(String str, boolean z);

    c getMraidCampaign();

    void open(String str);

    void unload();

    void useCustomClose(boolean z);
}
