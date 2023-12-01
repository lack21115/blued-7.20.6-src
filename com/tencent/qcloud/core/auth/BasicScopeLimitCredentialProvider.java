package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudClientException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/BasicScopeLimitCredentialProvider.class */
public abstract class BasicScopeLimitCredentialProvider implements ScopeLimitCredentialProvider {
    private static final int MAX_CACHE_CREDENTIAL_SIZE = 100;
    private Map<Integer, SessionQCloudCredentials> credentialPairs = new HashMap(100);

    private void cacheCredentialsAndCleanUp(int i, SessionQCloudCredentials sessionQCloudCredentials) {
        synchronized (this) {
            Iterator<Map.Entry<Integer, SessionQCloudCredentials>> it = this.credentialPairs.entrySet().iterator();
            while (it.hasNext()) {
                if (!it.next().getValue().isValid()) {
                    it.remove();
                }
            }
            if (this.credentialPairs.size() > 100) {
                Iterator<Map.Entry<Integer, SessionQCloudCredentials>> it2 = this.credentialPairs.entrySet().iterator();
                for (int size = this.credentialPairs.size() - 100; it2.hasNext() && size > 0; size--) {
                    it2.remove();
                }
            }
            this.credentialPairs.put(Integer.valueOf(i), sessionQCloudCredentials);
        }
    }

    private SessionQCloudCredentials lookupValidCredentials(int i) {
        synchronized (this) {
            SessionQCloudCredentials sessionQCloudCredentials = this.credentialPairs.get(Integer.valueOf(i));
            if (sessionQCloudCredentials != null) {
                if (sessionQCloudCredentials.isValid()) {
                    return sessionQCloudCredentials;
                }
            }
            return null;
        }
    }

    protected abstract SessionQCloudCredentials fetchNewCredentials(STSCredentialScope[] sTSCredentialScopeArr) throws QCloudClientException;

    @Override // com.tencent.qcloud.core.auth.QCloudCredentialProvider
    public QCloudCredentials getCredentials() throws QCloudClientException {
        throw new UnsupportedOperationException("not support ths op");
    }

    @Override // com.tencent.qcloud.core.auth.ScopeLimitCredentialProvider
    public SessionQCloudCredentials getCredentials(STSCredentialScope[] sTSCredentialScopeArr) throws QCloudClientException {
        int hashCode = STSCredentialScope.jsonify(sTSCredentialScopeArr).hashCode();
        SessionQCloudCredentials lookupValidCredentials = lookupValidCredentials(hashCode);
        SessionQCloudCredentials sessionQCloudCredentials = lookupValidCredentials;
        if (lookupValidCredentials == null) {
            sessionQCloudCredentials = fetchNewCredentials(sTSCredentialScopeArr);
            cacheCredentialsAndCleanUp(hashCode, sessionQCloudCredentials);
        }
        return sessionQCloudCredentials;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudCredentialProvider
    public void refresh() {
    }
}
