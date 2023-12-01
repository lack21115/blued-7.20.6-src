package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.processor.Processor;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.map.tools.net.processor.ResponseProcessor;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/fb.class */
public class fb extends eb {
    private static final String j = "URLNetImpl";
    private static final boolean k = false;
    private HttpURLConnection i;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/fb$a.class */
    public class a implements Callback<Boolean> {
        public final /* synthetic */ b b;

        public a(b bVar) {
            this.b = bVar;
        }

        @Override // com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(Boolean bool) {
            this.b.a();
            fb.this.i = null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/fb$b.class */
    public static class b {

        /* renamed from: c  reason: collision with root package name */
        private static final int f23754c = 3;

        /* renamed from: a  reason: collision with root package name */
        private int f23755a;
        private boolean b = true;

        public b(int i) {
            this.f23755a = i;
            if (i > 3) {
                this.f23755a = 3;
            }
            if (this.f23755a <= 0) {
                this.f23755a = 1;
            }
        }

        public void a() {
            this.b = false;
        }

        public void b() {
            this.f23755a--;
        }

        public boolean c() {
            return this.b && this.f23755a > 0;
        }
    }

    private void a() {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void a(NetResponse netResponse) throws Exception {
        List<Processor> processors = netResponse.getProcessors();
        Collections.reverse(processors);
        for (Processor processor : processors) {
            if (processor instanceof ResponseProcessor) {
                ((ResponseProcessor) processor).onResponse(netResponse);
            }
        }
    }

    private void c(NetRequest netRequest) throws Exception {
        for (Processor processor : netRequest.processors) {
            if (processor instanceof RequestProcessor) {
                ((RequestProcessor) processor).onRequest(netRequest);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x039a -> B:4:0x0008). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tencent.map.tools.net.NetResponse d(com.tencent.map.tools.net.NetRequest r8) {
        /*
            Method dump skipped, instructions count: 943
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.fb.d(com.tencent.map.tools.net.NetRequest):com.tencent.map.tools.net.NetResponse");
    }

    @Override // com.tencent.mapsdk.internal.eb
    public NetResponse a(NetRequest netRequest) {
        netRequest.setNetMethod(NetMethod.GET);
        return doRequest(netRequest);
    }

    @Override // com.tencent.mapsdk.internal.eb
    public void a(Context context, Bundle bundle) {
        a();
    }

    @Override // com.tencent.mapsdk.internal.eb
    public NetResponse b(NetRequest netRequest) {
        netRequest.setNetMethod(NetMethod.POST);
        return doRequest(netRequest);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public boolean cancel() {
        HttpURLConnection httpURLConnection = this.i;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            return true;
        }
        return false;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse doRequest(NetRequest netRequest) {
        netRequest.addProcessor(new sb());
        return d(netRequest);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse openStream(NetRequest netRequest) {
        netRequest.addProcessor(new yb());
        return d(netRequest);
    }
}
