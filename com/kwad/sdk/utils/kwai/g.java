package com.kwad.sdk.utils.kwai;

import com.kwad.sdk.utils.kwai.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/g.class */
public final class g implements c.b<Set<String>> {
    static final g aCH = new g();

    private g() {
    }

    private static byte[] c(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        Iterator<String> it = set.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next == null) {
                i += 5;
                iArr[i3] = -1;
            } else {
                int eY = b.eY(next);
                strArr[i3] = next;
                iArr[i3] = eY;
                i += b.ck(eY) + eY;
            }
            i2 = i3 + 1;
        }
        b bVar = new b(i);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size) {
                return bVar.aBO;
            }
            int i6 = iArr[i5];
            bVar.cj(i6);
            if (i6 >= 0) {
                bVar.eX(strArr[i5]);
            }
            i4 = i5 + 1;
        }
    }

    private static Set<String> h(byte[] bArr, int i, int i2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            b bVar = new b(bArr, i);
            int i3 = i + i2;
            while (bVar.position < i3) {
                linkedHashSet.add(bVar.getString(bVar.Fc()));
            }
            if (bVar.position == i3) {
                return linkedHashSet;
            }
            throw new IllegalArgumentException("Invalid String set");
        }
        return linkedHashSet;
    }

    @Override // com.kwad.sdk.utils.kwai.c.b
    public final String Fw() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.kwai.c.b
    public final /* synthetic */ Set<String> g(byte[] bArr, int i, int i2) {
        return h(bArr, i, i2);
    }

    @Override // com.kwad.sdk.utils.kwai.c.b
    public final /* synthetic */ byte[] j(Set<String> set) {
        return c(set);
    }
}
