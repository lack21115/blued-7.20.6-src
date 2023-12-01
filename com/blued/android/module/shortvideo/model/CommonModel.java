package com.blued.android.module.shortvideo.model;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.shortvideo.contract.IGetFrameCallback;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/CommonModel.class */
public class CommonModel extends IModel implements Serializable {
    public static final int FLING_MIN_DISTANCE = 80;
    public static final int SHOW_V_DEFAULT = 0;
    public static final int SHOW_V_FILTER = 2;
    private static final String Tag = CommonModel.class.getSimpleName();
    protected List<FilterItem> mFilters;
    protected FilterItem mSelectedFilter;
    protected String musicId;
    protected String musicName;
    protected String musicPath;
    protected String originalVideoPath;
    protected String videoPath;
    private long MAX_RECORD_DURATION = 15000;
    private long MIN_RECORD_DURATION = 3000;
    private long MAX_VIDEO_DURATION = 60000;
    private long MIN_VIDEO_DURATION = 3000;
    private int SHOW_V_TYPE = 0;
    protected int prePage = 0;
    protected int from = 0;
    protected int nextPage = 0;
    protected int currentPage = 0;
    protected boolean isPrivilegeUser = false;
    protected int mSelectFilterPosition = 0;
    public boolean openBeauty = false;
    protected boolean isAddMusic = false;
    protected boolean mHasBgMusic = false;
    protected boolean canDeleteVideoFile = true;
    protected boolean useData = false;
    protected boolean isAddAblum = false;

    private void setMusicId(String str) {
        this.musicId = str;
    }

    public void clear() {
        this.MAX_RECORD_DURATION = 15000L;
        this.MIN_RECORD_DURATION = 3000L;
        this.SHOW_V_TYPE = 0;
        this.prePage = 0;
        List<FilterItem> list = this.mFilters;
        if (list != null) {
            list.clear();
        }
        this.mSelectedFilter = null;
        this.mSelectFilterPosition = 0;
        this.mHasBgMusic = false;
        this.isAddMusic = false;
        this.isPrivilegeUser = false;
        this.videoPath = null;
        this.musicPath = null;
        this.musicId = null;
        this.useData = false;
        this.openBeauty = false;
        this.canDeleteVideoFile = true;
    }

    public void copyModel(CommonModel commonModel) {
        copyModel(commonModel, false);
    }

    public void copyModel(CommonModel commonModel, boolean z) {
        setFrom(commonModel.getFrom());
        if (z) {
            setPrePageType(commonModel.getCurrentPage());
        } else {
            setPrePageType(commonModel.getPrePageType());
            setCurrentPage(commonModel.getCurrentPage());
        }
        setOpenBeauty(commonModel.isOpenBeauty());
        setVideoPath(commonModel.getVideoPath());
        setMusicPath(commonModel.getMusicPath());
        setMusicName(commonModel.getMusicName());
        setSelectedFilter(commonModel.getSelectedFilter());
        setSelectFilterPosition(commonModel.getSelectFilterPosition());
        setMaxRecordDuration(commonModel.getMaxRecordDuration());
        setMinRecordDuration(commonModel.getMinRecordDuration());
        setMaxVideoDuration(commonModel.getMaxVideoDuration());
        setMinVideoDuration(commonModel.getMinVideoDuration());
        setPrivilegeUser(commonModel.isPrivilegeUser());
        setCanDeleteVideoFile(commonModel.isCanDeleteVideoFile());
        this.mHasBgMusic = commonModel.mHasBgMusic;
        this.originalVideoPath = commonModel.originalVideoPath;
        this.isAddAblum = commonModel.isAddAblum;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<FilterItem> getFilters() {
        return this.mFilters;
    }

    public int getFrom() {
        return this.from;
    }

    public long getMaxRecordDuration() {
        long j;
        synchronized (this) {
            j = this.MAX_RECORD_DURATION;
        }
        return j;
    }

    public long getMaxVideoDuration() {
        long j;
        synchronized (this) {
            j = this.MAX_VIDEO_DURATION;
        }
        return j;
    }

    public long getMinRecordDuration() {
        return this.MIN_RECORD_DURATION;
    }

    public float getMinRecordDurationPre() {
        return (((float) getMinRecordDuration()) * 1.0f) / ((float) getMaxRecordDuration());
    }

    public long getMinVideoDuration() {
        long j;
        synchronized (this) {
            j = this.MIN_VIDEO_DURATION;
        }
        return j;
    }

    public String getMusicId() {
        StvLogUtils.a(Tag + " 获取音乐Id:" + this.musicId, new Object[0]);
        return this.musicId;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public String getMusicPath() {
        return this.musicPath;
    }

    public int getNextPage() {
        return this.nextPage;
    }

    public String getOriginalVideoPath() {
        return this.originalVideoPath;
    }

    public int getPrePageType() {
        return this.prePage;
    }

    public int getSelectFilterPosition() {
        int i;
        synchronized (this) {
            i = this.mSelectFilterPosition;
        }
        return i;
    }

    public FilterItem getSelectedFilter() {
        return this.mSelectedFilter;
    }

    public int getShowVType() {
        return this.SHOW_V_TYPE;
    }

    public void getVideoFrame(long j, long j2, int i, int i2, int i3, IGetFrameCallback iGetFrameCallback) {
        VideoFrameModel.getInstance().getVideoFrame(getVideoPath(), j, j2, i, i2, i3, iGetFrameCallback);
    }

    public String getVideoPath() {
        StvLogUtils.a(Tag + " getVideoPath: " + this.videoPath, new Object[0]);
        return this.videoPath;
    }

    public boolean isAddAblum() {
        return this.isAddAblum;
    }

    public boolean isAddMusic() {
        return this.isAddMusic;
    }

    public boolean isCanDeleteVideoFile() {
        return this.canDeleteVideoFile;
    }

    public boolean isHasBgMusic() {
        return this.mHasBgMusic;
    }

    public boolean isOpenBeauty() {
        boolean z;
        synchronized (this) {
            z = this.openBeauty;
        }
        return z;
    }

    public boolean isPrivilegeUser() {
        return this.isPrivilegeUser;
    }

    public boolean isUseData() {
        return this.useData;
    }

    public void setAddAblum(boolean z) {
        this.isAddAblum = z;
    }

    public void setAddMusic(boolean z) {
        this.isAddMusic = z;
    }

    public void setCanDeleteVideoFile(boolean z) {
        this.canDeleteVideoFile = z;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public void setFilters(List<FilterItem> list) {
        this.mFilters = list;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setHasBgMusic(boolean z) {
        this.mHasBgMusic = z;
    }

    public void setMaxRecordDuration(long j) {
        synchronized (this) {
            this.MAX_RECORD_DURATION = j;
        }
    }

    public void setMaxVideoDuration(long j) {
        synchronized (this) {
            this.MAX_VIDEO_DURATION = j;
        }
    }

    public void setMinRecordDuration(long j) {
        this.MIN_RECORD_DURATION = j;
    }

    public void setMinVideoDuration(long j) {
        synchronized (this) {
            this.MIN_VIDEO_DURATION = j;
        }
    }

    public void setMusicName(String str) {
        this.musicName = str;
    }

    public void setMusicPath(String str) {
        this.musicPath = str;
        if (TextUtils.isEmpty(str)) {
            setMusicId("");
            setAddMusic(false);
            return;
        }
        setAddMusic(true);
        String substring = str.contains(".mp3") ? str.substring(str.lastIndexOf(BridgeUtil.SPLIT_MARK) + 1, str.lastIndexOf(".mp3")) : str.substring(str.lastIndexOf(BridgeUtil.SPLIT_MARK) + 1, str.length());
        StvLogUtils.a(Tag + " 使用的音乐Id:" + substring, new Object[0]);
        setMusicId(substring);
    }

    public void setNextPage(int i) {
        this.nextPage = i;
    }

    public void setOpenBeauty(boolean z) {
        synchronized (this) {
            this.openBeauty = z;
        }
    }

    public void setOriginalVideoPath(String str) {
        this.originalVideoPath = str;
    }

    public void setPrePageType(int i) {
        this.prePage = i;
    }

    public void setPrivilegeUser(boolean z) {
        this.isPrivilegeUser = z;
    }

    public void setSelectFilterPosition(int i) {
        synchronized (this) {
            this.mSelectFilterPosition = i;
        }
    }

    public void setSelectedFilter(FilterItem filterItem) {
        this.mSelectedFilter = filterItem;
    }

    public void setShowVType(int i) {
        this.SHOW_V_TYPE = i;
    }

    public void setUseData(Boolean bool) {
        this.useData = bool.booleanValue();
    }

    public void setVideoPath(String str) {
        StvLogUtils.a(Tag + " setVideoPath: " + str, new Object[0]);
        this.videoPath = str;
    }
}
