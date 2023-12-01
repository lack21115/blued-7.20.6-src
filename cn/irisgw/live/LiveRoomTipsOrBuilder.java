package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRoomTipsOrBuilder.class */
public interface LiveRoomTipsOrBuilder extends MessageOrBuilder {
    String getColors(int i);

    ByteString getColorsBytes(int i);

    int getColorsCount();

    /* renamed from: getColorsList */
    List<String> mo5087getColorsList();

    int getCountdown();

    int getDirection();

    String getIcon();

    ByteString getIconBytes();

    int getId();

    String getLink();

    ByteString getLinkBytes();

    int getLinkType();

    int getLocation();

    int getOrder();

    String getText();

    ByteString getTextBytes();
}
