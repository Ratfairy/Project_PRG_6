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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Repository.UserRepository;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.UserVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.UserModel;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.ViewModel.UserViewModel;

public class RegisterFragment extends Fragment {
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtNama;
    private EditText edtNoHp;
    private Button btnTambah;
    private UserViewModel mUserViewModel;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserRepository.initialize(requireContext());
        mUserViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        edtUsername = view.findViewById(R.id.txtUsername);
        edtPassword = view.findViewById(R.id.txtPassword);
        edtNama = view.findViewById(R.id.txtFullname);
        edtNoHp = view.findViewById(R.id.txtContact);
        btnTambah = view.findViewById(R.id.btnRegist);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String nama = edtNama.getText().toString().trim();
                String nohp = edtNoHp.getText().toString().trim();


                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(nama) || TextUtils.isEmpty(nohp)) {
                    Toast.makeText(getContext(), "All fields must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }

                UserModel createUser = new UserModel();
                createUser.setUsername(username);
                createUser.setPassword(password);
                createUser.setNama(nama);
                createUser.setNoHp(nohp);

                mUserViewModel.saveUser(createUser);

                mUserViewModel.getSuccessMessage().observe(getViewLifecycleOwner(), message -> {
                    Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                    navigateToLoginFragment();
                });

                mUserViewModel.getErrorMessage().observe(getViewLifecycleOwner(), error -> {
                    Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
                });


                mUserViewModel.getUserResponse().observe(getViewLifecycleOwner(), new Observer<UserVO>() {
                    @Override
                    public void onChanged(UserVO userVO) {
                        if (userVO != null && userVO.getStatus() == 200) {
                            Toast.makeText(getActivity(), "Error Duplikasi NIM", Toast.LENGTH_SHORT).show();
                        } else {

                        }

                    }
                });
            }
        });

        return view;
    }

    private void navigateToLoginFragment() {
        Fragment loginFragment = new LoginFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.LogSignActivity, loginFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUserViewModel.getUserResponse().removeObservers(this);
        mUserViewModel.getSuccessMessage().removeObservers(this);
        mUserViewModel.getErrorMessage().removeObservers(this);
    }
}
