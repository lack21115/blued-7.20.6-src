package org.apache.harmony.security.x509;

import org.apache.harmony.security.utils.Array;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/ExtensionValue.class */
public class ExtensionValue {
    protected byte[] encoding;

    public ExtensionValue() {
    }

    public ExtensionValue(byte[] bArr) {
        this.encoding = bArr;
    }

    public void dumpValue(StringBuilder sb) {
        dumpValue(sb, "");
    }

    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("Unparseable extension value:\n");
        if (this.encoding == null) {
            this.encoding = getEncoded();
        }
        if (this.encoding == null) {
            sb.append("NULL\n");
        } else {
            sb.append(Array.toString(this.encoding, str));
        }
    }

    public byte[] getEncoded() {
        return this.encoding;
    }
}
