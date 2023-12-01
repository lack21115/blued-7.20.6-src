package mtopsdk.mtop.common;

import java.io.Serializable;
import java.util.Map;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.unit.UserUnit;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopNetworkProp.class */
public class MtopNetworkProp implements Serializable, IMTOPDataObject {
    private static final long serialVersionUID = -3528337805304245196L;
    public Map e;
    public String g;
    public Map k;
    public int n;
    public UserUnit p;
    public String q;
    public ProtocolEnum a = ProtocolEnum.HTTP;
    public MethodEnum b = MethodEnum.GET;
    public boolean c = true;
    public int d = 1;
    public boolean f = false;
    public boolean h = false;
    public boolean i = false;
    public int j = -1;
    public int l = 15000;
    public int m = 15000;
    public EnvModeEnum o = EnvModeEnum.ONLINE;

    public String toString() {
        return "MtopNetworkProp [protocol=" + this.a + ", method=" + this.b + ", autoRedirect=" + this.c + ", retryTimes=" + this.d + ", requestHeaders=" + this.e + ", correctTimeStamp=" + this.f + ", ttid=" + this.g + ", useCache=" + this.h + ", forceRefreshCache=" + this.i + ", wuaFlag=" + this.j + ", queryParameterMap=" + this.k + ", connTimeout=" + this.l + ", socketTimeout=" + this.m + ", bizId=" + this.n + ", envMode=" + this.o + ", userUnit=" + this.p + "]";
    }
}
