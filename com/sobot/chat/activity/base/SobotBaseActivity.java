package com.sobot.chat.activity.base;

import android.Manifest;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.anythink.expressad.foundation.h.i;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotApi;
import com.sobot.chat.SobotUIConfig;
import com.sobot.chat.ZCSobotApi;
import com.sobot.chat.activity.SobotCameraActivity;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.application.MyApplication;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.listener.PermissionListener;
import com.sobot.chat.listener.PermissionListenerImpl;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.NotchScreenManager;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.widget.dialog.SobotPermissionTipDialog;
import com.sobot.chat.widget.image.SobotRCImageView;
import com.sobot.chat.widget.statusbar.StatusBarCompat;
import java.io.File;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/base/SobotBaseActivity.class */
public abstract class SobotBaseActivity extends FragmentActivity {
    protected File cameraFile;
    private int initMode;
    public PermissionListener permissionListener;
    public ZhiChiApi zhiChiApi;

    private void applyTitleUIConfig(TextView textView) {
        if (textView == null) {
            return;
        }
        if (-1 != SobotUIConfig.sobot_titleTextColor) {
            textView.setTextColor(getResources().getColor(SobotUIConfig.sobot_titleTextColor));
        }
        if (SobotUIConfig.sobot_head_title_is_bold) {
            return;
        }
        textView.setTypeface(null, 0);
    }

    public static boolean isCameraCanUse() {
        Camera camera;
        boolean z = false;
        try {
            camera = Camera.open(0);
            try {
                camera.setParameters(camera.getParameters());
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            camera = null;
        }
        if (camera != null) {
            camera.release();
            z = true;
        }
        return z;
    }

    public void changeAppLanguage() {
        Locale locale = (Locale) SharedPreferencesUtil.getObject(this, "SobotLanguage");
        if (locale != null) {
            try {
                Resources resources = getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                Configuration configuration = new Configuration();
                configuration.locale = locale;
                resources.updateConfiguration(configuration, displayMetrics);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkAudioPermission() {
        if (Build.VERSION.SDK_INT < 23 || CommonUtils.getTargetSdkVersion(getSobotBaseActivity().getApplicationContext()) < 23 || ContextCompat.checkSelfPermission(getSobotBaseActivity(), Manifest.permission.RECORD_AUDIO) == 0) {
            return true;
        }
        requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 193);
        return false;
    }

    public boolean checkCameraPermission() {
        if (Build.VERSION.SDK_INT < 23 || CommonUtils.getTargetSdkVersion(getSobotBaseActivity().getApplicationContext()) < 23 || ContextCompat.checkSelfPermission(getSobotBaseActivity(), Manifest.permission.CAMERA) == 0) {
            return true;
        }
        requestPermissions(new String[]{Manifest.permission.CAMERA}, 193);
        return false;
    }

    public boolean checkIsShowPermissionPop(String str, String str2, final int i) {
        if (!ZCSobotApi.getSwitchMarkStatus(16) || isHasPermission(i)) {
            return false;
        }
        new SobotPermissionTipDialog(getSobotBaseActivity(), str, str2, new SobotPermissionTipDialog.ClickViewListener() { // from class: com.sobot.chat.activity.base.SobotBaseActivity.7
            @Override // com.sobot.chat.widget.dialog.SobotPermissionTipDialog.ClickViewListener
            public void clickLeftView(Context context, SobotPermissionTipDialog sobotPermissionTipDialog) {
                sobotPermissionTipDialog.dismiss();
            }

            @Override // com.sobot.chat.widget.dialog.SobotPermissionTipDialog.ClickViewListener
            public void clickRightView(Context context, SobotPermissionTipDialog sobotPermissionTipDialog) {
                sobotPermissionTipDialog.dismiss();
                int i2 = i;
                if (i2 == 1) {
                    if (SobotBaseActivity.this.checkStoragePermission()) {
                    }
                } else if (i2 == 2) {
                    if (SobotBaseActivity.this.checkAudioPermission()) {
                    }
                } else {
                    if (i2 != 3 || !SobotBaseActivity.this.checkCameraPermission()) {
                    }
                }
            }
        }).show();
        return true;
    }

    public boolean checkStoragePermission() {
        if ((Build.VERSION.SDK_INT < 29 || CommonUtils.getTargetSdkVersion(getSobotBaseActivity().getApplicationContext()) < 29) && Build.VERSION.SDK_INT >= 23 && CommonUtils.getTargetSdkVersion(getSobotBaseActivity().getApplicationContext()) >= 23) {
            if (ContextCompat.checkSelfPermission(getSobotBaseActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 193);
                return false;
            } else if (ContextCompat.checkSelfPermission(getSobotBaseActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 193);
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public void displayInNotch(final View view) {
        if (SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4) && view != null) {
            NotchScreenManager.getInstance().getNotchInfo(this, new INotchScreen.NotchScreenCallback() { // from class: com.sobot.chat.activity.base.SobotBaseActivity.1
                @Override // com.sobot.chat.notchlib.INotchScreen.NotchScreenCallback
                public void onResult(INotchScreen.NotchScreenInfo notchScreenInfo) {
                    if (notchScreenInfo.hasNotch) {
                        for (Rect rect : notchScreenInfo.notchRects) {
                            View view2 = view;
                            if ((view2 instanceof WebView) && (view2.getParent() instanceof LinearLayout)) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                                layoutParams.rightMargin = (rect.right > 110 ? 110 : rect.right) + 14;
                                layoutParams.leftMargin = (rect.right <= 110 ? rect.right : 110) + 14;
                                view.setLayoutParams(layoutParams);
                            } else {
                                View view3 = view;
                                if ((view3 instanceof WebView) && (view3.getParent() instanceof RelativeLayout)) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                                    layoutParams2.rightMargin = (rect.right > 110 ? 110 : rect.right) + 14;
                                    layoutParams2.leftMargin = (rect.right <= 110 ? rect.right : 110) + 14;
                                    view.setLayoutParams(layoutParams2);
                                } else {
                                    View view4 = view;
                                    int i = rect.right > 110 ? 110 : rect.right;
                                    int paddingLeft = view.getPaddingLeft();
                                    view4.setPadding(i + paddingLeft, view.getPaddingTop(), (rect.right <= 110 ? rect.right : 110) + view.getPaddingRight(), view.getPaddingBottom());
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    protected SobotRCImageView getAvatarMenu() {
        return (SobotRCImageView) findViewById(getResId("sobot_avatar_iv"));
    }

    protected abstract int getContentViewResId();

    /* JADX INFO: Access modifiers changed from: protected */
    public TextView getLeftMenu() {
        return (TextView) findViewById(getResId("sobot_tv_left"));
    }

    public int getResColor(String str) {
        int resColorId = getResColorId(str);
        if (resColorId != 0) {
            return getResources().getColor(resColorId);
        }
        return 0;
    }

    public int getResColorId(String str) {
        return ResourceUtils.getIdByName(this, "color", str);
    }

    public int getResDrawableId(String str) {
        return ResourceUtils.getIdByName(this, i.f7952c, str);
    }

    public int getResId(String str) {
        return ResourceUtils.getIdByName(this, "id", str);
    }

    public int getResLayoutId(String str) {
        return ResourceUtils.getIdByName(this, "layout", str);
    }

    public String getResString(String str) {
        return ResourceUtils.getResString(this, str);
    }

    public int getResStringId(String str) {
        return ResourceUtils.getIdByName(this, "string", str);
    }

    protected TextView getRightMenu() {
        return (TextView) findViewById(getResId("sobot_tv_right"));
    }

    public SobotBaseActivity getSobotBaseActivity() {
        return this;
    }

    public Context getSobotBaseContext() {
        return this;
    }

    protected int getStatusBarColor() {
        return -1 != SobotUIConfig.sobot_statusbar_BgColor ? getResources().getColor(SobotUIConfig.sobot_statusbar_BgColor) : -1 != SobotUIConfig.sobot_titleBgColor ? getResources().getColor(SobotUIConfig.sobot_titleBgColor) : getResColor("sobot_status_bar_color");
    }

    protected View getTitleView() {
        return findViewById(getResId("sobot_text_title"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getToolBar() {
        return findViewById(getResId("sobot_layout_titlebar"));
    }

    protected void initBundleData(Bundle bundle) {
    }

    protected abstract void initData();

    protected abstract void initView();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFullScreen() {
        return (getWindow().getAttributes().flags & 1024) == 1024;
    }

    protected boolean isHasAudioPermission() {
        return Build.VERSION.SDK_INT < 23 || CommonUtils.getTargetSdkVersion(getSobotBaseActivity().getApplicationContext()) < 23 || ContextCompat.checkSelfPermission(getSobotBaseActivity(), Manifest.permission.RECORD_AUDIO) == 0;
    }

    protected boolean isHasCameraPermission() {
        return Build.VERSION.SDK_INT < 23 || CommonUtils.getTargetSdkVersion(getSobotBaseActivity().getApplicationContext()) < 23 || ContextCompat.checkSelfPermission(getSobotBaseActivity(), Manifest.permission.CAMERA) == 0;
    }

    protected boolean isHasPermission(int i) {
        if (i == 1) {
            return isHasStoragePermission();
        }
        if (i == 2) {
            return isHasAudioPermission();
        }
        if (i == 3) {
            return isHasCameraPermission();
        }
        return true;
    }

    protected boolean isHasStoragePermission() {
        if ((Build.VERSION.SDK_INT < 29 || CommonUtils.getTargetSdkVersion(getSobotBaseActivity().getApplicationContext()) < 29) && Build.VERSION.SDK_INT >= 23 && CommonUtils.getTargetSdkVersion(getSobotBaseActivity().getApplicationContext()) >= 23) {
            return ContextCompat.checkSelfPermission(getSobotBaseActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(getSobotBaseActivity(), "android.permission.READ_EXTERNAL_STORAGE") == 0;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.uiMode & 48;
        if (this.initMode != i) {
            this.initMode = i;
            recreate();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        this.initMode = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT != 26) {
            if (SobotApi.getSwitchMarkStatus(1)) {
                setRequestedOrientation(6);
            } else {
                setRequestedOrientation(7);
            }
        }
        if (SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4)) {
            NotchScreenManager.getInstance().setDisplayInNotch(this);
            getWindow().setFlags(1024, 1024);
        }
        setContentView(getContentViewResId());
        int statusBarColor = getStatusBarColor();
        if (statusBarColor != 0) {
            try {
                StatusBarCompat.setStatusBarColor(this, statusBarColor);
            } catch (Exception e) {
            }
        }
        setUpToolBar();
        getWindow().setSoftInputMode(2);
        this.zhiChiApi = SobotMsgManager.getInstance(getApplicationContext()).getZhiChiApi();
        MyApplication.getInstance().addActivity(this);
        if (findViewById(getResId("sobot_layout_titlebar")) != null) {
            setUpToolBarLeftMenu();
            setUpToolBarRightMenu();
        }
        try {
            initBundleData(bundle);
            initView();
            initData();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        changeAppLanguage();
        if (getLeftMenu() != null) {
            displayInNotch(getLeftMenu());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        HttpUtils.getInstance().cancelTag(this);
        MyApplication.getInstance().deleteActivity(this);
        super.onDestroy();
    }

    protected void onLeftMenuClick(View view) {
        onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 193) {
            return;
        }
        int i2 = 0;
        while (true) {
            try {
                int i3 = i2;
                if (i3 >= iArr.length) {
                    if (this.permissionListener != null) {
                        this.permissionListener.onPermissionSuccessListener();
                        return;
                    }
                    return;
                } else if (iArr[i3] != 0) {
                    if (strArr[i3] != null && strArr[i3].equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE") || ZCSobotApi.getSwitchMarkStatus(16)) {
                            if (this.permissionListener != null) {
                                this.permissionListener.onPermissionErrorListener(this, getResString("sobot_no_write_external_storage_permission"));
                                return;
                            }
                            return;
                        }
                        ToastUtil.showCustomLongToast(this, CommonUtils.getAppName(this) + getResString("sobot_want_use_your") + getResString("sobot_memory_card") + " , " + getResString("sobot_memory_card_yongtu"));
                        return;
                    } else if (strArr[i3] != null && strArr[i3].equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_EXTERNAL_STORAGE") || ZCSobotApi.getSwitchMarkStatus(16)) {
                            if (this.permissionListener != null) {
                                this.permissionListener.onPermissionErrorListener(this, getResString("sobot_no_write_external_storage_permission"));
                                return;
                            }
                            return;
                        }
                        ToastUtil.showCustomLongToast(this, CommonUtils.getAppName(this) + getResString("sobot_want_use_your") + getResString("sobot_memory_card") + " , " + getResString("sobot_memory_card_yongtu"));
                        return;
                    } else if (strArr[i3] != null && strArr[i3].equals(Manifest.permission.RECORD_AUDIO)) {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO) || ZCSobotApi.getSwitchMarkStatus(16)) {
                            if (this.permissionListener != null) {
                                this.permissionListener.onPermissionErrorListener(this, getResString("sobot_no_record_audio_permission"));
                                return;
                            }
                            return;
                        }
                        ToastUtil.showCustomLongToast(this, CommonUtils.getAppName(this) + getResString("sobot_want_use_your") + getResString("sobot_microphone") + " , " + getResString("sobot_microphone_yongtu"));
                        return;
                    } else if (strArr[i3] == null || !strArr[i3].equals(Manifest.permission.CAMERA)) {
                        return;
                    } else {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) || ZCSobotApi.getSwitchMarkStatus(16)) {
                            if (this.permissionListener != null) {
                                this.permissionListener.onPermissionErrorListener(this, getResString("sobot_no_camera_permission"));
                                return;
                            }
                            return;
                        }
                        ToastUtil.showCustomLongToast(this, CommonUtils.getAppName(this) + getResString("sobot_want_use_your") + getResString("sobot_camera") + " , " + getResString("sobot_camera_yongtu"));
                        return;
                    }
                } else {
                    i2 = i3 + 1;
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    protected void onRightMenuClick(View view) {
    }

    public void selectPicFromCamera() {
        if (!CommonUtils.isExitsSdcard()) {
            ToastUtil.showCustomToast(getSobotBaseActivity().getApplicationContext(), getResString("sobot_sdcard_does_not_exist"), 0);
            return;
        }
        this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.activity.base.SobotBaseActivity.4
            @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
            public void onPermissionSuccessListener() {
                SobotBaseActivity sobotBaseActivity = SobotBaseActivity.this;
                sobotBaseActivity.startActivityForResult(SobotCameraActivity.newIntent(sobotBaseActivity.getSobotBaseContext()), 108);
            }
        };
        if (!checkIsShowPermissionPop(getResString("sobot_camera"), getResString("sobot_camera_yongtu"), 3) && checkCameraPermission()) {
            startActivityForResult(SobotCameraActivity.newIntent(getSobotBaseContext()), 108);
        }
    }

    public void selectPicFromCameraBySys() {
        if (!CommonUtils.isExitsSdcard()) {
            ToastUtil.showCustomToast(getSobotBaseActivity(), getResString("sobot_sdcard_does_not_exist"), 0);
            return;
        }
        this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.activity.base.SobotBaseActivity.5
            @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
            public void onPermissionSuccessListener() {
                if (SobotBaseActivity.isCameraCanUse()) {
                    SobotBaseActivity sobotBaseActivity = SobotBaseActivity.this;
                    sobotBaseActivity.cameraFile = ChatUtils.openCamera(sobotBaseActivity.getSobotBaseActivity());
                }
            }
        };
        if (!checkIsShowPermissionPop(getResString("sobot_camera"), getResString("sobot_camera_yongtu"), 3) && checkCameraPermission()) {
            this.cameraFile = ChatUtils.openCamera(getSobotBaseActivity());
        }
    }

    public void selectPicFromLocal() {
        this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.activity.base.SobotBaseActivity.6
            @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
            public void onPermissionSuccessListener() {
                ChatUtils.openSelectPic(SobotBaseActivity.this.getSobotBaseActivity());
            }
        };
        if ((Build.VERSION.SDK_INT < 30 || CommonUtils.getTargetSdkVersion(getSobotBaseActivity().getApplicationContext()) < 30) && (checkIsShowPermissionPop(getResString("sobot_memory_card"), getResString("sobot_memory_card_yongtu"), 1) || !checkStoragePermission())) {
            return;
        }
        ChatUtils.openSelectPic(getSobotBaseActivity());
    }

    public void selectVedioFromLocal() {
        this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.activity.base.SobotBaseActivity.8
            @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
            public void onPermissionSuccessListener() {
                ChatUtils.openSelectVedio(SobotBaseActivity.this.getSobotBaseActivity());
            }
        };
        if ((Build.VERSION.SDK_INT < 30 || CommonUtils.getTargetSdkVersion(getSobotBaseActivity().getApplicationContext()) < 30) && (checkIsShowPermissionPop(getResString("sobot_memory_card"), getResString("sobot_memory_card_yongtu"), 1) || !checkStoragePermission())) {
            return;
        }
        ChatUtils.openSelectVedio(getSobotBaseActivity());
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        getAvatarMenu().setVisibility(8);
        View titleView = getTitleView();
        if (titleView == null || !(titleView instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) titleView;
        textView.setVisibility(0);
        textView.setText(i);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        View titleView = getTitleView();
        if (titleView == null || !(titleView instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) titleView;
        textView.setText(charSequence);
        applyTitleUIConfig(textView);
    }

    protected void setUpToolBar() {
        View toolBar = getToolBar();
        if (toolBar == null) {
            return;
        }
        if (-1 != SobotUIConfig.sobot_apicloud_titleBgColor) {
            toolBar.setBackgroundColor(getResources().getColor(SobotUIConfig.sobot_apicloud_titleBgColor));
        }
        if (-1 != SobotUIConfig.sobot_titleBgColor) {
            toolBar.setBackgroundColor(getResources().getColor(SobotUIConfig.sobot_titleBgColor));
        }
        int intData = SharedPreferencesUtil.getIntData(this, "robot_current_themeImg", 0);
        if (intData != 0) {
            toolBar.setBackgroundResource(intData);
        }
    }

    protected void setUpToolBarLeftMenu() {
        if (getLeftMenu() != null) {
            applyTitleUIConfig(getLeftMenu());
            getLeftMenu().setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.base.SobotBaseActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SobotBaseActivity.this.onLeftMenuClick(view);
                }
            });
        }
    }

    protected void setUpToolBarRightMenu() {
        if (getRightMenu() != null) {
            applyTitleUIConfig(getRightMenu());
            getRightMenu().setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.base.SobotBaseActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SobotBaseActivity.this.onRightMenuClick(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLeftMenu(int i, String str, boolean z) {
        TextView leftMenu = getLeftMenu();
        if (leftMenu == null || !(leftMenu instanceof TextView)) {
            return;
        }
        TextView textView = leftMenu;
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else {
            textView.setText(str);
        }
        if (i != 0) {
            Drawable drawable = getResources().getDrawable(i);
            Drawable drawable2 = drawable;
            if (-1 != SobotUIConfig.sobot_titleTextColor) {
                drawable2 = ScreenUtils.tintDrawable(getApplicationContext(), drawable, SobotUIConfig.sobot_titleTextColor);
            }
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView.setCompoundDrawables(drawable2, null, null, null);
        } else {
            textView.setCompoundDrawables(null, null, null, null);
        }
        if (z) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    protected void showRightMenu(int i, String str, boolean z) {
        TextView rightMenu = getRightMenu();
        if (rightMenu == null || !(rightMenu instanceof TextView)) {
            return;
        }
        TextView textView = rightMenu;
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else {
            textView.setText(str);
        }
        if (i != 0) {
            Drawable drawable = getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
        } else {
            textView.setCompoundDrawables(null, null, null, null);
        }
        if (z) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }
}
