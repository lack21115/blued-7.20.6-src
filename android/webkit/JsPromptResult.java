package android.webkit;

import android.webkit.JsResult;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/JsPromptResult.class */
public class JsPromptResult extends JsResult {
    private String mStringResult;

    public JsPromptResult(JsResult.ResultReceiver resultReceiver) {
        super(resultReceiver);
    }

    public void confirm(String str) {
        this.mStringResult = str;
        confirm();
    }

    public String getStringResult() {
        return this.mStringResult;
    }
}
