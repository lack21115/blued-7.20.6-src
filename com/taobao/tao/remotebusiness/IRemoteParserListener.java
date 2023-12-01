package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/IRemoteParserListener.class */
public interface IRemoteParserListener extends MtopListener {
    void parseResponse(MtopResponse mtopResponse);
}
