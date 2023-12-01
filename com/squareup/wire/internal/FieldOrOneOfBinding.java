package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/FieldOrOneOfBinding.class */
public abstract class FieldOrOneOfBinding<M, B> {
    private final Lazy adapter$delegate = LazyKt.a(new Function0<ProtoAdapter<Object>>(this) { // from class: com.squareup.wire.internal.FieldOrOneOfBinding$adapter$2
        final /* synthetic */ FieldOrOneOfBinding<M, B> this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* renamed from: invoke */
        public final ProtoAdapter<Object> m6710invoke() {
            return this.this$0.isMap() ? ProtoAdapter.Companion.newMapAdapter(this.this$0.getKeyAdapter(), this.this$0.getSingleAdapter()) : this.this$0.getSingleAdapter().withLabel$wire_runtime(this.this$0.getLabel());
        }
    });

    private final boolean omitIdentity(Syntax syntax) {
        if (getWriteIdentityValues()) {
            return false;
        }
        if (getLabel() == WireField.Label.OMIT_IDENTITY) {
            return true;
        }
        if (getLabel().isRepeated() && syntax == Syntax.PROTO_3) {
            return true;
        }
        return isMap() && syntax == Syntax.PROTO_3;
    }

    public abstract Object get(M m);

    public final ProtoAdapter<Object> getAdapter() {
        return (ProtoAdapter) this.adapter$delegate.getValue();
    }

    public abstract String getDeclaredName();

    public abstract Object getFromBuilder(B b);

    public abstract ProtoAdapter<?> getKeyAdapter();

    public abstract WireField.Label getLabel();

    public abstract String getName();

    public abstract boolean getRedacted();

    public abstract ProtoAdapter<?> getSingleAdapter();

    public abstract int getTag();

    public abstract String getWireFieldJsonName();

    public abstract boolean getWriteIdentityValues();

    public abstract boolean isMap();

    public abstract boolean isMessage();

    public final boolean omitFromJson(Syntax syntax, Object obj) {
        Intrinsics.e(syntax, "syntax");
        if (obj == null) {
            return true;
        }
        return omitIdentity(syntax) && Intrinsics.a(obj, getAdapter().getIdentity());
    }

    public abstract void set(B b, Object obj);

    public abstract void value(B b, Object obj);
}
