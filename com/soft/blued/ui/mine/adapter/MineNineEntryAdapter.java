package com.soft.blued.ui.mine.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/adapter/MineNineEntryAdapter.class */
public class MineNineEntryAdapter extends BaseQuickAdapter<MineEntryInfo.ColumnsItem, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f31587a;
    private IRequestHost b;

    public MineNineEntryAdapter(Context context, IRequestHost iRequestHost) {
        super((int) R.layout.item_mine_nine_entry);
        this.f31587a = context;
        this.b = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final MineEntryInfo.ColumnsItem columnsItem) {
        ImageView imageView = (ImageView) baseViewHolder.getView(2131364552);
        TextView textView = (TextView) baseViewHolder.getView(2131371186);
        QBadgeContainer qBadgeContainer = (QBadgeContainer) baseViewHolder.getView(R.id.badge_container);
        if ("help".equals(columnsItem.key)) {
            ServiceHelper.f33645a.a(qBadgeContainer, baseViewHolder.getView(R.id.bindView));
        } else {
            qBadgeContainer.setVisibility(8);
        }
        baseViewHolder.setGone(R.id.tv_anchor_level, false);
        imageView.setVisibility(0);
        ImageLoader.a(this.b, columnsItem.icon).a(imageView);
        if (columnsItem.extra == null || columnsItem.extra.show_new_icon != 1) {
            baseViewHolder.setGone(R.id.iv_new, false);
        } else {
            baseViewHolder.setGone(R.id.iv_new, true);
        }
        baseViewHolder.setText(2131372754, columnsItem.title);
        baseViewHolder.setGone(2131371196, false);
        if (TextUtils.isEmpty(columnsItem.recommend_text)) {
            baseViewHolder.setText(2131371186, "");
        } else {
            baseViewHolder.setText(2131371186, columnsItem.recommend_text);
        }
        if (columnsItem.extra != null && !TextUtils.isEmpty(columnsItem.extra.type)) {
            String str = columnsItem.extra.type;
            boolean z = true;
            switch (str.hashCode()) {
                case -1361632588:
                    if (str.equals("charge")) {
                        z = true;
                        break;
                    }
                    break;
                case -634444422:
                    if (str.equals(MineEntryInfo.ColumnsExtra.TYPE_ANCHOR_LEVEL)) {
                        z = false;
                        break;
                    }
                    break;
                case -378396698:
                    if (str.equals(MineEntryInfo.ColumnsExtra.TYPE_CALL_ORDERS)) {
                        z = true;
                        break;
                    }
                    break;
                case -358591903:
                    if (str.equals(MineEntryInfo.ColumnsExtra.TYPE_RICH_LEVEL)) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (!z) {
                imageView.setVisibility(4);
                baseViewHolder.setGone(R.id.tv_anchor_level, true);
                baseViewHolder.setText(R.id.tv_anchor_level, columnsItem.extra.anchor_level);
            } else if (z) {
                baseViewHolder.setGone(2131371196, true);
                long j = columnsItem.extra.beans;
                UserInfo.getInstance().setUserPrice(j);
                baseViewHolder.setText(2131371196, DistanceUtils.a(this.f31587a, Long.valueOf(j)));
                baseViewHolder.setText(2131371186, this.f31587a.getString(2131886105));
            } else if (z) {
                baseViewHolder.setText(2131371186, "Lv." + LiveUtils.a(columnsItem.extra.rich_level));
            } else if (z) {
                int i = columnsItem.extra.times;
                if (i > 0) {
                    baseViewHolder.setText(2131371186, String.format(this.f31587a.getString(R.string.blued_call_times), Integer.valueOf(i)));
                } else {
                    baseViewHolder.setText(2131371186, this.f31587a.getString(R.string.blued_call_buy));
                }
            }
        }
        if (columnsItem.is_highlight == 1) {
            textView.setTextColor(Color.parseColor("#00CCCC"));
        } else {
            textView.setTextColor(BluedSkinUtils.a(this.f31587a, 2131102263));
        }
        if (BluedPreferences.P(columnsItem.item_key) || (columnsItem.title != null && columnsItem.title.equals(this.f31587a.getResources().getString(2131891641)) && BluedPreferences.dI())) {
            baseViewHolder.setGone(2131365270, true);
        } else {
            baseViewHolder.setGone(2131365270, false);
        }
        baseViewHolder.getView(2131366742).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.adapter.MineNineEntryAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
                String str2 = columnsItem.url;
                String str3 = columnsItem.id;
                boolean z2 = true;
                if (BluedConfig.a().g().is_chat_shadow != 1) {
                    z2 = false;
                }
                EventTrackSettings.a(event, str2, str3, z2);
                Logger.e("MineNineEntryAdapter===" + columnsItem.title, new Object[0]);
                Logger.e("MineNineEntryAdapter===" + columnsItem.url, new Object[0]);
                InstantLog.f("mine", columnsItem.url);
                WebViewShowInfoFragment.show(MineNineEntryAdapter.this.f31587a, columnsItem.url, 9);
                BluedPreferences.Q(columnsItem.item_key);
            }
        });
    }
}
