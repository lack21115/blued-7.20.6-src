package com.blued.community.ui.circle.model;

import com.blued.community.model.BluedIngSelfFeed;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/model/CircleDetailsListModel.class */
public class CircleDetailsListModel {
    public boolean hasMore = true;
    public int page = 1;
    public int size = 30;
    public final List<BluedIngSelfFeed> dataList = new ArrayList();
    public int[] rvLocation = {0, 0};
}
