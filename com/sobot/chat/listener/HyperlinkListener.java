package com.sobot.chat.listener;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/listener/HyperlinkListener.class */
public interface HyperlinkListener {
    void onEmailClick(String str);

    void onPhoneClick(String str);

    void onUrlClick(String str);
}
