package com.taobao.tao.remotebusiness.a;

import com.taobao.tao.remotebusiness.MtopBusiness;
import java.io.Serializable;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/a/b.class */
public final class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public MtopListener f21220a;
    public MtopEvent b;

    /* renamed from: c  reason: collision with root package name */
    public BaseOutDo f21221c;
    public MtopBusiness d;
    public MtopResponse e;

    public b() {
    }

    public b(MtopListener mtopListener, MtopEvent mtopEvent, MtopBusiness mtopBusiness) {
        this.f21220a = mtopListener;
        this.b = mtopEvent;
        this.d = mtopBusiness;
    }
}
