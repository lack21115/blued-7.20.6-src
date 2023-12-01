package com.youzan.spiderman.html;

import android.content.ClipDescription;
import com.google.common.net.HttpHeaders;
import com.youzan.spiderman.cache.SpiderCacheCallback;
import com.youzan.spiderman.cache.SpiderMan;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.OkHttpUtil;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private l f41828a;

    public b(l lVar) {
        this.f41828a = lVar;
    }

    public final HtmlResponse a() {
        HashMap hashMap = new HashMap();
        hashMap.put("method", "GET");
        hashMap.put("Host", this.f41828a.b().getHost());
        hashMap.put(HttpHeaders.ACCEPT, ClipDescription.MIMETYPE_TEXT_HTML);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN,zh;");
        l lVar = this.f41828a;
        SpiderCacheCallback spiderCacheCallback = SpiderMan.getInstance().getSpiderCacheCallback();
        if (spiderCacheCallback != null) {
            spiderCacheCallback.onCustomRequestHeader(lVar.a(), hashMap);
        } else {
            Logger.e("FetchHelper", "SpiderCacheCallback should be offered to custom html request header", new Object[0]);
        }
        m downloadHtml = OkHttpUtil.downloadHtml(HtmlHeader.fromMap(hashMap), this.f41828a);
        HtmlResponse htmlResponse = null;
        if (downloadHtml == null) {
            Logger.e("FetchHtmlRunner", "html response return null", new Object[0]);
            return null;
        }
        e eVar = new e(this.f41828a);
        if (downloadHtml.a()) {
            eVar.a();
            return null;
        }
        g c2 = downloadHtml.c();
        byte[] a2 = com.youzan.spiderman.cache.b.a(downloadHtml.a(eVar));
        if (a2 != null) {
            htmlResponse = new HtmlResponse(downloadHtml.b().getHeaders(), a2, c2.c());
        }
        return htmlResponse;
    }
}
