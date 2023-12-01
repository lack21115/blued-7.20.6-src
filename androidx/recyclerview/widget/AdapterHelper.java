package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AdapterHelper.class */
public class AdapterHelper implements OpReorderer.Callback {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<UpdateOp> f3209a;
    final ArrayList<UpdateOp> b;

    /* renamed from: c  reason: collision with root package name */
    final Callback f3210c;
    Runnable d;
    final boolean e;
    final OpReorderer f;
    private Pools.Pool<UpdateOp> g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AdapterHelper$Callback.class */
    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i);

        void markViewHoldersUpdated(int i, int i2, Object obj);

        void offsetPositionsForAdd(int i, int i2);

        void offsetPositionsForMove(int i, int i2);

        void offsetPositionsForRemovingInvisible(int i, int i2);

        void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AdapterHelper$UpdateOp.class */
    public static class UpdateOp {

        /* renamed from: a  reason: collision with root package name */
        int f3211a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        Object f3212c;
        int d;

        UpdateOp(int i, int i2, int i3, Object obj) {
            this.f3211a = i;
            this.b = i2;
            this.d = i3;
            this.f3212c = obj;
        }

        String a() {
            int i = this.f3211a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : t.w : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i = this.f3211a;
            if (i != updateOp.f3211a) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.b) == 1 && this.d == updateOp.b && this.b == updateOp.d) {
                return true;
            }
            if (this.d == updateOp.d && this.b == updateOp.b) {
                Object obj2 = this.f3212c;
                return obj2 != null ? obj2.equals(updateOp.f3212c) : updateOp.f3212c == null;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f3211a * 31) + this.b) * 31) + this.d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.b + "c:" + this.d + ",p:" + this.f3212c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdapterHelper(Callback callback) {
        this(callback, false);
    }

    AdapterHelper(Callback callback, boolean z) {
        this.g = new Pools.SimplePool(30);
        this.f3209a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.h = 0;
        this.f3210c = callback;
        this.e = z;
        this.f = new OpReorderer(this);
    }

    private void a(UpdateOp updateOp) {
        f(updateOp);
    }

    private void b(UpdateOp updateOp) {
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3 = updateOp.b;
        int i4 = updateOp.b + updateOp.d;
        int i5 = updateOp.b;
        boolean z3 = true;
        int i6 = 0;
        while (true) {
            i = i6;
            if (i5 >= i4) {
                break;
            }
            if (this.f3210c.findViewHolder(i5) != null || c(i5)) {
                if (z3) {
                    z = false;
                } else {
                    d(obtainUpdateOp(2, i3, i, null));
                    z = true;
                }
                z3 = true;
            } else {
                if (z3) {
                    f(obtainUpdateOp(2, i3, i, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = z2;
                z3 = false;
            }
            if (z) {
                i5 -= i;
                i4 -= i;
                i2 = 1;
            } else {
                i2 = i + 1;
            }
            i5++;
            i6 = i2;
        }
        UpdateOp updateOp2 = updateOp;
        if (i != updateOp.d) {
            recycleUpdateOp(updateOp);
            updateOp2 = obtainUpdateOp(2, i3, i, null);
        }
        if (z3) {
            f(updateOp2);
        } else {
            d(updateOp2);
        }
    }

    private void c(UpdateOp updateOp) {
        int i;
        int i2;
        boolean z;
        int i3 = updateOp.b;
        int i4 = updateOp.b;
        int i5 = updateOp.d;
        int i6 = updateOp.b;
        boolean z2 = true;
        int i7 = 0;
        while (true) {
            i = i7;
            if (i6 >= i4 + i5) {
                break;
            }
            if (this.f3210c.findViewHolder(i6) != null || c(i6)) {
                int i8 = i3;
                i2 = i;
                if (!z2) {
                    d(obtainUpdateOp(4, i3, i, updateOp.f3212c));
                    i8 = i6;
                    i2 = 0;
                }
                z = true;
                i3 = i8;
            } else {
                int i9 = i3;
                int i10 = i;
                if (z2) {
                    f(obtainUpdateOp(4, i3, i, updateOp.f3212c));
                    i9 = i6;
                    i10 = 0;
                }
                z = false;
                i3 = i9;
                i2 = i10;
            }
            i6++;
            z2 = z;
            i7 = i2 + 1;
        }
        UpdateOp updateOp2 = updateOp;
        if (i != updateOp.d) {
            Object obj = updateOp.f3212c;
            recycleUpdateOp(updateOp);
            updateOp2 = obtainUpdateOp(4, i3, i, obj);
        }
        if (z2) {
            f(updateOp2);
        } else {
            d(updateOp2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(int r6) {
        /*
            r5 = this;
            r0 = r5
            java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r0 = r0.b
            int r0 = r0.size()
            r9 = r0
            r0 = 0
            r7 = r0
        Lb:
            r0 = r7
            r1 = r9
            if (r0 >= r1) goto L7c
            r0 = r5
            java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r0 = r0.b
            r1 = r7
            java.lang.Object r0 = r0.get(r1)
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = (androidx.recyclerview.widget.AdapterHelper.UpdateOp) r0
            r12 = r0
            r0 = r12
            int r0 = r0.f3211a
            r1 = 8
            if (r0 != r1) goto L3a
            r0 = r5
            r1 = r12
            int r1 = r1.d
            r2 = r7
            r3 = 1
            int r2 = r2 + r3
            int r0 = r0.a(r1, r2)
            r1 = r6
            if (r0 != r1) goto L75
            r0 = 1
            return r0
        L3a:
            r0 = r12
            int r0 = r0.f3211a
            r1 = 1
            if (r0 != r1) goto L75
            r0 = r12
            int r0 = r0.b
            r10 = r0
            r0 = r12
            int r0 = r0.d
            r11 = r0
            r0 = r12
            int r0 = r0.b
            r8 = r0
        L57:
            r0 = r8
            r1 = r10
            r2 = r11
            int r1 = r1 + r2
            if (r0 >= r1) goto L75
            r0 = r5
            r1 = r8
            r2 = r7
            r3 = 1
            int r2 = r2 + r3
            int r0 = r0.a(r1, r2)
            r1 = r6
            if (r0 != r1) goto L6e
            r0 = 1
            return r0
        L6e:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L57
        L75:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto Lb
        L7c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.AdapterHelper.c(int):boolean");
    }

    private int d(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int size = this.b.size();
        while (true) {
            int i6 = size - 1;
            i3 = i;
            if (i6 < 0) {
                break;
            }
            UpdateOp updateOp = this.b.get(i6);
            if (updateOp.f3211a == 8) {
                if (updateOp.b < updateOp.d) {
                    i4 = updateOp.b;
                    i5 = updateOp.d;
                } else {
                    i4 = updateOp.d;
                    i5 = updateOp.b;
                }
                if (i3 < i4 || i3 > i5) {
                    i = i3;
                    if (i3 < updateOp.b) {
                        if (i2 == 1) {
                            updateOp.b++;
                            updateOp.d++;
                            i = i3;
                        } else {
                            i = i3;
                            if (i2 == 2) {
                                updateOp.b--;
                                updateOp.d--;
                                i = i3;
                            }
                        }
                    }
                } else if (i4 == updateOp.b) {
                    if (i2 == 1) {
                        updateOp.d++;
                    } else if (i2 == 2) {
                        updateOp.d--;
                    }
                    i = i3 + 1;
                } else {
                    if (i2 == 1) {
                        updateOp.b++;
                    } else if (i2 == 2) {
                        updateOp.b--;
                    }
                    i = i3 - 1;
                }
            } else if (updateOp.b <= i3) {
                if (updateOp.f3211a == 1) {
                    i = i3 - updateOp.d;
                } else {
                    i = i3;
                    if (updateOp.f3211a == 2) {
                        i = i3 + updateOp.d;
                    }
                }
            } else if (i2 == 1) {
                updateOp.b++;
                i = i3;
            } else {
                i = i3;
                if (i2 == 2) {
                    updateOp.b--;
                    i = i3;
                }
            }
            size = i6;
        }
        int size2 = this.b.size();
        while (true) {
            int i7 = size2 - 1;
            if (i7 < 0) {
                return i3;
            }
            UpdateOp updateOp2 = this.b.get(i7);
            if (updateOp2.f3211a == 8) {
                if (updateOp2.d == updateOp2.b || updateOp2.d < 0) {
                    this.b.remove(i7);
                    recycleUpdateOp(updateOp2);
                }
            } else if (updateOp2.d <= 0) {
                this.b.remove(i7);
                recycleUpdateOp(updateOp2);
            }
            size2 = i7;
        }
    }

    private void d(UpdateOp updateOp) {
        int i;
        if (updateOp.f3211a == 1 || updateOp.f3211a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int d = d(updateOp.b, updateOp.f3211a);
        int i2 = updateOp.b;
        int i3 = updateOp.f3211a;
        if (i3 == 2) {
            i = 0;
        } else if (i3 != 4) {
            throw new IllegalArgumentException("op should be remove or update." + updateOp);
        } else {
            i = 1;
        }
        int i4 = 1;
        for (int i5 = 1; i5 < updateOp.d; i5++) {
            int d2 = d(updateOp.b + (i * i5), updateOp.f3211a);
            int i6 = updateOp.f3211a;
            if (i6 == 2 ? d2 == d : i6 == 4 && d2 == d + 1) {
                i4++;
            } else {
                UpdateOp obtainUpdateOp = obtainUpdateOp(updateOp.f3211a, d, i4, updateOp.f3212c);
                a(obtainUpdateOp, i2);
                recycleUpdateOp(obtainUpdateOp);
                int i7 = i2;
                if (updateOp.f3211a == 4) {
                    i7 = i2 + i4;
                }
                i4 = 1;
                i2 = i7;
                d = d2;
            }
        }
        Object obj = updateOp.f3212c;
        recycleUpdateOp(updateOp);
        if (i4 > 0) {
            UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.f3211a, d, i4, obj);
            a(obtainUpdateOp2, i2);
            recycleUpdateOp(obtainUpdateOp2);
        }
    }

    private void e(UpdateOp updateOp) {
        f(updateOp);
    }

    private void f(UpdateOp updateOp) {
        this.b.add(updateOp);
        int i = updateOp.f3211a;
        if (i == 1) {
            this.f3210c.offsetPositionsForAdd(updateOp.b, updateOp.d);
        } else if (i == 2) {
            this.f3210c.offsetPositionsForRemovingLaidOutOrNewView(updateOp.b, updateOp.d);
        } else if (i == 4) {
            this.f3210c.markViewHoldersUpdated(updateOp.b, updateOp.d, updateOp.f3212c);
        } else if (i == 8) {
            this.f3210c.offsetPositionsForMove(updateOp.b, updateOp.d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    int a(int i, int i2) {
        int size = this.b.size();
        int i3 = i2;
        while (true) {
            int i4 = i3;
            int i5 = i;
            if (i4 >= size) {
                return i5;
            }
            UpdateOp updateOp = this.b.get(i4);
            if (updateOp.f3211a != 8) {
                i = i5;
                if (updateOp.b > i5) {
                    continue;
                } else if (updateOp.f3211a != 2) {
                    i = i5;
                    if (updateOp.f3211a == 1) {
                        i = i5 + updateOp.d;
                    }
                } else if (i5 < updateOp.b + updateOp.d) {
                    return -1;
                } else {
                    i = i5 - updateOp.d;
                }
            } else if (updateOp.b == i5) {
                i = updateOp.d;
            } else {
                int i6 = i5;
                if (updateOp.b < i5) {
                    i6 = i5 - 1;
                }
                i = i6;
                if (updateOp.d <= i6) {
                    i = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        a(this.f3209a);
        a(this.b);
        this.h = 0;
    }

    void a(UpdateOp updateOp, int i) {
        this.f3210c.onDispatchFirstPass(updateOp);
        int i2 = updateOp.f3211a;
        if (i2 == 2) {
            this.f3210c.offsetPositionsForRemovingInvisible(i, updateOp.d);
        } else if (i2 != 4) {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        } else {
            this.f3210c.markViewHoldersUpdated(i, updateOp.d, updateOp.f3212c);
        }
    }

    void a(List<UpdateOp> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                list.clear();
                return;
            } else {
                recycleUpdateOp(list.get(i2));
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return (i & this.h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, int i3) {
        boolean z = false;
        if (i == i2) {
            return false;
        }
        if (i3 == 1) {
            this.f3209a.add(obtainUpdateOp(8, i, i2, null));
            this.h |= 8;
            if (this.f3209a.size() == 1) {
                z = true;
            }
            return z;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, Object obj) {
        boolean z = false;
        if (i2 < 1) {
            return false;
        }
        this.f3209a.add(obtainUpdateOp(4, i, i2, obj));
        this.h |= 4;
        if (this.f3209a.size() == 1) {
            z = true;
        }
        return z;
    }

    public int applyPendingUpdatesToPosition(int i) {
        int size = this.f3209a.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            int i4 = i;
            if (i3 >= size) {
                return i4;
            }
            UpdateOp updateOp = this.f3209a.get(i3);
            int i5 = updateOp.f3211a;
            if (i5 == 1) {
                i = i4;
                if (updateOp.b <= i4) {
                    i = i4 + updateOp.d;
                }
            } else if (i5 == 2) {
                i = i4;
                if (updateOp.b > i4) {
                    continue;
                } else if (updateOp.b + updateOp.d > i4) {
                    return -1;
                } else {
                    i = i4 - updateOp.d;
                }
            } else if (i5 != 8) {
                i = i4;
            } else if (updateOp.b == i4) {
                i = updateOp.d;
            } else {
                int i6 = i4;
                if (updateOp.b < i4) {
                    i6 = i4 - 1;
                }
                i = i6;
                if (updateOp.d <= i6) {
                    i = i6 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return a(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f.a(this.f3209a);
        int size = this.f3209a.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.f3209a.clear();
                return;
            }
            UpdateOp updateOp = this.f3209a.get(i2);
            int i3 = updateOp.f3211a;
            if (i3 == 1) {
                e(updateOp);
            } else if (i3 == 2) {
                b(updateOp);
            } else if (i3 == 4) {
                c(updateOp);
            } else if (i3 == 8) {
                a(updateOp);
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i, int i2) {
        boolean z = false;
        if (i2 < 1) {
            return false;
        }
        this.f3209a.add(obtainUpdateOp(1, i, i2, null));
        this.h |= 1;
        if (this.f3209a.size() == 1) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        int size = this.b.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                a(this.b);
                this.h = 0;
                return;
            }
            this.f3210c.onDispatchSecondPass(this.b.get(i2));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i, int i2) {
        boolean z = false;
        if (i2 < 1) {
            return false;
        }
        this.f3209a.add(obtainUpdateOp(2, i, i2, null));
        this.h |= 2;
        if (this.f3209a.size() == 1) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f3209a.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        c();
        int size = this.f3209a.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                a(this.f3209a);
                this.h = 0;
                return;
            }
            UpdateOp updateOp = this.f3209a.get(i2);
            int i3 = updateOp.f3211a;
            if (i3 == 1) {
                this.f3210c.onDispatchSecondPass(updateOp);
                this.f3210c.offsetPositionsForAdd(updateOp.b, updateOp.d);
            } else if (i3 == 2) {
                this.f3210c.onDispatchSecondPass(updateOp);
                this.f3210c.offsetPositionsForRemovingInvisible(updateOp.b, updateOp.d);
            } else if (i3 == 4) {
                this.f3210c.onDispatchSecondPass(updateOp);
                this.f3210c.markViewHoldersUpdated(updateOp.b, updateOp.d, updateOp.f3212c);
            } else if (i3 == 8) {
                this.f3210c.onDispatchSecondPass(updateOp);
                this.f3210c.offsetPositionsForMove(updateOp.b, updateOp.d);
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return (this.b.isEmpty() || this.f3209a.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj) {
        UpdateOp acquire = this.g.acquire();
        if (acquire == null) {
            return new UpdateOp(i, i2, i3, obj);
        }
        acquire.f3211a = i;
        acquire.b = i2;
        acquire.d = i3;
        acquire.f3212c = obj;
        return acquire;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp updateOp) {
        if (this.e) {
            return;
        }
        updateOp.f3212c = null;
        this.g.release(updateOp);
    }
}
