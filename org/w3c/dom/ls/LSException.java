package org.w3c.dom.ls;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/ls/LSException.class */
public class LSException extends RuntimeException {
    public static final short PARSE_ERR = 81;
    public static final short SERIALIZE_ERR = 82;
    public short code;

    public LSException(short s, String str) {
        super(str);
        this.code = s;
    }
}
