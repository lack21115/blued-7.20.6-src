package com.blued.android.module.yy_china.fragment;

import android.graphics.Bitmap;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.AchievementAdapter;
import com.blued.android.module.yy_china.databinding.DialogPreviewPosterBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYEventsThemeModel;
import com.blued.android.module.yy_china.model.YYShareAchievementModel;
import com.blued.android.module.yy_china.model.YYThemeActivityInfo;
import com.blued.android.module.yy_china.model.YYThemeRankList;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPreviewPosterDialog.class */
public final class YYPreviewPosterDialog extends BaseFullScreenDialog {
    private DialogPreviewPosterBinding a;
    private AchievementAdapter b;
    private List<YYShareAchievementModel> c;
    private List<YYThemeRankList> d;
    private YYThemeActivityInfo e;
    private YYEventsThemeModel f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPreviewPosterDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void a(YYEventsThemeModel yYEventsThemeModel) {
        if (yYEventsThemeModel == null) {
            return;
        }
        ImageWrapper a = ImageLoader.a(a(), yYEventsThemeModel.getPreview_bg()).a(12.0f);
        DialogPreviewPosterBinding dialogPreviewPosterBinding = this.a;
        DialogPreviewPosterBinding dialogPreviewPosterBinding2 = dialogPreviewPosterBinding;
        if (dialogPreviewPosterBinding == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding2 = null;
        }
        a.a(dialogPreviewPosterBinding2.i);
        ImageWrapper a2 = ImageLoader.a(a(), yYEventsThemeModel.getWinner_first());
        DialogPreviewPosterBinding dialogPreviewPosterBinding3 = this.a;
        DialogPreviewPosterBinding dialogPreviewPosterBinding4 = dialogPreviewPosterBinding3;
        if (dialogPreviewPosterBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding4 = null;
        }
        a2.a(dialogPreviewPosterBinding4.f);
        ImageWrapper a3 = ImageLoader.a(a(), yYEventsThemeModel.getWinner_second());
        DialogPreviewPosterBinding dialogPreviewPosterBinding5 = this.a;
        DialogPreviewPosterBinding dialogPreviewPosterBinding6 = dialogPreviewPosterBinding5;
        if (dialogPreviewPosterBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding6 = null;
        }
        a3.a(dialogPreviewPosterBinding6.g);
        ImageWrapper a4 = ImageLoader.a(a(), yYEventsThemeModel.getWinner_third());
        DialogPreviewPosterBinding dialogPreviewPosterBinding7 = this.a;
        DialogPreviewPosterBinding dialogPreviewPosterBinding8 = dialogPreviewPosterBinding7;
        if (dialogPreviewPosterBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding8 = null;
        }
        a4.a(dialogPreviewPosterBinding8.h);
        ImageWrapper a5 = ImageLoader.a(a(), yYEventsThemeModel.getThanks_giving_icon());
        DialogPreviewPosterBinding dialogPreviewPosterBinding9 = this.a;
        DialogPreviewPosterBinding dialogPreviewPosterBinding10 = dialogPreviewPosterBinding9;
        if (dialogPreviewPosterBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding10 = null;
        }
        a5.a(dialogPreviewPosterBinding10.j);
        ImageWrapper a6 = ImageLoader.a(a(), yYEventsThemeModel.getActivity_end_icon());
        DialogPreviewPosterBinding dialogPreviewPosterBinding11 = this.a;
        if (dialogPreviewPosterBinding11 == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding11 = null;
        }
        a6.a(dialogPreviewPosterBinding11.e);
        g();
    }

    private final void a(YYThemeRankList yYThemeRankList, TextView textView, ImageView imageView, TextView textView2) {
        ImageLoader.a(a(), yYThemeRankList.getAvatar()).b(R.drawable.user_bg_round).a(imageView);
        textView.setText(yYThemeRankList.getValue());
        textView2.setVisibility(0);
    }

    private final void a(List<YYThemeRankList> list) {
        List<YYThemeRankList> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            DialogPreviewPosterBinding dialogPreviewPosterBinding = this.a;
            DialogPreviewPosterBinding dialogPreviewPosterBinding2 = dialogPreviewPosterBinding;
            if (dialogPreviewPosterBinding == null) {
                Intrinsics.c("mBinding");
                dialogPreviewPosterBinding2 = null;
            }
            dialogPreviewPosterBinding2.q.setVisibility(8);
            DialogPreviewPosterBinding dialogPreviewPosterBinding3 = this.a;
            if (dialogPreviewPosterBinding3 == null) {
                Intrinsics.c("mBinding");
                dialogPreviewPosterBinding3 = null;
            }
            dialogPreviewPosterBinding3.e.setVisibility(0);
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
                DialogPreviewPosterBinding dialogPreviewPosterBinding4 = this.a;
                DialogPreviewPosterBinding dialogPreviewPosterBinding5 = dialogPreviewPosterBinding4;
                if (dialogPreviewPosterBinding4 == null) {
                    Intrinsics.c("mBinding");
                    dialogPreviewPosterBinding5 = null;
                }
                TextView textView = dialogPreviewPosterBinding5.t;
                Intrinsics.c(textView, "mBinding.tvFirstName");
                DialogPreviewPosterBinding dialogPreviewPosterBinding6 = this.a;
                DialogPreviewPosterBinding dialogPreviewPosterBinding7 = dialogPreviewPosterBinding6;
                if (dialogPreviewPosterBinding6 == null) {
                    Intrinsics.c("mBinding");
                    dialogPreviewPosterBinding7 = null;
                }
                ShapeableImageView shapeableImageView = dialogPreviewPosterBinding7.k;
                Intrinsics.c(shapeableImageView, "mBinding.imgUser1");
                ImageView imageView = (ImageView) shapeableImageView;
                DialogPreviewPosterBinding dialogPreviewPosterBinding8 = this.a;
                DialogPreviewPosterBinding dialogPreviewPosterBinding9 = dialogPreviewPosterBinding8;
                if (dialogPreviewPosterBinding8 == null) {
                    Intrinsics.c("mBinding");
                    dialogPreviewPosterBinding9 = null;
                }
                TextView textView2 = dialogPreviewPosterBinding9.u;
                Intrinsics.c(textView2, "mBinding.tvFirstUnit");
                a(yYThemeRankList, textView, imageView, textView2);
            } else if (i2 == 1) {
                DialogPreviewPosterBinding dialogPreviewPosterBinding10 = this.a;
                DialogPreviewPosterBinding dialogPreviewPosterBinding11 = dialogPreviewPosterBinding10;
                if (dialogPreviewPosterBinding10 == null) {
                    Intrinsics.c("mBinding");
                    dialogPreviewPosterBinding11 = null;
                }
                TextView textView3 = dialogPreviewPosterBinding11.w;
                Intrinsics.c(textView3, "mBinding.tvSecondName");
                DialogPreviewPosterBinding dialogPreviewPosterBinding12 = this.a;
                DialogPreviewPosterBinding dialogPreviewPosterBinding13 = dialogPreviewPosterBinding12;
                if (dialogPreviewPosterBinding12 == null) {
                    Intrinsics.c("mBinding");
                    dialogPreviewPosterBinding13 = null;
                }
                ShapeableImageView shapeableImageView2 = dialogPreviewPosterBinding13.l;
                Intrinsics.c(shapeableImageView2, "mBinding.imgUser2");
                ImageView imageView2 = (ImageView) shapeableImageView2;
                DialogPreviewPosterBinding dialogPreviewPosterBinding14 = this.a;
                DialogPreviewPosterBinding dialogPreviewPosterBinding15 = dialogPreviewPosterBinding14;
                if (dialogPreviewPosterBinding14 == null) {
                    Intrinsics.c("mBinding");
                    dialogPreviewPosterBinding15 = null;
                }
                TextView textView4 = dialogPreviewPosterBinding15.x;
                Intrinsics.c(textView4, "mBinding.tvSecondUnit");
                a(yYThemeRankList, textView3, imageView2, textView4);
            } else if (i2 == 2) {
                DialogPreviewPosterBinding dialogPreviewPosterBinding16 = this.a;
                DialogPreviewPosterBinding dialogPreviewPosterBinding17 = dialogPreviewPosterBinding16;
                if (dialogPreviewPosterBinding16 == null) {
                    Intrinsics.c("mBinding");
                    dialogPreviewPosterBinding17 = null;
                }
                TextView textView5 = dialogPreviewPosterBinding17.y;
                Intrinsics.c(textView5, "mBinding.tvThirdName");
                DialogPreviewPosterBinding dialogPreviewPosterBinding18 = this.a;
                DialogPreviewPosterBinding dialogPreviewPosterBinding19 = dialogPreviewPosterBinding18;
                if (dialogPreviewPosterBinding18 == null) {
                    Intrinsics.c("mBinding");
                    dialogPreviewPosterBinding19 = null;
                }
                ShapeableImageView shapeableImageView3 = dialogPreviewPosterBinding19.m;
                Intrinsics.c(shapeableImageView3, "mBinding.imgUser3");
                ImageView imageView3 = (ImageView) shapeableImageView3;
                DialogPreviewPosterBinding dialogPreviewPosterBinding20 = this.a;
                DialogPreviewPosterBinding dialogPreviewPosterBinding21 = dialogPreviewPosterBinding20;
                if (dialogPreviewPosterBinding20 == null) {
                    Intrinsics.c("mBinding");
                    dialogPreviewPosterBinding21 = null;
                }
                TextView textView6 = dialogPreviewPosterBinding21.z;
                Intrinsics.c(textView6, "mBinding.tvThirdUnit");
                a(yYThemeRankList, textView5, imageView3, textView6);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYPreviewPosterDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackYY.a(ChatRoomProtos.Event.YY_CELEBRATION_PRE_FEED_CANCEL_CLICK);
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYPreviewPosterDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackYY.a(ChatRoomProtos.Event.YY_CELEBRATION_PRE_FEED_CLICK);
        this$0.h();
    }

    private final void f() {
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        List<YYShareAchievementModel> list = this.c;
        GridLayoutManager gridLayoutManager2 = gridLayoutManager;
        if (list != null) {
            Integer valueOf = list == null ? null : Integer.valueOf(list.size());
            Intrinsics.a(valueOf);
            gridLayoutManager2 = gridLayoutManager;
            if (valueOf.intValue() <= 1) {
                GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getContext(), 1);
                DialogPreviewPosterBinding dialogPreviewPosterBinding = this.a;
                DialogPreviewPosterBinding dialogPreviewPosterBinding2 = dialogPreviewPosterBinding;
                if (dialogPreviewPosterBinding == null) {
                    Intrinsics.c("mBinding");
                    dialogPreviewPosterBinding2 = null;
                }
                dialogPreviewPosterBinding2.n.setVisibility(4);
                DialogPreviewPosterBinding dialogPreviewPosterBinding3 = this.a;
                DialogPreviewPosterBinding dialogPreviewPosterBinding4 = dialogPreviewPosterBinding3;
                if (dialogPreviewPosterBinding3 == null) {
                    Intrinsics.c("mBinding");
                    dialogPreviewPosterBinding4 = null;
                }
                ConstraintLayout.LayoutParams layoutParams = dialogPreviewPosterBinding4.r.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                layoutParams.width = -2;
                gridLayoutManager2 = gridLayoutManager3;
            }
        }
        DialogPreviewPosterBinding dialogPreviewPosterBinding5 = this.a;
        DialogPreviewPosterBinding dialogPreviewPosterBinding6 = dialogPreviewPosterBinding5;
        if (dialogPreviewPosterBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding6 = null;
        }
        dialogPreviewPosterBinding6.r.setLayoutManager(gridLayoutManager2);
        this.b = new AchievementAdapter();
        DialogPreviewPosterBinding dialogPreviewPosterBinding7 = this.a;
        DialogPreviewPosterBinding dialogPreviewPosterBinding8 = dialogPreviewPosterBinding7;
        if (dialogPreviewPosterBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding8 = null;
        }
        RecyclerView recyclerView = dialogPreviewPosterBinding8.r;
        RecyclerView.Adapter adapter = this.b;
        AchievementAdapter achievementAdapter = adapter;
        if (adapter == null) {
            Intrinsics.c("mAdapter");
            achievementAdapter = null;
        }
        recyclerView.setAdapter(achievementAdapter);
        AchievementAdapter achievementAdapter2 = this.b;
        if (achievementAdapter2 == null) {
            Intrinsics.c("mAdapter");
            achievementAdapter2 = null;
        }
        achievementAdapter2.setNewData(this.c);
    }

    private final void g() {
        DialogPreviewPosterBinding dialogPreviewPosterBinding = this.a;
        DialogPreviewPosterBinding dialogPreviewPosterBinding2 = dialogPreviewPosterBinding;
        if (dialogPreviewPosterBinding == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding2 = null;
        }
        dialogPreviewPosterBinding2.p.setOutlineProvider(new ViewOutlineProvider() { // from class: com.blued.android.module.yy_china.fragment.YYPreviewPosterDialog$initBackground$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (view == null) {
                    return;
                }
                YYPreviewPosterDialog yYPreviewPosterDialog = YYPreviewPosterDialog.this;
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), DensityUtils.a(yYPreviewPosterDialog.getContext(), 12.0f));
            }
        });
        DialogPreviewPosterBinding dialogPreviewPosterBinding3 = this.a;
        if (dialogPreviewPosterBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding3 = null;
        }
        dialogPreviewPosterBinding3.p.setClipToOutline(true);
    }

    private final void h() {
        DialogPreviewPosterBinding dialogPreviewPosterBinding = this.a;
        DialogPreviewPosterBinding dialogPreviewPosterBinding2 = dialogPreviewPosterBinding;
        if (dialogPreviewPosterBinding == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding2 = null;
        }
        Bitmap a = BitmapUtils.a(dialogPreviewPosterBinding2.p, Bitmap.Config.ARGB_8888);
        StringBuilder sb = new StringBuilder();
        FragmentActivity activity = getActivity();
        sb.append(activity == null ? null : activity.getFilesDir());
        sb.append('/');
        sb.append(System.currentTimeMillis());
        sb.append(".png");
        YYRoomInfoManager.e().c().a(getContext(), "", BitmapUtils.a(sb.toString(), a, 100, true).getPath());
    }

    public final void a(List<YYShareAchievementModel> list, YYThemeActivityInfo yYThemeActivityInfo, List<YYThemeRankList> list2, YYEventsThemeModel yYEventsThemeModel) {
        this.c = list;
        this.e = yYThemeActivityInfo;
        this.d = list2;
        this.f = yYEventsThemeModel;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_preview_poster, (ViewGroup) null);
        DialogPreviewPosterBinding a = DialogPreviewPosterBinding.a(inflate);
        Intrinsics.c(a, "bind(view)");
        this.a = a;
        YYThemeActivityInfo yYThemeActivityInfo = this.e;
        if (yYThemeActivityInfo != null) {
            DialogPreviewPosterBinding dialogPreviewPosterBinding = a;
            if (a == null) {
                Intrinsics.c("mBinding");
                dialogPreviewPosterBinding = null;
            }
            dialogPreviewPosterBinding.A.setText(yYThemeActivityInfo.getName());
            DialogPreviewPosterBinding dialogPreviewPosterBinding2 = this.a;
            if (dialogPreviewPosterBinding2 == null) {
                Intrinsics.c("mBinding");
                dialogPreviewPosterBinding2 = null;
            }
            dialogPreviewPosterBinding2.v.setText(TimeAndDateUtils.f(yYThemeActivityInfo.getStart_time()) + " 至 " + ((Object) TimeAndDateUtils.f(yYThemeActivityInfo.getEnd_time())));
        }
        a(this.f);
        f();
        a(this.d);
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        DialogPreviewPosterBinding dialogPreviewPosterBinding = this.a;
        DialogPreviewPosterBinding dialogPreviewPosterBinding2 = dialogPreviewPosterBinding;
        if (dialogPreviewPosterBinding == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding2 = null;
        }
        dialogPreviewPosterBinding2.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPreviewPosterDialog$8shWfzKmDQ2QmwYnaWCkTdoULrs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPreviewPosterDialog.a(YYPreviewPosterDialog.this, view2);
            }
        });
        DialogPreviewPosterBinding dialogPreviewPosterBinding3 = this.a;
        DialogPreviewPosterBinding dialogPreviewPosterBinding4 = dialogPreviewPosterBinding3;
        if (dialogPreviewPosterBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding4 = null;
        }
        dialogPreviewPosterBinding4.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPreviewPosterDialog$VrGDQ7QtnRX83ml11030Yeed9og
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPreviewPosterDialog.b(YYPreviewPosterDialog.this, view2);
            }
        });
        DialogPreviewPosterBinding dialogPreviewPosterBinding5 = this.a;
        if (dialogPreviewPosterBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogPreviewPosterBinding5 = null;
        }
        dialogPreviewPosterBinding5.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPreviewPosterDialog$2u5Oo-C2yMorK8sB3WpAL8Ed6eA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPreviewPosterDialog.c(YYPreviewPosterDialog.this, view2);
            }
        });
    }
}
