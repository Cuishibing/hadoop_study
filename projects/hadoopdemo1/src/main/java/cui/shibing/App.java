package cui.shibing;

import cui.shibing.mapper.WordCountMapper;
import cui.shibing.reduce.WordCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public final class App {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job wordCount = Job.getInstance(conf, "word cont");
        wordCount.setJarByClass(App.class);
        wordCount.setMapperClass(WordCountMapper.class);
        wordCount.setCombinerClass(WordCountReducer.class);
        wordCount.setReducerClass(WordCountReducer.class);
        wordCount.setOutputKeyClass(Text.class);
        wordCount.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(wordCount, new Path(args[0]));
        FileOutputFormat.setOutputPath(wordCount, new Path(args[1]));
        System.exit(wordCount.waitForCompletion(true) ? 0 : 1);
    }
}
