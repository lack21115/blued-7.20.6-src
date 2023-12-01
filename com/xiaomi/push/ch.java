package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ch.class */
public class ch {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ch f27611a;

    /* renamed from: a  reason: collision with other field name */
    private Context f193a;

    /* renamed from: a  reason: collision with other field name */
    private cg f194a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, cf> f196a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f197a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f195a = new ArrayList<>();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ch$a.class */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f199a;

        /* renamed from: a  reason: collision with other field name */
        private String f200a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f201a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected cf f198a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f202a = new Random();

        /* renamed from: a  reason: collision with root package name */
        private int f27612a = 0;

        public a(String str) {
            this.f200a = str;
        }

        public SQLiteDatabase a() {
            return this.f198a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object mo8532a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m8533a() {
            return this.f200a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            a aVar = this.f199a;
            if (aVar != null) {
                aVar.a(context, mo8532a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            ch.a(context).a(this);
        }

        void a(cf cfVar, Context context) {
            this.f198a = cfVar;
            this.b = cfVar.a();
            this.f201a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f199a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m8534a() {
            return this.f198a == null || TextUtils.isEmpty(this.b) || this.f201a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f201a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f198a == null || TextUtils.isEmpty(this.f200a)) {
                return;
            }
            File file = new File(this.f200a);
            u.a(context, new File(file.getParentFile(), bm.b(file.getAbsolutePath())), new cj(this, context));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ch$b.class */
    public static abstract class b<T> extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f27613a;

        /* renamed from: a  reason: collision with other field name */
        private String f203a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f204a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f205a;
        private List<T> b;

        /* renamed from: c  reason: collision with root package name */
        private String f27614c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f204a = list;
            this.f203a = str2;
            this.f205a = strArr;
            this.f27614c = str3;
            this.d = str4;
            this.e = str5;
            this.f27613a = i;
        }

        @Override // com.xiaomi.push.ch.a
        public SQLiteDatabase a() {
            return this.f198a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.ch.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            List<String> list = this.f204a;
            String str = null;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f204a.size()];
                this.f204a.toArray(strArr);
            }
            int i = this.f27613a;
            if (i > 0) {
                str = String.valueOf(i);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f203a, this.f205a, this.f27614c, this.d, this.e, str);
            if (query != null && query.moveToFirst()) {
                do {
                    T a2 = a(context, query);
                    if (a2 != null) {
                        this.b.add(a2);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.b);
        }

        public abstract void a(Context context, List<T> list);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ch$c.class */
    public static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<a> f27615a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f27615a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.ch.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.f27615a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.ch.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f27615a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ch$d.class */
    public static class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f27616a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f206a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f27616a = str2;
            this.f206a = strArr;
        }

        @Override // com.xiaomi.push.ch.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.f27616a, this.f206a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ch$e.class */
    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private ContentValues f27617a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f27617a = contentValues;
        }

        @Override // com.xiaomi.push.ch.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.f27617a);
        }
    }

    private ch(Context context) {
        this.f193a = context;
    }

    private cf a(String str) {
        cf cfVar;
        cf cfVar2 = this.f196a.get(str);
        if (cfVar2 == null) {
            synchronized (this.f196a) {
                cfVar = cfVar2;
                if (cfVar2 == null) {
                    cfVar = this.f194a.a(this.f193a, str);
                    this.f196a.put(str, cfVar);
                }
            }
            return cfVar;
        }
        return cfVar2;
    }

    public static ch a(Context context) {
        if (f27611a == null) {
            synchronized (ch.class) {
                try {
                    if (f27611a == null) {
                        f27611a = new ch(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27611a;
    }

    private void a() {
        ai.a(this.f193a).b(new ci(this), com.xiaomi.push.service.ba.a(this.f193a).a(hl.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8531a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        cf cfVar;
        if (aVar == null) {
            return;
        }
        if (this.f194a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m8533a = aVar.m8533a();
        synchronized (this.f196a) {
            cf cfVar2 = this.f196a.get(m8533a);
            cfVar = cfVar2;
            if (cfVar2 == null) {
                cfVar = this.f194a.a(this.f193a, m8533a);
                this.f196a.put(m8533a, cfVar);
            }
        }
        if (this.f197a.isShutdown()) {
            return;
        }
        aVar.a(cfVar, this.f193a);
        synchronized (this.f195a) {
            this.f195a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f197a.isShutdown()) {
            return;
        }
        this.f197a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f194a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f197a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m8534a()) {
                next.a(a(next.m8533a()), this.f193a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m8533a());
            ArrayList arrayList3 = arrayList2;
            if (arrayList2 == null) {
                arrayList3 = new ArrayList();
                hashMap.put(next.m8533a(), arrayList3);
            }
            arrayList3.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList4 = (ArrayList) hashMap.get(str);
            if (arrayList4 != null && arrayList4.size() > 0) {
                c cVar = new c(str, arrayList4);
                cVar.a(((a) arrayList4.get(0)).f198a, this.f193a);
                this.f197a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        cf cfVar;
        if (aVar == null) {
            return;
        }
        if (this.f194a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m8533a = aVar.m8533a();
        synchronized (this.f196a) {
            cf cfVar2 = this.f196a.get(m8533a);
            cfVar = cfVar2;
            if (cfVar2 == null) {
                cfVar = this.f194a.a(this.f193a, m8533a);
                this.f196a.put(m8533a, cfVar);
            }
        }
        if (this.f197a.isShutdown()) {
            return;
        }
        aVar.a(cfVar, this.f193a);
        a((Runnable) aVar);
    }
}
