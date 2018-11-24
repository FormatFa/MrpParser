package mrp;
import java.io.InputStream;
import io.LittleInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FileListItem
{
	InputStream is;
	LittleInputStream lis;
	
	short filenameSize;
	//byte after;
	short empty1;
	byte filename[];
	byte empty2;
	int offset;
	
	
	int size;
	//short empty4;
	int unknow;

	public FileListItem(InputStream is)
	{
		this.is = is;
		lis = new LittleInputStream(is);
	}

	public void setOffset(int offset)
	{
		this.offset = offset;
	}

	public int getOffset()
	{
		return offset;
	}

	public void setFilenameSize(short filenameSize)
	{
		this.filenameSize = filenameSize;
	}

	public short getFilenameSize()
	{
		return filenameSize;
	}

	

	public void setEmpty1(short empty1)
	{
		this.empty1 = empty1;
	}

	public short getEmpty1()
	{
		return empty1;
	}

	public void setFilename(byte[] filename)
	{
		this.filename = filename;
	}

	public byte[] getFilename()
	{
		return filename;
	}
	public String getFilenameString() throws UnsupportedEncodingException
	{
		return new String(filename,MrpHeader.code);
	}
	
	public void setEmpty2(byte empty2)
	{
		this.empty2 = empty2;
	}

	public byte getEmpty2()
	{
		return empty2;
	}

	public void setOffset(short offset)
	{
		this.offset = offset;
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
		
		
		filenameSize = lis.readShort();
		//after =  lis.readByte();
		empty1=lis.readShort();
		
		if(empty1!=0)
			throw new Exception("not zero");
		
		
		//System.out.println("read file name size:"+filenameSize);
		filename = new byte[filenameSize-1];
		
		lis.readFully(filename);
		
		empty2=lis.readByte();
		offset = lis.readInt();
	
		size=lis.readInt();
		//empty4 = lis.readShort();
		unknow=lis.readInt();
		
		
		
	}
}
