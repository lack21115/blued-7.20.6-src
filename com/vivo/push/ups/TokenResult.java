package com.vivo.push.ups;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/ups/TokenResult.class */
public class TokenResult extends CodeResult {
    String token;

    public TokenResult(int i, String str) {
        super(i);
        this.token = str;
    }

    public String getToken() {
        return this.token;
    }
}
