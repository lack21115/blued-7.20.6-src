package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserPropOrBuilder.class */
public interface UserPropOrBuilder extends MessageOrBuilder {
    int getCountdown();

    String getExtraDesc();

    ByteString getExtraDescBytes();

    int getMaxCountdown();

    Prop getProp();

    int getPropCountdown();

    String getPropDesc(int i);

    ByteString getPropDescBytes(int i);

    int getPropDescCount();

    /* renamed from: getPropDescList */
    List<String> mo8064getPropDescList();

    String getPropIcon();

    ByteString getPropIconBytes();

    String getPropName();

    ByteString getPropNameBytes();

    int getPropValue();

    int getUid();
}
