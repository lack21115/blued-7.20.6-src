package com.android.org.conscrypt;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLECGroupContext.class */
public final class OpenSSLECGroupContext {
    private final long groupCtx;

    public OpenSSLECGroupContext(long j) {
        this.groupCtx = j;
    }

    public static OpenSSLECGroupContext getCurveByName(String str) {
        String str2;
        if ("secp256r1".equals(str)) {
            str2 = "prime256v1";
        } else {
            str2 = str;
            if ("secp192r1".equals(str)) {
                str2 = "prime192v1";
            }
        }
        long EC_GROUP_new_by_curve_name = NativeCrypto.EC_GROUP_new_by_curve_name(str2);
        if (EC_GROUP_new_by_curve_name == 0) {
            return null;
        }
        NativeCrypto.EC_GROUP_set_point_conversion_form(EC_GROUP_new_by_curve_name, 4);
        NativeCrypto.EC_GROUP_set_asn1_flag(EC_GROUP_new_by_curve_name, 1);
        return new OpenSSLECGroupContext(EC_GROUP_new_by_curve_name);
    }

    public static OpenSSLECGroupContext getInstance(int i, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7) {
        long EC_GROUP_new_curve = NativeCrypto.EC_GROUP_new_curve(i, bigInteger.toByteArray(), bigInteger2.toByteArray(), bigInteger3.toByteArray());
        if (EC_GROUP_new_curve == 0) {
            return null;
        }
        NativeCrypto.EC_GROUP_set_point_conversion_form(EC_GROUP_new_curve, 4);
        OpenSSLECGroupContext openSSLECGroupContext = new OpenSSLECGroupContext(EC_GROUP_new_curve);
        OpenSSLECPointContext openSSLECPointContext = new OpenSSLECPointContext(openSSLECGroupContext, NativeCrypto.EC_POINT_new(EC_GROUP_new_curve));
        NativeCrypto.EC_POINT_set_affine_coordinates(EC_GROUP_new_curve, openSSLECPointContext.getContext(), bigInteger4.toByteArray(), bigInteger5.toByteArray());
        NativeCrypto.EC_GROUP_set_generator(EC_GROUP_new_curve, openSSLECPointContext.getContext(), bigInteger6.toByteArray(), bigInteger7.toByteArray());
        return openSSLECGroupContext;
    }

    public static OpenSSLECGroupContext getInstance(ECParameterSpec eCParameterSpec) throws InvalidAlgorithmParameterException {
        int i;
        BigInteger reductionPolynomial;
        String curveName = Platform.getCurveName(eCParameterSpec);
        if (curveName != null) {
            return getCurveByName(curveName);
        }
        EllipticCurve curve = eCParameterSpec.getCurve();
        ECField field = curve.getField();
        if (field instanceof ECFieldFp) {
            i = 1;
            reductionPolynomial = ((ECFieldFp) field).getP();
        } else if (!(field instanceof ECFieldF2m)) {
            throw new InvalidParameterException("unhandled field class " + field.getClass().getName());
        } else {
            i = 2;
            reductionPolynomial = ((ECFieldF2m) field).getReductionPolynomial();
        }
        ECPoint generator = eCParameterSpec.getGenerator();
        return getInstance(i, reductionPolynomial, curve.getA(), curve.getB(), generator.getAffineX(), generator.getAffineY(), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor()));
    }

    public boolean equals(Object obj) {
        if (obj instanceof OpenSSLECGroupContext) {
            return NativeCrypto.EC_GROUP_cmp(this.groupCtx, ((OpenSSLECGroupContext) obj).groupCtx);
        }
        return false;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.groupCtx != 0) {
                NativeCrypto.EC_GROUP_clear_free(this.groupCtx);
            }
        } finally {
            super.finalize();
        }
    }

    public long getContext() {
        return this.groupCtx;
    }

    public ECParameterSpec getECParameterSpec() {
        ECField eCFieldF2m;
        String EC_GROUP_get_curve_name = NativeCrypto.EC_GROUP_get_curve_name(this.groupCtx);
        byte[][] EC_GROUP_get_curve = NativeCrypto.EC_GROUP_get_curve(this.groupCtx);
        BigInteger bigInteger = new BigInteger(EC_GROUP_get_curve[0]);
        BigInteger bigInteger2 = new BigInteger(EC_GROUP_get_curve[1]);
        BigInteger bigInteger3 = new BigInteger(EC_GROUP_get_curve[2]);
        int i = NativeCrypto.get_EC_GROUP_type(this.groupCtx);
        if (i == 1) {
            eCFieldF2m = new ECFieldFp(bigInteger);
        } else if (i != 2) {
            throw new RuntimeException("unknown curve type " + i);
        } else {
            eCFieldF2m = new ECFieldF2m(bigInteger.bitLength() - 1, bigInteger);
        }
        ECParameterSpec eCParameterSpec = new ECParameterSpec(new EllipticCurve(eCFieldF2m, bigInteger2, bigInteger3), new OpenSSLECPointContext(this, NativeCrypto.EC_GROUP_get_generator(this.groupCtx)).getECPoint(), new BigInteger(NativeCrypto.EC_GROUP_get_order(this.groupCtx)), new BigInteger(NativeCrypto.EC_GROUP_get_cofactor(this.groupCtx)).intValue());
        Platform.setCurveName(eCParameterSpec, EC_GROUP_get_curve_name);
        return eCParameterSpec;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
