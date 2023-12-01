package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.MtopListener;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/listener/b.class */
abstract class b {
    protected MtopListener listener;
    protected MtopBusiness mtopBusiness;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        this.listener = null;
        this.mtopBusiness = null;
        this.mtopBusiness = mtopBusiness;
        this.listener = mtopListener;
    }
}
