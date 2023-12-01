package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/IntentSenderRequest.class */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new Parcelable.Creator<IntentSenderRequest>() { // from class: androidx.activity.result.IntentSenderRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest[] newArray(int i) {
            return new IntentSenderRequest[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final IntentSender f1474a;
    private final Intent b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1475c;
    private final int d;

    /* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/IntentSenderRequest$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private IntentSender f1476a;
        private Intent b;

        /* renamed from: c  reason: collision with root package name */
        private int f1477c;
        private int d;

        public Builder(PendingIntent pendingIntent) {
            this(pendingIntent.getIntentSender());
        }

        public Builder(IntentSender intentSender) {
            this.f1476a = intentSender;
        }

        public IntentSenderRequest build() {
            return new IntentSenderRequest(this.f1476a, this.b, this.f1477c, this.d);
        }

        public Builder setFillInIntent(Intent intent) {
            this.b = intent;
            return this;
        }

        public Builder setFlags(int i, int i2) {
            this.d = i;
            this.f1477c = i2;
            return this;
        }
    }

    IntentSenderRequest(IntentSender intentSender, Intent intent, int i, int i2) {
        this.f1474a = intentSender;
        this.b = intent;
        this.f1475c = i;
        this.d = i2;
    }

    IntentSenderRequest(Parcel parcel) {
        this.f1474a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f1475c = parcel.readInt();
        this.d = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Intent getFillInIntent() {
        return this.b;
    }

    public int getFlagsMask() {
        return this.f1475c;
    }

    public int getFlagsValues() {
        return this.d;
    }

    public IntentSender getIntentSender() {
        return this.f1474a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1474a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeInt(this.f1475c);
        parcel.writeInt(this.d);
    }
}
