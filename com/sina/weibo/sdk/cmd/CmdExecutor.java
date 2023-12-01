package com.sina.weibo.sdk.cmd;

import com.sina.weibo.sdk.cmd.BaseCmd;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/CmdExecutor.class */
interface CmdExecutor<T extends BaseCmd> {
    boolean doExecutor(T t);
}
