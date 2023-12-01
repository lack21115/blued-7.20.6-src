package cn.irisgw.live;

import cn.irisgw.live.CustomRank;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CustomRankOrBuilder.class */
public interface CustomRankOrBuilder extends MessageOrBuilder {
    int getEndTime();

    CustomRank.RankInfo getRankInfo(int i);

    int getRankInfoCount();

    List<CustomRank.RankInfo> getRankInfoList();

    CustomRank.RankInfoOrBuilder getRankInfoOrBuilder(int i);

    List<? extends CustomRank.RankInfoOrBuilder> getRankInfoOrBuilderList();

    int getStartTime();
}
