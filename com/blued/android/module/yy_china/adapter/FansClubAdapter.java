package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYClubLevelInfoModel;
import com.blued.android.module.yy_china.model.YYClubRankMemberModel;
import com.blued.android.module.yy_china.view.YYFansLevelView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/FansClubAdapter.class */
public final class FansClubAdapter extends BaseQuickAdapter<YYClubRankMemberModel, BaseViewHolder> {
    private ActivityFragmentActive a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FansClubAdapter(ActivityFragmentActive fragmentActive) {
        super(R.layout.item_fans_info);
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.a = fragmentActive;
    }

    private final int a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? R.drawable.icon_yy_rank_1 : R.drawable.icon_yy_rank_3 : R.drawable.icon_yy_rank_2 : R.drawable.icon_yy_rank_1;
    }

    private final void a(Context context, YYClubRankMemberModel yYClubRankMemberModel) {
        if (YYRoomInfoManager.e().y()) {
            YYRoomInfoManager.e().c().a(context, yYClubRankMemberModel == null ? null : yYClubRankMemberModel.uid, yYClubRankMemberModel == null ? null : yYClubRankMemberModel.name, yYClubRankMemberModel == null ? null : yYClubRankMemberModel.avatar, 0, 2);
        }
    }

    private final void a(TextView textView, ImageView imageView, int i) {
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(a(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FansClubAdapter this$0, YYClubRankMemberModel yYClubRankMemberModel, View view) {
        Context context;
        Intrinsics.e(this$0, "this$0");
        if (view == null || (context = view.getContext()) == null) {
            return;
        }
        this$0.a(context, yYClubRankMemberModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FansClubAdapter this$0, YYClubRankMemberModel yYClubRankMemberModel, View view) {
        Context context;
        Intrinsics.e(this$0, "this$0");
        if (view == null || (context = view.getContext()) == null) {
            return;
        }
        this$0.a(context, yYClubRankMemberModel);
    }

    public final ActivityFragmentActive a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final YYClubRankMemberModel yYClubRankMemberModel) {
        Context context;
        String string;
        String format;
        TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_rank_number);
        ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_rank_number);
        ImageView imageView2 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_rank_avatar);
        TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_user_name);
        TextView textView3 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_consumption);
        YYFansLevelView yYFansLevelView = baseViewHolder == null ? null : (YYFansLevelView) baseViewHolder.getView(R.id.ll_fans_level);
        ShapeConstraintLayout shapeConstraintLayout = baseViewHolder == null ? null : (ShapeConstraintLayout) baseViewHolder.getView(R.id.shape_cont);
        if (yYClubRankMemberModel != null) {
            ImageLoader.a(a(), yYClubRankMemberModel.avatar).b(R.drawable.user_bg_round).a(imageView2);
            if (textView2 != null) {
                textView2.setText(yYClubRankMemberModel.name);
            }
            YYClubLevelInfoModel yYClubLevelInfoModel = yYClubRankMemberModel.level;
            if (yYClubLevelInfoModel != null) {
                if (textView3 != null) {
                    if (textView3 == null || (context = textView3.getContext()) == null || (string = context.getString(R.string.yy_fans_consumption)) == null) {
                        format = null;
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                        format = String.format(string, Arrays.copyOf(new Object[]{yYClubLevelInfoModel.score}, 1));
                        Intrinsics.c(format, "format(format, *args)");
                    }
                    textView3.setText(format);
                }
                if (yYFansLevelView != null) {
                    yYFansLevelView.a(yYClubLevelInfoModel.level.toString(), yYClubLevelInfoModel.name, yYClubLevelInfoModel.status == 1);
                }
            }
        }
        Integer valueOf = baseViewHolder == null ? null : Integer.valueOf(baseViewHolder.getAdapterPosition() + 1);
        if (valueOf != null) {
            if (valueOf.intValue() <= 3) {
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                a(textView, imageView, valueOf.intValue());
            } else {
                if (textView != null) {
                    textView.setVisibility(0);
                }
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (textView != null) {
                    textView.setText(valueOf.toString());
                }
            }
        }
        if (textView2 != null) {
            textView2.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$FansClubAdapter$aB8sU6ojPc2IrzyXnzesvh9cm8U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FansClubAdapter.a(FansClubAdapter.this, yYClubRankMemberModel, view);
                }
            }));
        }
        if (imageView2 != null) {
            imageView2.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$FansClubAdapter$toJvbeTGHsBpSgsDGzcTSK-njZY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FansClubAdapter.b(FansClubAdapter.this, yYClubRankMemberModel, view);
                }
            }));
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            ShapeHelper.a(shapeConstraintLayout, R.color.color_14F7295B, R.color.color_00F7295B);
        } else {
            ShapeHelper.a(shapeConstraintLayout, R.color.transparent, R.color.transparent);
        }
    }
}
