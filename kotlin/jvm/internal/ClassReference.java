package kotlin.jvm.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ClassReference.class */
public final class ClassReference implements ClassBasedDeclarationContainer, KClass<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f42528a = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends Function<?>>, Integer> f42529c;
    private static final HashMap<String, String> d;
    private static final HashMap<String, String> e;
    private static final HashMap<String, String> f;
    private static final Map<String, String> g;
    private final Class<?> b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ClassReference$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0065, code lost:
            if (r0 == null) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String a(java.lang.Class<?> r7) {
            /*
                Method dump skipped, instructions count: 291
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.ClassReference.Companion.a(java.lang.Class):java.lang.String");
        }

        public final boolean a(Object obj, Class<?> jClass) {
            Intrinsics.e(jClass, "jClass");
            Integer num = (Integer) ClassReference.f42529c.get(jClass);
            if (num != null) {
                return TypeIntrinsics.a(obj, num.intValue());
            }
            Class<?> cls = jClass;
            if (jClass.isPrimitive()) {
                cls = JvmClassMappingKt.b(JvmClassMappingKt.a(jClass));
            }
            return cls.isInstance(obj);
        }

        public final String b(Class<?> jClass) {
            String str;
            Intrinsics.e(jClass, "jClass");
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (jClass.isArray()) {
                Class<?> componentType = jClass.getComponentType();
                String str2 = null;
                if (componentType.isPrimitive()) {
                    String str3 = (String) ClassReference.f.get(componentType.getName());
                    str2 = null;
                    if (str3 != null) {
                        str2 = str3 + "Array";
                    }
                }
                str = str2;
                if (str2 == null) {
                    return "kotlin.Array";
                }
            } else {
                String str4 = (String) ClassReference.f.get(jClass.getName());
                str = str4;
                if (str4 == null) {
                    str = jClass.getCanonicalName();
                }
            }
            return str;
        }
    }

    static {
        int i = 0;
        List b = CollectionsKt.b(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList = new ArrayList(CollectionsKt.a((Iterable) b, 10));
        for (Object obj : b) {
            if (i < 0) {
                CollectionsKt.c();
            }
            arrayList.add(TuplesKt.a((Class) obj, Integer.valueOf(i)));
            i++;
        }
        f42529c = MapsKt.a(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, "kotlin.Short");
        hashMap.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "kotlin.Int");
        hashMap.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(d);
        hashMap3.putAll(e);
        Collection<String> values = d.values();
        Intrinsics.c(values, "primitiveFqNames.values");
        for (String str : values) {
            HashMap<String, String> hashMap4 = hashMap3;
            String kotlinName = str;
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            Intrinsics.c(kotlinName, "kotlinName");
            sb.append(StringsKt.c(kotlinName, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            Pair a2 = TuplesKt.a(sb.toString(), kotlinName + ".Companion");
            hashMap4.put(a2.a(), a2.b());
        }
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : f42529c.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f = hashMap3;
        HashMap<String, String> hashMap5 = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.b(hashMap5.size()));
        for (Map.Entry<String, String> entry2 : hashMap5.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt.c(entry2.getValue(), '.', (String) null, 2, (Object) null));
        }
        g = linkedHashMap;
    }

    public ClassReference(Class<?> jClass) {
        Intrinsics.e(jClass, "jClass");
        this.b = jClass;
    }

    private final Void g() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> a() {
        return this.b;
    }

    @Override // kotlin.reflect.KClass
    public boolean a(Object obj) {
        return f42528a.a(obj, a());
    }

    @Override // kotlin.reflect.KClass
    public String b() {
        return f42528a.a(a());
    }

    @Override // kotlin.reflect.KClass
    public String c() {
        return f42528a.b(a());
    }

    public boolean equals(Object obj) {
        return (obj instanceof ClassReference) && Intrinsics.a(JvmClassMappingKt.b(this), JvmClassMappingKt.b((KClass) obj));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        g();
        throw new KotlinNothingValueException();
    }

    public int hashCode() {
        return JvmClassMappingKt.b(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
