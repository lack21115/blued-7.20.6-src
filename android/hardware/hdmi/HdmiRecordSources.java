package android.hardware.hdmi;

import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources.class */
public final class HdmiRecordSources {
    public static final int ANALOGUE_BROADCAST_TYPE_CABLE = 0;
    public static final int ANALOGUE_BROADCAST_TYPE_SATELLITE = 1;
    public static final int ANALOGUE_BROADCAST_TYPE_TERRESTRIAL = 2;
    public static final int BROADCAST_SYSTEM_NTSC_M = 3;
    public static final int BROADCAST_SYSTEM_PAL_BG = 0;
    public static final int BROADCAST_SYSTEM_PAL_DK = 8;
    public static final int BROADCAST_SYSTEM_PAL_I = 4;
    public static final int BROADCAST_SYSTEM_PAL_M = 2;
    public static final int BROADCAST_SYSTEM_PAL_OTHER_SYSTEM = 31;
    public static final int BROADCAST_SYSTEM_SECAM_BG = 6;
    public static final int BROADCAST_SYSTEM_SECAM_DK = 5;
    public static final int BROADCAST_SYSTEM_SECAM_L = 7;
    public static final int BROADCAST_SYSTEM_SECAM_LP = 1;
    private static final int CHANNEL_NUMBER_FORMAT_1_PART = 1;
    private static final int CHANNEL_NUMBER_FORMAT_2_PART = 2;
    public static final int DIGITAL_BROADCAST_TYPE_ARIB = 0;
    public static final int DIGITAL_BROADCAST_TYPE_ARIB_BS = 8;
    public static final int DIGITAL_BROADCAST_TYPE_ARIB_CS = 9;
    public static final int DIGITAL_BROADCAST_TYPE_ARIB_T = 10;
    public static final int DIGITAL_BROADCAST_TYPE_ATSC = 1;
    public static final int DIGITAL_BROADCAST_TYPE_ATSC_CABLE = 16;
    public static final int DIGITAL_BROADCAST_TYPE_ATSC_SATELLITE = 17;
    public static final int DIGITAL_BROADCAST_TYPE_ATSC_TERRESTRIAL = 18;
    public static final int DIGITAL_BROADCAST_TYPE_DVB = 2;
    public static final int DIGITAL_BROADCAST_TYPE_DVB_C = 24;
    public static final int DIGITAL_BROADCAST_TYPE_DVB_S = 25;
    public static final int DIGITAL_BROADCAST_TYPE_DVB_S2 = 26;
    public static final int DIGITAL_BROADCAST_TYPE_DVB_T = 27;
    private static final int RECORD_SOURCE_TYPE_ANALOGUE_SERVICE = 3;
    private static final int RECORD_SOURCE_TYPE_DIGITAL_SERVICE = 2;
    private static final int RECORD_SOURCE_TYPE_EXTERNAL_PHYSICAL_ADDRESS = 5;
    private static final int RECORD_SOURCE_TYPE_EXTERNAL_PLUG = 4;
    private static final int RECORD_SOURCE_TYPE_OWN_SOURCE = 1;
    private static final String TAG = "HdmiRecordSources";

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$AnalogueServiceSource.class */
    public static final class AnalogueServiceSource extends RecordSource {
        static final int EXTRA_DATA_SIZE = 4;
        private final int mBroadcastSystem;
        private final int mBroadcastType;
        private final int mFrequency;

        private AnalogueServiceSource(int i, int i2, int i3) {
            super(3, 4);
            this.mBroadcastType = i;
            this.mFrequency = i2;
            this.mBroadcastSystem = i3;
        }

        @Override // android.hardware.hdmi.HdmiRecordSources.RecordSource
        int extraParamToByteArray(byte[] bArr, int i) {
            bArr[i] = (byte) this.mBroadcastType;
            HdmiRecordSources.shortToByteArray((short) this.mFrequency, bArr, i + 1);
            bArr[i + 3] = (byte) this.mBroadcastSystem;
            return 4;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$AribData.class */
    public static final class AribData implements DigitalServiceIdentification {
        private final int mOriginalNetworkId;
        private final int mServiceId;
        private final int mTransportStreamId;

        public AribData(int i, int i2, int i3) {
            this.mTransportStreamId = i;
            this.mServiceId = i2;
            this.mOriginalNetworkId = i3;
        }

        @Override // android.hardware.hdmi.HdmiRecordSources.DigitalServiceIdentification
        public int toByteArray(byte[] bArr, int i) {
            return HdmiRecordSources.threeFieldsToSixBytes(this.mTransportStreamId, this.mServiceId, this.mOriginalNetworkId, bArr, i);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$AtscData.class */
    public static final class AtscData implements DigitalServiceIdentification {
        private final int mProgramNumber;
        private final int mTransportStreamId;

        public AtscData(int i, int i2) {
            this.mTransportStreamId = i;
            this.mProgramNumber = i2;
        }

        @Override // android.hardware.hdmi.HdmiRecordSources.DigitalServiceIdentification
        public int toByteArray(byte[] bArr, int i) {
            return HdmiRecordSources.threeFieldsToSixBytes(this.mTransportStreamId, this.mProgramNumber, 0, bArr, i);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$ChannelIdentifier.class */
    private static final class ChannelIdentifier {
        private final int mChannelNumberFormat;
        private final int mMajorChannelNumber;
        private final int mMinorChannelNumber;

        private ChannelIdentifier(int i, int i2, int i3) {
            this.mChannelNumberFormat = i;
            this.mMajorChannelNumber = i2;
            this.mMinorChannelNumber = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int toByteArray(byte[] bArr, int i) {
            bArr[i] = (byte) ((this.mChannelNumberFormat << 2) | ((this.mMajorChannelNumber >>> 8) & 3));
            bArr[i + 1] = (byte) (this.mMajorChannelNumber & 255);
            HdmiRecordSources.shortToByteArray((short) this.mMinorChannelNumber, bArr, i + 2);
            return 4;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$DigitalChannelData.class */
    public static final class DigitalChannelData implements DigitalServiceIdentification {
        private final ChannelIdentifier mChannelIdentifier;

        private DigitalChannelData(ChannelIdentifier channelIdentifier) {
            this.mChannelIdentifier = channelIdentifier;
        }

        public static DigitalChannelData ofOneNumber(int i) {
            return new DigitalChannelData(new ChannelIdentifier(1, 0, i));
        }

        public static DigitalChannelData ofTwoNumbers(int i, int i2) {
            return new DigitalChannelData(new ChannelIdentifier(2, i, i2));
        }

        @Override // android.hardware.hdmi.HdmiRecordSources.DigitalServiceIdentification
        public int toByteArray(byte[] bArr, int i) {
            this.mChannelIdentifier.toByteArray(bArr, i);
            bArr[i + 4] = 0;
            bArr[i + 5] = 0;
            return 6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$DigitalServiceIdentification.class */
    public interface DigitalServiceIdentification {
        int toByteArray(byte[] bArr, int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$DigitalServiceSource.class */
    public static final class DigitalServiceSource extends RecordSource {
        private static final int DIGITAL_SERVICE_IDENTIFIED_BY_CHANNEL = 1;
        private static final int DIGITAL_SERVICE_IDENTIFIED_BY_DIGITAL_ID = 0;
        static final int EXTRA_DATA_SIZE = 7;
        private final int mBroadcastSystem;
        private final DigitalServiceIdentification mIdentification;
        private final int mIdentificationMethod;

        private DigitalServiceSource(int i, int i2, DigitalServiceIdentification digitalServiceIdentification) {
            super(2, 7);
            this.mIdentificationMethod = i;
            this.mBroadcastSystem = i2;
            this.mIdentification = digitalServiceIdentification;
        }

        @Override // android.hardware.hdmi.HdmiRecordSources.RecordSource
        int extraParamToByteArray(byte[] bArr, int i) {
            bArr[i] = (byte) ((this.mIdentificationMethod << 7) | (this.mBroadcastSystem & 127));
            this.mIdentification.toByteArray(bArr, i + 1);
            return 7;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$DvbData.class */
    public static final class DvbData implements DigitalServiceIdentification {
        private final int mOriginalNetworkId;
        private final int mServiceId;
        private final int mTransportStreamId;

        public DvbData(int i, int i2, int i3) {
            this.mTransportStreamId = i;
            this.mServiceId = i2;
            this.mOriginalNetworkId = i3;
        }

        @Override // android.hardware.hdmi.HdmiRecordSources.DigitalServiceIdentification
        public int toByteArray(byte[] bArr, int i) {
            return HdmiRecordSources.threeFieldsToSixBytes(this.mTransportStreamId, this.mServiceId, this.mOriginalNetworkId, bArr, i);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$ExternalPhysicalAddress.class */
    public static final class ExternalPhysicalAddress extends RecordSource {
        static final int EXTRA_DATA_SIZE = 2;
        private final int mPhysicalAddress;

        private ExternalPhysicalAddress(int i) {
            super(5, 2);
            this.mPhysicalAddress = i;
        }

        @Override // android.hardware.hdmi.HdmiRecordSources.RecordSource
        int extraParamToByteArray(byte[] bArr, int i) {
            HdmiRecordSources.shortToByteArray((short) this.mPhysicalAddress, bArr, i);
            return 2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$ExternalPlugData.class */
    public static final class ExternalPlugData extends RecordSource {
        static final int EXTRA_DATA_SIZE = 1;
        private final int mPlugNumber;

        private ExternalPlugData(int i) {
            super(4, 1);
            this.mPlugNumber = i;
        }

        @Override // android.hardware.hdmi.HdmiRecordSources.RecordSource
        int extraParamToByteArray(byte[] bArr, int i) {
            bArr[i] = (byte) this.mPlugNumber;
            return 1;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$OwnSource.class */
    public static final class OwnSource extends RecordSource {
        private static final int EXTRA_DATA_SIZE = 0;

        private OwnSource() {
            super(1, 0);
        }

        @Override // android.hardware.hdmi.HdmiRecordSources.RecordSource
        int extraParamToByteArray(byte[] bArr, int i) {
            return 0;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiRecordSources$RecordSource.class */
    public static abstract class RecordSource {
        final int mExtraDataSize;
        final int mSourceType;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RecordSource(int i, int i2) {
            this.mSourceType = i;
            this.mExtraDataSize = i2;
        }

        abstract int extraParamToByteArray(byte[] bArr, int i);

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int getDataSize(boolean z) {
            return z ? this.mExtraDataSize + 1 : this.mExtraDataSize;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int toByteArray(boolean z, byte[] bArr, int i) {
            int i2 = i;
            if (z) {
                bArr[i] = (byte) this.mSourceType;
                i2 = i + 1;
            }
            extraParamToByteArray(bArr, i2);
            return getDataSize(z);
        }
    }

    private HdmiRecordSources() {
    }

    public static boolean checkRecordSource(byte[] bArr) {
        boolean z = true;
        if (bArr == null || bArr.length == 0) {
            z = false;
        } else {
            byte b = bArr[0];
            int length = bArr.length - 1;
            switch (b) {
                case 1:
                    if (length != 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (length != 7) {
                        return false;
                    }
                    break;
                case 3:
                    if (length != 4) {
                        return false;
                    }
                    break;
                case 4:
                    if (length != 1) {
                        return false;
                    }
                    break;
                case 5:
                    if (length != 2) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return z;
    }

    public static AnalogueServiceSource ofAnalogue(int i, int i2, int i3) {
        if (i < 0 || i > 2) {
            Log.w(TAG, "Invalid Broadcast type:" + i);
            throw new IllegalArgumentException("Invalid Broadcast type:" + i);
        } else if (i2 < 0 || i2 > 65535) {
            Log.w(TAG, "Invalid frequency value[0x0000-0xFFFF]:" + i2);
            throw new IllegalArgumentException("Invalid frequency value[0x0000-0xFFFF]:" + i2);
        } else if (i3 < 0 || i3 > 31) {
            Log.w(TAG, "Invalid Broadcast system:" + i3);
            throw new IllegalArgumentException("Invalid Broadcast system:" + i3);
        } else {
            return new AnalogueServiceSource(i, i2, i3);
        }
    }

    public static DigitalServiceSource ofArib(int i, AribData aribData) {
        if (aribData == null) {
            throw new IllegalArgumentException("data should not be null.");
        }
        switch (i) {
            case 0:
            case 8:
            case 9:
            case 10:
                return new DigitalServiceSource(0, i, aribData);
            default:
                Log.w(TAG, "Invalid ARIB type:" + i);
                throw new IllegalArgumentException("type should not be null.");
        }
    }

    public static DigitalServiceSource ofAtsc(int i, AtscData atscData) {
        if (atscData == null) {
            throw new IllegalArgumentException("data should not be null.");
        }
        switch (i) {
            case 1:
            case 16:
            case 17:
            case 18:
                return new DigitalServiceSource(0, i, atscData);
            default:
                Log.w(TAG, "Invalid ATSC type:" + i);
                throw new IllegalArgumentException("Invalid ATSC type:" + i);
        }
    }

    public static DigitalServiceSource ofDigitalChannelId(int i, DigitalChannelData digitalChannelData) {
        if (digitalChannelData == null) {
            throw new IllegalArgumentException("data should not be null.");
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 8:
            case 9:
            case 10:
            case 16:
            case 17:
            case 18:
            case 24:
            case 25:
            case 26:
            case 27:
                return new DigitalServiceSource(1, i, digitalChannelData);
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            default:
                Log.w(TAG, "Invalid broadcast type:" + i);
                throw new IllegalArgumentException("Invalid broadcast system value:" + i);
        }
    }

    public static DigitalServiceSource ofDvb(int i, DvbData dvbData) {
        if (dvbData == null) {
            throw new IllegalArgumentException("data should not be null.");
        }
        switch (i) {
            case 2:
            case 24:
            case 25:
            case 26:
            case 27:
                return new DigitalServiceSource(0, i, dvbData);
            default:
                Log.w(TAG, "Invalid DVB type:" + i);
                throw new IllegalArgumentException("Invalid DVB type:" + i);
        }
    }

    public static ExternalPhysicalAddress ofExternalPhysicalAddress(int i) {
        if (((-65536) & i) != 0) {
            Log.w(TAG, "Invalid physical address:" + i);
            throw new IllegalArgumentException("Invalid physical address:" + i);
        }
        return new ExternalPhysicalAddress(i);
    }

    public static ExternalPlugData ofExternalPlug(int i) {
        if (i < 1 || i > 255) {
            Log.w(TAG, "Invalid plug number[1-255]" + i);
            throw new IllegalArgumentException("Invalid plug number[1-255]" + i);
        }
        return new ExternalPlugData(i);
    }

    public static OwnSource ofOwnSource() {
        return new OwnSource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int shortToByteArray(short s, byte[] bArr, int i) {
        bArr[i] = (byte) ((s >>> 8) & 255);
        bArr[i + 1] = (byte) (s & 255);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int threeFieldsToSixBytes(int i, int i2, int i3, byte[] bArr, int i4) {
        shortToByteArray((short) i, bArr, i4);
        shortToByteArray((short) i2, bArr, i4 + 2);
        shortToByteArray((short) i3, bArr, i4 + 4);
        return 6;
    }
}
