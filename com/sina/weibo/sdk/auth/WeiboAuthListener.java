package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import com.sina.weibo.sdk.exception.WeiboException;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/auth/WeiboAuthListener.class */
public interface WeiboAuthListener {
    void onCancel();

    void onComplete(Bundle bundle);

    void onWeiboException(WeiboException weiboException);
}
