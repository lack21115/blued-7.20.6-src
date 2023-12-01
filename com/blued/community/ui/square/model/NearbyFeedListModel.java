package com.blued.community.ui.square.model;

import com.blued.community.model.BluedIngSelfFeed;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/model/NearbyFeedListModel.class */
public class NearbyFeedListModel {
    public boolean hasMore = true;
    public int page = 1;
    public int size = 30;
    public List<BluedIngSelfFeed> dataList = new ArrayList();
    public int[] rvLocation = {0, 0};
}
