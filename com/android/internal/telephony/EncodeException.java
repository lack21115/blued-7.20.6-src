package com.android.internal.telephony;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/EncodeException.class */
public class EncodeException extends Exception {
    public EncodeException() {
    }

    public EncodeException(char c) {
        super("Unencodable char: '" + c + "'");
    }

    public EncodeException(String str) {
        super(str);
    }
}
