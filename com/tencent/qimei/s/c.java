package com.tencent.qimei.s;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qimei.i.f;
import com.tencent.qimei.o.j;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/s/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f24716a = new AtomicInteger();
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public String f24717c;
    public String d;
    public b e;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/s/c$a.class */
    public abstract class a implements com.tencent.qimei.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final String f24718a;
        public final String b;

        public a(String str, String str2) {
            this.f24718a = str;
            this.b = str2;
        }

        public abstract String a(String str);

        @Override // com.tencent.qimei.d.c
        public void a(String str, int i, String str2) {
            c.a(c.this, this.b, null);
            com.tencent.qimei.k.a.a("HidTask", "pull content from server,code = %d", Integer.valueOf(i));
        }

        @Override // com.tencent.qimei.d.c
        public void a(String str, String... strArr) {
            String str2 = strArr.length > 0 ? strArr[0] : "";
            f.a(c.this.f24717c).a(this.f24718a, str2);
            c.a(c.this, this.b, a(str));
            com.tencent.qimei.k.a.b("HidTask", "pull content from server,code:%d lastModifiedTime:%s", 200, str2);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/s/c$b.class */
    public interface b {
    }

    public c(Context context, String str, b bVar) {
        this.b = context;
        this.f24717c = str;
        this.e = bVar;
        this.d = this.b.getFilesDir().getAbsolutePath() + "/jsfile/";
    }

    public static /* synthetic */ void a(c cVar, String str, String str2) {
        if (cVar.f24716a.incrementAndGet() == 2) {
            ((j) cVar.e).c();
        }
        f.a(cVar.f24717c).a("lc_fe_tm", System.currentTimeMillis());
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        f.a(cVar.f24717c).a(str, com.tencent.qimei.j.a.a(str2));
    }

    public void a(boolean z) {
        String c2 = f.a(this.f24717c).c("hm_md_tm");
        if (z) {
            c2 = "";
        }
        com.tencent.qimei.b.a.a().a(new com.tencent.qimei.d.a("https://tun-cos-1258344701.file.myqcloud.com/my.html", c2, new com.tencent.qimei.s.a(this, "hm_md_tm", "lc_fe_st_hm")));
    }

    public final boolean a(String str) {
        return new File(this.d + str).exists();
    }

    public final boolean a(String str, String str2) {
        return com.tencent.qimei.j.a.a(com.tencent.qimei.j.c.a(this.d, str)).equals(f.a(this.f24717c).c(str2));
    }

    public void b(boolean z) {
        String c2 = f.a(this.f24717c).c("js_md_tm");
        if (z) {
            c2 = "";
        }
        com.tencent.qimei.b.a.a().a(new com.tencent.qimei.d.a("https://tun-cos-1258344701.file.myqcloud.com/fp.js", c2, new com.tencent.qimei.s.b(this, "js_md_tm", "lc_fe_st_js")));
    }
}
