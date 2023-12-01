package org.apache.harmony.security.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.Name;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/TBSCertList.class */
public final class TBSCertList {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Integer.getInstance(), AlgorithmIdentifier.ASN1, Name.ASN1, Time.ASN1, Time.ASN1, new ASN1SequenceOf(RevokedCertificate.ASN1), new ASN1Explicit(0, Extensions.ASN1)}) { // from class: org.apache.harmony.security.x509.TBSCertList.1
        {
            setOptional(0);
            setOptional(4);
            setOptional(5);
            setOptional(6);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            Object[] objArr = (Object[]) berInputStream.content;
            return new TBSCertList(objArr[0] == null ? 1 : ASN1Integer.toIntValue(objArr[0]) + 1, (AlgorithmIdentifier) objArr[1], (Name) objArr[2], (Date) objArr[3], (Date) objArr[4], (List) objArr[5], (Extensions) objArr[6], berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            TBSCertList tBSCertList = (TBSCertList) obj;
            objArr[0] = tBSCertList.version > 1 ? ASN1Integer.fromIntValue(tBSCertList.version - 1) : null;
            objArr[1] = tBSCertList.signature;
            objArr[2] = tBSCertList.issuer;
            objArr[3] = tBSCertList.thisUpdate;
            objArr[4] = tBSCertList.nextUpdate;
            objArr[5] = tBSCertList.revokedCertificates;
            objArr[6] = tBSCertList.crlExtensions;
        }
    };
    private final Extensions crlExtensions;
    private byte[] encoding;
    private final Name issuer;
    private final Date nextUpdate;
    private final List<RevokedCertificate> revokedCertificates;
    private final AlgorithmIdentifier signature;
    private final Date thisUpdate;
    private final int version;

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/TBSCertList$RevokedCertificate.class */
    public static class RevokedCertificate {
        public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Integer.getInstance(), Time.ASN1, Extensions.ASN1}) { // from class: org.apache.harmony.security.x509.TBSCertList.RevokedCertificate.1
            {
                setOptional(2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.apache.harmony.security.asn1.ASN1Type
            public Object getDecodedObject(BerInputStream berInputStream) {
                Object[] objArr = (Object[]) berInputStream.content;
                return new RevokedCertificate(new BigInteger((byte[]) objArr[0]), (Date) objArr[1], (Extensions) objArr[2]);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
            public void getValues(Object obj, Object[] objArr) {
                RevokedCertificate revokedCertificate = (RevokedCertificate) obj;
                objArr[0] = revokedCertificate.userCertificate.toByteArray();
                objArr[1] = revokedCertificate.revocationDate;
                objArr[2] = revokedCertificate.crlEntryExtensions;
            }
        };
        private final Extensions crlEntryExtensions;
        private byte[] encoding;
        private X500Principal issuer;
        private boolean issuerRetrieved;
        private final Date revocationDate;
        private final BigInteger userCertificate;

        public RevokedCertificate(BigInteger bigInteger, Date date, Extensions extensions) {
            this.userCertificate = bigInteger;
            this.revocationDate = date;
            this.crlEntryExtensions = extensions;
        }

        public void dumpValue(StringBuilder sb, String str) {
            sb.append(str).append("Certificate Serial Number: ").append(this.userCertificate).append('\n');
            sb.append(str).append("Revocation Date: ").append(this.revocationDate);
            if (this.crlEntryExtensions != null) {
                sb.append('\n').append(str).append("CRL Entry Extensions: [");
                this.crlEntryExtensions.dumpValue(sb, str + "  ");
                sb.append(str).append(']');
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof RevokedCertificate) {
                RevokedCertificate revokedCertificate = (RevokedCertificate) obj;
                if (this.userCertificate.equals(revokedCertificate.userCertificate) && this.revocationDate.getTime() / 1000 == revokedCertificate.revocationDate.getTime() / 1000) {
                    return this.crlEntryExtensions == null ? revokedCertificate.crlEntryExtensions == null : this.crlEntryExtensions.equals(revokedCertificate.crlEntryExtensions);
                }
                return false;
            }
            return false;
        }

        public Extensions getCrlEntryExtensions() {
            return this.crlEntryExtensions;
        }

        public byte[] getEncoded() {
            if (this.encoding == null) {
                this.encoding = ASN1.encode(this);
            }
            return this.encoding;
        }

        public X500Principal getIssuer() {
            if (this.crlEntryExtensions == null) {
                return null;
            }
            if (!this.issuerRetrieved) {
                try {
                    this.issuer = this.crlEntryExtensions.valueOfCertificateIssuerExtension();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.issuerRetrieved = true;
            }
            return this.issuer;
        }

        public Date getRevocationDate() {
            return this.revocationDate;
        }

        public BigInteger getUserCertificate() {
            return this.userCertificate;
        }

        public int hashCode() {
            int hashCode = this.userCertificate.hashCode();
            return (this.crlEntryExtensions == null ? 0 : this.crlEntryExtensions.hashCode()) + (((int) this.revocationDate.getTime()) / 1000) + (hashCode * 37);
        }
    }

    private TBSCertList(int i, AlgorithmIdentifier algorithmIdentifier, Name name, Date date, Date date2, List<RevokedCertificate> list, Extensions extensions, byte[] bArr) {
        this.version = i;
        this.signature = algorithmIdentifier;
        this.issuer = name;
        this.thisUpdate = date;
        this.nextUpdate = date2;
        this.revokedCertificates = list;
        this.crlExtensions = extensions;
        this.encoding = bArr;
    }

    public void dumpValue(StringBuilder sb) {
        sb.append("X.509 CRL v").append(this.version);
        sb.append("\nSignature Algorithm: [");
        this.signature.dumpValue(sb);
        sb.append(']');
        sb.append("\nIssuer: ").append(this.issuer.getName(X500Principal.RFC2253));
        sb.append("\n\nThis Update: ").append(this.thisUpdate);
        sb.append("\nNext Update: ").append(this.nextUpdate).append('\n');
        if (this.revokedCertificates != null) {
            sb.append("\nRevoked Certificates: ").append(this.revokedCertificates.size()).append(" [");
            int i = 1;
            for (RevokedCertificate revokedCertificate : this.revokedCertificates) {
                sb.append("\n  [").append(i).append(']');
                revokedCertificate.dumpValue(sb, "  ");
                sb.append('\n');
                i++;
            }
            sb.append("]\n");
        }
        if (this.crlExtensions != null) {
            sb.append("\nCRL Extensions: ").append(this.crlExtensions.size()).append(" [");
            this.crlExtensions.dumpValue(sb, "  ");
            sb.append("]\n");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof TBSCertList) {
            TBSCertList tBSCertList = (TBSCertList) obj;
            if (this.version == tBSCertList.version && this.signature.equals(tBSCertList.signature) && Arrays.equals(this.issuer.getEncoded(), tBSCertList.issuer.getEncoded()) && this.thisUpdate.getTime() / 1000 == tBSCertList.thisUpdate.getTime() / 1000) {
                if (this.nextUpdate == null) {
                    if (tBSCertList.nextUpdate != null) {
                        return false;
                    }
                } else if (this.nextUpdate.getTime() / 1000 != tBSCertList.nextUpdate.getTime() / 1000) {
                    return false;
                }
                if (((this.revokedCertificates == null || tBSCertList.revokedCertificates == null) && this.revokedCertificates == tBSCertList.revokedCertificates) || this.revokedCertificates.equals(tBSCertList.revokedCertificates)) {
                    return this.crlExtensions == null ? tBSCertList.crlExtensions == null : this.crlExtensions.equals(tBSCertList.crlExtensions);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public Extensions getCrlExtensions() {
        return this.crlExtensions;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public Name getIssuer() {
        return this.issuer;
    }

    public Date getNextUpdate() {
        return this.nextUpdate;
    }

    public List<RevokedCertificate> getRevokedCertificates() {
        return this.revokedCertificates;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public Date getThisUpdate() {
        return this.thisUpdate;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((this.version * 37) + this.signature.hashCode()) * 37) + Arrays.hashCode(this.issuer.getEncoded())) * 37) + (((int) this.thisUpdate.getTime()) / 1000);
    }
}
