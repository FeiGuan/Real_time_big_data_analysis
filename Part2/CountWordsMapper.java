import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CountWordsMapper 
	extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] tokens = {"hackathon", "Dec", "Chicago", "Java"};
		String line = value.toString();
		line = line.toLowerCase();
		for (String token : tokens) {
			if (line.contains(token.toLowerCase())) {
				context.write(new Text(token), new IntWritable(1));
			} else {
				context.write(new Text(token), new IntWritable(0));
			}
		}
	}
}
