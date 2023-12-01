package com.zk_oaction.adengine.lk_sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static float[] f28234a = {0.0f, 0.0f};
    private float[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f28235c;
    private float d;
    private float e;
    private float f;
    private float g;
    private Handler h;

    /* renamed from: com.zk_oaction.adengine.lk_sdk.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/a$a.class */
    class HandlerC0934a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f28236a;
        final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f28237c;
        final /* synthetic */ float d;
        final /* synthetic */ b e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        HandlerC0934a(Looper looper, long j, float f, float f2, float f3, b bVar) {
            super(looper);
            this.f28236a = j;
            this.b = f;
            this.f28237c = f2;
            this.d = f3;
            this.e = bVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x013e, code lost:
            if (r7.f.f28235c < r7.f.b.length) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x01d5, code lost:
            if (r7.f.f28235c < r7.f.b.length) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x01fa  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r8) {
            /*
                Method dump skipped, instructions count: 516
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdk.a.HandlerC0934a.handleMessage(android.os.Message):void");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/a$b.class */
    public interface b {
        void a();

        void a(float f);
    }

    static /* synthetic */ int g(a aVar) {
        int i = aVar.f28235c;
        aVar.f28235c = i + 1;
        return i;
    }

    public void a(float f, float f2, float f3, b bVar, float[] fArr) {
        if (fArr != null) {
            this.b = (float[]) fArr.clone();
        }
        if (this.b == null) {
            this.b = f28234a;
        }
        this.f28235c = 1;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.036f;
        this.g = 6.0E-4f;
        HandlerC0934a handlerC0934a = new HandlerC0934a(Looper.getMainLooper(), SystemClock.uptimeMillis(), f3, f, f2, bVar);
        this.h = handlerC0934a;
        handlerC0934a.sendEmptyMessageDelayed(0, 16L);
    }
}
