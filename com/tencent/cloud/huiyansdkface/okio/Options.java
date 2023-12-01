package com.tencent.cloud.huiyansdkface.okio;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okio/Options.class */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        if (i2 >= i3) {
            throw new AssertionError();
        }
        int i6 = i2;
        while (true) {
            int i7 = i6;
            if (i7 >= i3) {
                ByteString byteString = list.get(i2);
                ByteString byteString2 = list.get(i3 - 1);
                int i8 = -1;
                int i9 = i2;
                ByteString byteString3 = byteString;
                if (i == byteString.size()) {
                    i8 = list2.get(i2).intValue();
                    i9 = i2 + 1;
                    byteString3 = list.get(i9);
                }
                if (byteString3.getByte(i) == byteString2.getByte(i)) {
                    int i10 = 0;
                    int min = Math.min(byteString3.size(), byteString2.size());
                    int i11 = i;
                    while (true) {
                        int i12 = i11;
                        if (i12 >= min || byteString3.getByte(i12) != byteString2.getByte(i12)) {
                            break;
                        }
                        i10++;
                        i11 = i12 + 1;
                    }
                    long intCount = 1 + j + intCount(buffer) + 2 + i10;
                    buffer.writeInt(-i10);
                    buffer.writeInt(i8);
                    int i13 = i;
                    while (true) {
                        int i14 = i13;
                        i4 = i + i10;
                        if (i14 >= i4) {
                            break;
                        }
                        buffer.writeInt(byteString3.getByte(i14) & 255);
                        i13 = i14 + 1;
                    }
                    if (i9 + 1 == i3) {
                        if (i4 != list.get(i9).size()) {
                            throw new AssertionError();
                        }
                        buffer.writeInt(list2.get(i9).intValue());
                        return;
                    }
                    Buffer buffer2 = new Buffer();
                    buffer.writeInt((int) ((intCount(buffer2) + intCount) * (-1)));
                    buildTrieRecursive(intCount, buffer2, i4, list, i9, i3, list2);
                    buffer.write(buffer2, buffer2.size());
                    return;
                }
                int i15 = i9 + 1;
                int i16 = 1;
                while (true) {
                    i5 = i16;
                    if (i15 >= i3) {
                        break;
                    }
                    int i17 = i5;
                    if (list.get(i15 - 1).getByte(i) != list.get(i15).getByte(i)) {
                        i17 = i5 + 1;
                    }
                    i15++;
                    i16 = i17;
                }
                long intCount2 = j + intCount(buffer) + 2 + (i5 * 2);
                buffer.writeInt(i5);
                buffer.writeInt(i8);
                int i18 = i9;
                while (true) {
                    int i19 = i18;
                    if (i19 >= i3) {
                        break;
                    }
                    byte b = list.get(i19).getByte(i);
                    if (i19 == i9 || b != list.get(i19 - 1).getByte(i)) {
                        buffer.writeInt(b & 255);
                    }
                    i18 = i19 + 1;
                }
                Buffer buffer3 = new Buffer();
                while (true) {
                    int i20 = i9;
                    if (i20 >= i3) {
                        buffer.write(buffer3, buffer3.size());
                        return;
                    }
                    byte b2 = list.get(i20).getByte(i);
                    int i21 = i20 + 1;
                    int i22 = i21;
                    while (true) {
                        i9 = i22;
                        if (i9 >= i3) {
                            i9 = i3;
                            break;
                        } else if (b2 != list.get(i9).getByte(i)) {
                            break;
                        } else {
                            i22 = i9 + 1;
                        }
                    }
                    if (i21 == i9 && i + 1 == list.get(i20).size()) {
                        buffer.writeInt(list2.get(i20).intValue());
                    } else {
                        buffer.writeInt((int) ((intCount(buffer3) + intCount2) * (-1)));
                        buildTrieRecursive(intCount2, buffer3, i + 1, list, i20, i9, list2);
                    }
                }
            } else if (list.get(i7).size() < i) {
                throw new AssertionError();
            } else {
                i6 = i7 + 1;
            }
        }
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0144, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.cloud.huiyansdkface.okio.Options of(com.tencent.cloud.huiyansdkface.okio.ByteString... r9) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.Options.of(com.tencent.cloud.huiyansdkface.okio.ByteString[]):com.tencent.cloud.huiyansdkface.okio.Options");
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }
}
