package com.example.android.bookclublatest.Authentication.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.bookclublatest.Admin.AdminActivity;
import com.example.android.bookclublatest.Authentication.Login.LoginActivity;
import com.example.android.bookclublatest.Base.BaseActivity;
import com.example.android.bookclublatest.BuildConfig;
import com.example.android.bookclublatest.Member.MemberActivity;
import com.example.android.bookclublatest.R;
import com.example.android.bookclublatest.Student.StudentActivity;
import com.firebase.ui.auth.ui.email.SignInActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends BaseActivity implements SignUpContract.View {


    @BindView(R.id.name)
    EditText name;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.admissionnumber)
    EditText admissionnumber;

    @BindView(R.id.phonenumber)
    EditText phonenumber;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.create_account)
    Button createaccount;

    SignUpContract.Presenter<SignUpContract.View> mPresenter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);


        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();
                mPresenter.CreateAccount(name.getText().toString().trim(),email.getText().toString().trim()
                ,admissionnumber.getText().toString().trim(),phonenumber.getText().toString().trim()
                ,password.getText().toString().trim());
               hideLoading();

            }
        });

    }


    private void startActivityUtil(Class activity) {
        Intent intent = new Intent(SignUpActivity.this, activity);
        startActivity(intent);
        finish();
    }


    @Override
    public void showSignUpResult() {


        if(BuildConfig.FLAVOR.equals("admin"))
        { startActivityUtil(AdminActivity.class); }

        else if(BuildConfig.FLAVOR.equals("member"))
        { startActivityUtil(MemberActivity.class); }

        else
        { startActivityUtil(StudentActivity.class); }
    }

    @Override
    public void erroronLoading(String error) {
        Toast.makeText(SignUpActivity.this,"OOPS Something Wrong Happen"+error,Toast.LENGTH_LONG).show();


    }
}