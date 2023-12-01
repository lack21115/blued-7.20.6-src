package com.sobot.chat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.sobot.chat.activity.base.SobotDialogBaseActivity;
import com.sobot.chat.adapter.SobotPostCascadeAdapter;
import com.sobot.chat.api.model.SobotCusFieldDataInfo;
import com.sobot.chat.api.model.SobotFieldModel;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotPostCascadeActivity.class */
public class SobotPostCascadeActivity extends SobotDialogBaseActivity {
    private SobotPostCascadeAdapter categoryAdapter;
    private int currentLevel = 1;
    private SobotFieldModel cusField;
    private List<SobotCusFieldDataInfo> cusFieldDataInfoList;
    private String fieldId;
    private ListView listView;
    private List<SobotCusFieldDataInfo> selectCusFieldDataInfos;
    private ImageView sobot_btn_back;
    private LinearLayout sobot_btn_cancle;
    private TextView sobot_tv_title;
    private List<SobotCusFieldDataInfo> tmpDatas;
    private SparseArray<List<SobotCusFieldDataInfo>> tmpMap;

    static /* synthetic */ int access$308(SobotPostCascadeActivity sobotPostCascadeActivity) {
        int i = sobotPostCascadeActivity.currentLevel;
        sobotPostCascadeActivity.currentLevel = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backPressed() {
        int i = this.currentLevel;
        if (i <= 1) {
            finish();
            return;
        }
        int i2 = i - 1;
        this.currentLevel = i2;
        if (i2 == 1) {
            this.sobot_btn_back.setVisibility(8);
        }
        if (this.currentLevel > 1) {
            this.sobot_btn_back.setVisibility(0);
        }
        List<SobotCusFieldDataInfo> list = this.selectCusFieldDataInfos;
        list.remove(list.size() - 1);
        notifyListData(this.tmpMap.get(this.currentLevel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SobotCusFieldDataInfo> getNextLevelList(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cusFieldDataInfoList.size()) {
                return arrayList;
            }
            if (StringUtils.isEmpty(str)) {
                if (StringUtils.isEmpty(this.cusFieldDataInfoList.get(i2).getParentDataId())) {
                    this.cusFieldDataInfoList.get(i2).setHasNext(isHasNext(this.cusFieldDataInfoList.get(i2).getDataId()));
                    arrayList.add(this.cusFieldDataInfoList.get(i2));
                }
            } else if (str.equals(this.cusFieldDataInfoList.get(i2).getParentDataId())) {
                this.cusFieldDataInfoList.get(i2).setHasNext(isHasNext(this.cusFieldDataInfoList.get(i2).getDataId()));
                arrayList.add(this.cusFieldDataInfoList.get(i2));
            }
            i = i2 + 1;
        }
    }

    private boolean isHasNext(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cusFieldDataInfoList.size()) {
                return false;
            }
            if (str.equals(this.cusFieldDataInfoList.get(i2).getParentDataId())) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private void notifyListData(List<SobotCusFieldDataInfo> list) {
        this.tmpDatas.clear();
        this.tmpDatas.addAll(list);
        SobotPostCascadeAdapter sobotPostCascadeAdapter = this.categoryAdapter;
        if (sobotPostCascadeAdapter != null) {
            sobotPostCascadeAdapter.notifyDataSetChanged();
            return;
        }
        SobotPostCascadeAdapter sobotPostCascadeAdapter2 = new SobotPostCascadeAdapter(this, this, this.tmpDatas);
        this.categoryAdapter = sobotPostCascadeAdapter2;
        this.listView.setAdapter((ListAdapter) sobotPostCascadeAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDataWithLevel(int i, String str) {
        this.sobot_btn_back.setVisibility(this.currentLevel > 1 ? 0 : 8);
        if (i >= 0) {
            this.tmpMap.put(this.currentLevel, getNextLevelList(str));
        }
        ArrayList arrayList = (ArrayList) this.tmpMap.get(this.currentLevel);
        if (arrayList != null) {
            notifyListData(arrayList);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return ResourceUtils.getResLayoutId(this, "sobot_activity_post_category");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        Bundle bundleExtra = getIntent().getBundleExtra(TTLiveConstants.BUNDLE_KEY);
        if (bundleExtra != null) {
            this.fieldId = bundleExtra.getString("fieldId");
            this.cusField = (SobotFieldModel) bundleExtra.getSerializable("cusField");
        }
        this.sobot_tv_title.setText(ResourceUtils.getResString(getBaseContext(), "sobot_choice_classification"));
        SobotFieldModel sobotFieldModel = this.cusField;
        if (sobotFieldModel == null || sobotFieldModel.getCusFieldDataInfoList() == null) {
            this.cusFieldDataInfoList = new ArrayList();
        } else {
            this.cusFieldDataInfoList = this.cusField.getCusFieldDataInfoList();
        }
        this.currentLevel = 1;
        this.tmpMap.put(1, getNextLevelList(""));
        List<SobotCusFieldDataInfo> list = this.cusFieldDataInfoList;
        if (list != null && list.size() != 0) {
            showDataWithLevel(-1, "");
        }
        this.sobot_btn_back.setVisibility(8);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        this.tmpMap = new SparseArray<>();
        this.tmpDatas = new ArrayList();
        this.selectCusFieldDataInfos = new ArrayList();
        this.sobot_btn_cancle = (LinearLayout) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_btn_cancle"));
        this.sobot_tv_title = (TextView) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_tv_title"));
        this.sobot_btn_back = (ImageView) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_btn_back"));
        ListView listView = (ListView) findViewById(ResourceUtils.getResId(getBaseContext(), "sobot_activity_post_category_listview"));
        this.listView = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sobot.chat.activity.SobotPostCascadeActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str;
                Tracker.onItemClick(adapterView, view, i, j);
                SobotPostCascadeActivity.this.selectCusFieldDataInfos.add(SobotPostCascadeActivity.this.categoryAdapter.getDatas().get(i));
                SobotPostCascadeActivity sobotPostCascadeActivity = SobotPostCascadeActivity.this;
                if (sobotPostCascadeActivity.getNextLevelList(sobotPostCascadeActivity.categoryAdapter.getDatas().get(i).getDataId()).size() > 0) {
                    SobotPostCascadeActivity.access$308(SobotPostCascadeActivity.this);
                    SobotPostCascadeActivity sobotPostCascadeActivity2 = SobotPostCascadeActivity.this;
                    sobotPostCascadeActivity2.showDataWithLevel(i, sobotPostCascadeActivity2.categoryAdapter.getDatas().get(i).getDataId());
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("CATEGORYSMALL", "CATEGORYSMALL");
                intent.putExtra("fieldType", 9);
                String str2 = "";
                String str3 = "";
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= SobotPostCascadeActivity.this.selectCusFieldDataInfos.size()) {
                        break;
                    }
                    if (i3 == SobotPostCascadeActivity.this.selectCusFieldDataInfos.size() - 1) {
                        str2 = str2 + ((SobotCusFieldDataInfo) SobotPostCascadeActivity.this.selectCusFieldDataInfos.get(i3)).getDataName();
                        str = str3 + ((SobotCusFieldDataInfo) SobotPostCascadeActivity.this.selectCusFieldDataInfos.get(i3)).getDataValue();
                    } else {
                        str2 = str2 + ((SobotCusFieldDataInfo) SobotPostCascadeActivity.this.selectCusFieldDataInfos.get(i3)).getDataName() + ",";
                        str = str3 + ((SobotCusFieldDataInfo) SobotPostCascadeActivity.this.selectCusFieldDataInfos.get(i3)).getDataValue() + ",";
                    }
                    str3 = str;
                    i2 = i3 + 1;
                }
                intent.putExtra("category_typeName", str2);
                intent.putExtra("category_fieldId", SobotPostCascadeActivity.this.fieldId);
                intent.putExtra("category_typeValue", str3);
                SobotPostCascadeActivity.this.setResult(304, intent);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= ((List) SobotPostCascadeActivity.this.tmpMap.get(SobotPostCascadeActivity.this.currentLevel)).size()) {
                        SobotPostCascadeActivity.this.categoryAdapter.notifyDataSetChanged();
                        SobotPostCascadeActivity.this.finish();
                        return;
                    }
                    ((SobotCusFieldDataInfo) ((List) SobotPostCascadeActivity.this.tmpMap.get(SobotPostCascadeActivity.this.currentLevel)).get(i5)).setChecked(i5 == i);
                    i4 = i5 + 1;
                }
            }
        });
        this.sobot_btn_cancle.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotPostCascadeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotPostCascadeActivity.this.finish();
            }
        });
        this.sobot_btn_back.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotPostCascadeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotPostCascadeActivity.this.backPressed();
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotDialogBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        backPressed();
    }
}
