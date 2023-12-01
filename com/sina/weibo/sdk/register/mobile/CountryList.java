package com.sina.weibo.sdk.register.mobile;

import com.heytap.mcssdk.constant.IntentConstant;
import com.sina.weibo.sdk.exception.WeiboException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/register/mobile/CountryList.class */
public class CountryList implements Serializable {
    private static final long serialVersionUID = 1;
    public List<Country> countries;

    public CountryList(String str) {
        initFromJsonStr(str);
    }

    private void initFromJsonStr(String str) {
        try {
            initFromJsonObject(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void initFromJsonObject(JSONObject jSONObject) throws WeiboException {
        try {
            this.countries = new ArrayList();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                String string = optJSONObject.getString("code");
                JSONArray optJSONArray = optJSONObject.optJSONObject(IntentConstant.RULE).optJSONArray("mcc");
                String[] strArr = new String[optJSONArray.length()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    strArr[i2] = optJSONArray.getString(i2);
                    i = i2 + 1;
                }
                Country country = new Country(next, string);
                country.setMccs(strArr);
                this.countries.add(country);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new WeiboException(e);
        }
    }
}
