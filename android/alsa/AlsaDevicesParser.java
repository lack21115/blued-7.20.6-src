package android.alsa;

import android.provider.Downloads;
import android.util.Slog;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/* loaded from: source-9557208-dex2jar.jar:android/alsa/AlsaDevicesParser.class */
public class AlsaDevicesParser {
    private static final String TAG = "AlsaDevicesParser";
    private static final int kEndIndex_CardNum = 8;
    private static final int kEndIndex_DeviceNum = 11;
    private static final int kIndex_CardDeviceField = 5;
    private static final int kStartIndex_CardNum = 6;
    private static final int kStartIndex_DeviceNum = 9;
    private static final int kStartIndex_Type = 14;
    private static LineTokenizer mTokenizer = new LineTokenizer(" :[]-");
    private boolean mHasCaptureDevices = false;
    private boolean mHasPlaybackDevices = false;
    private boolean mHasMIDIDevices = false;
    private Vector<AlsaDeviceRecord> deviceRecords_ = new Vector<>();

    /* loaded from: source-9557208-dex2jar.jar:android/alsa/AlsaDevicesParser$AlsaDeviceRecord.class */
    public class AlsaDeviceRecord {
        public static final int kDeviceDir_Capture = 0;
        public static final int kDeviceDir_Playback = 1;
        public static final int kDeviceDir_Unknown = -1;
        public static final int kDeviceType_Audio = 0;
        public static final int kDeviceType_Control = 1;
        public static final int kDeviceType_MIDI = 2;
        public static final int kDeviceType_Unknown = -1;
        int mCardNum = -1;
        int mDeviceNum = -1;
        int mDeviceType = -1;
        int mDeviceDir = -1;

        public AlsaDeviceRecord() {
        }

        public boolean parse(String str) {
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                int nextToken = AlsaDevicesParser.mTokenizer.nextToken(str, i);
                if (nextToken == -1) {
                    return true;
                }
                int nextDelimiter = AlsaDevicesParser.mTokenizer.nextDelimiter(str, nextToken);
                i = nextDelimiter;
                if (nextDelimiter == -1) {
                    i = str.length();
                }
                String substring = str.substring(nextToken, i);
                int i4 = i3;
                switch (i3) {
                    case 0:
                        break;
                    case 1:
                        this.mCardNum = Integer.parseInt(substring);
                        i4 = i3;
                        if (str.charAt(i) == '-') {
                            break;
                        } else {
                            i4 = i3 + 1;
                            break;
                        }
                    case 2:
                        this.mDeviceNum = Integer.parseInt(substring);
                        i4 = i3;
                        break;
                    case 3:
                        i4 = i3;
                        if (!substring.equals("digital")) {
                            if (!substring.equals(Downloads.Impl.COLUMN_CONTROL)) {
                                i4 = i3;
                                if (!substring.equals(ShareConstants.DEXMODE_RAW)) {
                                    break;
                                } else {
                                    i4 = i3;
                                    break;
                                }
                            } else {
                                this.mDeviceType = 1;
                                i4 = i3;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 4:
                        if (!substring.equals("audio")) {
                            i4 = i3;
                            if (!substring.equals("midi")) {
                                break;
                            } else {
                                this.mDeviceType = 2;
                                AlsaDevicesParser.this.mHasMIDIDevices = true;
                                i4 = i3;
                                break;
                            }
                        } else {
                            this.mDeviceType = 0;
                            i4 = i3;
                            break;
                        }
                    case 5:
                        if (!substring.equals("capture")) {
                            i4 = i3;
                            if (!substring.equals("playback")) {
                                break;
                            } else {
                                this.mDeviceDir = 1;
                                AlsaDevicesParser.this.mHasPlaybackDevices = true;
                                i4 = i3;
                                break;
                            }
                        } else {
                            this.mDeviceDir = 0;
                            AlsaDevicesParser.this.mHasCaptureDevices = true;
                            i4 = i3;
                            break;
                        }
                    default:
                        i4 = i3;
                        break;
                }
                i2 = i4 + 1;
            }
        }

        public String textFormat() {
            StringBuilder sb = new StringBuilder();
            sb.append("[" + this.mCardNum + ":" + this.mDeviceNum + "]");
            switch (this.mDeviceType) {
                case -1:
                    sb.append(" N/A");
                    break;
                case 0:
                    sb.append(" Audio");
                    break;
                case 1:
                    sb.append(" Control");
                    break;
                case 2:
                    sb.append(" MIDI");
                    break;
            }
            switch (this.mDeviceDir) {
                case -1:
                    sb.append(" N/A");
                    break;
                case 0:
                    sb.append(" Capture");
                    break;
                case 1:
                    sb.append(" Playback");
                    break;
            }
            return sb.toString();
        }
    }

    private boolean isLineDeviceRecord(String str) {
        return str.charAt(5) == '[';
    }

    public void Log() {
        int numDeviceRecords = getNumDeviceRecords();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= numDeviceRecords) {
                return;
            }
            Slog.w(TAG, "usb:" + getDeviceRecordAt(i2).textFormat());
            i = i2 + 1;
        }
    }

    public AlsaDeviceRecord getDeviceRecordAt(int i) {
        return this.deviceRecords_.get(i);
    }

    public int getNumDeviceRecords() {
        return this.deviceRecords_.size();
    }

    public boolean hasCaptureDevices() {
        return this.mHasCaptureDevices;
    }

    public boolean hasCaptureDevices(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.deviceRecords_.size()) {
                return false;
            }
            AlsaDeviceRecord alsaDeviceRecord = this.deviceRecords_.get(i3);
            if (alsaDeviceRecord.mCardNum == i && alsaDeviceRecord.mDeviceType == 0 && alsaDeviceRecord.mDeviceDir == 0) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public boolean hasMIDIDevices() {
        return this.mHasMIDIDevices;
    }

    public boolean hasMIDIDevices(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.deviceRecords_.size()) {
                return false;
            }
            AlsaDeviceRecord alsaDeviceRecord = this.deviceRecords_.get(i3);
            if (alsaDeviceRecord.mCardNum == i && alsaDeviceRecord.mDeviceType == 2) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public boolean hasPlaybackDevices() {
        return this.mHasPlaybackDevices;
    }

    public boolean hasPlaybackDevices(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.deviceRecords_.size()) {
                return false;
            }
            AlsaDeviceRecord alsaDeviceRecord = this.deviceRecords_.get(i3);
            if (alsaDeviceRecord.mCardNum == i && alsaDeviceRecord.mDeviceType == 0 && alsaDeviceRecord.mDeviceDir == 1) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public void scan() {
        this.deviceRecords_.clear();
        try {
            FileReader fileReader = new FileReader(new File("/proc/asound/devices"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    fileReader.close();
                    return;
                } else if (isLineDeviceRecord(readLine)) {
                    AlsaDeviceRecord alsaDeviceRecord = new AlsaDeviceRecord();
                    alsaDeviceRecord.parse(readLine);
                    this.deviceRecords_.add(alsaDeviceRecord);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
