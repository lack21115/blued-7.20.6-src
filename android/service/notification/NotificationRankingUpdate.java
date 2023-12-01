package android.service.notification;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/service/notification/NotificationRankingUpdate.class */
public class NotificationRankingUpdate implements Parcelable {
    public static final Parcelable.Creator<NotificationRankingUpdate> CREATOR = new Parcelable.Creator<NotificationRankingUpdate>() { // from class: android.service.notification.NotificationRankingUpdate.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationRankingUpdate createFromParcel(Parcel parcel) {
            return new NotificationRankingUpdate(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationRankingUpdate[] newArray(int i) {
            return new NotificationRankingUpdate[i];
        }
    };
    private final int mFirstAmbientIndex;
    private final String[] mInterceptedKeys;
    private final String[] mKeys;
    private final Bundle mVisibilityOverrides;

    public NotificationRankingUpdate(Parcel parcel) {
        this.mKeys = parcel.readStringArray();
        this.mFirstAmbientIndex = parcel.readInt();
        this.mInterceptedKeys = parcel.readStringArray();
        this.mVisibilityOverrides = parcel.readBundle();
    }

    public NotificationRankingUpdate(String[] strArr, String[] strArr2, Bundle bundle, int i) {
        this.mKeys = strArr;
        this.mFirstAmbientIndex = i;
        this.mInterceptedKeys = strArr2;
        this.mVisibilityOverrides = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFirstAmbientIndex() {
        return this.mFirstAmbientIndex;
    }

    public String[] getInterceptedKeys() {
        return this.mInterceptedKeys;
    }

    public String[] getOrderedKeys() {
        return this.mKeys;
    }

    public Bundle getVisibilityOverrides() {
        return this.mVisibilityOverrides;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(this.mKeys);
        parcel.writeInt(this.mFirstAmbientIndex);
        parcel.writeStringArray(this.mInterceptedKeys);
        parcel.writeBundle(this.mVisibilityOverrides);
    }
}
