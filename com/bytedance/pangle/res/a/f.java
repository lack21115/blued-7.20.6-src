package com.bytedance.pangle.res.a;

import java.io.DataInput;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/f.class */
public abstract class f implements DataInput {

    /* renamed from: a  reason: collision with root package name */
    public final i f7874a;

    public f(i iVar) {
        this.f7874a = iVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.f7874a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.f7874a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.f7874a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.f7874a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.f7874a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        this.f7874a.readFully(bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        this.f7874a.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.f7874a.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.f7874a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.f7874a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.f7874a.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.f7874a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.f7874a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.f7874a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return this.f7874a.skipBytes(i);
    }
}
