package android.accounts;

import android.accounts.IAccountManagerResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/accounts/AccountManagerResponse.class */
public class AccountManagerResponse implements Parcelable {
    public static final Parcelable.Creator<AccountManagerResponse> CREATOR = new Parcelable.Creator<AccountManagerResponse>() { // from class: android.accounts.AccountManagerResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountManagerResponse createFromParcel(Parcel parcel) {
            return new AccountManagerResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountManagerResponse[] newArray(int i) {
            return new AccountManagerResponse[i];
        }
    };
    private IAccountManagerResponse mResponse;

    public AccountManagerResponse(IAccountManagerResponse iAccountManagerResponse) {
        this.mResponse = iAccountManagerResponse;
    }

    public AccountManagerResponse(Parcel parcel) {
        this.mResponse = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void onError(int i, String str) {
        try {
            this.mResponse.onError(i, str);
        } catch (RemoteException e) {
        }
    }

    public void onResult(Bundle bundle) {
        try {
            this.mResponse.onResult(bundle);
        } catch (RemoteException e) {
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mResponse.asBinder());
    }
}
