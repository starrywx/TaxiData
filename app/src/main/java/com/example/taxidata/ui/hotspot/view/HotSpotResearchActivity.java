package com.example.taxidata.ui.hotspot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.example.taxidata.R;
import com.example.taxidata.base.BaseActivity;
import com.example.taxidata.bean.HotSpotCallBackInfo;
import com.example.taxidata.bean.HotSpotHint;
import com.example.taxidata.bean.HotSpotHistorySearch;
import com.example.taxidata.bean.HotSpotOrigin;
import com.example.taxidata.common.StatusManager;
import com.example.taxidata.ui.hotspot.adapter.HintHotSpotAdapter;
import com.example.taxidata.ui.hotspot.adapter.HistoryHotspotSearchAdapter;
import com.example.taxidata.ui.hotspot.adapter.OriginHotSpotAdapter;
import com.example.taxidata.ui.hotspot.adapter.RecommandHotSpotAdapter;
import com.example.taxidata.ui.hotspot.contract.HotSpotContract;
import com.example.taxidata.ui.hotspot.presenter.HotSpotPresenter;
import com.example.taxidata.util.ToastUtil;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.taxidata.application.TaxiApp.getContext;

/**
 * @author: ODM
 * @date: 2019/8/10
 */
public class HotSpotResearchActivity extends BaseActivity implements HotSpotContract.HotSpotView {

    @BindView(R.id.imagebutton_hotspot_search_back)
    ImageButton btnSearchBack;
    @BindView(R.id.et_hotspot_search)
    EditText etSearch;
    @BindView(R.id.btn_hotspot_search)
    Button btnSearch;
    @BindView(R.id.rv_hotspot_search_history)
    RecyclerView rvSearch;
    private static final String TAG = "HotSpotResearchFragment";
//    @BindView(R.id.imagebutton_hotspot_search_back_test)
//    ImageButton imagebuttonHotspotSearchBackTest;
//    @BindView(R.id.et_hotspot_search_test)
//    EditText etHotspotSearchTest;
//    @BindView(R.id.btn_hotspot_search_test)
//    Button btnHotspotSearchTest;
//    @BindView(R.id.rv_hotspot_search_history_test)
//    RecyclerView rvHotspotSearchHistoryTest;
    private HotSpotPresenter mPresenter = new HotSpotPresenter();
    private List<HotSpotHistorySearch> historyList;
    private List<HotSpotHint> hintList;
    private List<HotSpotCallBackInfo.DataBean> hotSpotList;
    private List<HotSpotOrigin> originList;
    private HistoryHotspotSearchAdapter historyAdapter;
    private HintHotSpotAdapter hintAdapter;
    private RecommandHotSpotAdapter recommandAdapter;
    private OriginHotSpotAdapter originAdapter;
    private GeocodeSearch geocodeSearch ;
    private String intputString;
    private ItemTouchHelper itemTouchHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotspot_search);
        ButterKnife.bind(this);
        mPresenter.attachView(this);
        initData();
        initRecyclerView();
        initOnclickEvent();
        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (StatusManager.hotSpotChosen) {
            //热点已经选定了
            etSearch.setHint("请输入起点");
            showHistoryOriginList(mPresenter.getHistoryOriginList());
        } else {
            //热点尚未选定
            showHistorySearchList(mPresenter.getHistorySearchList());
            etSearch.setHint("请输入地点");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StatusManager.hotSpotChosen = false;
    }

    public void initData() {
        hintList = new ArrayList<>();
        historyList = new ArrayList<>();
        hotSpotList = new ArrayList<>();
        originList = new ArrayList<>();
    }

    public void initViews() {
        geocodeSearch = new GeocodeSearch(this);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                intputString = s.toString();
                if( ! "".equals(intputString) && etSearch.isFocused()) {
                    //当前输入框有内容,将输入的内容发送请求获取提示列表
                    mPresenter.getHintList(s.toString());
                } else {
                    //当前输入框没有内容,则显示历史消息记录
                    showHistorySearchList(mPresenter.getHistorySearchList());
                }
            }
        });
//        etSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean hasFocus) {
//                if(!hasFocus) {
//                    InputMethodManager manager = ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE));
//                    if (manager != null) {
//
//                        manager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//                    }
//                }
//            }
//        });
    }


    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        historyAdapter = new HistoryHotspotSearchAdapter(R.layout.item_hotspot_history, historyList);
        hintAdapter = new HintHotSpotAdapter(R.layout.item_hotspot_hint, hintList);
        recommandAdapter = new RecommandHotSpotAdapter(R.layout.item_hotspot_recommand, hotSpotList);
        recommandAdapter.setEmptyView(new EmptyHotSpotView(this, null));
        originAdapter = new OriginHotSpotAdapter(R.layout.item_hotspot_origin_history, originList);
        rvSearch.setLayoutManager(layoutManager);
        rvSearch.setAdapter(historyAdapter);
        //初始化列表拖拽和滑动删除
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(historyAdapter);
        itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        historyAdapter.enableSwipeItem();
        historyAdapter.openLoadAnimation();
        hintAdapter.openLoadAnimation();
        recommandAdapter.openLoadAnimation();
        originAdapter.openLoadAnimation();
        //历史列表 滑动删除的 回调函数
        historyAdapter.setOnItemSwipeListener(new OnItemSwipeListener() {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
            }
            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.e(TAG, "clearView: 正在删除" );
            }
            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.e(TAG, "onItemSwiped: 已经删除 " );
            }
            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {
            }
        });
    }

    public void initOnclickEvent() {
        //返回按钮点击事件
        btnSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo 搜索页面返回到地图页面？
                finish();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Todo 将输入框的内容发送到P -》M ，请求获取热点数据
                String inputAddress = etSearch.getText().toString();
                //将用户输入的地址转换为坐标
                if (mPresenter != null && !"".equals(inputAddress)) {
                    mPresenter.convertToLocation(inputAddress ,geocodeSearch );
                }
                if(mPresenter != null ) {
                    if ( StatusManager.hotSpotChosen) {
                        mPresenter.saveOriginHotSpotHistory(inputAddress);
                    } else {
                        //保存热点搜索地点，热点选定状态->true
                        mPresenter.saveHotSpotSearchHistory(inputAddress);
                        StatusManager.hotSpotChosen = true;
                    }
                }
            }
        });
        historyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String address = historyAdapter.getData().get(position).getHotSpotHistory();
                etSearch.setText(address);
                mPresenter.convertToLocation(address ,geocodeSearch );
            }
        });
        hintAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.saveHotSpotSearchHistory(hintAdapter.getData().get(position).getHotSpotName());
                etSearch.setText(hintAdapter.getData().get(position).getHotSpotName());
                double longitute = hintAdapter.getData().get(position).getLongitude();
                double latitute = hintAdapter.getData().get(position).getLatitute();
                mPresenter.getHotSpotData(longitute ,latitute ,"");
            }
        });
        recommandAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //Todo：带着 选中的 热点的信息，去到 中间页面
            }
        });
        originAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //Todo：带着 选中的 热点 & 起点信息 ，去 地图页面画出来！
            }
        });
//        提示列表上拉加载没有意义，因为提示 API一个关键词只给10个
//        hintAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                mPresenter.getHintList(intputString);
//            }
//        });

    }


    @Override
    public void showHotSpot(List<HotSpotCallBackInfo.DataBean> hotSpotCallBackInfoList) {

        if (recommandAdapter != null && rvSearch != null) {
            hotSpotList.clear();
            recommandAdapter.setNewData(hotSpotList);
            rvSearch.setAdapter(recommandAdapter);
            itemTouchHelper.attachToRecyclerView(null);
            Logger.d(TAG+hotSpotCallBackInfoList.size());
            recommandAdapter.setNewData(hotSpotCallBackInfoList);
        }
    }

    @Override
    public void showHistorySearchList(List<HotSpotHistorySearch> hotSpotHistorySearchList) {
        if (historyAdapter != null && rvSearch != null) {
            //开启可滑动删除列表item
            itemTouchHelper.attachToRecyclerView(rvSearch);
            rvSearch.setAdapter(historyAdapter);
            historyAdapter.setNewData(hotSpotHistorySearchList);
        }
    }

    @Override
    public void showHintHotSpotList(List<HotSpotHint> hintList) {
        if (hintAdapter != null && rvSearch != null) {
            itemTouchHelper.attachToRecyclerView(null);
            rvSearch.setAdapter(hintAdapter);
            hintAdapter.setNewData(hintList);
        }
    }


    @Override
    public void showHistoryOriginList(List<HotSpotOrigin> hotSpotOrigins) {
        if (originAdapter != null && rvSearch != null) {
            rvSearch.setAdapter(originAdapter);
            originAdapter.setNewData(hotSpotOrigins);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
