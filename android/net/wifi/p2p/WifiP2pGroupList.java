package android.net.wifi.p2p;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.LruCache;
import java.util.Collection;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pGroupList.class */
public class WifiP2pGroupList implements Parcelable {
    public static final Parcelable.Creator<WifiP2pGroupList> CREATOR = new Parcelable.Creator<WifiP2pGroupList>() { // from class: android.net.wifi.p2p.WifiP2pGroupList.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pGroupList createFromParcel(Parcel parcel) {
            WifiP2pGroupList wifiP2pGroupList = new WifiP2pGroupList();
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return wifiP2pGroupList;
                }
                wifiP2pGroupList.add((WifiP2pGroup) parcel.readParcelable(null));
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pGroupList[] newArray(int i) {
            return new WifiP2pGroupList[i];
        }
    };
    private static final int CREDENTIAL_MAX_NUM = 32;
    private boolean isClearCalled;
    private final LruCache<Integer, WifiP2pGroup> mGroups;
    private final GroupDeleteListener mListener;

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pGroupList$GroupDeleteListener.class */
    public interface GroupDeleteListener {
        void onDeleteGroup(int i);
    }

    public WifiP2pGroupList() {
        this(null, null);
    }

    public WifiP2pGroupList(WifiP2pGroupList wifiP2pGroupList, GroupDeleteListener groupDeleteListener) {
        this.isClearCalled = false;
        this.mListener = groupDeleteListener;
        this.mGroups = new LruCache<Integer, WifiP2pGroup>(32) { // from class: android.net.wifi.p2p.WifiP2pGroupList.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public void entryRemoved(boolean z, Integer num, WifiP2pGroup wifiP2pGroup, WifiP2pGroup wifiP2pGroup2) {
                if (WifiP2pGroupList.this.mListener == null || WifiP2pGroupList.this.isClearCalled) {
                    return;
                }
                WifiP2pGroupList.this.mListener.onDeleteGroup(wifiP2pGroup.getNetworkId());
            }
        };
        if (wifiP2pGroupList != null) {
            for (Map.Entry<Integer, WifiP2pGroup> entry : wifiP2pGroupList.mGroups.snapshot().entrySet()) {
                this.mGroups.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void add(WifiP2pGroup wifiP2pGroup) {
        this.mGroups.put(Integer.valueOf(wifiP2pGroup.getNetworkId()), wifiP2pGroup);
    }

    public boolean clear() {
        if (this.mGroups.size() == 0) {
            return false;
        }
        this.isClearCalled = true;
        this.mGroups.evictAll();
        this.isClearCalled = false;
        return true;
    }

    public boolean contains(int i) {
        for (WifiP2pGroup wifiP2pGroup : this.mGroups.snapshot().values()) {
            if (i == wifiP2pGroup.getNetworkId()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Collection<WifiP2pGroup> getGroupList() {
        return this.mGroups.snapshot().values();
    }

    public int getNetworkId(String str) {
        if (str == null) {
            return -1;
        }
        for (WifiP2pGroup wifiP2pGroup : this.mGroups.snapshot().values()) {
            if (str.equalsIgnoreCase(wifiP2pGroup.getOwner().deviceAddress)) {
                this.mGroups.get(Integer.valueOf(wifiP2pGroup.getNetworkId()));
                return wifiP2pGroup.getNetworkId();
            }
        }
        return -1;
    }

    public int getNetworkId(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        for (WifiP2pGroup wifiP2pGroup : this.mGroups.snapshot().values()) {
            if (str.equalsIgnoreCase(wifiP2pGroup.getOwner().deviceAddress) && str2.equals(wifiP2pGroup.getNetworkName())) {
                this.mGroups.get(Integer.valueOf(wifiP2pGroup.getNetworkId()));
                return wifiP2pGroup.getNetworkId();
            }
        }
        return -1;
    }

    public String getOwnerAddr(int i) {
        WifiP2pGroup wifiP2pGroup = this.mGroups.get(Integer.valueOf(i));
        if (wifiP2pGroup != null) {
            return wifiP2pGroup.getOwner().deviceAddress;
        }
        return null;
    }

    public void remove(int i) {
        this.mGroups.remove(Integer.valueOf(i));
    }

    void remove(String str) {
        remove(getNetworkId(str));
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (WifiP2pGroup wifiP2pGroup : this.mGroups.snapshot().values()) {
            stringBuffer.append(wifiP2pGroup).append("\n");
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Collection<WifiP2pGroup> values = this.mGroups.snapshot().values();
        parcel.writeInt(values.size());
        for (WifiP2pGroup wifiP2pGroup : values) {
            parcel.writeParcelable(wifiP2pGroup, i);
        }
    }
}
