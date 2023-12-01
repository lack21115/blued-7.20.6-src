package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/RemoteBusiness.class */
public class RemoteBusiness extends MtopBusiness {
    private RemoteBusiness(IMTOPDataObject iMTOPDataObject, String str) {
        super(iMTOPDataObject, str);
    }

    private RemoteBusiness(MtopRequest mtopRequest, String str) {
        super(mtopRequest, str);
    }

    public static RemoteBusiness build(IMTOPDataObject iMTOPDataObject) {
        return new RemoteBusiness(iMTOPDataObject, (String) null);
    }

    public static RemoteBusiness build(IMTOPDataObject iMTOPDataObject, String str) {
        return new RemoteBusiness(iMTOPDataObject, str);
    }

    public static RemoteBusiness build(MtopRequest mtopRequest) {
        return new RemoteBusiness(mtopRequest, (String) null);
    }

    public static RemoteBusiness build(MtopRequest mtopRequest, String str) {
        return new RemoteBusiness(mtopRequest, str);
    }
}
