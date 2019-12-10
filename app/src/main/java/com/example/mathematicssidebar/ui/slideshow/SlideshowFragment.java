package com.example.mathematicssidebar.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mathematicssidebar.R;

public class SlideshowFragment extends Fragment implements View.OnClickListener{
    private EditText first,second;
    private Button btnS;

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        first=root.findViewById(R.id.numone);
        second=root.findViewById(R.id.numtwo);
        btnS=root.findViewById(R.id.btnSwap);
        btnS.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        int a,b;
        a=Integer.parseInt(first.getText().toString());
        b=Integer.parseInt(second.getText().toString());
        b=a+b;
        a=b-a;
        b=b-a;

        first.setText(Integer.toString(a));
        second.setText(Integer.toString(b));
    }
}