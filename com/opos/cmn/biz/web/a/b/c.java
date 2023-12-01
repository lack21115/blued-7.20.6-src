package com.opos.cmn.biz.web.a.b;

import android.content.Context;
import android.webkit.WebResourceResponse;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/a/b/c.class */
public class c implements com.opos.cmn.biz.web.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f24718a = new byte[0];
    private static c b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.cmn.biz.web.a.a.a f24719c = new com.opos.cmn.biz.web.a.a.b();

    private c() {
    }

    public static c a() {
        if (b == null) {
            synchronized (f24718a) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public WebResourceResponse a(String str) {
        return this.f24719c.a(str);
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            throw new Exception("init params error");
        }
        this.f24719c.a(context, bVar);
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(List<a> list) {
        this.f24719c.a(list);
    }
}
