package com.sobot.chat.voice;

import com.sobot.chat.api.model.ZhiChiMessageBase;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/voice/AudioPlayCallBack.class */
public interface AudioPlayCallBack {
    void onPlayEnd(ZhiChiMessageBase zhiChiMessageBase);

    void onPlayStart(ZhiChiMessageBase zhiChiMessageBase);
}
