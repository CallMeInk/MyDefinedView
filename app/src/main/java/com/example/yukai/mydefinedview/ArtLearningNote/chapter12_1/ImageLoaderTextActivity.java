package com.example.yukai.mydefinedview.ArtLearningNote.chapter12_1;

import android.app.Activity;
import android.graphics.BitmapShader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.BitmapUtils;

/**
 * Created by yukai on 2018/3/7.
 */

public class ImageLoaderTextActivity extends Activity{

    private ImageView mImageView;

    private GridView mGridView;

    private ImageLoader mImageLoader;

    private final String[] mUrlList = {
            "http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg",
            "http://img5.imgtn.bdimg.com/it/u=807605679,2027849210&fm=27&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1046983545,2051560208&fm=27&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=242354780,308135522&fm=27&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=147015573,3182587356&fm=27&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=4166721891,1503444760&fm=27&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=2194466256,3369833539&fm=27&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=3033257042,4077893909&fm=27&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=3478354780,1881434083&fm=27&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=4206126491,3754118948&fm=27&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=3895380214,1877236727&fm=27&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=1120065146,4182425066&fm=27&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=4106268149,3375352268&fm=27&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1919148010,2425935279&fm=27&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=3315553323,1499582357&fm=27&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=754915674,2504439448&fm=27&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=1580469912,4008553482&fm=27&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=971163052,3737099167&fm=27&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=342011580,3965983904&fm=27&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2956120171,1289370557&fm=27&gp=0.jpg"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_loader_test_activity_layout);
        mImageLoader = ImageLoader.build(this);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mImageView.setImageBitmap(BitmapUtils.decodeSampleBitmapFromResource(getResources(), R.drawable.hilton, 150, 150));
        mGridView = (GridView) findViewById(R.id.pic_grid_view);
        mGridView.setAdapter(new ImageAdapter());

    }

    private class ImageAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mUrlList.length;
        }

        @Override
        public Object getItem(int position) {
            return mUrlList[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null){
                convertView = LayoutInflater.from(ImageLoaderTextActivity.this).inflate(R.layout.image_loader_pic_grid_item, parent, false);
                holder = new ViewHolder();
                holder.mImageView = (ImageView) convertView.findViewById(R.id.image);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            ImageView imageView = holder.mImageView;
            final String tag = (String) imageView.getTag();
            final String uri = (String) getItem(position);
            imageView.setTag(uri);
            mImageLoader.bindBitmap(uri, imageView);
            Log.e("yk", "position::" + position);

            return convertView;
        }
    }

    private class ViewHolder{
        public ImageView mImageView;
    }
}
