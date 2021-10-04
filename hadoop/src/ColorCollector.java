package ssafy;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class ColorCollector {
	// Map
	public static class CCMapper extends Mapper<Object, Text, Text, Text>{
		private Text keyTxt = new Text(), val = new Text();
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String valStr = value.toString();
			String bigCategory = "outer";
			String bcInfo = valStr.split(bigCategory)[1].split("bottom")[0];
			String[] splitColor1 = bcInfo.split("color\":");
			String[] splitPrint = bcInfo.split("print\":\\[");
			if(splitColor1.length > 1 && splitPrint.length > 1){
				String[] splitColor2 = splitColor1[1].split(",");
				String color = splitColor2[0];
				String print = splitPrint[1].split("\\]")[0];
				String[] prints = print.split(",");
				String[] splitCategory = bcInfo.split("category\":\"");
				if(splitCategory.length > 1){
					String category = splitCategory[1].split("\"")[0];
					keyTxt.set(category);
					val.set(color);
					context.write(keyTxt, val);
					for(String p : prints){
						val.set(p);
						context.write(keyTxt, val);
					}
				}
			}
		}
	}
	// Reduce
	public static class CCReducer extends Reducer<Text, Text, Text, Text> {
		Text val = new Text();
		public void reduce(Text key, Iterable<Text> values, Context context) 
			throws IOException, InterruptedException {
			StringBuilder sb = new StringBuilder();
			Set<String> set = new HashSet<>();
			for(Text t : values){
				set.add(t.toString());
			}
			
			sb.append("[");
			for(String color : set){
				//System.out.println(color);
				//sb.append("\"").append(color).append("\"").append(",");
				sb.append(color).append(",");
			}
			sb.setLength(sb.length() - 1);
			sb.append("]");
			
			val.set(sb.toString());
			context.write(key, val);
		}
	}
	// Main
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		if (otherArgs.length != 2) {
			System.err.println("error");
			System.exit(2);
		}

                FileSystem hdfs = FileSystem.get(conf);
                Path output = new Path(otherArgs[1]);
                if (hdfs.exists(output))
                	hdfs.delete(output, true);

		Job job = new Job(conf, "color collect");

		job.setJarByClass(ColorCollector.class);
		job.setMapperClass(CCMapper.class);
		job.setReducerClass(CCReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setNumReduceTasks(3);

		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
