package com.squareup.wire.internal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireEnumConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/EnumJsonFormatter.class */
public final class EnumJsonFormatter<E extends WireEnum> implements JsonFormatter<E> {
    private final Map<String, E> stringToValue;
    private final Map<E, String> valueToString;

    public EnumJsonFormatter(EnumAdapter<E> adapter) {
        Intrinsics.e(adapter, "adapter");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        KClass<?> type = adapter.getType();
        Intrinsics.a(type);
        Class a2 = JvmClassMappingKt.a(type);
        Object[] enumConstants = a2.getEnumConstants();
        Intrinsics.c(enumConstants, "enumType.enumConstants");
        WireEnum[] wireEnumArr = (WireEnum[]) enumConstants;
        int length = wireEnumArr.length;
        int i = 0;
        while (i < length) {
            WireEnum wireEnum = wireEnumArr[i];
            int i2 = i + 1;
            if (wireEnum == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
            }
            String name = ((Enum) wireEnum).name();
            linkedHashMap.put(name, wireEnum);
            linkedHashMap.put(String.valueOf(wireEnum.getValue()), wireEnum);
            linkedHashMap2.put(wireEnum, name);
            WireEnumConstant wireEnumConstant = (WireEnumConstant) a2.getDeclaredField(name).getAnnotation(WireEnumConstant.class);
            i = i2;
            if (wireEnumConstant != null) {
                i = i2;
                if (wireEnumConstant.declaredName().length() > 0) {
                    linkedHashMap.put(wireEnumConstant.declaredName(), wireEnum);
                    linkedHashMap2.put(wireEnum, wireEnumConstant.declaredName());
                    i = i2;
                }
            }
        }
        this.stringToValue = linkedHashMap;
        this.valueToString = linkedHashMap2;
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public E fromString(String value) {
        Intrinsics.e(value, "value");
        return this.stringToValue.get(value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.JsonFormatter
    public /* bridge */ /* synthetic */ Object toStringOrNumber(Object obj) {
        return toStringOrNumber((EnumJsonFormatter<E>) ((WireEnum) obj));
    }

    public String toStringOrNumber(E value) {
        Intrinsics.e(value, "value");
        String str = this.valueToString.get(value);
        Intrinsics.a((Object) str);
        return str;
    }
}
