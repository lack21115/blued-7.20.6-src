package android.media.tv;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvContentRating.class */
public final class TvContentRating {
    private static final String DELIMITER = "/";
    private final String mDomain;
    private final int mHashCode;
    private final String mRating;
    private final String mRatingSystem;
    private final String[] mSubRatings;

    private TvContentRating(String str, String str2, String str3, String[] strArr) {
        this.mDomain = str;
        this.mRatingSystem = str2;
        this.mRating = str3;
        if (strArr == null || strArr.length == 0) {
            this.mSubRatings = null;
        } else {
            Arrays.sort(strArr);
            this.mSubRatings = strArr;
        }
        this.mHashCode = (Objects.hash(this.mDomain, this.mRating) * 31) + Arrays.hashCode(this.mSubRatings);
    }

    public static TvContentRating createRating(String str, String str2, String str3, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("domain cannot be empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("ratingSystem cannot be empty");
        }
        if (TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("rating cannot be empty");
        }
        return new TvContentRating(str, str2, str3, strArr);
    }

    public static TvContentRating unflattenFromString(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("ratingString cannot be empty");
        }
        String[] split = str.split("/");
        if (split.length < 3) {
            throw new IllegalArgumentException("Invalid rating string: " + str);
        }
        if (split.length > 3) {
            String[] strArr = new String[split.length - 3];
            System.arraycopy(split, 3, strArr, 0, strArr.length);
            return new TvContentRating(split[0], split[1], split[2], strArr);
        }
        return new TvContentRating(split[0], split[1], split[2], null);
    }

    public final boolean contains(TvContentRating tvContentRating) {
        if (tvContentRating == null) {
            throw new IllegalArgumentException("rating cannot be null");
        }
        if (tvContentRating.getMainRating().equals(this.mRating) && tvContentRating.getDomain().equals(this.mDomain) && tvContentRating.getRatingSystem().equals(this.mRatingSystem) && tvContentRating.getMainRating().equals(this.mRating)) {
            List<String> subRatings = getSubRatings();
            List<String> subRatings2 = tvContentRating.getSubRatings();
            if (subRatings == null && subRatings2 == null) {
                return true;
            }
            if (subRatings != null || subRatings2 == null) {
                if (subRatings == null || subRatings2 != null) {
                    return subRatings.containsAll(subRatings2);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TvContentRating) {
            TvContentRating tvContentRating = (TvContentRating) obj;
            if (this.mHashCode == tvContentRating.mHashCode && TextUtils.equals(this.mDomain, tvContentRating.mDomain) && TextUtils.equals(this.mRatingSystem, tvContentRating.mRatingSystem) && TextUtils.equals(this.mRating, tvContentRating.mRating)) {
                return Arrays.equals(this.mSubRatings, tvContentRating.mSubRatings);
            }
            return false;
        }
        return false;
    }

    public String flattenToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mDomain);
        sb.append("/");
        sb.append(this.mRatingSystem);
        sb.append("/");
        sb.append(this.mRating);
        if (this.mSubRatings != null) {
            String[] strArr = this.mSubRatings;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = strArr[i2];
                sb.append("/");
                sb.append(str);
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    public String getDomain() {
        return this.mDomain;
    }

    public String getMainRating() {
        return this.mRating;
    }

    public String getRatingSystem() {
        return this.mRatingSystem;
    }

    public List<String> getSubRatings() {
        if (this.mSubRatings == null) {
            return null;
        }
        return Collections.unmodifiableList(Arrays.asList(this.mSubRatings));
    }

    public int hashCode() {
        return this.mHashCode;
    }
}
