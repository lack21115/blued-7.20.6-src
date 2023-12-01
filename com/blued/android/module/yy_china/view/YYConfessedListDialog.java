package com.blued.android.module.yy_china.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogConfessedTopBinding;
import com.blued.android.module.yy_china.databinding.ItemConfessedMessBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ConfessedIMMode;
import com.blued.android.module.yy_china.model.ConfessedListDataMode;
import com.blued.android.module.yy_china.model.ConfessedListMode;
import com.blued.android.module.yy_china.model.ConfessedMode;
import com.blued.android.module.yy_china.model.ConfessedUserMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYConfessedListDialog.class */
public final class YYConfessedListDialog extends BaseFullScreenDialog {
    private DialogConfessedTopBinding a;
    private final ConfessedAdapter b = new ConfessedAdapter(this);
    private String c = "";
    private String d = "";
    private String e = "";
    private final ConfessedHandler f = new ConfessedHandler(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYConfessedListDialog$ConfessedAdapter.class */
    public final class ConfessedAdapter extends BaseMultiItemQuickAdapter<ConfessedListMode, BaseViewHolder> {
        final /* synthetic */ YYConfessedListDialog a;
        private TextView b;
        private long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfessedAdapter(YYConfessedListDialog this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            addItemType(0, R.layout.item_confessed_top);
            addItemType(1, R.layout.item_confessed_item);
            addItemType(2, R.layout.item_confessed_mess);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(ConfessedAdapter this$0, ConfessedListMode item, View view) {
            ConfessedUserMode confession_user;
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            ConfessedMode data = item.getData();
            Integer num = null;
            if (data != null && (confession_user = data.getConfession_user()) != null) {
                num = Integer.valueOf(confession_user.getRoom_id());
            }
            this$0.a(String.valueOf(num));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ConfessedAdapter this$0, ConfessedListMode item, View view) {
            ConfessedUserMode being_confession_user_to;
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            ConfessedMode data = item.getData();
            Integer num = null;
            if (data != null && (being_confession_user_to = data.getBeing_confession_user_to()) != null) {
                num = Integer.valueOf(being_confession_user_to.getRoom_id());
            }
            this$0.a(String.valueOf(num));
        }

        private final void b(BaseViewHolder baseViewHolder, ConfessedListMode confessedListMode) {
            ItemConfessedMessBinding a = ItemConfessedMessBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            a.a.setText(this.a.g());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ConfessedAdapter this$0, ConfessedListMode item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            this$0.a(String.valueOf(item.getData().getConfession_user().getRoom_id()));
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0072, code lost:
            if (r0 == null) goto L6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void c(com.chad.library.adapter.base.BaseViewHolder r7, final com.blued.android.module.yy_china.model.ConfessedListMode r8) {
            /*
                Method dump skipped, instructions count: 500
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.view.YYConfessedListDialog.ConfessedAdapter.c(com.chad.library.adapter.base.BaseViewHolder, com.blued.android.module.yy_china.model.ConfessedListMode):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ConfessedAdapter this$0, ConfessedListMode item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            this$0.a(String.valueOf(item.getData().getBeing_confession_user_to().getRoom_id()));
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x00c5, code lost:
            if (r0 == null) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void d(com.chad.library.adapter.base.BaseViewHolder r7, final com.blued.android.module.yy_china.model.ConfessedListMode r8) {
            /*
                Method dump skipped, instructions count: 537
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.view.YYConfessedListDialog.ConfessedAdapter.d(com.chad.library.adapter.base.BaseViewHolder, com.blued.android.module.yy_china.model.ConfessedListMode):void");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder helper, ConfessedListMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            int itemType = item.getItemType();
            if (itemType == 0) {
                d(helper, item);
            } else if (itemType == 1) {
                c(helper, item);
            } else if (itemType != 2) {
            } else {
                b(helper, item);
            }
        }

        public final void a(String roomId) {
            Intrinsics.e(roomId, "roomId");
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (StringUtils.a(b == null ? null : b.room_id, roomId)) {
                return;
            }
            YYRoomInfoManager e = YYRoomInfoManager.e();
            FragmentActivity activity = this.a.getActivity();
            if (activity == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.ui.BaseFragmentActivity");
            }
            e.a((BaseFragmentActivity) activity, roomId, "");
        }

        public final boolean a() {
            long currentTimeMillis = this.c - (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= 0) {
                TextView textView = this.b;
                if (textView == null) {
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(currentTimeMillis);
                sb.append('s');
                textView.setText(sb.toString());
                return true;
            }
            return false;
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYConfessedListDialog$ConfessedHandler.class */
    public static final class ConfessedHandler extends Handler {
        private final WeakReference<YYConfessedListDialog> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfessedHandler(YYConfessedListDialog yyPackGiftDialog) {
            super(Looper.getMainLooper());
            Intrinsics.e(yyPackGiftDialog, "yyPackGiftDialog");
            this.a = new WeakReference<>(yyPackGiftDialog);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            WeakReference<YYConfessedListDialog> weakReference;
            YYConfessedListDialog yYConfessedListDialog;
            Intrinsics.e(msg, "msg");
            super.handleMessage(msg);
            if (msg.what != 1 || (weakReference = this.a) == null || (yYConfessedListDialog = weakReference.get()) == null) {
                return;
            }
            yYConfessedListDialog.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        LiveEventBus.get("show_inner_dialog").post(YYRoomInfoManager.e().c().a(19));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYConfessedListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYConfessedRankListDialog yYConfessedRankListDialog = new YYConfessedRankListDialog();
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYConfessedRankListDialog.show(childFragmentManager, "YYConfessedRankListDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYConfessedListDialog this$0, ConfessedIMMode confessedIMMode) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYConfessedListDialog this$0, ConfessedListDataMode data, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(data, "$data");
        ConfessedUserMode confession_user = data.getMy_confession_info().getConfession_user();
        this$0.b((confession_user == null ? null : Integer.valueOf(confession_user.getRoom_id())).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        ConfessedHandler confessedHandler = this.f;
        if (confessedHandler != null) {
            confessedHandler.removeMessages(1);
        }
        ConfessedAdapter confessedAdapter = this.b;
        if ((confessedAdapter == null ? null : Boolean.valueOf(confessedAdapter.a())).booleanValue()) {
            this.f.sendEmptyMessageDelayed(1, 1000L);
        } else if (z) {
        } else {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYConfessedListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYConfessedListDialog this$0, ConfessedListDataMode data, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(data, "$data");
        ConfessedUserMode being_confession_user_to = data.getMy_confession_info().getBeing_confession_user_to();
        this$0.b((being_confession_user_to == null ? null : Integer.valueOf(being_confession_user_to.getRoom_id())).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYConfessedListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYConfessedListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogConfessedTopBinding i() {
        DialogConfessedTopBinding dialogConfessedTopBinding = this.a;
        Intrinsics.a(dialogConfessedTopBinding);
        return dialogConfessedTopBinding;
    }

    private final void j() {
        ImageLoader.a(a(), ImgURLMap.a.a("yy_confessed_list_url_bg")).a(i().h);
        ImageLoader.a(a(), ImgURLMap.a.a("yy_confessed_list_url_btn_data_null")).a(i().i);
        ImageLoader.a(a(), ImgURLMap.a.a("yy_confessed_list_url_btn_big_bg")).a((Target) new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YYConfessedListDialog$initView$1
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                DialogConfessedTopBinding i;
                Intrinsics.e(resource, "resource");
                i = YYConfessedListDialog.this.i();
                i.d.setBackground(resource);
            }
        });
        ImageLoader.a(a(), ImgURLMap.a.a("yy_confessed_list_url_btn_big_smal")).a((Target) new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YYConfessedListDialog$initView$2
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                DialogConfessedTopBinding i;
                Intrinsics.e(resource, "resource");
                i = YYConfessedListDialog.this.i();
                i.e.setBackground(resource);
            }
        });
        ImageLoader.a(a(), ImgURLMap.a.a("yy_confessed_list_url_btn_big_null")).a((Target) new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YYConfessedListDialog$initView$3
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                DialogConfessedTopBinding i;
                Intrinsics.e(resource, "resource");
                i = YYConfessedListDialog.this.i();
                i.f.setBackground(resource);
            }
        });
        i().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedListDialog$qVKPWaWzMQ0c9uYrPsliAgNG2Mo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedListDialog.a(view);
            }
        });
        i().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedListDialog$Ag7m6hAOL6VW8Fn1eU9zyskO788
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedListDialog.a(YYConfessedListDialog.this, view);
            }
        });
        i().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedListDialog$sIoyBQjPuSZqIHXACBI4kphQyXE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedListDialog.b(YYConfessedListDialog.this, view);
            }
        });
        i().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedListDialog$Gq8ZSHmUP5MCesboM7f46M8wHUc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedListDialog.c(YYConfessedListDialog.this, view);
            }
        });
        i().f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedListDialog$M6k-y-vAUjyr0UuaK_XwKGaUXsw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedListDialog.d(YYConfessedListDialog.this, view);
            }
        });
        LiveEventBus.get("notify_confessed", ConfessedIMMode.class).observe((LifecycleOwner) this, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedListDialog$ZxBplXsZExaNdzcrPUW1--QgsUw
            public final void onChanged(Object obj) {
                YYConfessedListDialog.a(YYConfessedListDialog.this, (ConfessedIMMode) obj);
            }
        });
        i().q.setLayoutManager(new LinearLayoutManager(getContext()));
        i().q.setAdapter(this.b);
        l();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.m(ChatRoomProtos.Event.YY_SHOW_LOVE_TOP_PAGE_SHOW, b.room_id, b.uid, f());
    }

    private final void k() {
        YyConfessedGiftDialog yyConfessedGiftDialog = new YyConfessedGiftDialog();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yyConfessedGiftDialog.show(childFragmentManager, "YyConfessedGiftDialog");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_SHOW_LOVE_TOP_PAGE_TO_CLICK, b.room_id, b.uid);
    }

    private final void l() {
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.j(new BluedUIHttpResponse<BluedEntityA<ConfessedListDataMode>>(a) { // from class: com.blued.android.module.yy_china.view.YYConfessedListDialog$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ConfessedListDataMode> bluedEntityA) {
                ConfessedListDataMode singleData;
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYConfessedListDialog.this.a(singleData);
            }
        }, a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x01d0, code lost:
        if (r0 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0204, code lost:
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x025f, code lost:
        if (r0 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0293, code lost:
        if (r0 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x02dd, code lost:
        if (r0 == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final com.blued.android.module.yy_china.model.ConfessedListDataMode r7) {
        /*
            Method dump skipped, instructions count: 1115
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.view.YYConfessedListDialog.a(com.blued.android.module.yy_china.model.ConfessedListDataMode):void");
    }

    public final void a(ConfessedMode myConfessionInfo, ImageView ivUser1Tag, ImageView ivUser2Tag) {
        Intrinsics.e(myConfessionInfo, "myConfessionInfo");
        Intrinsics.e(ivUser1Tag, "ivUser1Tag");
        Intrinsics.e(ivUser2Tag, "ivUser2Tag");
        ivUser1Tag.setImageResource(R.color.transparent);
        ivUser2Tag.setImageResource(R.color.transparent);
        ConfessedUserMode confession_user = myConfessionInfo.getConfession_user();
        if (confession_user != null) {
            if (StringUtils.a(YYRoomInfoManager.e().k(), confession_user.getUid())) {
                ivUser1Tag.setImageResource(R.drawable.icon_yy_confessed_sely_tag);
            } else {
                ivUser1Tag.setImageResource(R.drawable.icon_yy_confessed_tag);
            }
        }
        ConfessedUserMode being_confession_user_to = myConfessionInfo.getBeing_confession_user_to();
        if (being_confession_user_to == null) {
            return;
        }
        if (StringUtils.a(YYRoomInfoManager.e().k(), being_confession_user_to.getUid())) {
            ivUser2Tag.setImageResource(R.drawable.icon_yy_confessed_sely_tag);
        } else {
            ivUser2Tag.setImageResource(R.drawable.icon_yy_be_confessed_tag);
        }
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.c = str;
    }

    public final void b(String roomId) {
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

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public boolean d() {
        return true;
    }

    public final String f() {
        return this.c;
    }

    public final String g() {
        return this.d;
    }

    public final String h() {
        return this.e;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_confessed_top, (ViewGroup) null);
        this.a = DialogConfessedTopBinding.a(inflate);
        j();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        this.f.removeCallbacksAndMessages(null);
    }
}
