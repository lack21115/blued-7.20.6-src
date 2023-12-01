package com.youzan.spiderman.c.c;

import android.content.Context;
import com.youzan.spiderman.html.HtmlCallback;
import com.youzan.spiderman.html.d;
import com.youzan.spiderman.html.f;
import com.youzan.spiderman.html.l;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.NetWorkUtil;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/c/a.class */
public final class a extends com.youzan.spiderman.a.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f28063a;
    private f b;

    public a(Context context, f fVar) {
        this.f28063a = context;
        this.b = fVar;
    }

    @Override // com.youzan.spiderman.a.a
    public final void a() throws Throwable {
        List<String> b;
        if (!NetWorkUtil.hasNetworkPermission(this.f28063a)) {
            Logger.e("FetchHtmlJob", "has no network permission to run fetch html job", new Object[0]);
            return;
        }
        b bVar = (b) com.youzan.spiderman.cache.b.a((Class<Object>) b.class, "fetch_html_pref");
        f fVar = this.b;
        if (fVar == null || !fVar.a(bVar.a()) || (b = this.b.b()) == null || b.isEmpty()) {
            return;
        }
        d a2 = d.a();
        for (String str : b) {
            l lVar = new l(str);
            if (!a2.a(lVar)) {
                a2.b(lVar).a((HtmlCallback) null);
            }
        }
        bVar.a(System.currentTimeMillis());
        com.youzan.spiderman.cache.b.a(bVar, "fetch_html_pref");
    }

    @Override // com.youzan.spiderman.a.a
    public final void a(Throwable th) {
        Logger.e("FetchHtmlJob", "fetch html have error: " + th.getMessage(), new Object[0]);
    }
}
