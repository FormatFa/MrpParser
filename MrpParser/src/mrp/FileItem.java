package mrp;
import java.io.InputStream;
import io.LittleInputStream;
import java.io.IOException;

public class FileItem
{
	InputStream is;
	LittleInputStream lis;

	int filenameSize;
	byte filename[];
	byte empty2;
	int size;
	byte[] data;

	public FileItem(InputStream is)
	{
		this.is = is;
		lis = new LittleInputStream(is);
	}

	

	public void setFilenameSize(short filenameSize)
	{
		this.filenameSize = filenameSize;
	}

	public int getFilenameSize()
	{
		return filenameSize;
	}



	
	public void setFilename(byte[] filename)
	{
		this.filename = filename;
	}

	public byte[] getFilename()
	{
		return filename;
	}

	public void setEmpty2(byte empty2)
	{
		this.empty2 = empty2;
	}

	public byte getEmpty2()
	{
		return empty2;
	}

	


	public void setSize(short size)
	{
		this.size = size;
	}

	public int getSize()
	{
		return size;
	}





	public void read() throws IOException, Exception
	{


		filenameSize = lis.readInt();
		//after =  lis.readByte();
		

		

		//System.out.println("read file name size:"+filenameSize);
		filename = new byte[filenameSize-1];

		System.out.println("read file"+new String( filename,MrpHeader.code));
		lis.readFully(filename);

		
		empty2=lis.readByte();
		size=lis.readInt();
		
		
		data = new byte[size];
		lis.readFully(data);



	}
}
