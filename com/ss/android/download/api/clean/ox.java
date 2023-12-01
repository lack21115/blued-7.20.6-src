package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/clean/ox.class */
public class ox extends u implements Parcelable {
    public static final Parcelable.Creator<ox> CREATOR = new Parcelable.Creator<ox>() { // from class: com.ss.android.download.api.clean.ox.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: mb */
        public ox createFromParcel(Parcel parcel) {
            return new ox(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mb */
        public ox[] newArray(int i) {
            return new ox[i];
        }
    };
    List<u> mb;

    public ox() {
        this.mb = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ox(Parcel parcel) {
        super(parcel);
        this.mb = new ArrayList();
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            this.mb.add((u) parcel.readParcelable(u.class.getClassLoader()));
            i = i2 + 1;
        }
    }

    @Override // com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        if (this.mb == null) {
            this.mb = new ArrayList();
        }
        parcel.writeInt(this.mb.size());
        for (u uVar : this.mb) {
            parcel.writeParcelable(uVar, 0);
        }
    }
}
