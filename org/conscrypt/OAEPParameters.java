package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OAEPParameters.class */
public class OAEPParameters extends AlgorithmParametersSpi {
    private static final String MGF1_OID = "1.2.840.113549.1.1.8";
    private static final String PSPECIFIED_OID = "1.2.840.113549.1.1.9";
    private OAEPParameterSpec spec = OAEPParameterSpec.DEFAULT;
    private static final Map<String, String> OID_TO_NAME = new HashMap();
    private static final Map<String, String> NAME_TO_OID = new HashMap();

    static {
        OID_TO_NAME.put("1.3.14.3.2.26", "SHA-1");
        OID_TO_NAME.put("2.16.840.1.101.3.4.2.4", "SHA-224");
        OID_TO_NAME.put("2.16.840.1.101.3.4.2.1", "SHA-256");
        OID_TO_NAME.put("2.16.840.1.101.3.4.2.2", "SHA-384");
        OID_TO_NAME.put("2.16.840.1.101.3.4.2.3", "SHA-512");
        for (Map.Entry<String, String> entry : OID_TO_NAME.entrySet()) {
            NAME_TO_OID.put(entry.getValue(), entry.getKey());
        }
    }

    private static String getHashName(long j) throws IOException {
        long j2;
        try {
            j2 = NativeCrypto.asn1_read_sequence(j);
        } catch (Throwable th) {
            th = th;
            j2 = 0;
        }
        try {
            String asn1_read_oid = NativeCrypto.asn1_read_oid(j2);
            if (!NativeCrypto.asn1_read_is_empty(j2)) {
                NativeCrypto.asn1_read_null(j2);
            }
            if (NativeCrypto.asn1_read_is_empty(j2) && OID_TO_NAME.containsKey(asn1_read_oid)) {
                String str = OID_TO_NAME.get(asn1_read_oid);
                NativeCrypto.asn1_read_free(j2);
                return str;
            }
            throw new IOException("Error reading ASN.1 encoding");
        } catch (Throwable th2) {
            th = th2;
            NativeCrypto.asn1_read_free(j2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readHash(long j) throws IOException {
        if (NativeCrypto.asn1_read_next_tag_is(j, 0)) {
            long j2 = 0;
            try {
                long asn1_read_tagged = NativeCrypto.asn1_read_tagged(j);
                j2 = asn1_read_tagged;
                String hashName = getHashName(asn1_read_tagged);
                NativeCrypto.asn1_read_free(asn1_read_tagged);
                return hashName;
            } catch (Throwable th) {
                NativeCrypto.asn1_read_free(j2);
                throw th;
            }
        }
        return "SHA-1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readMgfHash(long j) throws IOException {
        long j2;
        long j3;
        if (NativeCrypto.asn1_read_next_tag_is(j, 1)) {
            try {
                j2 = NativeCrypto.asn1_read_tagged(j);
                j3 = 0;
            } catch (Throwable th) {
                th = th;
                j2 = 0;
                j3 = 0;
            }
            try {
                long asn1_read_sequence = NativeCrypto.asn1_read_sequence(j2);
                if (NativeCrypto.asn1_read_oid(asn1_read_sequence).equals(MGF1_OID)) {
                    String hashName = getHashName(asn1_read_sequence);
                    if (NativeCrypto.asn1_read_is_empty(asn1_read_sequence)) {
                        NativeCrypto.asn1_read_free(asn1_read_sequence);
                        NativeCrypto.asn1_read_free(j2);
                        return hashName;
                    }
                    throw new IOException("Error reading ASN.1 encoding");
                }
                throw new IOException("Error reading ASN.1 encoding");
            } catch (Throwable th2) {
                th = th2;
                NativeCrypto.asn1_read_free(j3);
                NativeCrypto.asn1_read_free(j2);
                throw th;
            }
        }
        return "SHA-1";
    }

    private static long writeAlgorithmIdentifier(long j, String str) throws IOException {
        long j2;
        try {
            j2 = NativeCrypto.asn1_write_sequence(j);
            try {
                NativeCrypto.asn1_write_oid(j2, str);
                return j2;
            } catch (IOException e) {
                e = e;
                NativeCrypto.asn1_write_free(j2);
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
            j2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeHashAndMgfHash(long j, String str, MGF1ParameterSpec mGF1ParameterSpec) throws IOException {
        long j2;
        long writeAlgorithmIdentifier;
        long j3;
        long j4;
        long j5 = 0;
        if (!str.equals("SHA-1")) {
            try {
                j2 = NativeCrypto.asn1_write_tag(j, 0);
                try {
                    writeAlgorithmIdentifier = writeAlgorithmIdentifier(j2, NAME_TO_OID.get(str));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                j2 = 0;
            }
            try {
                NativeCrypto.asn1_write_null(writeAlgorithmIdentifier);
                NativeCrypto.asn1_write_flush(j);
                NativeCrypto.asn1_write_free(writeAlgorithmIdentifier);
                NativeCrypto.asn1_write_free(j2);
            } catch (Throwable th3) {
                th = th3;
                j5 = writeAlgorithmIdentifier;
                NativeCrypto.asn1_write_flush(j);
                NativeCrypto.asn1_write_free(j5);
                NativeCrypto.asn1_write_free(j2);
                throw th;
            }
        }
        if (mGF1ParameterSpec.getDigestAlgorithm().equals("SHA-1")) {
            return;
        }
        try {
            j3 = NativeCrypto.asn1_write_tag(j, 1);
            try {
                j4 = writeAlgorithmIdentifier(j3, MGF1_OID);
                try {
                    long writeAlgorithmIdentifier2 = writeAlgorithmIdentifier(j4, NAME_TO_OID.get(mGF1ParameterSpec.getDigestAlgorithm()));
                    j5 = writeAlgorithmIdentifier2;
                    NativeCrypto.asn1_write_null(writeAlgorithmIdentifier2);
                    NativeCrypto.asn1_write_flush(j);
                    NativeCrypto.asn1_write_free(writeAlgorithmIdentifier2);
                    NativeCrypto.asn1_write_free(j4);
                    NativeCrypto.asn1_write_free(j3);
                } catch (Throwable th4) {
                    th = th4;
                    NativeCrypto.asn1_write_flush(j);
                    NativeCrypto.asn1_write_free(j5);
                    NativeCrypto.asn1_write_free(j4);
                    NativeCrypto.asn1_write_free(j3);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                j4 = 0;
            }
        } catch (Throwable th6) {
            th = th6;
            j3 = 0;
            j4 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x012b: MOVE  (r0 I:??[long, double]) = (r9 I:??[long, double]), block:B:54:0x012b */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long asn1_write_sequence;
        long j6;
        long j7 = 0;
        try {
            try {
                j2 = NativeCrypto.asn1_write_init();
                try {
                    asn1_write_sequence = NativeCrypto.asn1_write_sequence(j2);
                } catch (IOException e) {
                    e = e;
                    j4 = j2;
                    j3 = 0;
                } catch (Throwable th) {
                    th = th;
                    j = 0;
                    NativeCrypto.asn1_write_free(j);
                    NativeCrypto.asn1_write_free(j2);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                j3 = 0;
                j4 = 0;
            } catch (Throwable th2) {
                th = th2;
                j = 0;
                j2 = 0;
            }
            try {
                writeHashAndMgfHash(asn1_write_sequence, this.spec.getDigestAlgorithm(), (MGF1ParameterSpec) this.spec.getMGFParameters());
                PSource.PSpecified pSpecified = (PSource.PSpecified) this.spec.getPSource();
                if (pSpecified.getValue().length != 0) {
                    try {
                        j6 = NativeCrypto.asn1_write_tag(asn1_write_sequence, 2);
                        long j8 = 0;
                        try {
                            long writeAlgorithmIdentifier = writeAlgorithmIdentifier(j6, PSPECIFIED_OID);
                            j8 = writeAlgorithmIdentifier;
                            NativeCrypto.asn1_write_octetstring(writeAlgorithmIdentifier, pSpecified.getValue());
                            NativeCrypto.asn1_write_flush(asn1_write_sequence);
                            NativeCrypto.asn1_write_free(writeAlgorithmIdentifier);
                            NativeCrypto.asn1_write_free(j6);
                        } catch (Throwable th3) {
                            th = th3;
                            j7 = j8;
                            NativeCrypto.asn1_write_flush(asn1_write_sequence);
                            NativeCrypto.asn1_write_free(j7);
                            NativeCrypto.asn1_write_free(j6);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        j6 = 0;
                    }
                }
                byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(j2);
                NativeCrypto.asn1_write_free(asn1_write_sequence);
                NativeCrypto.asn1_write_free(j2);
                return asn1_write_finish;
            } catch (IOException e3) {
                e = e3;
                j4 = j2;
                j3 = asn1_write_sequence;
                NativeCrypto.asn1_write_cleanup(j4);
                long j9 = j4;
                throw e;
            }
        } catch (Throwable th5) {
            th = th5;
            j2 = j5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            return engineGetEncoded();
        }
        throw new IOException("Unsupported format: " + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls == null || cls != OAEPParameterSpec.class) {
            throw new InvalidParameterSpecException("Unsupported class: " + cls);
        }
        return this.spec;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
            throw new InvalidParameterSpecException("Only OAEPParameterSpec is supported");
        }
        this.spec = (OAEPParameterSpec) algorithmParameterSpec;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        long j;
        long asn1_read_init;
        long asn1_read_sequence;
        long j2;
        long j3 = 0;
        try {
            asn1_read_init = NativeCrypto.asn1_read_init(bArr);
            try {
                asn1_read_sequence = NativeCrypto.asn1_read_sequence(asn1_read_init);
            } catch (Throwable th) {
                th = th;
                j = asn1_read_init;
            }
        } catch (Throwable th2) {
            th = th2;
            j = 0;
        }
        try {
            PSource.PSpecified pSpecified = PSource.PSpecified.DEFAULT;
            String readHash = readHash(asn1_read_sequence);
            String readMgfHash = readMgfHash(asn1_read_sequence);
            if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 2)) {
                try {
                    j2 = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                } catch (Throwable th3) {
                    th = th3;
                    j2 = 0;
                }
                try {
                    long asn1_read_sequence2 = NativeCrypto.asn1_read_sequence(j2);
                    if (!NativeCrypto.asn1_read_oid(asn1_read_sequence2).equals(PSPECIFIED_OID)) {
                        throw new IOException("Error reading ASN.1 encoding");
                    }
                    pSpecified = new PSource.PSpecified(NativeCrypto.asn1_read_octetstring(asn1_read_sequence2));
                    if (!NativeCrypto.asn1_read_is_empty(asn1_read_sequence2)) {
                        throw new IOException("Error reading ASN.1 encoding");
                    }
                    NativeCrypto.asn1_read_free(asn1_read_sequence2);
                    NativeCrypto.asn1_read_free(j2);
                } catch (Throwable th4) {
                    th = th4;
                    NativeCrypto.asn1_read_free(0L);
                    NativeCrypto.asn1_read_free(j2);
                    throw th;
                }
            }
            if (!NativeCrypto.asn1_read_is_empty(asn1_read_sequence) || !NativeCrypto.asn1_read_is_empty(asn1_read_init)) {
                throw new IOException("Error reading ASN.1 encoding");
            }
            this.spec = new OAEPParameterSpec(readHash, "MGF1", new MGF1ParameterSpec(readMgfHash), pSpecified);
            NativeCrypto.asn1_read_free(asn1_read_sequence);
            NativeCrypto.asn1_read_free(asn1_read_init);
        } catch (Throwable th5) {
            th = th5;
            j3 = asn1_read_sequence;
            j = asn1_read_init;
            NativeCrypto.asn1_read_free(j3);
            NativeCrypto.asn1_read_free(j);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unsupported format: " + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "Conscrypt OAEP AlgorithmParameters";
    }
}
