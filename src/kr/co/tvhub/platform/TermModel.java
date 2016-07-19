package kr.co.tvhub.platform;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author jhkim
 * @since 2011. 2. 11.
 *
 * [클래스 정의]
 * 01. KT 단말기 정보
 *
 * [기능 정의]
 * 01. 셋탑정보 구성
 *
 */
public abstract class TermModel
{
	protected String	platformId;
	protected String	said;
	protected String	modelNo;
	protected String	firmware;
	protected String	mac;
	protected String	addr;
	// -------------------------------------------------------------------------
	
	private boolean ex = true;
	
	private File file=null;
	
	public TermModel()
	{
		if (ex == false)
		{
			loadProperty();
		}
		else
		{
			Properties info = new Properties();
			FileInputStream in = null;
			file = new File(("property/terminal.properties"));
			
			try
			{
				in = new FileInputStream("property/terminal.properties");
				info.load(in);
				in.close();

				this.said		= info.getProperty("said", "0");
				this.modelNo	= info.getProperty("model", "0");
				this.firmware	= info.getProperty("firmware", "0");
				this.mac		= info.getProperty("mac", "");
				this.addr		= info.getProperty("addr", "");
				
				info.clear();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				info = null;
				in = null;
			}
		}
	}
	public void dispose()
	{
		platformId	= null;
		said		= null;
		modelNo		= null;
		firmware	= null;
		mac			= null;
		addr		= null;
	}
	
	
	public void PrintPath(){
		System.out.println("abpath():"+file.getAbsolutePath());
	}
	//--------------------------------------------------------------------------
	
	public	String	getPlatformId()	{ return platformId; }
	public	void	setPlatformId(String platformId)
	{
		this.platformId = platformId;
	}
	public	String	getTermId()		{ return said; }
	public	String	getModelNo()	{ return modelNo; }
	public	String	getFirmware()	{ return firmware; }
	public	String	getMac()		{ return mac; }
	public	String	getIP()			{ return addr; }
	//--------------------------------------------------------------------------
	
	protected abstract void loadProperty();
	//--------------------------------------------------------------------------
}
