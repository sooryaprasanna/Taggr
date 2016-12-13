package taggr;

import java.io.File;

import javax.imageio.*;
import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.LoadLibs;

public class ExtractText {
	
	String result = null;
	public ExtractText(){
		
		System.setProperty("jna.library.path", "tesseractlib");
		ImageIO.scanForPlugins();
		
		
	}
	
	public String extractText(File imageFile){
		
		try{
		
		Tesseract1 instance = new Tesseract1();
		instance.setLanguage("eng");
		File tessDataFolder = LoadLibs.extractTessResources("tessdata");
		instance.setDatapath(tessDataFolder.getParent());
		result = instance.doOCR(imageFile);
		System.out.println(result);
					
		}catch(TesseractException e)
		{
			System.out.println(e);
		}
		
		return result;

		}

}
