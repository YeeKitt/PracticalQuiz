package sg.edu.rp.c346.practicalquiz;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etACnum;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etACnum = findViewById(R.id.editTextACnum);
        btnSubmit = findViewById(R.id.buttonSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Get input
                final String ACnum = etACnum.getText().toString();

                //Set the dialog details
                myBuilder.setTitle("Account's Submission");
                myBuilder.setMessage("Submit: " + ACnum);
                myBuilder.setCancelable(false);

                //Configure the 'positive' button
                myBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String msg = ACnum + " submitted";
                        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                //Configure the 'negative' button
                myBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String msg = "Submit Canceled";
                        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
    }
}
