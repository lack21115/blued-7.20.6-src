package com.sobot.chat.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.adapter.SobotMsgAdapter;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.chat.widget.RoundProgressBar;
import com.sobot.chat.widget.image.SobotRCImageView;
import com.sobot.pictureframe.SobotBitmapUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/ImageMessageHolder.class */
public class ImageMessageHolder extends MessageHolderBase {
    SobotRCImageView image;
    TextView isGif;
    public ProgressBar pic_progress;
    ImageView pic_send_status;
    RelativeLayout sobot_pic_progress_rl;
    public RoundProgressBar sobot_pic_progress_round;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/ImageMessageHolder$RetrySendImageLisenter.class */
    public static class RetrySendImageLisenter implements View.OnClickListener {
        private Context context;
        private String id;
        private String imageUrl;
        private ImageView img;
        SobotMsgAdapter.SobotMsgCallBack mMsgCallBack;

        public RetrySendImageLisenter(Context context, String str, String str2, ImageView imageView, SobotMsgAdapter.SobotMsgCallBack sobotMsgCallBack) {
            this.id = str;
            this.imageUrl = str2;
            this.img = imageView;
            this.context = context;
            this.mMsgCallBack = sobotMsgCallBack;
        }

        private void showReSendPicDialog(final Context context, final String str, final String str2, ImageView imageView) {
            MessageHolderBase.showReSendDialog(context, imageView, new MessageHolderBase.ReSendListener() { // from class: com.sobot.chat.viewHolder.ImageMessageHolder.RetrySendImageLisenter.1
                @Override // com.sobot.chat.viewHolder.base.MessageHolderBase.ReSendListener
                public void onReSend() {
                    if (context != null) {
                        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
                        zhiChiMessageBase.setContent(str);
                        zhiChiMessageBase.setId(str2);
                        zhiChiMessageBase.setSendSuccessState(2);
                        if (RetrySendImageLisenter.this.mMsgCallBack != null) {
                            RetrySendImageLisenter.this.mMsgCallBack.sendMessageToRobot(zhiChiMessageBase, 3, 3, "");
                        }
                    }
                }
            });
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            ImageView imageView = this.img;
            if (imageView != null) {
                imageView.setClickable(false);
            }
            showReSendPicDialog(this.context, this.imageUrl, this.id, this.img);
        }
    }

    public ImageMessageHolder(Context context, View view) {
        super(context, view);
        this.isGif = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_pic_isgif"));
        this.image = (SobotRCImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_iv_picture"));
        this.pic_send_status = (ImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_pic_send_status"));
        this.pic_progress = (ProgressBar) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_pic_progress"));
        this.sobot_pic_progress_round = (RoundProgressBar) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_pic_progress_round"));
        this.sobot_pic_progress_rl = (RelativeLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_pic_progress_rl"));
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.isGif.setVisibility(8);
        this.image.setVisibility(0);
        if (this.isRight) {
            this.sobot_pic_progress_round.setVisibility(8);
            this.sobot_pic_progress_rl.setVisibility(0);
            if (zhiChiMessageBase.getSendSuccessState() == 0) {
                this.pic_send_status.setVisibility(0);
                this.pic_progress.setVisibility(8);
                this.sobot_pic_progress_round.setVisibility(8);
                this.sobot_pic_progress_rl.setVisibility(8);
                this.pic_send_status.setOnClickListener(new RetrySendImageLisenter(context, zhiChiMessageBase.getId(), zhiChiMessageBase.getAnswer().getMsg(), this.pic_send_status, this.msgCallBack));
            } else if (1 == zhiChiMessageBase.getSendSuccessState()) {
                this.pic_send_status.setVisibility(8);
                this.pic_progress.setVisibility(8);
                this.sobot_pic_progress_round.setVisibility(8);
                this.sobot_pic_progress_rl.setVisibility(8);
            } else if (2 == zhiChiMessageBase.getSendSuccessState()) {
                this.pic_progress.setVisibility(0);
                this.pic_send_status.setVisibility(8);
            } else {
                this.pic_send_status.setVisibility(8);
                this.pic_progress.setVisibility(8);
                this.sobot_pic_progress_round.setVisibility(8);
                this.sobot_pic_progress_rl.setVisibility(8);
            }
        }
        SobotBitmapUtil.display(context, zhiChiMessageBase.getAnswer().getMsg(), this.image);
        this.image.setOnClickListener(new MessageHolderBase.ImageClickLisenter(context, zhiChiMessageBase.getAnswer().getMsg(), this.isRight));
    }
}
