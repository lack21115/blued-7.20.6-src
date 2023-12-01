package cn.irisgw.live;

import cn.irisgw.live.ChallengeEnd;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeEndOrBuilder.class */
public interface ChallengeEndOrBuilder extends MessageOrBuilder {
    int getAgainDisplay();

    boolean getKill();

    int getKillDisplayCountdown();

    int getMvpDisplayCountdown();

    ChallengeEnd.ChallengeScoreResult getRecords(int i);

    int getRecordsCount();

    List<ChallengeEnd.ChallengeScoreResult> getRecordsList();

    ChallengeEnd.ChallengeScoreResultOrBuilder getRecordsOrBuilder(int i);

    List<? extends ChallengeEnd.ChallengeScoreResultOrBuilder> getRecordsOrBuilderList();

    int getResultDisplayCountdown();
}
