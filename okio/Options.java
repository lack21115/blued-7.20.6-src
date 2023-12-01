package okio;

import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/Options.class */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:okio/Options$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void buildTrieRecursive(long j, Buffer buffer, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) {
            int i4;
            int i5;
            int i6;
            int i7 = i;
            if (!(i2 < i3)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i2 < i3) {
                int i8 = i2;
                while (true) {
                    int i9 = i8;
                    int i10 = i9 + 1;
                    if (!(list.get(i9).size() >= i7)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    if (i10 >= i3) {
                        break;
                    }
                    i8 = i10;
                }
            }
            ByteString byteString = list.get(i2);
            ByteString byteString2 = list.get(i3 - 1);
            if (i7 == byteString.size()) {
                i5 = list2.get(i2).intValue();
                i4 = i2 + 1;
                byteString = list.get(i4);
            } else {
                i4 = i2;
                i5 = -1;
            }
            if (byteString.getByte(i7) == byteString2.getByte(i7)) {
                int min = Math.min(byteString.size(), byteString2.size());
                if (i7 < min) {
                    int i11 = i7;
                    int i12 = 0;
                    while (true) {
                        int i13 = i11 + 1;
                        i6 = i12;
                        if (byteString.getByte(i11) != byteString2.getByte(i11)) {
                            break;
                        }
                        i12++;
                        if (i13 >= min) {
                            i6 = i12;
                            break;
                        }
                        i11 = i13;
                    }
                } else {
                    i6 = 0;
                }
                long intCount = j + getIntCount(buffer) + 2 + i6 + 1;
                buffer.writeInt(-i6);
                buffer.writeInt(i5);
                int i14 = i7 + i6;
                if (i7 < i14) {
                    while (true) {
                        int i15 = i7 + 1;
                        buffer.writeInt(byteString.getByte(i7) & 255);
                        if (i15 >= i14) {
                            break;
                        }
                        i7 = i15;
                    }
                }
                if (i4 + 1 == i3) {
                    if (!(i14 == list.get(i4).size())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    buffer.writeInt(list2.get(i4).intValue());
                    return;
                }
                Buffer buffer2 = new Buffer();
                buffer.writeInt(((int) (getIntCount(buffer2) + intCount)) * (-1));
                buildTrieRecursive(intCount, buffer2, i14, list, i4, i3, list2);
                buffer.writeAll(buffer2);
                return;
            }
            int i16 = i4 + 1;
            int i17 = 1;
            int i18 = 1;
            if (i16 < i3) {
                while (true) {
                    int i19 = i16 + 1;
                    i17 = i18;
                    if (list.get(i16 - 1).getByte(i7) != list.get(i16).getByte(i7)) {
                        i17 = i18 + 1;
                    }
                    if (i19 >= i3) {
                        break;
                    }
                    i16 = i19;
                    i18 = i17;
                }
            }
            long intCount2 = j + getIntCount(buffer) + 2 + (i17 * 2);
            buffer.writeInt(i17);
            buffer.writeInt(i5);
            if (i4 < i3) {
                int i20 = i4;
                while (true) {
                    int i21 = i20;
                    int i22 = i21 + 1;
                    byte b = list.get(i21).getByte(i7);
                    if (i21 == i4 || b != list.get(i21 - 1).getByte(i7)) {
                        buffer.writeInt(b & 255);
                    }
                    if (i22 >= i3) {
                        break;
                    }
                    i20 = i22;
                }
            }
            Buffer buffer3 = new Buffer();
            while (true) {
                int i23 = i4;
                if (i23 >= i3) {
                    buffer.writeAll(buffer3);
                    return;
                }
                byte b2 = list.get(i23).getByte(i7);
                int i24 = i23 + 1;
                if (i24 < i3) {
                    int i25 = i24;
                    while (true) {
                        i4 = i25;
                        int i26 = i4 + 1;
                        if (b2 != list.get(i4).getByte(i7)) {
                            break;
                        } else if (i26 >= i3) {
                            break;
                        } else {
                            i25 = i26;
                        }
                    }
                }
                i4 = i3;
                if (i24 == i4 && i7 + 1 == list.get(i23).size()) {
                    buffer.writeInt(list2.get(i23).intValue());
                } else {
                    buffer.writeInt(((int) (intCount2 + getIntCount(buffer3))) * (-1));
                    buildTrieRecursive(intCount2, buffer3, i7 + 1, list, i23, i4, list2);
                }
            }
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j, Buffer buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                j = 0;
            }
            if ((i4 & 4) != 0) {
                i = 0;
            }
            if ((i4 & 16) != 0) {
                i2 = 0;
            }
            if ((i4 & 32) != 0) {
                i3 = list.size();
            }
            companion.buildTrieRecursive(j, buffer, i, list, i2, i3, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:63:0x01a3, code lost:
            continue;
         */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okio.Options of(okio.ByteString... r13) {
            /*
                Method dump skipped, instructions count: 542
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.of(okio.ByteString[]):okio.Options");
        }
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    public static final Options of(ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Options) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Options) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Options) byteString);
    }
}
