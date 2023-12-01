package com.bytedance.sdk.openadsdk.api;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/b.class */
public final class b {
    private final SparseArray<Object> mb;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/b$mb.class */
    static final class mb implements ValueSet {
        private final SparseArray<Object> mb;

        private mb(SparseArray<Object> sparseArray) {
            this.mb = sparseArray;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object[]] */
        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.mb.get(i);
            if (obj == null) {
                return null;
            }
            Class<?> cls2 = obj.getClass();
            T[] tArr = null;
            if (cls2.isArray()) {
                tArr = null;
                if (cls.isAssignableFrom(cls2.getComponentType())) {
                    tArr = (Object[]) obj;
                }
            }
            return tArr;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            Object obj = this.mb.get(i);
            Object obj2 = obj;
            if (obj instanceof ValueSet.ValueGetter) {
                obj2 = ((ValueSet.ValueGetter) obj).get();
            }
            if (obj2 instanceof Boolean) {
                z = ((Boolean) obj2).booleanValue();
            }
            return z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            return this.mb.indexOfKey(i) >= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            Object obj = this.mb.get(i);
            Object obj2 = obj;
            if (obj instanceof ValueSet.ValueGetter) {
                obj2 = ((ValueSet.ValueGetter) obj).get();
            }
            if (obj2 instanceof Double) {
                return ((Double) obj2).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            Object obj = this.mb.get(i);
            Object obj2 = obj;
            if (obj instanceof ValueSet.ValueGetter) {
                obj2 = ((ValueSet.ValueGetter) obj).get();
            }
            if (obj2 instanceof Float) {
                f = ((Float) obj2).floatValue();
            }
            return f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            Object obj = this.mb.get(i);
            Object obj2 = obj;
            if (obj instanceof ValueSet.ValueGetter) {
                obj2 = ((ValueSet.ValueGetter) obj).get();
            }
            if (obj2 instanceof Integer) {
                i2 = ((Integer) obj2).intValue();
            }
            return i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.mb.size();
            HashSet hashSet = new HashSet();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return hashSet;
                }
                hashSet.add(Integer.valueOf(i2));
                i = i2 + 1;
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            Object obj = this.mb.get(i);
            Object obj2 = obj;
            if (obj instanceof ValueSet.ValueGetter) {
                obj2 = ((ValueSet.ValueGetter) obj).get();
            }
            if (obj2 instanceof Long) {
                j = ((Long) obj2).longValue();
            }
            return j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Object obj = this.mb.get(i);
            Object obj2 = obj;
            if (obj instanceof ValueSet.ValueGetter) {
                obj2 = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj2)) {
                return (T) this.mb.get(i);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            SparseArray<Object> sparseArray = this.mb;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            Object obj = this.mb.get(i);
            if ((obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String) {
                str = obj.toString();
            }
            return str;
        }
    }

    private b(SparseArray<Object> sparseArray) {
        this.mb = sparseArray;
    }

    public static final b mb() {
        return new b(new SparseArray());
    }

    public b mb(int i, Object obj) {
        this.mb.put(i, obj);
        return this;
    }

    public b mb(int i, String str) {
        this.mb.put(i, str);
        return this;
    }

    public b mb(int i, boolean z) {
        this.mb.put(i, Boolean.valueOf(z));
        return this;
    }

    public ValueSet ox() {
        return new mb(this.mb);
    }
}
