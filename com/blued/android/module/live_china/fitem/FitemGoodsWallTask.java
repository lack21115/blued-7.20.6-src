package com.blued.android.module.live_china.fitem;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.GoodsWallTaskAwardItemModel;
import com.blued.android.module.live_china.model.GoodsWallTaskItemModel;
import com.blued.android.module.live_china.view.LineProgressView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemGoodsWallTask.class */
public final class FitemGoodsWallTask extends FreedomItem {
    private GoodsWallTaskItemModel b;
    private boolean c;
    private ArrayList<FitemGoodsWallTaskGoods> d;
    private FreedomAdapter e;
    private final OvershootInterpolator f;
    private final OvershootInterpolator g;

    public FitemGoodsWallTask(GoodsWallTaskItemModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
        this.f = new OvershootInterpolator(1.1f);
        this.g = new OvershootInterpolator(1.8f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, int i, int i2, FitemGoodsWallTask this$0, ValueAnimator animation) {
        Intrinsics.e(view, "$view");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        view.getLayoutParams().height = (int) (i + ((i2 - i) * floatValue));
        view.setLayoutParams(view.getLayoutParams());
        this$0.a.a(R.id.iv_adorn).setAlpha(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TextView textView, float f) {
        textView.setText(R.string.live_goods_wall_pack);
        textView.setTranslationX(-f);
        textView.animate().alpha(1.0f).translationX(0.0f).setDuration(200L).setInterpolator(new DecelerateInterpolator(1.5f)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemGoodsWallTask this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        GoodsWallTaskItemModel goodsWallTaskItemModel = this$0.b;
        goodsWallTaskItemModel.setExpand(!goodsWallTaskItemModel.isExpand());
        this$0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TextView textView, float f) {
        textView.setText(R.string.live_goods_wall_check_award);
        textView.setTranslationX(f);
        textView.animate().alpha(1.0f).translationX(0.0f).setDuration(200L).setInterpolator(new DecelerateInterpolator(1.5f)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FitemGoodsWallTask this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        GoodsWallTaskItemModel goodsWallTaskItemModel = this$0.b;
        goodsWallTaskItemModel.setExpand(!goodsWallTaskItemModel.isExpand());
        this$0.g();
    }

    private final void f() {
        if (!this.b.isExpand()) {
            this.a.a(R.id.tv_check, R.string.live_goods_wall_check_award).a(R.id.iv_arrows).setRotation(0.0f);
            this.a.a(R.id.cl_root).getLayoutParams().height = DisplayUtil.a(AppInfo.d(), 48.0f);
            return;
        }
        this.a.a(R.id.tv_check, R.string.live_goods_wall_pack).a(R.id.iv_arrows).setRotation(-180.0f);
        h();
        this.a.a(R.id.cl_root).getLayoutParams().height = DisplayUtil.a(AppInfo.d(), 163.0f);
    }

    private final void g() {
        float f = 0.0f;
        if (this.b.isExpand()) {
            final TextView textView = (TextView) this.a.a(R.id.tv_check);
            final float a = DisplayUtil.a(AppInfo.d(), 5.0f);
            textView.animate().alpha(0.0f).translationX(a).setDuration(150L).setInterpolator(null).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemGoodsWallTask$O-Xmcl3Kj8IrFbIxXGIHRkKy5s4
                @Override // java.lang.Runnable
                public final void run() {
                    FitemGoodsWallTask.a(TextView.this, a);
                }
            });
            View a2 = this.a.a(R.id.iv_arrows);
            a2.setRotation(0.0f);
            a2.animate().rotation(180.0f).setDuration(500L).setInterpolator(this.g).start();
            h();
        } else {
            final TextView textView2 = (TextView) this.a.a(R.id.tv_check);
            final float a3 = DisplayUtil.a(AppInfo.d(), 5.0f);
            textView2.animate().alpha(0.0f).translationX(-a3).setDuration(150L).setInterpolator(null).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemGoodsWallTask$Qc_5_HO_I5WQ-Gpo2NoGgYMyT7E
                @Override // java.lang.Runnable
                public final void run() {
                    FitemGoodsWallTask.b(TextView.this, a3);
                }
            });
            View a4 = this.a.a(R.id.iv_arrows);
            a4.setRotation(-180.0f);
            a4.animate().rotation(0.0f).setDuration(500L).setInterpolator(this.g).start();
            DisplayUtil.a(AppInfo.d(), 2.0f);
        }
        final View a5 = this.a.a(R.id.cl_root);
        if (a5 == null) {
            return;
        }
        float f2 = e().isExpand() ? 0.0f : 1.0f;
        if (e().isExpand()) {
            f = 1.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f);
        final int a6 = DisplayUtil.a(AppInfo.d(), 48.0f);
        final int a7 = DisplayUtil.a(AppInfo.d(), 163.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(this.f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemGoodsWallTask$pWNQ6hB2qY1N0BMzG4BfyOi7Kck
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FitemGoodsWallTask.a(View.this, a6, a7, this, valueAnimator);
            }
        });
        ofFloat.start();
    }

    private final void h() {
        if (this.c) {
            return;
        }
        this.c = true;
        ArrayList<FitemGoodsWallTaskGoods> arrayList = this.d;
        if (arrayList == null) {
            this.d = new ArrayList<>();
        } else if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<GoodsWallTaskAwardItemModel> rewards = this.b.getRewards();
        if (rewards != null) {
            for (GoodsWallTaskAwardItemModel goodsWallTaskAwardItemModel : rewards) {
                ArrayList<FitemGoodsWallTaskGoods> arrayList2 = this.d;
                if (arrayList2 != null) {
                    arrayList2.add(new FitemGoodsWallTaskGoods(goodsWallTaskAwardItemModel));
                }
            }
        }
        i();
    }

    private final void i() {
        this.e = new FreedomAdapter(this.a.a.b, this.a.b, this.d);
        RecyclerView a = this.a.a(R.id.rv_list);
        a.setLayoutManager(new LinearLayoutManager(this.a.a.b, 0, false));
        if (a != null) {
            a.setItemAnimator(new DefaultItemAnimator());
        }
        FreedomAdapter freedomAdapter = this.e;
        if (freedomAdapter != null) {
            freedomAdapter.b("BaseFragment", this.a.a.a("BaseFragment", (String) null));
        }
        if (a == null) {
            return;
        }
        a.setAdapter(this.e);
    }

    private final void j() {
        int status = this.b.getStatus();
        if (status == 0) {
            m();
        } else if (status == 1) {
            l();
        } else if (status != 2) {
        } else {
            k();
        }
    }

    private final void k() {
        ShapeModel shapeModel = ((ShapeConstraintLayout) this.a.a(R.id.cl_shell)).getShapeModel();
        shapeModel.t = ContextCompat.getColor(this.a.a.b, R.color.transparent);
        shapeModel.v = ContextCompat.getColor(this.a.a.b, R.color.transparent);
        ((ShapeConstraintLayout) this.a.a(R.id.cl_shell)).setShapeModel(shapeModel);
        ShapeModel shapeModel2 = ((ShapeConstraintLayout) this.a.a(R.id.cl_root)).getShapeModel();
        shapeModel2.t = ContextCompat.getColor(this.a.a.b, R.color.syc_dark_4D37246E);
        shapeModel2.v = ContextCompat.getColor(this.a.a.b, R.color.syc_dark_4D37246E);
        ((ShapeConstraintLayout) this.a.a(R.id.cl_root)).setShapeModel(shapeModel2);
    }

    private final void l() {
        ShapeModel shapeModel = ((ShapeConstraintLayout) this.a.a(R.id.cl_shell)).getShapeModel();
        shapeModel.t = ContextCompat.getColor(this.a.a.b, R.color.syc_dark_CC60CB);
        shapeModel.v = ContextCompat.getColor(this.a.a.b, R.color.syc_dark_8E6BFF);
        ((ShapeConstraintLayout) this.a.a(R.id.cl_shell)).setShapeModel(shapeModel);
        ShapeModel shapeModel2 = ((ShapeConstraintLayout) this.a.a(R.id.cl_root)).getShapeModel();
        shapeModel2.t = ContextCompat.getColor(this.a.a.b, R.color.syc_dark_531E90);
        shapeModel2.v = ContextCompat.getColor(this.a.a.b, R.color.syc_dark_572BDA);
        ((ShapeConstraintLayout) this.a.a(R.id.cl_root)).setShapeModel(shapeModel2);
    }

    private final void m() {
        ShapeModel shapeModel = ((ShapeConstraintLayout) this.a.a(R.id.cl_shell)).getShapeModel();
        shapeModel.t = ContextCompat.getColor(this.a.a.b, R.color.syc_dark_613CB4);
        shapeModel.v = ContextCompat.getColor(this.a.a.b, R.color.syc_dark_613CB4);
        ((ShapeConstraintLayout) this.a.a(R.id.cl_shell)).setShapeModel(shapeModel);
        ShapeModel shapeModel2 = ((ShapeConstraintLayout) this.a.a(R.id.cl_root)).getShapeModel();
        shapeModel2.t = ContextCompat.getColor(this.a.a.b, R.color.syc_dark_37246E);
        shapeModel2.v = ContextCompat.getColor(this.a.a.b, R.color.syc_dark_37246E);
        ((ShapeConstraintLayout) this.a.a(R.id.cl_root)).setShapeModel(shapeModel2);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_goods_wall_task;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        ((TextView) vh.a(R.id.tv_tag, (CharSequence) (this.b.getOrder() < 10 ? Intrinsics.a("0", (Object) Integer.valueOf(this.b.getOrder())) : String.valueOf(this.b.getOrder()))).a(R.id.tv_tag, true).a(R.id.tv_tag_bg, this.b.getStatus() != 1 ? 1.0f : 0.0f).a(R.id.tv_title, (CharSequence) this.b.getTitle()).a(R.id.tv_title)).setTextSize(2, this.b.getStatus() == 1 ? 15.0f : 13.0f);
        int i2 = R.id.tv_subtitle;
        int status = this.b.getStatus();
        vh.a(i2, status != 0 ? status != 1 ? status != 2 ? R.string.live_goods_wall_task_list_state_not_lockup : R.string.live_goods_wall_task_list_state_complete : R.string.live_goods_wall_task_list_state_not_complete : R.string.live_goods_wall_task_list_state_not_lockup).b(R.id.tv_subtitle, ContextCompat.getColor(context, this.b.getStatus() == 1 ? R.color.syc_dark_ffb219 : R.color.white)).a(R.id.tv_subtitle, this.b.getStatus() == 1 ? 1.0f : 0.7f).a(R.id.tv_title, this.b.getStatus() != 2).a(R.id.tv_title, this.b.getStatus() != 2 ? 1.0f : 0.7f).b(R.id.view_progress, this.b.getStatus() == 1).b(R.id.tv_check, this.b.getStatus() != 1).b(R.id.iv_arrows, this.b.getStatus() != 1).a(R.id.tv_check, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemGoodsWallTask$0TbCpp7zdPu04HSxk4OFk2uf0_0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemGoodsWallTask.a(FitemGoodsWallTask.this, view);
            }
        }).a(R.id.iv_arrows, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemGoodsWallTask$_r0KFotup0VOYK4lYYKU_4r2-tI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemGoodsWallTask.b(FitemGoodsWallTask.this, view);
            }
        });
        if (this.b.getStatus() == 1) {
            ((LineProgressView) vh.d(R.id.tv_progress).d(R.id.tv_progress_count).a(R.id.tv_progress, (CharSequence) String.valueOf(this.b.getProgress())).a(R.id.tv_progress_count, (CharSequence) Intrinsics.a(BridgeUtil.SPLIT_MARK, (Object) Integer.valueOf(this.b.getCount()))).a(R.id.view_progress)).setProgress(this.b.getProgress() / this.b.getCount());
        } else {
            vh.c(R.id.tv_progress);
            vh.c(R.id.tv_progress_count);
        }
        this.c = false;
        f();
        j();
    }

    public final GoodsWallTaskItemModel e() {
        return this.b;
    }
}
