package com.blued.android.modules;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.base.user.IUser;
import com.blued.android.module.base.user.UserProxy;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.live_china.model.PayRemaining;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/UserModule.class */
class UserModule {
    private static IUser a = new IUser() { // from class: com.blued.android.modules.UserModule.1

        /* renamed from: com.blued.android.modules.UserModule$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/UserModule$1$1.class */
        class C01581 extends BluedUIHttpResponse<BluedEntityA<PayRemaining>> {
            final /* synthetic */ IUser.IWandouBalanceListener a;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayRemaining> bluedEntityA) {
                PayRemaining payRemaining;
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (payRemaining = bluedEntityA.data.get(0)) == null) {
                    return;
                }
                double d = payRemaining.beans + payRemaining.bonus;
                IUser.IWandouBalanceListener iWandouBalanceListener = this.a;
                if (iWandouBalanceListener != null) {
                    iWandouBalanceListener.a(d);
                }
                UserInfo.getInstance().setUserPrice(d);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                IUser.IWandouBalanceListener iWandouBalanceListener = this.a;
                if (iWandouBalanceListener != null) {
                    iWandouBalanceListener.a(th, 0, null);
                }
            }
        }

        @Override // com.blued.android.module.base.user.IUser
        public String a() {
            return UserInfo.getInstance().getLoginUserInfo().getVBadge() + "";
        }
    };

    UserModule() {
    }

    public static void a() {
        UserProxy.b().a(a);
    }
}
