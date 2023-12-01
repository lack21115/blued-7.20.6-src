package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYyTaskRewardBinding;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import com.blued.android.module.yy_china.model.YYRewardsModel;
import com.blued.android.module.yy_china.model.YYTaskRewardModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYTaskRewardDialog.class */
public final class YYTaskRewardDialog extends FrameLayout {
    private DialogYyTaskRewardBinding a;
    private ShapeConstraintLayout b;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYTaskRewardDialog$RewardAdapter.class */
    public static final class RewardAdapter extends BaseQuickAdapter<YYRewardsModel, BaseViewHolder> {
        private BaseFragment a;
        private final YYTaskRewardModel b;
        private Animation c;

        public RewardAdapter(BaseFragment baseFragment, YYTaskRewardModel yYTaskRewardModel) {
            super(R.layout.item_task_reward_layout);
            this.a = baseFragment;
            this.b = yYTaskRewardModel;
            this.c = AnimationUtils.loadAnimation(baseFragment == null ? null : baseFragment.getContext(), R.anim.view_in_from_right);
        }

        public final BaseFragment a() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYRewardsModel yYRewardsModel) {
            String str;
            String str2;
            String str3;
            String str4;
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_prize_name);
            TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_due_day);
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_effect);
            ImageView imageView2 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_prize_chat);
            ImageView imageView3 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_enter_effect);
            RelativeLayout relativeLayout = baseViewHolder == null ? null : (RelativeLayout) baseViewHolder.getView(R.id.rl_chat_prize);
            ImageView imageView4 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_prize_view);
            if (Intrinsics.a((Object) YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID, (Object) (yYRewardsModel == null ? null : yYRewardsModel.duration))) {
                if (textView2 != null) {
                    textView2.setText("永久");
                }
            } else if (textView2 != null) {
                textView2.setText(Intrinsics.a(yYRewardsModel == null ? null : yYRewardsModel.duration, (Object) "天"));
            }
            if (textView != null) {
                textView.setText(yYRewardsModel == null ? null : yYRewardsModel.name);
            }
            boolean z = false;
            if (TextUtils.equals(yYRewardsModel == null ? null : yYRewardsModel.type, "message")) {
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                if (imageView4 != null) {
                    imageView4.setVisibility(8);
                }
                if (yYRewardsModel != null && (str4 = yYRewardsModel.img) != null) {
                    BaseFragment a = a();
                    ImageLoader.a(a == null ? null : a.getFragmentActive(), str4).a(imageView2);
                }
                if (yYRewardsModel != null && (str3 = yYRewardsModel.icon) != null) {
                    BaseFragment a2 = a();
                    ImageLoader.a(a2 == null ? null : a2.getFragmentActive(), str3).f().g(-1).a(imageView);
                }
            } else {
                if (TextUtils.equals(yYRewardsModel == null ? null : yYRewardsModel.type, "enter_effects")) {
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(8);
                    }
                    if (imageView3 != null) {
                        imageView3.setVisibility(0);
                    }
                    if (imageView4 != null) {
                        imageView4.setVisibility(8);
                    }
                    if (yYRewardsModel != null && (str2 = yYRewardsModel.img) != null) {
                        BaseFragment a3 = a();
                        ImageLoader.a(a3 == null ? null : a3.getFragmentActive(), str2).f().g(-1).a(imageView3);
                    }
                    if (imageView3 != null) {
                        imageView3.startAnimation(this.c);
                    }
                } else {
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(8);
                    }
                    if (imageView3 != null) {
                        imageView3.setVisibility(8);
                    }
                    if (imageView4 != null) {
                        imageView4.setVisibility(0);
                    }
                    if (yYRewardsModel != null && (str = yYRewardsModel.img) != null) {
                        BaseFragment a4 = a();
                        ImageLoader.a(a4 == null ? null : a4.getFragmentActive(), str).f().g(-1).a(imageView4);
                    }
                }
            }
            YYTaskRewardModel yYTaskRewardModel = this.b;
            if (yYTaskRewardModel != null && yYTaskRewardModel.status == 0) {
                z = true;
            }
            if (!z || textView2 == null) {
                return;
            }
            textView2.setVisibility(4);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYTaskRewardDialog(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYTaskRewardDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYTaskRewardDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = DialogYyTaskRewardBinding.a(LayoutInflater.from(getContext()), this, true);
    }

    private final String a(int i) {
        return getResources().getString(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ShapeConstraintLayout shapeConstraintLayout, View view) {
        if (shapeConstraintLayout == null) {
            return;
        }
        shapeConstraintLayout.setVisibility(8);
    }

    public final void a(BaseFragment baseFragment, final ShapeConstraintLayout shapeConstraintLayout, YYTaskRewardModel yYTaskRewardModel) {
        String format;
        ImageView imageView;
        DialogYyTaskRewardBinding dialogYyTaskRewardBinding = this.a;
        if (dialogYyTaskRewardBinding != null && (imageView = dialogYyTaskRewardBinding.b) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYTaskRewardDialog$x_QmnSlJcSfBpzCQujHznbwg8wY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYTaskRewardDialog.a(ShapeConstraintLayout.this, view);
                }
            });
        }
        DialogYyTaskRewardBinding dialogYyTaskRewardBinding2 = this.a;
        TextView textView = dialogYyTaskRewardBinding2 == null ? null : dialogYyTaskRewardBinding2.d;
        if (textView != null) {
            textView.setText(a(yYTaskRewardModel != null && yYTaskRewardModel.status == 2 ? R.string.yy_daily_prize_be_sent : R.string.yy_daily_prize_package));
        }
        DialogYyTaskRewardBinding dialogYyTaskRewardBinding3 = this.a;
        TextView textView2 = dialogYyTaskRewardBinding3 == null ? null : dialogYyTaskRewardBinding3.e;
        if (textView2 != null) {
            if (yYTaskRewardModel != null && yYTaskRewardModel.status == 2) {
                format = a(R.string.yy_daily_prize_into_toolbox);
            } else {
                String a = a(R.string.yy_daily_task_target);
                if (a == null) {
                    format = null;
                } else {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                    format = String.format(a, Arrays.copyOf(new Object[]{String.valueOf(yYTaskRewardModel == null ? null : Integer.valueOf(yYTaskRewardModel.condition))}, 1));
                    Intrinsics.c(format, "format(format, *args)");
                }
            }
            textView2.setText(format);
        }
        RecyclerView.Adapter rewardAdapter = new RewardAdapter(baseFragment, yYTaskRewardModel);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        DialogYyTaskRewardBinding dialogYyTaskRewardBinding4 = this.a;
        RecyclerView recyclerView = dialogYyTaskRewardBinding4 == null ? null : dialogYyTaskRewardBinding4.c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        DialogYyTaskRewardBinding dialogYyTaskRewardBinding5 = this.a;
        RecyclerView recyclerView2 = dialogYyTaskRewardBinding5 == null ? null : dialogYyTaskRewardBinding5.c;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(rewardAdapter);
        }
        rewardAdapter.setNewData(yYTaskRewardModel == null ? null : yYTaskRewardModel.rewards);
    }

    public final DialogYyTaskRewardBinding getMBinding() {
        return this.a;
    }

    public final ShapeConstraintLayout getRootView() {
        return this.b;
    }

    public final void setMBinding(DialogYyTaskRewardBinding dialogYyTaskRewardBinding) {
        this.a = dialogYyTaskRewardBinding;
    }

    public final void setRootView(ShapeConstraintLayout shapeConstraintLayout) {
        this.b = shapeConstraintLayout;
    }
}
