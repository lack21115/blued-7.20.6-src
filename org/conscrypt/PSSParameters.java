package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/PSSParameters.class */
public class PSSParameters extends AlgorithmParametersSpi {
    private PSSParameterSpec spec = PSSParameterSpec.DEFAULT;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00fb: MOVE  (r0 I:??[long, double]) = (r9 I:??[long, double]), block:B:48:0x00fb */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long asn1_write_sequence;
        long j6 = 0;
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
                OAEPParameters.writeHashAndMgfHash(asn1_write_sequence, this.spec.getDigestAlgorithm(), (MGF1ParameterSpec) this.spec.getMGFParameters());
                if (this.spec.getSaltLength() != 20) {
                    try {
                        long asn1_write_tag = NativeCrypto.asn1_write_tag(asn1_write_sequence, 2);
                        j6 = asn1_write_tag;
                        NativeCrypto.asn1_write_uint64(asn1_write_tag, this.spec.getSaltLength());
                        NativeCrypto.asn1_write_flush(asn1_write_sequence);
                        NativeCrypto.asn1_write_free(asn1_write_tag);
                    } catch (Throwable th3) {
                        NativeCrypto.asn1_write_flush(asn1_write_sequence);
                        NativeCrypto.asn1_write_free(j6);
                        throw th3;
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
                long j7 = j4;
                throw e;
            }
        } catch (Throwable th4) {
            th = th4;
            j2 = j5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        if (str == null || str.equals("ASN.1") || str.equals("X.509")) {
            return engineGetEncoded();
        }
        throw new IOException("Unsupported format: " + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls == null || cls != PSSParameterSpec.class) {
            throw new InvalidParameterSpecException("Unsupported class: " + cls);
        }
        return this.spec;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof PSSParameterSpec)) {
            throw new InvalidParameterSpecException("Only PSSParameterSpec is supported");
        }
        this.spec = (PSSParameterSpec) algorithmParameterSpec;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        long j;
        long asn1_read_tagged;
        int asn1_read_uint64;
        long j2 = 0;
        try {
            j = NativeCrypto.asn1_read_init(bArr);
            try {
                long asn1_read_sequence = NativeCrypto.asn1_read_sequence(j);
                try {
                    String readHash = OAEPParameters.readHash(asn1_read_sequence);
                    String readMgfHash = OAEPParameters.readMgfHash(asn1_read_sequence);
                    if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 2)) {
                        try {
                            asn1_read_tagged = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            asn1_read_uint64 = (int) NativeCrypto.asn1_read_uint64(asn1_read_tagged);
                            NativeCrypto.asn1_read_free(asn1_read_tagged);
                        } catch (Throwable th2) {
                            th = th2;
                            j2 = asn1_read_tagged;
                            NativeCrypto.asn1_read_free(j2);
                            throw th;
                        }
                    } else {
                        asn1_read_uint64 = 20;
                    }
                    if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 3)) {
                        long asn1_read_tagged2 = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                        long asn1_read_uint642 = (int) NativeCrypto.asn1_read_uint64(asn1_read_tagged2);
                        NativeCrypto.asn1_read_free(asn1_read_tagged2);
                        if (asn1_read_uint642 != 1) {
                            throw new IOException("Error reading ASN.1 encoding");
                        }
                    }
                    if (!NativeCrypto.asn1_read_is_empty(asn1_read_sequence) || !NativeCrypto.asn1_read_is_empty(j)) {
                        throw new IOException("Error reading ASN.1 encoding");
                    }
                    this.spec = new PSSParameterSpec(readHash, "MGF1", new MGF1ParameterSpec(readMgfHash), asn1_read_uint64, 1);
                    NativeCrypto.asn1_read_free(asn1_read_sequence);
                    NativeCrypto.asn1_read_free(j);
                } catch (Throwable th3) {
                    th = th3;
                    j2 = asn1_read_sequence;
                    NativeCrypto.asn1_read_free(j2);
                    NativeCrypto.asn1_read_free(j);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            j = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1") || str.equals("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unsupported format: " + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "Conscrypt PSS AlgorithmParameters";
    }
}
