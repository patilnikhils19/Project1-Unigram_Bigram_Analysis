package profile1A;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

	/**
	 * @author Nikhil Patil <patilnikhils19@gmail.com>
	 * Apr 6, 2017
	 * WordMapper.java
	 */
	public class WordMapper extends Mapper<LongWritable, Text, Text, Text>{
			
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
			
			String CurrentLine;
			String StrLower;
			CurrentLine = value.toString();
			StrLower = CurrentLine.toLowerCase();
			String[] str = StrLower.split("<===>");
			if(str.length > 2){
				String Author = str[0];
				String Date = str[1];
				String Sentance = str[2];
				Sentance = Sentance.replaceAll("[^a-zA-Z0-9 ]", "").trim();
				//Sentance = Sentance.replaceAll("--", " ");
				Sentance = Sentance.replaceAll("( )+", " ").trim();
				Sentance = Sentance.replaceAll("/t", " ").trim();
				String[] AuthorLast = Author.split(" ");
				String AuthorLastName =AuthorLast[AuthorLast.length-1];
				String[] YearL = Date.split(" ");
				if (YearL.length>1){
					String Year = YearL[YearL.length-1].replaceAll(" ","");
					String[] Words = Sentance.split(" ");
					int i = 0;
					if(Words.length != 0){
						while(i < Words.length){
							if(Words[i].length()>=1){
								Text OutKey = new Text (Words[i]+"\t"+Year);
								Text OutValue = new Text ("One");
								//System.out.println(OutKey);
								context.write(OutKey, OutValue);
								}
							i++;
							}
						}
					}
				}
			}
	}