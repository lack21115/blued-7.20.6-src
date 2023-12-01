package com.blued.android.module.shortvideo.model;

import android.graphics.Bitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blued.android.module.shortvideo.contract.IGetFrameCallback;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameCallback;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvThreadPoolHelper;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.blued.android.module.shortvideo.utils.VideoExtractFrameAsyncUtils;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/VideoFrameModel.class */
public class VideoFrameModel extends IModel {
    private static final String Tag = VideoFrameModel.class.getSimpleName();
    public static VideoFrameModel instance;
    private volatile Map<String, StvThreadPoolHelper.StvThread> mOngoingTasks;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/VideoFrameModel$MyLoadVideoFrameForTimeTask.class */
    class MyLoadVideoFrameForTimeTask extends StvThreadPoolHelper.StvThread {
        private String d;
        private long e;
        private VideoExtractFrameAsyncUtils f = new VideoExtractFrameAsyncUtils();
        private IStvVideoFrameForTimeCallback g;

        public MyLoadVideoFrameForTimeTask(String str, long j, IStvVideoFrameForTimeCallback iStvVideoFrameForTimeCallback) {
            this.d = str;
            this.e = j;
            this.g = iStvVideoFrameForTimeCallback;
        }

        @Override // com.blued.android.module.shortvideo.utils.StvThreadPoolHelper.StvThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f.a(this.d, VideoFrameModel.this.getFrameDirectory(), this.e, this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/VideoFrameModel$MyLoadVideoFrameTask.class */
    public class MyLoadVideoFrameTask extends StvThreadPoolHelper.StvThread {
        private String d;
        private String e;
        private long f;
        private long g;
        private int h;
        private int i;
        private int j;
        private VideoExtractFrameAsyncUtils k;
        private IGetFrameCallback l;

        public MyLoadVideoFrameTask(String str, String str2, long j, long j2, int i, int i2, int i3, IGetFrameCallback iGetFrameCallback) {
            this.d = str;
            this.e = str2;
            this.f = j;
            this.g = j2;
            this.h = i;
            this.i = i2;
            this.j = i3;
            this.l = iGetFrameCallback;
            this.k = new VideoExtractFrameAsyncUtils(i2, i3);
        }

        @Override // com.blued.android.module.shortvideo.utils.StvThreadPoolHelper.StvThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            this.k.a(this.e, VideoFrameModel.this.getFrameDirectory(), this.f, this.g, this.h, this.l);
            VideoFrameModel.this.removeLoadFrameTask(this.d);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/VideoFrameModel$MySaveVideoFrameTask.class */
    class MySaveVideoFrameTask extends StvThreadPoolHelper.StvThread {
        private PLVideoFrame d;
        private IStvVideoFrameCallback e;

        public MySaveVideoFrameTask(PLVideoFrame pLVideoFrame, IStvVideoFrameCallback iStvVideoFrameCallback) {
            this.d = null;
            this.d = pLVideoFrame;
            this.e = iStvVideoFrameCallback;
        }

        @Override // com.blued.android.module.shortvideo.utils.StvThreadPoolHelper.StvThread
        public void a() {
            super.a();
            this.e = null;
        }

        @Override // com.blued.android.module.shortvideo.utils.StvThreadPoolHelper.StvThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.b) {
                this.f15861c = false;
                if (this.d == null || !this.b) {
                    StvLogUtils.a(VideoFrameModel.Tag + " videoFrame == null !!!", new Object[0]);
                } else {
                    Bitmap bitmap = this.d.toBitmap();
                    String takePhotoFrameImgPath = VideoFrameModel.this.getTakePhotoFrameImgPath(Long.valueOf(this.d.getTimestampMs()), this.d.getWidth(), this.d.getHeight());
                    if (!new File(takePhotoFrameImgPath).exists()) {
                        StvLogUtils.a(VideoFrameModel.Tag + " 保存帧到本地", new Object[0]);
                        StvTools.a(bitmap, takePhotoFrameImgPath, 100);
                    }
                    if (this.e != null && this.b) {
                        this.e.a(Long.valueOf(this.d.getTimestampMs()), this.d, bitmap, takePhotoFrameImgPath);
                    }
                }
            }
            this.f15861c = true;
        }
    }

    private VideoFrameModel() {
        if (this.mOngoingTasks == null) {
            this.mOngoingTasks = new Hashtable();
        }
    }

    private void addLoadFrameTask(String str, StvThreadPoolHelper.StvThread stvThread) {
        if (this.mOngoingTasks != null) {
            this.mOngoingTasks.put(str, stvThread);
        }
    }

    public static VideoFrameModel getInstance() {
        if (instance == null) {
            synchronized (VideoFrameModel.class) {
                try {
                    if (instance == null) {
                        instance = new VideoFrameModel();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private StvThreadPoolHelper.StvThread getLoadFrameTask(String str) {
        if (this.mOngoingTasks != null) {
            return this.mOngoingTasks.get(str);
        }
        return null;
    }

    private String getVideoFrameKey(Object obj, int i, int i2) {
        return obj + "-" + i + "-" + i2 + "-" + System.currentTimeMillis();
    }

    private String getVideoFrameKey(String str, int i, int i2) {
        return str + "-" + i + "-" + i2;
    }

    private String getVideoFrameKey(String str, Object obj, int i, int i2) {
        return str + "-" + obj + "-" + i + "-" + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLoadFrameTask(String str) {
        synchronized (this) {
            if (this.mOngoingTasks != null) {
                this.mOngoingTasks.remove(str);
            }
        }
    }

    public void clear() {
        if (this.mOngoingTasks != null) {
            for (Map.Entry<String, StvThreadPoolHelper.StvThread> entry : this.mOngoingTasks.entrySet()) {
                StvThreadPoolHelper.StvThread value = entry.getValue();
                if (value != null) {
                    value.a();
                    value.interrupt();
                }
            }
            this.mOngoingTasks.clear();
        }
        instance = null;
    }

    public String getFrameDirectory() {
        return StvTools.a(TypedValues.AttributesType.S_FRAME);
    }

    public String getTakePhotoFrameImgPath(Object obj, int i, int i2) {
        getVideoFrameKey(obj, i, i2);
        return StvTools.b(TypedValues.AttributesType.S_FRAME);
    }

    public void getVideoFrame(String str, long j, long j2, int i, int i2, int i3, IGetFrameCallback iGetFrameCallback) {
        String videoFrameKey = getVideoFrameKey(str, i2, i3);
        MyLoadVideoFrameTask myLoadVideoFrameTask = (MyLoadVideoFrameTask) getLoadFrameTask(videoFrameKey);
        if (myLoadVideoFrameTask == null || !myLoadVideoFrameTask.b()) {
            MyLoadVideoFrameTask myLoadVideoFrameTask2 = new MyLoadVideoFrameTask(videoFrameKey, str, j, j2, i, i2, i3, iGetFrameCallback);
            addLoadFrameTask(videoFrameKey, myLoadVideoFrameTask2);
            StvThreadPoolHelper.a().b(myLoadVideoFrameTask2);
        }
    }

    public void saveVideoFrameByTime(String str, long j, IStvVideoFrameForTimeCallback iStvVideoFrameForTimeCallback) {
        StvThreadPoolHelper.a().b(new MyLoadVideoFrameForTimeTask(str, j, iStvVideoFrameForTimeCallback));
    }

    public void saveVideoFrameToPicture(PLVideoFrame pLVideoFrame, IStvVideoFrameCallback iStvVideoFrameCallback) {
        StvThreadPoolHelper.a().a((Runnable) new MySaveVideoFrameTask(pLVideoFrame, iStvVideoFrameCallback));
    }
}
