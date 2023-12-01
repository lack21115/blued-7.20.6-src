package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/Objects.class */
public final class Objects {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/Objects$ToStringHelper.class */
    public static final class ToStringHelper {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f9048a;
        public final Object b;

        public ToStringHelper(Object obj) {
            this.b = Preconditions.checkNotNull(obj);
            this.f9048a = new ArrayList();
        }

        public final ToStringHelper add(String str, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(str2.length() + valueOf.length() + 1);
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            this.f9048a.add(sb.toString());
            return this;
        }

        public final String toString() {
            String simpleName = this.b.getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(100);
            sb.append(simpleName);
            sb.append('{');
            int size = this.f9048a.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    sb.append('}');
                    return sb.toString();
                }
                sb.append(this.f9048a.get(i2));
                if (i2 < size - 1) {
                    sb.append(", ");
                }
                i = i2 + 1;
            }
        }
    }

    public Objects() {
        throw new AssertionError("Uninstantiable");
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return obj != null && obj.equals(obj2);
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj);
    }
}
