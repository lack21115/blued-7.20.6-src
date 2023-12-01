package com.mokee.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/ExecutorDelivery.class */
public class ExecutorDelivery implements ResponseDelivery {
    private static final String[] b = null;

    /* renamed from: a  reason: collision with root package name */
    private final Executor f24233a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/ExecutorDelivery$a.class */
    public class a implements Runnable {
        private static final String[] d = null;

        /* renamed from: a  reason: collision with root package name */
        private final Response f24234a;
        private final Runnable b;

        /* renamed from: c  reason: collision with root package name */
        private final Request f24235c;

        static {
            String[] strArr = new String[3];
            throw new VerifyError("bad dex opcode");
        }

        public a(Request request, Response response, Runnable runnable) {
            this.f24235c = request;
            this.f24234a = response;
            this.b = runnable;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
            if (r0 != false) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0034, code lost:
            if (r0 != false) goto L20;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r4 = this;
                boolean r0 = com.mokee.volley.Request.e
                r5 = r0
                r0 = r4
                com.mokee.volley.Request r0 = r0.f24235c
                boolean r0 = r0.isCanceled()
                if (r0 == 0) goto L1b
                r0 = r4
                com.mokee.volley.Request r0 = r0.f24235c
                java.lang.String[] r1 = com.mokee.volley.ExecutorDelivery.a.d
                r2 = 1
                r1 = r1[r2]
                r0.b(r1)
            L1a:
                return
            L1b:
                r0 = r4
                com.mokee.volley.Response r0 = r0.f24234a
                boolean r0 = r0.isSuccess()
                if (r0 == 0) goto L37
                r0 = r4
                com.mokee.volley.Request r0 = r0.f24235c
                r1 = r4
                com.mokee.volley.Response r1 = r1.f24234a
                T r1 = r1.result
                r0.deliverResponse(r1)
                r0 = r5
                if (r0 == 0) goto L45
            L37:
                r0 = r4
                com.mokee.volley.Request r0 = r0.f24235c
                r1 = r4
                com.mokee.volley.Response r1 = r1.f24234a
                com.mokee.volley.VolleyError r1 = r1.error
                r0.deliverError(r1)
            L45:
                r0 = r4
                com.mokee.volley.Response r0 = r0.f24234a
                boolean r0 = r0.intermediate
                if (r0 == 0) goto L5f
                r0 = r4
                com.mokee.volley.Request r0 = r0.f24235c
                java.lang.String[] r1 = com.mokee.volley.ExecutorDelivery.a.d
                r2 = 2
                r1 = r1[r2]
                r0.addMarker(r1)
                r0 = r5
                if (r0 == 0) goto L6b
            L5f:
                r0 = r4
                com.mokee.volley.Request r0 = r0.f24235c
                java.lang.String[] r1 = com.mokee.volley.ExecutorDelivery.a.d
                r2 = 0
                r1 = r1[r2]
                r0.b(r1)
            L6b:
                r0 = r4
                java.lang.Runnable r0 = r0.b
                if (r0 == 0) goto L1a
                r0 = r4
                java.lang.Runnable r0 = r0.b
                r0.run()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.ExecutorDelivery.a.run():void");
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/ExecutorDelivery$b.class */
    class b implements Executor {
        private final /* synthetic */ Handler val$handler;

        b(Handler handler) {
            this.val$handler = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.val$handler.post(runnable);
        }
    }

    static {
        String[] strArr = new String[2];
        throw new VerifyError("bad dex opcode");
    }

    public ExecutorDelivery(Handler handler) {
        this.f24233a = new b(handler);
    }

    public ExecutorDelivery(Executor executor) {
        this.f24233a = executor;
    }

    @Override // com.mokee.volley.ResponseDelivery
    public void postError(Request<?> request, VolleyError volleyError) {
        request.addMarker(b[0]);
        this.f24233a.execute(new a(request, Response.error(volleyError), null));
    }

    @Override // com.mokee.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response) {
        postResponse(request, response, null);
    }

    @Override // com.mokee.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker(b[1]);
        this.f24233a.execute(new a(request, response, runnable));
    }
}
