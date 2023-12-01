package com.blued.android.module.media.selector.model;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.module.player.media.model.MediaInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/model/AlbumDataManager.class */
public class AlbumDataManager implements Serializable {
    private static volatile String mCurrentFolderName;
    private static volatile LinkedHashMap<String, List<MediaInfo>> mGroupMap = new LinkedHashMap<>();
    private static List<GroupImageInfo> mGroupFileList = new ArrayList();
    private static volatile List<MediaInfo> mCurrentList = new ArrayList();
    private static volatile MutableLiveData<Boolean> mCurrentListChangeLiveData = new MutableLiveData<>();
    private static AlbumSelectInfo mSelectInfo = new AlbumSelectInfo();
    private static int mCurrentPosition = 0;
    private static int mMaxSelectNum = 9;

    public static int addSelectImage(MediaInfo mediaInfo, int i) {
        AlbumSelectInfo albumSelectInfo = mSelectInfo;
        if (albumSelectInfo != null) {
            return albumSelectInfo.b(mediaInfo);
        }
        return 0;
    }

    public static void addSelectImageList(List<MediaInfo> list) {
        AlbumSelectInfo albumSelectInfo = mSelectInfo;
        if (albumSelectInfo != null) {
            albumSelectInfo.a(list);
        }
    }

    public static void clear() {
        clearSelectImageList();
        clearGroupMap();
        clearGroupList();
        clearCurrentList();
    }

    public static void clearAlbumSelectData() {
        mSelectInfo.a();
    }

    public static void clearCurrentList() {
        if (mCurrentList != null) {
            mCurrentList.clear();
            mCurrentListChangeLiveData.postValue(true);
        }
    }

    public static void clearGroupList() {
        List<GroupImageInfo> list = mGroupFileList;
        if (list != null) {
            list.clear();
        }
    }

    public static void clearGroupMap() {
        if (mGroupMap != null) {
            mGroupMap.clear();
        }
    }

    public static void clearSelectImageList() {
        AlbumSelectInfo albumSelectInfo = mSelectInfo;
        if (albumSelectInfo != null) {
            albumSelectInfo.b();
        }
    }

    public static void copySelectInfo(AlbumSelectInfo albumSelectInfo) {
        mSelectInfo.a(albumSelectInfo);
    }

    public static AlbumSelectInfo getAlbumSelectInfo() {
        return mSelectInfo;
    }

    public static MediaInfo getCurrentChildImageInfo() {
        return getVRChildImageInfo(getCurrentPosition());
    }

    public static String getCurrentFolderName() {
        return mCurrentFolderName;
    }

    public static List<MediaInfo> getCurrentList() {
        return mCurrentList;
    }

    public static LiveData<Boolean> getCurrentListChangeLiveData() {
        return mCurrentListChangeLiveData;
    }

    public static int getCurrentListSize() {
        if (mCurrentList != null) {
            return mCurrentList.size();
        }
        return 0;
    }

    public static int getCurrentPosition() {
        return mCurrentPosition;
    }

    public static List<MediaInfo> getGroupFileList(String str) {
        ArrayList arrayList = new ArrayList();
        if (mGroupMap != null && mGroupMap.containsKey(str)) {
            arrayList.addAll(mGroupMap.get(str));
        }
        return arrayList;
    }

    public static GroupImageInfo getGroupListFileInfo(int i) {
        List<GroupImageInfo> list = mGroupFileList;
        if (list == null || list.size() <= i) {
            return null;
        }
        return mGroupFileList.get(i);
    }

    public static int getGroupListSize() {
        List<GroupImageInfo> list = mGroupFileList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static int getMaxSelectNum() {
        return mMaxSelectNum;
    }

    public static int getMediaTypeImage() {
        return 1;
    }

    public static int getMediaTypeVideo() {
        return 3;
    }

    public static List<MediaInfo> getSelectImageList() {
        return mSelectInfo.c();
    }

    public static int getSelectImageSize() {
        AlbumSelectInfo albumSelectInfo = mSelectInfo;
        if (albumSelectInfo != null) {
            return albumSelectInfo.d();
        }
        return 0;
    }

    public static MediaInfo getVRChildImageInfo(int i) {
        if (getCurrentListSize() > i) {
            return mCurrentList.get(i);
        }
        return null;
    }

    public static void putGroupMap(String str, String str2, MediaInfo mediaInfo) {
        if (mGroupMap.containsKey(str2)) {
            mGroupMap.get(str2).add(mediaInfo);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediaInfo);
            mGroupMap.put(str2, arrayList);
        }
        if (mGroupMap.get(str) == null) {
            mGroupMap.put(str, new LinkedList());
        }
        mGroupMap.get(str).add(mediaInfo);
    }

    public static void removeAll() {
        clearGroupMap();
        clearGroupList();
        clearCurrentList();
    }

    public static int removeFromPath(String str) {
        AlbumSelectInfo albumSelectInfo = mSelectInfo;
        if (albumSelectInfo != null) {
            return albumSelectInfo.a(str);
        }
        return 0;
    }

    public static int removeSelectImage(MediaInfo mediaInfo) {
        return removeFromPath(mediaInfo.imagePath);
    }

    public static void setAlbumSelectInfo(AlbumSelectInfo albumSelectInfo) {
        mSelectInfo.a(albumSelectInfo);
    }

    public static void setCurrentList(String str, List<MediaInfo> list) {
        mCurrentFolderName = str;
        mCurrentList.clear();
        mCurrentList.addAll(list);
        mCurrentListChangeLiveData.postValue(true);
    }

    public static int setCurrentPosition(int i) {
        mCurrentPosition = i;
        return i;
    }

    public static void setMaxSelectNum(int i) {
        mMaxSelectNum = i;
    }

    public static void setSelectMediaType(int i) {
        AlbumSelectInfo albumSelectInfo = mSelectInfo;
        if (albumSelectInfo != null) {
            albumSelectInfo.a(i);
        }
    }

    public static void subGroupOfImage() {
        MediaInfo mediaInfo;
        if (mGroupMap.size() == 0) {
            return;
        }
        clearGroupList();
        for (Map.Entry<String, List<MediaInfo>> entry : mGroupMap.entrySet()) {
            GroupImageInfo groupImageInfo = new GroupImageInfo();
            String key = entry.getKey();
            List<MediaInfo> value = entry.getValue();
            Collections.reverse(value);
            groupImageInfo.setFolderName(key);
            groupImageInfo.setImageCounts(value.size());
            if (value.size() > 0 && (mediaInfo = value.get(0)) != null) {
                groupImageInfo.setMediaType(mediaInfo.media_type);
                if (mediaInfo.media_type == getMediaTypeVideo()) {
                    groupImageInfo.setChildImageInfo(mediaInfo);
                } else if (TextUtils.isEmpty(mediaInfo.imgUri)) {
                    groupImageInfo.setTopImagePath(mediaInfo.imagePath);
                } else {
                    groupImageInfo.topImageUri = mediaInfo.imgUri;
                }
            }
            mGroupFileList.add(groupImageInfo);
        }
    }

    public static void updateGroupFileList(String str, List<MediaInfo> list) {
        synchronized (AlbumDataManager.class) {
            try {
                if (mGroupMap != null && mGroupMap.containsKey(str) && list != null && list.size() > 0) {
                    mGroupMap.put(str, list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getSelectMediaType() {
        AlbumSelectInfo albumSelectInfo = mSelectInfo;
        if (albumSelectInfo != null) {
            return albumSelectInfo.e();
        }
        return 3;
    }
}
