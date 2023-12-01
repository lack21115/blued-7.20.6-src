package com.tencent.ugc;

import android.content.ContentResolver;
import android.os.Looper;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.UGCFrameQueue;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCMultiFileAudioFrameProvider.class */
public class UGCMultiFileAudioFrameProvider implements UGCAudioFrameProvider, UGCFrameQueue.UGCFrameQueueListener {
    private static final String TAG = "UGCMultiFileAudioFrameProvider";
    private final List<Clip> mClipList;
    private final UGCAudioFrameProvider[] mProviderList;
    private final com.tencent.liteav.base.util.b mSingleFileProviderHandler;
    private final UGCFrameQueue<List<AudioFrame>> mAudioFrameListQueue = new UGCFrameQueue<>();
    private final com.tencent.liteav.base.util.b mWorkHandler = new com.tencent.liteav.base.util.b(Looper.myLooper());

    public UGCMultiFileAudioFrameProvider(List<Clip> list, com.tencent.liteav.base.util.b bVar) {
        this.mProviderList = new UGCAudioFrameProvider[list.size()];
        this.mClipList = list;
        this.mSingleFileProviderHandler = bVar;
        this.mAudioFrameListQueue.setUGCFrameQueueListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$seekTo$2(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider, long j) {
        UGCAudioFrameProvider[] uGCAudioFrameProviderArr = uGCMultiFileAudioFrameProvider.mProviderList;
        int length = uGCAudioFrameProviderArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                uGCMultiFileAudioFrameProvider.mAudioFrameListQueue.clear();
                return;
            }
            UGCAudioFrameProvider uGCAudioFrameProvider = uGCAudioFrameProviderArr[i2];
            if (uGCAudioFrameProvider != null) {
                uGCAudioFrameProvider.seekTo(j);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$start$0(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= uGCMultiFileAudioFrameProvider.mClipList.size()) {
                uGCMultiFileAudioFrameProvider.readFrameToQueue();
                return;
            }
            UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider = new UGCSingleFileAudioFrameProvider(uGCMultiFileAudioFrameProvider.mClipList.get(i2), uGCMultiFileAudioFrameProvider.mSingleFileProviderHandler);
            uGCSingleFileAudioFrameProvider.initialize();
            uGCSingleFileAudioFrameProvider.start();
            uGCMultiFileAudioFrameProvider.mProviderList[i2] = uGCSingleFileAudioFrameProvider;
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$stop$1(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        int i = 0;
        while (true) {
            int i2 = i;
            UGCAudioFrameProvider[] uGCAudioFrameProviderArr = uGCMultiFileAudioFrameProvider.mProviderList;
            if (i2 >= uGCAudioFrameProviderArr.length) {
                uGCMultiFileAudioFrameProvider.mAudioFrameListQueue.clear();
                return;
            }
            if (uGCAudioFrameProviderArr[i2] != null) {
                uGCAudioFrameProviderArr[i2].stop();
                uGCMultiFileAudioFrameProvider.mProviderList[i2].uninitialize();
            }
            uGCMultiFileAudioFrameProvider.mProviderList[i2] = null;
            i = i2 + 1;
        }
    }

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public UGCFrameQueue<List<AudioFrame>> getFrameQueue() {
        return this.mAudioFrameListQueue;
    }

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public void initialize() {
        LiteavLog.i(TAG, ContentResolver.SYNC_EXTRAS_INITIALIZE);
    }

    @Override // com.tencent.ugc.UGCFrameQueue.UGCFrameQueueListener
    public void onFrameDequeued() {
        this.mWorkHandler.a(dz.a(this), 0);
    }

    public void readFrameToQueue() {
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        int i = 0;
        while (true) {
            int i2 = i;
            UGCAudioFrameProvider[] uGCAudioFrameProviderArr = this.mProviderList;
            if (i2 >= uGCAudioFrameProviderArr.length) {
                break;
            }
            UGCAudioFrameProvider uGCAudioFrameProvider = uGCAudioFrameProviderArr[i2];
            if (uGCAudioFrameProvider == null) {
                linkedList.add(new AudioFrame());
            } else {
                List<AudioFrame> dequeue = uGCAudioFrameProvider.getFrameQueue().dequeue();
                if (dequeue == UGCAudioFrameProvider.END_OF_STREAM) {
                    uGCAudioFrameProvider.stop();
                    uGCAudioFrameProvider.uninitialize();
                    this.mProviderList[i2] = null;
                    linkedList.add(new AudioFrame());
                } else {
                    linkedList.add(dequeue.get(0));
                    z = false;
                }
            }
            i = i2 + 1;
        }
        if (z) {
            this.mAudioFrameListQueue.queue(UGCAudioFrameProvider.END_OF_STREAM);
        } else {
            this.mAudioFrameListQueue.queue(linkedList);
        }
    }

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public void seekTo(long j) {
        this.mWorkHandler.a(dy.a(this, j), 0);
    }

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public void start() {
        this.mWorkHandler.a(dw.a(this), 0);
    }

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public void stop() {
        this.mWorkHandler.a(dx.a(this), 0);
    }

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public void uninitialize() {
        stop();
    }
}
