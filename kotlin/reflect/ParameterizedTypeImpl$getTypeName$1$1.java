package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/ParameterizedTypeImpl$getTypeName$1$1.class */
final /* synthetic */ class ParameterizedTypeImpl$getTypeName$1$1 extends FunctionReferenceImpl implements Function1<Type, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final ParameterizedTypeImpl$getTypeName$1$1 f42608a = new ParameterizedTypeImpl$getTypeName$1$1();

    ParameterizedTypeImpl$getTypeName$1$1() {
        super(1, TypesJVMKt.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final String invoke(Type p0) {
        String b;
        Intrinsics.e(p0, "p0");
        b = TypesJVMKt.b(p0);
        return b;
    }
}
