package com.sobot.chat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.WebViewActivity;
import com.sobot.chat.utils.CustomToast;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.widget.zxing.Result;
import com.sobot.chat.widget.zxing.util.CodeUtils;
import com.sobot.network.http.SobotOkHttpUtils;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SelectPicPopupWindow.class */
public class SelectPicPopupWindow extends PopupWindow {
    private Context context;
    private String imgUrl;
    private LayoutInflater inflater;
    private View mView;
    private Result[] result;
    private View.OnClickListener savePictureOnClick;
    private Button sobot_btn_cancel;
    private Button sobot_btn_scan_qr_code;
    private Button sobot_btn_take_photo;
    private String type;
    private String uid;

    public SelectPicPopupWindow(Activity activity, String str) {
        this.savePictureOnClick = new View.OnClickListener() { // from class: com.sobot.chat.widget.SelectPicPopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SelectPicPopupWindow.this.dismiss();
                if (view == SelectPicPopupWindow.this.sobot_btn_take_photo) {
                    LogUtils.i("imgUrl:" + SelectPicPopupWindow.this.imgUrl);
                    if (SelectPicPopupWindow.this.type.equals("gif")) {
                        SelectPicPopupWindow selectPicPopupWindow = SelectPicPopupWindow.this;
                        selectPicPopupWindow.saveImageToGallery(selectPicPopupWindow.context, SelectPicPopupWindow.this.imgUrl);
                    } else {
                        Bitmap compress = SobotBitmapUtil.compress(SelectPicPopupWindow.this.imgUrl, SelectPicPopupWindow.this.context, true);
                        SelectPicPopupWindow selectPicPopupWindow2 = SelectPicPopupWindow.this;
                        selectPicPopupWindow2.saveImageToGallery(selectPicPopupWindow2.context, compress);
                    }
                }
                Button unused = SelectPicPopupWindow.this.sobot_btn_cancel;
                if (view == SelectPicPopupWindow.this.sobot_btn_scan_qr_code) {
                    if (SelectPicPopupWindow.this.result == null || SelectPicPopupWindow.this.result.length != 1) {
                        SelectPicPopupWindow.this.sobot_btn_scan_qr_code.setVisibility(8);
                        return;
                    }
                    Intent intent = new Intent(SelectPicPopupWindow.this.context, WebViewActivity.class);
                    intent.putExtra("url", SelectPicPopupWindow.this.result[0].getText());
                    intent.addFlags(268435456);
                    SelectPicPopupWindow.this.context.startActivity(intent);
                }
            }
        };
        this.context = activity;
        this.uid = str;
        initView();
    }

    public SelectPicPopupWindow(Activity activity, String str, String str2) {
        super(activity);
        this.savePictureOnClick = new View.OnClickListener() { // from class: com.sobot.chat.widget.SelectPicPopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SelectPicPopupWindow.this.dismiss();
                if (view == SelectPicPopupWindow.this.sobot_btn_take_photo) {
                    LogUtils.i("imgUrl:" + SelectPicPopupWindow.this.imgUrl);
                    if (SelectPicPopupWindow.this.type.equals("gif")) {
                        SelectPicPopupWindow selectPicPopupWindow = SelectPicPopupWindow.this;
                        selectPicPopupWindow.saveImageToGallery(selectPicPopupWindow.context, SelectPicPopupWindow.this.imgUrl);
                    } else {
                        Bitmap compress = SobotBitmapUtil.compress(SelectPicPopupWindow.this.imgUrl, SelectPicPopupWindow.this.context, true);
                        SelectPicPopupWindow selectPicPopupWindow2 = SelectPicPopupWindow.this;
                        selectPicPopupWindow2.saveImageToGallery(selectPicPopupWindow2.context, compress);
                    }
                }
                Button unused = SelectPicPopupWindow.this.sobot_btn_cancel;
                if (view == SelectPicPopupWindow.this.sobot_btn_scan_qr_code) {
                    if (SelectPicPopupWindow.this.result == null || SelectPicPopupWindow.this.result.length != 1) {
                        SelectPicPopupWindow.this.sobot_btn_scan_qr_code.setVisibility(8);
                        return;
                    }
                    Intent intent = new Intent(SelectPicPopupWindow.this.context, WebViewActivity.class);
                    intent.putExtra("url", SelectPicPopupWindow.this.result[0].getText());
                    intent.addFlags(268435456);
                    SelectPicPopupWindow.this.context.startActivity(intent);
                }
            }
        };
        this.imgUrl = str;
        this.type = str2;
        this.context = activity.getApplicationContext();
        initView();
    }

    public SelectPicPopupWindow(Activity activity, String str, String str2, boolean z) {
        super(activity);
        this.savePictureOnClick = new View.OnClickListener() { // from class: com.sobot.chat.widget.SelectPicPopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SelectPicPopupWindow.this.dismiss();
                if (view == SelectPicPopupWindow.this.sobot_btn_take_photo) {
                    LogUtils.i("imgUrl:" + SelectPicPopupWindow.this.imgUrl);
                    if (SelectPicPopupWindow.this.type.equals("gif")) {
                        SelectPicPopupWindow selectPicPopupWindow = SelectPicPopupWindow.this;
                        selectPicPopupWindow.saveImageToGallery(selectPicPopupWindow.context, SelectPicPopupWindow.this.imgUrl);
                    } else {
                        Bitmap compress = SobotBitmapUtil.compress(SelectPicPopupWindow.this.imgUrl, SelectPicPopupWindow.this.context, true);
                        SelectPicPopupWindow selectPicPopupWindow2 = SelectPicPopupWindow.this;
                        selectPicPopupWindow2.saveImageToGallery(selectPicPopupWindow2.context, compress);
                    }
                }
                Button unused = SelectPicPopupWindow.this.sobot_btn_cancel;
                if (view == SelectPicPopupWindow.this.sobot_btn_scan_qr_code) {
                    if (SelectPicPopupWindow.this.result == null || SelectPicPopupWindow.this.result.length != 1) {
                        SelectPicPopupWindow.this.sobot_btn_scan_qr_code.setVisibility(8);
                        return;
                    }
                    Intent intent = new Intent(SelectPicPopupWindow.this.context, WebViewActivity.class);
                    intent.putExtra("url", SelectPicPopupWindow.this.result[0].getText());
                    intent.addFlags(268435456);
                    SelectPicPopupWindow.this.context.startActivity(intent);
                }
            }
        };
        this.imgUrl = str;
        this.type = str2;
        this.context = activity.getApplicationContext();
        initView();
        if (z) {
            new Thread(new Runnable() { // from class: com.sobot.chat.widget.SelectPicPopupWindow.1
                @Override // java.lang.Runnable
                public void run() {
                    SelectPicPopupWindow selectPicPopupWindow = SelectPicPopupWindow.this;
                    selectPicPopupWindow.result = CodeUtils.parseMultiQRCode(selectPicPopupWindow.imgUrl);
                    if (SelectPicPopupWindow.this.result != null) {
                        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.chat.widget.SelectPicPopupWindow.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SelectPicPopupWindow.this.result.length == 1) {
                                    LogUtils.i("图片中二维码:" + SelectPicPopupWindow.this.result[0].getText());
                                    SelectPicPopupWindow.this.sobot_btn_scan_qr_code.setVisibility(0);
                                    return;
                                }
                                LogUtils.i("图片中有 " + SelectPicPopupWindow.this.result.length + " 个二维码");
                                SelectPicPopupWindow.this.sobot_btn_scan_qr_code.setVisibility(8);
                            }
                        });
                    }
                }
            }).start();
        }
    }

    private void initView() {
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.inflater = layoutInflater;
        View inflate = layoutInflater.inflate(ResourceUtils.getIdByName(this.context, "layout", "sobot_clear_history_dialog"), (ViewGroup) null);
        this.mView = inflate;
        Button button = (Button) inflate.findViewById(ResourceUtils.getIdByName(this.context, "id", "sobot_btn_take_photo"));
        this.sobot_btn_take_photo = button;
        button.setText(ResourceUtils.getResString(this.context, "sobot_save_pic"));
        Button button2 = (Button) this.mView.findViewById(ResourceUtils.getIdByName(this.context, "id", "sobot_btn_cancel"));
        this.sobot_btn_cancel = button2;
        button2.setText(ResourceUtils.getResString(this.context, "sobot_btn_cancle"));
        Button button3 = (Button) this.mView.findViewById(ResourceUtils.getIdByName(this.context, "id", "sobot_btn_scan_qr_code"));
        this.sobot_btn_scan_qr_code = button3;
        button3.setText(ResourceUtils.getResString(this.context, "sobot_scan_qr_code"));
        setContentView(this.mView);
        setWidth(-1);
        setHeight(-2);
        setFocusable(true);
        setAnimationStyle(ResourceUtils.getIdByName(this.context, "style", "sobot_AnimBottom"));
        setBackgroundDrawable(new ColorDrawable(-1342177280));
        this.mView.setOnTouchListener(new View.OnTouchListener() { // from class: com.sobot.chat.widget.SelectPicPopupWindow.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int top = SelectPicPopupWindow.this.mView.findViewById(ResourceUtils.getIdByName(SelectPicPopupWindow.this.context, "id", "sobot_pop_layout")).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() != 1 || y >= top) {
                    return true;
                }
                SelectPicPopupWindow.this.dismiss();
                return true;
            }
        });
        if (TextUtils.isEmpty(this.imgUrl)) {
            return;
        }
        this.sobot_btn_take_photo.setTextColor(this.context.getResources().getColor(ResourceUtils.getIdByName(this.context, "color", "sobot_common_black")));
        this.sobot_btn_cancel.setTextColor(this.context.getResources().getColor(ResourceUtils.getIdByName(this.context, "color", "sobot_common_black")));
        this.sobot_btn_scan_qr_code.setTextColor(this.context.getResources().getColor(ResourceUtils.getIdByName(this.context, "color", "sobot_common_black")));
        this.sobot_btn_cancel.setOnClickListener(this.savePictureOnClick);
        this.sobot_btn_take_photo.setOnClickListener(this.savePictureOnClick);
        this.sobot_btn_scan_qr_code.setOnClickListener(this.savePictureOnClick);
    }

    private void showHint(String str) {
        Context context = this.context;
        CustomToast.makeText(context, str, 1000, ResourceUtils.getDrawableId(context, "sobot_iv_login_right")).show();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c5 A[Catch: IOException -> 0x0128, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x0128, blocks: (B:13:0x0046, B:15:0x004e, B:17:0x0054, B:19:0x005c, B:42:0x00c5, B:45:0x00d1, B:48:0x00da, B:51:0x00e2), top: B:76:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d1 A[Catch: IOException -> 0x0128, TRY_ENTER, TryCatch #3 {IOException -> 0x0128, blocks: (B:13:0x0046, B:15:0x004e, B:17:0x0054, B:19:0x005c, B:42:0x00c5, B:45:0x00d1, B:48:0x00da, B:51:0x00e2), top: B:76:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00da A[Catch: IOException -> 0x0128, TRY_ENTER, TryCatch #3 {IOException -> 0x0128, blocks: (B:13:0x0046, B:15:0x004e, B:17:0x0054, B:19:0x005c, B:42:0x00c5, B:45:0x00d1, B:48:0x00da, B:51:0x00e2), top: B:76:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e2 A[Catch: IOException -> 0x0128, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x0128, blocks: (B:13:0x0046, B:15:0x004e, B:17:0x0054, B:19:0x005c, B:42:0x00c5, B:45:0x00d1, B:48:0x00da, B:51:0x00e2), top: B:76:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0109 A[Catch: IOException -> 0x012c, TRY_ENTER, TryCatch #10 {IOException -> 0x012c, blocks: (B:59:0x00fd, B:62:0x0109, B:65:0x0112, B:68:0x011a), top: B:79:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0112 A[Catch: IOException -> 0x012c, TRY_ENTER, TryCatch #10 {IOException -> 0x012c, blocks: (B:59:0x00fd, B:62:0x0109, B:65:0x0112, B:68:0x011a), top: B:79:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011a A[Catch: IOException -> 0x012c, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x012c, blocks: (B:59:0x00fd, B:62:0x0109, B:65:0x0112, B:68:0x011a), top: B:79:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean fileChannelCopy(java.io.File r8, java.io.File r9) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.SelectPicPopupWindow.fileChannelCopy(java.io.File, java.io.File):boolean");
    }

    public boolean isSdCardExist() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public void notifyUpdatePic(File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && !TextUtils.isEmpty(str)) {
                    MediaStore.Images.Media.insertImage(this.context.getContentResolver(), file.getAbsolutePath(), str, (String) null);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        this.context.sendBroadcast(intent);
        showHint(ResourceUtils.getResString(this.context, "sobot_already_save_to_picture"));
    }

    public void saveImageToGallery(Context context, Bitmap bitmap) {
        if (!isSdCardExist()) {
            ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_save_err_sd_card"));
        } else if (bitmap == null) {
            ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_save_err_pic"));
        } else {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + File.separator + "Sobot", "sobot_pic");
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = System.currentTimeMillis() + ".jpg";
            File file2 = new File(file, str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_save_error_file"));
                e.printStackTrace();
            } catch (IOException e2) {
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_save_err"));
                e2.printStackTrace();
            } catch (Exception e3) {
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_save_err"));
                e3.printStackTrace();
            }
            notifyUpdatePic(file2, str);
        }
    }

    public void saveImageToGallery(Context context, String str) {
        if (!isSdCardExist()) {
            ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_save_err_sd_card"));
        } else if (TextUtils.isEmpty(str)) {
            ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_save_err_pic"));
        } else {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + File.separator + "Sobot", "sobot_pic");
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = System.currentTimeMillis() + ".gif";
            File file2 = new File(file, str2);
            if (fileChannelCopy(new File(str), file2)) {
                notifyUpdatePic(file2, str2);
            }
        }
    }
}
