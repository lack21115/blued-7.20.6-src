package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/WildcardTypeImpl.class */
public final class WildcardTypeImpl implements WildcardType, TypeImpl {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f42612a = new Companion(null);
    private static final WildcardTypeImpl d = new WildcardTypeImpl(null, null);
    private final Type b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f42613c;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/WildcardTypeImpl$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WildcardTypeImpl a() {
            return WildcardTypeImpl.d;
        }
    }

    public WildcardTypeImpl(Type type, Type type2) {
        this.b = type;
        this.f42613c = type2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            return Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds());
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.f42613c;
        return type == null ? new Type[0] : new Type[]{type};
    }

    public String getTypeName() {
        String b;
        String b2;
        if (this.f42613c != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("? super ");
            b2 = TypesJVMKt.b(this.f42613c);
            sb.append(b2);
            return sb.toString();
        }
        Type type = this.b;
        if (type == null || Intrinsics.a(type, Object.class)) {
            return "?";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("? extends ");
        b = TypesJVMKt.b(this.b);
        sb2.append(b);
        return sb2.toString();
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        Type type = this.b;
        Class cls = type;
        if (type == null) {
        }
        return new Type[]{cls};
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    public String toString() {
        return getTypeName();
    }
}
