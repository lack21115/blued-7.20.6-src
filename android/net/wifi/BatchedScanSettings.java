package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.codec.language.bm.Rule;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/BatchedScanSettings.class */
public class BatchedScanSettings implements Parcelable {
    public static final Parcelable.Creator<BatchedScanSettings> CREATOR = new Parcelable.Creator<BatchedScanSettings>() { // from class: android.net.wifi.BatchedScanSettings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatchedScanSettings createFromParcel(Parcel parcel) {
            BatchedScanSettings batchedScanSettings = new BatchedScanSettings();
            batchedScanSettings.maxScansPerBatch = parcel.readInt();
            batchedScanSettings.maxApPerScan = parcel.readInt();
            batchedScanSettings.scanIntervalSec = parcel.readInt();
            batchedScanSettings.maxApForDistance = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                batchedScanSettings.channelSet = new ArrayList(readInt);
                while (readInt > 0) {
                    batchedScanSettings.channelSet.add(parcel.readString());
                    readInt--;
                }
            }
            return batchedScanSettings;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatchedScanSettings[] newArray(int i) {
            return new BatchedScanSettings[i];
        }
    };
    public static final int DEFAULT_AP_FOR_DISTANCE = 0;
    public static final int DEFAULT_AP_PER_SCAN = 16;
    public static final int DEFAULT_INTERVAL_SEC = 30;
    public static final int DEFAULT_SCANS_PER_BATCH = 20;
    public static final int MAX_AP_FOR_DISTANCE = 16;
    public static final int MAX_AP_PER_SCAN = 16;
    public static final int MAX_INTERVAL_SEC = 500;
    public static final int MAX_SCANS_PER_BATCH = 20;
    public static final int MAX_WIFI_CHANNEL = 196;
    public static final int MIN_AP_FOR_DISTANCE = 0;
    public static final int MIN_AP_PER_SCAN = 2;
    public static final int MIN_INTERVAL_SEC = 10;
    public static final int MIN_SCANS_PER_BATCH = 2;
    private static final String TAG = "BatchedScanSettings";
    public static final int UNSPECIFIED = Integer.MAX_VALUE;
    public Collection<String> channelSet;
    public int maxApForDistance;
    public int maxApPerScan;
    public int maxScansPerBatch;
    public int scanIntervalSec;

    public BatchedScanSettings() {
        clear();
    }

    public BatchedScanSettings(BatchedScanSettings batchedScanSettings) {
        this.maxScansPerBatch = batchedScanSettings.maxScansPerBatch;
        this.maxApPerScan = batchedScanSettings.maxApPerScan;
        if (batchedScanSettings.channelSet != null) {
            this.channelSet = new ArrayList(batchedScanSettings.channelSet);
        }
        this.scanIntervalSec = batchedScanSettings.scanIntervalSec;
        this.maxApForDistance = batchedScanSettings.maxApForDistance;
    }

    private boolean channelSetIsValid() {
        int parseInt;
        if (this.channelSet == null || this.channelSet.isEmpty()) {
            return true;
        }
        for (String str : this.channelSet) {
            try {
                parseInt = Integer.parseInt(str);
            } catch (NumberFormatException e) {
            }
            if (parseInt > 0 && parseInt <= 196) {
            }
            if (!str.equals("A") && !str.equals("B")) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        this.maxScansPerBatch = Integer.MAX_VALUE;
        this.maxApPerScan = Integer.MAX_VALUE;
        this.channelSet = null;
        this.scanIntervalSec = Integer.MAX_VALUE;
        this.maxApForDistance = Integer.MAX_VALUE;
    }

    public void constrain() {
        if (this.scanIntervalSec == Integer.MAX_VALUE) {
            this.scanIntervalSec = 30;
        } else if (this.scanIntervalSec < 10) {
            this.scanIntervalSec = 10;
        } else if (this.scanIntervalSec > 500) {
            this.scanIntervalSec = 500;
        }
        if (this.maxScansPerBatch == Integer.MAX_VALUE) {
            this.maxScansPerBatch = 20;
        } else if (this.maxScansPerBatch < 2) {
            this.maxScansPerBatch = 2;
        } else if (this.maxScansPerBatch > 20) {
            this.maxScansPerBatch = 20;
        }
        if (this.maxApPerScan == Integer.MAX_VALUE) {
            this.maxApPerScan = 16;
        } else if (this.maxApPerScan < 2) {
            this.maxApPerScan = 2;
        } else if (this.maxApPerScan > 16) {
            this.maxApPerScan = 16;
        }
        if (this.maxApForDistance == Integer.MAX_VALUE) {
            this.maxApForDistance = 0;
        } else if (this.maxApForDistance < 0) {
            this.maxApForDistance = 0;
        } else if (this.maxApForDistance > 16) {
            this.maxApForDistance = 16;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BatchedScanSettings) {
            BatchedScanSettings batchedScanSettings = (BatchedScanSettings) obj;
            if (this.maxScansPerBatch == batchedScanSettings.maxScansPerBatch && this.maxApPerScan == batchedScanSettings.maxApPerScan && this.scanIntervalSec == batchedScanSettings.scanIntervalSec && this.maxApForDistance == batchedScanSettings.maxApForDistance) {
                return this.channelSet == null ? batchedScanSettings.channelSet == null : this.channelSet.equals(batchedScanSettings.channelSet);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return this.maxScansPerBatch + (this.maxApPerScan * 3) + (this.scanIntervalSec * 5) + (this.maxApForDistance * 7) + (this.channelSet.hashCode() * 11);
    }

    public boolean isInvalid() {
        if (this.maxScansPerBatch == Integer.MAX_VALUE || (this.maxScansPerBatch >= 2 && this.maxScansPerBatch <= 20)) {
            if ((this.maxApPerScan == Integer.MAX_VALUE || (this.maxApPerScan >= 2 && this.maxApPerScan <= 16)) && channelSetIsValid()) {
                if (this.scanIntervalSec == Integer.MAX_VALUE || (this.scanIntervalSec >= 10 && this.scanIntervalSec <= 500)) {
                    if (this.maxApForDistance != Integer.MAX_VALUE) {
                        return this.maxApForDistance < 0 || this.maxApForDistance > 16;
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BatchScanSettings [maxScansPerBatch: ").append(this.maxScansPerBatch == Integer.MAX_VALUE ? "<none>" : Integer.valueOf(this.maxScansPerBatch)).append(", maxApPerScan: ").append(this.maxApPerScan == Integer.MAX_VALUE ? "<none>" : Integer.valueOf(this.maxApPerScan)).append(", scanIntervalSec: ").append(this.scanIntervalSec == Integer.MAX_VALUE ? "<none>" : Integer.valueOf(this.scanIntervalSec)).append(", maxApForDistance: ").append(this.maxApForDistance == Integer.MAX_VALUE ? "<none>" : Integer.valueOf(this.maxApForDistance)).append(", channelSet: ");
        if (this.channelSet == null) {
            stringBuffer.append(Rule.ALL);
        } else {
            stringBuffer.append(SimpleComparison.LESS_THAN_OPERATION);
            Iterator<String> it = this.channelSet.iterator();
            while (it.hasNext()) {
                stringBuffer.append(" " + it.next());
            }
            stringBuffer.append(SimpleComparison.GREATER_THAN_OPERATION);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.maxScansPerBatch);
        parcel.writeInt(this.maxApPerScan);
        parcel.writeInt(this.scanIntervalSec);
        parcel.writeInt(this.maxApForDistance);
        parcel.writeInt(this.channelSet == null ? 0 : this.channelSet.size());
        if (this.channelSet != null) {
            for (String str : this.channelSet) {
                parcel.writeString(str);
            }
        }
    }
}
