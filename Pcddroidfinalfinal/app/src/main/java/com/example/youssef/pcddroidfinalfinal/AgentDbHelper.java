package com.example.youssef.pcddroidfinalfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Youssef on 22/03/2016.
 */
public class AgentDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="AGENT.DB";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE_QUERY=
            "CREATE TABLE "+AgentMedical.Agentinfo.TABLE_NAME+"("+AgentMedical.Agentinfo.NOMAGENT+" TEXT,"+AgentMedical.Agentinfo.PRENOMAGENT+" TEXT,"
                    +AgentMedical.Agentinfo.ADRESSEAGENT+" TEXT,"+AgentMedical.Agentinfo.NUMEROAGENT+" TEXT,"+AgentMedical.Agentinfo.TYPEAGENT+" TEXT,"
                    +AgentMedical.Agentinfo.OFFREAGENT+" TEXT,"+AgentMedical.Agentinfo.PHOTOAGENT+" TEXT,"+AgentMedical.Agentinfo.LATAGENT+" TEXT,"
                    +AgentMedical.Agentinfo.LONAGENT+" TEXT);";

    public AgentDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABSE OPERATIONS","DATABSE CREATED OR OPENED");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABSE OPERATIONS", "Table Created");
        db.execSQL("INSERT INTO agent VALUES('CLINIQUE','LA LIBERTE','avenue de la liberte tunis belvedere',71800288,1,'clinique conventionnée avec CNAM','http://imgur.com/vymAj7U',36.803986,10.151219);");
        Log.e("DATABSE OPERATIONS", "insertion");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getinfo(SQLiteDatabase db)
    {
        Cursor cursor;
        String [] projections={AgentMedical.Agentinfo.NOMAGENT,AgentMedical.Agentinfo.PRENOMAGENT,AgentMedical.Agentinfo.ADRESSEAGENT,AgentMedical.Agentinfo.NUMEROAGENT,AgentMedical.Agentinfo.TYPEAGENT,AgentMedical.Agentinfo.OFFREAGENT,AgentMedical.Agentinfo.PHOTOAGENT,AgentMedical.Agentinfo.LATAGENT,AgentMedical.Agentinfo.LONAGENT};
        cursor=db.query(AgentMedical.Agentinfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }

}
