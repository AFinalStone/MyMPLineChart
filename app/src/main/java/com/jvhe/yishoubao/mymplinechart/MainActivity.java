package com.jvhe.yishoubao.mymplinechart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChart = (LineChart) findViewById(R.id.chart);

        Description ds = new Description();
        ds.setText("七日收益");
        mChart.setDescription(ds);
        mChart.setData( getLineData() );


        //设置X轴
        XAxis mXAxis = mChart.getXAxis();
        mXAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        mXAxis.setDrawGridLines(false);
        mXAxis.setValueFormatter(new YearXAxisFormatter());

        //设置右侧的Y轴
        YAxis mAxisYRight = mChart.getAxisRight();
        mAxisYRight.setDrawAxisLine(false);

        //设置动画效果
        mChart.animateY(2000, Easing.EasingOption.Linear);
        mChart.animateX(2000, Easing.EasingOption.Linear);
        mChart.invalidate();
    }

    /* 將 DataSet 資料整理好後，回傳 LineData */
    private LineData getLineData(){
        final int DATA_COUNT = 5;  //資料數固定為 5 筆

        // LineDataSet(List<Entry> 資料點集合, String 類別名稱)
        LineDataSet dataSetA = new LineDataSet( getChartDataA(DATA_COUNT, 1), "A");

        LineDataSet dataSetB = new LineDataSet( getChartDataB(DATA_COUNT, 2), "B");

        //设置这条折线的颜色
        dataSetB.setColor(Color.RED);
        //设置折线点的颜色
        dataSetB.setCircleColor(0xFF333333);
        //设置点击某个点时候的横纵坐标
        dataSetB.setHighlightLineWidth(3f);
        dataSetB.setHighLightColor(Color.RED);
        //设置底部的遮影
        dataSetB.setDrawFilled(true);

        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSetA);
        dataSets.add(dataSetB);

        // LineData(List<String> Xvals座標標籤, List<Dataset> 資料集)
        LineData data = new LineData(dataSets);

        return data;

    }

    /* 取得 List<Entry> 的資料給 DataSet */
    private List<Entry> getChartDataA(int count, int ratio){

        List<Entry> chartData = new ArrayList<>();
        for(int i=0;i<count;i++){
            // Entry(value 數值, index 位置)
            chartData.add(new Entry( i*2*ratio, i));
        }
        return chartData;
    }

    /* 取得 List<Entry> 的資料給 DataSet */
    private List<Entry> getChartDataB(int count, int ratio){

        List<Entry> chartData = new ArrayList<>();
        chartData.add(new Entry( 0*2*ratio, 0));
        chartData.add(new Entry( 1*2*ratio, 10));
        chartData.add(new Entry( 2*2*ratio, 40));
        chartData.add(new Entry( 3*2*ratio, 30));
        chartData.add(new Entry( 4*2*ratio, 50));
        return chartData;
    }

    /* 取得 XVals Labels 給 LineData */
    private List<String> getLabels(int count){

        List<String> chartLabels = new ArrayList<>();
        for(int i=0;i<count;i++) {
            chartLabels.add("X" + i);
        }
        return chartLabels;
    }

}
