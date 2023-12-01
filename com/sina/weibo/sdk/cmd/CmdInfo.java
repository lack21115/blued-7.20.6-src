package com.sina.weibo.sdk.cmd;

import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/CmdInfo.class */
class CmdInfo {
    private static final String TAG = BaseCmd.class.getName();
    private int frequency;
    private List<AppInstallCmd> mInstallCmds;
    private List<AppInvokeCmd> mInvokeCmds;

    public CmdInfo(String str) throws WeiboException {
        initFromJsonStr(str);
    }

    private void initFromJsonStr(String str) throws WeiboException {
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("error") || jSONObject.has("error_code")) {
                LogUtil.w(TAG, "load cmd api has error !!!");
                throw new WeiboException("load cmd api has error !!!");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("cmd");
            if (optJSONObject == null) {
                return;
            }
            this.frequency = optJSONObject.optInt("frequency");
            JSONArray optJSONArray = optJSONObject.optJSONArray("app_install");
            if (optJSONArray != null) {
                this.mInstallCmds = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    this.mInstallCmds.add(new AppInstallCmd(optJSONArray.getJSONObject(i2)));
                    i = i2 + 1;
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("app_invoke");
            if (optJSONArray2 == null) {
                return;
            }
            this.mInvokeCmds = new ArrayList();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= optJSONArray2.length()) {
                    return;
                }
                this.mInvokeCmds.add(new AppInvokeCmd(optJSONArray2.getJSONObject(i4)));
                i3 = i4 + 1;
            }
        } catch (JSONException e) {
            LogUtil.d(TAG, "parse NotificationInfo error: " + e.getMessage());
        }
    }

    public int getFrequency() {
        return this.frequency;
    }

    public List<AppInstallCmd> getInstallCmds() {
        return this.mInstallCmds;
    }

    public List<AppInvokeCmd> getInvokeCmds() {
        return this.mInvokeCmds;
    }

    public void setFrequency(int i) {
        this.frequency = i;
    }

    public void setInstallCmds(List<AppInstallCmd> list) {
        this.mInstallCmds = list;
    }

    public void setInvokeCmds(List<AppInvokeCmd> list) {
        this.mInvokeCmds = list;
    }
}
