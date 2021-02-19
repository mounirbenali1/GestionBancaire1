package com.example.gestionbancaire1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gestionbancaire1.model.Operation;
import com.example.gestionbancaire1.model.OperationAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {
    private TextView Sld;
    private EditText Montant;
    private EditText Date ;
    private TextView errorMessage;
    private Button add;
    private ListView listView;
    ArrayList<Operation> arrayList;
    OperationAdapter arrayadapter;
    Integer NumOperation=1;

    public Boolean checkDateFormat(String date){
        if (date == null || !date.matches("^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}$"))
            return false;
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        try {
            format.parse(date);
            return true;
        }catch (ParseException e){

            return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Montant=(EditText)findViewById(R.id.Montant);
        Date=(EditText)findViewById(R.id.Date);
        Sld =(TextView)findViewById(R.id.sld);
        add=(Button)findViewById(R.id.add);
        errorMessage=(TextView)findViewById(R.id.error_msg);
        listView=(ListView)findViewById(R.id.listview);

        arrayList = new ArrayList<Operation>();
        arrayadapter = new OperationAdapter(this, R.layout.list_view_adapter,arrayList); // ici on a affecter l'adapdateur à un autre layout .
        listView.setAdapter(arrayadapter);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double Mnt=Double.parseDouble(Montant.getText().toString());
                String date=Date.getText().toString();
                Double solde=Double.parseDouble(Sld.getText().toString());
                Boolean  formatdate=checkDateFormat(date);

                Double Mnt_fnl= Mnt+solde;
                System.out.println(!date.isEmpty());
                System.out.println(Mnt.isNaN());

                if(!date.isEmpty() && Mnt.isNaN()==FALSE)
                {
                    if (Mnt_fnl<0) {
                        errorMessage.setText("Solde Insufi");
                    }
                    else if(formatdate==TRUE){
                    errorMessage.setText("");
                    Sld.setText(Mnt_fnl.toString());//Modifier le solde
                    Montant.setText("");//liberer montant saisie
                    Date.setText("");//liberer date saisie
                    Operation op= new Operation(NumOperation, Mnt.toString(), date); //creer un objet de class Operation
                    NumOperation++; // Incrementer le nombre des transactions
                    arrayList.add(op); //ajouter notre operation dans arraylist
                    arrayadapter.notifyDataSetChanged(); // Modifier listView

                    }else {
                        errorMessage.setText("");
                        errorMessage.setText(" Date format incompatible ");
                    }
                }
                else {
                    errorMessage.setText("");
                    errorMessage.setText("Données manquante ");

                }






            }
        });
    }
}