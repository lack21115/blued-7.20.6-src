package com.sobot.chat.adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.adapter.base.SobotBaseAdapter;
import com.sobot.chat.api.model.SobotMsgCenterModel;
import com.sobot.chat.utils.DateUtil;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotMsgCenterAdapter.class */
public class SobotMsgCenterAdapter extends SobotBaseAdapter<SobotMsgCenterModel> {

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotMsgCenterAdapter$SobotMsgCenterViewHolder.class */
    public static class SobotMsgCenterViewHolder {
        Context context;
        private SobotMsgCenterModel data = null;
        int defaultFaceId;
        ImageView sobot_iv_face;
        TextView sobot_tv_content;
        TextView sobot_tv_date;
        TextView sobot_tv_title;
        TextView sobot_tv_unread_count;

        public SobotMsgCenterViewHolder(Context context, View view) {
            this.context = context;
            this.sobot_tv_title = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_title"));
            this.sobot_tv_unread_count = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_unread_count"));
            this.sobot_tv_content = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_content"));
            this.sobot_tv_date = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_date"));
            this.sobot_iv_face = (ImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_iv_face"));
            this.defaultFaceId = ResourceUtils.getIdByName(context, i.f5112c, "sobot_chatting_default_head");
        }

        private void setUnReadNum(TextView textView, int i) {
            if (i <= 0) {
                textView.setVisibility(8);
                return;
            }
            if (i <= 9) {
                textView.setBackgroundResource(ResourceUtils.getIdByName(this.context, i.f5112c, "sobot_message_bubble_1"));
                textView.setText(i + "");
            } else if (i <= 9 || i > 99) {
                textView.setBackgroundResource(ResourceUtils.getIdByName(this.context, i.f5112c, "sobot_message_bubble_3"));
                textView.setText("99+");
            } else {
                textView.setBackgroundResource(ResourceUtils.getIdByName(this.context, i.f5112c, "sobot_message_bubble_2"));
                textView.setText(i + "");
            }
            textView.setVisibility(0);
        }

        public void bindData(SobotMsgCenterModel sobotMsgCenterModel) {
            if (sobotMsgCenterModel == null) {
                return;
            }
            this.data = sobotMsgCenterModel;
            Context context = this.context;
            String face = sobotMsgCenterModel.getFace();
            ImageView imageView = this.sobot_iv_face;
            int i = this.defaultFaceId;
            SobotBitmapUtil.display(context, face, imageView, i, i);
            this.sobot_tv_title.setText(sobotMsgCenterModel.getName());
            this.sobot_tv_content.setText(TextUtils.isEmpty(sobotMsgCenterModel.getLastMsg()) ? "" : Html.fromHtml(sobotMsgCenterModel.getLastMsg()).toString());
            if (!TextUtils.isEmpty(sobotMsgCenterModel.getLastDateTime())) {
                try {
                    this.sobot_tv_date.setText(DateUtil.formatDateTime2(sobotMsgCenterModel.getLastDateTime()));
                } catch (Exception e) {
                }
            }
            setUnReadNum(this.sobot_tv_unread_count, sobotMsgCenterModel.getUnreadCount());
        }
    }

    public SobotMsgCenterAdapter(Context context, List<SobotMsgCenterModel> list) {
        super(context, list);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        SobotMsgCenterViewHolder sobotMsgCenterViewHolder;
        SobotMsgCenterModel sobotMsgCenterModel = (SobotMsgCenterModel) this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(ResourceUtils.getIdByName(this.context, "layout", "sobot_msg_center_item"), (ViewGroup) null);
            sobotMsgCenterViewHolder = new SobotMsgCenterViewHolder(this.context, view);
            view.setTag(sobotMsgCenterViewHolder);
        } else {
            sobotMsgCenterViewHolder = (SobotMsgCenterViewHolder) view.getTag();
        }
        sobotMsgCenterViewHolder.bindData(sobotMsgCenterModel);
        return view;
    }
}
