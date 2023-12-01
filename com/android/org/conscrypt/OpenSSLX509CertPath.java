package com.android.org.conscrypt;

import com.android.org.conscrypt.OpenSSLX509CertificateFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLX509CertPath.class */
public class OpenSSLX509CertPath extends CertPath {
    private static final int PUSHBACK_SIZE = 64;
    private final List<? extends X509Certificate> mCertificates;
    private static final byte[] PKCS7_MARKER = {45, 45, 45, 45, 45, 66, 69, 71, 73, 78, 32, 80, 75, 67, 83, 55};
    private static final List<String> ALL_ENCODINGS = Collections.unmodifiableList(Arrays.asList(Encoding.PKI_PATH.apiName, Encoding.PKCS7.apiName));
    private static final Encoding DEFAULT_ENCODING = Encoding.PKI_PATH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.android.org.conscrypt.OpenSSLX509CertPath$1  reason: invalid class name */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLX509CertPath$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding = new int[Encoding.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0022 -> B:11:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[Encoding.PKI_PATH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[Encoding.PKCS7.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLX509CertPath$Encoding.class */
    public enum Encoding {
        PKI_PATH("PkiPath"),
        PKCS7("PKCS7");
        
        private final String apiName;

        Encoding(String str) {
            this.apiName = str;
        }

        static Encoding findByApiName(String str) throws CertificateEncodingException {
            Encoding[] values = values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                Encoding encoding = values[i2];
                if (encoding.apiName.equals(str)) {
                    return encoding;
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OpenSSLX509CertPath(List<? extends X509Certificate> list) {
        super("X.509");
        this.mCertificates = list;
    }

    public static CertPath fromEncoding(InputStream inputStream) throws CertificateException {
        return fromEncoding(inputStream, DEFAULT_ENCODING);
    }

    private static CertPath fromEncoding(InputStream inputStream, Encoding encoding) throws CertificateException {
        switch (AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[encoding.ordinal()]) {
            case 1:
                return fromPkiPathEncoding(inputStream);
            case 2:
                return fromPkcs7Encoding(inputStream);
            default:
                throw new CertificateEncodingException("Unknown encoding");
        }
    }

    public static CertPath fromEncoding(InputStream inputStream, String str) throws CertificateException {
        if (inputStream == null) {
            throw new CertificateException("inStream == null");
        }
        Encoding findByApiName = Encoding.findByApiName(str);
        if (findByApiName == null) {
            throw new CertificateException("Invalid encoding: " + str);
        }
        return fromEncoding(inputStream, findByApiName);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00a2 -> B:24:0x0064). Please submit an issue!!! */
    private static CertPath fromPkcs7Encoding(InputStream inputStream) throws CertificateException {
        if (inputStream != null) {
            try {
                if (inputStream.available() != 0) {
                    boolean markSupported = inputStream.markSupported();
                    if (markSupported) {
                        inputStream.mark(64);
                    }
                    PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 64);
                    try {
                        byte[] bArr = new byte[PKCS7_MARKER.length];
                        int read = pushbackInputStream.read(bArr);
                        if (read < 0) {
                            throw new OpenSSLX509CertificateFactory.ParsingException("inStream is empty");
                        }
                        pushbackInputStream.unread(bArr, 0, read);
                        return (read == PKCS7_MARKER.length && Arrays.equals(PKCS7_MARKER, bArr)) ? new OpenSSLX509CertPath(OpenSSLX509Certificate.fromPkcs7PemInputStream(pushbackInputStream)) : new OpenSSLX509CertPath(OpenSSLX509Certificate.fromPkcs7DerInputStream(pushbackInputStream));
                    } catch (Exception e) {
                        if (markSupported) {
                            try {
                                inputStream.reset();
                            } catch (IOException e2) {
                            }
                        }
                        throw new CertificateException(e);
                    }
                }
            } catch (IOException e3) {
                throw new CertificateException("Problem reading input stream", e3);
            }
        }
        return new OpenSSLX509CertPath(Collections.emptyList());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0093 -> B:14:0x003f). Please submit an issue!!! */
    private static CertPath fromPkiPathEncoding(InputStream inputStream) throws CertificateException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream);
        boolean markSupported = inputStream.markSupported();
        if (markSupported) {
            inputStream.mark(64);
        }
        try {
            try {
                long[] ASN1_seq_unpack_X509_bio = NativeCrypto.ASN1_seq_unpack_X509_bio(openSSLBIOInputStream.getBioContext());
                if (ASN1_seq_unpack_X509_bio == null) {
                    return new OpenSSLX509CertPath(Collections.emptyList());
                }
                ArrayList arrayList = new ArrayList(ASN1_seq_unpack_X509_bio.length);
                int length = ASN1_seq_unpack_X509_bio.length;
                while (true) {
                    int i = length - 1;
                    if (i < 0) {
                        return new OpenSSLX509CertPath(arrayList);
                    }
                    if (ASN1_seq_unpack_X509_bio[i] != 0) {
                        arrayList.add(new OpenSSLX509Certificate(ASN1_seq_unpack_X509_bio[i]));
                    }
                    length = i;
                }
            } catch (Exception e) {
                if (markSupported) {
                    try {
                        inputStream.reset();
                    } catch (IOException e2) {
                    }
                }
                throw new CertificateException(e);
            }
        } finally {
            openSSLBIOInputStream.release();
        }
    }

    private byte[] getEncoded(Encoding encoding) throws CertificateEncodingException {
        OpenSSLX509Certificate[] openSSLX509CertificateArr = new OpenSSLX509Certificate[this.mCertificates.size()];
        long[] jArr = new long[openSSLX509CertificateArr.length];
        int i = 0;
        int length = openSSLX509CertificateArr.length;
        while (true) {
            int i2 = length - 1;
            if (i2 < 0) {
                break;
            }
            X509Certificate x509Certificate = this.mCertificates.get(i);
            if (x509Certificate instanceof OpenSSLX509Certificate) {
                openSSLX509CertificateArr[i2] = (OpenSSLX509Certificate) x509Certificate;
            } else {
                openSSLX509CertificateArr[i2] = OpenSSLX509Certificate.fromX509Der(x509Certificate.getEncoded());
            }
            jArr[i2] = openSSLX509CertificateArr[i2].getContext();
            i++;
            length = i2;
        }
        switch (AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[encoding.ordinal()]) {
            case 1:
                return NativeCrypto.ASN1_seq_pack_X509(jArr);
            case 2:
                return NativeCrypto.i2d_PKCS7(jArr);
            default:
                throw new CertificateEncodingException("Unknown encoding");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Iterator<String> getEncodingsIterator() {
        return ALL_ENCODINGS.iterator();
    }

    @Override // java.security.cert.CertPath
    public List<? extends Certificate> getCertificates() {
        return Collections.unmodifiableList(this.mCertificates);
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded() throws CertificateEncodingException {
        return getEncoded(DEFAULT_ENCODING);
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded(String str) throws CertificateEncodingException {
        Encoding findByApiName = Encoding.findByApiName(str);
        if (findByApiName == null) {
            throw new CertificateEncodingException("Invalid encoding: " + str);
        }
        return getEncoded(findByApiName);
    }

    @Override // java.security.cert.CertPath
    public Iterator<String> getEncodings() {
        return getEncodingsIterator();
    }
}
