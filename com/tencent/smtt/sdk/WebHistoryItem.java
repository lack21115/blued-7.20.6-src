package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/WebHistoryItem.class */
public class WebHistoryItem {

    /* renamed from: a  reason: collision with root package name */
    private IX5WebHistoryItem f25106a = null;
    private android.webkit.WebHistoryItem b = null;

    private WebHistoryItem() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebHistoryItem a(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.b = webHistoryItem;
        return webHistoryItem2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebHistoryItem a(IX5WebHistoryItem iX5WebHistoryItem) {
        if (iX5WebHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.f25106a = iX5WebHistoryItem;
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f25106a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getFavicon() : this.b.getFavicon();
    }

    public String getOriginalUrl() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f25106a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getOriginalUrl() : this.b.getOriginalUrl();
    }

    public String getTitle() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f25106a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getTitle() : this.b.getTitle();
    }

    public String getUrl() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f25106a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getUrl() : this.b.getUrl();
    }
}
