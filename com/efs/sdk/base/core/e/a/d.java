package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/e/a/d.class */
public final class d extends a {
    private ILogEncryptAction b;

    public d() {
        if (ControllerCenter.getGlobalEnvStruct().getLogEncryptAction() == null) {
            this.b = new com.efs.sdk.base.core.e.b();
        } else {
            this.b = ControllerCenter.getGlobalEnvStruct().getLogEncryptAction();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        if (1 == r5.f8158a.f8157c) goto L26;
     */
    @Override // com.efs.sdk.base.core.e.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.efs.sdk.base.core.d.b r5) {
        /*
            r4 = this;
            r0 = r5
            com.efs.sdk.base.core.d.a r0 = r0.f8158a
            int r0 = r0.e
            r6 = r0
            r0 = 0
            r7 = r0
            r0 = 1
            r1 = r6
            if (r0 == r1) goto L14
            r0 = 1
            r6 = r0
            goto L16
        L14:
            r0 = 0
            r6 = r0
        L16:
            r0 = r6
            if (r0 != 0) goto L5a
            java.lang.String r0 = "wa"
            r1 = r5
            com.efs.sdk.base.core.d.a r1 = r1.f8158a
            java.lang.String r1 = r1.f8156a
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
            java.lang.String r0 = "startperf"
            r1 = r5
            com.efs.sdk.base.core.d.a r1 = r1.f8158a
            java.lang.String r1 = r1.f8156a
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
            r0 = 1
            r1 = r5
            com.efs.sdk.base.core.d.a r1 = r1.f8158a
            byte r1 = r1.b
            if (r0 != r1) goto L4d
            r0 = r5
            com.efs.sdk.base.core.d.c r0 = r0.b
            boolean r0 = r0.f8160a
            if (r0 == 0) goto L5a
        L4d:
            r0 = r7
            r6 = r0
            r0 = 1
            r1 = r5
            com.efs.sdk.base.core.d.a r1 = r1.f8158a
            int r1 = r1.f8157c
            if (r0 != r1) goto L5c
        L5a:
            r0 = 1
            r6 = r0
        L5c:
            r0 = r6
            if (r0 == 0) goto L66
            r0 = r4
            r1 = r5
            r0.b(r1)
            return
        L66:
            r0 = r4
            com.efs.sdk.base.processor.action.ILogEncryptAction r0 = r0.b
            com.efs.sdk.base.core.config.GlobalEnvStruct r1 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            java.lang.String r1 = r1.getSecret()
            r2 = r5
            byte[] r2 = r2.f8159c
            byte[] r0 = r0.encrypt(r1, r2)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L93
            r0 = r5
            r1 = r8
            r0.a(r1)
            r0 = r5
            r1 = r4
            com.efs.sdk.base.processor.action.ILogEncryptAction r1 = r1.b
            int r1 = r1.getDeVal()
            r0.a(r1)
        L93:
            r0 = r4
            r1 = r5
            r0.b(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.e.a.d.a(com.efs.sdk.base.core.d.b):void");
    }
}
