package com.android.ims;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;

/* loaded from: source-4181928-dex2jar.jar:com/android/ims/ImsReasonInfo.class */
public class ImsReasonInfo implements Parcelable {
    public static final int CODE_ANSWERED_ELSEWHERE = 1014;
    public static final int CODE_BLACKLISTED_CALL_ID = 506;
    public static final int CODE_CALL_DROP_IWLAN_TO_LTE_UNAVAILABLE = 10004;
    public static final int CODE_ECBM_NOT_SUPPORTED = 901;
    public static final int CODE_EMERGENCY_PERM_FAILURE = 364;
    public static final int CODE_EMERGENCY_TEMP_FAILURE = 363;
    public static final int CODE_FDN_BLOCKED = 241;
    public static final int CODE_LOCAL_CALL_BUSY = 142;
    public static final int CODE_LOCAL_CALL_CS_RETRY_REQUIRED = 146;
    public static final int CODE_LOCAL_CALL_DECLINE = 143;
    public static final int CODE_LOCAL_CALL_EXCEEDED = 141;
    public static final int CODE_LOCAL_CALL_RESOURCE_RESERVATION_FAILED = 145;
    public static final int CODE_LOCAL_CALL_TERMINATED = 148;
    public static final int CODE_LOCAL_CALL_VCC_ON_PROGRESSING = 144;
    public static final int CODE_LOCAL_CALL_VOLTE_RETRY_REQUIRED = 147;
    public static final int CODE_LOCAL_ILLEGAL_ARGUMENT = 101;
    public static final int CODE_LOCAL_ILLEGAL_STATE = 102;
    public static final int CODE_LOCAL_IMS_SERVICE_DOWN = 106;
    public static final int CODE_LOCAL_INTERNAL_ERROR = 103;
    public static final int CODE_LOCAL_LOW_BATTERY = 112;
    public static final int CODE_LOCAL_NETWORK_IP_CHANGED = 124;
    public static final int CODE_LOCAL_NETWORK_NO_LTE_COVERAGE = 122;
    public static final int CODE_LOCAL_NETWORK_NO_SERVICE = 121;
    public static final int CODE_LOCAL_NETWORK_ROAMING = 123;
    public static final int CODE_LOCAL_NOT_REGISTERED = 132;
    public static final int CODE_LOCAL_NO_PENDING_CALL = 107;
    public static final int CODE_LOCAL_POWER_OFF = 111;
    public static final int CODE_LOCAL_SERVICE_UNAVAILABLE = 131;
    public static final int CODE_LOW_BATTERY = 505;
    public static final int CODE_MEDIA_INIT_FAILED = 401;
    public static final int CODE_MEDIA_NOT_ACCEPTABLE = 403;
    public static final int CODE_MEDIA_NO_DATA = 402;
    public static final int CODE_MEDIA_UNSPECIFIED = 404;
    public static final int CODE_REGISTRATION_ERROR = 10100;
    public static final int CODE_SIP_BAD_ADDRESS = 337;
    public static final int CODE_SIP_BAD_REQUEST = 331;
    public static final int CODE_SIP_BUSY = 338;
    public static final int CODE_SIP_CLIENT_ERROR = 342;
    public static final int CODE_SIP_FORBIDDEN = 332;
    public static final int CODE_SIP_GLOBAL_ERROR = 362;
    public static final int CODE_SIP_NOT_ACCEPTABLE = 340;
    public static final int CODE_SIP_NOT_FOUND = 333;
    public static final int CODE_SIP_NOT_REACHABLE = 341;
    public static final int CODE_SIP_NOT_SUPPORTED = 334;
    public static final int CODE_SIP_REDIRECTED = 321;
    public static final int CODE_SIP_REQUEST_CANCELLED = 339;
    public static final int CODE_SIP_REQUEST_TIMEOUT = 335;
    public static final int CODE_SIP_SERVER_BAD_GATEWAY = 353;
    public static final int CODE_SIP_SERVER_ERROR = 359;
    public static final int CODE_SIP_SERVER_INTERNAL_ERROR = 351;
    public static final int CODE_SIP_SERVER_MESSAGE_TOOLARGE = 357;
    public static final int CODE_SIP_SERVER_NOT_IMPLEMENTED = 352;
    public static final int CODE_SIP_SERVER_PRECONDITION_FAILURE = 358;
    public static final int CODE_SIP_SERVER_TIMEOUT = 355;
    public static final int CODE_SIP_SERVER_VERSION_UNSUPPORTED = 356;
    public static final int CODE_SIP_SERVICE_UNAVAILABLE = 354;
    public static final int CODE_SIP_TEMPRARILY_UNAVAILABLE = 336;
    public static final int CODE_SIP_USER_REJECTED = 361;
    public static final int CODE_TIMEOUT_1XX_WAITING = 201;
    public static final int CODE_TIMEOUT_NO_ANSWER = 202;
    public static final int CODE_TIMEOUT_NO_ANSWER_CALL_UPDATE = 203;
    public static final int CODE_UNSPECIFIED = 0;
    public static final int CODE_USER_DECLINE = 504;
    public static final int CODE_USER_IGNORE = 503;
    public static final int CODE_USER_NOANSWER = 502;
    public static final int CODE_USER_TERMINATED = 501;
    public static final int CODE_USER_TERMINATED_BY_REMOTE = 510;
    public static final int CODE_UT_CB_PASSWORD_MISMATCH = 821;
    public static final int CODE_UT_NETWORK_ERROR = 804;
    public static final int CODE_UT_NOT_SUPPORTED = 801;
    public static final int CODE_UT_OPERATION_NOT_ALLOWED = 803;
    public static final int CODE_UT_SERVICE_UNAVAILABLE = 802;
    public static final Parcelable.Creator<ImsReasonInfo> CREATOR = new Parcelable.Creator<ImsReasonInfo>() { // from class: com.android.ims.ImsReasonInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsReasonInfo createFromParcel(Parcel parcel) {
            return new ImsReasonInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsReasonInfo[] newArray(int i) {
            return new ImsReasonInfo[i];
        }
    };
    public static final int EXTRA_CODE_CALL_RETRY_BY_SETTINGS = 3;
    public static final int EXTRA_CODE_CALL_RETRY_NORMAL = 1;
    public static final int EXTRA_CODE_CALL_RETRY_SILENT_REDIAL = 2;
    public static final String EXTRA_MSG_SERVICE_NOT_AUTHORIZED = "Forbidden. Not Authorized for Service";
    public static final int TYPE_CALL_DROP = 100;
    public static final int TYPE_LOCAL = 1;
    public static final int TYPE_MEDIA = 4;
    public static final int TYPE_REGISTRATION = 101;
    public static final int TYPE_STATUSCODE = 3;
    public static final int TYPE_TIMEOUT = 2;
    public static final int TYPE_UNSPECIFIED = 0;
    public static final int TYPE_USER = 5;
    public static final int TYPE_UT = 8;
    public int mCode;
    public int mExtraCode;
    public String mExtraMessage;
    public int mReasonType;

    public ImsReasonInfo() {
        this.mReasonType = 0;
        this.mCode = 0;
        this.mExtraCode = 0;
        this.mExtraMessage = null;
    }

    public ImsReasonInfo(int i, int i2) {
        this.mReasonType = i / 100;
        this.mCode = i;
        this.mExtraCode = i2;
        this.mExtraMessage = null;
    }

    public ImsReasonInfo(int i, int i2, String str) {
        this.mReasonType = i / 100;
        this.mCode = i;
        this.mExtraCode = i2;
        this.mExtraMessage = str;
    }

    public ImsReasonInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel) {
        this.mReasonType = parcel.readInt();
        this.mCode = parcel.readInt();
        this.mExtraCode = parcel.readInt();
        this.mExtraMessage = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.mCode;
    }

    public int getExtraCode() {
        return this.mExtraCode;
    }

    public String getExtraMessage() {
        return this.mExtraMessage;
    }

    public int getReasonType() {
        return this.mReasonType;
    }

    public String toString() {
        return "ImsReasonInfo :: {" + this.mReasonType + ", " + this.mCode + ", " + this.mExtraCode + ", " + this.mExtraMessage + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mReasonType);
        parcel.writeInt(this.mCode);
        parcel.writeInt(this.mExtraCode);
        parcel.writeString(this.mExtraMessage);
    }
}
