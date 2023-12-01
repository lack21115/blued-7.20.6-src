package android.hardware.camera2.legacy;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.legacy.RequestHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/BurstHolder.class */
public class BurstHolder {
    private static final String TAG = "BurstHolder";
    private final boolean mRepeating;
    private final ArrayList<RequestHolder.Builder> mRequestBuilders = new ArrayList<>();
    private final int mRequestId;

    public BurstHolder(int i, boolean z, List<CaptureRequest> list, Collection<Long> collection) {
        int i2 = 0;
        for (CaptureRequest captureRequest : list) {
            this.mRequestBuilders.add(new RequestHolder.Builder(i, i2, captureRequest, z, collection));
            i2++;
        }
        this.mRepeating = z;
        this.mRequestId = i;
    }

    public int getNumberOfRequests() {
        return this.mRequestBuilders.size();
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public boolean isRepeating() {
        return this.mRepeating;
    }

    public List<RequestHolder> produceRequestHolders(long j) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Iterator<RequestHolder.Builder> it = this.mRequestBuilders.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().build(i + j));
            i++;
        }
        return arrayList;
    }
}
