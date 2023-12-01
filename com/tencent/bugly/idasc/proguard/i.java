package com.tencent.bugly.idasc.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f21631a;
    private int b;

    public i(StringBuilder sb, int i) {
        this.b = 0;
        this.f21631a = sb;
        this.b = i;
    }

    private i a(char c2, String str) {
        a(str);
        StringBuilder sb = this.f21631a;
        sb.append(c2);
        sb.append('\n');
        return this;
    }

    private i a(double d, String str) {
        a(str);
        StringBuilder sb = this.f21631a;
        sb.append(d);
        sb.append('\n');
        return this;
    }

    private i a(float f, String str) {
        a(str);
        StringBuilder sb = this.f21631a;
        sb.append(f);
        sb.append('\n');
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(T t, String str) {
        if (t == null) {
            this.f21631a.append("null\n");
            return this;
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), str);
            return this;
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), str);
            return this;
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), str);
            return this;
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), str);
            return this;
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), str);
            return this;
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), str);
            return this;
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), str);
            return this;
        } else if (t instanceof String) {
            a((String) t, str);
            return this;
        } else if (t instanceof Map) {
            a((Map) t, str);
            return this;
        } else if (t instanceof List) {
            a((Collection) ((List) t), str);
            return this;
        } else if (t instanceof m) {
            a((m) t, str);
            return this;
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
            return this;
        } else if (t instanceof boolean[]) {
            a((i) ((boolean[]) t), str);
            return this;
        } else if (t instanceof short[]) {
            a((short[]) t, str);
            return this;
        } else if (t instanceof int[]) {
            a((int[]) t, str);
            return this;
        } else if (t instanceof long[]) {
            a((long[]) t, str);
            return this;
        } else if (t instanceof float[]) {
            a((float[]) t, str);
            return this;
        } else if (t instanceof double[]) {
            a((double[]) t, str);
            return this;
        } else if (t.getClass().isArray()) {
            a((Object[]) t, str);
            return this;
        } else {
            throw new j("write object error: unsupport type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(Collection<T> collection, String str) {
        if (collection == null) {
            a(str);
            this.f21631a.append("null\t");
            return this;
        }
        return a(collection.toArray(), str);
    }

    private i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            this.f21631a.append("null\n");
            return this;
        } else if (dArr.length == 0) {
            StringBuilder sb = this.f21631a;
            sb.append(dArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f21631a;
            sb2.append(dArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f21631a, this.b + 1);
            int length = dArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                iVar.a(dArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    private i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            this.f21631a.append("null\n");
            return this;
        } else if (fArr.length == 0) {
            StringBuilder sb = this.f21631a;
            sb.append(fArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f21631a;
            sb2.append(fArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f21631a, this.b + 1);
            int length = fArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                iVar.a(fArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    private i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            this.f21631a.append("null\n");
            return this;
        } else if (iArr.length == 0) {
            StringBuilder sb = this.f21631a;
            sb.append(iArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f21631a;
            sb2.append(iArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f21631a, this.b + 1);
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                iVar.a(iArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    private i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            this.f21631a.append("null\n");
            return this;
        } else if (jArr.length == 0) {
            StringBuilder sb = this.f21631a;
            sb.append(jArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f21631a;
            sb2.append(jArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f21631a, this.b + 1);
            int length = jArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                iVar.a(jArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    private <T> i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.f21631a.append("null\n");
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb = this.f21631a;
            sb.append(tArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f21631a;
            sb2.append(tArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f21631a, this.b + 1);
            int length = tArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                iVar.a((i) tArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    private i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            this.f21631a.append("null\n");
            return this;
        } else if (sArr.length == 0) {
            StringBuilder sb = this.f21631a;
            sb.append(sArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f21631a;
            sb2.append(sArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f21631a, this.b + 1);
            int length = sArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                iVar.a(sArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    private void a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b) {
                break;
            }
            this.f21631a.append('\t');
            i = i2 + 1;
        }
        if (str != null) {
            StringBuilder sb = this.f21631a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public final i a(byte b, String str) {
        a(str);
        StringBuilder sb = this.f21631a;
        sb.append((int) b);
        sb.append('\n');
        return this;
    }

    public final i a(int i, String str) {
        a(str);
        StringBuilder sb = this.f21631a;
        sb.append(i);
        sb.append('\n');
        return this;
    }

    public final i a(long j, String str) {
        a(str);
        StringBuilder sb = this.f21631a;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    public final i a(m mVar, String str) {
        a('{', str);
        if (mVar == null) {
            StringBuilder sb = this.f21631a;
            sb.append('\t');
            sb.append(com.igexin.push.core.b.l);
        } else {
            mVar.a(this.f21631a, this.b + 1);
        }
        a('}', (String) null);
        return this;
    }

    public final i a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.f21631a.append("null\n");
            return this;
        }
        StringBuilder sb = this.f21631a;
        sb.append(str);
        sb.append('\n');
        return this;
    }

    public final <K, V> i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.f21631a.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb = this.f21631a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        } else {
            StringBuilder sb2 = this.f21631a;
            sb2.append(map.size());
            sb2.append(", {\n");
            i iVar = new i(this.f21631a, this.b + 1);
            i iVar2 = new i(this.f21631a, this.b + 2);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                iVar.a('(', (String) null);
                iVar2.a((i) entry.getKey(), (String) null);
                iVar2.a((i) entry.getValue(), (String) null);
                iVar.a(')', (String) null);
            }
            a('}', (String) null);
            return this;
        }
    }

    public final i a(short s, String str) {
        a(str);
        StringBuilder sb = this.f21631a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public final i a(boolean z, String str) {
        a(str);
        StringBuilder sb = this.f21631a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public final i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.f21631a.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb = this.f21631a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f21631a;
            sb2.append(bArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f21631a, this.b + 1);
            int length = bArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                iVar.a(bArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }
}
