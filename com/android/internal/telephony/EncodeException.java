package com.android.internal.telephony;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/EncodeException.class */
public class EncodeException extends Exception {
    public EncodeException() {
    }

    public EncodeException(char c2) {
        super("Unencodable char: '" + c2 + "'");
    }

    public EncodeException(String str) {
        super(str);
    }
}
