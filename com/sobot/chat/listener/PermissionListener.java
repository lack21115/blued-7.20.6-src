package com.sobot.chat.listener;

import android.app.Activity;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/listener/PermissionListener.class */
public interface PermissionListener {
    void onPermissionErrorListener(Activity activity, String str);

    void onPermissionSuccessListener();
}
