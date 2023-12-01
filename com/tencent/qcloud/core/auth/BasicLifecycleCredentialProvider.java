package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudAuthenticationException;
import com.tencent.qcloud.core.common.QCloudClientException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider.class */
public abstract class BasicLifecycleCredentialProvider implements QCloudCredentialProvider {
    private volatile QCloudLifecycleCredentials credentials;
    private ReentrantLock lock = new ReentrantLock();

    private QCloudLifecycleCredentials safeGetCredentials() {
        QCloudLifecycleCredentials qCloudLifecycleCredentials;
        synchronized (this) {
            qCloudLifecycleCredentials = this.credentials;
        }
        return qCloudLifecycleCredentials;
    }

    private void safeSetCredentials(QCloudLifecycleCredentials qCloudLifecycleCredentials) {
        synchronized (this) {
            this.credentials = qCloudLifecycleCredentials;
        }
    }

    protected abstract QCloudLifecycleCredentials fetchNewCredentials() throws QCloudClientException;

    @Override // com.tencent.qcloud.core.auth.QCloudCredentialProvider
    public QCloudCredentials getCredentials() throws QCloudClientException {
        QCloudLifecycleCredentials safeGetCredentials = safeGetCredentials();
        if (safeGetCredentials == null || !safeGetCredentials.isValid()) {
            refresh();
            return safeGetCredentials();
        }
        return safeGetCredentials;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudCredentialProvider
    public void refresh() throws QCloudClientException {
        try {
            try {
                boolean tryLock = this.lock.tryLock(20L, TimeUnit.SECONDS);
                if (!tryLock) {
                    throw new QCloudClientException(new QCloudAuthenticationException("lock timeout, no credential for sign"));
                }
                QCloudLifecycleCredentials safeGetCredentials = safeGetCredentials();
                if (safeGetCredentials == null || !safeGetCredentials.isValid()) {
                    safeSetCredentials(null);
                    try {
                        safeSetCredentials(fetchNewCredentials());
                    } catch (Exception e) {
                        if (e instanceof QCloudClientException) {
                            throw e;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("fetch credentials error happens: ");
                        sb.append(e.getMessage());
                        throw new QCloudClientException(sb.toString(), new QCloudAuthenticationException(e.getMessage()));
                    }
                }
                if (tryLock) {
                    this.lock.unlock();
                }
            } catch (InterruptedException e2) {
                throw new QCloudClientException("interrupt when try to get credential", new QCloudAuthenticationException(e2.getMessage()));
            }
        } catch (Throwable th) {
            if (0 != 0) {
                this.lock.unlock();
            }
            throw th;
        }
    }
}
