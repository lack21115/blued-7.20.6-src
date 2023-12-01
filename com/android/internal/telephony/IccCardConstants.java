package com.android.internal.telephony;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/IccCardConstants.class */
public class IccCardConstants {
    public static final String INTENT_KEY_ICC_STATE = "ss";
    public static final String INTENT_KEY_LOCKED_REASON = "reason";
    public static final String INTENT_VALUE_ABSENT_ON_PERM_DISABLED = "PERM_DISABLED";
    public static final String INTENT_VALUE_ICC_ABSENT = "ABSENT";
    public static final String INTENT_VALUE_ICC_CARD_IO_ERROR = "CARD_IO_ERROR";
    public static final String INTENT_VALUE_ICC_IMSI = "IMSI";
    public static final String INTENT_VALUE_ICC_LOADED = "LOADED";
    public static final String INTENT_VALUE_ICC_LOCKED = "LOCKED";
    public static final String INTENT_VALUE_ICC_NOT_READY = "NOT_READY";
    public static final String INTENT_VALUE_ICC_READY = "READY";
    public static final String INTENT_VALUE_ICC_UNKNOWN = "UNKNOWN";
    public static final String INTENT_VALUE_LOCKED_ON_PIN = "PIN";
    public static final String INTENT_VALUE_LOCKED_ON_PUK = "PUK";
    public static final String INTENT_VALUE_LOCKED_PERSO = "PERSO";

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/IccCardConstants$State.class */
    public enum State {
        UNKNOWN,
        ABSENT,
        PIN_REQUIRED,
        PUK_REQUIRED,
        PERSO_LOCKED,
        READY,
        NOT_READY,
        PERM_DISABLED,
        CARD_IO_ERROR;

        public static State intToState(int i) throws IllegalArgumentException {
            switch (i) {
                case 0:
                    return UNKNOWN;
                case 1:
                    return ABSENT;
                case 2:
                    return PIN_REQUIRED;
                case 3:
                    return PUK_REQUIRED;
                case 4:
                    return PERSO_LOCKED;
                case 5:
                    return READY;
                case 6:
                    return NOT_READY;
                case 7:
                    return PERM_DISABLED;
                case 8:
                    return CARD_IO_ERROR;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public boolean iccCardExist() {
            return this == PIN_REQUIRED || this == PUK_REQUIRED || this == PERSO_LOCKED || this == READY || this == PERM_DISABLED || this == CARD_IO_ERROR;
        }

        public boolean isPinLocked() {
            return this == PIN_REQUIRED || this == PUK_REQUIRED;
        }
    }
}
