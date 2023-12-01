package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogConfessedUserListBinding;
import com.blued.android.module.yy_china.databinding.ItemConfessedUserListBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ConfessedUserGiftMode;
import com.blued.android.module.yy_china.model.ConfessedUserMode;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.YYTextSpanComputer;
import com.blued.android.module.yy_china.view.YYConfessedUserListDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYConfessedUserListDialog.class */
public final class YYConfessedUserListDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogConfessedUserListBinding f18105a;
    private ConfessedOnClickUserListListener b;

    /* renamed from: c  reason: collision with root package name */
    private final ConfessedListUserAdapter f18106c = new ConfessedListUserAdapter(this);
    private int d = 1;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYConfessedUserListDialog$ConfessedListUserAdapter.class */
    public final class ConfessedListUserAdapter extends BaseQuickAdapter<ConfessedUserMode, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYConfessedUserListDialog f18107a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfessedListUserAdapter(YYConfessedUserListDialog this$0) {
            super(R.layout.item_confessed_user_list);
            Intrinsics.e(this$0, "this$0");
            this.f18107a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(ConfessedUserMode item, View view) {
            Intrinsics.e(item, "$item");
            YYUserInfo yYUserInfo = new YYUserInfo();
            yYUserInfo.setUid(item.getUid());
            yYUserInfo.setName(item.getName());
            yYUserInfo.setAvatar(item.getAvatar());
            LiveEventBus.get("open_user").post(yYUserInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYConfessedUserListDialog this$0, ConfessedUserMode item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            ConfessedOnClickUserListListener f = this$0.f();
            if (f != null) {
                f.a(item);
            }
            this$0.dismissAllowingStateLoss();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, final ConfessedUserMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            ItemConfessedUserListBinding a2 = ItemConfessedUserListBinding.a(helper.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            YYRoomInfoManager.e().a(this.f18107a.a(), a2.b, item.getUid(), item.getAvatar());
            a2.d.setText(YYRoomInfoManager.e().a(item.getUid(), item.getName()));
            YYTextSpanComputer.Builder builder = new YYTextSpanComputer.Builder();
            if (item.getAnchor_level() > 0) {
                Context context = this.f18107a.getContext();
                Intrinsics.a(context);
                Drawable drawable = context.getResources().getDrawable(YYRoomInfoManager.e().b(item.getAnchor_level()));
                drawable.setBounds(0, 0, AppMethods.a(32), AppMethods.a(16));
                Intrinsics.c(drawable, "drawable");
                builder.a(drawable).a(" ");
            }
            a2.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedUserListDialog$ConfessedListUserAdapter$8qCKUDJajg8HC2Ib5HvGFIFOR3A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYConfessedUserListDialog.ConfessedListUserAdapter.a(ConfessedUserMode.this, view);
                }
            });
            if (item.getHonor_level() > 0) {
                Context context2 = this.f18107a.getContext();
                Intrinsics.a(context2);
                Drawable drawable2 = context2.getResources().getDrawable(YYRoomInfoManager.e().a(item.getHonor_level()));
                drawable2.setBounds(0, 0, AppMethods.a(38), AppMethods.a(16));
                Intrinsics.c(drawable2, "drawable");
                builder.a(drawable2).a(" ");
            }
            a2.f16581c.setText(builder.c().a());
            ShapeTextView shapeTextView = a2.f16580a;
            final YYConfessedUserListDialog yYConfessedUserListDialog = this.f18107a;
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedUserListDialog$ConfessedListUserAdapter$kICaq_6UxbYU7DC9dK-3_yMFSOs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYConfessedUserListDialog.ConfessedListUserAdapter.a(YYConfessedUserListDialog.this, item, view);
                }
            });
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYConfessedUserListDialog$ConfessedOnClickUserListListener.class */
    public interface ConfessedOnClickUserListListener {
        void a(ConfessedUserMode confessedUserMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYConfessedUserListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYConfessedUserListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogConfessedUserListBinding j() {
        DialogConfessedUserListBinding dialogConfessedUserListBinding = this.f18105a;
        Intrinsics.a(dialogConfessedUserListBinding);
        return dialogConfessedUserListBinding;
    }

    private final void k() {
        ImageLoader.a(a(), ImgURLMap.f10885a.a("yy_confessed_user_list_url_bg")).a(j().f16316c);
        ImageLoader.a(a(), ImgURLMap.f10885a.a("yy_confessed_user_list_url_top_bg")).a(j().f);
        ImageLoader.a(a(), ImgURLMap.f10885a.a("yy_confessed_user_list_url_btn_data_null")).a(j().e);
        j().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedUserListDialog$ZFyDXe1BfzFFGkJ6dxWK85NMdrc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedUserListDialog.a(YYConfessedUserListDialog.this, view);
            }
        });
        j().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedUserListDialog$7TbFTKBModyXxX2D9Rnf_Xqpc6M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedUserListDialog.b(YYConfessedUserListDialog.this, view);
            }
        });
        j().h.setLayoutManager(new LinearLayoutManager(getContext()));
        j().h.setAdapter(this.f18106c);
        j().i.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.view.YYConfessedUserListDialog$initView$3
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYConfessedUserListDialog.this.i();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYConfessedUserListDialog.this.a(1);
                YYConfessedUserListDialog.this.i();
            }
        });
        j().i.c(true);
        j().i.i();
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(ConfessedOnClickUserListListener confessedOnClickUserListListener) {
        this.b = confessedOnClickUserListListener;
    }

    public final ConfessedOnClickUserListListener f() {
        return this.b;
    }

    public final ConfessedListUserAdapter g() {
        return this.f18106c;
    }

    public final int h() {
        return this.d;
    }

    public final void i() {
        if (YYRoomInfoManager.e().b() == null) {
            return;
        }
        String str = YYRoomInfoManager.e().b().room_id;
        int i = this.d;
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.h(str, i, new BluedUIHttpResponse<BluedEntityA<ConfessedUserGiftMode>>(a2) { // from class: com.blued.android.module.yy_china.view.YYConfessedUserListDialog$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ConfessedUserGiftMode> bluedEntityA) {
                DialogConfessedUserListBinding j;
                DialogConfessedUserListBinding j2;
                DialogConfessedUserListBinding j3;
                DialogConfessedUserListBinding j4;
                DialogConfessedUserListBinding j5;
                DialogConfessedUserListBinding j6;
                if (bluedEntityA != null) {
                    YYConfessedUserListDialog yYConfessedUserListDialog = YYConfessedUserListDialog.this;
                    ConfessedUserGiftMode singleData = bluedEntityA.getSingleData();
                    if (singleData != null) {
                        if (yYConfessedUserListDialog.h() == 1) {
                            yYConfessedUserListDialog.g().setNewData(singleData.getConfession_user());
                        } else {
                            yYConfessedUserListDialog.g().addData((Collection) singleData.getConfession_user());
                            j6 = yYConfessedUserListDialog.j();
                            j6.i.h();
                        }
                    }
                    if (bluedEntityA.hasMore()) {
                        j5 = yYConfessedUserListDialog.j();
                        j5.i.l(true);
                    } else {
                        j3 = yYConfessedUserListDialog.j();
                        j3.i.l(false);
                    }
                    j4 = yYConfessedUserListDialog.j();
                    j4.i.j();
                }
                if (YYConfessedUserListDialog.this.h() == 1 && (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData().getConfession_user() == null || bluedEntityA.getSingleData().getConfession_user().size() == 0)) {
                    j2 = YYConfessedUserListDialog.this.j();
                    j2.g.setVisibility(0);
                } else {
                    j = YYConfessedUserListDialog.this.j();
                    j.g.setVisibility(8);
                }
                YYConfessedUserListDialog yYConfessedUserListDialog2 = YYConfessedUserListDialog.this;
                yYConfessedUserListDialog2.a(yYConfessedUserListDialog2.h() + 1);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                DialogConfessedUserListBinding j;
                super.onUIFinish(z);
                if (!z && YYConfessedUserListDialog.this.h() > 1) {
                    YYConfessedUserListDialog yYConfessedUserListDialog = YYConfessedUserListDialog.this;
                    yYConfessedUserListDialog.a(yYConfessedUserListDialog.h() - 1);
                }
                j = YYConfessedUserListDialog.this.j();
                j.i.j();
            }
        }, a());
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_confessed_user_list, (ViewGroup) null);
        this.f18105a = DialogConfessedUserListBinding.a(inflate);
        k();
        return inflate;
    }
}
