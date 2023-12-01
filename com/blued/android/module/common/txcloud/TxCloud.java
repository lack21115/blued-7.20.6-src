package com.blued.android.module.common.txcloud;

import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.tencent.cos.xml.CosXmlService;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.qcloud.core.auth.BasicLifecycleCredentialProvider;
import com.tencent.qcloud.core.auth.QCloudLifecycleCredentials;
import com.tencent.qcloud.core.auth.SessionQCloudCredentials;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/txcloud/TxCloud.class */
public final class TxCloud {
    public static final TxCloud a = new TxCloud();
    private static CredentialsInfo b;
    private static CosXmlService c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/txcloud/TxCloud$SessionCredentialProvider.class */
    public static final class SessionCredentialProvider extends BasicLifecycleCredentialProvider {
        public QCloudLifecycleCredentials fetchNewCredentials() {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String a = Intrinsics.a(BluedHttpUrl.q(), (Object) "/blued/tencent/cos-key");
            BluedUIHttpResponse<BluedEntityA<CredentialsInfo>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<CredentialsInfo>>() { // from class: com.blued.android.module.common.txcloud.TxCloud$SessionCredentialProvider$fetchNewCredentials$resp$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(null);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<CredentialsInfo> resp) {
                    Intrinsics.e(resp, "resp");
                    if (resp.hasData()) {
                        objectRef.a = resp.getSingleData();
                    }
                }
            };
            bluedUIHttpResponse.setRunUiThread(false);
            HttpManager.a(a, bluedUIHttpResponse).b(BluedHttpTools.a(true)).f().h();
            String str = null;
            if (objectRef.a != 0) {
                CredentialsInfo credentialsInfo = (CredentialsInfo) objectRef.a;
                String tmp_secret_id = credentialsInfo == null ? null : credentialsInfo.getTmp_secret_id();
                CredentialsInfo credentialsInfo2 = (CredentialsInfo) objectRef.a;
                String tmp_secret_key = credentialsInfo2 == null ? null : credentialsInfo2.getTmp_secret_key();
                CredentialsInfo credentialsInfo3 = (CredentialsInfo) objectRef.a;
                if (credentialsInfo3 != null) {
                    str = credentialsInfo3.getSession_token();
                }
                CredentialsInfo credentialsInfo4 = (CredentialsInfo) objectRef.a;
                long start_time = credentialsInfo4 == null ? 0L : credentialsInfo4.getStart_time();
                CredentialsInfo credentialsInfo5 = (CredentialsInfo) objectRef.a;
                return new SessionQCloudCredentials(tmp_secret_id, tmp_secret_key, str, start_time, credentialsInfo5 == null ? 0L : credentialsInfo5.getExpired_time());
            }
            return null;
        }
    }

    private TxCloud() {
    }

    private final void d() {
        CosXmlServiceConfig.Builder builder = new CosXmlServiceConfig.Builder();
        CredentialsInfo credentialsInfo = b;
        c = new CosXmlService(AppInfo.d(), builder.setRegion(credentialsInfo == null ? null : credentialsInfo.getRegion()).isHttps(true).builder(), new SessionCredentialProvider());
    }

    public final CredentialsInfo a() {
        return b;
    }

    public final void a(CredentialsInfo credentialsInfo) {
        b = credentialsInfo;
    }

    public final CosXmlService b() {
        if (b != null) {
            if (c == null) {
                d();
            }
            return c;
        }
        throw new RuntimeException("CredentialsInfo is null");
    }

    public final void c() {
        b = null;
        c = null;
    }
}
