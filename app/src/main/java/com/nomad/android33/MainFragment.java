package com.nomad.android33;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MainFragment extends Fragment {
    private Button button;
    private EditText editTextName, editTextSurname;


    public final static String THEME = "theme";
    public final static String MASSAGE = "massage";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.btn);
        editTextName = view.findViewById(R.id.ed_name);
        editTextSurname = view.findViewById(R.id.ed_surname);

        button.setOnClickListener(view1 -> {
            MainActivity activity = (MainActivity) requireActivity();
            MainActivity.isMainFragment = false;
            Bundle bundle = new Bundle();
            Fragment fragment = new SecondFragment();
            if (editTextName.getText()!=null){
                bundle.putString(THEME,editTextName.getText().toString());
            }
            if (editTextSurname.getText()!=null){
                bundle.putString(MASSAGE,editTextSurname.getText().toString());
            }
            fragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
        });
    }
}