package io;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IO
{
	
	public static void writeBytes(OutputStream os,byte[] data) throws IOException
	{
		os.write(data);
		
	}
	public static boolean checkMagic(String is,int magic) throws FileNotFoundException
	{
		
		
		LittleInputStream lis= new LittleInputStream(new FileInputStream( is));
		try
		{
			int i = lis.readInt();
			if(i!=magic)
			{System.err.println("Except:"+Integer.toHexString(magic)+" got:"+Integer.toHexString(i));
			return false;
			}
			
			return true;
		}
		catch (IOException e)
		{}
		return false;
	}
}
