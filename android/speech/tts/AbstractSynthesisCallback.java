package android.speech.tts;

/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/AbstractSynthesisCallback.class */
abstract class AbstractSynthesisCallback implements SynthesisCallback {
    protected final boolean mClientIsUsingV2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractSynthesisCallback(boolean z) {
        this.mClientIsUsingV2 = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int errorCodeOnStop() {
        return this.mClientIsUsingV2 ? -2 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void stop();
}
