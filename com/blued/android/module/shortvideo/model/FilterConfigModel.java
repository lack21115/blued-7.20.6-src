package com.blued.android.module.shortvideo.model;

import com.blued.android.module.external_sense_library.config.BluedFilterType;
import com.blued.android.module.external_sense_library.manager.FilterDataManager;
import com.blued.android.module.shortvideo.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/FilterConfigModel.class */
public class FilterConfigModel extends IModel {
    private final int[] mFilterShowNameRsIds = {R.string.flash_filter_ruby, R.string.flash_filter_pansy, R.string.flash_filter_morden, R.string.flash_filter_city, R.string.flash_filter_babypink};
    private final int[] mFilterIconRsIds = {R.drawable.stv_flash_ruby, R.drawable.stv_flash_pansy, R.drawable.stv_flash_modern, R.drawable.stv_flash_city, R.drawable.stv_flash_babypink};
    private final FilterItem nullKwFilter = new FilterItem(null, R.drawable.stv_flash_origin, R.string.live_filter_off);
    private List<FilterItem> filtersDatas = new ArrayList();
    private Map<BluedFilterType.FILER, FilterItem> mFilterNameMap = new HashMap();

    /* renamed from: com.blued.android.module.shortvideo.model.FilterConfigModel$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/FilterConfigModel$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15753a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[BluedFilterType.FILER.values().length];
            f15753a = iArr;
            try {
                iArr[BluedFilterType.FILER.RUBY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15753a[BluedFilterType.FILER.PANSY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15753a[BluedFilterType.FILER.MODERN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15753a[BluedFilterType.FILER.CITY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public List<FilterItem> getFilters() {
        int i;
        if (this.filtersDatas.size() > 0) {
            return this.filtersDatas;
        }
        this.filtersDatas.add(this.nullKwFilter);
        List<BluedFilterType.FILER> filters = FilterDataManager.getInstance().getFilters();
        FilterItem[] filterItemArr = new FilterItem[5];
        if (this.mFilterNameMap.size() <= 0) {
            Iterator<BluedFilterType.FILER> it = filters.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BluedFilterType.FILER next = it.next();
                if (next != null) {
                    int i2 = AnonymousClass1.f15753a[next.ordinal()];
                    char c2 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? (char) 4 : (char) 3 : (char) 2 : (char) 1 : (char) 0;
                    filterItemArr[c2] = new FilterItem(next, this.mFilterIconRsIds[c2], this.mFilterShowNameRsIds[c2]);
                }
            }
            for (i = 0; i < 5; i++) {
                FilterItem filterItem = filterItemArr[i];
                if (filterItem != null && filterItem.b() != null) {
                    this.mFilterNameMap.put(filterItem.b(), filterItem);
                    this.filtersDatas.add(filterItem);
                }
            }
        } else {
            this.filtersDatas.addAll(this.mFilterNameMap.values());
        }
        return this.filtersDatas;
    }
}
