package com.bytedance.pangle.res.a;

import java.io.DataInput;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/f.class */
public abstract class f implements DataInput {

    /* renamed from: a  reason: collision with root package name */
    public final i f21480a;

    public f(i iVar) {
        this.f21480a = iVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.f21480a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.f21480a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.f21480a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.f21480a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.f21480a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        this.f21480a.readFully(bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        this.f21480a.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.f21480a.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.f21480a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.f21480a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.f21480a.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.f21480a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.f21480a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.f21480a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return this.f21480a.skipBytes(i);
    }
}
