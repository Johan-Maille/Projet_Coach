package com.example.frozen.coach;

import android.os.AsyncTask;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class testco extends AsyncTask<String, Void, String> {

    //Faudra qu'on déclare ses variables dans la classe qui utilise la bdd:

private static final String url = "bdd:mysql://127.0.0.1/tets"; //y a peut être un risque qu'on doive remplacer mysql par mariaDB
private static final String user = "root";
private static final String pass = "";


   // Faudra qu'on fasse tous ses import:




    //Et le code pour la connection, a foutre dans le code de l'activité:

    String res = "";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
       // Toast.makeText(Conseil.this, "Please wait...", Toast.LENGTH_SHORT).show();

    }

    @Override
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

    @Override
    public void onPostExecute(String result)
    {
        String text = result;

        System.out.println (text);

       // text.setText(result);

    }






}
