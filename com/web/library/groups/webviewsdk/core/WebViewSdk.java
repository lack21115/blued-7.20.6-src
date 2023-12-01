package com.web.library.groups.webviewsdk.core;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/core/WebViewSdk.class */
public class WebViewSdk {
    private String appTicket;
    private a onAppTicketChangeListener;
    private OnAuthExpiredListener onAuthExpiredListener;
    private String scheme;
    private String webUrl;

    /* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/core/WebViewSdk$OnAuthExpiredListener.class */
    public interface OnAuthExpiredListener {
        void onAuthExpired();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/core/WebViewSdk$a.class */
    interface a {
        void a(String str);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/core/WebViewSdk$b.class */
    enum b {
        INSTANCE;
        
        private WebViewSdk singleton = new WebViewSdk();

        b() {
        }

        public WebViewSdk getInstance() {
            return this.singleton;
        }
    }

    private WebViewSdk() {
        this.scheme = "wmsdk.n.weimob.com";
    }

    public static WebViewSdk getInstance() {
        return b.INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void authExpired() {
        OnAuthExpiredListener onAuthExpiredListener = this.onAuthExpiredListener;
        if (onAuthExpiredListener != null) {
            onAuthExpiredListener.onAuthExpired();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getAppTicket() {
        return this.appTicket;
    }

    public String getScheme() {
        return this.scheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getWebUrl() {
        return this.webUrl;
    }

    public void init(String str) {
        if (str != null && str.endsWith("n.weimob.com")) {
            this.scheme = str;
        }
    }

    public void setAppTicket(String str) {
        this.appTicket = str;
        a aVar = this.onAppTicketChangeListener;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setOnAppTicketChangeListener(a aVar) {
        this.onAppTicketChangeListener = aVar;
    }

    public void setOnAuthExpiredListener(OnAuthExpiredListener onAuthExpiredListener) {
        this.onAuthExpiredListener = onAuthExpiredListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setWebUrl(String str) {
        this.webUrl = str;
    }
}
