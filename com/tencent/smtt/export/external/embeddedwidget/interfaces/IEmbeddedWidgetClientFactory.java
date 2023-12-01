package com.tencent.smtt.export.external.embeddedwidget.interfaces;

import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/embeddedwidget/interfaces/IEmbeddedWidgetClientFactory.class */
public interface IEmbeddedWidgetClientFactory {
    IEmbeddedWidgetClient createWidgetClient(String str, Map<String, String> map, IEmbeddedWidget iEmbeddedWidget);
}
