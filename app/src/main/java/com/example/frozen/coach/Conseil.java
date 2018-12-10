package com.example.frozen.coach;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.PrintStreamPrinter;
import android.widget.TextView;


import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Conseil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conseil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView helloTextView = findViewById(R.id.text_view_id);
        helloTextView.setText(res);
    }

//Faudra qu'on déclare ses variables dans la classe qui utilise la bdd:

    private static final String url = "bdd:mysql://127.0.0.1/tets"; //y a peut être un risque qu'on doive remplacer mysql par mariaDB
    private static final String user = "root";
    private static final String pass = "";


    //Et le code pour la connection, a foutre dans le code de l'activité:

    String res = "";

//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        // Toast.makeText(Conseil.this, "Please wait...", Toast.LENGTH_SHORT).show();
//
//    }


    protected String doInBackground(String... params)
    {
        try
        {
            Class.forName("com.mysql.bdd.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Database connection success");

            String result = "Database Connection Successful\n";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM probleme "); //Notre requete ce met ici
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next())
            {
                result += rs.getString(1) + "\n";
            }
            res = result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            res = e.toString();
        }
        return res;
    }


    public void onPostExecute(String result)
    {
         text = result;



        // text.setText(result);

    }

public String affiche (String... params){

    try
    {
        Class.forName("com.mysql.bdd.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        System.out.println("Database connection success");

        String result = "Database Connection Successful\n";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM probleme "); //Notre requete ce met ici
        ResultSetMetaData rsmd = rs.getMetaData();

        while (rs.next())
        {
            result += rs.getString(1) + "\n";
        }
        res = result;
    }
    catch (Exception e)
    {
        e.printStackTrace();
        res = e.toString();
    }

    return res;

}

}

