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
    private static volatile ch f41302a;

    /* renamed from: a  reason: collision with other field name */
    private Context f240a;

    /* renamed from: a  reason: collision with other field name */
    private cg f241a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, cf> f243a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f244a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f242a = new ArrayList<>();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ch$a.class */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f246a;

        /* renamed from: a  reason: collision with other field name */
        private String f247a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f248a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected cf f245a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f249a = new Random();

        /* renamed from: a  reason: collision with root package name */
        private int f41303a = 0;

        public a(String str) {
            this.f247a = str;
        }

        public SQLiteDatabase a() {
            return this.f245a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object mo11582a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m11583a() {
            return this.f247a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            a aVar = this.f246a;
            if (aVar != null) {
                aVar.a(context, mo11582a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            ch.a(context).a(this);
        }

        void a(cf cfVar, Context context) {
            this.f245a = cfVar;
            this.b = cfVar.a();
            this.f248a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f246a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m11584a() {
            return this.f245a == null || TextUtils.isEmpty(this.b) || this.f248a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f248a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f245a == null || TextUtils.isEmpty(this.f247a)) {
                return;
            }
            File file = new File(this.f247a);
            u.a(context, new File(file.getParentFile(), bm.b(file.getAbsolutePath())), new cj(this, context));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ch$b.class */
    public static abstract class b<T> extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f41304a;

        /* renamed from: a  reason: collision with other field name */
        private String f250a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f251a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f252a;
        private List<T> b;

        /* renamed from: c  reason: collision with root package name */
        private String f41305c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f251a = list;
            this.f250a = str2;
            this.f252a = strArr;
            this.f41305c = str3;
            this.d = str4;
            this.e = str5;
            this.f41304a = i;
        }

        @Override // com.xiaomi.push.ch.a
        public SQLiteDatabase a() {
            return this.f245a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.ch.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            List<String> list = this.f251a;
            String str = null;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f251a.size()];
                this.f251a.toArray(strArr);
            }
            int i = this.f41304a;
            if (i > 0) {
                str = String.valueOf(i);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f250a, this.f252a, this.f41305c, this.d, this.e, str);
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
        private ArrayList<a> f41306a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f41306a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.ch.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.f41306a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.ch.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f41306a.iterator();
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
        private String f41307a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f253a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f41307a = str2;
            this.f253a = strArr;
        }

        @Override // com.xiaomi.push.ch.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.f41307a, this.f253a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ch$e.class */
    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private ContentValues f41308a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f41308a = contentValues;
        }

        @Override // com.xiaomi.push.ch.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.f41308a);
        }
    }

    private ch(Context context) {
        this.f240a = context;
    }

    private cf a(String str) {
        cf cfVar;
        cf cfVar2 = this.f243a.get(str);
        if (cfVar2 == null) {
            synchronized (this.f243a) {
                cfVar = cfVar2;
                if (cfVar2 == null) {
                    cfVar = this.f241a.a(this.f240a, str);
                    this.f243a.put(str, cfVar);
                }
            }
            return cfVar;
        }
        return cfVar2;
    }

    public static ch a(Context context) {
        if (f41302a == null) {
            synchronized (ch.class) {
                try {
                    if (f41302a == null) {
                        f41302a = new ch(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41302a;
    }

    private void a() {
        ai.a(this.f240a).b(new ci(this), com.xiaomi.push.service.ba.a(this.f240a).a(hl.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11581a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        cf cfVar;
        if (aVar == null) {
            return;
        }
        if (this.f241a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m11583a = aVar.m11583a();
        synchronized (this.f243a) {
            cf cfVar2 = this.f243a.get(m11583a);
            cfVar = cfVar2;
            if (cfVar2 == null) {
                cfVar = this.f241a.a(this.f240a, m11583a);
                this.f243a.put(m11583a, cfVar);
            }
        }
        if (this.f244a.isShutdown()) {
            return;
        }
        aVar.a(cfVar, this.f240a);
        synchronized (this.f242a) {
            this.f242a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f244a.isShutdown()) {
            return;
        }
        this.f244a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f241a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f244a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m11584a()) {
                next.a(a(next.m11583a()), this.f240a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m11583a());
            ArrayList arrayList3 = arrayList2;
            if (arrayList2 == null) {
                arrayList3 = new ArrayList();
                hashMap.put(next.m11583a(), arrayList3);
            }
            arrayList3.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList4 = (ArrayList) hashMap.get(str);
            if (arrayList4 != null && arrayList4.size() > 0) {
                c cVar = new c(str, arrayList4);
                cVar.a(((a) arrayList4.get(0)).f245a, this.f240a);
                this.f244a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        cf cfVar;
        if (aVar == null) {
            return;
        }
        if (this.f241a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m11583a = aVar.m11583a();
        synchronized (this.f243a) {
            cf cfVar2 = this.f243a.get(m11583a);
            cfVar = cfVar2;
            if (cfVar2 == null) {
                cfVar = this.f241a.a(this.f240a, m11583a);
                this.f243a.put(m11583a, cfVar);
            }
        }
        if (this.f244a.isShutdown()) {
            return;
        }
        aVar.a(cfVar, this.f240a);
        a((Runnable) aVar);
    }
}
