package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3.class */
public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3<R> implements Flow<R> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Flow[] f43346a;
    final /* synthetic */ Function6 b;

    @Metadata
    @DebugMetadata(b = "Zip.kt", c = {333, 333}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2.class */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f43347a;
        /* synthetic */ Object b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Function6 f43348c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Continuation continuation, Function6 function6) {
            super(3, continuation);
            this.f43348c = function6;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object a(Object obj, Object[] objArr, Continuation<? super Unit> continuation) {
            return a((FlowCollector) ((FlowCollector) obj), objArr, continuation);
        }

        public final Object a(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation, this.f43348c);
            anonymousClass2.d = flowCollector;
            anonymousClass2.b = objArr;
            return anonymousClass2.invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object a2 = IntrinsicsKt.a();
            int i = this.f43347a;
            if (i == 0) {
                ResultKt.a(obj);
                flowCollector = (FlowCollector) this.d;
                Object[] objArr = (Object[]) this.b;
                Function6 function6 = this.f43348c;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                this.d = flowCollector;
                this.f43347a = 1;
                InlineMarker.a(6);
                Object a3 = function6.a(obj2, obj3, obj4, obj5, obj6, this);
                InlineMarker.a(7);
                obj = a3;
                if (a3 == a2) {
                    return a2;
                }
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.a(obj);
                    return Unit.f42314a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                flowCollector = (FlowCollector) this.d;
                ResultKt.a(obj);
            }
            this.d = null;
            this.f43347a = 2;
            if (flowCollector.emit(obj, this) == a2) {
                return a2;
            }
            return Unit.f42314a;
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector flowCollector, Continuation continuation) {
        Function0 b;
        Flow[] flowArr = this.f43346a;
        b = FlowKt__ZipKt.b();
        Object a2 = CombineKt.a(flowCollector, flowArr, b, new AnonymousClass2(null, this.b), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
