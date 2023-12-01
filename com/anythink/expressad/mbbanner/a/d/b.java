package com.anythink.expressad.mbbanner.a.d;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.mbbanner.a.b.e;
import com.anythink.expressad.mbbanner.a.c.d;
import com.anythink.expressad.mbbanner.a.c.f;
import com.anythink.expressad.mbbanner.a.c.g;
import com.anythink.expressad.videocommon.b.i;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/a/d/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5184a = b.class.getSimpleName();
    private Context b;
    private e d;
    private com.anythink.expressad.mbbanner.a.e.a e;
    private com.anythink.expressad.mbbanner.a.c.b f;
    private d g;

    /* renamed from: c  reason: collision with root package name */
    private int f5185c = 0;
    private volatile boolean h = false;
    private Timer i = new Timer();
    private volatile List<String> j = new ArrayList();
    private volatile boolean k = false;
    private volatile boolean l = false;
    private volatile boolean m = false;

    /* renamed from: com.anythink.expressad.mbbanner.a.d.b$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/a/d/b$1.class */
    final class AnonymousClass1 extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f5186a;

        AnonymousClass1(String str) {
            this.f5186a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (b.this.h) {
                return;
            }
            b.b(b.this);
            b.this.a(this.f5186a, -1, "", false);
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.b$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/a/d/b$2.class */
    final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.d f5187a;

        AnonymousClass2(com.anythink.expressad.foundation.d.d dVar) {
            this.f5187a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.b(b.f5184a, "在单独子线程保存数据库 开始");
            com.anythink.expressad.foundation.d.d dVar = this.f5187a;
            if (dVar != null && dVar.J != null && this.f5187a.J.size() > 0) {
                Context unused = b.this.b;
                com.anythink.expressad.mbbanner.a.e.b.a();
            }
            o.b(b.f5184a, "在单独子线程保存数据库 完成");
        }
    }

    public b(Context context, e eVar, com.anythink.expressad.mbbanner.a.c.b bVar, com.anythink.expressad.mbbanner.a.e.a aVar) {
        this.b = context.getApplicationContext();
        this.d = eVar;
        this.f = bVar;
        this.e = aVar;
    }

    private String a(String str, String str2) {
        FileOutputStream fileOutputStream;
        String str3;
        File file;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                String b = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
                String a2 = p.a(x.a(str2));
                String str4 = a2;
                if (TextUtils.isEmpty(a2)) {
                    str4 = String.valueOf(System.currentTimeMillis());
                }
                File file2 = new File(b, str4.concat(".html"));
                Uri.parse(str2).getPath();
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(str2.getBytes());
                    fileOutputStream.flush();
                    str3 = file2.getAbsolutePath();
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    str3 = "";
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            str3 = "";
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            str3 = "";
                        }
                    }
                    file = new File(str3);
                    if (!file.exists()) {
                    }
                    a(str, 2, str2, false);
                    return str3;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
            }
            file = new File(str3);
            if (!file.exists() && file.isFile() && file.canRead()) {
                a(str, 2, str2, true);
                return str3;
            }
            a(str, 2, str2, false);
            return str3;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private List<com.anythink.expressad.foundation.d.c> a(com.anythink.expressad.foundation.d.d dVar) {
        ArrayList arrayList = new ArrayList();
        if (dVar != null) {
            try {
                if (dVar.J != null && dVar.J.size() > 0) {
                    ArrayList<com.anythink.expressad.foundation.d.c> arrayList2 = dVar.J;
                    String str = f5184a;
                    o.b(str, "getNeedShowList 总共返回的campaign有：" + arrayList2.size());
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= arrayList2.size()) {
                            String str2 = f5184a;
                            o.b(str2, "getNeedShowList 返回有以下带有视频素材的campaign：" + arrayList.size());
                            return arrayList;
                        }
                        com.anythink.expressad.foundation.d.c cVar = arrayList2.get(i2);
                        if (cVar != null && cVar.O() != 99 && (!TextUtils.isEmpty(cVar.p()) || !TextUtils.isEmpty(cVar.q()) || !TextUtils.isEmpty(cVar.be()))) {
                            if (t.a(cVar)) {
                                cVar.i(t.a(this.b, cVar.ba()) ? 1 : 2);
                            }
                            if (cVar.ae() != 1 && t.a(this.b, cVar.ba())) {
                                if (t.a(cVar)) {
                                    arrayList.add(cVar);
                                }
                            }
                            arrayList.add(cVar);
                        }
                        i = i2 + 1;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private void a(String str) {
        if (this.m) {
            return;
        }
        if ((this.k || this.l) && this.j.size() == 0) {
            o.b(f5184a, "在子线程处理业务逻辑 完成");
            this.h = true;
            this.m = true;
            this.i.cancel();
            this.e.a(this.f, str);
            this.g.a(str);
        }
    }

    private void a(String str, List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (!TextUtils.isEmpty(cVar.be())) {
                this.j.add(cVar.be());
                com.anythink.expressad.foundation.g.d.b.a(this.b).a(cVar.be(), new g(this, str));
            }
        }
    }

    private String b() {
        return this.d.a();
    }

    private void b(com.anythink.expressad.foundation.d.d dVar) {
        new Thread(new AnonymousClass2(dVar)).start();
    }

    private void b(String str) {
        o.b(f5184a, "在子线程处理业务逻辑 完成");
        o.b(f5184a, "downloadResource--> Fail");
        this.h = true;
        this.e.b(this.f, str);
        this.g.a(str);
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        i.a().a(str2, new f(this, str));
    }

    private void b(String str, List<com.anythink.expressad.foundation.d.c> list) {
        int i = this.f5185c;
        int i2 = i;
        if (list != null) {
            i2 = i;
            try {
                if (list.size() > 0) {
                    i2 = i + list.size();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        int i3 = i2;
        if (i2 > this.d.c()) {
            o.b(f5184a, "saveNextOffset 重置offset为0");
            i3 = 0;
        }
        o.b(f5184a, "saveNextOffset 算出 下次的offset是:".concat(String.valueOf(i3)));
        if (w.b(str)) {
            this.d.a(i3);
        }
    }

    static /* synthetic */ boolean b(b bVar) {
        bVar.h = true;
        return true;
    }

    private int c() {
        try {
            int b = this.d.b();
            if (b > this.d.c()) {
                return 0;
            }
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void c(String str) {
        this.i.schedule(new AnonymousClass1(str), 60000L);
    }

    private void d(String str) {
        this.d.a(str);
    }

    public final void a(String str, int i, String str2, boolean z) {
        if (!z) {
            if (i == -1) {
                String str3 = f5184a;
                o.d(str3, " unitId =" + str + " --> time out!");
            }
            this.i.cancel();
            o.b(f5184a, "在子线程处理业务逻辑 完成");
            o.b(f5184a, "downloadResource--> Fail");
            this.h = true;
            this.e.b(this.f, str);
            this.g.a(str);
        } else if (i == 1) {
            o.b(f5184a, "downloadResource--> Success Image");
            synchronized (this) {
                this.j.remove(str2);
                if (this.j.size() == 0) {
                    a(str);
                }
            }
        } else if (i == 2) {
            o.b(f5184a, "downloadResource--> Success banner_html");
            this.l = true;
            a(str);
        } else if (i == 3) {
            o.b(f5184a, "downloadResource--> Success banner_url");
            this.k = true;
            a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, com.anythink.expressad.foundation.d.d dVar, d dVar2) {
        this.g = dVar2;
        if (dVar == null) {
            this.e.a(this.f, "campaignUnit is NULL!", str);
            this.g.a(str);
            return;
        }
        List<com.anythink.expressad.foundation.d.c> a2 = a(dVar);
        new Thread(new AnonymousClass2(dVar)).start();
        if (a2.size() == 0) {
            o.b(f5184a, "tryDownloadOnLoadSuccess 返回的campaign 没有符合下载规则的");
            this.e.a(this.f, com.anythink.expressad.reward.a.d.f5273a, str);
            this.g.a(str);
            return;
        }
        o.b(f5184a, "在子线程处理业务逻辑 开始");
        this.i.schedule(new AnonymousClass1(str), 60000L);
        this.d.a(dVar.c());
        int i = this.f5185c;
        int i2 = i;
        try {
            if (a2.size() > 0) {
                i2 = i + a2.size();
            }
            int i3 = i2;
            if (i2 > this.d.c()) {
                o.b(f5184a, "saveNextOffset 重置offset为0");
                i3 = 0;
            }
            o.b(f5184a, "saveNextOffset 算出 下次的offset是:".concat(String.valueOf(i3)));
            if (w.b(str)) {
                this.d.a(i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.anythink.expressad.foundation.d.c cVar = a2.get(0);
        String trim = cVar.p().trim();
        if (TextUtils.isEmpty(trim)) {
            String trim2 = cVar.q().trim();
            if (TextUtils.isEmpty(trim2)) {
                this.l = true;
                this.k = true;
            } else {
                String a3 = a(str, trim2);
                if (a2.size() > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= a2.size()) {
                            break;
                        }
                        a2.get(i5).e(a3);
                        a2.get(i5).a(trim2.contains("<MBTPLMARK>"));
                        i4 = i5 + 1;
                    }
                }
            }
        } else {
            if (!TextUtils.isEmpty(trim)) {
                i.a().a(trim, new f(this, str));
            }
            if (a2.size() > 0) {
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= a2.size()) {
                        break;
                    }
                    a2.get(i7).d(cVar.p());
                    a2.get(i7).a(true);
                    i6 = i7 + 1;
                }
            }
        }
        a(str, a2);
    }
}
