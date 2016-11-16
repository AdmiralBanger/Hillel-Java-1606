package logic;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

public class Mongo 
{
	
	public static void query(String Query)
	{
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

		@SuppressWarnings("unused")
		MongoDatabase db = mongoClient.getDatabase( "mydb" );
		
		mongoClient.close();
	}
}
