/*=====================================================================
06.03.2018
eun1310434@naver.com
https://blog.naver.com/eun1310434
참고) Do it android app programming
=====================================================================*/
package com.eun1310434.fragment02;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class Fragment_ImageView extends Fragment {
    ImageView imageView;
    Button button;

    public ImageSelectionCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ImageSelectionCallback) {//ImageSelectionCallback 를 상속받은 것 체크 실행
            callback = (ImageSelectionCallback) context; // mainActivity에서 ImageSelectionCallback의 메소드만 활용 하기 위하여 설정
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_imageview, container, false);

        imageView = (ImageView) rootView.findViewById(R.id.imageView);
        button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedList = callback.onSelectedListFind();
                //selectedList 번호를 통해 활용 가능
            }
        });

        return rootView;
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }

}
