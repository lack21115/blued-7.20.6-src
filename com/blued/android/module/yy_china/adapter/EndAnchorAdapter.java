package com.blued.android.module.yy_china.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/EndAnchorAdapter.class */
public class EndAnchorAdapter extends BaseQuickAdapter<YYRoomModel, BaseViewHolder> {
    private final MvpFragment a;

    public EndAnchorAdapter(MvpFragment mvpFragment) {
        super(R.layout.item_yy_end_recom_anchor, new ArrayList());
        this.a = mvpFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final YYRoomModel yYRoomModel) {
        ImageView imageView = (ImageView) baseViewHolder.itemView.findViewById(R.id.iv_anchor);
        ((TextView) baseViewHolder.itemView.findViewById(R.id.tv_anchor_name)).setText(yYRoomModel.name);
        ImageLoader.a(this.a.getFragmentActive(), yYRoomModel.avatar).b(R.drawable.user_bg_round).a(imageView);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.EndAnchorAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ClickUtils.a(R.id.iv_anchor, 2000L)) {
                    return;
                }
                YYRoomInfoManager.e().x();
                YYRoomInfoManager.e().a((BaseFragmentActivity) EndAnchorAdapter.this.a.getActivity(), yYRoomModel.room_id, "endPage_recommend");
                EndAnchorAdapter.this.a.getActivity().finish();
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_END_PAGE_LIVING_USER_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
            }
        });
    }
}
