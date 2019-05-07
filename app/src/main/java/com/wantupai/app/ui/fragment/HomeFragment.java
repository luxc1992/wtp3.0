package com.wantupai.app.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.wantupai.app.R;
import com.wantupai.app.adapters.HomeAdapter;
import com.wantupai.app.base.BaseFragment;
import com.wantupai.app.base.interfaces.contrenct.HomeContract;
import com.wantupai.app.model.bean.HomeBean;
import com.wantupai.app.presenter.HomePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {


    @BindView(R.id.home_xre)
    XRecyclerView mHomeXre;
    private View view;
    private Unbinder unbinder;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView(View v) {

    }

    @Override
    protected void initData() {
        presenter.HomeList();

    }


    @Override
    public void showHomeChannel(List<HomeBean.T1348647909107Bean> list) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mHomeXre.setLayoutManager(gridLayoutManager);
        HomeAdapter homeAdapter = new HomeAdapter(getContext(), list);
        mHomeXre.setAdapter(homeAdapter);

    }
}


