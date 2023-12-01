package com.blued.android.module.live_china.view.operation;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveBottomOperationViewBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.FunctionRedPModelJson;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.WishingWellBottomView;
import com.blued.android.module.live_china.view.WishingWellView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.soft.blued.constant.EventBusConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/operation/LiveBottomOperationView.class */
public final class LiveBottomOperationView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15342a;
    private final Lazy b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<LiveRoomOperationModel> f15343c;
    private BaseFragment d;
    private boolean e;
    private WishingWellBottomView f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveBottomOperationView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveBottomOperationView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveBottomOperationView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.f15342a = mContext;
        this.b = LazyKt.a(new Function0<LiveBottomOperationViewBinding>() { // from class: com.blued.android.module.live_china.view.operation.LiveBottomOperationView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveBottomOperationViewBinding invoke() {
                LiveBottomOperationViewBinding a2 = LiveBottomOperationViewBinding.a(LayoutInflater.from(LiveBottomOperationView.this.getMContext()).inflate(R.layout.live_bottom_operation_view, LiveBottomOperationView.this));
                Intrinsics.c(a2, "bind(\n            Layout…ion_view, this)\n        )");
                return a2;
            }
        });
        this.f15343c = new ArrayList<>();
    }

    public /* synthetic */ LiveBottomOperationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a() {
        Iterator<LiveRoomOperationModel> it = this.f15343c.iterator();
        while (it.hasNext()) {
            LiveRoomOperationModel next = it.next();
            int tools_type = next.getTools_type();
            if (tools_type == EnumOperation.VIEW_TYPE_DEFAULT.getValue()) {
                a(next);
            } else if (tools_type == EnumOperation.VIEW_TYPE_WISHING.getValue()) {
                b(next);
            } else {
                a(next);
            }
        }
    }

    private final void a(final LiveRoomOperationModel liveRoomOperationModel) {
        ShapeRelativeLayout redDot;
        if (this.d == null || liveRoomOperationModel == null || TextUtils.isEmpty(liveRoomOperationModel.getIcon())) {
            return;
        }
        final OperationBottomChildH5View h5View = getH5View();
        h5View.a(this.d, liveRoomOperationModel);
        getVb().f12155a.addView(h5View);
        if (liveRoomOperationModel.getRed_point() == 1 && (redDot = h5View.getRedDot()) != null) {
            redDot.setVisibility(0);
        }
        EventTrackLive.r(LiveProtos.Event.LIVE_DOWN_SETTINGS_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveRoomOperationModel.getLink());
        h5View.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveBottomOperationView$CFzvOwXICiNkjFkAcqk8wCOYo8A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBottomOperationView.a(LiveRoomOperationModel.this, h5View, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRoomOperationModel liveRoomOperationModel, OperationBottomChildH5View h5View, View view) {
        Intrinsics.e(h5View, "$h5View");
        LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
        liveRoomFunctionItemModel.setLink(liveRoomOperationModel == null ? null : liveRoomOperationModel.getLink());
        liveRoomFunctionItemModel.setLink_type((liveRoomOperationModel == null ? null : Integer.valueOf(liveRoomOperationModel.getLink_type())).intValue());
        LiveEventBusUtil.a(liveRoomFunctionItemModel);
        if (liveRoomOperationModel.getRed_point_cancel() == 1) {
            LiveRoomHttpUtils.b((BluedUIHttpResponse) null, liveRoomOperationModel.getRed_point_word());
            ShapeRelativeLayout redDot = h5View.getRedDot();
            if (redDot != null) {
                redDot.setVisibility(8);
            }
        }
        EventTrackLive.r(LiveProtos.Event.LIVE_DOWN_SETTINGS_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveRoomFunctionItemModel.getLink());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBottomOperationView this$0, LiveRoomOperationModel model, View view) {
        View view2;
        View view3;
        View view4;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        EventTrackLive.r(LiveProtos.Event.LIVE_DOWN_SETTINGS_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), !TextUtils.isEmpty(WishingWellView.f15314a) ? WishingWellView.f15314a : !TextUtils.isEmpty(LiveRoomManager.a().p().entrance_url) ? LiveRoomManager.a().p().entrance_url : LiveRoomInfo.a().j() ? "https://activity-test.blued.cn/hd/2021/wishing-well/star-site?blued_mode=hide_nav" : "https://activity.blued.cn/hd/2021/wishing-well/star-site?blued_mode=hide_nav");
        LiveSetDataObserver.a().w();
        WishingWellBottomView wishingWellView = this$0.getWishingWellView();
        if ((wishingWellView == null ? null : wishingWellView.f15312a) != null) {
            WishingWellBottomView wishingWellView2 = this$0.getWishingWellView();
            boolean z = false;
            if (wishingWellView2 != null && (view4 = wishingWellView2.f15312a) != null && view4.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                WishingWellBottomView wishingWellView3 = this$0.getWishingWellView();
                if (((wishingWellView3 == null || (view2 = wishingWellView3.f15312a) == null) ? null : view2.getTag()) == null || model.getRed_point_cancel() == 0) {
                    if (model.getRed_point_cancel() == 1) {
                        LiveRoomHttpUtils.b((BluedUIHttpResponse) null, model.getRed_point_word());
                        WishingWellBottomView wishingWellView4 = this$0.getWishingWellView();
                        View view5 = wishingWellView4 == null ? null : wishingWellView4.f15312a;
                        if (view5 == null) {
                            return;
                        }
                        view5.setVisibility(8);
                        return;
                    }
                    return;
                }
                WishingWellBottomView wishingWellView5 = this$0.getWishingWellView();
                Object tag = (wishingWellView5 == null || (view3 = wishingWellView5.f15312a) == null) ? null : view3.getTag();
                if (tag == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.FunctionRedPModelJson");
                }
                FunctionRedPModelJson functionRedPModelJson = (FunctionRedPModelJson) tag;
                String red_point_word = functionRedPModelJson.getRed_point_word();
                if (functionRedPModelJson.getRed_point_cancel()) {
                    LiveRoomHttpUtils.b((BluedUIHttpResponse) null, red_point_word);
                    WishingWellBottomView wishingWellView6 = this$0.getWishingWellView();
                    View view6 = wishingWellView6 == null ? null : wishingWellView6.f15312a;
                    if (view6 == null) {
                        return;
                    }
                    view6.setVisibility(8);
                }
            }
        }
    }

    private final void b(final LiveRoomOperationModel liveRoomOperationModel) {
        if (this.d == null || liveRoomOperationModel == null || TextUtils.isEmpty(liveRoomOperationModel.getIcon())) {
            return;
        }
        WishingWellBottomView wishingWellBottomView = this.f;
        if (wishingWellBottomView != null && wishingWellBottomView.getParent() != null) {
            ViewParent parent = wishingWellBottomView.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(wishingWellBottomView);
        }
        LiveRoomManager.a().p().entrance_icon = liveRoomOperationModel.getIcon();
        getVb().f12155a.addView(getWishingWellView());
        boolean z = false;
        if (liveRoomOperationModel.getRed_point() == 1) {
            WishingWellBottomView wishingWellView = getWishingWellView();
            View view = wishingWellView == null ? null : wishingWellView.f15312a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
        EventTrackLive.r(LiveProtos.Event.LIVE_DOWN_SETTINGS_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveRoomOperationModel.getLink());
        WishingWellBottomView wishingWellView2 = getWishingWellView();
        if (wishingWellView2 != null) {
            wishingWellView2.setIcon(liveRoomOperationModel.getIcon());
        }
        WishingWellBottomView wishingWellView3 = getWishingWellView();
        if (wishingWellView3 != null) {
            wishingWellView3.setRedPointWord(liveRoomOperationModel.getRed_point_word());
        }
        WishingWellBottomView wishingWellView4 = getWishingWellView();
        if (wishingWellView4 != null) {
            wishingWellView4.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveBottomOperationView$sXlIqK-ad_83THqRAOEusUpjs3c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveBottomOperationView.a(LiveBottomOperationView.this, liveRoomOperationModel, view2);
                }
            });
        }
        Observable<Object> observable = LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_LUCK_TURNING_BTN);
        if (LiveRoomManager.a().p().entrance_status == 1) {
            z = true;
        }
        observable.post(Boolean.valueOf(z));
    }

    private final LiveBottomOperationViewBinding getVb() {
        return (LiveBottomOperationViewBinding) this.b.getValue();
    }

    public final void a(BaseFragment baseFragment, boolean z) {
        if (baseFragment != null) {
            this.d = baseFragment;
        }
        this.e = z;
    }

    public final void a(List<LiveRoomOperationModel> list) {
        if (list == null) {
            return;
        }
        CollectionsKt.a((Iterable) list, new Comparator() { // from class: com.blued.android.module.live_china.view.operation.LiveBottomOperationView$dataSort$lambda-3$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.a(Float.valueOf(((LiveRoomOperationModel) t).getWeight()), Float.valueOf(((LiveRoomOperationModel) t2).getWeight()));
            }
        });
    }

    public final OperationBottomChildH5View getH5View() {
        return new OperationBottomChildH5View(this.f15342a);
    }

    public final Context getMContext() {
        return this.f15342a;
    }

    public final List<View> getViewList() {
        ArrayList arrayList = new ArrayList();
        int childCount = getVb().f12155a.getChildCount() - 1;
        if (childCount >= 0) {
            while (true) {
                int i = childCount - 1;
                View childAt = getVb().f12155a.getChildAt(childCount);
                if (childAt != null) {
                    arrayList.add(childAt);
                }
                if (i < 0) {
                    break;
                }
                childCount = i;
            }
        }
        return arrayList;
    }

    public final WishingWellBottomView getWishingWellView() {
        if (this.f == null) {
            WishingWellBottomView wishingWellBottomView = new WishingWellBottomView(this.f15342a, null);
            this.f = wishingWellBottomView;
            if (wishingWellBottomView != null) {
                wishingWellBottomView.setBaseFragment(this.d);
            }
        }
        return this.f;
    }

    public final void setData(List<LiveRoomOperationModel> list) {
        if (list == null) {
            return;
        }
        a(list);
        this.f15343c = (ArrayList) list;
        a();
    }
}
