package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.widget.refresh.BluedLoadMoreView;
import com.blued.android.module.live.base.music.model.YYChorusMusicModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogChorusPlaylistBinding;
import com.blued.android.module.yy_china.fragment.YYChorusPlaylistDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChorusPlaylistDialog.class */
public final class YYChorusPlaylistDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogChorusPlaylistBinding f17141a;
    private PlaylistAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private int f17142c = 1;
    private View d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChorusPlaylistDialog$PlaylistAdapter.class */
    public final class PlaylistAdapter extends BaseQuickAdapter<YYChorusMusicModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYChorusPlaylistDialog f17143a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlaylistAdapter(YYChorusPlaylistDialog this$0) {
            super(R.layout.item_chorus_playlist_layout);
            Intrinsics.e(this$0, "this$0");
            this.f17143a = this$0;
        }

        private final void a(final int i) {
            PlaylistAdapter playlistAdapter = this.f17143a.b;
            PlaylistAdapter playlistAdapter2 = null;
            PlaylistAdapter playlistAdapter3 = playlistAdapter;
            if (playlistAdapter == null) {
                Intrinsics.c("mAdapter");
                playlistAdapter3 = null;
            }
            if (i >= playlistAdapter3.getData().size()) {
                return;
            }
            YYRoomModel b = YYRoomInfoManager.e().b();
            String str = b == null ? null : b.room_id;
            PlaylistAdapter playlistAdapter4 = this.f17143a.b;
            if (playlistAdapter4 == null) {
                Intrinsics.c("mAdapter");
            } else {
                playlistAdapter2 = playlistAdapter4;
            }
            String str2 = playlistAdapter2.getData().get(i).musicId;
            final ActivityFragmentActive a2 = this.f17143a.a();
            final YYChorusPlaylistDialog yYChorusPlaylistDialog = this.f17143a;
            YYRoomHttpUtils.r(str, str2, new BluedUIHttpResponse<BluedEntityA<Object>>(i, a2) { // from class: com.blued.android.module.yy_china.fragment.YYChorusPlaylistDialog$PlaylistAdapter$deleteMusic$1
                final /* synthetic */ int b;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(a2);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    YYChorusPlaylistDialog.PlaylistAdapter playlistAdapter5 = YYChorusPlaylistDialog.this.b;
                    YYChorusPlaylistDialog.PlaylistAdapter playlistAdapter6 = playlistAdapter5;
                    if (playlistAdapter5 == null) {
                        Intrinsics.c("mAdapter");
                        playlistAdapter6 = null;
                    }
                    playlistAdapter6.remove(this.b);
                }
            }, this.f17143a.a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(PlaylistAdapter this$0, BaseViewHolder baseViewHolder, View view) {
            Intrinsics.e(this$0, "this$0");
            this$0.a(baseViewHolder.getAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(final PlaylistAdapter this$0, final BaseViewHolder baseViewHolder, View view) {
            Intrinsics.e(this$0, "this$0");
            new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusPlaylistDialog$PlaylistAdapter$yPJTolb3DiLVi61l_IPs1OJRRiQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYChorusPlaylistDialog.PlaylistAdapter.a(YYChorusPlaylistDialog.PlaylistAdapter.this, baseViewHolder, view2);
                }
            }, 2000L, null).onClick(view);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:71:0x016f  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x01e9  */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void convert(final com.chad.library.adapter.base.BaseViewHolder r7, com.blued.android.module.live.base.music.model.YYChorusMusicModel r8) {
            /*
                Method dump skipped, instructions count: 551
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYChorusPlaylistDialog.PlaylistAdapter.convert(com.chad.library.adapter.base.BaseViewHolder, com.blued.android.module.live.base.music.model.YYChorusMusicModel):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYChorusPlaylistDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        this.b = new PlaylistAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding = this.f17141a;
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding2 = dialogChorusPlaylistBinding;
        if (dialogChorusPlaylistBinding == null) {
            Intrinsics.c("mBinding");
            dialogChorusPlaylistBinding2 = null;
        }
        dialogChorusPlaylistBinding2.b.setLayoutManager(linearLayoutManager);
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding3 = this.f17141a;
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding4 = dialogChorusPlaylistBinding3;
        if (dialogChorusPlaylistBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogChorusPlaylistBinding4 = null;
        }
        RecyclerView recyclerView = dialogChorusPlaylistBinding4.b;
        PlaylistAdapter playlistAdapter = this.b;
        if (playlistAdapter == null) {
            Intrinsics.c("mAdapter");
            playlistAdapter = null;
        }
        recyclerView.setAdapter(playlistAdapter);
    }

    private final void g() {
        View view;
        FrameLayout frameLayout;
        BluedLoadMoreView bluedLoadMoreView = new BluedLoadMoreView(getContext());
        bluedLoadMoreView.setBackgroundColorRes(R.color.transparent);
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding = this.f17141a;
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding2 = dialogChorusPlaylistBinding;
        if (dialogChorusPlaylistBinding == null) {
            Intrinsics.c("mBinding");
            dialogChorusPlaylistBinding2 = null;
        }
        dialogChorusPlaylistBinding2.f16308c.a(bluedLoadMoreView);
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding3 = this.f17141a;
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding4 = dialogChorusPlaylistBinding3;
        if (dialogChorusPlaylistBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogChorusPlaylistBinding4 = null;
        }
        RefreshFooter refreshFooter = dialogChorusPlaylistBinding4.f16308c.getRefreshFooter();
        if (refreshFooter != null && (view = refreshFooter.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(R.id.layout_load_more_view)) != null) {
            frameLayout.setBackgroundResource(R.color.transparent);
        }
        View inflate = View.inflate(getContext(), R.layout.layout_load_end_footer, null);
        this.d = inflate;
        if (inflate != null) {
            inflate.setVisibility(8);
        }
        PlaylistAdapter playlistAdapter = this.b;
        PlaylistAdapter playlistAdapter2 = playlistAdapter;
        if (playlistAdapter == null) {
            Intrinsics.c("mAdapter");
            playlistAdapter2 = null;
        }
        playlistAdapter2.addFooterView(this.d);
        PlaylistAdapter playlistAdapter3 = this.b;
        PlaylistAdapter playlistAdapter4 = playlistAdapter3;
        if (playlistAdapter3 == null) {
            Intrinsics.c("mAdapter");
            playlistAdapter4 = null;
        }
        playlistAdapter4.setEnableLoadMore(false);
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding5 = this.f17141a;
        if (dialogChorusPlaylistBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogChorusPlaylistBinding5 = null;
        }
        dialogChorusPlaylistBinding5.f16308c.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYChorusPlaylistDialog$initRefreshView$1
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYChorusPlaylistDialog.this.h();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYChorusPlaylistDialog.this.f17142c = 1;
                YYChorusPlaylistDialog.this.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str = b == null ? null : b.room_id;
        int i = this.f17142c;
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.a(str, i, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYChorusMusicModel, BluedEntityBaseExtra>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYChorusPlaylistDialog$loadPlaylist$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                YYChorusPlaylistDialog.this.i();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYChorusMusicModel, BluedEntityBaseExtra> bluedEntity) {
                int i2;
                DialogChorusPlaylistBinding dialogChorusPlaylistBinding;
                View view;
                int i3;
                DialogChorusPlaylistBinding dialogChorusPlaylistBinding2;
                View view2;
                DialogChorusPlaylistBinding dialogChorusPlaylistBinding3;
                if (bluedEntity == null) {
                    YYChorusPlaylistDialog.this.i();
                    return;
                }
                i2 = YYChorusPlaylistDialog.this.f17142c;
                if (i2 == 1) {
                    dialogChorusPlaylistBinding3 = YYChorusPlaylistDialog.this.f17141a;
                    DialogChorusPlaylistBinding dialogChorusPlaylistBinding4 = dialogChorusPlaylistBinding3;
                    if (dialogChorusPlaylistBinding3 == null) {
                        Intrinsics.c("mBinding");
                        dialogChorusPlaylistBinding4 = null;
                    }
                    ShapeTextView shapeTextView = dialogChorusPlaylistBinding4.e;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                    String string = YYChorusPlaylistDialog.this.getResources().getString(R.string.yy_playlist_amount);
                    Intrinsics.c(string, "resources.getString(R.string.yy_playlist_amount)");
                    BluedEntityBaseExtra bluedEntityBaseExtra = bluedEntity.extra;
                    String format = String.format(string, Arrays.copyOf(new Object[]{bluedEntityBaseExtra == null ? null : Integer.valueOf(bluedEntityBaseExtra.total)}, 1));
                    Intrinsics.c(format, "format(format, *args)");
                    shapeTextView.setText(format);
                    YYChorusPlaylistDialog.PlaylistAdapter playlistAdapter = YYChorusPlaylistDialog.this.b;
                    YYChorusPlaylistDialog.PlaylistAdapter playlistAdapter2 = playlistAdapter;
                    if (playlistAdapter == null) {
                        Intrinsics.c("mAdapter");
                        playlistAdapter2 = null;
                    }
                    playlistAdapter2.setNewData(bluedEntity.data);
                } else {
                    YYChorusPlaylistDialog.PlaylistAdapter playlistAdapter3 = YYChorusPlaylistDialog.this.b;
                    YYChorusPlaylistDialog.PlaylistAdapter playlistAdapter4 = playlistAdapter3;
                    if (playlistAdapter3 == null) {
                        Intrinsics.c("mAdapter");
                        playlistAdapter4 = null;
                    }
                    playlistAdapter4.addData((Collection) bluedEntity.data);
                }
                if (!bluedEntity.hasMore()) {
                    dialogChorusPlaylistBinding = YYChorusPlaylistDialog.this.f17141a;
                    DialogChorusPlaylistBinding dialogChorusPlaylistBinding5 = dialogChorusPlaylistBinding;
                    if (dialogChorusPlaylistBinding5 == null) {
                        Intrinsics.c("mBinding");
                        dialogChorusPlaylistBinding5 = null;
                    }
                    dialogChorusPlaylistBinding5.f16308c.l(false);
                    view = YYChorusPlaylistDialog.this.d;
                    if (view == null) {
                        return;
                    }
                    view.setVisibility(0);
                    return;
                }
                YYChorusPlaylistDialog yYChorusPlaylistDialog = YYChorusPlaylistDialog.this;
                i3 = yYChorusPlaylistDialog.f17142c;
                yYChorusPlaylistDialog.f17142c = i3 + 1;
                dialogChorusPlaylistBinding2 = YYChorusPlaylistDialog.this.f17141a;
                DialogChorusPlaylistBinding dialogChorusPlaylistBinding6 = dialogChorusPlaylistBinding2;
                if (dialogChorusPlaylistBinding6 == null) {
                    Intrinsics.c("mBinding");
                    dialogChorusPlaylistBinding6 = null;
                }
                dialogChorusPlaylistBinding6.f16308c.l(true);
                view2 = YYChorusPlaylistDialog.this.d;
                if (view2 == null) {
                    return;
                }
                view2.setVisibility(8);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding = this.f17141a;
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding2 = dialogChorusPlaylistBinding;
        if (dialogChorusPlaylistBinding == null) {
            Intrinsics.c("mBinding");
            dialogChorusPlaylistBinding2 = null;
        }
        dialogChorusPlaylistBinding2.f16308c.h();
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding3 = this.f17141a;
        if (dialogChorusPlaylistBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogChorusPlaylistBinding3 = null;
        }
        dialogChorusPlaylistBinding3.f16308c.j();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_chorus_playlist, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…laylist, container, true)");
        DialogChorusPlaylistBinding a2 = DialogChorusPlaylistBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.f17141a = a2;
        f();
        g();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding = this.f17141a;
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding2 = dialogChorusPlaylistBinding;
        if (dialogChorusPlaylistBinding == null) {
            Intrinsics.c("mBinding");
            dialogChorusPlaylistBinding2 = null;
        }
        dialogChorusPlaylistBinding2.f16307a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusPlaylistDialog$dsurF8IWl_HYRD2JwTDYqkjAIxE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYChorusPlaylistDialog.a(YYChorusPlaylistDialog.this, view2);
            }
        });
        DialogChorusPlaylistBinding dialogChorusPlaylistBinding3 = this.f17141a;
        if (dialogChorusPlaylistBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogChorusPlaylistBinding3 = null;
        }
        dialogChorusPlaylistBinding3.f16308c.i();
    }
}
