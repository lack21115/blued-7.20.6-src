package cn.irisgw.live;

import cn.irisgw.live.StartPKExtra;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/StartPKExtraOrBuilder.class */
public interface StartPKExtraOrBuilder extends MessageOrBuilder {
    String getAvatar();

    ByteString getAvatarBytes();

    String getConferenceId();

    ByteString getConferenceIdBytes();

    String getConferenceToken();

    ByteString getConferenceTokenBytes();

    long getCountdown();

    long getDelay();

    String getFirstKillMessage();

    ByteString getFirstKillMessageBytes();

    String getLid();

    ByteString getLidBytes();

    String getName();

    ByteString getNameBytes();

    StartPKExtra.StartRecord getRecords(int i);

    int getRecordsCount();

    List<StartPKExtra.StartRecord> getRecordsList();

    StartPKExtra.StartRecordOrBuilder getRecordsOrBuilder(int i);

    List<? extends StartPKExtra.StartRecordOrBuilder> getRecordsOrBuilderList();

    String getStream();

    ByteString getStreamBytes();

    String getTargetStream();

    ByteString getTargetStreamBytes();

    String getUid();

    ByteString getUidBytes();
}
