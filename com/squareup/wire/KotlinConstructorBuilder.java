package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/KotlinConstructorBuilder.class */
public final class KotlinConstructorBuilder<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message.Builder<M, B> {
    private final Map<Integer, Pair<WireField, Object>> fieldValueMap;
    private final Map<Integer, Pair<WireField, Map<?, ?>>> mapFieldKeyValueMap;
    private final Class<M> messageType;
    private final Map<Integer, Pair<WireField, List<?>>> repeatedFieldValueMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/KotlinConstructorBuilder$ProtoField.class */
    public static final class ProtoField {
        private final Class<?> type;
        private final WireField wireField;

        public ProtoField(Class<?> type, WireField wireField) {
            Intrinsics.e(type, "type");
            Intrinsics.e(wireField, "wireField");
            this.type = type;
            this.wireField = wireField;
        }

        public final Class<?> getType() {
            return this.type;
        }

        public final WireField getWireField() {
            return this.wireField;
        }
    }

    public KotlinConstructorBuilder(Class<M> messageType) {
        Intrinsics.e(messageType, "messageType");
        this.messageType = messageType;
        int length = messageType.getDeclaredFields().length;
        this.fieldValueMap = new LinkedHashMap(length);
        this.repeatedFieldValueMap = new LinkedHashMap(length);
        this.mapFieldKeyValueMap = new LinkedHashMap(length);
    }

    private final void clobberOtherIsOneOfs(WireField wireField) {
        Collection<Pair<WireField, Object>> values = this.fieldValueMap.values();
        ArrayList arrayList = new ArrayList(CollectionsKt.a(values, 10));
        for (Pair<WireField, Object> pair : values) {
            arrayList.add(pair.a());
        }
        ArrayList arrayList2 = arrayList;
        ArrayList<WireField> arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            WireField wireField2 = (WireField) obj;
            if (Intrinsics.a((Object) wireField2.oneofName(), (Object) wireField.oneofName()) && wireField2.tag() != wireField.tag()) {
                arrayList3.add(obj);
            }
        }
        for (WireField wireField3 : arrayList3) {
            this.fieldValueMap.remove(Integer.valueOf(wireField3.tag()));
        }
    }

    private final List<ProtoField> declaredProtoFields(Class<M> cls) {
        ProtoField protoField;
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.c(declaredFields, "declaredFields");
        Field[] fieldArr = declaredFields;
        ArrayList arrayList = new ArrayList();
        int length = fieldArr.length;
        int i = 0;
        while (i < length) {
            Field field = fieldArr[i];
            i++;
            Field field2 = field;
            Annotation[] declaredAnnotations = field2.getDeclaredAnnotations();
            Intrinsics.c(declaredAnnotations, "field.declaredAnnotations");
            WireField wireField = (WireField) CollectionsKt.i((List<? extends Object>) ArraysKt.a((Object[]) declaredAnnotations, WireField.class));
            if (wireField == null) {
                protoField = null;
            } else {
                Class<?> type = field2.getType();
                Intrinsics.c(type, "field.type");
                protoField = new ProtoField(type, wireField);
            }
            if (protoField != null) {
                arrayList.add(protoField);
            }
        }
        return arrayList;
    }

    @Override // com.squareup.wire.Message.Builder
    public M build() {
        boolean isMap;
        List<ProtoField> declaredProtoFields = declaredProtoFields(this.messageType);
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        for (ProtoField protoField : declaredProtoFields) {
            if (!protoField.getWireField().label().isRepeated()) {
                isMap = KotlinConstructorBuilderKt.isMap(protoField.getWireField());
                if (!isMap) {
                    arrayDeque2.add(protoField);
                }
            }
            arrayDeque.add(protoField);
        }
        Constructor<?>[] constructors = this.messageType.getConstructors();
        Intrinsics.c(constructors, "messageType.constructors");
        Constructor<?>[] constructorArr = constructors;
        int length = constructorArr.length;
        int i = 0;
        while (i < length) {
            Constructor<?> constructor = constructorArr[i];
            i++;
            Constructor<?> constructor2 = constructor;
            if (constructor2.getParameterCount() == declaredProtoFields.size() + 1) {
                Parameter[] parameters = constructor2.getParameters();
                Intrinsics.c(parameters, "constructor.parameters");
                Parameter[] parameterArr = parameters;
                ArrayList arrayList = new ArrayList(parameterArr.length);
                int length2 = parameterArr.length;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i2 >= length2) {
                        break;
                    }
                    Parameter parameter = parameterArr[i2];
                    i2++;
                    Parameter parameter2 = parameter;
                    arrayList.add((Intrinsics.a(parameter2.getType(), List.class) || Intrinsics.a(parameter2.getType(), Map.class)) ? get(((ProtoField) arrayDeque.a()).getWireField()) : i4 == declaredProtoFields.size() ? buildUnknownFields() : get(((ProtoField) arrayDeque2.a()).getWireField()));
                    i3 = i4 + 1;
                }
                Object[] array = arrayList.toArray(new Object[0]);
                if (array != null) {
                    Object newInstance = constructor2.newInstance(Arrays.copyOf(array, array.length));
                    if (newInstance != null) {
                        return (M) newInstance;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type M of com.squareup.wire.KotlinConstructorBuilder");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public final Object get(WireField field) {
        boolean isMap;
        Map<?, ?> b;
        Intrinsics.e(field, "field");
        isMap = KotlinConstructorBuilderKt.isMap(field);
        Map<?, ?> map = null;
        if (isMap) {
            Pair<WireField, Map<?, ?>> pair = this.mapFieldKeyValueMap.get(Integer.valueOf(field.tag()));
            if (pair != null) {
                map = pair.b();
            }
            b = map;
            if (map == null) {
                return MapsKt.a();
            }
        } else if (field.label().isRepeated()) {
            Pair<WireField, List<?>> pair2 = this.repeatedFieldValueMap.get(Integer.valueOf(field.tag()));
            List<?> b2 = pair2 == null ? null : pair2.b();
            b = b2;
            if (b2 == null) {
                return CollectionsKt.b();
            }
        } else {
            Pair<WireField, Object> pair3 = this.fieldValueMap.get(Integer.valueOf(field.tag()));
            if (pair3 == null) {
                return null;
            }
            b = pair3.b();
        }
        return b;
    }

    public final void set(WireField field, Object obj) {
        boolean isMap;
        Intrinsics.e(field, "field");
        isMap = KotlinConstructorBuilderKt.isMap(field);
        if (isMap) {
            Map<Integer, Pair<WireField, Map<?, ?>>> map = this.mapFieldKeyValueMap;
            int tag = field.tag();
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
            }
            map.put(Integer.valueOf(tag), TuplesKt.a(field, TypeIntrinsics.i(obj)));
        } else if (field.label().isRepeated()) {
            Map<Integer, Pair<WireField, List<?>>> map2 = this.repeatedFieldValueMap;
            int tag2 = field.tag();
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<*>");
            }
            map2.put(Integer.valueOf(tag2), TuplesKt.a(field, TypeIntrinsics.f(obj)));
        } else {
            this.fieldValueMap.put(Integer.valueOf(field.tag()), TuplesKt.a(field, obj));
            if (obj == null || !field.label().isOneOf()) {
                return;
            }
            clobberOtherIsOneOfs(field);
        }
    }
}
