/*=====================================================================
06.03.2018
eun1310434@naver.com
https://blog.naver.com/eun1310434
참고) Do it android app programming
=====================================================================*/
package com.eun1310434.fragment02;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ImageSelectionCallback {
    Fragment_ListView listFragment;
    Fragment_ImageView viewerFragment;

    int[] images = {R.drawable.img_a, R.drawable.img_b, R.drawable.img_c};
    int CurrentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();//프래그먼트 관리용 ... 기존 Activity는 설정이 필요없었으나 Fragment는 필요

        listFragment = (Fragment_ListView) manager.findFragmentById(R.id.listFragment);//XML 활용 Fragment 추가
        viewerFragment = (Fragment_ImageView) manager.findFragmentById(R.id.viewerFragment);//XML 활용 Fragment 추가

    }

    @Override
    public void onImageSelected(int position) {
        //프래그먼트 끼리의 통신은 Main에서 무조건 실시한다. listFragment -> MainActivity -> viewerFragment
        CurrentPosition = position;
        viewerFragment.setImage(images[CurrentPosition]);
        listFragment.setListCheck(CurrentPosition,"> ");
    }

    @Override
    public int onSelectedListFind() {
        //프래그먼트 끼리의 통신은 Main에서 무조건 실시한다. listFragment -> MainActivity -> viewerFragment
        listFragment.setListCheck(CurrentPosition,"-----> ");
        return CurrentPosition;
    }
}
