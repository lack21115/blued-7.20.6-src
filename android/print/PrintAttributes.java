package android.print;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.Camera;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.igexin.push.core.b;
import com.qq.e.comm.constants.ErrorCode;
import com.tencent.thumbplayer.api.TPErrorCode;
import com.umeng.analytics.pro.i;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/print/PrintAttributes.class */
public final class PrintAttributes implements Parcelable {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final Parcelable.Creator<PrintAttributes> CREATOR = new Parcelable.Creator<PrintAttributes>() { // from class: android.print.PrintAttributes.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrintAttributes createFromParcel(Parcel parcel) {
            return new PrintAttributes(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrintAttributes[] newArray(int i) {
            return new PrintAttributes[i];
        }
    };
    private static final int VALID_COLOR_MODES = 3;
    private int mColorMode;
    private MediaSize mMediaSize;
    private Margins mMinMargins;
    private Resolution mResolution;

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrintAttributes$Builder.class */
    public static final class Builder {
        private final PrintAttributes mAttributes = new PrintAttributes();

        public PrintAttributes build() {
            return this.mAttributes;
        }

        public Builder setColorMode(int i) {
            if (Integer.bitCount(i) > 1) {
                throw new IllegalArgumentException("can specify at most one colorMode bit.");
            }
            this.mAttributes.setColorMode(i);
            return this;
        }

        public Builder setMediaSize(MediaSize mediaSize) {
            this.mAttributes.setMediaSize(mediaSize);
            return this;
        }

        public Builder setMinMargins(Margins margins) {
            this.mAttributes.setMinMargins(margins);
            return this;
        }

        public Builder setResolution(Resolution resolution) {
            this.mAttributes.setResolution(resolution);
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrintAttributes$Margins.class */
    public static final class Margins {
        public static final Margins NO_MARGINS = new Margins(0, 0, 0, 0);
        private final int mBottomMils;
        private final int mLeftMils;
        private final int mRightMils;
        private final int mTopMils;

        public Margins(int i, int i2, int i3, int i4) {
            this.mTopMils = i2;
            this.mLeftMils = i;
            this.mRightMils = i3;
            this.mBottomMils = i4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Margins createFromParcel(Parcel parcel) {
            return new Margins(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Margins margins = (Margins) obj;
                return this.mBottomMils == margins.mBottomMils && this.mLeftMils == margins.mLeftMils && this.mRightMils == margins.mRightMils && this.mTopMils == margins.mTopMils;
            }
            return false;
        }

        public int getBottomMils() {
            return this.mBottomMils;
        }

        public int getLeftMils() {
            return this.mLeftMils;
        }

        public int getRightMils() {
            return this.mRightMils;
        }

        public int getTopMils() {
            return this.mTopMils;
        }

        public int hashCode() {
            return ((((((this.mBottomMils + 31) * 31) + this.mLeftMils) * 31) + this.mRightMils) * 31) + this.mTopMils;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Margins{");
            sb.append("leftMils: ").append(this.mLeftMils);
            sb.append(", topMils: ").append(this.mTopMils);
            sb.append(", rightMils: ").append(this.mRightMils);
            sb.append(", bottomMils: ").append(this.mBottomMils);
            sb.append("}");
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.mLeftMils);
            parcel.writeInt(this.mTopMils);
            parcel.writeInt(this.mRightMils);
            parcel.writeInt(this.mBottomMils);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrintAttributes$MediaSize.class */
    public static final class MediaSize {
        private static final String LOG_TAG = "MediaSize";
        private final int mHeightMils;
        private final String mId;
        public final String mLabel;
        public final int mLabelResId;
        public final String mPackageName;
        private final int mWidthMils;
        private static final Map<String, MediaSize> sIdToMediaSizeMap = new ArrayMap();
        public static final MediaSize UNKNOWN_PORTRAIT = new MediaSize("UNKNOWN_PORTRAIT", "android", 17041210, 1, Integer.MAX_VALUE);
        public static final MediaSize UNKNOWN_LANDSCAPE = new MediaSize("UNKNOWN_LANDSCAPE", "android", 17041211, Integer.MAX_VALUE, 1);
        public static final MediaSize ISO_A0 = new MediaSize("ISO_A0", "android", 17041129, 33110, 46810);
        public static final MediaSize ISO_A1 = new MediaSize("ISO_A1", "android", 17041130, 23390, 33110);
        public static final MediaSize ISO_A2 = new MediaSize("ISO_A2", "android", 17041131, 16540, 23390);
        public static final MediaSize ISO_A3 = new MediaSize("ISO_A3", "android", 17041132, 11690, 16540);
        public static final MediaSize ISO_A4 = new MediaSize("ISO_A4", "android", 17041133, 8270, 11690);
        public static final MediaSize ISO_A5 = new MediaSize("ISO_A5", "android", 17041134, 5830, 8270);
        public static final MediaSize ISO_A6 = new MediaSize("ISO_A6", "android", 17041135, 4130, 5830);
        public static final MediaSize ISO_A7 = new MediaSize("ISO_A7", "android", 17041136, 2910, 4130);
        public static final MediaSize ISO_A8 = new MediaSize("ISO_A8", "android", 17041137, i.b, 2910);
        public static final MediaSize ISO_A9 = new MediaSize("ISO_A9", "android", 17041138, 1460, i.b);
        public static final MediaSize ISO_A10 = new MediaSize("ISO_A10", "android", 17041139, 1020, 1460);
        public static final MediaSize ISO_B0 = new MediaSize("ISO_B0", "android", 17041140, 39370, 55670);
        public static final MediaSize ISO_B1 = new MediaSize("ISO_B1", "android", 17041141, 27830, 39370);
        public static final MediaSize ISO_B2 = new MediaSize("ISO_B2", "android", 17041142, 19690, 27830);
        public static final MediaSize ISO_B3 = new MediaSize("ISO_B3", "android", 17041143, 13900, 19690);
        public static final MediaSize ISO_B4 = new MediaSize("ISO_B4", "android", 17041144, 9840, 13900);
        public static final MediaSize ISO_B5 = new MediaSize("ISO_B5", "android", 17041145, 6930, 9840);
        public static final MediaSize ISO_B6 = new MediaSize("ISO_B6", "android", 17041146, 4920, 6930);
        public static final MediaSize ISO_B7 = new MediaSize("ISO_B7", "android", 17041147, 3460, 4920);
        public static final MediaSize ISO_B8 = new MediaSize("ISO_B8", "android", 17041148, 2440, 3460);
        public static final MediaSize ISO_B9 = new MediaSize("ISO_B9", "android", 17041149, 1730, 2440);
        public static final MediaSize ISO_B10 = new MediaSize("ISO_B10", "android", 17041150, 1220, 1730);
        public static final MediaSize ISO_C0 = new MediaSize("ISO_C0", "android", 17041151, 36100, 51060);
        public static final MediaSize ISO_C1 = new MediaSize("ISO_C1", "android", 17041152, 25510, 36100);
        public static final MediaSize ISO_C2 = new MediaSize("ISO_C2", "android", 17041153, 18030, 25510);
        public static final MediaSize ISO_C3 = new MediaSize("ISO_C3", "android", 17041154, 12760, 18030);
        public static final MediaSize ISO_C4 = new MediaSize("ISO_C4", "android", 17041155, 9020, 12760);
        public static final MediaSize ISO_C5 = new MediaSize("ISO_C5", "android", 17041156, 6380, 9020);
        public static final MediaSize ISO_C6 = new MediaSize("ISO_C6", "android", 17041157, 4490, 6380);
        public static final MediaSize ISO_C7 = new MediaSize("ISO_C7", "android", 17041158, 3190, 4490);
        public static final MediaSize ISO_C8 = new MediaSize("ISO_C8", "android", 17041159, 2240, 3190);
        public static final MediaSize ISO_C9 = new MediaSize("ISO_C9", "android", 17041160, 1570, 2240);
        public static final MediaSize ISO_C10 = new MediaSize("ISO_C10", "android", 17041161, 1100, 1570);
        public static final MediaSize NA_LETTER = new MediaSize("NA_LETTER", "android", 17041162, 8500, 11000);
        public static final MediaSize NA_GOVT_LETTER = new MediaSize("NA_GOVT_LETTER", "android", 17041163, 8000, 10500);
        public static final MediaSize NA_LEGAL = new MediaSize("NA_LEGAL", "android", 17041164, 8500, 14000);
        public static final MediaSize NA_JUNIOR_LEGAL = new MediaSize("NA_JUNIOR_LEGAL", "android", 17041165, 8000, 5000);
        public static final MediaSize NA_LEDGER = new MediaSize("NA_LEDGER", "android", 17041166, 17000, 11000);
        public static final MediaSize NA_TABLOID = new MediaSize("NA_TABLOID", "android", 17041167, 11000, 17000);
        public static final MediaSize NA_INDEX_3X5 = new MediaSize("NA_INDEX_3X5", "android", 17041168, 3000, 5000);
        public static final MediaSize NA_INDEX_4X6 = new MediaSize("NA_INDEX_4X6", "android", 17041169, TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY, 6000);
        public static final MediaSize NA_INDEX_5X8 = new MediaSize("NA_INDEX_5X8", "android", 17041170, 5000, 8000);
        public static final MediaSize NA_MONARCH = new MediaSize("NA_MONARCH", "android", 17041171, 7250, 10500);
        public static final MediaSize NA_QUARTO = new MediaSize("NA_QUARTO", "android", 17041172, 8000, 10000);
        public static final MediaSize NA_FOOLSCAP = new MediaSize("NA_FOOLSCAP", "android", 17041173, 8000, 13000);
        public static final MediaSize ROC_8K = new MediaSize("ROC_8K", "android", 17041174, 10629, 15354);
        public static final MediaSize ROC_16K = new MediaSize("ROC_16K", "android", 17041175, 7677, 10629);
        public static final MediaSize PRC_1 = new MediaSize("PRC_1", "android", 17041176, ErrorCode.AD_REPLAY, 6496);
        public static final MediaSize PRC_2 = new MediaSize("PRC_2", "android", 17041177, ErrorCode.AD_REPLAY, 6929);
        public static final MediaSize PRC_3 = new MediaSize("PRC_3", "android", 17041178, 4921, 6929);
        public static final MediaSize PRC_4 = new MediaSize("PRC_4", "android", 17041179, 4330, 8189);
        public static final MediaSize PRC_5 = new MediaSize("PRC_5", "android", 17041180, 4330, 8661);
        public static final MediaSize PRC_6 = new MediaSize("PRC_6", "android", 17041181, 4724, 12599);
        public static final MediaSize PRC_7 = new MediaSize("PRC_7", "android", 17041182, 6299, 9055);
        public static final MediaSize PRC_8 = new MediaSize("PRC_8", "android", 17041183, 4724, 12165);
        public static final MediaSize PRC_9 = new MediaSize("PRC_9", "android", 17041184, 9016, 12756);
        public static final MediaSize PRC_10 = new MediaSize("PRC_10", "android", 17041185, 12756, 18032);
        public static final MediaSize PRC_16K = new MediaSize("PRC_16K", "android", 17041186, 5749, 8465);
        public static final MediaSize OM_PA_KAI = new MediaSize("OM_PA_KAI", "android", 17041187, 10512, 15315);
        public static final MediaSize OM_DAI_PA_KAI = new MediaSize("OM_DAI_PA_KAI", "android", 17041188, 10827, 15551);
        public static final MediaSize OM_JUURO_KU_KAI = new MediaSize("OM_JUURO_KU_KAI", "android", 17041189, 7796, 10827);
        public static final MediaSize JIS_B10 = new MediaSize("JIS_B10", "android", 17041190, 1259, 1772);
        public static final MediaSize JIS_B9 = new MediaSize("JIS_B9", "android", 17041191, 1772, 2520);
        public static final MediaSize JIS_B8 = new MediaSize("JIS_B8", "android", 17041192, 2520, 3583);
        public static final MediaSize JIS_B7 = new MediaSize("JIS_B7", "android", 17041193, 3583, 5049);
        public static final MediaSize JIS_B6 = new MediaSize("JIS_B6", "android", 17041194, 5049, 7165);
        public static final MediaSize JIS_B5 = new MediaSize("JIS_B5", "android", 17041195, 7165, 10118);
        public static final MediaSize JIS_B4 = new MediaSize("JIS_B4", "android", 17041196, 10118, 14331);
        public static final MediaSize JIS_B3 = new MediaSize("JIS_B3", "android", 17041197, 14331, 20276);
        public static final MediaSize JIS_B2 = new MediaSize("JIS_B2", "android", 17041198, 20276, 28661);
        public static final MediaSize JIS_B1 = new MediaSize("JIS_B1", "android", 17041199, 28661, 40551);
        public static final MediaSize JIS_B0 = new MediaSize("JIS_B0", "android", 17041200, 40551, 57323);
        public static final MediaSize JIS_EXEC = new MediaSize("JIS_EXEC", "android", 17041201, 8504, 12992);
        public static final MediaSize JPN_CHOU4 = new MediaSize("JPN_CHOU4", "android", 17041202, 3543, 8071);
        public static final MediaSize JPN_CHOU3 = new MediaSize("JPN_CHOU3", "android", 17041203, 4724, 9252);
        public static final MediaSize JPN_CHOU2 = new MediaSize("JPN_CHOU2", "android", 17041204, 4374, 5748);
        public static final MediaSize JPN_HAGAKI = new MediaSize("JPN_HAGAKI", "android", 17041205, 3937, 5827);
        public static final MediaSize JPN_OUFUKU = new MediaSize("JPN_OUFUKU", "android", 17041206, 5827, 7874);
        public static final MediaSize JPN_KAHU = new MediaSize("JPN_KAHU", "android", 17041207, 9449, 12681);
        public static final MediaSize JPN_KAKU2 = new MediaSize("JPN_KAKU2", "android", 17041208, 9449, 13071);
        public static final MediaSize JPN_YOU4 = new MediaSize("JPN_YOU4", "android", 17041209, 4134, 9252);

        public MediaSize(String str, String str2, int i, int i2) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("id cannot be empty.");
            }
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("label cannot be empty.");
            }
            if (i <= 0) {
                throw new IllegalArgumentException("widthMils cannot be less than or equal to zero.");
            }
            if (i2 <= 0) {
                throw new IllegalArgumentException("heightMils cannot be less than or euqual to zero.");
            }
            this.mId = str;
            this.mLabel = str2;
            this.mWidthMils = i;
            this.mHeightMils = i2;
            this.mLabelResId = 0;
            this.mPackageName = null;
        }

        public MediaSize(String str, String str2, int i, int i2, int i3) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("id cannot be empty.");
            }
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("packageName cannot be empty.");
            }
            if (i <= 0) {
                throw new IllegalArgumentException("labelResId must be greater than zero.");
            }
            if (i2 <= 0) {
                throw new IllegalArgumentException("widthMils cannot be less than or equal to zero.");
            }
            if (i3 <= 0) {
                throw new IllegalArgumentException("heightMils cannot be less than or euqual to zero.");
            }
            this.mPackageName = str2;
            this.mId = str;
            this.mLabelResId = i;
            this.mWidthMils = i2;
            this.mHeightMils = i3;
            this.mLabel = null;
            sIdToMediaSizeMap.put(this.mId, this);
        }

        public MediaSize(String str, String str2, String str3, int i, int i2, int i3) {
            this.mPackageName = str3;
            this.mId = str;
            this.mLabelResId = i3;
            this.mWidthMils = i;
            this.mHeightMils = i2;
            this.mLabel = str2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static MediaSize createFromParcel(Parcel parcel) {
            return new MediaSize(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        public static MediaSize getStandardMediaSizeById(String str) {
            return sIdToMediaSizeMap.get(str);
        }

        public MediaSize asLandscape() {
            return !isPortrait() ? this : new MediaSize(this.mId, this.mLabel, this.mPackageName, Math.max(this.mWidthMils, this.mHeightMils), Math.min(this.mWidthMils, this.mHeightMils), this.mLabelResId);
        }

        public MediaSize asPortrait() {
            return isPortrait() ? this : new MediaSize(this.mId, this.mLabel, this.mPackageName, Math.min(this.mWidthMils, this.mHeightMils), Math.max(this.mWidthMils, this.mHeightMils), this.mLabelResId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                MediaSize mediaSize = (MediaSize) obj;
                return this.mWidthMils == mediaSize.mWidthMils && this.mHeightMils == mediaSize.mHeightMils;
            }
            return false;
        }

        public int getHeightMils() {
            return this.mHeightMils;
        }

        public String getId() {
            return this.mId;
        }

        public String getLabel(PackageManager packageManager) {
            if (!TextUtils.isEmpty(this.mPackageName) && this.mLabelResId > 0) {
                try {
                    return packageManager.getResourcesForApplication(this.mPackageName).getString(this.mLabelResId);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.w(LOG_TAG, "Could not load resouce" + this.mLabelResId + " from package " + this.mPackageName);
                } catch (Resources.NotFoundException e2) {
                    Log.w(LOG_TAG, "Could not load resouce" + this.mLabelResId + " from package " + this.mPackageName);
                }
            }
            return this.mLabel;
        }

        public int getWidthMils() {
            return this.mWidthMils;
        }

        public int hashCode() {
            return ((this.mWidthMils + 31) * 31) + this.mHeightMils;
        }

        public boolean isPortrait() {
            return this.mHeightMils >= this.mWidthMils;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MediaSize{");
            sb.append("id: ").append(this.mId);
            sb.append(", label: ").append(this.mLabel);
            sb.append(", packageName: ").append(this.mPackageName);
            sb.append(", heightMils: ").append(this.mHeightMils);
            sb.append(", widthMils: ").append(this.mWidthMils);
            sb.append(", labelResId: ").append(this.mLabelResId);
            sb.append("}");
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeString(this.mId);
            parcel.writeString(this.mLabel);
            parcel.writeString(this.mPackageName);
            parcel.writeInt(this.mWidthMils);
            parcel.writeInt(this.mHeightMils);
            parcel.writeInt(this.mLabelResId);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrintAttributes$Resolution.class */
    public static final class Resolution {
        private final int mHorizontalDpi;
        private final String mId;
        private final String mLabel;
        private final int mVerticalDpi;

        public Resolution(String str, String str2, int i, int i2) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("id cannot be empty.");
            }
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("label cannot be empty.");
            }
            if (i <= 0) {
                throw new IllegalArgumentException("horizontalDpi cannot be less than or equal to zero.");
            }
            if (i2 <= 0) {
                throw new IllegalArgumentException("verticalDpi cannot be less than or equal to zero.");
            }
            this.mId = str;
            this.mLabel = str2;
            this.mHorizontalDpi = i;
            this.mVerticalDpi = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Resolution createFromParcel(Parcel parcel) {
            return new Resolution(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Resolution resolution = (Resolution) obj;
                return this.mHorizontalDpi == resolution.mHorizontalDpi && this.mVerticalDpi == resolution.mVerticalDpi;
            }
            return false;
        }

        public int getHorizontalDpi() {
            return this.mHorizontalDpi;
        }

        public String getId() {
            return this.mId;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public int getVerticalDpi() {
            return this.mVerticalDpi;
        }

        public int hashCode() {
            return ((this.mHorizontalDpi + 31) * 31) + this.mVerticalDpi;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Resolution{");
            sb.append("id: ").append(this.mId);
            sb.append(", label: ").append(this.mLabel);
            sb.append(", horizontalDpi: ").append(this.mHorizontalDpi);
            sb.append(", verticalDpi: ").append(this.mVerticalDpi);
            sb.append("}");
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeString(this.mId);
            parcel.writeString(this.mLabel);
            parcel.writeInt(this.mHorizontalDpi);
            parcel.writeInt(this.mVerticalDpi);
        }
    }

    PrintAttributes() {
    }

    private PrintAttributes(Parcel parcel) {
        this.mMediaSize = parcel.readInt() == 1 ? MediaSize.createFromParcel(parcel) : null;
        this.mResolution = parcel.readInt() == 1 ? Resolution.createFromParcel(parcel) : null;
        this.mMinMargins = parcel.readInt() == 1 ? Margins.createFromParcel(parcel) : null;
        this.mColorMode = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String colorModeToString(int i) {
        switch (i) {
            case 1:
                return "COLOR_MODE_MONOCHROME";
            case 2:
                return "COLOR_MODE_COLOR";
            default:
                return "COLOR_MODE_UNKNOWN";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void enforceValidColorMode(int i) {
        if ((i & 3) == 0 && Integer.bitCount(i) == 1) {
            throw new IllegalArgumentException("invalid color mode: " + i);
        }
    }

    public PrintAttributes asLandscape() {
        if (isPortrait()) {
            PrintAttributes printAttributes = new PrintAttributes();
            printAttributes.setMediaSize(getMediaSize().asLandscape());
            Resolution resolution = getResolution();
            printAttributes.setResolution(new Resolution(resolution.getId(), resolution.getLabel(), resolution.getVerticalDpi(), resolution.getHorizontalDpi()));
            printAttributes.setMinMargins(getMinMargins());
            printAttributes.setColorMode(getColorMode());
            return printAttributes;
        }
        return this;
    }

    public PrintAttributes asPortrait() {
        if (isPortrait()) {
            return this;
        }
        PrintAttributes printAttributes = new PrintAttributes();
        printAttributes.setMediaSize(getMediaSize().asPortrait());
        Resolution resolution = getResolution();
        printAttributes.setResolution(new Resolution(resolution.getId(), resolution.getLabel(), resolution.getVerticalDpi(), resolution.getHorizontalDpi()));
        printAttributes.setMinMargins(getMinMargins());
        printAttributes.setColorMode(getColorMode());
        return printAttributes;
    }

    public void clear() {
        this.mMediaSize = null;
        this.mResolution = null;
        this.mMinMargins = null;
        this.mColorMode = 0;
    }

    public void copyFrom(PrintAttributes printAttributes) {
        this.mMediaSize = printAttributes.mMediaSize;
        this.mResolution = printAttributes.mResolution;
        this.mMinMargins = printAttributes.mMinMargins;
        this.mColorMode = printAttributes.mColorMode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PrintAttributes printAttributes = (PrintAttributes) obj;
            if (this.mColorMode != printAttributes.mColorMode) {
                return false;
            }
            if (this.mMinMargins == null) {
                if (printAttributes.mMinMargins != null) {
                    return false;
                }
            } else if (!this.mMinMargins.equals(printAttributes.mMinMargins)) {
                return false;
            }
            if (this.mMediaSize == null) {
                if (printAttributes.mMediaSize != null) {
                    return false;
                }
            } else if (!this.mMediaSize.equals(printAttributes.mMediaSize)) {
                return false;
            }
            return this.mResolution == null ? printAttributes.mResolution == null : this.mResolution.equals(printAttributes.mResolution);
        }
        return false;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public MediaSize getMediaSize() {
        return this.mMediaSize;
    }

    public Margins getMinMargins() {
        return this.mMinMargins;
    }

    public Resolution getResolution() {
        return this.mResolution;
    }

    public int hashCode() {
        int i = 0;
        int i2 = this.mColorMode;
        int hashCode = this.mMinMargins == null ? 0 : this.mMinMargins.hashCode();
        int hashCode2 = this.mMediaSize == null ? 0 : this.mMediaSize.hashCode();
        if (this.mResolution != null) {
            i = this.mResolution.hashCode();
        }
        return ((((((i2 + 31) * 31) + hashCode) * 31) + hashCode2) * 31) + i;
    }

    public boolean isPortrait() {
        return this.mMediaSize.isPortrait();
    }

    public void setColorMode(int i) {
        enforceValidColorMode(i);
        this.mColorMode = i;
    }

    public void setMediaSize(MediaSize mediaSize) {
        this.mMediaSize = mediaSize;
    }

    public void setMinMargins(Margins margins) {
        this.mMinMargins = margins;
    }

    public void setResolution(Resolution resolution) {
        this.mResolution = resolution;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrintAttributes{");
        sb.append("mediaSize: ").append(this.mMediaSize);
        if (this.mMediaSize != null) {
            sb.append(", orientation: ").append(this.mMediaSize.isPortrait() ? Camera.Parameters.SCENE_MODE_PORTRAIT : Camera.Parameters.SCENE_MODE_LANDSCAPE);
        } else {
            sb.append(", orientation: ").append(b.l);
        }
        sb.append(", resolution: ").append(this.mResolution);
        sb.append(", minMargins: ").append(this.mMinMargins);
        sb.append(", colorMode: ").append(colorModeToString(this.mColorMode));
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.mMediaSize != null) {
            parcel.writeInt(1);
            this.mMediaSize.writeToParcel(parcel);
        } else {
            parcel.writeInt(0);
        }
        if (this.mResolution != null) {
            parcel.writeInt(1);
            this.mResolution.writeToParcel(parcel);
        } else {
            parcel.writeInt(0);
        }
        if (this.mMinMargins != null) {
            parcel.writeInt(1);
            this.mMinMargins.writeToParcel(parcel);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.mColorMode);
    }
}
