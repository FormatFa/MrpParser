package mrp;
import java.io.InputStream;
import javax.xml.namespace.QName;
import io.LittleInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MrpHeader
{
	
	InputStream is;
	
	LittleInputStream lis;
	public static String code="gb2312";
	
	int magic;
	int dataStart;
	int fileSize;
	int listStart;
	byte inname[]=new byte[12];//16-28
	byte outname[]=new byte[24];//28-52
	byte number[]=new byte[16];//52-68
	int versionId;//68-72
	int appId;//72-76
	byte[] unknow=new byte[12];//76-88
	byte[] author =new byte[40];//88-128

	byte[] info = new byte[64];//128-192
	int versionIdHex;//192-196
	int appIdHex;//196-200
	byte[] unknow2=new byte[40];

	public MrpHeader(InputStream is)
	{
		this.is = is;
		lis=new LittleInputStream(is);
	}

	public void setVersionId(int versionId)
	{
		this.versionId = versionId;
	}

	public int getVersionId()
	{
		return versionId;
	}

	public void setAppId(int appId)
	{
		this.appId = appId;
	}

	public int getAppId()
	{
		return appId;
	}

	public void setMagic(int magic)
	{
		this.magic = magic;
	}

	public int getMagic()
	{
		return magic;
	}

	public void setDataStart(int dataStart)
	{
		this.dataStart = dataStart;
	}

	public int getDataStart()
	{
		return dataStart;
	}

	public void setFileSize(int fileSize)
	{
		this.fileSize = fileSize;
	}

	public int getFileSize()
	{
		return fileSize;
	}

	public void setListStart(int listStart)
	{
		this.listStart = listStart;
	}

	public int getListStart()
	{
		return listStart;
	}

	public void setInname(byte[] inname)
	{
		this.inname = inname;
	}

	public byte[] getInname()
	{
		return inname;
	}
	public String getInnameString() throws UnsupportedEncodingException
	{
		return  new String( inname,code);
	}
	
	public void setOutname(byte[] outname)
	{
		this.outname = outname;
	}

	public byte[] getOutname()
	{
		return outname;
	}
	public String getOutnameString() throws UnsupportedEncodingException
	{
		return new String( outname,code);
	}
	
	public void setNumber(byte[] number)
	{
		this.number = number;
	}

	public byte[] getNumber()
	{
		return number;
	}

	
	
	public void setUnknow(byte[] unknow)
	{
		this.unknow = unknow;
	}

	public byte[] getUnknow()
	{
		return unknow;
	}

	public void setAuthor(byte[] author)
	{
		this.author = author;
	}

	public byte[] getAuthor()
	{
		return author;
	}
	public String getAuthorString() throws UnsupportedEncodingException
	{
		return new String(author,code);
	}
	
	public void setInfo(byte[] info)
	{
		this.info = info;
	}

	public byte[] getInfo()
	{
		return info;
	}
	public String getInfoString() throws UnsupportedEncodingException
	{
		return new String(info,code);
	}
	
	public void setVersionIdHex(int versionIdHex)
	{
		this.versionIdHex = versionIdHex;
	}

	public int getVersionIdHex()
	{
		return versionIdHex;
	}

	public void setAppIdHex(int appIdHex)
	{
		this.appIdHex = appIdHex;
	}

	public int getAppIdHex()
	{
		return appIdHex;
	}

	public void setUnknow2(byte[] unknow2)
	{
		this.unknow2 = unknow2;
	}

	public byte[] getUnknow2()
	{
		return unknow2;
	}//200-240
	
	public void read() throws IOException
	{
		
		
		magic=lis.readInt();
		dataStart=lis.readInt();
		fileSize= lis.readInt();
		listStart=lis.readInt();
		
		lis.readFully(inname);
		lis.readFully(outname);
		lis.readFully(number);
		versionId=lis.readInt();
		appId=lis.readInt();
		lis.readFully(unknow);
		lis.readFully(author);
		lis.readFully(info);
	    versionIdHex=	lis.readInt();
	    appIdHex=lis.readInt();
	    lis.readFully(unknow2);
		
			
	
	}
}
