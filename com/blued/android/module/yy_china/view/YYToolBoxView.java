package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.core.api.ATAdConst;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.urlroute.BluedUrlUtils;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemToolBoxBinding;
import com.blued.android.module.yy_china.dialog.YYRomanticTripDialog;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYCreateComingEventsDialog;
import com.blued.android.module.yy_china.fragment.YYDailyTaskFragment;
import com.blued.android.module.yy_china.fragment.YYDecorateCarDialog;
import com.blued.android.module.yy_china.fragment.YYPackGiftDialog;
import com.blued.android.module.yy_china.fragment.YYRedPackageDialog;
import com.blued.android.module.yy_china.fragment.YYRoomPKFragment;
import com.blued.android.module.yy_china.fragment.YYRoomPKFragmentNew;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ToolMode;
import com.blued.android.module.yy_china.model.ToolkitMode;
import com.blued.android.module.yy_china.model.YYExtoolBoxModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYToolBoxView.class */
public class YYToolBoxView extends LinearLayout {
    private RecyclerView a;
    private RecyclerView b;
    private TextView c;
    private TextView d;
    private BaseYYStudioFragment e;
    private ToolKitBoxAdapter f;
    private ToolKitBoxAdapter g;
    private YYRoomModel h;
    private OnItemCLickListener i;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYToolBoxView$OnItemCLickListener.class */
    public interface OnItemCLickListener {
        void onItemClick(ToolMode toolMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYToolBoxView$ToolKitBoxAdapter.class */
    public class ToolKitBoxAdapter extends BaseQuickAdapter<ToolMode, BaseViewHolder> {
        public ToolKitBoxAdapter(boolean z) {
            super(z ? R.layout.item_tool_box_top : R.layout.item_tool_box);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final ToolMode toolMode) {
            ItemToolBoxBinding a = ItemToolBoxBinding.a(baseViewHolder.itemView);
            a.a.setVisibility(8);
            if (toolMode.getNa() <= 0) {
                a.c.setText(toolMode.getName());
                ImageLoader.a(YYToolBoxView.this.e.getFragmentActive(), toolMode.getIcon()).a(a.b);
            } else {
                a.c.setText(toolMode.getNa());
                a.b.setImageResource(toolMode.getImg());
            }
            if (toolMode.isRed()) {
                a.a.setVisibility(0);
            }
            if (TextUtils.equals("10", toolMode.getType()) && YYToolBoxView.this.h != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_BG_MUSIC_ENTRANCE_SHOW, YYToolBoxView.this.h.room_id, YYToolBoxView.this.h.uid);
            }
            if (TextUtils.equals("18", toolMode.getType()) && YYToolBoxView.this.h != null) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_ROOM_BOX_REDBAG_SHOW, YYToolBoxView.this.h.room_id, YYToolBoxView.this.h.uid);
            }
            if (TextUtils.equals("21", toolMode.getType()) && YYToolBoxView.this.h != null) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_BOX_RELATION_SHOW, YYToolBoxView.this.h.room_id, YYToolBoxView.this.h.uid);
            }
            if (TextUtils.equals("24", toolMode.getType()) && YYToolBoxView.this.h != null) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_ROOM_BOX_SET_GIFT_SHOW, YYToolBoxView.this.h.room_id, YYToolBoxView.this.h.uid);
            }
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYToolBoxView.ToolKitBoxAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (ClickUtils.a(view.getId())) {
                        return;
                    }
                    YYToolBoxView.this.b(toolMode);
                    String type = toolMode.getType();
                    if (TextUtils.equals("1", type)) {
                        YYToolBoxView.this.m();
                    } else if (TextUtils.equals("2", type)) {
                        YYToolBoxView.this.n();
                    } else if (TextUtils.equals("3", type)) {
                        YYToolBoxView.this.o();
                    } else if (TextUtils.equals("4", type)) {
                        YYToolBoxView.this.c();
                    } else if (TextUtils.equals("5", type)) {
                        YYToolBoxView.this.g();
                    } else if (TextUtils.equals(ATAdConst.ATDevFrameworkType.FLUTTER, type)) {
                        YYToolBoxView.this.h();
                    } else if (TextUtils.equals(ATAdConst.ATDevFrameworkType.ADOBIE_AIR, type)) {
                        YYToolBoxView.this.i();
                    } else if (TextUtils.equals("8", type)) {
                        YYToolBoxView.this.p();
                    } else if (TextUtils.equals("9", type)) {
                        YYToolBoxView.this.q();
                    } else if (TextUtils.equals("10", type)) {
                        YYToolBoxView.this.r();
                    } else if (TextUtils.equals("11", type)) {
                        YYToolBoxView.this.s();
                    } else if (TextUtils.equals(type, "12")) {
                        YYToolBoxView.this.t();
                    } else if (TextUtils.equals(type, "14")) {
                        YYToolBoxView.this.c(toolMode);
                    } else if (TextUtils.equals(type, "15")) {
                        YYToolBoxView.this.u();
                    } else if (TextUtils.equals(type, "16")) {
                        YYToolBoxView.this.v();
                    } else if (TextUtils.equals(type, "17")) {
                        YYToolBoxView.this.w();
                    } else if (TextUtils.equals(type, "18")) {
                        YYToolBoxView.this.x();
                    } else if (TextUtils.equals(type, "20")) {
                        YYToolBoxView.this.y();
                    } else if (TextUtils.equals(type, "21")) {
                        YYToolBoxView.this.l();
                    } else if (TextUtils.equals(type, "22")) {
                        YYToolBoxView.this.z();
                    } else if (TextUtils.equals(type, "23")) {
                        YYToolBoxView.this.A();
                    } else if (TextUtils.equals(type, "24")) {
                        YYToolBoxView.this.B();
                    } else if (TextUtils.equals(type, "25")) {
                        YYToolBoxView.this.k();
                    } else {
                        YYToolBoxView.this.d(toolMode);
                    }
                    if (YYToolBoxView.this.i != null) {
                        YYToolBoxView.this.i.onItemClick(toolMode);
                    }
                }
            });
        }
    }

    public YYToolBoxView(Context context) {
        super(context);
        a();
    }

    public YYToolBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYToolBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        new YYRomanticTripDialog().show(this.e.getParentFragmentManager(), "dialog_romantic_trip");
        this.e.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        new YYPackGiftDialog().show(this.e.getParentFragmentManager(), "YYPackGiftDialog");
        if (YYRoomInfoManager.e().b() != null) {
            YYRoomModel b = YYRoomInfoManager.e().b();
            EventTrackYY.d(ChatRoomProtos.Event.YY_ROOM_BOX_SET_GIFT_CLICK, b.room_id, b.uid);
        }
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_toolbox, (ViewGroup) this, true);
        this.c = (TextView) findViewById(R.id.tv_tools_activities);
        this.d = (TextView) findViewById(R.id.tv_tools_basic);
        b();
        e();
    }

    private void a(String str) {
        ImageFileLoader.a(this.e.getFragmentActive()).b(str).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.yy_china.view.YYToolBoxView.1
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                YYRoomInfoManager.e().c().a(YYToolBoxView.this.e, YYRoomInfoManager.e().b(), (file == null || !file.exists()) ? null : BitmapFactory.decodeFile(file.getPath()), "");
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ToolMode toolMode) {
        if (toolMode.getRed_dot() > 0) {
            SharedPreferences b = SharedPreferencesUtils.b();
            StringBuilder sb = new StringBuilder();
            sb.append("TOOL_BOX_ITEM_RED");
            sb.append(toolMode.getName());
            sb.append(toolMode.getType());
            sb.append(YYRoomInfoManager.e().k());
            return b.getInt(sb.toString(), 0) <= 0;
        }
        return false;
    }

    private void b() {
        this.a = findViewById(R.id.rv_activities_list);
        this.a.setLayoutManager(new GridLayoutManager(getContext(), 5));
        ToolKitBoxAdapter toolKitBoxAdapter = new ToolKitBoxAdapter(true);
        this.f = toolKitBoxAdapter;
        this.a.setAdapter(toolKitBoxAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ToolMode toolMode) {
        if (toolMode == null || !toolMode.isRed()) {
            return;
        }
        toolMode.setRed(false);
        SharedPreferences.Editor edit = SharedPreferencesUtils.b().edit();
        edit.putInt("TOOL_BOX_ITEM_RED" + toolMode.getName() + toolMode.getType() + YYRoomInfoManager.e().k(), 1).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.e == null) {
            return;
        }
        YYEmojiView yYEmojiView = new YYEmojiView(getContext());
        yYEmojiView.a(this.e);
        this.e.a(yYEmojiView, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ToolMode toolMode) {
        this.e.y();
        if (toolMode == null) {
            return;
        }
        String target_url = toolMode.getTarget_url();
        if (TextUtils.isEmpty(target_url)) {
            return;
        }
        Uri.Builder buildUpon = Uri.parse(target_url).buildUpon();
        buildUpon.clearQuery();
        buildUpon.appendQueryParameter("room_id", this.h.room_id);
        buildUpon.appendQueryParameter("uid", EncryptTool.b(YYRoomInfoManager.e().k()));
        String builder = buildUpon.toString();
        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_COOL_STAGE_CLICK, this.h.room_id, this.h.uid);
        YYRoomInfoManager.e().c().a(getContext(), builder, 9, true);
    }

    private void d() {
        YYRoomPKFragment.a.a().show(this.e.getFragmentManager(), "pk_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ToolMode toolMode) {
        this.e.y();
        if (toolMode == null) {
            return;
        }
        if (TextUtils.equals(toolMode.getType(), "19")) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_BOX_ANCHOR_GROWTH_PLAN_CLICK, this.h.room_id, this.h.uid);
        }
        String target_url = toolMode.getTarget_url();
        if (TextUtils.isEmpty(target_url)) {
            return;
        }
        Map<String, String> a = BluedUrlUtils.a(target_url);
        Uri.Builder buildUpon = Uri.parse(target_url).buildUpon();
        buildUpon.clearQuery();
        buildUpon.appendQueryParameter("room_id", this.h.room_id);
        buildUpon.appendQueryParameter("uid", EncryptTool.b(YYRoomInfoManager.e().k()));
        for (String str : a.keySet()) {
            if (!TextUtils.equals(str, "room_id") && !TextUtils.equals(str, "uid")) {
                buildUpon.appendQueryParameter(str, a.get(str));
            }
        }
        String builder = buildUpon.toString();
        EventTrackYY.p(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_ACTIVITY_CLICK, this.h.room_id, this.h.uid, builder);
        LiveEventBus.get("event_yy_game").post(builder);
    }

    private void e() {
        this.b = findViewById(R.id.rv_basic_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.b.setLayoutManager(linearLayoutManager);
        ToolKitBoxAdapter toolKitBoxAdapter = new ToolKitBoxAdapter(false);
        this.g = toolKitBoxAdapter;
        this.b.setAdapter(toolKitBoxAdapter);
        ArrayList arrayList = new ArrayList();
        if (YYRoomInfoManager.e().i()) {
            arrayList.add(new ToolMode("", "", "4", "", 0, R.string.yy_mic_emoji, R.drawable.icon_mic_emoji, false));
        }
        if (YYRoomInfoManager.e().y()) {
            arrayList.add(new ToolMode("", "", "5", "", 0, R.string.yy_mic_sound, R.drawable.icon_mic_sound, false));
        }
        arrayList.add(new ToolMode("", "", "8", "", 0, R.string.yy_share_room, R.drawable.icon_yy_share_room, false));
        this.g.setNewData(arrayList);
    }

    private void f() {
        if (this.h == null) {
            return;
        }
        this.c.setVisibility(8);
        this.a.setVisibility(8);
        this.d.setVisibility(8);
        YYRoomHttpUtils.d(this.h.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<ToolkitMode, YYExtoolBoxModel>>(this.e.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYToolBoxView.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<ToolkitMode, YYExtoolBoxModel> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ToolkitMode singleData = bluedEntity.getSingleData();
                if (singleData.getFun_modes() != null && singleData.getFun_modes().getItems() != null && singleData.getFun_modes().getItems().size() > 0) {
                    YYToolBoxView.this.c.setText(singleData.getFun_modes().getName());
                    Iterator<ToolMode> it = singleData.getFun_modes().getItems().iterator();
                    while (it.hasNext()) {
                        ToolMode next = it.next();
                        next.setRed(YYToolBoxView.this.a(next));
                        arrayList.add(next);
                    }
                }
                if (singleData.getTools() != null && singleData.getTools().getItems() != null && singleData.getTools().getItems().size() > 0) {
                    YYToolBoxView.this.d.setText(singleData.getTools().getName());
                    Iterator<ToolMode> it2 = singleData.getTools().getItems().iterator();
                    while (it2.hasNext()) {
                        ToolMode next2 = it2.next();
                        next2.setRed(YYToolBoxView.this.a(next2));
                        arrayList2.add(next2);
                    }
                }
                if (arrayList.size() > 0) {
                    YYToolBoxView.this.c.setVisibility(0);
                    YYToolBoxView.this.a.setVisibility(0);
                    YYToolBoxView.this.d.setVisibility(0);
                    YYToolBoxView.this.f.setNewData(arrayList);
                } else {
                    YYToolBoxView.this.c.setVisibility(8);
                    YYToolBoxView.this.a.setVisibility(8);
                    YYToolBoxView.this.d.setVisibility(8);
                }
                YYToolBoxView.this.g.setNewData(arrayList2);
            }
        }, (IRequestHost) this.e.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!YYRoomInfoManager.e().i()) {
            ToastUtils.a("上麦才能播放氛围音效！");
            return;
        }
        YYEmojiView yYEmojiView = new YYEmojiView(getContext());
        yYEmojiView.b(this.e);
        this.e.a(yYEmojiView, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.h == null) {
            return;
        }
        IYYRoomInfoCallback c = YYRoomInfoManager.e().c();
        Context context = getContext();
        c.a(context, YYRoomInfoManager.e().c(3) + "?room_id=" + this.h.room_id, 0, true);
        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_PROP_CLICK, this.h.room_id, this.h.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.h == null) {
            return;
        }
        IYYRoomInfoCallback c = YYRoomInfoManager.e().c();
        Context context = getContext();
        c.a(context, YYRoomInfoManager.e().c(1) + "?roomid=" + this.h.room_id, 0);
        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_ANCHOR_LEVEL_CLICK, this.h.room_id, this.h.uid);
    }

    private void j() {
        YYSendVoteView yYSendVoteView = new YYSendVoteView(getContext());
        yYSendVoteView.a(this.e);
        this.e.a(yYSendVoteView, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        YYConfessedListDialog yYConfessedListDialog = new YYConfessedListDialog();
        yYConfessedListDialog.a("box");
        yYConfessedListDialog.show(this.e.getChildFragmentManager(), "YYConfessedListDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.e == null || this.h == null) {
            return;
        }
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        this.e.w();
        if (this.h != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_BOX_RELATION_CLICK, this.h.room_id, this.h.uid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (!YYRoomInfoManager.e().h()) {
            ToastUtils.a("必须主持人才能设置心愿礼物");
            return;
        }
        if (this.h != null) {
            EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_OWNER_DOWN_GIFT_CLICK, this.h.room_id);
        }
        this.e.y();
        if (YYRoomInfoManager.e().b) {
            LiveEventBus.get("show_wish_detail").post("");
        } else {
            LiveEventBus.get("show_create_wish").post("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (!YYRoomInfoManager.e().h()) {
            ToastUtils.a("必须主持人才能发起礼物PK");
        } else if (YYRoomInfoManager.e().p()) {
            ToastUtils.a("投票结束后才能发起礼物PK");
        } else {
            if (this.h != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_PK_CLICK, this.h.room_id, this.h.uid);
            }
            this.e.y();
            LiveEventBus.get("show_create_pk").post("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!YYRoomInfoManager.e().h()) {
            ToastUtils.a("必须主持人才能发起投票");
        } else if (YYRoomInfoManager.e().q()) {
            ToastUtils.a("礼物PK结束后才能发起投票");
        } else {
            if (this.h != null) {
                EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_VOTE_ICON_CLICK, this.h.room_id);
            }
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.e.x()) {
            this.e.y();
        }
        if (this.h == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_SHARE_CLICK, this.h.room_id, this.h.uid);
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (yYUserInfo == null) {
            return;
        }
        a(yYUserInfo.getAvatar());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.e.y();
        this.e.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (!YYRoomInfoManager.e().i()) {
            ToastUtils.a("上麦才能播放音乐！");
            return;
        }
        this.e.y();
        this.e.p();
        if (this.h != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_BG_MUSIC_ENTRANCE_CLICK, this.h.room_id, this.h.uid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (!YYRoomInfoManager.e().h()) {
            ToastUtils.a("必须主持人才能开启pk");
            return;
        }
        if (this.h != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_BOX_PK_CLICK, this.h.room_id, this.h.uid);
        }
        this.e.y();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        YYRoomModel yYRoomModel = this.h;
        if (yYRoomModel == null) {
            return;
        }
        String str = yYRoomModel.task_url;
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.clearQuery();
            buildUpon.appendQueryParameter("room_id", this.h.room_id);
            buildUpon.appendQueryParameter("uid", EncryptTool.b(YYRoomInfoManager.e().k()));
            str2 = buildUpon.toString();
        }
        LiveEventBus.get("event_yy_game").post(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        new YYRoomSettingDialog(this.e).show(this.e.getParentFragmentManager(), "show_setting_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.h != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_PK_ENTRANCE_CLICK, this.h.room_id, this.h.uid);
        }
        this.e.y();
        YYRoomPKFragmentNew.b.a().show(this.e.getParentFragmentManager(), "pk_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.h != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_TASK_ICON_CLICK, this.h.room_id, this.h.uid);
        }
        new YYDailyTaskFragment(this.e).show(this.e.getParentFragmentManager(), "show_daily_task");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.e.y();
        if (this.h == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_ROOM_BOX_REDBAG_CLICK, this.h.room_id, this.h.uid);
        ArrayList arrayList = new ArrayList();
        List<YYSeatMemberModel> hasPeopleMics = this.h.getHasPeopleMics();
        if (!hasPeopleMics.isEmpty()) {
            Iterator<YYSeatMemberModel> it = hasPeopleMics.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                YYSeatMemberModel next = it.next();
                if (!TextUtils.equals(next.getUid(), YYRoomInfoManager.e().k())) {
                    arrayList.add(next);
                    break;
                }
            }
        }
        new YYRedPackageDialog(arrayList).show(this.e.getParentFragmentManager(), "red_package_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.h != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_BOX_MADE_CAR_CLICK, this.h.room_id, this.h.uid);
        }
        this.e.y();
        new YYDecorateCarDialog("", "", 0, this.e).show(this.e.getParentFragmentManager(), "show_daily_task");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.e == null) {
            return;
        }
        if (this.h != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_BOX_CREATE_PRE_CLICK, this.h.room_id, this.h.uid);
        }
        this.e.y();
        new YYCreateComingEventsDialog(this.e).show(this.e.getParentFragmentManager(), "coming_events_dialog");
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, OnItemCLickListener onItemCLickListener) {
        this.e = baseYYStudioFragment;
        this.i = onItemCLickListener;
        YYRoomModel b = YYRoomInfoManager.e().b();
        this.h = b;
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_BOX_SHOW, this.h.room_id, this.h.uid);
        f();
    }
}
