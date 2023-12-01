package android.telephony;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.anythink.expressad.exoplayer.b;
import com.google.android.material.timepicker.TimeModel;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/SubscriptionInfo.class */
public class SubscriptionInfo implements Parcelable {
    public static final Parcelable.Creator<SubscriptionInfo> CREATOR = new Parcelable.Creator<SubscriptionInfo>() { // from class: android.telephony.SubscriptionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubscriptionInfo createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            int readInt2 = parcel.readInt();
            CharSequence readCharSequence = parcel.readCharSequence();
            CharSequence readCharSequence2 = parcel.readCharSequence();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            String readString2 = parcel.readString();
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            int readInt7 = parcel.readInt();
            int readInt8 = parcel.readInt();
            int readInt9 = parcel.readInt();
            int readInt10 = parcel.readInt();
            return new SubscriptionInfo(readInt, readString, readInt2, readCharSequence, readCharSequence2, readInt3, readInt4, readString2, readInt5, Bitmap.CREATOR.createFromParcel(parcel), readInt6, readInt7, parcel.readString(), readInt8, readInt9, readInt10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubscriptionInfo[] newArray(int i) {
            return new SubscriptionInfo[i];
        }
    };
    private static final int TEXT_SIZE = 16;
    private CharSequence mCarrierName;
    private String mCountryIso;
    private int mDataRoaming;
    private CharSequence mDisplayName;
    private String mIccId;
    private Bitmap mIconBitmap;
    private int mIconTint;
    private int mId;
    private int mMcc;
    private int mMnc;
    private int mNameSource;
    private String mNumber;
    public int mNwMode;
    private int mSimSlotIndex;
    public int mStatus;
    public int mUserNwMode;

    public SubscriptionInfo(int i, String str, int i2, CharSequence charSequence, CharSequence charSequence2, int i3, int i4, String str2, int i5, Bitmap bitmap, int i6, int i7, String str3, int i8, int i9, int i10) {
        this.mId = i;
        this.mIccId = str;
        this.mSimSlotIndex = i2;
        this.mDisplayName = charSequence;
        this.mCarrierName = charSequence2;
        this.mNameSource = i3;
        this.mIconTint = i4;
        this.mNumber = str2;
        this.mDataRoaming = i5;
        this.mIconBitmap = bitmap;
        this.mMcc = i6;
        this.mMnc = i7;
        this.mStatus = i8;
        this.mNwMode = i9;
        this.mUserNwMode = i10;
        this.mCountryIso = str3;
    }

    public Bitmap createIconBitmap(Context context) {
        int width = this.mIconBitmap.getWidth();
        int height = this.mIconBitmap.getHeight();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Bitmap createBitmap = Bitmap.createBitmap(displayMetrics, width, height, this.mIconBitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(this.mIconTint, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(this.mIconBitmap, 0.0f, 0.0f, paint);
        paint.setColorFilter(null);
        paint.setAntiAlias(true);
        paint.setTypeface(Typeface.create(b.m, 0));
        paint.setColor(-1);
        paint.setTextSize(16.0f * displayMetrics.density);
        String format = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.mSimSlotIndex + 1));
        Rect rect = new Rect();
        paint.getTextBounds(format, 0, 1, rect);
        canvas.drawText(format, (width / 2.0f) - rect.centerX(), (height / 2.0f) - rect.centerY(), paint);
        return createBitmap;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CharSequence getCarrierName() {
        return this.mCarrierName;
    }

    public String getCountryIso() {
        return this.mCountryIso;
    }

    public int getDataRoaming() {
        return this.mDataRoaming;
    }

    public CharSequence getDisplayName() {
        return this.mDisplayName;
    }

    public String getIccId() {
        return this.mIccId;
    }

    public int getIconTint() {
        return this.mIconTint;
    }

    public int getMcc() {
        return this.mMcc;
    }

    public int getMnc() {
        return this.mMnc;
    }

    public int getNameSource() {
        return this.mNameSource;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public int getNwMode() {
        return this.mNwMode;
    }

    public int getSimSlotIndex() {
        return this.mSimSlotIndex;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getSubscriptionId() {
        return this.mId;
    }

    public int getUserNwMode() {
        return this.mUserNwMode;
    }

    public void setCarrierName(CharSequence charSequence) {
        this.mCarrierName = charSequence;
    }

    public void setDisplayName(CharSequence charSequence) {
        this.mDisplayName = charSequence;
    }

    public void setIconTint(int i) {
        this.mIconTint = i;
    }

    public String toString() {
        return "{id=" + this.mId + ", iccId=" + this.mIccId + " simSlotIndex=" + this.mSimSlotIndex + " displayName=" + ((Object) this.mDisplayName) + " carrierName=" + ((Object) this.mCarrierName) + " nameSource=" + this.mNameSource + " iconTint=" + this.mIconTint + " dataRoaming=" + this.mDataRoaming + " iconBitmap=" + this.mIconBitmap + " mcc " + this.mMcc + " mnc " + this.mMnc + " mSubStatus=" + this.mStatus + " mNwMode=" + this.mNwMode + " mUserNwMode=" + this.mUserNwMode + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
        parcel.writeString(this.mIccId);
        parcel.writeInt(this.mSimSlotIndex);
        parcel.writeCharSequence(this.mDisplayName);
        parcel.writeCharSequence(this.mCarrierName);
        parcel.writeInt(this.mNameSource);
        parcel.writeInt(this.mIconTint);
        parcel.writeString(this.mNumber);
        parcel.writeInt(this.mDataRoaming);
        parcel.writeInt(this.mMcc);
        parcel.writeInt(this.mMnc);
        parcel.writeInt(this.mStatus);
        parcel.writeInt(this.mNwMode);
        parcel.writeInt(this.mUserNwMode);
        parcel.writeString(this.mCountryIso);
        this.mIconBitmap.writeToParcel(parcel, i);
    }
}
