package com.example.homebudget;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;



public class DatabaseofBudget extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "usersdb1";
    private static final String TABLE_Users = "userbudget";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TIMESTAMP = "timestamp";

    public DatabaseofBudget(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
                + KEY_TIMESTAMP + " Text not null " + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exist
        db.execSQL(" DROP TABLE IF EXISTS  " + TABLE_Users);
        // Create tables again
        onCreate(db);
    }
    public void  insertUserDetails(String name,String timestamp)
    {
         SQLiteDatabase db=this.getWritableDatabase();
         ContentValues cValues=new ContentValues();
         cValues.put(KEY_NAME,name);
         cValues.put(KEY_TIMESTAMP,timestamp);
        long newRowid= db.insert(TABLE_Users,null,cValues);

         db.close();
    }
    public ArrayList<HashMap<String,String>> GetUsers(){

        SQLiteDatabase db= this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userLIst=new ArrayList<>();
        String Query= "SELECT id,name,timestamp from "+ TABLE_Users;
        Cursor cursor=db.rawQuery(Query,null);
        while(cursor.moveToNext()){
            HashMap<String ,String > user =new HashMap<>();
            user.put("id",cursor.getString(cursor.getColumnIndex(KEY_ID)));
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("timestamp", cursor.getString(cursor.getColumnIndex(KEY_TIMESTAMP)));
            userLIst.add(user);

        }
        return userLIst;

    }
    // Get User Details based on userid
    public ArrayList<HashMap<String, String>> GetUserByUserId(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT id, name,timestamp FROM "+ TABLE_Users;
        Cursor cursor = db.query(TABLE_Users, new String[]{KEY_NAME, KEY_TIMESTAMP}, KEY_ID+ "=?",new String[]{String.valueOf(userid)},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("id",cursor.getString(cursor.getColumnIndex(KEY_ID)));
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));

            user.put("timestamp",cursor.getString(cursor.getColumnIndex(KEY_TIMESTAMP)));
            userList.add(user);
        }
        return  userList;
    }
    public void DeleteUser(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Users, KEY_ID+" = ?",new String[]{String.valueOf(userid)});
        db.close();
    }
    // Update User Details
    public int UpdateUserDetails(String name, String timestamp, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(KEY_NAME,name);

        cVals.put(KEY_TIMESTAMP, timestamp);


        int count = db.update(TABLE_Users, cVals, KEY_ID+" = ?",new String[]{String.valueOf(id)});
        return  count;
    }



}
