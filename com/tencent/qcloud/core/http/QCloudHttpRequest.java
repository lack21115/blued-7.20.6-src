package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.auth.QCloudSelfSigner;
import com.tencent.qcloud.core.auth.QCloudSignSourceProvider;
import com.tencent.qcloud.core.auth.QCloudSigner;
import com.tencent.qcloud.core.auth.STSCredentialScope;
import com.tencent.qcloud.core.auth.SignerFactory;
import com.tencent.qcloud.core.common.QCloudAuthenticationException;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.util.QCloudStringUtils;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/QCloudHttpRequest.class */
public class QCloudHttpRequest<T> extends HttpRequest<T> {
    private final STSCredentialScope[] credentialScope;
    private QCloudSelfSigner selfSigner;
    private final boolean signInUrl;
    private final QCloudSignSourceProvider signProvider;
    private final String signerType;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/QCloudHttpRequest$Builder.class */
    public static class Builder<T> extends HttpRequest.Builder<T> {
        private STSCredentialScope[] credentialScope;
        private QCloudSelfSigner selfSigner;
        private boolean signInUrl;
        private QCloudSignSourceProvider signProvider;
        private String signerType;

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> addHeader(String str, String str2) {
            return (Builder) super.addHeader(str, str2);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> body(RequestBodySerializer requestBodySerializer) {
            return (Builder) super.body(requestBodySerializer);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public QCloudHttpRequest<T> build() {
            prepareBuild();
            return new QCloudHttpRequest<>(this);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> contentMD5() {
            return (Builder) super.contentMD5();
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> converter(ResponseBodyConverter<T> responseBodyConverter) {
            return (Builder) super.converter((ResponseBodyConverter) responseBodyConverter);
        }

        public Builder<T> credentialScope(STSCredentialScope[] sTSCredentialScopeArr) {
            this.credentialScope = sTSCredentialScopeArr;
            return this;
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> host(String str) {
            return (Builder) super.host(str);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> method(String str) {
            return (Builder) super.method(str);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> path(String str) {
            return (Builder) super.path(str);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> port(int i) {
            return (Builder) super.port(i);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> query(String str, String str2) {
            return (Builder) super.query(str, str2);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> removeHeader(String str) {
            return (Builder) super.removeHeader(str);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> scheme(String str) {
            return (Builder) super.scheme(str);
        }

        public Builder<T> selfSigner(QCloudSelfSigner qCloudSelfSigner) {
            this.selfSigner = qCloudSelfSigner;
            return this;
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> setUseCache(boolean z) {
            return (Builder) super.setUseCache(z);
        }

        public Builder<T> signInUrl(boolean z) {
            this.signInUrl = z;
            return this;
        }

        public Builder<T> signer(String str, QCloudSignSourceProvider qCloudSignSourceProvider) {
            this.signerType = str;
            this.signProvider = qCloudSignSourceProvider;
            return this;
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> tag(Object obj) {
            return (Builder) super.tag(obj);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> url(URL url) {
            return (Builder) super.url(url);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> userAgent(String str) {
            return (Builder) super.userAgent(str);
        }
    }

    public QCloudHttpRequest(Builder<T> builder) {
        super(builder);
        this.signerType = ((Builder) builder).signerType;
        this.signProvider = ((Builder) builder).signProvider;
        this.credentialScope = ((Builder) builder).credentialScope;
        this.signInUrl = ((Builder) builder).signInUrl;
        this.selfSigner = ((Builder) builder).selfSigner;
    }

    private boolean shouldCalculateAuth() {
        return QCloudStringUtils.isEmpty(header("Authorization"));
    }

    public STSCredentialScope[] getCredentialScope() {
        return this.credentialScope;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.qcloud.core.http.HttpRequest
    public QCloudSelfSigner getQCloudSelfSigner() throws QCloudClientException {
        return this.selfSigner;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.qcloud.core.http.HttpRequest
    public QCloudSigner getQCloudSigner() throws QCloudClientException {
        if (this.signerType == null || !shouldCalculateAuth()) {
            return null;
        }
        QCloudSigner signer = SignerFactory.getSigner(this.signerType);
        if (signer != null) {
            return signer;
        }
        throw new QCloudClientException(new QCloudAuthenticationException("can't get signer for type : " + this.signerType));
    }

    public QCloudSignSourceProvider getSignProvider() {
        return this.signProvider;
    }

    public boolean isSignInUrl() {
        return this.signInUrl;
    }
}
