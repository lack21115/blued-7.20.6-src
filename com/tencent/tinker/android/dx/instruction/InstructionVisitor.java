package com.tencent.tinker.android.dx.instruction;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/InstructionVisitor.class */
public class InstructionVisitor {
    private final InstructionVisitor prevIv;

    public InstructionVisitor(InstructionVisitor instructionVisitor) {
        this.prevIv = instructionVisitor;
    }

    public void visitFillArrayDataPayloadInsn(int i, int i2, Object obj, int i3, int i4) {
        InstructionVisitor instructionVisitor = this.prevIv;
        if (instructionVisitor != null) {
            instructionVisitor.visitFillArrayDataPayloadInsn(i, i2, obj, i3, i4);
        }
    }

    public void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        InstructionVisitor instructionVisitor = this.prevIv;
        if (instructionVisitor != null) {
            instructionVisitor.visitFiveRegisterInsn(i, i2, i3, i4, i5, j, i6, i7, i8, i9, i10);
        }
    }

    public void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        InstructionVisitor instructionVisitor = this.prevIv;
        if (instructionVisitor != null) {
            instructionVisitor.visitFourRegisterInsn(i, i2, i3, i4, i5, j, i6, i7, i8, i9);
        }
    }

    public void visitOneRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        InstructionVisitor instructionVisitor = this.prevIv;
        if (instructionVisitor != null) {
            instructionVisitor.visitOneRegisterInsn(i, i2, i3, i4, i5, j, i6);
        }
    }

    public void visitPackedSwitchPayloadInsn(int i, int i2, int i3, int[] iArr) {
        InstructionVisitor instructionVisitor = this.prevIv;
        if (instructionVisitor != null) {
            instructionVisitor.visitPackedSwitchPayloadInsn(i, i2, i3, iArr);
        }
    }

    public void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        InstructionVisitor instructionVisitor = this.prevIv;
        if (instructionVisitor != null) {
            instructionVisitor.visitRegisterRangeInsn(i, i2, i3, i4, i5, j, i6, i7);
        }
    }

    public void visitSparseSwitchPayloadInsn(int i, int i2, int[] iArr, int[] iArr2) {
        InstructionVisitor instructionVisitor = this.prevIv;
        if (instructionVisitor != null) {
            instructionVisitor.visitSparseSwitchPayloadInsn(i, i2, iArr, iArr2);
        }
    }

    public void visitThreeRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        InstructionVisitor instructionVisitor = this.prevIv;
        if (instructionVisitor != null) {
            instructionVisitor.visitThreeRegisterInsn(i, i2, i3, i4, i5, j, i6, i7, i8);
        }
    }

    public void visitTwoRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        InstructionVisitor instructionVisitor = this.prevIv;
        if (instructionVisitor != null) {
            instructionVisitor.visitTwoRegisterInsn(i, i2, i3, i4, i5, j, i6, i7);
        }
    }

    public void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
        InstructionVisitor instructionVisitor = this.prevIv;
        if (instructionVisitor != null) {
            instructionVisitor.visitZeroRegisterInsn(i, i2, i3, i4, i5, j);
        }
    }
}
