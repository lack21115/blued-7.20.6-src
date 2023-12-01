package com.squareup.wire.internal;

import com.squareup.wire.KotlinConstructorBuilder;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Regex;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/FieldBinding.class */
public final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> extends FieldOrOneOfBinding<M, B> {
    public static final Companion Companion = new Companion(null);
    private static final Regex IS_GETTER_FIELD_NAME_REGEX = new Regex("^is[^a-z].*$");
    private final String adapterString;
    private final Function1<B, Object> builderGetter;
    private final Function2<B, Object, Unit> builderSetter;
    private final String declaredName;
    private final Function1<M, Object> instanceGetter;
    private final String keyAdapterString;
    private final WireField.Label label;
    private final Field messageField;
    private final String name;
    private final boolean redacted;
    private final int tag;
    private final String wireFieldJsonName;
    private final boolean writeIdentityValues;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/FieldBinding$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FieldBinding(WireField wireField, Class<M> cls, Field field, Class<B> cls2, boolean z) {
        String declaredName;
        Intrinsics.e(wireField, "wireField");
        Intrinsics.e(cls, "messageType");
        Intrinsics.e(field, "messageField");
        Intrinsics.e(cls2, "builderType");
        this.messageField = field;
        this.writeIdentityValues = z;
        this.label = wireField.label();
        String name = this.messageField.getName();
        Intrinsics.c(name, "messageField.name");
        this.name = name;
        this.wireFieldJsonName = wireField.jsonName();
        if (wireField.declaredName().length() == 0) {
            declaredName = this.messageField.getName();
            Intrinsics.c(declaredName, "messageField.name");
        } else {
            declaredName = wireField.declaredName();
        }
        this.declaredName = declaredName;
        this.tag = wireField.tag();
        this.keyAdapterString = wireField.keyAdapter();
        this.adapterString = wireField.adapter();
        this.redacted = wireField.redacted();
        this.builderSetter = getBuilderSetter(cls2, wireField);
        this.builderGetter = getBuilderGetter(cls2, wireField);
        this.instanceGetter = getInstanceGetter(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Function1<B, Object> getBuilderGetter(Class<?> cls, final WireField wireField) {
        if (cls.isAssignableFrom(KotlinConstructorBuilder.class)) {
            return new Function1<B, Object>() { // from class: com.squareup.wire.internal.FieldBinding$getBuilderGetter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TB;)Ljava/lang/Object; */
                public final Object invoke(Message.Builder builder) {
                    Intrinsics.e(builder, "builder");
                    return ((KotlinConstructorBuilder) builder).get(WireField.this);
                }
            };
        }
        try {
            final Field field = cls.getField(getName());
            return new Function1<B, Object>() { // from class: com.squareup.wire.internal.FieldBinding$getBuilderGetter$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TB;)Ljava/lang/Object; */
                public final Object invoke(Message.Builder builder) {
                    Intrinsics.e(builder, "builder");
                    return field.get(builder);
                }
            };
        } catch (NoSuchFieldException e) {
            throw new AssertionError("No builder field " + ((Object) cls.getName()) + '.' + getName());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Function2<B, Object, Unit> getBuilderSetter(Class<?> cls, final WireField wireField) {
        if (cls.isAssignableFrom(KotlinConstructorBuilder.class)) {
            return new Function2<B, Object, Unit>() { // from class: com.squareup.wire.internal.FieldBinding$getBuilderSetter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Message.Builder) obj, obj2);
                    return Unit.a;
                }

                /* JADX WARN: Incorrect types in method signature: (TB;Ljava/lang/Object;)V */
                public final void invoke(Message.Builder builder, Object obj) {
                    Intrinsics.e(builder, "builder");
                    ((KotlinConstructorBuilder) builder).set(WireField.this, obj);
                }
            };
        }
        if (!wireField.label().isOneOf()) {
            try {
                final Field field = cls.getField(getName());
                return new Function2<B, Object, Unit>() { // from class: com.squareup.wire.internal.FieldBinding$getBuilderSetter$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Message.Builder) obj, obj2);
                        return Unit.a;
                    }

                    /* JADX WARN: Incorrect types in method signature: (TB;Ljava/lang/Object;)V */
                    public final void invoke(Message.Builder builder, Object obj) {
                        Intrinsics.e(builder, "builder");
                        field.set(builder, obj);
                    }
                };
            } catch (NoSuchFieldException e) {
                throw new AssertionError("No builder field " + ((Object) cls.getName()) + '.' + getName());
            }
        }
        Class<?> type = this.messageField.getType();
        try {
            final Method method = cls.getMethod(getName(), type);
            return new Function2<B, Object, Unit>() { // from class: com.squareup.wire.internal.FieldBinding$getBuilderSetter$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Message.Builder) obj, obj2);
                    return Unit.a;
                }

                /* JADX WARN: Incorrect types in method signature: (TB;Ljava/lang/Object;)V */
                public final void invoke(Message.Builder builder, Object obj) {
                    Intrinsics.e(builder, "builder");
                    method.invoke(builder, obj);
                }
            };
        } catch (NoSuchMethodException e2) {
            throw new AssertionError("No builder method " + ((Object) cls.getName()) + '.' + getName() + '(' + ((Object) type.getName()) + ')');
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Function1<M, Object> getInstanceGetter(Class<M> cls) {
        if (Modifier.isPrivate(this.messageField.getModifiers())) {
            String name = this.messageField.getName();
            Regex regex = IS_GETTER_FIELD_NAME_REGEX;
            Intrinsics.c(name, "fieldName");
            String str = name;
            if (!regex.a(str)) {
                String str2 = name;
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    String upperCase = String.valueOf(name.charAt(0)).toUpperCase(Locale.ROOT);
                    Intrinsics.c(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    sb.append((Object) upperCase);
                    String substring = name.substring(1);
                    Intrinsics.c(substring, "this as java.lang.String).substring(startIndex)");
                    sb.append(substring);
                    str2 = sb.toString();
                }
                name = Intrinsics.a(MonitorConstants.CONNECT_TYPE_GET, str2);
            }
            final Method method = cls.getMethod(name, new Class[0]);
            return new Function1<M, Object>() { // from class: com.squareup.wire.internal.FieldBinding$getInstanceGetter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TM;)Ljava/lang/Object; */
                public final Object invoke(Message message) {
                    Intrinsics.e(message, "instance");
                    return method.invoke(message, new Object[0]);
                }
            };
        }
        return new Function1<M, Object>(this) { // from class: com.squareup.wire.internal.FieldBinding$getInstanceGetter$2
            final /* synthetic */ FieldBinding<M, B> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect types in method signature: (TM;)Ljava/lang/Object; */
            public final Object invoke(Message message) {
                Field field;
                Intrinsics.e(message, "instance");
                field = ((FieldBinding) this.this$0).messageField;
                return field.get(message);
            }
        };
    }

    public Object get(M m) {
        Intrinsics.e(m, "message");
        return this.instanceGetter.invoke(m);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return get((FieldBinding<M, B>) ((Message) obj));
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getDeclaredName() {
        return this.declaredName;
    }

    public Object getFromBuilder(B b) {
        Intrinsics.e(b, "builder");
        return this.builderGetter.invoke(b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public /* bridge */ /* synthetic */ Object getFromBuilder(Object obj) {
        return getFromBuilder((FieldBinding<M, B>) ((Message.Builder) obj));
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public ProtoAdapter<?> getKeyAdapter() {
        return ProtoAdapter.Companion.get(this.keyAdapterString);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public WireField.Label getLabel() {
        return this.label;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getName() {
        return this.name;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getRedacted() {
        return this.redacted;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public ProtoAdapter<?> getSingleAdapter() {
        return ProtoAdapter.Companion.get(this.adapterString);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public int getTag() {
        return this.tag;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getWireFieldJsonName() {
        return this.wireFieldJsonName;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getWriteIdentityValues() {
        return this.writeIdentityValues;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMap() {
        return this.keyAdapterString.length() > 0;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMessage() {
        KClass<?> type = getSingleAdapter().getType();
        return Message.class.isAssignableFrom(type == null ? null : JvmClassMappingKt.b(type));
    }

    public void set(B b, Object obj) {
        Intrinsics.e(b, "builder");
        this.builderSetter.invoke(b, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public /* bridge */ /* synthetic */ void set(Object obj, Object obj2) {
        set((FieldBinding<M, B>) ((Message.Builder) obj), obj2);
    }

    public void value(B b, Object obj) {
        Intrinsics.e(b, "builder");
        Intrinsics.e(obj, "value");
        if (getLabel().isRepeated()) {
            Object fromBuilder = getFromBuilder((FieldBinding<M, B>) b);
            if (TypeIntrinsics.e(fromBuilder)) {
                if (fromBuilder == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
                }
                TypeIntrinsics.f(fromBuilder).add(obj);
                return;
            } else if (fromBuilder instanceof List) {
                List c2 = CollectionsKt.c((Collection) fromBuilder);
                c2.add(obj);
                set((FieldBinding<M, B>) b, (Object) c2);
                return;
            } else {
                Class<?> cls = fromBuilder == null ? null : fromBuilder.getClass();
                throw new ClassCastException("Expected a list type, got " + cls + '.');
            }
        }
        if (!(this.keyAdapterString.length() > 0)) {
            set((FieldBinding<M, B>) b, obj);
            return;
        }
        Object fromBuilder2 = getFromBuilder((FieldBinding<M, B>) b);
        if (TypeIntrinsics.h(fromBuilder2)) {
            ((Map) fromBuilder2).putAll((Map) obj);
        } else if (fromBuilder2 instanceof Map) {
            Map d = MapsKt.d((Map) fromBuilder2);
            d.putAll((Map) obj);
            set((FieldBinding<M, B>) b, (Object) d);
        } else {
            Class<?> cls2 = fromBuilder2 == null ? null : fromBuilder2.getClass();
            throw new ClassCastException("Expected a map type, got " + cls2 + '.');
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public /* bridge */ /* synthetic */ void value(Object obj, Object obj2) {
        value((FieldBinding<M, B>) ((Message.Builder) obj), obj2);
    }
}
