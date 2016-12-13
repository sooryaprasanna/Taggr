package taggr;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;

public class ExtractImages 
{
    public void extractImage(File videoFile, Integer videoNumber) throws IOException, JCodecException {
    	int i = 0;
    	ExtractText extractingInstance = new ExtractText();
    	String convertedDestination = "videoFile"+videoNumber;
    	FileWriter writeToDestination = new FileWriter("/Users/Soorya/Documents/Masters/SEM 3/Multimedia Systems/Project/Code/"+convertedDestination+".txt");
    	StringBuilder textFromImages = new StringBuilder();
    	String fileName = null;
    	File inputFile = null;
        long time = System.currentTimeMillis();
        try{
        	double bytes = videoFile.length();
			double kilobytes = (bytes / 1024);
			System.out.println("File Size " + kilobytes);
			double durationInSeconds = (kilobytes / 50);
			System.out.println("Video Seconds " + durationInSeconds);
        for (i = 1; i < durationInSeconds*30; i=i+30) { 
            BufferedImage frame = FrameGrab.getFrame(videoFile,i);
            fileName = "/Users/Soorya/Documents/Masters/SEM 3/Multimedia Systems/Project/Code/"+i+".png";
            inputFile = new File(fileName);
            ImageIO.write(frame, "png", inputFile);
            textFromImages.append(extractingInstance.extractText(inputFile));
            textFromImages.append("\n...BadhriSoorya#"+(i)+"*...\n");
        }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
        	System.out.println("the frame got over at "+i);
        }
        
        writeToDestination.write(textFromImages.toString());
        System.out.println("Time Used:" + (System.currentTimeMillis() - time)+" Milliseconds");
        writeToDestination.close();
    }
}