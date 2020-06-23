package unis.edu.alunosapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;

import unis.edu.alunosapp.helpers.AsyncResponse;
import unis.edu.alunosapp.model.Usuario;
import unis.edu.alunosapp.model.UsuarioViewModel;

public class SignUpActivity extends AppCompatActivity implements AsyncResponse {

    private UsuarioViewModel usuarioViewModel;

    private TextInputLayout textInputLayoutUsuario;
    private TextInputLayout textInputLayoutSenha;
    private TextInputLayout textInputLayoutConfirmarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);
        initViews();
    }

    private void initViews() {
        textInputLayoutUsuario = findViewById(R.id.textInputUsuario);
        textInputLayoutSenha = findViewById(R.id.textInputSenha);
        textInputLayoutConfirmarSenha = findViewById(R.id.textIputConfirmarSenha);
    }

    @Override
    public void processFinish(Object output) {
        Usuario usuario = (Usuario)output;
    }
}