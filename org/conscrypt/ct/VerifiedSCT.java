package org.conscrypt.ct;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/ct/VerifiedSCT.class */
public final class VerifiedSCT {
    public final SignedCertificateTimestamp sct;
    public final Status status;

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/ct/VerifiedSCT$Status.class */
    public enum Status {
        VALID,
        INVALID_SIGNATURE,
        UNKNOWN_LOG,
        INVALID_SCT
    }

    public VerifiedSCT(SignedCertificateTimestamp signedCertificateTimestamp, Status status) {
        this.sct = signedCertificateTimestamp;
        this.status = status;
    }
}
