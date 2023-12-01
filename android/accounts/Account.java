package android.accounts;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.blued.das.live.LiveProtos;

/* loaded from: source-9557208-dex2jar.jar:android/accounts/Account.class */
public class Account implements Parcelable {
    public static final Parcelable.Creator<Account> CREATOR = new Parcelable.Creator<Account>() { // from class: android.accounts.Account.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Account createFromParcel(Parcel parcel) {
            return new Account(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Account[] newArray(int i) {
            return new Account[i];
        }
    };
    public final String name;
    public final String type;

    public Account(Parcel parcel) {
        this.name = parcel.readString();
        this.type = parcel.readString();
    }

    public Account(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the name must not be empty: " + str);
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("the type must not be empty: " + str2);
        }
        this.name = str;
        this.type = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Account) {
            Account account = (Account) obj;
            return this.name.equals(account.name) && this.type.equals(account.type);
        }
        return false;
    }

    public int hashCode() {
        return ((this.name.hashCode() + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "Account {name=" + this.name + ", type=" + this.type + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.type);
    }
}
