package com.svafvel.software.production.latihanfragmentandroid;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener{


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);
        btnDetailCategory.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_detail_category){

            DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment();

            Bundle mBundle = new Bundle();
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle");
            String description = "Katagori ini akan berisi produk-produk lifestyle";

            mDetailCategoryFragment.setArguments(mBundle);
            mDetailCategoryFragment.setDescription(description);

            /* Method addBackStack akan menambahkan fragment ke backstact Behavior dari button akan cek
            * fragmane dari backstact, jika ada fragment di dalam backstack maka fragment yang akan di
            * closse / remove jika sudah tidak ada fragment di dalam backstack maka activity yang akan diclose / finish */


//            CategoryFragment mCategoryFragment = new CategoryFragment();
            FragmentManager mFragmentManager = getFragmentManager();
            if(mFragmentManager != null){

                mFragmentManager.
                        beginTransaction().
                        replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment.class.getSimpleName()).
                        addToBackStack(null).
                        commit();

            }

        }
    }
}
