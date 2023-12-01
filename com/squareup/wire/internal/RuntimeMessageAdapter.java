package com.squareup.wire.internal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.ReverseProtoWriter;
import com.squareup.wire.WireField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/RuntimeMessageAdapter.class */
public final class RuntimeMessageAdapter<M, B> extends ProtoAdapter<M> {
    public static final Companion Companion = new Companion(null);
    private static final String REDACTED = "██";
    private final MessageBinding<M, B> binding;
    private final FieldOrOneOfBinding<M, B>[] fieldBindingsArray;
    private final Map<Integer, FieldOrOneOfBinding<M, B>> fields;
    private final List<String> jsonAlternateNames;
    private final List<String> jsonNames;
    private final KClass<? super M> messageType;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/RuntimeMessageAdapter$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuntimeMessageAdapter(MessageBinding<M, B> messageBinding) {
        super(FieldEncoding.LENGTH_DELIMITED, messageBinding.getMessageType(), messageBinding.getTypeUrl(), messageBinding.getSyntax());
        Intrinsics.e(messageBinding, "binding");
        this.binding = messageBinding;
        this.messageType = messageBinding.getMessageType();
        Map<Integer, FieldOrOneOfBinding<M, B>> fields = this.binding.getFields();
        this.fields = fields;
        Object[] array = fields.values().toArray(new FieldOrOneOfBinding[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        FieldOrOneOfBinding<M, B>[] fieldOrOneOfBindingArr = (FieldOrOneOfBinding[]) array;
        this.fieldBindingsArray = fieldOrOneOfBindingArr;
        ArrayList arrayList = new ArrayList(fieldOrOneOfBindingArr.length);
        int length = fieldOrOneOfBindingArr.length;
        int i = 0;
        while (i < length) {
            FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = fieldOrOneOfBindingArr[i];
            i++;
            arrayList.add(getJsonName(fieldOrOneOfBinding));
        }
        this.jsonNames = arrayList;
        FieldOrOneOfBinding<M, B>[] fieldOrOneOfBindingArr2 = this.fieldBindingsArray;
        ArrayList arrayList2 = new ArrayList(fieldOrOneOfBindingArr2.length);
        int length2 = fieldOrOneOfBindingArr2.length;
        int i2 = 0;
        while (i2 < length2) {
            FieldOrOneOfBinding<M, B> fieldOrOneOfBinding2 = fieldOrOneOfBindingArr2[i2];
            i2++;
            arrayList2.add(!Intrinsics.a(getJsonName(fieldOrOneOfBinding2), fieldOrOneOfBinding2.getDeclaredName()) ? fieldOrOneOfBinding2.getDeclaredName() : !Intrinsics.a(getJsonName(fieldOrOneOfBinding2), fieldOrOneOfBinding2.getName()) ? fieldOrOneOfBinding2.getName() : null);
        }
        this.jsonAlternateNames = arrayList2;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M decode(ProtoReader protoReader) {
        Intrinsics.e(protoReader, "reader");
        B newBuilder = newBuilder();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessageAndGetUnknownFields(beginMessage);
                return this.binding.build(newBuilder);
            }
            FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = this.fields.get(Integer.valueOf(nextTag));
            if (fieldOrOneOfBinding != null) {
                try {
                    Object decode = (fieldOrOneOfBinding.isMap() ? fieldOrOneOfBinding.getAdapter() : fieldOrOneOfBinding.getSingleAdapter()).decode(protoReader);
                    Intrinsics.a(decode);
                    fieldOrOneOfBinding.value(newBuilder, decode);
                } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                    this.binding.addUnknownField(newBuilder, nextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                }
            } else {
                FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                Intrinsics.a(peekFieldEncoding);
                this.binding.addUnknownField(newBuilder, nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
            }
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ProtoWriter protoWriter, M m) {
        Intrinsics.e(protoWriter, "writer");
        Intrinsics.e(m, "value");
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : this.fields.values()) {
            Object obj = fieldOrOneOfBinding.get(m);
            if (obj != null) {
                fieldOrOneOfBinding.getAdapter().encodeWithTag(protoWriter, fieldOrOneOfBinding.getTag(), (int) obj);
            }
        }
        protoWriter.writeBytes(this.binding.unknownFields(m));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ReverseProtoWriter reverseProtoWriter, M m) {
        Intrinsics.e(reverseProtoWriter, "writer");
        Intrinsics.e(m, "value");
        reverseProtoWriter.writeBytes(this.binding.unknownFields(m));
        int length = this.fieldBindingsArray.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = this.fieldBindingsArray[length];
            Object obj = fieldOrOneOfBinding.get(m);
            if (obj != null) {
                fieldOrOneOfBinding.getAdapter().encodeWithTag(reverseProtoWriter, fieldOrOneOfBinding.getTag(), (int) obj);
            }
            if (i < 0) {
                return;
            }
            length = i;
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(M m) {
        Intrinsics.e(m, "value");
        int cachedSerializedSize = this.binding.getCachedSerializedSize(m);
        if (cachedSerializedSize != 0) {
            return cachedSerializedSize;
        }
        int i = 0;
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : this.fields.values()) {
            Object obj = fieldOrOneOfBinding.get(m);
            if (obj != null) {
                i += fieldOrOneOfBinding.getAdapter().encodedSizeWithTag(fieldOrOneOfBinding.getTag(), obj);
            }
        }
        int size = i + this.binding.unknownFields(m).size();
        this.binding.setCachedSerializedSize(m, size);
        return size;
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeMessageAdapter) && Intrinsics.a(((RuntimeMessageAdapter) obj).messageType, this.messageType);
    }

    public final FieldOrOneOfBinding<M, B>[] getFieldBindingsArray() {
        return this.fieldBindingsArray;
    }

    public final Map<Integer, FieldOrOneOfBinding<M, B>> getFields() {
        return this.fields;
    }

    public final List<String> getJsonAlternateNames() {
        return this.jsonAlternateNames;
    }

    public final String getJsonName(FieldOrOneOfBinding<?, ?> fieldOrOneOfBinding) {
        Intrinsics.e(fieldOrOneOfBinding, "<this>");
        return fieldOrOneOfBinding.getWireFieldJsonName().length() == 0 ? fieldOrOneOfBinding.getDeclaredName() : fieldOrOneOfBinding.getWireFieldJsonName();
    }

    public final List<String> getJsonNames() {
        return this.jsonNames;
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    public final B newBuilder() {
        return this.binding.newBuilder();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M redact(M m) {
        Intrinsics.e(m, "value");
        B newBuilder = this.binding.newBuilder();
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : this.fields.values()) {
            if (fieldOrOneOfBinding.getRedacted() && fieldOrOneOfBinding.getLabel() == WireField.Label.REQUIRED) {
                throw new UnsupportedOperationException("Field '" + fieldOrOneOfBinding.getName() + "' in " + getType() + " is required and cannot be redacted.");
            }
            boolean isMessage = fieldOrOneOfBinding.isMessage();
            if (fieldOrOneOfBinding.getRedacted() || (isMessage && !fieldOrOneOfBinding.getLabel().isRepeated())) {
                Object fromBuilder = fieldOrOneOfBinding.getFromBuilder(newBuilder);
                if (fromBuilder != null) {
                    fieldOrOneOfBinding.set(newBuilder, fieldOrOneOfBinding.getAdapter().redact(fromBuilder));
                }
            } else if (isMessage && fieldOrOneOfBinding.getLabel().isRepeated()) {
                Object fromBuilder2 = fieldOrOneOfBinding.getFromBuilder(newBuilder);
                if (fromBuilder2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                }
                fieldOrOneOfBinding.set(newBuilder, Internal.m6712redactElements((List) fromBuilder2, fieldOrOneOfBinding.getSingleAdapter()));
            }
        }
        this.binding.clearUnknownFields(newBuilder);
        return this.binding.build(newBuilder);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public String toString(M m) {
        Intrinsics.e(m, "value");
        StringBuilder sb = new StringBuilder();
        sb.append(this.messageType.b());
        sb.append('{');
        boolean z = true;
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : getFields().values()) {
            Object obj = fieldOrOneOfBinding.get(m);
            if (obj != null) {
                if (!z) {
                    sb.append(", ");
                }
                z = false;
                sb.append(fieldOrOneOfBinding.getName());
                sb.append('=');
                if (fieldOrOneOfBinding.getRedacted()) {
                    obj = REDACTED;
                }
                sb.append(obj);
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.c(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final <A> void writeAllFields(M m, List<? extends A> list, A a2, Function3<? super String, Object, ? super A, Unit> function3) {
        boolean z;
        Intrinsics.e(list, "jsonAdapters");
        Intrinsics.e(function3, "encodeValue");
        int length = this.fieldBindingsArray.length;
        ArrayList arrayList = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = this.fieldBindingsArray[i2];
            Intrinsics.a(m);
            Object obj = fieldOrOneOfBinding.get(m);
            if (!fieldOrOneOfBinding.omitFromJson(getSyntax(), obj)) {
                if (!fieldOrOneOfBinding.getRedacted() || a2 == null || obj == null) {
                    function3.a(this.jsonNames.get(i2), obj, list.get(i2));
                } else {
                    ArrayList arrayList2 = arrayList;
                    if (arrayList == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(this.jsonNames.get(i2));
                    arrayList = arrayList2;
                }
            }
            i = i2 + 1;
        }
        if (arrayList == null) {
            z = false;
        } else {
            z = false;
            if (!arrayList.isEmpty()) {
                z = true;
            }
        }
        if (z) {
            Intrinsics.a(a2);
            function3.a("__redacted_fields", arrayList, a2);
        }
    }
}
