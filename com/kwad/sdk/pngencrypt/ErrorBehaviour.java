package com.kwad.sdk.pngencrypt;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/ErrorBehaviour.class */
public enum ErrorBehaviour {
    STRICT(0),
    LENIENT1_CRC(1),
    LENIENT2_ANCILLARY(3),
    SUPER_LENIENT(5);
    

    /* renamed from: c  reason: collision with root package name */
    final int f23928c;

    ErrorBehaviour(int i) {
        this.f23928c = i;
    }
}
