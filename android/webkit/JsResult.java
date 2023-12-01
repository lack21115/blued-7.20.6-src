package android.webkit;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/JsResult.class */
public class JsResult {
    private final ResultReceiver mReceiver;
    private boolean mResult;

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/JsResult$ResultReceiver.class */
    public interface ResultReceiver {
        void onJsResultComplete(JsResult jsResult);
    }

    public JsResult(ResultReceiver resultReceiver) {
        this.mReceiver = resultReceiver;
    }

    private final void wakeUp() {
        this.mReceiver.onJsResultComplete(this);
    }

    public final void cancel() {
        this.mResult = false;
        wakeUp();
    }

    public final void confirm() {
        this.mResult = true;
        wakeUp();
    }

    public final boolean getResult() {
        return this.mResult;
    }
}
