package com.sina.weibo.sdk.api.share;

import android.os.Bundle;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/Base.class */
public abstract class Base {
    public String transaction;

    public abstract void fromBundle(Bundle bundle);

    public abstract int getType();

    public abstract void toBundle(Bundle bundle);
}
