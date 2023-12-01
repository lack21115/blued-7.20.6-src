package java.math;

import com.android.ims.ImsReasonInfo;
import com.android.internal.R;
import com.android.internal.telephony.RILConstants;
import io.grpc.internal.GrpcUtil;
import java.net.HttpURLConnection;
import java.util.Arrays;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-2895416-dex2jar.jar:java/math/Primality.class */
class Primality {
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, R.styleable.Theme_preferenceListStyle, R.styleable.Theme_colorSwitchThumbNormal, 311, 313, 317, ImsReasonInfo.CODE_SIP_BAD_REQUEST, ImsReasonInfo.CODE_SIP_BAD_ADDRESS, 347, 349, ImsReasonInfo.CODE_SIP_SERVER_BAD_GATEWAY, ImsReasonInfo.CODE_SIP_SERVER_ERROR, 367, 373, 379, 383, 389, 397, 401, HttpURLConnection.HTTP_CONFLICT, 419, 421, 431, 433, 439, GrpcUtil.DEFAULT_PORT_SSL, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, GL10.GL_ONE_MINUS_SRC_COLOR, GL10.GL_ONE_MINUS_DST_ALPHA, 787, 797, 809, 811, ImsReasonInfo.CODE_UT_CB_PASSWORD_MISMATCH, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, RILConstants.RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED, RILConstants.RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS};
    private static final BigInteger[] BIprimes = new BigInteger[primes.length];

    static {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= primes.length) {
                return;
            }
            BIprimes[i2] = BigInteger.valueOf(primes[i2]);
            i = i2 + 1;
        }
    }

    private Primality() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger nextProbablePrime(BigInteger bigInteger) {
        int longInt;
        int[] iArr = new int[primes.length];
        boolean[] zArr = new boolean[1024];
        BigInt bigInt = bigInteger.getBigInt();
        if (bigInt.bitLength() > 10 || (longInt = (int) bigInt.longInt()) >= primes[primes.length - 1]) {
            BigInt copy = bigInt.copy();
            BigInt bigInt2 = new BigInt();
            copy.addPositiveInt(BigInt.remainderByPositiveInt(bigInt, 2) + 1);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= primes.length) {
                    break;
                }
                iArr[i2] = BigInt.remainderByPositiveInt(copy, primes[i2]) - 1024;
                i = i2 + 1;
            }
            while (true) {
                Arrays.fill(zArr, false);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= primes.length) {
                        break;
                    }
                    iArr[i4] = (iArr[i4] + 1024) % primes[i4];
                    int i5 = iArr[i4] == 0 ? 0 : primes[i4] - iArr[i4];
                    while (true) {
                        int i6 = i5;
                        if (i6 < 1024) {
                            zArr[i6] = true;
                            i5 = i6 + primes[i4];
                        }
                    }
                    i3 = i4 + 1;
                }
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 < 1024) {
                        if (!zArr[i8]) {
                            bigInt2.putCopy(copy);
                            bigInt2.addPositiveInt(i8);
                            if (bigInt2.isPrime(100)) {
                                return new BigInteger(bigInt2);
                            }
                        }
                        i7 = i8 + 1;
                    }
                }
                copy.addPositiveInt(1024);
            }
        } else {
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (longInt < primes[i10]) {
                    return BIprimes[i10];
                }
                i9 = i10 + 1;
            }
        }
    }
}
