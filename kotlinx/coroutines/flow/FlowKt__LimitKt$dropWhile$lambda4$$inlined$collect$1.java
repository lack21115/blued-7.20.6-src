package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$lambda-4$$inlined$collect$1  reason: invalid class name */
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__LimitKt$dropWhile$lambda-4$$inlined$collect$1.class */
public final class FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1<T> implements FlowCollector<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f43190a;
    final /* synthetic */ FlowCollector b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function2 f43191c;

    @Metadata
    @DebugMetadata(b = "Limit.kt", c = {136, 137, 139}, d = "emit", e = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$lambda-4$$inlined$collect$1")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$lambda-4$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__LimitKt$dropWhile$lambda-4$$inlined$collect$1$1.class */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f43192a;
        int b;
        Object d;
        Object e;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f43192a = obj;
            this.b |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1(Ref.BooleanRef booleanRef, FlowCollector flowCollector, Function2 function2) {
        this.f43190a = booleanRef;
        this.b = flowCollector;
        this.f43191c = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fb  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object emit(T r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
