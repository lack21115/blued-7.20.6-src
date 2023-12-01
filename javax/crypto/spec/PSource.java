package javax.crypto.spec;

import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/PSource.class */
public class PSource {
    private String pSrcName;

    /* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/PSource$PSpecified.class */
    public static final class PSpecified extends PSource {
        public static final PSpecified DEFAULT = new PSpecified();
        private final byte[] p;

        private PSpecified() {
            super("PSpecified");
            this.p = EmptyArray.BYTE;
        }

        public PSpecified(byte[] bArr) {
            super("PSpecified");
            if (bArr == null) {
                throw new NullPointerException("p == null");
            }
            this.p = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.p, 0, bArr.length);
        }

        public byte[] getValue() {
            byte[] bArr = new byte[this.p.length];
            System.arraycopy(this.p, 0, bArr, 0, this.p.length);
            return bArr;
        }
    }

    private PSource() {
    }

    protected PSource(String str) {
        if (str == null) {
            throw new NullPointerException("pSrcName == null");
        }
        this.pSrcName = str;
    }

    public String getAlgorithm() {
        return this.pSrcName;
    }
}
