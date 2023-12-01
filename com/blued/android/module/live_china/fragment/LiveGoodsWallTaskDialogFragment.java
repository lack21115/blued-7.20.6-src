package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveGoodsWallTaskBinding;
import com.blued.android.module.live_china.fitem.FitemGoodsWallTask;
import com.blued.android.module.live_china.fitem.FitemGoodsWallTaskExplain;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.GoodsWallTaskDataModel;
import com.blued.android.module.live_china.model.GoodsWallTaskItemModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGoodsWallTaskDialogFragment.class */
public final class LiveGoodsWallTaskDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private boolean c;
    private BaseFragment d;
    private FreedomAdapter f;
    private final Lazy b = LazyKt.a(new Function0<DialogLiveGoodsWallTaskBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveGoodsWallTaskDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveGoodsWallTaskBinding invoke() {
            return DialogLiveGoodsWallTaskBinding.a(LayoutInflater.from(LiveGoodsWallTaskDialogFragment.this.getContext()));
        }
    });
    private final ArrayList<FreedomItem> e = new ArrayList<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGoodsWallTaskDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveGoodsWallTaskDialogFragment a(FragmentManager manager, BaseFragment fragment) {
            Intrinsics.e(manager, "manager");
            Intrinsics.e(fragment, "fragment");
            LiveGoodsWallTaskDialogFragment liveGoodsWallTaskDialogFragment = new LiveGoodsWallTaskDialogFragment();
            liveGoodsWallTaskDialogFragment.d = fragment;
            liveGoodsWallTaskDialogFragment.show(manager, LiveGoodsWallTaskDialogFragment.class.getSimpleName());
            return liveGoodsWallTaskDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGoodsWallTaskDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(GoodsWallTaskDataModel goodsWallTaskDataModel) {
        this.e.clear();
        ArrayList<GoodsWallTaskItemModel> tasks = goodsWallTaskDataModel.getTasks();
        if (tasks != null) {
            for (GoodsWallTaskItemModel goodsWallTaskItemModel : tasks) {
                if (goodsWallTaskItemModel.getStatus() == 1) {
                    goodsWallTaskItemModel.setExpand(true);
                }
                this.e.add(new FitemGoodsWallTask(goodsWallTaskItemModel));
            }
        }
        String description = goodsWallTaskDataModel.getDescription();
        if (!(description != null ? description.length() == 0 : true)) {
            this.e.add(new FitemGoodsWallTaskExplain(goodsWallTaskDataModel.getDescription()));
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveGoodsWallTaskBinding d() {
        return (DialogLiveGoodsWallTaskBinding) this.b.getValue();
    }

    private final void e() {
        d().b.b();
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.G(new BluedUIHttpResponse<BluedEntity<GoodsWallTaskDataModel, ?>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveGoodsWallTaskDialogFragment$getData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogLiveGoodsWallTaskBinding d;
                super.onUIFinish();
                d = LiveGoodsWallTaskDialogFragment.this.d();
                d.b.c();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<GoodsWallTaskDataModel, ?> entity) {
                Intrinsics.e(entity, "entity");
                GoodsWallTaskDataModel singleData = entity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LiveGoodsWallTaskDialogFragment.this.a(singleData);
            }
        }, a());
    }

    private final void f() {
        ViewPropertyAnimator animate;
        FreedomAdapter freedomAdapter = this.f;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.f = new FreedomAdapter(getContext(), a(), this.e);
        DialogLiveGoodsWallTaskBinding d = d();
        RecyclerView recyclerView = d == null ? null : d.c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        DialogLiveGoodsWallTaskBinding d2 = d();
        RecyclerView recyclerView2 = d2 == null ? null : d2.c;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }
        FreedomAdapter freedomAdapter2 = this.f;
        if (freedomAdapter2 != null) {
            freedomAdapter2.b("BaseFragment", this);
        }
        DialogLiveGoodsWallTaskBinding d3 = d();
        RecyclerView recyclerView3 = d3 == null ? null : d3.c;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.f);
        }
        DialogLiveGoodsWallTaskBinding d4 = d();
        if (d4 == null) {
            animate = null;
        } else {
            RecyclerView recyclerView4 = d4.c;
            animate = recyclerView4 == null ? null : recyclerView4.animate();
        }
        animate.alpha(1.0f).setDuration(200L).start();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 511.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView((View) d().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        this.c = TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g());
        d().d.getPaint().setFakeBoldText(true);
        d().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGoodsWallTaskDialogFragment$Kx8SYxjP83snveW2PuZF18QbUp4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGoodsWallTaskDialogFragment.a(LiveGoodsWallTaskDialogFragment.this, view);
            }
        });
        e();
    }
}
