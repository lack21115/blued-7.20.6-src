package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/IRemoteCacheListener.class */
public interface IRemoteCacheListener extends MtopListener {
    void onCached(MtopCacheEvent mtopCacheEvent, BaseOutDo baseOutDo, Object obj);
}
