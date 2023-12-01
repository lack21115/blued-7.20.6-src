package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/IRemoteBaseListener.class */
public interface IRemoteBaseListener extends MtopListener {
    void onError(int i, MtopResponse mtopResponse, Object obj);

    void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj);

    void onSystemError(int i, MtopResponse mtopResponse, Object obj);
}
