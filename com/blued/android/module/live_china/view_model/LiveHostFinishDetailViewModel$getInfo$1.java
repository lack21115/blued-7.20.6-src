package com.blued.android.module.live_china.view_model;

import com.blued.android.module.live_china.view_model.LiveHostFinishDetailViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "LiveHostFinishDetailViewModel.kt", c = {43, 52, 61, 70, 79, 88, 97, 106, 115}, d = "invokeSuspend", e = "com.blued.android.module.live_china.view_model.LiveHostFinishDetailViewModel$getInfo$1")
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel$getInfo$1.class */
final class LiveHostFinishDetailViewModel$getInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f15472a;
    final /* synthetic */ LiveHostFinishDetailViewModel.ApiState b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f15473c;
    final /* synthetic */ LiveHostFinishDetailViewModel d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveHostFinishDetailViewModel$getInfo$1(LiveHostFinishDetailViewModel.ApiState apiState, int i, LiveHostFinishDetailViewModel liveHostFinishDetailViewModel, Continuation<? super LiveHostFinishDetailViewModel$getInfo$1> continuation) {
        super(2, continuation);
        this.b = apiState;
        this.f15473c = i;
        this.d = liveHostFinishDetailViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LiveHostFinishDetailViewModel$getInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LiveHostFinishDetailViewModel$getInfo$1(this.b, this.f15473c, this.d, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0765  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x078e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0449  */
    /* JADX WARN: Type inference failed for: r1v50, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v53, types: [java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 1957
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view_model.LiveHostFinishDetailViewModel$getInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
