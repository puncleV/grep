import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
//MY GREP)))0
class main{
	public static void main(String[] args) throws IOException, FileNotFoundException{
		BufferedReader reader = new BufferedReader(new FileReader("text.txt"));

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
			System.out.println("Your string has not found here");
		}
	}
}