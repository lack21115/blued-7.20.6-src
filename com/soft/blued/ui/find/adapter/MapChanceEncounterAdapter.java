package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.find.model.MapChanceEncounterModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.presenter.PayUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/MapChanceEncounterAdapter.class */
public class MapChanceEncounterAdapter extends BaseQuickAdapter<MapChanceEncounterModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f16368a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16369c;

    public MapChanceEncounterAdapter(Context context, IRequestHost iRequestHost, boolean z) {
        super((int) R.layout.item_chance_counter_user);
        this.f16368a = context;
        this.f16369c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final MapChanceEncounterModel mapChanceEncounterModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_avatar);
        ImageLoader.a(this.b, mapChanceEncounterModel.avatar).c().b(2131237310).d(2131237310).a(imageView);
        baseViewHolder.setText(R.id.tv_time, TimeAndDateUtils.a(AppInfo.d(), TimeAndDateUtils.c(mapChanceEncounterModel.last_meet_time)));
        String string = this.f16368a.getString(R.string.chance_encounter_times);
        baseViewHolder.setText(R.id.tv_number_of_times, String.format(string, mapChanceEncounterModel.meet_count + ""));
        ShapeTextView view = baseViewHolder.getView(R.id.btn_to_chat);
        a(mapChanceEncounterModel.label, (LinearLayout) baseViewHolder.getView(R.id.ll_tag_view));
        EventTrackVIP.b(VipProtos.Event.MAP_FIND_PASSBY_POP_USER_SHOW, UserInfo.getInstance().getLoginUserInfo().vip_grade, mapChanceEncounterModel.uid);
        String str = this.f16369c ? "msg_pass" : "map_pass";
        final String str2 = str;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.MapChanceEncounterAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                EventTrackVIP.b(VipProtos.Event.MAP_FIND_PASSBY_POP_USER_PHOTO_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade, mapChanceEncounterModel.uid);
                if (baseViewHolder.getLayoutPosition() > 0 && UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                    PayUtils.a(MapChanceEncounterAdapter.this.f16368a, 2, str2, -1, VipProtos.FromType.FIND_MAP_PASS);
                } else if (TextUtils.isEmpty(mapChanceEncounterModel.uid)) {
                } else {
                    UserInfoFragmentNew.a(MapChanceEncounterAdapter.this.f16368a, mapChanceEncounterModel.uid, "");
                }
            }
        });
        final String str3 = str;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.MapChanceEncounterAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                EventTrackVIP.b(VipProtos.Event.MAP_FIND_PASSBY_POP_USER_CHAT_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade, mapChanceEncounterModel.uid);
                if (baseViewHolder.getLayoutPosition() > 0 && UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                    PayUtils.a(MapChanceEncounterAdapter.this.f16368a, 2, str3, -1, VipProtos.FromType.FIND_MAP_PASS);
                } else if (TextUtils.isEmpty(mapChanceEncounterModel.uid)) {
                } else {
                    LogData logData = new LogData();
                    logData.from = "none";
                    ChatHelperV4.a().a(MapChanceEncounterAdapter.this.f16368a, Long.parseLong(mapChanceEncounterModel.uid), "", mapChanceEncounterModel.avatar, 0, 0, 0, 0, "", false, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
                }
            }
        });
    }

    public void a(String[] strArr, LinearLayout linearLayout) {
        if (strArr == null || strArr.length <= 0) {
            linearLayout.setVisibility(8);
            linearLayout.removeAllViews();
            return;
        }
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        for (String str : strArr) {
            View inflate = LayoutInflater.from(this.f16368a).inflate(R.layout.tag_map_chance_encounter_user, (ViewGroup) null);
            ((TextView) inflate.findViewById(2131372684)).setText(str);
            linearLayout.addView(inflate);
        }
    }
}
