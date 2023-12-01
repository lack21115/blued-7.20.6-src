package com.blued.android.module.live_china.model;

import android.text.TextUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveActivityItemModel.class */
public class LiveActivityItemModel implements MultiItemEntity, Serializable, Comparable<LiveActivityItemModel> {
    public String display_url;
    public List<LiveActivityDisplayUrlModel> display_urls;
    public String icon;
    public long id;
    public String jsData;
    public int page;
    public int sort;
    public int status;
    public String url;

    @Override // java.lang.Comparable
    public int compareTo(LiveActivityItemModel liveActivityItemModel) {
        return this.sort - liveActivityItemModel.sort;
    }

    public boolean displayUrlsEqual(LiveActivityItemModel liveActivityItemModel) {
        int i;
        boolean z = false;
        if (liveActivityItemModel != null) {
            List<LiveActivityDisplayUrlModel> list = liveActivityItemModel.display_urls;
            z = false;
            if (list != null) {
                z = false;
                if (list.size() > 0) {
                    List<LiveActivityDisplayUrlModel> list2 = this.display_urls;
                    z = false;
                    if (list2 != null) {
                        z = false;
                        if (list2.size() > 0) {
                            z = false;
                            if (liveActivityItemModel.display_urls.size() == this.display_urls.size()) {
                                int i2 = 0;
                                int i3 = 0;
                                while (true) {
                                    i = i3;
                                    if (i2 >= liveActivityItemModel.display_urls.size()) {
                                        break;
                                    }
                                    int i4 = i;
                                    if (liveActivityItemModel.display_urls.get(i2) != null) {
                                        i4 = i;
                                        if (this.display_urls.get(i2) != null) {
                                            i4 = i;
                                            if (!TextUtils.isEmpty(liveActivityItemModel.display_urls.get(i2).url)) {
                                                i4 = i;
                                                if (TextUtils.equals(liveActivityItemModel.display_urls.get(i2).url, this.display_urls.get(i2).url)) {
                                                    i4 = i + 1;
                                                }
                                            }
                                        }
                                    }
                                    i2++;
                                    i3 = i4;
                                }
                                z = false;
                                if (i == liveActivityItemModel.display_urls.size()) {
                                    z = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 0;
    }

    public boolean isIcon() {
        return !TextUtils.isEmpty(this.icon) && TypeUtils.a((List<?>) this.display_urls);
    }
}
