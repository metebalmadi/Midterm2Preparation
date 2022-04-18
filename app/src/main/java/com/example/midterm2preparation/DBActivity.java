package com.example.midterm2preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DBActivity extends AppCompatActivity {


    DatabaseHelper myDB;
    EditText productQuantity, productName, productReview;
    TextView productID, ViewDB;

    String prodName;
    String prodQuan;
    String prodReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);



        Button bttnAdd = (Button) findViewById(R.id.bttnAdd);
        Button bttnFind = (Button) findViewById(R.id.bttnFind);
        Button bttnView = (Button) findViewById(R.id.bttnView);
        Button bttnDelete = (Button) findViewById(R.id.bttnDelete);


        myDB = new DatabaseHelper(this);

        productID = (TextView) findViewById(R.id.productID);
        productQuantity = (EditText) findViewById(R.id.productQuantity);
        productName = (EditText) findViewById(R.id.productName);
        productReview = (EditText) findViewById(R.id.productReview);

        ViewDB = (TextView) findViewById(R.id.txtViewDB);

        bttnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prodName = productName.getText().toString();
                prodQuan = productQuantity.getText().toString();
                prodReview = productReview.getText().toString();


                if (prodName.equals("") || prodQuan.equals("") || prodReview.equals(""))
                {
                    Toast.makeText(DBActivity.this,
                            "Fields are empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!myDB.addData(prodName, prodQuan, prodReview))
                    Toast.makeText(DBActivity.this,
                            "Insertion Failed", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DBActivity.this,
                            "Insertion Success", Toast.LENGTH_SHORT).show();


            }
        });

        bttnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prodName = productName.getText().toString();

                if (prodName.equals(""))
                {
                    Toast.makeText(DBActivity.this,
                            "Product Name field is empty",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Cursor cursor = myDB.structuredQuery(prodName);
                String cID = cursor.getString(0);
                String cName = cursor.getString(1);
                String cPrQuant = cursor.getString(2);
                String cReview = cursor.getString(3);

                productID.setText(cID);
                productQuantity.setText(cPrQuant);
                productReview.setText(cReview);



            }
        });

        bttnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cur = myDB.getListContents();
                StringBuffer buffer = new StringBuffer();

                while(cur.moveToNext()){
                    buffer.append("ID: "+cur.getString(0)+"\n");
                    buffer.append("Product Name: "+cur.getString(1)+"\n");
                    buffer.append("Quantity: "+cur.getString(2)+"\n");
                    buffer.append("Review: "+cur.getString(3)+"\n\n");
                }
                ViewDB.setText(buffer.toString());
//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            builder.setCancelable(true);
//            builder.setTitle("All Emplpyees");
//            builder.setMessage(buffer.toString());
//            builder.show();


            }
        });

        bttnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String prodID = productID.getText().toString();

                if (prodID.equals(""))
                {
                    Toast.makeText(DBActivity.this,
                            "Find the product first",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (myDB.deleteData(prodID))
                {
                    Toast.makeText(DBActivity.this,
                            "Product Deleted", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(DBActivity.this,
                            "Could not Delete", Toast.LENGTH_SHORT).show();
                }
                productID.setText("");
                productName.setText("");
                productQuantity.setText("");
                productReview.setText("");

            }
        });

    }
}