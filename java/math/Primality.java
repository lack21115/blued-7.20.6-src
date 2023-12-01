package java.math;

import android.provider.Downloads;
import com.android.ims.ImsReasonInfo;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.live.LiveProtos;
import com.tencent.cloud.huiyansdkface.facelivesdk.BuildConfig;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/math/Primality.class */
class Primality {
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, ChatRoomProtos.Event.YY_LIFT_MASK_POP_USE_CLICK_VALUE, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, LiveProtos.Event.LIVE_ROOM_CONFIG_POP_LINK_CLICK_VALUE, LiveProtos.Event.LIVE_LIST_CONFIG_POP_SHOW_VALUE, LiveProtos.Event.LIVE_VIP_ICON_CLICK_VALUE, LiveProtos.Event.LIVE_DOWN_COLLECTION_FEATURE_CLICK_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_HISTORY_ONE_CLICK_VALUE, Downloads.Impl.STATUS_UNKNOWN_ERROR, 499, 503, 509, LiveProtos.Event.LIVE_HOUR_LIST_TOP_TAB_SHOW_VALUE, LiveProtos.Event.LIVE_HOUR_LIST_TIME_TAB_SHOW_VALUE, LiveProtos.Event.LIVE_BAG_CHAT_MARK_USE_CLICK_VALUE, LiveProtos.Event.LIVE_GIFT_VALIDITY_POP_YES_CLICK_VALUE, LiveProtos.Event.LIVE_KEYBOARD_BARRAGE_CLICK_VALUE, LiveProtos.Event.LIVE_NOBLE_BANNER_SHOW_VALUE, 569, 571, 577, LiveProtos.Event.LIVE_PK_MORE_START_BTN_SHOW_VALUE, LiveProtos.Event.LIVE_PK_MORE_SCORE_BTN_SHOW_VALUE, LiveProtos.Event.LIVE_PK_MORE_EXIT_YES_CLICK_VALUE, 601, 607, 613, LiveProtos.Event.LIVE_BATTLE_PASS_TOP_ENTRANCE_CLICK_VALUE, LiveProtos.Event.LIVE_BATTLE_PASS_TOP_PAGE_BUY_CLICK_VALUE, LiveProtos.Event.LIVE_SET_GIFT_EXPLAIN_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_STAR_CANCEL_VALUE, LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_RECORD_CLICK_VALUE, LiveProtos.Event.LIVE_NEW_FIRST_PAY_POP_SHOW_VALUE, LiveProtos.Event.LIVE_PROFILE_CARD_SUBSTITUTE_ME_CLICK_VALUE, LiveProtos.Event.LIVE_ONLINE_USER_PAGE_BTN_CLICK_VALUE, LiveProtos.Event.LIVE_USER_RANDOM_GIFT_PAGE_LOTTERY_CLICK_VALUE, LiveProtos.Event.LIVE_ANCHOR_RANDOM_GIFT_EXPLAIN_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_CUSTOM_MADE_SEAL_PAGE_REWARD_POP_SHOW_VALUE, 691, 701, LiveProtos.Event.ANCHOR_END_PAGE_COLLEGE_CLICK_VALUE, 719, 727, 733, 739, 743, TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA, 757, 761, 769, 773, 787, 797, 809, 811, ImsReasonInfo.CODE_UT_CB_PASSWORD_MISMATCH, 823, 827, 829, BuildConfig.VERSION_CODE, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021};
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
