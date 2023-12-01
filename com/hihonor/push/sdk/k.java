package com.hihonor.push.sdk;

import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.common.data.UpMsgType;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/k.class */
public class k {
    public Void a(boolean z) throws ApiException {
        try {
            q0 q0Var = new q0(z ? UpMsgType.TURN_ON_PUSH : UpMsgType.TURN_OFF_PUSH, null);
            q0Var.e = a.a();
            a.a(j.f8694c.a(q0Var));
            return null;
        } catch (Exception e) {
            throw a.a(e);
        }
    }
}
