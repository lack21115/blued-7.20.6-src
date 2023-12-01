package com.efs.sdk.base.core.e;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/e/b.class */
public final class b implements ILogEncryptAction {
    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] decrypt(String str, byte[] bArr) {
        try {
            return com.efs.sdk.base.core.util.b.a.a(bArr, str);
        } catch (Exception e) {
            Log.e("efs.base", "aes decrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] encrypt(String str, byte[] bArr) {
        try {
            return com.efs.sdk.base.core.util.b.a.b(bArr, str);
        } catch (Exception e) {
            Log.e("efs.base", "aes encrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final int getDeVal() {
        return 2;
    }
}
