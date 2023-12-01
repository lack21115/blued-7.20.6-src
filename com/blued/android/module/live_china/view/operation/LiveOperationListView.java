package com.blued.android.module.live_china.view.operation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveOperationListViewBinding;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.view.LiveRechargeGiftBagView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/operation/LiveOperationListView.class */
public final class LiveOperationListView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15350a;
    private final Lazy b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<LiveRoomOperationModel> f15351c;
    private final ArrayList<OperationChildView> d;
    private BaseFragment e;
    private boolean f;
    private int g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveOperationListView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveOperationListView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveOperationListView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.f15350a = mContext;
        this.b = LazyKt.a(new Function0<LiveOperationListViewBinding>() { // from class: com.blued.android.module.live_china.view.operation.LiveOperationListView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveOperationListViewBinding invoke() {
                LiveOperationListViewBinding a2 = LiveOperationListViewBinding.a(LayoutInflater.from(LiveOperationListView.this.getMContext()).inflate(R.layout.live_operation_list_view, LiveOperationListView.this));
                Intrinsics.c(a2, "bind(\n            Layout…ist_view, this)\n        )");
                return a2;
            }
        });
        this.f15351c = new ArrayList<>();
        this.d = new ArrayList<>();
        this.g = -1;
    }

    public /* synthetic */ LiveOperationListView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a() {
        OperationChildView a2;
        Iterator<LiveRoomOperationModel> it = this.f15351c.iterator();
        while (it.hasNext()) {
            LiveRoomOperationModel next = it.next();
            if (next.getStatus() == 1 && (a2 = new OperationChildView(this.f15350a).a(this.e, this.f, next, (Object) null)) != null) {
                LiveRoomOperationModel model = a2.getModel();
                if (model != null && model.getStatus() == 1) {
                    this.d.add(a2);
                    LiveRoomOperationModel model2 = a2.getModel();
                    if (!(model2 != null && model2.getTools_type() == EnumOperation.VIEW_TYPE_TREASURE_BOX.getValue()) || this.g == -1) {
                        getVb().f12312a.addView(a2);
                    } else {
                        getVb().f12312a.addView(a2, this.g);
                        this.g = -1;
                    }
                    LiveRoomOperationModel model3 = a2.getModel();
                    if (model3 != null && model3.getView_init_finish()) {
                        a2.c();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOperationListView this$0, OperationChildView it, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        ArrayList<OperationChildView> arrayList = this$0.d;
        if (arrayList != null) {
            arrayList.remove(it);
        }
        this$0.getVb().f12312a.removeView(it);
        if ((i == EnumOperation.VIEW_TYPE_RECHARGE_GIFT_BAG.getValue() || i == EnumOperation.VIEW_TYPE_FIRST_RECHARGE_GIFT_BAG.getValue()) && (it.getView() instanceof LiveRechargeGiftBagView)) {
            View view = it.getView();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.view.LiveRechargeGiftBagView");
            }
            ((LiveRechargeGiftBagView) view).a();
        }
    }

    private final void a(OperationChildView operationChildView, int i, LiveRoomOperationModel liveRoomOperationModel) {
        if (operationChildView != null) {
            if (operationChildView.a()) {
                boolean b = operationChildView.b();
                OperationChildView operationChildView2 = operationChildView;
                getVb().f12312a.removeView(operationChildView2);
                getVb().f12312a.addView(operationChildView2, i);
                if (b) {
                    operationChildView.setShow(false);
                    operationChildView.c();
                }
            } else {
                liveRoomOperationModel.setCurrent_weight(liveRoomOperationModel.getWeight());
            }
        }
        this.g = -1;
    }

    private final void b() {
        View splitLine;
        ArrayList<OperationChildView> arrayList = this.d;
        OperationChildView operationChildView = null;
        OperationChildView operationChildView2 = null;
        if (arrayList != null) {
            Iterator<OperationChildView> it = arrayList.iterator();
            while (true) {
                operationChildView = operationChildView2;
                if (!it.hasNext()) {
                    break;
                }
                OperationChildView next = it.next();
                View splitLine2 = next.getSplitLine();
                boolean z = false;
                if (splitLine2 != null) {
                    splitLine2.setVisibility(0);
                }
                if (next.a()) {
                    LiveRoomOperationModel model = next.getModel();
                    if (model != null && model.getView_init_finish()) {
                        z = true;
                    }
                    if (z) {
                        operationChildView2 = next;
                    }
                }
            }
        }
        if (operationChildView == null || (splitLine = operationChildView.getSplitLine()) == null) {
            return;
        }
        splitLine.setVisibility(8);
    }

    private final LiveOperationListViewBinding getVb() {
        return (LiveOperationListViewBinding) this.b.getValue();
    }

    private final void setData(List<LiveRoomOperationModel> list) {
        getVb().f12312a.removeAllViews();
        if (list == null) {
            return;
        }
        if (list == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.blued.android.module.live_china.model.LiveRoomOperationModel>{ kotlin.collections.TypeAliasesKt.ArrayList<com.blued.android.module.live_china.model.LiveRoomOperationModel> }");
        }
        this.f15351c = (ArrayList) list;
        a();
        b();
    }

    public final OperationChildView a(int i) {
        LiveRoomOperationModel model;
        Iterator<OperationChildView> it = this.d.iterator();
        while (it.hasNext()) {
            OperationChildView next = it.next();
            boolean z = false;
            if (next != null && (model = next.getModel()) != null && model.getTools_type() == i) {
                z = true;
            }
            if (z) {
                return next;
            }
        }
        return null;
    }

    public final void a(int i, LiveRoomOperationModel model, Object data) {
        int i2;
        int i3;
        Intrinsics.e(model, "model");
        Intrinsics.e(data, "data");
        if (this.e == null) {
            return;
        }
        Iterator<OperationChildView> it = this.d.iterator();
        boolean z = false;
        int i4 = 0;
        while (true) {
            i2 = i4;
            if (!it.hasNext()) {
                break;
            }
            LiveRoomOperationModel model2 = it.next().getModel();
            Float valueOf = model2 == null ? null : Float.valueOf(model2.getCurrent_weight());
            Intrinsics.a(valueOf);
            if (valueOf.floatValue() >= model.getCurrent_weight()) {
                break;
            }
            i4 = i2 + 1;
        }
        OperationChildView a2 = new OperationChildView(this.f15350a).a(this.e, this.f, model, data);
        if (a2 == null) {
            return;
        }
        LiveRoomOperationModel model3 = a2.getModel();
        if (model3 != null && model3.getTools_type() == EnumOperation.VIEW_TYPE_TREASURE_BOX.getValue()) {
            z = true;
        }
        if (!z || (i3 = this.g) == -1) {
            this.d.add(i2, a2);
            getVb().f12312a.addView(a2, i2);
        } else {
            this.d.add(i3, a2);
            getVb().f12312a.addView(a2, this.g);
            this.g = -1;
        }
        if (model.getView_init_finish()) {
            a2.c();
        }
    }

    public final void a(BaseFragment baseFragment, boolean z, List<LiveRoomOperationModel> list) {
        if (baseFragment != null) {
            this.e = baseFragment;
        }
        this.f = z;
        setData(list);
    }

    public final void a(boolean z) {
        LiveRoomOperationModel liveRoomOperationModel;
        int i;
        Iterator<LiveRoomOperationModel> it = this.f15351c.iterator();
        while (true) {
            if (!it.hasNext()) {
                liveRoomOperationModel = null;
                break;
            }
            liveRoomOperationModel = it.next();
            if (liveRoomOperationModel.getTools_type() == EnumOperation.VIEW_TYPE_TREASURE_BOX.getValue()) {
                liveRoomOperationModel.setStatus(1);
                break;
            }
        }
        if (liveRoomOperationModel == null) {
            return;
        }
        Iterator<OperationChildView> it2 = this.d.iterator();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (!it2.hasNext()) {
                break;
            }
            LiveRoomOperationModel model = it2.next().getModel();
            Float valueOf = model == null ? null : Float.valueOf(model.getCurrent_weight());
            Intrinsics.a(valueOf);
            if (valueOf.floatValue() >= liveRoomOperationModel.getCurrent_weight()) {
                break;
            }
            i3 = i + 1;
        }
        liveRoomOperationModel.setCurrent_weight(z ? liveRoomOperationModel.getDynamic_weight() : liveRoomOperationModel.getWeight());
        Iterator<OperationChildView> it3 = this.d.iterator();
        while (it3.hasNext()) {
            LiveRoomOperationModel model2 = it3.next().getModel();
            Float valueOf2 = model2 == null ? null : Float.valueOf(model2.getCurrent_weight());
            Intrinsics.a(valueOf2);
            if (valueOf2.floatValue() >= liveRoomOperationModel.getCurrent_weight()) {
                break;
            }
            i2++;
        }
        if (i != i2) {
            OperationChildView a2 = a(EnumOperation.VIEW_TYPE_TREASURE_BOX.getValue());
            if (a2 == null) {
                this.g = i2;
            } else {
                a(a2, i2, liveRoomOperationModel);
            }
        }
    }

    public final void b(final int i) {
        final OperationChildView a2 = a(i);
        if (a2 == null) {
            return;
        }
        a2.a(new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationListView$dowWWiT8LaPOI7mDchqu75F6TBk
            @Override // java.lang.Runnable
            public final void run() {
                LiveOperationListView.a(LiveOperationListView.this, a2, i);
            }
        });
        b();
    }

    public final Context getMContext() {
        return this.f15350a;
    }

    public final int getShowChildCount() {
        Iterator<OperationChildView> it = this.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            OperationChildView next = it.next();
            LiveRoomOperationModel model = next.getModel();
            if (model != null && next.getView() != null && next.a() && model.getView_init_finish()) {
                i++;
            }
        }
        return i;
    }
}
