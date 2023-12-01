package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/CallbackWithHandler.class */
public class CallbackWithHandler {

    /* renamed from: a  reason: collision with root package name */
    private final FontsContractCompat.FontRequestCallback f2475a;
    private final Handler b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackWithHandler(FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this.f2475a = fontRequestCallback;
        this.b = CalleeHandler.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackWithHandler(FontsContractCompat.FontRequestCallback fontRequestCallback, Handler handler) {
        this.f2475a = fontRequestCallback;
        this.b = handler;
    }

    private void a(final int i) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f2475a;
        this.b.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.2
            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(i);
            }
        });
    }

    private void a(final Typeface typeface) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f2475a;
        this.b.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.1
            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRetrieved(typeface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.a()) {
            a(typefaceResult.f2491a);
        } else {
            a(typefaceResult.b);
        }
    }
}
