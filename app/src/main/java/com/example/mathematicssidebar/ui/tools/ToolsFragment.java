package com.example.mathematicssidebar.ui.tools;

import android.app.Activity;
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

public class ToolsFragment extends Fragment implements View.OnClickListener{
    private Button btnCc;
    private EditText num;

    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        btnCc=root.findViewById(R.id.btnChe);
        num=root.findViewById(R.id.numvv);
        btnCc.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        int n,tmp,number,check=0,a=0;
        n=Integer.parseInt(num.getText().toString());
        tmp=n;
        number=n*n;

        while(n>0)
        {
            a=a+1;
            for(int i=0;number>=1;i++)
            {

                if(n%10==number%10)
                {
                    check=check+1;


                }
                number=number/10;

            }
            number=tmp;
            n=n/10;



        }











        if(check==a)
        {
            Toast.makeText(getActivity(),"The number is Automorphic",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getActivity(),"The number is not Automorphic",Toast.LENGTH_SHORT).show();
        }


    }
}