package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogRoomPkEndLayoutBinding;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYRoomPkMVPExtra;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPKEndDialogNew.class */
public final class YYPKEndDialogNew extends BaseFullScreenDialog {
    private YYRoomPkMVPExtra a;
    private DialogRoomPkEndLayoutBinding b;
    private RankAdapter c;
    private RankAdapter d;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPKEndDialogNew$RankAdapter.class */
    public final class RankAdapter extends BaseQuickAdapter<YYAudienceModel, BaseViewHolder> {
        final /* synthetic */ YYPKEndDialogNew a;
        private final boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RankAdapter(YYPKEndDialogNew this$0, boolean z) {
            super(R.layout.item_room_pk_rank, new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYAudienceModel yYAudienceModel) {
            View view;
            View view2;
            ShapeableImageView view3 = baseViewHolder == null ? null : baseViewHolder.getView(R.id.header_img);
            ShapeTextView shapeTextView = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.tv_serial_num);
            ShapeTextView shapeTextView2 = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.tv_empty);
            if (view3 != null) {
                view3.setImageResource(R.drawable.shape_circular_202020);
            }
            ShapeHelper.b(shapeTextView2, R.color.syc_tran30_FFFFFF);
            if (this.b) {
                if (view3 != null) {
                    view3.setStrokeColor(ContextCompat.getColorStateList(this.mContext, R.color.syc_FF57F0));
                }
                ShapeHelper.b(shapeTextView, R.color.syc_FF57F0);
                if (baseViewHolder != null && (view2 = baseViewHolder.itemView) != null) {
                    view2.setPadding(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.dp_5), 0);
                }
            } else {
                if (view3 != null) {
                    view3.setStrokeColor(ContextCompat.getColorStateList(this.mContext, R.color.syc_3883FD));
                }
                ShapeHelper.b(shapeTextView, R.color.syc_3883FD);
                if (baseViewHolder != null && (view = baseViewHolder.itemView) != null) {
                    view.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.dp_5), 0, 0, 0);
                }
            }
            if (yYAudienceModel != null) {
                if (TextUtils.isEmpty(yYAudienceModel.getUid())) {
                    if (shapeTextView != null) {
                        shapeTextView.setVisibility(8);
                    }
                    if (shapeTextView2 == null) {
                        return;
                    }
                    shapeTextView2.setVisibility(0);
                    return;
                }
                if (shapeTextView2 != null) {
                    shapeTextView2.setVisibility(8);
                }
                if (shapeTextView != null) {
                    shapeTextView.setVisibility(0);
                }
                ImageLoader.a((IRequestHost) null, yYAudienceModel.getAvatar()).b(R.drawable.shape_circular_202020).d(R.drawable.user_bg_round).a((ImageView) view3);
            }
            if (shapeTextView == null) {
                return;
            }
            shapeTextView.setText(String.valueOf(baseViewHolder == null ? null : Integer.valueOf(baseViewHolder.getAdapterPosition() + 1)));
        }
    }

    public YYPKEndDialogNew(YYRoomPkMVPExtra yYRoomPkMVPExtra) {
        this.a = yYRoomPkMVPExtra;
    }

    private final void a(RankAdapter rankAdapter, List<YYAudienceModel> list) {
        ArrayList arrayList = list == null ? new ArrayList() : list;
        if (arrayList.size() < 3) {
            int size = arrayList.size();
            int i = 0;
            while (i < 3 - size) {
                i++;
                arrayList.add(null);
            }
        }
        if (rankAdapter == null) {
            return;
        }
        rankAdapter.setNewData(list);
    }

    private final void f() {
        g();
        i();
        h();
    }

    private final void g() {
        YYAudienceModel yYAudienceModel;
        YYAudienceModel yYAudienceModel2;
        YYRoomPkMVPExtra yYRoomPkMVPExtra = this.a;
        if (yYRoomPkMVPExtra != null && (yYAudienceModel2 = yYRoomPkMVPExtra.anchor_info) != null) {
            ImageWrapper a = ImageLoader.a(a(), yYAudienceModel2.getAvatar());
            DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding = this.b;
            a.a(dialogRoomPkEndLayoutBinding == null ? null : dialogRoomPkEndLayoutBinding.g);
        }
        YYRoomPkMVPExtra yYRoomPkMVPExtra2 = this.a;
        if (yYRoomPkMVPExtra2 == null || (yYAudienceModel = yYRoomPkMVPExtra2.other_anchor_info) == null) {
            return;
        }
        ImageWrapper a2 = ImageLoader.a(a(), yYAudienceModel.getAvatar());
        DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding2 = this.b;
        a2.a(dialogRoomPkEndLayoutBinding2 == null ? null : dialogRoomPkEndLayoutBinding2.h);
    }

    private final void h() {
        this.c = new RankAdapter(this, true);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding = this.b;
        RecyclerView recyclerView = dialogRoomPkEndLayoutBinding == null ? null : dialogRoomPkEndLayoutBinding.j;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding2 = this.b;
        RecyclerView recyclerView2 = dialogRoomPkEndLayoutBinding2 == null ? null : dialogRoomPkEndLayoutBinding2.j;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.c);
        }
        this.d = new RankAdapter(this, false);
        RecyclerView.LayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(0);
        linearLayoutManager2.setStackFromEnd(true);
        linearLayoutManager2.setReverseLayout(true);
        DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding3 = this.b;
        RecyclerView recyclerView3 = dialogRoomPkEndLayoutBinding3 == null ? null : dialogRoomPkEndLayoutBinding3.i;
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(linearLayoutManager2);
        }
        DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding4 = this.b;
        RecyclerView recyclerView4 = dialogRoomPkEndLayoutBinding4 == null ? null : dialogRoomPkEndLayoutBinding4.i;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(this.d);
        }
        RankAdapter rankAdapter = this.c;
        YYRoomPkMVPExtra yYRoomPkMVPExtra = this.a;
        a(rankAdapter, yYRoomPkMVPExtra == null ? null : yYRoomPkMVPExtra.rank_list);
        RankAdapter rankAdapter2 = this.d;
        YYRoomPkMVPExtra yYRoomPkMVPExtra2 = this.a;
        a(rankAdapter2, yYRoomPkMVPExtra2 == null ? null : yYRoomPkMVPExtra2.other_rank_list);
    }

    private final void i() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        YYRoomPkMVPExtra yYRoomPkMVPExtra = this.a;
        if (yYRoomPkMVPExtra == null) {
            return;
        }
        int i = yYRoomPkMVPExtra.result;
        if (i == 0) {
            DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding = this.b;
            if (dialogRoomPkEndLayoutBinding != null && (imageView2 = dialogRoomPkEndLayoutBinding.e) != null) {
                imageView2.setImageResource(R.drawable.icon_room_pk_dialog_draw);
            }
            DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding2 = this.b;
            if (dialogRoomPkEndLayoutBinding2 != null && (imageView = dialogRoomPkEndLayoutBinding2.f) != null) {
                imageView.setImageResource(R.drawable.icon_room_pk_dialog_draw);
            }
        } else if (i == 1) {
            DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding3 = this.b;
            if (dialogRoomPkEndLayoutBinding3 != null && (imageView4 = dialogRoomPkEndLayoutBinding3.e) != null) {
                imageView4.setImageResource(R.drawable.icon_room_pk_dialog_win);
            }
            DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding4 = this.b;
            if (dialogRoomPkEndLayoutBinding4 != null && (imageView3 = dialogRoomPkEndLayoutBinding4.f) != null) {
                imageView3.setImageResource(R.drawable.icon_room_pk_dialog_lose);
            }
        } else if (i == 2) {
            DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding5 = this.b;
            if (dialogRoomPkEndLayoutBinding5 != null && (imageView6 = dialogRoomPkEndLayoutBinding5.e) != null) {
                imageView6.setImageResource(R.drawable.icon_room_pk_dialog_lose);
            }
            DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding6 = this.b;
            if (dialogRoomPkEndLayoutBinding6 != null && (imageView5 = dialogRoomPkEndLayoutBinding6.f) != null) {
                imageView5.setImageResource(R.drawable.icon_room_pk_dialog_win);
            }
        }
        DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding7 = this.b;
        ImageView imageView7 = dialogRoomPkEndLayoutBinding7 == null ? null : dialogRoomPkEndLayoutBinding7.e;
        if (imageView7 != null) {
            imageView7.setVisibility(0);
        }
        DialogRoomPkEndLayoutBinding dialogRoomPkEndLayoutBinding8 = this.b;
        ImageView imageView8 = dialogRoomPkEndLayoutBinding8 == null ? null : dialogRoomPkEndLayoutBinding8.f;
        if (imageView8 == null) {
            return;
        }
        imageView8.setVisibility(0);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_room_pk_end_layout, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…_layout, container, true)");
        this.b = DialogRoomPkEndLayoutBinding.a(inflate);
        f();
        return inflate;
    }

    public final void setResult(YYRoomPkMVPExtra yYRoomPkMVPExtra) {
        this.a = yYRoomPkMVPExtra;
    }
}
