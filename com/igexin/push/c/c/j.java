package com.igexin.push.c.c;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c/j.class */
public final class j extends c {

    /* renamed from: a  reason: collision with root package name */
    public byte f9739a;
    public Object b;

    @Override // com.igexin.push.c.c.c
    public final void a(byte[] bArr) {
    }

    @Override // com.igexin.push.c.c.c
    public final byte[] b() {
        byte b = this.f9739a;
        byte[] bArr = null;
        byte[] bytes = (b == 1 || b == 2 || (b != 3 && (b == 4 || b == 5 || b == 6))) ? ((String) this.b).getBytes() : null;
        if (bytes != null) {
            bArr = new byte[bytes.length + 2];
            bArr[0] = this.f9739a;
            bArr[1] = (byte) bytes.length;
            System.arraycopy(bytes, 0, bArr, 2, bytes.length);
        }
        return bArr;
    }
}
