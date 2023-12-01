package com.blued.android.module.yy_china.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentConfessedRankItemBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ConfessedMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YyConfessedGiftDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYConfessedRankItemFragment.class */
public final class YYConfessedRankItemFragment extends MvpFragment<MvpPresenter> {
    private FragmentConfessedRankItemBinding a;
    private boolean c;
    private String b = "2";
    private final YYConfessedRankItemAdapter d = new YYConfessedRankItemAdapter(this);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYConfessedRankItemFragment$YYConfessedRankItemAdapter.class */
    public final class YYConfessedRankItemAdapter extends BaseQuickAdapter<ConfessedMode, BaseViewHolder> {
        final /* synthetic */ YYConfessedRankItemFragment a;
        private final ArrayList<Integer> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public YYConfessedRankItemAdapter(YYConfessedRankItemFragment this$0) {
            super(R.layout.item_confessed_rank_item);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            this.b = CollectionsKt.d(Integer.valueOf(R.drawable.icon_yy_confessed_top_1), Integer.valueOf(R.drawable.icon_yy_confessed_top_2), Integer.valueOf(R.drawable.icon_yy_confessed_top_3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYConfessedRankItemFragment this$0, ConfessedMode item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            this$0.d(String.valueOf(item.getConfession_user().getRoom_id()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(YYConfessedRankItemFragment this$0, ConfessedMode item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            this$0.d(String.valueOf(item.getBeing_confession_user_to().getRoom_id()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x00c7, code lost:
            if (r0 == null) goto L6;
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void convert(com.chad.library.adapter.base.BaseViewHolder r7, final com.blued.android.module.yy_china.model.ConfessedMode r8) {
            /*
                Method dump skipped, instructions count: 454
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYConfessedRankItemFragment.YYConfessedRankItemAdapter.convert(com.chad.library.adapter.base.BaseViewHolder, com.blued.android.module.yy_china.model.ConfessedMode):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYConfessedRankItemFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YyConfessedGiftDialog yyConfessedGiftDialog = new YyConfessedGiftDialog();
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yyConfessedGiftDialog.show(childFragmentManager, "YyConfessedGiftDialog");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_SHOW_LOVE_TOP_PAGE_TO_CLICK, b.room_id, b.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYConfessedRankItemFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YyConfessedGiftDialog yyConfessedGiftDialog = new YyConfessedGiftDialog();
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yyConfessedGiftDialog.show(childFragmentManager, "YyConfessedGiftDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentConfessedRankItemBinding d() {
        FragmentConfessedRankItemBinding fragmentConfessedRankItemBinding = this.a;
        Intrinsics.a(fragmentConfessedRankItemBinding);
        return fragmentConfessedRankItemBinding;
    }

    private final void e() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<ConfessedMode>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<ConfessedMode>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYConfessedRankItemFragment$loadData$value$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ConfessedMode> bluedEntityA) {
                FragmentConfessedRankItemBinding d;
                YYConfessedRankItemFragment.this.c().setNewData(bluedEntityA == null ? null : bluedEntityA.data);
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    d = YYConfessedRankItemFragment.this.d();
                    d.c.setVisibility(0);
                }
            }
        };
        if (this.c) {
            if (StringUtils.a(this.b, "2")) {
                d().e.setText("注：根据自然周内占据尊享告白位的时长（单位为秒）降序排列，只显示前50名，每周日23:59:59清空");
            } else {
                d().e.setText("注：根据占据的累计尊享告白位的时长（单位为秒）降序排列，只显示前50名，无限累计，不做清空");
            }
            YYRoomHttpUtils.f(this.b, (BluedUIHttpResponse) bluedUIHttpResponse, (IRequestHost) getFragmentActive());
            return;
        }
        if (StringUtils.a(this.b, "2")) {
            d().e.setText("注：根据自然周内累计告白值降序排列，只显示前50名，每周日23:59:59清空");
        } else {
            d().e.setText("注：根据累计告白值降序排列，只显示前50名，无限累计，不做清空");
        }
        YYRoomHttpUtils.e(this.b, (BluedUIHttpResponse) bluedUIHttpResponse, (IRequestHost) getFragmentActive());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = FragmentConfessedRankItemBinding.a(this.i);
        ImageLoader.a(getFragmentActive(), ImgURLMap.a.a("yy_confessed_rank_item_btn_data_null")).a(d().b);
        ImageLoader.a(getFragmentActive(), ImgURLMap.a.a("yy_confessed_rank_item_btn_big_null")).a((Target) new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.fragment.YYConfessedRankItemFragment$onInitView$1
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                FragmentConfessedRankItemBinding d;
                Intrinsics.e(resource, "resource");
                d = YYConfessedRankItemFragment.this.d();
                d.a.setBackground(resource);
            }
        });
        d().d.setLayoutManager(new LinearLayoutManager(getContext()));
        d().d.setAdapter(this.d);
        d().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYConfessedRankItemFragment$O_cZStCFFw4mVagRu6hOkB3g5xE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRankItemFragment.a(YYConfessedRankItemFragment.this, view);
            }
        });
        d().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYConfessedRankItemFragment$BxFP74IJjEX4hj0W9v73qgZ8IDo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRankItemFragment.b(YYConfessedRankItemFragment.this, view);
            }
        });
        e();
    }

    public final void b(boolean z) {
        this.c = z;
    }

    public final boolean b() {
        return this.c;
    }

    public final YYConfessedRankItemAdapter c() {
        return this.d;
    }

    public final void c(String str) {
        Intrinsics.e(str, "<set-?>");
        this.b = str;
    }

    public final void d(String roomId) {
        Intrinsics.e(roomId, "roomId");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (StringUtils.a(b == null ? null : b.room_id, roomId)) {
            return;
        }
        YYRoomInfoManager e = YYRoomInfoManager.e();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.ui.BaseFragmentActivity");
        }
        e.a((BaseFragmentActivity) activity, roomId, "");
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_confessed_rank_item;
    }

    public final String getType() {
        return this.b;
    }
}
