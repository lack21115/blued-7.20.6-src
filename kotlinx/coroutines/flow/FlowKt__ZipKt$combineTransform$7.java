package kotlinx.coroutines.flow;

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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
@DebugMetadata(b = "Zip.kt", c = {308}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7.class */
public final class FlowKt__ZipKt$combineTransform$7<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43393a;
    final /* synthetic */ Flow<T>[] b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> f43394c;
    private /* synthetic */ Object d;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata
    @DebugMetadata(b = "Zip.kt", c = {308}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7$2.class */
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f43396a;
        /* synthetic */ Object b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> f43397c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.f43397c = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object a(FlowCollector<? super R> flowCollector, T[] tArr, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f43397c, continuation);
            anonymousClass2.d = flowCollector;
            anonymousClass2.b = tArr;
            return anonymousClass2.invokeSuspend(Unit.f42314a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object a2 = IntrinsicsKt.a();
            int i = this.f43396a;
            if (i == 0) {
                ResultKt.a(obj);
                FlowCollector flowCollector = (FlowCollector) this.d;
                Object[] objArr = (Object[]) this.b;
                this.d = null;
                this.f43396a = 1;
                if (this.f43397c.a(flowCollector, objArr, this) == a2) {
                    return a2;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.a(obj);
            }
            return Unit.f42314a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransform$7(Flow<T>[] flowArr, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combineTransform$7> continuation) {
        super(2, continuation);
        this.b = flowArr;
        this.f43394c = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        return ((FlowKt__ZipKt$combineTransform$7) create(flowCollector, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__ZipKt$combineTransform$7 flowKt__ZipKt$combineTransform$7 = new FlowKt__ZipKt$combineTransform$7(this.b, this.f43394c, continuation);
        flowKt__ZipKt$combineTransform$7.d = obj;
        return flowKt__ZipKt$combineTransform$7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f43393a;
        if (i == 0) {
            ResultKt.a(obj);
            FlowCollector flowCollector = (FlowCollector) this.d;
            Flow<T>[] flowArr = this.b;
            Intrinsics.d();
            final Flow<T>[] flowArr2 = this.b;
            this.f43393a = 1;
            if (CombineKt.a(flowCollector, flowArr, new Function0<T[]>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: a */
                public final T[] invoke() {
                    int length = flowArr2.length;
                    Intrinsics.a(0, "T?");
                    return (T[]) new Object[length];
                }
            }, new AnonymousClass2(this.f43394c, null), this) == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        return Unit.f42314a;
    }
}
