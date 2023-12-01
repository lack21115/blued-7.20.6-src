package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/w9.class */
public class w9 extends n9 {

    /* renamed from: a  reason: collision with root package name */
    public String f38090a;

    public w9() {
    }

    public w9(String str) {
        this.f38090a = str;
    }

    @Override // com.tencent.mapsdk.internal.n9
    public int a() {
        return b().length;
    }

    @Override // com.tencent.mapsdk.internal.n9
    public void a(byte[] bArr) {
        this.f38090a = new String(bArr);
    }

    @Override // com.tencent.mapsdk.internal.n9
    public byte[] b() {
        String str = this.f38090a;
        return str != null ? str.getBytes() : new byte[0];
    }

    public String toString() {
        return "StringData{strData='" + this.f38090a + "'}";
    }
}
