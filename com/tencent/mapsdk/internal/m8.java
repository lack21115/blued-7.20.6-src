package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.k8;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m8.class */
public final class m8 extends k8 {

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<k8> f23940c = new ArrayList<>();
    private HashMap<k8, f> d = new HashMap<>();
    private ArrayList<f> e = new ArrayList<>();
    private ArrayList<f> f = new ArrayList<>();
    private boolean g = true;
    private b h = null;
    public boolean i = false;
    private boolean j = false;
    private long k = 0;
    private z8 l = null;
    private long m = -1;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m8$a.class */
    public class a extends l8 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f23941a = false;
        public final /* synthetic */ ArrayList b;

        public a(ArrayList arrayList) {
            this.b = arrayList;
        }

        @Override // com.tencent.mapsdk.internal.l8, com.tencent.mapsdk.internal.k8.a
        public void b(k8 k8Var) {
            this.f23941a = true;
        }

        @Override // com.tencent.mapsdk.internal.l8, com.tencent.mapsdk.internal.k8.a
        public void c(k8 k8Var) {
            if (this.f23941a) {
                return;
            }
            int size = this.b.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                f fVar = (f) this.b.get(i2);
                fVar.b.j();
                m8.this.f23940c.add(fVar.b);
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m8$b.class */
    public class b implements k8.a {

        /* renamed from: a  reason: collision with root package name */
        private m8 f23943a;

        public b(m8 m8Var) {
            this.f23943a = m8Var;
        }

        @Override // com.tencent.mapsdk.internal.k8.a
        public void a(k8 k8Var) {
        }

        @Override // com.tencent.mapsdk.internal.k8.a
        public void b(k8 k8Var) {
            ArrayList<k8.a> arrayList;
            m8 m8Var = m8.this;
            if (m8Var.i || m8Var.f23940c.size() != 0 || (arrayList = m8.this.b) == null) {
                return;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                m8.this.b.get(i2).b(this.f23943a);
                i = i2 + 1;
            }
        }

        @Override // com.tencent.mapsdk.internal.k8.a
        public void c(k8 k8Var) {
            boolean z;
            k8Var.b(this);
            m8.this.f23940c.remove(k8Var);
            ((f) this.f23943a.d.get(k8Var)).g = true;
            if (m8.this.i) {
                return;
            }
            ArrayList arrayList = this.f23943a.f;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                z = true;
                if (i2 >= size) {
                    break;
                } else if (!((f) arrayList.get(i2)).g) {
                    z = false;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (z) {
                ArrayList<k8.a> arrayList2 = m8.this.b;
                if (arrayList2 != null) {
                    ArrayList arrayList3 = (ArrayList) arrayList2.clone();
                    int size2 = arrayList3.size();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= size2) {
                            break;
                        }
                        ((k8.a) arrayList3.get(i4)).c(this.f23943a);
                        i3 = i4 + 1;
                    }
                }
                this.f23943a.j = false;
            }
        }

        @Override // com.tencent.mapsdk.internal.k8.a
        public void d(k8 k8Var) {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m8$c.class */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        private f f23944a;

        public c(k8 k8Var) {
            f fVar = (f) m8.this.d.get(k8Var);
            this.f23944a = fVar;
            if (fVar == null) {
                this.f23944a = new f(k8Var);
                m8.this.d.put(k8Var, this.f23944a);
                m8.this.e.add(this.f23944a);
            }
        }

        public c a(long j) {
            z8 a2 = z8.a((h8) null, 0.0d, 1.0d);
            a2.a(j);
            a(a2);
            return this;
        }

        public c a(k8 k8Var) {
            f fVar = (f) m8.this.d.get(k8Var);
            f fVar2 = fVar;
            if (fVar == null) {
                fVar2 = new f(k8Var);
                m8.this.d.put(k8Var, fVar2);
                m8.this.e.add(fVar2);
            }
            this.f23944a.a(new d(fVar2, 1));
            return this;
        }

        public c b(k8 k8Var) {
            f fVar = (f) m8.this.d.get(k8Var);
            f fVar2 = fVar;
            if (fVar == null) {
                fVar2 = new f(k8Var);
                m8.this.d.put(k8Var, fVar2);
                m8.this.e.add(fVar2);
            }
            fVar2.a(new d(this.f23944a, 1));
            return this;
        }

        public c c(k8 k8Var) {
            f fVar = (f) m8.this.d.get(k8Var);
            f fVar2 = fVar;
            if (fVar == null) {
                fVar2 = new f(k8Var);
                m8.this.d.put(k8Var, fVar2);
                m8.this.e.add(fVar2);
            }
            fVar2.a(new d(this.f23944a, 0));
            return this;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m8$d.class */
    public static class d {

        /* renamed from: c  reason: collision with root package name */
        public static final int f23945c = 0;
        public static final int d = 1;

        /* renamed from: a  reason: collision with root package name */
        public f f23946a;
        public int b;

        public d(f fVar, int i) {
            this.f23946a = fVar;
            this.b = i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m8$e.class */
    public static class e implements k8.a {

        /* renamed from: a  reason: collision with root package name */
        private m8 f23947a;
        private f b;

        /* renamed from: c  reason: collision with root package name */
        private int f23948c;

        public e(m8 m8Var, f fVar, int i) {
            this.f23947a = m8Var;
            this.b = fVar;
            this.f23948c = i;
        }

        private void e(k8 k8Var) {
            d dVar;
            if (this.f23947a.i) {
                return;
            }
            int size = this.b.d.size();
            int i = 0;
            while (true) {
                int i2 = i;
                dVar = null;
                if (i2 >= size) {
                    break;
                }
                dVar = this.b.d.get(i2);
                if (dVar.b == this.f23948c && dVar.f23946a.b == k8Var) {
                    k8Var.b(this);
                    break;
                }
                i = i2 + 1;
            }
            this.b.d.remove(dVar);
            if (this.b.d.size() == 0) {
                this.b.b.j();
                this.f23947a.f23940c.add(this.b.b);
            }
        }

        @Override // com.tencent.mapsdk.internal.k8.a
        public void a(k8 k8Var) {
        }

        @Override // com.tencent.mapsdk.internal.k8.a
        public void b(k8 k8Var) {
        }

        @Override // com.tencent.mapsdk.internal.k8.a
        public void c(k8 k8Var) {
            if (this.f23948c == 1) {
                e(k8Var);
            }
        }

        @Override // com.tencent.mapsdk.internal.k8.a
        public void d(k8 k8Var) {
            if (this.f23948c == 0) {
                e(k8Var);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m8$f.class */
    public static class f implements Cloneable {
        public k8 b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<d> f23949c = null;
        public ArrayList<d> d = null;
        public ArrayList<f> e = null;
        public ArrayList<f> f = null;
        public boolean g = false;

        public f(k8 k8Var) {
            this.b = k8Var;
        }

        /* renamed from: a */
        public f clone() {
            try {
                f fVar = (f) super.clone();
                fVar.b = this.b.clone();
                return fVar;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        public void a(d dVar) {
            if (this.f23949c == null) {
                this.f23949c = new ArrayList<>();
                this.e = new ArrayList<>();
            }
            this.f23949c.add(dVar);
            if (!this.e.contains(dVar.f23946a)) {
                this.e.add(dVar.f23946a);
            }
            f fVar = dVar.f23946a;
            if (fVar.f == null) {
                fVar.f = new ArrayList<>();
            }
            fVar.f.add(this);
        }
    }

    private void m() {
        if (this.g) {
            this.f.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.e.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                f fVar = this.e.get(i2);
                ArrayList<d> arrayList2 = fVar.f23949c;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    arrayList.add(fVar);
                }
                i = i2 + 1;
            }
            ArrayList arrayList3 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < size2) {
                        f fVar2 = (f) arrayList.get(i4);
                        this.f.add(fVar2);
                        ArrayList<f> arrayList4 = fVar2.f;
                        if (arrayList4 != null) {
                            int size3 = arrayList4.size();
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 < size3) {
                                    f fVar3 = fVar2.f.get(i6);
                                    fVar3.e.remove(fVar2);
                                    if (fVar3.e.size() == 0) {
                                        arrayList3.add(fVar3);
                                    }
                                    i5 = i6 + 1;
                                }
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList3);
                arrayList3.clear();
            }
            this.g = false;
            if (this.f.size() != this.e.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.e.size();
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= size4) {
                return;
            }
            f fVar4 = this.e.get(i8);
            ArrayList<d> arrayList5 = fVar4.f23949c;
            if (arrayList5 != null && arrayList5.size() > 0) {
                int size5 = fVar4.f23949c.size();
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 < size5) {
                        d dVar = fVar4.f23949c.get(i10);
                        if (fVar4.e == null) {
                            fVar4.e = new ArrayList<>();
                        }
                        if (!fVar4.e.contains(dVar.f23946a)) {
                            fVar4.e.add(dVar.f23946a);
                        }
                        i9 = i10 + 1;
                    }
                }
            }
            fVar4.g = false;
            i7 = i8 + 1;
        }
    }

    public c a(k8 k8Var) {
        if (k8Var != null) {
            this.g = true;
            return new c(k8Var);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.k8
    public void a() {
        this.i = true;
        if (h()) {
            ArrayList arrayList = null;
            ArrayList<k8.a> arrayList2 = this.b;
            if (arrayList2 != null) {
                ArrayList arrayList3 = (ArrayList) arrayList2.clone();
                Iterator it = arrayList3.iterator();
                while (true) {
                    arrayList = arrayList3;
                    if (!it.hasNext()) {
                        break;
                    }
                    ((k8.a) it.next()).b(this);
                }
            }
            z8 z8Var = this.l;
            if (z8Var != null && z8Var.g()) {
                this.l.a();
            } else if (this.f.size() > 0) {
                Iterator<f> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    it2.next().b.a();
                }
            }
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((k8.a) it3.next()).c(this);
                }
            }
            this.j = false;
        }
    }

    @Override // com.tencent.mapsdk.internal.k8
    public void a(Interpolator interpolator) {
        Iterator<f> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().b.a(interpolator);
        }
    }

    public void a(Collection<k8> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.g = true;
        c cVar = null;
        for (k8 k8Var : collection) {
            if (cVar == null) {
                cVar = a(k8Var);
            } else {
                cVar.c(k8Var);
            }
        }
    }

    public void a(List<k8> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.g = true;
        int i = 0;
        if (list.size() == 1) {
            a(list.get(0));
            return;
        }
        while (i < list.size() - 1) {
            i++;
            a(list.get(i)).b(list.get(i));
        }
    }

    public void a(k8... k8VarArr) {
        if (k8VarArr != null) {
            this.g = true;
            int i = 0;
            if (k8VarArr.length == 1) {
                a(k8VarArr[0]);
                return;
            }
            while (i < k8VarArr.length - 1) {
                i++;
                a(k8VarArr[i]).b(k8VarArr[i]);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.k8
    public void b(long j) {
        this.k = j;
    }

    public void b(k8... k8VarArr) {
        if (k8VarArr != null) {
            this.g = true;
            c a2 = a(k8VarArr[0]);
            for (int i = 1; i < k8VarArr.length; i++) {
                a2.c(k8VarArr[i]);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.k8
    /* renamed from: c */
    public m8 a(long j) {
        if (j >= 0) {
            Iterator<f> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().b.a(j);
            }
            this.m = j;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    @Override // com.tencent.mapsdk.internal.k8
    public void c() {
        this.i = true;
        if (h()) {
            if (this.f.size() != this.e.size()) {
                m();
                Iterator<f> it = this.f.iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    if (this.h == null) {
                        this.h = new b(this);
                    }
                    next.b.a(this.h);
                }
            }
            z8 z8Var = this.l;
            if (z8Var != null) {
                z8Var.a();
            }
            if (this.f.size() > 0) {
                Iterator<f> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    it2.next().b.c();
                }
            }
            ArrayList<k8.a> arrayList = this.b;
            if (arrayList != null) {
                Iterator it3 = ((ArrayList) arrayList.clone()).iterator();
                while (it3.hasNext()) {
                    ((k8.a) it3.next()).c(this);
                }
            }
            this.j = false;
        }
    }

    @Override // com.tencent.mapsdk.internal.k8
    public long d() {
        return this.m;
    }

    @Override // com.tencent.mapsdk.internal.k8
    public long f() {
        return this.k;
    }

    @Override // com.tencent.mapsdk.internal.k8
    public boolean g() {
        Iterator<f> it = this.e.iterator();
        while (it.hasNext()) {
            if (it.next().b.g()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.k8
    public boolean h() {
        return this.j;
    }

    @Override // com.tencent.mapsdk.internal.k8
    public void j() {
        this.i = false;
        this.j = true;
        m();
        int size = this.f.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            f fVar = this.f.get(i2);
            ArrayList<k8.a> e2 = fVar.b.e();
            if (e2 != null && e2.size() > 0) {
                Iterator it = new ArrayList(e2).iterator();
                while (it.hasNext()) {
                    k8.a aVar = (k8.a) it.next();
                    if ((aVar instanceof e) || (aVar instanceof b)) {
                        fVar.b.b(aVar);
                    }
                }
            }
            i = i2 + 1;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                break;
            }
            f fVar2 = this.f.get(i4);
            if (this.h == null) {
                this.h = new b(this);
            }
            ArrayList<d> arrayList2 = fVar2.f23949c;
            if (arrayList2 == null || arrayList2.size() == 0) {
                arrayList.add(fVar2);
            } else {
                int size2 = fVar2.f23949c.size();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= size2) {
                        break;
                    }
                    d dVar = fVar2.f23949c.get(i6);
                    dVar.f23946a.b.a(new e(this, fVar2, dVar.b));
                    i5 = i6 + 1;
                }
                fVar2.d = (ArrayList) fVar2.f23949c.clone();
            }
            fVar2.b.a(this.h);
            i3 = i4 + 1;
        }
        if (this.k <= 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                f fVar3 = (f) it2.next();
                fVar3.b.j();
                this.f23940c.add(fVar3.b);
            }
        } else {
            z8 a2 = z8.a((h8) null, 0.0d, 1.0d);
            this.l = a2;
            a2.a(this.k);
            this.l.a(new a(arrayList));
            this.l.j();
        }
        ArrayList<k8.a> arrayList3 = this.b;
        if (arrayList3 != null) {
            ArrayList arrayList4 = (ArrayList) arrayList3.clone();
            int size3 = arrayList4.size();
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= size3) {
                    break;
                }
                ((k8.a) arrayList4.get(i8)).d(this);
                i7 = i8 + 1;
            }
        }
        if (this.e.size() != 0 || this.k != 0) {
            return;
        }
        this.j = false;
        ArrayList<k8.a> arrayList5 = this.b;
        if (arrayList5 == null) {
            return;
        }
        ArrayList arrayList6 = (ArrayList) arrayList5.clone();
        int size4 = arrayList6.size();
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= size4) {
                return;
            }
            ((k8.a) arrayList6.get(i10)).c(this);
            i9 = i10 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.k8
    /* renamed from: k */
    public m8 clone() {
        m8 m8Var = (m8) super.clone();
        m8Var.g = true;
        m8Var.i = false;
        m8Var.j = false;
        m8Var.f23940c = new ArrayList<>();
        m8Var.d = new HashMap<>();
        m8Var.e = new ArrayList<>();
        m8Var.f = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<f> it = this.e.iterator();
        while (it.hasNext()) {
            f next = it.next();
            f clone = next.clone();
            hashMap.put(next, clone);
            m8Var.e.add(clone);
            m8Var.d.put(clone.b, clone);
            ArrayList arrayList = null;
            clone.f23949c = null;
            clone.d = null;
            clone.f = null;
            clone.e = null;
            ArrayList<k8.a> e2 = clone.b.e();
            if (e2 != null) {
                Iterator<k8.a> it2 = e2.iterator();
                while (it2.hasNext()) {
                    k8.a next2 = it2.next();
                    if (next2 instanceof b) {
                        ArrayList arrayList2 = arrayList;
                        if (arrayList == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(next2);
                        arrayList = arrayList2;
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        e2.remove((k8.a) it3.next());
                    }
                }
            }
        }
        Iterator<f> it4 = this.e.iterator();
        while (it4.hasNext()) {
            f next3 = it4.next();
            f fVar = (f) hashMap.get(next3);
            ArrayList<d> arrayList3 = next3.f23949c;
            if (arrayList3 != null) {
                Iterator<d> it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    d next4 = it5.next();
                    fVar.a(new d((f) hashMap.get(next4.f23946a), next4.b));
                }
            }
        }
        return m8Var;
    }

    public ArrayList<k8> l() {
        ArrayList<k8> arrayList = new ArrayList<>();
        Iterator<f> it = this.e.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b);
        }
        return arrayList;
    }
}
