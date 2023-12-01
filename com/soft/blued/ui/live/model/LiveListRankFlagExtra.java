package com.soft.blued.ui.live.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveHotListDiversion;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/model/LiveListRankFlagExtra.class */
public class LiveListRankFlagExtra extends BluedEntityBaseExtra {
    public List<BluedLiveListData> fresh_beans_list;
    public List<LiveHotListDiversion> hot_list_diversion;
    public List<BluedLiveListData> hotpk_list;
    public String last;
    public List<BluedLiveListData> official_list;
    public int pkhasmore;
    public int rankflag;
    public int recommend;
}
