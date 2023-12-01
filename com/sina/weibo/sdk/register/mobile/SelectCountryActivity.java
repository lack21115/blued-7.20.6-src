package com.sina.weibo.sdk.register.mobile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.sina.weibo.sdk.component.view.TitleBar;
import com.sina.weibo.sdk.register.mobile.LetterIndexBar;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/register/mobile/SelectCountryActivity.class */
public class SelectCountryActivity extends Activity implements LetterIndexBar.OnIndexChangeListener {
    private static final String CHINA_CN = "中国";
    private static final String CHINA_EN = "China";
    private static final String CHINA_TW = "中國";
    public static final String EXTRA_COUNTRY_CODE = "code";
    public static final String EXTRA_COUNTRY_NAME = "name";
    private static final String INFO_CN = "常用";
    private static final String INFO_EN = "Common";
    private static final String INFO_TW = "常用";
    private static final String SELECT_COUNTRY_EN = "Region";
    private static final String SELECT_COUNTRY_ZH_CN = "选择国家";
    private static final String SELECT_COUNTRY_ZH_TW = "選擇國家";
    private List<Country>[] arrSubCountry;
    String countryStr = "";
    private List<IndexCountry> indexCountries = new ArrayList();
    private CountryAdapter mAdapter;
    private List<Country> mCountries;
    private FrameLayout mFrameLayout;
    private LetterIndexBar mLetterIndexBar;
    private ListView mListView;
    private RelativeLayout mMainLayout;
    private CountryList result;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/register/mobile/SelectCountryActivity$CountryAdapter.class */
    public class CountryAdapter extends BaseAdapter {
        private CountryAdapter() {
        }

        /* synthetic */ CountryAdapter(SelectCountryActivity selectCountryActivity, CountryAdapter countryAdapter) {
            this();
        }

        private SelectCountryTitleView createTitleView(int i) {
            SelectCountryTitleView selectCountryTitleView = new SelectCountryTitleView(SelectCountryActivity.this.getApplicationContext());
            if (i == 0) {
                selectCountryTitleView.setTitle(ResourceManager.getString(SelectCountryActivity.this, SelectCountryActivity.INFO_EN, "常用", "常用"));
                return selectCountryTitleView;
            }
            selectCountryTitleView.setTitle(String.valueOf((char) ((i + 65) - 1)));
            return selectCountryTitleView;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (SelectCountryActivity.this.indexCountries != null) {
                return SelectCountryActivity.this.indexCountries.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (SelectCountryActivity.this.indexCountries == null || SelectCountryActivity.this.indexCountries.isEmpty() || i == SelectCountryActivity.this.indexCountries.size()) {
                return null;
            }
            IndexCountry indexCountry = (IndexCountry) SelectCountryActivity.this.indexCountries.get(i);
            if (indexCountry.indexInList == -1) {
                return null;
            }
            return SelectCountryActivity.this.arrSubCountry[indexCountry.indexInListArray].get(indexCountry.indexInList);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            IndexCountry indexCountry = (IndexCountry) SelectCountryActivity.this.indexCountries.get(i);
            if (view == null) {
                if (indexCountry.indexInList == -1) {
                    return createTitleView(indexCountry.indexInListArray);
                }
                Country country = (Country) SelectCountryActivity.this.arrSubCountry[indexCountry.indexInListArray].get(indexCountry.indexInList);
                view = new SelectCountryItemView(SelectCountryActivity.this, country.getName(), country.getCode());
            } else if (indexCountry.indexInList != -1) {
                Country country2 = (Country) SelectCountryActivity.this.arrSubCountry[indexCountry.indexInListArray].get(indexCountry.indexInList);
                if (view instanceof SelectCountryTitleView) {
                    view = new SelectCountryItemView(SelectCountryActivity.this, country2.getName(), country2.getCode());
                } else {
                    ((SelectCountryItemView) view).updateContent(country2.getName(), country2.getCode());
                }
            } else if (!(view instanceof SelectCountryTitleView)) {
                view = createTitleView(indexCountry.indexInListArray);
            } else if (indexCountry.indexInListArray == 0) {
                ((SelectCountryTitleView) view).update(ResourceManager.getString(SelectCountryActivity.this, SelectCountryActivity.INFO_EN, "常用", "常用"));
            } else {
                view = createTitleView(indexCountry.indexInListArray);
            }
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/register/mobile/SelectCountryActivity$IndexCountry.class */
    public class IndexCountry {
        int indexInList;
        int indexInListArray;

        IndexCountry(int i, int i2) {
            this.indexInListArray = i;
            this.indexInList = i2;
        }

        public boolean equals(Object obj) {
            int i;
            if ((obj instanceof IndexCountry) && (i = this.indexInList) == -1) {
                IndexCountry indexCountry = (IndexCountry) obj;
                return this.indexInListArray == indexCountry.indexInListArray && i == indexCountry.indexInList;
            }
            return false;
        }
    }

    private List<IndexCountry> compose(List<Country>[] listArr) {
        ArrayList arrayList = new ArrayList();
        if (listArr == null) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= listArr.length) {
                return arrayList;
            }
            List<Country> list = listArr[i2];
            if (list != null && list.size() > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= list.size()) {
                        break;
                    }
                    if (i4 == 0) {
                        arrayList.add(new IndexCountry(i2, -1));
                    }
                    arrayList.add(new IndexCountry(i2, i4));
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    private void initView() {
        this.mMainLayout = new RelativeLayout(this);
        this.mMainLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        TitleBar titleBar = new TitleBar(this);
        titleBar.setId(1);
        titleBar.setLeftBtnBg(ResourceManager.createStateListDrawable(this, "weibosdk_navigationbar_back.png", "weibosdk_navigationbar_back_highlighted.png"));
        titleBar.setTitleBarText(ResourceManager.getString(this, SELECT_COUNTRY_EN, SELECT_COUNTRY_ZH_CN, SELECT_COUNTRY_ZH_TW));
        titleBar.setTitleBarClickListener(new TitleBar.ListenerOnTitleBtnClicked() { // from class: com.sina.weibo.sdk.register.mobile.SelectCountryActivity.1
            @Override // com.sina.weibo.sdk.component.view.TitleBar.ListenerOnTitleBtnClicked
            public void onLeftBtnClicked() {
                SelectCountryActivity.this.setResult(0);
                SelectCountryActivity.this.finish();
            }
        });
        this.mMainLayout.addView(titleBar);
        this.mFrameLayout = new FrameLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, titleBar.getId());
        this.mFrameLayout.setLayoutParams(layoutParams);
        this.mMainLayout.addView(this.mFrameLayout);
        this.mListView = new ListView(this);
        this.mListView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(new ColorDrawable(0));
        this.mListView.setDividerHeight(ResourceManager.dp2px(this, 1));
        this.mListView.setCacheColorHint(0);
        this.mListView.setDrawSelectorOnTop(false);
        this.mListView.setScrollingCacheEnabled(false);
        this.mListView.setScrollbarFadingEnabled(false);
        this.mListView.setVerticalScrollBarEnabled(false);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sina.weibo.sdk.register.mobile.SelectCountryActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                Country country = (Country) SelectCountryActivity.this.mAdapter.getItem(i);
                if (country == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("code", country.getCode());
                intent.putExtra("name", country.getName());
                SelectCountryActivity.this.setResult(-1, intent);
                SelectCountryActivity.this.finish();
            }
        });
        this.mFrameLayout.addView(this.mListView);
        CountryAdapter countryAdapter = new CountryAdapter(this, null);
        this.mAdapter = countryAdapter;
        this.mListView.setAdapter((ListAdapter) countryAdapter);
        LetterIndexBar letterIndexBar = new LetterIndexBar(this);
        this.mLetterIndexBar = letterIndexBar;
        letterIndexBar.setIndexChangeListener(this);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 5;
        this.mLetterIndexBar.setLayoutParams(layoutParams2);
        this.mFrameLayout.addView(this.mLetterIndexBar);
        PinyinUtils.getInstance(this);
        Locale language = ResourceManager.getLanguage();
        if (Locale.SIMPLIFIED_CHINESE.equals(language)) {
            this.countryStr = ResourceManager.readCountryFromAsset(this, "countryCode.txt");
        } else if (Locale.TRADITIONAL_CHINESE.equals(language)) {
            this.countryStr = ResourceManager.readCountryFromAsset(this, "countryCodeTw.txt");
        } else {
            this.countryStr = ResourceManager.readCountryFromAsset(this, "countryCodeEn.txt");
        }
        CountryList countryList = new CountryList(this.countryStr);
        this.result = countryList;
        List<Country> list = countryList.countries;
        this.mCountries = list;
        List<Country>[] subCountries = subCountries(list);
        this.arrSubCountry = subCountries;
        this.indexCountries = compose(subCountries);
        this.mAdapter.notifyDataSetChanged();
        setContentView(this.mMainLayout);
    }

    private List<Country>[] subCountries(List<Country> list) {
        ArrayList[] arrayListArr = new ArrayList[27];
        Country country = new Country();
        country.setCode(Country.CHINA_CODE);
        country.setName(ResourceManager.getString(this, CHINA_EN, CHINA_CN, CHINA_TW));
        arrayListArr[0] = new ArrayList();
        arrayListArr[0].add(country);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayListArr;
            }
            Country country2 = list.get(i2);
            if (country2.getCode().equals("00852") || country2.getCode().equals("00853") || country2.getCode().equals("00886")) {
                arrayListArr[0].add(country2);
            } else {
                int charAt = (country2.getPinyin().charAt(0) - 'a') + 1;
                if (arrayListArr[charAt] == null) {
                    arrayListArr[charAt] = new ArrayList();
                }
                arrayListArr[charAt].add(country2);
            }
            i = i2 + 1;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.sina.weibo.sdk.register.mobile.LetterIndexBar.OnIndexChangeListener
    public void onIndexChange(int i) {
        List<Country>[] listArr = this.arrSubCountry;
        if (listArr == null || i >= listArr.length || listArr[i] == null) {
            return;
        }
        this.mListView.setSelection(this.indexCountries.indexOf(new IndexCountry(i, -1)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }
}
