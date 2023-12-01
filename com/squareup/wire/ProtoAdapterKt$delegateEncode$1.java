package com.squareup.wire;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ProtoAdapterKt$delegateEncode$1.class */
public final class ProtoAdapterKt$delegateEncode$1 extends Lambda implements Function1<ProtoWriter, Unit> {
    final /* synthetic */ ProtoAdapter<E> $this_delegateEncode;
    final /* synthetic */ E $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProtoAdapterKt$delegateEncode$1(ProtoAdapter<E> protoAdapter, E e) {
        super(1);
        this.$this_delegateEncode = protoAdapter;
        this.$value = e;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProtoWriter) obj);
        return Unit.a;
    }

    public final void invoke(ProtoWriter protoWriter) {
        Intrinsics.e(protoWriter, "forwardWriter");
        this.$this_delegateEncode.encode(protoWriter, (ProtoWriter) this.$value);
    }
}
