package com.sobot.chat.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.api.model.SobotLocationModel;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.StMapOpenHelper;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.chat.widget.image.SobotRCImageView;
import com.sobot.pictureframe.SobotBitmapUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/LocationMessageHolder.class */
public class LocationMessageHolder extends MessageHolderBase implements View.OnClickListener {
    private SobotLocationModel mLocationData;
    private ZhiChiMessageBase mMessage;
    private int sobot_bg_default_map;
    private ProgressBar sobot_msgProgressBar;
    private ImageView sobot_msgStatus;
    private LinearLayout sobot_msg_container;
    private TextView st_localLabel;
    private TextView st_localName;
    private SobotRCImageView st_snapshot;

    public LocationMessageHolder(Context context, View view) {
        super(context, view);
        this.st_localName = (TextView) view.findViewById(ResourceUtils.getResId(context, "st_localName"));
        this.st_localLabel = (TextView) view.findViewById(ResourceUtils.getResId(context, "st_localLabel"));
        this.sobot_msgStatus = (ImageView) view.findViewById(ResourceUtils.getResId(context, "sobot_msgStatus"));
        this.st_snapshot = (SobotRCImageView) view.findViewById(ResourceUtils.getResId(context, "st_snapshot"));
        this.sobot_msg_container = (LinearLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_ll_hollow_container"));
        this.sobot_msgProgressBar = (ProgressBar) view.findViewById(ResourceUtils.getResId(context, "sobot_msgProgressBar"));
        this.sobot_msg_container.setOnClickListener(this);
        this.sobot_bg_default_map = ResourceUtils.getDrawableId(context, "sobot_bg_default_map");
    }

    private void refreshUi() {
        try {
            if (this.mMessage == null) {
                return;
            }
            if (this.mMessage.getSendSuccessState() == 1) {
                this.sobot_msgStatus.setVisibility(8);
                this.sobot_msgProgressBar.setVisibility(8);
            } else if (this.mMessage.getSendSuccessState() == 0) {
                this.sobot_msgStatus.setVisibility(0);
                this.sobot_msgProgressBar.setVisibility(8);
                this.sobot_msgProgressBar.setClickable(true);
                this.sobot_msgStatus.setOnClickListener(this);
            } else if (this.mMessage.getSendSuccessState() == 2) {
                this.sobot_msgStatus.setVisibility(8);
                this.sobot_msgProgressBar.setVisibility(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.mMessage = zhiChiMessageBase;
        if (zhiChiMessageBase.getAnswer() == null || zhiChiMessageBase.getAnswer().getLocationData() == null) {
            return;
        }
        SobotLocationModel locationData = zhiChiMessageBase.getAnswer().getLocationData();
        this.mLocationData = locationData;
        this.st_localName.setText(locationData.getLocalName());
        this.st_localLabel.setText(this.mLocationData.getLocalLabel());
        String snapshot = this.mLocationData.getSnapshot();
        SobotRCImageView sobotRCImageView = this.st_snapshot;
        int i = this.sobot_bg_default_map;
        SobotBitmapUtil.display(context, snapshot, sobotRCImageView, i, i);
        if (this.isRight) {
            refreshUi();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_msgStatus) {
            showReSendDialog(this.mContext, this.msgStatus, new MessageHolderBase.ReSendListener() { // from class: com.sobot.chat.viewHolder.LocationMessageHolder.1
                @Override // com.sobot.chat.viewHolder.base.MessageHolderBase.ReSendListener
                public void onReSend() {
                    if (LocationMessageHolder.this.msgCallBack == null || LocationMessageHolder.this.mMessage == null || LocationMessageHolder.this.mMessage.getAnswer() == null) {
                        return;
                    }
                    LocationMessageHolder.this.msgCallBack.sendMessageToRobot(LocationMessageHolder.this.mMessage, 5, 0, null);
                }
            });
        }
        if (view != this.sobot_msg_container || this.mLocationData == null) {
            return;
        }
        if (SobotOption.mapCardListener == null || !SobotOption.mapCardListener.onClickMapCradMsg(this.mContext, this.mLocationData)) {
            StMapOpenHelper.openMap(this.mContext, this.mLocationData);
        }
    }
}
