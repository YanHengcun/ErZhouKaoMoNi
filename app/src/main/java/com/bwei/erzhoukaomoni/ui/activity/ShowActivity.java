package com.bwei.erzhoukaomoni.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bwei.erzhoukaomoni.R;
import com.bwei.erzhoukaomoni.data.persenter.PresentImpl;
import com.bwei.erzhoukaomoni.di.IContract;
import com.bwei.erzhoukaomoni.ui.wethg.myListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

/**
 * Created by Jack Lee on 2018/8/11.
 * name:Juck Lee
 */

public class ShowActivity extends AppCompatActivity implements IContract.IView, View.OnClickListener {
    private EditText edit_text;
    private Button sousuo;
    private myListView Mylist_view;
    private PullToRefreshScrollView pull_to_refresh;
    private IContract.IPersenter<IContract.IView> present;
    private int page =1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show);
        initView();
        //连接P层
        present = new PresentImpl();
        present.attachView(this);

        String souxia = edit_text.getText().toString();

        pull_to_refresh.setMode(PullToRefreshBase.Mode.BOTH);
        pull_to_refresh.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                page=1;
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                page++;
            }
        });
    }


    @Override
    public void showResponseMsg(String failureString) {

    }

    private void initView() {
        edit_text = (EditText) findViewById(R.id.edit_text);
        sousuo = (Button) findViewById(R.id.sousuo);
        Mylist_view = (myListView) findViewById(R.id.Mylist_view);
        pull_to_refresh = (PullToRefreshScrollView) findViewById(R.id.pull_to_refresh);

        sousuo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sousuo:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        present.detachView(this);
    }
}
