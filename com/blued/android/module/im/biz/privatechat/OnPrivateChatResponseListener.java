package com.blued.android.module.im.biz.privatechat;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/privatechat/OnPrivateChatResponseListener.class */
public interface OnPrivateChatResponseListener {
    void onFailure(int i, int i2, Exception exc);

    void onSuccess(int i, long j, long j2, String str);
}
