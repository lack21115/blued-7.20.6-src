package com.sobot.chat.widget.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.sobot.chat.R;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.MD5Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/gif/GifView2.class */
public class GifView2 extends View implements View.OnTouchListener {
    public static final float SCALE_MAX = 3.0f;
    private static final float SCALE_MIN = 0.5f;
    private final int DEFAULT_MOVIE_VIEW_DURATION;
    private int currentAnimationTime;
    private double downX;
    private double downY;
    int gifResource;
    private String gifUrl;
    private boolean isCanTouch;
    volatile boolean isPaused;
    boolean isPlaying;
    private boolean isScale;
    private boolean isVisible;
    LoadFinishListener loadFinishListener;
    private double moveDist;
    private double moveRawX;
    private double moveRawY;
    private double moveX;
    private double moveY;
    private Movie movie;
    private float movieLeft;
    private int movieMeasuredMovieHeight;
    private int movieMeasuredMovieWidth;
    private int movieMovieResourceId;
    private float movieScale;
    private long movieStart;
    private float movieTop;
    private double oldDist;
    private int point_num;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/gif/GifView2$LoadFinishListener.class */
    public interface LoadFinishListener {
        void endCallBack(String str);
    }

    public GifView2(Context context) {
        this(context, null);
    }

    public GifView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DEFAULT_MOVIE_VIEW_DURATION = 1000;
        this.movieMovieResourceId = 0;
        this.movieStart = 0L;
        this.isVisible = true;
        this.isCanTouch = false;
        this.point_num = 0;
        this.oldDist = 0.0d;
        this.moveDist = 0.0d;
        this.moveX = 0.0d;
        this.moveY = 0.0d;
        this.downX = 0.0d;
        this.downY = 0.0d;
        this.moveRawX = 0.0d;
        this.moveRawY = 0.0d;
        this.isScale = false;
        setOnTouchListener(this);
    }

    private void drawMovieFrame(Canvas canvas) {
        int i = this.movieMeasuredMovieHeight;
        if (i == 0 || i == 0) {
            canvas.restore();
            return;
        }
        this.movie.setTime(this.currentAnimationTime);
        canvas.save();
        float f = this.movieScale;
        canvas.scale(f, f);
        Movie movie = this.movie;
        float f2 = this.movieLeft;
        float f3 = this.movieScale;
        movie.draw(canvas, f2 / f3, this.movieTop / f3);
        canvas.restore();
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        setLayerType(1, null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sobot_GifView2, i, 16973842);
        this.movieMovieResourceId = obtainStyledAttributes.getResourceId(R.styleable.sobot_GifView2_sobot_gif, -1);
        obtainStyledAttributes.recycle();
        if (this.movieMovieResourceId != -1) {
            this.movie = Movie.decodeStream(getResources().openRawResource(this.movieMovieResourceId));
        }
    }

    private void invalidateView() {
        if (this.isVisible) {
            if (Build.VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
            } else {
                invalidate();
            }
        }
    }

    private void setSelfPivot(float f, float f2) {
        float f3;
        float f4;
        if (getScaleX() <= 1.0d) {
            return;
        }
        float pivotX = getPivotX() + f;
        float pivotY = getPivotY() + f2;
        Log.e("lawwingLog", "setPivotX:" + pivotX + "  setPivotY:" + pivotY + "  getWidth:" + getWidth() + "  getHeight:" + getHeight());
        int i = (pivotX > 0.0f ? 1 : (pivotX == 0.0f ? 0 : -1));
        if (i >= 0 || pivotY >= 0.0f) {
            if (pivotX > 0.0f && pivotY < 0.0f) {
                f3 = pivotX;
                if (pivotX > getWidth()) {
                    f3 = getWidth();
                }
                f4 = 0.0f;
            } else if (i >= 0 || pivotY <= 0.0f) {
                float f5 = pivotX;
                if (pivotX > getWidth()) {
                    f5 = getWidth();
                }
                f3 = f5;
                f4 = pivotY;
                if (pivotY > getHeight()) {
                    f4 = getHeight();
                    f3 = f5;
                }
            } else {
                f4 = pivotY;
                if (pivotY > getHeight()) {
                    f4 = getHeight();
                }
            }
            setPivot(f3, f4);
        }
        f4 = 0.0f;
        f3 = 0.0f;
        setPivot(f3, f4);
    }

    private double spacing(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 2) {
            float x = motionEvent.getX(0) - motionEvent.getX(1);
            float y = motionEvent.getY(0) - motionEvent.getY(1);
            return Math.sqrt((x * x) + (y * y));
        }
        return 0.0d;
    }

    private void updateAnimationTime() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.movieStart == 0) {
            this.movieStart = uptimeMillis;
        }
        long duration = this.movie.duration();
        long j = duration;
        if (duration == 0) {
            j = 1000;
        }
        this.currentAnimationTime = (int) ((uptimeMillis - this.movieStart) % j);
    }

    public void displayImage(String str, File file, GifView2 gifView2) {
        HttpUtils.getInstance().download(str, file, null, new HttpUtils.FileCallBack() { // from class: com.sobot.chat.widget.gif.GifView2.1
            @Override // com.sobot.chat.core.HttpUtils.FileCallBack
            public void inProgress(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.FileCallBack
            public void onError(Exception exc, String str2, int i) {
                LogUtils.w("图片下载失败:" + str2, exc);
            }

            @Override // com.sobot.chat.core.HttpUtils.FileCallBack
            public void onResponse(File file2) {
                LogUtils.i("down load onSuccess gif" + file2.getAbsolutePath());
                if (GifView2.this.loadFinishListener != null) {
                    GifView2.this.loadFinishListener.endCallBack(file2.getAbsolutePath());
                }
            }
        });
    }

    public File getFilesDir(Context context, String str) {
        return isSdCardExist() ? context.getExternalFilesDir(str) : context.getFilesDir();
    }

    public File getImageDir(Context context) {
        return getFilesDir(context, "images");
    }

    public int getMovieMovieResourceId() {
        return this.movieMovieResourceId;
    }

    public boolean isSdCardExist() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.movie != null) {
            if (this.isPaused) {
                drawMovieFrame(canvas);
                return;
            }
            updateAnimationTime();
            drawMovieFrame(canvas);
            invalidateView();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.movieLeft = (getWidth() - this.movieMeasuredMovieWidth) / 2.0f;
        this.movieTop = (getHeight() - this.movieMeasuredMovieHeight) / 2.0f;
        this.isVisible = getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r6, int r7) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.gif.GifView2.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.isVisible = z;
        invalidateView();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.isCanTouch) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.point_num = 1;
                this.downX = motionEvent.getX();
                this.downY = motionEvent.getY();
                return true;
            } else if (action == 1) {
                this.point_num = 0;
                this.downX = 0.0d;
                this.downY = 0.0d;
                if (getScaleX() < 1.0f) {
                    setInitScale();
                }
                this.isScale = false;
                return true;
            } else if (action != 2) {
                if (action != 5) {
                    if (action != 6) {
                        return true;
                    }
                    this.point_num--;
                    return true;
                }
                this.oldDist = spacing(motionEvent);
                int i = this.point_num + 1;
                this.point_num = i;
                if (i >= 2) {
                    this.isScale = true;
                    return true;
                }
                return true;
            } else if (this.point_num == 1 && !this.isScale) {
                this.moveX = motionEvent.getX();
                this.moveY = motionEvent.getY();
                this.moveRawX = motionEvent.getRawX();
                this.moveRawY = motionEvent.getRawY();
                setSelfPivot((float) (this.downX - motionEvent.getX()), (float) (this.downY - motionEvent.getY()));
                return true;
            } else if (this.point_num == 2) {
                double spacing = spacing(motionEvent);
                this.moveDist = spacing;
                float scaleX = (float) (getScaleX() + ((spacing - this.oldDist) / getWidth()));
                if (scaleX > 0.5f && scaleX < 3.0f) {
                    setScale(scaleX);
                    return true;
                } else if (scaleX < 0.5f) {
                    setScale(0.5f);
                    return true;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.isVisible = i == 0;
        invalidateView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisible = i == 0;
        invalidateView();
    }

    public void pause() {
        if (this.isPaused) {
            return;
        }
        this.isPaused = true;
        invalidate();
    }

    public void play() {
        if (this.isPaused) {
            this.isPaused = false;
            this.movieStart = SystemClock.uptimeMillis() - this.currentAnimationTime;
            invalidate();
        }
    }

    public void setGifImage(FileInputStream fileInputStream) {
        if (fileInputStream != null) {
            this.movie = Movie.decodeStream(fileInputStream);
        }
        requestLayout();
    }

    public void setGifImage(FileInputStream fileInputStream, String str) {
        setGifImage(fileInputStream);
        this.gifUrl = str;
        Movie movie = this.movie;
        if (movie == null || movie.width() == 0 || this.movie.height() == 0) {
            displayImage(str, new File(getImageDir(getContext()), MD5Util.encode(str)), this);
        }
    }

    public void setInitScale() {
        setScaleX(1.0f);
        setScaleY(1.0f);
        setPivot(getWidth() / 2, getHeight() / 2);
    }

    public void setIsCanTouch(boolean z) {
        this.isCanTouch = z;
    }

    public void setLoadFinishListener(LoadFinishListener loadFinishListener) {
        this.loadFinishListener = loadFinishListener;
    }

    public void setMovieMovieResourceId(int i, InputStream inputStream) {
        this.movieMovieResourceId = i;
        if (i != -1) {
            this.movie = Movie.decodeStream(getResources().openRawResource(i));
        } else if (inputStream != null) {
            this.movie = Movie.decodeStream(inputStream);
        }
        requestLayout();
    }

    public void setPivot(float f, float f2) {
        setPivotX(f);
        setPivotY(f2);
    }

    public void setScale(float f) {
        setScaleX(f);
        setScaleY(f);
    }
}
