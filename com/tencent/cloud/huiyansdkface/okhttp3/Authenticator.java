package com.tencent.cloud.huiyansdkface.okhttp3;

import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Authenticator.class */
public interface Authenticator {

    /* renamed from: a  reason: collision with root package name */
    public static final Authenticator f22115a = new Authenticator() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.Authenticator.1
        @Override // com.tencent.cloud.huiyansdkface.okhttp3.Authenticator
        public Request authenticate(Route route, Response response) {
            return null;
        }
    };

    Request authenticate(Route route, Response response) throws IOException;
}
