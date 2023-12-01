package cn.irisgw.live;

import cn.irisgw.live.ChallengeMatch;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeMatchOrBuilder.class */
public interface ChallengeMatchOrBuilder extends MessageOrBuilder {
    ChallengeMatch.ChallengeInfo getChallengeInfo(int i);

    int getChallengeInfoCount();

    List<ChallengeMatch.ChallengeInfo> getChallengeInfoList();

    ChallengeMatch.ChallengeInfoOrBuilder getChallengeInfoOrBuilder(int i);

    List<? extends ChallengeMatch.ChallengeInfoOrBuilder> getChallengeInfoOrBuilderList();

    int getCountdown();

    String getDescContents();

    ByteString getDescContentsBytes();

    String getDescLink();

    ByteString getDescLinkBytes();

    int getEggAlertCountdown();

    int getEggAlertDelay();

    int getEggDelay();

    int getFullCountdown();

    int getMaxEggCountdown();

    int getTargetEggScore();
}
