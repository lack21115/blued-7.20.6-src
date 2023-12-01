package com.tencent.thumbplayer.api.proxy;

import android.content.Context;
import com.tencent.thumbplayer.c.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/proxy/TPP2PProxyFactory.class */
public class TPP2PProxyFactory {
    public static ITPPreloadProxy createPreloadManager(Context context, int i) {
        return new g(context, i);
    }
}
