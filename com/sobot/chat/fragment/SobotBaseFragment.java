package com.sobot.chat.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.anythink.expressad.foundation.h.i;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotApi;
import com.sobot.chat.SobotUIConfig;
import com.sobot.chat.ZCSobotApi;
import com.sobot.chat.activity.SobotCameraActivity;
import com.sobot.chat.api.ZhiChiApi;
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
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.dialog.SobotPermissionTipDialog;
import com.sobot.chat.widget.image.SobotRCImageView;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/fragment/SobotBaseFragment.class */
public abstract class SobotBaseFragment extends Fragment {
    public static final int REQUEST_CODE_CAMERA = 108;
    private Activity activity;
    protected File cameraFile;
    public PermissionListener permissionListener;
    public ZhiChiApi zhiChiApi;

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

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyTitleTextColor(TextView textView) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkAudioPermission() {
        if (Build.VERSION.SDK_INT < 23 || CommonUtils.getTargetSdkVersion(getSobotActivity().getApplicationContext()) < 23 || ContextCompat.checkSelfPermission(getSobotActivity(), Manifest.permission.RECORD_AUDIO) == 0) {
            return true;
        }
        requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 193);
        return false;
    }

    protected boolean checkCameraPermission() {
        if (Build.VERSION.SDK_INT < 23 || CommonUtils.getTargetSdkVersion(getSobotActivity().getApplicationContext()) < 23 || ContextCompat.checkSelfPermission(getSobotActivity(), Manifest.permission.CAMERA) == 0) {
            return true;
        }
        requestPermissions(new String[]{Manifest.permission.CAMERA}, 193);
        return false;
    }

    public boolean checkIsShowPermissionPop(String str, String str2, final int i) {
        if (!ZCSobotApi.getSwitchMarkStatus(16) || isHasPermission(i)) {
            return false;
        }
        new SobotPermissionTipDialog(this.activity, str, str2, new SobotPermissionTipDialog.ClickViewListener() { // from class: com.sobot.chat.fragment.SobotBaseFragment.5
            @Override // com.sobot.chat.widget.dialog.SobotPermissionTipDialog.ClickViewListener
            public void clickLeftView(Context context, SobotPermissionTipDialog sobotPermissionTipDialog) {
                sobotPermissionTipDialog.dismiss();
            }

            @Override // com.sobot.chat.widget.dialog.SobotPermissionTipDialog.ClickViewListener
            public void clickRightView(Context context, SobotPermissionTipDialog sobotPermissionTipDialog) {
                sobotPermissionTipDialog.dismiss();
                int i2 = i;
                if (i2 == 1) {
                    if (SobotBaseFragment.this.checkStoragePermission()) {
                    }
                } else if (i2 == 2) {
                    if (SobotBaseFragment.this.checkAudioPermission()) {
                    }
                } else {
                    if (i2 != 3 || !SobotBaseFragment.this.checkCameraPermission()) {
                    }
                }
            }
        }).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkStoragePermission() {
        if ((Build.VERSION.SDK_INT < 29 || CommonUtils.getTargetSdkVersion(getSobotActivity().getApplicationContext()) < 29) && Build.VERSION.SDK_INT >= 23 && CommonUtils.getTargetSdkVersion(getSobotActivity().getApplicationContext()) >= 23) {
            if (ContextCompat.checkSelfPermission(getSobotActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 193);
                return false;
            } else if (ContextCompat.checkSelfPermission(getSobotActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
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
            NotchScreenManager.getInstance().getNotchInfo(getActivity(), new INotchScreen.NotchScreenCallback() { // from class: com.sobot.chat.fragment.SobotBaseFragment.1
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

    public float getDimens(String str) {
        return getResources().getDimension(getResDimenId(str));
    }

    public int getResDimenId(String str) {
        return ResourceUtils.getIdByName(getSobotActivity(), "dimen", str);
    }

    public int getResDrawableId(String str) {
        return ResourceUtils.getIdByName(getSobotActivity(), i.f7952c, str);
    }

    public int getResId(String str) {
        return ResourceUtils.getIdByName(getSobotActivity(), "id", str);
    }

    public int getResLayoutId(String str) {
        return ResourceUtils.getIdByName(getSobotActivity(), "layout", str);
    }

    public String getResString(String str) {
        return ResourceUtils.getResString(getSobotActivity(), str);
    }

    public int getResStringId(String str) {
        return ResourceUtils.getIdByName(getSobotActivity(), "string", str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.app.Activity] */
    public Activity getSobotActivity() {
        FragmentActivity activity = getActivity();
        FragmentActivity fragmentActivity = activity;
        if (activity == null) {
            fragmentActivity = this.activity;
        }
        return fragmentActivity;
    }

    public SobotBaseFragment getSobotBaseFragment() {
        return this;
    }

    protected boolean isHasAudioPermission() {
        return Build.VERSION.SDK_INT < 23 || CommonUtils.getTargetSdkVersion(getSobotActivity().getApplicationContext()) < 23 || ContextCompat.checkSelfPermission(getSobotActivity(), Manifest.permission.RECORD_AUDIO) == 0;
    }

    protected boolean isHasCameraPermission() {
        return Build.VERSION.SDK_INT < 23 || CommonUtils.getTargetSdkVersion(getSobotActivity().getApplicationContext()) < 23 || ContextCompat.checkSelfPermission(getSobotActivity(), Manifest.permission.CAMERA) == 0;
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
        if ((Build.VERSION.SDK_INT < 29 || CommonUtils.getTargetSdkVersion(getSobotActivity().getApplicationContext()) < 29) && Build.VERSION.SDK_INT >= 23 && CommonUtils.getTargetSdkVersion(getSobotActivity().getApplicationContext()) >= 23) {
            return ContextCompat.checkSelfPermission(getSobotActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(getSobotActivity(), "android.permission.READ_EXTERNAL_STORAGE") == 0;
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.activity == null) {
            this.activity = (Activity) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zhiChiApi = SobotMsgManager.getInstance(getContext().getApplicationContext()).getZhiChiApi();
        if (SobotApi.getSwitchMarkStatus(4) && SobotApi.getSwitchMarkStatus(1)) {
            NotchScreenManager.getInstance().setDisplayInNotch(getActivity());
            getActivity().getWindow().setFlags(1024, 1024);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        HttpUtils.getInstance().cancelTag(this);
        HttpUtils.getInstance().cancelTag(ZhiChiConstant.SOBOT_GLOBAL_REQUEST_CANCEL_TAG);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Tracker.onHiddenChanged(this, z);
        super.onHiddenChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Tracker.onPause(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
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
                        if (!shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE") || ZCSobotApi.getSwitchMarkStatus(16)) {
                            if (this.permissionListener != null) {
                                this.permissionListener.onPermissionErrorListener(getSobotActivity(), getResString("sobot_no_write_external_storage_permission"));
                                return;
                            }
                            return;
                        }
                        Activity sobotActivity = getSobotActivity();
                        ToastUtil.showCustomLongToast(sobotActivity, CommonUtils.getAppName(getContext()) + getResString("sobot_want_use_your") + getResString("sobot_memory_card") + " , " + getResString("sobot_memory_card_yongtu"));
                        return;
                    } else if (strArr[i3] != null && strArr[i3].equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        if (!shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE") || ZCSobotApi.getSwitchMarkStatus(16)) {
                            if (this.permissionListener != null) {
                                this.permissionListener.onPermissionErrorListener(getSobotActivity(), getResString("sobot_no_write_external_storage_permission"));
                                return;
                            }
                            return;
                        }
                        Activity sobotActivity2 = getSobotActivity();
                        ToastUtil.showCustomLongToast(sobotActivity2, CommonUtils.getAppName(getContext()) + getResString("sobot_want_use_your") + getResString("sobot_memory_card") + " , " + getResString("sobot_memory_card_yongtu"));
                        return;
                    } else if (strArr[i3] != null && strArr[i3].equals(Manifest.permission.RECORD_AUDIO)) {
                        if (!shouldShowRequestPermissionRationale(Manifest.permission.RECORD_AUDIO) || ZCSobotApi.getSwitchMarkStatus(16)) {
                            if (this.permissionListener != null) {
                                this.permissionListener.onPermissionErrorListener(getSobotActivity(), getResString("sobot_no_record_audio_permission"));
                                return;
                            }
                            return;
                        }
                        Activity sobotActivity3 = getSobotActivity();
                        ToastUtil.showCustomLongToast(sobotActivity3, CommonUtils.getAppName(getContext()) + getResString("sobot_want_use_your") + getResString("sobot_microphone") + " , " + getResString("sobot_microphone_yongtu"));
                        return;
                    } else if (strArr[i3] == null || !strArr[i3].equals(Manifest.permission.CAMERA)) {
                        return;
                    } else {
                        if (!shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) || ZCSobotApi.getSwitchMarkStatus(16)) {
                            if (this.permissionListener != null) {
                                this.permissionListener.onPermissionErrorListener(getSobotActivity(), getResString("sobot_no_camera_permission"));
                                return;
                            }
                            return;
                        }
                        Activity sobotActivity4 = getSobotActivity();
                        ToastUtil.showCustomLongToast(sobotActivity4, CommonUtils.getAppName(getContext()) + getResString("sobot_want_use_your") + getResString("sobot_camera") + " , " + getResString("sobot_camera_yongtu"));
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Tracker.onResume(this);
        super.onResume();
    }

    public void selectPicFromCamera() {
        if (!CommonUtils.isExitsSdcard()) {
            ToastUtil.showCustomToast(getSobotActivity().getApplicationContext(), getResString("sobot_sdcard_does_not_exist"), 0);
            return;
        }
        this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.fragment.SobotBaseFragment.2
            @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
            public void onPermissionSuccessListener() {
                SobotBaseFragment sobotBaseFragment = SobotBaseFragment.this;
                sobotBaseFragment.startActivityForResult(SobotCameraActivity.newIntent(sobotBaseFragment.getSobotBaseFragment().getContext()), 108);
            }
        };
        if (!checkIsShowPermissionPop(getResString("sobot_camera"), getResString("sobot_camera_yongtu"), 3) && checkCameraPermission()) {
            startActivityForResult(SobotCameraActivity.newIntent(getContext()), 108);
        }
    }

    public void selectPicFromCameraBySys() {
        if (!CommonUtils.isExitsSdcard()) {
            ToastUtil.showCustomToast(getSobotActivity(), getResString("sobot_sdcard_does_not_exist"), 0);
            return;
        }
        this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.fragment.SobotBaseFragment.3
            @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
            public void onPermissionSuccessListener() {
                if (SobotBaseFragment.isCameraCanUse()) {
                    SobotBaseFragment sobotBaseFragment = SobotBaseFragment.this;
                    sobotBaseFragment.cameraFile = ChatUtils.openCamera(sobotBaseFragment.getSobotActivity(), SobotBaseFragment.this.getSobotBaseFragment());
                }
            }
        };
        if (!checkIsShowPermissionPop(getResString("sobot_camera"), getResString("sobot_camera_yongtu"), 3) && checkCameraPermission()) {
            this.cameraFile = ChatUtils.openCamera(getSobotActivity(), this);
        }
    }

    public void selectPicFromLocal() {
        this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.fragment.SobotBaseFragment.4
            @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
            public void onPermissionSuccessListener() {
                ChatUtils.openSelectPic(SobotBaseFragment.this.getSobotActivity(), SobotBaseFragment.this.getSobotBaseFragment());
            }
        };
        if ((Build.VERSION.SDK_INT < 30 || CommonUtils.getTargetSdkVersion(getSobotActivity().getApplicationContext()) < 30) && (checkIsShowPermissionPop(getResString("sobot_memory_card"), getResString("sobot_memory_card_yongtu"), 1) || !checkStoragePermission())) {
            return;
        }
        ChatUtils.openSelectPic(getSobotActivity(), this);
    }

    public void selectVedioFromLocal() {
        this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.fragment.SobotBaseFragment.6
            @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
            public void onPermissionSuccessListener() {
                ChatUtils.openSelectVedio(SobotBaseFragment.this.getSobotActivity(), SobotBaseFragment.this.getSobotBaseFragment());
            }
        };
        if ((Build.VERSION.SDK_INT < 30 || CommonUtils.getTargetSdkVersion(getSobotActivity().getApplicationContext()) < 30) && (checkIsShowPermissionPop(getResString("sobot_memory_card"), getResString("sobot_memory_card_yongtu"), 1) || !checkStoragePermission())) {
            return;
        }
        ChatUtils.openSelectVedio(getSobotActivity(), this);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
    }

    protected void showAvatar(SobotRCImageView sobotRCImageView, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            SobotBitmapUtil.display(getContext(), str, sobotRCImageView);
        }
        if (z) {
            sobotRCImageView.setVisibility(0);
        } else {
            sobotRCImageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLeftMenu(View view, int i, String str) {
        if (view == null || !(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else {
            textView.setText(str);
        }
        if (i != 0) {
            Drawable drawable = getResources().getDrawable(i);
            Drawable drawable2 = drawable;
            if (-1 != SobotUIConfig.sobot_titleTextColor) {
                drawable2 = ScreenUtils.tintDrawable(getContext(), drawable, SobotUIConfig.sobot_titleTextColor);
            }
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView.setCompoundDrawables(drawable2, null, null, null);
        } else {
            textView.setCompoundDrawables(null, null, null, null);
        }
        applyTitleTextColor(textView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showRightMenu(View view, int i, String str) {
        if (view == null || !(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
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
        textView.setVisibility(0);
    }
}
