package com.blued.android.chat.listener;

import com.blued.android.chat.model.SessionModel;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/listener/SingleSessionListener.class */
public interface SingleSessionListener {
    void onSessionDataChanged(SessionModel sessionModel);

    void onSessionRemoved(short s, long j);
}
