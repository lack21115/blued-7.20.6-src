package android.filterfw.core;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/CachedFrameManager.class */
public class CachedFrameManager extends SimpleFrameManager {
    private int mStorageCapacity = 25165824;
    private int mStorageSize = 0;
    private int mTimeStamp = 0;
    private SortedMap<Integer, Frame> mAvailableFrames = new TreeMap();

    private void dropOldestFrame() {
        int intValue = this.mAvailableFrames.firstKey().intValue();
        Frame frame = this.mAvailableFrames.get(Integer.valueOf(intValue));
        this.mStorageSize -= frame.getFormat().getSize();
        frame.releaseNativeAllocation();
        this.mAvailableFrames.remove(Integer.valueOf(intValue));
    }

    private Frame findAvailableFrame(FrameFormat frameFormat, int i, long j) {
        synchronized (this.mAvailableFrames) {
            for (Map.Entry<Integer, Frame> entry : this.mAvailableFrames.entrySet()) {
                Frame value = entry.getValue();
                if (value.getFormat().isReplaceableBy(frameFormat) && i == value.getBindingType() && (i == 0 || j == value.getBindingId())) {
                    super.retainFrame(value);
                    this.mAvailableFrames.remove(entry.getKey());
                    value.onFrameFetch();
                    value.reset(frameFormat);
                    this.mStorageSize -= frameFormat.getSize();
                    return value;
                }
            }
            return null;
        }
    }

    private boolean storeFrame(Frame frame) {
        synchronized (this.mAvailableFrames) {
            int size = frame.getFormat().getSize();
            if (size > this.mStorageCapacity) {
                return false;
            }
            int i = this.mStorageSize + size;
            while (i > this.mStorageCapacity) {
                dropOldestFrame();
                i = this.mStorageSize + size;
            }
            frame.onFrameStore();
            this.mStorageSize = i;
            this.mAvailableFrames.put(Integer.valueOf(this.mTimeStamp), frame);
            this.mTimeStamp++;
            return true;
        }
    }

    public void clearCache() {
        for (Frame frame : this.mAvailableFrames.values()) {
            frame.releaseNativeAllocation();
        }
        this.mAvailableFrames.clear();
    }

    @Override // android.filterfw.core.SimpleFrameManager, android.filterfw.core.FrameManager
    public Frame newBoundFrame(FrameFormat frameFormat, int i, long j) {
        Frame findAvailableFrame = findAvailableFrame(frameFormat, i, j);
        Frame frame = findAvailableFrame;
        if (findAvailableFrame == null) {
            frame = super.newBoundFrame(frameFormat, i, j);
        }
        frame.setTimestamp(-2L);
        return frame;
    }

    @Override // android.filterfw.core.SimpleFrameManager, android.filterfw.core.FrameManager
    public Frame newFrame(FrameFormat frameFormat) {
        Frame findAvailableFrame = findAvailableFrame(frameFormat, 0, 0L);
        Frame frame = findAvailableFrame;
        if (findAvailableFrame == null) {
            frame = super.newFrame(frameFormat);
        }
        frame.setTimestamp(-2L);
        return frame;
    }

    @Override // android.filterfw.core.SimpleFrameManager, android.filterfw.core.FrameManager
    public Frame releaseFrame(Frame frame) {
        if (!frame.isReusable()) {
            super.releaseFrame(frame);
            return frame;
        }
        int decRefCount = frame.decRefCount();
        if (decRefCount == 0 && frame.hasNativeAllocation()) {
            if (!storeFrame(frame)) {
                frame.releaseNativeAllocation();
            }
            frame = null;
        } else if (decRefCount < 0) {
            throw new RuntimeException("Frame reference count dropped below 0!");
        }
        return frame;
    }

    @Override // android.filterfw.core.SimpleFrameManager, android.filterfw.core.FrameManager
    public Frame retainFrame(Frame frame) {
        return super.retainFrame(frame);
    }

    @Override // android.filterfw.core.FrameManager
    public void tearDown() {
        clearCache();
    }
}
