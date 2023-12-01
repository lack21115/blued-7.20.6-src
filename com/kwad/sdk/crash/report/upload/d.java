package com.kwad.sdk.crash.report.upload;

import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/upload/d.class */
public final class d {
    public static void a(final File file, boolean z, final CountDownLatch countDownLatch) {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "upload()" + Thread.currentThread());
        final f fVar = new f();
        fVar.asW = au.getDeviceId();
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", g.dW(file.getName()));
        fVar.asY = new JSONObject(hashMap).toString();
        fVar.asZ = q.getExtension(file.getName());
        fVar.atb = file;
        new m<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: Ah */
            public c createRequest() {
                return new c(au.getDeviceId(), f.this.asU, "zip");
            }

            private static GetUploadTokenResult dV(String str) {
                JSONObject jSONObject = new JSONObject(str);
                GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
                getUploadTokenResult.parseJson(jSONObject);
                return getUploadTokenResult;
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.m
            public final /* synthetic */ GetUploadTokenResult parseData(String str) {
                return dV(str);
            }
        }.request(new p<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.2
            private static void a(c cVar, int i, String str) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "onError errorCode=" + i + "errorMsg=" + str + "url=" + cVar.getUrl());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(c cVar, GetUploadTokenResult getUploadTokenResult) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
                if (getUploadTokenResult.isResultOk()) {
                    f.this.ata = getUploadTokenResult.uploadToken;
                    b.a(file, f.this, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void Af() {
                            if (countDownLatch != null) {
                                countDownLatch.countDown();
                            }
                        }

                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void Ag() {
                            com.kwad.sdk.core.d.b.d("ExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                            if (countDownLatch != null) {
                                countDownLatch.countDown();
                            }
                            if (r7) {
                                q.delete(file.getPath());
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.g gVar, int i, String str) {
                a((c) gVar, i, str);
            }
        });
    }
}
