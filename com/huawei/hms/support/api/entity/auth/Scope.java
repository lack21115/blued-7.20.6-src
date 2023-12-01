package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.core.aidl.IMessageEntity;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/entity/auth/Scope.class */
public class Scope implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<Scope> CREATOR = new a();
    private String mScopeUri;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/entity/auth/Scope$a.class */
    static final class a implements Parcelable.Creator<Scope> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Scope createFromParcel(Parcel parcel) {
            return new Scope(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Scope[] newArray(int i) {
            return new Scope[i];
        }
    }

    public Scope() {
        this.mScopeUri = null;
    }

    protected Scope(Parcel parcel) {
        this.mScopeUri = parcel.readString();
    }

    public Scope(String str) {
        this.mScopeUri = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return Objects.equal(this.mScopeUri, ((Scope) obj).mScopeUri);
        }
        return false;
    }

    @Deprecated
    public boolean equeals(Object obj) {
        return equals(obj);
    }

    public String getScopeUri() {
        return this.mScopeUri;
    }

    public final int hashCode() {
        String str = this.mScopeUri;
        return str == null ? super.hashCode() : str.hashCode();
    }

    public final String toString() {
        return this.mScopeUri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mScopeUri);
    }
}
