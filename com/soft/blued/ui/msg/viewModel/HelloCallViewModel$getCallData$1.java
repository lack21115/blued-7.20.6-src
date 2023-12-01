package com.soft.blued.ui.msg.viewModel;

import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.find.model.HelloDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.msg.state.HelloCallAction;
import com.soft.blued.ui.msg.state.HelloCallState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "HelloCallViewModel.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.msg.viewModel.HelloCallViewModel$getCallData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/viewModel/HelloCallViewModel$getCallData$1.class */
public final class HelloCallViewModel$getCallData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f18918a;
    final /* synthetic */ HelloCallAction.GetHelloCallData b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ HelloCallViewModel f18919c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HelloCallViewModel$getCallData$1(HelloCallAction.GetHelloCallData getHelloCallData, HelloCallViewModel helloCallViewModel, Continuation<? super HelloCallViewModel$getCallData$1> continuation) {
        super(2, continuation);
        this.b = getHelloCallData;
        this.f18919c = helloCallViewModel;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HelloCallViewModel$getCallData$1(this.b, this.f18919c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f18918a == 0) {
            ResultKt.a(obj);
            UserHttpUtils.a(null, new BluedUIHttpResponse<BluedEntity<UserFindResult, HelloDataExtra>>(this.b.f()) { // from class: com.soft.blued.ui.msg.viewModel.HelloCallViewModel$getCallData$1.1
                {
                    super((IRequestHost) r5);
                }

                public boolean onUIFailure(int i, String str, String str2) {
                    BluedStructureExtKt.a(HelloCallViewModel.this, new MviEvent.LoadFinished(false, false));
                    return super.onUIFailure(i, str, str2);
                }

                public void onUIFinish() {
                    boolean z;
                    super.onUIFinish();
                    HelloCallViewModel helloCallViewModel = HelloCallViewModel.this;
                    z = helloCallViewModel.f18917a;
                    BluedStructureExtKt.a(helloCallViewModel, new MviEvent.LoadFinished(true, z));
                }

                public void onUIUpdate(final BluedEntity<UserFindResult, HelloDataExtra> bluedEntity) {
                    if (bluedEntity == null) {
                        return;
                    }
                    HelloCallViewModel helloCallViewModel = HelloCallViewModel.this;
                    helloCallViewModel.f18917a = bluedEntity.hasMore();
                    BluedStructureExtKt.a(helloCallViewModel, new Function1<HelloCallState, HelloCallState>() { // from class: com.soft.blued.ui.msg.viewModel.HelloCallViewModel$getCallData$1$1$onUIUpdate$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* renamed from: a */
                        public final HelloCallState invoke(HelloCallState helloCallState) {
                            Intrinsics.e(helloCallState, "$this$setState");
                            return helloCallState.a(bluedEntity);
                        }
                    });
                }

                public BluedEntity<UserFindResult, HelloDataExtra> parseData(String str) {
                    BluedEntity<UserFindResult, HelloDataExtra> parseData = super.parseData(str);
                    if (parseData != null) {
                        int size = parseData.data.size();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= size) {
                                break;
                            }
                            ((UserFindResult) parseData.data.get(i2)).distance = DistanceUtils.a(((UserFindResult) parseData.data.get(i2)).distance, BlueAppLocal.c(), false);
                            ((UserFindResult) parseData.data.get(i2)).last_operate = TimeAndDateUtils.a(AppInfo.d(), TimeAndDateUtils.c(((UserFindResult) parseData.data.get(i2)).last_operate));
                            i = i2 + 1;
                        }
                        if (parseData.extra != null) {
                            List<UserFindResult> list = ((HelloDataExtra) parseData.extra).top_data;
                            if (!(list == null || list.isEmpty())) {
                                List<UserFindResult> list2 = ((HelloDataExtra) parseData.extra).top_data;
                                Intrinsics.c(list2, "parseData.extra.top_data");
                                for (UserFindResult userFindResult : list2) {
                                    userFindResult.distance = DistanceUtils.a(userFindResult.distance, BlueAppLocal.c(), false);
                                    userFindResult.last_operate = TimeAndDateUtils.a(AppInfo.d(), TimeAndDateUtils.c(userFindResult.last_operate));
                                }
                            }
                        }
                    }
                    Intrinsics.c(parseData, "parseData");
                    return parseData;
                }
            }, String.valueOf(this.b.a()), String.valueOf(this.b.b()), this.b.c(), this.b.d(), this.b.e(), this.b.f());
            return Unit.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
