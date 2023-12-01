package com.bytedance.pangle.res.a;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/k.class */
public final class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(g gVar) {
        return (int) gVar.f7874a.a().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, int i2, h hVar) {
        int i3 = i;
        if (i >= 2130706432) {
            i3 = hVar.a(i);
            byte[] a2 = a(i3);
            bArr[i2] = a2[0];
            bArr[i2 + 1] = a2[1];
            bArr[i2 + 2] = a2[2];
            bArr[i2 + 3] = a2[3];
        }
        return i3;
    }

    public static void a(int i, byte[] bArr, int[] iArr, int i2, HashMap<Integer, Integer> hashMap) {
        int i3;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        int i4 = 0;
        int i5 = -1;
        while (true) {
            i3 = i5;
            if (i4 >= i2) {
                break;
            }
            int i6 = i4 * 5;
            int i7 = iArr[i6 + 1];
            int i8 = i3;
            if (hashMap.containsKey(Integer.valueOf(i7))) {
                i8 = i3;
                if (i3 == -1) {
                    i8 = i4;
                }
                int i9 = (i6 * 4) + i;
                hashMap2.put(Integer.valueOf(i4), Arrays.copyOfRange(bArr, i9, i9 + 20));
                hashMap3.put(Integer.valueOf(hashMap.get(Integer.valueOf(i7)).intValue()), Integer.valueOf(i4));
            }
            i4++;
            i5 = i8;
        }
        ArrayList arrayList = new ArrayList(hashMap3.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (!it.hasNext()) {
                return;
            }
            byte[] bArr2 = (byte[]) hashMap2.get(Integer.valueOf(((Integer) hashMap3.get((Integer) it.next())).intValue()));
            System.arraycopy(bArr2, 0, bArr, ((i11 + i3) * 5 * 4) + i, bArr2.length);
            i10 = i11 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, h hVar) {
        b bVar = new b(bArr, hVar);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        bVar.a();
        bVar.f7868c = new g(new i(new e(byteArrayInputStream)));
        do {
        } while (bVar.b() != 1);
    }

    private static byte[] a(int i) {
        return new byte[]{(byte) (i >> 0), (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }
}
