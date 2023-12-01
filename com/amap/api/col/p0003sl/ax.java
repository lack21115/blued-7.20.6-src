package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;

/* renamed from: com.amap.api.col.3sl.ax  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ax.class */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    public static String f4761a = "";
    public static boolean b = false;
    public static String d = "";
    private static volatile ax k;
    public bb f;
    bd g;
    private Context i;
    private a l;
    private bg m;
    private bm n;
    private boolean j = true;

    /* renamed from: c  reason: collision with root package name */
    List<aw> f4762c = new Vector();
    private lb o = null;
    private lb p = null;
    private lb q = null;
    b e = null;
    ba h = null;
    private boolean r = true;

    /* renamed from: com.amap.api.col.3sl.ax$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ax$a.class */
    public interface a {
        void a();

        void a(aw awVar);

        void b(aw awVar);

        void c(aw awVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.ax$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ax$b.class */
    public final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof aw) {
                    aw awVar = (aw) obj;
                    StringBuilder sb = new StringBuilder("OfflineMapHandler handleMessage CitObj  name: ");
                    sb.append(awVar.getCity());
                    sb.append(" complete: ");
                    sb.append(awVar.getcompleteCode());
                    sb.append(" status: ");
                    sb.append(awVar.getState());
                    if (ax.this.l != null) {
                        ax.this.l.a(awVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private ax(Context context) {
        this.i = context;
    }

    public static ax a(Context context) {
        if (k == null) {
            synchronized (ax.class) {
                try {
                    if (k == null && !b) {
                        k = new ax(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return k;
    }

    private void a(final aw awVar, final boolean z) {
        if (this.g == null) {
            this.g = new bd(this.i);
        }
        if (this.p == null) {
            this.p = dv.a("AMapOfflineRemove");
        }
        try {
            this.p.a(new lc() { // from class: com.amap.api.col.3sl.ax.2
                @Override // com.amap.api.col.p0003sl.lc
                public final void runTask() {
                    try {
                        if (awVar.c().equals(awVar.f4756a)) {
                            if (ax.this.l != null) {
                                ax.this.l.c(awVar);
                                return;
                            }
                            return;
                        }
                        if (awVar.getState() != 7 && awVar.getState() != -1) {
                            ax.this.g.a(awVar);
                            if (ax.this.l != null) {
                                ax.this.l.c(awVar);
                                return;
                            }
                            return;
                        }
                        ax.this.g.a(awVar);
                        if (!z || ax.this.l == null) {
                            return;
                        }
                        ax.this.l.c(awVar);
                    } catch (Throwable th) {
                        iw.c(th, "requestDelete", "removeExcecRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            iw.c(th, "requestDelete", "removeExcecRunnable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= str2.length()) {
                    return false;
                }
                if (str.charAt(i2) > str2.charAt(i2)) {
                    return true;
                }
                if (str.charAt(i2) < str2.charAt(i2)) {
                    return false;
                }
                i = i2 + 1;
            } catch (Throwable th) {
                return false;
            }
        }
    }

    private void f(final aw awVar) throws AMapException {
        j();
        if (awVar == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        if (this.q == null) {
            this.q = dv.a("AMapOfflineDownload");
        }
        try {
            this.q.a(new lc() { // from class: com.amap.api.col.3sl.ax.3
                @Override // com.amap.api.col.p0003sl.lc
                public final void runTask() {
                    try {
                        if (ax.this.j) {
                            ax.this.j();
                            ay c2 = new az(ax.this.i, ax.d).c();
                            if (c2 != null) {
                                ax.f(ax.this);
                                if (c2.a()) {
                                    ax.this.c();
                                }
                            }
                        }
                        awVar.setVersion(ax.d);
                        awVar.f();
                    } catch (AMapException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        iw.c(th, "OfflineDownloadManager", "startDownloadRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            iw.c(th, "startDownload", "downloadExcecRunnable");
        }
    }

    static /* synthetic */ boolean f(ax axVar) {
        axVar.j = false;
        return false;
    }

    private void g() {
        try {
            bh a2 = this.n.a("000001");
            if (a2 != null) {
                this.n.c("000001");
                a2.c("100000");
                this.n.a(a2);
            }
        } catch (Throwable th) {
            iw.c(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    private void h() {
        if ("".equals(dw.c(this.i))) {
            return;
        }
        File file = new File(dw.c(this.i) + "offlinemapv4.png");
        String a2 = !file.exists() ? bu.a(this.i, "offlinemapv4.png") : bu.c(file);
        if (a2 != null) {
            try {
                h(a2);
            } catch (JSONException e) {
                if (file.exists()) {
                    file.delete();
                }
                iw.c(e, "MapDownloadManager", "paseJson io");
                e.printStackTrace();
            }
        }
    }

    private void h(String str) throws JSONException {
        bb bbVar;
        List<OfflineMapProvince> a2 = bu.a(str, this.i.getApplicationContext());
        if (a2 == null || a2.size() == 0 || (bbVar = this.f) == null) {
            return;
        }
        bbVar.a(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public aw i(String str) {
        aw next;
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.f4762c) {
            Iterator<aw> it = this.f4762c.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
                if (str.equals(next.getCity())) {
                    break;
                }
            } while (!str.equals(next.getPinyin()));
            return next;
        }
    }

    private void i() {
        Iterator<bh> it = this.n.a().iterator();
        while (it.hasNext()) {
            bh next = it.next();
            if (next != null && next.c() != null && next.e().length() > 0) {
                if (next.l != 4 && next.l != 7 && next.l >= 0) {
                    next.l = 3;
                }
                aw i = i(next.c());
                if (i != null) {
                    String d2 = next.d();
                    if (d2 == null || !b(d, d2)) {
                        i.a(next.l);
                        i.setCompleteCode(next.g());
                    } else {
                        i.a(7);
                    }
                    if (next.d().length() > 0) {
                        i.setVersion(next.d());
                    }
                    List<String> b2 = this.n.b(next.e());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : b2) {
                        stringBuffer.append(str);
                        stringBuffer.append(";");
                    }
                    i.a(stringBuffer.toString());
                    bb bbVar = this.f;
                    if (bbVar != null) {
                        bbVar.a(i);
                    }
                }
            }
        }
    }

    private aw j(String str) {
        aw next;
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.f4762c) {
            Iterator<aw> it = this.f4762c.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
            } while (!str.equals(next.getCode()));
            return next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws AMapException {
        if (!dw.d(this.i)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    private static void k() {
        k = null;
        b = true;
    }

    private static void k(String str) {
        f4761a = str;
    }

    private void l() {
        synchronized (this) {
            this.l = null;
        }
    }

    public final void a() {
        this.n = bm.a(this.i.getApplicationContext());
        g();
        this.e = new b(this.i.getMainLooper());
        this.f = new bb(this.i);
        this.m = bg.a();
        k(dw.c(this.i));
        try {
            h();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.f4762c) {
            Iterator<OfflineMapProvince> it = this.f.a().iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity next = it2.next();
                    if (next != null) {
                        this.f4762c.add(new aw(this.i, next));
                    }
                }
            }
        }
        ba baVar = new ba(this.i);
        this.h = baVar;
        baVar.start();
    }

    public final void a(aw awVar) {
        a(awVar, false);
    }

    public final void a(a aVar) {
        this.l = aVar;
    }

    public final void a(final String str) {
        try {
            if (str == null) {
                if (this.l != null) {
                    this.l.b(null);
                    return;
                }
                return;
            }
            if (this.o == null) {
                this.o = dv.a("AMapOfflineCheckUpdate");
            }
            this.o.a(new lc() { // from class: com.amap.api.col.3sl.ax.1
                @Override // com.amap.api.col.p0003sl.lc
                public final void runTask() {
                    aw i = ax.this.i(str);
                    if (i != null) {
                        try {
                            if (!i.c().equals(i.f4757c) && !i.c().equals(i.e)) {
                                String pinyin = i.getPinyin();
                                if (pinyin.length() > 0) {
                                    String d2 = ax.this.n.d(pinyin);
                                    String str2 = d2;
                                    if (d2 == null) {
                                        str2 = i.getVersion();
                                    }
                                    if (ax.d.length() > 0 && str2 != null && ax.b(ax.d, str2)) {
                                        i.j();
                                    }
                                }
                            }
                            if (ax.this.l != null) {
                                synchronized (ax.this) {
                                    try {
                                        ax.this.l.b(i);
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            if (ax.this.l != null) {
                                synchronized (ax.this) {
                                    try {
                                        ax.this.l.b(i);
                                        return;
                                    }
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            if (ax.this.l != null) {
                                synchronized (ax.this) {
                                    try {
                                        ax.this.l.b(i);
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                    ax.this.j();
                    ay c2 = new az(ax.this.i, ax.d).c();
                    if (ax.this.l != null) {
                        if (c2 == null) {
                            if (ax.this.l != null) {
                                synchronized (ax.this) {
                                    try {
                                        ax.this.l.b(i);
                                    }
                                }
                                return;
                            }
                            return;
                        } else if (c2.a()) {
                            ax.this.c();
                        }
                    }
                    if (ax.this.l != null) {
                        synchronized (ax.this) {
                            try {
                                ax.this.l.b(i);
                            }
                        }
                    }
                }
            });
        } catch (Throwable th) {
            iw.c(th, "OfflineDownloadManager", "checkUpdate");
        }
    }

    public final void b() {
        i();
        a aVar = this.l;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Throwable th) {
                iw.c(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    public final void b(aw awVar) {
        try {
            if (this.m != null) {
                this.m.a(awVar, this.i);
            }
        } catch (hn e) {
            e.printStackTrace();
        }
    }

    public final boolean b(String str) {
        return i(str) != null;
    }

    protected final void c() throws AMapException {
        if (this.f == null) {
            return;
        }
        be beVar = new be(this.i, "");
        beVar.a(this.i);
        List<OfflineMapProvince> c2 = beVar.c();
        if (this.f4762c != null) {
            this.f.a(c2);
        }
        List<aw> list = this.f4762c;
        if (list != null) {
            synchronized (list) {
                Iterator<OfflineMapProvince> it = this.f.a().iterator();
                while (it.hasNext()) {
                    Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                    while (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        for (aw awVar : this.f4762c) {
                            if (next.getPinyin().equals(awVar.getPinyin())) {
                                String version = awVar.getVersion();
                                if (awVar.getState() == 4 && d.length() > 0 && b(d, version)) {
                                    awVar.j();
                                    awVar.setUrl(next.getUrl());
                                    awVar.s();
                                } else {
                                    awVar.setCity(next.getCity());
                                    awVar.setUrl(next.getUrl());
                                    awVar.s();
                                    awVar.setAdcode(next.getAdcode());
                                    awVar.setVersion(next.getVersion());
                                    awVar.setSize(next.getSize());
                                    awVar.setCode(next.getCode());
                                    awVar.setJianpin(next.getJianpin());
                                    awVar.setPinyin(next.getPinyin());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c(aw awVar) {
        bb bbVar = this.f;
        if (bbVar != null) {
            bbVar.a(awVar);
        }
        b bVar = this.e;
        if (bVar != null) {
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.obj = awVar;
            this.e.sendMessage(obtainMessage);
        }
    }

    public final void c(String str) {
        aw i = i(str);
        if (i != null) {
            d(i);
            a(i, true);
            return;
        }
        a aVar = this.l;
        if (aVar != null) {
            try {
                aVar.c(i);
            } catch (Throwable th) {
                iw.c(th, "OfflineDownloadManager", "remove");
            }
        }
    }

    public final void d() {
        synchronized (this.f4762c) {
            for (aw awVar : this.f4762c) {
                if (awVar.c().equals(awVar.f4757c) || awVar.c().equals(awVar.b)) {
                    d(awVar);
                    awVar.g();
                }
            }
        }
    }

    public final void d(aw awVar) {
        bg bgVar = this.m;
        if (bgVar != null) {
            bgVar.a(awVar);
        }
    }

    public final void d(String str) {
        aw i = i(str);
        if (i != null) {
            i.f();
        }
    }

    public final void e() {
        synchronized (this.f4762c) {
            Iterator<aw> it = this.f4762c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                aw next = it.next();
                if (next.c().equals(next.f4757c)) {
                    next.g();
                    break;
                }
            }
        }
    }

    public final void e(aw awVar) {
        bg bgVar = this.m;
        if (bgVar != null) {
            bgVar.b(awVar);
        }
    }

    public final void e(String str) throws AMapException {
        aw i = i(str);
        if (str == null || str.length() <= 0 || i == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        f(i);
    }

    public final void f() {
        lb lbVar = this.o;
        if (lbVar != null) {
            lbVar.e();
        }
        lb lbVar2 = this.q;
        if (lbVar2 != null) {
            lbVar2.e();
            this.q = null;
        }
        ba baVar = this.h;
        if (baVar != null) {
            if (baVar.isAlive()) {
                this.h.interrupt();
            }
            this.h = null;
        }
        b bVar = this.e;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
            this.e = null;
        }
        bg bgVar = this.m;
        if (bgVar != null) {
            bgVar.b();
            this.m = null;
        }
        bb bbVar = this.f;
        if (bbVar != null) {
            bbVar.g();
        }
        k();
        this.j = true;
        l();
    }

    public final void f(String str) throws AMapException {
        aw j = j(str);
        if (j == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        f(j);
    }

    public final String g(String str) {
        aw i;
        return (str == null || (i = i(str)) == null) ? "" : i.getAdcode();
    }
}
