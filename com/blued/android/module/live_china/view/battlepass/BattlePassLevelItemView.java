package com.blued.android.module.live_china.view.battlepass;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.BattlePassLevelDataModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/battlepass/BattlePassLevelItemView.class */
public final class BattlePassLevelItemView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private BattlePassLevelDataModel f15317a;
    private BattlePassLevelProgressItemView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f15318c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BattlePassLevelItemView(Context context, BattlePassLevelDataModel model) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(model, "model");
        View inflate = LayoutInflater.from(context).inflate(R.layout.live_battle_pass_level_item_view, this);
        View findViewById = inflate.findViewById(R.id.bppiv);
        Intrinsics.c(findViewById, "inflate.findViewById(R.id.bppiv)");
        this.b = (BattlePassLevelProgressItemView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tv_level);
        Intrinsics.c(findViewById2, "inflate.findViewById(R.id.tv_level)");
        this.f15318c = (TextView) findViewById2;
    }

    private final void a() {
        BattlePassLevelDataModel battlePassLevelDataModel = this.f15317a;
        if (battlePassLevelDataModel == null) {
            return;
        }
        getBppiv().setProgressMax(battlePassLevelDataModel.getExp() - battlePassLevelDataModel.getPriorExp());
        int progressMax = battlePassLevelDataModel.getCurrentExp() >= battlePassLevelDataModel.getExp() ? getBppiv().getProgressMax() : battlePassLevelDataModel.getCurrentExp() <= battlePassLevelDataModel.getPriorExp() ? 0 : battlePassLevelDataModel.getCurrentExp() - battlePassLevelDataModel.getPriorExp();
        if (battlePassLevelDataModel.getLevel() == 1) {
            getBppiv().setForwardExtend(battlePassLevelDataModel.getX());
        }
        getBppiv().setProgress(progressMax);
        getTv_level().setBackgroundResource(battlePassLevelDataModel.getUiIsLight() ? R.drawable.live_battle_award_little_level : R.drawable.live_battle_award_little_level_un);
        getTv_level().setTextColor(ContextCompat.getColor(getContext(), battlePassLevelDataModel.getUiIsLight() ? R.color.black : R.color.white));
        getTv_level().setText(b(battlePassLevelDataModel.getLevel()));
        getTv_level().getPaint().setFakeBoldText(true);
    }

    private final String b(int i) {
        return i < 10 ? Intrinsics.a("LV.0", (Object) Integer.valueOf(i)) : Intrinsics.a("LV.", (Object) Integer.valueOf(i));
    }

    public final int a(int i) {
        BattlePassLevelDataModel battlePassLevelDataModel = this.f15317a;
        if (battlePassLevelDataModel == null) {
            return -1;
        }
        battlePassLevelDataModel.setCurrentExp(i);
        int progressMax = battlePassLevelDataModel.getCurrentExp() >= battlePassLevelDataModel.getExp() ? getBppiv().getProgressMax() : battlePassLevelDataModel.getCurrentExp() <= battlePassLevelDataModel.getPriorExp() ? 0 : battlePassLevelDataModel.getCurrentExp() - battlePassLevelDataModel.getPriorExp();
        if (getBppiv().getProgress() != progressMax) {
            getBppiv().setProgress(progressMax);
        }
        boolean z = i >= battlePassLevelDataModel.getExp();
        if (z != battlePassLevelDataModel.getUiIsLight()) {
            battlePassLevelDataModel.setUiIsLight(z);
            getTv_level().setBackgroundResource(battlePassLevelDataModel.getUiIsLight() ? R.drawable.live_battle_award_little_level : R.drawable.live_battle_award_little_level_un);
            getTv_level().setTextColor(ContextCompat.getColor(getContext(), battlePassLevelDataModel.getUiIsLight() ? R.color.black : R.color.white));
            if (z) {
                ObjectAnimator.ofFloat(getTv_level(), "scaleX", 1.0f, 1.1f, 1.0f).setDuration(180L).start();
                ObjectAnimator.ofFloat(getTv_level(), "scaleY", 1.0f, 1.1f, 1.0f).setDuration(180L).start();
                return 1;
            }
            return 0;
        }
        return -1;
    }

    public final BattlePassLevelProgressItemView getBppiv() {
        return this.b;
    }

    public final BattlePassLevelDataModel getModel() {
        return this.f15317a;
    }

    public final int getProgress() {
        return this.b.getProgress();
    }

    public final TextView getTv_level() {
        return this.f15318c;
    }

    public final void setBppiv(BattlePassLevelProgressItemView battlePassLevelProgressItemView) {
        Intrinsics.e(battlePassLevelProgressItemView, "<set-?>");
        this.b = battlePassLevelProgressItemView;
    }

    public final void setData(BattlePassLevelDataModel model) {
        Intrinsics.e(model, "model");
        this.f15317a = model;
        a();
    }

    public final void setModel(BattlePassLevelDataModel battlePassLevelDataModel) {
        this.f15317a = battlePassLevelDataModel;
    }

    public final void setProgress(int i) {
        this.b.setProgress(i);
    }

    public final void setTv_level(TextView textView) {
        Intrinsics.e(textView, "<set-?>");
        this.f15318c = textView;
    }
}
