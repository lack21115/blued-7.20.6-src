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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
@DebugMetadata(b = "Zip.kt", c = {273}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4.class */
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    int a;
    final /* synthetic */ Flow[] b;
    final /* synthetic */ Function6 c;
    private /* synthetic */ Object d;

    @Metadata
    @DebugMetadata(b = "Zip.kt", c = {ImsReasonInfo.CODE_SIP_NOT_FOUND}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4$1")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {
        int a;
        /* synthetic */ Object b;
        final /* synthetic */ Function6 c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Continuation continuation, Function6 function6) {
            super(3, continuation);
            this.c = function6;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object a(Object obj, Object[] objArr, Continuation<? super Unit> continuation) {
            return a((FlowCollector) ((FlowCollector) obj), objArr, continuation);
        }

        public final Object a(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation, this.c);
            anonymousClass1.d = flowCollector;
            anonymousClass1.b = objArr;
            return anonymousClass1.invokeSuspend(Unit.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object a = IntrinsicsKt.a();
            int i = this.a;
            if (i == 0) {
                ResultKt.a(obj);
                FlowCollector flowCollector = (FlowCollector) this.d;
                Object[] objArr = (Object[]) this.b;
                Function6 function6 = this.c;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                this.a = 1;
                InlineMarker.a(6);
                Object a2 = function6.a(flowCollector, obj2, obj3, obj4, obj5, this);
                InlineMarker.a(7);
                if (a2 == a) {
                    return a;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.a(obj);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4(Flow[] flowArr, Continuation continuation, Function6 function6) {
        super(2, continuation);
        this.b = flowArr;
        this.c = function6;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        return ((FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4) create(flowCollector, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4 flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4 = new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4(this.b, continuation, this.c);
        flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4.d = obj;
        return flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function0 b;
        Object a = IntrinsicsKt.a();
        int i = this.a;
        if (i == 0) {
            ResultKt.a(obj);
            FlowCollector flowCollector = (FlowCollector) this.d;
            Flow[] flowArr = this.b;
            b = FlowKt__ZipKt.b();
            this.a = 1;
            if (CombineKt.a(flowCollector, flowArr, b, new AnonymousClass1(null, this.c), this) == a) {
                return a;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        return Unit.a;
    }
}
