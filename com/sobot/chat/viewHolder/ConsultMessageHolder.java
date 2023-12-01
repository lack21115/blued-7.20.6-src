package com.sobot.chat.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.WebViewActivity;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.pictureframe.SobotBitmapUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/ConsultMessageHolder.class */
public class ConsultMessageHolder extends MessageHolderBase implements View.OnClickListener {
    private Button btn_sendBtn;
    private int defaultPicResId;
    private ImageView iv_pic;
    private ZhiChiMessageBase mData;
    private View sobot_container;
    private TextView tv_des;
    private TextView tv_lable;
    private TextView tv_title;

    public ConsultMessageHolder(Context context, View view) {
        super(context, view);
        Button button = (Button) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_sendBtn"));
        this.btn_sendBtn = button;
        button.setText(ResourceUtils.getResString(context, "sobot_send_cus_service"));
        this.sobot_container = view.findViewById(ResourceUtils.getResId(context, "sobot_container"));
        this.iv_pic = (ImageView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_pic"));
        this.tv_title = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_title"));
        this.tv_lable = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_label"));
        this.tv_des = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_des"));
        this.defaultPicResId = ResourceUtils.getDrawableId(context, "sobot_icon_consulting_default_pic");
        this.sobot_container.setOnClickListener(this);
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.mData = zhiChiMessageBase;
        String content = zhiChiMessageBase.getContent();
        String picurl = zhiChiMessageBase.getPicurl();
        final String url = zhiChiMessageBase.getUrl();
        String aname = zhiChiMessageBase.getAname();
        String receiverFace = zhiChiMessageBase.getReceiverFace();
        if (TextUtils.isEmpty(picurl)) {
            this.iv_pic.setVisibility(8);
            this.iv_pic.setImageResource(this.defaultPicResId);
        } else {
            this.iv_pic.setVisibility(0);
            this.tv_des.setMaxLines(1);
            this.tv_des.setEllipsize(TextUtils.TruncateAt.END);
            String encode = CommonUtils.encode(picurl);
            ImageView imageView = this.iv_pic;
            int i = this.defaultPicResId;
            SobotBitmapUtil.display(context, encode, imageView, i, i);
        }
        this.tv_des.setText(receiverFace);
        this.tv_title.setText(content);
        if (!TextUtils.isEmpty(aname)) {
            this.tv_lable.setVisibility(0);
            this.tv_lable.setText(aname);
        } else if (TextUtils.isEmpty(picurl)) {
            this.tv_lable.setVisibility(8);
        } else {
            this.tv_lable.setVisibility(4);
        }
        this.btn_sendBtn.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.ConsultMessageHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LogUtils.i("发送连接---->" + url);
                if (ConsultMessageHolder.this.msgCallBack != null) {
                    ConsultMessageHolder.this.msgCallBack.sendConsultingContent();
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ZhiChiMessageBase zhiChiMessageBase;
        Tracker.onClick(view);
        if (view != this.sobot_container || (zhiChiMessageBase = this.mData) == null || TextUtils.isEmpty(zhiChiMessageBase.getUrl())) {
            return;
        }
        if (SobotOption.hyperlinkListener != null) {
            SobotOption.hyperlinkListener.onUrlClick(this.mData.getUrl());
        } else if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onUrlClick(this.mContext, this.mData.getUrl())) {
            Intent intent = new Intent(this.mContext, WebViewActivity.class);
            intent.putExtra("url", this.mData.getUrl());
            intent.addFlags(268435456);
            this.mContext.startActivity(intent);
        }
    }
}
