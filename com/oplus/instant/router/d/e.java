package com.oplus.instant.router.d;

import android.content.Context;
import com.oplus.instant.router.callback.Callback;
import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.utils.QgRouterManager;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/d/e.class */
public class e extends com.oplus.instant.router.d.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/d/e$a.class */
    public class a extends Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.oplus.instant.router.callback.Callback f24290a;

        a(e eVar, com.oplus.instant.router.callback.Callback callback) {
            this.f24290a = callback;
        }

        @Override // com.oplus.quickgame.sdk.engine.callback.Callback
        public void onResponse(Callback.Response response) {
            Callback.Response response2 = new Callback.Response();
            response2.setCode(response.getCode());
            response2.setMsg(response.getMsg());
            this.f24290a.onResponse(response2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        super(bVar);
    }

    private com.oplus.quickgame.sdk.engine.callback.Callback a(com.oplus.instant.router.callback.Callback callback) {
        if (callback != null) {
            return new a(this, callback);
        }
        return null;
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void preload(Context context) {
        QuickGame.Req createReq = QgRouterManager.createReq(context, this.f, this.f24285a, this.b, this.f24286c, this.d, a(this.e));
        if (createReq != null) {
            createReq.preload(context);
        } else {
            com.oplus.instant.router.g.e.b(context.getApplicationContext(), this.f, this.f24285a, this.b, this.f24286c, this.d, this.e);
        }
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void request(Context context) {
        QuickGame.Req createReq = QgRouterManager.createReq(context, this.f, this.f24285a, this.b, this.f24286c, this.d, a(this.e));
        if (createReq == null) {
            com.oplus.instant.router.g.e.a(context, this.f, this.f24285a, this.b, this.f24286c, this.d, this.e);
            return;
        }
        createReq.request(context);
        com.oplus.instant.router.g.d.a("XGame_Router_TAG", "router newEngineRequest.request ");
    }
}
