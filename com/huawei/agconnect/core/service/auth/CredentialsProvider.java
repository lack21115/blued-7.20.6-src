package com.huawei.agconnect.core.service.auth;

import com.huawei.hmf.tasks.Task;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/core/service/auth/CredentialsProvider.class */
public interface CredentialsProvider {
    Task<Token> getTokens();

    Task<Token> getTokens(boolean z);
}
