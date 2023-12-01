package com.sobot.chat.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.SobotVideoActivity;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.SobotCacheFile;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.chat.widget.RoundProgressBar;
import com.sobot.chat.widget.image.SobotRCImageView;
import com.sobot.network.http.model.SobotProgress;
import com.sobot.network.http.upload.SobotUpload;
import com.sobot.network.http.upload.SobotUploadListener;
import com.sobot.network.http.upload.SobotUploadModelBase;
import com.sobot.network.http.upload.SobotUploadTask;
import com.sobot.pictureframe.SobotBitmapUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/VideoMessageHolder.class */
public class VideoMessageHolder extends MessageHolderBase implements View.OnClickListener {
    private ZhiChiMessageBase mData;
    private String mTag;
    private int sobot_bg_default_pic;
    private ImageView sobot_msgStatus;
    private RoundProgressBar sobot_progress;
    private SobotRCImageView st_iv_pic;
    private ImageView st_tv_play;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/VideoMessageHolder$ListUploadListener.class */
    static class ListUploadListener extends SobotUploadListener {
        private VideoMessageHolder holder;

        ListUploadListener(Object obj, VideoMessageHolder videoMessageHolder) {
            super(obj);
            this.holder = videoMessageHolder;
        }

        @Override // com.sobot.network.http.upload.ProgressListener
        public void onError(SobotProgress sobotProgress) {
            if (this.tag == this.holder.getTag()) {
                this.holder.refreshUploadUi(sobotProgress);
            }
        }

        @Override // com.sobot.network.http.upload.ProgressListener
        public void onFinish(SobotUploadModelBase sobotUploadModelBase, SobotProgress sobotProgress) {
            if (this.tag == this.holder.getTag()) {
                this.holder.refreshUploadUi(sobotProgress);
            }
        }

        @Override // com.sobot.network.http.upload.ProgressListener
        public void onProgress(SobotProgress sobotProgress) {
            if (this.tag == this.holder.getTag()) {
                this.holder.refreshUploadUi(sobotProgress);
            }
        }

        @Override // com.sobot.network.http.upload.ProgressListener
        public void onRemove(SobotProgress sobotProgress) {
        }

        @Override // com.sobot.network.http.upload.ProgressListener
        public void onStart(SobotProgress sobotProgress) {
        }
    }

    public VideoMessageHolder(Context context, View view) {
        super(context, view);
        this.sobot_progress = (RoundProgressBar) view.findViewById(ResourceUtils.getResId(context, "sobot_pic_progress_round"));
        this.sobot_msgStatus = (ImageView) view.findViewById(ResourceUtils.getResId(context, "sobot_msgStatus"));
        this.st_tv_play = (ImageView) view.findViewById(ResourceUtils.getResId(context, "st_tv_play"));
        this.st_iv_pic = (SobotRCImageView) view.findViewById(ResourceUtils.getResId(context, "st_iv_pic"));
        this.sobot_bg_default_pic = ResourceUtils.getDrawableId(context, "sobot_bg_default_pic");
        this.sobot_progress.setTextDisplayable(false);
        ImageView imageView = this.sobot_msgStatus;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.st_tv_play.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTag() {
        return this.mTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFileTaskRemove() {
        Intent intent = new Intent(ZhiChiConstants.SOBOT_BROCAST_REMOVE_FILE_TASK);
        intent.putExtra("sobot_msgId", this.mTag);
        CommonUtils.sendLocalBroadcast(this.mContext, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUploadUi(SobotProgress sobotProgress) {
        if (sobotProgress == null) {
            ImageView imageView = this.sobot_msgStatus;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            this.sobot_progress.setProgress(100);
            this.sobot_progress.setVisibility(8);
            this.msgProgressBar.setVisibility(8);
            this.st_tv_play.setVisibility(0);
        } else if (this.sobot_msgStatus == null) {
        } else {
            int i = sobotProgress.status;
            if (i == 0) {
                this.sobot_msgStatus.setVisibility(8);
                this.st_tv_play.setVisibility(0);
                this.sobot_progress.setProgress((int) (sobotProgress.fraction * 100.0f));
            } else if (i == 1 || i == 2 || i == 3) {
                this.st_tv_play.setVisibility(8);
                this.sobot_msgStatus.setVisibility(8);
                this.sobot_progress.setProgress((int) (sobotProgress.fraction * 100.0f));
                this.sobot_progress.setVisibility(8);
                this.msgProgressBar.setVisibility(0);
            } else if (i == 4) {
                this.st_tv_play.setVisibility(0);
                this.sobot_msgStatus.setVisibility(0);
                this.sobot_progress.setProgress(100);
                this.sobot_progress.setVisibility(8);
                this.msgProgressBar.setVisibility(8);
            } else if (i != 5) {
            } else {
                this.st_tv_play.setVisibility(0);
                this.sobot_msgStatus.setVisibility(8);
                this.sobot_progress.setProgress(100);
                this.sobot_progress.setVisibility(8);
                this.msgProgressBar.setVisibility(8);
            }
        }
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.mData = zhiChiMessageBase;
        if (zhiChiMessageBase.getAnswer() == null || zhiChiMessageBase.getAnswer().getCacheFile() == null) {
            return;
        }
        SobotCacheFile cacheFile = zhiChiMessageBase.getAnswer().getCacheFile();
        Context context2 = this.mContext;
        String snapshot = cacheFile.getSnapshot();
        SobotRCImageView sobotRCImageView = this.st_iv_pic;
        int i = this.sobot_bg_default_pic;
        SobotBitmapUtil.display(context2, snapshot, sobotRCImageView, i, i);
        this.mTag = cacheFile.getMsgId();
        if (!this.isRight) {
            refreshUploadUi(null);
        } else if (!SobotUpload.getInstance().hasTask(this.mTag)) {
            refreshUploadUi(null);
        } else {
            SobotUploadTask<?> task = SobotUpload.getInstance().getTask(this.mTag);
            task.register(new ListUploadListener(this.mTag, this));
            refreshUploadUi(task.progress);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        ZhiChiMessageBase zhiChiMessageBase = this.mData;
        if (zhiChiMessageBase != null) {
            if (this.st_tv_play == view && zhiChiMessageBase.getAnswer() != null && this.mData.getAnswer().getCacheFile() != null) {
                this.mContext.startActivity(SobotVideoActivity.newIntent(this.mContext, this.mData.getAnswer().getCacheFile()));
            }
            if (this.sobot_msgStatus == view) {
                showReSendDialog(this.mContext, this.msgStatus, new MessageHolderBase.ReSendListener() { // from class: com.sobot.chat.viewHolder.VideoMessageHolder.1
                    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase.ReSendListener
                    public void onReSend() {
                        SobotUploadTask<?> task = SobotUpload.getInstance().getTask(VideoMessageHolder.this.mTag);
                        if (task != null) {
                            task.restart();
                        } else {
                            VideoMessageHolder.this.notifyFileTaskRemove();
                        }
                    }
                });
            }
        }
    }
}
