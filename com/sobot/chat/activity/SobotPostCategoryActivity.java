package com.sobot.chat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.sobot.chat.adapter.SobotPostCategoryAdapter;
import com.sobot.chat.api.model.SobotTypeModel;
import com.sobot.chat.utils.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotPostCategoryActivity.class */
public class SobotPostCategoryActivity extends SobotDialogBaseActivity {
    private SobotPostCategoryAdapter categoryAdapter;
    private ListView listView;
    private ImageView sobot_btn_back;
    private LinearLayout sobot_btn_cancle;
    private TextView sobot_tv_title;
    private String typeId;
    private String typeName;
    private List<SobotTypeModel> types = new ArrayList();
    private SparseArray<List<SobotTypeModel>> tmpMap = new SparseArray<>();
    private List<SobotTypeModel> tmpDatas = new ArrayList();
    private int currentLevel = 1;

    static /* synthetic */ int access$008(SobotPostCategoryActivity sobotPostCategoryActivity) {
        int i = sobotPostCategoryActivity.currentLevel;
        sobotPostCategoryActivity.currentLevel = i + 1;
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
        notifyListData(this.tmpMap.get(this.currentLevel));
    }

    private void notifyListData(List<SobotTypeModel> list) {
        this.tmpDatas.clear();
        this.tmpDatas.addAll(list);
        SobotPostCategoryAdapter sobotPostCategoryAdapter = this.categoryAdapter;
        if (sobotPostCategoryAdapter != null) {
            sobotPostCategoryAdapter.notifyDataSetChanged();
            return;
        }
        SobotPostCategoryAdapter sobotPostCategoryAdapter2 = new SobotPostCategoryAdapter(this, this, this.tmpDatas);
        this.categoryAdapter = sobotPostCategoryAdapter2;
        this.listView.setAdapter((ListAdapter) sobotPostCategoryAdapter2);
    }

    private void resetChecked(ArrayList<SobotTypeModel> arrayList) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            if (!TextUtils.isEmpty(this.typeId) && this.typeId.equals(arrayList.get(i2).getTypeId())) {
                arrayList.get(i2).setChecked(true);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDataWithLevel(int i) {
        this.sobot_btn_back.setVisibility(this.currentLevel > 1 ? 0 : 8);
        if (i >= 0) {
            SparseArray<List<SobotTypeModel>> sparseArray = this.tmpMap;
            int i2 = this.currentLevel;
            sparseArray.put(i2, sparseArray.get(i2 - 1).get(i).getItems());
        }
        ArrayList<SobotTypeModel> arrayList = (ArrayList) this.tmpMap.get(this.currentLevel);
        if (arrayList != null) {
            resetChecked(arrayList);
            notifyListData(arrayList);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return ResourceUtils.getResLayoutId(this, "sobot_activity_post_category");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        ArrayList arrayList;
        this.types.clear();
        Bundle bundleExtra = getIntent().getBundleExtra(TTLiveConstants.BUNDLE_KEY);
        if (bundleExtra != null) {
            this.typeName = bundleExtra.getString("typeName");
            this.typeId = bundleExtra.getString("typeId");
            arrayList = (ArrayList) bundleExtra.getSerializable("types");
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.types.addAll(arrayList);
        }
        this.sobot_tv_title.setText(ResourceUtils.getResString(getBaseContext(), "sobot_choice_classification"));
        this.currentLevel = 1;
        this.tmpMap.put(1, this.types);
        List<SobotTypeModel> list = this.types;
        if (list != null && list.size() != 0) {
            showDataWithLevel(-1);
        }
        this.sobot_btn_back.setVisibility(8);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        this.sobot_btn_cancle = (LinearLayout) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_btn_cancle"));
        this.sobot_tv_title = (TextView) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_tv_title"));
        this.sobot_btn_back = (ImageView) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_btn_back"));
        ListView listView = (ListView) findViewById(ResourceUtils.getResId(getBaseContext(), "sobot_activity_post_category_listview"));
        this.listView = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sobot.chat.activity.SobotPostCategoryActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                if (1 == ((SobotTypeModel) ((List) SobotPostCategoryActivity.this.tmpMap.get(SobotPostCategoryActivity.this.currentLevel)).get(i)).getNodeFlag()) {
                    SobotPostCategoryActivity.access$008(SobotPostCategoryActivity.this);
                    SobotPostCategoryActivity.this.showDataWithLevel(i);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("category_typeName", ((SobotTypeModel) ((List) SobotPostCategoryActivity.this.tmpMap.get(SobotPostCategoryActivity.this.currentLevel)).get(i)).getTypeName());
                intent.putExtra("category_typeId", ((SobotTypeModel) ((List) SobotPostCategoryActivity.this.tmpMap.get(SobotPostCategoryActivity.this.currentLevel)).get(i)).getTypeId());
                SobotPostCategoryActivity.this.setResult(304, intent);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ((List) SobotPostCategoryActivity.this.tmpMap.get(SobotPostCategoryActivity.this.currentLevel)).size()) {
                        SobotPostCategoryActivity.this.categoryAdapter.notifyDataSetChanged();
                        SobotPostCategoryActivity.this.finish();
                        return;
                    }
                    ((SobotTypeModel) ((List) SobotPostCategoryActivity.this.tmpMap.get(SobotPostCategoryActivity.this.currentLevel)).get(i3)).setChecked(i3 == i);
                    i2 = i3 + 1;
                }
            }
        });
        this.sobot_btn_cancle.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotPostCategoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotPostCategoryActivity.this.finish();
            }
        });
        this.sobot_btn_back.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotPostCategoryActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotPostCategoryActivity.this.backPressed();
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotDialogBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        backPressed();
    }
}
