package com.taobao.tao.remotebusiness.auth;

import com.huawei.openalliance.ad.constant.t;
import com.igexin.push.core.b;
import com.taobao.tao.remotebusiness.a;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/auth/RemoteAuth.class */
public class RemoteAuth {
    private static final String TAG = "mtop.rb-RemoteAuth";
    private static IRemoteAuth iRemoteAuth;

    /* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/auth/RemoteAuth$AuthHandler.class */
    class AuthHandler implements AuthListener {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/auth/RemoteAuth$AuthHandler$Holder.class */
        public class Holder {
            static AuthHandler instance = new AuthHandler();

            private Holder() {
            }
        }

        private AuthHandler() {
        }

        public static AuthHandler instance() {
            return Holder.instance;
        }

        @Override // com.taobao.tao.remotebusiness.auth.AuthListener
        public void onAuthCancel(String str, String str2) {
            TBSdkLog.b(RemoteAuth.TAG, "auth cancel");
            a.a(str, str2);
        }

        @Override // com.taobao.tao.remotebusiness.auth.AuthListener
        public void onAuthFail(String str, String str2) {
            TBSdkLog.b(RemoteAuth.TAG, "auth fail");
            a.a(str, str2);
        }

        @Override // com.taobao.tao.remotebusiness.auth.AuthListener
        public void onAuthSuccess() {
            TBSdkLog.b(RemoteAuth.TAG, "auth success");
            mtopsdk.xstate.a.a(t.cN, RemoteAuth.getAuthToken());
            a.a();
        }
    }

    public static void authorize(String str, String str2, String str3, boolean z) {
        IRemoteAuth iRemoteAuth2 = iRemoteAuth;
        if (iRemoteAuth2 == null || iRemoteAuth2.isAuthorizing()) {
            return;
        }
        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.b(TAG, "call auth. bizId=" + str + " apiInfo=" + str2 + " failInfo=" + str3);
        }
        iRemoteAuth.authorize(str, str2, str3, z, AuthHandler.instance());
    }

    public static String getAuthToken() {
        IRemoteAuth iRemoteAuth2 = iRemoteAuth;
        if (iRemoteAuth2 == null) {
            return null;
        }
        return iRemoteAuth2.getAuthToken();
    }

    public static boolean isAuthInfoValid() {
        IRemoteAuth iRemoteAuth2 = iRemoteAuth;
        if (iRemoteAuth2 == null) {
            return true;
        }
        if (iRemoteAuth2.isAuthorizing()) {
            return false;
        }
        return iRemoteAuth.isAuthInfoValid();
    }

    public static void setAuthImpl(IRemoteAuth iRemoteAuth2) {
        StringBuilder sb = new StringBuilder("set auth implement. remoteAuth=");
        sb.append(iRemoteAuth2);
        TBSdkLog.a(TAG, sb.toString() != null ? iRemoteAuth2.toString() : b.l);
        iRemoteAuth = iRemoteAuth2;
    }
}
