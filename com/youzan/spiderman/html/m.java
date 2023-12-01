package com.youzan.spiderman.html;

import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.OkHttpUtil;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private l f28156a;
    private HtmlHeader b;

    /* renamed from: c  reason: collision with root package name */
    private Headers f28157c;
    private Response d;
    private ResponseBody e;
    private g f;

    public m(l lVar, Headers headers, Response response) {
        this.f28156a = lVar;
        this.b = HtmlHeader.fromMapList(headers.toMultimap());
        this.f28157c = headers;
        this.d = response;
        ResponseBody body = response.body();
        this.e = body;
        this.f = new g(System.currentTimeMillis(), this.f28156a.c(), this.f28156a.a(), null, OkHttpUtil.getContentCharset(body).name());
    }

    public final j a(e eVar) {
        InputStream byteStream;
        BufferedInputStream bufferedInputStream;
        ResponseBody responseBody = this.e;
        if (responseBody == null || (byteStream = responseBody.byteStream()) == null) {
            return null;
        }
        if ("gzip".equalsIgnoreCase(this.f28157c.get("Content-Encoding"))) {
            try {
                bufferedInputStream = new BufferedInputStream(new GZIPInputStream(byteStream));
            } catch (IOException e) {
                Logger.e("HttpResponse", e);
                bufferedInputStream = null;
            }
        } else {
            bufferedInputStream = new BufferedInputStream(byteStream);
        }
        if (bufferedInputStream != null) {
            return new j(this.b, this.f, bufferedInputStream, eVar);
        }
        return null;
    }

    public final boolean a() {
        return this.d.isRedirect();
    }

    public final HtmlHeader b() {
        return this.b;
    }

    public final g c() {
        return this.f;
    }
}
