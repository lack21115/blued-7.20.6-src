package com.android.internal.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/net/VpnProfile.class */
public class VpnProfile implements Cloneable, Parcelable {
    public static final Parcelable.Creator<VpnProfile> CREATOR = new Parcelable.Creator<VpnProfile>() { // from class: com.android.internal.net.VpnProfile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VpnProfile createFromParcel(Parcel parcel) {
            return new VpnProfile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VpnProfile[] newArray(int i) {
            return new VpnProfile[i];
        }
    };
    private static final String TAG = "VpnProfile";
    public static final int TYPE_IPSEC_HYBRID_RSA = 5;
    public static final int TYPE_IPSEC_XAUTH_PSK = 3;
    public static final int TYPE_IPSEC_XAUTH_RSA = 4;
    public static final int TYPE_L2TP_IPSEC_PSK = 1;
    public static final int TYPE_L2TP_IPSEC_RSA = 2;
    public static final int TYPE_MAX = 5;
    public static final int TYPE_PPTP = 0;
    public String dnsServers;
    public String ipsecCaCert;
    public String ipsecIdentifier;
    public String ipsecSecret;
    public String ipsecServerCert;
    public String ipsecUserCert;
    public final String key;
    public String l2tpSecret;
    public boolean mppe;
    public String name;
    public String password;
    public String routes;
    public boolean saveLogin;
    public String searchDomains;
    public String server;
    public int type;
    public String username;

    public VpnProfile(Parcel parcel) {
        this.name = "";
        this.type = 0;
        this.server = "";
        this.username = "";
        this.password = "";
        this.dnsServers = "";
        this.searchDomains = "";
        this.routes = "";
        this.mppe = true;
        this.l2tpSecret = "";
        this.ipsecIdentifier = "";
        this.ipsecSecret = "";
        this.ipsecUserCert = "";
        this.ipsecCaCert = "";
        this.ipsecServerCert = "";
        this.saveLogin = false;
        this.key = parcel.readString();
        this.name = parcel.readString();
        this.type = parcel.readInt();
        this.server = parcel.readString();
        this.username = parcel.readString();
        this.password = parcel.readString();
        this.dnsServers = parcel.readString();
        this.searchDomains = parcel.readString();
        this.routes = parcel.readString();
        this.mppe = parcel.readInt() != 0;
        this.l2tpSecret = parcel.readString();
        this.ipsecIdentifier = parcel.readString();
        this.ipsecSecret = parcel.readString();
        this.ipsecUserCert = parcel.readString();
        this.ipsecCaCert = parcel.readString();
        this.ipsecServerCert = parcel.readString();
        this.saveLogin = parcel.readInt() != 0;
    }

    public VpnProfile(String str) {
        this.name = "";
        this.type = 0;
        this.server = "";
        this.username = "";
        this.password = "";
        this.dnsServers = "";
        this.searchDomains = "";
        this.routes = "";
        this.mppe = true;
        this.l2tpSecret = "";
        this.ipsecIdentifier = "";
        this.ipsecSecret = "";
        this.ipsecUserCert = "";
        this.ipsecCaCert = "";
        this.ipsecServerCert = "";
        this.saveLogin = false;
        this.key = str;
    }

    public static VpnProfile decode(String str, byte[] bArr) {
        boolean z = false;
        if (str == null) {
            return null;
        }
        try {
            String[] split = new String(bArr, StandardCharsets.UTF_8).split("��", -1);
            if (split.length >= 14 && split.length <= 15) {
                VpnProfile vpnProfile = new VpnProfile(str);
                vpnProfile.name = split[0];
                vpnProfile.type = Integer.valueOf(split[1]).intValue();
                if (vpnProfile.type >= 0 && vpnProfile.type <= 5) {
                    vpnProfile.server = split[2];
                    vpnProfile.username = split[3];
                    vpnProfile.password = split[4];
                    vpnProfile.dnsServers = split[5];
                    vpnProfile.searchDomains = split[6];
                    vpnProfile.routes = split[7];
                    vpnProfile.mppe = Boolean.valueOf(split[8]).booleanValue();
                    vpnProfile.l2tpSecret = split[9];
                    vpnProfile.ipsecIdentifier = split[10];
                    vpnProfile.ipsecSecret = split[11];
                    vpnProfile.ipsecUserCert = split[12];
                    vpnProfile.ipsecCaCert = split[13];
                    vpnProfile.ipsecServerCert = split.length > 14 ? split[14] : "";
                    if (vpnProfile.username.isEmpty()) {
                        if (!vpnProfile.password.isEmpty()) {
                        }
                        vpnProfile.saveLogin = z;
                        return vpnProfile;
                    }
                    z = true;
                    vpnProfile.saveLogin = z;
                    return vpnProfile;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] encode() {
        StringBuilder sb = new StringBuilder(this.name);
        sb.append((char) 0).append(this.type);
        sb.append((char) 0).append(this.server);
        sb.append((char) 0).append(this.saveLogin ? this.username : "");
        sb.append((char) 0).append(this.saveLogin ? this.password : "");
        sb.append((char) 0).append(this.dnsServers);
        sb.append((char) 0).append(this.searchDomains);
        sb.append((char) 0).append(this.routes);
        sb.append((char) 0).append(this.mppe);
        sb.append((char) 0).append(this.l2tpSecret);
        sb.append((char) 0).append(this.ipsecIdentifier);
        sb.append((char) 0).append(this.ipsecSecret);
        sb.append((char) 0).append(this.ipsecUserCert);
        sb.append((char) 0).append(this.ipsecCaCert);
        sb.append((char) 0).append(this.ipsecServerCert);
        return sb.toString().getBytes(StandardCharsets.UTF_8);
    }

    public boolean isValidLockdownProfile() {
        try {
            InetAddress.parseNumericAddress(this.server);
            String[] split = this.dnsServers.split(" +");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = split[i2];
                InetAddress.parseNumericAddress(this.dnsServers);
                i = i2 + 1;
            }
            if (TextUtils.isEmpty(this.dnsServers)) {
                Log.w(TAG, "DNS required");
                return false;
            }
            return true;
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "Invalid address", e);
            return false;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.name);
        parcel.writeInt(this.type);
        parcel.writeString(this.server);
        parcel.writeString(this.username);
        parcel.writeString(this.password);
        parcel.writeString(this.dnsServers);
        parcel.writeString(this.searchDomains);
        parcel.writeString(this.routes);
        parcel.writeInt(this.mppe ? 1 : 0);
        parcel.writeString(this.l2tpSecret);
        parcel.writeString(this.ipsecIdentifier);
        parcel.writeString(this.ipsecSecret);
        parcel.writeString(this.ipsecUserCert);
        parcel.writeString(this.ipsecCaCert);
        parcel.writeString(this.ipsecServerCert);
        parcel.writeInt(this.saveLogin ? 1 : 0);
    }
}
