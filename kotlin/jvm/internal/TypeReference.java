package kotlin.jvm.internal;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/TypeReference.class */
public final class TypeReference implements KType {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f42553a = new Companion(null);
    private final KClassifier b;

    /* renamed from: c  reason: collision with root package name */
    private final List<KTypeProjection> f42554c;
    private final KType d;
    private final int e;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/TypeReference$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/TypeReference$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42555a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            f42555a = iArr;
        }
    }

    public TypeReference(KClassifier classifier, List<KTypeProjection> arguments, KType kType, int i) {
        Intrinsics.e(classifier, "classifier");
        Intrinsics.e(arguments, "arguments");
        this.b = classifier;
        this.f42554c = arguments;
        this.d = kType;
        this.e = i;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public TypeReference(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private final String a(Class<?> cls) {
        return Intrinsics.a(cls, boolean[].class) ? "kotlin.BooleanArray" : Intrinsics.a(cls, char[].class) ? "kotlin.CharArray" : Intrinsics.a(cls, byte[].class) ? "kotlin.ByteArray" : Intrinsics.a(cls, short[].class) ? "kotlin.ShortArray" : Intrinsics.a(cls, int[].class) ? "kotlin.IntArray" : Intrinsics.a(cls, float[].class) ? "kotlin.FloatArray" : Intrinsics.a(cls, long[].class) ? "kotlin.LongArray" : Intrinsics.a(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
        if (r0 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(kotlin.reflect.KTypeProjection r4) {
        /*
            r3 = this;
            r0 = r4
            kotlin.reflect.KVariance r0 = r0.a()
            if (r0 != 0) goto La
            java.lang.String r0 = "*"
            return r0
        La:
            r0 = r4
            kotlin.reflect.KType r0 = r0.getType()
            r6 = r0
            r0 = r6
            boolean r0 = r0 instanceof kotlin.jvm.internal.TypeReference
            if (r0 == 0) goto L1e
            r0 = r6
            kotlin.jvm.internal.TypeReference r0 = (kotlin.jvm.internal.TypeReference) r0
            r6 = r0
            goto L20
        L1e:
            r0 = 0
            r6 = r0
        L20:
            r0 = r6
            if (r0 == 0) goto L33
            r0 = r6
            r1 = 1
            java.lang.String r0 = r0.a(r1)
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r7
            if (r0 != 0) goto L3b
        L33:
            r0 = r4
            kotlin.reflect.KType r0 = r0.getType()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r6 = r0
        L3b:
            r0 = r4
            kotlin.reflect.KVariance r0 = r0.a()
            r4 = r0
            int[] r0 = kotlin.jvm.internal.TypeReference.WhenMappings.f42555a
            r1 = r4
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r5 = r0
            r0 = r6
            r4 = r0
            r0 = r5
            r1 = 1
            if (r0 == r1) goto L96
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L7c
            r0 = r5
            r1 = 3
            if (r0 != r1) goto L74
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "out "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.toString()
            return r0
        L74:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r1 = r0
            r1.<init>()
            throw r0
        L7c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "in "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.toString()
            r4 = r0
        L96:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.TypeReference.a(kotlin.reflect.KTypeProjection):java.lang.String");
    }

    private final String a(boolean z) {
        KClassifier a2 = a();
        Class<?> cls = null;
        KClass kClass = a2 instanceof KClass ? (KClass) a2 : null;
        if (kClass != null) {
            cls = JvmClassMappingKt.a(kClass);
        }
        String str = (cls == null ? a().toString() : (this.e & 4) != 0 ? "kotlin.Nothing" : cls.isArray() ? a(cls) : (z && cls.isPrimitive()) ? JvmClassMappingKt.b((KClass) a()).getName() : cls.getName()) + (b().isEmpty() ? "" : CollectionsKt.a(b(), ", ", SimpleComparison.LESS_THAN_OPERATION, SimpleComparison.GREATER_THAN_OPERATION, 0, null, new Function1<KTypeProjection, CharSequence>() { // from class: kotlin.jvm.internal.TypeReference$asString$args$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final CharSequence invoke(KTypeProjection it) {
                String a3;
                Intrinsics.e(it, "it");
                a3 = TypeReference.this.a(it);
                return a3;
            }
        }, 24, null)) + (c() ? "?" : "");
        KType kType = this.d;
        String str2 = str;
        if (kType instanceof TypeReference) {
            String a3 = ((TypeReference) kType).a(true);
            if (Intrinsics.a((Object) a3, (Object) str)) {
                return str;
            }
            if (Intrinsics.a((Object) a3, (Object) (str + '?'))) {
                return str + '!';
            }
            str2 = '(' + str + ".." + a3 + ')';
        }
        return str2;
    }

    @Override // kotlin.reflect.KType
    public KClassifier a() {
        return this.b;
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> b() {
        return this.f42554c;
    }

    public boolean c() {
        return (this.e & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            return Intrinsics.a(a(), typeReference.a()) && Intrinsics.a(b(), typeReference.b()) && Intrinsics.a(this.d, typeReference.d) && this.e == typeReference.e;
        }
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return CollectionsKt.b();
    }

    public int hashCode() {
        return (((a().hashCode() * 31) + b().hashCode()) * 31) + Integer.valueOf(this.e).hashCode();
    }

    public String toString() {
        return a(false) + " (Kotlin reflection is not available)";
    }
}
