package android.hardware.hdmi;

import android.hardware.hdmi.HdmiRecordSources;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiTimerRecordSources.class */
public class HdmiTimerRecordSources {
    private static final int EXTERNAL_SOURCE_SPECIFIER_EXTERNAL_PHYSICAL_ADDRESS = 5;
    private static final int EXTERNAL_SOURCE_SPECIFIER_EXTERNAL_PLUG = 4;
    public static final int RECORDING_SEQUENCE_REPEAT_FRIDAY = 32;
    private static final int RECORDING_SEQUENCE_REPEAT_MASK = 127;
    public static final int RECORDING_SEQUENCE_REPEAT_MONDAY = 2;
    public static final int RECORDING_SEQUENCE_REPEAT_ONCE_ONLY = 0;
    public static final int RECORDING_SEQUENCE_REPEAT_SATUREDAY = 64;
    public static final int RECORDING_SEQUENCE_REPEAT_SUNDAY = 1;
    public static final int RECORDING_SEQUENCE_REPEAT_THURSDAY = 16;
    public static final int RECORDING_SEQUENCE_REPEAT_TUESDAY = 4;
    public static final int RECORDING_SEQUENCE_REPEAT_WEDNESDAY = 8;
    private static final String TAG = "HdmiTimerRecordingSources";

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiTimerRecordSources$Duration.class */
    public static final class Duration extends TimeUnit {
        private Duration(int i, int i2) {
            super(i, i2);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiTimerRecordSources$ExternalSourceDecorator.class */
    private static class ExternalSourceDecorator extends HdmiRecordSources.RecordSource {
        private final int mExternalSourceSpecifier;
        private final HdmiRecordSources.RecordSource mRecordSource;

        private ExternalSourceDecorator(HdmiRecordSources.RecordSource recordSource, int i) {
            super(recordSource.mSourceType, recordSource.getDataSize(false) + 1);
            this.mRecordSource = recordSource;
            this.mExternalSourceSpecifier = i;
        }

        @Override // android.hardware.hdmi.HdmiRecordSources.RecordSource
        int extraParamToByteArray(byte[] bArr, int i) {
            bArr[i] = (byte) this.mExternalSourceSpecifier;
            this.mRecordSource.toByteArray(false, bArr, i + 1);
            return getDataSize(false);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiTimerRecordSources$Time.class */
    public static final class Time extends TimeUnit {
        private Time(int i, int i2) {
            super(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiTimerRecordSources$TimeUnit.class */
    public static class TimeUnit {
        final int mHour;
        final int mMinute;

        TimeUnit(int i, int i2) {
            this.mHour = i;
            this.mMinute = i2;
        }

        static byte toBcdByte(int i) {
            return (byte) ((((i / 10) % 10) << 4) | (i % 10));
        }

        int toByteArray(byte[] bArr, int i) {
            bArr[i] = toBcdByte(this.mHour);
            bArr[i + 1] = toBcdByte(this.mMinute);
            return 2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiTimerRecordSources$TimerInfo.class */
    public static final class TimerInfo {
        private static final int BASIC_INFO_SIZE = 7;
        private static final int DAY_OF_MONTH_SIZE = 1;
        private static final int DURATION_SIZE = 2;
        private static final int MONTH_OF_YEAR_SIZE = 1;
        private static final int RECORDING_SEQUENCE_SIZE = 1;
        private static final int START_TIME_SIZE = 2;
        private final int mDayOfMonth;
        private final Duration mDuration;
        private final int mMonthOfYear;
        private final int mRecordingSequence;
        private final Time mStartTime;

        private TimerInfo(int i, int i2, Time time, Duration duration, int i3) {
            this.mDayOfMonth = i;
            this.mMonthOfYear = i2;
            this.mStartTime = time;
            this.mDuration = duration;
            this.mRecordingSequence = i3;
        }

        int getDataSize() {
            return 7;
        }

        int toByteArray(byte[] bArr, int i) {
            bArr[i] = (byte) this.mDayOfMonth;
            int i2 = i + 1;
            bArr[i2] = (byte) this.mMonthOfYear;
            int i3 = i2 + 1;
            int byteArray = i3 + this.mStartTime.toByteArray(bArr, i3);
            bArr[byteArray + this.mDuration.toByteArray(bArr, byteArray)] = (byte) this.mRecordingSequence;
            return getDataSize();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiTimerRecordSources$TimerRecordSource.class */
    public static final class TimerRecordSource {
        private final HdmiRecordSources.RecordSource mRecordSource;
        private final TimerInfo mTimerInfo;

        private TimerRecordSource(TimerInfo timerInfo, HdmiRecordSources.RecordSource recordSource) {
            this.mTimerInfo = timerInfo;
            this.mRecordSource = recordSource;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getDataSize() {
            return this.mTimerInfo.getDataSize() + this.mRecordSource.getDataSize(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int toByteArray(byte[] bArr, int i) {
            this.mRecordSource.toByteArray(false, bArr, i + this.mTimerInfo.toByteArray(bArr, i));
            return getDataSize();
        }
    }

    private HdmiTimerRecordSources() {
    }

    private static void checkDurationValue(int i, int i2) {
        if (i < 0 || i > 99) {
            throw new IllegalArgumentException("Hour should be in rage of [0, 99]:" + i);
        }
        if (i2 < 0 || i2 > 59) {
            throw new IllegalArgumentException("minute should be in rage of [0, 59]:" + i2);
        }
    }

    private static void checkTimeValue(int i, int i2) {
        if (i < 0 || i > 23) {
            throw new IllegalArgumentException("Hour should be in rage of [0, 23]:" + i);
        }
        if (i2 < 0 || i2 > 59) {
            throw new IllegalArgumentException("Minute should be in rage of [0, 59]:" + i2);
        }
    }

    public static boolean checkTimerRecordSource(int i, byte[] bArr) {
        boolean z = true;
        int length = bArr.length - 7;
        switch (i) {
            case 1:
                if (7 != length) {
                    return false;
                }
                break;
            case 2:
                if (4 != length) {
                    return false;
                }
                break;
            case 3:
                byte b = bArr[7];
                if (b == 4) {
                    if (2 != length) {
                        return false;
                    }
                } else if (b != 5 || 3 != length) {
                    return false;
                }
                break;
            default:
                z = false;
                break;
        }
        return z;
    }

    private static void checkTimerRecordSourceInputs(TimerInfo timerInfo, HdmiRecordSources.RecordSource recordSource) {
        if (timerInfo == null) {
            Log.w(TAG, "TimerInfo should not be null.");
            throw new IllegalArgumentException("TimerInfo should not be null.");
        } else if (recordSource == null) {
            Log.w(TAG, "source should not be null.");
            throw new IllegalArgumentException("source should not be null.");
        }
    }

    public static Duration durationOf(int i, int i2) {
        checkDurationValue(i, i2);
        return new Duration(i, i2);
    }

    public static TimerRecordSource ofAnalogueSource(TimerInfo timerInfo, HdmiRecordSources.AnalogueServiceSource analogueServiceSource) {
        checkTimerRecordSourceInputs(timerInfo, analogueServiceSource);
        return new TimerRecordSource(timerInfo, analogueServiceSource);
    }

    public static TimerRecordSource ofDigitalSource(TimerInfo timerInfo, HdmiRecordSources.DigitalServiceSource digitalServiceSource) {
        checkTimerRecordSourceInputs(timerInfo, digitalServiceSource);
        return new TimerRecordSource(timerInfo, digitalServiceSource);
    }

    public static TimerRecordSource ofExternalPhysicalAddress(TimerInfo timerInfo, HdmiRecordSources.ExternalPhysicalAddress externalPhysicalAddress) {
        checkTimerRecordSourceInputs(timerInfo, externalPhysicalAddress);
        return new TimerRecordSource(timerInfo, new ExternalSourceDecorator(externalPhysicalAddress, 5));
    }

    public static TimerRecordSource ofExternalPlug(TimerInfo timerInfo, HdmiRecordSources.ExternalPlugData externalPlugData) {
        checkTimerRecordSourceInputs(timerInfo, externalPlugData);
        return new TimerRecordSource(timerInfo, new ExternalSourceDecorator(externalPlugData, 4));
    }

    public static Time timeOf(int i, int i2) {
        checkTimeValue(i, i2);
        return new Time(i, i2);
    }

    public static TimerInfo timerInfoOf(int i, int i2, Time time, Duration duration, int i3) {
        if (i < 0 || i > 31) {
            throw new IllegalArgumentException("Day of month should be in range of [0, 31]:" + i);
        }
        if (i2 < 1 || i2 > 12) {
            throw new IllegalArgumentException("Month of year should be in range of [1, 12]:" + i2);
        }
        checkTimeValue(time.mHour, time.mMinute);
        checkDurationValue(duration.mHour, duration.mMinute);
        if (i3 == 0 || (i3 & (-128)) == 0) {
            return new TimerInfo(i, i2, time, duration, i3);
        }
        throw new IllegalArgumentException("Invalid reecording sequence value:" + i3);
    }
}
