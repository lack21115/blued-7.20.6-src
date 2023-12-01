package com.anythink.expressad.exoplayer.j.a;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/l.class */
public final class l implements i {
    public static final l b = new l(Collections.emptyMap());

    /* renamed from: c  reason: collision with root package name */
    private static final int f7570c = 10485760;
    private int d;
    private final Map<String, byte[]> e;

    private l(Map<String, byte[]> map) {
        this.e = Collections.unmodifiableMap(map);
    }

    public static l a(DataInputStream dataInputStream) {
        int readInt;
        int readInt2 = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt2) {
                return new l(hashMap);
            }
            String readUTF = dataInputStream.readUTF();
            readInt = dataInputStream.readInt();
            if (readInt < 0 || readInt > f7570c) {
                break;
            }
            byte[] bArr = new byte[readInt];
            dataInputStream.readFully(bArr);
            hashMap.put(readUTF, bArr);
            i = i2 + 1;
        }
        throw new IOException("Invalid value size: ".concat(String.valueOf(readInt)));
    }

    private static Map<String, byte[]> a(Map<String, byte[]> map, k kVar) {
        HashMap hashMap = new HashMap(map);
        a(hashMap, kVar.a());
        a(hashMap, kVar.b());
        return hashMap;
    }

    private static void a(HashMap<String, byte[]> hashMap, List<String> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            hashMap.remove(list.get(i2));
            i = i2 + 1;
        }
    }

    private static void a(HashMap<String, byte[]> hashMap, Map<String, Object> map) {
        byte[] bArr;
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof Long) {
                bArr = ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
            } else if (obj instanceof String) {
                bArr = ((String) obj).getBytes(Charset.forName("UTF-8"));
            } else if (!(obj instanceof byte[])) {
                throw new IllegalArgumentException();
            } else {
                bArr = (byte[]) obj;
            }
            if (bArr.length > f7570c) {
                throw new IllegalArgumentException(String.format("The size of %s (%d) is greater than maximum allowed: %d", str, Integer.valueOf(bArr.length), Integer.valueOf((int) f7570c)));
            }
            hashMap.put(str, bArr);
        }
    }

    private boolean a(Map<String, byte[]> map) {
        if (this.e.size() != map.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : this.e.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static byte[] a(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(Charset.forName("UTF-8"));
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final long a(String str) {
        if (this.e.containsKey(str)) {
            return ByteBuffer.wrap(this.e.get(str)).getLong();
        }
        return -1L;
    }

    public final l a(k kVar) {
        HashMap hashMap = new HashMap(this.e);
        a(hashMap, kVar.a());
        a(hashMap, kVar.b());
        return a((Map<String, byte[]>) hashMap) ? this : new l(hashMap);
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final String a(String str, String str2) {
        if (this.e.containsKey(str)) {
            str2 = new String(this.e.get(str), Charset.forName("UTF-8"));
        }
        return str2;
    }

    public final void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.e.size());
        for (Map.Entry<String, byte[]> entry : this.e.entrySet()) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final byte[] a(String str, byte[] bArr) {
        if (this.e.containsKey(str)) {
            byte[] bArr2 = this.e.get(str);
            return Arrays.copyOf(bArr2, bArr2.length);
        }
        return bArr;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final boolean b(String str) {
        return this.e.containsKey(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return a(((l) obj).e);
    }

    public final int hashCode() {
        if (this.d == 0) {
            int i = 0;
            for (Map.Entry<String, byte[]> entry : this.e.entrySet()) {
                i += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.d = i;
        }
        return this.d;
    }
}
