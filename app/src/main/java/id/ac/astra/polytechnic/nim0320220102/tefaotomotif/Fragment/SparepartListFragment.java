package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;

public class SparepartListFragment extends Fragment {

    private ImageView tambahAddSparepart;

    public SparepartListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize fragment-specific logic here if needed
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sparepart_list, container, false);

        //Pindah Fragment tambah Add Service
        tambahAddSparepart = view.findViewById(R.id.plusIcon1);
        tambahAddSparepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddSparepartFragment fragmentForgetPassword = new AddSparepartFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Sparepart, fragmentForgetPassword);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Initialize views, setup adapters or listeners here
    }
}
