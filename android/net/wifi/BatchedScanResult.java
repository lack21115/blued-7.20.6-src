package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/BatchedScanResult.class */
public class BatchedScanResult implements Parcelable {
    public static final Parcelable.Creator<BatchedScanResult> CREATOR = new Parcelable.Creator<BatchedScanResult>() { // from class: android.net.wifi.BatchedScanResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatchedScanResult createFromParcel(Parcel parcel) {
            boolean z = true;
            BatchedScanResult batchedScanResult = new BatchedScanResult();
            if (parcel.readInt() != 1) {
                z = false;
            }
            batchedScanResult.truncated = z;
            int readInt = parcel.readInt();
            while (true) {
                int i = readInt;
                if (i <= 0) {
                    return batchedScanResult;
                }
                batchedScanResult.scanResults.add(ScanResult.CREATOR.createFromParcel(parcel));
                readInt = i - 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatchedScanResult[] newArray(int i) {
            return new BatchedScanResult[i];
        }
    };
    private static final String TAG = "BatchedScanResult";
    public final List<ScanResult> scanResults = new ArrayList();
    public boolean truncated;

    public BatchedScanResult() {
    }

    public BatchedScanResult(BatchedScanResult batchedScanResult) {
        this.truncated = batchedScanResult.truncated;
        for (ScanResult scanResult : batchedScanResult.scanResults) {
            this.scanResults.add(new ScanResult(scanResult));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BatchedScanResult: ").append("truncated: ").append(String.valueOf(this.truncated)).append("scanResults: [");
        for (ScanResult scanResult : this.scanResults) {
            stringBuffer.append(" <").append(scanResult.toString()).append("> ");
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.truncated ? 1 : 0);
        parcel.writeInt(this.scanResults.size());
        for (ScanResult scanResult : this.scanResults) {
            scanResult.writeToParcel(parcel, i);
        }
    }
}
