package com.sobot.chat.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.android.internal.telephony.PhoneConstants;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.application.MyApplication;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.utils.ImageUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.MD5Util;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.widget.RoundProgressBar;
import com.sobot.chat.widget.SelectPicPopupWindow;
import com.sobot.chat.widget.gif.GifView2;
import com.sobot.chat.widget.subscaleview.ImageSource;
import com.sobot.chat.widget.subscaleview.SobotScaleImageView;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotPhotoActivity.class */
public class SobotPhotoActivity extends Activity implements View.OnLongClickListener {
    Bitmap bitmap;
    private View.OnLongClickListener gifLongClickListener = new View.OnLongClickListener() { // from class: com.sobot.chat.activity.SobotPhotoActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (TextUtils.isEmpty(SobotPhotoActivity.this.sdCardPath) || !new File(SobotPhotoActivity.this.sdCardPath).exists()) {
                return false;
            }
            SobotPhotoActivity sobotPhotoActivity = SobotPhotoActivity.this;
            SobotPhotoActivity sobotPhotoActivity2 = SobotPhotoActivity.this;
            sobotPhotoActivity.menuWindow = new SelectPicPopupWindow(sobotPhotoActivity2, sobotPhotoActivity2.sdCardPath, "gif");
            try {
                SobotPhotoActivity.this.menuWindow.showAtLocation(SobotPhotoActivity.this.sobot_rl_gif, 81, 0, 0);
                return false;
            } catch (Exception e) {
                SobotPhotoActivity.this.menuWindow = null;
                return false;
            }
        }
    };
    String imageUrL;
    boolean isRight;
    private SobotScaleImageView mImageView;
    private SelectPicPopupWindow menuWindow;
    String sdCardPath;
    private GifView2 sobot_image_view;
    private RoundProgressBar sobot_progress;
    private RelativeLayout sobot_rl_gif;

    private void initBundleData(Bundle bundle) {
        if (bundle == null) {
            this.imageUrL = getIntent().getStringExtra("imageUrL");
            this.isRight = getIntent().getBooleanExtra("isRight", false);
            return;
        }
        this.imageUrL = bundle.getString("imageUrL");
        this.isRight = bundle.getBoolean("isRight");
    }

    private void showGif(String str) {
        int i;
        int i2;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            this.bitmap = BitmapFactory.decodeFile(str);
            this.sobot_image_view.setGifImage(fileInputStream, this.imageUrL);
            int screenWidth = ScreenUtils.getScreenWidth(this);
            int screenHeight = ScreenUtils.getScreenHeight(this);
            int formatDipToPx = ScreenUtils.formatDipToPx((Context) this, this.bitmap.getWidth());
            int formatDipToPx2 = ScreenUtils.formatDipToPx((Context) this, this.bitmap.getHeight());
            if (formatDipToPx != formatDipToPx2) {
                if (formatDipToPx > screenWidth) {
                    int i3 = (int) (formatDipToPx2 * ((screenWidth * 1.0f) / formatDipToPx));
                    formatDipToPx = screenWidth;
                    i = i3;
                } else {
                    i = formatDipToPx2;
                }
                if (i > screenHeight) {
                    screenWidth = (int) (formatDipToPx * ((screenHeight * 1.0f) / i));
                    i2 = screenHeight;
                } else {
                    int i4 = formatDipToPx;
                    i2 = i;
                    screenWidth = i4;
                }
            } else if (formatDipToPx > screenWidth) {
                i2 = screenWidth;
            } else {
                screenWidth = formatDipToPx;
                i2 = formatDipToPx2;
            }
            LogUtils.i("bitmap" + screenWidth + PhoneConstants.APN_TYPE_ALL + i2);
            this.sobot_image_view.setLayoutParams(new RelativeLayout.LayoutParams(screenWidth, i2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.sobot_rl_gif.setVisibility(0);
        this.sobot_rl_gif.setOnLongClickListener(this.gifLongClickListener);
        this.sobot_image_view.setOnLongClickListener(this.gifLongClickListener);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void displayImage(String str, File file, GifView2 gifView2) {
        this.sobot_progress.setVisibility(0);
        HttpUtils.getInstance().download(str, file, null, new HttpUtils.FileCallBack() { // from class: com.sobot.chat.activity.SobotPhotoActivity.5
            @Override // com.sobot.chat.core.HttpUtils.FileCallBack
            public void inProgress(int i) {
                SobotPhotoActivity.this.sobot_progress.setProgress(i);
            }

            @Override // com.sobot.chat.core.HttpUtils.FileCallBack
            public void onError(Exception exc, String str2, int i) {
                LogUtils.w("图片下载失败:" + str2, exc);
            }

            @Override // com.sobot.chat.core.HttpUtils.FileCallBack
            public void onResponse(File file2) {
                LogUtils.i("down load onSuccess gif" + file2.getAbsolutePath());
                SobotPhotoActivity.this.showView(file2.getAbsolutePath());
                SobotPhotoActivity.this.sobot_progress.setProgress(100);
                SobotPhotoActivity.this.sobot_progress.setVisibility(8);
            }
        });
    }

    public File getFilesDir(Context context, String str) {
        return isSdCardExist() ? context.getExternalFilesDir(str) : context.getFilesDir();
    }

    public File getImageDir(Context context) {
        return getFilesDir(context, "images");
    }

    public boolean isSdCardExist() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.mImageView.playSoundEffect(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(ResourceUtils.getIdByName(this, "layout", "sobot_photo_activity"));
        MyApplication.getInstance().addActivity(this);
        RoundProgressBar roundProgressBar = (RoundProgressBar) findViewById(ResourceUtils.getResId(this, "sobot_pic_progress_round"));
        this.sobot_progress = roundProgressBar;
        roundProgressBar.setRoundWidth(10.0f);
        this.sobot_progress.setCricleProgressColor(-1);
        this.sobot_progress.setTextColor(-1);
        this.sobot_progress.setTextDisplayable(true);
        this.sobot_progress.setVisibility(8);
        this.mImageView = (SobotScaleImageView) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_big_photo"));
        GifView2 gifView2 = (GifView2) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_image_view"));
        this.sobot_image_view = gifView2;
        gifView2.setIsCanTouch(true);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_rl_gif"));
        this.sobot_rl_gif = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotPhotoActivity.this.finish();
            }
        });
        this.sobot_image_view.setLoadFinishListener(new GifView2.LoadFinishListener() { // from class: com.sobot.chat.activity.SobotPhotoActivity.2
            @Override // com.sobot.chat.widget.gif.GifView2.LoadFinishListener
            public void endCallBack(String str) {
                SobotPhotoActivity.this.showView(str);
            }
        });
        initBundleData(bundle);
        LogUtils.i("SobotPhotoActivity-------" + this.imageUrL);
        if (TextUtils.isEmpty(this.imageUrL)) {
            return;
        }
        if (this.imageUrL.startsWith("http")) {
            File file = new File(getImageDir(this), MD5Util.encode(this.imageUrL));
            this.sdCardPath = file.getAbsolutePath();
            if (file.exists()) {
                showView(file.getAbsolutePath());
            } else {
                if (this.imageUrL.contains("?")) {
                    String str = this.imageUrL;
                    this.imageUrL = str.substring(0, str.indexOf("?"));
                }
                displayImage(this.imageUrL, file, this.sobot_image_view);
            }
        } else {
            File file2 = new File(this.imageUrL);
            this.sdCardPath = this.imageUrL;
            if (file2.exists()) {
                showView(this.imageUrL);
            }
        }
        this.sobot_rl_gif.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        this.sobot_image_view.pause();
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.bitmap.recycle();
            System.gc();
        }
        SelectPicPopupWindow selectPicPopupWindow = this.menuWindow;
        if (selectPicPopupWindow != null && selectPicPopupWindow.isShowing()) {
            try {
                this.menuWindow.dismiss();
            } catch (Exception e) {
            }
            this.menuWindow = null;
        }
        MyApplication.getInstance().deleteActivity(this);
        super.onDestroy();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (TextUtils.isEmpty(this.sdCardPath) || !new File(this.sdCardPath).exists()) {
            return false;
        }
        SelectPicPopupWindow selectPicPopupWindow = new SelectPicPopupWindow(this, this.sdCardPath, "jpg/png", true);
        this.menuWindow = selectPicPopupWindow;
        try {
            selectPicPopupWindow.showAtLocation(this.sobot_rl_gif, 81, 0, 0);
            return false;
        } catch (Exception e) {
            this.menuWindow = null;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("imageUrL", this.imageUrL);
        bundle.putBoolean("isRight", this.isRight);
        super.onSaveInstanceState(bundle);
    }

    void showView(String str) {
        if (!TextUtils.isEmpty(this.imageUrL) && ((this.imageUrL.endsWith(".gif") || this.imageUrL.endsWith(".GIF")) && this.isRight)) {
            showGif(str);
        } else if (!TextUtils.isEmpty(this.imageUrL) && (this.imageUrL.endsWith(".gif") || this.imageUrL.endsWith(".GIF"))) {
            showGif(str);
        } else {
            this.bitmap = SobotBitmapUtil.compress(str, getApplicationContext(), true);
            try {
                int readPictureDegree = ImageUtils.readPictureDegree(str);
                if (readPictureDegree > 0) {
                    this.bitmap = ImageUtils.rotateBitmap(this.bitmap, readPictureDegree);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mImageView.setImage(ImageSource.bitmap(this.bitmap));
            this.mImageView.setVisibility(0);
            this.mImageView.setMinimumDpi(50);
            this.mImageView.setMinimumTileDpi(240);
            this.mImageView.setDoubleTapZoomStyle(1);
            this.mImageView.setDoubleTapZoomScale(2.0f);
            this.mImageView.setPanLimit(1);
            this.mImageView.setPanEnabled(true);
            this.mImageView.setZoomEnabled(true);
            this.mImageView.setQuickScaleEnabled(true);
            this.mImageView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotPhotoActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SobotPhotoActivity.this.mImageView.playSoundEffect(0);
                    SobotPhotoActivity.this.finish();
                }
            });
            this.mImageView.setOnLongClickListener(this.gifLongClickListener);
        }
    }
}
