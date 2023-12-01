package com.sobot.chat.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotUIConfig;
import com.sobot.chat.adapter.SobotMsgAdapter;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.api.model.ZhiChiReplyAnswer;
import com.sobot.chat.utils.DateUtil;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/VoiceMessageHolder.class */
public class VoiceMessageHolder extends MessageHolderBase {
    LinearLayout ll_voice_layout;
    public ZhiChiMessageBase message;
    ImageView voicePlay;
    TextView voiceTimeLong;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/VoiceMessageHolder$RetrySendVoiceLisenter.class */
    public static class RetrySendVoiceLisenter implements View.OnClickListener {
        private Context context;
        private String duration;
        private String id;
        private ImageView img;
        private SobotMsgAdapter.SobotMsgCallBack msgCallBack;
        private String voicePath;

        public RetrySendVoiceLisenter(Context context, String str, String str2, String str3, ImageView imageView, SobotMsgAdapter.SobotMsgCallBack sobotMsgCallBack) {
            this.context = context;
            this.msgCallBack = sobotMsgCallBack;
            this.voicePath = str2;
            this.id = str;
            this.duration = str3;
            this.img = imageView;
        }

        private void showReSendVoiceDialog(final Context context, final String str, final String str2, final String str3, ImageView imageView) {
            MessageHolderBase.showReSendDialog(context, imageView, new MessageHolderBase.ReSendListener() { // from class: com.sobot.chat.viewHolder.VoiceMessageHolder.RetrySendVoiceLisenter.1
                @Override // com.sobot.chat.viewHolder.base.MessageHolderBase.ReSendListener
                public void onReSend() {
                    if (context != null) {
                        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
                        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
                        zhiChiReplyAnswer.setDuration(str3);
                        zhiChiMessageBase.setContent(str);
                        zhiChiMessageBase.setId(str2);
                        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
                        if (RetrySendVoiceLisenter.this.msgCallBack != null) {
                            RetrySendVoiceLisenter.this.msgCallBack.sendMessageToRobot(zhiChiMessageBase, 2, 3, "");
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
            showReSendVoiceDialog(this.context, this.voicePath, this.id, this.duration, this.img);
        }
    }

    public VoiceMessageHolder(Context context, View view) {
        super(context, view);
        this.voicePlay = (ImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_iv_voice"));
        this.voiceTimeLong = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_voiceTimeLong"));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_voice_layout"));
        this.ll_voice_layout = linearLayout;
        if (linearLayout != null && -1 != SobotUIConfig.sobot_chat_right_bgColor) {
            ScreenUtils.setBubbleBackGroud(this.mContext, this.ll_voice_layout, SobotUIConfig.sobot_chat_right_bgColor);
        }
        this.msgProgressBar = (ProgressBar) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_msgProgressBar"));
    }

    private void resetAnim() {
        this.voicePlay.setImageResource(this.isRight ? ResourceUtils.getIdByName(this.mContext, i.f5112c, "sobot_voice_to_icon") : ResourceUtils.getIdByName(this.mContext, i.f5112c, "sobot_voice_from_icon"));
        Drawable drawable = this.voicePlay.getDrawable();
        if (drawable == null || !(drawable instanceof AnimationDrawable)) {
            return;
        }
        ((AnimationDrawable) drawable).start();
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, final ZhiChiMessageBase zhiChiMessageBase) {
        String str;
        this.message = zhiChiMessageBase;
        TextView textView = this.voiceTimeLong;
        if (zhiChiMessageBase.getAnswer().getDuration() == null) {
            str = "";
        } else {
            str = DateUtil.stringToLongMs(zhiChiMessageBase.getAnswer().getDuration()) + "″";
        }
        textView.setText(str);
        applyTextViewUIConfig(this.voiceTimeLong);
        checkBackground();
        this.ll_voice_layout.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.VoiceMessageHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (VoiceMessageHolder.this.msgCallBack != null) {
                    VoiceMessageHolder.this.msgCallBack.clickAudioItem(zhiChiMessageBase);
                }
            }
        });
        if (this.isRight) {
            if (zhiChiMessageBase.getSendSuccessState() == 1) {
                this.msgStatus.setVisibility(8);
                this.msgProgressBar.setVisibility(8);
                this.voiceTimeLong.setVisibility(0);
                this.voicePlay.setVisibility(0);
            } else if (zhiChiMessageBase.getSendSuccessState() == 0) {
                this.msgStatus.setVisibility(0);
                this.msgProgressBar.setVisibility(8);
                this.voicePlay.setVisibility(0);
                this.voiceTimeLong.setVisibility(0);
                stopAnim();
                this.msgStatus.setOnClickListener(new RetrySendVoiceLisenter(context, zhiChiMessageBase.getId(), zhiChiMessageBase.getAnswer().getMsg(), zhiChiMessageBase.getAnswer().getDuration(), this.msgStatus, this.msgCallBack));
            } else if (zhiChiMessageBase.getSendSuccessState() == 2) {
                this.msgProgressBar.setVisibility(0);
                this.msgStatus.setVisibility(8);
                this.voiceTimeLong.setVisibility(8);
                this.voicePlay.setVisibility(8);
            } else if (zhiChiMessageBase.getSendSuccessState() == 4) {
                this.msgProgressBar.setVisibility(8);
                this.msgStatus.setVisibility(8);
                this.voiceTimeLong.setVisibility(8);
                this.voicePlay.setVisibility(8);
            }
            long stringToLongMs = DateUtil.stringToLongMs(zhiChiMessageBase.getAnswer().getDuration());
            long j = stringToLongMs;
            if (stringToLongMs == 0) {
                j = 1;
            }
            Activity activity = (Activity) context;
            int screenWidth = ScreenUtils.getScreenWidth(activity) / 5;
            int screenWidth2 = (ScreenUtils.getScreenWidth(activity) * 3) / 5;
            if (j >= 10) {
                j = (j / 10) + 9;
            }
            int i = (int) j;
            ViewGroup.LayoutParams layoutParams = this.ll_voice_layout.getLayoutParams();
            if (i != 0) {
                screenWidth += ((screenWidth2 - screenWidth) / 15) * i;
            }
            layoutParams.width = screenWidth;
        }
    }

    public void checkBackground() {
        if (this.message.isVoideIsPlaying()) {
            resetAnim();
        } else {
            this.voicePlay.setImageResource(this.isRight ? ResourceUtils.getIdByName(this.mContext, i.f5112c, "sobot_pop_voice_send_anime_3") : ResourceUtils.getIdByName(this.mContext, i.f5112c, "sobot_pop_voice_receive_anime_3"));
        }
    }

    public void startAnim() {
        this.message.setVoideIsPlaying(true);
        Drawable drawable = this.voicePlay.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        } else {
            resetAnim();
        }
    }

    public void stopAnim() {
        this.message.setVoideIsPlaying(false);
        Drawable drawable = this.voicePlay.getDrawable();
        if (drawable == null || !(drawable instanceof AnimationDrawable)) {
            return;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        animationDrawable.stop();
        animationDrawable.selectDrawable(2);
    }
}
