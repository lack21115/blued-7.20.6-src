package com.tencent.smtt.export.external.embeddedwidget.interfaces;

import android.webkit.ValueCallback;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/embeddedwidget/interfaces/IEmbeddedWidget.class */
public interface IEmbeddedWidget {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/embeddedwidget/interfaces/IEmbeddedWidget$EventResponseType.class */
    public enum EventResponseType {
        UNKNOWN,
        CONSUME_EVENT,
        NOT_CONSUME_EVENT
    }

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    long getWidgetId();

    void onClientError(IEmbeddedWidgetClient iEmbeddedWidgetClient);

    void setEventResponseType(EventResponseType eventResponseType);
}
