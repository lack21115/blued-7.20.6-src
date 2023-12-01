package android.bluetooth.le;

import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/TruncatedFilter.class */
public final class TruncatedFilter {
    private final ScanFilter mFilter;
    private final List<ResultStorageDescriptor> mStorageDescriptors;

    public TruncatedFilter(ScanFilter scanFilter, List<ResultStorageDescriptor> list) {
        this.mFilter = scanFilter;
        this.mStorageDescriptors = list;
    }

    public ScanFilter getFilter() {
        return this.mFilter;
    }

    public List<ResultStorageDescriptor> getStorageDescriptors() {
        return this.mStorageDescriptors;
    }
}
