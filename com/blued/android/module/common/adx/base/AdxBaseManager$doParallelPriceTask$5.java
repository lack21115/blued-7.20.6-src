package com.blued.android.module.common.adx.base;

import com.android.internal.telephony.RILConstants;
import com.blued.android.module.common.login.model.BluedADExtra;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata
@DebugMetadata(b = "AdxBaseManager.kt", c = {RILConstants.RIL_UNSOL_CALL_RING, 1407}, d = "invokeSuspend", e = "com.blued.android.module.common.adx.base.AdxBaseManager$doParallelPriceTask$5")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$doParallelPriceTask$5.class */
final class AdxBaseManager$doParallelPriceTask$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int a;
    final /* synthetic */ AdxBaseManager b;
    final /* synthetic */ List<BluedADExtra> c;
    final /* synthetic */ List<BluedADExtra> d;
    final /* synthetic */ CoroutineScope e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdxBaseManager$doParallelPriceTask$5(AdxBaseManager adxBaseManager, List<? extends BluedADExtra> list, List<? extends BluedADExtra> list2, CoroutineScope coroutineScope, Continuation<? super AdxBaseManager$doParallelPriceTask$5> continuation) {
        super(2, continuation);
        this.b = adxBaseManager;
        this.c = list;
        this.d = list2;
        this.e = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdxBaseManager$doParallelPriceTask$5) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdxBaseManager$doParallelPriceTask$5(this.b, this.c, this.d, this.e, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a = IntrinsicsKt.a();
        int i = this.a;
        if (i == 0) {
            ResultKt.a(obj);
            this.a = 1;
            Object a2 = this.b.a(this.c, this);
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
            ResultKt.a(obj);
        }
        Flow a3 = FlowKt.a(FlowKt.a(FlowKt.a((Function2) new AdxBaseManager$doParallelPriceTask$5$invokeSuspend$$inlined$transform$1((Flow) obj, null)), Dispatchers.b()));
        final AdxBaseManager adxBaseManager = this.b;
        final List<BluedADExtra> list = this.d;
        final CoroutineScope coroutineScope = this.e;
        this.a = 2;
        if (a3.a(new FlowCollector<ADEvent>() { // from class: com.blued.android.module.common.adx.base.AdxBaseManager$doParallelPriceTask$5$invokeSuspend$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(ADEvent aDEvent, Continuation<? super Unit> continuation) {
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                ADEvent aDEvent2 = aDEvent;
                BaseNativeExpressAd model = (BaseNativeExpressAd) aDEvent2.a(BaseNativeExpressAd.class);
                Map<String, Object> d = model.d();
                Object obj2 = d == null ? null : d.get("original_ad");
                if (obj2 != null) {
                    BluedADExtra bluedADExtra = (BluedADExtra) obj2;
                    arrayList = AdxBaseManager.this.e;
                    Iterator it = arrayList.iterator();
                    Intrinsics.c(it, "noBiddingTaskList.iterator()");
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((BluedADExtra) it.next()).price == ((BluedADExtra) list.get(0)).price) {
                            it.remove();
                            break;
                        }
                    }
                    if (aDEvent2.getType() == 100) {
                        AdxBaseManager adxBaseManager2 = AdxBaseManager.this;
                        Intrinsics.c(model, "model");
                        arrayList3 = AdxBaseManager.this.b;
                        adxBaseManager2.a(bluedADExtra, model, (List<? extends BluedADExtra>) arrayList3, false);
                        AdxBaseManager.this.a("「**同价格最先**」成功回来的广告任务：", bluedADExtra);
                        CoroutineScopeKt.a(coroutineScope, null, 1, null);
                    } else if (aDEvent2.getType() == 101) {
                        AdxBaseManager adxBaseManager3 = AdxBaseManager.this;
                        Intrinsics.c(model, "model");
                        arrayList2 = AdxBaseManager.this.b;
                        adxBaseManager3.a(bluedADExtra, model, arrayList2);
                    }
                    return Unit.a;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
            }
        }, this) == a) {
            return a;
        }
        return Unit.a;
    }
}
