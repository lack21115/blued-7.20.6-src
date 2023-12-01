package com.soft.blued.ui.user.viewmodel;

import android.content.Context;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.api.UserApiService;
import com.soft.blued.ui.user.state.VIPCenterState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(b = "VIPCenterTabPageViewModel.kt", c = {41}, d = "invokeSuspend", e = "com.soft.blued.ui.user.viewmodel.VIPCenterTabPageViewModel$getData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/VIPCenterTabPageViewModel$getData$1.class */
public final class VIPCenterTabPageViewModel$getData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f34357a;
    final /* synthetic */ VIPCenterTabPageViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VIPCenterTabPageViewModel$getData$1(VIPCenterTabPageViewModel vIPCenterTabPageViewModel, Continuation<? super VIPCenterTabPageViewModel$getData$1> continuation) {
        super(2, continuation);
        this.b = vIPCenterTabPageViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VIPCenterTabPageViewModel$getData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VIPCenterTabPageViewModel$getData$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiState error;
        Object a2 = IntrinsicsKt.a();
        int i = this.f34357a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f34357a = 1;
            Object b = ((UserApiService) BluedApiProxy.b().a(UserApiService.class)).b(this.b.a(), this);
            obj = b;
            if (b == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        VIPCenterTabPageViewModel vIPCenterTabPageViewModel = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                final List<T> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                boolean hasMore = bluedEntityA.hasMore();
                VIPCenterTabPageViewModel vIPCenterTabPageViewModel2 = vIPCenterTabPageViewModel;
                BluedStructureExtKt.a(vIPCenterTabPageViewModel2, new Function1<VIPCenterState, VIPCenterState>() { // from class: com.soft.blued.ui.user.viewmodel.VIPCenterTabPageViewModel$getData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final VIPCenterState invoke(VIPCenterState setState) {
                        Intrinsics.e(setState, "$this$setState");
                        return setState.a(data.get(0));
                    }
                });
                BluedStructureExtKt.a(vIPCenterTabPageViewModel2, new MviEvent.LoadFinished(true, hasMore));
            } else {
                final List b2 = CollectionsKt.b();
                VIPCenterTabPageViewModel vIPCenterTabPageViewModel3 = vIPCenterTabPageViewModel;
                BluedStructureExtKt.a(vIPCenterTabPageViewModel3, new Function1<VIPCenterState, VIPCenterState>() { // from class: com.soft.blued.ui.user.viewmodel.VIPCenterTabPageViewModel$getData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final VIPCenterState invoke(VIPCenterState setState) {
                        Intrinsics.e(setState, "$this$setState");
                        return setState.a(b2.get(0));
                    }
                });
                BluedStructureExtKt.a(vIPCenterTabPageViewModel3, new MviEvent.LoadFinished(true, false));
            }
            error = Succeed.f10631a;
        } else {
            int i2 = bluedEntityA.code;
            String message = bluedEntityA.message;
            Intrinsics.c(message, "message");
            error = new Error(i2, message);
        }
        VIPCenterTabPageViewModel vIPCenterTabPageViewModel4 = this.b;
        if (error instanceof Error) {
            Error error2 = (Error) error;
            error2.a();
            error2.b();
            BluedStructureExtKt.a(vIPCenterTabPageViewModel4, new MviEvent.LoadFinished(false, false));
        }
        final VIPCenterTabPageViewModel vIPCenterTabPageViewModel5 = this.b;
        ProfileHttpUtils.a((Context) null, new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>() { // from class: com.soft.blued.ui.user.viewmodel.VIPCenterTabPageViewModel$getData$1.3
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA2) {
                if (bluedEntityA2 == null || bluedEntityA2.data.size() <= 0) {
                    return;
                }
                VIPCenterTabPageViewModel.this.a(bluedEntityA2.data.get(0));
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), (IRequestHost) null);
        return Unit.f42314a;
    }
}
