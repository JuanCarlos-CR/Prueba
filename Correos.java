//package capacitacion;

/*En mi computadora cree el archivo "correos.txt" el cual contiene un texto dentro del cual se pueden encontrar
algunos correos electrónicos, el archivo se encuentra en "C:/Users/Juan Carlos/Desktop/correos.txt", tal como se
vió en clase mediante "FileReader" y "BufferedReade" se obtuvo el texto de dicho archivo, en seguida haciendo uso
de las clases Pattern y Matcher, se utilizarón expresiones regulares para encontrar los correos que contenía el,
por ultimo se mando a imprimir en consola dichos correos.*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Correos {
	
	public static void main(String [] args) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File("C:/Users/Juan Carlos/Desktop/correos.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			System.out.println("Los correos obtenidos del texto son:\n");
			while((linea = br.readLine()) != null) {
				Pattern pat = Pattern.compile("([a-z0-9_.-]+)@([a-z0-9_.-]+[a-z])");
				Matcher mat = pat.matcher(linea);
				while(mat.find()){
					System.out.println(mat.group());
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != fr) {
					fr.close();
				}
				
			}catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
		}
		
	}