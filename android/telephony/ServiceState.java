package android.telephony;

import android.hardware.Camera;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.cm.QSConstants;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/ServiceState.class */
public class ServiceState implements Parcelable {
    public static final Parcelable.Creator<ServiceState> CREATOR = new Parcelable.Creator<ServiceState>() { // from class: android.telephony.ServiceState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceState createFromParcel(Parcel parcel) {
            return new ServiceState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceState[] newArray(int i) {
            return new ServiceState[i];
        }
    };
    static final boolean DBG = true;
    static final String LOG_TAG = "PHONE";
    public static final int REGISTRATION_STATE_HOME_NETWORK = 1;
    public static final int REGISTRATION_STATE_NOT_REGISTERED_AND_NOT_SEARCHING = 0;
    public static final int REGISTRATION_STATE_NOT_REGISTERED_AND_SEARCHING = 2;
    public static final int REGISTRATION_STATE_REGISTRATION_DENIED = 3;
    public static final int REGISTRATION_STATE_ROAMING = 5;
    public static final int REGISTRATION_STATE_UNKNOWN = 4;
    public static final int RIL_RADIO_TECHNOLOGY_1xRTT = 6;
    public static final int RIL_RADIO_TECHNOLOGY_EDGE = 2;
    public static final int RIL_RADIO_TECHNOLOGY_EHRPD = 13;
    public static final int RIL_RADIO_TECHNOLOGY_EVDO_0 = 7;
    public static final int RIL_RADIO_TECHNOLOGY_EVDO_A = 8;
    public static final int RIL_RADIO_TECHNOLOGY_EVDO_B = 12;
    public static final int RIL_RADIO_TECHNOLOGY_GPRS = 1;
    public static final int RIL_RADIO_TECHNOLOGY_GSM = 16;
    public static final int RIL_RADIO_TECHNOLOGY_HSDPA = 9;
    public static final int RIL_RADIO_TECHNOLOGY_HSPA = 11;
    public static final int RIL_RADIO_TECHNOLOGY_HSPAP = 15;
    public static final int RIL_RADIO_TECHNOLOGY_HSUPA = 10;
    public static final int RIL_RADIO_TECHNOLOGY_IS95A = 4;
    public static final int RIL_RADIO_TECHNOLOGY_IS95B = 5;
    public static final int RIL_RADIO_TECHNOLOGY_IWLAN = 18;
    public static final int RIL_RADIO_TECHNOLOGY_LTE = 14;
    public static final int RIL_RADIO_TECHNOLOGY_TD_SCDMA = 17;
    public static final int RIL_RADIO_TECHNOLOGY_UMTS = 3;
    public static final int RIL_RADIO_TECHNOLOGY_UNKNOWN = 0;
    public static final int RIL_REG_STATE_DENIED = 3;
    public static final int RIL_REG_STATE_DENIED_EMERGENCY_CALL_ENABLED = 13;
    public static final int RIL_REG_STATE_HOME = 1;
    public static final int RIL_REG_STATE_NOT_REG = 0;
    public static final int RIL_REG_STATE_NOT_REG_EMERGENCY_CALL_ENABLED = 10;
    public static final int RIL_REG_STATE_ROAMING = 5;
    public static final int RIL_REG_STATE_SEARCHING = 2;
    public static final int RIL_REG_STATE_SEARCHING_EMERGENCY_CALL_ENABLED = 12;
    public static final int RIL_REG_STATE_UNKNOWN = 4;
    public static final int RIL_REG_STATE_UNKNOWN_EMERGENCY_CALL_ENABLED = 14;
    public static final int ROAMING_TYPE_DOMESTIC = 2;
    public static final int ROAMING_TYPE_INTERNATIONAL = 3;
    public static final int ROAMING_TYPE_NOT_ROAMING = 0;
    public static final int ROAMING_TYPE_UNKNOWN = 1;
    public static final int STATE_EMERGENCY_ONLY = 2;
    public static final int STATE_IN_SERVICE = 0;
    public static final int STATE_OUT_OF_SERVICE = 1;
    public static final int STATE_POWER_OFF = 3;
    private int mCdmaDefaultRoamingIndicator;
    private int mCdmaEriIconIndex;
    private int mCdmaEriIconMode;
    private int mCdmaRoamingIndicator;
    private boolean mCssIndicator;
    private String mDataOperatorAlphaLong;
    private String mDataOperatorAlphaShort;
    private String mDataOperatorNumeric;
    private int mDataRegState;
    private int mDataRoamingType;
    private boolean mIsEmergencyOnly;
    private boolean mIsManualNetworkSelection;
    private int mNetworkId;
    private int mRilDataRadioTechnology;
    private int mRilVoiceRadioTechnology;
    private int mSystemId;
    private String mVoiceOperatorAlphaLong;
    private String mVoiceOperatorAlphaShort;
    private String mVoiceOperatorNumeric;
    private int mVoiceRegState;
    private int mVoiceRoamingType;

    public ServiceState() {
        this.mVoiceRegState = 1;
        this.mDataRegState = 1;
        this.mCdmaEriIconIndex = 1;
    }

    public ServiceState(Parcel parcel) {
        this.mVoiceRegState = 1;
        this.mDataRegState = 1;
        this.mCdmaEriIconIndex = 1;
        this.mVoiceRegState = parcel.readInt();
        this.mDataRegState = parcel.readInt();
        this.mVoiceRoamingType = parcel.readInt();
        this.mDataRoamingType = parcel.readInt();
        this.mVoiceOperatorAlphaLong = parcel.readString();
        this.mVoiceOperatorAlphaShort = parcel.readString();
        this.mVoiceOperatorNumeric = parcel.readString();
        this.mDataOperatorAlphaLong = parcel.readString();
        this.mDataOperatorAlphaShort = parcel.readString();
        this.mDataOperatorNumeric = parcel.readString();
        this.mIsManualNetworkSelection = parcel.readInt() != 0;
        this.mRilVoiceRadioTechnology = parcel.readInt();
        this.mRilDataRadioTechnology = parcel.readInt();
        this.mCssIndicator = parcel.readInt() != 0;
        this.mNetworkId = parcel.readInt();
        this.mSystemId = parcel.readInt();
        this.mCdmaRoamingIndicator = parcel.readInt();
        this.mCdmaDefaultRoamingIndicator = parcel.readInt();
        this.mCdmaEriIconIndex = parcel.readInt();
        this.mCdmaEriIconMode = parcel.readInt();
        this.mIsEmergencyOnly = parcel.readInt() != 0;
    }

    public ServiceState(ServiceState serviceState) {
        this.mVoiceRegState = 1;
        this.mDataRegState = 1;
        this.mCdmaEriIconIndex = 1;
        copyFrom(serviceState);
    }

    private static boolean equalsHandlesNulls(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static final String getRoamingLogString(int i) {
        switch (i) {
            case 0:
                return "home";
            case 1:
                return QSConstants.TILE_ROAMING;
            case 2:
                return "Domestic Roaming";
            case 3:
                return "International Roaming";
            default:
                return "UNKNOWN";
        }
    }

    public static boolean isCdma(int i) {
        return i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 12 || i == 13;
    }

    public static boolean isGsm(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9 || i == 10 || i == 11 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18;
    }

    public static ServiceState mergeServiceStates(ServiceState serviceState, ServiceState serviceState2) {
        if (serviceState2.mVoiceRegState != 0) {
            return serviceState;
        }
        ServiceState serviceState3 = new ServiceState(serviceState);
        serviceState3.mVoiceRegState = serviceState2.mVoiceRegState;
        serviceState3.mIsEmergencyOnly = false;
        return serviceState3;
    }

    public static ServiceState newFromBundle(Bundle bundle) {
        ServiceState serviceState = new ServiceState();
        serviceState.setFromNotifierBundle(bundle);
        return serviceState;
    }

    private int rilRadioTechnologyToNetworkType(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
            case 5:
                return 4;
            case 6:
                return 7;
            case 7:
                return 5;
            case 8:
                return 6;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                return 10;
            case 12:
                return 12;
            case 13:
                return 14;
            case 14:
                return 13;
            case 15:
                return 15;
            case 16:
                return 16;
            case 17:
                return 17;
            case 18:
                return 18;
            default:
                return 0;
        }
    }

    public static String rilRadioTechnologyToString(int i) {
        switch (i) {
            case 0:
                return "Unknown";
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA-IS95A";
            case 5:
                return "CDMA-IS95B";
            case 6:
                return "1xRTT";
            case 7:
                return "EvDo-rev.0";
            case 8:
                return "EvDo-rev.A";
            case 9:
                return "HSDPA";
            case 10:
                return "HSUPA";
            case 11:
                return "HSPA";
            case 12:
                return "EvDo-rev.B";
            case 13:
                return "eHRPD";
            case 14:
                return "LTE";
            case 15:
                return "HSPAP";
            case 16:
                return "GSM";
            case 17:
                return "TD-SCDMA";
            case 18:
                return "IWLAN";
            default:
                Rlog.w(LOG_TAG, "Unexpected radioTechnology=" + i);
                return "Unexpected";
        }
    }

    private void setFromNotifierBundle(Bundle bundle) {
        this.mVoiceRegState = bundle.getInt("voiceRegState");
        this.mDataRegState = bundle.getInt("dataRegState");
        this.mVoiceRoamingType = bundle.getInt("voiceRoamingType");
        this.mDataRoamingType = bundle.getInt("dataRoamingType");
        this.mVoiceOperatorAlphaLong = bundle.getString("operator-alpha-long");
        this.mVoiceOperatorAlphaShort = bundle.getString("operator-alpha-short");
        this.mVoiceOperatorNumeric = bundle.getString("operator-numeric");
        this.mDataOperatorAlphaLong = bundle.getString("data-operator-alpha-long");
        this.mDataOperatorAlphaShort = bundle.getString("data-operator-alpha-short");
        this.mDataOperatorNumeric = bundle.getString("data-operator-numeric");
        this.mIsManualNetworkSelection = bundle.getBoolean(Camera.Parameters.FOCUS_MODE_MANUAL_POSITION);
        this.mRilVoiceRadioTechnology = bundle.getInt("radioTechnology");
        this.mRilDataRadioTechnology = bundle.getInt("dataRadioTechnology");
        this.mCssIndicator = bundle.getBoolean("cssIndicator");
        this.mNetworkId = bundle.getInt("networkId");
        this.mSystemId = bundle.getInt("systemId");
        this.mCdmaRoamingIndicator = bundle.getInt("cdmaRoamingIndicator");
        this.mCdmaDefaultRoamingIndicator = bundle.getInt("cdmaDefaultRoamingIndicator");
        this.mIsEmergencyOnly = bundle.getBoolean("emergencyOnly");
    }

    private void setNullState(int i) {
        Rlog.d(LOG_TAG, "[ServiceState] setNullState=" + i);
        this.mVoiceRegState = i;
        this.mDataRegState = i;
        this.mVoiceRoamingType = 0;
        this.mDataRoamingType = 0;
        this.mVoiceOperatorAlphaLong = null;
        this.mVoiceOperatorAlphaShort = null;
        this.mVoiceOperatorNumeric = null;
        this.mDataOperatorAlphaLong = null;
        this.mDataOperatorAlphaShort = null;
        this.mDataOperatorNumeric = null;
        this.mIsManualNetworkSelection = false;
        this.mRilVoiceRadioTechnology = 0;
        this.mRilDataRadioTechnology = 0;
        this.mCssIndicator = false;
        this.mNetworkId = -1;
        this.mSystemId = -1;
        this.mCdmaRoamingIndicator = -1;
        this.mCdmaDefaultRoamingIndicator = -1;
        this.mCdmaEriIconIndex = -1;
        this.mCdmaEriIconMode = -1;
        this.mIsEmergencyOnly = false;
    }

    protected void copyFrom(ServiceState serviceState) {
        this.mVoiceRegState = serviceState.mVoiceRegState;
        this.mDataRegState = serviceState.mDataRegState;
        this.mVoiceRoamingType = serviceState.mVoiceRoamingType;
        this.mDataRoamingType = serviceState.mDataRoamingType;
        this.mVoiceOperatorAlphaLong = serviceState.mVoiceOperatorAlphaLong;
        this.mVoiceOperatorAlphaShort = serviceState.mVoiceOperatorAlphaShort;
        this.mVoiceOperatorNumeric = serviceState.mVoiceOperatorNumeric;
        this.mDataOperatorAlphaLong = serviceState.mDataOperatorAlphaLong;
        this.mDataOperatorAlphaShort = serviceState.mDataOperatorAlphaShort;
        this.mDataOperatorNumeric = serviceState.mDataOperatorNumeric;
        this.mIsManualNetworkSelection = serviceState.mIsManualNetworkSelection;
        this.mRilVoiceRadioTechnology = serviceState.mRilVoiceRadioTechnology;
        this.mRilDataRadioTechnology = serviceState.mRilDataRadioTechnology;
        this.mCssIndicator = serviceState.mCssIndicator;
        this.mNetworkId = serviceState.mNetworkId;
        this.mSystemId = serviceState.mSystemId;
        this.mCdmaRoamingIndicator = serviceState.mCdmaRoamingIndicator;
        this.mCdmaDefaultRoamingIndicator = serviceState.mCdmaDefaultRoamingIndicator;
        this.mCdmaEriIconIndex = serviceState.mCdmaEriIconIndex;
        this.mCdmaEriIconMode = serviceState.mCdmaEriIconMode;
        this.mIsEmergencyOnly = serviceState.mIsEmergencyOnly;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        try {
            ServiceState serviceState = (ServiceState) obj;
            return obj != null && this.mVoiceRegState == serviceState.mVoiceRegState && this.mDataRegState == serviceState.mDataRegState && this.mIsManualNetworkSelection == serviceState.mIsManualNetworkSelection && this.mVoiceRoamingType == serviceState.mVoiceRoamingType && this.mDataRoamingType == serviceState.mDataRoamingType && equalsHandlesNulls(this.mVoiceOperatorAlphaLong, serviceState.mVoiceOperatorAlphaLong) && equalsHandlesNulls(this.mVoiceOperatorAlphaShort, serviceState.mVoiceOperatorAlphaShort) && equalsHandlesNulls(this.mVoiceOperatorNumeric, serviceState.mVoiceOperatorNumeric) && equalsHandlesNulls(this.mDataOperatorAlphaLong, serviceState.mDataOperatorAlphaLong) && equalsHandlesNulls(this.mDataOperatorAlphaShort, serviceState.mDataOperatorAlphaShort) && equalsHandlesNulls(this.mDataOperatorNumeric, serviceState.mDataOperatorNumeric) && equalsHandlesNulls(Integer.valueOf(this.mRilVoiceRadioTechnology), Integer.valueOf(serviceState.mRilVoiceRadioTechnology)) && equalsHandlesNulls(Integer.valueOf(this.mRilDataRadioTechnology), Integer.valueOf(serviceState.mRilDataRadioTechnology)) && equalsHandlesNulls(Boolean.valueOf(this.mCssIndicator), Boolean.valueOf(serviceState.mCssIndicator)) && equalsHandlesNulls(Integer.valueOf(this.mNetworkId), Integer.valueOf(serviceState.mNetworkId)) && equalsHandlesNulls(Integer.valueOf(this.mSystemId), Integer.valueOf(serviceState.mSystemId)) && equalsHandlesNulls(Integer.valueOf(this.mCdmaRoamingIndicator), Integer.valueOf(serviceState.mCdmaRoamingIndicator)) && equalsHandlesNulls(Integer.valueOf(this.mCdmaDefaultRoamingIndicator), Integer.valueOf(serviceState.mCdmaDefaultRoamingIndicator)) && this.mIsEmergencyOnly == serviceState.mIsEmergencyOnly;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public void fillInNotifierBundle(Bundle bundle) {
        bundle.putInt("voiceRegState", this.mVoiceRegState);
        bundle.putInt("dataRegState", this.mDataRegState);
        bundle.putInt("voiceRoamingType", this.mVoiceRoamingType);
        bundle.putInt("dataRoamingType", this.mDataRoamingType);
        bundle.putString("operator-alpha-long", this.mVoiceOperatorAlphaLong);
        bundle.putString("operator-alpha-short", this.mVoiceOperatorAlphaShort);
        bundle.putString("operator-numeric", this.mVoiceOperatorNumeric);
        bundle.putString("data-operator-alpha-long", this.mDataOperatorAlphaLong);
        bundle.putString("data-operator-alpha-short", this.mDataOperatorAlphaShort);
        bundle.putString("data-operator-numeric", this.mDataOperatorNumeric);
        bundle.putBoolean(Camera.Parameters.FOCUS_MODE_MANUAL_POSITION, Boolean.valueOf(this.mIsManualNetworkSelection).booleanValue());
        bundle.putInt("radioTechnology", this.mRilVoiceRadioTechnology);
        bundle.putInt("dataRadioTechnology", this.mRilDataRadioTechnology);
        bundle.putBoolean("cssIndicator", this.mCssIndicator);
        bundle.putInt("networkId", this.mNetworkId);
        bundle.putInt("systemId", this.mSystemId);
        bundle.putInt("cdmaRoamingIndicator", this.mCdmaRoamingIndicator);
        bundle.putInt("cdmaDefaultRoamingIndicator", this.mCdmaDefaultRoamingIndicator);
        bundle.putBoolean("emergencyOnly", Boolean.valueOf(this.mIsEmergencyOnly).booleanValue());
    }

    public int getCdmaDefaultRoamingIndicator() {
        return this.mCdmaDefaultRoamingIndicator;
    }

    public int getCdmaEriIconIndex() {
        return this.mCdmaEriIconIndex;
    }

    public int getCdmaEriIconMode() {
        return this.mCdmaEriIconMode;
    }

    public int getCdmaRoamingIndicator() {
        return this.mCdmaRoamingIndicator;
    }

    public int getCssIndicator() {
        return this.mCssIndicator ? 1 : 0;
    }

    public int getDataNetworkType() {
        return rilRadioTechnologyToNetworkType(this.mRilDataRadioTechnology);
    }

    public String getDataOperatorAlphaLong() {
        return this.mDataOperatorAlphaLong;
    }

    public String getDataOperatorAlphaShort() {
        return this.mDataOperatorAlphaShort;
    }

    public String getDataOperatorNumeric() {
        return this.mDataOperatorNumeric;
    }

    public int getDataRegState() {
        return this.mDataRegState;
    }

    public boolean getDataRoaming() {
        return this.mDataRoamingType != 0;
    }

    public int getDataRoamingType() {
        return this.mDataRoamingType;
    }

    public boolean getIsManualSelection() {
        return this.mIsManualNetworkSelection;
    }

    public int getNetworkId() {
        return this.mNetworkId;
    }

    public int getNetworkType() {
        Rlog.e(LOG_TAG, "ServiceState.getNetworkType() DEPRECATED will be removed *******");
        return rilRadioTechnologyToNetworkType(this.mRilVoiceRadioTechnology);
    }

    public String getOperatorAlphaLong() {
        return this.mVoiceOperatorAlphaLong;
    }

    public String getOperatorAlphaShort() {
        return this.mVoiceOperatorAlphaShort;
    }

    public String getOperatorNumeric() {
        return this.mVoiceOperatorNumeric;
    }

    public int getRadioTechnology() {
        Rlog.e(LOG_TAG, "ServiceState.getRadioTechnology() DEPRECATED will be removed *******");
        return getRilDataRadioTechnology();
    }

    public int getRilDataRadioTechnology() {
        return this.mRilDataRadioTechnology;
    }

    public int getRilVoiceRadioTechnology() {
        return this.mRilVoiceRadioTechnology;
    }

    public boolean getRoaming() {
        return getVoiceRoaming() || getDataRoaming();
    }

    public int getState() {
        return getVoiceRegState();
    }

    public int getSystemId() {
        return this.mSystemId;
    }

    public int getVoiceNetworkType() {
        return rilRadioTechnologyToNetworkType(this.mRilVoiceRadioTechnology);
    }

    public String getVoiceOperatorAlphaLong() {
        return this.mVoiceOperatorAlphaLong;
    }

    public String getVoiceOperatorAlphaShort() {
        return this.mVoiceOperatorAlphaShort;
    }

    public String getVoiceOperatorNumeric() {
        return this.mVoiceOperatorNumeric;
    }

    public int getVoiceRegState() {
        return this.mVoiceRegState;
    }

    public boolean getVoiceRoaming() {
        return this.mVoiceRoamingType != 0;
    }

    public int getVoiceRoamingType() {
        return this.mVoiceRoamingType;
    }

    public int hashCode() {
        int i = 1;
        int i2 = this.mVoiceRegState;
        int i3 = this.mDataRegState;
        int i4 = this.mVoiceRoamingType;
        int i5 = this.mDataRoamingType;
        int i6 = this.mIsManualNetworkSelection ? 1 : 0;
        int hashCode = this.mVoiceOperatorAlphaLong == null ? 0 : this.mVoiceOperatorAlphaLong.hashCode();
        int hashCode2 = this.mVoiceOperatorAlphaShort == null ? 0 : this.mVoiceOperatorAlphaShort.hashCode();
        int hashCode3 = this.mVoiceOperatorNumeric == null ? 0 : this.mVoiceOperatorNumeric.hashCode();
        int hashCode4 = this.mDataOperatorAlphaLong == null ? 0 : this.mDataOperatorAlphaLong.hashCode();
        int hashCode5 = this.mDataOperatorAlphaShort == null ? 0 : this.mDataOperatorAlphaShort.hashCode();
        int hashCode6 = this.mDataOperatorNumeric == null ? 0 : this.mDataOperatorNumeric.hashCode();
        int i7 = this.mCdmaRoamingIndicator;
        int i8 = this.mCdmaDefaultRoamingIndicator;
        if (!this.mIsEmergencyOnly) {
            i = 0;
        }
        return hashCode6 + i5 + (i2 * 31) + (i3 * 37) + i4 + i6 + hashCode + hashCode2 + hashCode3 + hashCode4 + hashCode5 + i7 + i8 + i;
    }

    public boolean isEmergencyOnly() {
        return this.mIsEmergencyOnly;
    }

    public void setCdmaDefaultRoamingIndicator(int i) {
        this.mCdmaDefaultRoamingIndicator = i;
    }

    public void setCdmaEriIconIndex(int i) {
        this.mCdmaEriIconIndex = i;
    }

    public void setCdmaEriIconMode(int i) {
        this.mCdmaEriIconMode = i;
    }

    public void setCdmaRoamingIndicator(int i) {
        this.mCdmaRoamingIndicator = i;
    }

    public void setCssIndicator(int i) {
        this.mCssIndicator = i != 0;
    }

    public void setDataOperatorAlphaLong(String str) {
        this.mDataOperatorAlphaLong = str;
    }

    public void setDataOperatorName(String str, String str2, String str3) {
        this.mDataOperatorAlphaLong = str;
        this.mDataOperatorAlphaShort = str2;
        this.mDataOperatorNumeric = str3;
    }

    public void setDataRegState(int i) {
        this.mDataRegState = i;
        Rlog.d(LOG_TAG, "[ServiceState] setDataRegState=" + this.mDataRegState);
    }

    public void setDataRoaming(boolean z) {
        this.mDataRoamingType = z ? 1 : 0;
    }

    public void setDataRoamingType(int i) {
        this.mDataRoamingType = i;
    }

    public void setEmergencyOnly(boolean z) {
        this.mIsEmergencyOnly = z;
    }

    public void setIsManualSelection(boolean z) {
        this.mIsManualNetworkSelection = z;
    }

    public void setOperatorAlphaLong(String str) {
        this.mVoiceOperatorAlphaLong = str;
        this.mDataOperatorAlphaLong = str;
    }

    public void setOperatorName(String str, String str2, String str3) {
        this.mVoiceOperatorAlphaLong = str;
        this.mVoiceOperatorAlphaShort = str2;
        this.mVoiceOperatorNumeric = str3;
        this.mDataOperatorAlphaLong = str;
        this.mDataOperatorAlphaShort = str2;
        this.mDataOperatorNumeric = str3;
    }

    public void setRilDataRadioTechnology(int i) {
        this.mRilDataRadioTechnology = i;
        Rlog.d(LOG_TAG, "[ServiceState] setDataRadioTechnology=" + this.mRilDataRadioTechnology);
    }

    public void setRilVoiceRadioTechnology(int i) {
        this.mRilVoiceRadioTechnology = i;
    }

    public void setRoaming(boolean z) {
        this.mVoiceRoamingType = z ? 1 : 0;
        this.mDataRoamingType = this.mVoiceRoamingType;
    }

    public void setState(int i) {
        setVoiceRegState(i);
        Rlog.e(LOG_TAG, "[ServiceState] setState deprecated use setVoiceRegState()");
    }

    public void setStateOff() {
        setNullState(3);
    }

    public void setStateOutOfService() {
        setNullState(1);
    }

    public void setSystemAndNetworkId(int i, int i2) {
        this.mSystemId = i;
        this.mNetworkId = i2;
    }

    public void setVoiceOperatorAlphaLong(String str) {
        this.mVoiceOperatorAlphaLong = str;
    }

    public void setVoiceOperatorName(String str, String str2, String str3) {
        this.mVoiceOperatorAlphaLong = str;
        this.mVoiceOperatorAlphaShort = str2;
        this.mVoiceOperatorNumeric = str3;
    }

    public void setVoiceRegState(int i) {
        this.mVoiceRegState = i;
        Rlog.d(LOG_TAG, "[ServiceState] setVoiceRegState=" + this.mVoiceRegState);
    }

    public void setVoiceRoaming(boolean z) {
        this.mVoiceRoamingType = z ? 1 : 0;
    }

    public void setVoiceRoamingType(int i) {
        this.mVoiceRoamingType = i;
    }

    public String toString() {
        return this.mVoiceRegState + " " + this.mDataRegState + " voice " + getRoamingLogString(this.mVoiceRoamingType) + " data " + getRoamingLogString(this.mDataRoamingType) + " " + this.mVoiceOperatorAlphaLong + " " + this.mVoiceOperatorAlphaShort + " " + this.mVoiceOperatorNumeric + " " + this.mDataOperatorAlphaLong + " " + this.mDataOperatorAlphaShort + " " + this.mDataOperatorNumeric + " " + (this.mIsManualNetworkSelection ? "(manual)" : "") + " " + rilRadioTechnologyToString(this.mRilVoiceRadioTechnology) + " " + rilRadioTechnologyToString(this.mRilDataRadioTechnology) + " " + (this.mCssIndicator ? "CSS supported" : "CSS not supported") + " " + this.mNetworkId + " " + this.mSystemId + " RoamInd=" + this.mCdmaRoamingIndicator + " DefRoamInd=" + this.mCdmaDefaultRoamingIndicator + " EmergOnly=" + this.mIsEmergencyOnly;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVoiceRegState);
        parcel.writeInt(this.mDataRegState);
        parcel.writeInt(this.mVoiceRoamingType);
        parcel.writeInt(this.mDataRoamingType);
        parcel.writeString(this.mVoiceOperatorAlphaLong);
        parcel.writeString(this.mVoiceOperatorAlphaShort);
        parcel.writeString(this.mVoiceOperatorNumeric);
        parcel.writeString(this.mDataOperatorAlphaLong);
        parcel.writeString(this.mDataOperatorAlphaShort);
        parcel.writeString(this.mDataOperatorNumeric);
        parcel.writeInt(this.mIsManualNetworkSelection ? 1 : 0);
        parcel.writeInt(this.mRilVoiceRadioTechnology);
        parcel.writeInt(this.mRilDataRadioTechnology);
        parcel.writeInt(this.mCssIndicator ? 1 : 0);
        parcel.writeInt(this.mNetworkId);
        parcel.writeInt(this.mSystemId);
        parcel.writeInt(this.mCdmaRoamingIndicator);
        parcel.writeInt(this.mCdmaDefaultRoamingIndicator);
        parcel.writeInt(this.mCdmaEriIconIndex);
        parcel.writeInt(this.mCdmaEriIconMode);
        parcel.writeInt(this.mIsEmergencyOnly ? 1 : 0);
    }
}
