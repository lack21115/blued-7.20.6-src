package com.blued.android.module.shortvideo.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.FileUtils;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.base.shortvideo.ISaveInterface;
import com.blued.android.module.base.shortvideo.ITranscodingVideoListener;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.external_sense_library.manager.SenseTimeFactory;
import com.blued.android.module.external_sense_library.manager.SenseTimeQiniuEditVideoManager;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.model.VideoFrameModel;
import com.blued.android.module.shortvideo.utils.StvThreadPoolHelper;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEditor;
import com.qiniu.pili.droid.shortvideo.PLShortVideoTranscoder;
import com.qiniu.pili.droid.shortvideo.PLVideoEditSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvMediaUtils.class */
public class StvMediaUtils {
    static PLShortVideoEditor a;
    static PLShortVideoTranscoder b;

    public static EditDataModel a(String str) {
        EditDataModel editDataModel = new EditDataModel();
        editDataModel.setSaveVideoPath(str);
        editDataModel.isNeedTranscodeAgain(str);
        if (!editDataModel.isTranscode()) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mediaExtractor.getTrackCount()) {
                    break;
                }
                String string = mediaExtractor.getTrackFormat(i2).getString("mime");
                if (string.startsWith("video/")) {
                    if (string.equals("video/avc")) {
                        editDataModel.getSerializableData().p = false;
                        return editDataModel;
                    }
                    editDataModel.getSerializableData().p = true;
                    return editDataModel;
                }
                i = i2 + 1;
            }
        }
        return editDataModel;
    }

    public static void a() {
        PLShortVideoTranscoder pLShortVideoTranscoder = b;
        if (pLShortVideoTranscoder != null) {
            pLShortVideoTranscoder.cancelTranscode();
        }
    }

    public static void a(final Context context, CommonModel commonModel, EditDataModel.SerializableData serializableData, final int i, int i2, final ISaveInterface iSaveInterface) {
        if (commonModel == null && serializableData == null) {
            if (iSaveInterface != null) {
                iSaveInterface.a(-1);
                return;
            }
            return;
        }
        final EditDataModel editDataModel = new EditDataModel();
        editDataModel.copyModel(commonModel, serializableData);
        editDataModel.setScreenWidth(context.getResources().getDisplayMetrics().widthPixels);
        String videoPath = editDataModel.getSerializableData().getVideoPath();
        if (StringUtils.b(videoPath)) {
            if (iSaveInterface != null) {
                iSaveInterface.a(-1);
                return;
            }
            return;
        }
        GLSurfaceView gLSurfaceView = new GLSurfaceView(context);
        gLSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        PLVideoEditSetting pLVideoEditSetting = new PLVideoEditSetting();
        pLVideoEditSetting.setSourceFilepath(videoPath);
        pLVideoEditSetting.setDestFilepath(StvTools.c());
        a = new PLShortVideoEditor(gLSurfaceView, pLVideoEditSetting);
        if (editDataModel.getSerializableData().isHasBgMusic()) {
            a(editDataModel, a, editDataModel.getSerializableData().getMusicPath());
        }
        float f = editDataModel.getSerializableData().a / 100.0f;
        float f2 = 0.0f;
        if (editDataModel.getSerializableData().isHasBgMusic()) {
            f2 = editDataModel.getSerializableData().b / 100.0f;
        }
        a.setAudioMixVolume(f, f2);
        final SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = (SenseTimeQiniuEditVideoManager) SenseTimeFactory.createInstance(context, 2);
        FilterItem selectedFilter = editDataModel.getSerializableData().getSelectedFilter();
        if (selectedFilter != null) {
            senseTimeQiniuEditVideoManager.enableBeautify(false);
            senseTimeQiniuEditVideoManager.setFilterStyle(selectedFilter.b());
        }
        editDataModel.calculateEncodingSize(editDataModel.getVideoBitrate(), editDataModel.getVideoWidth(), editDataModel.getVideoHeight());
        if (editDataModel.getVideoBitrate() != editDataModel.getEncodingVideoBitrate() || editDataModel.getVideoHeight() != editDataModel.getEncodingH() || editDataModel.getVideoWidth() != editDataModel.getEncodingW()) {
            PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(context);
            pLVideoEncodeSetting.setEncodingBitrate(editDataModel.getEncodingVideoBitrate());
            pLVideoEncodeSetting.setEncodingFps(30);
            pLVideoEncodeSetting.setHWCodecEnabled(VideoConfigData.a.booleanValue());
            pLVideoEncodeSetting.setEncodingBitrateMode(PLVideoEncodeSetting.BitrateMode.QUALITY_PRIORITY);
            pLVideoEncodeSetting.setPreferredEncodingSize(editDataModel.getEncodingW(), editDataModel.getEncodingH());
            a.setVideoEncodeSetting(pLVideoEncodeSetting);
        }
        a.setVideoSaveListener(new PLVideoSaveListener() { // from class: com.blued.android.module.shortvideo.utils.StvMediaUtils.1
            public void onProgressUpdate(float f3) {
                ISaveInterface iSaveInterface2 = iSaveInterface;
                if (iSaveInterface2 != null) {
                    iSaveInterface2.a(f3);
                }
            }

            public void onSaveVideoCanceled() {
                ISaveInterface iSaveInterface2 = iSaveInterface;
                if (iSaveInterface2 != null) {
                    iSaveInterface2.a();
                }
                StvMediaUtils.a = null;
            }

            public void onSaveVideoFailed(int i3) {
                ISaveInterface iSaveInterface2 = iSaveInterface;
                if (iSaveInterface2 != null) {
                    iSaveInterface2.a(i3);
                }
                StvMediaUtils.a = null;
            }

            public void onSaveVideoSuccess(String str) {
                int i3 = i;
                if (i3 == 0 || i3 == 3) {
                    StvMediaUtils.b(editDataModel, context, str, i, iSaveInterface);
                } else {
                    StvMediaUtils.b(editDataModel, str, context, i3, iSaveInterface);
                }
                StvMediaUtils.a = null;
            }
        });
        if (selectedFilter != null) {
            if (iSaveInterface != null) {
                iSaveInterface.b();
            }
            a.save(new PLVideoFilterListener() { // from class: com.blued.android.module.shortvideo.utils.StvMediaUtils.2
                public int onDrawFrame(int i3, int i4, int i5, long j, float[] fArr) {
                    return SenseTimeQiniuEditVideoManager.this.drawFrame(i3, i4, i5, false);
                }

                public void onSurfaceChanged(int i3, int i4) {
                    SenseTimeQiniuEditVideoManager.this.adjustViewPort(i3, i4);
                }

                public void onSurfaceCreated() {
                    SenseTimeQiniuEditVideoManager.this.onSurfaceCreated();
                }

                public void onSurfaceDestroy() {
                    SenseTimeQiniuEditVideoManager.this.onSurfaceDestroyed();
                }
            });
            return;
        }
        if (editDataModel.getSerializableData().isHasBgMusic() && iSaveInterface != null) {
            iSaveInterface.b();
        }
        a.save();
    }

    public static void a(final Context context, final String str) {
        if (StringUtils.b(str)) {
            return;
        }
        Logger.c("StvMediaUtils", "photoAlbumScanFile filepath" + str);
        ThreadManager.a().a(new ThreadExecutor("compressVideoToAndroidQ") { // from class: com.blued.android.module.shortvideo.utils.StvMediaUtils.7
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                StvMediaUtils.a(str, context);
            }
        });
    }

    public static void a(final EditDataModel editDataModel, final ITranscodingVideoListener iTranscodingVideoListener) {
        if (iTranscodingVideoListener == null || editDataModel == null) {
            return;
        }
        String e = StvTools.e();
        editDataModel.calculateEncodingSize(editDataModel.getVideoBitrate(), editDataModel.getVideoWidth(), editDataModel.getVideoHeight());
        PLShortVideoTranscoder pLShortVideoTranscoder = new PLShortVideoTranscoder(AppInfo.d(), editDataModel.getSaveVideoPath(), e);
        b = pLShortVideoTranscoder;
        pLShortVideoTranscoder.transcode(editDataModel.getEncodingW(), editDataModel.getEncodingH(), editDataModel.getEncodingVideoBitrate(), new PLVideoSaveListener() { // from class: com.blued.android.module.shortvideo.utils.StvMediaUtils.6
            public void onProgressUpdate(float f) {
                ITranscodingVideoListener.this.a(editDataModel.getSaveVideoPath(), f * 100.0f);
            }

            public void onSaveVideoCanceled() {
                ITranscodingVideoListener.this.a(false, editDataModel.getSaveVideoPath(), null);
            }

            public void onSaveVideoFailed(int i) {
                ITranscodingVideoListener.this.a(false, editDataModel.getSaveVideoPath(), null);
            }

            public void onSaveVideoSuccess(String str) {
                ITranscodingVideoListener.this.a(true, editDataModel.getSaveVideoPath(), str);
                editDataModel.setSaveVideoPath(str);
            }
        });
    }

    public static void a(EditDataModel editDataModel, PLShortVideoEditor pLShortVideoEditor, String str) {
        editDataModel.getSerializableData().setHasBgMusic(true);
        editDataModel.getSerializableData().setMusicPath(str);
        pLShortVideoEditor.setAudioMixFile(str);
        a(pLShortVideoEditor, editDataModel, editDataModel.getCurrentFgVolume(), 100);
    }

    public static void a(PLShortVideoEditor pLShortVideoEditor, EditDataModel editDataModel, int i, int i2) {
        editDataModel.setCurrentFgVolume(i);
        editDataModel.setCurrentBgVolume(i2);
        if (pLShortVideoEditor != null) {
            pLShortVideoEditor.setAudioMixVolume(i / 100.0f, i2 / 100.0f);
        }
    }

    public static void a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            if (mediaMetadataRetriever.extractMetadata(18) == null || mediaMetadataRetriever.extractMetadata(19) == null || mediaMetadataRetriever.extractMetadata(9) == null) {
                return;
            }
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
            long currentTimeMillis = System.currentTimeMillis();
            String name = file.getName();
            String name2 = file.getName();
            ContentValues contentValues = new ContentValues(9);
            contentValues.put("title", name);
            contentValues.put("_display_name", name2);
            contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
            contentValues.put("date_modified", Long.valueOf(currentTimeMillis / 1000));
            contentValues.put("mime_type", "video/mp4");
            contentValues.put("width", Integer.valueOf(parseInt));
            contentValues.put("height", Integer.valueOf(parseInt2));
            contentValues.put("resolution", Integer.toString(parseInt) + "x" + Integer.toString(parseInt2));
            contentValues.put("_size", Long.valueOf(new File(str).length()));
            contentValues.put("duration", Integer.valueOf(parseInt3));
            if (AppUtils.b()) {
                contentValues.put("relative_path", "DCIM/Camera");
            } else {
                contentValues.put("_data", str);
            }
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = null;
            try {
                uri = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Uri uri2 = uri;
            if (uri == null) {
                try {
                    uri2 = contentResolver.insert(MediaStore.Video.Media.INTERNAL_CONTENT_URI, contentValues);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    uri2 = uri;
                }
            }
            if (AppUtils.b()) {
                try {
                    OutputStream openOutputStream = contentResolver.openOutputStream(uri2);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileUtils.copy(fileInputStream, openOutputStream);
                    fileInputStream.close();
                    openOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(EditDataModel editDataModel, int i, ISaveInterface iSaveInterface) {
        if (iSaveInterface == null || editDataModel == null) {
            return;
        }
        StvResultModel stvResultModel = new StvResultModel();
        stvResultModel.a(true);
        stvResultModel.b(editDataModel.getCoverImgPath());
        stvResultModel.c(editDataModel.getSaveVideoPath());
        stvResultModel.a(editDataModel.getSaveVideoWidth());
        stvResultModel.b(editDataModel.getSaveVideoHeight());
        stvResultModel.a(editDataModel.getSaveDurationMs());
        stvResultModel.b(editDataModel.getVideoSize());
        stvResultModel.d(editDataModel.getSerializableData().getMusicId());
        stvResultModel.c(editDataModel.getSerializableData().getSelectFilterPosition());
        if (i == 1 || i == 7) {
            stvResultModel.b(editDataModel.isAutoDelete());
        }
        iSaveInterface.a(stvResultModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final EditDataModel editDataModel, Context context, final String str, final int i, final ISaveInterface iSaveInterface) {
        final String videoPath = editDataModel.getSerializableData().getVideoPath();
        final String needDeleteVideoPath = editDataModel.getNeedDeleteVideoPath();
        final boolean isCanDeleteVideoFile = editDataModel.getSerializableData().isCanDeleteVideoFile();
        StvThreadPoolHelper.a().a((Runnable) new StvThreadPoolHelper.StvThread(new Runnable() { // from class: com.blued.android.module.shortvideo.utils.StvMediaUtils.4
            @Override // java.lang.Runnable
            public void run() {
                if (isCanDeleteVideoFile && !TextUtils.isEmpty(videoPath) && !videoPath.equals(editDataModel.getSerializableData().getOriginalVideoPath()) && !videoPath.equals(str)) {
                    File file = new File(videoPath);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                if (TextUtils.isEmpty(needDeleteVideoPath) || needDeleteVideoPath.equals(editDataModel.getSerializableData().getOriginalVideoPath()) || needDeleteVideoPath.equals(str)) {
                    return;
                }
                File file2 = new File(needDeleteVideoPath);
                if (file2.exists()) {
                    file2.delete();
                }
            }
        }));
        if (editDataModel.getSerializableData().isAddAblum()) {
            a(context, str);
        }
        editDataModel.setSaveVideoPath(str);
        editDataModel.getSerializableData().setMusicPath(editDataModel.getSerializableData().getMusicPath());
        if (TextUtils.isEmpty(editDataModel.getCoverImgPath())) {
            VideoFrameModel.getInstance().saveVideoFrameByTime(editDataModel.getSaveVideoPath(), editDataModel.getCurrentCoverTime(), new IStvVideoFrameForTimeCallback() { // from class: com.blued.android.module.shortvideo.utils.StvMediaUtils.5
                @Override // com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback
                public void a(final String str2) {
                    new Thread(new Runnable() { // from class: com.blued.android.module.shortvideo.utils.StvMediaUtils.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            EditDataModel.this.setCoverImgPath(str2);
                            StvMediaUtils.b(EditDataModel.this, i, iSaveInterface);
                        }
                    }).start();
                }
            });
        } else {
            b(editDataModel, i, iSaveInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final EditDataModel editDataModel, String str, final Context context, final int i, final ISaveInterface iSaveInterface) {
        if (editDataModel == null) {
            return;
        }
        if (!editDataModel.isNeedTranscodeAgain(str)) {
            if (editDataModel.getSerializableData().getVideoPath().equals(str) || str.equals(editDataModel.getSerializableData().getOriginalVideoPath())) {
                editDataModel.getSerializableData().setCanDeleteVideoFile(false);
            } else {
                editDataModel.getSerializableData().setCanDeleteVideoFile(true);
            }
            b(editDataModel, context, str, i, iSaveInterface);
            return;
        }
        String e = StvTools.e();
        editDataModel.setNeedDeleteVideoPath(str);
        editDataModel.calculateEncodingSize(editDataModel.getVideoBitrate(), editDataModel.getVideoWidth(), editDataModel.getVideoHeight());
        PLShortVideoTranscoder pLShortVideoTranscoder = new PLShortVideoTranscoder(context, str, e);
        if (iSaveInterface != null) {
            iSaveInterface.b();
        }
        pLShortVideoTranscoder.transcode(editDataModel.getEncodingW(), editDataModel.getEncodingH(), editDataModel.getEncodingVideoBitrate(), new PLVideoSaveListener() { // from class: com.blued.android.module.shortvideo.utils.StvMediaUtils.3
            public void onProgressUpdate(float f) {
                ISaveInterface iSaveInterface2 = iSaveInterface;
                if (iSaveInterface2 != null) {
                    iSaveInterface2.a(f);
                }
            }

            public void onSaveVideoCanceled() {
                ISaveInterface iSaveInterface2 = iSaveInterface;
                if (iSaveInterface2 != null) {
                    iSaveInterface2.a();
                }
            }

            public void onSaveVideoFailed(int i2) {
                ISaveInterface iSaveInterface2 = iSaveInterface;
                if (iSaveInterface2 != null) {
                    iSaveInterface2.a(i2);
                }
            }

            public void onSaveVideoSuccess(String str2) {
                StvMediaUtils.b(EditDataModel.this, context, str2, i, iSaveInterface);
            }
        });
    }

    public static byte[] b(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
