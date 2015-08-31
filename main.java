import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;

//MY GREP)))0
    /**
	* Аналог grep, с чтением только из файла
	* @author : Viktor Kozlov
	*
	* */
class Main {
    public static final String DEFAULT_PATH_TO_FILE = "text.txt";

    /**
    * Октрытие буфферизированного чтения из файла
    * @param pathToFile Путь к файлу
    * @throws FileNotFoundException if path to file is wrong
    * @return BufferReader with opened file
    * */
    public static BufferedReader openFile(String pathToFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
            return reader;
        } catch (FileNotFoundException err) {
            System.err.println(err.getMessage());
            BufferedReader reader = openFile(DEFAULT_PATH_TO_FILE);
            return reader;
        }
    }

    /**
    * Получение пользовательского пути к файлу из аргументов программы
    * @param args - массив аргументов
    * @return String file path or "text.txt" if second argument does not exist
    * */
    public static String getPath(String[] args) {
        if (args.length < 2) {
            return DEFAULT_PATH_TO_FILE;
        } else {
            return args[1];
        }
    }

    /**
    * Читает файл построчно и выводит в консоль строки, содержащие искоую строку
    * @param toFind искомый набор символов, для унификации рпиведен в нижний регистр
    * @param reader Буферезированный вывод из файла
    * @throws IOException
    * */
    public static void grep(BufferedReader reader, String toFind) throws IOException {
        String lineFromFile, stringWithLowerCase;
        Boolean isNothing = true;
        while ((lineFromFile = reader.readLine()) != null) {
            stringWithLowerCase = lineFromFile;
            stringWithLowerCase.toLowerCase();
            if (stringWithLowerCase.indexOf(toFind) != -1) {
                System.out.println(lineFromFile);
                isNothing = false;
            }
        }
        if (isNothing)
            System.out.println("I can't found your string here((");
    }

    /**
    * Получение введенной пользователем строки для поиска из аргументов
    * @param args массив аргументов программы
    * */
    public static String getArgString(String[] args) {
        return args[0];
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("GOOD BYE MISTER!!!!1!");
            System.exit(0);
        }
        BufferedReader reader;
        String toFind;
        //pathToFile = getPath( args );
        reader = openFile(getPath(args));
        toFind = getArgString(args).toLowerCase();
        try {
            grep(reader, toFind);
        } catch (IOException err) {
            System.err.println(err.getMessage());
        }
    }
}