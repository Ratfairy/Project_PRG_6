package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Repository.UserRepository;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.UserVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Activity.DashboardActivity;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Activity.DashboardAdminActivity;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.UserModel;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.ViewModel.UserViewModel;

public class LoginFragment extends Fragment {
    private final String TAG = "LoginFragment";

    private EditText mEdtUsername, mEdtPassword;
    private Button mBtnLogin;
    private UserViewModel mUserViewModel;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Navigated to LoginFragment");
        super.onCreate(savedInstanceState);
        UserRepository.initialize(requireContext());
        mUserViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        checkLogin();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        mEdtUsername = view.findViewById(R.id.txtUsername);
        mEdtPassword = view.findViewById(R.id.txtPassword);

        mBtnLogin = view.findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEdtUsername.getText().toString().trim();
                String password = mEdtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) ) {
                    Toast.makeText(getContext(), "All fields must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }
                mUserViewModel.getUserLogin(username, password);
                observeLoginResponse();
            }
        });

        return view;
    }

    private void checkLogin() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            String role = sharedPreferences.getString("role", null);
            navigateToDashboard(role);
        }
    }

    private void navigateToDashboard(String role) {
        if (role.equals("Customer")) {
            Intent intent = new Intent(getActivity(), DashboardActivity.class);
            startActivity(intent);
            getActivity().finish();
        } else if (role.equals("Admin")) {
            Intent intent = new Intent(getActivity(), DashboardAdminActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }

    private void observeLoginResponse() {
        mUserViewModel.getLoginResponse().observe(getViewLifecycleOwner(), new Observer<UserVO>() {
            @Override
            public void onChanged(UserVO userVO) {
                if (userVO != null && userVO.getData() != null) {
                    Integer idUser = userVO.getData().getIdUser();
                    String namaUser = userVO.getData().getNama();
                    String noTelp = userVO.getData().getNoHp();
                    String role = userVO.getData().getRole();
                    String status = userVO.getData().getStatus();
                    UserModel dataLogin = new UserModel(idUser, namaUser, noTelp, role, status);

                    if (dataLogin.getRole().equals("Owner")) {
                        Toast.makeText(getActivity(), "Email dan password salah", Toast.LENGTH_SHORT).show();
                    } else {
                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("loginSession", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        Gson gson = new Gson();
                        String userJson = gson.toJson(dataLogin);
                        editor.putString("dataUser", userJson);
                        editor.putBoolean("isLoggedIn", true);
                        editor.putString("role", role);
                        editor.apply();
                        Toast.makeText(getActivity(), "Login berhasil", Toast.LENGTH_SHORT).show();
                        navigateToDashboard(role);
                    }
                } else {
                    Toast.makeText(getActivity(), "Email dan password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
