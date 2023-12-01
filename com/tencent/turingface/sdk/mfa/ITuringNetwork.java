package com.tencent.turingface.sdk.mfa;

import com.tencent.turingface.sdk.mfa.BfUKf;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/ITuringNetwork.class */
public interface ITuringNetwork extends BfUKf {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/ITuringNetwork$Resp.class */
    public static class Resp extends BfUKf.spXPg {
        public Resp(int i, byte[] bArr) {
            super(i, bArr);
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.BfUKf
    /* synthetic */ BfUKf.spXPg onHttpPost(byte[] bArr);

    @Override // com.tencent.turingface.sdk.mfa.BfUKf
    Resp onHttpPost(byte[] bArr);
}
