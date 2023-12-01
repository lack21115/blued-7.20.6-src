package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/SystemWebViewClient.class */
public class SystemWebViewClient extends android.webkit.WebViewClient {

    /* renamed from: c  reason: collision with root package name */
    private static String f25052c;

    /* renamed from: a  reason: collision with root package name */
    private WebViewClient f25053a;
    private WebView b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/SystemWebViewClient$a.class */
    static class a extends ClientCertRequest {

        /* renamed from: a  reason: collision with root package name */
        private android.webkit.ClientCertRequest f25057a;

        public a(android.webkit.ClientCertRequest clientCertRequest) {
            this.f25057a = clientCertRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void cancel() {
            this.f25057a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String getHost() {
            return this.f25057a.getHost();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String[] getKeyTypes() {
            return this.f25057a.getKeyTypes();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public int getPort() {
            return this.f25057a.getPort();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public Principal[] getPrincipals() {
            return this.f25057a.getPrincipals();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void ignore() {
            this.f25057a.ignore();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.f25057a.proceed(privateKey, x509CertificateArr);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/SystemWebViewClient$b.class */
    static class b implements HttpAuthHandler {

        /* renamed from: a  reason: collision with root package name */
        private android.webkit.HttpAuthHandler f25058a;

        b(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.f25058a = httpAuthHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void cancel() {
            this.f25058a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void proceed(String str, String str2) {
            this.f25058a.proceed(str, str2);
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            return this.f25058a.useHttpAuthUsernamePassword();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/SystemWebViewClient$c.class */
    static class c implements SslErrorHandler {

        /* renamed from: a  reason: collision with root package name */
        android.webkit.SslErrorHandler f25059a;

        c(android.webkit.SslErrorHandler sslErrorHandler) {
            this.f25059a = sslErrorHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void cancel() {
            this.f25059a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void proceed() {
            this.f25059a.proceed();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/SystemWebViewClient$d.class */
    static class d implements SslError {

        /* renamed from: a  reason: collision with root package name */
        android.net.http.SslError f25060a;

        d(android.net.http.SslError sslError) {
            this.f25060a = sslError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean addError(int i) {
            return this.f25060a.addError(i);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public SslCertificate getCertificate() {
            return this.f25060a.getCertificate();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public int getPrimaryError() {
            return this.f25060a.getPrimaryError();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public String getUrl() {
            return this.f25060a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean hasError(int i) {
            return this.f25060a.hasError(i);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/SystemWebViewClient$e.class */
    static class e implements WebResourceRequest {

        /* renamed from: a  reason: collision with root package name */
        private String f25061a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f25062c;
        private boolean d;
        private String e;
        private Map<String, String> f;

        public e(String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
            this.f25061a = str;
            this.b = z;
            this.f25062c = z2;
            this.d = z3;
            this.e = str2;
            this.f = map;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.e;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return Uri.parse(this.f25061a);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            return this.f25062c;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/SystemWebViewClient$f.class */
    static class f implements WebResourceRequest {

        /* renamed from: a  reason: collision with root package name */
        android.webkit.WebResourceRequest f25063a;

        f(android.webkit.WebResourceRequest webResourceRequest) {
            this.f25063a = webResourceRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f25063a.getMethod();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f25063a.getRequestHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return this.f25063a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.f25063a.hasGesture();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f25063a.isForMainFrame();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            if (Build.VERSION.SDK_INT >= 24) {
                Object a2 = com.tencent.smtt.utils.i.a(this.f25063a, "isRedirect");
                if (a2 instanceof Boolean) {
                    return ((Boolean) a2).booleanValue();
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/SystemWebViewClient$g.class */
    static class g extends WebResourceResponse {

        /* renamed from: a  reason: collision with root package name */
        android.webkit.WebResourceResponse f25064a;

        public g(android.webkit.WebResourceResponse webResourceResponse) {
            this.f25064a = webResourceResponse;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public InputStream getData() {
            return this.f25064a.getData();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getEncoding() {
            return this.f25064a.getEncoding();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getMimeType() {
            return this.f25064a.getMimeType();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getReasonPhrase() {
            return this.f25064a.getReasonPhrase();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public Map<String, String> getResponseHeaders() {
            return this.f25064a.getResponseHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public int getStatusCode() {
            return this.f25064a.getStatusCode();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setData(InputStream inputStream) {
            this.f25064a.setData(inputStream);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setEncoding(String str) {
            this.f25064a.setEncoding(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setMimeType(String str) {
            this.f25064a.setMimeType(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setResponseHeaders(Map<String, String> map) {
            this.f25064a.setResponseHeaders(map);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setStatusCodeAndReasonPhrase(int i, String str) {
            this.f25064a.setStatusCodeAndReasonPhrase(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.b = webView;
        this.f25053a = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z) {
        this.b.a(webView);
        this.f25053a.doUpdateVisitedHistory(this.b, str, z);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(android.webkit.WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.f25053a.onFormResubmission(this.b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(android.webkit.WebView webView, String str) {
        this.b.a(webView);
        this.f25053a.onLoadResource(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(android.webkit.WebView webView, String str) {
        this.b.a(webView);
        this.f25053a.onPageCommitVisible(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, String str) {
        com.tencent.smtt.utils.n a2;
        if (f25052c == null && (a2 = com.tencent.smtt.utils.n.a()) != null) {
            a2.a(true);
            f25052c = Boolean.toString(true);
        }
        this.b.a(webView);
        this.b.f25114a++;
        this.f25053a.onPageFinished(this.b, str);
        if ("com.qzone".equals(webView.getContext().getApplicationInfo().packageName)) {
            this.b.a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.d();
        if (!TbsShareManager.mHasQueryed && this.b.getContext() != null && TbsShareManager.isThirdPartyApp(this.b.getContext())) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TbsShareManager.forceLoadX5FromTBSDemo(SystemWebViewClient.this.b.getContext()) || !TbsDownloader.needDownload(SystemWebViewClient.this.b.getContext(), false)) {
                        return;
                    }
                    TbsDownloader.startDownload(SystemWebViewClient.this.b.getContext());
                }
            }).start();
        }
        if (this.b.getContext() == null || TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()) {
            return;
        }
        TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.b.getContext()).dailyReport();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
        this.b.a(webView);
        this.f25053a.onPageStarted(this.b, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(android.webkit.WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.a(webView);
            this.f25053a.onReceivedClientCertRequest(this.b, new a(clientCertRequest));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, int i, String str, String str2) {
        this.b.a(webView);
        this.f25053a.onReceivedError(this.b, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        this.b.a(webView);
        f fVar = webResourceRequest != null ? new f(webResourceRequest) : null;
        com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError2 = null;
        if (webResourceError != null) {
            webResourceError2 = new com.tencent.smtt.export.external.interfaces.WebResourceError() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.2
                @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
                public CharSequence getDescription() {
                    return webResourceError.getDescription();
                }

                @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
                public int getErrorCode() {
                    return webResourceError.getErrorCode();
                }
            };
        }
        this.f25053a.onReceivedError(this.b, fVar, webResourceError2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(android.webkit.WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.b.a(webView);
        this.f25053a.onReceivedHttpAuthRequest(this.b, new b(httpAuthHandler), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        this.b.a(webView);
        this.f25053a.onReceivedHttpError(this.b, new f(webResourceRequest), new g(webResourceResponse));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(android.webkit.WebView webView, String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 12) {
            this.b.a(webView);
            this.f25053a.onReceivedLoginRequest(this.b, str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        if (Build.VERSION.SDK_INT >= 8) {
            this.b.a(webView);
            this.f25053a.onReceivedSslError(this.b, new c(sslErrorHandler), new d(sslError));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(android.webkit.WebView webView, final RenderProcessGoneDetail renderProcessGoneDetail) {
        this.b.a(webView);
        return this.f25053a.onRenderProcessGone(this.b, new WebViewClient.a() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.3
        });
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(android.webkit.WebView webView, float f2, float f3) {
        this.b.a(webView);
        this.f25053a.onScaleChanged(this.b, f2, f3);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(android.webkit.WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.f25053a.onTooManyRedirects(this.b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        this.f25053a.onUnhandledKeyEvent(this.b, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r10, android.webkit.WebResourceRequest r11) {
        /*
            r9 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto La
            r0 = 0
            return r0
        La:
            r0 = r11
            if (r0 != 0) goto L10
            r0 = 0
            return r0
        L10:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L33
            r0 = r11
            java.lang.String r1 = "isRedirect"
            java.lang.Object r0 = com.tencent.smtt.utils.i.a(r0, r1)
            r10 = r0
            r0 = r10
            boolean r0 = r0 instanceof java.lang.Boolean
            if (r0 == 0) goto L33
            r0 = r10
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r13 = r0
            goto L36
        L33:
            r0 = 0
            r13 = r0
        L36:
            com.tencent.smtt.sdk.SystemWebViewClient$e r0 = new com.tencent.smtt.sdk.SystemWebViewClient$e
            r1 = r0
            r2 = r11
            android.net.Uri r2 = r2.getUrl()
            java.lang.String r2 = r2.toString()
            r3 = r11
            boolean r3 = r3.isForMainFrame()
            r4 = r13
            r5 = r11
            boolean r5 = r5.hasGesture()
            r6 = r11
            java.lang.String r6 = r6.getMethod()
            r7 = r11
            java.util.Map r7 = r7.getRequestHeaders()
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r10 = r0
            r0 = r9
            com.tencent.smtt.sdk.WebViewClient r0 = r0.f25053a
            r1 = r9
            com.tencent.smtt.sdk.WebView r1 = r1.b
            r2 = r10
            com.tencent.smtt.export.external.interfaces.WebResourceResponse r0 = r0.shouldInterceptRequest(r1, r2)
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L74
            r0 = 0
            return r0
        L74:
            android.webkit.WebResourceResponse r0 = new android.webkit.WebResourceResponse
            r1 = r0
            r2 = r11
            java.lang.String r2 = r2.getMimeType()
            r3 = r11
            java.lang.String r3 = r3.getEncoding()
            r4 = r11
            java.io.InputStream r4 = r4.getData()
            r1.<init>(r2, r3, r4)
            r10 = r0
            r0 = r10
            r1 = r11
            java.util.Map r1 = r1.getResponseHeaders()
            r0.setResponseHeaders(r1)
            r0 = r11
            int r0 = r0.getStatusCode()
            r12 = r0
            r0 = r11
            java.lang.String r0 = r0.getReasonPhrase()
            r11 = r0
            r0 = r12
            r1 = r10
            int r1 = r1.getStatusCode()
            if (r0 != r1) goto Lb1
            r0 = r11
            if (r0 == 0) goto Lb7
            r0 = r11
            r1 = r10
            java.lang.String r1 = r1.getReasonPhrase()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb7
        Lb1:
            r0 = r10
            r1 = r12
            r2 = r11
            r0.setStatusCodeAndReasonPhrase(r1, r2)
        Lb7:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.SystemWebViewClient.shouldInterceptRequest(android.webkit.WebView, android.webkit.WebResourceRequest):android.webkit.WebResourceResponse");
    }

    @Override // android.webkit.WebViewClient
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
        WebResourceResponse shouldInterceptRequest;
        if (Build.VERSION.SDK_INT >= 11 && (shouldInterceptRequest = this.f25053a.shouldInterceptRequest(this.b, str)) != null) {
            return new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        return this.f25053a.shouldOverrideKeyEvent(this.b, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        boolean z;
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.b.showDebugView(uri)) {
            return true;
        }
        this.b.a(webView);
        if (Build.VERSION.SDK_INT >= 24) {
            Object a2 = com.tencent.smtt.utils.i.a(webResourceRequest, "isRedirect");
            if (a2 instanceof Boolean) {
                z = ((Boolean) a2).booleanValue();
                return this.f25053a.shouldOverrideUrlLoading(this.b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
            }
        }
        z = false;
        return this.f25053a.shouldOverrideUrlLoading(this.b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
        if (str == null || this.b.showDebugView(str)) {
            return true;
        }
        this.b.a(webView);
        return this.f25053a.shouldOverrideUrlLoading(this.b, str);
    }
}
