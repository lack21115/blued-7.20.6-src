package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/BfUKf.class */
public interface BfUKf {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/BfUKf$spXPg.class */
    public static class spXPg {
        public final byte[] data;
        public final int errCode;

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
            if (r4 < (-9999)) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public spXPg(int r4, byte[] r5) {
            /*
                r3 = this;
                r0 = r3
                r0.<init>()
                r0 = r4
                if (r0 > 0) goto L11
                r0 = r4
                r6 = r0
                r0 = r4
                r1 = -9999(0xffffffffffffd8f1, float:NaN)
                if (r0 >= r1) goto L13
            L11:
                r0 = -1
                r6 = r0
            L13:
                r0 = r3
                r1 = r6
                r0.errCode = r1
                r0 = r3
                r1 = r5
                r0.data = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.BfUKf.spXPg.<init>(int, byte[]):void");
        }
    }

    spXPg onHttpPost(byte[] bArr);
}
