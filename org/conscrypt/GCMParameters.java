package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/GCMParameters.class */
public final class GCMParameters extends AlgorithmParametersSpi {
    private static final int DEFAULT_TLEN = 96;
    private byte[] iv;
    private int tLen;

    public GCMParameters() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GCMParameters(int i, byte[] bArr) {
        this.tLen = i;
        this.iv = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        long j;
        long j2;
        long asn1_write_init;
        long j3;
        long j4 = 0;
        try {
            asn1_write_init = NativeCrypto.asn1_write_init();
            j3 = 0;
        } catch (IOException e) {
            e = e;
            j2 = 0;
        } catch (Throwable th) {
            th = th;
            j = 0;
        }
        try {
            long asn1_write_sequence = NativeCrypto.asn1_write_sequence(asn1_write_init);
            NativeCrypto.asn1_write_octetstring(asn1_write_sequence, this.iv);
            if (this.tLen != 96) {
                NativeCrypto.asn1_write_uint64(asn1_write_sequence, this.tLen / 8);
            }
            j3 = asn1_write_sequence;
            j4 = asn1_write_sequence;
            byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(asn1_write_init);
            NativeCrypto.asn1_write_free(asn1_write_sequence);
            NativeCrypto.asn1_write_free(asn1_write_init);
            return asn1_write_finish;
        } catch (IOException e2) {
            e = e2;
            j2 = j4;
            j4 = asn1_write_init;
            try {
                NativeCrypto.asn1_write_cleanup(j4);
                throw e;
            } catch (Throwable th2) {
                th = th2;
                long j5 = j2;
                j = j4;
                j4 = j5;
                NativeCrypto.asn1_write_free(j4);
                NativeCrypto.asn1_write_free(j);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j4 = j3;
            j = asn1_write_init;
            NativeCrypto.asn1_write_free(j4);
            NativeCrypto.asn1_write_free(j);
            throw th;
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
        if (cls == null || !cls.getName().equals("javax.crypto.spec.GCMParameterSpec")) {
            throw new InvalidParameterSpecException("Unsupported class: " + cls);
        }
        return cls.cast(Platform.toGCMParameterSpec(this.tLen, this.iv));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        GCMParameters fromGCMParameterSpec = Platform.fromGCMParameterSpec(algorithmParameterSpec);
        if (fromGCMParameterSpec == null) {
            throw new InvalidParameterSpecException("Only GCMParameterSpec is supported");
        }
        this.tLen = fromGCMParameterSpec.tLen;
        this.iv = fromGCMParameterSpec.iv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        long j;
        try {
            j = NativeCrypto.asn1_read_init(bArr);
        } catch (Throwable th) {
            th = th;
            j = 0;
        }
        try {
            long asn1_read_sequence = NativeCrypto.asn1_read_sequence(j);
            byte[] asn1_read_octetstring = NativeCrypto.asn1_read_octetstring(asn1_read_sequence);
            int i = 96;
            if (!NativeCrypto.asn1_read_is_empty(asn1_read_sequence)) {
                i = ((int) NativeCrypto.asn1_read_uint64(asn1_read_sequence)) * 8;
            }
            if (!NativeCrypto.asn1_read_is_empty(asn1_read_sequence) || !NativeCrypto.asn1_read_is_empty(j)) {
                throw new IOException("Error reading ASN.1 encoding");
            }
            this.iv = asn1_read_octetstring;
            this.tLen = i;
            NativeCrypto.asn1_read_free(asn1_read_sequence);
            NativeCrypto.asn1_read_free(j);
        } catch (Throwable th2) {
            th = th2;
            NativeCrypto.asn1_read_free(0L);
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
        return "Conscrypt GCM AlgorithmParameters";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getIV() {
        return this.iv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTLen() {
        return this.tLen;
    }
}
