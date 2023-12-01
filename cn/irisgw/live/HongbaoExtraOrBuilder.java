package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HongbaoExtraOrBuilder.class */
public interface HongbaoExtraOrBuilder extends MessageOrBuilder {
    long getBeans();

    String getCondition();

    ByteString getConditionBytes();

    int getEndSecond();

    String getHongbaoId();

    ByteString getHongbaoIdBytes();

    boolean getIsAnim();

    String getPwd();

    ByteString getPwdBytes();

    long getRemainingMillisecond();

    String getSize();

    ByteString getSizeBytes();

    int getStartSecond();

    int getStatus();
}
