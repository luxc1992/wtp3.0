package com.wantupai.app;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wantupai.app.ui.fragment.ConsultFragment;
import com.wantupai.app.ui.fragment.HomeFragment;
import com.wantupai.app.ui.fragment.MyFragment;
import com.wantupai.app.ui.fragment.TopicFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    FrameLayout fragmentBox;
    @BindView(R.id.find)
    RadioButton mFind;
    @BindView(R.id.Photo)
    RadioButton mPhoto;
    @BindView(R.id.mine)
    RadioButton mMine;
    @BindView(R.id.icon_group)
    RadioGroup mIconGroup;

    private HomeFragment mHomeFragment;
    private ConsultFragment mConsultFragment;
    private TopicFragment mTopicFragment;
    private MyFragment mMyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

        initFragments();
    }

    private void initFragments() {

        mHomeFragment = new HomeFragment();
        mConsultFragment = new ConsultFragment();
        mTopicFragment = new TopicFragment();
        mMyFragment = new MyFragment();

        mIconGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.find:
                        transaction.replace(R.id.fragment_box, mHomeFragment).commit();
                        break;
                    case R.id.Photo:
                        transaction.replace(R.id.fragment_box, mConsultFragment).commit();
                        break;
                    case R.id.mine:
                        transaction.replace(R.id.fragment_box, mMyFragment).commit();
                        break;
                }
            }
        });

        //初始化第一个界面
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_box, mHomeFragment).commit();

    }

    private void initView() {

    }
}
