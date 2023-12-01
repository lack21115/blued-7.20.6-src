package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/Challenge.class */
public final class Challenge {
    private final String realm;
    private final String scheme;

    public Challenge(String str, String str2) {
        this.scheme = str;
        this.realm = str2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            return Util.equal(this.scheme, challenge.scheme) && Util.equal(this.realm, challenge.realm);
        }
        return false;
    }

    public String getRealm() {
        return this.realm;
    }

    public String getScheme() {
        return this.scheme;
    }

    public int hashCode() {
        String str = this.realm;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.scheme;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((899 + hashCode) * 31) + i;
    }

    public String toString() {
        return this.scheme + " realm=\"" + this.realm + "\"";
    }
}
