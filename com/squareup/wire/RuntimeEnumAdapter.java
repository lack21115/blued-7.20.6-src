package com.squareup.wire;

import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/RuntimeEnumAdapter.class */
public final class RuntimeEnumAdapter<E extends WireEnum> extends EnumAdapter<E> {
    public static final Companion Companion = new Companion(null);
    private Method fromValueMethod;
    private final Class<E> javaType;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/RuntimeEnumAdapter$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final <E extends WireEnum> RuntimeEnumAdapter<E> create(Class<E> cls) {
            Intrinsics.e(cls, "enumType");
            return new RuntimeEnumAdapter<>(cls, ProtoAdapter.Companion.get(cls).getSyntax());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RuntimeEnumAdapter(Class<E> cls) {
        this(cls, Syntax.PROTO_2);
        Intrinsics.e(cls, "javaType");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuntimeEnumAdapter(Class<E> cls, Syntax syntax) {
        super(JvmClassMappingKt.a(cls), syntax, Internal.getIdentityOrNull(cls));
        Intrinsics.e(cls, "javaType");
        Intrinsics.e(syntax, "syntax");
        this.javaType = cls;
    }

    @JvmStatic
    public static final <E extends WireEnum> RuntimeEnumAdapter<E> create(Class<E> cls) {
        return Companion.create(cls);
    }

    private final Method getFromValueMethod() {
        Method method = this.fromValueMethod;
        Method method2 = method;
        if (method == null) {
            method2 = this.javaType.getMethod("fromValue", Integer.TYPE);
            this.fromValueMethod = method2;
            Intrinsics.c(method2, "javaType.getMethod(\"from…romValueMethod = it\n    }");
        }
        return method2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeEnumAdapter) && Intrinsics.a(((RuntimeEnumAdapter) obj).getType(), getType());
    }

    @Override // com.squareup.wire.EnumAdapter
    protected E fromValue(int i) {
        Object invoke = getFromValueMethod().invoke(null, Integer.valueOf(i));
        if (invoke != null) {
            return (E) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type E of com.squareup.wire.RuntimeEnumAdapter");
    }

    public int hashCode() {
        KClass<?> type = getType();
        if (type == null) {
            return 0;
        }
        return type.hashCode();
    }
}
