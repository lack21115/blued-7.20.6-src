package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/ActivityResult.class */
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() { // from class: androidx.activity.result.ActivityResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityResult[] newArray(int i) {
            return new ActivityResult[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f1457a;
    private final Intent b;

    public ActivityResult(int i, Intent intent) {
        this.f1457a = i;
        this.b = intent;
    }

    ActivityResult(Parcel parcel) {
        this.f1457a = parcel.readInt();
        this.b = parcel.readInt() == 0 ? null : Intent.CREATOR.createFromParcel(parcel);
    }

    public static String resultCodeToString(int i) {
        return i != -1 ? i != 0 ? String.valueOf(i) : "RESULT_CANCELED" : "RESULT_OK";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Intent getData() {
        return this.b;
    }

    public int getResultCode() {
        return this.f1457a;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.f1457a) + ", data=" + this.b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1457a);
        parcel.writeInt(this.b == null ? 0 : 1);
        Intent intent = this.b;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }
}
