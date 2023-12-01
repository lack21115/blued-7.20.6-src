package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/JsError.class */
public class JsError {

    /* renamed from: a  reason: collision with root package name */
    private final IX5JsError f38706a;

    /* JADX INFO: Access modifiers changed from: protected */
    public JsError(IX5JsError iX5JsError) {
        this.f38706a = iX5JsError;
    }

    public String getMessage() {
        return this.f38706a.getMessage();
    }

    public String getStack() {
        return this.f38706a.getStack();
    }
}
