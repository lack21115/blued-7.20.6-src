package com.tencent.bugly.proguard;

import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f35385a;
    private int b;

    public h(StringBuilder sb, int i) {
        this.b = 0;
        this.f35385a = sb;
        this.b = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> h a(T t, String str) {
        if (t == null) {
            this.f35385a.append("null\n");
            return this;
        } else if (t instanceof Byte) {
            byte byteValue = ((Byte) t).byteValue();
            a(str);
            StringBuilder sb = this.f35385a;
            sb.append((int) byteValue);
            sb.append('\n');
            return this;
        } else if (t instanceof Boolean) {
            boolean booleanValue = ((Boolean) t).booleanValue();
            a(str);
            StringBuilder sb2 = this.f35385a;
            sb2.append(booleanValue ? 'T' : 'F');
            sb2.append('\n');
            return this;
        } else if (t instanceof Short) {
            short shortValue = ((Short) t).shortValue();
            a(str);
            StringBuilder sb3 = this.f35385a;
            sb3.append((int) shortValue);
            sb3.append('\n');
            return this;
        } else if (t instanceof Integer) {
            int intValue = ((Integer) t).intValue();
            a(str);
            StringBuilder sb4 = this.f35385a;
            sb4.append(intValue);
            sb4.append('\n');
            return this;
        } else if (t instanceof Long) {
            long longValue = ((Long) t).longValue();
            a(str);
            StringBuilder sb5 = this.f35385a;
            sb5.append(longValue);
            sb5.append('\n');
            return this;
        } else if (t instanceof Float) {
            float floatValue = ((Float) t).floatValue();
            a(str);
            StringBuilder sb6 = this.f35385a;
            sb6.append(floatValue);
            sb6.append('\n');
            return this;
        } else if (t instanceof Double) {
            double doubleValue = ((Double) t).doubleValue();
            a(str);
            StringBuilder sb7 = this.f35385a;
            sb7.append(doubleValue);
            sb7.append('\n');
            return this;
        } else if (t instanceof String) {
            a((String) t, str);
            return this;
        } else if (t instanceof Map) {
            a((Map) t, str);
            return this;
        } else if (t instanceof List) {
            List list = (List) t;
            if (list != null) {
                a(list.toArray(), str);
                return this;
            }
            a(str);
            this.f35385a.append("null\t");
            return this;
        } else if (t instanceof k) {
            a((k) t, str);
            return this;
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
            return this;
        } else if (t instanceof boolean[]) {
            a((h) ((boolean[]) t), str);
            return this;
        } else {
            if (t instanceof short[]) {
                short[] sArr = (short[]) t;
                a(str);
                if (sArr == null) {
                    this.f35385a.append("null\n");
                    return this;
                } else if (sArr.length == 0) {
                    StringBuilder sb8 = this.f35385a;
                    sb8.append(sArr.length);
                    sb8.append(", []\n");
                    return this;
                } else {
                    StringBuilder sb9 = this.f35385a;
                    sb9.append(sArr.length);
                    sb9.append(", [\n");
                    h hVar = new h(this.f35385a, this.b + 1);
                    for (short s : sArr) {
                        hVar.a(null);
                        StringBuilder sb10 = hVar.f35385a;
                        sb10.append((int) s);
                        sb10.append('\n');
                    }
                    a(null);
                    StringBuilder sb11 = this.f35385a;
                    sb11.append(']');
                    sb11.append('\n');
                    return this;
                }
            } else if (t instanceof int[]) {
                int[] iArr = (int[]) t;
                a(str);
                if (iArr == null) {
                    this.f35385a.append("null\n");
                    return this;
                } else if (iArr.length == 0) {
                    StringBuilder sb12 = this.f35385a;
                    sb12.append(iArr.length);
                    sb12.append(", []\n");
                    return this;
                } else {
                    StringBuilder sb13 = this.f35385a;
                    sb13.append(iArr.length);
                    sb13.append(", [\n");
                    h hVar2 = new h(this.f35385a, this.b + 1);
                    int length = iArr.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            a(null);
                            StringBuilder sb14 = this.f35385a;
                            sb14.append(']');
                            sb14.append('\n');
                            return this;
                        }
                        int i3 = iArr[i2];
                        hVar2.a(null);
                        StringBuilder sb15 = hVar2.f35385a;
                        sb15.append(i3);
                        sb15.append('\n');
                        i = i2 + 1;
                    }
                }
            } else if (t instanceof long[]) {
                long[] jArr = (long[]) t;
                a(str);
                if (jArr == null) {
                    this.f35385a.append("null\n");
                    return this;
                } else if (jArr.length == 0) {
                    StringBuilder sb16 = this.f35385a;
                    sb16.append(jArr.length);
                    sb16.append(", []\n");
                    return this;
                } else {
                    StringBuilder sb17 = this.f35385a;
                    sb17.append(jArr.length);
                    sb17.append(", [\n");
                    h hVar3 = new h(this.f35385a, this.b + 1);
                    int length2 = jArr.length;
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= length2) {
                            a(null);
                            StringBuilder sb18 = this.f35385a;
                            sb18.append(']');
                            sb18.append('\n');
                            return this;
                        }
                        long j = jArr[i5];
                        hVar3.a(null);
                        StringBuilder sb19 = hVar3.f35385a;
                        sb19.append(j);
                        sb19.append('\n');
                        i4 = i5 + 1;
                    }
                }
            } else if (t instanceof float[]) {
                float[] fArr = (float[]) t;
                a(str);
                if (fArr == null) {
                    this.f35385a.append("null\n");
                    return this;
                } else if (fArr.length == 0) {
                    StringBuilder sb20 = this.f35385a;
                    sb20.append(fArr.length);
                    sb20.append(", []\n");
                    return this;
                } else {
                    StringBuilder sb21 = this.f35385a;
                    sb21.append(fArr.length);
                    sb21.append(", [\n");
                    h hVar4 = new h(this.f35385a, this.b + 1);
                    int length3 = fArr.length;
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        if (i7 >= length3) {
                            a(null);
                            StringBuilder sb22 = this.f35385a;
                            sb22.append(']');
                            sb22.append('\n');
                            return this;
                        }
                        float f = fArr[i7];
                        hVar4.a(null);
                        StringBuilder sb23 = hVar4.f35385a;
                        sb23.append(f);
                        sb23.append('\n');
                        i6 = i7 + 1;
                    }
                }
            } else if (!(t instanceof double[])) {
                if (t.getClass().isArray()) {
                    a((Object[]) t, str);
                    return this;
                }
                throw new b("write object error: unsupport type.");
            } else {
                double[] dArr = (double[]) t;
                a(str);
                if (dArr == null) {
                    this.f35385a.append("null\n");
                    return this;
                } else if (dArr.length == 0) {
                    StringBuilder sb24 = this.f35385a;
                    sb24.append(dArr.length);
                    sb24.append(", []\n");
                    return this;
                } else {
                    StringBuilder sb25 = this.f35385a;
                    sb25.append(dArr.length);
                    sb25.append(", [\n");
                    h hVar5 = new h(this.f35385a, this.b + 1);
                    int length4 = dArr.length;
                    int i8 = 0;
                    while (true) {
                        int i9 = i8;
                        if (i9 >= length4) {
                            a(null);
                            StringBuilder sb26 = this.f35385a;
                            sb26.append(']');
                            sb26.append('\n');
                            return this;
                        }
                        double d = dArr[i9];
                        hVar5.a(null);
                        StringBuilder sb27 = hVar5.f35385a;
                        sb27.append(d);
                        sb27.append('\n');
                        i8 = i9 + 1;
                    }
                }
            }
        }
    }

    private <T> h a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.f35385a.append("null\n");
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb = this.f35385a;
            sb.append(tArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f35385a;
            sb2.append(tArr.length);
            sb2.append(", [\n");
            h hVar = new h(this.f35385a, this.b + 1);
            int length = tArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(null);
                    StringBuilder sb3 = this.f35385a;
                    sb3.append(']');
                    sb3.append('\n');
                    return this;
                }
                hVar.a((h) tArr[i2], (String) null);
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
            this.f35385a.append('\t');
            i = i2 + 1;
        }
        if (str != null) {
            StringBuilder sb = this.f35385a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public final h a(byte b, String str) {
        a(str);
        StringBuilder sb = this.f35385a;
        sb.append((int) b);
        sb.append('\n');
        return this;
    }

    public final h a(int i, String str) {
        a(str);
        StringBuilder sb = this.f35385a;
        sb.append(i);
        sb.append('\n');
        return this;
    }

    public final h a(long j, String str) {
        a(str);
        StringBuilder sb = this.f35385a;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    public final h a(k kVar, String str) {
        a(str);
        StringBuilder sb = this.f35385a;
        sb.append('{');
        sb.append('\n');
        if (kVar == null) {
            StringBuilder sb2 = this.f35385a;
            sb2.append('\t');
            sb2.append(com.igexin.push.core.b.l);
        } else {
            kVar.a(this.f35385a, this.b + 1);
        }
        a(null);
        StringBuilder sb3 = this.f35385a;
        sb3.append('}');
        sb3.append('\n');
        return this;
    }

    public final h a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.f35385a.append("null\n");
            return this;
        }
        StringBuilder sb = this.f35385a;
        sb.append(str);
        sb.append('\n');
        return this;
    }

    public final <K, V> h a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.f35385a.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb = this.f35385a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        } else {
            StringBuilder sb2 = this.f35385a;
            sb2.append(map.size());
            sb2.append(", {\n");
            h hVar = new h(this.f35385a, this.b + 1);
            h hVar2 = new h(this.f35385a, this.b + 2);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                hVar.a(null);
                StringBuilder sb3 = hVar.f35385a;
                sb3.append('(');
                sb3.append('\n');
                hVar2.a((h) entry.getKey(), (String) null);
                hVar2.a((h) entry.getValue(), (String) null);
                hVar.a(null);
                StringBuilder sb4 = hVar.f35385a;
                sb4.append(')');
                sb4.append('\n');
            }
            a(null);
            StringBuilder sb5 = this.f35385a;
            sb5.append('}');
            sb5.append('\n');
            return this;
        }
    }

    public final h a(short s, String str) {
        a(str);
        StringBuilder sb = this.f35385a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public final h a(boolean z, String str) {
        a(str);
        StringBuilder sb = this.f35385a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public final h a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.f35385a.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb = this.f35385a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f35385a;
            sb2.append(bArr.length);
            sb2.append(", [\n");
            h hVar = new h(this.f35385a, this.b + 1);
            int length = bArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(null);
                    StringBuilder sb3 = this.f35385a;
                    sb3.append(']');
                    sb3.append('\n');
                    return this;
                }
                byte b = bArr[i2];
                hVar.a(null);
                StringBuilder sb4 = hVar.f35385a;
                sb4.append((int) b);
                sb4.append('\n');
                i = i2 + 1;
            }
        }
    }
}
