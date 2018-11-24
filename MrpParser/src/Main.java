import io.GZipUtils;
import io.IO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import mrp.FileData;
import mrp.FileListItem;
import mrp.MrpHeader;

public class Main
{
    public static void main(String[] args)
    {
		try
		{
			String path="/home/formatfa/eclipse-workspace/MrpParser/src/黑白棋.mrp";
			
			InputStream is=new FileInputStream(path);
		MrpHeader header=new MrpHeader(is);
		header.read();
		System.out.println("in name:"+header.getInnameString());
		System.out.println("out name:"+header.getOutnameString());
		System.out.println("author:"+header.getAuthorString());
		System.out.println("info:"+header.getInfoString());
			System.out.println("appid:"+header.getAppId());
			System.out.println("versionid:"+header.getVersionId());
			
			System.out.println("app id hex:"+ header.getAppIdHex());
		FileListItem item1 = new FileListItem(is);
		
		item1.read();
		System.out.println(new String(item1.getFilename(),"gb2312"));
		System.out.println(item1.getOffset());
		System.out.println(item1.getSize());
		
		while(true)
		{
			
			FileListItem item2= new FileListItem(is);

			try{
			item2.read();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				break;
			}
			
			System.out.println("----------"+new String(item2.getFilename(),"gb2312"));
			System.out.println(item2.getOffset());
			System.out.println(item2.getSize());
			System.out.println(item2.getOffset()+item2.getSize());
			byte[] data=FileData.read(item2,path);
			String out = ""
				+item2.getFilenameString();
			IO.writeBytes(new FileOutputStream(out),data);
			if(IO.checkMagic(out,0x00088b1f))
			{
		
				System.out.println("ungzip:"+out);
				GZipUtils.decompress(new FileInputStream(out),new File(out));
				
			}
			}
		
		}
		catch (Exception e)
		{e.printStackTrace();}

     }
}
