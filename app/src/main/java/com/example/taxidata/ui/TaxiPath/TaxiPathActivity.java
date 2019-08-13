package com.example.taxidata.ui.TaxiPath;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolylineOptions;
import com.example.taxidata.R;
import com.example.taxidata.base.BaseActivity;
import com.example.taxidata.bean.GetTaxiPathInfo;
import com.example.taxidata.bean.TaxiInfo;
import com.example.taxidata.bean.TaxiPathInfo;
import com.example.taxidata.constant.Area;
import com.example.taxidata.widget.DropDownSelectView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.taxidata.constant.Area.BAI_YUN;
import static com.example.taxidata.constant.Area.CONG_HUA;
import static com.example.taxidata.constant.Area.HAI_ZHU;
import static com.example.taxidata.constant.Area.HUANG_PU;
import static com.example.taxidata.constant.Area.HUA_DU;
import static com.example.taxidata.constant.Area.LI_WAN;
import static com.example.taxidata.constant.Area.NAN_SHA;
import static com.example.taxidata.constant.Area.PAN_YU;
import static com.example.taxidata.constant.Area.TIAN_HE;
import static com.example.taxidata.constant.Area.YUE_XIU;
import static com.example.taxidata.constant.Area.ZENG_CHENG;

public class TaxiPathActivity extends BaseActivity implements TaxiPathContract.TaxiPathView {

    @BindView(R.id.taxi_path_clear_btn)
    Button taxiPathClearBtn;
    @BindView(R.id.taxi_path_map)
    MapView taxiPathMap;
    @BindView(R.id.taxi_path_licenseplateno_btn)
    Button taxiPathLicenseplatenoBtn;
    @BindView(R.id.taxi_path_area_select_view)
    DropDownSelectView taxiPathAreaSelectView;

    private TaxiPathContract.TaxiPathPresent taxiPathPresent;
    private AMap taxiPathAMap;
    private double longitude;    //经度
    private double latitude;     //纬度
    private int area;
    private List<TaxiInfo.DataBean> taxiList = new ArrayList<>();
    ArrayList<String> areaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi_path);
        ButterKnife.bind(this);
        taxiPathPresent = new TaxiPathPresent();
        taxiPathPresent.attachView(this);
        //绑定显示出租车信息的dialog
        EventBus.getDefault().register(this);
        //隐藏清除按钮
        taxiPathClearBtn.setVisibility(View.GONE);
        //初始化区域选择框
        initAreaList();
        //得到地图实例
        if (taxiPathAMap == null) {
            taxiPathAMap = taxiPathMap.getMap();
        }
        taxiPathMap.onCreate(savedInstanceState);
        //设置默认显示番禺区
        LatLng latLng = Area.area_latlng.get(5);
        taxiPathAMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        taxiPathPresent.detachView();
        EventBus.getDefault().unregister(this);
    }

    //初始化车牌号列表dialog
    @Override
    public void initList(List<TaxiInfo.DataBean> taxiInfoList) {
        taxiList.addAll(taxiInfoList);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    }

    //在地图上显示出租车路径
    @Override
    public void showPath(List<TaxiPathInfo.DataBean> listInfo) {
        List<LatLng> latLngs = new ArrayList<LatLng>();
        for (TaxiPathInfo.DataBean info : listInfo) {
            latLngs.add(new LatLng(info.getLatitude(), info.getLongitude()));
        }
        taxiPathAMap.addPolyline(new PolylineOptions()
                .addAll(latLngs)
                .width(10)
                .color(Color.GREEN));
        //显示清除路径按钮
        taxiPathClearBtn.setVisibility(View.VISIBLE);
    }

    //处理dialog发送的事件
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void getPathInfo(GetTaxiPathInfo getTaxiPathInfo) {
        taxiPathPresent.getTaxiPathInfo(this, getTaxiPathInfo.getTime(), getTaxiPathInfo.getLicenseplateno());
    }

    //点击事件
    @OnClick({R.id.taxi_path_clear_btn, R.id.taxi_path_licenseplateno_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.taxi_path_clear_btn:
                //清除地图显示的路径
                taxiPathAMap.clear();
                //将清除按钮隐藏
                taxiPathClearBtn.setVisibility(View.GONE);
                break;
            case R.id.taxi_path_licenseplateno_btn:
                //显示车牌号
                //得到用户所选区域
                area = 1;
                taxiPathPresent.getTaxiInfo(TaxiPathActivity.this, area, "2017-02-01 17:00:00");
                break;
        }
    }

    //初始化区域popupWindow
    private void initAreaList() {
        areaList.add(LI_WAN);
        areaList.add(YUE_XIU);
        areaList.add(TIAN_HE);
        areaList.add(HAI_ZHU);
        areaList.add(HUANG_PU);
        areaList.add(HUA_DU);
        areaList.add(BAI_YUN);
        areaList.add(PAN_YU);
        areaList.add(NAN_SHA);
        areaList.add(CONG_HUA);
        areaList.add(ZENG_CHENG);
        taxiPathAreaSelectView.setItemsData(areaList, 1);
    }
}
