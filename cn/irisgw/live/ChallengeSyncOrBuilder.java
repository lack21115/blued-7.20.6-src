package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeSyncOrBuilder.class */
public interface ChallengeSyncOrBuilder extends MessageOrBuilder {
    ChallengeSyncInfo getChallengeInfo(int i);

    int getChallengeInfoCount();

    List<ChallengeSyncInfo> getChallengeInfoList();

    ChallengeSyncInfoOrBuilder getChallengeInfoOrBuilder(int i);

    List<? extends ChallengeSyncInfoOrBuilder> getChallengeInfoOrBuilderList();

    int getCountdown();

    String getDescContents();

    ByteString getDescContentsBytes();

    String getDescLink();

    ByteString getDescLinkBytes();

    int getEggAlertCountdown();

    int getEggAlertDelay();

    int getEggCountdown();

    int getEggDelay();

    int getFullCountdown();

    int getGreaterScore();

    int getKillAlertCountdown();

    int getKillAlertDelay();

    int getKillCountdown();

    int getKillDelay();

    boolean getKillOpen();

    int getMaxEggCountdown();

    int getStage();

    int getTargetEggScore();
}
