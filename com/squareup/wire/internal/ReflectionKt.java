package com.squareup.wire.internal;

import com.squareup.wire.KotlinConstructorBuilder;
import com.squareup.wire.Message;
import com.squareup.wire.OneOf;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/ReflectionKt.class */
public final class ReflectionKt {
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> createRuntimeMessageAdapter(final Class<M> cls, String str, Syntax syntax, boolean z) {
        Intrinsics.e(cls, "messageType");
        Intrinsics.e(syntax, "syntax");
        final Class builderType = getBuilderType(cls);
        Function0 function0 = new Function0<B>() { // from class: com.squareup.wire.internal.ReflectionKt$createRuntimeMessageAdapter$newBuilderInstance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TB; */
            /* renamed from: invoke */
            public final Message.Builder m6726invoke() {
                if (builderType.isAssignableFrom(KotlinConstructorBuilder.class)) {
                    return new KotlinConstructorBuilder(cls);
                }
                B newInstance = builderType.newInstance();
                Intrinsics.c(newInstance, "{\n      builderType.newInstance()\n    }");
                return (Message.Builder) newInstance;
            }
        };
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.c(declaredFields, "messageType.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                KClass a2 = JvmClassMappingKt.a(cls);
                Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
                Intrinsics.c(unmodifiableMap, "unmodifiableMap(fields)");
                return new RuntimeMessageAdapter<>(new RuntimeMessageBinding(a2, builderType, function0, unmodifiableMap, str, syntax));
            }
            Field field = declaredFields[i2];
            WireField wireField = (WireField) field.getAnnotation(WireField.class);
            if (wireField != null) {
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                int tag = wireField.tag();
                Intrinsics.c(field, "messageField");
                linkedHashMap2.put(Integer.valueOf(tag), new FieldBinding(wireField, cls, field, builderType, z));
            } else if (Intrinsics.a(field.getType(), OneOf.class)) {
                Intrinsics.c(field, "messageField");
                for (OneOf.Key<?> key : getKeys(field)) {
                    linkedHashMap.put(Integer.valueOf(key.getTag()), new OneOfBinding(field, builderType, key, z));
                }
            }
            i = i2 + 1;
        }
    }

    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> createRuntimeMessageAdapter(Class<M> cls, boolean z) {
        Intrinsics.e(cls, "messageType");
        ProtoAdapter protoAdapter = ProtoAdapter.Companion.get(cls);
        return createRuntimeMessageAdapter(cls, protoAdapter.getTypeUrl(), protoAdapter.getSyntax(), z);
    }

    public static /* synthetic */ RuntimeMessageAdapter createRuntimeMessageAdapter$default(Class cls, String str, Syntax syntax, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return createRuntimeMessageAdapter(cls, str, syntax, z);
    }

    private static final <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> cls) {
        Object f;
        Class<?> cls2;
        try {
            Result.Companion companion = Result.a;
            cls2 = Class.forName(Intrinsics.a(cls.getName(), "$Builder"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.a;
            f = Result.f(ResultKt.a(th));
        }
        if (cls2 != null) {
            f = Result.f(cls2);
            Object obj = f;
            if (Result.b(f)) {
                obj = null;
            }
            Class<B> cls3 = (Class) obj;
            Class<B> cls4 = cls3;
            if (cls3 == null) {
                cls4 = KotlinConstructorBuilder.class;
            }
            return cls4;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<B of com.squareup.wire.internal.ReflectionKt.getBuilderType$lambda-0>");
    }

    private static final <M extends Message<M, B>, B extends Message.Builder<M, B>> Set<OneOf.Key<?>> getKeys(Field field) {
        Class<?> declaringClass = field.getDeclaringClass();
        String name = field.getName();
        Intrinsics.c(name, "messageField.name");
        Field declaredField = declaringClass.getDeclaredField(Internal.boxedOneOfKeysFieldName(name));
        declaredField.setAccessible(true);
        Object obj = declaredField.get(null);
        if (obj != null) {
            return (Set) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<com.squareup.wire.OneOf.Key<*>>");
    }
}
