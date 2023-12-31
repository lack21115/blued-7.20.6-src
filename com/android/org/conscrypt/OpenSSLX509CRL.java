package com.android.org.conscrypt;

import com.android.org.conscrypt.OpenSSLX509CertificateFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.utils.AlgNameMapper;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLX509CRL.class */
public class OpenSSLX509CRL extends X509CRL {
    private final long mContext;

    private OpenSSLX509CRL(long j) {
        this.mContext = j;
    }

    public static List<OpenSSLX509CRL> fromPkcs7DerInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream);
        try {
            try {
                long[] d2i_PKCS7_bio = NativeCrypto.d2i_PKCS7_bio(openSSLBIOInputStream.getBioContext(), 2);
                openSSLBIOInputStream.release();
                ArrayList arrayList = new ArrayList(d2i_PKCS7_bio.length);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= d2i_PKCS7_bio.length) {
                        return arrayList;
                    }
                    if (d2i_PKCS7_bio[i2] != 0) {
                        arrayList.add(new OpenSSLX509CRL(d2i_PKCS7_bio[i2]));
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                throw new OpenSSLX509CertificateFactory.ParsingException(e);
            }
        } catch (Throwable th) {
            openSSLBIOInputStream.release();
            throw th;
        }
    }

    public static List<OpenSSLX509CRL> fromPkcs7PemInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream);
        try {
            try {
                long[] PEM_read_bio_PKCS7 = NativeCrypto.PEM_read_bio_PKCS7(openSSLBIOInputStream.getBioContext(), 2);
                openSSLBIOInputStream.release();
                ArrayList arrayList = new ArrayList(PEM_read_bio_PKCS7.length);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= PEM_read_bio_PKCS7.length) {
                        return arrayList;
                    }
                    if (PEM_read_bio_PKCS7[i2] != 0) {
                        arrayList.add(new OpenSSLX509CRL(PEM_read_bio_PKCS7[i2]));
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                throw new OpenSSLX509CertificateFactory.ParsingException(e);
            }
        } catch (Throwable th) {
            openSSLBIOInputStream.release();
            throw th;
        }
    }

    public static OpenSSLX509CRL fromX509DerInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream);
        try {
            try {
                long d2i_X509_CRL_bio = NativeCrypto.d2i_X509_CRL_bio(openSSLBIOInputStream.getBioContext());
                if (d2i_X509_CRL_bio == 0) {
                    openSSLBIOInputStream.release();
                    return null;
                }
                return new OpenSSLX509CRL(d2i_X509_CRL_bio);
            } catch (Exception e) {
                throw new OpenSSLX509CertificateFactory.ParsingException(e);
            }
        } finally {
            openSSLBIOInputStream.release();
        }
    }

    public static OpenSSLX509CRL fromX509PemInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream);
        try {
            try {
                long PEM_read_bio_X509_CRL = NativeCrypto.PEM_read_bio_X509_CRL(openSSLBIOInputStream.getBioContext());
                if (PEM_read_bio_X509_CRL == 0) {
                    openSSLBIOInputStream.release();
                    return null;
                }
                return new OpenSSLX509CRL(PEM_read_bio_X509_CRL);
            } catch (Exception e) {
                throw new OpenSSLX509CertificateFactory.ParsingException(e);
            }
        } finally {
            openSSLBIOInputStream.release();
        }
    }

    private void verifyInternal(PublicKey publicKey, String str) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        String sigAlgName = getSigAlgName();
        String str2 = sigAlgName;
        if (sigAlgName == null) {
            str2 = getSigAlgOID();
        }
        Signature signature = str == null ? Signature.getInstance(str2) : Signature.getInstance(str2, str);
        signature.initVerify(publicKey);
        signature.update(getTBSCertList());
        if (!signature.verify(getSignature())) {
            throw new SignatureException("signature did not verify");
        }
    }

    private void verifyOpenSSL(OpenSSLKey openSSLKey) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        NativeCrypto.X509_CRL_verify(this.mContext, openSSLKey.getPkeyContext());
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mContext != 0) {
                NativeCrypto.X509_CRL_free(this.mContext);
            }
        } finally {
            super.finalize();
        }
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        String[] strArr = NativeCrypto.get_X509_CRL_ext_oids(this.mContext, 1);
        if (strArr.length == 0 && NativeCrypto.get_X509_CRL_ext_oids(this.mContext, 0).length == 0) {
            return null;
        }
        return new HashSet(Arrays.asList(strArr));
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() throws CRLException {
        return NativeCrypto.i2d_X509_CRL(this.mContext);
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        return NativeCrypto.X509_CRL_get_ext_oid(this.mContext, str);
    }

    @Override // java.security.cert.X509CRL
    public Principal getIssuerDN() {
        return getIssuerX500Principal();
    }

    @Override // java.security.cert.X509CRL
    public X500Principal getIssuerX500Principal() {
        return new X500Principal(NativeCrypto.X509_CRL_get_issuer_name(this.mContext));
    }

    @Override // java.security.cert.X509CRL
    public Date getNextUpdate() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(14, 0);
        NativeCrypto.ASN1_TIME_to_Calendar(NativeCrypto.X509_CRL_get_nextUpdate(this.mContext), calendar);
        return calendar.getTime();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        String[] strArr = NativeCrypto.get_X509_CRL_ext_oids(this.mContext, 0);
        if (strArr.length == 0 && NativeCrypto.get_X509_CRL_ext_oids(this.mContext, 1).length == 0) {
            return null;
        }
        return new HashSet(Arrays.asList(strArr));
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        long X509_CRL_get0_by_serial = NativeCrypto.X509_CRL_get0_by_serial(this.mContext, bigInteger.toByteArray());
        if (X509_CRL_get0_by_serial == 0) {
            return null;
        }
        return new OpenSSLX509CRLEntry(NativeCrypto.X509_REVOKED_dup(X509_CRL_get0_by_serial));
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(X509Certificate x509Certificate) {
        if (x509Certificate instanceof OpenSSLX509Certificate) {
            long X509_CRL_get0_by_cert = NativeCrypto.X509_CRL_get0_by_cert(this.mContext, ((OpenSSLX509Certificate) x509Certificate).getContext());
            if (X509_CRL_get0_by_cert == 0) {
                return null;
            }
            return new OpenSSLX509CRLEntry(NativeCrypto.X509_REVOKED_dup(X509_CRL_get0_by_cert));
        }
        return getRevokedCertificate(x509Certificate.getSerialNumber());
    }

    @Override // java.security.cert.X509CRL
    public Set<? extends X509CRLEntry> getRevokedCertificates() {
        HashSet hashSet;
        long[] X509_CRL_get_REVOKED = NativeCrypto.X509_CRL_get_REVOKED(this.mContext);
        if (X509_CRL_get_REVOKED != null && X509_CRL_get_REVOKED.length != 0) {
            HashSet hashSet2 = new HashSet();
            int length = X509_CRL_get_REVOKED.length;
            int i = 0;
            while (true) {
                int i2 = i;
                hashSet = hashSet2;
                if (i2 >= length) {
                    break;
                }
                hashSet2.add(new OpenSSLX509CRLEntry(X509_CRL_get_REVOKED[i2]));
                i = i2 + 1;
            }
        } else {
            hashSet = null;
        }
        return hashSet;
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgName() {
        return AlgNameMapper.map2AlgName(getSigAlgOID());
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgOID() {
        return NativeCrypto.get_X509_CRL_sig_alg_oid(this.mContext);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSigAlgParams() {
        return NativeCrypto.get_X509_CRL_sig_alg_parameter(this.mContext);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSignature() {
        return NativeCrypto.get_X509_CRL_signature(this.mContext);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getTBSCertList() throws CRLException {
        return NativeCrypto.get_X509_CRL_crl_enc(this.mContext);
    }

    @Override // java.security.cert.X509CRL
    public Date getThisUpdate() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(14, 0);
        NativeCrypto.ASN1_TIME_to_Calendar(NativeCrypto.X509_CRL_get_lastUpdate(this.mContext), calendar);
        return calendar.getTime();
    }

    @Override // java.security.cert.X509CRL
    public int getVersion() {
        return ((int) NativeCrypto.X509_CRL_get_version(this.mContext)) + 1;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        String[] strArr = NativeCrypto.get_X509_CRL_ext_oids(this.mContext, 1);
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (NativeCrypto.X509_supported_extension(NativeCrypto.X509_CRL_get_ext(this.mContext, strArr[i2])) != 1) {
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // java.security.cert.CRL
    public boolean isRevoked(Certificate certificate) {
        OpenSSLX509Certificate fromX509DerInputStream;
        if (certificate instanceof X509Certificate) {
            if (certificate instanceof OpenSSLX509Certificate) {
                fromX509DerInputStream = (OpenSSLX509Certificate) certificate;
            } else {
                try {
                    fromX509DerInputStream = OpenSSLX509Certificate.fromX509DerInputStream(new ByteArrayInputStream(certificate.getEncoded()));
                } catch (Exception e) {
                    throw new RuntimeException("cannot convert certificate", e);
                }
            }
            return NativeCrypto.X509_CRL_get0_by_cert(this.mContext, fromX509DerInputStream.getContext()) != 0;
        }
        return false;
    }

    @Override // java.security.cert.CRL
    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long create_BIO_OutputStream = NativeCrypto.create_BIO_OutputStream(byteArrayOutputStream);
        try {
            NativeCrypto.X509_CRL_print(create_BIO_OutputStream, this.mContext);
            return byteArrayOutputStream.toString();
        } finally {
            NativeCrypto.BIO_free_all(create_BIO_OutputStream);
        }
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        if (publicKey instanceof OpenSSLKeyHolder) {
            verifyOpenSSL(((OpenSSLKeyHolder) publicKey).getOpenSSLKey());
        } else {
            verifyInternal(publicKey, null);
        }
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey, String str) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        verifyInternal(publicKey, str);
    }
}
