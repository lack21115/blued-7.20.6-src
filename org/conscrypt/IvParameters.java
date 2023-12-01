package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/IvParameters.class */
public class IvParameters extends AlgorithmParametersSpi {
    private byte[] iv;

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/IvParameters$AES.class */
    public static class AES extends IvParameters {
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/IvParameters$ChaCha20.class */
    public static class ChaCha20 extends IvParameters {
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/IvParameters$DESEDE.class */
    public static class DESEDE extends IvParameters {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        long j = 0;
        long j2 = 0;
        try {
            try {
                long asn1_write_init = NativeCrypto.asn1_write_init();
                NativeCrypto.asn1_write_octetstring(asn1_write_init, this.iv);
                j2 = asn1_write_init;
                j = asn1_write_init;
                byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(asn1_write_init);
                NativeCrypto.asn1_write_free(asn1_write_init);
                return asn1_write_finish;
            } catch (IOException e) {
                NativeCrypto.asn1_write_cleanup(j);
                j2 = j;
                throw e;
            }
        } catch (Throwable th) {
            NativeCrypto.asn1_write_free(j2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            return engineGetEncoded();
        }
        if (str.equals("RAW")) {
            return (byte[]) this.iv.clone();
        }
        throw new IOException("Unsupported format: " + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls == IvParameterSpec.class) {
            return new IvParameterSpec(this.iv);
        }
        throw new InvalidParameterSpecException("Incompatible AlgorithmParametersSpec class: " + cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof IvParameterSpec)) {
            throw new InvalidParameterSpecException("Only IvParameterSpec is supported");
        }
        this.iv = (byte[]) ((IvParameterSpec) algorithmParameterSpec).getIV().clone();
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
            byte[] asn1_read_octetstring = NativeCrypto.asn1_read_octetstring(j);
            if (!NativeCrypto.asn1_read_is_empty(j)) {
                throw new IOException("Error reading ASN.1 encoding");
            }
            this.iv = asn1_read_octetstring;
            NativeCrypto.asn1_read_free(j);
        } catch (Throwable th2) {
            th = th2;
            NativeCrypto.asn1_read_free(j);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            engineInit(bArr);
        } else if (str.equals("RAW")) {
            this.iv = (byte[]) bArr.clone();
        } else {
            throw new IOException("Unsupported format: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "Conscrypt IV AlgorithmParameters";
    }
}
