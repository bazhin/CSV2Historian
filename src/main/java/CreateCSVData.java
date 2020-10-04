import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;

public class CreateCSVData {

    public static void prepareDataForWWHistorian(){
        final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss.SSS");

        for(int k = 0; k < 10; k++){
            final String DATAFILE_NAME = "output\\data_random_2020_08_21_"+k+".csv";
            String data = "tagName, timeStamp, value, quality\n"; // CSV Headers

            //d.getTime();
            try(FileWriter fileWriter = new FileWriter(DATAFILE_NAME)){
                System.out.println(data);
                fileWriter.write(data);
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++) {
                        Date d = new Date();
                        data = "Analog_" + j + ", " + SDF.format(d) + ", " + Math.random() * 100 + ", 192 \n";
                        System.out.println(data);
                        fileWriter.write(data);
                        sleep(20);
                    }
                    sleep(20);
                }

            }catch(IOException e){
                System.out.println(e.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void prepareDataForSmartHistorian(){
        final SimpleDateFormat SDF = new SimpleDateFormat("YYYY-MM-dd kk:mm:ss.SSS+0300");
        final SimpleDateFormat SDF4FileName = new SimpleDateFormat("ddMMyyyykkmmss");

        for(int k = 0; k < 1; k++){// k - number  of files
            Date fDate = new Date();
            final String DATAFILE_NAME = "data_pila_"+SDF4FileName.format(fDate)+".csv";
            String header = "tag_id, timestamp, version, value, quality\n"; // CSV Headers
            StringBuilder stringBuilder = new StringBuilder();
            //d.getTime();
            try(FileWriter fileWriter = new FileWriter(DATAFILE_NAME)){
                System.out.println(header);
                stringBuilder.append(header);

                for(int i = 0; i < 10000; i++){ // number for rows for each tag
                    for(int j = 1; j < 11; j++) { //number of tags
                        Date d = new Date();
                        stringBuilder.append(j).append(",").append(SDF.format(d)).append(",0,").append(i).append(",192\n");
                        sleep(0);
                    }
                    sleep(2);
                }
                System.out.println(stringBuilder.toString());
                fileWriter.write(stringBuilder.toString());

            }catch(IOException e){
                System.out.println(e.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

    public static void main(String[] args) {
        prepareDataForWWHistorian();

    }

}
