package com.blued.android.module.shortvideo.model;

import com.blued.android.module.shortvideo.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/ConfigData.class */
public class ConfigData extends IModel {
    public static final int ID_BEAUTY = 1;
    public static final int ID_COVER = 5;
    public static final int ID_FILTER = 2;
    public static final int ID_MUSIC = 0;
    public static final int ID_TIMEDOWN = 3;
    public static final int ID_VOLUME = 4;
    private CommonModel mCommonModel;
    private int mFrom;
    private int mPageType;
    private int mPrePageType;
    public int[] all_iconids = {R.drawable.config_music_icon, R.drawable.config_beauty_btn_selector, R.drawable.config_filter_icon, R.drawable.config_countdown_btn_selector, R.drawable.config_volume_icon, R.drawable.config_cover_selector};
    public int[] all_nameids = {R.string.stv_config_music_name, R.string.stv_config_open_beauty_name, R.string.stv_config_filter_name, R.string.stv_config_countdown_close_name, R.string.stv_config_volume_name, R.string.stv_config_cover_name};
    private float[] all_alphas = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    public boolean[] all_activated = {true, true, false, false, true, false};
    public List<Integer> ids = new ArrayList();
    public List<Integer> iconids = new ArrayList();
    public List<Integer> nameids = new ArrayList();
    public List<Float> alphas = new ArrayList();
    public List<Boolean> activateds = new ArrayList();

    public ConfigData(CommonModel commonModel) {
        this.mCommonModel = commonModel;
    }

    private void initData(CommonModel commonModel) {
        FilterItem selectedFilter;
        FilterItem selectedFilter2;
        if (this.mPageType == 4 && this.mPrePageType == 1) {
            setMusicActivated(!commonModel.isAddMusic());
            setMusicAlphas(commonModel.isAddMusic() ? 0.4f : 1.0f);
            if (!commonModel.isUseData() || (selectedFilter2 = commonModel.getSelectedFilter()) == null) {
                return;
            }
            setFilter(selectedFilter2.b, selectedFilter2.c);
        } else if (this.mPageType == 1) {
            setBeauty(commonModel.isOpenBeauty());
            if (!commonModel.isUseData() || (selectedFilter = commonModel.getSelectedFilter()) == null) {
                return;
            }
            setFilter(selectedFilter.b, selectedFilter.c);
        }
    }

    private void setAlphas(int i, float f) {
        if (this.alphas.size() >= i) {
            this.alphas.set(i, Float.valueOf(f));
        }
    }

    private void updateActivated(int i, boolean z) {
        if (i < 0 || this.activateds.size() < i) {
            return;
        }
        this.activateds.set(i, Boolean.valueOf(z));
    }

    public int getDefaultFilterNameId() {
        return this.all_nameids[2];
    }

    public int setBeauty(boolean z) {
        int indexOf = this.ids.indexOf(1);
        updateActivated(indexOf, z);
        return indexOf;
    }

    public int setCoverActivated(boolean z) {
        CommonModel commonModel = this.mCommonModel;
        if (commonModel == null || !commonModel.isUseData()) {
            return -1;
        }
        int indexOf = this.ids.indexOf(5);
        updateActivated(indexOf, z);
        return indexOf;
    }

    public int setFilter(int i, int i2) {
        int indexOf = this.ids.indexOf(2);
        if (indexOf >= 0) {
            this.nameids.set(indexOf, Integer.valueOf(i));
            this.iconids.set(indexOf, Integer.valueOf(i2));
            return indexOf;
        }
        return 0;
    }

    public int setMusicActivated(boolean z) {
        int indexOf = this.ids.indexOf(0);
        updateActivated(indexOf, z);
        return indexOf;
    }

    public int setMusicAlphas(float f) {
        int indexOf = this.ids.indexOf(0);
        if (indexOf >= 0) {
            setAlphas(indexOf, f);
        }
        return indexOf;
    }

    public void switchPage(int i, int i2, int i3) {
        int i4;
        this.ids.clear();
        this.iconids.clear();
        this.nameids.clear();
        this.alphas.clear();
        this.activateds.clear();
        this.mFrom = i;
        this.mPageType = i3;
        this.mPrePageType = i2;
        if (i3 != 1) {
            if (i3 != 4) {
                if (i3 != 5) {
                    i4 = 0;
                } else {
                    this.ids.add(1);
                    this.ids.add(2);
                    i4 = 0;
                }
            } else if (i >= 60) {
                i4 = 0;
            } else {
                this.ids.add(0);
                if (this.mPrePageType == 3) {
                    this.ids.add(2);
                    this.ids.add(4);
                } else {
                    this.ids.add(4);
                }
                i4 = 0;
                if (this.mFrom != 1) {
                    this.ids.add(5);
                    i4 = 0;
                }
            }
        } else if (i >= 60) {
            this.ids.add(1);
            this.ids.add(2);
            this.ids.add(3);
            i4 = 0;
        } else {
            this.ids.add(0);
            this.ids.add(1);
            this.ids.add(2);
            this.ids.add(3);
            i4 = 0;
        }
        while (i4 < this.ids.size()) {
            this.iconids.add(Integer.valueOf(this.all_iconids[this.ids.get(i4).intValue()]));
            this.nameids.add(Integer.valueOf(this.all_nameids[this.ids.get(i4).intValue()]));
            this.alphas.add(Float.valueOf(this.all_alphas[this.ids.get(i4).intValue()]));
            this.activateds.add(Boolean.valueOf(this.all_activated[this.ids.get(i4).intValue()]));
            i4++;
        }
        initData(this.mCommonModel);
    }
}
