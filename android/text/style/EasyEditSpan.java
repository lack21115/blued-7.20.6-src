package android.text.style;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.ParcelableSpan;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/EasyEditSpan.class */
public class EasyEditSpan implements ParcelableSpan {
    public static final String EXTRA_TEXT_CHANGED_TYPE = "android.text.style.EXTRA_TEXT_CHANGED_TYPE";
    public static final int TEXT_DELETED = 1;
    public static final int TEXT_MODIFIED = 2;
    private boolean mDeleteEnabled;
    private final PendingIntent mPendingIntent;

    public EasyEditSpan() {
        this.mPendingIntent = null;
        this.mDeleteEnabled = true;
    }

    public EasyEditSpan(PendingIntent pendingIntent) {
        this.mPendingIntent = pendingIntent;
        this.mDeleteEnabled = true;
    }

    public EasyEditSpan(Parcel parcel) {
        this.mPendingIntent = (PendingIntent) parcel.readParcelable(null);
        this.mDeleteEnabled = parcel.readByte() == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 22;
    }

    public boolean isDeleteEnabled() {
        return this.mDeleteEnabled;
    }

    public void setDeleteEnabled(boolean z) {
        this.mDeleteEnabled = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeParcelable(this.mPendingIntent, 0);
        if (this.mDeleteEnabled) {
            i2 = 1;
        }
        parcel.writeByte((byte) i2);
    }
}
