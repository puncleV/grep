import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
//MY GREP)))0
class main{
	public static void main(String[] args) throws IOException, FileNotFoundException{
		String path;
		if( args.length < 1){
			System.out.println("GOOD BYE MISTER!!!!1!");
		}else{
			if( args.length == 2 ){
				path = args[1];
			}else{
				path = "text.txt";
			}
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line, buf;
			Boolean isnothing = true;
			while ( ( line = reader.readLine() ) != null){
				buf = line;
				buf.toLowerCase();
				if( buf.indexOf(args[0].toLowerCase()) != -1 ){
					System.out.println(line);
					isnothing = false;
				}
			}
			if(isnothing){
				System.out.println("I can't found your string here((");
			}
		}
	}
}