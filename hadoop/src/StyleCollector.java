package ssafy;

import java.io.IOException;
import java.util.StringTokenizer;

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

public class StyleCollector {
	// Map
	public static class SCMapper extends Mapper<Object, Text, Text, Text>{
		private Text keyTxt = new Text(), val = new Text();
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String valStr = value.toString();
			String[] split = valStr.split("label\":");
			if(split.length > 1){
				String split1 = split[1];
				String[] split2 = split1.split("},"); 
				
				String style = split2[0];
				String fileInfo = split2[1].split("}")[0];
				StringBuilder sb = new StringBuilder();
				style = style.substring(0, style.length() - 1);
				sb.append(style).append(",").append(fileInfo);
				// 스타일 split
				String styleCategory = style.split("style")[2];
				styleCategory = styleCategory.split("\"")[2];
				//styleCategory = styleCategory.substring(3, styleCategory.length());
				
				keyTxt.set(styleCategory);
				Text val = new Text();
				val.set(sb.toString() + "}");
				context.write(keyTxt, val);
			}
		}
	}
	// Reduce
	public static class SCReducer extends Reducer<Text, Text, Text, Text> {

		public void reduce(Text key, Iterable<Text> values, Context context) 
			throws IOException, InterruptedException {
			for(Text t : values){
				context.write(key, t);
			}
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

		Job job = new Job(conf, "style collect");

		job.setJarByClass(StyleCollector.class);
		job.setMapperClass(SCMapper.class);
		job.setReducerClass(SCReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setNumReduceTasks(10);

		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
