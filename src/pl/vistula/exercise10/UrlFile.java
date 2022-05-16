package pl.vistula.exercise10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UrlFile {

    public static void main(String[] args) throws IOException {
        URL url = new URL ("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in)) ;


        System.out.println(" ENTER THE FIRST THREE DIGIT OF YOUR BANK ACCOUNT");
        String  accountNumber = bufferedReader.readLine();



        try (BufferedReader br = new BufferedReader( new InputStreamReader( url.openStream))){
            String line;
            System.out.println("READ DATA FROM THE FILE");
            while ((line = br.readLine()) !=null){
                System.out.println(line);

                String[] words = line.split("\\t+");
                String bankNumber = words[0].trim();
                String bankName = words[1].trim();
                if (bankNumber.equals(accountNumber)){
                    System.out.println("BANK NUMBER :" +  bankNumber + " your bank name is:" + bankName);
                    break;
                }

            }
        }catch (IOException e){
            System.out.println("data loading error");
        }
    }
}
