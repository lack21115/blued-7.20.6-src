package com.tencent.tmsbeacon.pack;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/pack/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, byte[]> f39605a;
    public final RequestPacket b = new RequestPacket();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, byte[]> f39606c = new HashMap<>();
    public String d = "GBK";
    public a e = new a();

    static {
        HashMap<String, byte[]> hashMap = new HashMap<>();
        f39605a = hashMap;
        hashMap.put("", new byte[0]);
    }

    private Object a(byte[] bArr, Object obj) {
        this.e.a(bArr);
        this.e.a(this.d);
        return this.e.a((a) obj, 0, true);
    }

    private byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy((Object) byteBuffer.array(), 0, (Object) bArr, 0, position);
        return bArr;
    }

    private void b() {
        a aVar = new a(this.b.sBuffer);
        aVar.a(this.d);
        this.f39606c = aVar.a((Map) f39605a, 0, false);
    }

    public <T> T a(String str, T t) throws Exception {
        if (this.f39606c.containsKey(str)) {
            try {
                return (T) a(this.f39606c.get(str), t);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
        return null;
    }

    public void a(int i) {
        this.b.iRequestId = i;
    }

    public void a(String str) {
        this.b.sFuncName = str;
    }

    public void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            a aVar = new a(bArr, 4);
            aVar.a(this.d);
            this.b.readFrom(aVar);
            b();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] a() {
        b bVar = new b(0);
        bVar.a(this.d);
        bVar.a((Map) this.f39606c, 0);
        RequestPacket requestPacket = this.b;
        requestPacket.iVersion = (short) 3;
        requestPacket.sBuffer = a(bVar.a());
        b bVar2 = new b(0);
        bVar2.a(this.d);
        this.b.writeTo(bVar2);
        byte[] a2 = a(bVar2.a());
        int length = a2.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a2).flip();
        return allocate.array();
    }

    public void b(String str) {
        this.b.sServantName = str;
    }

    public <T> void b(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        b bVar = new b();
        bVar.a(this.d);
        bVar.a(t, 0);
        this.f39606c.put(str, a(bVar.a()));
    }
}
