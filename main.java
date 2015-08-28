import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;

//MY GREP)))0
class Main{
	public static final String DEFAULT_PATH_TO_FILE = "text.txt";
	public static BufferedReader openFile( String pathToFile){
		try {
			BufferedReader reader = new BufferedReader( new FileReader( pathToFile ) );
			return reader;
		}catch ( FileNotFoundException err ){
			System.err.println( err.getMessage() );
			BufferedReader reader = openFile( DEFAULT_PATH_TO_FILE );
			return reader;
		}
	}
	public static String getPath( String[] args ){
		if(args.length < 2){
			return DEFAULT_PATH_TO_FILE;
		}else{
			return args[1];
		}
	}
	public static void grep ( BufferedReader reader, String toFind ) throws IOException{
		String lineFromFile, stringWithLowerCase;
		Boolean isNothing = true;
		while ( ( lineFromFile = reader.readLine() ) != null){
			stringWithLowerCase = lineFromFile;
			stringWithLowerCase.toLowerCase();
			if( stringWithLowerCase.indexOf( toFind ) != -1 ){
				System.out.println( lineFromFile );
				isNothing = false;
			}
		}
		if( isNothing )
			System.out.println("I can't found your string here((");
	}
	public static String getArgString ( String[] args ){
		return args[0];
	}
	public static void main( String[] args ) throws IOException, FileNotFoundException{
		if( args.length < 1 ){
			System.out.println( "GOOD BYE MISTER!!!!1!" );
			System.exit(0);
		}
		BufferedReader reader;
		String toFind;
		//pathToFile = getPath( args );
		reader = openFile( getPath( args ) );
		toFind = getArgString( args ).toLowerCase();
		try{
			grep ( reader, toFind );
		}catch( IOException err ){
			System.err.println( err.getMessage() );
		}
	}
}