package com.xk2318.emotionkeyboard.viewpager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xk2318.emotionkeyboarddemo.R;

/**
 * Created by xiaokai on 2017/02/07.
 */
public class EmotionFragment extends Fragment {

    private Context mContext;
    private GridView emotionGrid;
    private int startPosition;

    public static EmotionFragment newInstance(int position) {
        EmotionFragment fragment = new EmotionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("emotion_start_position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* 先确定每页第一个表情的position */
        if(getArguments() != null){
            startPosition = getArguments().getInt("emotion_start_position", 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emotion_gird_classic, container, false);
        emotionGrid = (GridView) view.findViewById(R.id.grid);
        emotionGrid.setAdapter(new MyAdapter());
        emotionGrid.setOnItemClickListener(
                GlobalOnItemClickManager.getInstance().getOnItemClickListener(startPosition/20, mContext));
        
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 21;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.emotion_gird_item_classic, parent, false);
                holder = new ViewHolder();
                holder.img = (ImageView) convertView.findViewById(R.id.image);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            String path= "";
            if(position == 20){
                path = "file:///android_asset/ems/delete.png";
            } else {
                path = "file:///android_asset/ems/" + (position + startPosition) + ".png";
            }
            Picasso.with(mContext).load(path).into(holder.img);
            return convertView;
        }

        class ViewHolder{
            public ImageView img;
        }
    }
}
