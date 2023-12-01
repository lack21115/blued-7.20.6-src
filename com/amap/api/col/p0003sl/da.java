package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.hx;
import com.amap.api.col.p0003sl.kb;
import com.amap.api.maps.MapsInitializer;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.da  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/da.class */
public abstract class da extends kb {
    protected boolean isPostFlag = true;

    @Override // com.amap.api.col.p0003sl.kb
    public Map<String, String> getParams() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] makeHttpRequest() throws hn {
        kc makeHttpRequestNeedHeader = makeHttpRequestNeedHeader();
        if (makeHttpRequestNeedHeader != null) {
            return makeHttpRequestNeedHeader.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public kc makeHttpRequestNeedHeader() throws hn {
        if (aa.a == null || hx.a(aa.a, dw.a()).a == hx.c.SuccessCode) {
            setHttpProtocol(MapsInitializer.getProtocol() == 1 ? kb.c.HTTP : kb.c.HTTPS);
            ka.c();
            return this.isPostFlag ? ka.a(this) : ka.e(this);
        }
        return null;
    }

    public byte[] makeHttpRequestWithInterrupted() throws hn {
        setDegradeAbility(kb.a.INTERRUPT_IO);
        return makeHttpRequest();
    }
}
