package android.speech.tts;

/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/SynthesisCallback.class */
public interface SynthesisCallback {
    int audioAvailable(byte[] bArr, int i, int i2);

    int done();

    void error();

    void error(int i);

    int getMaxBufferSize();

    boolean hasFinished();

    boolean hasStarted();

    int start(int i, int i2, int i3);
}
