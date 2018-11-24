package io;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

public class GZipUtils
{
	
	public static void decompress(InputStream is,File out)
	{
		File temp = new File(out+"temp");
		try
		{
			GZIPInputStream gi = new GZIPInputStream(is);
			OutputStream os = new FileOutputStream(temp);
			
			///这么小,直接全部读取算了
		
			byte[] buff=new byte[1024*4];
			int len;
			while( (len=gi.read(buff,0,buff.length))!=-1)
			{
				os.write(buff,0,len);
			}

			if(out.exists())out.delete();
			temp.renameTo(out);
			
		}
		catch (Exception e)
		{e.printStackTrace();}

		
	}
	
	

}
