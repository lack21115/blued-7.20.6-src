package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/OpReorderer.class */
public class OpReorderer {

    /* renamed from: a  reason: collision with root package name */
    final Callback f3310a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/OpReorderer$Callback.class */
    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpReorderer(Callback callback) {
        this.f3310a = callback;
    }

    private void a(List<AdapterHelper.UpdateOp> list, int i, int i2) {
        AdapterHelper.UpdateOp updateOp = list.get(i);
        AdapterHelper.UpdateOp updateOp2 = list.get(i2);
        int i3 = updateOp2.f3211a;
        if (i3 == 1) {
            c(list, i, updateOp, i2, updateOp2);
        } else if (i3 == 2) {
            a(list, i, updateOp, i2, updateOp2);
        } else if (i3 != 4) {
        } else {
            b(list, i, updateOp, i2, updateOp2);
        }
    }

    private int b(List<AdapterHelper.UpdateOp> list) {
        boolean z;
        int size = list.size() - 1;
        boolean z2 = false;
        while (true) {
            boolean z3 = z2;
            if (size < 0) {
                return -1;
            }
            if (list.get(size).f3211a == 8) {
                z = z3;
                if (z3) {
                    return size;
                }
            } else {
                z = true;
            }
            size--;
            z2 = z;
        }
    }

    private void c(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        int i3 = updateOp.d < updateOp2.b ? -1 : 0;
        int i4 = i3;
        if (updateOp.b < updateOp2.b) {
            i4 = i3 + 1;
        }
        if (updateOp2.b <= updateOp.b) {
            updateOp.b += updateOp2.d;
        }
        if (updateOp2.b <= updateOp.d) {
            updateOp.d += updateOp2.d;
        }
        updateOp2.b += i4;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int b = b(list);
            if (b == -1) {
                return;
            }
            a(list, b, b + 1);
        }
    }

    void a(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        boolean z;
        boolean z2 = false;
        if (updateOp.b < updateOp.d) {
            if (updateOp2.b == updateOp.b && updateOp2.d == updateOp.d - updateOp.b) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (updateOp2.b == updateOp.d + 1 && updateOp2.d == updateOp.b - updateOp.d) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (updateOp.d < updateOp2.b) {
            updateOp2.b--;
        } else if (updateOp.d < updateOp2.b + updateOp2.d) {
            updateOp2.d--;
            updateOp.f3211a = 2;
            updateOp.d = 1;
            if (updateOp2.d == 0) {
                list.remove(i2);
                this.f3310a.recycleUpdateOp(updateOp2);
                return;
            }
            return;
        }
        AdapterHelper.UpdateOp updateOp3 = null;
        if (updateOp.b <= updateOp2.b) {
            updateOp2.b++;
        } else if (updateOp.b < updateOp2.b + updateOp2.d) {
            updateOp3 = this.f3310a.obtainUpdateOp(2, updateOp.b + 1, (updateOp2.b + updateOp2.d) - updateOp.b, null);
            updateOp2.d = updateOp.b - updateOp2.b;
        }
        if (z2) {
            list.set(i, updateOp2);
            list.remove(i2);
            this.f3310a.recycleUpdateOp(updateOp);
            return;
        }
        if (z) {
            if (updateOp3 != null) {
                if (updateOp.b > updateOp3.b) {
                    updateOp.b -= updateOp3.d;
                }
                if (updateOp.d > updateOp3.b) {
                    updateOp.d -= updateOp3.d;
                }
            }
            if (updateOp.b > updateOp2.b) {
                updateOp.b -= updateOp2.d;
            }
            if (updateOp.d > updateOp2.b) {
                updateOp.d -= updateOp2.d;
            }
        } else {
            if (updateOp3 != null) {
                if (updateOp.b >= updateOp3.b) {
                    updateOp.b -= updateOp3.d;
                }
                if (updateOp.d >= updateOp3.b) {
                    updateOp.d -= updateOp3.d;
                }
            }
            if (updateOp.b >= updateOp2.b) {
                updateOp.b -= updateOp2.d;
            }
            if (updateOp.d >= updateOp2.b) {
                updateOp.d -= updateOp2.d;
            }
        }
        list.set(i, updateOp2);
        if (updateOp.b != updateOp.d) {
            list.set(i2, updateOp);
        } else {
            list.remove(i2);
        }
        if (updateOp3 != null) {
            list.add(i, updateOp3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void b(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r7, int r8, androidx.recyclerview.widget.AdapterHelper.UpdateOp r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.b(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
