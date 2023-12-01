package cn.irisgw.live;

import cn.irisgw.live.ChallengeUpdate;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeUpdateOrBuilder.class */
public interface ChallengeUpdateOrBuilder extends MessageOrBuilder {
    boolean getIsEgg();

    ChallengeUpdate.ChallengeScoreUpdate getRecords(int i);

    int getRecordsCount();

    List<ChallengeUpdate.ChallengeScoreUpdate> getRecordsList();

    ChallengeUpdate.ChallengeScoreUpdateOrBuilder getRecordsOrBuilder(int i);

    List<? extends ChallengeUpdate.ChallengeScoreUpdateOrBuilder> getRecordsOrBuilderList();
}
