package android.speech.tts;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/AudioPlaybackHandler.class */
public class AudioPlaybackHandler {
    private static final boolean DBG = false;
    private static final String TAG = "TTS.AudioPlaybackHandler";
    private final LinkedBlockingQueue<PlaybackQueueItem> mQueue = new LinkedBlockingQueue<>();
    private volatile PlaybackQueueItem mCurrentWorkItem = null;
    private final Thread mHandlerThread = new Thread(new MessageLoop(), "TTS.AudioPlaybackThread");

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/AudioPlaybackHandler$MessageLoop.class */
    private final class MessageLoop implements Runnable {
        private MessageLoop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    PlaybackQueueItem playbackQueueItem = (PlaybackQueueItem) AudioPlaybackHandler.this.mQueue.take();
                    AudioPlaybackHandler.this.mCurrentWorkItem = playbackQueueItem;
                    playbackQueueItem.run();
                    AudioPlaybackHandler.this.mCurrentWorkItem = null;
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    private void removeAllMessages() {
        this.mQueue.clear();
    }

    private void removeWorkItemsFor(Object obj) {
        Iterator<PlaybackQueueItem> it = this.mQueue.iterator();
        while (it.hasNext()) {
            if (it.next().getCallerIdentity() == obj) {
                it.remove();
            }
        }
    }

    private void stop(PlaybackQueueItem playbackQueueItem) {
        if (playbackQueueItem == null) {
            return;
        }
        playbackQueueItem.stop(-2);
    }

    public void enqueue(PlaybackQueueItem playbackQueueItem) {
        try {
            this.mQueue.put(playbackQueueItem);
        } catch (InterruptedException e) {
        }
    }

    public boolean isSpeaking() {
        return (this.mQueue.peek() == null && this.mCurrentWorkItem == null) ? false : true;
    }

    public void quit() {
        removeAllMessages();
        stop(this.mCurrentWorkItem);
        this.mHandlerThread.interrupt();
    }

    public void start() {
        this.mHandlerThread.start();
    }

    public void stop() {
        removeAllMessages();
        stop(this.mCurrentWorkItem);
    }

    public void stopForApp(Object obj) {
        removeWorkItemsFor(obj);
        PlaybackQueueItem playbackQueueItem = this.mCurrentWorkItem;
        if (playbackQueueItem == null || playbackQueueItem.getCallerIdentity() != obj) {
            return;
        }
        stop(playbackQueueItem);
    }
}
