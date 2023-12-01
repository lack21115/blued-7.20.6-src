package com.anythink.rewardvideo.a;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.h;
import com.anythink.core.common.k.g;
import com.anythink.core.common.k.s;
import com.anythink.core.common.v;
import com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener;
import com.anythink.rewardvideo.api.ATRewardVideoListener;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/rewardvideo/a/a.class */
public class a extends com.anythink.core.common.f<f> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9155a = a.class.getSimpleName();
    Runnable n;

    private a(Context context, String str) {
        super(context, str);
        this.n = new Runnable() { // from class: com.anythink.rewardvideo.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.j()) {
                    a.this.a(n.a().E(), 4, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        };
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static h a2(f fVar) {
        b bVar = new b(fVar.a());
        bVar.a(fVar.d);
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if ((r0 instanceof com.anythink.rewardvideo.a.a) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.rewardvideo.a.a a(android.content.Context r5, java.lang.String r6) {
        /*
            com.anythink.core.common.v r0 = com.anythink.core.common.v.a()
            r1 = r6
            com.anythink.core.common.f r0 = r0.b(r1)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L15
            r0 = r8
            r7 = r0
            r0 = r8
            boolean r0 = r0 instanceof com.anythink.rewardvideo.a.a
            if (r0 != 0) goto L27
        L15:
            com.anythink.rewardvideo.a.a r0 = new com.anythink.rewardvideo.a.a
            r1 = r0
            r2 = r5
            r3 = r6
            r1.<init>(r2, r3)
            r7 = r0
            com.anythink.core.common.v r0 = com.anythink.core.common.v.a()
            r1 = r6
            r2 = r7
            r0.a(r1, r2)
        L27:
            r0 = r7
            com.anythink.rewardvideo.a.a r0 = (com.anythink.rewardvideo.a.a) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.rewardvideo.a.a.a(android.content.Context, java.lang.String):com.anythink.rewardvideo.a.a");
    }

    private void m() {
        n.a().a(this.n, ((long) Math.pow(2.0d, this.h)) * 1000);
    }

    @Override // com.anythink.core.common.f
    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        ATAdStatusInfo a2 = super.a(context, map);
        if (!c() && a(a2)) {
            a(context, 5, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
        }
        return a2;
    }

    @Override // com.anythink.core.common.f
    public final /* synthetic */ h a(f fVar) {
        f fVar2 = fVar;
        b bVar = new b(fVar2.a());
        bVar.a(fVar2.d);
        return bVar;
    }

    @Override // com.anythink.core.common.f
    public final String a() {
        return "1";
    }

    public final void a(final Activity activity, final String str, final ATRewardVideoListener aTRewardVideoListener, final ATEventInterface aTEventInterface, final Map<String, Object> map) {
        synchronized (this) {
            final com.anythink.core.common.e.b a2 = a((Context) activity, false, true, map);
            if (a2 != null && (a2.e() instanceof CustomRewardVideoAdapter)) {
                a(a2);
                f();
                a2.a(a2.d() + 1);
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.anythink.core.common.e.e trackingInfo = a2.e().getTrackingInfo();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (trackingInfo != null) {
                            trackingInfo.v = a.this.g;
                            trackingInfo.C = str;
                            trackingInfo.h(g.a(trackingInfo.X(), trackingInfo.x(), currentTimeMillis));
                            s.a(a.this.b, trackingInfo);
                            s.a(map, trackingInfo);
                        }
                        com.anythink.core.common.a.a().a(a.this.b, a2);
                        com.anythink.core.common.j.a.a(a.this.b).a(13, trackingInfo, a2.e().getUnitGroupInfo(), currentTimeMillis);
                        final CustomRewardVideoAdapter customRewardVideoAdapter = (CustomRewardVideoAdapter) a2.e();
                        Activity activity2 = activity;
                        if (activity2 != null) {
                            customRewardVideoAdapter.refreshActivityContext(activity2);
                        }
                        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                customRewardVideoAdapter.setScenario(str);
                                IExHandler b = n.a().b();
                                if (b != null) {
                                    CustomRewardVideoAdapter customRewardVideoAdapter2 = customRewardVideoAdapter;
                                    customRewardVideoAdapter2.setAdDownloadListener(b.createDownloadListener(customRewardVideoAdapter2, null, aTEventInterface));
                                }
                                customRewardVideoAdapter.internalShow(activity, new e(customRewardVideoAdapter, n.a().B(), aTRewardVideoListener));
                            }
                        });
                    }
                });
                return;
            }
            if (a((ATAdStatusInfo) null)) {
                a(n.a().E(), 7, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, map);
            }
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noADError, "", "No Cache.");
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, j.a((com.anythink.core.common.b.d) null));
            }
        }
    }

    public final void a(Context context, int i, com.anythink.core.common.b.a aVar, com.anythink.core.common.b.b bVar, Map<String, Object> map) {
        f fVar = new f();
        fVar.a(context);
        fVar.d = i;
        fVar.e = bVar;
        if (map != null) {
            try {
                fVar.g = new HashMap(map);
            } catch (Throwable th) {
            }
        }
        super.a(this.b, "1", this.f6687c, (String) fVar, aVar);
    }

    @Override // com.anythink.core.common.f
    public final void b(AdError adError) {
        super.b(adError);
        if (j()) {
            n.a().a(this.n, ((long) Math.pow(2.0d, this.h)) * 1000);
            ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener = d.a().b;
            if (aTRewardVideoAutoLoadListener != null) {
                aTRewardVideoAutoLoadListener.onRewardVideoAutoLoadFail(this.f6687c, adError);
            }
        }
    }

    @Override // com.anythink.core.common.f
    public final boolean j() {
        return v.a().f(this.f6687c);
    }

    @Override // com.anythink.core.common.f
    public final void k() {
        n.a().c(this.n);
    }

    @Override // com.anythink.core.common.f
    public final void l() {
        ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener;
        super.l();
        if (!j() || (aTRewardVideoAutoLoadListener = d.a().b) == null) {
            return;
        }
        aTRewardVideoAutoLoadListener.onRewardVideoAutoLoaded(this.f6687c);
    }
}
