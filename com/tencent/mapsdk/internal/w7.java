package com.tencent.mapsdk.internal;

import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/w7.class */
public class w7 extends r7 {
    private ArrayList<r7> j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w7(r7... r7VarArr) {
        super(0L);
        long j = 0;
        this.j = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= r7VarArr.length) {
                this.f24044a = j;
                return;
            }
            this.j.add(r7VarArr[i2]);
            j += r7VarArr[i2].a();
            i = i2 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.r7
    public void a(GL10 gl10) {
        a(gl10, 0L);
    }

    @Override // com.tencent.mapsdk.internal.r7
    public void a(GL10 gl10, long j) {
        ArrayList<r7> arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<r7> it = this.j.iterator();
        while (it.hasNext()) {
            r7 next = it.next();
            if (!next.c()) {
                next.a(gl10);
                return;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.r7
    public boolean c() {
        Iterator<r7> it = this.j.iterator();
        while (it.hasNext()) {
            if (!it.next().c()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.r7
    public void d() {
        super.d();
        Iterator<r7> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    @Override // com.tencent.mapsdk.internal.r7
    public void e() {
        super.e();
        Iterator<r7> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }
}
