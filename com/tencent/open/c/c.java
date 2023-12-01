package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.a.f;
import com.tencent.open.web.security.SecureJsInterface;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/c/c.class */
public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f24572a;
    private KeyEvent b;

    /* renamed from: c  reason: collision with root package name */
    private com.tencent.open.web.security.a f24573c;

    public c(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode;
        int unicodeChar;
        f.b("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f24572a);
        if (f24572a && keyEvent.getAction() == 0 && (keyCode = keyEvent.getKeyCode()) != 4 && keyCode != 66) {
            if (keyCode == 67) {
                com.tencent.open.web.security.a.b = true;
                return super.dispatchKeyEvent(keyEvent);
            } else if (keyEvent.getUnicodeChar() == 0) {
                return super.dispatchKeyEvent(keyEvent);
            } else {
                if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                KeyEvent keyEvent2 = new KeyEvent(0, 17);
                this.b = keyEvent2;
                return super.dispatchKeyEvent(keyEvent2);
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        f.c("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        f.a("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection == null) {
            f24572a = false;
            return onCreateInputConnection;
        }
        f24572a = true;
        com.tencent.open.web.security.a aVar = new com.tencent.open.web.security.a(super.onCreateInputConnection(editorInfo), false);
        this.f24573c = aVar;
        return aVar;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int keyCode;
        int unicodeChar;
        f.b("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f24572a);
        if (f24572a && keyEvent.getAction() == 0 && (keyCode = keyEvent.getKeyCode()) != 4 && keyCode != 66) {
            if (keyCode == 67) {
                com.tencent.open.web.security.a.b = true;
                return super.onKeyDown(i, keyEvent);
            } else if (keyEvent.getUnicodeChar() == 0) {
                return super.onKeyDown(i, keyEvent);
            } else {
                if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                    return super.onKeyDown(i, keyEvent);
                }
                KeyEvent keyEvent2 = new KeyEvent(0, 17);
                this.b = keyEvent2;
                return super.onKeyDown(keyEvent2.getKeyCode(), this.b);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
