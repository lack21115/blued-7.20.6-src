package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveGoodsWallBrandAwardBinding;
import com.blued.android.module.live_china.fitem.FitemGoodsWallBrandAward;
import com.blued.android.module.live_china.model.GoodsWallBrandAwardDataModel;
import com.blued.android.module.live_china.model.GoodsWallBrandAwardModel;
import com.blued.android.module.live_china.model.GoodsWallBrandAwardTaskModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.BluedViewExKt;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGoodsWallBrandAwardDialogFragment.class */
public final class LiveGoodsWallBrandAwardDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private FreedomAdapter d;
    private final Lazy b = LazyKt.a(new Function0<DialogLiveGoodsWallBrandAwardBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveGoodsWallBrandAwardDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveGoodsWallBrandAwardBinding invoke() {
            return DialogLiveGoodsWallBrandAwardBinding.a(LayoutInflater.from(LiveGoodsWallBrandAwardDialogFragment.this.getContext()));
        }
    });
    private final ArrayList<FreedomItem> c = new ArrayList<>();
    private final String e = "@\\(word:([\\s\\S]*?)\\)";
    private Pattern f = Pattern.compile("@\\(word:([\\s\\S]*?)\\)");

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGoodsWallBrandAwardDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveGoodsWallBrandAwardDialogFragment a(FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            LiveGoodsWallBrandAwardDialogFragment liveGoodsWallBrandAwardDialogFragment = new LiveGoodsWallBrandAwardDialogFragment();
            liveGoodsWallBrandAwardDialogFragment.show(manager, LiveGoodsWallBrandAwardDialogFragment.class.getSimpleName());
            return liveGoodsWallBrandAwardDialogFragment;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private final CharSequence a(CharSequence charSequence, String str, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGoodsWallBrandAwardDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(GoodsWallBrandAwardDataModel goodsWallBrandAwardDataModel) {
        GoodsWallBrandAwardTaskModel goodsWallBrandAwardTaskModel;
        GoodsWallBrandAwardTaskModel goodsWallBrandAwardTaskModel2;
        d().h.setText(AppInfo.d().getString(R.string.live_goods_wall_get_award_count, Integer.valueOf(goodsWallBrandAwardDataModel.getStamp_count())));
        d().g.setText(String.valueOf(goodsWallBrandAwardDataModel.getStamp_count()));
        ArrayList<GoodsWallBrandAwardTaskModel> tasks = goodsWallBrandAwardDataModel.getTasks();
        if (tasks != null && (goodsWallBrandAwardTaskModel2 = tasks.get(0)) != null) {
            String title = goodsWallBrandAwardTaskModel2.getTitle();
            if (!(title == null || title.length() == 0)) {
                d().n.setText(goodsWallBrandAwardTaskModel2.getTitle());
                TextView textView = d().n;
                CharSequence text = d().n.getText();
                Intrinsics.c(text, "vb.tvTask1Title.text");
                textView.setText(a(text, "#FFB219", true));
                if (goodsWallBrandAwardTaskModel2.getFinish() == 0) {
                    d().m.setText(R.string.live_goods_wall_task_state_not_complete);
                } else if (goodsWallBrandAwardTaskModel2.getFinish() == 1) {
                    d().m.setText(R.string.live_goods_wall_task_state_complete);
                }
                View view = d().a;
                Intrinsics.c(view, "vb.clTask1");
                BluedViewExKt.b(view);
            }
        }
        ArrayList<GoodsWallBrandAwardTaskModel> tasks2 = goodsWallBrandAwardDataModel.getTasks();
        if (tasks2 != null && (goodsWallBrandAwardTaskModel = tasks2.get(1)) != null) {
            String title2 = goodsWallBrandAwardTaskModel.getTitle();
            if (!(title2 == null || title2.length() == 0)) {
                d().o.setText(goodsWallBrandAwardTaskModel.getTitle());
                TextView textView2 = d().o;
                CharSequence text2 = d().o.getText();
                Intrinsics.c(text2, "vb.tvTask2Title.text");
                textView2.setText(a(text2, "#FFB219", true));
                View view2 = d().b;
                Intrinsics.c(view2, "vb.clTask2");
                BluedViewExKt.b(view2);
            }
        }
        ArrayList<GoodsWallBrandAwardModel> rewards = goodsWallBrandAwardDataModel.getRewards();
        if (rewards != null ? rewards.isEmpty() : true) {
            View view3 = d().c;
            Intrinsics.c(view3, "vb.groupList");
            BluedViewExKt.a(view3);
            TextView textView3 = d().l;
            Intrinsics.c(textView3, "vb.tvNoData");
            BluedViewExKt.b(textView3);
            return;
        }
        View view4 = d().c;
        Intrinsics.c(view4, "vb.groupList");
        BluedViewExKt.b(view4);
        TextView textView4 = d().l;
        Intrinsics.c(textView4, "vb.tvNoData");
        BluedViewExKt.a(textView4);
        this.c.clear();
        ArrayList<GoodsWallBrandAwardModel> rewards2 = goodsWallBrandAwardDataModel.getRewards();
        if (rewards2 != null) {
            for (GoodsWallBrandAwardModel goodsWallBrandAwardModel : rewards2) {
                this.c.add(new FitemGoodsWallBrandAward(goodsWallBrandAwardModel));
            }
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveGoodsWallBrandAwardBinding d() {
        return (DialogLiveGoodsWallBrandAwardBinding) this.b.getValue();
    }

    private final void e() {
        d().e.b();
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.H(new BluedUIHttpResponse<BluedEntity<GoodsWallBrandAwardDataModel, ?>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveGoodsWallBrandAwardDialogFragment$getData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogLiveGoodsWallBrandAwardBinding d;
                super.onUIFinish();
                d = LiveGoodsWallBrandAwardDialogFragment.this.d();
                d.e.c();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<GoodsWallBrandAwardDataModel, ?> entity) {
                Intrinsics.e(entity, "entity");
                GoodsWallBrandAwardDataModel singleData = entity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LiveGoodsWallBrandAwardDialogFragment.this.a(singleData);
            }
        }, a());
    }

    private final void f() {
        FreedomAdapter freedomAdapter = this.d;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.d = new FreedomAdapter(getContext(), a(), this.c);
        DialogLiveGoodsWallBrandAwardBinding d = d();
        RecyclerView recyclerView = d == null ? null : d.f;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        DialogLiveGoodsWallBrandAwardBinding d2 = d();
        RecyclerView recyclerView2 = d2 == null ? null : d2.f;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }
        DialogLiveGoodsWallBrandAwardBinding d3 = d();
        RecyclerView recyclerView3 = d3 == null ? null : d3.f;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(this.d);
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
        d().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGoodsWallBrandAwardDialogFragment$h1TR8NhEuuwfBZzSBhH88L_C_s4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGoodsWallBrandAwardDialogFragment.a(LiveGoodsWallBrandAwardDialogFragment.this, view);
            }
        });
        e();
    }
}
