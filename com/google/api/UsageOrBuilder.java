package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/UsageOrBuilder.class */
public interface UsageOrBuilder extends MessageOrBuilder {
    String getProducerNotificationChannel();

    ByteString getProducerNotificationChannelBytes();

    String getRequirements(int i);

    ByteString getRequirementsBytes(int i);

    int getRequirementsCount();

    List<String> getRequirementsList();

    UsageRule getRules(int i);

    int getRulesCount();

    List<UsageRule> getRulesList();

    UsageRuleOrBuilder getRulesOrBuilder(int i);

    List<? extends UsageRuleOrBuilder> getRulesOrBuilderList();
}
