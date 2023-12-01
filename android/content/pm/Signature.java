package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.ArrayUtils;
import java.io.ByteArrayInputStream;
import java.lang.ref.SoftReference;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/Signature.class */
public class Signature implements Parcelable {
    public static final Parcelable.Creator<Signature> CREATOR = new Parcelable.Creator<Signature>() { // from class: android.content.pm.Signature.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Signature createFromParcel(Parcel parcel) {
            return new Signature(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Signature[] newArray(int i) {
            return new Signature[i];
        }
    };
    private Certificate[] mCertificateChain;
    private int mHashCode;
    private boolean mHaveHashCode;
    private final byte[] mSignature;
    private SoftReference<String> mStringRef;

    private Signature(Parcel parcel) {
        this.mSignature = parcel.createByteArray();
    }

    public Signature(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("text size " + length + " is not even");
        }
        byte[] bArr = new byte[length / 2];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                this.mSignature = bArr;
                return;
            }
            int i4 = i + 1;
            int parseHexDigit = parseHexDigit(bytes[i]);
            i = i4 + 1;
            bArr[i3] = (byte) ((parseHexDigit << 4) | parseHexDigit(bytes[i4]));
            i2 = i3 + 1;
        }
    }

    public Signature(byte[] bArr) {
        this.mSignature = (byte[]) bArr.clone();
        this.mCertificateChain = null;
    }

    public Signature(Certificate[] certificateArr) throws CertificateEncodingException {
        this.mSignature = certificateArr[0].getEncoded();
        if (certificateArr.length > 1) {
            this.mCertificateChain = (Certificate[]) Arrays.copyOfRange(certificateArr, 1, certificateArr.length);
        }
    }

    public static boolean areEffectiveMatch(Signature[] signatureArr, Signature[] signatureArr2) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        Signature[] signatureArr3 = new Signature[signatureArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= signatureArr.length) {
                break;
            }
            signatureArr3[i2] = bounce(certificateFactory, signatureArr[i2]);
            i = i2 + 1;
        }
        Signature[] signatureArr4 = new Signature[signatureArr2.length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= signatureArr2.length) {
                return areExactMatch(signatureArr3, signatureArr4);
            }
            signatureArr4[i4] = bounce(certificateFactory, signatureArr2[i4]);
            i3 = i4 + 1;
        }
    }

    public static boolean areExactMatch(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && ArrayUtils.containsAll(signatureArr, signatureArr2) && ArrayUtils.containsAll(signatureArr2, signatureArr);
    }

    public static Signature bounce(CertificateFactory certificateFactory, Signature signature) throws CertificateException {
        Signature signature2 = new Signature(((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature.mSignature))).getEncoded());
        if (Math.abs(signature2.mSignature.length - signature.mSignature.length) > 2) {
            throw new CertificateException("Bounced cert length looks fishy; before " + signature.mSignature.length + ", after " + signature2.mSignature.length);
        }
        return signature2;
    }

    private static final int parseHexDigit(int i) {
        if (48 > i || i > 57) {
            if (97 > i || i > 102) {
                if (65 > i || i > 70) {
                    throw new IllegalArgumentException("Invalid character " + i + " in hex string");
                }
                return (i - 65) + 10;
            }
            return (i - 97) + 10;
        }
        return i - 48;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (java.util.Arrays.equals(r3.mSignature, r0.mSignature) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L28
            r0 = r4
            android.content.pm.Signature r0 = (android.content.pm.Signature) r0     // Catch: java.lang.ClassCastException -> L2a
            r4 = r0
            r0 = r3
            r1 = r4
            if (r0 == r1) goto L26
            r0 = r3
            byte[] r0 = r0.mSignature     // Catch: java.lang.ClassCastException -> L2a
            r1 = r4
            byte[] r1 = r1.mSignature     // Catch: java.lang.ClassCastException -> L2a
            boolean r0 = java.util.Arrays.equals(r0, r1)     // Catch: java.lang.ClassCastException -> L2a
            r7 = r0
            r0 = r6
            r5 = r0
            r0 = r7
            if (r0 == 0) goto L28
        L26:
            r0 = 1
            r5 = r0
        L28:
            r0 = r5
            return r0
        L2a:
            r4 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.Signature.equals(java.lang.Object):boolean");
    }

    public Signature[] getChainSignatures() throws CertificateEncodingException {
        Signature[] signatureArr;
        if (this.mCertificateChain != null) {
            Signature[] signatureArr2 = new Signature[this.mCertificateChain.length + 1];
            signatureArr2[0] = this;
            Certificate[] certificateArr = this.mCertificateChain;
            int length = certificateArr.length;
            int i = 0;
            int i2 = 1;
            while (true) {
                int i3 = i2;
                signatureArr = signatureArr2;
                if (i >= length) {
                    break;
                }
                signatureArr2[i3] = new Signature(certificateArr[i].getEncoded());
                i++;
                i2 = i3 + 1;
            }
        } else {
            signatureArr = new Signature[]{this};
        }
        return signatureArr;
    }

    public PublicKey getPublicKey() throws CertificateException {
        return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.mSignature)).getPublicKey();
    }

    public int hashCode() {
        if (this.mHaveHashCode) {
            return this.mHashCode;
        }
        this.mHashCode = Arrays.hashCode(this.mSignature);
        this.mHaveHashCode = true;
        return this.mHashCode;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[this.mSignature.length];
        System.arraycopy(this.mSignature, 0, bArr, 0, this.mSignature.length);
        return bArr;
    }

    public char[] toChars() {
        return toChars(null, null);
    }

    public char[] toChars(char[] cArr, int[] iArr) {
        byte[] bArr = this.mSignature;
        int length = bArr.length;
        int i = length * 2;
        if (cArr == null || i > cArr.length) {
            cArr = new char[i];
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            byte b = bArr[i3];
            int i4 = (b >> 4) & 15;
            cArr[i3 * 2] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
            int i5 = b & 15;
            cArr[(i3 * 2) + 1] = (char) (i5 >= 10 ? (i5 + 97) - 10 : i5 + 48);
            i2 = i3 + 1;
        }
        if (iArr != null) {
            iArr[0] = length;
        }
        return cArr;
    }

    public String toCharsString() {
        String str = this.mStringRef == null ? null : this.mStringRef.get();
        if (str != null) {
            return str;
        }
        String str2 = new String(toChars());
        this.mStringRef = new SoftReference<>(str2);
        return str2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.mSignature);
    }
}
