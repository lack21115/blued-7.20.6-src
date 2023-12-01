package com.huawei.hms.ads.nativead;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.bs;
import com.huawei.hms.ads.bu;
import com.huawei.hms.ads.bv;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ha;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.la;
import com.huawei.hms.ads.lb;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAdMonitor.class */
public final class NativeAdMonitor implements View.OnAttachStateChangeListener, ha {
    private static final String Code = NativeAdMonitor.class.getSimpleName();
    private static WeakHashMap<View, NativeAdMonitor> V = new WeakHashMap<>();
    private View B;
    private bu C;
    private lb D;
    private la F;
    private List<View> I;
    private n L;
    private hb S;
    private List<View> Z;
    private PPSNativeView.b f;
    private PPSNativeView.e g;
    private DislikeAdListener h;

    /* renamed from: a  reason: collision with root package name */
    private boolean f8910a = true;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private final String f8911c = t.ah + hashCode();
    private final String d = t.ai + hashCode();
    private boolean e = false;
    private View.OnClickListener i = new View.OnClickListener() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (NativeAdMonitor.this.f8910a) {
                NativeAdMonitor.this.f8910a = false;
                ge.V(NativeAdMonitor.Code, "onClick");
                NativeAdMonitor.this.e = true;
                if (NativeAdMonitor.this.f != null) {
                    NativeAdMonitor.this.f.Code(view);
                }
                NativeAdMonitor.this.C.V();
                NativeAdMonitor.this.Code((Integer) 1, true);
                ba.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeAdMonitor.this.f8910a = true;
                    }
                }, 500L);
            }
        }
    };
    private View.OnClickListener j = new View.OnClickListener() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
        }
    };

    public NativeAdMonitor(View view, Map<String, View> map, Map<String, View> map2) {
        String str;
        String str2;
        this.I = new ArrayList();
        this.Z = new ArrayList();
        if (view instanceof NativeView) {
            str = Code;
            str2 = "containerView can't be an instance of NativeView class or NativeView subclass";
        } else if (view == null) {
            str = Code;
            str2 = "containerView can't be null";
        } else if (V.get(view) == null) {
            V.put(view, this);
            this.B = view;
            this.C = new bv(view.getContext(), this.B);
            this.S = new hb(view, this);
            this.B.addOnAttachStateChangeListener(this);
            if (map != null) {
                this.I = new ArrayList(map.values());
            }
            if (map2 != null) {
                this.Z = new ArrayList(map2.values());
                return;
            }
            return;
        } else {
            str = Code;
            str2 = "containerView has been existed in other NativeAdMonitor object.";
        }
        ge.I(str, str2);
    }

    private void C() {
        n nVar = this.L;
        if (this.B == null || nVar == null) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                n nVar2 = NativeAdMonitor.this.L;
                if (NativeAdMonitor.this.B == null || nVar2 == null) {
                    return;
                }
                NativeAdMonitor.this.S.a();
            }
        }, this.d, nVar.r() / 2);
    }

    private MediaView Code(View view) {
        LinkedList linkedList = new LinkedList();
        if (view instanceof ViewGroup) {
            linkedList.add(view);
        }
        while (linkedList.size() > 0) {
            View view2 = (View) linkedList.poll();
            if (view2 instanceof MediaView) {
                return (MediaView) view2;
            }
            if (view2 instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    ViewGroup viewGroup = (ViewGroup) view2;
                    if (i2 < viewGroup.getChildCount()) {
                        linkedList.offer(viewGroup.getChildAt(i2));
                        i = i2 + 1;
                    }
                }
            }
        }
        return null;
    }

    private void Code(NativeAd nativeAd) {
        View view = this.B;
        if (view == null || V.get(view) == null) {
            ge.V(Code, "container view is null, please add a container view first.");
            return;
        }
        if (nativeAd instanceof bs) {
            g Code2 = ((bs) nativeAd).Code();
            if (Code2 instanceof n) {
                n nVar = (n) Code2;
                this.L = nVar;
                this.S.V(nVar.r(), this.L.s());
                this.C.Code(this.L);
                View view2 = this.B;
                if (view2 != null) {
                    view2.setOnClickListener(this.i);
                }
                MediaView Code3 = Code(this.B);
                if (Code3 != null) {
                    b mediaViewAdapter = Code3.getMediaViewAdapter();
                    mediaViewAdapter.Code(nativeAd);
                    VideoOperator videoOperator = nativeAd.getVideoOperator();
                    if (videoOperator instanceof c) {
                        ((c) videoOperator).Code(Code3);
                    }
                    View B = mediaViewAdapter.B();
                    if (B instanceof NativeVideoView) {
                        NativeVideoView nativeVideoView = (NativeVideoView) B;
                        this.F = nativeVideoView;
                        nativeVideoView.setCoverClickListener(this.j);
                        this.F.setNativeAd(Code2);
                    }
                    if (B instanceof NativeWindowImageView) {
                        NativeWindowImageView nativeWindowImageView = (NativeWindowImageView) B;
                        this.D = nativeWindowImageView;
                        nativeWindowImageView.setNativeAd(Code2);
                        this.D.setDisplayView(this.B);
                    }
                }
                V(this.I);
                I(this.Z);
            }
        }
        S();
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        n nVar = this.L;
        if (nVar == null || nVar.R()) {
            return;
        }
        PPSNativeView.e eVar = this.g;
        if (eVar != null) {
            eVar.B();
        }
        this.L.Z(true);
        this.C.Code(l, num, num2, z);
    }

    private void D() {
        if (aa.Code(this.Z)) {
            return;
        }
        for (View view : this.Z) {
            if (view != null) {
                view.setClickable(true);
            }
        }
    }

    private void F() {
        if (aa.Code(this.I)) {
            return;
        }
        for (View view : this.I) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
    }

    private void I(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof MediaView) {
                NativeVideoView videoView = ((MediaView) view).getVideoView();
                if (videoView != null) {
                    videoView.setCoverClickListener(this.j);
                    videoView.getPreviewImageView().setOnClickListener(null);
                }
            } else if (view != null) {
                view.setClickable(false);
                view.setOnClickListener(null);
            }
        }
    }

    private void S() {
        n nVar;
        if (!Code() || (nVar = this.L) == null || nVar.T()) {
            return;
        }
        ge.V(Code, " maybe report show start.");
        I();
    }

    private void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof MediaView) {
                NativeVideoView videoView = ((MediaView) view).getVideoView();
                if (videoView != null) {
                    videoView.setCoverClickListener(this.i);
                    videoView.getPreviewImageView().setOnClickListener(this.i);
                }
            } else if (view != null) {
                view.setOnClickListener(this.i);
            }
        }
    }

    @Override // com.huawei.hms.ads.ha
    public void Code(long j, int i) {
        ba.Code(this.f8911c);
        if (!this.S.Code(j) || this.b) {
            return;
        }
        this.b = true;
        Code(Long.valueOf(j), Integer.valueOf(i), null, false);
    }

    public void Code(DislikeAdListener dislikeAdListener) {
        this.h = dislikeAdListener;
    }

    public void Code(PPSNativeView.b bVar) {
        this.f = bVar;
    }

    public void Code(PPSNativeView.e eVar) {
        this.g = eVar;
        this.C.Code(eVar);
    }

    public void Code(Integer num, boolean z) {
        Code(Long.valueOf(System.currentTimeMillis() - this.S.Z()), Integer.valueOf(this.S.I()), num, z);
    }

    public void Code(List<String> list) {
        ge.V(Code, "onClose keyWords");
        this.C.Code(list);
        Code((Integer) 3, false);
        la laVar = this.F;
        if (laVar != null) {
            laVar.S();
        }
        DislikeAdListener dislikeAdListener = this.h;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        unregister();
    }

    public boolean Code() {
        hb hbVar = this.S;
        if (hbVar != null) {
            return hbVar.d();
        }
        return false;
    }

    @Override // com.huawei.hms.ads.ha
    public void I() {
        PPSNativeView.e eVar;
        this.b = false;
        String valueOf = String.valueOf(v.Code());
        n nVar = this.L;
        if (nVar == null) {
            ge.V(Code, "nativeAd is null, please register first");
            return;
        }
        nVar.Z(false);
        this.L.B(true);
        if (this.e && (eVar = this.g) != null) {
            this.e = false;
            eVar.Z();
        }
        if (!this.L.Q()) {
            this.L.V(true);
        }
        this.C.Code(valueOf);
        la laVar = this.F;
        if (laVar != null) {
            laVar.Code(valueOf);
        }
        this.C.Code();
    }

    @Override // com.huawei.hms.ads.ha
    public void V(long j, int i) {
        ba.Code(this.f8911c);
        n nVar = this.L;
        if (nVar != null) {
            nVar.B(false);
        }
        this.C.Code(j, i);
    }

    public void Z() {
        ge.V(Code, "onClose");
        Code((List<String>) null);
    }

    @Override // com.huawei.hms.ads.ha
    public void a_() {
        n nVar = this.L;
        if (nVar != null) {
            ba.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.4
                @Override // java.lang.Runnable
                public void run() {
                    n nVar2 = NativeAdMonitor.this.L;
                    if (nVar2 != null) {
                        NativeAdMonitor.this.Code(Long.valueOf(nVar2.r()), Integer.valueOf(NativeAdMonitor.this.S.I()), null, false);
                    }
                }
            }, this.f8911c, nVar.r());
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        hb hbVar = this.S;
        if (hbVar != null) {
            hbVar.D();
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ge.V(Code, "onDetachedFromWindow");
        hb hbVar = this.S;
        if (hbVar != null) {
            hbVar.L();
        }
    }

    public void setNativeAd(NativeAd nativeAd) {
        ba.Code(this.d);
        ba.Code(this.f8911c);
        if (nativeAd == null) {
            ge.V(Code, "nativeAd is null, can't set the nativeAd now.");
            return;
        }
        if (nativeAd instanceof bs) {
            ((bs) nativeAd).Code(this);
        }
        Code(nativeAd);
    }

    public void unregister() {
        ba.Code(this.d);
        ba.Code(this.f8911c);
        n nVar = this.L;
        if (nVar != null) {
            nVar.B(false);
        }
        View view = this.B;
        if (view != null) {
            view.setOnClickListener(null);
        }
        this.L = null;
        this.S.V();
        this.C.Code((n) null);
        this.h = null;
        F();
        D();
        la laVar = this.F;
        if (laVar != null) {
            laVar.setNativeAd(null);
        }
        this.F = null;
    }
}
