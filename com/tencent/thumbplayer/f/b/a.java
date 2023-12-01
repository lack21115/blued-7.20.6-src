package com.tencent.thumbplayer.f.b;

import android.os.SystemClock;
import android.provider.BrowserContract;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.utils.i;
import com.tencent.thumbplayer.utils.l;
import com.tencent.thumbplayer.utils.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/f/b/a.class */
public class a implements com.tencent.thumbplayer.tplayer.plugins.a {
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f25617c;
    private TPRichMediaFeature[] d;

    /* renamed from: a  reason: collision with root package name */
    m f25616a = new m();
    private int e = 0;
    private int f = 0;
    private int g = -1;
    private long h = 0;
    private List<b> i = new ArrayList();
    private Map<Integer, C0851a> j = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.thumbplayer.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/f/b/a$a.class */
    public static class C0851a {

        /* renamed from: a  reason: collision with root package name */
        public int f25619a;
        public long b;

        private C0851a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/f/b/a$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f25620a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public long f25621c;

        private b() {
        }
    }

    private void a(int i) {
        this.e++;
        b bVar = new b();
        bVar.f25620a = i;
        bVar.b = this.e;
        bVar.f25621c = SystemClock.elapsedRealtime();
        this.i.add(bVar);
    }

    private void a(int i, int i2) {
        b(i, i2);
        c(i, i2);
    }

    private void a(com.tencent.thumbplayer.common.a.a aVar) {
        aVar.a("url", this.f25617c);
        aVar.a("flowid", this.b);
        aVar.a(TPDownloadProxyEnum.USER_GUID, TPPlayerConfig.getGuid());
        aVar.a("appplatform", TPPlayerConfig.getPlatform());
        aVar.a("network", i.b());
    }

    private void a(C0851a c0851a, String str, int i) {
        l lVar = new l();
        lVar.a("duration", SystemClock.elapsedRealtime() - c0851a.b);
        lVar.a("code", i);
        lVar.a("seq", c0851a.f25619a);
        lVar.a("featuretype", str);
        lVar.a(BrowserContract.Bookmarks.POSITION, this.g);
        a("rich_media_feature_data_callback", lVar);
    }

    private void a(b bVar, String str, int i) {
        l lVar = new l();
        lVar.a("duration", SystemClock.elapsedRealtime() - bVar.f25621c);
        lVar.a("code", i);
        lVar.a("seq", bVar.b);
        lVar.a("featuretype", str);
        lVar.a(BrowserContract.Bookmarks.POSITION, this.g);
        a("rich_media_feature_select", lVar);
    }

    private void a(Object obj) {
        if (obj instanceof TPRichMediaFeature[]) {
            this.d = (TPRichMediaFeature[]) obj;
        }
        l(0);
    }

    private void a(String str) {
        this.b = UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform();
        this.f25617c = str;
    }

    private void a(String str, com.tencent.thumbplayer.common.a.a aVar) {
        a(aVar);
        com.tencent.thumbplayer.common.a.b.a(str, aVar);
    }

    private void b(int i) {
        b(i, 0);
        if (this.j.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.f++;
        C0851a c0851a = new C0851a();
        c0851a.f25619a = this.f;
        c0851a.b = SystemClock.elapsedRealtime();
        this.j.put(Integer.valueOf(i), c0851a);
    }

    private void b(int i, int i2) {
        String k = k(i);
        Iterator<b> it = this.i.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f25620a == i) {
                a(next, k, i2);
                it.remove();
            }
        }
    }

    private void c() {
        this.h = SystemClock.elapsedRealtime();
    }

    private void c(int i) {
        b(i, 0);
    }

    private void c(int i, int i2) {
        if (this.j.containsKey(Integer.valueOf(i))) {
            a(this.j.get(Integer.valueOf(i)), k(i), i2);
            this.j.remove(Integer.valueOf(i));
        }
    }

    private void d() {
        g(0);
    }

    private void d(int i) {
        c(i, 0);
    }

    private void e() {
        g(0);
    }

    private void e(int i) {
        g(i);
    }

    private void f() {
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.h = 0L;
        this.i.clear();
        this.j.clear();
    }

    private void f(int i) {
        this.g = i;
    }

    private void g(int i) {
        h(i);
        f();
    }

    private void h(int i) {
        l(i);
        i(i);
        j(i);
    }

    private void i(int i) {
        if (this.d == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.d.length) {
                return;
            }
            b(i3, 0);
            i2 = i3 + 1;
        }
    }

    private void j(int i) {
        if (this.d == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.d.length) {
                return;
            }
            c(i3, 0);
            i2 = i3 + 1;
        }
    }

    private String k(int i) {
        TPRichMediaFeature[] tPRichMediaFeatureArr = this.d;
        return (tPRichMediaFeatureArr == null || i < 0 || i >= tPRichMediaFeatureArr.length) ? "" : tPRichMediaFeatureArr[i].getFeatureType();
    }

    private void l(int i) {
        if (this.h <= 0) {
            return;
        }
        l lVar = new l();
        lVar.a("duration", SystemClock.elapsedRealtime() - this.h);
        lVar.a("code", i);
        a("rich_media_prepare", lVar);
        this.h = 0L;
    }

    @Override // com.tencent.thumbplayer.tplayer.plugins.a
    public void a() {
    }

    @Override // com.tencent.thumbplayer.tplayer.plugins.a
    public void a(int i, int i2, int i3, String str, Object obj) {
        this.f25616a.writeLock().lock();
        switch (i) {
            case 300:
                c();
                break;
            case 301:
                a(obj);
                break;
            case 302:
                a(i2);
                break;
            case 303:
                b(i2);
                break;
            case 304:
                c(i2);
                break;
            case 305:
                d(i2);
                break;
            case 306:
                d();
                break;
            case 307:
                e();
                break;
            case 308:
                e(i2);
                break;
            case 309:
                a(str);
                break;
            case 310:
                a(i2, i3);
                break;
            case 311:
                f(i2);
                break;
        }
        this.f25616a.writeLock().unlock();
    }

    @Override // com.tencent.thumbplayer.tplayer.plugins.a
    public void b() {
    }
}
