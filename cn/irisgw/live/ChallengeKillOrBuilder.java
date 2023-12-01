package cn.irisgw.live;

import cn.irisgw.live.ChallengeKill;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeKillOrBuilder.class */
public interface ChallengeKillOrBuilder extends MessageOrBuilder {
    ChallengeKill.ChallengeKillActiveType getActiveType();

    int getActiveTypeValue();

    int getCountdown();

    int getGreaterScore();

    ChallengeKill.ChallengeKillType getType();

    int getTypeValue();
}
