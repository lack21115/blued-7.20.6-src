package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiEapSimInfo.class */
public class WifiEapSimInfo implements Parcelable {
    private static final boolean DBG = false;
    public static final int MAX_NUM_OF_SIMS_SUPPORTED = 4;
    private static final String NUM_OF_SIMS_STR = "no_of_sims=";
    public static final int SIM_2G = 1;
    public static final int SIM_3G = 3;
    private static final String SIM_FOUR_TYPE_STR = "sim4=";
    private static final String SIM_ONE_TYPE_STR = "sim1=";
    private static final String SIM_THREE_TYPE_STR = "sim3=";
    private static final String SIM_TWO_TYPE_STR = "sim2=";
    public static final int SIM_UNSUPPORTED = 0;
    private static final String TAG = "WifiEapSimInfo";
    public int mNumOfSims;
    public ArrayList<Integer> mSimTypes;
    public static final String[] m2GSupportedTypes = {"SIM"};
    public static final String[] m3GSupportedTypes = {"SIM", "AKA"};
    public static final Parcelable.Creator<WifiEapSimInfo> CREATOR = new Parcelable.Creator<WifiEapSimInfo>() { // from class: android.net.wifi.WifiEapSimInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiEapSimInfo createFromParcel(Parcel parcel) {
            WifiEapSimInfo wifiEapSimInfo = new WifiEapSimInfo();
            wifiEapSimInfo.mNumOfSims = parcel.readInt();
            int readInt = parcel.readInt();
            while (true) {
                int i = readInt;
                if (i <= 0) {
                    return wifiEapSimInfo;
                }
                wifiEapSimInfo.mSimTypes.add(new Integer(parcel.readInt()));
                readInt = i - 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiEapSimInfo[] newArray(int i) {
            return new WifiEapSimInfo[i];
        }
    };

    public WifiEapSimInfo() {
        this.mSimTypes = new ArrayList<>();
    }

    public WifiEapSimInfo(WifiEapSimInfo wifiEapSimInfo) {
        this.mSimTypes = new ArrayList<>();
        if (wifiEapSimInfo != null) {
            this.mNumOfSims = wifiEapSimInfo.mNumOfSims;
            this.mSimTypes = wifiEapSimInfo.mSimTypes;
        }
    }

    public WifiEapSimInfo(String str) throws IllegalArgumentException {
        int i;
        int i2;
        int i3;
        int i4;
        this.mSimTypes = new ArrayList<>();
        String[] split = str.split(" ");
        if (split.length < 1 || split.length > 4) {
            throw new IllegalArgumentException();
        }
        int length = split.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length) {
                return;
            }
            String str2 = split[i6];
            if (str2.startsWith(NUM_OF_SIMS_STR)) {
                try {
                    this.mNumOfSims = Integer.parseInt(str2.substring(NUM_OF_SIMS_STR.length()));
                } catch (NumberFormatException e) {
                    this.mNumOfSims = 0;
                }
            } else if (str2.startsWith(SIM_ONE_TYPE_STR)) {
                try {
                    i = Integer.parseInt(str2.substring(SIM_ONE_TYPE_STR.length()));
                } catch (NumberFormatException e2) {
                    i = 0;
                }
                this.mSimTypes.add(Integer.valueOf(i));
            } else if (str2.startsWith(SIM_TWO_TYPE_STR)) {
                try {
                    i2 = Integer.parseInt(str2.substring(SIM_TWO_TYPE_STR.length()));
                } catch (NumberFormatException e3) {
                    i2 = 0;
                }
                this.mSimTypes.add(Integer.valueOf(i2));
            } else if (str2.startsWith(SIM_THREE_TYPE_STR)) {
                try {
                    i3 = Integer.parseInt(str2.substring(SIM_THREE_TYPE_STR.length()));
                } catch (NumberFormatException e4) {
                    i3 = 0;
                }
                this.mSimTypes.add(Integer.valueOf(i3));
            } else if (!str2.startsWith(SIM_FOUR_TYPE_STR)) {
                throw new IllegalArgumentException();
            } else {
                try {
                    i4 = Integer.parseInt(str2.substring(SIM_FOUR_TYPE_STR.length()));
                } catch (NumberFormatException e5) {
                    i4 = 0;
                }
                this.mSimTypes.add(Integer.valueOf(i4));
            }
            i5 = i6 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mNumOfSims);
        parcel.writeInt(this.mSimTypes.size());
        Iterator<Integer> it = this.mSimTypes.iterator();
        while (it.hasNext()) {
            parcel.writeInt(it.next().intValue());
        }
    }
}
