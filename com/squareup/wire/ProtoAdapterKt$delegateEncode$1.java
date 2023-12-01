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

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ProtoWriter protoWriter) {
        invoke2(protoWriter);
        return Unit.f42314a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ProtoWriter forwardWriter) {
        Intrinsics.e(forwardWriter, "forwardWriter");
        this.$this_delegateEncode.encode(forwardWriter, (ProtoWriter) this.$value);
    }
}
