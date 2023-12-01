package com.tencent.ugc;

import android.content.ContentResolver;
import android.os.Looper;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.ugc.UGCFrameQueue;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCMultiFilePixelFrameProvider.class */
public class UGCMultiFilePixelFrameProvider implements UGCFrameQueue.UGCFrameQueueListener, UGCPixelFrameProvider {
    private static final String TAG = "UGCMultiFileVideoFrameProvider";
    private int mClipIndexOfMaxFps;
    private final List<Clip> mClipList;
    private final PixelFrame[] mPixelFrameStash;
    private final UGCPixelFrameProvider[] mProviderList;
    private final com.tencent.liteav.base.util.b mSingleFileProviderHandler;
    private long mCurrentTimestamp = 0;
    private long mFrameDuration = 0;
    private final UGCFrameQueue<List<PixelFrame>> mPixelFrameListQueue = new UGCFrameQueue<>();
    private final com.tencent.liteav.base.util.b mWorkHandler = new com.tencent.liteav.base.util.b(Looper.myLooper());

    public UGCMultiFilePixelFrameProvider(List<Clip> list, com.tencent.liteav.base.util.b bVar) {
        this.mProviderList = new UGCPixelFrameProvider[list.size()];
        this.mPixelFrameStash = new PixelFrame[list.size()];
        this.mClipList = list;
        this.mSingleFileProviderHandler = bVar;
        this.mPixelFrameListQueue.setUGCFrameQueueListener(this);
    }

    private void clearFrameCache() {
        int i = 0;
        while (true) {
            int i2 = i;
            PixelFrame[] pixelFrameArr = this.mPixelFrameStash;
            if (i2 >= pixelFrameArr.length) {
                return;
            }
            if (pixelFrameArr[i2] != null) {
                pixelFrameArr[i2].release();
                this.mPixelFrameStash[i2] = null;
            }
            i = i2 + 1;
        }
    }

    private void clearFrameQueue() {
        for (List<PixelFrame> list : this.mPixelFrameListQueue.dequeueAll()) {
            PixelFrame.releasePixelFrames(list);
        }
    }

    private PixelFrame copyPixelFrame(PixelFrame pixelFrame) {
        if (pixelFrame instanceof e.b) {
            e.b bVar = (e.b) pixelFrame;
            return bVar.f36634a.a(bVar.getGLContext());
        }
        return null;
    }

    private void getCurrentTimestampWithFpsInfo() {
        float f = -1.0f;
        int i = 0;
        while (i < this.mClipList.size()) {
            float f2 = f;
            if (f < this.mClipList.get(i).fps) {
                f2 = f;
                if (this.mProviderList[i] != null) {
                    f2 = this.mClipList.get(i).fps;
                    this.mClipIndexOfMaxFps = i;
                }
            }
            i++;
            f = f2;
        }
        long j = f > 0.0f ? 1000.0f / f : 40.0f;
        this.mFrameDuration = j;
        this.mCurrentTimestamp += j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$seekTo$2(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider, long j, boolean z) {
        UGCPixelFrameProvider[] uGCPixelFrameProviderArr = uGCMultiFilePixelFrameProvider.mProviderList;
        int length = uGCPixelFrameProviderArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                uGCMultiFilePixelFrameProvider.mCurrentTimestamp = j;
                uGCMultiFilePixelFrameProvider.clearFrameCache();
                uGCMultiFilePixelFrameProvider.clearFrameQueue();
                return;
            }
            UGCPixelFrameProvider uGCPixelFrameProvider = uGCPixelFrameProviderArr[i2];
            if (uGCPixelFrameProvider != null) {
                uGCPixelFrameProvider.seekTo(j, z);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$start$0(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= uGCMultiFilePixelFrameProvider.mClipList.size()) {
                uGCMultiFilePixelFrameProvider.readFrameToQueue();
                return;
            }
            UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider = new UGCSingleFilePixelFrameProvider(uGCMultiFilePixelFrameProvider.mClipList.get(i2), uGCMultiFilePixelFrameProvider.mSingleFileProviderHandler);
            uGCSingleFilePixelFrameProvider.initialize();
            uGCSingleFilePixelFrameProvider.start();
            uGCMultiFilePixelFrameProvider.mProviderList[i2] = uGCSingleFilePixelFrameProvider;
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$stop$1(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        int i = 0;
        while (true) {
            int i2 = i;
            UGCPixelFrameProvider[] uGCPixelFrameProviderArr = uGCMultiFilePixelFrameProvider.mProviderList;
            if (i2 >= uGCPixelFrameProviderArr.length) {
                uGCMultiFilePixelFrameProvider.clearFrameCache();
                uGCMultiFilePixelFrameProvider.clearFrameQueue();
                return;
            }
            if (uGCPixelFrameProviderArr[i2] != null) {
                uGCPixelFrameProviderArr[i2].stop();
                uGCMultiFilePixelFrameProvider.mProviderList[i2].uninitialize();
            }
            uGCMultiFilePixelFrameProvider.mProviderList[i2] = null;
            i = i2 + 1;
        }
    }

    private void putOneFrameToList(PixelFrame pixelFrame, List<PixelFrame> list) {
        if (pixelFrame == null) {
            return;
        }
        if (pixelFrame.getTimestamp() == this.mCurrentTimestamp) {
            list.add(pixelFrame);
            pixelFrame.retain();
            return;
        }
        PixelFrame copyPixelFrame = copyPixelFrame(pixelFrame);
        if (copyPixelFrame != null) {
            copyPixelFrame.setTimestamp(this.mCurrentTimestamp);
            pixelFrame = copyPixelFrame;
        } else {
            pixelFrame.retain();
        }
        list.add(pixelFrame);
    }

    private void readFrameToCache() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mProviderList.length) {
                return;
            }
            PixelFrame pixelFrame = this.mPixelFrameStash[i2];
            if (pixelFrame != null) {
                if (this.mCurrentTimestamp - pixelFrame.getTimestamp() > this.mFrameDuration / 2) {
                    pixelFrame.release();
                    this.mPixelFrameStash[i2] = null;
                } else {
                    i = i2 + 1;
                }
            }
            UGCPixelFrameProvider uGCPixelFrameProvider = this.mProviderList[i2];
            if (uGCPixelFrameProvider != null) {
                List<PixelFrame> dequeue = uGCPixelFrameProvider.getFrameQueue().dequeue();
                if (dequeue == UGCPixelFrameProvider.END_OF_STREAM) {
                    uGCPixelFrameProvider.stop();
                    uGCPixelFrameProvider.uninitialize();
                    this.mProviderList[i2] = null;
                } else {
                    this.mPixelFrameStash[i2] = dequeue.get(0);
                    if (this.mClipIndexOfMaxFps == i2) {
                        this.mCurrentTimestamp = this.mPixelFrameStash[i2].getTimestamp();
                    }
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readFrameToQueue() {
        getCurrentTimestampWithFpsInfo();
        readFrameToCache();
        LinkedList linkedList = new LinkedList();
        PixelFrame[] pixelFrameArr = this.mPixelFrameStash;
        int length = pixelFrameArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            putOneFrameToList(pixelFrameArr[i2], linkedList);
            i = i2 + 1;
        }
        if (linkedList.size() == this.mClipList.size()) {
            this.mPixelFrameListQueue.queue(linkedList);
            return;
        }
        this.mPixelFrameListQueue.queue(UGCPixelFrameProvider.END_OF_STREAM);
        PixelFrame.releasePixelFrames(linkedList);
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public UGCFrameQueue<List<PixelFrame>> getFrameQueue() {
        return this.mPixelFrameListQueue;
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void initialize() {
        LiteavLog.i(TAG, ContentResolver.SYNC_EXTRAS_INITIALIZE);
    }

    @Override // com.tencent.ugc.UGCFrameQueue.UGCFrameQueueListener
    public void onFrameDequeued() {
        this.mWorkHandler.a(ed.a(this), 0);
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void seekTo(long j, boolean z) {
        this.mWorkHandler.a(ec.a(this, j, z), 0);
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void setReverse(boolean z) {
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void start() {
        this.mWorkHandler.a(ea.a(this), 0);
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void stop() {
        this.mWorkHandler.a(eb.a(this), 0);
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void uninitialize() {
        stop();
    }
}
