package android.os;

import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/os/BatteryProperties.class */
public class BatteryProperties implements Parcelable {
    public static final Parcelable.Creator<BatteryProperties> CREATOR = new Parcelable.Creator<BatteryProperties>() { // from class: android.os.BatteryProperties.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatteryProperties createFromParcel(Parcel parcel) {
            return new BatteryProperties(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatteryProperties[] newArray(int i) {
            return new BatteryProperties[i];
        }
    };
    public int batteryHealth;
    public int batteryLevel;
    public boolean batteryPresent;
    public int batteryStatus;
    public String batteryTechnology;
    public int batteryTemperature;
    public int batteryVoltage;
    public boolean chargerAcOnline;
    public boolean chargerDockAcOnline;
    public boolean chargerUsbOnline;
    public boolean chargerWirelessOnline;
    public int dockBatteryHealth;
    public int dockBatteryLevel;
    public boolean dockBatteryPresent;
    public int dockBatteryStatus;
    public boolean dockBatterySupported;
    public String dockBatteryTechnology;
    public int dockBatteryTemperature;
    public int dockBatteryVoltage;

    public BatteryProperties() {
    }

    private BatteryProperties(Parcel parcel) {
        this.chargerAcOnline = parcel.readInt() == 1;
        this.chargerUsbOnline = parcel.readInt() == 1;
        this.chargerWirelessOnline = parcel.readInt() == 1;
        this.batteryStatus = parcel.readInt();
        this.batteryHealth = parcel.readInt();
        this.batteryPresent = parcel.readInt() == 1;
        this.batteryLevel = parcel.readInt();
        this.batteryVoltage = parcel.readInt();
        this.batteryTemperature = parcel.readInt();
        this.batteryTechnology = parcel.readString();
        this.dockBatterySupported = parcel.readInt() == 1;
        if (this.dockBatterySupported) {
            this.chargerDockAcOnline = parcel.readInt() == 1;
            this.dockBatteryStatus = parcel.readInt();
            this.dockBatteryHealth = parcel.readInt();
            this.dockBatteryPresent = parcel.readInt() == 1;
            this.dockBatteryLevel = parcel.readInt();
            this.dockBatteryVoltage = parcel.readInt();
            this.dockBatteryTemperature = parcel.readInt();
            this.dockBatteryTechnology = parcel.readString();
            return;
        }
        this.chargerDockAcOnline = false;
        this.dockBatteryStatus = 1;
        this.dockBatteryHealth = 1;
        this.dockBatteryPresent = false;
        this.dockBatteryLevel = 0;
        this.dockBatteryVoltage = 0;
        this.dockBatteryTemperature = 0;
        this.dockBatteryTechnology = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void set(BatteryProperties batteryProperties) {
        this.chargerAcOnline = batteryProperties.chargerAcOnline;
        this.chargerUsbOnline = batteryProperties.chargerUsbOnline;
        this.chargerWirelessOnline = batteryProperties.chargerWirelessOnline;
        this.batteryStatus = batteryProperties.batteryStatus;
        this.batteryHealth = batteryProperties.batteryHealth;
        this.batteryPresent = batteryProperties.batteryPresent;
        this.batteryLevel = batteryProperties.batteryLevel;
        this.batteryVoltage = batteryProperties.batteryVoltage;
        this.batteryTemperature = batteryProperties.batteryTemperature;
        this.batteryTechnology = batteryProperties.batteryTechnology;
        this.dockBatterySupported = batteryProperties.dockBatterySupported;
        this.chargerDockAcOnline = batteryProperties.chargerDockAcOnline;
        this.dockBatteryStatus = batteryProperties.dockBatteryStatus;
        this.dockBatteryHealth = batteryProperties.dockBatteryHealth;
        this.dockBatteryPresent = batteryProperties.dockBatteryPresent;
        this.dockBatteryLevel = batteryProperties.dockBatteryLevel;
        this.dockBatteryVoltage = batteryProperties.dockBatteryVoltage;
        this.dockBatteryTemperature = batteryProperties.dockBatteryTemperature;
        this.dockBatteryTechnology = batteryProperties.dockBatteryTechnology;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.chargerAcOnline ? 1 : 0);
        parcel.writeInt(this.chargerUsbOnline ? 1 : 0);
        parcel.writeInt(this.chargerWirelessOnline ? 1 : 0);
        parcel.writeInt(this.batteryStatus);
        parcel.writeInt(this.batteryHealth);
        parcel.writeInt(this.batteryPresent ? 1 : 0);
        parcel.writeInt(this.batteryLevel);
        parcel.writeInt(this.batteryVoltage);
        parcel.writeInt(this.batteryTemperature);
        parcel.writeString(this.batteryTechnology);
        parcel.writeInt(this.dockBatterySupported ? 1 : 0);
        if (this.dockBatterySupported) {
            parcel.writeInt(this.chargerDockAcOnline ? 1 : 0);
            parcel.writeInt(this.dockBatteryStatus);
            parcel.writeInt(this.dockBatteryHealth);
            parcel.writeInt(this.dockBatteryPresent ? 1 : 0);
            parcel.writeInt(this.dockBatteryLevel);
            parcel.writeInt(this.dockBatteryVoltage);
            parcel.writeInt(this.dockBatteryTemperature);
            parcel.writeString(this.dockBatteryTechnology);
        }
    }
}
