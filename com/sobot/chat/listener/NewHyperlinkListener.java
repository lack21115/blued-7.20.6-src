package com.sobot.chat.listener;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/listener/NewHyperlinkListener.class */
public interface NewHyperlinkListener {
    boolean onEmailClick(Context context, String str);

    boolean onPhoneClick(Context context, String str);

    boolean onUrlClick(Context context, String str);
}
