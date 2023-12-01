package mtopsdk.mtop.common;

import mtopsdk.a.a;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxy;
import mtopsdk.mtop.domain.IMTOPDataObject;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/ApiID.class */
public class ApiID implements IMTOPDataObject {

    /* renamed from: a  reason: collision with root package name */
    private MtopProxy f43706a;
    private volatile a b;

    public ApiID(a aVar, MtopProxy mtopProxy) {
        this.b = aVar;
        this.f43706a = mtopProxy;
    }

    public a a() {
        return this.b;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public boolean b() {
        if (this.b == null) {
            TBSdkLog.d("mtopsdk.ApiID", "Future is null,cancel apiCall failed");
            return false;
        }
        this.b.c();
        return true;
    }

    public String toString() {
        return "ApiID [call=" + this.b + ", mtopProxy=" + this.f43706a + "]";
    }
}
