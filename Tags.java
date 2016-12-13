package taggr;

import java.util.*;
import java.io.*;


public class Tags
{
	public static void generateTagFile() throws IOException
	{
	FileReader fr = new FileReader("stopWords.txt");
	BufferedReader br = new BufferedReader(fr);
	FileWriter fw = new FileWriter("toBeTagged.txt");
	BufferedWriter bw = new BufferedWriter(fw);
	
	String line = br.readLine();
	HashSet<String> stopWordsSet = new HashSet<>();
	HashMap<String, Integer> tagsMap = new HashMap<>();
	
	
	while(line!=null)
	{
		line.toLowerCase().replaceAll("[^a-z]", "");
		String[] words = line.split(";");
		
		for(String word: words)
		{
		stopWordsSet.add(word);
		
		}
		line = br.readLine();
		
	}
	
	fr = new FileReader("/Users/Soorya/Documents/Masters/SEM 3/Multimedia Systems/Project/Code/videoFile1.txt");
	br = new BufferedReader(fr);
	
	String inputLine = br.readLine();
	int frameNumber = 1;
	
	while(inputLine!=null)
	{
		if(inputLine.contains("BadhriSoorya"))
		{
			frameNumber = Integer.parseInt(inputLine.substring(inputLine.indexOf('#')+1, inputLine.indexOf('*')));
		}
		inputLine.toLowerCase().replaceAll("[^a-z ]", "");
		String[] words = inputLine.split(" ");
		for(String word: words)
		{
			if(!stopWordsSet.contains(word))
			{
				if(!tagsMap.containsKey(word))
				{
					
					tagsMap.put(word, frameNumber);
				}
				else
				{
					tagsMap.put(word, frameNumber);
				}
			}
		}
		inputLine = br.readLine();
	}
	for(Map.Entry<String, Integer> mapEntry: tagsMap.entrySet())
	{
		System.out.println(mapEntry.getKey()+" "+mapEntry.getValue());
		
		bw.write(mapEntry.getKey()+" "+mapEntry.getValue());
		bw.newLine();
	}
	
	br.close();bw.close();
	
	}
}
