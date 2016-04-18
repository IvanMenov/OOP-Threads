package threads;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo {
	private static final int NUMBER_OF_THREADS = 5;

	public static void main(String[] args) throws FileNotFoundException, InterruptedException, ExecutionException {
		Scanner scan = new Scanner(new File("war_peace.txt"));
		StringBuilder wholeText = new StringBuilder();
		while(scan.hasNextLine()){
			String line= scan.nextLine();
			wholeText.append(line);
			wholeText.append("\n");	
		}
		long wholeTextSize=wholeText.length();
		scan.close();
		//System.out.println(wholeText.toString());
		StringBuilder firstPart= new StringBuilder();
		StringBuilder secondPart= new StringBuilder();
		StringBuilder thirdPart= new StringBuilder();
		StringBuilder fourthPart= new StringBuilder();
		StringBuilder fifthPart= new StringBuilder();
		
		
		int partsOfTheWholeText= wholeText.length()/5;
		firstPart.append(wholeText, 0, partsOfTheWholeText);
		secondPart.append(wholeText,partsOfTheWholeText, partsOfTheWholeText*2);
		thirdPart.append(wholeText,partsOfTheWholeText*2,partsOfTheWholeText*3 );
		fourthPart.append(wholeText,partsOfTheWholeText*3, partsOfTheWholeText*4);
		fifthPart.append(wholeText,partsOfTheWholeText*4, wholeText.length());
		//System.out.println(firstPart.toString());
		
		ExtractText textInParts= new ExtractText(firstPart, secondPart, thirdPart, fourthPart, fifthPart,wholeText);
		Thread nishkaZaCeliqText= new Thread(new WholePart(textInParts));
		nishkaZaCeliqText.start();
		nishkaZaCeliqText.join();
		
		WholePart chastPurva= new FirstPart(textInParts);
		WholePart vtoraChast= new SecondPart(textInParts);
		WholePart tretaChast= new ThirdPart(textInParts);
		WholePart chetvurtaChast= new FourthPart(textInParts);
		WholePart petaChast= new FifthPart(textInParts);
		
		Thread nishkaZaPurvataChast= (new Thread(chastPurva));
		Thread nishkaZaVtorataChast= new Thread(vtoraChast);
		Thread nishkaZaThretaChast= new Thread(tretaChast);
		Thread nishkaZaChetvurtaChast= new Thread(chetvurtaChast);
		Thread nishkaZaPetaChast= new Thread(petaChast);
		
		LocalDateTime start = LocalDateTime.now();
		nishkaZaPurvataChast.start();
		nishkaZaPurvataChast.join();
		
		nishkaZaVtorataChast.start();
		nishkaZaVtorataChast.join();
		
		nishkaZaThretaChast.start();
		nishkaZaThretaChast.join();
		nishkaZaChetvurtaChast.start();
		nishkaZaChetvurtaChast.join();
		nishkaZaPetaChast.start();
		nishkaZaPetaChast.join();
		
		LocalDateTime end = LocalDateTime.now();
		long difference = Duration.between(start, end).toMillis();
		Integer total= chastPurva.getNumberOfCommas()+vtoraChast.getNumberOfCommas()+tretaChast.getNumberOfCommas()+
					chetvurtaChast.getNumberOfCommas()+ petaChast.getNumberOfCommas();
			
		System.out.println("Total commas using 5 threads: "+total);
		System.out.println("Time it took in milliseconds for 5 threads: "+difference);
		
		
		//Тук съм създал нови пет класа, които да имплементират Callable интерфейс,
		//защото не знам как от обектите, които са Runnable(FirstPart,SecondPart...) да взема резултата 
		//от броенето на запетайки с Future обект.
		
		LocalDateTime startPool= LocalDateTime.now();
		ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		ArrayList<Future<Integer>> list = new ArrayList<Future<Integer>>();
		Integer commas=new Integer(0);
		list.add(pool.submit(new FirstTaskPool(firstPart)));
		list.add(pool.submit(new SecondTaskPool(secondPart)));
		list.add(pool.submit(new ThirdPartPool(thirdPart)));
		list.add(pool.submit(new FourthPartPool(fourthPart)));
		list.add(pool.submit(new FifthPartPool(fifthPart)));
		
		for (int i = 0; i < list.size(); i++) {
			commas+=list.get(i).get();
		}
		
		pool.shutdown();
		LocalDateTime endPool= LocalDateTime.now();
		long timeDiff= Duration.between(startPool, endPool).toMillis();
		System.out.println("Commas with pool of threads: "+commas);
		System.out.println("Time for the pool to complete the task: "+timeDiff);
	}	
}
