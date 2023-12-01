package com.sobot.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.application.MyApplication;
import com.sobot.chat.camera.StCameraView;
import com.sobot.chat.camera.listener.StCameraListener;
import com.sobot.chat.camera.listener.StClickListener;
import com.sobot.chat.camera.listener.StErrorListener;
import com.sobot.chat.camera.util.FileUtil;
import com.sobot.chat.listener.PermissionListenerImpl;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotPathManager;
import com.sobot.chat.widget.statusbar.StatusBarCompat;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotCameraActivity.class */
public class SobotCameraActivity extends SobotBaseActivity {
    public static final int ACTION_TYPE_PHOTO = 0;
    public static final int ACTION_TYPE_VIDEO = 1;
    private static final String EXTRA_ACTION_TYPE = "EXTRA_ACTION_TYPE";
    private static final String EXTRA_IMAGE_FILE_PATH = "EXTRA_IMAGE_FILE_PATH";
    private static final String EXTRA_VIDEO_FILE_PATH = "EXTRA_VIDEO_FILE_PATH";
    private static final int RESULT_CODE = 103;
    private StCameraView jCameraView;

    public static int getActionType(Intent intent) {
        return intent.getIntExtra(EXTRA_ACTION_TYPE, 0);
    }

    public static String getSelectedImage(Intent intent) {
        return intent.getStringExtra(EXTRA_IMAGE_FILE_PATH);
    }

    public static String getSelectedVideo(Intent intent) {
        return intent.getStringExtra(EXTRA_VIDEO_FILE_PATH);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, SobotCameraActivity.class);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_camera");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        StCameraView stCameraView = (StCameraView) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_cameraview"));
        this.jCameraView = stCameraView;
        stCameraView.setSaveVideoPath(SobotPathManager.getInstance().getVideoDir());
        this.jCameraView.setFeatures(259);
        this.jCameraView.setTip(ResourceUtils.getResString(this, "sobot_tap_hold_camera"));
        this.jCameraView.setMediaQuality(StCameraView.MEDIA_QUALITY_MIDDLE);
        this.jCameraView.setErrorLisenter(new StErrorListener() { // from class: com.sobot.chat.activity.SobotCameraActivity.1
            @Override // com.sobot.chat.camera.listener.StErrorListener
            public void AudioPermissionError() {
                SobotCameraActivity.this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.activity.SobotCameraActivity.1.1
                };
                SobotCameraActivity sobotCameraActivity = SobotCameraActivity.this;
                if (sobotCameraActivity.checkIsShowPermissionPop(sobotCameraActivity.getResString("sobot_microphone"), SobotCameraActivity.this.getResString("sobot_microphone_yongtu"), 2)) {
                    return;
                }
                SobotCameraActivity.this.checkAudioPermission();
            }

            @Override // com.sobot.chat.camera.listener.StErrorListener
            public void onError() {
                SobotCameraActivity.this.finish();
            }
        });
        this.jCameraView.setJCameraLisenter(new StCameraListener() { // from class: com.sobot.chat.activity.SobotCameraActivity.2
            @Override // com.sobot.chat.camera.listener.StCameraListener
            public void captureSuccess(Bitmap bitmap) {
                Intent intent = new Intent();
                intent.putExtra(SobotCameraActivity.EXTRA_ACTION_TYPE, 0);
                if (bitmap != null) {
                    intent.putExtra(SobotCameraActivity.EXTRA_IMAGE_FILE_PATH, FileUtil.saveBitmap(100, bitmap));
                }
                SobotCameraActivity.this.setResult(103, intent);
                SobotCameraActivity.this.finish();
            }

            @Override // com.sobot.chat.camera.listener.StCameraListener
            public void recordSuccess(String str, Bitmap bitmap) {
                Intent intent = new Intent();
                intent.putExtra(SobotCameraActivity.EXTRA_ACTION_TYPE, 1);
                if (bitmap != null) {
                    intent.putExtra(SobotCameraActivity.EXTRA_IMAGE_FILE_PATH, FileUtil.saveBitmap(80, bitmap));
                }
                intent.putExtra(SobotCameraActivity.EXTRA_VIDEO_FILE_PATH, str);
                SobotCameraActivity.this.setResult(103, intent);
                SobotCameraActivity.this.finish();
            }
        });
        this.jCameraView.setLeftClickListener(new StClickListener() { // from class: com.sobot.chat.activity.SobotCameraActivity.3
            @Override // com.sobot.chat.camera.listener.StClickListener
            public void onClick() {
                SobotCameraActivity.this.finish();
            }
        });
        StatusBarCompat.setNavigationBarColor(this, 855638016);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setRequestedOrientation(1);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MyApplication.getInstance().deleteActivity(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jCameraView.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jCameraView.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } else if (Build.VERSION.SDK_INT >= 16) {
            getWindow().getDecorView().setSystemUiVisibility(4);
        }
    }
}
