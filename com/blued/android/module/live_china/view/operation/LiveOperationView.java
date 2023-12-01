package com.blued.android.module.live_china.view.operation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveOperationViewBinding;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.view.GrabBoxView;
import com.blued.android.module.live_china.view.GrabRewardView;
import com.blued.android.module.live_china.view.LiveWishCourtView;
import com.blued.android.module.live_china.view.WishingWellView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/operation/LiveOperationView.class */
public final class LiveOperationView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15353a;
    private final Lazy b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<LiveRoomOperationModel> f15354c;
    private HashMap<Integer, Object> d;
    private BaseFragment e;
    private ArrayList<LiveRoomOperationModel> f;
    private boolean g;
    private LiveRoomOperationModel h;
    private int i;
    private boolean j;
    private final DecelerateInterpolator k;
    private final long l;
    private final long m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveOperationView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveOperationView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveOperationView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.f15353a = mContext;
        this.b = LazyKt.a(new Function0<LiveOperationViewBinding>() { // from class: com.blued.android.module.live_china.view.operation.LiveOperationView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveOperationViewBinding invoke() {
                LiveOperationViewBinding a2 = LiveOperationViewBinding.a(LayoutInflater.from(LiveOperationView.this.getMContext()).inflate(R.layout.live_operation_view, LiveOperationView.this));
                Intrinsics.c(a2, "bind(\n            Layout…ion_view, this)\n        )");
                return a2;
            }
        });
        this.f15354c = new ArrayList<>();
        this.d = new HashMap<>();
        this.f = new ArrayList<>();
        this.k = new DecelerateInterpolator(2.0f);
        this.l = 560L;
        this.m = 1050L;
    }

    public /* synthetic */ LiveOperationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a(int i, LiveRoomOperationModel liveRoomOperationModel) {
        if (liveRoomOperationModel.getStatus() != 1 || liveRoomOperationModel.getDesc_type() != 1 || TextUtils.isEmpty(liveRoomOperationModel.getDesc()) || TextUtils.isEmpty(liveRoomOperationModel.getDesc_icon())) {
            return;
        }
        if (i < 0 || i > this.f.size()) {
            this.f.add(liveRoomOperationModel);
        } else {
            this.f.add(i, liveRoomOperationModel);
        }
    }

    private final void a(LiveRoomOperationModel liveRoomOperationModel) {
        int i;
        if (liveRoomOperationModel.getDesc_type() != 1) {
            c(liveRoomOperationModel.getTools_type());
        } else if (this.f.isEmpty()) {
            b(liveRoomOperationModel);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationView$JSfdHEvN1UhdISHzedZYxGb9qD4
                @Override // java.lang.Runnable
                public final void run() {
                    LiveOperationView.f(LiveOperationView.this);
                }
            }, this.l);
        } else {
            c(liveRoomOperationModel.getTools_type());
            int i2 = 0;
            Iterator<LiveRoomOperationModel> it = this.f.iterator();
            while (it.hasNext()) {
                if (it.next().getCurrent_weight() < liveRoomOperationModel.getCurrent_weight()) {
                    i2++;
                }
            }
            int i3 = i2;
            if (i2 > this.f.size()) {
                i3 = this.f.size();
            }
            if (!this.g || this.f.size() < (i = i3 + 1)) {
                a(i3, liveRoomOperationModel);
            } else {
                a(i, liveRoomOperationModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOperationView this$0, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(animation, "animation");
        ViewGroup.LayoutParams layoutParams = this$0.getVb().f12313a.getLayoutParams();
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        layoutParams.width = ((Integer) animatedValue).intValue();
        this$0.getVb().f12313a.setLayoutParams(this$0.getVb().f12313a.getLayoutParams());
    }

    private final void b(LiveRoomOperationModel liveRoomOperationModel) {
        a(-1, liveRoomOperationModel);
    }

    private final boolean b(LiveRoomOperationModel liveRoomOperationModel, LiveRoomOperationModel liveRoomOperationModel2) {
        if (liveRoomOperationModel == null) {
            return true;
        }
        if (TextUtils.isEmpty(liveRoomOperationModel.getDesc()) && TextUtils.isEmpty(liveRoomOperationModel2.getDesc())) {
            return false;
        }
        if (TextUtils.isEmpty(liveRoomOperationModel.getDesc()) != TextUtils.isEmpty(liveRoomOperationModel2.getDesc())) {
            return true;
        }
        return !liveRoomOperationModel.getDesc().equals(liveRoomOperationModel2.getDesc());
    }

    private final void c() {
        Iterator<LiveRoomOperationModel> it = this.f15354c.iterator();
        while (it.hasNext()) {
            LiveRoomOperationModel it2 = it.next();
            if (it2.getStatus() == 1 && it2.getDesc_type() != 1) {
                break;
            }
            Intrinsics.c(it2, "it");
            b(it2);
        }
        if (!this.f.isEmpty()) {
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationView$viImQzcIjhnXlH81x38-o8-d--o
                @Override // java.lang.Runnable
                public final void run() {
                    LiveOperationView.e(LiveOperationView.this);
                }
            }, this.m + ((long) PushConstants.DOWN_LOAD_LARGE_ICON_ERROR));
        }
    }

    private final void c(int i) {
        Iterator<LiveRoomOperationModel> it = this.f.iterator();
        Intrinsics.c(it, "descList.iterator()");
        while (it.hasNext()) {
            LiveRoomOperationModel next = it.next();
            Intrinsics.c(next, "iterator.next()");
            if (next.getTools_type() == i) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(LiveRoomOperationModel liveRoomOperationModel) {
        setCurrentShowDesc(true);
        setCurrentShowDesc(liveRoomOperationModel);
        a(this.m);
        LiveOperationDescView liveOperationDescView = getVb().b;
        BaseFragment baseFragment = this.e;
        liveOperationDescView.a(baseFragment == null ? null : baseFragment.getFragmentActive(), liveRoomOperationModel);
        getVb().f12314c.animate().translationY(-DensityUtils.a(getContext(), 45.0f)).setInterpolator(this.k).setDuration(this.m).start();
        getVb().b.animate().translationY(0.0f).setInterpolator(this.k).setDuration(this.m).setListener(new LiveOperationView$startShowDesc$1$1(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        this.g = false;
        if (CollectionsKt.a((Iterable<? extends LiveRoomOperationModel>) this.f, this.h)) {
            ArrayList<LiveRoomOperationModel> arrayList = this.f;
            TypeIntrinsics.c(arrayList).remove(this.h);
        }
        a(this.m);
        int a2 = DensityUtils.a(getContext(), 45.0f);
        getVb().f12314c.animate().translationY(0.0f).setDuration(this.m).start();
        getVb().b.animate().translationY(a2).setDuration(this.m).setListener(new LiveOperationView$goBackToList$1(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveOperationView this$0) {
        Intrinsics.e(this$0, "this$0");
        if (!this$0.f.isEmpty()) {
            LiveRoomOperationModel liveRoomOperationModel = this$0.f.get(0);
            Intrinsics.c(liveRoomOperationModel, "descList[0]");
            this$0.c(liveRoomOperationModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LiveOperationView this$0) {
        Intrinsics.e(this$0, "this$0");
        if (!this$0.f.isEmpty()) {
            LiveRoomOperationModel liveRoomOperationModel = this$0.f.get(0);
            Intrinsics.c(liveRoomOperationModel, "descList[0]");
            this$0.c(liveRoomOperationModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveOperationViewBinding getVb() {
        return (LiveOperationViewBinding) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setData$lambda-3$lambda-2  reason: not valid java name */
    public static final void m4301setData$lambda3$lambda2(LiveOperationView this$0) {
        Intrinsics.e(this$0, "this$0");
        for (Map.Entry<Integer, Object> entry : this$0.d.entrySet()) {
            this$0.a(entry.getKey().intValue(), entry.getValue());
        }
    }

    public final LiveRoomOperationModel a(LiveRoomOperationModel liveRoomOperationModel, LiveRoomOperationModel data) {
        Intrinsics.e(data, "data");
        if (liveRoomOperationModel != null || data.is_grpc()) {
            if (liveRoomOperationModel == null) {
                return liveRoomOperationModel;
            }
            liveRoomOperationModel.setStatus(data.getStatus());
            liveRoomOperationModel.setBadge_text(data.getBadge_text());
            liveRoomOperationModel.setTitle(data.getTitle());
            liveRoomOperationModel.setIcon(data.getIcon());
            liveRoomOperationModel.setDesc_type(data.getDesc_type());
            liveRoomOperationModel.setDesc(data.getDesc());
            liveRoomOperationModel.setDesc_icon(data.getDesc_icon());
            liveRoomOperationModel.setCountdown(data.getCountdown());
            liveRoomOperationModel.setCountdonw_type(data.getCountdonw_type());
            liveRoomOperationModel.setGet_countdown_timemillis(data.getGet_countdown_timemillis());
            if (liveRoomOperationModel.getCurrent_weight() == 0.0f) {
                liveRoomOperationModel.setCurrent_weight(liveRoomOperationModel.getWeight());
            }
            return liveRoomOperationModel;
        }
        return data;
    }

    public final List<LiveRoomOperationModel> a(List<LiveRoomOperationModel> model) {
        Intrinsics.e(model, "model");
        return CollectionsKt.a((Iterable) model, new Comparator() { // from class: com.blued.android.module.live_china.view.operation.LiveOperationView$dataSort$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.a(Float.valueOf(((LiveRoomOperationModel) t).getCurrent_weight()), Float.valueOf(((LiveRoomOperationModel) t2).getCurrent_weight()));
            }
        });
    }

    public final void a() {
        a(this.l);
    }

    public final void a(int i) {
        getVb().f12314c.b(i);
        a();
        ArrayList<LiveRoomOperationModel> arrayList = this.f;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (this.g && this.f.get(0).getTools_type() == i) {
            return;
        }
        c(i);
    }

    public final void a(int i, Object obj) {
        LiveRoomOperationModel liveRoomOperationModel;
        LiveRoomOperationModel liveRoomOperationModel2;
        boolean z;
        LiveRoomOperationModel liveRoomOperationModel3;
        ArrayList<LiveRoomOperationModel> arrayList = this.f15354c;
        if ((arrayList == null ? null : Boolean.valueOf(arrayList.isEmpty())).booleanValue()) {
            this.d.put(Integer.valueOf(i), obj);
        } else if (obj == null) {
            a(i);
        } else {
            boolean z2 = obj instanceof LiveRoomOperationModel;
            boolean z3 = true;
            if (z2) {
                LiveRoomOperationModel liveRoomOperationModel4 = (LiveRoomOperationModel) obj;
                if (liveRoomOperationModel4.getStatus() != 1) {
                    LiveRoomOperationModel b = b(i);
                    if (b != null) {
                        a(b, liveRoomOperationModel4);
                    }
                    a(i);
                    return;
                }
            }
            LiveOperationListView liveOperationListView = getVb().f12314c;
            OperationChildView a2 = liveOperationListView.a(i);
            if (a2 != null) {
                if ((a2.getView() instanceof OperationChildDefaultView) && z2) {
                    LiveRoomOperationModel model = a2.getModel();
                    LiveRoomOperationModel liveRoomOperationModel5 = (LiveRoomOperationModel) obj;
                    z = b(model, liveRoomOperationModel5);
                    a2.setModel(a(a2.getModel(), liveRoomOperationModel5));
                    liveRoomOperationModel3 = a2.getModel();
                    if (liveRoomOperationModel3 != null && a2.b(liveRoomOperationModel3)) {
                        a2.c();
                    }
                } else {
                    z = false;
                    liveRoomOperationModel3 = null;
                }
                if ((a2.getView() instanceof GrabRewardView) && a2.b(obj)) {
                    a2.c();
                }
                if ((a2.getView() instanceof WishingWellView) && a2.b(obj)) {
                    a2.c();
                }
                if ((a2.getView() instanceof GrabBoxView) && a2.b(obj)) {
                    a2.c();
                }
                liveRoomOperationModel2 = liveRoomOperationModel3;
                z3 = z;
                if (a2.getView() instanceof LiveWishCourtView) {
                    liveRoomOperationModel2 = liveRoomOperationModel3;
                    z3 = z;
                    if (a2.b(obj)) {
                        a2.c();
                        liveRoomOperationModel2 = liveRoomOperationModel3;
                        z3 = z;
                    }
                }
            } else {
                Iterator<LiveRoomOperationModel> it = this.f15354c.iterator();
                while (true) {
                    liveRoomOperationModel = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    liveRoomOperationModel = it.next();
                    if (liveRoomOperationModel.getTools_type() == i) {
                        liveRoomOperationModel.setStatus(1);
                        if (z2) {
                            liveRoomOperationModel = a(liveRoomOperationModel, (LiveRoomOperationModel) obj);
                        }
                    }
                }
                if (liveRoomOperationModel == null) {
                    return;
                }
                liveOperationListView.a(i, liveRoomOperationModel, obj);
                if (liveRoomOperationModel.getStatus() != 1 || liveRoomOperationModel.getDesc_type() != 1 || TextUtils.isEmpty(liveRoomOperationModel.getDesc()) || TextUtils.isEmpty(liveRoomOperationModel.getDesc_icon())) {
                    z3 = false;
                    liveRoomOperationModel2 = liveRoomOperationModel;
                } else {
                    liveRoomOperationModel2 = liveRoomOperationModel;
                }
            }
            a();
            if (!z3 || liveRoomOperationModel2 == null) {
                return;
            }
            a(liveRoomOperationModel2);
        }
    }

    public final void a(long j) {
        int b = b();
        int i = this.i;
        if (i != b) {
            boolean z = i < b;
            if (z) {
                getVb().getRoot().getLayoutParams().width = b;
                getVb().getRoot().setLayoutParams(getVb().getRoot().getLayoutParams());
                if (getVisibility() != 0) {
                    setVisibility(0);
                }
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.i, b);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationView$Ji7qttmK3ZkaWUG5HmnCTV9sKQg
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LiveOperationView.a(LiveOperationView.this, valueAnimator);
                }
            });
            if (!z) {
                ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.operation.LiveOperationView$refreshBackgroundWidth$2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        Intrinsics.e(animation, "animation");
                        super.onAnimationEnd(animation);
                        LiveOperationView.this.getLayoutParams().width = LiveOperationView.this.getCurrentWidth();
                        LiveOperationView liveOperationView = LiveOperationView.this;
                        liveOperationView.setLayoutParams(liveOperationView.getLayoutParams());
                        if (LiveOperationView.this.getCurrentWidth() != 0 || LiveOperationView.this.getVisibility() == 8) {
                            return;
                        }
                        LiveOperationView.this.setVisibility(8);
                    }
                });
            }
            ofInt.setDuration(j);
            ofInt.setInterpolator(this.k);
            ofInt.start();
            this.i = b;
        }
    }

    public final void a(BaseFragment baseFragment, boolean z) {
        if (baseFragment != null) {
            this.e = baseFragment;
        }
        this.j = z;
    }

    public final void a(boolean z) {
        LiveOperationListView liveOperationListView;
        LiveOperationViewBinding vb = getVb();
        if (vb == null || (liveOperationListView = vb.f12314c) == null) {
            return;
        }
        liveOperationListView.a(z);
    }

    public final int b() {
        if (this.g) {
            return DensityUtils.a(getContext(), 130.0f);
        }
        int showChildCount = getVb().f12314c.getShowChildCount();
        if (showChildCount != 0) {
            return showChildCount != 1 ? showChildCount != 2 ? DensityUtils.a(getContext(), 130.0f) : DensityUtils.a(getContext(), 87.5f) : DensityUtils.a(getContext(), 45.0f);
        }
        return 0;
    }

    public final LiveRoomOperationModel b(int i) {
        ArrayList<LiveRoomOperationModel> arrayList = this.f15354c;
        if (arrayList == null) {
            return null;
        }
        for (LiveRoomOperationModel liveRoomOperationModel : arrayList) {
            if (liveRoomOperationModel.getTools_type() == i) {
                return liveRoomOperationModel;
            }
        }
        return null;
    }

    public final LiveRoomOperationModel getCurrentShowDesc() {
        return this.h;
    }

    public final int getCurrentWidth() {
        return this.i;
    }

    public final Context getMContext() {
        return this.f15353a;
    }

    public final void setCurrentShowDesc(LiveRoomOperationModel liveRoomOperationModel) {
        this.h = liveRoomOperationModel;
    }

    public final void setCurrentShowDesc(boolean z) {
        this.g = z;
    }

    public final void setCurrentWidth(int i) {
        this.i = i;
    }

    public final void setData(ArrayList<LiveRoomOperationModel> data) {
        Intrinsics.e(data, "data");
        if (data.isEmpty()) {
            return;
        }
        this.f15354c.clear();
        this.f15354c.addAll(a(data));
        getVb().f12314c.a(this.e, this.j, this.f15354c);
        a();
        c();
        HashMap<Integer, Object> hashMap = this.d;
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationView$BP4qrvdJOnlYpJ1AOHcTRCY3O_8
            @Override // java.lang.Runnable
            public final void run() {
                LiveOperationView.m4301setData$lambda3$lambda2(LiveOperationView.this);
            }
        }, 100L);
    }
}
