package android.speech.tts;

import android.speech.tts.TextToSpeech;

/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/UtteranceProgressListener.class */
public abstract class UtteranceProgressListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static UtteranceProgressListener from(final TextToSpeech.OnUtteranceCompletedListener onUtteranceCompletedListener) {
        return new UtteranceProgressListener() { // from class: android.speech.tts.UtteranceProgressListener.1
            @Override // android.speech.tts.UtteranceProgressListener
            public void onDone(String str) {
                synchronized (this) {
                    TextToSpeech.OnUtteranceCompletedListener.this.onUtteranceCompleted(str);
                }
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public void onError(String str) {
                TextToSpeech.OnUtteranceCompletedListener.this.onUtteranceCompleted(str);
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public void onStart(String str) {
            }
        };
    }

    public abstract void onDone(String str);

    @Deprecated
    public abstract void onError(String str);

    public void onError(String str, int i) {
        onError(str);
    }

    public abstract void onStart(String str);
}
