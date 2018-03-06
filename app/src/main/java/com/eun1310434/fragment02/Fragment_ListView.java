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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Fragment_ListView extends Fragment {
    String[] BasicValues = {"Image A", "Image B", "Image C"};
    String[] values = {"Image A", "Image B", "Image C"};
    ListView listView;
    ArrayAdapter<String> adapter;

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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_listview, container, false);

        listView = (ListView) rootView.findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (callback != null) {
                    callback.onImageSelected(position);
                }
            }
        });

        return rootView;
    }


    public void setListCheck(int position, String Check) {
        for(int i = 0 ; i < BasicValues.length ; i++){
            if(i == position){
                values[i] = Check+BasicValues[i];
            }else{
                values[i] = BasicValues[i];
            }
        }
        adapter.notifyDataSetChanged();
    }

}
