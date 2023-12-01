package android.telephony;

import android.provider.CalendarContract;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/DisconnectCause.class */
public class DisconnectCause {
    public static final int ACCESS_INFORMATION_DISCARDED = 65;
    public static final int BEARER_CAPABILITY_NOT_AUTHORIZED = 54;
    public static final int BEARER_CAPABILITY_UNAVAILABLE = 71;
    public static final int BEARER_SERVICE_NOT_IMPLEMENTED = 73;
    public static final int BUSY = 4;
    public static final int CALL_BARRED = 20;
    public static final int CALL_BLACKLISTED = 400;
    public static final int CALL_FAIL_DESTINATION_OUT_OF_ORDER = 53;
    public static final int CALL_FAIL_NO_ANSWER_FROM_USER = 52;
    public static final int CALL_FAIL_NO_USER_RESPONDING = 51;
    public static final int CALL_REJECTED = 56;
    public static final int CDMA_ACCESS_BLOCKED = 35;
    public static final int CDMA_ACCESS_FAILURE = 32;
    public static final int CDMA_CALL_LOST = 41;
    public static final int CDMA_DROP = 27;
    public static final int CDMA_INTERCEPT = 28;
    public static final int CDMA_LOCKED_UNTIL_POWER_CYCLE = 26;
    public static final int CDMA_NOT_EMERGENCY = 34;
    public static final int CDMA_PREEMPTED = 33;
    public static final int CDMA_REORDER = 29;
    public static final int CDMA_RETRY_ORDER = 31;
    public static final int CDMA_SO_REJECT = 30;
    public static final int CHANNEL_UNACCEPTABLE = 55;
    public static final int CONDITIONAL_IE_ERROR = 86;
    public static final int CONGESTION = 5;
    public static final int CS_RESTRICTED = 22;
    public static final int CS_RESTRICTED_EMERGENCY = 24;
    public static final int CS_RESTRICTED_NORMAL = 23;
    public static final int DIALED_MMI = 39;
    public static final int DIAL_MODIFIED_TO_DIAL = 47;
    public static final int DIAL_MODIFIED_TO_SS = 46;
    public static final int DIAL_MODIFIED_TO_USSD = 45;
    public static final int EMERGENCY_ONLY = 37;
    public static final int EMERGENCY_PERM_FAILURE = 93;
    public static final int EMERGENCY_TEMP_FAILURE = 92;
    public static final int ERROR_UNSPECIFIED = 36;
    public static final int EXITED_ECM = 42;
    public static final int FACILITY_REJECTED = 59;
    public static final int FDN_BLOCKED = 21;
    public static final int ICC_ERROR = 19;
    public static final int IMS_MERGED_SUCCESSFULLY = 91;
    public static final int INCOMING_CALLS_BARRED_WITHIN_CUG = 70;
    public static final int INCOMING_MISSED = 1;
    public static final int INCOMING_REJECTED = 16;
    public static final int INCOMPATIBLE_DESTINATION = 79;
    public static final int INFORMATION_ELEMENT_NON_EXISTENT = 85;
    public static final int INTERWORKING_UNSPECIFIED = 90;
    public static final int INVALID_CREDENTIALS = 10;
    public static final int INVALID_MANDATORY_INFORMATION = 82;
    public static final int INVALID_NUMBER = 7;
    public static final int INVALID_TRANSACTION_IDENTIFIER = 77;
    public static final int INVALID_TRANSIT_NW_SELECTION = 80;
    public static final int LIMIT_EXCEEDED = 15;
    public static final int LOCAL = 3;
    public static final int LOST_SIGNAL = 14;
    public static final int MAXIMUM_VALID_VALUE = 91;
    public static final int MESSAGE_NOT_COMPATIBLE_WITH_PROTOCOL_STATE = 87;
    public static final int MESSAGE_TYPE_NON_IMPLEMENTED = 83;
    public static final int MESSAGE_TYPE_NOT_COMPATIBLE_WITH_PROTOCOL_STATE = 84;
    public static final int MINIMUM_VALID_VALUE = 0;
    public static final int MMI = 6;
    public static final int NETWORK_OUT_OF_ORDER = 62;
    public static final int NORMAL = 2;
    public static final int NORMAL_UNSPECIFIED = 61;
    public static final int NOT_DISCONNECTED = 0;
    public static final int NOT_VALID = -1;
    public static final int NO_CIRCUIT_AVAIL = 48;
    public static final int NO_PHONE_NUMBER_SUPPLIED = 38;
    public static final int NO_ROUTE_TO_DESTINAON = 49;
    public static final int NUMBER_CHANGED = 57;
    public static final int NUMBER_UNREACHABLE = 8;
    public static final int ONLY_DIGITAL_INFORMATION_BEARER_AVAILABLE = 75;
    public static final int OPERATOR_DETERMINED_BARRING = 50;
    public static final int OUTGOING_CANCELED = 44;
    public static final int OUTGOING_FAILURE = 43;
    public static final int OUT_OF_NETWORK = 11;
    public static final int OUT_OF_SERVICE = 18;
    public static final int POWER_OFF = 17;
    public static final int PREEMPTION = 58;
    public static final int PROTOCOL_ERROR_UNSPECIFIED = 89;
    public static final int QOS_UNAVAILABLE = 68;
    public static final int RECOVERY_ON_TIMER_EXPIRED = 88;
    public static final int REQUESTED_CIRCUIT_OR_CHANNEL_NOT_AVAILABLE = 66;
    public static final int REQUESTED_FACILITY_NOT_IMPLEMENTED = 74;
    public static final int REQUESTED_FACILITY_NOT_SUBSCRIBED = 69;
    public static final int RESOURCES_UNAVAILABLE_OR_UNSPECIFIED = 67;
    public static final int RESP_TO_STATUS_ENQUIRY = 60;
    public static final int SEMANTICALLY_INCORRECT_MESSAGE = 81;
    public static final int SERVER_ERROR = 12;
    public static final int SERVER_UNREACHABLE = 9;
    public static final int SERVICE_OPTION_NOT_AVAILABLE = 72;
    public static final int SERVICE_OR_OPTION_NOT_IMPLEMENTED = 76;
    public static final int SWITCHING_EQUIPMENT_CONGESTION = 64;
    public static final int TEMPORARY_FAILURE = 63;
    public static final int TIMED_OUT = 13;
    public static final int UNOBTAINABLE_NUMBER = 25;
    public static final int USER_NOT_MEMBER_OF_CUG = 78;
    public static final int VOICEMAIL_NUMBER_MISSING = 40;

    private DisconnectCause() {
    }

    public static String toString(int i) {
        switch (i) {
            case 0:
                return "NOT_DISCONNECTED";
            case 1:
                return "INCOMING_MISSED";
            case 2:
                return "NORMAL";
            case 3:
                return CalendarContract.ACCOUNT_TYPE_LOCAL;
            case 4:
                return "BUSY";
            case 5:
                return "CONGESTION";
            case 7:
                return "INVALID_NUMBER";
            case 8:
                return "NUMBER_UNREACHABLE";
            case 9:
                return "SERVER_UNREACHABLE";
            case 10:
                return "INVALID_CREDENTIALS";
            case 11:
                return "OUT_OF_NETWORK";
            case 12:
                return "SERVER_ERROR";
            case 13:
                return "TIMED_OUT";
            case 14:
                return "LOST_SIGNAL";
            case 15:
                return "LIMIT_EXCEEDED";
            case 16:
                return "INCOMING_REJECTED";
            case 17:
                return "POWER_OFF";
            case 18:
                return "OUT_OF_SERVICE";
            case 19:
                return "ICC_ERROR";
            case 20:
                return "CALL_BARRED";
            case 21:
                return "FDN_BLOCKED";
            case 22:
                return "CS_RESTRICTED";
            case 23:
                return "CS_RESTRICTED_NORMAL";
            case 24:
                return "CS_RESTRICTED_EMERGENCY";
            case 25:
                return "UNOBTAINABLE_NUMBER";
            case 26:
                return "CDMA_LOCKED_UNTIL_POWER_CYCLE";
            case 27:
                return "CDMA_DROP";
            case 28:
                return "CDMA_INTERCEPT";
            case 29:
                return "CDMA_REORDER";
            case 30:
                return "CDMA_SO_REJECT";
            case 31:
                return "CDMA_RETRY_ORDER";
            case 32:
                return "CDMA_ACCESS_FAILURE";
            case 33:
                return "CDMA_PREEMPTED";
            case 34:
                return "CDMA_NOT_EMERGENCY";
            case 35:
                return "CDMA_ACCESS_BLOCKED";
            case 36:
                return "ERROR_UNSPECIFIED";
            case 37:
                return "EMERGENCY_ONLY";
            case 38:
                return "NO_PHONE_NUMBER_SUPPLIED";
            case 39:
                return "DIALED_MMI";
            case 40:
                return "VOICEMAIL_NUMBER_MISSING";
            case 41:
                return "CDMA_CALL_LOST";
            case 42:
                return "EXITED_ECM";
            case 43:
                return "OUTGOING_FAILURE";
            case 44:
                return "OUTGOING_CANCELED";
            case 45:
                return "DIAL_MODIFIED_TO_USSD";
            case 46:
                return "DIAL_MODIFIED_TO_SS";
            case 47:
                return "DIAL_MODIFIED_TO_DIAL";
            case 91:
                return "IMS_MERGED_SUCCESSFULLY";
            case 400:
                return "CALL_BLACKLISTED";
            default:
                return "INVALID: " + i;
        }
    }
}
