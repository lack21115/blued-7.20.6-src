package cn.irisgw.live;

import cn.irisgw.live.ChallengeEggResult;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeEggResultOrBuilder.class */
public interface ChallengeEggResultOrBuilder extends MessageOrBuilder {
    int getCountdown();

    boolean getHide();

    int getKillAlertCountdown();

    int getKillAlertDelay();

    int getKillDelay();

    String getName();

    ByteString getNameBytes();

    String getPropIcon();

    ByteString getPropIconBytes();

    String getPropName();

    ByteString getPropNameBytes();

    int getPropResultDisplayCountdown();

    Prop getResultProp();

    int getResultPropValue();

    ChallengeEggResult.ChallengeEggResultType getType();

    int getTypeValue();

    int getUid();
}
