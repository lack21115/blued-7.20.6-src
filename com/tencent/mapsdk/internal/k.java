package com.tencent.mapsdk.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f37580a;
    private int b;

    public k(StringBuilder sb) {
        this.b = 0;
        this.f37580a = sb;
    }

    public k(StringBuilder sb, int i) {
        this.b = 0;
        this.f37580a = sb;
        this.b = i;
    }

    private void a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b) {
                break;
            }
            this.f37580a.append('\t');
            i = i2 + 1;
        }
        if (str != null) {
            StringBuilder sb = this.f37580a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public k a(byte b, String str) {
        a(str);
        StringBuilder sb = this.f37580a;
        sb.append((int) b);
        sb.append('\n');
        return this;
    }

    public k a(byte b, boolean z) {
        this.f37580a.append((int) b);
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(char c2, String str) {
        a(str);
        StringBuilder sb = this.f37580a;
        sb.append(c2);
        sb.append('\n');
        return this;
    }

    public k a(char c2, boolean z) {
        this.f37580a.append(c2);
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(double d, String str) {
        a(str);
        StringBuilder sb = this.f37580a;
        sb.append(d);
        sb.append('\n');
        return this;
    }

    public k a(double d, boolean z) {
        this.f37580a.append(d);
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(float f, String str) {
        a(str);
        StringBuilder sb = this.f37580a;
        sb.append(f);
        sb.append('\n');
        return this;
    }

    public k a(float f, boolean z) {
        this.f37580a.append(f);
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(int i, String str) {
        a(str);
        StringBuilder sb = this.f37580a;
        sb.append(i);
        sb.append('\n');
        return this;
    }

    public k a(int i, boolean z) {
        this.f37580a.append(i);
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(long j, String str) {
        a(str);
        StringBuilder sb = this.f37580a;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    public k a(long j, boolean z) {
        this.f37580a.append(j);
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(p pVar, String str) {
        a('{', str);
        if (pVar == null) {
            StringBuilder sb = this.f37580a;
            sb.append('\t');
            sb.append(com.igexin.push.core.b.l);
        } else {
            pVar.display(this.f37580a, this.b + 1);
        }
        a('}', (String) null);
        return this;
    }

    public k a(p pVar, boolean z) {
        this.f37580a.append("{");
        if (pVar == null) {
            StringBuilder sb = this.f37580a;
            sb.append('\t');
            sb.append(com.igexin.push.core.b.l);
        } else {
            pVar.displaySimple(this.f37580a, this.b + 1);
        }
        this.f37580a.append(com.alipay.sdk.util.i.d);
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> k a(T t, String str) {
        if (t == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
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
        } else if (t instanceof p) {
            a((p) t, str);
            return this;
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
            return this;
        } else if (t instanceof boolean[]) {
            a((k) ((boolean[]) t), str);
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
            throw new l("write object error: unsupport type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> k a(T t, boolean z) {
        if (t == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
            return this;
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), z);
            return this;
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), z);
            return this;
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), z);
            return this;
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), z);
            return this;
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), z);
            return this;
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), z);
            return this;
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), z);
            return this;
        } else if (t instanceof String) {
            a((String) t, z);
            return this;
        } else if (t instanceof Map) {
            a((Map) t, z);
            return this;
        } else if (t instanceof List) {
            a((Collection) ((List) t), z);
            return this;
        } else if (t instanceof p) {
            a((p) t, z);
            return this;
        } else if (t instanceof byte[]) {
            a((byte[]) t, z);
            return this;
        } else if (t instanceof boolean[]) {
            a((k) ((boolean[]) t), z);
            return this;
        } else if (t instanceof short[]) {
            a((short[]) t, z);
            return this;
        } else if (t instanceof int[]) {
            a((int[]) t, z);
            return this;
        } else if (t instanceof long[]) {
            a((long[]) t, z);
            return this;
        } else if (t instanceof float[]) {
            a((float[]) t, z);
            return this;
        } else if (t instanceof double[]) {
            a((double[]) t, z);
            return this;
        } else if (t.getClass().isArray()) {
            a((Object[]) t, z);
            return this;
        } else {
            throw new l("write object error: unsupport type.");
        }
    }

    public k a(String str, String str2) {
        a(str2);
        if (str == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
            return this;
        }
        StringBuilder sb2 = this.f37580a;
        sb2.append(str);
        sb2.append('\n');
        return this;
    }

    public k a(String str, boolean z) {
        if (str == null) {
            this.f37580a.append(com.igexin.push.core.b.l);
        } else {
            this.f37580a.append(str);
        }
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> k a(Collection<T> collection, String str) {
        if (collection == null) {
            a(str);
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\t');
            return this;
        }
        return a(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> k a(Collection<T> collection, boolean z) {
        if (collection == null) {
            this.f37580a.append("[]");
            if (z) {
                this.f37580a.append("|");
            }
            return this;
        }
        return a(collection.toArray(), z);
    }

    public <K, V> k a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb2 = this.f37580a;
            sb2.append(map.size());
            sb2.append(", {}");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f37580a;
            sb3.append(map.size());
            sb3.append(", {");
            sb3.append('\n');
            k kVar = new k(this.f37580a, this.b + 1);
            k kVar2 = new k(this.f37580a, this.b + 2);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                kVar.a('(', (String) null);
                kVar2.a((k) entry.getKey(), (String) null);
                kVar2.a((k) entry.getValue(), (String) null);
                kVar.a(')', (String) null);
            }
            a('}', (String) null);
            return this;
        }
    }

    public <K, V> k a(Map<K, V> map, boolean z) {
        if (map == null || map.isEmpty()) {
            this.f37580a.append("{}");
            if (z) {
                this.f37580a.append("|");
            }
            return this;
        }
        this.f37580a.append("{");
        k kVar = new k(this.f37580a, this.b + 2);
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        boolean z2 = true;
        while (true) {
            boolean z3 = z2;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<K, V> next = it.next();
            if (!z3) {
                this.f37580a.append(",");
            }
            kVar.a((k) next.getKey(), true);
            kVar.a((k) next.getValue(), false);
            z2 = false;
        }
        this.f37580a.append(com.alipay.sdk.util.i.d);
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(short s, String str) {
        a(str);
        StringBuilder sb = this.f37580a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public k a(short s, boolean z) {
        this.f37580a.append((int) s);
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(boolean z, String str) {
        a(str);
        StringBuilder sb = this.f37580a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public k a(boolean z, boolean z2) {
        this.f37580a.append(z ? 'T' : 'F');
        if (z2) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb2 = this.f37580a;
            sb2.append(bArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f37580a;
            sb3.append(bArr.length);
            sb3.append(", [");
            sb3.append('\n');
            k kVar = new k(this.f37580a, this.b + 1);
            int length = bArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                kVar.a(bArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    public k a(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            if (z) {
                this.f37580a.append("|");
            }
            return this;
        }
        this.f37580a.append(i.a(bArr));
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(char[] cArr, String str) {
        a(str);
        if (cArr == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
            return this;
        } else if (cArr.length == 0) {
            StringBuilder sb2 = this.f37580a;
            sb2.append(cArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f37580a;
            sb3.append(cArr.length);
            sb3.append(", [");
            sb3.append('\n');
            k kVar = new k(this.f37580a, this.b + 1);
            int length = cArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                kVar.a(cArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    public k a(char[] cArr, boolean z) {
        if (cArr == null || cArr.length == 0) {
            if (z) {
                this.f37580a.append("|");
            }
            return this;
        }
        this.f37580a.append(new String(cArr));
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
            return this;
        } else if (dArr.length == 0) {
            StringBuilder sb2 = this.f37580a;
            sb2.append(dArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f37580a;
            sb3.append(dArr.length);
            sb3.append(", [");
            sb3.append('\n');
            k kVar = new k(this.f37580a, this.b + 1);
            int length = dArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                kVar.a(dArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    public k a(double[] dArr, boolean z) {
        if (dArr == null || dArr.length == 0) {
            this.f37580a.append("[]");
            if (z) {
                this.f37580a.append("|");
            }
            return this;
        }
        this.f37580a.append("[");
        k kVar = new k(this.f37580a, this.b + 1);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                break;
            }
            double d = dArr[i2];
            if (i2 != 0) {
                this.f37580a.append("|");
            }
            kVar.a(d, false);
            i = i2 + 1;
        }
        this.f37580a.append("[");
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
            return this;
        } else if (fArr.length == 0) {
            StringBuilder sb2 = this.f37580a;
            sb2.append(fArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f37580a;
            sb3.append(fArr.length);
            sb3.append(", [");
            sb3.append('\n');
            k kVar = new k(this.f37580a, this.b + 1);
            int length = fArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                kVar.a(fArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    public k a(float[] fArr, boolean z) {
        if (fArr == null || fArr.length == 0) {
            this.f37580a.append("[]");
            if (z) {
                this.f37580a.append("|");
            }
            return this;
        }
        this.f37580a.append("[");
        k kVar = new k(this.f37580a, this.b + 1);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                break;
            }
            float f = fArr[i2];
            if (i2 != 0) {
                this.f37580a.append("|");
            }
            kVar.a(f, false);
            i = i2 + 1;
        }
        this.f37580a.append("]");
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
            return this;
        } else if (iArr.length == 0) {
            StringBuilder sb2 = this.f37580a;
            sb2.append(iArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f37580a;
            sb3.append(iArr.length);
            sb3.append(", [");
            sb3.append('\n');
            k kVar = new k(this.f37580a, this.b + 1);
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                kVar.a(iArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    public k a(int[] iArr, boolean z) {
        if (iArr == null || iArr.length == 0) {
            this.f37580a.append("[]");
            if (z) {
                this.f37580a.append("|");
            }
            return this;
        }
        this.f37580a.append("[");
        k kVar = new k(this.f37580a, this.b + 1);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                break;
            }
            int i3 = iArr[i2];
            if (i2 != 0) {
                this.f37580a.append("|");
            }
            kVar.a(i3, false);
            i = i2 + 1;
        }
        this.f37580a.append("]");
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
            return this;
        } else if (jArr.length == 0) {
            StringBuilder sb2 = this.f37580a;
            sb2.append(jArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f37580a;
            sb3.append(jArr.length);
            sb3.append(", [");
            sb3.append('\n');
            k kVar = new k(this.f37580a, this.b + 1);
            int length = jArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                kVar.a(jArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    public k a(long[] jArr, boolean z) {
        if (jArr == null || jArr.length == 0) {
            this.f37580a.append("[]");
            if (z) {
                this.f37580a.append("|");
            }
            return this;
        }
        this.f37580a.append("[");
        k kVar = new k(this.f37580a, this.b + 1);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jArr.length) {
                break;
            }
            long j = jArr[i2];
            if (i2 != 0) {
                this.f37580a.append("|");
            }
            kVar.a(j, false);
            i = i2 + 1;
        }
        this.f37580a.append("]");
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public <T> k a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb2 = this.f37580a;
            sb2.append(tArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f37580a;
            sb3.append(tArr.length);
            sb3.append(", [");
            sb3.append('\n');
            k kVar = new k(this.f37580a, this.b + 1);
            int length = tArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                kVar.a((k) tArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    public <T> k a(T[] tArr, boolean z) {
        if (tArr == null || tArr.length == 0) {
            this.f37580a.append("[]");
            if (z) {
                this.f37580a.append("|");
            }
            return this;
        }
        this.f37580a.append("[");
        k kVar = new k(this.f37580a, this.b + 1);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= tArr.length) {
                break;
            }
            T t = tArr[i2];
            if (i2 != 0) {
                this.f37580a.append("|");
            }
            kVar.a((k) t, false);
            i = i2 + 1;
        }
        this.f37580a.append("]");
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }

    public k a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            StringBuilder sb = this.f37580a;
            sb.append(com.igexin.push.core.b.l);
            sb.append('\n');
            return this;
        } else if (sArr.length == 0) {
            StringBuilder sb2 = this.f37580a;
            sb2.append(sArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f37580a;
            sb3.append(sArr.length);
            sb3.append(", [");
            sb3.append('\n');
            k kVar = new k(this.f37580a, this.b + 1);
            int length = sArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(']', (String) null);
                    return this;
                }
                kVar.a(sArr[i2], (String) null);
                i = i2 + 1;
            }
        }
    }

    public k a(short[] sArr, boolean z) {
        if (sArr == null || sArr.length == 0) {
            this.f37580a.append("[]");
            if (z) {
                this.f37580a.append("|");
            }
            return this;
        }
        this.f37580a.append("[");
        k kVar = new k(this.f37580a, this.b + 1);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sArr.length) {
                break;
            }
            short s = sArr[i2];
            if (i2 != 0) {
                this.f37580a.append("|");
            }
            kVar.a(s, false);
            i = i2 + 1;
        }
        this.f37580a.append("]");
        if (z) {
            this.f37580a.append("|");
        }
        return this;
    }
}
