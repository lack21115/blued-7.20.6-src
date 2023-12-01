package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/TypesJVMKt.class */
public final class TypesJVMKt {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/TypesJVMKt$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42610a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.IN.ordinal()] = 1;
            iArr[KVariance.INVARIANT.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            f42610a = iArr;
        }
    }

    private static final Type a(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<KTypeProjection> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.a((Iterable) list2, 10));
            for (KTypeProjection kTypeProjection : list2) {
                arrayList.add(a(kTypeProjection));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        } else if (Modifier.isStatic(cls.getModifiers())) {
            Class<?> cls2 = declaringClass;
            List<KTypeProjection> list3 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.a((Iterable) list3, 10));
            for (KTypeProjection kTypeProjection2 : list3) {
                arrayList2.add(a(kTypeProjection2));
            }
            return new ParameterizedTypeImpl(cls, cls2, arrayList2);
        } else {
            int length = cls.getTypeParameters().length;
            Type a2 = a(declaringClass, list.subList(length, list.size()));
            List<KTypeProjection> subList = list.subList(0, length);
            ArrayList arrayList3 = new ArrayList(CollectionsKt.a((Iterable) subList, 10));
            for (KTypeProjection kTypeProjection3 : subList) {
                arrayList3.add(a(kTypeProjection3));
            }
            return new ParameterizedTypeImpl(cls, a2, arrayList3);
        }
    }

    static /* synthetic */ Type a(KType kType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return b(kType, z);
    }

    private static final Type a(KTypeProjection kTypeProjection) {
        KVariance a2 = kTypeProjection.a();
        if (a2 == null) {
            return WildcardTypeImpl.f42612a.a();
        }
        KType type = kTypeProjection.getType();
        Intrinsics.a(type);
        int i = WhenMappings.f42610a[a2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new WildcardTypeImpl(b(type, true), null);
                }
                throw new NoWhenBranchMatchedException();
            }
            return b(type, true);
        }
        return new WildcardTypeImpl(null, b(type, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Type type) {
        String name;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                Sequence a2 = SequencesKt.a(type, TypesJVMKt$typeToString$unwrap$1.f42611a);
                name = ((Class) SequencesKt.b(a2)).getName() + StringsKt.a((CharSequence) "[]", SequencesKt.f(a2));
            } else {
                name = cls.getName();
            }
            Intrinsics.c(name, "{\n        if (type.isArr…   } else type.name\n    }");
            return name;
        }
        return type.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v57, types: [kotlin.reflect.GenericArrayTypeImpl] */
    public static final Type b(KType kType, boolean z) {
        KClassifier a2 = kType.a();
        if (a2 instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) a2);
        }
        if (!(a2 instanceof KClass)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        KClass kClass = (KClass) a2;
        Class b = z ? JvmClassMappingKt.b(kClass) : JvmClassMappingKt.a(kClass);
        List<KTypeProjection> b2 = kType.b();
        if (b2.isEmpty()) {
            return b;
        }
        if (b.isArray()) {
            if (b.getComponentType().isPrimitive()) {
                return b;
            }
            KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.l((List<? extends Object>) b2);
            if (kTypeProjection == null) {
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
            }
            KVariance b3 = kTypeProjection.b();
            KType c2 = kTypeProjection.c();
            int i = b3 == null ? -1 : WhenMappings.f42610a[b3.ordinal()];
            if (i == -1 || i == 1) {
                return b;
            }
            if (i == 2 || i == 3) {
                Intrinsics.a(c2);
                Type a3 = a(c2, false, 1, null);
                if (!(a3 instanceof Class)) {
                    b = new GenericArrayTypeImpl(a3);
                }
                return b;
            }
            throw new NoWhenBranchMatchedException();
        }
        return a(b, b2);
    }
}
