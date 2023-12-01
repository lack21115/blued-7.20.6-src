package com.soft.blued.ui.msg.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/SelectSessionAdapter.class */
public class SelectSessionAdapter extends BaseQuickAdapter<SessionModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f32187a;

    public SelectSessionAdapter(IRequestHost iRequestHost) {
        super((int) R.layout.item_select_session);
        this.f32187a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, SessionModel sessionModel) {
        String str = sessionModel.nickName;
        String str2 = str;
        if (sessionModel.sessionSettingModel != null) {
            SessionSettingModel sessionSettingModel = (SessionSettingModel) sessionModel.sessionSettingModel;
            str2 = str;
            if (!TextUtils.isEmpty(sessionSettingModel.getSessinoNote())) {
                str2 = sessionSettingModel.getSessinoNote();
            }
        }
        baseViewHolder.setText(2131372046, str2);
        ((ImageView) baseViewHolder.getView(R.id.iv_radio)).setSelected(sessionModel.checked);
        ImageLoader.a(this.f32187a, sessionModel.avatar).c().b(2131237310).a((ImageView) baseViewHolder.getView(2131365504));
    }
}
