import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageRankMapper 
	extends Mapper<LongWritable, Text, Text, Text> {
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		String[] strs = line.split(" ");
		
		String source = strs[0];
		String targetPages = "";
		
		int targets = strs.length - 2;
		Double pr = Double.parseDouble(strs[strs.length-1]);
		String targetPr = String.format("%.6f", pr/targets);
		
		for (int i = 1; i < strs.length-1; i++) {
			targetPages += strs[i] + " ";
			context.write(new Text(strs[i]), new Text(targetPr));
		}
		context.write(new Text(source), new Text(targetPages));
	}
}
