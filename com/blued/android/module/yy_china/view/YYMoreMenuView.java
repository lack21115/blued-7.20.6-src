package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.utils.YyChatRoomTagShapeUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyMoreMenuRoomBinding;
import com.blued.android.module.yy_china.databinding.ViewYyMoreMenuLayoutBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYJumpLoadingFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import com.blued.android.module.yy_china.model.YYRecomRoomModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMoreMenuView.class */
public class YYMoreMenuView extends LinearLayout implements View.OnClickListener {
    private BaseYYStudioFragment a;
    private View.OnClickListener b;
    private ViewYyMoreMenuLayoutBinding c;
    private RoomAdapter d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMoreMenuView$RoomAdapter.class */
    public class RoomAdapter extends BaseQuickAdapter<YYRecomRoomModel, BaseViewHolder> {
        public RoomAdapter() {
            super(R.layout.item_yy_more_menu_room, new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final YYRecomRoomModel yYRecomRoomModel) {
            ItemYyMoreMenuRoomBinding a = ItemYyMoreMenuRoomBinding.a(baseViewHolder.itemView);
            a.d.setText(yYRecomRoomModel.getUser_name());
            a.b.setText(yYRecomRoomModel.getRoom_name());
            TextView textView = a.e;
            textView.setText(yYRecomRoomModel.getRoom_member_count() + "人");
            ImageLoader.a(YYMoreMenuView.this.a.getFragmentActive(), yYRecomRoomModel.getUser_avatar()).a(4.0f, 4.0f, 4.0f, 4.0f).a(a.a);
            ShapeHelper.a(a.c, a.c.getResources().getDimension(R.dimen.dp_4), 0.0f, 0.0f, a.c.getResources().getDimension(R.dimen.dp_4));
            YyChatRoomTagShapeUtils.a.a(a.c, yYRecomRoomModel.getType_id());
            a.c.setText(yYRecomRoomModel.getRoom_type());
            if (!yYRecomRoomModel.isUp) {
                yYRecomRoomModel.isUp = true;
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_DRAW, yYRecomRoomModel.getRoom_id(), yYRecomRoomModel.getUid(), YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID, yYRecomRoomModel.getType_id(), false, "list_room", "recommend_second", yYRecomRoomModel.label_link);
            }
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYMoreMenuView.RoomAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (YYRoomInfoManager.e().b() == null || !YYRoomInfoManager.e().b().room_id.equals(yYRecomRoomModel.getRoom_id())) {
                        YYJumpLoadingFragment.a(YYMoreMenuView.this.a.getContext());
                        YYRoomInfoManager.e().a((BaseFragmentActivity) YYMoreMenuView.this.a.getActivity(), yYRecomRoomModel.getRoom_id(), "room_recommend");
                        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, yYRecomRoomModel.getRoom_id(), yYRecomRoomModel.getUid(), YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID, yYRecomRoomModel.getType_id(), false, "list_room", "recommend_second", yYRecomRoomModel.label_link);
                    }
                }
            });
        }
    }

    public YYMoreMenuView(Context context) {
        super(context);
        a();
    }

    public YYMoreMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYMoreMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        ViewYyMoreMenuLayoutBinding a = ViewYyMoreMenuLayoutBinding.a(LayoutInflater.from(getContext()), this, true);
        this.c = a;
        a.c.setOnClickListener(this);
        this.c.b.setOnClickListener(this);
        this.c.a.setOnClickListener(this);
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, String str) {
        this.a = baseYYStudioFragment;
        this.c.e.setText(str);
        this.c.d.setLayoutManager(new LinearLayoutManager(getContext()));
        this.d = new RoomAdapter();
        this.c.d.setAdapter(this.d);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            YYRoomHttpUtils.b(b.room_id, new Integer(b.type_id).intValue(), new BluedUIHttpResponse<BluedEntityA<YYRecomRoomModel>>(baseYYStudioFragment.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYMoreMenuView.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<YYRecomRoomModel> bluedEntityA) {
                    if (!bluedEntityA.hasData() || YYMoreMenuView.this.d == null) {
                        return;
                    }
                    YYMoreMenuView.this.d.setNewData(bluedEntityA.data);
                }
            }, baseYYStudioFragment.getFragmentActive());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseYYStudioFragment baseYYStudioFragment;
        View.OnClickListener onClickListener;
        Tracker.onClick(view);
        if (view.getId() == R.id.ll_shutdown) {
            if (this.a == null || (onClickListener = this.b) == null) {
                return;
            }
            onClickListener.onClick(view);
        } else if (view.getId() != R.id.ll_fold_room) {
            if (view.getId() != R.id.iv_clos || (baseYYStudioFragment = this.a) == null) {
                return;
            }
            baseYYStudioFragment.y();
        } else {
            BaseYYStudioFragment baseYYStudioFragment2 = this.a;
            if (baseYYStudioFragment2 == null) {
                return;
            }
            baseYYStudioFragment2.onBackPressed();
            this.a.getActivity().finish();
        }
    }

    public void setShutdownLisenter(View.OnClickListener onClickListener) {
        this.b = onClickListener;
    }
}
