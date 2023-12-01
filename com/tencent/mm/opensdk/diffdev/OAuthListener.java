package com.tencent.mm.opensdk.diffdev;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mm/opensdk/diffdev/OAuthListener.class */
public interface OAuthListener {
    void onAuthFinish(OAuthErrCode oAuthErrCode, String str);

    void onAuthGotQrcode(String str, byte[] bArr);

    void onQrcodeScanned();
}
