package com.blued.android.module.media.selector.model;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.contract.IBaseCallback;
import com.blued.android.module.media.selector.utils.ThreadPoolHelper;
import com.blued.android.module.media.selector.utils.ThumbLoader;
import com.blued.android.module.player.media.model.MediaInfo;
import com.oplus.quickgame.sdk.hall.Constant;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/model/AlbumLoadDataModel.class */
public class AlbumLoadDataModel extends BaseModel<IAlbumLoadDataCallback> implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String b = AlbumLoadDataModel.class.getSimpleName();
    private static String h;
    private static String i;

    /* renamed from: c  reason: collision with root package name */
    private String f15562c;
    private Uri d;
    private int e;
    private ThumbLoader.GetVideoThumsAsynctack f;
    private boolean g;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/model/AlbumLoadDataModel$IAlbumLoadDataCallback.class */
    public interface IAlbumLoadDataCallback extends IBaseCallback {
        void a(boolean z, String str);

        void d();

        int e();

        long f();

        long g();

        Activity getActivity();
    }

    public AlbumLoadDataModel(Context context, Bundle bundle, IAlbumLoadDataCallback iAlbumLoadDataCallback) {
        super(iAlbumLoadDataCallback);
        boolean z;
        AlbumSelectInfo albumSelectInfo;
        this.e = 0;
        this.g = false;
        if (this.f15566a == 0) {
            return;
        }
        this.f15562c = context.getResources().getString(R.string.foudation_media_all_photos);
        this.d = MediaStore.Files.getContentUri(Constant.Param.KEY_RPK_EXTERNAL);
        if (bundle == null || (albumSelectInfo = (AlbumSelectInfo) bundle.getSerializable("serializeble_data")) == null) {
            z = false;
        } else {
            AlbumDataManager.setAlbumSelectInfo(albumSelectInfo);
            z = true;
        }
        if (z) {
            ((IAlbumLoadDataCallback) this.f15566a).getActivity().getLoaderManager().restartLoader(0, null, this);
        } else {
            ((IAlbumLoadDataCallback) this.f15566a).getActivity().getLoaderManager().initLoader(0, null, this);
        }
    }

    public static String a() {
        if (TextUtils.isEmpty(h)) {
            try {
                h = AppInfo.d().getExternalCacheDir().getParentFile().getAbsolutePath();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (h == null) {
            h = "";
        }
        return h;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (TextUtils.isEmpty(b()) || !str.startsWith(b())) {
            return !TextUtils.isEmpty(a()) && str.startsWith(a());
        }
        return true;
    }

    public static String b() {
        if (TextUtils.isEmpty(i)) {
            try {
                i = AppInfo.d().getCacheDir().getParentFile().getAbsolutePath();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (i == null) {
            i = "";
        }
        return i;
    }

    public static int c() {
        return AlbumDataManager.getMediaTypeVideo();
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    /* renamed from: a */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        LogUtils.c(" onLoadFinished start");
        this.g = AppUtils.b();
        if (this.f15566a == 0) {
            return;
        }
        if (cursor == null) {
            ((IAlbumLoadDataCallback) this.f15566a).a(true, "");
        } else if (this.e == 0) {
            this.e = cursor.getCount();
            if (cursor.isAfterLast()) {
                ((IAlbumLoadDataCallback) this.f15566a).a(true, "");
                return;
            }
            AlbumDataManager.removeAll();
            HashMap hashMap = new HashMap();
            for (MediaInfo mediaInfo : AlbumDataManager.getSelectImageList()) {
                hashMap.put(mediaInfo.imagePath, mediaInfo);
            }
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("_data"));
                try {
                    String name = new File(string).getParentFile().getName();
                    if (!TextUtils.isEmpty(string)) {
                        int i2 = cursor.getInt(cursor.getColumnIndex("media_type"));
                        String string2 = cursor.getString(cursor.getColumnIndex("mime_type"));
                        String string3 = cursor.getString(cursor.getColumnIndex("title"));
                        long j = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                        long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                        long j3 = cursor.getLong(cursor.getColumnIndexOrThrow("duration"));
                        int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("width"));
                        try {
                            int i4 = cursor.getInt(cursor.getColumnIndexOrThrow("height"));
                            if (AppInfo.m()) {
                                LogUtils.c("media_type=" + i2 + ", mime_type=" + string2 + ", path=" + string);
                            }
                            if (i2 == c()) {
                                if (new File(string).exists() && string.endsWith(".mp4")) {
                                    if (this.f15566a == 0) {
                                        return;
                                    }
                                    if (j3 >= ((IAlbumLoadDataCallback) this.f15566a).f() && j3 <= ((IAlbumLoadDataCallback) this.f15566a).g()) {
                                    }
                                }
                            }
                            MediaInfo mediaInfo2 = new MediaInfo();
                            mediaInfo2.id = j;
                            mediaInfo2.media_type = i2;
                            mediaInfo2.mime_type = 0;
                            mediaInfo2.title = string3;
                            if (i2 == c()) {
                                mediaInfo2.path = string;
                                if (this.g && !a(string)) {
                                    mediaInfo2.imgUri = Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, String.valueOf(j)).toString();
                                }
                            } else if (!this.g || a(string)) {
                                mediaInfo2.imagePath = string;
                            } else {
                                mediaInfo2.imgUri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, String.valueOf(j)).toString();
                                mediaInfo2.imagePath = string;
                            }
                            mediaInfo2.width = i3;
                            mediaInfo2.height = i4;
                            mediaInfo2.size = j2;
                            mediaInfo2.videoTime = j3;
                            if (hashMap.containsKey(mediaInfo2.imagePath)) {
                                mediaInfo2.isSelected = true;
                            }
                            AlbumDataManager.putGroupMap(this.f15562c, name, mediaInfo2);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                }
            }
            LogUtils.c(" onLoadFinished cursor end");
            AlbumDataManager.subGroupOfImage();
            final String str = this.f15562c;
            this.f = new ThumbLoader.GetVideoThumsAsynctack(new ThumbLoader.OnGetVideoThumsListener<MediaInfo>() { // from class: com.blued.android.module.media.selector.model.AlbumLoadDataModel.1
                @Override // com.blued.android.module.media.selector.utils.ThumbLoader.OnGetVideoThumsListener
                public void a(List<MediaInfo> list) {
                    AlbumDataManager.updateGroupFileList(str, list);
                    AlbumDataManager.setCurrentList(str, AlbumDataManager.getGroupFileList(str));
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.media.selector.model.AlbumLoadDataModel.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AlbumLoadDataModel.this.f15566a != 0) {
                                ((IAlbumLoadDataCallback) AlbumLoadDataModel.this.f15566a).a(AlbumDataManager.getGroupListSize() <= 0, str);
                            }
                        }
                    });
                }
            }, AlbumDataManager.getGroupFileList(this.f15562c));
            ThreadPoolHelper.a().a(this.f);
        }
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        String str;
        if (this.f15566a == 0) {
            return null;
        }
        ((IAlbumLoadDataCallback) this.f15566a).d();
        String[] strArr = {"_id", "_data", "date_added", "media_type", "mime_type", "title", "_size", "duration", "width", "height"};
        if (((IAlbumLoadDataCallback) this.f15566a).e() == 2) {
            str = strArr[3] + "=3";
        } else if (((IAlbumLoadDataCallback) this.f15566a).e() == 1) {
            str = strArr[3] + "=1";
        } else {
            str = strArr[3] + "=3 OR " + strArr[3] + "=1";
        }
        return new CursorLoader(((IAlbumLoadDataCallback) this.f15566a).getActivity(), this.d, strArr, str, null, strArr[2] + " ASC");
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
