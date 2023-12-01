package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/signature/EmptySignature.class */
public final class EmptySignature implements Key {
    private static final EmptySignature b = new EmptySignature();

    private EmptySignature() {
    }

    public static EmptySignature a() {
        return b;
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }
}
