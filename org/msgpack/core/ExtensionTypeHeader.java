package org.msgpack.core;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/ExtensionTypeHeader.class */
public class ExtensionTypeHeader {
    private final int length;
    private final byte type;

    public ExtensionTypeHeader(byte b, int i) {
        Preconditions.checkArgument(i >= 0, "length must be >= 0");
        this.type = b;
        this.length = i;
    }

    public static byte checkedCastToByte(int i) {
        Preconditions.checkArgument(-128 <= i && i <= 127, "Extension type code must be within the range of byte");
        return (byte) i;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof ExtensionTypeHeader) {
            ExtensionTypeHeader extensionTypeHeader = (ExtensionTypeHeader) obj;
            z = false;
            if (this.type == extensionTypeHeader.type) {
                z = false;
                if (this.length == extensionTypeHeader.length) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int getLength() {
        return this.length;
    }

    public byte getType() {
        return this.type;
    }

    public int hashCode() {
        return ((this.type + 31) * 31) + this.length;
    }

    public String toString() {
        return String.format("ExtensionTypeHeader(type:%d, length:%,d)", Byte.valueOf(this.type), Integer.valueOf(this.length));
    }
}
