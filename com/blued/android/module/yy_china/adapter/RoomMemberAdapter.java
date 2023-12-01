package com.blued.android.module.yy_china.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.OnItemClickRoomMemberListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/RoomMemberAdapter.class */
public class RoomMemberAdapter extends BaseQuickAdapter<YYAudienceModel, BaseViewHolder> {
    private BaseYYStudioFragment a;
    private int b;
    private OnItemClickRoomMemberListener c;
    private YYRoomModel d;

    public RoomMemberAdapter(BaseYYStudioFragment baseYYStudioFragment, int i) {
        super(R.layout.item_yy_room_member_layout, new ArrayList());
        this.mContext = baseYYStudioFragment.getContext();
        this.b = i;
        this.a = baseYYStudioFragment;
        this.d = YYRoomInfoManager.e().b();
    }

    private void a(YYAudienceModel yYAudienceModel, TextView textView, ImageView imageView, TextView textView2) {
        ImageLoader.a(this.a.getFragmentActive(), yYAudienceModel.getAvatar()).b(R.drawable.user_bg_round).a(imageView);
        textView.setText(yYAudienceModel.getName());
        if (TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k())) {
            textView2.setText(this.mContext.getResources().getString(R.string.yy_msg_self));
        } else {
            textView2.setText(String.format(this.mContext.getResources().getString(R.string.yy_years_height_weight), yYAudienceModel.age, yYAudienceModel.height, yYAudienceModel.weight, UserInfoHelper.a(this.mContext, (TextView) null, yYAudienceModel.role)));
        }
    }

    private void b(BaseViewHolder baseViewHolder, YYAudienceModel yYAudienceModel) {
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_follow);
        ShapeTextView shapeTextView2 = (ShapeTextView) baseViewHolder.getView(R.id.tv_invite);
        shapeTextView.setVisibility(8);
        shapeTextView2.setVisibility(0);
        if (yYAudienceModel.is_on_mic == 1) {
            shapeTextView2.setEnabled(false);
            ShapeHelper.a(shapeTextView2, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_8d8d8e);
            shapeTextView2.setText(this.mContext.getResources().getString(R.string.yy_has_seat));
            return;
        }
        shapeTextView2.setEnabled(true);
        ShapeHelper.a(shapeTextView2, R.color.syc_00E0AB, R.color.syc_3883FD);
        ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_dark_b);
        shapeTextView2.setText(this.mContext.getResources().getString(R.string.yy_invite_seat));
    }

    private void c(BaseViewHolder baseViewHolder, YYAudienceModel yYAudienceModel) {
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_follow);
        shapeTextView.setVisibility(0);
        ((ShapeTextView) baseViewHolder.getView(R.id.tv_invite)).setVisibility(8);
        if (TextUtils.equals(yYAudienceModel.relationship, "1") || TextUtils.equals(yYAudienceModel.relationship, "3")) {
            ShapeHelper.a(shapeTextView, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_8d8d8e);
        } else {
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_dark_b);
            ShapeHelper.a(shapeTextView, R.color.syc_00E0AB, R.color.syc_3883FD);
        }
        shapeTextView.setText(UserRelationshipUtils.a(this.mContext, yYAudienceModel.relationship));
    }

    public int a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getData().size()) {
                return -1;
            }
            if (TextUtils.equals(str, ((YYAudienceModel) getData().get(i2)).getUid())) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public void a(OnItemClickRoomMemberListener onItemClickRoomMemberListener) {
        this.c = onItemClickRoomMemberListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final YYAudienceModel yYAudienceModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_member_view);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_member_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_member_style);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_follow);
        ShapeTextView shapeTextView2 = (ShapeTextView) baseViewHolder.getView(R.id.tv_invite);
        ShapeTextView shapeTextView3 = (ShapeTextView) baseViewHolder.getView(R.id.tv_role_text);
        YYRoomModel yYRoomModel = this.d;
        if (yYRoomModel == null || !TextUtils.equals(yYRoomModel.chat_type, "9")) {
            if (TextUtils.equals(this.b + "", "1")) {
                b(baseViewHolder, yYAudienceModel);
            } else {
                c(baseViewHolder, yYAudienceModel);
            }
        } else {
            if (!TextUtils.equals(this.b + "", "1")) {
                if (!TextUtils.equals(this.b + "", "2")) {
                    c(baseViewHolder, yYAudienceModel);
                }
            }
            b(baseViewHolder, yYAudienceModel);
            if (yYAudienceModel.is_on_mic != 1 && TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k())) {
                shapeTextView2.setVisibility(8);
            }
        }
        if (!YYRoomInfoManager.e().J()) {
            a(yYAudienceModel, textView, imageView, textView2);
        } else if (YYRoomInfoManager.e().g(yYAudienceModel.getUid())) {
            a(yYAudienceModel, textView, imageView, textView2);
        } else {
            ImageLoader.a(this.a.getFragmentActive(), R.drawable.icon_user_mask_with_text).b(R.drawable.user_bg_round).a(imageView);
            textView.setText(this.a.getResources().getString(R.string.masked_user_name));
            textView2.setVisibility(8);
            shapeTextView.setVisibility(8);
        }
        if (TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k()) || TextUtils.equals(yYAudienceModel.relationship, "8") || TextUtils.equals(yYAudienceModel.relationship, "4")) {
            shapeTextView.setVisibility(8);
        }
        if (TextUtils.equals(yYAudienceModel.chat_anchor, "1")) {
            shapeTextView3.setVisibility(0);
            shapeTextView3.setText(this.mContext.getResources().getString(R.string.yy_role_host));
            ShapeHelper.b(shapeTextView3, R.color.syc_3883FD);
        } else if (TextUtils.equals(yYAudienceModel.chat_anchor, "2")) {
            shapeTextView3.setVisibility(0);
            shapeTextView3.setText(this.mContext.getResources().getString(R.string.yy_role_manager));
            ShapeHelper.b(shapeTextView3, R.color.syc_8F38FD);
        } else {
            shapeTextView3.setVisibility(4);
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.RoomMemberAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (RoomMemberAdapter.this.c != null) {
                    RoomMemberAdapter.this.c.a(yYAudienceModel, baseViewHolder.getAdapterPosition());
                }
            }
        });
        shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.RoomMemberAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_INVITE_CLICK, b.room_id, b.uid, yYAudienceModel.getUid());
                }
                if (RoomMemberAdapter.this.c != null) {
                    RoomMemberAdapter.this.c.b(yYAudienceModel, baseViewHolder.getAdapterPosition());
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.RoomMemberAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                boolean isExistById = b != null ? b.isExistById(yYAudienceModel.getUid()) : false;
                if (YYRoomInfoManager.e().a != null) {
                    RoomMemberAdapter.this.a.a(yYAudienceModel.getUid(), yYAudienceModel.getName(), yYAudienceModel.getAvatar(), YYRoomInfoManager.e().a.chat_anchor, isExistById);
                }
            }
        });
    }
}
