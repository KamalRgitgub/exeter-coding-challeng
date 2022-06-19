import java.util.*;
import java.io.*;
import java.nio.file.*;
public class task{
	public static void main(String args[]) throws IOException,NoSuchElementException{
		long start=System.currentTimeMillis();
		File f=new File("C:/Users/sound/Downloads/TranslateWords Challenge (1)/t8.shakespeare.txt");
		File dic=new File("C:/Users/sound/Downloads/TranslateWords Challenge (1)/french_dictionary.csv");
		File trans=new File("C:/Users/sound/Downloads/Myproject/t8.shakespeare.translated.txt");
		PrintWriter p=new PrintWriter(trans);
		File freq=new File("C:/Users/sound/Downloads/Myproject/frequency.csv");
		PrintWriter fs=new PrintWriter(freq);
		fs.append("English");
		fs.append(",");
		fs.append("French");
		fs.append(",");
		fs.append("frequency\n");
		File per=new File("C:/Users/sound/Downloads/Myproject/performance.txt");
		PrintWriter pw=new PrintWriter(per);
		String str="";
		String str1="";
		String a[]=new String[2];
		Map<String,String>hs=new TreeMap<String,String>(); //To store Dictionary format key,value
		Map<String,String>rs=new HashMap<String,String>();
		Scanner s=new Scanner(dic);
		while(s.hasNextLine()){
			str=s.nextLine();
			 a=str.split(",");
				hs.put(a[0],a[1]);
		}
		Scanner file1=new Scanner(f);
		String str2="";
		while(file1.hasNextLine()){
			str1=file1.nextLine();
			str2=str1.trim();
		String org[]=str2.split(" ");
		for(String x:org){
		if(hs.containsKey(x)){
			rs.put(x,hs.get(x));
			x=hs.get(x);
		p.write(x+" ");
		} else p.write(x+" "); 
		}
		System.out.println();
		}
		Integer count=0;
		Map<String,Integer>val=new HashMap<String,Integer>();
		Scanner scan=new Scanner(trans);
		while(scan.hasNext()){
		String word=scan.next();
		 count=val.get(word);
		if(count==null){
		count=1;
		}
		else{
		count+=1;
		}
		val.put(word,count);
	}
	scan.close(); 
		// while (val.values().remove(null));
			Set<String>set=rs.keySet();
		
		for(String m:set){
			if(val.get(m)!=null){
			fs.println(m+","+rs.get(m)+","+val.get(m)+" ");
			}
		}
		 p.close();
		fs.close();
			long end=System.currentTimeMillis();
			long time=end-start;
			long minute=(time/1000)/60;
			long second=(time/1000)%60;
			long memory=trans.length()+freq.length()+per.length();
			long total=memory/(1024*1024);
			pw.write("Time to process:"+minute+" minutes "+second+" seconds \nMemory Used:"+total+" MB");
		pw.close();	
			
	}

}
