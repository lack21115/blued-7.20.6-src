package com.huawei.agconnect;

import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/CustomAuthProvider.class */
public interface CustomAuthProvider {
    Task<Token> getTokens(boolean z);

    String getUid();
}
