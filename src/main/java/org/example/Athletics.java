package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Athletics
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AthleticsConfigure.class);
        CsvReader csvReader = applicationContext.getBean(CsvReader.class);
        ResultProcessor resultProcessor = applicationContext.getBean(ResultProcessor.class);
        resultProcessor.showResult(5, "Male", "5");
        System.out.println("\nА теперь все результаты: \n");
        csvReader.out();
        System.out.println("The end!");
    }
}
