package com.wantupai.app.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wantupai.app.R;
import com.wantupai.app.model.bean.HomeBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class HomeAdapter extends XRecyclerView.Adapter {


    private  List<HomeBean.T1348647909107Bean> mList;
    private Context mContext;


    public HomeAdapter(Context context, List<HomeBean.T1348647909107Bean> list) {
        this.mContext = context;
        this.mList = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.home_item, null);
        HomeViewHoler homeViewHoler = new HomeViewHoler(inflate);
        return homeViewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        HomeBean.T1348647909107Bean t1348647909107Bean = mList.get(i);
        HomeViewHoler homeViewHoler = (HomeViewHoler) viewHolder;
        Glide.with(mContext).load(t1348647909107Bean.getImgsrc()).into(homeViewHoler.mHome_img);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HomeViewHoler extends XRecyclerView.ViewHolder {

        private final ImageView mHome_img;

        public HomeViewHoler(@NonNull View itemView) {
            super(itemView);
            mHome_img = itemView.findViewById(R.id.home_img);
        }
    }
}
