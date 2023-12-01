package com.alibaba.mtl.appmonitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import java.util.UUID;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/Transaction.class */
public class Transaction implements Parcelable {
    public static final Parcelable.Creator<Transaction> CREATOR = new Parcelable.Creator<Transaction>() { // from class: com.alibaba.mtl.appmonitor.Transaction.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Transaction[] newArray(int i) {
            return new Transaction[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Transaction createFromParcel(Parcel parcel) {
            return Transaction.a(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected Integer f4451a;
    protected DimensionValueSet b;
    private Object lock;
    protected String o;
    protected String p;
    protected String r;

    public Transaction() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Transaction(Integer num, String str, String str2, DimensionValueSet dimensionValueSet) {
        this.f4451a = num;
        this.o = str;
        this.p = str2;
        this.r = UUID.randomUUID().toString();
        this.b = dimensionValueSet;
        this.lock = new Object();
    }

    static Transaction a(Parcel parcel) {
        Transaction transaction = new Transaction();
        try {
            transaction.b = (DimensionValueSet) parcel.readParcelable(Transaction.class.getClassLoader());
            transaction.f4451a = Integer.valueOf(parcel.readInt());
            transaction.o = parcel.readString();
            transaction.p = parcel.readString();
            transaction.r = parcel.readString();
            return transaction;
        } catch (Throwable th) {
            th.printStackTrace();
            return transaction;
        }
    }

    public void addDimensionValues(DimensionValueSet dimensionValueSet) {
        synchronized (this.lock) {
            if (this.b == null) {
                this.b = dimensionValueSet;
            } else {
                this.b.addValues(dimensionValueSet);
            }
        }
    }

    public void addDimensionValues(String str, String str2) {
        synchronized (this.lock) {
            if (this.b == null) {
                this.b = (DimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(DimensionValueSet.class, new Object[0]);
            }
            this.b.setValue(str, str2);
        }
    }

    public void begin(String str) {
        if (AppMonitor.f4a == null) {
            return;
        }
        try {
            AppMonitor.f4a.transaction_begin(this, str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void end(String str) {
        if (AppMonitor.f4a == null) {
            return;
        }
        try {
            AppMonitor.f4a.transaction_end(this, str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
        parcel.writeInt(this.f4451a.intValue());
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.r);
    }
}
