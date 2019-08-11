package cui.shibing.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<Object, Text,Text,IntWritable>{
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String v = value.toString();
        String[] words = v.split("\\s");
        for (String word : words) {
            context.write(new Text(word),new IntWritable(1));
        }
    }
}
