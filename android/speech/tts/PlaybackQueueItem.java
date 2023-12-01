package android.speech.tts;

import android.speech.tts.TextToSpeechService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/PlaybackQueueItem.class */
public abstract class PlaybackQueueItem implements Runnable {
    private final Object mCallerIdentity;
    private final TextToSpeechService.UtteranceProgressDispatcher mDispatcher;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaybackQueueItem(TextToSpeechService.UtteranceProgressDispatcher utteranceProgressDispatcher, Object obj) {
        this.mDispatcher = utteranceProgressDispatcher;
        this.mCallerIdentity = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getCallerIdentity() {
        return this.mCallerIdentity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextToSpeechService.UtteranceProgressDispatcher getDispatcher() {
        return this.mDispatcher;
    }

    @Override // java.lang.Runnable
    public abstract void run();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void stop(int i);
}
