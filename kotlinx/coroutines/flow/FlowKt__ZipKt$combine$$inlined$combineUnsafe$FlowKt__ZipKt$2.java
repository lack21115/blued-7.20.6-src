package kotlinx.coroutines.flow;

import com.android.ims.ImsReasonInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2.class */
public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2<R> implements Flow<R> {
    final /* synthetic */ Flow[] a;
    final /* synthetic */ Function5 b;

    @Metadata
    @DebugMetadata(b = "Zip.kt", c = {ImsReasonInfo.CODE_SIP_NOT_FOUND, ImsReasonInfo.CODE_SIP_NOT_FOUND}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2.class */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {
        int a;
        /* synthetic */ Object b;
        final /* synthetic */ Function5 c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Continuation continuation, Function5 function5) {
            super(3, continuation);
            this.c = function5;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object a(Object obj, Object[] objArr, Continuation<? super Unit> continuation) {
            return a((FlowCollector) ((FlowCollector) obj), objArr, continuation);
        }

        public final Object a(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation, this.c);
            anonymousClass2.d = flowCollector;
            anonymousClass2.b = objArr;
            return anonymousClass2.invokeSuspend(Unit.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object a = IntrinsicsKt.a();
            int i = this.a;
            if (i == 0) {
                ResultKt.a(obj);
                flowCollector = (FlowCollector) this.d;
                Object[] objArr = (Object[]) this.b;
                Function5 function5 = this.c;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                this.d = flowCollector;
                this.a = 1;
                InlineMarker.a(6);
                Object a2 = function5.a(obj2, obj3, obj4, obj5, this);
                InlineMarker.a(7);
                obj = a2;
                if (a2 == a) {
                    return a;
                }
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.a(obj);
                    return Unit.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                flowCollector = (FlowCollector) this.d;
                ResultKt.a(obj);
            }
            this.d = null;
            this.a = 2;
            if (flowCollector.emit(obj, this) == a) {
                return a;
            }
            return Unit.a;
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector flowCollector, Continuation continuation) {
        Function0 b;
        Flow[] flowArr = this.a;
        b = FlowKt__ZipKt.b();
        Object a = CombineKt.a(flowCollector, flowArr, b, new AnonymousClass2(null, this.b), continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }
}
