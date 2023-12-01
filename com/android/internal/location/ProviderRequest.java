package com.android.internal.location;

import android.location.LocationRequest;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TimeUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/location/ProviderRequest.class */
public final class ProviderRequest implements Parcelable {
    public static final Parcelable.Creator<ProviderRequest> CREATOR = new Parcelable.Creator<ProviderRequest>() { // from class: com.android.internal.location.ProviderRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProviderRequest createFromParcel(Parcel parcel) {
            boolean z = true;
            ProviderRequest providerRequest = new ProviderRequest();
            if (parcel.readInt() != 1) {
                z = false;
            }
            providerRequest.reportLocation = z;
            providerRequest.interval = parcel.readLong();
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return providerRequest;
                }
                providerRequest.locationRequests.add(LocationRequest.CREATOR.createFromParcel(parcel));
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProviderRequest[] newArray(int i) {
            return new ProviderRequest[i];
        }
    };
    public boolean reportLocation = false;
    public long interval = Long.MAX_VALUE;
    public List<LocationRequest> locationRequests = new ArrayList();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProviderRequest[");
        if (this.reportLocation) {
            sb.append("ON");
            sb.append(" interval=");
            TimeUtils.formatDuration(this.interval, sb);
        } else {
            sb.append("OFF");
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.reportLocation ? 1 : 0);
        parcel.writeLong(this.interval);
        parcel.writeInt(this.locationRequests.size());
        for (LocationRequest locationRequest : this.locationRequests) {
            locationRequest.writeToParcel(parcel, i);
        }
    }
}
