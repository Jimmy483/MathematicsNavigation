package com.example.mathematicssidebar.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mathematicssidebar.R;

public class GalleryFragment extends Fragment implements View.OnClickListener{
    private Button btnC;
    private EditText num;

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        btnC=root.findViewById(R.id.btnCheck);
        num=root.findViewById(R.id.number);
        btnC.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        int number,check=0,n;
        number=Integer.parseInt(num.getText().toString());;

        n=number;

        for(int i=0;n>0;i++)
        {
            check=n%10+(check*10);
            n=n/10;


        }

        if(number==check)
        {
            Toast.makeText(getActivity(),"The Number is Palindrome",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getActivity(),"The Number is not Palindrome",Toast.LENGTH_SHORT).show();
        }
    }
}