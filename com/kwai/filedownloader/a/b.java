package com.kwai.filedownloader.a;

import android.util.SparseArray;
import com.kwai.filedownloader.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/a/b.class */
public final class b implements com.kwai.filedownloader.a.a {
    final SparseArray<com.kwai.filedownloader.c.c> aGt = new SparseArray<>();
    final SparseArray<List<com.kwai.filedownloader.c.a>> aGu = new SparseArray<>();

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/a/b$a.class */
    final class a implements a.InterfaceC0414a {
        a() {
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0414a
        public final void Hy() {
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0414a
        public final void a(int i, com.kwai.filedownloader.c.c cVar) {
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0414a
        public final void c(com.kwai.filedownloader.c.c cVar) {
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwai.filedownloader.c.c> iterator() {
            return new C0415b();
        }
    }

    /* renamed from: com.kwai.filedownloader.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/a/b$b.class */
    final class C0415b implements Iterator<com.kwai.filedownloader.c.c> {
        C0415b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwai.filedownloader.c.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }
    }

    private void d(com.kwai.filedownloader.c.c cVar) {
        synchronized (this.aGt) {
            this.aGt.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void A(int i, int i2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0414a Hx() {
        return new a();
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, int i2, long j) {
        List<com.kwai.filedownloader.c.a> list;
        synchronized (this.aGu) {
            list = this.aGu.get(i);
        }
        if (list == null) {
            return;
        }
        for (com.kwai.filedownloader.c.a aVar : list) {
            if (aVar.getIndex() == i2) {
                aVar.am(j);
                return;
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, long j, String str, String str2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, String str, long j, long j2, int i2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th, long j) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.a aVar) {
        ArrayList arrayList;
        try {
            int id = aVar.getId();
            synchronized (this.aGu) {
                List<com.kwai.filedownloader.c.a> list = this.aGu.get(id);
                arrayList = list;
                if (list == null) {
                    arrayList = new ArrayList();
                    this.aGu.put(id, arrayList);
                }
            }
            arrayList.add(aVar);
        } catch (Exception e) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        if (cVar == null) {
            com.kwai.filedownloader.e.d.h(this, "update but model == null!", new Object[0]);
        } else if (cI(cVar.getId()) == null) {
            d(cVar);
        } else {
            synchronized (this.aGt) {
                this.aGt.remove(cVar.getId());
                this.aGt.put(cVar.getId(), cVar);
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cH(int i) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cI(int i) {
        com.kwai.filedownloader.c.c cVar;
        synchronized (this.aGt) {
            cVar = this.aGt.get(i);
        }
        return cVar;
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> cJ(int i) {
        List<com.kwai.filedownloader.c.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.aGu) {
                list = this.aGu.get(i);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cK(int i) {
        try {
            synchronized (this.aGu) {
                this.aGu.remove(i);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cL(int i) {
        synchronized (this.aGt) {
            this.aGt.remove(i);
        }
        return true;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cM(int i) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        synchronized (this.aGt) {
            this.aGt.clear();
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i, long j) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void f(int i, long j) {
        cL(i);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void g(int i, long j) {
    }
}
