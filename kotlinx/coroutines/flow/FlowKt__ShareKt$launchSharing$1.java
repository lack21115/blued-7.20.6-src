package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
@Metadata
@DebugMetadata(b = "Share.kt", c = {206, 210, 211, 217}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ShareKt$launchSharing$1.class */
final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43279a;
    final /* synthetic */ SharingStarted b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Flow<T> f43280c;
    final /* synthetic */ MutableSharedFlow<T> d;
    final /* synthetic */ T e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "Share.kt", c = {}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ShareKt$launchSharing$1$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f43281a;
        /* synthetic */ int b;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Object a(int i, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.b = ((Number) obj).intValue();
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Integer num, Continuation<? super Boolean> continuation) {
            return a(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.a();
            if (this.f43281a == 0) {
                ResultKt.a(obj);
                return Boxing.a(this.b > 0);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "Share.kt", c = {219}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ShareKt$launchSharing$1$2.class */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f43282a;
        /* synthetic */ Object b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Flow<T> f43283c;
        final /* synthetic */ MutableSharedFlow<T> d;
        final /* synthetic */ T e;

        @Metadata
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$WhenMappings */
        /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ShareKt$launchSharing$1$2$WhenMappings.class */
        public final /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f43284a;

            static {
                int[] iArr = new int[SharingCommand.valuesCustom().length];
                iArr[SharingCommand.START.ordinal()] = 1;
                iArr[SharingCommand.STOP.ordinal()] = 2;
                iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                f43284a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Flow<? extends T> flow, MutableSharedFlow<T> mutableSharedFlow, T t, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.f43283c = flow;
            this.d = mutableSharedFlow;
            this.e = t;
        }

        public final Object a(SharingCommand sharingCommand, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(sharingCommand, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f43283c, this.d, this.e, continuation);
            anonymousClass2.b = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(SharingCommand sharingCommand, Continuation<? super Unit> continuation) {
            return a(sharingCommand, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object a2 = IntrinsicsKt.a();
            int i = this.f43282a;
            if (i == 0) {
                ResultKt.a(obj);
                int i2 = WhenMappings.f43284a[((SharingCommand) this.b).ordinal()];
                if (i2 == 1) {
                    this.f43282a = 1;
                    if (this.f43283c.a(this.d, this) == a2) {
                        return a2;
                    }
                } else if (i2 == 3) {
                    if (this.e == SharedFlowKt.f43416a) {
                        this.d.b();
                    } else {
                        this.d.a(this.e);
                    }
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
    FlowKt__ShareKt$launchSharing$1(SharingStarted sharingStarted, Flow<? extends T> flow, MutableSharedFlow<T> mutableSharedFlow, T t, Continuation<? super FlowKt__ShareKt$launchSharing$1> continuation) {
        super(2, continuation);
        this.b = sharingStarted;
        this.f43280c = flow;
        this.d = mutableSharedFlow;
        this.e = t;
    }

    public final Object a(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FlowKt__ShareKt$launchSharing$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowKt__ShareKt$launchSharing$1(this.b, this.f43280c, this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return a(coroutineScope, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
