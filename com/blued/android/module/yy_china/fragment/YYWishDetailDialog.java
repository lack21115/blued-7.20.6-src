package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYWishDetailAdapter;
import com.blued.android.module.yy_china.databinding.ViewYyWishDetailLayoutBinding;
import com.blued.android.module.yy_china.fragment.YYWishDetailDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYWishGoodsExtraModel;
import com.blued.android.module.yy_china.model.YYWishGoodsModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYWishRankingView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYWishDetailDialog.class */
public final class YYWishDetailDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f17489a;
    private ViewYyWishDetailLayoutBinding b;

    /* renamed from: c  reason: collision with root package name */
    private YYWishDetailAdapter f17490c;
    private GoldUserAdapter d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYWishDetailDialog$GoldUserAdapter.class */
    public final class GoldUserAdapter extends BaseQuickAdapter<YYAudienceModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYWishDetailDialog f17491a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoldUserAdapter(YYWishDetailDialog this$0) {
            super(R.layout.item_yy_gold_user, null);
            Intrinsics.e(this$0, "this$0");
            this.f17491a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYWishDetailDialog this$0, YYAudienceModel yYAudienceModel, View view) {
            Intrinsics.e(this$0, "this$0");
            if (this$0.f() == null) {
                return;
            }
            YYRoomInfoManager.e().c().a(this$0.getContext(), yYAudienceModel == null ? null : yYAudienceModel.getUid(), yYAudienceModel == null ? null : yYAudienceModel.getName(), yYAudienceModel == null ? null : yYAudienceModel.getAvatar(), 0, 2);
            this$0.f().onBackPressed();
            FragmentActivity activity = this$0.f().getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final YYAudienceModel yYAudienceModel) {
            String avatar;
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.iv_user_head);
            if (yYAudienceModel != null && (avatar = yYAudienceModel.getAvatar()) != null) {
                ImageLoader.a(this.f17491a.f().getFragmentActive(), avatar).a(imageView);
            }
            if (imageView == null) {
                return;
            }
            final YYWishDetailDialog yYWishDetailDialog = this.f17491a;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYWishDetailDialog$GoldUserAdapter$STJw_FKDbdGuIIgJMDFDMmYhz9Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYWishDetailDialog.GoldUserAdapter.a(YYWishDetailDialog.this, yYAudienceModel, view);
                }
            });
        }
    }

    public YYWishDetailDialog(BaseYYStudioFragment fragment) {
        Intrinsics.e(fragment, "fragment");
        this.f17489a = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_WISH_RESET_NO_CLICK, b.room_id, b.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYWishDetailDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends YYWishGoodsModel> list) {
        RecyclerView recyclerView;
        GridLayoutManager linearLayoutManager;
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding = this.b;
        ViewGroup.LayoutParams layoutParams = (viewYyWishDetailLayoutBinding == null || (recyclerView = viewYyWishDetailLayoutBinding.e) == null) ? null : recyclerView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (list.size() >= 3) {
            layoutParams2.width = -1;
            YYWishDetailAdapter yYWishDetailAdapter = this.f17490c;
            if (yYWishDetailAdapter != null) {
                yYWishDetailAdapter.a(0);
            }
            linearLayoutManager = new GridLayoutManager(getContext(), 3);
        } else {
            layoutParams2.width = -2;
            YYWishDetailAdapter yYWishDetailAdapter2 = this.f17490c;
            if (yYWishDetailAdapter2 != null) {
                yYWishDetailAdapter2.a(DensityUtils.a(getContext(), 100.0f));
            }
            linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(0);
        }
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding2 = this.b;
        RecyclerView recyclerView2 = viewYyWishDetailLayoutBinding2 == null ? null : viewYyWishDetailLayoutBinding2.e;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding3 = this.b;
        RecyclerView recyclerView3 = viewYyWishDetailLayoutBinding3 == null ? null : viewYyWishDetailLayoutBinding3.e;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.f17490c);
        }
        YYWishDetailAdapter yYWishDetailAdapter3 = this.f17490c;
        if (yYWishDetailAdapter3 == null) {
            return;
        }
        yYWishDetailAdapter3.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYWishDetailDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_USER_LIST_CLICK, b.room_id, b.uid);
        }
        YYWishRankingView yYWishRankingView = new YYWishRankingView(this$0.getContext());
        yYWishRankingView.a(this$0.f17489a);
        this$0.f17489a.a(yYWishRankingView, -2);
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYWishDetailDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_WISH_RESET_YES_CLICK, b.room_id, b.uid);
        }
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final YYWishDetailDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_WISH_RESET_CLICK, b.room_id, b.uid);
        }
        View inflate = LayoutInflater.from(this$0.f17489a.getContext()).inflate(R.layout.dialog_single_line_layout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_title_text)).setText("确认重置吗？重置后，当前心愿礼物数据会被清空。");
        LiveAlterDialog.b(this$0.getContext(), inflate, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYWishDetailDialog$XXq6SMM5yNqWdVgci7lz1zNs_BY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYWishDetailDialog.a(view2);
            }
        }, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYWishDetailDialog$mEcv2KDH2W1_RVHiWw8JheoBMgw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYWishDetailDialog.c(YYWishDetailDialog.this, view2);
            }
        }, true, false);
    }

    private final void g() {
        TextView textView;
        TextView textView2;
        View view;
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding = this.b;
        if (viewYyWishDetailLayoutBinding != null && (view = viewYyWishDetailLayoutBinding.b) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYWishDetailDialog$WdzMDZk2B_Ux8MfYMMDI2xn5AAI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYWishDetailDialog.a(YYWishDetailDialog.this, view2);
                }
            });
        }
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding2 = this.b;
        TextView textView3 = viewYyWishDetailLayoutBinding2 == null ? null : viewYyWishDetailLayoutBinding2.f;
        if (textView3 != null) {
            textView3.setVisibility(YYRoomInfoManager.e().y() ? 0 : 8);
        }
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding3 = this.b;
        TextView textView4 = viewYyWishDetailLayoutBinding3 == null ? null : viewYyWishDetailLayoutBinding3.j;
        if (textView4 != null) {
            textView4.setText(YYRoomInfoManager.e().y() ? getResources().getString(R.string.yy_create_wish_mess) : "打赏房主，完成房主心愿");
        }
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding4 = this.b;
        if (viewYyWishDetailLayoutBinding4 != null && (textView2 = viewYyWishDetailLayoutBinding4.h) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYWishDetailDialog$1cRzRBzys4WEDX0cPYfM5NRPGNI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYWishDetailDialog.b(YYWishDetailDialog.this, view2);
                }
            });
        }
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding5 = this.b;
        if (viewYyWishDetailLayoutBinding5 != null && (textView = viewYyWishDetailLayoutBinding5.f) != null) {
            textView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYWishDetailDialog$LzDEgbnYXGl0Eb2CAZCRQIp0nAs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYWishDetailDialog.d(YYWishDetailDialog.this, view2);
                }
            }));
        }
        h();
    }

    private final void h() {
        YYWishDetailAdapter yYWishDetailAdapter = new YYWishDetailAdapter();
        this.f17490c = yYWishDetailAdapter;
        if (yYWishDetailAdapter != null) {
            yYWishDetailAdapter.a(new YYWishDetailAdapter.OnClickVoteListener() { // from class: com.blued.android.module.yy_china.fragment.YYWishDetailDialog$initAdapter$1
                @Override // com.blued.android.module.yy_china.adapter.YYWishDetailAdapter.OnClickVoteListener
                public void a(YYWishGoodsModel yYWishGoodsModel) {
                    if (YYWishDetailDialog.this.f() == null || yYWishGoodsModel == null) {
                        return;
                    }
                    YYWishDetailDialog yYWishDetailDialog = YYWishDetailDialog.this;
                    yYWishDetailDialog.f().y();
                    YYRoomModel b = YYRoomInfoManager.e().b();
                    if (b == null) {
                        return;
                    }
                    EventTrackYY.o(ChatRoomProtos.Event.CHAT_ROOM_USER_GIFT_SEND_CLICK, b.room_id, b.uid, yYWishGoodsModel.goods_id);
                    yYWishDetailDialog.f().a(true, "wish_goods", yYWishGoodsModel.goods_id, b.room_id);
                    yYWishDetailDialog.dismissAllowingStateLoss();
                }
            });
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding = this.b;
        RecyclerView recyclerView = viewYyWishDetailLayoutBinding == null ? null : viewYyWishDetailLayoutBinding.d;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        this.d = new GoldUserAdapter(this);
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding2 = this.b;
        RecyclerView recyclerView2 = viewYyWishDetailLayoutBinding2 == null ? null : viewYyWishDetailLayoutBinding2.d;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(this.d);
    }

    private final void i() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        String str = b.room_id;
        final ActivityFragmentActive fragmentActive = this.f17489a.getFragmentActive();
        YYRoomHttpUtils.C(str, new BluedUIHttpResponse<BluedEntity<YYWishGoodsModel, YYWishGoodsExtraModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYWishDetailDialog$getWishDetails$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYWishGoodsModel, YYWishGoodsExtraModel> bluedEntity) {
                ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding;
                ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding2;
                YYWishDetailDialog.GoldUserAdapter goldUserAdapter;
                ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding3;
                ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding4;
                RecyclerView recyclerView;
                ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding5;
                ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding6;
                if ((bluedEntity == null ? null : bluedEntity.data) == null) {
                    return;
                }
                YYWishDetailDialog yYWishDetailDialog = YYWishDetailDialog.this;
                List<YYWishGoodsModel> list = bluedEntity.data;
                if (list == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.blued.android.module.yy_china.model.YYWishGoodsModel>");
                }
                yYWishDetailDialog.a(list);
                YYWishGoodsExtraModel yYWishGoodsExtraModel = bluedEntity.extra;
                if (yYWishGoodsExtraModel == null) {
                    return;
                }
                YYWishDetailDialog yYWishDetailDialog2 = YYWishDetailDialog.this;
                if (TextUtils.equals("0", yYWishGoodsExtraModel.wish_complete)) {
                    if (YYRoomInfoManager.e().y()) {
                        viewYyWishDetailLayoutBinding6 = yYWishDetailDialog2.b;
                        TextView textView = viewYyWishDetailLayoutBinding6 == null ? null : viewYyWishDetailLayoutBinding6.i;
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                    } else {
                        viewYyWishDetailLayoutBinding3 = yYWishDetailDialog2.b;
                        TextView textView2 = viewYyWishDetailLayoutBinding3 == null ? null : viewYyWishDetailLayoutBinding3.i;
                        if (textView2 != null) {
                            textView2.setVisibility(8);
                        }
                        viewYyWishDetailLayoutBinding4 = yYWishDetailDialog2.b;
                        ViewGroup.LayoutParams layoutParams = (viewYyWishDetailLayoutBinding4 == null || (recyclerView = viewYyWishDetailLayoutBinding4.e) == null) ? null : recyclerView.getLayoutParams();
                        if (layoutParams == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        }
                        ((ConstraintLayout.LayoutParams) layoutParams).bottomMargin = DensityUtils.a(yYWishDetailDialog2.getContext(), 47.0f);
                    }
                    viewYyWishDetailLayoutBinding5 = yYWishDetailDialog2.b;
                    TextView textView3 = viewYyWishDetailLayoutBinding5 == null ? null : viewYyWishDetailLayoutBinding5.i;
                    if (textView3 != null) {
                        textView3.setText("今日还未达成心愿，快在房间完成心愿吧");
                    }
                } else {
                    viewYyWishDetailLayoutBinding = yYWishDetailDialog2.b;
                    TextView textView4 = viewYyWishDetailLayoutBinding == null ? null : viewYyWishDetailLayoutBinding.i;
                    if (textView4 != null) {
                        textView4.setVisibility(8);
                    }
                    viewYyWishDetailLayoutBinding2 = yYWishDetailDialog2.b;
                    TextView textView5 = viewYyWishDetailLayoutBinding2 == null ? null : viewYyWishDetailLayoutBinding2.i;
                    if (textView5 != null) {
                        textView5.setText("");
                    }
                }
                if (yYWishGoodsExtraModel.guard != null) {
                    List<YYAudienceModel> list2 = yYWishGoodsExtraModel.guard;
                    Intrinsics.c(list2, "it.guard");
                    if (!list2.isEmpty()) {
                        yYWishDetailDialog2.k();
                        goldUserAdapter = yYWishDetailDialog2.d;
                        if (goldUserAdapter == null) {
                            return;
                        }
                        goldUserAdapter.setNewData(yYWishGoodsExtraModel.guard);
                        return;
                    }
                }
                yYWishDetailDialog2.j();
            }
        }, this.f17489a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        ViewGroup.LayoutParams layoutParams;
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding = this.b;
        RelativeLayout relativeLayout = viewYyWishDetailLayoutBinding == null ? null : viewYyWishDetailLayoutBinding.f16975c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding2 = this.b;
        if (viewYyWishDetailLayoutBinding2 == null) {
            layoutParams = null;
        } else {
            TextView textView = viewYyWishDetailLayoutBinding2.g;
            layoutParams = textView == null ? null : textView.getLayoutParams();
        }
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.topToBottom = R.id.tv_wish_sub_title;
        layoutParams2.topMargin = DensityUtils.a(getContext(), 18.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        ViewGroup.LayoutParams layoutParams;
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding = this.b;
        RelativeLayout relativeLayout = viewYyWishDetailLayoutBinding == null ? null : viewYyWishDetailLayoutBinding.f16975c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        ViewYyWishDetailLayoutBinding viewYyWishDetailLayoutBinding2 = this.b;
        if (viewYyWishDetailLayoutBinding2 == null) {
            layoutParams = null;
        } else {
            TextView textView = viewYyWishDetailLayoutBinding2.g;
            layoutParams = textView == null ? null : textView.getLayoutParams();
        }
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.topToBottom = R.id.rl_gold;
        layoutParams2.topMargin = DensityUtils.a(getContext(), 10.0f);
    }

    private final void l() {
        if (YYRoomInfoManager.e().b() == null || this.f17489a == null) {
            return;
        }
        String str = YYRoomInfoManager.e().b().room_id;
        final ActivityFragmentActive fragmentActive = this.f17489a.getFragmentActive();
        YYRoomHttpUtils.E(str, new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYWishDetailDialog$resetWish$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                LiveEventBus.get("show_create_wish").post("");
                YYWishDetailDialog.this.dismissAllowingStateLoss();
            }
        }, this.f17489a.getFragmentActive());
    }

    public final BaseYYStudioFragment f() {
        return this.f17489a;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.view_yy_wish_detail_layout, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…_layout, container, true)");
        this.b = ViewYyWishDetailLayoutBinding.a(inflate);
        g();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        i();
    }
}
