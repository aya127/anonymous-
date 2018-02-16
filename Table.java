import java.sql.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;


public class Table
{
	private String strTableName;	
	private String strClusteringKeyColumn;
	private Hashtable<String,String> htblColNameType; 
	private ArrayList<Object> table;
	private ArrayList<String> colNames;
	
	public Table(String strTableName, String strClusteringKeyColumn,
			Hashtable<String,String> htblColNameType) throws DBAppException
	{
		this.strTableName = strTableName;
		this.strClusteringKeyColumn = strClusteringKeyColumn;
		this.htblColNameType = htblColNameType;
		Set <String> keys = htblColNameType.keySet();
		this.table = new ArrayList();
		this.colNames = new ArrayList();
		colNames.add("Touchdate");
		table.add(new ArrayList<Date>());
		for(String key : keys)
		{
			colNames.add(key);
			switch(htblColNameType.get(key))
			{
				case "java.lang.Integer" : table.add(new ArrayList<Integer>()); break;
				case "java.lang.String" : table.add(new ArrayList<String>()); break;
				case "java.lang.double" : table.add(new ArrayList<Double>()); break;
				case "java.lang.boolean" : table.add(new ArrayList<Boolean>()); break;
				case "java.lang.Character" : table.add(new ArrayList<Character>()); break;
				case "java.lang.Date" : table.add(new ArrayList<Date>()); break;
				default:
			}
		}
	}
	
	
	public void	insertIntoTable(Hashtable<String,Object> htblColNameValue) throws DBAppException
	{
		if (htblColNameValue.size() == colNames.size()-1)
		{
			
			int i = 0;
			
			for (String key : htblColNameValue.keySet())
			{
				if (!(key.equals(colNames.get(i))))
				{
					throw new DBAppException("Incorrect column name/order: " + key);
				}
				
				i += 1;
			}
			
			i = 0;
			
			
			
			for (String key : htblColNameValue.keySet())
			{
				//insuring correct types missing
				/*if(!((htblColNameValue.get(key).getClass()) instanceof ((table.get(i)).getClass()))){
					throw new DBAppException("Incorrect type "+ key);
				}
				i+=1;*/
			}
			
		}
		
		else
		{
			throw new DBAppException("Incorrect number of columns.");
		}
	}
	
	
	public String getStrTableName()
	{
		return strTableName;
	}
	
	
}
