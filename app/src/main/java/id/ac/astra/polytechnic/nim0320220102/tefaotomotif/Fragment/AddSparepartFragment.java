package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Repository.SparepartRepository;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.SparepartVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.UserVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.SparepartModel;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.ViewModel.SparepartViewModel;

public class AddSparepartFragment extends Fragment {
    private Button mBtnSimpan;
    private EditText mEdtSparepartName, mEdtSparepartPrice, mEdtSparepartQuantity, mEdtSparepartBrand,mEdtDeskripsi;
    private SparepartViewModel mSparepartViewModel;

    public AddSparepartFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SparepartRepository.initialize(requireContext());
        mSparepartViewModel = new ViewModelProvider(this).get(SparepartViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_sparepart_fragment, container, false);

        mEdtSparepartName = view.findViewById(R.id.txtSparepartName);
        mEdtSparepartPrice = view.findViewById(R.id.txtSparepartPrice);
        mEdtSparepartQuantity = view.findViewById(R.id.txtQuantity);
        mEdtSparepartBrand = view.findViewById(R.id.txtBrand);
        mEdtDeskripsi = view.findViewById(R.id.txtSparepartDeskripsi);
        mBtnSimpan = view.findViewById(R.id.btnSimpanSparepart);

        mBtnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sparepartName = mEdtSparepartName.getText().toString().trim();
                String sparepartPrice = mEdtSparepartPrice.getText().toString().trim();
                String sparepartQuantity = mEdtSparepartQuantity.getText().toString().trim();
                String sparepartBrand = mEdtSparepartBrand.getText().toString().trim();
                String sparepartDeskripsi = mEdtDeskripsi.getText().toString().trim();

                if (TextUtils.isEmpty(sparepartName) || TextUtils.isEmpty(sparepartPrice) || TextUtils.isEmpty(sparepartQuantity) || TextUtils.isEmpty(sparepartBrand)) {
                    Toast.makeText(getContext(), "All fields must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Buat objek SparepartModel dan isi dengan data
                SparepartModel sparepart = new SparepartModel();
                sparepart.setNamaSparepart(sparepartName);
                sparepart.setHargaSparepart(Integer.parseInt(sparepartPrice));
                sparepart.setSatuanSparepart(Integer.parseInt(sparepartQuantity));
                sparepart.setMerkSparepart(sparepartBrand);
                sparepart.setDeskripsiSparepart(sparepartDeskripsi);

                // Simpan data sparepart
                mSparepartViewModel.saveSparepart(sparepart);

                mSparepartViewModel.getSuccessResponse().observe(getViewLifecycleOwner(), message -> {
                    Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                    navigateToSparepartListFragment();
                });

                mSparepartViewModel.getErrorResponse().observe(getViewLifecycleOwner(), error -> {
                    Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
                });

                mSparepartViewModel.getSparepartResponse().observe(getViewLifecycleOwner(), new Observer<SparepartVO>() {
                    @Override
                    public void onChanged(SparepartVO sparepartVO) {
                        if (sparepartVO != null && sparepartVO.getStatus() == 200) {
                            Toast.makeText(getActivity(), "Error Duplikasi NIM", Toast.LENGTH_SHORT).show();
                        } else {

                        }

                    }
                });
            }
        });

        return view;
    }

    private void navigateToSparepartListFragment() {
        // Navigasi ke fragment daftar sparepart
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_Sparepart, new SparepartListFragment())
                .addToBackStack(null)
                .commit();
    }
}
