package cn.irisgw.live;

import cn.irisgw.live.CommonAlert;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CommonAlertOrBuilder.class */
public interface CommonAlertOrBuilder extends MessageOrBuilder {
    CommonAlert.AlertCloseType getCloseType();

    int getCloseTypeValue();

    CommonAlert.AlertResource getResource();

    CommonAlert.AlertResourceOrBuilder getResourceOrBuilder();

    CommonAlert.AlertResourceType getResourceType();

    int getResourceTypeValue();

    boolean getShowCloseBtn();

    boolean hasResource();
}
