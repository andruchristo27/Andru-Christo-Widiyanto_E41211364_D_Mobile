package com.example.acara18;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.app.Fragment;
import androidx.annotation.Nullable;
public class SecondFragment extends Fragment {
    View view;
    Button firstButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_second, container, false);
        //get the reference of Button
        firstButton = view.findViewById(R.id.secondButton);
        //perform setOnClickListener on secondButton
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //display a massage by using a Toast
                Toast.makeText(getActivity(), "First Fragment", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
