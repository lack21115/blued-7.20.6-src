package com.tencent.tinker.commons.dexpatcher.util;

import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dx.instruction.InstructionPromoter;
import com.tencent.tinker.android.dx.instruction.InstructionReader;
import com.tencent.tinker.android.dx.instruction.InstructionVisitor;
import com.tencent.tinker.android.dx.instruction.InstructionWriter;
import com.tencent.tinker.android.dx.instruction.ShortArrayCodeInput;
import com.tencent.tinker.android.dx.instruction.ShortArrayCodeOutput;
import java.io.EOFException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/util/InstructionTransformer.class */
public final class InstructionTransformer {
    private final AbstractIndexMap indexMap;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/util/InstructionTransformer$InstructionTransformVisitor.class */
    final class InstructionTransformVisitor extends InstructionVisitor {
        InstructionTransformVisitor(InstructionVisitor instructionVisitor) {
            super(instructionVisitor);
        }

        private int transformIndexIfNeeded(int i, int i2) {
            return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i : InstructionTransformer.this.indexMap.adjustFieldIdIndex(i) : InstructionTransformer.this.indexMap.adjustMethodIdIndex(i) : InstructionTransformer.this.indexMap.adjustStringIndex(i) : InstructionTransformer.this.indexMap.adjustTypeIdIndex(i);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
            super.visitFiveRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6, i7, i8, i9, i10);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
            super.visitFourRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6, i7, i8, i9);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitOneRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6) {
            super.visitOneRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.visitRegisterRangeInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6, i7);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitThreeRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
            super.visitThreeRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6, i7, i8);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitTwoRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.visitTwoRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6, i7);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
            super.visitZeroRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j);
        }
    }

    public InstructionTransformer(AbstractIndexMap abstractIndexMap) {
        this.indexMap = abstractIndexMap;
    }

    public short[] transform(short[] sArr) throws DexException {
        ShortArrayCodeOutput shortArrayCodeOutput = new ShortArrayCodeOutput(sArr.length);
        InstructionPromoter instructionPromoter = new InstructionPromoter();
        InstructionWriter instructionWriter = new InstructionWriter(shortArrayCodeOutput, instructionPromoter);
        InstructionReader instructionReader = new InstructionReader(new ShortArrayCodeInput(sArr));
        try {
            instructionReader.accept(new InstructionTransformVisitor(instructionPromoter));
            instructionReader.accept(new InstructionTransformVisitor(instructionWriter));
            return shortArrayCodeOutput.getArray();
        } catch (EOFException e) {
            throw new DexException(e);
        }
    }
}
