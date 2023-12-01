package com.anythink.expressad.exoplayer.j.a;

import android.os.ConditionVariable;
import android.util.Log;
import com.anythink.expressad.exoplayer.j.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/m.class */
public final class m implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7571a = "SimpleCache";
    private static final HashSet<File> b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f7572c;
    private final File d;
    private final d e;
    private final h f;
    private final HashMap<String, ArrayList<a.b>> g;
    private long h;
    private boolean i;

    private m(File file, d dVar) {
        this(file, dVar, null, false);
    }

    private m(File file, d dVar, h hVar) {
        if (!c(file)) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: ".concat(String.valueOf(file)));
        }
        this.d = file;
        this.e = dVar;
        this.f = hVar;
        this.g = new HashMap<>();
        final ConditionVariable conditionVariable = new ConditionVariable();
        new Thread("SimpleCache.initialize()") { // from class: com.anythink.expressad.exoplayer.j.a.m.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                synchronized (m.this) {
                    conditionVariable.open();
                    m.a(m.this);
                    d unused = m.this.e;
                }
            }
        }.start();
        conditionVariable.block();
    }

    private m(File file, d dVar, byte[] bArr) {
        this(file, dVar, bArr, bArr != null);
    }

    private m(File file, d dVar, byte[] bArr, boolean z) {
        this(file, dVar, new h(file, bArr, z));
    }

    private void a(e eVar, boolean z) {
        g b2 = this.f.b(eVar.f7557a);
        if (b2 == null || !b2.a(eVar)) {
            return;
        }
        this.h -= eVar.f7558c;
        if (z) {
            try {
                this.f.d(b2.b);
                this.f.b();
            } finally {
                c(eVar);
            }
        }
    }

    static /* synthetic */ void a(m mVar) {
        if (!mVar.d.exists()) {
            mVar.d.mkdirs();
            return;
        }
        mVar.f.a();
        File[] listFiles = mVar.d.listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                mVar.f.d();
                try {
                    mVar.f.b();
                    return;
                } catch (a.C0138a e) {
                    Log.e(f7571a, "Storing index file failed", e);
                    return;
                }
            }
            File file = listFiles[i2];
            if (!file.getName().equals(h.f7564a)) {
                n a2 = file.length() > 0 ? n.a(file, mVar.f) : null;
                if (a2 != null) {
                    mVar.a(a2);
                } else {
                    file.delete();
                }
            }
            i = i2 + 1;
        }
    }

    private void a(n nVar) {
        this.f.a(nVar.f7557a).a(nVar);
        this.h += nVar.f7558c;
        b(nVar);
    }

    private void b(n nVar) {
        ArrayList<a.b> arrayList = this.g.get(nVar.f7557a);
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            arrayList.get(i);
            size = i;
        }
    }

    private static boolean b(File file) {
        boolean contains;
        synchronized (m.class) {
            try {
                contains = b.contains(file.getAbsoluteFile());
            } catch (Throwable th) {
                throw th;
            }
        }
        return contains;
    }

    private void c(e eVar) {
        ArrayList<a.b> arrayList = this.g.get(eVar.f7557a);
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            arrayList.get(i);
            size = i;
        }
    }

    private void c(n nVar) {
        ArrayList<a.b> arrayList = this.g.get(nVar.f7557a);
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            arrayList.get(i);
            size = i;
        }
    }

    private static boolean c(File file) {
        synchronized (m.class) {
            try {
                if (f7572c) {
                    return true;
                }
                return b.add(file.getAbsoluteFile());
            } finally {
            }
        }
    }

    @Deprecated
    private static void d() {
        synchronized (m.class) {
            try {
                f7572c = true;
                b.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void d(File file) {
        synchronized (m.class) {
            try {
                if (!f7572c) {
                    b.remove(file.getAbsoluteFile());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.expressad.exoplayer.j.a.a
    /* renamed from: e */
    public n a(String str, long j) {
        n b2;
        synchronized (this) {
            while (true) {
                b2 = b(str, j);
                if (b2 == null) {
                    wait();
                }
            }
        }
        return b2;
    }

    private void e() {
        if (!this.d.exists()) {
            this.d.mkdirs();
            return;
        }
        this.f.a();
        File[] listFiles = this.d.listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.f.d();
                try {
                    this.f.b();
                    return;
                } catch (a.C0138a e) {
                    Log.e(f7571a, "Storing index file failed", e);
                    return;
                }
            }
            File file = listFiles[i2];
            if (!file.getName().equals(h.f7564a)) {
                n a2 = file.length() > 0 ? n.a(file, this.f) : null;
                if (a2 != null) {
                    a(a2);
                } else {
                    file.delete();
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.expressad.exoplayer.j.a.a
    /* renamed from: f */
    public n b(String str, long j) {
        n a2;
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            g b2 = this.f.b(str);
            if (b2 != null) {
                while (true) {
                    a2 = b2.a(j);
                    if (!a2.d || a2.e.exists()) {
                        break;
                    }
                    f();
                }
            } else {
                a2 = n.b(str, j);
            }
            if (!a2.d) {
                g a3 = this.f.a(str);
                if (a3.b()) {
                    return null;
                }
                a3.a(true);
                return a2;
            }
            n b3 = this.f.b(str).b(a2);
            ArrayList<a.b> arrayList = this.g.get(a2.f7557a);
            if (arrayList != null) {
                int size = arrayList.size();
                while (true) {
                    int i = size - 1;
                    if (i < 0) {
                        break;
                    }
                    arrayList.get(i);
                    size = i;
                }
            }
            return b3;
        }
    }

    private void f() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.f.c()) {
            Iterator<n> it = gVar.c().iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (!next.e.exists()) {
                    arrayList.add(next);
                }
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                this.f.d();
                this.f.b();
                return;
            }
            a((e) arrayList.get(i2), false);
            i = i2 + 1;
        }
    }

    private n g(String str, long j) {
        n a2;
        g b2 = this.f.b(str);
        if (b2 == null) {
            return n.b(str, j);
        }
        while (true) {
            a2 = b2.a(j);
            if (!a2.d || a2.e.exists()) {
                break;
            }
            f();
        }
        return a2;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final NavigableSet<e> a(String str) {
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            g b2 = this.f.b(str);
            if (b2 != null && !b2.d()) {
                return new TreeSet((Collection) b2.c());
            }
            return new TreeSet();
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final NavigableSet<e> a(String str, a.b bVar) {
        NavigableSet<e> a2;
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            ArrayList<a.b> arrayList = this.g.get(str);
            ArrayList<a.b> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>();
                this.g.put(str, arrayList2);
            }
            arrayList2.add(bVar);
            a2 = a(str);
        }
        return a2;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final void a() {
        synchronized (this) {
            if (this.i) {
                return;
            }
            this.g.clear();
            f();
            d(this.d);
            this.i = true;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final void a(e eVar) {
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            g b2 = this.f.b(eVar.f7557a);
            com.anythink.expressad.exoplayer.k.a.a(b2);
            com.anythink.expressad.exoplayer.k.a.b(b2.b());
            b2.a(false);
            this.f.d(b2.b);
            notifyAll();
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final void a(File file) {
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            n a2 = n.a(file, this.f);
            com.anythink.expressad.exoplayer.k.a.b(a2 != null);
            g b2 = this.f.b(a2.f7557a);
            com.anythink.expressad.exoplayer.k.a.a(b2);
            com.anythink.expressad.exoplayer.k.a.b(b2.b());
            if (file.exists()) {
                if (file.length() == 0) {
                    file.delete();
                    return;
                }
                long a3 = j.a(b2.a());
                if (a3 != -1) {
                    com.anythink.expressad.exoplayer.k.a.b(a2.b + a2.f7558c <= a3);
                }
                a(a2);
                this.f.b();
                notifyAll();
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final void a(String str, k kVar) {
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            this.f.a(str, kVar);
            this.f.b();
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final boolean a(String str, long j, long j2) {
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            g b2 = this.f.b(str);
            if (b2 != null) {
                if (b2.a(j, j2) >= j2) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final long b(String str) {
        long a2;
        synchronized (this) {
            a2 = j.a(c(str));
        }
        return a2;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final long b(String str, long j, long j2) {
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            g b2 = this.f.b(str);
            if (b2 != null) {
                return b2.a(j, j2);
            }
            return -j2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final Set<String> b() {
        HashSet hashSet;
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            hashSet = new HashSet(this.f.e());
        }
        return hashSet;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final void b(e eVar) {
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            a(eVar, true);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final void b(String str, a.b bVar) {
        synchronized (this) {
            if (this.i) {
                return;
            }
            ArrayList<a.b> arrayList = this.g.get(str);
            if (arrayList != null) {
                arrayList.remove(bVar);
                if (arrayList.isEmpty()) {
                    this.g.remove(str);
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final long c() {
        long j;
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            j = this.h;
        }
        return j;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final i c(String str) {
        i e;
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            e = this.f.e(str);
        }
        return e;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final File c(String str, long j) {
        File a2;
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(!this.i);
            g b2 = this.f.b(str);
            com.anythink.expressad.exoplayer.k.a.a(b2);
            com.anythink.expressad.exoplayer.k.a.b(b2.b());
            if (!this.d.exists()) {
                this.d.mkdirs();
                f();
            }
            a2 = n.a(this.d, b2.f7563a, j, System.currentTimeMillis());
        }
        return a2;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final void d(String str, long j) {
        synchronized (this) {
            k kVar = new k();
            j.a(kVar, j);
            a(str, kVar);
        }
    }
}
