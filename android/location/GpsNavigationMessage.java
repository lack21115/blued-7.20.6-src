package android.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.security.InvalidParameterException;

/* loaded from: source-9557208-dex2jar.jar:android/location/GpsNavigationMessage.class */
public class GpsNavigationMessage implements Parcelable {
    private static final String TAG = "GpsNavigationMessage";
    public static final byte TYPE_CNAV2 = 4;
    public static final byte TYPE_L1CA = 1;
    public static final byte TYPE_L2CNAV = 2;
    public static final byte TYPE_L5CNAV = 3;
    public static final byte TYPE_UNKNOWN = 0;
    private byte[] mData;
    private short mMessageId;
    private byte mPrn;
    private short mSubmessageId;
    private byte mType;
    private static final byte[] EMPTY_ARRAY = new byte[0];
    public static final Parcelable.Creator<GpsNavigationMessage> CREATOR = new Parcelable.Creator<GpsNavigationMessage>() { // from class: android.location.GpsNavigationMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GpsNavigationMessage createFromParcel(Parcel parcel) {
            GpsNavigationMessage gpsNavigationMessage = new GpsNavigationMessage();
            gpsNavigationMessage.setType(parcel.readByte());
            gpsNavigationMessage.setPrn(parcel.readByte());
            gpsNavigationMessage.setMessageId((short) parcel.readInt());
            gpsNavigationMessage.setSubmessageId((short) parcel.readInt());
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            gpsNavigationMessage.setData(bArr);
            return gpsNavigationMessage;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GpsNavigationMessage[] newArray(int i) {
            return new GpsNavigationMessage[i];
        }
    };

    GpsNavigationMessage() {
        initialize();
    }

    private String getTypeString() {
        switch (this.mType) {
            case 0:
                return "Unknown";
            case 1:
                return "L1 C/A";
            case 2:
                return "L2-CNAV";
            case 3:
                return "L5-CNAV";
            case 4:
                return "CNAV-2";
            default:
                return "<Invalid>";
        }
    }

    private void initialize() {
        this.mType = (byte) 0;
        this.mPrn = (byte) 0;
        this.mMessageId = (short) -1;
        this.mSubmessageId = (short) -1;
        this.mData = EMPTY_ARRAY;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.mData;
    }

    public short getMessageId() {
        return this.mMessageId;
    }

    public byte getPrn() {
        return this.mPrn;
    }

    public short getSubmessageId() {
        return this.mSubmessageId;
    }

    public byte getType() {
        return this.mType;
    }

    public void reset() {
        initialize();
    }

    public void set(GpsNavigationMessage gpsNavigationMessage) {
        this.mType = gpsNavigationMessage.mType;
        this.mPrn = gpsNavigationMessage.mPrn;
        this.mMessageId = gpsNavigationMessage.mMessageId;
        this.mSubmessageId = gpsNavigationMessage.mSubmessageId;
        this.mData = gpsNavigationMessage.mData;
    }

    public void setData(byte[] bArr) {
        if (bArr == null) {
            throw new InvalidParameterException("Data must be a non-null array");
        }
        this.mData = bArr;
    }

    public void setMessageId(short s) {
        this.mMessageId = s;
    }

    public void setPrn(byte b) {
        this.mPrn = b;
    }

    public void setSubmessageId(short s) {
        this.mSubmessageId = s;
    }

    public void setType(byte b) {
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                this.mType = b;
                return;
            default:
                Log.d(TAG, "Sanitizing invalid 'type': " + ((int) b));
                this.mType = (byte) 0;
                return;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GpsNavigationMessage:\n");
        sb.append(String.format("   %-15s = %s\n", "Type", getTypeString()));
        sb.append(String.format("   %-15s = %s\n", "Prn", Byte.valueOf(this.mPrn)));
        sb.append(String.format("   %-15s = %s\n", "MessageId", Short.valueOf(this.mMessageId)));
        sb.append(String.format("   %-15s = %s\n", "SubmessageId", Short.valueOf(this.mSubmessageId)));
        sb.append(String.format("   %-15s = %s\n", "Data", "{"));
        String str = "        ";
        byte[] bArr = this.mData;
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append(" }");
                return sb.toString();
            }
            byte b = bArr[i2];
            sb.append(str);
            sb.append((int) b);
            str = ", ";
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mType);
        parcel.writeByte(this.mPrn);
        parcel.writeInt(this.mMessageId);
        parcel.writeInt(this.mSubmessageId);
        parcel.writeInt(this.mData.length);
        parcel.writeByteArray(this.mData);
    }
}
