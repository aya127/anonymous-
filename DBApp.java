import java.util.ArrayList;
import java.util.Hashtable;



public class DBApp
{
	//String strClusteringKeyColumn;
	ArrayList<Table> tables;
	
	public void createTable(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType) throws DBAppException
	{
		for(int i = 0; i < tables.size(); i++)
		{
			if(tables.get(i).getStrTableName().equals(strTableName))
			{
				throw new DBAppException("The table name " + strTableName + " already exists.");			
			}
		}
		
		Table table = new Table(strTableName, strClusteringKeyColumn, htblColNameType);
		tables.add(table);
	}
	

	public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException
	{
		for(int i = 0; i < tables.size(); i++)
		{
			if ((tables.get(i).getStrTableName().equals(strTableName)))
			{
				tables.get(i).insertIntoTable(htblColNameValue);
				break;
			}
			
			if (!(tables.get(i).getStrTableName().equals(strTableName)) && i == tables.size()-1)
			{
				throw new DBAppException("The table " + strTableName + " does not exist.");
			}
		}
	}






}
