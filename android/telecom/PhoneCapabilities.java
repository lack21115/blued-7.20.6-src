package android.telecom;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/PhoneCapabilities.class */
public final class PhoneCapabilities {
    public static final int ADD_PARTICIPANT = 32768;
    public static final int ALL = 12527;
    public static final int CALL_TYPE_MODIFIABLE = 131072;
    public static final int DISCONNECT_FROM_CONFERENCE = 8192;
    public static final int GENERIC_CONFERENCE = 16384;
    public static final int HOLD = 1;
    public static final int MANAGE_CONFERENCE = 128;
    public static final int MERGE_CONFERENCE = 4;
    public static final int MUTE = 64;
    public static final int RESPOND_VIA_TEXT = 32;
    public static final int SEPARATE_FROM_CONFERENCE = 4096;
    public static final int SUPPORTS_VT_LOCAL = 256;
    public static final int SUPPORTS_VT_REMOTE = 512;
    public static final int SUPPORT_HOLD = 2;
    public static final int SWAP_CONFERENCE = 8;
    public static final int UNUSED = 16;
    public static final int VOICE_PRIVACY = 65536;
    public static final int VoLTE = 1024;
    public static final int VoWIFI = 2048;

    private PhoneCapabilities() {
    }

    public static boolean can(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int remove(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Capabilities:");
        if (can(i, 1)) {
            sb.append(" HOLD");
        }
        if (can(i, 2)) {
            sb.append(" SUPPORT_HOLD");
        }
        if (can(i, 4)) {
            sb.append(" MERGE_CONFERENCE");
        }
        if (can(i, 8)) {
            sb.append(" SWAP_CONFERENCE");
        }
        if (can(i, 32)) {
            sb.append(" RESPOND_VIA_TEXT");
        }
        if (can(i, 64)) {
            sb.append(" MUTE");
        }
        if (can(i, 128)) {
            sb.append(" MANAGE_CONFERENCE");
        }
        if (can(i, 256)) {
            sb.append(" SUPPORTS_VT_LOCAL");
        }
        if (can(i, 512)) {
            sb.append(" SUPPORTS_VT_REMOTE");
        }
        if (can(i, 1024)) {
            sb.append(" VoLTE");
        }
        if (can(i, 2048)) {
            sb.append(" VoWIFI");
        }
        if ((65536 & i) != 0) {
            sb.append(" VOICE_PRIVACY");
        }
        if ((131072 & i) != 0) {
            sb.append(" CALL_TYPE_MODIFIABLE");
        }
        if ((32768 & i) != 0) {
            sb.append(" ADD_PARTICIPANT");
        }
        if (can(i, 16384)) {
            sb.append(" GENERIC_CONFERENCE");
        }
        sb.append("]");
        return sb.toString();
    }
}
