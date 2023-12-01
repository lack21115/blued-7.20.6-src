package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLiveRoomFuctionBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.ConstFunction;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveRoomFunctionModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRoomFunctionDlgFragment.class */
public final class LiveRoomFunctionDlgFragment extends BottomSheetDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13241a = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private CommonAdapter<LiveRoomFunctionModel> f13242c;
    private boolean e;
    private final Lazy b = LazyKt.a(new Function0<FragmentLiveRoomFuctionBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveRoomFunctionDlgFragment$viewBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final FragmentLiveRoomFuctionBinding invoke() {
            return FragmentLiveRoomFuctionBinding.a(LayoutInflater.from(LiveRoomFunctionDlgFragment.this.getContext()));
        }
    });
    private int d = 130;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRoomFunctionDlgFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveRoomFunctionDlgFragment a(FragmentManager manager, boolean z) {
            Intrinsics.e(manager, "manager");
            LiveRoomFunctionDlgFragment liveRoomFunctionDlgFragment = new LiveRoomFunctionDlgFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("type", z);
            liveRoomFunctionDlgFragment.setArguments(bundle);
            liveRoomFunctionDlgFragment.show(manager, LiveRoomFunctionDlgFragment.class.getSimpleName());
            return liveRoomFunctionDlgFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(LiveRoomFunctionItemModel liveRoomFunctionItemModel) {
        if (liveRoomFunctionItemModel == null) {
            return;
        }
        EventTrackLive.r(LiveProtos.Event.LIVE_DOWN_COLLECTION_FEATURE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveRoomFunctionItemModel.getLink());
        if (Intrinsics.a((Object) liveRoomFunctionItemModel.getLink(), (Object) ConstFunction.LIVE_ROOM_GIFT_ANIMATION)) {
            LiveRoomManager.a().b(!LiveRoomManager.a().H());
            ToastUtils.a(LiveRoomManager.a().H() ? this.e ? R.string.live_gift_anim_switch_host_on : R.string.live_gift_anim_switch_on : this.e ? R.string.live_gift_anim_switch_host_off : R.string.live_gift_anim_switch_off);
            EventTrackLive.o(LiveProtos.Event.LIVE_GIFT_EFFECT_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), LiveRoomManager.a().H() ? "open" : "close");
        }
        n();
        LiveEventBusUtil.a(liveRoomFunctionItemModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(LiveRoomFunctionItemModel liveRoomFunctionItemModel, View view) {
        if (LiveRoomManager.a().p().red_point == null || liveRoomFunctionItemModel == null || TextUtils.isEmpty(liveRoomFunctionItemModel.getAction())) {
            if (view == null) {
                return;
            }
            view.setVisibility(8);
        } else if (StringUtils.a(LiveRoomManager.a().p().red_point.get(liveRoomFunctionItemModel.getAction()), 0L) > StringUtils.a(LiveRoomPreferences.B(liveRoomFunctionItemModel.getAction()), 0L)) {
            if (view == null) {
                return;
            }
            view.setVisibility(0);
        } else if (view == null) {
        } else {
            view.setVisibility(8);
        }
    }

    private final void l() {
        this.d = (int) ((AppInfo.l - DisplayUtil.a(getContext(), 7.5f)) / 5.5f);
        final int i = R.layout.item_live_room_fuction;
        this.f13242c = new CommonAdapter<LiveRoomFunctionModel>(i) { // from class: com.blued.android.module.live_china.fragment.LiveRoomFunctionDlgFragment$onInitView$1
            @Override // com.blued.android.module.common.adapter.CommonAdapter
            public void a(CommonAdapter.ViewHolder viewHolder, LiveRoomFunctionModel liveRoomFunctionModel, int i2) {
                if (viewHolder != null) {
                    viewHolder.a(R.id.item_live_room_func_title, liveRoomFunctionModel == null ? null : liveRoomFunctionModel.getTitle());
                }
                RecyclerView recyclerView = viewHolder == null ? null : (RecyclerView) viewHolder.a(R.id.item_live_room_func_rv);
                if (recyclerView != null) {
                    if (recyclerView.getAdapter() == null) {
                        recyclerView.setAdapter(new LiveRoomFunctionDlgFragment$onInitView$1$convert$1(LiveRoomFunctionDlgFragment.this, LiveRoomFunctionDlgFragment.this.getContext()));
                        recyclerView.setLayoutManager(new LinearLayoutManager(LiveRoomFunctionDlgFragment.this.getContext(), 0, false));
                    }
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    if (adapter == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.adapter.CommonRecycleAdapter<com.blued.android.module.live_china.model.LiveRoomFunctionItemModel>");
                    }
                    ((CommonRecycleAdapter) adapter).setDataAndNotify(liveRoomFunctionModel == null ? null : liveRoomFunctionModel.getData());
                    recyclerView.setHasFixedSize(true);
                }
            }
        };
        h().f11971a.setAdapter((ListAdapter) this.f13242c);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private final void m() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private final void n() {
        dismissAllowingStateLoss();
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public void a(BottomSheetDialog bottomSheetDialog, boolean z) {
        super.a(bottomSheetDialog, z);
        BottomSheetBehavior<FrameLayout> a2 = bottomSheetDialog == null ? null : bottomSheetDialog.a();
        if (a2 == null) {
            return;
        }
        a2.d(z);
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public boolean e() {
        return true;
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public boolean f() {
        return false;
    }

    public final FragmentLiveRoomFuctionBinding h() {
        return (FragmentLiveRoomFuctionBinding) this.b.getValue();
    }

    public final CommonAdapter<LiveRoomFunctionModel> i() {
        return this.f13242c;
    }

    public final int j() {
        return this.d;
    }

    public final boolean k() {
        return this.e;
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(h().getRoot());
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null && arguments.getBoolean("type")) {
            z = true;
        }
        this.e = z;
        l();
        m();
    }
}
