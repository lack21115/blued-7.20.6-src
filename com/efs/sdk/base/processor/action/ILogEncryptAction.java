package com.efs.sdk.base.processor.action;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/processor/action/ILogEncryptAction.class */
public interface ILogEncryptAction {
    byte[] decrypt(String str, byte[] bArr);

    byte[] encrypt(String str, byte[] bArr);

    int getDeVal();
}
