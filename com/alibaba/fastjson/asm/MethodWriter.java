package com.alibaba.fastjson.asm;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/asm/MethodWriter.class */
public class MethodWriter implements MethodVisitor {
    private int access;
    private ByteVector code = new ByteVector();
    final ClassWriter cw;
    private final int desc;
    int exceptionCount;
    int[] exceptions;
    private int maxLocals;
    private int maxStack;
    private final int name;
    MethodWriter next;

    public MethodWriter(ClassWriter classWriter, int i, String str, String str2, String str3, String[] strArr) {
        if (classWriter.firstMethod == null) {
            classWriter.firstMethod = this;
        } else {
            classWriter.lastMethod.next = this;
        }
        classWriter.lastMethod = this;
        this.cw = classWriter;
        this.access = i;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.exceptionCount = length;
        this.exceptions = new int[length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.exceptionCount) {
                return;
            }
            this.exceptions[i3] = classWriter.newClassItem(strArr[i3]).index;
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getSize() {
        int i;
        if (this.code.length > 0) {
            this.cw.newUTF8("Code");
            i = this.code.length + 18 + 0 + 8;
        } else {
            i = 8;
        }
        int i2 = i;
        if (this.exceptionCount > 0) {
            this.cw.newUTF8("Exceptions");
            i2 = i + (this.exceptionCount * 2) + 8;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(ByteVector byteVector) {
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        int i = this.code.length > 0 ? 1 : 0;
        int i2 = i;
        if (this.exceptionCount > 0) {
            i2 = i + 1;
        }
        byteVector.putShort(i2);
        if (this.code.length > 0) {
            byteVector.putShort(this.cw.newUTF8("Code")).putInt(this.code.length + 12 + 0);
            byteVector.putShort(this.maxStack).putShort(this.maxLocals);
            byteVector.putInt(this.code.length).putByteArray(this.code.data, 0, this.code.length);
            byteVector.putShort(0);
            byteVector.putShort(0);
        }
        if (this.exceptionCount <= 0) {
            return;
        }
        byteVector.putShort(this.cw.newUTF8("Exceptions")).putInt((this.exceptionCount * 2) + 2);
        byteVector.putShort(this.exceptionCount);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.exceptionCount) {
                return;
            }
            byteVector.putShort(this.exceptions[i4]);
            i3 = i4 + 1;
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitEnd() {
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitFieldInsn(int i, String str, String str2, String str3) {
        this.code.put12(i, this.cw.newFieldItem(str, str2, str3).index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIincInsn(int i, int i2) {
        this.code.putByte(132).put11(i, i2);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitInsn(int i) {
        this.code.putByte(i);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIntInsn(int i, int i2) {
        this.code.put11(i, i2);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitJumpInsn(int i, Label label) {
        if ((label.status & 2) != 0 && label.position - this.code.length < -32768) {
            throw new UnsupportedOperationException();
        }
        this.code.putByte(i);
        ByteVector byteVector = this.code;
        label.put(this, byteVector, byteVector.length - 1);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLabel(Label label) {
        label.resolve(this, this.code.length, this.code.data);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLdcInsn(Object obj) {
        Item newConstItem = this.cw.newConstItem(obj);
        int i = newConstItem.index;
        if (newConstItem.type == 5 || newConstItem.type == 6) {
            this.code.put12(20, i);
        } else if (i >= 256) {
            this.code.put12(19, i);
        } else {
            this.code.put11(18, i);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMaxs(int i, int i2) {
        this.maxStack = i;
        this.maxLocals = i2;
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMethodInsn(int i, String str, String str2, String str3) {
        boolean z = i == 185;
        Item newMethodItem = this.cw.newMethodItem(str, str2, str3, z);
        int i2 = newMethodItem.intVal;
        if (!z) {
            this.code.put12(i, newMethodItem.index);
            return;
        }
        int i3 = i2;
        if (i2 == 0) {
            i3 = Type.getArgumentsAndReturnSizes(str3);
            newMethodItem.intVal = i3;
        }
        this.code.put12(185, newMethodItem.index).put11(i3 >> 2, 0);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitTypeInsn(int i, String str) {
        this.code.put12(i, this.cw.newClassItem(str).index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitVarInsn(int i, int i2) {
        if (i2 < 4 && i != 169) {
            this.code.putByte((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        } else if (i2 >= 256) {
            this.code.putByte(196).put12(i, i2);
        } else {
            this.code.put11(i, i2);
        }
    }
}
