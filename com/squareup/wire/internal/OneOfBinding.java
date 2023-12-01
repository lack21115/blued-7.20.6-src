package com.squareup.wire.internal;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.OneOf;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/OneOfBinding.class */
public final class OneOfBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> extends FieldOrOneOfBinding<M, B> {
    private final Field builderField;
    private final OneOf.Key<?> key;
    private final Field messageField;
    private final boolean writeIdentityValues;

    public OneOfBinding(Field messageField, Class<B> builderType, OneOf.Key<?> key, boolean z) {
        Intrinsics.e(messageField, "messageField");
        Intrinsics.e(builderType, "builderType");
        Intrinsics.e(key, "key");
        this.messageField = messageField;
        this.key = key;
        this.writeIdentityValues = z;
        Field declaredField = builderType.getDeclaredField(messageField.getName());
        Intrinsics.c(declaredField, "builderType.getDeclaredField(messageField.name)");
        this.builderField = declaredField;
    }

    public Object get(M message) {
        Intrinsics.e(message, "message");
        OneOf oneOf = (OneOf) this.messageField.get(message);
        if (oneOf == null) {
            return null;
        }
        return oneOf.getOrNull(this.key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return get((OneOfBinding<M, B>) ((Message) obj));
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getDeclaredName() {
        return this.key.getDeclaredName();
    }

    public Object getFromBuilder(B builder) {
        Intrinsics.e(builder, "builder");
        OneOf oneOf = (OneOf) this.builderField.get(builder);
        if (oneOf == null) {
            return null;
        }
        return oneOf.getOrNull(this.key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public /* bridge */ /* synthetic */ Object getFromBuilder(Object obj) {
        return getFromBuilder((OneOfBinding<M, B>) ((Message.Builder) obj));
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public /* bridge */ /* synthetic */ ProtoAdapter getKeyAdapter() {
        return (ProtoAdapter) m9771getKeyAdapter();
    }

    /* renamed from: getKeyAdapter  reason: collision with other method in class */
    public Void m9771getKeyAdapter() {
        throw new IllegalStateException("not a map".toString());
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public WireField.Label getLabel() {
        return WireField.Label.OPTIONAL;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getName() {
        return this.key.getDeclaredName();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getRedacted() {
        return this.key.getRedacted();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public ProtoAdapter<Object> getSingleAdapter() {
        return this.key.getAdapter();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public int getTag() {
        return this.key.getTag();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getWireFieldJsonName() {
        return this.key.getJsonName();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getWriteIdentityValues() {
        return this.writeIdentityValues;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMap() {
        return false;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMessage() {
        KClass<?> type = getSingleAdapter().getType();
        return Message.class.isAssignableFrom(type == null ? null : JvmClassMappingKt.b(type));
    }

    public void set(B builder, Object obj) {
        Intrinsics.e(builder, "builder");
        Field field = this.builderField;
        OneOf.Key<?> key = this.key;
        Intrinsics.a(obj);
        field.set(builder, new OneOf(key, obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public /* bridge */ /* synthetic */ void set(Object obj, Object obj2) {
        set((OneOfBinding<M, B>) ((Message.Builder) obj), obj2);
    }

    public void value(B builder, Object value) {
        Intrinsics.e(builder, "builder");
        Intrinsics.e(value, "value");
        set((OneOfBinding<M, B>) builder, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public /* bridge */ /* synthetic */ void value(Object obj, Object obj2) {
        value((OneOfBinding<M, B>) ((Message.Builder) obj), obj2);
    }
}
