package com.vivo.push.sdk.service;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/sdk/service/CommandClientService.class */
public class CommandClientService extends CommandService {
    @Override // com.vivo.push.sdk.service.CommandService
    protected final boolean a(String str) {
        return "com.vivo.pushclient.action.RECEIVE".equals(str);
    }
}
