package profile1B;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

	/**
	 * @author Nikhil Patil <patilnikhils19@gmail.com>
	 * Apr 6, 2017
	 * MainClass.java
	 */
	public class MainClass {
			public static void main(String[] args) throws IOException, ClassNotFoundException,InterruptedException {
					if (args.length != 2) {
							System.out.printf("Usage: <jar file> <input dir> <output dir>\n");
							System.exit(-1);
							}

					Configuration conf =new Configuration();
					Job job=Job.getInstance(conf);
					job.setJarByClass(MainClass.class);
					job.setMapperClass(WordMapper.class);
					job.setReducerClass(WordReducer.class);
					job.setOutputKeyClass(Text.class);
					job.setOutputValueClass(Text.class);
					job.setInputFormatClass(TextInputFormat.class);
					job.setOutputFormatClass(TextOutputFormat.class);
					FileInputFormat.setInputPaths(job, new Path(args[0]));
					FileOutputFormat.setOutputPath(job, new Path(args[1]));
					System.exit(job.waitForCompletion(true) ? 0 : 1);
			}
}