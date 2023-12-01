package com.android.org.conscrypt;

import java.math.BigInteger;
import java.security.spec.ECPoint;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLECPointContext.class */
public final class OpenSSLECPointContext {
    private final OpenSSLECGroupContext group;
    private final long pointCtx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLECPointContext(OpenSSLECGroupContext openSSLECGroupContext, long j) {
        this.group = openSSLECGroupContext;
        this.pointCtx = j;
    }

    public static OpenSSLECPointContext getInstance(int i, OpenSSLECGroupContext openSSLECGroupContext, ECPoint eCPoint) {
        OpenSSLECPointContext openSSLECPointContext = new OpenSSLECPointContext(openSSLECGroupContext, NativeCrypto.EC_POINT_new(openSSLECGroupContext.getContext()));
        NativeCrypto.EC_POINT_set_affine_coordinates(openSSLECGroupContext.getContext(), openSSLECPointContext.getContext(), eCPoint.getAffineX().toByteArray(), eCPoint.getAffineY().toByteArray());
        return openSSLECPointContext;
    }

    public boolean equals(Object obj) {
        if (obj instanceof OpenSSLECPointContext) {
            OpenSSLECPointContext openSSLECPointContext = (OpenSSLECPointContext) obj;
            if (NativeCrypto.EC_GROUP_cmp(this.group.getContext(), openSSLECPointContext.group.getContext())) {
                return NativeCrypto.EC_POINT_cmp(this.group.getContext(), this.pointCtx, openSSLECPointContext.pointCtx);
            }
            return false;
        }
        return false;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.pointCtx != 0) {
                NativeCrypto.EC_POINT_clear_free(this.pointCtx);
            }
        } finally {
            super.finalize();
        }
    }

    public long getContext() {
        return this.pointCtx;
    }

    public ECPoint getECPoint() {
        byte[][] EC_POINT_get_affine_coordinates = NativeCrypto.EC_POINT_get_affine_coordinates(this.group.getContext(), this.pointCtx);
        return new ECPoint(new BigInteger(EC_POINT_get_affine_coordinates[0]), new BigInteger(EC_POINT_get_affine_coordinates[1]));
    }

    public int hashCode() {
        return super.hashCode();
    }
}
