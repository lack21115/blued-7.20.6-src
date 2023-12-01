package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.map.tools.json.JsonUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f6.class */
public class f6 {
    private static final String l = "stData";

    /* renamed from: a  reason: collision with root package name */
    private int f37430a;
    private List<w6> b;

    /* renamed from: c  reason: collision with root package name */
    private String f37431c;
    private String d;
    private String e;
    private String f;
    private File g;
    private File h;
    private volatile boolean i;
    private boolean j;
    private h k;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f6$a.class */
    public class a implements Runnable {
        public final /* synthetic */ e b;

        public a(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.READ;
            i.a(gVar).a(f.START).a(f6.this.g).a(f6.this.k);
            boolean z = false;
            if (!f6.this.g.exists()) {
                i.a(gVar).a(f.END).a(f6.this.g).a(false).a(f6.this.k);
                e eVar = this.b;
                if (eVar != null) {
                    eVar.a(null);
                    return;
                }
                return;
            }
            i.a(gVar).a(f.PROCESSING).a(f6.this.g).a(f6.this.k);
            byte[] h = ga.h(f6.this.g);
            i a2 = i.a(gVar).a(f.END).a(f6.this.g);
            if (h != null) {
                z = true;
            }
            a2.a(z).a(f6.this.k);
            e eVar2 = this.b;
            if (eVar2 != null) {
                eVar2.a(h);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f6$b.class */
    public class b implements e<byte[]> {

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f6$b$a.class */
        public class a implements e<Boolean> {
            public a() {
            }

            @Override // com.tencent.mapsdk.internal.f6.e
            public void a(Boolean bool) {
                f6.this.a(bool.booleanValue());
            }
        }

        public b() {
        }

        @Override // com.tencent.mapsdk.internal.f6.e
        public void a(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            f6.this.a(bArr, new a());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f6$c.class */
    public class c implements Runnable {
        public final /* synthetic */ byte[] b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f37435c;

        public c(byte[] bArr, e eVar) {
            this.b = bArr;
            this.f37435c = eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0116  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 346
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.f6.c.run():void");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f6$d.class */
    public class d implements e<Boolean> {
        public d() {
        }

        @Override // com.tencent.mapsdk.internal.f6.e
        public void a(Boolean bool) {
            f6.this.a(bool.booleanValue());
            if (bool.booleanValue()) {
                f6.this.b.clear();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f6$e.class */
    public interface e<T> {
        void a(T t);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f6$f.class */
    public enum f {
        START,
        PROCESSING,
        END,
        CANCEL
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f6$g.class */
    public enum g {
        CREATE,
        READ,
        UPLOAD,
        UPLOAD_END,
        WRITE,
        TRANSLATE_BYTE
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f6$h.class */
    public interface h {
        void a(i iVar);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f6$i.class */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        private g f37439a;
        private f b;

        /* renamed from: c  reason: collision with root package name */
        private i f37440c;
        private boolean d;
        private byte[] e;
        private Object f;

        public static i a(g gVar) {
            i iVar = new i();
            iVar.f37439a = gVar;
            return iVar;
        }

        public i a(f fVar) {
            this.b = fVar;
            return this;
        }

        public i a(h hVar) {
            if (hVar != null) {
                hVar.a(this);
            }
            return this;
        }

        public i a(i iVar) {
            this.f37440c = iVar;
            return this;
        }

        public i a(Object obj) {
            this.f = obj;
            return this;
        }

        public i a(boolean z) {
            this.d = z;
            return this;
        }

        public i a(byte[] bArr) {
            this.e = bArr;
            return this;
        }

        public boolean a(g gVar, f fVar) {
            i iVar = this.f37440c;
            if (iVar != null) {
                return iVar.b(gVar, fVar);
            }
            return false;
        }

        public byte[] a() {
            return this.e;
        }

        public f b() {
            return this.b;
        }

        public boolean b(g gVar) {
            i iVar = this.f37440c;
            if (iVar != null) {
                return iVar.c(gVar);
            }
            return false;
        }

        public boolean b(g gVar, f fVar) {
            return fVar == this.b && gVar == this.f37439a;
        }

        public g c() {
            return this.f37439a;
        }

        public boolean c(g gVar) {
            return gVar == this.f37439a;
        }

        public Object d() {
            return this.f;
        }

        public boolean e() {
            return this.d;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("StatisticState{");
            stringBuffer.append("mState=");
            stringBuffer.append(this.f37439a);
            stringBuffer.append(", mStage=");
            stringBuffer.append(this.b);
            stringBuffer.append(", mParentState=");
            stringBuffer.append(this.f37440c);
            stringBuffer.append(", mResult=");
            stringBuffer.append(this.d);
            stringBuffer.append(", mData=");
            if (this.e == null) {
                stringBuffer.append(com.igexin.push.core.b.l);
            } else {
                stringBuffer.append('[');
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.e.length) {
                        break;
                    }
                    stringBuffer.append(i2 == 0 ? "" : ", ");
                    stringBuffer.append((int) this.e[i2]);
                    i = i2 + 1;
                }
                stringBuffer.append(']');
            }
            stringBuffer.append(", mTag=");
            stringBuffer.append(this.f);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    public f6(q1 q1Var) {
        this(q1Var, true);
    }

    public f6(q1 q1Var, boolean z) {
        this.j = z;
        this.b = new ArrayList();
        this.d = q1Var.q().g();
        this.e = "";
        this.f = "";
        if (q1Var.r() != null) {
            this.e = q1Var.r().getSubKey();
            this.f = q1Var.r().getSubId();
        }
        String str = q1Var.getContext().getFilesDir().getAbsolutePath() + File.separator + l + BridgeUtil.UNDERLINE_STR + wa.a(this.d);
        this.f37431c = str;
        ga.a(str);
        this.g = new File(this.f37431c);
        this.h = new File(this.f37431c + com.anythink.china.common.a.a.e);
    }

    private List<w6> a(File file) {
        ArrayList arrayList = new ArrayList();
        List<String> g2 = ga.g(file);
        if (g2 != null && !g2.isEmpty()) {
            for (String str : g2) {
                List list = null;
                try {
                    list = JsonUtils.parseToList(new JSONArray(str), w6.class, new Object[0]);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (list != null) {
                    arrayList.addAll(list);
                }
            }
        }
        return arrayList;
    }

    private void a(e<byte[]> eVar) {
        a(new a(eVar));
    }

    private void a(Runnable runnable) {
        if (this.i) {
            return;
        }
        if (this.j) {
            new Thread(runnable).start();
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        g gVar = g.UPLOAD_END;
        i a2 = i.a(gVar);
        f fVar = f.START;
        a2.a(fVar).a(this.k);
        byte[] h2 = ga.h(this.h);
        i a3 = i.a(gVar).a(f.PROCESSING).a(z).a(h2).a(this.h).a(this.k);
        if (z) {
            ga.d(this.g);
            if (h2 != null && h2.length > 0) {
                ga.b(this.h, this.g);
            }
        } else if (h2 != null && h2.length > 0) {
            ArrayList arrayList = new ArrayList();
            List<w6> a4 = a(this.g);
            List<w6> a5 = a(this.h);
            arrayList.addAll(a4);
            arrayList.addAll(a5);
            ga.d(this.g);
            ga.d(this.h);
            byte[] a6 = a(arrayList, a3);
            g gVar2 = g.WRITE;
            i.a(gVar2).a(fVar).a(a3).a(a6).a(this.g).a(this.k);
            i.a(gVar2).a(f.END).a(a3).a(ga.b(this.g, a6)).a(this.k);
        }
        i.a(gVar).a(f.END).a(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, e<Boolean> eVar) {
        a(new c(bArr, eVar));
    }

    private byte[] a(List<w6> list, i iVar) {
        g gVar = g.TRANSLATE_BYTE;
        i.a(gVar).a(f.START).a(iVar).a(this.k);
        boolean z = false;
        if (list == null || list.isEmpty()) {
            i.a(gVar).a(f.END).a(iVar).a(false).a(this.k);
            return null;
        }
        i.a(gVar).a(f.PROCESSING).a(list).a(iVar).a(this.k);
        String collectionToJson = JsonUtils.collectionToJson(new ArrayList(list));
        byte[] bArr = null;
        if (!TextUtils.isEmpty(collectionToJson)) {
            try {
                bArr = collectionToJson.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e2) {
                bArr = collectionToJson.getBytes();
            }
        }
        i a2 = i.a(g.TRANSLATE_BYTE).a(f.END).a(bArr).a(collectionToJson).a(iVar);
        if (bArr != null) {
            z = true;
        }
        a2.a(z).a(this.k);
        return bArr;
    }

    private void d() {
        a(new b());
    }

    public w6 a() {
        return a(System.currentTimeMillis());
    }

    public w6 a(long j) {
        i.a(g.CREATE).a(Long.valueOf(j)).a(this.k);
        return new w6(j);
    }

    public void a(h hVar) {
        this.k = hVar;
    }

    public void a(w6 w6Var) {
        this.f37430a--;
        if (w6Var != null) {
            synchronized (this) {
                this.b.add(w6Var);
            }
        }
        if (this.f37430a == 0 && !this.b.isEmpty()) {
            a(a(this.b, (i) null), new d());
        }
    }

    public String b() {
        return this.f37431c;
    }

    public void c() {
        if (this.f37430a == 0) {
            d();
        }
        this.f37430a++;
    }
}
