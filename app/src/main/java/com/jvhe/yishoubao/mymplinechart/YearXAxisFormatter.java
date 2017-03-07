package com.jvhe.yishoubao.mymplinechart;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;


/**
 * Created by SHI Jahoda on 14/09/15.
 */
public class YearXAxisFormatter implements IAxisValueFormatter {

    protected String[] mMonths = new String[]{
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"
    };

    public YearXAxisFormatter() {
        // maybe do something here or provide parameters in constructor

    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        float percent = value / axis.mAxisRange;
        return mMonths[(int) (mMonths.length * percent)];
    }
}
