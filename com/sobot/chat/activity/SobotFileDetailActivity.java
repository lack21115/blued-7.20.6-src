package com.sobot.chat.activity;

import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.api.model.SobotCacheFile;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.FileOpenHelper;
import com.sobot.chat.utils.FileSizeUtil;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotPathManager;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.network.http.db.SobotDownloadManager;
import com.sobot.network.http.download.SobotDownload;
import com.sobot.network.http.download.SobotDownloadListener;
import com.sobot.network.http.download.SobotDownloadTask;
import com.sobot.network.http.model.SobotProgress;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotFileDetailActivity.class */
public class SobotFileDetailActivity extends SobotBaseActivity implements View.OnClickListener {
    private SobotCacheFile mCacheFile;
    private SobotDownloadListener mDownloadListener;
    private String mProgressStr;
    private SobotDownloadTask mTask;
    private TextView sobot_btn_cancel;
    private TextView sobot_btn_start;
    private TextView sobot_file_icon;
    private TextView sobot_file_name;
    private LinearLayout sobot_ll_progress;
    private ProgressBar sobot_pb_progress;
    private TextView sobot_tv_decribe;
    private TextView sobot_tv_file_size;
    private TextView sobot_tv_progress;

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI(SobotProgress sobotProgress) {
        int i = sobotProgress.status;
        if (i != 0) {
            if (i == 1) {
                showCommonUi();
                return;
            } else if (i == 2) {
                showLoadingUi(sobotProgress.fraction, sobotProgress.currentSize, sobotProgress.totalSize);
                return;
            } else if (i != 3 && i != 4) {
                if (i != 5) {
                    return;
                }
                showFinishUi();
                this.mCacheFile.setFilePath(sobotProgress.filePath);
                return;
            }
        }
        showCommonUi();
    }

    private void restoreTask() {
        SobotProgress sobotProgress = SobotDownloadManager.getInstance().get(this.mCacheFile.getMsgId());
        if (sobotProgress == null) {
            showCommonUi();
            return;
        }
        SobotDownloadTask register = SobotDownload.restore(sobotProgress).register(this.mDownloadListener);
        this.mTask = register;
        refreshUI(register.progress);
    }

    private void showCommonUi() {
        this.sobot_btn_start.setSelected(false);
        this.sobot_btn_start.setText(getResString("sobot_file_download"));
        this.sobot_tv_file_size.setVisibility(0);
        this.sobot_tv_progress.setVisibility(8);
        this.sobot_btn_start.setVisibility(0);
        this.sobot_tv_decribe.setVisibility(8);
        this.sobot_ll_progress.setVisibility(8);
    }

    private void showFinishUi() {
        this.sobot_tv_file_size.setVisibility(0);
        this.sobot_tv_progress.setVisibility(8);
        this.sobot_btn_start.setText(getResString("sobot_file_open"));
        this.sobot_btn_start.setVisibility(0);
        this.sobot_tv_decribe.setVisibility(0);
        this.sobot_ll_progress.setVisibility(8);
        this.sobot_btn_start.setSelected(true);
    }

    private void showLoadingUi(float f, long j, long j2) {
        this.sobot_btn_start.setVisibility(8);
        this.sobot_tv_decribe.setVisibility(8);
        this.sobot_tv_file_size.setVisibility(8);
        this.sobot_tv_progress.setVisibility(0);
        this.sobot_ll_progress.setVisibility(0);
        String formatFileSize = Formatter.formatFileSize(this, j);
        String formatFileSize2 = Formatter.formatFileSize(this, j2);
        TextView textView = this.sobot_tv_progress;
        textView.setText(this.mProgressStr + "…(" + formatFileSize + BridgeUtil.SPLIT_MARK + formatFileSize2 + ")");
        this.sobot_pb_progress.setProgress((int) (f * 100.0f));
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_file_detail");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        try {
            SobotCacheFile sobotCacheFile = (SobotCacheFile) getIntent().getSerializableExtra(ZhiChiConstant.SOBOT_INTENT_DATA_SELECTED_FILE);
            this.mCacheFile = sobotCacheFile;
            if (sobotCacheFile == null || TextUtils.isEmpty(sobotCacheFile.getMsgId())) {
                return;
            }
            this.sobot_file_icon.setBackgroundResource(ChatUtils.getFileIcon(getApplicationContext(), this.mCacheFile.getFileType()));
            this.sobot_file_name.setText(this.mCacheFile.getFileName());
            if (TextUtils.isEmpty(this.mCacheFile.getFileSize())) {
                FileSizeUtil.getFileUrlSize(this.mCacheFile.getUrl(), new FileSizeUtil.CallBack<String>() { // from class: com.sobot.chat.activity.SobotFileDetailActivity.2
                    @Override // com.sobot.chat.utils.FileSizeUtil.CallBack
                    public void call(final String str) {
                        SobotFileDetailActivity.this.runOnUiThread(new Runnable() { // from class: com.sobot.chat.activity.SobotFileDetailActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SobotFileDetailActivity.this.mCacheFile.setFileSize(str);
                                TextView textView = SobotFileDetailActivity.this.sobot_tv_file_size;
                                textView.setText(SobotFileDetailActivity.this.getResString("sobot_file_size") + "：" + SobotFileDetailActivity.this.mCacheFile.getFileSize());
                            }
                        });
                    }
                });
            } else {
                TextView textView = this.sobot_tv_file_size;
                textView.setText(getResString("sobot_file_size") + "：" + this.mCacheFile.getFileSize());
            }
            SobotDownload.getInstance().setFolder(SobotPathManager.getInstance().getCacheDir());
            if (TextUtils.isEmpty(this.mCacheFile.getFilePath())) {
                restoreTask();
            } else {
                showFinishUi();
            }
        } catch (Exception e) {
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        setTitle(getResString("sobot_file_preview"));
        showLeftMenu(getResDrawableId("sobot_btn_back_selector"), "", true);
        this.sobot_file_icon = (TextView) findViewById(getResId("sobot_file_icon"));
        this.sobot_file_name = (TextView) findViewById(getResId("sobot_file_name"));
        this.sobot_tv_file_size = (TextView) findViewById(getResId("sobot_tv_file_size"));
        this.sobot_tv_progress = (TextView) findViewById(getResId("sobot_tv_progress"));
        TextView textView = (TextView) findViewById(getResId("sobot_btn_start"));
        this.sobot_btn_start = textView;
        textView.setText(ResourceUtils.getResString(this, "sobot_file_download"));
        this.sobot_ll_progress = (LinearLayout) findViewById(getResId("sobot_ll_progress"));
        this.sobot_pb_progress = (ProgressBar) findViewById(getResId("sobot_pb_progress"));
        this.sobot_btn_cancel = (TextView) findViewById(getResId("sobot_btn_cancel"));
        this.sobot_tv_decribe = (TextView) findViewById(getResId("sobot_tv_decribe"));
        this.mProgressStr = getResString("sobot_file_downloading");
        this.sobot_btn_start.setOnClickListener(this);
        this.sobot_btn_cancel.setOnClickListener(this);
        this.mDownloadListener = new SobotDownloadListener(SobotDownload.CancelTagType.SOBOT_TAG_DOWNLOAD_ACT) { // from class: com.sobot.chat.activity.SobotFileDetailActivity.1
            @Override // com.sobot.network.http.upload.ProgressListener
            public void onError(SobotProgress sobotProgress) {
                SobotFileDetailActivity.this.refreshUI(sobotProgress);
            }

            @Override // com.sobot.network.http.upload.ProgressListener
            public void onFinish(File file, SobotProgress sobotProgress) {
                SobotFileDetailActivity.this.refreshUI(sobotProgress);
            }

            @Override // com.sobot.network.http.upload.ProgressListener
            public void onProgress(SobotProgress sobotProgress) {
                SobotFileDetailActivity.this.refreshUI(sobotProgress);
            }

            @Override // com.sobot.network.http.upload.ProgressListener
            public void onRemove(SobotProgress sobotProgress) {
            }

            @Override // com.sobot.network.http.upload.ProgressListener
            public void onStart(SobotProgress sobotProgress) {
                SobotFileDetailActivity.this.refreshUI(sobotProgress);
            }
        };
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_btn_cancel) {
            showCommonUi();
            SobotDownloadTask sobotDownloadTask = this.mTask;
            if (sobotDownloadTask != null) {
                sobotDownloadTask.remove(true);
            }
        }
        if (view == this.sobot_btn_start && checkStoragePermission()) {
            if (!this.sobot_btn_start.isSelected()) {
                SobotDownloadTask sobotDownloadTask2 = this.mTask;
                if (sobotDownloadTask2 != null) {
                    if (sobotDownloadTask2.progress.isUpload) {
                        this.mTask.remove(true);
                    } else {
                        this.mTask.progress.request = HttpUtils.getInstance().obtainGetRequest(this.mCacheFile.getUrl(), null);
                    }
                }
                SobotDownloadTask addDownloadFileTask = HttpUtils.getInstance().addDownloadFileTask(this.mCacheFile.getMsgId(), this.mCacheFile.getUrl(), this.mCacheFile.getFileName(), null);
                this.mTask = addDownloadFileTask;
                if (addDownloadFileTask != null) {
                    addDownloadFileTask.register(this.mDownloadListener).start();
                }
            } else if (this.mCacheFile != null) {
                File file = new File(this.mCacheFile.getFilePath());
                if (file.exists()) {
                    FileOpenHelper.openFileWithType(getApplicationContext(), file);
                    return;
                }
                showCommonUi();
                this.mCacheFile.setFilePath(null);
                SobotDownloadTask sobotDownloadTask3 = this.mTask;
                if (sobotDownloadTask3 != null) {
                    sobotDownloadTask3.remove(true);
                }
            }
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SobotDownload.getInstance().unRegister(SobotDownload.CancelTagType.SOBOT_TAG_DOWNLOAD_ACT);
        SobotDownloadTask sobotDownloadTask = this.mTask;
        if (sobotDownloadTask != null && (sobotDownloadTask.progress.status == 5 || this.mTask.progress.status == 0 || this.mTask.progress.status == 4)) {
            SobotDownload.getInstance().removeTask(this.mTask.progress.tag);
        }
        super.onDestroy();
    }
}
