package com.sobot.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.api.model.SobotCacheFile;
import com.sobot.chat.application.MyApplication;
import com.sobot.chat.camera.StVideoView;
import com.sobot.chat.camera.listener.StVideoListener;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotPathManager;
import com.sobot.network.http.HttpBaseUtils;
import com.sobot.network.http.db.SobotDownloadManager;
import com.sobot.network.http.download.SobotDownload;
import com.sobot.network.http.download.SobotDownloadListener;
import com.sobot.network.http.download.SobotDownloadTask;
import com.sobot.network.http.model.SobotProgress;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotVideoActivity.class */
public class SobotVideoActivity extends FragmentActivity implements View.OnClickListener {
    public static final int ACTION_TYPE_PHOTO = 0;
    public static final int ACTION_TYPE_VIDEO = 1;
    private static final String EXTRA_IMAGE_FILE_PATH = "EXTRA_IMAGE_FILE_PATH";
    private static final String EXTRA_VIDEO_FILE_DATA = "EXTRA_VIDEO_FILE_DATA";
    private static final String EXTRA_VIDEO_FILE_PATH = "EXTRA_VIDEO_FILE_PATH";
    private static final int RESULT_CODE = 103;
    private static final String SOBOT_TAG_DOWNLOAD_ACT_VIDEO = "SOBOT_TAG_DOWNLOAD_ACT_VIDEO";
    private SobotCacheFile mCacheFile;
    private SobotDownloadListener mDownloadListener;
    private SobotDownloadTask mTask;
    private StVideoView mVideoView;
    private ProgressBar progressBar;
    private ImageView st_iv_pic;
    private TextView st_tv_play;

    private void downloadFile(SobotProgress sobotProgress) {
        if (sobotProgress != null) {
            SobotDownloadTask restore = SobotDownload.restore(sobotProgress);
            this.mTask = restore;
            if (restore != null) {
                restore.remove(true);
            }
        }
        SobotDownloadTask addDownloadFileTask = HttpBaseUtils.getInstance().addDownloadFileTask(this.mCacheFile.getMsgId(), this.mCacheFile.getUrl(), this.mCacheFile.getFileName(), null, null);
        this.mTask = addDownloadFileTask;
        if (addDownloadFileTask != null) {
            addDownloadFileTask.register(this.mDownloadListener).start();
        }
    }

    private void initData() {
        try {
            SobotCacheFile sobotCacheFile = (SobotCacheFile) getIntent().getSerializableExtra(EXTRA_VIDEO_FILE_DATA);
            this.mCacheFile = sobotCacheFile;
            if (sobotCacheFile == null || TextUtils.isEmpty(sobotCacheFile.getMsgId())) {
                return;
            }
            SobotDownload.getInstance().setFolder(SobotPathManager.getInstance().getVideoDir());
            if (TextUtils.isEmpty(this.mCacheFile.getFilePath())) {
                restoreTask();
            } else {
                showFinishUi(this.mCacheFile.getFilePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Intent newIntent(Context context, SobotCacheFile sobotCacheFile) {
        if (sobotCacheFile == null) {
            return null;
        }
        Intent intent = new Intent(context, SobotVideoActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(EXTRA_VIDEO_FILE_DATA, sobotCacheFile);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI(SobotProgress sobotProgress) {
        int i = sobotProgress.status;
        if (i == 0 || i == 1) {
            this.st_tv_play.setVisibility(8);
            this.progressBar.setVisibility(0);
            this.st_iv_pic.setVisibility(0);
            SobotBitmapUtil.display(this, this.mCacheFile.getSnapshot(), this.st_iv_pic, 0, 0);
        } else if (i == 2 || i == 3) {
            showLoadingUi(sobotProgress.fraction, sobotProgress.currentSize, sobotProgress.totalSize);
        } else if (i == 4) {
            SobotDownload.getInstance().removeTask(sobotProgress.tag);
            showErrorUi();
        } else if (i != 5) {
        } else {
            this.mCacheFile.setFilePath(sobotProgress.filePath);
            showFinishUi(sobotProgress.filePath);
        }
    }

    private void restoreTask() {
        SobotProgress sobotProgress = SobotDownloadManager.getInstance().get(this.mCacheFile.getMsgId());
        if (sobotProgress == null) {
            downloadFile(null);
        } else if (sobotProgress.status != 5) {
            downloadFile(sobotProgress);
        } else if (TextUtils.isEmpty(sobotProgress.filePath) || !new File(sobotProgress.filePath).exists()) {
            downloadFile(sobotProgress);
        } else {
            refreshUI(sobotProgress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorUi() {
        this.st_tv_play.setVisibility(8);
        this.progressBar.setVisibility(0);
        this.st_iv_pic.setVisibility(0);
        SobotBitmapUtil.display(this, this.mCacheFile.getSnapshot(), this.st_iv_pic, 0, 0);
    }

    private void showFinishUi(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            this.st_tv_play.setVisibility(8);
            this.progressBar.setVisibility(8);
            this.st_iv_pic.setVisibility(8);
            this.mVideoView.setVideoPath(str);
            this.mVideoView.playVideo();
        }
    }

    private void showLoadingUi(float f, long j, long j2) {
        this.st_tv_play.setVisibility(8);
        this.progressBar.setVisibility(0);
        this.st_iv_pic.setVisibility(0);
        SobotBitmapUtil.display(this, this.mCacheFile.getSnapshot(), this.st_iv_pic, 0, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        TextView textView = this.st_tv_play;
        if (view == textView) {
            textView.setSelected(!textView.isSelected());
            this.mVideoView.switchVideoPlay(this.st_tv_play.isSelected());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setRequestedOrientation(1);
        setContentView(ResourceUtils.getResLayoutId(getApplicationContext(), "sobot_activity_video"));
        MyApplication.getInstance().addActivity(this);
        this.mVideoView = (StVideoView) findViewById(ResourceUtils.getResId(getApplicationContext(), "sobot_videoview"));
        this.st_tv_play = (TextView) findViewById(ResourceUtils.getResId(getApplicationContext(), "st_tv_play"));
        this.st_iv_pic = (ImageView) findViewById(ResourceUtils.getResId(getApplicationContext(), "st_iv_pic"));
        this.progressBar = (ProgressBar) findViewById(ResourceUtils.getResId(getApplicationContext(), "sobot_msgProgressBar"));
        this.st_tv_play.setOnClickListener(this);
        this.mDownloadListener = new SobotDownloadListener(SOBOT_TAG_DOWNLOAD_ACT_VIDEO) { // from class: com.sobot.chat.activity.SobotVideoActivity.1
            @Override // com.sobot.network.http.upload.ProgressListener
            public void onError(SobotProgress sobotProgress) {
                SobotVideoActivity.this.refreshUI(sobotProgress);
            }

            @Override // com.sobot.network.http.upload.ProgressListener
            public void onFinish(File file, SobotProgress sobotProgress) {
                SobotVideoActivity.this.refreshUI(sobotProgress);
            }

            @Override // com.sobot.network.http.upload.ProgressListener
            public void onProgress(SobotProgress sobotProgress) {
                SobotVideoActivity.this.refreshUI(sobotProgress);
            }

            @Override // com.sobot.network.http.upload.ProgressListener
            public void onRemove(SobotProgress sobotProgress) {
            }

            @Override // com.sobot.network.http.upload.ProgressListener
            public void onStart(SobotProgress sobotProgress) {
                SobotVideoActivity.this.refreshUI(sobotProgress);
            }
        };
        initData();
        this.mVideoView.setVideoLisenter(new StVideoListener() { // from class: com.sobot.chat.activity.SobotVideoActivity.2
            @Override // com.sobot.chat.camera.listener.StVideoListener
            public void onCancel() {
                SobotVideoActivity.this.finish();
            }

            @Override // com.sobot.chat.camera.listener.StVideoListener
            public void onEnd() {
                LogUtils.i("progress---onEnd");
                SobotVideoActivity.this.st_tv_play.setVisibility(0);
            }

            @Override // com.sobot.chat.camera.listener.StVideoListener
            public void onError() {
                SobotVideoActivity.this.showErrorUi();
            }

            @Override // com.sobot.chat.camera.listener.StVideoListener
            public void onStart() {
                SobotVideoActivity.this.st_tv_play.setVisibility(8);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MyApplication.getInstance().deleteActivity(this);
        SobotDownload.getInstance().unRegister(SOBOT_TAG_DOWNLOAD_ACT_VIDEO);
        SobotDownloadTask sobotDownloadTask = this.mTask;
        if (sobotDownloadTask != null && (sobotDownloadTask.progress.status == 5 || this.mTask.progress.status == 0 || this.mTask.progress.status == 3 || this.mTask.progress.status == 4)) {
            SobotDownload.getInstance().removeTask(this.mTask.progress.tag);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.mVideoView.onPause();
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mVideoView.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(5380);
        } else if (Build.VERSION.SDK_INT >= 16) {
            getWindow().getDecorView().setSystemUiVisibility(4);
        }
    }
}
