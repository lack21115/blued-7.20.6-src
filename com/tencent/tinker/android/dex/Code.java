package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/Code.class */
public final class Code extends TableOfContents.Section.Item<Code> {
    public CatchHandler[] catchHandlers;
    public int debugInfoOffset;
    public int insSize;
    public short[] instructions;
    public int outsSize;
    public int registersSize;
    public Try[] tries;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/Code$CatchHandler.class */
    public static class CatchHandler implements Comparable<CatchHandler> {
        public int[] addresses;
        public int catchAllAddress;
        public int offset;
        public int[] typeIndexes;

        public CatchHandler(int[] iArr, int[] iArr2, int i, int i2) {
            this.typeIndexes = iArr;
            this.addresses = iArr2;
            this.catchAllAddress = i;
            this.offset = i2;
        }

        @Override // java.lang.Comparable
        public int compareTo(CatchHandler catchHandler) {
            int sArrCompare = CompareUtils.sArrCompare(this.typeIndexes, catchHandler.typeIndexes);
            if (sArrCompare != 0) {
                return sArrCompare;
            }
            int sArrCompare2 = CompareUtils.sArrCompare(this.addresses, catchHandler.addresses);
            return sArrCompare2 != 0 ? sArrCompare2 : CompareUtils.sCompare(this.catchAllAddress, catchHandler.catchAllAddress);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/Code$Try.class */
    public static class Try implements Comparable<Try> {
        public int catchHandlerIndex;
        public int instructionCount;
        public int startAddress;

        public Try(int i, int i2, int i3) {
            this.startAddress = i;
            this.instructionCount = i2;
            this.catchHandlerIndex = i3;
        }

        @Override // java.lang.Comparable
        public int compareTo(Try r4) {
            int sCompare = CompareUtils.sCompare(this.startAddress, r4.startAddress);
            if (sCompare != 0) {
                return sCompare;
            }
            int sCompare2 = CompareUtils.sCompare(this.instructionCount, r4.instructionCount);
            return sCompare2 != 0 ? sCompare2 : CompareUtils.sCompare(this.catchHandlerIndex, r4.catchHandlerIndex);
        }
    }

    public Code(int i, int i2, int i3, int i4, int i5, short[] sArr, Try[] tryArr, CatchHandler[] catchHandlerArr) {
        super(i);
        this.registersSize = i2;
        this.insSize = i3;
        this.outsSize = i4;
        this.debugInfoOffset = i5;
        this.instructions = sArr;
        this.tries = tryArr;
        this.catchHandlers = catchHandlerArr;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        int length = this.instructions.length;
        int i = (length * 2) + 16;
        int i2 = i;
        if (this.tries.length > 0) {
            int i3 = i;
            if ((length & 1) == 1) {
                i3 = i + 2;
            }
            int length2 = i3 + (this.tries.length * 8) + Leb128.unsignedLeb128Size(this.catchHandlers.length);
            CatchHandler[] catchHandlerArr = this.catchHandlers;
            int length3 = catchHandlerArr.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                i2 = length2;
                if (i5 >= length3) {
                    break;
                }
                CatchHandler catchHandler = catchHandlerArr[i5];
                int length4 = catchHandler.typeIndexes.length;
                length2 += catchHandler.catchAllAddress != -1 ? Leb128.signedLeb128Size(-length4) + Leb128.unsignedLeb128Size(catchHandler.catchAllAddress) : Leb128.signedLeb128Size(length4);
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 < length4) {
                        length2 += Leb128.unsignedLeb128Size(catchHandler.typeIndexes[i7]) + Leb128.unsignedLeb128Size(catchHandler.addresses[i7]);
                        i6 = i7 + 1;
                    }
                }
                i4 = i5 + 1;
            }
        }
        return i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Code code) {
        int sCompare = CompareUtils.sCompare(this.registersSize, code.registersSize);
        if (sCompare != 0) {
            return sCompare;
        }
        int sCompare2 = CompareUtils.sCompare(this.insSize, code.insSize);
        if (sCompare2 != 0) {
            return sCompare2;
        }
        int sCompare3 = CompareUtils.sCompare(this.outsSize, code.outsSize);
        if (sCompare3 != 0) {
            return sCompare3;
        }
        int sCompare4 = CompareUtils.sCompare(this.debugInfoOffset, code.debugInfoOffset);
        if (sCompare4 != 0) {
            return sCompare4;
        }
        int uArrCompare = CompareUtils.uArrCompare(this.instructions, code.instructions);
        if (uArrCompare != 0) {
            return uArrCompare;
        }
        int aArrCompare = CompareUtils.aArrCompare(this.tries, code.tries);
        return aArrCompare != 0 ? aArrCompare : CompareUtils.aArrCompare(this.catchHandlers, code.catchHandlers);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof Code) {
            if (compareTo((Code) obj) == 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Integer.valueOf(this.registersSize), Integer.valueOf(this.insSize), Integer.valueOf(this.outsSize), Integer.valueOf(this.debugInfoOffset), this.instructions, this.tries, this.catchHandlers);
    }
}
