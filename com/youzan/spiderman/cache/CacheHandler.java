package com.youzan.spiderman.cache;

import android.content.Context;
import android.net.Uri;
import com.youzan.spiderman.cache.CacheStatistic;
import com.youzan.spiderman.cache.b;
import com.youzan.spiderman.html.HtmlResponse;
import com.youzan.spiderman.html.HtmlStatistic;
import com.youzan.spiderman.html.k;
import com.youzan.spiderman.html.l;
import com.youzan.spiderman.utils.IOUtils;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.UriUtil;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/CacheHandler.class */
public class CacheHandler {

    /* renamed from: a  reason: collision with root package name */
    private Context f28092a;

    /* renamed from: c  reason: collision with root package name */
    private final HandlerCallback f28093c;
    private final CacheStatistic d;
    private final k b = k.a();
    private final f e = f.a();
    private final b f = b.a.f28110a;
    private final com.youzan.spiderman.c.a.a g = com.youzan.spiderman.c.a.a.a();
    private final com.youzan.spiderman.b.f h = com.youzan.spiderman.b.f.a();
    private List<CacheUrl> i = new LinkedList();

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/CacheHandler$HandlerCallback.class */
    public interface HandlerCallback {
        void onCacheStatistic(Map<String, String> map);

        void onHtmlStatistic(Map<String, String> map);
    }

    public CacheHandler(Context context, final HandlerCallback handlerCallback) {
        this.f28092a = context;
        this.f28093c = handlerCallback;
        this.d = new CacheStatistic(new CacheStatistic.StatisticCallback() { // from class: com.youzan.spiderman.cache.CacheHandler.1
            @Override // com.youzan.spiderman.cache.CacheStatistic.StatisticCallback
            public final void onStatistic(String str, Map<String, String> map) {
                HandlerCallback handlerCallback2 = handlerCallback;
                if (handlerCallback2 != null) {
                    handlerCallback2.onCacheStatistic(map);
                }
                if (CacheHandler.this.i == null || CacheHandler.this.i.isEmpty()) {
                    return;
                }
                com.youzan.spiderman.c.g.b bVar = new com.youzan.spiderman.c.g.b(str, CacheHandler.this.i);
                CacheHandler.this.i = new LinkedList();
                com.youzan.spiderman.c.g.a.a().a(CacheHandler.this.f28092a, bVar);
            }
        });
    }

    private static ResourceResponse a(String str, File file) {
        try {
            return new ResourceResponse(str, "UTF-8", IOUtils.openFile(file));
        } catch (IOException e) {
            e.printStackTrace();
            Logger.e("CacheHandler", "build web resource response exception: ", e);
            return null;
        }
    }

    public void destory() {
        this.d.destory();
    }

    public void parseStatisticTiming(Uri uri) {
        this.d.parseStatisticTiming(uri);
    }

    public void parseStatisticTiming(String str) {
        this.d.parseStatisticTiming(str);
    }

    public void resetStatistic() {
        this.d.reset();
    }

    public HtmlResponse shouldInterceptHtml(Uri uri) {
        HandlerCallback handlerCallback;
        l lVar = new l(uri);
        if (this.f.a(lVar)) {
            HtmlStatistic htmlStatistic = new HtmlStatistic(lVar.a());
            HtmlResponse a2 = this.b.a(this.f28092a, lVar, htmlStatistic);
            if (htmlStatistic.isNeedRecord() && (handlerCallback = this.f28093c) != null) {
                handlerCallback.onHtmlStatistic(htmlStatistic.getStatisticData());
            }
            return a2;
        }
        return null;
    }

    public HtmlResponse shouldInterceptHtml(String str) {
        HandlerCallback handlerCallback;
        l lVar = new l(str);
        if (this.f.a(lVar)) {
            HtmlStatistic htmlStatistic = new HtmlStatistic(str);
            HtmlResponse a2 = this.b.a(this.f28092a, lVar, htmlStatistic);
            if (htmlStatistic.isNeedRecord() && (handlerCallback = this.f28093c) != null) {
                handlerCallback.onHtmlStatistic(htmlStatistic.getStatisticData());
            }
            return a2;
        }
        return null;
    }

    public ResourceResponse shouldInterceptRequest(Uri uri) {
        this.d.resetStatisticTimer();
        if (this.g.b()) {
            CacheUrl cacheUrl = new CacheUrl(uri);
            ResourceResponse resourceResponse = null;
            if (this.f.a(cacheUrl)) {
                String buildMimeType = UriUtil.buildMimeType(cacheUrl.getExtend());
                File a2 = this.e.a(cacheUrl);
                if (a2 != null) {
                    this.d.addStatisticCount(1, true);
                    this.h.a(cacheUrl, a2);
                    return a(buildMimeType, a2);
                }
                this.d.addStatisticCount(1, false);
                this.i.add(cacheUrl);
                resourceResponse = new ResourceResponse(buildMimeType, "UTF-8", new com.youzan.spiderman.d.a(this.f28092a, cacheUrl));
            }
            return resourceResponse;
        }
        return null;
    }

    public void tryInjectJs(String str, CacheStatistic.InjectJsCallback injectJsCallback) {
        this.d.tryInjectJs(str, injectJsCallback);
    }
}
