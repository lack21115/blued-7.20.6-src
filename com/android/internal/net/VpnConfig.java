package com.android.internal.net;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.IpPrefix;
import android.net.LinkAddress;
import android.net.Network;
import android.net.RouteInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;
import com.android.internal.R;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/net/VpnConfig.class */
public class VpnConfig implements Parcelable {
    public static final Parcelable.Creator<VpnConfig> CREATOR = new Parcelable.Creator<VpnConfig>() { // from class: com.android.internal.net.VpnConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VpnConfig createFromParcel(Parcel parcel) {
            VpnConfig vpnConfig = new VpnConfig();
            vpnConfig.user = parcel.readString();
            vpnConfig.interfaze = parcel.readString();
            vpnConfig.session = parcel.readString();
            vpnConfig.mtu = parcel.readInt();
            parcel.readTypedList(vpnConfig.addresses, LinkAddress.CREATOR);
            parcel.readTypedList(vpnConfig.routes, RouteInfo.CREATOR);
            vpnConfig.dnsServers = parcel.createStringArrayList();
            vpnConfig.searchDomains = parcel.createStringArrayList();
            vpnConfig.allowedApplications = parcel.createStringArrayList();
            vpnConfig.disallowedApplications = parcel.createStringArrayList();
            vpnConfig.configureIntent = (PendingIntent) parcel.readParcelable(null);
            vpnConfig.startTime = parcel.readLong();
            vpnConfig.legacy = parcel.readInt() != 0;
            vpnConfig.blocking = parcel.readInt() != 0;
            vpnConfig.allowBypass = parcel.readInt() != 0;
            vpnConfig.allowIPv4 = parcel.readInt() != 0;
            vpnConfig.allowIPv6 = parcel.readInt() != 0;
            vpnConfig.underlyingNetworks = (Network[]) parcel.createTypedArray(Network.CREATOR);
            return vpnConfig;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VpnConfig[] newArray(int i) {
            return new VpnConfig[i];
        }
    };
    public static final String DIALOGS_PACKAGE = "com.android.vpndialogs";
    public static final String LEGACY_VPN = "[Legacy VPN]";
    public static final String SERVICE_INTERFACE = "android.net.VpnService";
    public boolean allowBypass;
    public boolean allowIPv4;
    public boolean allowIPv6;
    public List<String> allowedApplications;
    public boolean blocking;
    public PendingIntent configureIntent;
    public List<String> disallowedApplications;
    public List<String> dnsServers;
    public String interfaze;
    public boolean legacy;
    public List<String> searchDomains;
    public String session;
    public Network[] underlyingNetworks;
    public String user;
    public int mtu = -1;
    public List<LinkAddress> addresses = new ArrayList();
    public List<RouteInfo> routes = new ArrayList();
    public long startTime = -1;

    public static Intent getIntentForConfirmation() {
        Intent intent = new Intent();
        ComponentName unflattenFromString = ComponentName.unflattenFromString(Resources.getSystem().getString(R.string.config_customVpnConfirmDialogComponent));
        intent.setClassName(unflattenFromString.getPackageName(), unflattenFromString.getClassName());
        return intent;
    }

    public static PendingIntent getIntentForStatusPanel(Context context) {
        Intent intent = new Intent();
        intent.setClassName(DIALOGS_PACKAGE, "com.android.vpndialogs.ManageDialog");
        intent.addFlags(1350565888);
        return PendingIntent.getActivityAsUser(context, 0, intent, 0, null, UserHandle.CURRENT);
    }

    public static CharSequence getVpnLabel(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(SERVICE_INTERFACE);
        intent.setPackage(str);
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        return (queryIntentServices == null || queryIntentServices.size() != 1) ? packageManager.getApplicationInfo(str, 0).loadLabel(packageManager) : queryIntentServices.get(0).loadLabel(packageManager);
    }

    public void addLegacyAddresses(String str) {
        if (str.trim().equals("")) {
            return;
        }
        String[] split = str.trim().split(" ");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            LinkAddress linkAddress = new LinkAddress(split[i2]);
            this.addresses.add(linkAddress);
            updateAllowedFamilies(linkAddress.getAddress());
            i = i2 + 1;
        }
    }

    public void addLegacyRoutes(String str) {
        if (str.trim().equals("")) {
            return;
        }
        String[] split = str.trim().split(" ");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            RouteInfo routeInfo = new RouteInfo(new IpPrefix(split[i2]), null);
            this.routes.add(routeInfo);
            updateAllowedFamilies(routeInfo.getDestination().getAddress());
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void updateAllowedFamilies(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            this.allowIPv4 = true;
        } else {
            this.allowIPv6 = true;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.user);
        parcel.writeString(this.interfaze);
        parcel.writeString(this.session);
        parcel.writeInt(this.mtu);
        parcel.writeTypedList(this.addresses);
        parcel.writeTypedList(this.routes);
        parcel.writeStringList(this.dnsServers);
        parcel.writeStringList(this.searchDomains);
        parcel.writeStringList(this.allowedApplications);
        parcel.writeStringList(this.disallowedApplications);
        parcel.writeParcelable(this.configureIntent, i);
        parcel.writeLong(this.startTime);
        parcel.writeInt(this.legacy ? 1 : 0);
        parcel.writeInt(this.blocking ? 1 : 0);
        parcel.writeInt(this.allowBypass ? 1 : 0);
        parcel.writeInt(this.allowIPv4 ? 1 : 0);
        parcel.writeInt(this.allowIPv6 ? 1 : 0);
        parcel.writeTypedArray(this.underlyingNetworks, i);
    }
}
