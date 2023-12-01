package com.sobot.chat.widget.dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotApi;
import com.sobot.chat.activity.SobotPhotoActivity;
import com.sobot.chat.activity.SobotVideoActivity;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.activity.base.SobotDialogBaseActivity;
import com.sobot.chat.adapter.SobotPicListAdapter;
import com.sobot.chat.api.ResultCallBack;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.model.SobotCacheFile;
import com.sobot.chat.api.model.SobotUserTicketInfo;
import com.sobot.chat.api.model.ZhiChiMessage;
import com.sobot.chat.api.model.ZhiChiUploadAppFileModelResult;
import com.sobot.chat.application.MyApplication;
import com.sobot.chat.camera.util.FileUtil;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.listener.PermissionListener;
import com.sobot.chat.listener.PermissionListenerImpl;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.NotchScreenManager;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.CustomToast;
import com.sobot.chat.utils.FastClickUtils;
import com.sobot.chat.utils.ImageUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.MD5Util;
import com.sobot.chat.utils.MediaFileUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.StringUtils;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.widget.attachment.FileTypeConfig;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;
import com.sobot.network.http.callback.StringResultCallBack;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotReplyActivity.class */
public class SobotReplyActivity extends SobotDialogBaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private SobotPicListAdapter adapter;
    protected File cameraFile;
    private SobotUserTicketInfo mTicketInfo;
    private SobotSelectPicDialog menuWindow;
    public PermissionListener permissionListener;
    protected SobotDeleteWorkOrderDialog seleteMenuWindow;
    private Button sobotBtnSubmit;
    private LinearLayout sobotNegativeButton;
    private EditText sobotReplyEdit;
    private GridView sobotReplyMsgPic;
    private TextView sobotTvTitle;
    private ArrayList<ZhiChiUploadAppFileModelResult> pic_list = new ArrayList<>();
    private String mUid = "";
    private String mCompanyId = "";
    private View.OnClickListener itemsOnClick = new View.OnClickListener() { // from class: com.sobot.chat.widget.dialog.SobotReplyActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            SobotReplyActivity.this.menuWindow.dismiss();
            if (view.getId() == SobotReplyActivity.this.getResId("btn_take_photo")) {
                LogUtils.i("拍照");
                if (!CommonUtils.isExitsSdcard()) {
                    SobotReplyActivity sobotReplyActivity = SobotReplyActivity.this;
                    ToastUtil.showCustomToast(sobotReplyActivity, sobotReplyActivity.getResString("sobot_sdcard_does_not_exist"), 0);
                    return;
                }
                SobotReplyActivity.this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.widget.dialog.SobotReplyActivity.4.1
                    @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
                    public void onPermissionSuccessListener() {
                        if (SobotBaseActivity.isCameraCanUse()) {
                            SobotReplyActivity.this.cameraFile = ChatUtils.openCamera(SobotReplyActivity.this);
                        }
                    }
                };
                if (!SobotReplyActivity.this.checkCameraPermission()) {
                    return;
                }
                SobotReplyActivity sobotReplyActivity2 = SobotReplyActivity.this;
                sobotReplyActivity2.cameraFile = ChatUtils.openCamera(sobotReplyActivity2);
            }
            if (view.getId() == SobotReplyActivity.this.getResId("btn_pick_photo")) {
                LogUtils.i("选择照片");
                SobotReplyActivity.this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.widget.dialog.SobotReplyActivity.4.2
                    @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
                    public void onPermissionSuccessListener() {
                        ChatUtils.openSelectPic(SobotReplyActivity.this);
                    }
                };
                if (!SobotReplyActivity.this.checkStoragePermission()) {
                    return;
                }
                ChatUtils.openSelectPic(SobotReplyActivity.this);
            }
            if (view.getId() == SobotReplyActivity.this.getResId("btn_pick_vedio")) {
                LogUtils.i("选择视频");
                SobotReplyActivity.this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.widget.dialog.SobotReplyActivity.4.3
                    @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
                    public void onPermissionSuccessListener() {
                        ChatUtils.openSelectVedio(SobotReplyActivity.this, null);
                    }
                };
                if (SobotReplyActivity.this.checkStoragePermission()) {
                    ChatUtils.openSelectVedio(SobotReplyActivity.this, null);
                }
            }
        }
    };
    private ChatUtils.SobotSendFileListener sendFileListener = new ChatUtils.SobotSendFileListener() { // from class: com.sobot.chat.widget.dialog.SobotReplyActivity.5
        @Override // com.sobot.chat.utils.ChatUtils.SobotSendFileListener
        public void onError() {
            SobotDialogUtils.stopProgressDialog(SobotReplyActivity.this);
        }

        @Override // com.sobot.chat.utils.ChatUtils.SobotSendFileListener
        public void onSuccess(final String str) {
            ZhiChiApi zhiChiApi = SobotReplyActivity.this.zhiChiApi;
            SobotReplyActivity sobotReplyActivity = SobotReplyActivity.this;
            zhiChiApi.fileUploadForPostMsg(sobotReplyActivity, sobotReplyActivity.mCompanyId, SobotReplyActivity.this.mUid, str, new ResultCallBack<ZhiChiMessage>() { // from class: com.sobot.chat.widget.dialog.SobotReplyActivity.5.1
                @Override // com.sobot.chat.api.ResultCallBack
                public void onFailure(Exception exc, String str2) {
                    SobotDialogUtils.stopProgressDialog(SobotReplyActivity.this);
                    SobotReplyActivity.this.showHint(ResourceUtils.getResString(SobotReplyActivity.this, "sobot_net_work_err"));
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onLoading(long j, long j2, boolean z) {
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onSuccess(ZhiChiMessage zhiChiMessage) {
                    SobotDialogUtils.stopProgressDialog(SobotReplyActivity.this);
                    if (zhiChiMessage.getData() != null) {
                        ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult = new ZhiChiUploadAppFileModelResult();
                        zhiChiUploadAppFileModelResult.setFileUrl(zhiChiMessage.getData().getUrl());
                        zhiChiUploadAppFileModelResult.setFileLocalPath(str);
                        zhiChiUploadAppFileModelResult.setViewState(1);
                        SobotReplyActivity.this.addPicView(zhiChiUploadAppFileModelResult);
                    }
                }
            });
        }
    };

    private void initPicListView() {
        this.adapter.setOnClickItemViewListener(new SobotPicListAdapter.ViewClickListener() { // from class: com.sobot.chat.widget.dialog.SobotReplyActivity.3
            @Override // com.sobot.chat.adapter.SobotPicListAdapter.ViewClickListener
            public void clickView(View view, int i, int i2) {
                ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult;
                KeyboardUtil.hideKeyboard(view);
                if (i2 == 0) {
                    SobotReplyActivity sobotReplyActivity = SobotReplyActivity.this;
                    SobotReplyActivity sobotReplyActivity2 = SobotReplyActivity.this;
                    sobotReplyActivity.menuWindow = new SobotSelectPicDialog(sobotReplyActivity2, sobotReplyActivity2.itemsOnClick);
                    SobotReplyActivity.this.menuWindow.show();
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    String resString = ResourceUtils.getResString(SobotReplyActivity.this, "sobot_do_you_delete_picture");
                    if (SobotReplyActivity.this.adapter == null || SobotReplyActivity.this.adapter.getPicList() == null) {
                        return;
                    }
                    ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult2 = SobotReplyActivity.this.adapter.getPicList().get(i);
                    String str = resString;
                    if (zhiChiUploadAppFileModelResult2 != null) {
                        str = resString;
                        if (!TextUtils.isEmpty(zhiChiUploadAppFileModelResult2.getFileLocalPath())) {
                            str = resString;
                            if (MediaFileUtils.isVideoFileType(zhiChiUploadAppFileModelResult2.getFileLocalPath())) {
                                str = ResourceUtils.getResString(SobotReplyActivity.this, "sobot_do_you_delete_video");
                            }
                        }
                    }
                    if (SobotReplyActivity.this.seleteMenuWindow != null) {
                        SobotReplyActivity.this.seleteMenuWindow.dismiss();
                        SobotReplyActivity.this.seleteMenuWindow = null;
                    }
                    if (SobotReplyActivity.this.seleteMenuWindow == null) {
                        SobotReplyActivity.this.seleteMenuWindow = new SobotDeleteWorkOrderDialog(SobotReplyActivity.this, str, new View.OnClickListener() { // from class: com.sobot.chat.widget.dialog.SobotReplyActivity.3.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                Tracker.onClick(view2);
                                SobotReplyActivity.this.seleteMenuWindow.dismiss();
                                if (view2.getId() == SobotReplyActivity.this.getResId("btn_pick_photo")) {
                                    Log.e("onClick: ", SobotReplyActivity.this.seleteMenuWindow.getPosition() + "");
                                    SobotReplyActivity.this.pic_list.remove(SobotReplyActivity.this.seleteMenuWindow.getPosition());
                                    SobotReplyActivity.this.adapter.restDataView();
                                }
                            }
                        });
                    }
                    SobotReplyActivity.this.seleteMenuWindow.setPosition(i);
                    SobotReplyActivity.this.seleteMenuWindow.show();
                } else {
                    LogUtils.i("当前选择图片位置：" + i);
                    if (SobotReplyActivity.this.adapter == null || SobotReplyActivity.this.adapter.getPicList() == null || (zhiChiUploadAppFileModelResult = SobotReplyActivity.this.adapter.getPicList().get(i)) == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(zhiChiUploadAppFileModelResult.getFileLocalPath()) || !MediaFileUtils.isVideoFileType(zhiChiUploadAppFileModelResult.getFileLocalPath())) {
                        if (SobotOption.imagePreviewListener.onPreviewImage(SobotReplyActivity.this.getSobotBaseContext(), TextUtils.isEmpty(zhiChiUploadAppFileModelResult.getFileLocalPath()) ? zhiChiUploadAppFileModelResult.getFileUrl() : zhiChiUploadAppFileModelResult.getFileLocalPath())) {
                            return;
                        }
                        Intent intent = new Intent(SobotReplyActivity.this, SobotPhotoActivity.class);
                        intent.putExtra("imageUrL", TextUtils.isEmpty(zhiChiUploadAppFileModelResult.getFileLocalPath()) ? zhiChiUploadAppFileModelResult.getFileUrl() : zhiChiUploadAppFileModelResult.getFileLocalPath());
                        SobotReplyActivity.this.startActivity(intent);
                        return;
                    }
                    File file = new File(zhiChiUploadAppFileModelResult.getFileLocalPath());
                    SobotCacheFile sobotCacheFile = new SobotCacheFile();
                    sobotCacheFile.setFileName(file.getName());
                    sobotCacheFile.setUrl(zhiChiUploadAppFileModelResult.getFileUrl());
                    sobotCacheFile.setFilePath(zhiChiUploadAppFileModelResult.getFileLocalPath());
                    sobotCacheFile.setFileType(FileTypeConfig.getFileType(FileUtil.getFileEndWith(zhiChiUploadAppFileModelResult.getFileLocalPath())));
                    sobotCacheFile.setMsgId("" + System.currentTimeMillis());
                    SobotReplyActivity.this.startActivity(SobotVideoActivity.newIntent(SobotReplyActivity.this, sobotCacheFile));
                }
            }
        });
        this.adapter.restDataView();
    }

    public void addPicView(ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult) {
        this.adapter.addData(zhiChiUploadAppFileModelResult);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        if (motionEvent.getAction() != 0) {
            if (getWindow().superDispatchTouchEvent(motionEvent)) {
                return true;
            }
            return onTouchEvent(motionEvent);
        }
        View currentFocus = getCurrentFocus();
        if (isShouldHideInput(currentFocus, motionEvent) && (inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return ResourceUtils.getResLayoutId(this, "sobot_layout_dialog_reply");
    }

    public String getFileStr() {
        ArrayList<ZhiChiUploadAppFileModelResult> picList;
        String str = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.adapter.getPicList().size()) {
                return str;
            }
            str = str + picList.get(i2).getFileUrl() + ";";
            i = i2 + 1;
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        TextView textView = (TextView) findViewById(getResId("sobot_tv_title"));
        this.sobotTvTitle = textView;
        textView.setText(getResString("sobot_reply"));
        this.sobotNegativeButton = (LinearLayout) findViewById(getResId("sobot_negativeButton"));
        EditText editText = (EditText) findViewById(getResId("sobot_reply_edit"));
        this.sobotReplyEdit = editText;
        editText.setHint(ResourceUtils.getResString(this, "sobot_please_input_reply_hint"));
        this.sobotReplyMsgPic = (GridView) findViewById(getResId("sobot_reply_msg_pic"));
        Button button = (Button) findViewById(getResId("sobot_btn_submit"));
        this.sobotBtnSubmit = button;
        button.setText(ResourceUtils.getResString(this, "sobot_btn_submit_text"));
        List list = (List) getIntent().getSerializableExtra("picTempList");
        String stringExtra = getIntent().getStringExtra("replyTempContent");
        if (!StringUtils.isEmpty(stringExtra)) {
            this.sobotReplyEdit.setText(stringExtra);
        }
        if (list != null && list.size() > 0) {
            this.pic_list.addAll(list);
        }
        this.sobotNegativeButton.setOnClickListener(this);
        this.sobotBtnSubmit.setOnClickListener(this);
        SobotPicListAdapter sobotPicListAdapter = new SobotPicListAdapter(this, this.pic_list);
        this.adapter = sobotPicListAdapter;
        this.sobotReplyMsgPic.setAdapter((ListAdapter) sobotPicListAdapter);
        initPicListView();
        this.mUid = getIntent().getStringExtra("uid");
        this.mCompanyId = getIntent().getStringExtra("companyId");
        this.mTicketInfo = (SobotUserTicketInfo) getIntent().getSerializableExtra("ticketInfo");
        if (SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4)) {
            NotchScreenManager.getInstance().getNotchInfo(this, new INotchScreen.NotchScreenCallback() { // from class: com.sobot.chat.widget.dialog.SobotReplyActivity.1
                @Override // com.sobot.chat.notchlib.INotchScreen.NotchScreenCallback
                public void onResult(INotchScreen.NotchScreenInfo notchScreenInfo) {
                    if (notchScreenInfo.hasNotch) {
                        for (Rect rect : notchScreenInfo.notchRects) {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ScreenUtils.dip2px(SobotReplyActivity.this, 104.0f));
                            int i = 110;
                            int i2 = rect.right > 110 ? 110 : rect.right;
                            int dip2px = ScreenUtils.dip2px(SobotReplyActivity.this, 20.0f);
                            if (rect.right <= 110) {
                                i = rect.right;
                            }
                            layoutParams.setMargins(i2 + dip2px, i + ScreenUtils.dip2px(SobotReplyActivity.this, 20.0f), ScreenUtils.dip2px(SobotReplyActivity.this, 20.0f), ScreenUtils.dip2px(SobotReplyActivity.this, 20.0f));
                            SobotReplyActivity.this.sobotReplyEdit.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
        }
        displayInNotch(this.sobotReplyMsgPic);
    }

    public boolean isShouldHideInput(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view.getHeight() + i2));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i != 701) {
                if (i == 702) {
                    File file = this.cameraFile;
                    if (file == null || !file.exists()) {
                        showHint(getResString("sobot_pic_select_again"));
                        return;
                    }
                    SobotDialogUtils.startProgressDialog(this);
                    ChatUtils.sendPicByFilePath(this, this.cameraFile.getAbsolutePath(), this.sendFileListener, true);
                }
            } else if (intent == null || intent.getData() == null) {
                showHint(getResString("sobot_did_not_get_picture_path"));
            } else {
                Uri data = intent.getData();
                Uri uri = data;
                if (data == null) {
                    uri = ImageUtils.getUri(intent, this);
                }
                String path = ImageUtils.getPath(this, uri);
                if (!MediaFileUtils.isVideoFileType(path)) {
                    SobotDialogUtils.startProgressDialog(this);
                    ChatUtils.sendPicByUriPost(this, uri, this.sendFileListener, false);
                    return;
                }
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(this, uri);
                    mediaPlayer.prepare();
                    if (mediaPlayer.getDuration() / 1000 > 15) {
                        ToastUtil.showToast(this, getResString("sobot_upload_vodie_length"));
                        return;
                    }
                    SobotDialogUtils.startProgressDialog(this);
                    String encode = MD5Util.encode(path);
                    try {
                        this.sendFileListener.onSuccess(FileUtil.saveImageFile(this, uri, encode + FileUtil.getFileEndWith(path), path));
                    } catch (Exception e) {
                        e.printStackTrace();
                        ToastUtil.showToast(this, ResourceUtils.getResString(this, "sobot_pic_type_error"));
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        LinearLayout linearLayout = this.sobotNegativeButton;
        if (view == linearLayout) {
            KeyboardUtil.hideKeyboard(linearLayout);
            Intent intent = new Intent();
            intent.putExtra("replyTempContent", this.sobotReplyEdit.getText().toString());
            intent.putExtra("picTempList", this.pic_list);
            intent.putExtra("isTemp", true);
            setResult(-1, intent);
            finish();
        }
        Button button = this.sobotBtnSubmit;
        if (view == button) {
            KeyboardUtil.hideKeyboard(button);
            if (StringUtils.isEmpty(this.sobotReplyEdit.getText().toString().trim())) {
                Toast.makeText(getContext(), ResourceUtils.getResString(getContext(), "sobot_please_input_reply_no_empty"), 0).show();
            } else if (FastClickUtils.isCanClick()) {
                SobotDialogUtils.startProgressDialog(this);
                this.zhiChiApi.replyTicketContent(this, this.mUid, this.mTicketInfo.getTicketId(), this.sobotReplyEdit.getText().toString(), getFileStr(), this.mCompanyId, new StringResultCallBack<String>() { // from class: com.sobot.chat.widget.dialog.SobotReplyActivity.2
                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    public void onFailure(Exception exc, String str) {
                        SobotReplyActivity sobotReplyActivity = SobotReplyActivity.this;
                        ToastUtil.showCustomToast(sobotReplyActivity, ResourceUtils.getResString(sobotReplyActivity, "sobot_leavemsg_error_tip"));
                        exc.printStackTrace();
                        SobotDialogUtils.stopProgressDialog(SobotReplyActivity.this);
                    }

                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    public void onSuccess(String str) {
                        LogUtils.e(str);
                        SobotReplyActivity sobotReplyActivity = SobotReplyActivity.this;
                        CustomToast.makeText(sobotReplyActivity, ResourceUtils.getResString(sobotReplyActivity, "sobot_leavemsg_success_tip"), 1000, ResourceUtils.getDrawableId(SobotReplyActivity.this, "sobot_iv_login_right")).show();
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        SobotReplyActivity.this.pic_list.clear();
                        Intent intent2 = new Intent();
                        intent2.putExtra("replyTempContent", "");
                        intent2.putExtra("picTempList", SobotReplyActivity.this.pic_list);
                        intent2.putExtra("isTemp", false);
                        SobotReplyActivity.this.setResult(-1, intent2);
                        SobotDialogUtils.stopProgressDialog(SobotReplyActivity.this);
                        SobotReplyActivity.this.finish();
                    }
                });
            }
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        HttpUtils.getInstance().cancelTag(this);
        MyApplication.getInstance().deleteActivity(this);
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        initData();
    }

    @Override // com.sobot.chat.activity.base.SobotDialogBaseActivity, android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || motionEvent.getY() > 0.0f) {
            return true;
        }
        Intent intent = new Intent();
        intent.putExtra("replyTempContent", this.sobotReplyEdit.getText().toString());
        intent.putExtra("picTempList", this.pic_list);
        intent.putExtra("isTemp", true);
        setResult(-1, intent);
        finish();
        return true;
    }

    public void showHint(String str) {
        CustomToast.makeText(this, str, 1000).show();
    }
}
