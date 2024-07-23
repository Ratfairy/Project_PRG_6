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

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Repository.LayananRepository;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Repository.SparepartRepository;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.LayananVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.SparepartVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.LayananModel;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.SparepartModel;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.ViewModel.LayananViewModel;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.ViewModel.SparepartViewModel;

public class AddServiceFragment extends Fragment
{
    private Button mBtnSimpan;
    private EditText mEdtLayananName, mEdtLayananPrice, mEdtEstimasi;
    private LayananViewModel mLayananViewModel;

    public AddServiceFragment()
    {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayananRepository.initialize(requireContext());
        mLayananViewModel = new ViewModelProvider(this).get(LayananViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_service, container, false);
        mEdtLayananName = view.findViewById(R.id.txtServiceName);
        mEdtLayananPrice = view.findViewById(R.id.txtServicePrice);
        mEdtEstimasi = view.findViewById(R.id.txtEstimated);
        mBtnSimpan = view.findViewById(R.id.btnAddLayanan);

        mBtnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String layananName = mEdtLayananName.getText().toString().trim();
                String layananPrice = mEdtLayananPrice.getText().toString().trim();
                String Estimated = mEdtEstimasi.getText().toString().trim();

                if (TextUtils.isEmpty(layananName) || TextUtils.isEmpty(layananPrice) || TextUtils.isEmpty(Estimated)) {
                    Toast.makeText(getContext(), "All fields must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Buat objek SparepartModel dan isi dengan data
                LayananModel layanan = new LayananModel();
                layanan.setNamaLayanan(layananName);
                layanan.setHargaLayanan(Integer.parseInt(layananPrice));
                layanan.setEstimasiLayanan(Integer.parseInt(Estimated));

                // Simpan data sparepart
                mLayananViewModel.saveLayanan(layanan);

                mLayananViewModel.getSuccessResponse().observe(getViewLifecycleOwner(), message -> {
                    Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                    navigateToSparepartListFragment();
                });

                mLayananViewModel.getErrorResponse().observe(getViewLifecycleOwner(), error -> {
                    Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
                });

                mLayananViewModel.getLayananResponse().observe(getViewLifecycleOwner(), new Observer<LayananVO>() {
                    @Override
                    public void onChanged(LayananVO layananVO) {
                        if (layananVO != null && layananVO.getStatus() == 200) {
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
                .replace(R.id.fragment_Service, new ServiceListFragment())
                .addToBackStack(null)
                .commit();
    }
}
