package com.blued.android.module.common.utils.cities;

import com.blued.android.core.AppInfo;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/cities/ChineseCitiesHelper.class */
public class ChineseCitiesHelper {
    private static final String TAG = "ChineseCitiesHelper";
    private static volatile ChineseCitiesHelper instance;
    public List<ChineseCitiesList> citiesList = new ArrayList();

    public ChineseCitiesHelper() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AppInfo.d().getAssets().open("chinese_cities.txt"), "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (ChineseCitiesLetter chineseCitiesLetter : (List) AppInfo.f().fromJson(sb.toString(), new TypeToken<List<ChineseCitiesLetter>>() { // from class: com.blued.android.module.common.utils.cities.ChineseCitiesHelper.1
        }.getType())) {
            if (chineseCitiesLetter.data != null && chineseCitiesLetter.data.size() > 0) {
                this.citiesList.add(new ChineseCitiesList(chineseCitiesLetter.letter, chineseCitiesLetter.data));
            }
        }
    }

    public static ChineseCitiesHelper getInstance() {
        if (instance == null) {
            synchronized (ChineseCitiesHelper.class) {
                try {
                    if (instance == null) {
                        instance = new ChineseCitiesHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public List<ChineseCitiesList> getCitiesList() {
        return this.citiesList;
    }
}
