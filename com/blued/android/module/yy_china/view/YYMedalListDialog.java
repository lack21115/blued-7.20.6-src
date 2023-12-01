package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogMedalListsBinding;
import com.blued.android.module.yy_china.databinding.ItemMedalListBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.BadgeMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYMedalListDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMedalListDialog.class */
public final class YYMedalListDialog extends BaseFullScreenDialog {
    private DialogMedalListsBinding a;
    private YYUserInfo b;
    private BaseYYStudioFragment c;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMedalListDialog$Ad.class */
    public final class Ad extends BaseQuickAdapter<BadgeMode, BaseViewHolder> {
        final /* synthetic */ YYMedalListDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(YYMedalListDialog this$0) {
            super(R.layout.item_medal_list);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYMedalListDialog this$0, BadgeMode badgeMode, View view) {
            Intrinsics.e(this$0, "this$0");
            YYMedalInfoDialog yYMedalInfoDialog = new YYMedalInfoDialog();
            if (this$0.g() == null || this$0.h() == null) {
                return;
            }
            YYUserInfo g = this$0.g();
            Intrinsics.a(g);
            String bid = badgeMode == null ? null : badgeMode.getBid();
            BaseYYStudioFragment h = this$0.h();
            Intrinsics.a(h);
            YYMedalInfoDialog a = yYMedalInfoDialog.a(g, bid, h);
            BaseYYStudioFragment h2 = this$0.h();
            FragmentManager childFragmentManager = h2 == null ? null : h2.getChildFragmentManager();
            Intrinsics.a(childFragmentManager);
            Intrinsics.c(childFragmentManager, "fra?.childFragmentManager!!");
            a.show(childFragmentManager, "YYMedalInfoDialog");
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_PROFILE_MEDAL_ONE_CLICK;
            String str = b.room_id;
            String str2 = b.uid;
            YYUserInfo g2 = this$0.g();
            EventTrackYY.c(event, str, str2, g2 == null ? null : g2.getUid(), badgeMode == null ? null : badgeMode.getBid());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final BadgeMode badgeMode) {
            Intrinsics.a(baseViewHolder);
            ItemMedalListBinding a = ItemMedalListBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper!!.itemView)");
            if (badgeMode == null) {
                return;
            }
            final YYMedalListDialog yYMedalListDialog = this.a;
            BaseYYStudioFragment h = yYMedalListDialog.h();
            ImageLoader.a(h == null ? null : h.getFragmentActive(), badgeMode.getPic()).b(R.drawable.anchor_badge_default).d(R.drawable.anchor_badge_default).a(a.a);
            a.b.setText(badgeMode.getName());
            a.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMedalListDialog$Ad$qT7P9dwmz46QdJgB8zAeBf_kIcI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYMedalListDialog.Ad.a(YYMedalListDialog.this, badgeMode, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMedalListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYMedalListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void i() {
        ImageView imageView;
        FrameLayout frameLayout;
        YYUserInfo yYUserInfo = this.b;
        if (yYUserInfo != null) {
            BaseYYStudioFragment h = h();
            ImageWrapper c = ImageLoader.a(h == null ? null : h.getFragmentActive(), yYUserInfo.getAvatar()).c();
            DialogMedalListsBinding f = f();
            c.a(f == null ? null : f.c);
            DialogMedalListsBinding f2 = f();
            TextView textView = f2 == null ? null : f2.g;
            if (textView != null) {
                textView.setText(yYUserInfo.getName());
            }
            DialogMedalListsBinding f3 = f();
            TextView textView2 = f3 == null ? null : f3.e;
            if (textView2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(yYUserInfo.badge.size());
                sb.append((char) 26522);
                textView2.setText(sb.toString());
            }
            DialogMedalListsBinding f4 = f();
            RecyclerView recyclerView = f4 == null ? null : f4.d;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
            }
            RecyclerView.Adapter ad = new Ad(this);
            DialogMedalListsBinding f5 = f();
            RecyclerView recyclerView2 = f5 == null ? null : f5.d;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(ad);
            }
            ad.setNewData(yYUserInfo.badge);
        }
        DialogMedalListsBinding dialogMedalListsBinding = this.a;
        if (dialogMedalListsBinding != null && (frameLayout = dialogMedalListsBinding.a) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMedalListDialog$K3Xm2q8bCVBY3snkUByMe8US1gI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYMedalListDialog.a(YYMedalListDialog.this, view);
                }
            });
        }
        DialogMedalListsBinding dialogMedalListsBinding2 = this.a;
        if (dialogMedalListsBinding2 == null || (imageView = dialogMedalListsBinding2.b) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMedalListDialog$OT80RWvDk7ZktzHr841ZuHbLRAs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMedalListDialog.b(YYMedalListDialog.this, view);
            }
        });
    }

    public final YYMedalListDialog a(YYUserInfo info, BaseYYStudioFragment fra) {
        Intrinsics.e(info, "info");
        Intrinsics.e(fra, "fra");
        this.b = info;
        this.c = fra;
        return this;
    }

    public final DialogMedalListsBinding f() {
        return this.a;
    }

    public final YYUserInfo g() {
        return this.b;
    }

    public final BaseYYStudioFragment h() {
        return this.c;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = DialogMedalListsBinding.a(inflater.inflate(R.layout.dialog_medal_lists, viewGroup, true));
        i();
        DialogMedalListsBinding dialogMedalListsBinding = this.a;
        return dialogMedalListsBinding == null ? null : dialogMedalListsBinding.getRoot();
    }
}
