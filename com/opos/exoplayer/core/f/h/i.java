package com.opos.exoplayer.core.f.h;

import android.text.SpannableStringBuilder;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/h/i.class */
final class i implements com.opos.exoplayer.core.f.d {

    /* renamed from: a  reason: collision with root package name */
    private final List<c> f25409a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f25410c;
    private final long[] d;

    public i(List<c> list) {
        this.f25409a = list;
        int size = list.size();
        this.b = size;
        this.f25410c = new long[size * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b) {
                long[] jArr = this.f25410c;
                long[] copyOf = Arrays.copyOf(jArr, jArr.length);
                this.d = copyOf;
                Arrays.sort(copyOf);
                return;
            }
            c cVar = list.get(i2);
            int i3 = i2 * 2;
            this.f25410c[i3] = cVar.m;
            this.f25410c[i3 + 1] = cVar.n;
            i = i2 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j) {
        int b = u.b(this.d, j, false, false);
        if (b < this.d.length) {
            return b;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i) {
        com.opos.exoplayer.core.i.a.a(i >= 0);
        boolean z = false;
        if (i < this.d.length) {
            z = true;
        }
        com.opos.exoplayer.core.i.a.a(z);
        return this.d[i];
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.d.length;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j) {
        SpannableStringBuilder append;
        SpannableStringBuilder spannableStringBuilder = null;
        ArrayList arrayList = null;
        c cVar = null;
        int i = 0;
        while (i < this.b) {
            long[] jArr = this.f25410c;
            int i2 = i * 2;
            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
            ArrayList arrayList2 = arrayList;
            c cVar2 = cVar;
            if (jArr[i2] <= j) {
                spannableStringBuilder2 = spannableStringBuilder;
                arrayList2 = arrayList;
                cVar2 = cVar;
                if (j < jArr[i2 + 1]) {
                    arrayList2 = arrayList;
                    if (arrayList == null) {
                        arrayList2 = new ArrayList();
                    }
                    cVar2 = this.f25409a.get(i);
                    if (!cVar2.a()) {
                        arrayList2.add(cVar2);
                        cVar2 = cVar;
                        spannableStringBuilder2 = spannableStringBuilder;
                    } else if (cVar == null) {
                        spannableStringBuilder2 = spannableStringBuilder;
                    } else {
                        if (spannableStringBuilder == null) {
                            spannableStringBuilder = new SpannableStringBuilder();
                            append = spannableStringBuilder.append(cVar.f25344a).append((CharSequence) "\n");
                        } else {
                            append = spannableStringBuilder.append((CharSequence) "\n");
                        }
                        append.append(cVar2.f25344a);
                        spannableStringBuilder2 = spannableStringBuilder;
                        cVar2 = cVar;
                    }
                }
            }
            i++;
            spannableStringBuilder = spannableStringBuilder2;
            arrayList = arrayList2;
            cVar = cVar2;
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new c(spannableStringBuilder));
        } else if (cVar != null) {
            arrayList.add(cVar);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
