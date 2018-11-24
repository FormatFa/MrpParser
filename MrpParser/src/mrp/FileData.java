package mrp;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileData
{
	public static  byte[] read(FileListItem item,String path) throws Exception
	{
		InputStream is=new FileInputStream(path);
		is.skip(item.getOffset());
		byte[] data =  new byte[item.getSize()];
		is.read(data);
		is.close();
		return data;
		
	}
	
	
}
