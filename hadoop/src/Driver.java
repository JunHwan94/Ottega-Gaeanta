package ssafy;

import org.apache.hadoop.util.ProgramDriver;

public class Driver {
	public static void main(String[] args) {
		int exitCode = -1;
		ProgramDriver pgd = new ProgramDriver();
		try {
			pgd.addClass("wordcount", Wordcount.class,"");
			pgd.addClass("kmeans", Kmeans.class,"");
			pgd.addClass("wordcount1char", Wordcount1char.class, "");
			pgd.addClass("wordcountsort", Wordcountsort.class, "A map/reduce program that counts words and sort words");
			pgd.addClass("inverted", InvertedIndex.class, "A map/reduce program that genereates the inverted index using words in the input files.");
			pgd.addClass("matadd", MatrixAdd.class, "A map/reduce program that computes the addition of two matrices.");
			pgd.addClass("matmulti1", MatrixMultiplier1.class, "A map/reduce program that computes the addition of two matrices.");
			pgd.addClass("onlystyle", StyleCollector.class, "");
      			pgd.driver(args);
			exitCode = 0;
		}
		catch(Throwable e) {
			e.printStackTrace();
		}

		System.exit(exitCode);
	}
}
