package com.tencent.tinker.android.dx.instruction;

import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dx.util.Hex;
import java.io.EOFException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/InstructionComparator.class */
public abstract class InstructionComparator {
    private final InstructionHolder[] insnHolders1;
    private final InstructionHolder[] insnHolders2;
    private final short[] insns1;
    private final short[] insns2;
    private final Set<String> visitedInsnAddrPairs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/InstructionComparator$FillArrayDataPayloadInstructionHolder.class */
    public static class FillArrayDataPayloadInstructionHolder extends InstructionHolder {
        Object data;
        int elementWidth;
        int size;

        private FillArrayDataPayloadInstructionHolder() {
            super();
            this.data = null;
            this.size = 0;
            this.elementWidth = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/InstructionComparator$InstructionHolder.class */
    public static class InstructionHolder {

        /* renamed from: a  reason: collision with root package name */
        int f39455a;
        int address;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f39456c;
        int d;
        int e;
        int index;
        int insnFormat;
        long literal;
        int opcode;
        int registerCount;
        int target;

        private InstructionHolder() {
            this.insnFormat = 0;
            this.address = -1;
            this.opcode = -1;
            this.index = 0;
            this.target = 0;
            this.literal = 0L;
            this.registerCount = 0;
            this.f39455a = 0;
            this.b = 0;
            this.f39456c = 0;
            this.d = 0;
            this.e = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/InstructionComparator$PackedSwitchPayloadInsntructionHolder.class */
    public static class PackedSwitchPayloadInsntructionHolder extends InstructionHolder {
        int firstKey;
        int[] targets;

        private PackedSwitchPayloadInsntructionHolder() {
            super();
            this.firstKey = 0;
            this.targets = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/InstructionComparator$SparseSwitchPayloadInsntructionHolder.class */
    public static class SparseSwitchPayloadInsntructionHolder extends InstructionHolder {
        int[] keys;
        int[] targets;

        private SparseSwitchPayloadInsntructionHolder() {
            super();
            this.keys = null;
            this.targets = null;
        }
    }

    public InstructionComparator(short[] sArr, short[] sArr2) {
        this.insns1 = sArr;
        this.insns2 = sArr2;
        if (sArr != null) {
            this.insnHolders1 = readInstructionsIntoHolders(new ShortArrayCodeInput(sArr), sArr.length);
        } else {
            this.insnHolders1 = null;
        }
        if (sArr2 != null) {
            this.insnHolders2 = readInstructionsIntoHolders(new ShortArrayCodeInput(sArr2), sArr2.length);
        } else {
            this.insnHolders2 = null;
        }
        this.visitedInsnAddrPairs = new HashSet();
    }

    private boolean compareIndex(int i, int i2, int i3) {
        int instructionIndexType = InstructionCodec.getInstructionIndexType(i);
        return instructionIndexType != 2 ? instructionIndexType != 3 ? instructionIndexType != 4 ? instructionIndexType != 5 ? i2 == i3 : compareField(i2, i3) : compareMethod(i2, i3) : compareString(i2, i3) : compareType(i2, i3);
    }

    private int getPromotedOpCodeOnDemand(InstructionHolder instructionHolder) {
        int i = instructionHolder.opcode;
        if (i == 26 || i == 27) {
            return 27;
        }
        if (i == 40 || i == 41 || i == 42) {
            return 42;
        }
        return i;
    }

    private InstructionHolder[] readInstructionsIntoHolders(ShortArrayCodeInput shortArrayCodeInput, int i) {
        shortArrayCodeInput.reset();
        final InstructionHolder[] instructionHolderArr = new InstructionHolder[i];
        try {
            new InstructionReader(shortArrayCodeInput).accept(new InstructionVisitor(null) { // from class: com.tencent.tinker.android.dx.instruction.InstructionComparator.1
                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitFillArrayDataPayloadInsn(int i2, int i3, Object obj, int i4, int i5) {
                    FillArrayDataPayloadInstructionHolder fillArrayDataPayloadInstructionHolder = new FillArrayDataPayloadInstructionHolder();
                    fillArrayDataPayloadInstructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    fillArrayDataPayloadInstructionHolder.address = i2;
                    fillArrayDataPayloadInstructionHolder.opcode = i3;
                    fillArrayDataPayloadInstructionHolder.data = obj;
                    fillArrayDataPayloadInstructionHolder.size = i4;
                    fillArrayDataPayloadInstructionHolder.elementWidth = i5;
                    instructionHolderArr[i2] = fillArrayDataPayloadInstructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitFiveRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8, int i9, int i10, int i11) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = 5;
                    instructionHolder.f39455a = i7;
                    instructionHolder.b = i8;
                    instructionHolder.f39456c = i9;
                    instructionHolder.d = i10;
                    instructionHolder.e = i11;
                    instructionHolderArr[i2] = instructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitFourRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8, int i9, int i10) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = 4;
                    instructionHolder.f39455a = i7;
                    instructionHolder.b = i8;
                    instructionHolder.f39456c = i9;
                    instructionHolder.d = i10;
                    instructionHolderArr[i2] = instructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitOneRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = 1;
                    instructionHolder.f39455a = i7;
                    instructionHolderArr[i2] = instructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitPackedSwitchPayloadInsn(int i2, int i3, int i4, int[] iArr) {
                    PackedSwitchPayloadInsntructionHolder packedSwitchPayloadInsntructionHolder = new PackedSwitchPayloadInsntructionHolder();
                    packedSwitchPayloadInsntructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    packedSwitchPayloadInsntructionHolder.address = i2;
                    packedSwitchPayloadInsntructionHolder.opcode = i3;
                    packedSwitchPayloadInsntructionHolder.firstKey = i4;
                    packedSwitchPayloadInsntructionHolder.targets = iArr;
                    instructionHolderArr[i2] = packedSwitchPayloadInsntructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitRegisterRangeInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = i8;
                    instructionHolder.f39455a = i7;
                    instructionHolderArr[i2] = instructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitSparseSwitchPayloadInsn(int i2, int i3, int[] iArr, int[] iArr2) {
                    SparseSwitchPayloadInsntructionHolder sparseSwitchPayloadInsntructionHolder = new SparseSwitchPayloadInsntructionHolder();
                    sparseSwitchPayloadInsntructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    sparseSwitchPayloadInsntructionHolder.address = i2;
                    sparseSwitchPayloadInsntructionHolder.opcode = i3;
                    sparseSwitchPayloadInsntructionHolder.keys = iArr;
                    sparseSwitchPayloadInsntructionHolder.targets = iArr2;
                    instructionHolderArr[i2] = sparseSwitchPayloadInsntructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitThreeRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8, int i9) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = 3;
                    instructionHolder.f39455a = i7;
                    instructionHolder.b = i8;
                    instructionHolder.f39456c = i9;
                    instructionHolderArr[i2] = instructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitTwoRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = 2;
                    instructionHolder.f39455a = i7;
                    instructionHolder.b = i8;
                    instructionHolderArr[i2] = instructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitZeroRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j) {
                    if (i3 != 0) {
                        InstructionHolder instructionHolder = new InstructionHolder();
                        instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                        instructionHolder.address = i2;
                        instructionHolder.opcode = i3;
                        instructionHolder.index = i4;
                        instructionHolder.target = i6;
                        instructionHolder.literal = j;
                        instructionHolderArr[i2] = instructionHolder;
                    }
                }
            });
            return instructionHolderArr;
        } catch (EOFException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean compare() {
        InstructionHolder instructionHolder;
        InstructionHolder instructionHolder2;
        this.visitedInsnAddrPairs.clear();
        if (this.insnHolders1 == null && this.insnHolders2 == null) {
            return true;
        }
        if (this.insnHolders1 == null || this.insnHolders2 == null) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        do {
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            if (i < this.insnHolders1.length) {
                i5 = i;
                i6 = i2;
                i7 = i3;
                if (i2 < this.insnHolders2.length) {
                    instructionHolder = null;
                    instructionHolder2 = null;
                    while (true) {
                        InstructionHolder[] instructionHolderArr = this.insnHolders1;
                        if (i >= instructionHolderArr.length || instructionHolder2 != null) {
                            break;
                        }
                        instructionHolder2 = instructionHolderArr[i];
                        i++;
                    }
                    i5 = i;
                    i6 = i2;
                    i7 = i3;
                    if (instructionHolder2 != null) {
                        i3++;
                        while (true) {
                            InstructionHolder[] instructionHolderArr2 = this.insnHolders2;
                            if (i2 >= instructionHolderArr2.length || instructionHolder != null) {
                                break;
                            }
                            instructionHolder = instructionHolderArr2[i2];
                            i2++;
                        }
                        i5 = i;
                        i6 = i2;
                        i7 = i3;
                        if (instructionHolder != null) {
                            i4++;
                        }
                    }
                }
            }
            while (true) {
                InstructionHolder[] instructionHolderArr3 = this.insnHolders1;
                int i8 = i6;
                if (i5 >= instructionHolderArr3.length) {
                    while (true) {
                        InstructionHolder[] instructionHolderArr4 = this.insnHolders2;
                        if (i8 >= instructionHolderArr4.length) {
                            return i7 == i4;
                        } else if (instructionHolderArr4[i8] != null) {
                            return false;
                        } else {
                            i8++;
                        }
                    }
                } else if (instructionHolderArr3[i5] != null) {
                    return false;
                } else {
                    i5++;
                }
            }
        } while (isSameInstruction(instructionHolder2, instructionHolder));
        return false;
    }

    protected abstract boolean compareField(int i, int i2);

    protected abstract boolean compareMethod(int i, int i2);

    protected abstract boolean compareString(int i, int i2);

    protected abstract boolean compareType(int i, int i2);

    public boolean isSameInstruction(int i, int i2) {
        return isSameInstruction(this.insnHolders1[i], this.insnHolders2[i2]);
    }

    public boolean isSameInstruction(InstructionHolder instructionHolder, InstructionHolder instructionHolder2) {
        if (instructionHolder == null && instructionHolder2 == null) {
            return true;
        }
        if (instructionHolder == null || instructionHolder2 == null || getPromotedOpCodeOnDemand(instructionHolder) != getPromotedOpCodeOnDemand(instructionHolder2)) {
            return false;
        }
        int i = instructionHolder.opcode;
        int i2 = instructionHolder.insnFormat;
        if (i2 != 2 && i2 != 11) {
            if (i2 != 13) {
                if (i2 != 15 && i2 != 21 && i2 != 7) {
                    if (i2 != 8) {
                        if (i2 != 18) {
                            if (i2 != 19 && i2 != 23 && i2 != 24) {
                                switch (i2) {
                                    case 26:
                                        FillArrayDataPayloadInstructionHolder fillArrayDataPayloadInstructionHolder = (FillArrayDataPayloadInstructionHolder) instructionHolder;
                                        FillArrayDataPayloadInstructionHolder fillArrayDataPayloadInstructionHolder2 = (FillArrayDataPayloadInstructionHolder) instructionHolder2;
                                        if (fillArrayDataPayloadInstructionHolder.elementWidth == fillArrayDataPayloadInstructionHolder2.elementWidth && fillArrayDataPayloadInstructionHolder.size == fillArrayDataPayloadInstructionHolder2.size) {
                                            int i3 = fillArrayDataPayloadInstructionHolder.elementWidth;
                                            if (i3 == 1) {
                                                return CompareUtils.uArrCompare((byte[]) fillArrayDataPayloadInstructionHolder.data, (byte[]) fillArrayDataPayloadInstructionHolder2.data) == 0;
                                            } else if (i3 == 2) {
                                                return CompareUtils.uArrCompare((short[]) fillArrayDataPayloadInstructionHolder.data, (short[]) fillArrayDataPayloadInstructionHolder2.data) == 0;
                                            } else if (i3 == 4) {
                                                return CompareUtils.uArrCompare((int[]) fillArrayDataPayloadInstructionHolder.data, (int[]) fillArrayDataPayloadInstructionHolder2.data) == 0;
                                            } else if (i3 == 8) {
                                                return CompareUtils.sArrCompare((long[]) fillArrayDataPayloadInstructionHolder.data, (long[]) fillArrayDataPayloadInstructionHolder2.data) == 0;
                                            } else {
                                                throw new DexException("bogus element_width: " + Hex.u2(i3));
                                            }
                                        }
                                        return false;
                                    case 27:
                                        PackedSwitchPayloadInsntructionHolder packedSwitchPayloadInsntructionHolder = (PackedSwitchPayloadInsntructionHolder) instructionHolder;
                                        PackedSwitchPayloadInsntructionHolder packedSwitchPayloadInsntructionHolder2 = (PackedSwitchPayloadInsntructionHolder) instructionHolder2;
                                        if (packedSwitchPayloadInsntructionHolder.firstKey != packedSwitchPayloadInsntructionHolder2.firstKey || packedSwitchPayloadInsntructionHolder.targets.length != packedSwitchPayloadInsntructionHolder2.targets.length) {
                                            return false;
                                        }
                                        int length = packedSwitchPayloadInsntructionHolder.targets.length;
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            if (i5 >= length) {
                                                return true;
                                            }
                                            if (!isSameInstruction(packedSwitchPayloadInsntructionHolder.targets[i5], packedSwitchPayloadInsntructionHolder2.targets[i5])) {
                                                return false;
                                            }
                                            i4 = i5 + 1;
                                        }
                                        break;
                                    case 28:
                                        SparseSwitchPayloadInsntructionHolder sparseSwitchPayloadInsntructionHolder = (SparseSwitchPayloadInsntructionHolder) instructionHolder;
                                        SparseSwitchPayloadInsntructionHolder sparseSwitchPayloadInsntructionHolder2 = (SparseSwitchPayloadInsntructionHolder) instructionHolder2;
                                        if (CompareUtils.uArrCompare(sparseSwitchPayloadInsntructionHolder.keys, sparseSwitchPayloadInsntructionHolder2.keys) != 0 || sparseSwitchPayloadInsntructionHolder.targets.length != sparseSwitchPayloadInsntructionHolder2.targets.length) {
                                            return false;
                                        }
                                        int length2 = sparseSwitchPayloadInsntructionHolder.targets.length;
                                        int i6 = 0;
                                        while (true) {
                                            int i7 = i6;
                                            if (i7 >= length2) {
                                                return true;
                                            }
                                            if (!isSameInstruction(sparseSwitchPayloadInsntructionHolder.targets[i7], sparseSwitchPayloadInsntructionHolder2.targets[i7])) {
                                                return false;
                                            }
                                            i6 = i7 + 1;
                                        }
                                        break;
                                    default:
                                        return instructionHolder.literal == instructionHolder2.literal && instructionHolder.registerCount == instructionHolder2.registerCount && instructionHolder.f39455a == instructionHolder2.f39455a && instructionHolder.b == instructionHolder2.b && instructionHolder.f39456c == instructionHolder2.f39456c && instructionHolder.d == instructionHolder2.d && instructionHolder.e == instructionHolder2.e;
                                }
                            }
                        }
                    }
                }
            }
            return compareIndex(i, instructionHolder.index, instructionHolder2.index);
        }
        if (this.visitedInsnAddrPairs.add(instructionHolder.address + "-" + instructionHolder2.address)) {
            return isSameInstruction(instructionHolder.target, instructionHolder2.target);
        }
        return true;
    }
}
