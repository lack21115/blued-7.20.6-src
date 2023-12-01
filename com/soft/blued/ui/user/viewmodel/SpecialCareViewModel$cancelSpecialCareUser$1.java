package com.soft.blued.ui.user.viewmodel;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.soft.blued.R;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.user.state.SpecialCareAction;
import com.soft.blued.ui.user.viewmodel.SpecialCareViewModel$cancelSpecialCareUser$1;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "SpecialCareViewModel.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.user.viewmodel.SpecialCareViewModel$cancelSpecialCareUser$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/SpecialCareViewModel$cancelSpecialCareUser$1.class */
final class SpecialCareViewModel$cancelSpecialCareUser$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f34349a;
    final /* synthetic */ SpecialCareAction.cancelSpecialCareUser b;

    @Metadata
    /* renamed from: com.soft.blued.ui.user.viewmodel.SpecialCareViewModel$cancelSpecialCareUser$1$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/SpecialCareViewModel$cancelSpecialCareUser$1$2.class */
    public static final class AnonymousClass2 extends BluedUIHttpResponse<BluedEntityA<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpecialCareAction.cancelSpecialCareUser f34350a;

        AnonymousClass2(SpecialCareAction.cancelSpecialCareUser cancelspecialcareuser) {
            this.f34350a = cancelspecialcareuser;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(SessionSettingBaseModel sessionSettingBaseModel) {
            if (sessionSettingBaseModel == null || !(sessionSettingBaseModel instanceof SessionSettingModel)) {
                return;
            }
            SessionSettingModel sessionSettingModel = (SessionSettingModel) sessionSettingBaseModel;
            sessionSettingModel.setSessionCommonStatus("0");
            ChatManager.getInstance().setSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), sessionSettingBaseModel);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            boolean z = false;
            if (bluedEntityA != null && bluedEntityA.code == 4031101) {
                z = true;
            }
            if (z) {
                AppMethods.d((int) R.string.msg_special_care_pay_vip_to_set);
                return;
            }
            for (String str : this.f34350a.a()) {
                ChatManager.getInstance().getSessionSettingModel((short) 2, Long.parseLong(str), new FetchDataListener() { // from class: com.soft.blued.ui.user.viewmodel.-$$Lambda$SpecialCareViewModel$cancelSpecialCareUser$1$2$FMnKsWH7L_buRa-ytRZY8AzueY8
                    @Override // com.blued.android.chat.listener.FetchDataListener
                    public final void onFetchData(Object obj) {
                        SpecialCareViewModel$cancelSpecialCareUser$1.AnonymousClass2.a((SessionSettingBaseModel) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecialCareViewModel$cancelSpecialCareUser$1(SpecialCareAction.cancelSpecialCareUser cancelspecialcareuser, Continuation<? super SpecialCareViewModel$cancelSpecialCareUser$1> continuation) {
        super(2, continuation);
        this.b = cancelspecialcareuser;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpecialCareViewModel$cancelSpecialCareUser$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpecialCareViewModel$cancelSpecialCareUser$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f34349a == 0) {
            ResultKt.a(obj);
            List<String> a2 = this.b.a();
            SpecialCareAction.cancelSpecialCareUser cancelspecialcareuser = this.b;
            int i = 0;
            String str = "";
            for (String str2 : a2) {
                if (i < 0) {
                    CollectionsKt.c();
                }
                String str3 = str2;
                str = i != cancelspecialcareuser.a().size() ? str + str3 + ',' : Intrinsics.a(str, (Object) str3);
                i++;
            }
            UserHttpUtils.c(str, new AnonymousClass2(this.b), (IRequestHost) null);
            return Unit.f42314a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
