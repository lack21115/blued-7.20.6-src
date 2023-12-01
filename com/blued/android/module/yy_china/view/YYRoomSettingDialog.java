package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.ClickRoomBgListener;
import com.blued.android.module.yy_china.adapter.OnClickRoomTypeListener;
import com.blued.android.module.yy_china.adapter.SettingRoomBgAdapter;
import com.blued.android.module.yy_china.adapter.SettingRoomLabelAdapter;
import com.blued.android.module.yy_china.databinding.DialogYyRoomSettingBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYBeanClearAlertDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.BgCollectionMode;
import com.blued.android.module.yy_china.model.RoomSettingAnchorLevel;
import com.blued.android.module.yy_china.model.RoomSettingManagerMode;
import com.blued.android.module.yy_china.model.RoomSettingMode;
import com.blued.android.module.yy_china.model.RoomSettingRoomInfoMode;
import com.blued.android.module.yy_china.model.RoomSettingTopicModel;
import com.blued.android.module.yy_china.model.YYMsgNoAnchorModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYRoomSettingListDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRoomSettingDialog.class */
public final class YYRoomSettingDialog extends BaseFullScreenDialog implements ClickRoomBgListener, OnClickRoomTypeListener {
    private BaseYYStudioFragment a;
    private DialogYyRoomSettingBinding b;
    private SettingRoomLabelAdapter c;
    private SettingRoomBgAdapter d;
    private String e;

    public YYRoomSettingDialog(BaseYYStudioFragment fragment) {
        Intrinsics.e(fragment, "fragment");
        this.a = fragment;
        this.e = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        YYMsgNoAnchorModel yYMsgNoAnchorModel = new YYMsgNoAnchorModel();
        yYMsgNoAnchorModel.title = "麦位弯豆值";
        yYMsgNoAnchorModel.submit_title = "我知道了";
        yYMsgNoAnchorModel.content = "麦位弯豆值是指麦位上用户收礼弯豆值。 开启后，麦位下方会展示出来麦位弯豆值。";
        yYMsgNoAnchorModel.background = "";
        yYMsgNoAnchorModel.link = "";
        LiveEventBus.get("show_no_anchor_alert").post(yYMsgNoAnchorModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(RoomSettingMode roomSettingMode) {
        SettingRoomBgAdapter settingRoomBgAdapter;
        RoomSettingRoomInfoMode room_info = roomSettingMode.getRoom_info();
        if (room_info != null) {
            f().u.setText(room_info.hall_id);
            f().v.setText(room_info.room_name);
            f().w.setText(room_info.room_desc);
            TextView textView = f().t;
            RoomSettingRoomInfoMode.WelcomeDTO welcomeDTO = room_info.welcome;
            textView.setText(Intrinsics.a("欢迎", (Object) (welcomeDTO == null ? null : welcomeDTO.content)));
            SettingRoomLabelAdapter settingRoomLabelAdapter = this.c;
            if (settingRoomLabelAdapter != null) {
                settingRoomLabelAdapter.setNewData(roomSettingMode.theme);
            }
            SettingRoomLabelAdapter settingRoomLabelAdapter2 = this.c;
            if (settingRoomLabelAdapter2 != null) {
                settingRoomLabelAdapter2.a(roomSettingMode.theme.get(room_info.label_id - 1 < 0 ? 0 : room_info.label_id - 1));
            }
            SettingRoomBgAdapter settingRoomBgAdapter2 = this.d;
            if (settingRoomBgAdapter2 != null) {
                settingRoomBgAdapter2.a(roomSettingMode.anchor_level.level);
            }
            if (roomSettingMode.getBackground().size() > 0) {
                SettingRoomBgAdapter settingRoomBgAdapter3 = this.d;
                if (settingRoomBgAdapter3 != null) {
                    settingRoomBgAdapter3.setNewData(roomSettingMode.getBackground().get(0).getBg_collection());
                }
                ArrayList<BgCollectionMode> bg_collection = roomSettingMode.getBackground().get(0).getBg_collection();
                Intrinsics.c(bg_collection, "its.background[0].bg_collection");
                for (BgCollectionMode bgCollectionMode : bg_collection) {
                    if (TextUtils.equals(bgCollectionMode.getBg_id(), room_info.bg_id) && (settingRoomBgAdapter = this.d) != null) {
                        settingRoomBgAdapter.a(bgCollectionMode);
                    }
                }
            }
            if (room_info.mic_bean == 1) {
                f().o.setChecked(false);
                f().r.setVisibility(8);
            } else {
                f().r.setVisibility(0);
                f().o.setChecked(true);
            }
        }
        RoomSettingAnchorLevel roomSettingAnchorLevel = roomSettingMode.anchor_level;
        if (roomSettingAnchorLevel != null) {
            if (roomSettingAnchorLevel.level >= 11) {
                f().g.setVisibility(0);
            } else {
                f().g.setVisibility(8);
            }
        }
        f().p.setChecked(roomSettingMode.is_fans_notice != 0);
        ArrayList<RoomSettingManagerMode> manager = roomSettingMode.getManager();
        if (manager != null) {
            a(manager);
        }
        f().o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$CpAKwzpHFWbVCZ4DtcgZavRw4mM
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                YYRoomSettingDialog.a(YYRoomSettingDialog.this, compoundButton, z);
            }
        });
        f().p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$2bwdrcoLtJan7Fdz7XdD8ot6-V8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                YYRoomSettingDialog.b(YYRoomSettingDialog.this, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRoomSettingDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final YYRoomSettingDialog this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z) {
            final ActivityFragmentActive a = this$0.a();
            this$0.a("", "", "2", "", new BluedUIHttpResponse<BluedEntityA<RoomSettingMode>>(a) { // from class: com.blued.android.module.yy_china.view.YYRoomSettingDialog$initData$4$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<RoomSettingMode> p0) {
                    DialogYyRoomSettingBinding f;
                    Intrinsics.e(p0, "p0");
                    f = YYRoomSettingDialog.this.f();
                    f.r.setVisibility(0);
                }
            });
            return;
        }
        final ActivityFragmentActive a2 = this$0.a();
        this$0.a("", "", "1", "", new BluedUIHttpResponse<BluedEntityA<RoomSettingMode>>(a2) { // from class: com.blued.android.module.yy_china.view.YYRoomSettingDialog$initData$4$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RoomSettingMode> p0) {
                DialogYyRoomSettingBinding f;
                Intrinsics.e(p0, "p0");
                f = YYRoomSettingDialog.this.f();
                f.r.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRoomSettingDialog this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().v.setText(str);
    }

    private final void a(String str, String str2, String str3, String str4, BluedUIHttpResponse<BluedEntityA<RoomSettingMode>> bluedUIHttpResponse) {
        YYRoomHttpUtils.a(this.e, str, str2, str3, str4, (BluedUIHttpResponse) bluedUIHttpResponse, (IRequestHost) a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends RoomSettingManagerMode> list) {
        f().d.setVisibility(8);
        f().e.setVisibility(8);
        f().f.setVisibility(8);
        if (list.size() > 0) {
            f().d.setVisibility(0);
            ImageLoader.a(a(), list.get(0).getAvatar()).b(R.drawable.user_bg_round).c().a((ImageView) f().d);
        }
        if (list.size() > 1) {
            f().e.setVisibility(0);
            ImageLoader.a(a(), list.get(1).getAvatar()).b(R.drawable.user_bg_round).c().a((ImageView) f().e);
        }
        if (list.size() > 2) {
            f().f.setVisibility(0);
            ImageLoader.a(a(), list.get(2).getAvatar()).b(R.drawable.user_bg_round).c().a((ImageView) f().f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        YYMsgNoAnchorModel yYMsgNoAnchorModel = new YYMsgNoAnchorModel();
        yYMsgNoAnchorModel.title = "开播提醒";
        yYMsgNoAnchorModel.submit_title = "我知道了";
        yYMsgNoAnchorModel.content = "当主播等级升级至Lv.11时，可以解锁给粉丝发送开播提醒的特权，主播可选择是否开启，开启时粉丝会收到对应的开播提醒。";
        yYMsgNoAnchorModel.background = "";
        yYMsgNoAnchorModel.link = "";
        LiveEventBus.get("show_no_anchor_alert").post(yYMsgNoAnchorModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRoomSettingDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRoomSettingDialog this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z) {
            final ActivityFragmentActive a = this$0.a();
            this$0.a("", "", "", "1", new BluedUIHttpResponse<BluedEntityA<RoomSettingMode>>(a) { // from class: com.blued.android.module.yy_china.view.YYRoomSettingDialog$initData$5$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<RoomSettingMode> p0) {
                    Intrinsics.e(p0, "p0");
                }
            });
            return;
        }
        final ActivityFragmentActive a2 = this$0.a();
        this$0.a("", "", "", "0", new BluedUIHttpResponse<BluedEntityA<RoomSettingMode>>(a2) { // from class: com.blued.android.module.yy_china.view.YYRoomSettingDialog$initData$5$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RoomSettingMode> p0) {
                Intrinsics.e(p0, "p0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRoomSettingDialog this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().w.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYRoomSettingDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a.H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYRoomSettingDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        final ActivityFragmentActive a = this$0.a();
        this$0.a("", "", "3", "", new BluedUIHttpResponse<BluedEntityA<RoomSettingMode>>(a) { // from class: com.blued.android.module.yy_china.view.YYRoomSettingDialog$initView$4$dia$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RoomSettingMode> p0) {
                Intrinsics.e(p0, "p0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final YYRoomSettingDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYBeanClearAlertDialog yYBeanClearAlertDialog = new YYBeanClearAlertDialog(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$5ZpoSzOkzQKSyuiBHIG9AHdjB4U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYRoomSettingDialog.d(YYRoomSettingDialog.this, view2);
            }
        });
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYBeanClearAlertDialog.show(childFragmentManager, "YYBeanClearAlertDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogYyRoomSettingBinding f() {
        DialogYyRoomSettingBinding dialogYyRoomSettingBinding = this.b;
        Intrinsics.a(dialogYyRoomSettingBinding);
        return dialogYyRoomSettingBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final YYRoomSettingDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomSettingListDialog yYRoomSettingListDialog = new YYRoomSettingListDialog();
        yYRoomSettingListDialog.a(this$0.e);
        yYRoomSettingListDialog.a(new YYRoomSettingListDialog.OnChangeHostManagerListSizeListener() { // from class: com.blued.android.module.yy_china.view.YYRoomSettingDialog$initView$8$1
            @Override // com.blued.android.module.yy_china.view.YYRoomSettingListDialog.OnChangeHostManagerListSizeListener
            public void a(List<? extends RoomSettingManagerMode> dat) {
                Intrinsics.e(dat, "dat");
                YYRoomSettingDialog.this.a(dat);
            }
        });
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYRoomSettingListDialog.show(childFragmentManager, "YYRoomSettingListDialog");
    }

    private final void g() {
        String str = YYRoomInfoManager.e().b().room_id;
        Intrinsics.c(str, "getInstance().roomModel.room_id");
        this.e = str;
        f().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$ED5lMq9r90ke6f69n0nuov5RCwE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomSettingDialog.a(YYRoomSettingDialog.this, view);
            }
        });
        YYRoomSettingDialog yYRoomSettingDialog = this;
        this.c = new SettingRoomLabelAdapter(this, yYRoomSettingDialog);
        f().n.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        f().n.setAdapter(this.c);
        this.d = new SettingRoomBgAdapter(this, yYRoomSettingDialog, 0, 4, null);
        f().m.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        f().m.setAdapter(this.d);
        f().j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$sz46ZFr3XaZABSr8q3E1F0qilsY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomSettingDialog.b(YYRoomSettingDialog.this, view);
            }
        });
        f().k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$AuwLwdmI0kjiT1kxI2r2YIg7w2w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomSettingDialog.c(YYRoomSettingDialog.this, view);
            }
        });
        f().r.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$IuYZV5Am42qUOvfsRAyQuOcjanM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomSettingDialog.e(YYRoomSettingDialog.this, view);
            }
        });
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveEventBus.get("notify_room_rename", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$rD3JOIkhVd4ut9PdVGfEX-GRsME
            public final void onChanged(Object obj) {
                YYRoomSettingDialog.a(YYRoomSettingDialog.this, (String) obj);
            }
        });
        LiveEventBus.get("notify_room_renote", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$MNxLE7lzRmuePjd8bHGmg-FH3qY
            public final void onChanged(Object obj) {
                YYRoomSettingDialog.b(YYRoomSettingDialog.this, (String) obj);
            }
        });
        String str2 = this.e;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.c(str2, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<RoomSettingMode>>(a) { // from class: com.blued.android.module.yy_china.view.YYRoomSettingDialog$initView$7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RoomSettingMode> bluedEntityA) {
                RoomSettingMode singleData;
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYRoomSettingDialog.this.a(singleData);
            }
        }, (IRequestHost) a());
        f().l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$eILUR3eFjcjQC_wqyZB8slNq_SY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomSettingDialog.f(YYRoomSettingDialog.this, view);
            }
        });
        f().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$xd06pwPe05N9Gjui808HFhlQdZk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomSettingDialog.a(view);
            }
        });
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingDialog$somUMm0z_Uu3qnTIez80VV2w2rQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomSettingDialog.b(view);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.adapter.ClickRoomBgListener
    public void a(BgCollectionMode item, final View.OnClickListener clic) {
        Intrinsics.e(item, "item");
        Intrinsics.e(clic, "clic");
        String bg_id = item.getBg_id();
        final ActivityFragmentActive a = a();
        a("", bg_id, "", "", new BluedUIHttpResponse<BluedEntityA<RoomSettingMode>>(a) { // from class: com.blued.android.module.yy_china.view.YYRoomSettingDialog$clickBg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(a);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RoomSettingMode> p0) {
                Intrinsics.e(p0, "p0");
                View.OnClickListener.this.onClick(null);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.adapter.OnClickRoomTypeListener
    public void a(RoomSettingTopicModel item, String str, final View.OnClickListener clic) {
        Intrinsics.e(item, "item");
        Intrinsics.e(clic, "clic");
        String label_id = item.getLabel_id();
        Intrinsics.c(label_id, "item.label_id");
        final ActivityFragmentActive a = a();
        a(label_id, "", "", "", new BluedUIHttpResponse<BluedEntityA<RoomSettingMode>>(a) { // from class: com.blued.android.module.yy_china.view.YYRoomSettingDialog$clickType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(a);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RoomSettingMode> bluedEntityA) {
                View.OnClickListener.this.onClick(null);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_SETTINGS_PAGE_SHOW, b.room_id, b.uid);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_yy_room_setting, viewGroup, true);
        this.b = DialogYyRoomSettingBinding.a(inflate);
        g();
        return inflate;
    }
}
