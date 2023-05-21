package com.example.loginpageveuygulama;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class CosmeticsFrag2 extends Fragment {

    TextView bill,rankings,product_name;
    ImageView resim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cosmetics_frag2, container, false);

        bill=view.findViewById(R.id.bill);
        rankings=view.findViewById(R.id.rankings);
        product_name=view.findViewById(R.id.product_name);
        resim=view.findViewById(R.id.resim);

        Bundle bundle = this.getArguments();
        if(bundle!=null){
            String cos = getArguments().getString("arg1");
            product_name.setText(cos);
            String cos1 = getArguments().getString("arg3");
            rankings.setText(cos1);
            String cos2 = getArguments().getString("arg4");
            bill.setText(cos2);
            Bitmap cosimg = getArguments().getParcelable("arg2");
            resim.setImageBitmap(cosimg);
        }

        return view;


    }
}