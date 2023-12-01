package com.sobot.chat.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.SobotFileDetailActivity;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.SobotCacheFile;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.chat.widget.SobotSectorProgressView;
import com.sobot.network.http.model.SobotProgress;
import com.sobot.network.http.upload.SobotUpload;
import com.sobot.network.http.upload.SobotUploadListener;
import com.sobot.network.http.upload.SobotUploadModelBase;
import com.sobot.network.http.upload.SobotUploadTask;
import com.sobot.pictureframe.SobotBitmapUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/FileMessageHolder.class */
public class FileMessageHolder extends MessageHolderBase implements View.OnClickListener {
    private ZhiChiMessageBase mData;
    private int mResNetError;
    private int mResRemove;
    private String mTag;
    private TextView sobot_file_name;
    private TextView sobot_file_size;
    private RelativeLayout sobot_ll_file_container;
    private ImageView sobot_msgStatus;
    private SobotSectorProgressView sobot_progress;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/FileMessageHolder$ListUploadListener.class */
    static class ListUploadListener extends SobotUploadListener {
        private FileMessageHolder holder;

        ListUploadListener(Object obj, FileMessageHolder fileMessageHolder) {
            super(obj);
            this.holder = fileMessageHolder;
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

    public FileMessageHolder(Context context, View view) {
        super(context, view);
        this.sobot_progress = (SobotSectorProgressView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_progress"));
        this.sobot_file_name = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_file_name"));
        this.sobot_file_size = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_file_size"));
        this.sobot_msgStatus = (ImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_msgStatus"));
        this.sobot_ll_file_container = (RelativeLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_file_container"));
        this.mResNetError = ResourceUtils.getIdByName(context, i.f5112c, "sobot_re_send_selector");
        this.mResRemove = ResourceUtils.getIdByName(context, i.f5112c, "sobot_icon_remove");
        ImageView imageView = this.sobot_msgStatus;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.sobot_ll_file_container.setOnClickListener(this);
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
                this.msgProgressBar.setVisibility(8);
            }
        } else if (this.sobot_msgStatus == null) {
        } else {
            int i = sobotProgress.status;
            if (i == 0) {
                this.sobot_msgStatus.setVisibility(8);
                this.msgProgressBar.setVisibility(8);
            } else if (i == 1 || i == 2 || i == 3) {
                this.msgProgressBar.setVisibility(0);
                this.sobot_msgStatus.setVisibility(8);
                this.sobot_msgStatus.setBackgroundResource(this.mResRemove);
                this.sobot_msgStatus.setSelected(false);
            } else if (i != 4) {
                if (i != 5) {
                    return;
                }
                this.sobot_msgStatus.setVisibility(8);
                this.msgProgressBar.setVisibility(8);
            } else {
                this.sobot_msgStatus.setVisibility(0);
                this.sobot_msgStatus.setBackgroundResource(this.mResNetError);
                this.sobot_msgStatus.setSelected(true);
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
        this.sobot_file_name.setText(cacheFile.getFileName());
        this.sobot_file_size.setText(cacheFile.getFileSize());
        SobotBitmapUtil.display(this.mContext, ChatUtils.getFileIcon(this.mContext, cacheFile.getFileType()), this.sobot_progress);
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
            if (this.sobot_ll_file_container == view && zhiChiMessageBase.getAnswer() != null && this.mData.getAnswer().getCacheFile() != null) {
                Intent intent = new Intent(this.mContext, SobotFileDetailActivity.class);
                intent.putExtra(ZhiChiConstant.SOBOT_INTENT_DATA_SELECTED_FILE, this.mData.getAnswer().getCacheFile());
                intent.setFlags(268435456);
                this.mContext.startActivity(intent);
            }
            ImageView imageView = this.sobot_msgStatus;
            if (imageView == view) {
                if (imageView.isSelected()) {
                    showReSendDialog(this.mContext, this.msgStatus, new MessageHolderBase.ReSendListener() { // from class: com.sobot.chat.viewHolder.FileMessageHolder.1
                        @Override // com.sobot.chat.viewHolder.base.MessageHolderBase.ReSendListener
                        public void onReSend() {
                            SobotUploadTask<?> task = SobotUpload.getInstance().getTask(FileMessageHolder.this.mTag);
                            if (task != null) {
                                task.restart();
                            } else {
                                FileMessageHolder.this.notifyFileTaskRemove();
                            }
                        }
                    });
                    return;
                }
                if (SobotUpload.getInstance().hasTask(this.mTag)) {
                    SobotUpload.getInstance().getTask(this.mTag).remove();
                }
                notifyFileTaskRemove();
            }
        }
    }
}
