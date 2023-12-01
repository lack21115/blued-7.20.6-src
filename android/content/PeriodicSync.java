package android.content;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/content/PeriodicSync.class */
public class PeriodicSync implements Parcelable {
    public static final Parcelable.Creator<PeriodicSync> CREATOR = new Parcelable.Creator<PeriodicSync>() { // from class: android.content.PeriodicSync.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeriodicSync createFromParcel(Parcel parcel) {
            return new PeriodicSync(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeriodicSync[] newArray(int i) {
            return new PeriodicSync[i];
        }
    };
    public final Account account;
    public final String authority;
    public final Bundle extras;
    public final long flexTime;
    public final long period;

    public PeriodicSync(Account account, String str, Bundle bundle, long j) {
        this.account = account;
        this.authority = str;
        if (bundle == null) {
            this.extras = new Bundle();
        } else {
            this.extras = new Bundle(bundle);
        }
        this.period = j;
        this.flexTime = 0L;
    }

    public PeriodicSync(Account account, String str, Bundle bundle, long j, long j2) {
        this.account = account;
        this.authority = str;
        this.extras = new Bundle(bundle);
        this.period = j;
        this.flexTime = j2;
    }

    public PeriodicSync(PeriodicSync periodicSync) {
        this.account = periodicSync.account;
        this.authority = periodicSync.authority;
        this.extras = new Bundle(periodicSync.extras);
        this.period = periodicSync.period;
        this.flexTime = periodicSync.flexTime;
    }

    private PeriodicSync(Parcel parcel) {
        this.account = (Account) parcel.readParcelable(null);
        this.authority = parcel.readString();
        this.extras = parcel.readBundle();
        this.period = parcel.readLong();
        this.flexTime = parcel.readLong();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean syncExtrasEquals(android.os.Bundle r4, android.os.Bundle r5) {
        /*
            r0 = r4
            int r0 = r0.size()
            r1 = r5
            int r1 = r1.size()
            if (r0 == r1) goto Ld
        Lb:
            r0 = 0
            return r0
        Ld:
            r0 = r4
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L16
            r0 = 1
            return r0
        L16:
            r0 = r4
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
            r6 = r0
        L20:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L4d
            r0 = r6
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            r7 = r0
            r0 = r5
            r1 = r7
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto Lb
            r0 = r4
            r1 = r7
            java.lang.Object r0 = r0.get(r1)
            r1 = r5
            r2 = r7
            java.lang.Object r1 = r1.get(r2)
            boolean r0 = java.util.Objects.equals(r0, r1)
            if (r0 != 0) goto L20
            r0 = 0
            return r0
        L4d:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.PeriodicSync.syncExtrasEquals(android.os.Bundle, android.os.Bundle):boolean");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PeriodicSync) {
            PeriodicSync periodicSync = (PeriodicSync) obj;
            return this.account.equals(periodicSync.account) && this.authority.equals(periodicSync.authority) && this.period == periodicSync.period && syncExtrasEquals(this.extras, periodicSync.extras);
        }
        return false;
    }

    public String toString() {
        return "account: " + this.account + ", authority: " + this.authority + ". period: " + this.period + "s , flex: " + this.flexTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.account, i);
        parcel.writeString(this.authority);
        parcel.writeBundle(this.extras);
        parcel.writeLong(this.period);
        parcel.writeLong(this.flexTime);
    }
}
