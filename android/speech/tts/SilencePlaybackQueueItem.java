package android.speech.tts;

import android.os.ConditionVariable;
import android.speech.tts.TextToSpeechService;

/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/SilencePlaybackQueueItem.class */
class SilencePlaybackQueueItem extends PlaybackQueueItem {
    private final ConditionVariable mCondVar;
    private final long mSilenceDurationMs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SilencePlaybackQueueItem(TextToSpeechService.UtteranceProgressDispatcher utteranceProgressDispatcher, Object obj, long j) {
        super(utteranceProgressDispatcher, obj);
        this.mCondVar = new ConditionVariable();
        this.mSilenceDurationMs = j;
    }

    @Override // android.speech.tts.PlaybackQueueItem, java.lang.Runnable
    public void run() {
        getDispatcher().dispatchOnStart();
        boolean z = false;
        if (this.mSilenceDurationMs > 0) {
            z = this.mCondVar.block(this.mSilenceDurationMs);
        }
        if (z) {
            getDispatcher().dispatchOnStop();
        } else {
            getDispatcher().dispatchOnSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.speech.tts.PlaybackQueueItem
    public void stop(int i) {
        this.mCondVar.open();
    }
}
