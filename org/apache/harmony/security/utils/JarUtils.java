package org.apache.harmony.security.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import javax.xml.datatype.DatatypeConstants;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.pkcs7.ContentInfo;
import org.apache.harmony.security.pkcs7.SignedData;
import org.apache.harmony.security.pkcs7.SignerInfo;
import org.apache.harmony.security.x501.AttributeTypeAndValue;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/utils/JarUtils.class */
public class JarUtils {
    private static final int[] MESSAGE_DIGEST_OID = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 9, 4};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/utils/JarUtils$VerbatimX509Certificate.class */
    public static class VerbatimX509Certificate extends WrappedX509Certificate {
        private byte[] encodedVerbatim;

        public VerbatimX509Certificate(X509Certificate x509Certificate, byte[] bArr) {
            super(x509Certificate);
            this.encodedVerbatim = bArr;
        }

        @Override // org.apache.harmony.security.utils.WrappedX509Certificate, java.security.cert.Certificate
        public byte[] getEncoded() throws CertificateEncodingException {
            return this.encodedVerbatim;
        }
    }

    private static X509Certificate[] createChain(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) {
        Principal issuerDN = x509Certificate.getIssuerDN();
        if (x509Certificate.getSubjectDN().equals(issuerDN)) {
            return new X509Certificate[]{x509Certificate};
        }
        ArrayList arrayList = new ArrayList(x509CertificateArr.length + 1);
        arrayList.add(0, x509Certificate);
        int i = 1;
        Principal principal = issuerDN;
        while (true) {
            X509Certificate findCert = findCert(principal, x509CertificateArr);
            if (findCert != null) {
                arrayList.add(findCert);
                int i2 = i + 1;
                i = i2;
                if (i2 > x509CertificateArr.length) {
                    break;
                }
                Principal issuerDN2 = findCert.getIssuerDN();
                i = i2;
                principal = issuerDN2;
                if (findCert.getSubjectDN().equals(issuerDN2)) {
                    i = i2;
                    break;
                }
            } else {
                break;
            }
        }
        return (X509Certificate[]) arrayList.toArray(new X509Certificate[i]);
    }

    private static X509Certificate findCert(Principal principal, X509Certificate[] x509CertificateArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= x509CertificateArr.length) {
                return null;
            }
            if (principal.equals(x509CertificateArr[i2].getSubjectDN())) {
                return x509CertificateArr[i2];
            }
            i = i2 + 1;
        }
    }

    public static Certificate[] verifySignature(InputStream inputStream, InputStream inputStream2) throws IOException, GeneralSecurityException {
        int i;
        int i2;
        SignedData signedData = ((ContentInfo) ContentInfo.ASN1.decode(new BerInputStream(inputStream2))).getSignedData();
        if (signedData == null) {
            throw new IOException("No SignedData found");
        }
        List<org.apache.harmony.security.x509.Certificate> certificates = signedData.getCertificates();
        if (certificates.isEmpty()) {
            return null;
        }
        X509Certificate[] x509CertificateArr = new X509Certificate[certificates.size()];
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        int i3 = 0;
        for (org.apache.harmony.security.x509.Certificate certificate : certificates) {
            byte[] encoded = certificate.getEncoded();
            x509CertificateArr[i3] = new VerbatimX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(encoded)), encoded);
            i3++;
        }
        List<SignerInfo> signerInfos = signedData.getSignerInfos();
        if (signerInfos.isEmpty()) {
            return null;
        }
        SignerInfo signerInfo = signerInfos.get(0);
        X500Principal issuer = signerInfo.getIssuer();
        BigInteger serialNumber = signerInfo.getSerialNumber();
        int i4 = 0;
        while (true) {
            i = i4;
            i2 = 0;
            if (i >= x509CertificateArr.length) {
                break;
            }
            if (issuer.equals(x509CertificateArr[i].getIssuerDN()) && serialNumber.equals(x509CertificateArr[i].getSerialNumber())) {
                i2 = i;
                break;
            }
            i4 = i + 1;
        }
        if (i == x509CertificateArr.length) {
            return null;
        }
        if (x509CertificateArr[i2].hasUnsupportedCriticalExtension()) {
            throw new SecurityException("Can not recognize a critical extension");
        }
        String digestAlgorithm = signerInfo.getDigestAlgorithm();
        String digestAlgorithmName = signerInfo.getDigestAlgorithmName();
        String digestEncryptionAlgorithm = signerInfo.getDigestEncryptionAlgorithm();
        String digestEncryptionAlgorithmName = signerInfo.getDigestEncryptionAlgorithmName();
        Signature signature = null;
        Signature signature2 = null;
        if (digestAlgorithm != null) {
            signature2 = null;
            if (digestEncryptionAlgorithm != null) {
                try {
                    signature = Signature.getInstance(digestAlgorithm + "with" + digestEncryptionAlgorithm);
                } catch (NoSuchAlgorithmException e) {
                }
                signature2 = signature;
                if (signature == null) {
                    signature2 = signature;
                    if (digestAlgorithmName != null) {
                        signature2 = signature;
                        if (digestEncryptionAlgorithmName != null) {
                            try {
                                signature2 = Signature.getInstance(digestAlgorithmName + "with" + digestEncryptionAlgorithmName);
                            } catch (NoSuchAlgorithmException e2) {
                                signature2 = signature;
                            }
                        }
                    }
                }
            }
        }
        Signature signature3 = signature2;
        if (signature2 == null) {
            signature3 = signature2;
            if (digestEncryptionAlgorithm != null) {
                try {
                    signature2 = Signature.getInstance(digestEncryptionAlgorithm);
                } catch (NoSuchAlgorithmException e3) {
                }
                signature3 = signature2;
                if (signature2 == null) {
                    try {
                        signature3 = Signature.getInstance(digestEncryptionAlgorithmName);
                    } catch (NoSuchAlgorithmException e4) {
                        signature3 = signature2;
                    }
                }
            }
        }
        if (signature3 == null) {
            return null;
        }
        signature3.initVerify(x509CertificateArr[i2]);
        List<AttributeTypeAndValue> authenticatedAttributes = signerInfo.getAuthenticatedAttributes();
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr);
        if (authenticatedAttributes == null) {
            signature3.update(bArr);
        } else {
            signature3.update(signerInfo.getEncodedAuthenticatedAttributes());
            byte[] bArr2 = null;
            for (AttributeTypeAndValue attributeTypeAndValue : authenticatedAttributes) {
                if (Arrays.equals(attributeTypeAndValue.getType().getOid(), MESSAGE_DIGEST_OID)) {
                    if (bArr2 != null) {
                        throw new SecurityException("Too many MessageDigest attributes");
                    }
                    Collection<?> values = attributeTypeAndValue.getValue().getValues(ASN1OctetString.getInstance());
                    if (values.size() != 1) {
                        throw new SecurityException("Too many values for MessageDigest attribute");
                    }
                    bArr2 = (byte[]) values.iterator().next();
                }
            }
            if (bArr2 == null) {
                throw new SecurityException("Missing MessageDigest in Authenticated Attributes");
            }
            MessageDigest messageDigest = digestAlgorithm != null ? MessageDigest.getInstance(digestAlgorithm) : null;
            MessageDigest messageDigest2 = messageDigest;
            if (messageDigest == null) {
                messageDigest2 = messageDigest;
                if (digestAlgorithmName != null) {
                    messageDigest2 = MessageDigest.getInstance(digestAlgorithmName);
                }
            }
            if (messageDigest2 == null) {
                return null;
            }
            if (!Arrays.equals(bArr2, messageDigest2.digest(bArr))) {
                throw new SecurityException("Incorrect MD");
            }
        }
        if (signature3.verify(signerInfo.getEncryptedDigest())) {
            return createChain(x509CertificateArr[i2], x509CertificateArr);
        }
        throw new SecurityException("Incorrect signature");
    }
}
