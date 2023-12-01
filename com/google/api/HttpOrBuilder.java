package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/HttpOrBuilder.class */
public interface HttpOrBuilder extends MessageOrBuilder {
    boolean getFullyDecodeReservedExpansion();

    HttpRule getRules(int i);

    int getRulesCount();

    List<HttpRule> getRulesList();

    HttpRuleOrBuilder getRulesOrBuilder(int i);

    List<? extends HttpRuleOrBuilder> getRulesOrBuilderList();
}
