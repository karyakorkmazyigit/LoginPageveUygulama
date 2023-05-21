package com.example.loginpageveuygulama;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CosmeticsFrag extends Fragment {

    ListView mylist;
    private ArrayAdapter<String> adapter;

    private String [] ranking={"★4.5","★4.7","★4.7","★4.3","★4.2","★3.7","★2.3",
            "★0.2","★3.3","★4.8",
            "★5.0","★3.7",
            "★4.0","★3.5","★2.7","★1.7"};

    private String [] bill={"100TL","175TL","250TL","75TL","120TL","55TL","45TL",
            "20TL","65TL","167TL",
            "175TL","169TL",
            "123TL","69TL","70TL","55TL"};
    private String [] cosmeticler={"Face Primer","Foundation","Concealer","Face Powder","Rouge","Blush","Highlighter",
            "Bronzer","Eyebrow Pen","Eye Primer",
            "Mascara","Lip-liners",
            "Lip Gloss","Setting Spray","Nail Polish","Remover"};
    private int[] cosmeticimg={R.drawable.face_primer,R.drawable.foundation,R.drawable.concealer,R.drawable.face_powder,
            R.drawable.rouge,R.drawable.blush,R.drawable.highlighter,R.drawable.bronzer,R.drawable.eyebrow_pen,R.drawable.eye_pri,
            R.drawable.mascara,R.drawable.lip_liner,R.drawable.lip_gloss,R.drawable.setting_spray,R.drawable.nail_polish,
            R.drawable.makeup_romver};
    private Bitmap choose_cosmetic;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cosmetics, container, false);

        mylist=view.findViewById(R.id.mylist);
        adapter=new ArrayAdapter<>(view.getContext(),android.R.layout.simple_expandable_list_item_1,cosmeticler);
        mylist.setAdapter(adapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                String cosmetic = cosmeticler[i];
                String rankings=ranking[i];
                String bills= bill[i];
                bundle.putString("arg1",cosmetic);
                bundle.putString("arg3",rankings);
                bundle.putString("arg4",bills);
                choose_cosmetic= BitmapFactory.decodeResource(getActivity().getApplicationContext().getResources(),cosmeticimg[i]);
                bundle.putParcelable("arg2",choose_cosmetic);
                CosmeticsFrag2 fragment2 = new CosmeticsFrag2();
                fragment2.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragments,fragment2).commit();
            }
        });
        return view;
    }
}