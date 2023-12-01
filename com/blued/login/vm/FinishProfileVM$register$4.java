package com.blued.login.vm;

import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.BluedLoginResultVerBinding;
import com.blued.login.R;
import com.blued.login.api.LoginService;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.model.LoginAVConfigExtra;
import com.blued.login.model.ProfileInfoModel;
import com.google.gson.Gson;
import java.util.HashMap;
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
@DebugMetadata(b = "FinishProfileVM.kt", c = {152}, d = "invokeSuspend", e = "com.blued.login.vm.FinishProfileVM$register$4")
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/FinishProfileVM$register$4.class */
final class FinishProfileVM$register$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f7003a;
    final /* synthetic */ HashMap<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ProfileInfoModel f7004c;
    final /* synthetic */ FinishProfileVM d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinishProfileVM$register$4(HashMap<String, String> hashMap, ProfileInfoModel profileInfoModel, FinishProfileVM finishProfileVM, Continuation<? super FinishProfileVM$register$4> continuation) {
        super(2, continuation);
        this.b = hashMap;
        this.f7004c = profileInfoModel;
        this.d = finishProfileVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FinishProfileVM$register$4(this.b, this.f7004c, this.d, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f7003a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f7003a = 1;
            Object b = ((LoginService) BluedApiProxy.b().a(LoginService.class)).b(this.b, (Continuation) this);
            obj = b;
            if (b == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntity bluedEntity = (BluedEntity) obj;
        ProfileInfoModel profileInfoModel = this.f7004c;
        FinishProfileVM finishProfileVM = this.d;
        if (bluedEntity.code == 200) {
            if (bluedEntity.hasData()) {
                Object obj2 = bluedEntity.data.get(0);
                BluedEntityBaseExtra bluedEntityBaseExtra = bluedEntity.extra;
                bluedEntity.hasMore();
                LoginAVConfigExtra loginAVConfigExtra = (LoginAVConfigExtra) bluedEntityBaseExtra;
                BluedLoginResult bluedLoginResult = (BluedLoginResult) obj2;
                if (bluedLoginResult != null) {
                    try {
                        Gson f = AppInfo.f();
                        BluedEntityA bluedEntityA = new BluedEntityA();
                        bluedEntityA.data = CollectionsKt.d(new BluedLoginResult[]{bluedLoginResult});
                        String json = f.toJson(bluedEntityA);
                        Intrinsics.c(json, "gson.toJson(bluedEntityA)");
                        profileInfoModel.n(json);
                        BluedLoginResult bluedLoginResult2 = (BluedLoginResult) f.fromJson(AesCrypto2.a(bluedLoginResult.getEncrypted()), (Class<Object>) BluedLoginResult.class);
                        if (profileInfoModel.k() == 1) {
                            if (bluedLoginResult2.getVerified_bindings() == null) {
                                bluedLoginResult2.setVerified_bindings(new BluedLoginResultVerBinding());
                            }
                            bluedLoginResult2.getVerified_bindings().mobile = profileInfoModel.m();
                        }
                        LoginServiceManager.a().a(bluedLoginResult2, loginAVConfigExtra, profileInfoModel, finishProfileVM.getContext());
                        finishProfileVM.c().setValue(null);
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.d(R.string.common_net_error);
                    }
                }
            }
            ApiState apiState = Succeed.a;
        } else {
            int i2 = bluedEntity.code;
            String str = bluedEntity.message;
            Intrinsics.c(str, "message");
            new Error(i2, str);
        }
        return Unit.a;
    }
}
