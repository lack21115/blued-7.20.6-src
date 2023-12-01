package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Locale;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/net/ProxyInfo.class */
public class ProxyInfo implements Parcelable {
    public static final Parcelable.Creator<ProxyInfo> CREATOR = new Parcelable.Creator<ProxyInfo>() { // from class: android.net.ProxyInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProxyInfo createFromParcel(Parcel parcel) {
            String str = null;
            int i = 0;
            if (parcel.readByte() != 0) {
                return new ProxyInfo(Uri.CREATOR.createFromParcel(parcel), parcel.readInt());
            }
            if (parcel.readByte() != 0) {
                str = parcel.readString();
                i = parcel.readInt();
            }
            return new ProxyInfo(str, i, parcel.readString(), parcel.readStringArray());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProxyInfo[] newArray(int i) {
            return new ProxyInfo[i];
        }
    };
    public static final String LOCAL_EXCL_LIST = "";
    public static final String LOCAL_HOST = "localhost";
    public static final int LOCAL_PORT = -1;
    private String mExclusionList;
    private String mHost;
    private Uri mPacFileUrl;
    private String[] mParsedExclusionList;
    private int mPort;

    public ProxyInfo(ProxyInfo proxyInfo) {
        if (proxyInfo == null) {
            this.mPacFileUrl = Uri.EMPTY;
            return;
        }
        this.mHost = proxyInfo.getHost();
        this.mPort = proxyInfo.getPort();
        this.mPacFileUrl = proxyInfo.mPacFileUrl;
        this.mExclusionList = proxyInfo.getExclusionListAsString();
        this.mParsedExclusionList = proxyInfo.mParsedExclusionList;
    }

    public ProxyInfo(Uri uri) {
        this.mHost = LOCAL_HOST;
        this.mPort = -1;
        setExclusionList("");
        if (uri == null) {
            throw new NullPointerException();
        }
        this.mPacFileUrl = uri;
    }

    public ProxyInfo(Uri uri, int i) {
        this.mHost = LOCAL_HOST;
        this.mPort = i;
        setExclusionList("");
        if (uri == null) {
            throw new NullPointerException();
        }
        this.mPacFileUrl = uri;
    }

    public ProxyInfo(String str) {
        this.mHost = LOCAL_HOST;
        this.mPort = -1;
        setExclusionList("");
        this.mPacFileUrl = Uri.parse(str);
    }

    public ProxyInfo(String str, int i, String str2) {
        this.mHost = str;
        this.mPort = i;
        setExclusionList(str2);
        this.mPacFileUrl = Uri.EMPTY;
    }

    private ProxyInfo(String str, int i, String str2, String[] strArr) {
        this.mHost = str;
        this.mPort = i;
        this.mExclusionList = str2;
        this.mParsedExclusionList = strArr;
        this.mPacFileUrl = Uri.EMPTY;
    }

    public static ProxyInfo buildDirectProxy(String str, int i) {
        return new ProxyInfo(str, i, null);
    }

    public static ProxyInfo buildDirectProxy(String str, int i, List<String> list) {
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        return new ProxyInfo(str, i, TextUtils.join(",", strArr), strArr);
    }

    public static ProxyInfo buildPacProxy(Uri uri) {
        return new ProxyInfo(uri);
    }

    private void setExclusionList(String str) {
        this.mExclusionList = str;
        if (this.mExclusionList == null) {
            this.mParsedExclusionList = new String[0];
        } else {
            this.mParsedExclusionList = str.toLowerCase(Locale.ROOT).split(",");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj instanceof ProxyInfo) {
            ProxyInfo proxyInfo = (ProxyInfo) obj;
            if (!Uri.EMPTY.equals(this.mPacFileUrl)) {
                if (!this.mPacFileUrl.equals(proxyInfo.getPacFileUrl()) || this.mPort != proxyInfo.mPort) {
                    z = false;
                }
                return z;
            } else if (Uri.EMPTY.equals(proxyInfo.mPacFileUrl)) {
                if (this.mExclusionList == null || this.mExclusionList.equals(proxyInfo.getExclusionListAsString())) {
                    if (this.mHost == null || proxyInfo.getHost() == null || this.mHost.equals(proxyInfo.getHost())) {
                        if (this.mHost == null || proxyInfo.mHost != null) {
                            return (this.mHost != null || proxyInfo.mHost == null) && this.mPort == proxyInfo.mPort;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            } else {
                return false;
            }
        }
        return false;
    }

    public String[] getExclusionList() {
        return this.mParsedExclusionList;
    }

    public String getExclusionListAsString() {
        return this.mExclusionList;
    }

    public String getHost() {
        return this.mHost;
    }

    public Uri getPacFileUrl() {
        return this.mPacFileUrl;
    }

    public int getPort() {
        return this.mPort;
    }

    public InetSocketAddress getSocketAddress() {
        try {
            return new InetSocketAddress(this.mHost, this.mPort);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.mHost == null ? 0 : this.mHost.hashCode();
        if (this.mExclusionList != null) {
            i = this.mExclusionList.hashCode();
        }
        return hashCode + i + this.mPort;
    }

    public boolean isValid() {
        if (Uri.EMPTY.equals(this.mPacFileUrl)) {
            return Proxy.validate(this.mHost == null ? "" : this.mHost, this.mPort == 0 ? "" : Integer.toString(this.mPort), this.mExclusionList == null ? "" : this.mExclusionList) == 0;
        }
        return true;
    }

    public java.net.Proxy makeProxy() {
        java.net.Proxy proxy = java.net.Proxy.NO_PROXY;
        java.net.Proxy proxy2 = proxy;
        if (this.mHost != null) {
            try {
                proxy2 = new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.mHost, this.mPort));
            } catch (IllegalArgumentException e) {
                return proxy;
            }
        }
        return proxy2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!Uri.EMPTY.equals(this.mPacFileUrl)) {
            sb.append("PAC Script: ");
            sb.append(this.mPacFileUrl);
        }
        if (this.mHost != null) {
            sb.append("[");
            sb.append(this.mHost);
            sb.append("] ");
            sb.append(Integer.toString(this.mPort));
            if (this.mExclusionList != null) {
                sb.append(" xl=").append(this.mExclusionList);
            }
        } else {
            sb.append("[ProxyProperties.mHost == null]");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (!Uri.EMPTY.equals(this.mPacFileUrl)) {
            parcel.writeByte((byte) 1);
            this.mPacFileUrl.writeToParcel(parcel, 0);
            parcel.writeInt(this.mPort);
            return;
        }
        parcel.writeByte((byte) 0);
        if (this.mHost != null) {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.mHost);
            parcel.writeInt(this.mPort);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeString(this.mExclusionList);
        parcel.writeStringArray(this.mParsedExclusionList);
    }
}
