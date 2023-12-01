package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.lib.models.CommandFunctionModelClass;
import com.tencent.map.lib.models.EventParamsModelClass;
import com.tencent.map.lib.models.ReturnInfoModelClass;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlayProvider;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.internal.g4;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kh.class */
public class kh implements VisualLayer {
    private static final int v = 15;
    private z3 g;
    private List<VisualLayer.OnLayerStatusChangedListener> h;
    private int i;
    private int j;
    private int k;
    private float l;
    private boolean m;
    private boolean n;
    private boolean o;
    private final String p;
    private VectorOverlay q;
    private g4 r;
    private boolean s = true;
    private volatile int t = -1;
    private lh u;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kh$a.class */
    public class a implements Callback<byte[]> {
        public final /* synthetic */ z3 b;

        public a(z3 z3Var) {
            this.b = z3Var;
        }

        @Override // com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("读取本地图层数据[");
            sb.append(bArr != null ? bArr.length : 0);
            sb.append("]");
            na.a(ma.x, sb.toString());
            if (bArr != null && bArr.length > 0 && kh.this.a(bArr, false)) {
                kh.this.a(this.b);
            }
            kh.this.c(this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kh$b.class */
    public class b implements Callback<byte[]> {
        public final /* synthetic */ z3 b;

        public b(z3 z3Var) {
            this.b = z3Var;
        }

        @Override // com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(byte[] bArr) {
            if (bArr != null && bArr.length > 0 && kh.this.a(bArr, true)) {
                kh.this.a(this.b);
                this.b.a(kh.this.p, bArr);
            }
            kh.this.d(this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kh$c.class */
    public class c implements VectorOverlay.OnVectorOverlayLoadListener {
        public c() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay.OnVectorOverlayLoadListener
        public void onVectorOverlayLoaded(boolean z) {
            if (z) {
                kh.this.b(0);
            } else {
                kh.this.b(20);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kh$d.class */
    public class d implements VectorOverlay.OnVectorOverlayClickListener {
        public d() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay.OnVectorOverlayClickListener
        public void onClicked(LatLng latLng, String str, String str2) {
            kh.this.a(VisualLayer.OnLayerStatusChangedListener.EventType.ON_CLICK, JsonUtils.modelToJsonString(new EventParamsModelClass.ClickEventParams(kh.this.p, latLng, str, str2)));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kh$e.class */
    public class e implements IAnimatorModel.IAnimatorEndListener {
        public e() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel.IAnimatorEndListener
        public void onAnimatorEnd() {
            kh.this.a(VisualLayer.OnLayerStatusChangedListener.EventType.ON_TRANSLATEANIMATION_COMPLETE, JsonUtils.modelToJsonString(new EventParamsModelClass.TranslateAnimationCompleteEventParams(kh.this.p)));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kh$f.class */
    public class f implements Runnable {
        public final /* synthetic */ int b;

        public f(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (kh.this.a(this.b) && kh.this.h != null) {
                na.a(ma.x, "notifyStatusChange do success");
                ArrayList arrayList = new ArrayList(kh.this.h);
                kh.this.a(VisualLayer.OnLayerStatusChangedListener.EventType.ON_LAYER_LOAD_FINISH, JsonUtils.modelToJsonString(new EventParamsModelClass.LoadFinishEventParams(kh.this.p, EventParamsModelClass.LoadFinishEventParams.LoadFinishInfo.getById(this.b))));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    VisualLayer.OnLayerStatusChangedListener onLayerStatusChangedListener = (VisualLayer.OnLayerStatusChangedListener) it.next();
                    if (onLayerStatusChangedListener != null) {
                        onLayerStatusChangedListener.onLayerLoadFinish(this.b);
                    }
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kh$g.class */
    public class g implements Runnable {
        public final /* synthetic */ VisualLayer b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f23910c;
        public final /* synthetic */ String d;

        public g(VisualLayer visualLayer, String str, String str2) {
            this.b = visualLayer;
            this.f23910c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (kh.this.h == null) {
                return;
            }
            Iterator it = new ArrayList(kh.this.h).iterator();
            while (it.hasNext()) {
                VisualLayer.OnLayerStatusChangedListener onLayerStatusChangedListener = (VisualLayer.OnLayerStatusChangedListener) it.next();
                if (onLayerStatusChangedListener != null) {
                    onLayerStatusChangedListener.onEvent(this.b, this.f23910c, this.d);
                }
            }
        }
    }

    public kh(VisualLayerOptions visualLayerOptions) {
        this.p = visualLayerOptions.getLayerId();
        a(visualLayerOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(z3 z3Var) {
        na.a(ma.x, "#drawLayer");
        g4 g4Var = this.r;
        if (g4Var == null || !g4Var.a() || z3Var == null) {
            return;
        }
        BaseOverlayProvider a2 = a(this.r);
        if (a2 == null) {
            na.g(ma.x, "创建OverlayProvider失败");
            b(4);
            return;
        }
        na.a(ma.x, "创建OverlayProvider:" + a2);
        a2.setVectorOverlayLoadedListener((VectorOverlay.OnVectorOverlayLoadListener) new c());
        a2.setVectorOverlayClickListener(new d());
        if (a2 instanceof GLModelOverlayProvider) {
            ((GLModelOverlayProvider) a2).setTransAnimatorEndListener(new e());
        }
        a2.enableClick(this.o);
        if (this.q == null) {
            this.q = z3Var.getMapContext().j().getMap().addVectorOverlay(a2);
            na.a(ma.x, "创建Overlay:" + this.q);
            return;
        }
        z3Var.getMapContext().j().getMap().updateVectorOverlay(this.q, a2);
        na.a(ma.x, "更新Overlay:" + this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r4) {
        /*
            r3 = this;
            r0 = r3
            int r0 = r0.t
            r1 = r4
            if (r0 != r1) goto La
            r0 = 0
            return r0
        La:
            r0 = r3
            int r0 = r0.t
            r5 = r0
            r0 = r5
            r1 = 20
            if (r0 == r1) goto L44
            r0 = r5
            if (r0 == 0) goto L32
            r0 = r5
            r1 = 1
            if (r0 == r1) goto L44
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L44
            r0 = r5
            r1 = 3
            if (r0 == r1) goto L44
            r0 = r5
            r1 = 4
            if (r0 == r1) goto L44
            r0 = r4
            r5 = r0
            goto L49
        L32:
            r0 = r4
            r5 = r0
            r0 = r4
            r1 = r3
            int r1 = r1.t
            if (r0 <= r1) goto L49
            r0 = r3
            int r0 = r0.t
            r5 = r0
            goto L49
        L44:
            r0 = r3
            int r0 = r0.t
            r5 = r0
        L49:
            r0 = r3
            int r0 = r0.t
            r1 = r5
            if (r0 != r1) goto L53
            r0 = 0
            return r0
        L53:
            r0 = r3
            r1 = r5
            r0.t = r1
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.kh.a(int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(z3 z3Var) {
        if (z3Var == null || !this.s) {
            return;
        }
        this.s = false;
        int i = this.k;
        if (i <= 0) {
            z3Var.d(this.p);
            return;
        }
        if (i < 15) {
            this.k = 15;
        }
        z3Var.a(this.p, this.k);
    }

    public BaseOverlayProvider a(g4 g4Var) {
        lh lhVar = this.u;
        if (lhVar != null) {
            return lhVar.a(g4Var);
        }
        return null;
    }

    public g4 a(g4 g4Var, String str) {
        lh lhVar = this.u;
        if (lhVar != null) {
            return lhVar.a(g4Var, str);
        }
        return null;
    }

    public g4 a(byte[] bArr) {
        lh lhVar = this.u;
        if (lhVar != null) {
            return lhVar.a(bArr);
        }
        return null;
    }

    public final void a(VisualLayerOptions visualLayerOptions) {
        if (visualLayerOptions != null) {
            setAlpha(visualLayerOptions.getAlpha());
            setLevel(visualLayerOptions.getLevel());
            setTimeInterval(visualLayerOptions.getTimeInterval());
            setVisible(visualLayerOptions.isVisible());
            setZIndex(visualLayerOptions.getZIndex());
            enableClick(visualLayerOptions.isClickEnabled());
        }
    }

    public void a(lh lhVar) {
        this.u = lhVar;
    }

    public void a(String str, String str2) {
        ca.a(new g(this, str, str2), 10L);
    }

    public final boolean a(byte[] bArr, boolean z) {
        g4 g4Var;
        g4.b bVar;
        StringBuilder sb = new StringBuilder();
        sb.append("#parseLayerData[");
        sb.append(bArr != null ? bArr.length : 0);
        sb.append("]");
        na.a(ma.x, sb.toString());
        g4 a2 = a(bArr);
        this.r = a2;
        if (a2 != null && this.g != null && a2.a()) {
            this.r = a(this.r, this.g.f(this.p));
            this.g.a(getId(), this.r.b(), this.r.c());
            na.a(ma.x, "创建Protocol对象：成功");
            return true;
        } else if (z && (g4Var = this.r) != null && (bVar = g4Var.f23765a) != null && bVar.f23773a == 0) {
            na.a(ma.x, "创建Protocol对象：网络返回数据版本无变化, 无需更新本地数据");
            return false;
        } else {
            b(3);
            na.g(ma.x, "创建Protocol对象：失败");
            return false;
        }
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer
    public void addLayerStatusChangedListener(VisualLayer.OnLayerStatusChangedListener onLayerStatusChangedListener) {
        if (this.h == null) {
            this.h = new ArrayList();
        }
        this.h.remove(onLayerStatusChangedListener);
        this.h.add(onLayerStatusChangedListener);
    }

    public void b(int i) {
        na.a(ma.x, "notifyStatusChange want from[" + this.t + "]to[" + i + "]");
        ca.a(new f(i), 10L);
    }

    public void b(z3 z3Var) {
        if (z3Var == null) {
            return;
        }
        this.g = z3Var;
        if (z3Var.e(this.p)) {
            z3Var.b(this.p, new a(z3Var));
        } else if (z3Var.c()) {
            b(2);
        } else {
            z3Var.a(this.p);
        }
    }

    public final void c(z3 z3Var) {
        if (z3Var == null) {
            return;
        }
        z3Var.a(this.p, new b(z3Var));
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer
    public void clearCache() {
        z3 z3Var;
        if (isRemoved() || TextUtils.isEmpty(this.p) || (z3Var = this.g) == null) {
            return;
        }
        z3Var.c(this.p);
    }

    public <T extends g4> T d() {
        return (T) this.r;
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void enableClick(boolean z) {
        if (this.o != z) {
            this.o = z;
            VectorOverlay vectorOverlay = this.q;
            if (vectorOverlay != null) {
                vectorOverlay.enableClick(z);
            }
        }
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer
    public String executeCommand(TencentMap tencentMap, String str) {
        CommandFunctionModelClass.BaseCommandFunction a2 = oh.a(str);
        if (a2 == null) {
            return oh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse));
        }
        String str2 = a2.commandFunction;
        if (TextUtils.isEmpty(str2)) {
            return oh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.unsupported));
        }
        na.a(ma.x, "executeCommand functionType: [" + str2 + "]");
        CommandFunctionModelClass.BaseCommandFunction a3 = oh.a(str, str2);
        VectorOverlay vectorOverlay = this.q;
        if (vectorOverlay != null) {
            ReturnInfoModelClass.ReturnStatus executeCommandFunction = vectorOverlay.executeCommandFunction(a3);
            na.a(ma.x, "executeCommand returnJson:" + oh.a(executeCommandFunction));
            return oh.a(executeCommandFunction);
        }
        return oh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.internal));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public ReturnInfoModelClass.ReturnStatus executeCommandFunction(CommandFunctionModelClass.BaseCommandFunction baseCommandFunction) {
        VectorOverlay vectorOverlay = this.q;
        if (vectorOverlay != null) {
            return vectorOverlay.executeCommandFunction(baseCommandFunction);
        }
        return null;
    }

    public int f() {
        return this.k;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable
    public float getAlpha() {
        return this.l;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public String getId() {
        return this.p;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public int getLevel() {
        return this.i;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public String getType() {
        VectorOverlay vectorOverlay = this.q;
        return vectorOverlay == null ? "" : vectorOverlay.getType();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public int getZIndex() {
        return this.j;
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public boolean isClickEnabled() {
        VectorOverlay vectorOverlay = this.q;
        if (vectorOverlay != null) {
            return vectorOverlay.isClickEnabled();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public boolean isRemoved() {
        return this.m;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public boolean isVisible() {
        return this.n;
    }

    public void l() {
        VectorOverlay vectorOverlay = this.q;
        if (vectorOverlay != null) {
            vectorOverlay.remove();
            this.q = null;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public void releaseData() {
        if (isRemoved() || TextUtils.isEmpty(this.p)) {
            return;
        }
        l();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final void remove() {
        List<VisualLayer.OnLayerStatusChangedListener> list = this.h;
        if (list != null) {
            list.clear();
            this.h = null;
        }
        l();
        z3 z3Var = this.g;
        if (z3Var != null) {
            z3Var.b(this.p);
            this.g = null;
        }
        this.m = true;
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer
    public void removeLayerStatusChangedListener(VisualLayer.OnLayerStatusChangedListener onLayerStatusChangedListener) {
        List<VisualLayer.OnLayerStatusChangedListener> list = this.h;
        if (list != null) {
            list.remove(onLayerStatusChangedListener);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable
    public void setAlpha(float f2) {
        if (this.l != f2) {
            this.l = f2;
            VectorOverlay vectorOverlay = this.q;
            if (vectorOverlay != null) {
                vectorOverlay.setOpacity(f2);
            }
        }
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setLevel(int i) {
        if (this.i == i || i == 0) {
            return;
        }
        this.i = i;
        VectorOverlay vectorOverlay = this.q;
        if (vectorOverlay != null) {
            vectorOverlay.setLevel(i);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setOpacity(float f2) {
        setAlpha(f2);
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer
    public void setTimeInterval(int i) {
        if (this.k != i) {
            this.s = true;
            this.k = i;
            if (i > 0 && i < 15) {
                this.k = 15;
            }
            d(this.g);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setVisibility(boolean z) {
        setVisible(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public void setVisible(boolean z) {
        if (this.n != z) {
            this.n = z;
            VectorOverlay vectorOverlay = this.q;
            if (vectorOverlay != null) {
                vectorOverlay.setVisibility(z);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public void setZIndex(float f2) {
        setZIndex((int) f2);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public void setZIndex(int i) {
        if (this.j != i) {
            this.j = i;
            VectorOverlay vectorOverlay = this.q;
            if (vectorOverlay != null) {
                vectorOverlay.setZIndex(i);
            }
        }
    }
}
