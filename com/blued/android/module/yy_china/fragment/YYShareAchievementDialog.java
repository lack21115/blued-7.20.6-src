package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.AchievementAdapter;
import com.blued.android.module.yy_china.databinding.DialogShareAchievementBinding;
import com.blued.android.module.yy_china.model.YYEventsThemeModel;
import com.blued.android.module.yy_china.model.YYShareAchievementModel;
import com.blued.android.module.yy_china.model.YYThemeActivityInfo;
import com.blued.android.module.yy_china.model.YYThemeEventEndInfo;
import com.blued.android.module.yy_china.model.YYThemeRankList;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYShareAchievementDialog.class */
public final class YYShareAchievementDialog extends BaseFullScreenDialog {
    private String a = "";
    private DialogShareAchievementBinding b;
    private AchievementAdapter c;
    private YYThemeEventEndInfo d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYShareAchievementDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYEventsThemeModel yYEventsThemeModel) {
        if (yYEventsThemeModel == null) {
            return;
        }
        ImageLoader.a(a(), yYEventsThemeModel.getActivity_detail_bg()).a((Target) new CustomTarget<Drawable>() { // from class: com.blued.android.module.yy_china.fragment.YYShareAchievementDialog$initResource$1
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                DialogShareAchievementBinding dialogShareAchievementBinding;
                Intrinsics.e(resource, "resource");
                if (resource instanceof BitmapDrawable) {
                    dialogShareAchievementBinding = YYShareAchievementDialog.this.b;
                    DialogShareAchievementBinding dialogShareAchievementBinding2 = dialogShareAchievementBinding;
                    if (dialogShareAchievementBinding == null) {
                        Intrinsics.c("mBinding");
                        dialogShareAchievementBinding2 = null;
                    }
                    dialogShareAchievementBinding2.o.setBackground(resource);
                }
            }

            public void onLoadCleared(Drawable drawable) {
            }
        });
        ImageWrapper a = ImageLoader.a(a(), yYEventsThemeModel.getWinner_first());
        DialogShareAchievementBinding dialogShareAchievementBinding = this.b;
        DialogShareAchievementBinding dialogShareAchievementBinding2 = dialogShareAchievementBinding;
        if (dialogShareAchievementBinding == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding2 = null;
        }
        a.a(dialogShareAchievementBinding2.e);
        ImageWrapper a2 = ImageLoader.a(a(), yYEventsThemeModel.getWinner_second());
        DialogShareAchievementBinding dialogShareAchievementBinding3 = this.b;
        DialogShareAchievementBinding dialogShareAchievementBinding4 = dialogShareAchievementBinding3;
        if (dialogShareAchievementBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding4 = null;
        }
        a2.a(dialogShareAchievementBinding4.f);
        ImageWrapper a3 = ImageLoader.a(a(), yYEventsThemeModel.getWinner_third());
        DialogShareAchievementBinding dialogShareAchievementBinding5 = this.b;
        DialogShareAchievementBinding dialogShareAchievementBinding6 = dialogShareAchievementBinding5;
        if (dialogShareAchievementBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding6 = null;
        }
        a3.a(dialogShareAchievementBinding6.g);
        ImageWrapper a4 = ImageLoader.a(a(), yYEventsThemeModel.getThanks_giving_icon());
        DialogShareAchievementBinding dialogShareAchievementBinding7 = this.b;
        DialogShareAchievementBinding dialogShareAchievementBinding8 = dialogShareAchievementBinding7;
        if (dialogShareAchievementBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding8 = null;
        }
        a4.a(dialogShareAchievementBinding8.i);
        ImageWrapper a5 = ImageLoader.a(a(), yYEventsThemeModel.getActivity_end_icon());
        DialogShareAchievementBinding dialogShareAchievementBinding9 = this.b;
        DialogShareAchievementBinding dialogShareAchievementBinding10 = dialogShareAchievementBinding9;
        if (dialogShareAchievementBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding10 = null;
        }
        a5.a(dialogShareAchievementBinding10.d);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(DensityUtils.a(getContext(), 22.0f));
        gradientDrawable.setColor(Color.parseColor(yYEventsThemeModel.getButton_color()));
        DialogShareAchievementBinding dialogShareAchievementBinding11 = this.b;
        if (dialogShareAchievementBinding11 == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding11 = null;
        }
        dialogShareAchievementBinding11.b.setBackground(gradientDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYThemeEventEndInfo yYThemeEventEndInfo) {
        if (yYThemeEventEndInfo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(yYThemeEventEndInfo.getDuration_time())) {
            arrayList.add(new YYShareAchievementModel("开播时长", yYThemeEventEndInfo.getDuration_time(), "", false));
        }
        if (!TextUtils.isEmpty(yYThemeEventEndInfo.getSend_users_count())) {
            arrayList.add(new YYShareAchievementModel("祝福人数", yYThemeEventEndInfo.getSend_users_count(), "祝福人数是指在主题专场活动中给您送礼的人数", true));
        }
        if (!TextUtils.isEmpty(yYThemeEventEndInfo.getUsers_count())) {
            arrayList.add(new YYShareAchievementModel("观看人数", yYThemeEventEndInfo.getUsers_count(), "", false));
        }
        if (!TextUtils.isEmpty(yYThemeEventEndInfo.getValue())) {
            arrayList.add(new YYShareAchievementModel("庆典值", yYThemeEventEndInfo.getValue(), yYThemeEventEndInfo.getValue_desc(), true));
        }
        AchievementAdapter achievementAdapter = this.c;
        AchievementAdapter achievementAdapter2 = achievementAdapter;
        if (achievementAdapter == null) {
            Intrinsics.c("mAdapter");
            achievementAdapter2 = null;
        }
        achievementAdapter2.setNewData(arrayList);
    }

    private final void a(YYThemeRankList yYThemeRankList, TextView textView, ImageView imageView, TextView textView2) {
        ImageLoader.a(a(), yYThemeRankList.getAvatar()).b(R.drawable.user_bg_round).a(imageView);
        textView.setText(yYThemeRankList.getValue());
        textView2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<YYThemeRankList> list) {
        List<YYThemeRankList> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            DialogShareAchievementBinding dialogShareAchievementBinding = this.b;
            DialogShareAchievementBinding dialogShareAchievementBinding2 = dialogShareAchievementBinding;
            if (dialogShareAchievementBinding == null) {
                Intrinsics.c("mBinding");
                dialogShareAchievementBinding2 = null;
            }
            dialogShareAchievementBinding2.d.setVisibility(0);
            DialogShareAchievementBinding dialogShareAchievementBinding3 = this.b;
            if (dialogShareAchievementBinding3 == null) {
                Intrinsics.c("mBinding");
                dialogShareAchievementBinding3 = null;
            }
            dialogShareAchievementBinding3.p.setVisibility(8);
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            YYThemeRankList yYThemeRankList = list.get(i2);
            if (i2 == 0) {
                DialogShareAchievementBinding dialogShareAchievementBinding4 = this.b;
                DialogShareAchievementBinding dialogShareAchievementBinding5 = dialogShareAchievementBinding4;
                if (dialogShareAchievementBinding4 == null) {
                    Intrinsics.c("mBinding");
                    dialogShareAchievementBinding5 = null;
                }
                TextView textView = dialogShareAchievementBinding5.r;
                Intrinsics.c(textView, "mBinding.tvFirstName");
                DialogShareAchievementBinding dialogShareAchievementBinding6 = this.b;
                DialogShareAchievementBinding dialogShareAchievementBinding7 = dialogShareAchievementBinding6;
                if (dialogShareAchievementBinding6 == null) {
                    Intrinsics.c("mBinding");
                    dialogShareAchievementBinding7 = null;
                }
                ShapeableImageView shapeableImageView = dialogShareAchievementBinding7.j;
                Intrinsics.c(shapeableImageView, "mBinding.imgUser1");
                ImageView imageView = (ImageView) shapeableImageView;
                DialogShareAchievementBinding dialogShareAchievementBinding8 = this.b;
                DialogShareAchievementBinding dialogShareAchievementBinding9 = dialogShareAchievementBinding8;
                if (dialogShareAchievementBinding8 == null) {
                    Intrinsics.c("mBinding");
                    dialogShareAchievementBinding9 = null;
                }
                TextView textView2 = dialogShareAchievementBinding9.s;
                Intrinsics.c(textView2, "mBinding.tvFirstUnit");
                a(yYThemeRankList, textView, imageView, textView2);
            } else if (i2 == 1) {
                DialogShareAchievementBinding dialogShareAchievementBinding10 = this.b;
                DialogShareAchievementBinding dialogShareAchievementBinding11 = dialogShareAchievementBinding10;
                if (dialogShareAchievementBinding10 == null) {
                    Intrinsics.c("mBinding");
                    dialogShareAchievementBinding11 = null;
                }
                TextView textView3 = dialogShareAchievementBinding11.u;
                Intrinsics.c(textView3, "mBinding.tvSecondName");
                DialogShareAchievementBinding dialogShareAchievementBinding12 = this.b;
                DialogShareAchievementBinding dialogShareAchievementBinding13 = dialogShareAchievementBinding12;
                if (dialogShareAchievementBinding12 == null) {
                    Intrinsics.c("mBinding");
                    dialogShareAchievementBinding13 = null;
                }
                ShapeableImageView shapeableImageView2 = dialogShareAchievementBinding13.k;
                Intrinsics.c(shapeableImageView2, "mBinding.imgUser2");
                ImageView imageView2 = (ImageView) shapeableImageView2;
                DialogShareAchievementBinding dialogShareAchievementBinding14 = this.b;
                DialogShareAchievementBinding dialogShareAchievementBinding15 = dialogShareAchievementBinding14;
                if (dialogShareAchievementBinding14 == null) {
                    Intrinsics.c("mBinding");
                    dialogShareAchievementBinding15 = null;
                }
                TextView textView4 = dialogShareAchievementBinding15.v;
                Intrinsics.c(textView4, "mBinding.tvSecondUnit");
                a(yYThemeRankList, textView3, imageView2, textView4);
            } else if (i2 == 2) {
                DialogShareAchievementBinding dialogShareAchievementBinding16 = this.b;
                DialogShareAchievementBinding dialogShareAchievementBinding17 = dialogShareAchievementBinding16;
                if (dialogShareAchievementBinding16 == null) {
                    Intrinsics.c("mBinding");
                    dialogShareAchievementBinding17 = null;
                }
                TextView textView5 = dialogShareAchievementBinding17.w;
                Intrinsics.c(textView5, "mBinding.tvThirdName");
                DialogShareAchievementBinding dialogShareAchievementBinding18 = this.b;
                DialogShareAchievementBinding dialogShareAchievementBinding19 = dialogShareAchievementBinding18;
                if (dialogShareAchievementBinding18 == null) {
                    Intrinsics.c("mBinding");
                    dialogShareAchievementBinding19 = null;
                }
                ShapeableImageView shapeableImageView3 = dialogShareAchievementBinding19.l;
                Intrinsics.c(shapeableImageView3, "mBinding.imgUser3");
                ImageView imageView3 = (ImageView) shapeableImageView3;
                DialogShareAchievementBinding dialogShareAchievementBinding20 = this.b;
                DialogShareAchievementBinding dialogShareAchievementBinding21 = dialogShareAchievementBinding20;
                if (dialogShareAchievementBinding20 == null) {
                    Intrinsics.c("mBinding");
                    dialogShareAchievementBinding21 = null;
                }
                TextView textView6 = dialogShareAchievementBinding21.x;
                Intrinsics.c(textView6, "mBinding.tvThirdUnit");
                a(yYThemeRankList, textView5, imageView3, textView6);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYShareAchievementDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackYY.a(ChatRoomProtos.Event.YY_CELEBRATION_KNOW_CLICK);
        DialogShareAchievementBinding dialogShareAchievementBinding = this$0.b;
        DialogShareAchievementBinding dialogShareAchievementBinding2 = dialogShareAchievementBinding;
        if (dialogShareAchievementBinding == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding2 = null;
        }
        if (!dialogShareAchievementBinding2.a.isChecked()) {
            this$0.dismissAllowingStateLoss();
            return;
        }
        YYPostFeedStyleDialog yYPostFeedStyleDialog = new YYPostFeedStyleDialog();
        yYPostFeedStyleDialog.a(this$0.d);
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYPostFeedStyleDialog.show(childFragmentManager, "feed_style_dialog");
    }

    private final void f() {
        Resources resources;
        Float valueOf;
        Context context = getContext();
        DisplayMetrics displayMetrics = (context == null || (resources = context.getResources()) == null) ? null : resources.getDisplayMetrics();
        if ((displayMetrics == null ? null : Float.valueOf(displayMetrics.density)) != null) {
            DialogShareAchievementBinding dialogShareAchievementBinding = this.b;
            DialogShareAchievementBinding dialogShareAchievementBinding2 = dialogShareAchievementBinding;
            if (dialogShareAchievementBinding == null) {
                Intrinsics.c("mBinding");
                dialogShareAchievementBinding2 = null;
            }
            ConstraintLayout.LayoutParams layoutParams = dialogShareAchievementBinding2.i.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
            DialogShareAchievementBinding dialogShareAchievementBinding3 = this.b;
            if (dialogShareAchievementBinding3 == null) {
                Intrinsics.c("mBinding");
                dialogShareAchievementBinding3 = null;
            }
            ConstraintLayout.LayoutParams layoutParams3 = dialogShareAchievementBinding3.n.getLayoutParams();
            if (layoutParams3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams4 = layoutParams3;
            if (valueOf.floatValue() < 3.0d) {
                layoutParams2.topMargin = DensityUtils.a(getContext(), 81.0f);
                layoutParams4.topMargin = DensityUtils.a(getContext(), 84.0f);
                return;
            }
            layoutParams2.topMargin = DensityUtils.a(getContext(), 75.0f);
            layoutParams4.topMargin = DensityUtils.a(getContext(), 78.0f);
        }
    }

    private final void g() {
        String str = this.a;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.Z(str, new BluedUIHttpResponse<BluedEntityA<YYThemeEventEndInfo>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYShareAchievementDialog$loadThemeEventInfo$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYThemeEventEndInfo> bluedEntityA) {
                YYThemeEventEndInfo yYThemeEventEndInfo;
                YYThemeEventEndInfo yYThemeEventEndInfo2;
                YYThemeEventEndInfo yYThemeEventEndInfo3;
                YYThemeEventEndInfo yYThemeEventEndInfo4;
                YYThemeActivityInfo activity_info;
                DialogShareAchievementBinding dialogShareAchievementBinding;
                DialogShareAchievementBinding dialogShareAchievementBinding2;
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                YYShareAchievementDialog.this.d = bluedEntityA.getSingleData();
                yYThemeEventEndInfo = YYShareAchievementDialog.this.d;
                if (yYThemeEventEndInfo != null && (activity_info = yYThemeEventEndInfo.getActivity_info()) != null) {
                    YYShareAchievementDialog yYShareAchievementDialog = YYShareAchievementDialog.this;
                    dialogShareAchievementBinding = yYShareAchievementDialog.b;
                    DialogShareAchievementBinding dialogShareAchievementBinding3 = dialogShareAchievementBinding;
                    if (dialogShareAchievementBinding == null) {
                        Intrinsics.c("mBinding");
                        dialogShareAchievementBinding3 = null;
                    }
                    dialogShareAchievementBinding3.y.setText(activity_info.getName());
                    dialogShareAchievementBinding2 = yYShareAchievementDialog.b;
                    DialogShareAchievementBinding dialogShareAchievementBinding4 = dialogShareAchievementBinding2;
                    if (dialogShareAchievementBinding2 == null) {
                        Intrinsics.c("mBinding");
                        dialogShareAchievementBinding4 = null;
                    }
                    dialogShareAchievementBinding4.t.setText(TimeAndDateUtils.f(activity_info.getStart_time()) + " 至 " + ((Object) TimeAndDateUtils.f(activity_info.getEnd_time())));
                }
                YYShareAchievementDialog yYShareAchievementDialog2 = YYShareAchievementDialog.this;
                yYThemeEventEndInfo2 = yYShareAchievementDialog2.d;
                yYShareAchievementDialog2.a(yYThemeEventEndInfo2 == null ? null : yYThemeEventEndInfo2.getSkin());
                YYShareAchievementDialog yYShareAchievementDialog3 = YYShareAchievementDialog.this;
                yYThemeEventEndInfo3 = yYShareAchievementDialog3.d;
                yYShareAchievementDialog3.a(yYThemeEventEndInfo3 == null ? null : yYThemeEventEndInfo3.getRank_list());
                YYShareAchievementDialog yYShareAchievementDialog4 = YYShareAchievementDialog.this;
                yYThemeEventEndInfo4 = yYShareAchievementDialog4.d;
                yYShareAchievementDialog4.a(yYThemeEventEndInfo4);
            }
        }, a());
    }

    private final void h() {
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        DialogShareAchievementBinding dialogShareAchievementBinding = this.b;
        DialogShareAchievementBinding dialogShareAchievementBinding2 = dialogShareAchievementBinding;
        if (dialogShareAchievementBinding == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding2 = null;
        }
        dialogShareAchievementBinding2.q.setLayoutManager(gridLayoutManager);
        this.c = new AchievementAdapter();
        DialogShareAchievementBinding dialogShareAchievementBinding3 = this.b;
        DialogShareAchievementBinding dialogShareAchievementBinding4 = dialogShareAchievementBinding3;
        if (dialogShareAchievementBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding4 = null;
        }
        RecyclerView recyclerView = dialogShareAchievementBinding4.q;
        AchievementAdapter achievementAdapter = this.c;
        if (achievementAdapter == null) {
            Intrinsics.c("mAdapter");
            achievementAdapter = null;
        }
        recyclerView.setAdapter(achievementAdapter);
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.a = str;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public void onActivityCreated(Bundle bundle) {
        Resources resources;
        super.onActivityCreated(bundle);
        g();
        Context context = getContext();
        DisplayMetrics displayMetrics = (context == null || (resources = context.getResources()) == null) ? null : resources.getDisplayMetrics();
        Float valueOf = displayMetrics == null ? null : Float.valueOf(displayMetrics.density);
        Integer valueOf2 = displayMetrics == null ? null : Integer.valueOf(displayMetrics.densityDpi);
        LogUtils.d("屏幕密度", "density：" + valueOf + "; dpi：" + valueOf2);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_share_achievement, (ViewGroup) null);
        DialogShareAchievementBinding a = DialogShareAchievementBinding.a(inflate);
        Intrinsics.c(a, "bind(view)");
        this.b = a;
        f();
        h();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        DialogShareAchievementBinding dialogShareAchievementBinding = this.b;
        DialogShareAchievementBinding dialogShareAchievementBinding2 = dialogShareAchievementBinding;
        if (dialogShareAchievementBinding == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding2 = null;
        }
        dialogShareAchievementBinding2.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYShareAchievementDialog$5Dqk76CtkeAds_jzCdWHqF-Y1CY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYShareAchievementDialog.a(YYShareAchievementDialog.this, view2);
            }
        });
        DialogShareAchievementBinding dialogShareAchievementBinding3 = this.b;
        DialogShareAchievementBinding dialogShareAchievementBinding4 = dialogShareAchievementBinding3;
        if (dialogShareAchievementBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding4 = null;
        }
        dialogShareAchievementBinding4.o.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYShareAchievementDialog$Jv5bcvXA350A3M8ZzBTXpTEly2A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYShareAchievementDialog.a(view2);
            }
        });
        DialogShareAchievementBinding dialogShareAchievementBinding5 = this.b;
        if (dialogShareAchievementBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogShareAchievementBinding5 = null;
        }
        dialogShareAchievementBinding5.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYShareAchievementDialog$tnDaALx4ubNCt__YPXON582FwXs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYShareAchievementDialog.b(YYShareAchievementDialog.this, view2);
            }
        });
    }
}
