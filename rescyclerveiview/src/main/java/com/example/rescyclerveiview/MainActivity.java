package com.example.rescyclerveiview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //1
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //2
        gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 3 - position % 3;
            }
        });

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        myadapter = new Myadapter();
        recyclerView.setAdapter(myadapter);
        myadapter.setOnItemClickListener(new Myadapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                myadapter.add(position);
            }
        });


        myadapter.setOnItemLongClickListener(new Myadapter.OnItemLongClickListener() {
            @Override
            public void OnItemLongClick(View view, int position) {
                myadapter.updata(position, "更新后的内容");
            }
        });

        recyclerView.addItemDecoration(new MyDecoration(this, LinearLayoutManager.VERTICAL));
    }

    public void onclick(View view) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        if (layoutManager instanceof GridLayoutManager) {
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(myadapter);
        } else if (layoutManager instanceof LinearLayoutManager) {
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(myadapter);
        }


    }


}
