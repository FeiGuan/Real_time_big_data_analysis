import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;



public class PageRankReducer
	extends Reducer<Text, Text, Text, Text> {
	
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		Double newPr = 0.0f;
		String keyStr = key.toString();
		for (Text value : values) {
			String[] strs = value.toString().split(" ");
			if (strs[strs.length-1].matches("[A-Z]")) {
				keyStr += " " + value.toString();
			} else {
				newPr += Double.parseDouble(strs[strs.length-1]);
			}
		}
		context.write(new Text(keyStr), new Text(String.format("%.6f", newPr)));
	}
	
}
