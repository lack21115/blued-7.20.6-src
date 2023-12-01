package android.speech.tts;

import android.speech.tts.TextToSpeechService;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/SynthesisPlaybackQueueItem.class */
public final class SynthesisPlaybackQueueItem extends PlaybackQueueItem {
    private static final boolean DBG = false;
    private static final long MAX_UNCONSUMED_AUDIO_MS = 500;
    private static final String TAG = "TTS.SynthQueueItem";
    private final BlockingAudioTrack mAudioTrack;
    private final LinkedList<ListEntry> mDataBufferList;
    private volatile boolean mDone;
    private final Lock mListLock;
    private final AbstractEventLogger mLogger;
    private final Condition mNotFull;
    private final Condition mReadReady;
    private volatile int mStatusCode;
    private volatile boolean mStopped;
    private int mUnconsumedBytes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/SynthesisPlaybackQueueItem$ListEntry.class */
    public static final class ListEntry {
        final byte[] mBytes;

        ListEntry(byte[] bArr) {
            this.mBytes = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SynthesisPlaybackQueueItem(TextToSpeechService.AudioOutputParams audioOutputParams, int i, int i2, int i3, TextToSpeechService.UtteranceProgressDispatcher utteranceProgressDispatcher, Object obj, AbstractEventLogger abstractEventLogger) {
        super(utteranceProgressDispatcher, obj);
        this.mListLock = new ReentrantLock();
        this.mReadReady = this.mListLock.newCondition();
        this.mNotFull = this.mListLock.newCondition();
        this.mDataBufferList = new LinkedList<>();
        this.mUnconsumedBytes = 0;
        this.mStopped = false;
        this.mDone = false;
        this.mStatusCode = 0;
        this.mAudioTrack = new BlockingAudioTrack(audioOutputParams, i, i2, i3);
        this.mLogger = abstractEventLogger;
    }

    private byte[] take() throws InterruptedException {
        try {
            this.mListLock.lock();
            while (this.mDataBufferList.size() == 0 && !this.mStopped && !this.mDone) {
                this.mReadReady.await();
            }
            if (this.mStopped) {
                this.mListLock.unlock();
                return null;
            }
            ListEntry poll = this.mDataBufferList.poll();
            if (poll == null) {
                this.mListLock.unlock();
                return null;
            }
            this.mUnconsumedBytes -= poll.mBytes.length;
            this.mNotFull.signal();
            return poll.mBytes;
        } finally {
            this.mListLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        try {
            this.mListLock.lock();
            this.mDone = true;
            this.mReadReady.signal();
            this.mNotFull.signal();
        } finally {
            this.mListLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void put(byte[] bArr) throws InterruptedException {
        try {
            this.mListLock.lock();
            while (this.mAudioTrack.getAudioLengthMs(this.mUnconsumedBytes) > 500 && !this.mStopped) {
                this.mNotFull.await();
            }
            if (this.mStopped) {
                return;
            }
            this.mDataBufferList.add(new ListEntry(bArr));
            this.mUnconsumedBytes += bArr.length;
            this.mReadReady.signal();
        } finally {
            this.mListLock.unlock();
        }
    }

    @Override // android.speech.tts.PlaybackQueueItem, java.lang.Runnable
    public void run() {
        TextToSpeechService.UtteranceProgressDispatcher dispatcher = getDispatcher();
        dispatcher.dispatchOnStart();
        if (!this.mAudioTrack.init()) {
            dispatcher.dispatchOnError(-5);
            return;
        }
        while (true) {
            try {
                byte[] take = take();
                if (take == null) {
                    break;
                }
                this.mAudioTrack.write(take);
                this.mLogger.onAudioDataWritten();
            } catch (InterruptedException e) {
            }
        }
        this.mAudioTrack.waitAndRelease();
        if (this.mStatusCode == 0) {
            dispatcher.dispatchOnSuccess();
        } else if (this.mStatusCode == -2) {
            dispatcher.dispatchOnStop();
        } else {
            dispatcher.dispatchOnError(this.mStatusCode);
        }
        this.mLogger.onCompleted(this.mStatusCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.speech.tts.PlaybackQueueItem
    public void stop(int i) {
        try {
            this.mListLock.lock();
            this.mStopped = true;
            this.mStatusCode = i;
            this.mReadReady.signal();
            this.mNotFull.signal();
            this.mListLock.unlock();
            this.mAudioTrack.stop();
        } catch (Throwable th) {
            this.mListLock.unlock();
            throw th;
        }
    }
}
