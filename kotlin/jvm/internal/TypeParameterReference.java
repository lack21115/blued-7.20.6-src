package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/TypeParameterReference.class */
public final class TypeParameterReference implements KTypeParameter {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f42550a = new Companion(null);
    private final Object b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42551c;
    private final KVariance d;
    private volatile List<? extends KType> e;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/TypeParameterReference$Companion.class */
    public static final class Companion {

        @Metadata
        /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/TypeParameterReference$Companion$WhenMappings.class */
        public final /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f42552a;

            static {
                int[] iArr = new int[KVariance.values().length];
                iArr[KVariance.INVARIANT.ordinal()] = 1;
                iArr[KVariance.IN.ordinal()] = 2;
                iArr[KVariance.OUT.ordinal()] = 3;
                f42552a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(KTypeParameter typeParameter) {
            Intrinsics.e(typeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i = WhenMappings.f42552a[typeParameter.b().ordinal()];
            if (i == 2) {
                sb.append("in ");
            } else if (i == 3) {
                sb.append("out ");
            }
            sb.append(typeParameter.a());
            String sb2 = sb.toString();
            Intrinsics.c(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    @Override // kotlin.reflect.KTypeParameter
    public String a() {
        return this.f42551c;
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance b() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.KTypeParameter
    public List<KType> c() {
        List list = this.e;
        List list2 = list;
        if (list == null) {
            list2 = CollectionsKt.a(Reflection.c(Object.class));
            this.e = list2;
        }
        return list2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeParameterReference) {
            TypeParameterReference typeParameterReference = (TypeParameterReference) obj;
            return Intrinsics.a(this.b, typeParameterReference.b) && Intrinsics.a((Object) a(), (Object) typeParameterReference.a());
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.b;
        return ((obj != null ? obj.hashCode() : 0) * 31) + a().hashCode();
    }

    public String toString() {
        return f42550a.a(this);
    }
}
