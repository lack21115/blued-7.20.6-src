package io.grpc;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/Attributes.class */
public final class Attributes {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Attributes EMPTY = new Attributes(Collections.emptyMap());
    private final Map<Key<?>, Object> data;

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Attributes$Builder.class */
    public static final class Builder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Attributes base;
        private Map<Key<?>, Object> newdata;

        private Builder(Attributes attributes) {
            this.base = attributes;
        }

        private Map<Key<?>, Object> data(int i) {
            if (this.newdata == null) {
                this.newdata = new IdentityHashMap(i);
            }
            return this.newdata;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Attributes build() {
            if (this.newdata != null) {
                for (Map.Entry entry : this.base.data.entrySet()) {
                    if (!this.newdata.containsKey(entry.getKey())) {
                        this.newdata.put(entry.getKey(), entry.getValue());
                    }
                }
                this.base = new Attributes(this.newdata);
                this.newdata = null;
            }
            return this.base;
        }

        public <T> Builder discard(Key<T> key) {
            if (this.base.data.containsKey(key)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.base.data);
                identityHashMap.remove(key);
                this.base = new Attributes(identityHashMap);
            }
            Map<Key<?>, Object> map = this.newdata;
            if (map != null) {
                map.remove(key);
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <T> Builder set(Key<T> key, T t) {
            data(1).put(key, t);
            return this;
        }

        public Builder setAll(Attributes attributes) {
            data(attributes.data.size()).putAll(attributes.data);
            return this;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Attributes$Key.class */
    public static final class Key<T> {
        private final String debugString;

        private Key(String str) {
            this.debugString = str;
        }

        public static <T> Key<T> create(String str) {
            return new Key<>(str);
        }

        @Deprecated
        public static <T> Key<T> of(String str) {
            return new Key<>(str);
        }

        public String toString() {
            return this.debugString;
        }
    }

    private Attributes(Map<Key<?>, Object> map) {
        this.data = map;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Deprecated
    public static Builder newBuilder(Attributes attributes) {
        Preconditions.checkNotNull(attributes, "base");
        return new Builder();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            if (r0 != r1) goto L7
            r0 = 1
            return r0
        L7:
            r0 = r5
            if (r0 == 0) goto L89
            r0 = r4
            java.lang.Class r0 = r0.getClass()
            r1 = r5
            java.lang.Class r1 = r1.getClass()
            if (r0 == r1) goto L18
            r0 = 0
            return r0
        L18:
            r0 = r5
            io.grpc.Attributes r0 = (io.grpc.Attributes) r0
            r5 = r0
            r0 = r4
            java.util.Map<io.grpc.Attributes$Key<?>, java.lang.Object> r0 = r0.data
            int r0 = r0.size()
            r1 = r5
            java.util.Map<io.grpc.Attributes$Key<?>, java.lang.Object> r1 = r1.data
            int r1 = r1.size()
            if (r0 == r1) goto L34
            r0 = 0
            return r0
        L34:
            r0 = r4
            java.util.Map<io.grpc.Attributes$Key<?>, java.lang.Object> r0 = r0.data
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r6 = r0
        L43:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L87
            r0 = r6
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r7 = r0
            r0 = r5
            java.util.Map<io.grpc.Attributes$Key<?>, java.lang.Object> r0 = r0.data
            r1 = r7
            java.lang.Object r1 = r1.getKey()
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L6a
            r0 = 0
            return r0
        L6a:
            r0 = r7
            java.lang.Object r0 = r0.getValue()
            r1 = r5
            java.util.Map<io.grpc.Attributes$Key<?>, java.lang.Object> r1 = r1.data
            r2 = r7
            java.lang.Object r2 = r2.getKey()
            java.lang.Object r1 = r1.get(r2)
            boolean r0 = com.google.common.base.Objects.equal(r0, r1)
            if (r0 != 0) goto L43
            r0 = 0
            return r0
        L87:
            r0 = 1
            return r0
        L89:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.Attributes.equals(java.lang.Object):boolean");
    }

    @Nullable
    public <T> T get(Key<T> key) {
        return (T) this.data.get(key);
    }

    public int hashCode() {
        Iterator<Map.Entry<Key<?>, Object>> it = this.data.entrySet().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            Map.Entry<Key<?>, Object> next = it.next();
            i = i2 + Objects.hashCode(next.getKey(), next.getValue());
        }
    }

    @Deprecated
    public Set<Key<?>> keys() {
        return Collections.unmodifiableSet(this.data.keySet());
    }

    Set<Key<?>> keysForTest() {
        return Collections.unmodifiableSet(this.data.keySet());
    }

    public Builder toBuilder() {
        return new Builder();
    }

    public String toString() {
        return this.data.toString();
    }
}
