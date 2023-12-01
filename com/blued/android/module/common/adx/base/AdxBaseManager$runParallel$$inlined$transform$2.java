package com.blued.android.module.common.adx.base;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@DebugMetadata(b = "AdxBaseManager.kt", c = {223}, d = "invokeSuspend", e = "com.blued.android.module.common.adx.base.AdxBaseManager$runParallel$$inlined$transform$2")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$runParallel$$inlined$transform$2.class */
public final class AdxBaseManager$runParallel$$inlined$transform$2 extends SuspendLambda implements Function2<FlowCollector<? super ADEvent>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f10476a;
    final /* synthetic */ Flow b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ Object f10477c;

    @Metadata
    /* renamed from: com.blued.android.module.common.adx.base.AdxBaseManager$runParallel$$inlined$transform$2$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$runParallel$$inlined$transform$2$1.class */
    public static final class AnonymousClass1 implements FlowCollector<IBaseAd> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlowCollector f10478a;

        @Metadata
        @DebugMetadata(b = "AdxBaseManager.kt", c = {136, 136}, d = "emit", e = "com.blued.android.module.common.adx.base.AdxBaseManager$runParallel$$inlined$transform$2$1")
        /* renamed from: com.blued.android.module.common.adx.base.AdxBaseManager$runParallel$$inlined$transform$2$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$runParallel$$inlined$transform$2$1$1.class */
        public static final class C02141 extends ContinuationImpl {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f10479a;
            int b;
            Object d;

            public C02141(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f10479a = obj;
                this.b |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector) {
            this.f10478a = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00c3  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object emit(com.blued.android.module.common.adx.base.IBaseAd r6, kotlin.coroutines.Continuation r7) {
            /*
                Method dump skipped, instructions count: 202
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.base.AdxBaseManager$runParallel$$inlined$transform$2.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxBaseManager$runParallel$$inlined$transform$2(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.b = flow;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(FlowCollector<? super ADEvent> flowCollector, Continuation<? super Unit> continuation) {
        return ((AdxBaseManager$runParallel$$inlined$transform$2) create(flowCollector, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AdxBaseManager$runParallel$$inlined$transform$2 adxBaseManager$runParallel$$inlined$transform$2 = new AdxBaseManager$runParallel$$inlined$transform$2(this.b, continuation);
        adxBaseManager$runParallel$$inlined$transform$2.f10477c = obj;
        return adxBaseManager$runParallel$$inlined$transform$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f10476a;
        if (i == 0) {
            ResultKt.a(obj);
            FlowCollector flowCollector = (FlowCollector) this.f10477c;
            this.f10476a = 1;
            if (this.b.a(new AnonymousClass1(flowCollector), this) == a2) {
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
