package com.example.xaviernara.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
   //this app entails the basics of using SQLite3 in Android Studio 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //SQLiteDatabase has methods to create, delete, execute SQL commands, and perform other common database management tasks.
           //THIS line creates the database Users
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

            //this line say create a new table if a table doesn't exists create a new table called users
            //and we want to make the properties(columns) of the users table (ie name and age)
            //VARCHAR = string ,INT(# of digits you wanna go up to)
            //myDatabase.execSQL("this where you write sql code and its in all caps unless your naming something");
            //execSQL allows you to connect with the database

            //if this code is ran more than once then it will no longer create a table but
            //it will add another name and age to the table
            //myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name  VARCHAR, age INT(3))");


            //this line says create a new table if a table doesn't exists create a new table called users in the Users db
            //and we want to make the properties(columns) of the users table (ie name and age)
            //this also adds a primary key id to each entry of the table (YOU DON'T NEED TO UPDATE THIS FOR THIS TO UPDATE)
            //if you want a specific primary key you'll have to update with similar code as below
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name  VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");

            //this line says that insert into the users table for the name and age
            //the values ('Xavier',23)
            //'' ==" " (ie in SQL signle quotes is from string declaration)
            myDatabase.execSQL("INSERT INTO users(name,age) VALUES('Xavier',23)");
            myDatabase.execSQL("INSERT INTO users(name,age) VALUES('Ashley',23)");

            //myDatabase.execSQL("INSERT INTO users(name,age) VALUES('Bobby',13)");
            //myDatabase.execSQL("INSERT INTO users(name,age) VALUES('Jake',17)");

            /*
            Cursor c = myDatabase.rawQuery("SELECT * FROM users",null); pulls all the info form a SQL table
            a cursor basically points to the different info in the table
            Cursor c = myDatabase.rawQuery("SELECT * FROM users",null);
            Cursor c = myDatabase.rawQuery("SELECT * FROM users",null); pulls all the info form a SQL table
            a cursor basically points to the different info in the table
            */

            //pulls info form a SQL table that pertains to the users who are older than 18
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age > 18",null);

            //this pulls info form a SQL table that pertains to the users who have the age 23
            //and named Xavier
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age = 23 AND  name = 'Xavier' ",null);


            //this pulls info form a SQL table that pertains to the users who have the letter X in their name
            //'X%' means find a name that has X in the front of their name
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'X%' ",null);

            //this deletes names from the table that are bobby
            //Cursor c = myDatabase.rawQuery("DELETE FROM users WHERE name = 'Bobby' ",null);

            //or
            //Cursor c = myDatabase.execSQL("DELETE FROM users WHERE id = 2 ",null);
            Cursor c;



            //this pulls info form a SQL table that pertains to the users who have the letter X in their name
            //'%a%' means find a name that has the letter a in it with another letter in front and back of it
            //and limits the name to 1 person
            c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%a%' LIMIT 1 ",null);



            //these are for the column index of the sqlite table
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            //this moves the cursor to the beginning of the table (ie the 1st row)
            c.moveToFirst();


            //this will cycle thru the table row by row (index by index) until the table is null
            //and log the contents of each column unto the logcat
            while(c!= null){
                Log.i("name",c.getString(nameIndex));
                Log.i("age",c.getString(ageIndex));
                Log.i("id",c.getString(idIndex));

                //c.moveToNext(); == cursor++;
                //c.moveToNext() moves row by row
                c.moveToNext();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
