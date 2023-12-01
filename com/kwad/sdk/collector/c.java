package com.kwad.sdk.collector;

import android.content.Context;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.utils.bd;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/c.class */
public final class c {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/c$a.class */
    public interface a {
        void b(AppStatusRules appStatusRules);

        void h(int i, String str);
    }

    public static void a(final Context context, final a aVar) {
        if (context == null) {
            return;
        }
        d.a(context, new d.a() { // from class: com.kwad.sdk.collector.c.1
            @Override // com.kwad.sdk.collector.d.a
            public final void bo(String str) {
                com.kwad.sdk.core.d.b.e("AppStatusFetchConfigManager", "onLoadError: " + str);
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void onLoaded() {
                c.b(Context.this, aVar);
            }
        });
    }

    public static void b(final Context context, final a aVar) {
        new m<com.kwad.sdk.collector.kwai.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.2
            private static AppStatusRules bp(String str) {
                return AppStatusRules.createFromJson(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: tE */
            public com.kwad.sdk.collector.kwai.a createRequest() {
                return new com.kwad.sdk.collector.kwai.a(bd.db(Context.this));
            }

            @Override // com.kwad.sdk.core.network.m
            public final /* synthetic */ AppStatusRules parseData(String str) {
                return bp(str);
            }
        }.request(new p<com.kwad.sdk.collector.kwai.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.3
            private void a(AppStatusRules appStatusRules) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.b(appStatusRules);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(com.kwad.sdk.collector.kwai.a aVar2) {
                super.onStartRequest(aVar2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(com.kwad.sdk.collector.kwai.a aVar2, int i, String str) {
                super.onError(aVar2, i, str);
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.h(i, str);
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.g gVar, BaseResultData baseResultData) {
                a((AppStatusRules) baseResultData);
            }
        });
    }
}
