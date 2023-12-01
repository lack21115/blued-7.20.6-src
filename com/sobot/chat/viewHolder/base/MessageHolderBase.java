package com.sobot.chat.viewHolder.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotUIConfig;
import com.sobot.chat.activity.SobotPhotoActivity;
import com.sobot.chat.adapter.SobotMsgAdapter;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.widget.ReSendDialog;
import com.sobot.chat.widget.SobotImageView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/base/MessageHolderBase.class */
public abstract class MessageHolderBase {
    protected FrameLayout frameLayout;
    private SobotImageView imgHead;
    protected boolean isRight = false;
    public Context mContext;
    protected View mItemView;
    public ZhiChiMessageBase message;
    public SobotMsgAdapter.SobotMsgCallBack msgCallBack;
    private TextView msgContentTV;
    protected ProgressBar msgProgressBar;
    protected ImageView msgStatus;
    public TextView name;
    public TextView reminde_time_Text;
    protected RelativeLayout rightEmptyRL;
    protected int sobot_chat_file_bgColor;
    protected View sobot_ll_content;
    protected LinearLayout sobot_ll_dislikeBtn;
    protected LinearLayout sobot_ll_hollow_container;
    protected LinearLayout sobot_ll_likeBtn;
    protected RelativeLayout sobot_rl_hollow_container;
    protected TextView sobot_tv_dislikeBtn;
    protected TextView sobot_tv_likeBtn;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/base/MessageHolderBase$ImageClickLisenter.class */
    public static class ImageClickLisenter implements View.OnClickListener {
        private Context context;
        private String imageUrl;
        private boolean isRight;

        public ImageClickLisenter(Context context, String str) {
            this.imageUrl = str;
            this.context = context;
        }

        public ImageClickLisenter(Context context, String str, boolean z) {
            this(context, str);
            this.isRight = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (TextUtils.isEmpty(this.imageUrl)) {
                Context context = this.context;
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_pic_type_error"));
            } else if (SobotOption.imagePreviewListener == null || !SobotOption.imagePreviewListener.onPreviewImage(this.context, this.imageUrl)) {
                Intent intent = new Intent(this.context, SobotPhotoActivity.class);
                intent.putExtra("imageUrL", this.imageUrl);
                boolean z = this.isRight;
                if (z) {
                    intent.putExtra("isRight", z);
                }
                this.context.startActivity(intent);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/base/MessageHolderBase$ReSendListener.class */
    public interface ReSendListener {
        void onReSend();
    }

    public MessageHolderBase(Context context, View view) {
        this.mItemView = view;
        this.mContext = context;
        this.reminde_time_Text = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_reminde_time_Text"));
        this.imgHead = (SobotImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_imgHead"));
        this.name = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_name"));
        this.frameLayout = (FrameLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_frame_layout"));
        this.msgProgressBar = (ProgressBar) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_msgProgressBar"));
        this.msgStatus = (ImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_msgStatus"));
        this.sobot_ll_content = view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_content"));
        this.sobot_rl_hollow_container = (RelativeLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_rl_hollow_container"));
        this.sobot_ll_hollow_container = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_hollow_container"));
        this.rightEmptyRL = (RelativeLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_right_empty_rl"));
        this.sobot_ll_likeBtn = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_likeBtn"));
        this.sobot_ll_dislikeBtn = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_dislikeBtn"));
        this.sobot_tv_likeBtn = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_likeBtn"));
        this.sobot_tv_dislikeBtn = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_dislikeBtn"));
        this.msgContentTV = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_msg"));
        this.sobot_chat_file_bgColor = ResourceUtils.getIdByName(this.mContext, "color", "sobot_chat_file_bgColor");
        applyCustomHeadUI();
    }

    private void applyCustomHeadUI() {
        SobotImageView sobotImageView = this.imgHead;
        if (sobotImageView != null) {
            sobotImageView.setCornerRadius(4);
        }
    }

    public static void showReSendDialog(Context context, ImageView imageView, final ReSendListener reSendListener) {
        int i = context.getResources().getDisplayMetrics().widthPixels == 480 ? 80 : 120;
        final ReSendDialog reSendDialog = new ReSendDialog(context);
        reSendDialog.setOnClickListener(new ReSendDialog.OnItemClick() { // from class: com.sobot.chat.viewHolder.base.MessageHolderBase.1
            @Override // com.sobot.chat.widget.ReSendDialog.OnItemClick
            public void OnClick(int i2) {
                if (i2 == 0) {
                    ReSendListener.this.onReSend();
                }
                reSendDialog.dismiss();
            }
        });
        reSendDialog.show();
        imageView.setClickable(true);
        Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
        if (reSendDialog.getWindow() != null) {
            WindowManager.LayoutParams attributes = reSendDialog.getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth() - i;
            reSendDialog.getWindow().setAttributes(attributes);
        }
    }

    public void applyCustomUI() {
        View view;
        View view2;
        if (isRight()) {
            if (-1 != SobotUIConfig.sobot_chat_right_bgColor && (view2 = this.sobot_ll_content) != null) {
                ScreenUtils.setBubbleBackGroud(this.mContext, view2, SobotUIConfig.sobot_chat_right_bgColor);
            }
        } else if (-1 != SobotUIConfig.sobot_chat_left_bgColor && (view = this.sobot_ll_content) != null) {
            ScreenUtils.setBubbleBackGroud(this.mContext, view, SobotUIConfig.sobot_chat_left_bgColor);
        }
        RelativeLayout relativeLayout = this.sobot_rl_hollow_container;
        if (relativeLayout != null && relativeLayout.getBackground() != null) {
            int i = -1 != SobotUIConfig.sobot_chat_file_bgColor ? SobotUIConfig.sobot_chat_file_bgColor : this.sobot_chat_file_bgColor;
            Drawable mutate = this.sobot_rl_hollow_container.getBackground().mutate();
            GradientDrawable gradientDrawable = mutate instanceof GradientDrawable ? (GradientDrawable) mutate : null;
            if (gradientDrawable != null) {
                gradientDrawable.setStroke(ScreenUtils.dip2px(this.mContext, 1.0f), this.mContext.getResources().getColor(i));
            }
        }
        LinearLayout linearLayout = this.sobot_ll_hollow_container;
        if (linearLayout == null || linearLayout.getBackground() == null) {
            return;
        }
        int i2 = -1 != SobotUIConfig.sobot_chat_file_bgColor ? SobotUIConfig.sobot_chat_file_bgColor : this.sobot_chat_file_bgColor;
        Drawable mutate2 = this.sobot_ll_hollow_container.getBackground().mutate();
        GradientDrawable gradientDrawable2 = null;
        if (mutate2 instanceof GradientDrawable) {
            gradientDrawable2 = (GradientDrawable) mutate2;
        }
        if (gradientDrawable2 != null) {
            gradientDrawable2.setStroke(ScreenUtils.dip2px(this.mContext, 1.0f), this.mContext.getResources().getColor(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyTextViewUIConfig(TextView textView) {
        if (textView != null) {
            if (isRight()) {
                if (-1 != SobotUIConfig.sobot_chat_right_textColor) {
                    textView.setTextColor(this.mContext.getResources().getColor(SobotUIConfig.sobot_chat_right_textColor));
                }
            } else if (-1 != SobotUIConfig.sobot_chat_left_textColor) {
                textView.setTextColor(this.mContext.getResources().getColor(SobotUIConfig.sobot_chat_left_textColor));
            }
        }
    }

    public abstract void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase);

    public void bindZhiChiMessageBase(ZhiChiMessageBase zhiChiMessageBase) {
        this.message = zhiChiMessageBase;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLinkTextColor() {
        return isRight() ? -1 != SobotUIConfig.sobot_chat_right_link_textColor ? SobotUIConfig.sobot_chat_right_link_textColor : ResourceUtils.getIdByName(this.mContext, "color", "sobot_color_rlink") : -1 != SobotUIConfig.sobot_chat_left_link_textColor ? SobotUIConfig.sobot_chat_left_link_textColor : ResourceUtils.getIdByName(this.mContext, "color", "sobot_color_link");
    }

    public void initNameAndFace(int i) {
        switch (i) {
            case 0:
            case 3:
            case 4:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 17:
            case 18:
            case 19:
            case 28:
                this.isRight = false;
                return;
            case 1:
            case 5:
            case 6:
            case 12:
            case 20:
            case 21:
            case 22:
            case 24:
            case 25:
                this.isRight = true;
                return;
            case 2:
            case 7:
            case 8:
            case 16:
            case 23:
            case 26:
            case 27:
            default:
                return;
        }
    }

    public boolean isRight() {
        return this.isRight;
    }

    public void setMsgCallBack(SobotMsgAdapter.SobotMsgCallBack sobotMsgCallBack) {
        this.msgCallBack = sobotMsgCallBack;
    }

    public void setRight(boolean z) {
        this.isRight = z;
    }
}
