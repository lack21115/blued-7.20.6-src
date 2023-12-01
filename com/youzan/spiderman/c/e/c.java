package com.youzan.spiderman.c.e;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.youzan.spiderman.cache.CacheUrl;
import com.youzan.spiderman.utils.FileCallback;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.Stone;
import com.youzan.spiderman.utils.StringUtils;
import java.io.File;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/e/c.class */
public final class c extends com.youzan.spiderman.a.a {

    /* renamed from: a  reason: collision with root package name */
    private int f41758a;
    private Set<String> b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f41759c = Collections.synchronizedSet(new HashSet());
    private Context d;
    private com.youzan.spiderman.c.b.f e;
    private a f;

    public c(Set<String> set, Context context, com.youzan.spiderman.c.b.f fVar, a aVar) {
        this.b = set;
        this.f41758a = set.size();
        this.d = context;
        this.e = fVar;
        this.f = aVar;
    }

    static /* synthetic */ void a(c cVar, CacheUrl cacheUrl, final String str) {
        boolean equalsIgnoreCase = cacheUrl.getUri().getHost().equalsIgnoreCase("b.yzcdn.cn");
        CacheUrl cacheUrl2 = null;
        if (equalsIgnoreCase) {
            if (StringUtils.isStartWith(str, Stone.SUPPORTED_SCHEME)) {
                cacheUrl2 = null;
            } else if (str.startsWith("/public_files/")) {
                cacheUrl2 = new CacheUrl(Uri.parse("https://img.yzcdn.cn" + str));
            } else {
                cacheUrl2 = null;
                if (!str.startsWith("/upload_files/")) {
                    cacheUrl2 = new CacheUrl(Uri.parse("https://su.yzcdn.cn" + str));
                }
            }
        }
        if (cacheUrl2 != null) {
            cVar.a(cacheUrl2, new FileCallback() { // from class: com.youzan.spiderman.c.e.c.2
                @Override // com.youzan.spiderman.utils.FileCallback
                public final void fail(int i, Exception exc) {
                    c.this.b();
                }

                @Override // com.youzan.spiderman.utils.FileCallback
                public final void success() {
                    c.this.f41759c.add(str);
                    c.this.b();
                }
            });
        }
    }

    private void a(CacheUrl cacheUrl, FileCallback fileCallback) {
        com.youzan.spiderman.cache.a.a().a(this.d, cacheUrl, fileCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this) {
            int i = this.f41758a - 1;
            this.f41758a = i;
            if (i == 0) {
                this.b.removeAll(this.f41759c);
                if (this.f != null) {
                    this.f.a(this, this.b);
                }
                this.b.clear();
                this.f41759c.clear();
            }
        }
    }

    @Override // com.youzan.spiderman.a.a
    public final void a() throws Throwable {
        String str;
        CacheUrl cacheUrl;
        com.youzan.spiderman.cache.f a2 = com.youzan.spiderman.cache.f.a();
        boolean a3 = this.e.a(this.d);
        boolean b = this.e.b();
        Iterator<String> it = this.b.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String str2 = next;
            if (!next.startsWith(BridgeUtil.SPLIT_MARK)) {
                str2 = next;
                if (!StringUtils.isStartWith(next, Stone.SUPPORTED_SCHEME)) {
                    str2 = BridgeUtil.SPLIT_MARK + next;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                cacheUrl = null;
            } else {
                if (str2.startsWith("/public_files/")) {
                    str = "https://b.yzcdn.cn" + str2;
                } else if (str2.startsWith("/upload_files/")) {
                    str = "https://img.yzcdn.cn" + str2;
                } else if (StringUtils.isStartWith(str2, Stone.SUPPORTED_SCHEME)) {
                    str = str2;
                } else {
                    str = "https://b.yzcdn.cn" + str2;
                }
                cacheUrl = new CacheUrl(Uri.parse(str));
            }
            File a4 = a2.a(cacheUrl);
            if (cacheUrl != null && a4 == null && !b && (a3 || cacheUrl.isScript())) {
                try {
                    final String str3 = str2;
                    final CacheUrl cacheUrl2 = cacheUrl;
                    a(cacheUrl, new FileCallback() { // from class: com.youzan.spiderman.c.e.c.1
                        @Override // com.youzan.spiderman.utils.FileCallback
                        public final void fail(int i, Exception exc) {
                            if (i == 404) {
                                c.a(c.this, cacheUrl2, str3);
                            } else if (exc instanceof UnknownHostException) {
                                c.a(c.this, cacheUrl2, str3);
                            } else {
                                c.this.b();
                            }
                        }

                        @Override // com.youzan.spiderman.utils.FileCallback
                        public final void success() {
                            c.this.f41759c.add(str3);
                            c.this.b();
                        }
                    });
                } catch (Exception e) {
                    Logger.e("SyncDownloadJob", "download file have a crash error!", e);
                }
            } else if (a4 != null) {
                it.remove();
            }
            b();
        }
    }

    @Override // com.youzan.spiderman.a.a
    public final void a(Throwable th) {
        Logger.e("SyncDownloadJob", "sync download job exception", th);
    }
}
