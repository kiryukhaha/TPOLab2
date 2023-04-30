package trigonometric;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Sec {

    private final Cos cos;

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public Sec() {
        this.cos = new Cos();
    }

    public double sec(double x, double eps){

        double cosVal = cos.cos(x, eps);
//        System.out.println("Fds" + cosVal);
        if (Double.isNaN(cosVal) || cosVal == 0) return Double.NaN;
//        System.out.println(1/cosVal);
        return 1/cosVal;
    }
    public double writeToCSV(double x, double eps, Writer writer){
        double res = sec(x, eps);
        try(CSVPrinter printer = CSVFormat.DEFAULT.print(writer)) {
            printer.printRecord(x,res);
        }catch (IOException ioException){
            System.err.println("Wrong file");
        }
        return res;
    }
}
