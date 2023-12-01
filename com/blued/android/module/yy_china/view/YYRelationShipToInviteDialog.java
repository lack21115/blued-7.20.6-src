package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.anythink.core.api.ATAdConst;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogRelationshipToInviteBinding;
import com.blued.android.module.yy_china.databinding.ItemRelationshipToInviteDayBinding;
import com.blued.android.module.yy_china.databinding.ItemRelationshipToInviteGiftBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomToInvitedDayMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomToInvitedGiftMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUser;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYRelationShipToInviteDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationShipToInviteDialog.class */
public final class YYRelationShipToInviteDialog extends BaseFullScreenDialog {
    private DialogRelationshipToInviteBinding a;
    private final RelationInvitedDayAdapter b = new RelationInvitedDayAdapter(this);
    private final RelationInvitedGiftAdapter c = new RelationInvitedGiftAdapter(this);
    private String d;
    private Long e;
    private String f;
    private YYRelationShipRoomMode g;
    private YYRelationShipRoomUser h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationShipToInviteDialog$RelationInvitedDayAdapter.class */
    public final class RelationInvitedDayAdapter extends BaseMultiItemQuickAdapter<YYRelationShipRoomToInvitedDayMode, BaseViewHolder> {
        final /* synthetic */ YYRelationShipToInviteDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RelationInvitedDayAdapter(YYRelationShipToInviteDialog this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            addItemType(0, R.layout.item_relationship_to_invite_day);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYRelationShipToInviteDialog this$0, YYRelationShipRoomToInvitedDayMode item, RelationInvitedDayAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            this$0.f = item.getDay();
            this$1.notifyDataSetChanged();
        }

        private final void b(BaseViewHolder baseViewHolder, final YYRelationShipRoomToInvitedDayMode yYRelationShipRoomToInvitedDayMode) {
            ItemRelationshipToInviteDayBinding a = ItemRelationshipToInviteDayBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            a.a.setText(yYRelationShipRoomToInvitedDayMode.getDay());
            ShapeModel shapeModel = a.a.getShapeModel();
            if (StringUtils.a(this.a.f, yYRelationShipRoomToInvitedDayMode.getDay())) {
                shapeModel.b = this.a.getResources().getColor(R.color.syc_1AB6D0);
                shapeModel.k = this.a.getResources().getColor(R.color.syc_210BCEBB);
            } else {
                shapeModel.b = this.a.getResources().getColor(R.color.syc_dark_777777);
                shapeModel.k = this.a.getResources().getColor(R.color.syc_F8F8F8);
            }
            a.a.setShapeModel(shapeModel);
            ShapeTextView shapeTextView = a.a;
            final YYRelationShipToInviteDialog yYRelationShipToInviteDialog = this.a;
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipToInviteDialog$RelationInvitedDayAdapter$l5Ovidf5j8YFvT3Hb9CEbdJnGVU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipToInviteDialog.RelationInvitedDayAdapter.a(YYRelationShipToInviteDialog.this, yYRelationShipRoomToInvitedDayMode, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YYRelationShipRoomToInvitedDayMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            if (item.getItemType() == 0) {
                b(helper, item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationShipToInviteDialog$RelationInvitedGiftAdapter.class */
    public final class RelationInvitedGiftAdapter extends BaseMultiItemQuickAdapter<YYRelationShipRoomToInvitedGiftMode, BaseViewHolder> {
        final /* synthetic */ YYRelationShipToInviteDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RelationInvitedGiftAdapter(YYRelationShipToInviteDialog this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            addItemType(0, R.layout.item_relationship_to_invite_gift);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYRelationShipToInviteDialog this$0, YYRelationShipRoomToInvitedGiftMode item, RelationInvitedGiftAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            YYGiftModel mode = item.getMode();
            this$0.d = mode == null ? null : mode.goods_id;
            YYGiftModel mode2 = item.getMode();
            this$0.e = mode2 == null ? null : Long.valueOf(mode2.beans);
            this$1.notifyDataSetChanged();
        }

        private final void b(BaseViewHolder baseViewHolder, final YYRelationShipRoomToInvitedGiftMode yYRelationShipRoomToInvitedGiftMode) {
            YYGiftModel mode;
            String str;
            ItemRelationshipToInviteGiftBinding a = ItemRelationshipToInviteGiftBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            String str2 = this.a.d;
            String str3 = "";
            if (yYRelationShipRoomToInvitedGiftMode != null && (mode = yYRelationShipRoomToInvitedGiftMode.getMode()) != null && (str = mode.goods_id) != null) {
                str3 = str;
            }
            if (StringUtils.a(str2, str3)) {
                a.b.setBackgroundResource(R.drawable.shape_relation_gift_select);
            } else {
                a.b.setBackgroundResource(R.drawable.shape_relation_gift_un_select);
            }
            ActivityFragmentActive a2 = this.a.a();
            YYGiftModel mode2 = yYRelationShipRoomToInvitedGiftMode.getMode();
            ImageLoader.a(a2, mode2 == null ? null : mode2.images_static).a(a.a);
            a.c.setText(String.valueOf(yYRelationShipRoomToInvitedGiftMode.getMode().beans));
            a.d.setText(yYRelationShipRoomToInvitedGiftMode.getMode().name);
            LinearLayout linearLayout = a.b;
            final YYRelationShipToInviteDialog yYRelationShipToInviteDialog = this.a;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipToInviteDialog$RelationInvitedGiftAdapter$Xk-bRz44C9QlsX7nIlEIGEA11xQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipToInviteDialog.RelationInvitedGiftAdapter.a(YYRelationShipToInviteDialog.this, yYRelationShipRoomToInvitedGiftMode, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YYRelationShipRoomToInvitedGiftMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            if (item.getItemType() == 0) {
                b(helper, item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRelationShipToInviteDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRelationShipToInviteDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final YYRelationShipToInviteDialog this$0, View view) {
        String str;
        Intrinsics.e(this$0, "this$0");
        if (StringUtils.b(this$0.d) || StringUtils.b(this$0.f)) {
            return;
        }
        YYRelationShipRoomUser yYRelationShipRoomUser = this$0.h;
        String uid = yYRelationShipRoomUser == null ? null : yYRelationShipRoomUser.getUid();
        YYRelationShipRoomMode yYRelationShipRoomMode = this$0.g;
        String id = yYRelationShipRoomMode == null ? null : yYRelationShipRoomMode.getId();
        String str2 = this$0.f;
        String str3 = this$0.d;
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str4 = "";
        if (b != null && (str = b.room_id) != null) {
            str4 = str;
        }
        final ActivityFragmentActive a = this$0.a();
        YYRoomHttpUtils.b(uid, id, str2, str3, str4, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(a) { // from class: com.blued.android.module.yy_china.view.YYRelationShipToInviteDialog$initView$5$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                ToastUtils.a("邀请已发出，等待对方确认");
                YYRelationShipToInviteDialog.this.dismissAllowingStateLoss();
            }
        }, (IRequestHost) this$0.a());
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        if (b2 == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_RELATION_USER_INVITE_YES_CLICK;
        String str5 = b2.room_id;
        String str6 = b2.uid;
        YYRelationShipRoomMode f = this$0.f();
        String id2 = f == null ? null : f.getId();
        YYRelationShipRoomUser g = this$0.g();
        String uid2 = g == null ? null : g.getUid();
        String str7 = this$0.f;
        int parseInt = str7 == null ? 0 : Integer.parseInt(str7);
        String str8 = this$0.d;
        Long l = this$0.e;
        EventTrackYY.a(event, str5, str6, id2, uid2, parseInt, str8, l == null ? 0 : (int) l.longValue());
    }

    private final DialogRelationshipToInviteBinding h() {
        DialogRelationshipToInviteBinding dialogRelationshipToInviteBinding = this.a;
        Intrinsics.a(dialogRelationshipToInviteBinding);
        return dialogRelationshipToInviteBinding;
    }

    private final void i() {
        h().h.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        h().h.setAdapter(this.b);
        h().i.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        h().i.setAdapter(this.c);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new YYRelationShipRoomToInvitedDayMode(ATAdConst.ATDevFrameworkType.ADOBIE_AIR));
        arrayList.add(new YYRelationShipRoomToInvitedDayMode("30"));
        arrayList.add(new YYRelationShipRoomToInvitedDayMode("99"));
        this.f = ATAdConst.ATDevFrameworkType.ADOBIE_AIR;
        this.b.setNewData(arrayList);
        String str = YYRoomInfoManager.e().b().room_id;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.B(str, new BluedUIHttpResponse<BluedEntity<YYGiftModel, BluedEntityBaseExtra>>(a) { // from class: com.blued.android.module.yy_china.view.YYRelationShipToInviteDialog$initView$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYGiftModel, BluedEntityBaseExtra> bluedEntity) {
                YYRelationShipToInviteDialog.RelationInvitedGiftAdapter relationInvitedGiftAdapter;
                List<YYGiftModel> list;
                ArrayList arrayList2 = new ArrayList();
                if (bluedEntity != null && (list = bluedEntity.data) != null) {
                    List<YYGiftModel> list2 = list;
                    YYRelationShipToInviteDialog yYRelationShipToInviteDialog = YYRelationShipToInviteDialog.this;
                    for (YYGiftModel it : list2) {
                        if (StringUtils.b(yYRelationShipToInviteDialog.d)) {
                            yYRelationShipToInviteDialog.d = it.goods_id;
                            yYRelationShipToInviteDialog.e = Long.valueOf(it.beans);
                        }
                        Intrinsics.c(it, "it");
                        arrayList2.add(new YYRelationShipRoomToInvitedGiftMode(it));
                    }
                }
                relationInvitedGiftAdapter = YYRelationShipToInviteDialog.this.c;
                relationInvitedGiftAdapter.setNewData(arrayList2);
            }
        }, a());
        h().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipToInviteDialog$6pV126FIQvycpKIA2beX8eN3KC4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipToInviteDialog.a(YYRelationShipToInviteDialog.this, view);
            }
        });
        h().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipToInviteDialog$HQNxpAJJJGxoby168I9ccBZG0i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipToInviteDialog.b(YYRelationShipToInviteDialog.this, view);
            }
        });
        h().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipToInviteDialog$R876V98EKEMZ-0pjLGpCra69jes
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipToInviteDialog.a(view);
            }
        });
        h().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipToInviteDialog$eo4WyIeXW-v06cHHUg1upyoR6E0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipToInviteDialog.c(YYRelationShipToInviteDialog.this, view);
            }
        });
        TextView textView = h().j;
        StringBuilder sb = new StringBuilder();
        sb.append("成为他的「");
        YYRelationShipRoomMode yYRelationShipRoomMode = this.g;
        String str2 = null;
        sb.append((Object) (yYRelationShipRoomMode == null ? null : yYRelationShipRoomMode.getRelation_name()));
        sb.append((char) 12301);
        textView.setText(sb.toString());
        h().k.setText("对方同意邀请后，即可获得该礼物");
        YYRoomInfoManager.e().a(a(), (ImageView) h().f, YYRoomInfoManager.e().k(), YYRoomInfoManager.e().m());
        YYRoomInfoManager e = YYRoomInfoManager.e();
        ActivityFragmentActive a2 = a();
        ImageView imageView = (ImageView) h().g;
        YYRelationShipRoomUser yYRelationShipRoomUser = this.h;
        String uid = yYRelationShipRoomUser == null ? null : yYRelationShipRoomUser.getUid();
        YYRelationShipRoomUser yYRelationShipRoomUser2 = this.h;
        if (yYRelationShipRoomUser2 != null) {
            str2 = yYRelationShipRoomUser2.getAvatar();
        }
        e.a(a2, imageView, uid, str2);
    }

    public final void a(YYRelationShipRoomMode yYRelationShipRoomMode) {
        this.g = yYRelationShipRoomMode;
    }

    public final void a(YYRelationShipRoomUser yYRelationShipRoomUser) {
        this.h = yYRelationShipRoomUser;
    }

    public final YYRelationShipRoomMode f() {
        return this.g;
    }

    public final YYRelationShipRoomUser g() {
        return this.h;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = DialogRelationshipToInviteBinding.a(inflater.inflate(R.layout.dialog_relationship_to_invite, viewGroup, true));
        i();
        return h().getRoot();
    }
}
