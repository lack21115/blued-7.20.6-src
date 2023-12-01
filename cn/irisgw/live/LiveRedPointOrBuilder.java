package cn.irisgw.live;

import cn.irisgw.live.LiveRedPoint;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRedPointOrBuilder.class */
public interface LiveRedPointOrBuilder extends MessageOrBuilder {
    String getGoodsPackPointInfo();

    ByteString getGoodsPackPointInfoBytes();

    String getPointInfo();

    ByteString getPointInfoBytes();

    LiveRedPoint.PointAction getRedPointAction();

    int getRedPointActionValue();

    boolean getRedPointCancel();

    LiveRedPoint.PointType getRedPointType();

    int getRedPointTypeValue();

    String getRedPointWord();

    ByteString getRedPointWordBytes();
}
